import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.zip.*;

/** Fresh full-source Java ME builds; no dependency on a prior class directory. */
public class StandaloneJarBuild {
    record Resource(String path, long size, String sha256) {}

    static String hash(byte[] bytes) throws Exception {
        return HexFormat.of().formatHex(MessageDigest.getInstance("SHA-256").digest(bytes));
    }

    static List<Path> files(Path root, String suffix) throws IOException {
        if (!Files.isDirectory(root)) return List.of();
        try (Stream<Path> stream = Files.walk(root)) {
            return stream.filter(Files::isRegularFile).filter(p -> suffix == null || p.toString().endsWith(suffix)).sorted().toList();
        }
    }

    static String stringProperty(String json, String name) {
        Matcher match = Pattern.compile("\\\"" + Pattern.quote(name) + "\\\"\\s*:\\s*\\\"([^\\\"]+)\\\"").matcher(json);
        if (!match.find()) throw new IllegalStateException("Missing lock property: " + name);
        return match.group(1);
    }

    static List<Resource> resourceLock(Path project) throws Exception {
        String text = Files.readString(project.resolve("config/resources.lock.json"), StandardCharsets.UTF_8);
        Matcher match = Pattern.compile("\\{\\s*\\\"path\\\"\\s*:\\s*\\\"([^\\\"\\\\]+)\\\"\\s*,\\s*\\\"size\\\"\\s*:\\s*(\\d+)\\s*,\\s*\\\"sha256\\\"\\s*:\\s*\\\"([0-9a-f]{64})\\\"\\s*\\}").matcher(text);
        List<Resource> result = new ArrayList<>();
        while (match.find()) result.add(new Resource(match.group(1), Long.parseLong(match.group(2)), match.group(3)));
        if (result.size() != 239) throw new IllegalStateException("Expected exactly 239 locked resources");
        return result;
    }

    static Path resourcePath(Path root, String name) {
        Path path = root.resolve(name).normalize();
        if (!path.startsWith(root) || name.indexOf('\\') >= 0 || name.startsWith("/"))
            throw new IllegalStateException("Unsafe resource path: " + name);
        return path;
    }

    static void importResources(Path project, Path original) throws Exception {
        String lock = Files.readString(project.resolve("config/resources.lock.json"), StandardCharsets.UTF_8);
        if (!hash(Files.readAllBytes(original)).equals(stringProperty(lock, "input_jar_sha256")))
            throw new IllegalStateException("Original JAR SHA-256 differs from this project's input");
        Path root = project.resolve("src/main/resources");
        try (ZipFile archive = new ZipFile(original.toFile())) {
            for (Resource resource : resourceLock(project)) {
                ZipEntry entry = archive.getEntry(resource.path());
                if (entry == null || entry.isDirectory()) throw new IllegalStateException("Original resource missing: " + resource.path());
                byte[] bytes;
                try (InputStream input = archive.getInputStream(entry)) { bytes = input.readAllBytes(); }
                if (bytes.length != resource.size() || !hash(bytes).equals(resource.sha256()))
                    throw new IllegalStateException("Original resource differs: " + resource.path());
                Path output = resourcePath(root, resource.path());
                if (Files.exists(output)) {
                    if (!hash(Files.readAllBytes(output)).equals(resource.sha256()))
                        throw new IllegalStateException("Existing edited resource was NOT overwritten: " + output);
                } else {
                    Files.createDirectories(output.getParent()); Files.write(output, bytes, StandardOpenOption.CREATE_NEW);
                }
            }
        }
        System.out.println("Imported/verified 239 resources; original JAR was not modified.");
    }

    static Map<String, byte[]> resources(Path project) throws Exception {
        Path root = project.resolve("src/main/resources");
        Map<String, byte[]> result = new TreeMap<>();
        for (Resource resource : resourceLock(project)) {
            Path path = resourcePath(root, resource.path());
            if (!Files.isRegularFile(path)) throw new IllegalStateException("Missing resource " + resource.path() + "; run build.ps1 -OriginalJar <original.jar>");
            byte[] bytes = Files.readAllBytes(path);
            if (bytes.length != resource.size() || !hash(bytes).equals(resource.sha256())) throw new IllegalStateException("Resource differs from lock: " + resource.path());
            if (result.put(resource.path(), bytes) != null) throw new IllegalStateException("Duplicate resource: " + resource.path());
        }
        if (files(root, null).size() != result.size()) throw new IllegalStateException("Unexpected resource files outside the lock");
        return result;
    }

    static void dependencies(Path project) throws Exception {
        String lock = Files.readString(project.resolve("config/dependencies.lock.json"), StandardCharsets.UTF_8);
        Matcher records = Pattern.compile("\\{[^{}]*\\\"name\\\"\\s*:\\s*\\\"([^\\\"]+)\\\"[^{}]*\\}").matcher(lock);
        int count = 0;
        while (records.find()) {
            Path path = project.resolve("lib").resolve(records.group(1));
            String expected = stringProperty(records.group(), "sha256");
            if (!Files.isRegularFile(path) || !hash(Files.readAllBytes(path)).equals(expected))
                throw new IllegalStateException("Pinned dependency missing/hash differs: " + path + "; run prepare.ps1");
            count++;
        }
        if (count != 5) throw new IllegalStateException("Expected five pinned dependencies");
    }

    static Set<String> expectedClasses(Path project) throws Exception {
        Set<String> result = new TreeSet<>();
        for (String line : Files.readAllLines(project.resolve("config/classes.list"), StandardCharsets.UTF_8)) {
            String name = line.trim();
            if (name.isEmpty() || name.startsWith("#")) continue;
            if (!name.matches("[A-Za-z_$][A-Za-z0-9_$/]*") || name.contains("..") || !result.add(name)) throw new IllegalStateException("Invalid/duplicate class: " + name);
        }
        if (result.size() != 130) throw new IllegalStateException("Expected 130 reconstructed classes");
        return result;
    }

    static void build(Path project, Path output, boolean debug, boolean compileOnly) throws Exception {
        dependencies(project);
        Map<String, byte[]> entries = compileOnly ? new TreeMap<>() : resources(project);
        Set<String> expected = expectedClasses(project);
        Path sourceRoot = project.resolve("src/main/java");
        List<Path> sources = files(sourceRoot, ".java");
        Set<String> sourceNames = new TreeSet<>();
        for (Path source : sources) {
            String name = sourceRoot.relativize(source).toString().replace('\\', '/');
            sourceNames.add(name.substring(0, name.length() - 5));
            String text = Files.readString(source, StandardCharsets.UTF_8);
            if (text.contains("Couldn't be decompiled") || text.contains("Decompilation failed") || text.contains("** GOTO")
                    || Pattern.compile("\\b(?:field|method)_[A-Za-z]+_[0-9a-f]{8}\\b").matcher(text).find())
                throw new IllegalStateException("Unrecovered/unreadable source: " + source);
        }
        if (!sourceNames.equals(expected)) throw new IllegalStateException("Source class coverage differs from config/classes.list");
        Path workRoot = project.resolve(".build"); Files.createDirectories(workRoot);
        Path work = Files.createTempDirectory(workRoot, "jar-"); Path classes = Files.createDirectory(work.resolve("classes"));
        Path arguments = work.resolve("sources.args");
        Files.writeString(arguments, sources.stream().map(p -> "\"" + p.toString().replace('\\', '/') + "\"").collect(Collectors.joining("\n")), StandardCharsets.UTF_8);
        String executable = System.getProperty("os.name").toLowerCase(Locale.ROOT).contains("win") ? "java.exe" : "java";
        Path java = Paths.get(System.getProperty("java.home"), "bin", executable);
        Path lib = project.resolve("lib");
        String api = lib.resolve("cldcapi11-2.0.4.jar") + File.pathSeparator + lib.resolve("midpapi20-2.0.4.jar") + File.pathSeparator + lib.resolve("microemu-jsr-120-2.0.4.jar");
        List<String> command = List.of(java.toString(), "-Dfile.encoding=UTF-8", "-Xmx3g", "-jar", lib.resolve("ecj-3.33.0.jar").toString(),
            "-1.3", "-encoding", "UTF-8", debug ? "-g" : "-g:lines,source", "-proc:none", "-bootclasspath", api, "-classpath", api,
            "-d", classes.toString(), "-maxProblems", "3000", "-warn:none", "-log", work.resolve("compiler.xml").toString(), "@" + arguments);
        Process process = new ProcessBuilder(command).directory(project.toFile()).redirectErrorStream(true).start();
        byte[] log = process.getInputStream().readAllBytes(); int exit = process.waitFor(); Files.write(work.resolve("compiler.log"), log);
        if (exit != 0) { System.err.write(log); throw new IllegalStateException("ECJ failed; logs retained in " + work); }
        List<Path> compiled = files(classes, ".class"); Set<String> actual = new TreeSet<>();
        for (Path file : compiled) {
            byte[] bytes = Files.readAllBytes(file); ByteBuffer header = ByteBuffer.wrap(bytes);
            if (header.getInt() != 0xcafebabe || Short.toUnsignedInt(header.getShort()) != 3 || Short.toUnsignedInt(header.getShort()) != 45)
                throw new IllegalStateException("Classfile is not 45.3: " + file);
            String name = classes.relativize(file).toString().replace('\\', '/'); actual.add(name.substring(0, name.length() - 6));
            if (entries.put(name, bytes) != null) throw new IllegalStateException("Entry collision: " + name);
        }
        if (!actual.equals(expected)) throw new IllegalStateException("Compiled class coverage differs");
        Files.createDirectories(output); Files.write(output.resolve("compiler.log"), log);
        Files.copy(work.resolve("compiler.xml"), output.resolve("compiler.xml"), StandardCopyOption.REPLACE_EXISTING);
        String jarHash = "";
        if (!compileOnly) {
            String manifest = Files.readString(project.resolve("config/MANIFEST.MF"), StandardCharsets.UTF_8).lines().collect(Collectors.joining("\r\n")).stripTrailing() + "\r\n\r\n";
            entries.put("META-INF/MANIFEST.MF", manifest.getBytes(StandardCharsets.UTF_8));
            Path temporary = Files.createTempFile(output, ".building-", ".jar");
            try (ZipOutputStream archive = new ZipOutputStream(Files.newOutputStream(temporary))) {
                archive.setLevel(9);
                for (var item : entries.entrySet()) {
                    ZipEntry entry = new ZipEntry(item.getKey()); entry.setTimeLocal(LocalDateTime.of(1980, 1, 1, 0, 0));
                    archive.putNextEntry(entry); archive.write(item.getValue()); archive.closeEntry();
                }
            }
            int checked = 0;
            try (ZipFile archive = new ZipFile(temporary.toFile())) {
                Enumeration<? extends ZipEntry> iterator = archive.entries();
                while (iterator.hasMoreElements()) {
                    ZipEntry entry = iterator.nextElement(); byte[] bytes;
                    try (InputStream input = archive.getInputStream(entry)) { bytes = input.readAllBytes(); }
                    CRC32 crc = new CRC32(); crc.update(bytes);
                    if (crc.getValue() != entry.getCrc() || !Arrays.equals(entries.get(entry.getName()), bytes)) throw new IllegalStateException("JAR payload/CRC differs: " + entry.getName());
                    checked++;
                }
            }
            if (checked != 370) throw new IllegalStateException("Expected 130 classes + 239 resources + manifest");
            Path jar = output.resolve("NinjaSchool_251-source-rebuilt.jar"); Files.move(temporary, jar, StandardCopyOption.REPLACE_EXISTING);
            String jad = manifest.replace("Manifest-Version: 1.0\r\n", "").stripTrailing() + "\r\nMIDlet-Jar-URL: " + jar.getFileName() + "\r\nMIDlet-Jar-Size: " + Files.size(jar) + "\r\n";
            Files.writeString(output.resolve("NinjaSchool_251-source-rebuilt.jad"), jad, StandardCharsets.UTF_8); jarHash = hash(Files.readAllBytes(jar));
            System.out.println("JAR: " + jar); System.out.println("SHA-256: " + jarHash);
        }
        Path bin = project.resolve("bin");
        for (Path file : files(bin, null)) if (!file.toString().endsWith(".class")) throw new IllegalStateException("Non-generated file in bin was not overwritten: " + file);
        for (Path file : compiled) {
            Path target = bin.resolve(classes.relativize(file)); Files.createDirectories(target.getParent()); Files.copy(file, target, StandardCopyOption.REPLACE_EXISTING);
        }
        String report = "{\n  \"passed\": true,\n  \"compiler\": \"ECJ 3.33.0\",\n  \"source_files\": 130,\n  \"class_files\": 130,\n  \"classfile_version\": \"45.3\",\n  \"debug_symbols\": " + debug + ",\n  \"compile_only\": " + compileOnly + ",\n  \"resources\": " + (compileOnly ? 0 : 239) + ",\n  \"sha256\": \"" + jarHash + "\"\n}\n";
        Files.writeString(output.resolve("build-report.json"), report, StandardCharsets.UTF_8);
        for (Path file : files(work, null)) Files.delete(file);
        try (Stream<Path> stream = Files.walk(work)) { for (Path path : stream.sorted(Comparator.reverseOrder()).toList()) Files.delete(path); }
        System.out.println("Built all 130 Java classes, classfile 45.3; mode=" + (debug ? "debug" : "release") + (compileOnly ? " (compile only)" : "; 239 locked resources"));
    }

    public static void main(String[] args) throws Exception {
        if (Runtime.version().feature() < 17) throw new IllegalStateException("JDK 17+ is required");
        if (args.length < 3) throw new IllegalArgumentException("Usage: build|compile <project> <output> [release|debug], or import <project> <original.jar>");
        Path project = Paths.get(args[1]).toAbsolutePath().normalize();
        if (args[0].equals("import")) importResources(project, Paths.get(args[2]).toAbsolutePath().normalize());
        else if (args[0].equals("build") || args[0].equals("compile")) build(project, Paths.get(args[2]).toAbsolutePath().normalize(), args.length > 3 && args[3].equals("debug"), args[0].equals("compile"));
        else throw new IllegalArgumentException("Unknown action: " + args[0]);
    }
}
