# Build và debug NSO

[Về README](../README.md) · [Xử lý lỗi](TROUBLESHOOTING.md) · [Kết quả kiểm tra](../reports/VERIFICATION.md)

## 1. Chọn đúng thư mục làm việc

Repository có một cấp `source/`. Lệnh sau giả sử terminal đang đứng ở gốc repo:

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\source\build.ps1
```

Nếu đang ở trong `source`, bỏ tiền tố `source\`:

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\build.ps1
```

Đường dẫn script dùng `$PSScriptRoot`, nên project không phụ thuộc ổ `D:` của máy đã phục hồi. Không cần sửa đường dẫn trong script khi clone sang ổ/thư mục khác.

## 2. JDK host và target game

JDK 17 chạy `StandaloneJarBuild.java`, ECJ và MicroEmulator. ECJ compile source ở mức 1.3 và tạo classfile 45.3. Hai mốc này phục vụ hai mục đích khác nhau.

Không thay compiler bằng `javac` hiện đại rồi giữ nguyên kỳ vọng classfile 45.3. Không đưa API Java SE mới vào source game chỉ vì host có JDK 17.

Java được chọn theo thứ tự:

1. `-JavaHome` nếu truyền vào và tìm thấy `bin/java.exe`.
2. JDK cục bộ `source/toolchain/java` nếu có.
3. `JAVA_HOME`.
4. Lệnh `java` trong PATH.

```powershell
$env:JAVA_HOME = 'C:\path\jdk-17'
& "$env:JAVA_HOME\bin\java.exe" -version

powershell -NoProfile -ExecutionPolicy Bypass -File .\source\build.ps1 `
  -JavaHome 'C:\path\jdk-17'
```

`-JavaHome` và `JAVA_HOME` trỏ tới gốc JDK, không trỏ tới `bin`. Repo không tự tải JDK.

## 3. Phục hồi dependency

`source/prepare.ps1` đọc `config/dependencies.lock.json`, tạo `lib/` và xử lý từng JAR:

- Đã có file: so SHA-256; đúng thì giữ nguyên, sai thì dừng.
- Chưa có file: tải vào tên tạm, so SHA-256 rồi mới chuyển thành tên dependency.
- Không có credential GitHub hoặc thông tin tài khoản trong quy trình tải dependency.

```powershell
# Chỉ chuẩn bị thư viện; chưa nhập tài nguyên.
powershell -NoProfile -ExecutionPolicy Bypass -File .\source\prepare.ps1
```

| Dependency | Vai trò |
|---|---|
| `ecj-3.33.0.jar` | Compiler Java cũ trên host JDK mới |
| `cldcapi11-2.0.4.jar` | Boot API CLDC để compile |
| `midpapi20-2.0.4.jar` | API MIDP/lcdui/RecordStore |
| `microemulator-2.0.4.jar` | Runtime desktop cho MIDlet |
| `microemu-jsr-120-2.0.4.jar` | WMA API/runtime được dùng bởi SMS |

Không xóa WMA khỏi classpath chỉ vì luồng test không gửi SMS. Việc code tham chiếu API này vẫn là một phần của liên kết class.

## 4. Phục hồi tài nguyên

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\source\prepare.ps1 `
  -OriginalJar 'C:\path\NinjaSchool_251.jar' -JavaHome 'C:\path\jdk-17'
```

Builder kiểm tra SHA-256 của toàn bộ JAR trước khi lấy resource. Sau đó chỉ nhập 239 resource trong lock và kiểm tra size/hash từng file. Classfile của JAR gốc không được chép sang output compiler.

Nếu resource đích đã tồn tại và có nội dung khác, import dừng thay vì ghi đè bản đang sửa. Khi một lần import dừng giữa chừng, các file đã nhập đúng hash có thể còn lại; kiểm tra nguyên nhân rồi chạy lại là được vì file đúng được kiểm tra và giữ nguyên.

## 5. Các chế độ build

| Mode | Lệnh thêm | Kiểm resource | Đóng JAR mới | Debug metadata |
|---|---|---|---|---|
| Release | Không thêm | Có | Có | `-g:lines,source` |
| Debug | `-DebugSymbols` | Có | Có | `-g` |
| Compile-only | `-CompileOnly` | Không | Không | Theo cờ debug nếu có |

```powershell
# Release.
powershell -NoProfile -ExecutionPolicy Bypass -File .\source\build.ps1

# Debug.
powershell -NoProfile -ExecutionPolicy Bypass -File .\source\build.ps1 -DebugSymbols

# Compile source/API khi chưa có resource.
powershell -NoProfile -ExecutionPolicy Bypass -File .\source\build.ps1 -CompileOnly

# Compile-only có local debug metadata.
powershell -NoProfile -ExecutionPolicy Bypass -File .\source\build.ps1 -CompileOnly -DebugSymbols
```

Build đầy đủ dùng thư mục class tạm mới. `bin/` phục vụ Eclipse; JAR không lấy các class cũ trong `bin/` làm đầu vào.

`-CompileOnly` không xóa một JAR cũ đã có trong output. Luôn xem exit code, mode và thời điểm của `build-report.json`; không coi JAR cũ là kết quả của lần compile-only.

## 6. Đọc kết quả

```powershell
Get-Content .\source\dist\build-report.json
Get-FileHash -Algorithm SHA256 .\source\dist\NinjaSchool_251-source-rebuilt.jar
```

Các field quan trọng trong report:

| Field | Ý nghĩa |
|---|---|
| `passed` | Builder hoàn tất các điều kiện của mode đó |
| `compiler` | ECJ được dùng |
| `source_files` / `class_files` | Số source và class yêu cầu |
| `classfile_version` | Phải là `45.3` với cấu hình hiện tại |
| `debug_symbols` | Cờ debug của lần build |
| `compile_only` | Có bỏ bước đóng gói hay không |
| `resources` | 239 với full build, 0 với compile-only |
| `sha256` | Hash JAR mới; rỗng ở compile-only |

Khi ECJ lỗi, xem log `compiler.log` / `compiler.xml` được giữ trong thư mục làm việc mà lỗi chỉ ra. Nếu build chưa tới bước ghi output thì report cũ có thể còn tồn tại.

## 7. Eclipse

Import thư mục `source` bằng Existing Projects into Workspace. Tên project là `NinjaSchool-251`.

`.project` dùng `org.eclipse.ui.externaltools.ExternalToolBuilder`; launch file gọi Windows PowerShell và `eclipse-build.ps1`. `.classpath` trỏ source vào `src/main/java`, API vào `lib` và output editor vào `bin`.

Các thiết lập JDT source/compliance cũ chủ yếu mô tả cú pháp project. Eclipse hiện đại có thể hiện marker không hỗ trợ 1.3. Kết quả external ECJ và log là căn cứ build của repository này.

Nếu Eclipse có một project cùng tên, dùng workspace riêng hoặc xử lý xung đột import. Không trộn source của project tái dựng cũ và layout mới trong cùng source path.

## 8. Runner và remote debugger

`run.ps1` luôn gọi build trước: release nếu chạy thường, debug nếu có `-Debug`. Nó thêm WMA vào runtime classpath và dùng RMS memory.

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\source\run.ps1
powershell -NoProfile -ExecutionPolicy Bypass -File .\source\run.ps1 -Debug
powershell -NoProfile -ExecutionPolicy Bypass -File .\source\run.ps1 -Debug -Port 5006
```

Trong Eclipse, Remote Java Application phải trỏ project `NinjaSchool-251`, host `127.0.0.1`, đúng port. Sau khi attach, Resume để JVM vào MicroEmulator, rồi Start MIDlet.

Chọn breakpoint phù hợp:

- Constructor `GameMidlet`: khởi tạo trước khi app hiện canvas.
- `GameMidlet.startApp`: lúc đặt canvas lên Display.
- `GameCanvas.run`: game loop; tạm dừng ở đây có thể làm UI đứng chờ.
- `SelectServerScr.perform`: action từ màn chọn server.
- `Service.login`: payload trước khi xếp queue.
- `SessionReceiver.run`: frame raw trước dispatcher; cần chú ý handshake/nhánh đặc biệt.
- `Controller.onMessage`: dữ liệu sau khi receiver đã dựng Message.

Breakpoint là yêu cầu quan sát code hiện tại. Nếu sửa file nhưng chạy JAR khác hoặc release cũ, số dòng/tên local có thể không khớp. Rebuild debug và khởi động lại runner để đồng bộ.

## 9. Java trực tiếp trên nền tảng khác

Đường Java trong builder có phân biệt `java.exe` / `java` và separator classpath theo hệ điều hành. Tuy nhiên bộ kiểm tra ghi trong repo chạy trên Windows; các `.ps1` hiện tại dùng `powershell.exe`, `.exe` và separator Windows ở runner. Không coi chúng là script Linux/macOS đã được xác minh.

Khi đã tự chuẩn bị đúng 5 JAR trong `lib`, từ thư mục `source` có thể dùng cấu trúc lệnh Java trực tiếp:

```bash
java -Dfile.encoding=UTF-8 toolchain/StandaloneJarBuild.java import . /path/NinjaSchool_251.jar
java -Dfile.encoding=UTF-8 toolchain/StandaloneJarBuild.java build . dist release
java -Dfile.encoding=UTF-8 toolchain/StandaloneJarBuild.java build . debug-dist debug

java -cp 'lib/microemulator-2.0.4.jar:lib/microemu-jsr-120-2.0.4.jar' \
  org.microemu.app.Main --rms memory dist/NinjaSchool_251-source-rebuilt.jar
```

Dấu `:` trong runtime classpath là cho Unix; Windows dùng `;`. Các lệnh này mô tả đường chạy tương ứng với builder/runner, không bổ sung một kết quả kiểm thử nền tảng mới.

## 10. Dừng ở đâu khi chỉnh tiếp

`classes.list` và builder hiện khóa 130 source/class; resource lock/builder khóa 239 resource và 370 JAR entry. Nếu thêm class hoặc asset, cần cập nhật toàn bộ điều kiện liên quan có chủ đích. Đừng thay một con số để che một file bị mất.

Sau thay đổi logic, hash baseline có thể đổi hợp lệ. Sau thay đổi chỉ tài liệu, source/config/JAR game phải giữ nguyên. Xem [phạm vi audit](MAPPING_AND_VERIFICATION.md) trước khi diễn giải kết quả.
