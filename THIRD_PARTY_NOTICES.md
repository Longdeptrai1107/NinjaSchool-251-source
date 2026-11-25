# Công cụ và thành phần bên thứ ba

Repo lưu URL, phiên bản và SHA-256 thay vì commit JDK/SDK/compiler/emulator JAR.

| Thành phần | Phiên bản | Vai trò | Nguồn |
|---|---|---|---|
| Eclipse Temurin / OpenJDK | JDK 17 | Host build/runtime/debug | Eclipse Adoptium / OpenJDK |
| Eclipse ECJ | 3.33.0 | Source Java 1.3, classfile 45.3 | Eclipse JDT / Maven Central |
| MicroEmulator | 2.0.4 | MIDP/CLDC trên JVM desktop | MicroEmulator / Maven Central |
| cldcapi11 / midpapi20 | 2.0.4 | Compile-only API | MicroEmulator / Maven Central |
| microemu-jsr-120 | 2.0.4 | WMA API và runtime SMS | MicroEmulator / Maven Central |

Các API/host library chỉ nằm trong `source/lib`, không được nhúng vào JAR game. `microemu-jsr-120` cung cấp API WMA chuẩn để compile thay vì tạo phần thân giả trong source game. Kiểm tra LICENSE/NOTICE/POM của artifact khi phân phối lại binary. Không gán một giấy phép mới cho nội dung game hoặc đầu vào do bên thứ ba sở hữu.
