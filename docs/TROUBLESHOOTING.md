# Chẩn đoán lỗi NSO

[Về README](../README.md) · [Build/debug](BUILD_AND_DEBUG.md) · [Mạng](NETWORK.md)

## 1. Bắt đầu từ exit code và output đúng

Sau lệnh PowerShell, xem thông báo cuối và `$LASTEXITCODE`. Khi build không hoàn tất, JAR/report của lần trước có thể vẫn nằm trong `dist` hoặc `debug-dist`.

```powershell
Get-Item .\source\dist\NinjaSchool_251-source-rebuilt.jar | Select-Object Name,Length,LastWriteTime
Get-Content .\source\dist\build-report.json
```

Không kết luận build mới thành công chỉ từ việc file JAR tồn tại. Compile-only cũng không tạo JAR mới.

## 2. Không tìm thấy Java hoặc phiên bản quá cũ

Kiểm tra `-JavaHome`, JDK cục bộ, `JAVA_HOME` và PATH theo thứ tự tìm của script. Một thư mục có `java.exe` cũ có thể được chọn trước JDK trong PATH.

```powershell
Get-Command java -ErrorAction SilentlyContinue
$env:JAVA_HOME
java -version
```

Dùng `-JavaHome 'C:\path\jdk-17'` để chỉ rõ môi trường. Không sửa target của source game sang 17 để giải quyết lỗi host.

## 3. PowerShell chặn script

Dùng lệnh mẫu có `-NoProfile -ExecutionPolicy Bypass -File`. Đây là tùy chọn của tiến trình đang gọi; không cần đổi policy toàn máy chỉ để build project.

Nếu đường dẫn có khoảng trắng, giữ dấu quote quanh path. `-JavaHome` nhận thư mục JDK, `-OriginalJar` nhận file JAR.

## 4. Tải dependency lỗi

Kiểm tra mạng tới các URL Maven Central trong `dependencies.lock.json`, proxy/TLS và file download tạm nếu có. So đúng filename, phiên bản và SHA-256.

Nếu file đích đã có nhưng sai hash, script cố ý không ghi đè. Di chuyển bản đang có ra nơi riêng để điều tra, rồi phục hồi đúng artifact theo lock. Không sửa hash thành hash của một JAR không rõ nguồn chỉ để script chạy tiếp.

## 5. JAR đầu vào sai hash

Resource import chỉ nhận JAR được khóa. Hai file có cùng tên nhưng khác nội dung vẫn bị từ chối.

```powershell
Get-FileHash -Algorithm SHA256 -LiteralPath 'C:\path\NinjaSchool_251.jar'
```

Hash kỳ vọng nằm trong `source/config/resources.lock.json`. Một bản game khác phiên bản cần quy trình kiểm kê riêng; đổi lock không tự bảo đảm tương thích source.

## 6. Thiếu resource hoặc có resource lạ

Sau clone, thiếu `src/main/resources` là bình thường. Chạy build với `-OriginalJar` để nhập resource.

Nếu build báo file lạ ngoài lock, kiểm tra cả các file do editor/công cụ ảnh tạo. Nếu báo existing edited resource không bị ghi đè, có asset đang khác baseline: giữ/sao lưu thay đổi trước khi quyết định phục hồi hoặc cập nhật lock có chủ đích.

Xem [RESOURCES](RESOURCES.md) để phân biệt asset trong JAR, metadata atlas, cache RMS và nội dung tải từ server.

## 7. Thiếu/thừa class hoặc source

Builder yêu cầu tập tên source/class bằng `classes.list` và các số lượng cố định hiện tại. Lỗi có thể do mất file, đổi package/tên class hoặc thêm class ngoài danh sách.

Nếu thay đổi có chủ đích, cập nhật list và mọi kiểm tra hardcode tương ứng. Nếu chỉ đang build lại baseline, phục hồi file đúng thay vì đổi số lượng mong đợi.

## 8. Eclipse hiện marker nhưng script vẫn build

Eclipse mới có thể không chấp nhận source/compliance 1.3 ở JDT. Project dùng external ECJ builder để tạo target cũ. Xem Console của external builder và compiler log.

Import đúng thư mục `source`; không tạo thêm Java project bao cả `mapping`/`docs`. Kiểm tra các JAR trong `.classpath` đã được `prepare.ps1` tải đủ.

## 9. Debug chạy nhưng chưa có cửa sổ

Runner dùng `suspend=y`, chờ debugger. Trong Eclipse attach Remote Java Application tới `127.0.0.1` và đúng port, sau đó Resume.

Nếu port đang dùng, chạy `-Port 5006` và đổi cấu hình Eclipse theo. Nếu đã có launcher, cần chọn game/Start để thực sự khởi tạo MIDlet.

## 10. Breakpoint không hit hoặc Variables không như mong đợi

Xác nhận đang chạy `debug-dist` mới, đúng project `NinjaSchool-251` và đúng source. Rebuild bằng `-DebugSymbols`, khởi động runner debug rồi attach lại nếu code đã thay.

Tên local trong bản debug là tên source hiện tại. Một số biến có scope ngắn hoặc bị compiler biểu diễn khác; không phải mọi tên đều luôn hiện ở mọi instruction. Breakpoint `startApp` cũng không bắt phần khởi tạo đã chạy trong constructor GameMidlet.

## 11. Màn hình đen hoặc chậm theo nhịp

Phân biệt ba trạng thái: JVM đang chờ debugger, emulator đang ở launcher, và MIDlet đã Start nhưng frame lỗi. Xem log cùng screen/tick hiện tại nếu đang instrument test.

`GameCanvas.run` bắt exception ở vòng ngoài và có nhánh ngủ 1 giây. Nếu UI khựng đều, stack trace có thể chỉ ra một lỗi update/paint tái diễn. Không dùng việc tăng sleep hoặc nuốt exception làm cách xác nhận đã sửa lỗi.

## 12. Ảnh/font sai hoặc không hiện

Theo path thực sau khi thêm `/x{zoom}`. Kiểm tra `zoomLevel`, resource lock, ảnh/atlas metadata và clip/translate/anchor tại nơi vẽ.

Không dùng hướng dẫn XOR ảnh của NRO cho loader NSO. Asset hiện tại có 166 PNG đã được decode bằng chương trình, nhưng chưa có kiểm tra mọi sprite trong chiến đấu.

## 13. Không giữ cài đặt/tài khoản

Runner dùng `--rms memory`. Thông tin RMS của một lần chạy không được dùng làm profile tài khoản bền vững cho lần sau. Đây là cấu hình runtime, không có nghĩa hàm RMS trong source không tồn tại.

Nếu tự đổi sang persistence, ghi rõ cấu hình và giữ profile ngoài Git. Test lịch sử không xác nhận luồng này.

## 14. Không kết nối server

Kiểm tra server đang chọn, `GameMidlet.IP/PORT`, URL ở `GameCanvas.connect`, log connector và trạng thái key. Danh sách hardcode/HTTP/cache trong source có thể khác trạng thái server hiện tại.

Đã có log `Creating thread with no MIDlet context` tại connector. UI vẫn chạy, nhưng kết nối/login online chưa được chứng minh. Không ghi “online hoạt động” chỉ vì emulator mở form login.

## 15. Báo lỗi có đủ thông tin

Thông tin hữu ích gồm commit/source đang dùng, JDK, lệnh đã chạy, release/debug/compile-only, exit code, hash JAR output và đoạn stack trace liên quan. Nêu rõ lỗi xảy ra ở build, launcher, startup, input, kết nối hay trong map.

Không đưa credential, mật khẩu, dữ liệu tài khoản hoặc profile runtime lên issue public. Các log raw của quá trình phục hồi không được commit vào repo này.
