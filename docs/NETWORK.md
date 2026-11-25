# Mạng và message của NSO

[Về README](../README.md) · [Service](../source/src/main/java/nso/Service.java) · [Controller](../source/src/main/java/nso/Controller.java)

Nội dung dưới đây là bản đồ đọc source hiện tại. Chưa có kết quả đăng nhập thật hoặc xác minh toàn bộ giao thức với server, nên đây không phải đặc tả protocol hoàn chỉnh.

## 1. Chọn server

`GameMidlet` giữ `IP`, `PORT`, `serverLogin`, các mảng tên/IP/port/ngôn ngữ và chuỗi danh sách dự phòng. `IP` ban đầu rỗng; `PORT` ban đầu là 14444. Các giá trị được điều chỉnh theo server đã chọn.

`loadLinkRMS()` thử cache `NJlink`; nếu chưa có thì đi qua đường lấy/parse danh sách server. `getStrSv()` có nhánh HTTP và fallback đã có trong source. Không coi địa chỉ hardcode hay URL trong source là bằng chứng host hiện còn chạy.

`GameCanvas.connect(int)` ghép chuỗi `socket://` từ `IP` và `PORT`. Nhánh BlackBerry có thể bổ sung tham số kết nối. Sau đó nó gọi singleton session.

## 2. Session và queue

| Thành phần | State quan trọng |
|---|---|
| `Session_ME` | `connected`, `connecting`, socket/stream, handler, key, cursor đọc/ghi |
| `SessionSender` | Tham chiếu session; queue nằm trong session |
| `SessionReceiver` | Tham chiếu session; đọc từ input stream |
| `SessionConnector` | URL kết nối và session |
| `ConnectionTimeout` | Runnable timeout được connector tạo |

Source dùng một singleton `Session_ME.gI()`. Không có hai session chính/phụ theo sơ đồ NRO trong phiên bản này. Cũng không suy ra các cơ chế generation/watchdog nâng cấp của repo khác tồn tại ở NSO.

`sendMessage(Message)` xếp message vào `sendQueue`. Sender chỉ lấy queue khi `getKeyComplete` đã bật; giữa các lượt có khoảng ngủ 10 ms. Message có thể được xếp trước khi handshake hoàn tất.

## 3. Kết nối

Luồng cần đọc:

```text
GameCanvas.connect
  → Session_ME.connect
      → tạo initThread/SessionConnector và khởi động qua đường hiện có
  → SessionConnector.run
      → tạo ConnectionTimeout
      → Connector.open(connectionUrl)
      → mở DataOutputStream / DataInputStream
      → khởi động SessionSender và SessionReceiver
      → ghi thời điểm kết nối
      → gửi trực tiếp Message(-27)
```

Một số cờ kết nối được gán trước khi `Connector.open` hoàn tất. Khi quan sát lỗi, xem cờ cùng socket/stream thực tế; không coi một boolean riêng là bằng chứng toàn bộ kết nối/handshake đã xong.

## 4. Message

[Message.java](../source/src/main/java/nso/Message.java) bao gói command và payload. Nhánh tạo để gửi dùng output buffer/writer; nhánh nhận từ byte array cấp reader.

Các method cần tra là `writer()`, `reader()`, `getData()`, `cleanup()`. Việc `Service` gọi `cleanup` sau khi xếp message có thể trông lạ khi chỉ đọc tên hàm; hãy xem implementation buffer/stream thực tế trước khi sửa thời điểm giải phóng.

`PacketBuffer` là lớp buffer được giữ trong source; `Readmsg` xử lý nhánh dữ liệu vĩ thú/countdown liên quan. Tên class không đủ để kết luận đó là một thread đọc socket khác.

## 5. Service và nhóm command

| Wrapper | Outer command | Subcommand |
|---|---:|---|
| `messageNotLogin(byte)` | -29 | Ghi ở byte đầu payload |
| `messageNotMap(byte)` | -28 | Ghi ở byte đầu payload |
| `messageSubCommand(byte)` | -30 | Ghi ở byte đầu payload |

Các hàm khác có thể tạo `new Message(cmd)` trực tiếp. Không gán mọi message vào một trong ba wrapper nếu thân hàm không làm vậy.

Ví dụ đường login đang thấy trong source:

1. `Service.login(username, pass, version)` gọi `setClientType()`.
2. Message thông tin client được ghi các trường môi trường/viewport/type theo source.
3. Message login dùng outer command -29 và subcommand -127.
4. Payload ghi username, password, version, các chuỗi bổ sung, giá trị RMS `random` và `serverLogin` theo đúng thứ tự.
5. Message được xếp vào session.

Chuỗi version `2.5.1` do các màn hình gọi truyền vào không phải `MIDlet-Version` trong manifest. Đổi nhãn manifest không tự đổi payload giao thức.

## 6. Frame gửi thông thường

```text
command: 1 byte
length:  2 byte
payload: length byte
```

Trong `Session_ME.doSendMessage`:

- Trước khi có key, command/length/data đi theo nhánh chưa XOR.
- Sau khi có key, command đi qua `writeKey`.
- Length thường được tách hai byte và XOR; command -31 có nhánh khác dùng `writeShort`.
- Payload được XOR tại chỗ trước khi ghi nếu key đã sẵn sàng.
- Nếu data là `null`, code có nhánh ghi length 0 riêng.
- Sau khi ghi, stream được flush.

Đây là mô tả của các nhánh code hiện tại. Không tự suy ra length encoding của một hướng từ hướng còn lại.

## 7. Frame nhận và command -32

Receiver đọc byte command đầu, giải mã nếu đã có key. Sau đó:

| Nhánh | Cách lấy command/length |
|---|---|
| Command khác -32, chưa có key | Length bằng `readUnsignedShort()` |
| Command khác -32, đã có key | Hai byte length được đọc/giải XOR rồi ghép unsigned |
| Command -32 | Đọc thêm command thực và bốn byte length theo nhánh đặc biệt |

Payload được đọc trong vòng lặp cho đến khi đủ lượng cần hoặc gặp kết thúc đọc theo code. Nếu có key, từng byte payload được giải XOR trước khi tạo `Message`.

Khi nhìn packet capture, nhớ TCP là byte stream: một lần `read()` không được đảm bảo trùng với một frame. Source có logic gom đủ payload; đừng “tối giản” thành một lần read duy nhất.

Các counter `sendByteCount`/`recvByteCount` được code cập nhật để hiển thị. Muốn đo byte thực qua wire phải kiểm tra cách cộng ở từng nhánh; tên counter không đủ để bảo đảm đó là bộ đếm chính xác cho mọi tình huống.

## 8. Handshake key

Connector gửi command -27. Receiver khi nhận `Message.command == -27` gọi `getKey` thay vì đẩy message vào dispatcher thông thường.

`getKey` đọc độ dài và mảng key, sau đó thực hiện:

```text
key[i + 1] = key[i + 1] XOR key[i]
```

Cuối cùng bật `getKeyComplete`. Cursor đọc/ghi là state của session; `readKey` và `writeKey` tiến cursor, quay vòng theo độ dài key.

XOR theo state yêu cầu đúng thứ tự byte. Khi điều tra parse lệch, xem từ frame/header đầu tiên bị sai thay vì chỉ sửa ở nơi cuối cùng ném exception.

## 9. Controller

`Controller.onMessage` phân nhóm command và gọi parser tương ứng. Những điểm bắt đầu quan trọng:

- `messageNotLogin`: nhóm dữ liệu trước login.
- `messageNotMap`: nhóm ngoài map.
- `messageSubCommand`: subcommand.
- `createItem`, `createSkill`, `createMap`, `createData`: tạo bảng dữ liệu.
- `readCharInfo`, `loadInfoMap`: áp dụng thông tin nhân vật/map.
- Các method effect/icon/mob: đọc dữ liệu animation/hình ảnh và model liên quan.

Phần đọc stream dùng `readByte`, `readShort`, `readInt`, `readUTF`, v.v. Mỗi kiểu có kích thước/encoding riêng; đổi kiểu để “hợp tên field hơn” mà không kiểm chứng payload có thể làm lệch mọi trường theo sau.

## 10. Khi mất kết nối

Receiver có nhánh xử lý khi loop kết thúc/exception; tùy trạng thái và thời gian kết nối, code có thể reset UI về login/chọn server hoặc báo lỗi qua handler. `Session_ME.cleanNetwork` reset key/cursor/cờ và đóng socket/stream.

Không tự thêm hành vi reconnect trong tài liệu rồi coi đó là code đã có. Bộ test hiện tại chưa chạy kịch bản reconnect/đăng nhập thật nhiều lần với server.

## 11. Điểm quan sát khi debug

| Câu hỏi | Quan sát |
|---|---|
| Đang gọi host nào? | `GameMidlet.IP`, `PORT` và URL ở `GameCanvas.connect` |
| Socket đã mở chưa? | `SessionConnector.run`, socket/stream thực tế |
| Đã nhận key chưa? | `SessionReceiver.getKey`, `getKeyComplete` |
| Có message đang chờ không? | Queue session và `SessionSender.run` |
| Client gửi field nào? | `Service` method cụ thể và `Message.writer` |
| Sai ở header hay payload? | Receiver trước/sau XOR, length và command thực |
| Nhánh parser nào nhận data? | `Controller.onMessage` và outer/subcommand |
| UI thay đổi ở đâu? | Field/model sau parser, lượt update/paint tiếp theo |

Các điểm trên là hướng dẫn quan sát source. Không đưa tài khoản, token hay payload có thông tin đăng nhập vào issue/log công khai khi báo lỗi.

## 12. Phạm vi đã thử

Đã kiểm tra linkage của hai JAR mới, khởi động emulator, input/lifecycle và chuyển tới form login. Log đã có `Creating thread with no MIDlet context` tại connector. Chưa xác nhận server handshake/login thành công, tương thích mọi phiên bản server hoặc mọi nhánh parser. [Báo cáo](../reports/VERIFICATION.md) giữ rõ các giới hạn này.
