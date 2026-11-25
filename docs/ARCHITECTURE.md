# Kiến trúc source NSO

[Về README](../README.md) · [API theo class](API_REFERENCE.md) · [Luồng mạng](NETWORK.md)

## 1. Các tầng của chương trình

```text
Java ME runtime / MicroEmulator
  ├── GameMidlet: lifecycle, Display, danh sách server
  ├── MotherCanvas: Canvas MIDP thật
  │     └── CanvasAdapter → GameCanvas: input, loop, overlay
  │           └── mScreen → screen hiện tại
  │                 ├── screen khởi động / login / chọn nhân vật
  │                 ├── GameScr / MapScr
  │                 └── dialog / menu / command / text field
  ├── Model game: Char, Mob, Npc, Item, Skill, Task, Clan…
  ├── Render: mGraphics, mFont, Paint, SmallImage, Part, Effect…
  ├── Network: Service → Message → Session; Session → Controller
  └── Resource / RMS / cache
```

Đây là cách chia để đọc source. Nhiều class dùng singleton và field static chung; code không tách thành module độc lập như một framework desktop hiện đại.

## 2. Lifecycle thực tế

Trong [GameMidlet](../source/src/main/java/main/GameMidlet.java), constructor:

1. Tạo `MotherCanvas.instance`.
2. Gắn `Controller.gI()` vào `Session_ME.gI()`.
3. Gán `GameMidlet.instance` và tạo `GameCanvas`.
4. Gọi `startGameLoop()` để tạo thread.
5. Đọc `agent.txt`, `provider.txt` và dựng `SplashScr`.

`startApp()` đặt `MotherCanvas.instance` lên `Display`; không phải nơi chứa toàn bộ khởi tạo. `exit()` tắt `GameCanvas.bRun`, gọi GC và `notifyDestroyed()`.

`pauseApp()` và `destroyApp(boolean)` hiện không có phần thân xử lý. Kiểm thử lifecycle của emulator đã gọi các hook, nhưng không vì vậy mà khẳng định game tự pause toàn bộ thread hoặc đóng mọi socket ở hai hook này.

## 3. Canvas và adapter

[MotherCanvas](../source/src/main/java/main/MotherCanvas.java) kế thừa MIDP `Canvas`, giữ một `CanvasAdapter`. Các sự kiện paint/key/pointer đi tới adapter. [GameCanvas](../source/src/main/java/main/GameCanvas.java) cung cấp logic game và giữ các screen/dialog dùng chung.

Tách hai lớp này giúp nhìn rõ ba hệ tọa độ/trạng thái:

- `Graphics` của Canvas là đối tượng runtime cung cấp cho frame hiện tại.
- `mGraphics` là wrapper game dùng để clip/translate/draw/scale.
- Pointer được `MotherCanvas` chia zoom trước khi vào adapter.

Khi debug một lỗi chạm, quan sát tọa độ tại cả callback Canvas và handler screen. Một lần chia zoom không đúng ở hai lớp có thể làm hitbox lệch dù ảnh vẫn vẽ đúng.

## 4. Thread game và ngân sách frame

`GameCanvas.startGameLoop()` tạo thread chạy `run()`. Sau khoảng ngủ đầu 10 ms, loop bật `bRun` và tiếp tục đến khi cờ này bị tắt.

Trong từng lượt, code cập nhật cờ effect theo thời gian, task tick/game tick, dialog/menu, screen, Timer, InfoDlg và nhánh reset. Việc render được yêu cầu bằng `repaint()` / `serviceRepaints()`.

Nếu xử lý mất dưới 40 ms, thread ngủ phần còn lại; nếu quá, ngủ 1 ms. Vì vậy:

- 25 FPS là tốc độ mục tiêu suy ra từ 40 ms, không phải kết quả benchmark.
- Breakpoint dừng game thread có thể khiến không có frame mới.
- Nhánh bắt exception ngoài cùng ngủ 1 giây; nếu lỗi tái diễn sẽ tạo cảm giác giật theo nhịp.
- Thread mạng và việc đọc socket không được đồng nhất với loop 40 ms.

## 5. Screen và chuyển màn hình

[mScreen](../source/src/main/java/nso/mScreen.java) là base screen. Các hook chính là `switchToMe`, `keyPress`, `update`, `updateKey`, `paint` và `unLoad`.

| Screen | Mục đích để tra cứu |
|---|---|
| `SplashScr` | Giai đoạn khởi động/tải ban đầu |
| `LanguageScr` | Chọn/ngữ cảnh ngôn ngữ |
| `SelectServerScr` | Danh sách server và action kết nối |
| `LoginScr` | Form tài khoản/mật khẩu, chuyển tới thao tác login |
| `RegisterScr` | Form đăng ký |
| `SelectCharScr` | Chọn nhân vật |
| `CreateCharScr` | Tạo nhân vật |
| `GameScr` | Màn chơi và UI liên quan |
| `MapScr` | Giao diện map |

Danh sách này là chức năng theo source, không khẳng định mọi screen đã được tới bằng luồng online trong test. Smoke test đã quan sát splash, chọn server và login.

## 6. Phím, pointer và command

Các callback vật lý vào `MotherCanvas`, qua adapter tới `GameCanvas`. Game giữ trạng thái phím bấm/giữ và cờ pointer, rồi screen đọc trong lượt `updateKey`.

[Command](../source/src/main/java/nso/Command.java) giữ thông tin nhãn/action/đối tượng xử lý. [IActionListener](../source/src/main/java/nso/IActionListener.java) định nghĩa điểm nhận action; screen/dialog/menu triển khai theo mục đích riêng.

Một tính năng có thể được kích hoạt bằng phím mềm hoặc pointer. Khi chỉnh action, kiểm tra cả đường callback lẫn command thực hiện, không chỉ text đang vẽ trên nút.

`TField` và `NativeTextBoxListener` hỗ trợ đường nhập text của MIDP. Hành vi bàn phím desktop trong emulator có thể khác thiết bị Java ME thật; không suy ra hỗ trợ mọi kiểu bàn phím chỉ từ test UP/DOWN.

## 7. Rendering và overlay

`GameCanvas.paint(Graphics)` gắn `Graphics` vào wrapper, gọi paint của screen khi không loading, reset clip/translate rồi vẽ InfoDlg và dialog hoặc menu. Các trạng thái thông báo khác có nhánh vẽ sau đó.

`GameScr` cùng `Char`, `Mob`, `Npc`, effect, tile/map và UI thực hiện phần lớn việc vẽ trong màn chơi. Khi một phần tử vẽ sai vị trí hoặc bị cắt, xem:

1. Camera/offset ở màn chơi.
2. Clip/translate trước và sau hàm gọi.
3. Anchor khi vẽ ảnh/region.
4. Zoom và kích thước canvas thực/logical.

Source hiện đặt `disableZoom = true` ở MotherCanvas. Code chọn zoom khác vẫn còn nhưng không phải đường mặc định đã được quan sát.

## 8. Model và dữ liệu

`Char`, `Mob`, `Npc` chứa cả dữ liệu lẫn logic update/render. Các class `Item`, `ItemTemplate`, `ItemOption`, `Skill`, `SkillTemplate`, `Task`, `TaskOrder`, `Clan`, `Member`, `Party` và các template/info khác giữ dữ liệu mà parser dựng từ server hoặc resource.

Không phải mọi class có tên model đều hoàn toàn thuần dữ liệu. Dùng [API reference](API_REFERENCE.md) và [field reference](FIELD_REFERENCE.md) để xem đúng những declaration của class trước khi thay đổi.

Khi đọc một thuộc tính nhân vật, nên theo chuỗi:

```text
Controller đọc stream
  → gán field / tạo model
  → GameScr / Char / Mob update
  → hàm paint đọc field
```

Chỉ đổi tên field mà bỏ một use-site sẽ làm sai liên kết; mapping descriptor và audit là công cụ để kiểm soát việc này.

## 9. Cache và tài nguyên

`SmallImage` quản lý ảnh nhỏ/atlas; `FrameImage` chọn frame; `Part` và `PartImage` phục vụ ghép bộ phận; `GameData` giữ bảng icon/byte data và có nhánh thử RMS/resource rồi yêu cầu server.

Source có cả resource cục bộ và dữ liệu tải trong phiên. Vì vậy ảnh không có trong resource lock chưa chắc là file bị mất: trước tiên xác định ID/loader đó vốn lấy từ đâu.

## 10. RMS

[RMS](../source/src/main/java/nso/RMS.java) bọc `RecordStore`. Các nhóm hàm gồm byte array, int, string, ảnh, xóa record và xóa RMS.

Ví dụ có thể tra trong code:

- `NJlink`: cache danh sách server do GameMidlet ghi/đọc.
- `lowGraphic`: lựa chọn đồ họa được GameCanvas đọc.
- `random`: giá trị được Service đọc khi dựng payload login.
- Cache ảnh/effect: các nhánh trong GameData/SmallImage và code liên quan.

Runner hiện dùng `--rms memory`, nên kiểm tra startup không tạo một hồ sơ đăng nhập bền vững để đưa vào repo. Nếu muốn thử persistence, đó là một cấu hình test riêng cần ghi rõ; các kết quả hiện có không xác nhận luồng lưu tài khoản qua nhiều lần khởi động.

## 11. Reset và thoát

Trong loop có nhánh reset về chọn server, xóa nhân vật hiện tại, reset GameScr/vector, dialog, party/clan/friend/enemy và camera/background. Không đồng nhất reset UI này với đóng toàn bộ tài nguyên hệ thống trong mọi hoàn cảnh.

`Session_ME.close()` có đường dọn stream/socket/key riêng. Lifecycle MIDlet, game loop và network session là ba phần cần theo cùng nhau khi điều tra lỗi thoát/kết nối lại.

## 12. Giới hạn diễn giải

Tài liệu này mô tả code hiện tại. Những tên `reference_proposal` không phải tên nguyên thủy được xác nhận; những hành vi chưa được chạy online vẫn cần kiểm thử. Thông tin “giống NRO” chỉ nói đến cách tổ chức/build/debug, không thay thế kiểm tra từng luồng NSO.
