# NinjaSchool Java ME — source hiện tại

Project Eclipse **NinjaSchool-251** chứa 130 file Java, 239 tài nguyên khóa theo hash và script build/run/debug, theo cùng bố cục với project `D:\NRO`.

Đây là hướng dẫn nhanh khi đang đứng trong thư mục `source`. [README gốc](../README.md) có danh mục đủ 130 file và giải thích từng module. Xem thêm [build/debug chi tiết](../docs/BUILD_AND_DEBUG.md), [kiến trúc](../docs/ARCHITECTURE.md), [mạng](../docs/NETWORK.md), [tài nguyên](../docs/RESOURCES.md), [API](../docs/API_REFERENCE.md) và [field](../docs/FIELD_REFERENCE.md).

## Build

Cần **JDK 17**. Script dùng JDK được truyền bằng `-JavaHome`, JDK cục bộ `toolchain/java`, `JAVA_HOME` hoặc `java` trong PATH. JDK/binary không được commit.

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\build.ps1 -OriginalJar 'C:\path\NinjaSchool_251.jar'
powershell -NoProfile -ExecutionPolicy Bypass -File .\run.ps1
```

`prepare.ps1` tải ECJ/API/MicroEmulator theo URL và SHA-256 trong `config/dependencies.lock.json`. Tài nguyên chỉ được nhập từ đúng JAR có hash tương ứng `config/resources.lock.json`; không sửa JAR đầu vào. Sau lần nhập đầu tiên, không cần `-OriginalJar` nữa. Khi thư viện/tài nguyên đã có, build không cần tải mạng.

Release ở `dist/`; debug có local-variable metadata ở `debug-dist/`. Cả hai đều là classfile **45.3**, dùng source Java 1.3, boot API CLDC/MIDP/WMA. API và emulator không được chèn vào JAR game.

Manifest hiện giữ `MIDlet-Version: 1.0.0` và CLDC-1.0 theo bản đầu vào; chuỗi `2.5.1` được các màn hình truyền khi login là version nghiệp vụ riêng. API dùng để compile là CLDC 1.1/MIDP 2.0/WMA, không tự đổi metadata manifest.

## Eclipse và debug

1. Import → General → Existing Projects into Workspace; chọn thư mục này và import **NinjaSchool-251**. Nên dùng workspace riêng nếu project cũ cùng tên đã được import.
2. Project → Build Project dùng external builder `eclipse-build.ps1` đã có; Eclipse mới có thể không hỗ trợ JDT compliance 1.3 trực tiếp, nhưng external ECJ build vẫn hoạt động.
3. Đặt breakpoint ở `main.GameMidlet.startApp()`, `main.GameCanvas` hoặc class cần sửa trong `nso`.
4. Chạy lệnh debug bên dưới. JVM chờ debugger nên cửa sổ chưa xuất hiện ngay.
5. Run → Debug Configurations → Remote Java Application; Project **NinjaSchool-251**, Host **127.0.0.1**, Port **5005**; Debug và Resume (F8).
6. Khi MicroEmulator hiện ra, chọn game và bấm **Start**.

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\run.ps1 -Debug
```

Đổi cổng bằng `-Port 5006`; chỉ build debug bằng `build.ps1 -DebugSymbols`. `build.ps1 -CompileOnly` kiểm tra source/API khi chưa có tài nguyên; nó không tạo JAR game chạy được.

## Mapping và phạm vi

`../mapping` giữ toàn bộ định danh class/method/field/local-slot và đề xuất tên. Đã đổi 461 field / 249 method còn tên hash, trong đó `Char.tickEffWolf` và `Char.timeBocdau`. Không thay logic để giống một bản game khác. Tên gốc trước obfuscation và mọi gameplay online không được coi là đã chứng minh.

`src/main/java` là source game, `src/main/resources` là tài nguyên cục bộ, `lib` là phụ thuộc nhỏ, `toolchain/StandaloneJarBuild.java` là builder. ZIP source nhẹ không kèm JDK, bản gốc, cache, runtime profile hoặc JAR từ các build cũ.
