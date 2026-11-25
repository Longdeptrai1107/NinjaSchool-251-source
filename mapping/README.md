# Đọc mapping

`symbols.json` và `remap_config.json` giữ định danh JVM gốc theo bộ `(owner, name, descriptor)`. Không dùng riêng tên method/field để đối chiếu vì có overload và tên trùng giữa các class.

- `classes.csv`, `methods.csv`, `fields.csv`, `locals.csv`: kiểm kê 130 class, 1.349 method, 2.322 field và 3.767 slot local bytecode của đầu vào.
- `source_index.json`, `source_*.csv`: vị trí khai báo trong `source/src/main/java`; gồm 5.043 khai báo tham số/local/catch. `source_locals.json` là bản xuất tương thích của source index.
- `class_correspondence.json`, `classes/*.md`: căn cứ đối chiếu và ghi chú cho từng class.
- `call_graph.*`, `field_accesses.csv`: quan hệ gọi và truy cập field của đầu vào; không thay thế kiểm thử luồng điều khiển.
- `readable_*_changes.json`, `readable_name_changes.csv`: lịch sử đổi 461 field và 249 method còn tên hash.
- `NAMING_EVIDENCE.md`, `UNRESOLVED_NAMES.md`: căn cứ đặt tên và giới hạn phục hồi.

`reference_proposal` là tên đề xuất theo vai trò trong DLL tham chiếu; `behavioral_name` mô tả hành vi thấy trong Java. Chúng không phải bằng chứng đã tìm lại tên nguyên thủy trước obfuscation. Slot local bytecode có thể được tái sử dụng; tên local gốc không có trong metadata đầu vào.

Đường dẫn source được đổi sang bố cục mới; định danh gốc, descriptor và bằng chứng đối chiếu được giữ lại. Xem `../reports/VERIFICATION.md` để phân biệt kiểm tra đợt đổi tên với các giới hạn của quá trình tái dựng ban đầu.

Nếu đọc trực tiếp trên GitHub, [API reference](../docs/API_REFERENCE.md) có đầy đủ 1.311 khai báo method/constructor và [field reference](../docs/FIELD_REFERENCE.md) có 2.322 field, liên kết tới đúng dòng Java. [Hướng dẫn mapping/kiểm chứng](../docs/MAPPING_AND_VERIFICATION.md) giải thích vì sao số method input, declaration source và method compiler sinh ra không phải cùng một số đếm.
