# Kiểm chứng source theo bố cục NRO

## Source và build

- 130/130 file Java ở `source/src/main/java` có nội dung byte giống source đã kiểm chứng trước khi chuyển bố cục.
- Khi đưa vào Git, `.gitattributes` chuẩn hóa CRLF thành LF. Bản checkout được so sánh toàn bộ nội dung source sau khi chuẩn hóa kiểu xuống dòng; không sửa tên, câu lệnh hoặc logic Java.
- Kiểm kê đầu vào: 130 class, 1.349 method, 2.322 field, 3.767 slot local bytecode; source index ghi 5.043 khai báo tham số/local/catch.
- Không còn tên member `field_*_<hash>` / `method_*_<hash>` hoặc các marker lỗi decompiler đã rà trong source hiện tại.
- Build dùng JDK 17 và ECJ 3.33.0, source Java 1.3, classfile 45.3. Release giữ thông tin dòng/source; debug có thêm thông tin local variable.
- Mỗi JAR có đúng 370 file: 130 class, 239 tài nguyên và manifest. Tài nguyên được đối chiếu size/SHA-256 với resource lock; thư viện API/emulator không được đóng vào JAR game.

## Mười vòng build sạch

Đã chạy đủ **10 vòng**, mỗi vòng build cả release và debug từ thư mục class tạm mới, tổng cộng 20 build. Không lấy class từ output cũ. Mỗi vòng đều kiểm tra đủ class/tài nguyên và có cùng SHA-256 trong từng chế độ.

| Vòng | Release | Debug |
|---|---|---|
| 1 | PASS | PASS |
| 2 | PASS | PASS |
| 3 | PASS | PASS |
| 4 | PASS | PASS |
| 5 | PASS | PASS |
| 6 | PASS | PASS |
| 7 | PASS | PASS |
| 8 | PASS | PASS |
| 9 | PASS | PASS |
| 10 | PASS | PASS |

SHA-256 release:

```text
1d8a8672583143927ddd229453ed5df169a1922fbebf914590223d0431b3f4e0
```

SHA-256 debug:

```text
3190c93cc994a02e6fbd5b4a698940d614765c821265d34428632991d2ebd35a
```

Hai hash khác nhau do debug metadata. JAR của workflow cũ có hash `c8ee047f1e3807284ec53e671fb358a2c45ea8f02690adb808c4cffba2ea7c3d`; đổi cách đóng gói không có nghĩa executable code thay đổi.

## Checkout sạch và phục hồi phụ thuộc

Đã xuất chính nội dung staged của Git sang thư mục mới, không mang theo JDK, thư viện, tài nguyên hoặc output. Quy trình này tải lại đủ 5 dependency từ URL đã ghim và kiểm tra SHA-256, compile thành công với `-CompileOnly` khi chưa có tài nguyên, rồi nhập 239 tài nguyên từ JAR gốc. Build release và debug sau đó cho đúng hai hash bên trên. JDK được truyền từ bên ngoài bằng `-JavaHome`.

Đã rà nội dung public để loại binary đầu vào, JDK, tài nguyên game, output/cache/profile runtime và các mẫu GitHub credential/private key/credential trong URL. ZIP source nhẹ được tạo từ chính các file public trong Git index và kiểm tra lại toàn bộ payload/CRC; tài nguyên và thư viện được phục hồi bằng script khi người dùng build.

## Bytecode và runtime

- Cả release và debug đều khớp canonical bytecode **130/130 class** với baseline ECJ đã lưu trước đợt đổi tên, sau khi quy tên về định danh gốc.
- So sánh 193.867 lệnh và 1.479 exception handler; gồm thứ tự lệnh, branch target, constants, member/access metadata, maxStack/maxLocals. Phép so sánh loại debug attributes và stack-map frames.
- Audit có kiểm tra độ nhạy với 10 dạng thay đổi chủ động trên fixture trong giai đoạn đổi tên.
- Linkage kiểm tra 19.828 call site và 43.970 field site của từng JAR mới, cùng xác minh class với `-Xverify:all`; kiểm tra linkage không chạy static initializer của mọi class.
- MicroEmulator 2.0.4 chạy cả hai JAR mới qua splash, chọn server và màn hình đăng nhập; nhận DOWN/UP, pause/resume và destroy MIDlet. Mỗi bản giải mã được 166 PNG, có framebuffer kích thước 176×220 và tick tăng.
- Chạy thật `source/run.ps1 -Debug` trên cổng riêng ở `127.0.0.1`, nhận được listener JDWP và bắt tay `JDWP-Handshake` thành công. Sau kiểm tra chỉ dừng cây tiến trình vừa tạo; không đóng phiên game cũ.
- Kiểm tra framebuffer/PNG được thực hiện bằng chương trình, không phải đánh giá trực quan bằng mắt.

Trước khi chuyển bố cục, hai bộ kiểm tra 10 vòng trên source đã đổi tên cũng đã hoàn tất; mỗi vòng có 15.218 ca differential và kiểm tra MicroEmulator. Bản mới giữ nguyên byte của 130 file Java. Các lượt này không được tính thành 10 vòng build mới ở bảng trên.

## Giới hạn đã biết

- Canonical comparison chứng minh riêng đợt đổi tên và chuyển workflow không làm thay đổi executable code so với baseline rebuilt đã lưu. Nó không chứng minh mọi hành vi của bản tái dựng tương đương JAR gốc.
- Audit heuristic giữa JAR gốc và bản rebuilt chỉ có 122/130 class khớp tập thao tác, còn 565 khác biệt theo method và 64 residual cấp class; phép kiểm tra này bỏ qua các chi tiết luồng điều khiển quan trọng.
- Tám class còn được gắn cờ trong audit gốc: `SessionConnector`, `ItemTree`, `SkillOption`, `Npc`, `mFont`, `GameScr`, `SessionReceiver`, `DataSkillEff`.
- Đã gặp log MicroEmulator `Creating thread with no MIDlet context` ở `SessionConnector.run`; giao diện vẫn chạy. Chưa kiểm thử đăng nhập thật, server/network, chiến đấu, toàn bộ giao thức hoặc gameplay online dài hạn.
- Tên đọc được là đề xuất dựa vào tham chiếu/hành vi, không tự nhận phục hồi đầy đủ tên trước obfuscation hoặc tên local gốc.

Kết quả chọn lọc dạng máy đọc được nằm trong `verification-summary.json`. Log thô, baseline binary, profile runtime và đầu vào gốc được giữ cục bộ, không thuộc nội dung repo public.
