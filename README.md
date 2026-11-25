# NinjaSchool 2.5.1 Java ME

Project source theo cùng bố cục với `D:\NRO`, dùng Eclipse và JDK 17.

- `source/`: project Eclipse, source game hiện tại và script build/run/debug.
- `source/src/main/java/`: 130 file Java đã đổi tên field/method theo mapping.
- `source/src/main/resources/`: tài nguyên nhập cục bộ từ JAR gốc; không đưa vào Git.
- `source/dist/`, `source/debug-dist/`: JAR/JAD release và debug được build từ source.
- `mapping/`: đầy đủ định danh 130 class, 1.349 method, 2.322 field và 3.767 slot local.
- `reports/VERIFICATION.md`: phạm vi và kết quả kiểm tra; không phải chứng minh mọi gameplay online tương đương.
- `NinjaSchool-source-debug.zip`: gói source nhẹ lưu cục bộ, cùng nội dung public; không kèm JDK, tài nguyên game, thư viện binary hay build/cache cũ.

## Clone và build

Cần JDK 17 và bản JAR NinjaSchool 2.5.1 đầu vào mà bạn có quyền sử dụng. Thư viện nhỏ được tải theo URL/hash đã ghim; tài nguyên gốc được kiểm tra theo resource lock.

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\source\build.ps1 -OriginalJar 'C:\path\NinjaSchool_251.jar'
powershell -NoProfile -ExecutionPolicy Bypass -File .\source\run.ps1
```

Sau lần nhập tài nguyên đầu tiên, chạy `build.ps1` không cần `-OriginalJar`. Có thể truyền `-JavaHome 'C:\path\jdk-17'` hoặc đặt `JAVA_HOME`.

Xem [hướng dẫn source/Eclipse/debug](source/README.md) và [căn cứ đặt tên](mapping/NAMING_EVIDENCE.md). Repo public không chứa token, tài khoản, runtime profile, DLL/JAR gốc, JDK, decompiler hoặc dữ liệu phân tích thô. Project `NinjaSchool-src` cũ vẫn được giữ cục bộ, không bị xóa hoặc thay logic.

## Giới hạn

Source không còn tên `field_*_<hash>` / `method_*_<hash>` hoặc placeholder decompiler. Tên là đề xuất đối chiếu DLL hoặc mô tả hành vi Java, không tự nhận đã khôi phục mọi tên trước obfuscation. Tên local gốc không có trong metadata. Chưa kiểm thử đăng nhập, chiến đấu, mọi nhánh giao thức hoặc gameplay online dài hạn.

Xem [tình trạng giấy phép](LICENSE.md) trước khi phân phối lại nội dung.
