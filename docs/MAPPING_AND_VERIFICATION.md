# Đọc mapping và hiểu kết quả kiểm chứng

[Về README](../README.md) · [Mapping](../mapping/README.md) · [Báo cáo](../reports/VERIFICATION.md)

## 1. Những số lượng khác nhau

| Đối tượng | Số lượng | Nguồn |
|---|---:|---|
| Class đầu vào | 130 | Inventory bytecode / symbols |
| Method đầu vào | 1.349 | Symbols, gồm các dạng member JVM được kiểm kê |
| Field đầu vào | 2.322 | Symbols |
| Local slot bytecode | 3.767 | Symbols/locals |
| Method/constructor khai báo trong source | 1.311 | Source index |
| Field khai báo trong source | 2.322 | Source index |
| Tham số/local/catch declaration trong source | 5.043 | Source index |
| Method declaration ở hai JAR rebuilt dùng trong canonical audit | 1.350 | Kết quả canonical audit |

Không dùng chênh lệch giữa hai hàng khác loại để kết luận thiếu code. JVM có initializer/compiler-generated member; source có constructor mặc định/implicit và các biểu diễn không trùng một-một với method table. Để kiểm tra coverage, phải dùng định danh và loại member tương ứng.

## 2. Định danh JVM

Method/field được giữ theo bộ `(owner, name, descriptor)` gốc. Descriptor method gồm đầy đủ kiểu tham số và return type. Descriptor field xác định kiểu của field.

Ví dụ hai field được đối chiếu riêng:

| Định danh gốc | Tên hiện tại |
|---|---|
| `bp.cmI` | `nso.Char.tickEffWolf` |
| `bp.cnI` | `nso.Char.timeBocdau` |

Trong identity trên, phần `I` biểu diễn int. Khi tra một tên ngắn trong input, luôn kiểm tra owner và descriptor, vì tên ngắn rất dễ trùng.

## 3. Tên và bằng chứng

`reference_proposal` nói rằng tên được đề xuất bằng đối chiếu DLL: signature, cấu trúc, literal, truy cập field và hành vi. Nó không biến một phép suy luận thành map obfuscation gốc.

`behavioral_name` mô tả hành vi nhìn thấy trong Java. Tên `unused...` có thể giữ một field thực của input hiện không được dùng theo cách nhìn thấy; không phải mặc định đó là một field giả.

`preserved` giữ tên hiện có. `unresolved` ghi phần chưa suy ra đủ chắc, đặc biệt trong dữ liệu local-slot. [NAMING_EVIDENCE](../mapping/NAMING_EVIDENCE.md) liệt kê cơ sở và các nhóm tên cụ thể.

Đợt xử lý tên hash đã thay 461 field và 249 method. Trong đó có 626 tên đề xuất theo vai trò DLL và 84 tên theo hành vi Java. Tổng này chỉ nói về đợt đổi tên đó, không phải số member của toàn bộ game.

## 4. Local slot không phải source variable

Bytecode dùng chỉ số slot và có thể tái sử dụng slot theo phạm vi sống. Decompiler có thể tách hoặc gộp biến theo cấu trúc source nó dựng lại. Vì vậy không có phép ghép một-một được bảo đảm giữa 3.767 slot và 5.043 declaration source.

Input không có tên debug local gốc để đối chiếu đầy đủ. Các tên local hiện tại là tên source đã dựng/đặt theo type/use hoặc tham chiếu, có ghi status. Compile `-g` ghi những tên hiện tại vào bản debug; không khôi phục tên đã mất.

## 5. Chọn file để tra

| Bạn đang có | Nên mở |
|---|---|
| Tên class đọc được | API/field reference, rồi mapping class |
| Tên class obfuscate | `classes.csv` hoặc `symbols.json` |
| Một method overload | `methods.csv`, tra descriptor đầy đủ |
| Một field nguồn | `source_fields.csv`, lấy `originalId` |
| Số dòng source | `source_index.json`, API/field reference |
| Slot local | `locals.csv` và declaration index; đọc giới hạn ghép slot |
| Caller/callee | `call_graph.csv/json` của input |
| Truy cập field | `field_accesses.csv` của input |
| Căn cứ tên trước/sau rename | `readable_name_changes.csv`, các file changes JSON |

`source_locals.json` là bản xuất tương thích của source index, không phải một kết quả phục hồi độc lập khác. Các path public đã được chuyển sang `source/src/main/java`.

## 6. Canonical comparison đã so cái gì

Hai phía là bản ECJ rebuilt trước đổi tên và bản ECJ rebuilt hiện tại. Tên ở mỗi phía được quy về identity chung theo remap config, rồi so canonical class bytes.

Các phần được bao gồm theo report:

- Instruction và thứ tự của instruction.
- Branch target.
- Exception handler có thứ tự.
- Constant.
- Member/access metadata.
- `maxStack` và `maxLocals`.

Debug attributes/stack-map frames bị loại khỏi phép so sánh. Kết quả của release và debug đều là 130/130 class, 193.867 instruction và 1.479 exception handler không mismatch.

Điều đó xác nhận đợt rename/chuyển workflow giữ executable code của **baseline rebuilt đã lưu**. Nó không chứng minh baseline decompile ban đầu đã tương đương mọi nhánh của JAR obfuscate gốc.

## 7. Audit heuristic gốc là phép kiểm khác

So sánh heuristic giữa JAR gốc và rebuilt chỉ khớp tập thao tác ở 122/130 class; còn 565 khác biệt theo method và 64 residual cấp class. Tập thao tác bỏ qua các chi tiết luồng điều khiển quan trọng.

Tám class gắn cờ:

- `SessionConnector`
- `ItemTree`
- `SkillOption`
- `Npc`
- `mFont`
- `GameScr`
- `SessionReceiver`
- `DataSkillEff`

Không lấy số class canonical khớp baseline để che số class heuristic chưa khớp original. Hai phép kiểm có mục đích và hai đối tượng so khác nhau.

## 8. Build, linkage và runtime

10 vòng mới chạy cả release/debug, tổng 20 build sạch. Trong từng mode, hash JAR ổn định. Checkout mới không có thư viện/resource/JDK kèm theo cũng đã tải dependency, compile-only, import resource và build lại đúng hash.

Linkage kiểm tra 19.828 call site và 43.970 field site của mỗi JAR mới với `-Xverify:all`. Report ghi rõ `classInitialization: false`: không dùng kết quả này để nói static initializer của mọi class đã chạy.

MicroEmulator test quan sát splash, chọn server, DOWN/UP, form login và lifecycle. 166 PNG được decode; framebuffer được đo bằng chương trình. Kết quả này không xác nhận tương thích mọi server hoặc chất lượng hình ảnh bằng mắt.

Runner debug được mở thật, có listener và `JDWP-Handshake` ở loopback. Đây là kiểm tra đường khởi chạy debugger, không phải test mọi breakpoint ở mọi nhánh game.

## 9. Những gì còn phải thử nếu phát triển tiếp

Các nhóm chưa có bằng chứng đầy đủ gồm login thật, handshake/network với server, combat, parser cho mọi command, cache/RMS qua nhiều phiên và gameplay online dài hạn. Log `Creating thread with no MIDlet context` ở connector vẫn được ghi nhận thay vì xóa khỏi báo cáo.

Khi sửa một nhánh, bổ sung ca kiểm tra đúng nhánh đó. Không cần lặp những phép kiểm không liên quan chỉ để tăng số lượt; số lượng test không thay thế coverage và sự khác biệt của ca thử.

## 10. Bằng chứng nào nằm trong repo

[verification-summary.json](../reports/verification-summary.json) chứa các round build, hash, số liệu canonical/linkage, frame/action runtime và kết quả checkout/debug launcher đã chọn lọc.

Baseline binary, JAR/DLL đầu vào, fixture, log thô và runtime profile được giữ cục bộ. Public repo không có đầy đủ các input đó để chạy lại mọi audit lịch sử chỉ bằng một clone. Build nguồn hiện tại vẫn có script/lock để tái tạo khi người dùng cung cấp đúng JAR resource và JDK.

## 11. Khi đổi tên tiếp

Giữ identity gốc, kiểm tra method override family và overload, cập nhật reference theo descriptor và làm canonical audit với baseline phù hợp. Tránh thay thế theo chữ toàn repo vì tên ngắn hoặc tên trùng có thể thuộc member khác.

Khi chỉ sửa tài liệu, không đổi Java, mapping identity, dependency lock, resource lock hoặc JAR đã kiểm chứng. Các bảng API/field được tạo từ source index để tránh chép sai signature và vị trí.
