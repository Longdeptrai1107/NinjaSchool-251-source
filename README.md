# NinjaSchool 2.5.1 — source Java ME

Source Java được tái dựng từ `NinjaSchool_251.jar`, đối chiếu thêm với bản Unity/C# do người dùng cung cấp, rồi tổ chức thành project Eclipse có build release, build debug và chạy MicroEmulator. Bố cục sử dụng cùng cách làm với project NRO: `src/main/java`, `src/main/resources`, ECJ và external builder của Eclipse.

Repo giữ source hiện tại, mapping định danh, cấu hình phụ thuộc và báo cáo kiểm tra. JAR/DLL đầu vào, tài nguyên game, JDK, thư viện binary, profile runtime và dữ liệu đăng nhập được giữ ngoài Git. Khi build lần đầu, script tải thư viện theo hash và nhập tài nguyên từ đúng JAR mà bạn có sẵn.

**Giới hạn cần đọc trước:** bản dựng đã qua kiểm tra source, build, bytecode baseline và khởi động emulator. Chưa kiểm chứng đăng nhập thật hay toàn bộ gameplay online. Tên đọc được là đề xuất theo tham chiếu/hành vi; không tự nhận phục hồi đầy đủ tên gốc trước obfuscation.

## Mục lục

- [Thông tin nhanh](#thông-tin-nhanh)
- [Bắt đầu từ bản clone sạch](#bắt-đầu-từ-bản-clone-sạch)
- [Build release, debug và compile-only](#build-release-debug-và-compile-only)
- [Chạy và debug trong Eclipse](#chạy-và-debug-trong-eclipse)
- [Cấu trúc repository](#cấu-trúc-repository)
- [Kiến trúc và thứ tự khởi động](#kiến-trúc-và-thứ-tự-khởi-động)
- [Mạng, message và handshake](#mạng-message-và-handshake)
- [Đồ họa, map và tài nguyên](#đồ-họa-map-và-tài-nguyên)
- [Các module nên đọc trước](#các-module-nên-đọc-trước)
- [Danh mục toàn bộ 130 file Java](#danh-mục-toàn-bộ-130-file-java)
- [Mapping, tên và biến cục bộ](#mapping-tên-và-biến-cục-bộ)
- [Compiler, lock file và JAR](#compiler-lock-file-và-jar)
- [Kết quả kiểm chứng](#kết-quả-kiểm-chứng)
- [Lỗi thường gặp](#lỗi-thường-gặp)
- [Sửa source và đọc tiếp](#sửa-source-và-đọc-tiếp)
- [Giấy phép và phân phối](#giấy-phép-và-phân-phối)

## Thông tin nhanh

| Mục | Giá trị của NSO trong repo này |
|---|---|
| Game/đầu vào | NinjaSchool, file đầu vào mang nhãn 2.5.1 |
| Version gửi khi login | Chuỗi `2.5.1` trong `LoginScr` / `SelectServerScr` |
| `MIDlet-Version` trong manifest | `1.0.0`, giữ theo manifest hiện tại; không đổi thành nhãn filename |
| Cấu hình manifest | CLDC-1.0 / MIDP-2.0 |
| API dùng để compile | CLDC API 1.1, MIDP API 2.0 và WMA JSR-120 |
| MIDlet entry | `main.GameMidlet` |
| Source | 130 file Java, 50.666 dòng |
| Package | `main` có 4 file; `nso` có 126 file |
| Tài nguyên khóa theo hash | 239 file, 541.878 byte; có 166 PNG |
| Kiểm kê bytecode đầu vào | 130 class, 1.349 method, 2.322 field |
| Slot local bytecode | 3.767 slot được kiểm kê |
| Khai báo tham số/local/catch trong source | 5.043 khai báo được lập chỉ mục |
| Compiler | Eclipse ECJ 3.33.0 |
| Classfile output | 45.3 — Java 1.1; source được compile theo mức 1.3 |
| Host đã kiểm tra | Windows PowerShell + JDK 17 + MicroEmulator 2.0.4 |
| Vòng lặp game | Mục tiêu 40 ms/frame, khoảng 25 frame/giây khi xử lý đủ nhanh |
| Session mạng | Một singleton `Session_ME.gI()` trong source hiện tại |
| Debug mặc định | JDWP `127.0.0.1:5005`, chờ attach trước khi chạy |
| Project Eclipse | `NinjaSchool-251` |

Số method của input, số method declaration trong source và số method của classfile compile không phải cùng một khái niệm. Source index hiện có **1.311 khai báo method/constructor**; compiler có thể phát sinh initializer/accessor. [Hướng dẫn mapping](docs/MAPPING_AND_VERIFICATION.md) giải thích phạm vi từng bảng.

## Bắt đầu từ bản clone sạch

### Chuẩn bị

1. Cài JDK 17 hoặc dùng một thư mục JDK 17 đã có. Đây là JDK chạy công cụ build và emulator; không làm đổi target của JAR game.
2. Trên Windows, dùng PowerShell. Các lệnh bên dưới chạy từ **gốc repository**, nơi chứa `README.md`, `source/` và `mapping/`.
3. Chuẩn bị đúng `NinjaSchool_251.jar` đầu vào để nhập tài nguyên. File khác phiên bản sẽ bị từ chối bằng SHA-256.
4. Lần đầu cần truy cập Maven Central để tải 5 dependency. Sau khi có đủ thư viện và tài nguyên đúng hash, build có thể thực hiện offline.

```powershell
git clone https://github.com/Longdeptrai1107/NinjaSchool-251-source.git
cd NinjaSchool-251-source

# Chỉ định JDK nếu JAVA_HOME/PATH chưa có.
$env:JAVA_HOME = 'C:\path\jdk-17'

# Lần đầu: tải thư viện và nhập tài nguyên từ JAR bạn có sẵn.
powershell -NoProfile -ExecutionPolicy Bypass -File .\source\build.ps1 `
  -OriginalJar 'C:\path\NinjaSchool_251.jar'

# Những lần sau không cần truyền -OriginalJar.
powershell -NoProfile -ExecutionPolicy Bypass -File .\source\run.ps1
```

SHA-256 của JAR được chấp nhận để nhập tài nguyên:

```text
96f811dc1317ec41ba01953350436dc8f850090c3018a26b4ae35f3124c2e95d
```

Kiểm tra file trước khi build:

```powershell
Get-FileHash -Algorithm SHA256 -LiteralPath 'C:\path\NinjaSchool_251.jar'
```

Đường dẫn `C:\path\...` là ví dụ để thay bằng đường dẫn của bạn. Không cần chép JAR gốc vào repository. `-OriginalJar` đọc JAR và nhập các resource được khóa; nó không sửa file đầu vào và không lấy class đã compile trong JAR gốc để dùng thay source.

Nếu chỉ muốn xem source và kiểm tra compiler khi chưa có JAR đầu vào, dùng `-CompileOnly`. Chế độ này **không tạo một JAR game đầy đủ để chạy**.

## Build release, debug và compile-only

### Release

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\source\build.ps1
```

Compiler nhận `-g:lines,source`: giữ tên file và số dòng để trace/breakpoint, không yêu cầu giữ toàn bộ local-variable metadata.

### Debug

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\source\build.ps1 -DebugSymbols
```

Compiler nhận `-g`, tạo bản có thêm thông tin debug cho biến cục bộ. Các biến thấy được là tên trong source hiện tại, không phải bằng chứng phục hồi tên gốc đã mất. Phạm vi sống của biến và cách compiler sinh bytecode vẫn ảnh hưởng cửa sổ Variables của debugger.

### Chỉ compile

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\source\build.ps1 -CompileOnly
```

Kiểm tra đủ 130 source, dependency và classfile output; bỏ qua bước nhập/đóng gói tài nguyên. Không dùng chế độ này để kết luận game đã chạy được. Nếu thư mục output đã có JAR từ lần build cũ, JAR đó không phải sản phẩm mới của lần compile-only.

### Chọn JDK hoặc thư mục output

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\source\build.ps1 `
  -JavaHome 'C:\path\jdk-17' -OutputDirectory 'C:\path\nso-release'
```

Thứ tự tìm Java: `-JavaHome` → `source/toolchain/java` → `JAVA_HOME` → `java` trong PATH. `-JavaHome` trỏ tới **thư mục JDK**, không phải tới `bin` hoặc `java.exe`.

| Tham số build | Ý nghĩa |
|---|---|
| `-JavaHome <folder>` | Chọn JDK cho công cụ build |
| `-OriginalJar <file>` | Nhập/kiểm tra tài nguyên từ đúng JAR đầu vào |
| `-DebugSymbols` | Compile bằng `-g`, mặc định xuất vào `debug-dist` |
| `-CompileOnly` | Chỉ compile và kiểm tra class; không đóng gói JAR game |
| `-OutputDirectory <folder>` | Chọn output thay cho `dist` / `debug-dist` |

`run.ps1` sử dụng hai output mặc định. Một lần build với `-OutputDirectory` riêng không làm runner tự chuyển sang thư mục đó.

### Output

```text
source/dist/                         source/debug-dist/
├── NinjaSchool_251-source-rebuilt.jar
├── NinjaSchool_251-source-rebuilt.jad
├── build-report.json
├── compiler.log
└── compiler.xml
```

Hai thư mục có cùng tên file bên trong nhưng chế độ debug khác nhau. Không nhầm chúng với `NinjaSchool_251-rebuilt.jar` của workflow tái dựng trước khi chuyển bố cục.

### Gọi builder trực tiếp

Builder là Java source một file và có tham số đầu tiên là action:

```powershell
cd source

java -Dfile.encoding=UTF-8 toolchain/StandaloneJarBuild.java import . 'C:\path\NinjaSchool_251.jar'
java -Dfile.encoding=UTF-8 toolchain/StandaloneJarBuild.java build . dist release
java -Dfile.encoding=UTF-8 toolchain/StandaloneJarBuild.java build . debug-dist debug
java -Dfile.encoding=UTF-8 toolchain/StandaloneJarBuild.java compile . dist release
```

Các lệnh trực tiếp này yêu cầu `lib/` đã được chuẩn bị. Chúng không tự tải dependency như wrapper PowerShell. Xem [hướng dẫn build đầy đủ](docs/BUILD_AND_DEBUG.md) về PowerShell, Java trực tiếp và các giới hạn nền tảng đã kiểm tra.

## Chạy và debug trong Eclipse

### Chạy bình thường

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\source\run.ps1
```

Runner build lại release trước khi mở MicroEmulator. Khi thấy màn hình chọn MIDlet, chọn game rồi bấm **Start**. Màn hình launcher của emulator chưa phải màn hình game.

### Chạy có debugger

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\source\run.ps1 -Debug

# Hoặc dùng cổng riêng.
powershell -NoProfile -ExecutionPolicy Bypass -File .\source\run.ps1 -Debug -Port 5006
```

JVM dùng:

```text
-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=127.0.0.1:5005
```

`suspend=y` nghĩa là JVM chờ debugger trước khi vào chương trình. Chưa thấy cửa sổ game ngay lúc này là hành vi dự kiến. Listener chỉ bind loopback; số cổng trong Eclipse phải khớp `-Port` của runner.

### Cấu hình Eclipse

1. File → Import → General → Existing Projects into Workspace.
2. Chọn thư mục **`source`**, import project **`NinjaSchool-251`**. Không chọn nhầm gốc repo làm một Java project mới.
3. Chuẩn bị JDK/dependency/resource theo mục build. Eclipse external builder cũng cần tìm được Java.
4. Project → Build Project. `.externalToolBuilders/Build-JAR.launch` gọi `eclipse-build.ps1`.
5. Đặt breakpoint ở `main.GameMidlet.startApp()` để bắt thời điểm hiển thị canvas, hoặc ở constructor `GameMidlet` để quan sát phần khởi tạo trước `startApp()`.
6. Chạy `run.ps1 -Debug` trong terminal.
7. Run → Debug Configurations → Remote Java Application: Project `NinjaSchool-251`, Host `127.0.0.1`, Port `5005`.
8. Bấm Debug, sau đó Resume (F8). Trong emulator chọn game và Start nếu launcher còn đang hiển thị.

Eclipse mới có thể không hỗ trợ mức source 1.3 trong JDT editor như các bản cũ. Build chuẩn của project là external ECJ builder; không nâng compliance/target chỉ để xóa cảnh báo editor nếu vẫn muốn tạo đúng classfile 45.3.

| Muốn quan sát | Vị trí breakpoint |
|---|---|
| Khởi tạo app | Constructor và `startApp()` của `main.GameMidlet` |
| Tick/update | `main.GameCanvas.run()` |
| Frame render | `main.GameCanvas.paint(Graphics)` và `nso.GameScr.paint(mGraphics)` |
| Chọn server | `nso.SelectServerScr.perform(int,Object)` |
| Gửi login | `nso.Service.login(String,String,String)` |
| Dựng kết nối | `nso.SessionConnector.run()` |
| Đọc frame mạng | `nso.SessionReceiver.run()` |
| Dispatch dữ liệu | `nso.Controller.onMessage(Message)` |
| Ảnh trong JAR | `main.GameCanvas.loadImage(String)` |

Runner truyền `--rms memory`. Không dựa vào cấu hình này để kiểm tra dữ liệu tài khoản còn tồn tại qua nhiều lần chạy; xem chi tiết RMS trong [kiến trúc](docs/ARCHITECTURE.md).

## Cấu trúc repository

```text
NinjaSchool-251-source/
├── README.md                         Hướng dẫn tổng thể và danh mục source
├── LICENSE.md                        Tình trạng quyền/giấy phép
├── THIRD_PARTY_NOTICES.md             Công cụ và thành phần bên thứ ba
├── docs/                             Hướng dẫn theo chủ đề, API/field index
├── mapping/                          Định danh gốc, căn cứ đặt tên và exports
│   ├── symbols.json                  Owner + name + descriptor gốc
│   ├── remap_config.json             Tên mapped và resource rules
│   ├── source_index.json             Khai báo source và vị trí dòng
│   ├── classes/*.md                  Bảng field/method của từng class
│   └── *.csv                         Exports để lọc/đối chiếu
├── reports/
│   ├── VERIFICATION.md               Phạm vi và kết quả kiểm tra
│   └── verification-summary.json     Bằng chứng chọn lọc dạng JSON
└── source/
    ├── .project / .classpath          Project Eclipse NinjaSchool-251
    ├── .externalToolBuilders/         Builder Eclipse
    ├── .settings/                    JDT/encoding
    ├── build.ps1                     Wrapper build
    ├── eclipse-build.ps1             Chuẩn bị dependency và gọi builder
    ├── prepare.ps1                   Tải/hash dependency, nhập resource
    ├── run.ps1                       Build + MicroEmulator + JDWP tùy chọn
    ├── config/
    │   ├── MANIFEST.MF               Manifest giữ theo bản hiện tại
    │   ├── classes.list              Danh sách 130 class mong đợi
    │   ├── dependencies.lock.json    5 dependency và hash/URL
    │   └── resources.lock.json       239 resource và hash JAR đầu vào
    ├── toolchain/
    │   ├── JavaHome.ps1              Tìm Java
    │   └── StandaloneJarBuild.java   Compile, kiểm tra và đóng gói
    ├── src/main/java/
    │   ├── main/                     4 class canvas/MIDlet
    │   └── nso/                      126 class game/UI/network/model
    ├── src/main/resources/           Sinh cục bộ từ JAR, không commit
    ├── lib/                          Dependency tải cục bộ, không commit JAR
    ├── bin/                          Class cho Eclipse, không commit
    ├── dist/                         Release, không commit
    └── debug-dist/                   Debug, không commit
```

`source/toolchain/java`, `.build`, output, runtime profile, JAR/DLL gốc và project tái dựng cũ cũng nằm ngoài nội dung public. Một bản clone sạch không có sẵn các thư mục sinh cục bộ trong sơ đồ; script tạo chúng khi cần.

## Kiến trúc và thứ tự khởi động

### MIDlet → canvas → screen

```text
MicroEmulator launcher: Start
  → new main.GameMidlet()
      → new MotherCanvas()
      → Session_ME.gI().setHandler(Controller.gI())
      → new GameCanvas().startGameLoop()
      → đọc /agent.txt và /provider.txt
      → currentScreen = new SplashScr()
  → GameMidlet.startApp()
      → Display.setCurrent(MotherCanvas.instance)
  → GameCanvas.run()
      → currentScreen.update()/updateKey()
      → repaint()/serviceRepaints()
```

Trong NSO, phần lớn khởi tạo ở **constructor `GameMidlet`**, còn `startApp()` đặt canvas lên `Display`. Đây là điểm cần nhớ khi so với project NRO: breakpoint chỉ ở `startApp()` sẽ bỏ qua phần tạo singleton, gắn handler và tạo game loop.

`MotherCanvas` là `Canvas` thật của MIDP. Nó chuyển các lời gọi paint/key/pointer cho `CanvasAdapter`; `GameCanvas` là implementation xử lý game. Các màn hình game kế thừa `nso.mScreen` và được trỏ qua `GameCanvas.currentScreen`.

### Một lượt frame

1. `GameCanvas.run()` cập nhật cờ thời gian hiệu ứng, `taskTick` và `gameTick`.
2. Nếu có dialog thì update dialog; nếu không thì xử lý menu đang mở.
3. Gọi `currentScreen.update()` khi không loading; gọi `currentScreen.updateKey()`.
4. Xử lý action hẹn giờ qua `Timer`, thời hạn `InfoDlg` và nhánh reset về chọn server.
5. Gọi `MotherCanvas.repaint()` rồi `serviceRepaints()`.
6. Lấy thời gian đã xử lý; ngủ phần còn lại của 40 ms, hoặc ngủ 1 ms nếu đã quá ngân sách.

40 ms là mục tiêu đặt trong source, không phải cam kết FPS đo trên mọi máy. Nếu vòng ngoài bắt exception, có nhánh ngủ 1.000 ms rồi in stack trace; đây có thể là nguyên nhân game khựng khi lỗi lặp lại.

### Vẽ một frame

```text
MotherCanvas.paint(Graphics)
  → CanvasAdapter.paint(Graphics)
  → GameCanvas.paint(Graphics)
      → g.graphics = Graphics
      → currentScreen.paint(g), nếu không loading
      → reset translate/clip
      → InfoDlg.paint(g)
      → currentDialog.paint(g) hoặc menu.paintMenu(g)
      → lớp thông báo/kiểm duyệt nếu được bật
```

Background, map, nhân vật và effect của màn chơi được triển khai trong `GameScr` cùng các đối tượng mà nó gọi. `GameCanvas.paint` bọc việc vẽ màn hình và overlay; không có nghĩa mọi background luôn được vẽ trực tiếp ở lớp canvas.

### Input và zoom

`MotherCanvas` chuyển phím sang adapter; tọa độ pointer được chia cho `zoomLevel` trước khi chuyển tiếp. `GameCanvas` cập nhật các mảng trạng thái phím và cờ chạm; screen hiện tại xử lý trong `updateKey()`.

Source hiện tại đặt `MotherCanvas.disableZoom = true`, nên đường đi mặc định giữ zoom 1. Nhánh tính zoom vẫn còn trong code, nhưng không nên mô tả rằng app luôn tự chọn zoom cao như NRO. Asset lock của bản này chỉ chứa nhóm `x1`.

Chi tiết hơn: [kiến trúc, screen, input và RMS](docs/ARCHITECTURE.md).

## Mạng, message và handshake

### Các lớp tham gia

| Lớp | Vai trò trong source |
|---|---|
| `GameMidlet` | Danh sách server, tải/đọc cache `NJlink`, `IP`, `PORT`, `serverLogin` |
| `SelectServerScr` | Chọn server, cập nhật thông tin phục vụ kết nối |
| `GameCanvas.connect(int)` | Ghép URL `socket://` từ host/port đang chọn |
| `Session_ME` | Singleton session, stream, queue, khóa XOR và trạng thái kết nối |
| `SessionConnector` | Mở socket, stream, khởi động sender/receiver và gửi handshake |
| `SessionSender` | Lấy message khỏi queue sau khi có khóa |
| `SessionReceiver` | Đọc command/length/payload, giải mã và chuyển cho handler |
| `Message` | Buffer payload cùng `reader()` / `writer()` |
| `Service` | Các hàm gửi nghiệp vụ: login, di chuyển, item, skill, party, clan… |
| `Controller` | Đọc message và cập nhật dữ liệu/màn hình |

### Đường gửi và nhận

```text
UI / GameScr
  → Service.<action>()
  → Message.writer(): ghi payload đúng thứ tự
  → Session_ME.sendMessage(): xếp queue
  → SessionSender.run(): đợi getKeyComplete, lấy queue
  → Session_ME.doSendMessage(): command + length + data
  → socket

socket
  → SessionReceiver.run(): đọc frame, giải XOR nếu đã handshake
  → new Message(command, data)
  → command -27: getKey()
     command khác: Controller.onMessage()
```

`SessionSender` có khoảng ngủ 10 ms giữa các lượt. Đây là thread gửi, độc lập với mục tiêu 40 ms của game loop.

### Wrapper command của Service

| Hàm tạo message | Outer command | Byte đầu payload |
|---|---:|---|
| `messageNotLogin(byte)` | -29 | Subcommand được truyền vào |
| `messageNotMap(byte)` | -28 | Subcommand được truyền vào |
| `messageSubCommand(byte)` | -30 | Subcommand được truyền vào |

Ví dụ `Service.login()` gọi `setClientType()` trước, rồi tạo message nhóm -29 với subcommand -127, ghi username/password/version và các trường bổ sung theo source. Không hoán đổi thứ tự `writeUTF`/`writeByte`: receiver phía server đọc theo hợp đồng giao thức, không theo tên biến.

### Framing và các nhánh đặc biệt

Frame thường có command một byte, length hai byte và payload. Sau khi handshake, command, length và payload có các nhánh XOR theo source. Riêng gửi command -31 có cách xử lý length khác; nhận command -32 đọc thêm command thực và length bốn byte. Không dùng sơ đồ frame thường để thay thế các nhánh này.

Handshake do `SessionConnector` gửi bằng command -27; `SessionReceiver.getKey()` đọc mảng key rồi XOR lũy tiến các phần tử trước khi bật `getKeyComplete`. Đây là cơ chế đang thấy trong source, chưa phải một tài liệu đặc tả đầy đủ đã kiểm thử với server.

`GameMidlet.IP` khởi tạo là chuỗi rỗng; host thực được chọn/tải qua danh sách server. Các host ghi trong source là dữ liệu tham chiếu của bản game, không phải kết quả kiểm tra server còn hoạt động. Đợt kiểm tra đã mở form login nhưng chưa gửi đăng nhập thật.

Đọc tiếp: [luồng mạng và nơi đặt breakpoint](docs/NETWORK.md).

## Đồ họa, map và tài nguyên

### Nạp ảnh

```java
// GameCanvas.loadImage: minh họa đúng cách ghép đường dẫn trong source.
path = "/x" + mGraphics.zoomLevel + path;
image = Image.createImage(path);
```

Với zoom 1 và tham số `/bg/bg00.png`, đường dẫn resource là `/x1/bg/bg00.png`. `Controller.createImage(byte[])` gọi `Image.createImage` cho byte array và trả `null` khi bắt lỗi. Không áp dụng cơ chế XOR ảnh của NRO vào các file PNG của NSO: các loader này không có bước giải XOR đó.

### Các lớp chính

| Lớp | Việc cần tìm |
|---|---|
| `mGraphics` | Wrapper `Graphics`: draw, region, màu, clip, translate, zoom |
| `mFont` | Font bitmap: đo chữ, vẽ chữ, chia dòng, giải phóng/nạp lại atlas |
| `Paint` | Các hàm vẽ khung, thanh lệnh và phần tử giao diện |
| `SmallImage` | Đọc atlas/ảnh nhỏ, cache, nhận ảnh và vẽ theo ID |
| `GameData` | Cache icon/effect theo ID, thử RMS/resource và có thể yêu cầu server |
| `FrameImage` | Vẽ một frame trong sprite nhiều frame |
| `TileMap` | Tile, map, vật cản và tài nguyên nền |
| `Part` / `PartImage` | Ghép bộ phận nhân vật |
| `DataSkillEff` / `EffectAuto` | Dữ liệu và vòng đời effect theo frame |

### Phân bố tài nguyên

<!-- RESOURCE_TABLE_START -->
| Thư mục | File | Byte |
|---|---:|---:|
| `/` | 3 | 3310 |
| `font/` | 4 | 5488 |
| `map/` | 61 | 96878 |
| `x1/` | 7 | 33176 |
| `x1/bg/` | 53 | 88271 |
| `x1/del/` | 6 | 25366 |
| `x1/e/` | 16 | 1768 |
| `x1/eff/` | 7 | 2788 |
| `x1/export/` | 6 | 7932 |
| `x1/font/` | 20 | 16529 |
| `x1/hd/` | 27 | 30730 |
| `x1/img/` | 5 | 100201 |
| `x1/t/` | 15 | 126500 |
| `x1/u/` | 9 | 2941 |
<!-- RESOURCE_TABLE_END -->

Tổng cộng **239 file / 541.878 byte**, trong đó **166 PNG**. Đây là số liệu trong resource lock, không phải số resource được commit: thư mục resource bị bỏ qua bởi Git và được nhập cục bộ.

Không phải mọi ảnh/effect/map mà server có thể tham chiếu đều nằm trong JAR. Ví dụ `GameData` có nhánh lấy từ RMS, thử resource rồi yêu cầu server khi đang kết nối. Kiểm tra đủ resource lock không tương đương có toàn bộ dữ liệu của một phiên online.

Xem [tài nguyên, hash và cách sửa asset có chủ đích](docs/RESOURCES.md).

## Các module nên đọc trước

### `main.GameMidlet` — điểm vào và danh sách server

Constructor dựng canvas, handler, loop và splash. `startApp()` hiển thị `MotherCanvas`. `exit()` tắt cờ `GameCanvas.bRun` rồi báo MIDlet đã kết thúc. `loadLinkRMS()`, `getStrSv()` và `saveIP()` xử lý danh sách server/cache.

Nên đọc constructor trước `startApp()`, rồi theo sang `GameCanvas.initGameCanvas()` và `SplashScr`. Không mặc định rằng mọi hook rỗng là lỗi decompiler: `pauseApp()` / `destroyApp(boolean)` đang có thân rỗng trong source và baseline; đây là một điểm cần xem theo hành vi thực tế, không tự chèn logic mới trong đợt viết tài liệu.

### `main.GameCanvas` — loop, input và overlay

Giữ màn hình hiện tại, dialog, menu, trạng thái phím/pointer, kích thước viewport và bộ đếm tick. `run()` gọi logic theo frame; `paint(Graphics)` bọc màn hình cùng overlay. Các hàm `startOKDlg`, `startWaitDlg`, `startYesNoDlg`, `endDlg` điều khiển dialog dùng chung.

`connect(int)` không nhận trực tiếp host/port; nó dùng `GameMidlet.IP/PORT` đã được chọn. `loadImage(String)` thêm tiền tố theo zoom. Khi tìm lỗi tọa độ, theo cả `MotherCanvas`, `GameCanvas` và screen thay vì chỉ sửa một nơi.

### `nso.Controller` — đọc và áp dụng dữ liệu server

`onMessage(Message)` là dispatcher lớn; các nhóm -29/-28/-30 chuyển sang `messageNotLogin`, `messageNotMap`, `messageSubCommand`. Các hàm `createItem`, `createSkill`, `createMap`, `createData`, `loadInfoMap` và `readCharInfo` dựng dữ liệu từ stream.

Nếu parse sai một kiểu hoặc số lượng field, vị trí đọc bị lệch và những lỗi sau có thể xuất hiện xa chỗ gây ra lỗi. Khi sửa, dùng descriptor/source index và trace cùng phiên bản giao thức; chưa có kiểm thử online đầy đủ để bảo đảm mọi nhánh parser.

### `nso.Service` — ghi payload cho thao tác

Gồm nhóm login, đăng ký/khôi phục tài khoản, chuyển map/khu, di chuyển, chọn/tạo nhân vật, item, skill, party, clan, bạn bè và các menu nghiệp vụ. Các hàm tạo `Message`, ghi field rồi xếp vào session.

Điểm bắt đầu dễ đọc: `login`, `charMove`, `requestChangeMap`, `requestChangeZone`, `selectCharToPlay`, `createChar`. Tên hàm là chỉ dẫn để tìm code; thứ tự ghi trong thân hàm mới là căn cứ payload.

### `nso.GameScr` — màn chơi

Màn hình game xử lý camera, danh sách đối tượng, input trong map, lựa chọn mục tiêu, combat, item/UI, effect và giao diện party/clan. File lớn nên nên tìm theo nhóm method và field, không đọc toàn bộ tuyến tính ngay từ đầu.

Để theo một lỗi nhân vật/map: bắt đầu `Controller.loadInfoMap` hoặc nhánh message cập nhật đối tượng, kiểm tra model tương ứng, rồi `GameScr.update` và `paint`. Màn chọn server/form login chạy được không xác nhận các luồng này đã được thử trong gameplay online.

### `nso.Char`, `Mob`, `Npc` — thực thể

`Char` giữ tọa độ/vận tốc, trạng thái, chỉ số, trang bị, skill, hiển thị và các nhánh hiệu ứng nhân vật. `Mob` xử lý dữ liệu/hành vi quái; `Npc` kế thừa `Char` và có logic tương tác/render riêng.

Hai field đã được truy vết riêng: `Char.tickEffWolf` tương ứng định danh gốc `bp.cmI`, và `Char.timeBocdau` tương ứng `bp.cnI`. Căn cứ đặt tên và các giới hạn nằm trong [NAMING_EVIDENCE.md](mapping/NAMING_EVIDENCE.md).

### `nso.mScreen` và các màn hình

`mScreen` cung cấp `switchToMe`, `keyPress`, `update`, `updateKey`, `paint` cùng các command cơ sở. Nhóm màn hình gồm `SplashScr`, `LanguageScr`, `SelectServerScr`, `LoginScr`, `RegisterScr`, `SelectCharScr`, `CreateCharScr`, `MapScr` và `GameScr`.

Để thêm/chỉnh một hành vi giao diện, theo `Command` → `IActionListener.perform` của screen. Phím vật lý, command mềm và pointer có thể đi qua các nhánh khác nhau trước khi cùng kích hoạt action.

### UI, text và hội thoại

`Command` mô tả lệnh; `Menu` quản lý lựa chọn; `Dialog`, `MsgDlg`, `InputDlg`, `Input2Dlg` là các loại hộp thoại. `TField` quản lý nhập text, `NativeTextBoxListener` nối với text box MIDP. `ChatTextField`, `ChatPopup`, `ChatManager`, `ChatTab` xử lý chat ở các tầng khác nhau.

`Scroll` / `ScrollResult` phục vụ cuộn và kết quả hit/input. `Info`, `InfoMe`, `InfoDlg`, `InfoItem` có vai trò hiển thị thông tin; không thay tên file chỉ vì chúng có từ gần giống nhau.

### Dữ liệu thuần và tiện ích

`Item`, `ItemTemplate`, `ItemOption`, `Skill`, `Task`, `Clan`, `Member`, `Party`, `MobTemplate`, `NpcTemplate`, `Frame`, `Position`, `Waypoint` và các class `*Info` / `*Template` giữ dữ liệu/định dạng sử dụng trong game.

`RMS` bọc RecordStore; `Res` chứa toán/tách chuỗi/countdown; `MyVector`, `mHashtable`, `StringHashtable` là lớp chứa dữ liệu; `mResources` giữ chuỗi giao diện. `SMS` / `SmsSender` dùng WMA, vì vậy `microemu-jsr-120` là dependency thực chứ không phải file thừa để bỏ khỏi classpath.

## Danh mục toàn bộ 130 file Java

Bảng dưới được dựng từ source hiện tại và source index. “Khai báo” là method/constructor tìm được trong source; “Hàm tiêu biểu” chỉ rút gọn để tra cứu. Bảng API đầy đủ có **1.311 khai báo**, bảng field có **2.322 field**; mọi dòng đều có đường dẫn về source và định danh JVM gốc.

- [API đầy đủ theo class](docs/API_REFERENCE.md)
- [Field đầy đủ theo class](docs/FIELD_REFERENCE.md)
- [Mapping và căn cứ từng class](mapping/README.md)

<!-- SOURCE_CATALOG_START -->
### Khởi động và canvas — 4 file

| File | Dòng | Khai báo | Field | Vai trò / hàm tiêu biểu |
|---|---:|---:|---:|---|
| [`main/CanvasAdapter.java`](source/src/main/java/main/CanvasAdapter.java) | 21 | 7 | 0 | Hợp đồng callback paint/key/pointer giữa Canvas và game. `paint()`, `keyPressed()`, `keyReleased()`, `pointerDragged()`, `pointerPressed()`, `pointerReleased()`. [API](docs/API_REFERENCE.md#maincanvasadapter) / [field](docs/FIELD_REFERENCE.md#maincanvasadapter) |
| [`main/GameCanvas.java`](source/src/main/java/main/GameCanvas.java) | 1630 | 44 | 91 | Loop 40 ms, input, screen/dialog/menu, background và tiện ích chung. `gI()`, `connect()`, `initGameCanvas()`, `startGameLoop()`, `run()`, `updateBallEffect()`. [API](docs/API_REFERENCE.md#maingamecanvas) / [field](docs/FIELD_REFERENCE.md#maingamecanvas) |
| [`main/GameMidlet.java`](source/src/main/java/main/GameMidlet.java) | 264 | 14 | 20 | MIDlet entry, Display, server list và cache danh sách server. `destroyApp()`, `pauseApp()`, `startApp()`, `exit()`, `openUrlAndExit()`, `readFileText()`. [API](docs/API_REFERENCE.md#maingamemidlet) / [field](docs/FIELD_REFERENCE.md#maingamemidlet) |
| [`main/MotherCanvas.java`](source/src/main/java/main/MotherCanvas.java) | 82 | 10 | 6 | Canvas MIDP thật; chuyển paint/key/pointer sang adapter. `setCanvasAdapter()`, `paint()`, `keyPressed()`, `keyReleased()`, `pointerDragged()`, `pointerPressed()`. [API](docs/API_REFERENCE.md#mainmothercanvas) / [field](docs/FIELD_REFERENCE.md#mainmothercanvas) |

### Mạng, message và SMS — 12 file

| File | Dòng | Khai báo | Field | Vai trò / hàm tiêu biểu |
|---|---:|---:|---:|---|
| [`nso/ConnectionTimeout.java`](source/src/main/java/nso/ConnectionTimeout.java) | 24 | 2 | 0 | Runnable timeout liên quan quá trình kết nối. `run()`. [API](docs/API_REFERENCE.md#nsoconnectiontimeout) / [field](docs/FIELD_REFERENCE.md#nsoconnectiontimeout) |
| [`nso/Controller.java`](source/src/main/java/nso/Controller.java) | 5007 | 27 | 2 | Dispatch message và parse dữ liệu server vào model/UI. `gI()`, `onConnectionError()`, `requestItemPlayer()`, `viewItemAuction()`, `onMessage()`, `createItem()`. [API](docs/API_REFERENCE.md#nsocontroller) / [field](docs/FIELD_REFERENCE.md#nsocontroller) |
| [`nso/Message.java`](source/src/main/java/nso/Message.java) | 60 | 7 | 5 | Command và buffer payload; cung cấp reader/writer/cleanup. `getData()`, `reader()`, `writer()`, `cleanup()`. [API](docs/API_REFERENCE.md#nsomessage) / [field](docs/FIELD_REFERENCE.md#nsomessage) |
| [`nso/PacketBuffer.java`](source/src/main/java/nso/PacketBuffer.java) | 11 | 1 | 1 | Buffer byte và thao tác đọc dữ liệu theo source. [API](docs/API_REFERENCE.md#nsopacketbuffer) / [field](docs/FIELD_REFERENCE.md#nsopacketbuffer) |
| [`nso/Readmsg.java`](source/src/main/java/nso/Readmsg.java) | 122 | 2 | 0 | Đọc nhánh thông tin vĩ thú và dữ liệu countdown. `onVithuInfo()`. [API](docs/API_REFERENCE.md#nsoreadmsg) / [field](docs/FIELD_REFERENCE.md#nsoreadmsg) |
| [`nso/SMS.java`](source/src/main/java/nso/SMS.java) | 16 | 3 | 0 | Điểm gọi gửi SMS và khởi động đường kết nối theo source. `sendSMS()`, `startConnectionThread()`. [API](docs/API_REFERENCE.md#nsosms) / [field](docs/FIELD_REFERENCE.md#nsosms) |
| [`nso/Service.java`](source/src/main/java/nso/Service.java) | 1990 | 151 | 4 | Dựng payload gửi cho các thao tác game. `gI()`, `messageNotLogin()`, `messageNotMap()`, `messageSubCommand()`, `setClientType()`, `login()`. [API](docs/API_REFERENCE.md#nsoservice) / [field](docs/FIELD_REFERENCE.md#nsoservice) |
| [`nso/SessionConnector.java`](source/src/main/java/nso/SessionConnector.java) | 50 | 2 | 2 | Runnable mở kết nối, khởi động stream/thread và gửi handshake. `run()`. [API](docs/API_REFERENCE.md#nsosessionconnector) / [field](docs/FIELD_REFERENCE.md#nsosessionconnector) |
| [`nso/SessionReceiver.java`](source/src/main/java/nso/SessionReceiver.java) | 95 | 3 | 1 | Runnable đọc command/length/payload, key và dispatch message. `run()`, `getKey()`. [API](docs/API_REFERENCE.md#nsosessionreceiver) / [field](docs/FIELD_REFERENCE.md#nsosessionreceiver) |
| [`nso/SessionSender.java`](source/src/main/java/nso/SessionSender.java) | 34 | 2 | 1 | Runnable lấy message đã xếp hàng và gửi sau handshake. `run()`. [API](docs/API_REFERENCE.md#nsosessionsender) / [field](docs/FIELD_REFERENCE.md#nsosessionsender) |
| [`nso/Session_ME.java`](source/src/main/java/nso/Session_ME.java) | 192 | 17 | 21 | Singleton socket session, stream, queue và key XOR. `gI()`, `isConnected()`, `setHandler()`, `connect()`, `sendMessage()`, `doSendMessage()`. [API](docs/API_REFERENCE.md#nsosession_me) / [field](docs/FIELD_REFERENCE.md#nsosession_me) |
| [`nso/SmsSender.java`](source/src/main/java/nso/SmsSender.java) | 40 | 2 | 5 | Runnable gửi tin nhắn qua WMA, gọi command kết quả. `run()`. [API](docs/API_REFERENCE.md#nsosmssender) / [field](docs/FIELD_REFERENCE.md#nsosmssender) |

### Màn hình — 10 file

| File | Dòng | Khai báo | Field | Vai trò / hàm tiêu biểu |
|---|---:|---:|---:|---|
| [`nso/CreateCharScr.java`](source/src/main/java/nso/CreateCharScr.java) | 235 | 8 | 11 | Màn tạo nhân vật. `gI()`, `switchToMe()`, `keyPress()`, `update()`, `updateKey()`, `paint()`. [API](docs/API_REFERENCE.md#nsocreatecharscr) / [field](docs/FIELD_REFERENCE.md#nsocreatecharscr) |
| [`nso/GameScr.java`](source/src/main/java/nso/GameScr.java) | 17216 | 365 | 455 | Màn chơi: camera, đối tượng, combat, UI và render. `getMaxExp()`, `resetAllvector()`, `loadSkillShortcut()`, `loadSkillShortcutNhanban()`, `onOSkill()`, `onKSkill()`. [API](docs/API_REFERENCE.md#nsogamescr) / [field](docs/FIELD_REFERENCE.md#nsogamescr) |
| [`nso/LanguageScr.java`](source/src/main/java/nso/LanguageScr.java) | 131 | 8 | 5 | Screen ngôn ngữ. `switchToMe()`, `paint()`, `saveLanguageID()`, `loadLanguageID()`, `update()`, `updateKey()`. [API](docs/API_REFERENCE.md#nsolanguagescr) / [field](docs/FIELD_REFERENCE.md#nsolanguagescr) |
| [`nso/LoginScr.java`](source/src/main/java/nso/LoginScr.java) | 591 | 12 | 25 | Form đăng nhập, nhập liệu và các command liên quan. `switchToMe()`, `mgI()`, `doSetGPRS()`, `doRegister()`, `update()`, `keyPress()`. [API](docs/API_REFERENCE.md#nsologinscr) / [field](docs/FIELD_REFERENCE.md#nsologinscr) |
| [`nso/MapScr.java`](source/src/main/java/nso/MapScr.java) | 466 | 9 | 34 | Giao diện map. `resetCMLim()`, `gI()`, `switchToMe()`, `unLoad()`, `paint()`, `updateKey()`. [API](docs/API_REFERENCE.md#nsomapscr) / [field](docs/FIELD_REFERENCE.md#nsomapscr) |
| [`nso/RegisterScr.java`](source/src/main/java/nso/RegisterScr.java) | 156 | 7 | 12 | Form đăng ký tài khoản. `update()`, `keyPress()`, `updateKey()`, `paint()`, `switchToMe()`, `perform()`. [API](docs/API_REFERENCE.md#nsoregisterscr) / [field](docs/FIELD_REFERENCE.md#nsoregisterscr) |
| [`nso/SelectCharScr.java`](source/src/main/java/nso/SelectCharScr.java) | 229 | 8 | 20 | Màn chọn nhân vật. `gI()`, `doSelect()`, `updateKey()`, `update()`, `switchToMe()`, `paint()`. [API](docs/API_REFERENCE.md#nsoselectcharscr) / [field](docs/FIELD_REFERENCE.md#nsoselectcharscr) |
| [`nso/SelectServerScr.java`](source/src/main/java/nso/SelectServerScr.java) | 349 | 11 | 17 | Chọn server, đọc thông tin server và xử lý action. `loadIP()`, `loadInfoIp()`, `switchToMe()`, `paint()`, `update()`, `updateKey()`. [API](docs/API_REFERENCE.md#nsoselectserverscr) / [field](docs/FIELD_REFERENCE.md#nsoselectserverscr) |
| [`nso/SplashScr.java`](source/src/main/java/nso/SplashScr.java) | 24 | 2 | 1 | Screen khởi động và chuyển trạng thái ban đầu. `update()`. [API](docs/API_REFERENCE.md#nsosplashscr) / [field](docs/FIELD_REFERENCE.md#nsosplashscr) |
| [`nso/mScreen.java`](source/src/main/java/nso/mScreen.java) | 152 | 9 | 7 | Base màn hình: chuyển screen, update, input và paint. `switchToMe()`, `unLoad()`, `initPos()`, `keyPress()`, `update()`, `updateKey()`. [API](docs/API_REFERENCE.md#nsomscreen) / [field](docs/FIELD_REFERENCE.md#nsomscreen) |

### Nhân vật, quái và đối tượng map — 14 file

| File | Dòng | Khai báo | Field | Vai trò / hàm tiêu biểu |
|---|---:|---:|---:|---|
| [`nso/Arrow.java`](source/src/main/java/nso/Arrow.java) | 133 | 4 | 14 | Đối tượng mũi tên, update và paint. `update()`, `endMe()`, `paint()`. [API](docs/API_REFERENCE.md#nsoarrow) / [field](docs/FIELD_REFERENCE.md#nsoarrow) |
| [`nso/BuNhin.java`](source/src/main/java/nso/BuNhin.java) | 18 | 1 | 4 | Đối tượng bù nhìn và dữ liệu của nó. [API](docs/API_REFERENCE.md#nsobunhin) / [field](docs/FIELD_REFERENCE.md#nsobunhin) |
| [`nso/Char.java`](source/src/main/java/nso/Char.java) | 8860 | 130 | 277 | State, chỉ số, di chuyển, skill/effect và render nhân vật. `getdxSkill()`, `getdySkill()`, `getSys()`, `getSpeed()`, `isUseLongRangeWeapon()`, `getMyChar()`. [API](docs/API_REFERENCE.md#nsochar) / [field](docs/FIELD_REFERENCE.md#nsochar) |
| [`nso/EggMonters.java`](source/src/main/java/nso/EggMonters.java) | 39 | 2 | 6 | Dữ liệu có các field `x`, `y`, `frame`, `status`. `isPaint()`. [API](docs/API_REFERENCE.md#nsoeggmonters) / [field](docs/FIELD_REFERENCE.md#nsoeggmonters) |
| [`nso/ItemMap.java`](source/src/main/java/nso/ItemMap.java) | 51 | 3 | 10 | Vật phẩm nằm trên map. `setPoint()`. [API](docs/API_REFERENCE.md#nsoitemmap) / [field](docs/FIELD_REFERENCE.md#nsoitemmap) |
| [`nso/ItemTree.java`](source/src/main/java/nso/ItemTree.java) | 31 | 3 | 3 | Đối tượng ItemTree có dữ liệu/vẽ riêng. `getImageFromHash()`, `paint()`. [API](docs/API_REFERENCE.md#nsoitemtree) / [field](docs/FIELD_REFERENCE.md#nsoitemtree) |
| [`nso/Lanterns.java`](source/src/main/java/nso/Lanterns.java) | 20 | 1 | 5 | Dữ liệu có các field `x`, `y`, `dy`, `yStart`. [API](docs/API_REFERENCE.md#nsolanterns) / [field](docs/FIELD_REFERENCE.md#nsolanterns) |
| [`nso/Mob.java`](source/src/main/java/nso/Mob.java) | 2025 | 28 | 58 | Dữ liệu, trạng thái, cập nhật và render quái. `updateMobAttack()`, `setInjure()`, `setAttack()`, `updateInjure()`, `updateTypeMobAttk()`, `getDistance()`. [API](docs/API_REFERENCE.md#nsomob) / [field](docs/FIELD_REFERENCE.md#nsomob) |
| [`nso/MobAttack.java`](source/src/main/java/nso/MobAttack.java) | 70 | 1 | 10 | Dữ liệu/cập nhật đòn tấn công của mob. `update()`. [API](docs/API_REFERENCE.md#nsomobattack) / [field](docs/FIELD_REFERENCE.md#nsomobattack) |
| [`nso/MobSoul.java`](source/src/main/java/nso/MobSoul.java) | 125 | 4 | 11 | Đối tượng MobSoul có update/paint. `update()`, `paint()`. [API](docs/API_REFERENCE.md#nsomobsoul) / [field](docs/FIELD_REFERENCE.md#nsomobsoul) |
| [`nso/MonsterDart.java`](source/src/main/java/nso/MonsterDart.java) | 328 | 7 | 24 | Đạn/phi tiêu từ mob và logic frame liên quan. `setAngle()`, `addMonsterDart()`, `update()`, `paint()`. [API](docs/API_REFERENCE.md#nsomonsterdart) / [field](docs/FIELD_REFERENCE.md#nsomonsterdart) |
| [`nso/MovePoint.java`](source/src/main/java/nso/MovePoint.java) | 21 | 2 | 3 | Điểm di chuyển. [API](docs/API_REFERENCE.md#nsomovepoint) / [field](docs/FIELD_REFERENCE.md#nsomovepoint) |
| [`nso/Npc.java`](source/src/main/java/nso/Npc.java) | 113 | 4 | 2 | Thực thể NPC kế thừa Char, update/paint và tương tác. `clearEffTask()`, `update()`, `paint()`. [API](docs/API_REFERENCE.md#nsonpc) / [field](docs/FIELD_REFERENCE.md#nsonpc) |
| [`nso/Waypoint.java`](source/src/main/java/nso/Waypoint.java) | 19 | 1 | 4 | Dữ liệu cổng/vùng chuyển map. [API](docs/API_REFERENCE.md#nsowaypoint) / [field](docs/FIELD_REFERENCE.md#nsowaypoint) |

### Hiệu ứng và animation — 16 file

| File | Dòng | Khai báo | Field | Vai trò / hàm tiêu biểu |
|---|---:|---:|---:|---|
| [`nso/AnimateEffect.java`](source/src/main/java/nso/AnimateEffect.java) | 142 | 4 | 7 | Đối tượng animation effect với update/paint. `paint()`, `update()`, `rndPos()`. [API](docs/API_REFERENCE.md#nsoanimateeffect) / [field](docs/FIELD_REFERENCE.md#nsoanimateeffect) |
| [`nso/AnimationAction.java`](source/src/main/java/nso/AnimationAction.java) | 7 | 1 | 0 | Base action của animation. [API](docs/API_REFERENCE.md#nsoanimationaction) / [field](docs/FIELD_REFERENCE.md#nsoanimationaction) |
| [`nso/DataSkillEff.java`](source/src/main/java/nso/DataSkillEff.java) | 571 | 14 | 35 | Dữ liệu frame, vị trí và cập nhật effect kỹ năng. `loadnew()`, `loadData()`, `setTypeEff()`, `vector2arr()`, `isHavedata()`, `paintBottomEff_new()`. [API](docs/API_REFERENCE.md#nsodataskilleff) / [field](docs/FIELD_REFERENCE.md#nsodataskilleff) |
| [`nso/Domsang.java`](source/src/main/java/nso/Domsang.java) | 59 | 3 | 5 | Hiệu ứng vị trí có update/paint. `update()`, `paint()`. [API](docs/API_REFERENCE.md#nsodomsang) / [field](docs/FIELD_REFERENCE.md#nsodomsang) |
| [`nso/EffAtutoTemp.java`](source/src/main/java/nso/EffAtutoTemp.java) | 17 | 1 | 5 | Dữ liệu có các field `imginfo`, `frameEffAuto`, `frameRunning`, `timerequest`. [API](docs/API_REFERENCE.md#nsoeffatutotemp) / [field](docs/FIELD_REFERENCE.md#nsoeffatutotemp) |
| [`nso/Effect.java`](source/src/main/java/nso/Effect.java) | 21 | 1 | 5 | Dữ liệu và thao tác effect. [API](docs/API_REFERENCE.md#nsoeffect) / [field](docs/FIELD_REFERENCE.md#nsoeffect) |
| [`nso/Effect2.java`](source/src/main/java/nso/Effect2.java) | 19 | 3 | 4 | Base effect với hợp đồng update/paint. `update()`, `paint()`. [API](docs/API_REFERENCE.md#nsoeffect2) / [field](docs/FIELD_REFERENCE.md#nsoeffect2) |
| [`nso/EffectAuto.java`](source/src/main/java/nso/EffectAuto.java) | 220 | 10 | 12 | Effect theo dữ liệu/frame và vòng đời tự cập nhật. `addEffectAuto()`, `getTemplate()`, `paint()`, `update()`, `reciveData()`, `creatDataEffauto()`. [API](docs/API_REFERENCE.md#nsoeffectauto) / [field](docs/FIELD_REFERENCE.md#nsoeffectauto) |
| [`nso/EffectCharPaint.java`](source/src/main/java/nso/EffectCharPaint.java) | 11 | 1 | 2 | Dữ liệu effect gắn với nhân vật. [API](docs/API_REFERENCE.md#nsoeffectcharpaint) / [field](docs/FIELD_REFERENCE.md#nsoeffectcharpaint) |
| [`nso/EffectInfoPaint.java`](source/src/main/java/nso/EffectInfoPaint.java) | 13 | 1 | 3 | Thông tin vẽ effect. [API](docs/API_REFERENCE.md#nsoeffectinfopaint) / [field](docs/FIELD_REFERENCE.md#nsoeffectinfopaint) |
| [`nso/EffectPaint.java`](source/src/main/java/nso/EffectPaint.java) | 21 | 2 | 5 | Dữ liệu frame/ảnh để vẽ effect. `getImgId()`. [API](docs/API_REFERENCE.md#nsoeffectpaint) / [field](docs/FIELD_REFERENCE.md#nsoeffectpaint) |
| [`nso/EffectTemplate.java`](source/src/main/java/nso/EffectTemplate.java) | 13 | 1 | 3 | Template effect. [API](docs/API_REFERENCE.md#nsoeffecttemplate) / [field](docs/FIELD_REFERENCE.md#nsoeffecttemplate) |
| [`nso/EmptyAnimationAction.java`](source/src/main/java/nso/EmptyAnimationAction.java) | 7 | 1 | 0 | Biến thể action có constructor rỗng đang được giữ theo baseline. [API](docs/API_REFERENCE.md#nsoemptyanimationaction) / [field](docs/FIELD_REFERENCE.md#nsoemptyanimationaction) |
| [`nso/FrameEff.java`](source/src/main/java/nso/FrameEff.java) | 13 | 1 | 2 | Dữ liệu frame effect. [API](docs/API_REFERENCE.md#nsoframeeff) / [field](docs/FIELD_REFERENCE.md#nsoframeeff) |
| [`nso/Lightning.java`](source/src/main/java/nso/Lightning.java) | 240 | 5 | 11 | Hiệu ứng Lightning và các điểm/frame để vẽ. `addLight()`, `setInfo()`, `update()`, `paint()`. [API](docs/API_REFERENCE.md#nsolightning) / [field](docs/FIELD_REFERENCE.md#nsolightning) |
| [`nso/ServerEffect.java`](source/src/main/java/nso/ServerEffect.java) | 103 | 7 | 8 | Effect có điểm gọi/tham số liên quan dữ liệu server. `addServerEffect()`, `addServerEffectWithTime()`, `paint()`, `update()`. [API](docs/API_REFERENCE.md#nsoservereffect) / [field](docs/FIELD_REFERENCE.md#nsoservereffect) |

### Đồ họa, font và tài nguyên — 15 file

| File | Dòng | Khai báo | Field | Vai trò / hàm tiêu biểu |
|---|---:|---:|---:|---|
| [`nso/CharPartInfo.java`](source/src/main/java/nso/CharPartInfo.java) | 176 | 2 | 12 | Thông tin part của nhân vật. `doSetInfo()`. [API](docs/API_REFERENCE.md#nsocharpartinfo) / [field](docs/FIELD_REFERENCE.md#nsocharpartinfo) |
| [`nso/Frame.java`](source/src/main/java/nso/Frame.java) | 17 | 1 | 5 | Dữ liệu frame. [API](docs/API_REFERENCE.md#nsoframe) / [field](docs/FIELD_REFERENCE.md#nsoframe) |
| [`nso/FrameImage.java`](source/src/main/java/nso/FrameImage.java) | 36 | 2 | 6 | Vẽ sprite nhiều frame. `drawFrame()`. [API](docs/API_REFERENCE.md#nsoframeimage) / [field](docs/FIELD_REFERENCE.md#nsoframeimage) |
| [`nso/GameData.java`](source/src/main/java/nso/GameData.java) | 62 | 3 | 3 | Cache icon/byte data; thử RMS/resource và yêu cầu server. `getImgIcon()`, `setImgIcon()`. [API](docs/API_REFERENCE.md#nsogamedata) / [field](docs/FIELD_REFERENCE.md#nsogamedata) |
| [`nso/ImageIcon.java`](source/src/main/java/nso/ImageIcon.java) | 13 | 1 | 2 | Dữ liệu ảnh/icon và trạng thái thời gian liên quan. [API](docs/API_REFERENCE.md#nsoimageicon) / [field](docs/FIELD_REFERENCE.md#nsoimageicon) |
| [`nso/ImageInfo.java`](source/src/main/java/nso/ImageInfo.java) | 15 | 1 | 4 | Thông tin/metadata ảnh. [API](docs/API_REFERENCE.md#nsoimageinfo) / [field](docs/FIELD_REFERENCE.md#nsoimageinfo) |
| [`nso/MyImage.java`](source/src/main/java/nso/MyImage.java) | 15 | 1 | 3 | Dữ liệu có các field `img`, `timerequest`, `timeUse`. [API](docs/API_REFERENCE.md#nsomyimage) / [field](docs/FIELD_REFERENCE.md#nsomyimage) |
| [`nso/Paint.java`](source/src/main/java/nso/Paint.java) | 198 | 10 | 7 | Các hàm vẽ khung và thành phần UI. `paintCmdBar()`, `paintCommandBarBackground()`, `paintInputTf()`, `paintInputTf_new()`, `paintInputDlg()`, `paintFrame()`. [API](docs/API_REFERENCE.md#nsopaint) / [field](docs/FIELD_REFERENCE.md#nsopaint) |
| [`nso/Part.java`](source/src/main/java/nso/Part.java) | 21 | 1 | 1 | Dữ liệu part dùng để ghép hình nhân vật. [API](docs/API_REFERENCE.md#nsopart) / [field](docs/FIELD_REFERENCE.md#nsopart) |
| [`nso/PartFrame.java`](source/src/main/java/nso/PartFrame.java) | 20 | 1 | 5 | Dữ liệu frame của part. [API](docs/API_REFERENCE.md#nsopartframe) / [field](docs/FIELD_REFERENCE.md#nsopartframe) |
| [`nso/PartImage.java`](source/src/main/java/nso/PartImage.java) | 13 | 1 | 3 | Dữ liệu một ảnh part. [API](docs/API_REFERENCE.md#nsopartimage) / [field](docs/FIELD_REFERENCE.md#nsopartimage) |
| [`nso/SmallImage.java`](source/src/main/java/nso/SmallImage.java) | 185 | 12 | 7 | Ảnh nhỏ/atlas, cache theo ID và vẽ region. `checkTimeUseImg()`, `freeBig()`, `loadBigImage()`, `init()`, `readImage()`, `reciveImage()`. [API](docs/API_REFERENCE.md#nsosmallimage) / [field](docs/FIELD_REFERENCE.md#nsosmallimage) |
| [`nso/TileMap.java`](source/src/main/java/nso/TileMap.java) | 711 | 20 | 51 | Map, tile, vật cản và tài nguyên nền. `setPosMiniMap()`, `updateMiniMap()`, `updateCmMiniMap()`, `freeTileImage()`, `loadTileImage()`, `loadMap()`. [API](docs/API_REFERENCE.md#nsotilemap) / [field](docs/FIELD_REFERENCE.md#nsotilemap) |
| [`nso/mFont.java`](source/src/main/java/nso/mFont.java) | 199 | 9 | 27 | Font bitmap, đo chữ, vẽ chữ và chia dòng. `reloadImage()`, `freeImage()`, `getHeight()`, `getWidth()`, `drawString()`, `splitFontVector()`. [API](docs/API_REFERENCE.md#nsomfont) / [field](docs/FIELD_REFERENCE.md#nsomfont) |
| [`nso/mGraphics.java`](source/src/main/java/nso/mGraphics.java) | 112 | 16 | 2 | Wrapper Graphics: draw, clip, translate, màu và zoom. `drawImage()`, `drawLine()`, `drawRect()`, `drawRegion()`, `drawRoundRect()`, `fillRect()`. [API](docs/API_REFERENCE.md#nsomgraphics) / [field](docs/FIELD_REFERENCE.md#nsomgraphics) |

### UI, chat và nhập liệu — 21 file

| File | Dòng | Khai báo | Field | Vai trò / hàm tiêu biểu |
|---|---:|---:|---:|---|
| [`nso/ChatManager.java`](source/src/main/java/nso/ChatManager.java) | 129 | 15 | 8 | Quản lý dữ liệu/tab chat. `switchToNextTab()`, `switchToPreviousTab()`, `switchToTab()`, `switchToLastTab()`, `gI()`, `findTab()`. [API](docs/API_REFERENCE.md#nsochatmanager) / [field](docs/FIELD_REFERENCE.md#nsochatmanager) |
| [`nso/ChatPopup.java`](source/src/main/java/nso/ChatPopup.java) | 112 | 6 | 13 | Bong bóng/nội dung chat có vòng đời và paint. `addChatPopupMultiLine()`, `addChatPopup()`, `update()`, `paint()`, `perform()`. [API](docs/API_REFERENCE.md#nsochatpopup) / [field](docs/FIELD_REFERENCE.md#nsochatpopup) |
| [`nso/ChatTab.java`](source/src/main/java/nso/ChatTab.java) | 55 | 5 | 3 | Dữ liệu một tab chat. `addChat()`, `clear()`, `addInfo()`. [API](docs/API_REFERENCE.md#nsochattab) / [field](docs/FIELD_REFERENCE.md#nsochattab) |
| [`nso/ChatTextField.java`](source/src/main/java/nso/ChatTextField.java) | 92 | 6 | 9 | Ô nhập và gửi chat. `gI()`, `startChat()`, `showChat()`, `paint()`, `perform()`. [API](docs/API_REFERENCE.md#nsochattextfield) / [field](docs/FIELD_REFERENCE.md#nsochattextfield) |
| [`nso/Command.java`](source/src/main/java/nso/Command.java) | 118 | 9 | 13 | Nhãn/action, đối tượng xử lý và vẽ nút/lệnh. `performAction()`, `paint()`, `input()`, `updatePointer()`. [API](docs/API_REFERENCE.md#nsocommand) / [field](docs/FIELD_REFERENCE.md#nsocommand) |
| [`nso/Dialog.java`](source/src/main/java/nso/Dialog.java) | 87 | 4 | 3 | Base dialog và các hook input/update/paint. `paint()`, `keyPress()`, `update()`. [API](docs/API_REFERENCE.md#nsodialog) / [field](docs/FIELD_REFERENCE.md#nsodialog) |
| [`nso/IActionListener.java`](source/src/main/java/nso/IActionListener.java) | 6 | 1 | 0 | Interface nhận action từ command. `perform()`. [API](docs/API_REFERENCE.md#nsoiactionlistener) / [field](docs/FIELD_REFERENCE.md#nsoiactionlistener) |
| [`nso/Info.java`](source/src/main/java/nso/Info.java) | 152 | 4 | 8 | Thông tin hiển thị dùng chung. `paint()`, `update()`, `addInfo()`. [API](docs/API_REFERENCE.md#nsoinfo) / [field](docs/FIELD_REFERENCE.md#nsoinfo) |
| [`nso/InfoDlg.java`](source/src/main/java/nso/InfoDlg.java) | 69 | 6 | 5 | Overlay thông tin/chờ với thời hạn. `show()`, `showWait()`, `paint()`, `hide()`. [API](docs/API_REFERENCE.md#nsoinfodlg) / [field](docs/FIELD_REFERENCE.md#nsoinfodlg) |
| [`nso/InfoItem.java`](source/src/main/java/nso/InfoItem.java) | 22 | 2 | 3 | Dữ liệu một mục thông tin. [API](docs/API_REFERENCE.md#nsoinfoitem) / [field](docs/FIELD_REFERENCE.md#nsoinfoitem) |
| [`nso/InfoMe.java`](source/src/main/java/nso/InfoMe.java) | 174 | 7 | 8 | Thông tin/hiển thị liên quan người chơi. `paint()`, `update()`, `addInfo()`, `canMergeString()`, `isEmpty()`. [API](docs/API_REFERENCE.md#nsoinfome) / [field](docs/FIELD_REFERENCE.md#nsoinfome) |
| [`nso/Input2Dlg.java`](source/src/main/java/nso/Input2Dlg.java) | 123 | 7 | 7 | Dialog nhập hai trường text. `setTitle()`, `show()`, `paint()`, `keyPress()`, `update()`, `perform()`. [API](docs/API_REFERENCE.md#nsoinput2dlg) / [field](docs/FIELD_REFERENCE.md#nsoinput2dlg) |
| [`nso/InputDlg.java`](source/src/main/java/nso/InputDlg.java) | 66 | 5 | 3 | Dialog nhập một trường text. `show()`, `paint()`, `keyPress()`, `update()`. [API](docs/API_REFERENCE.md#nsoinputdlg) / [field](docs/FIELD_REFERENCE.md#nsoinputdlg) |
| [`nso/Menu.java`](source/src/main/java/nso/Menu.java) | 407 | 6 | 30 | Danh sách command, lựa chọn, cuộn và vẽ menu. `startAt()`, `updateMenuKey()`, `paintMenu()`, `moveCamera()`, `perform()`. [API](docs/API_REFERENCE.md#nsomenu) / [field](docs/FIELD_REFERENCE.md#nsomenu) |
| [`nso/MsgDlg.java`](source/src/main/java/nso/MsgDlg.java) | 87 | 5 | 5 | Dialog thông báo/chờ. `pleasewait()`, `setInfo()`, `paint()`, `update()`. [API](docs/API_REFERENCE.md#nsomsgdlg) / [field](docs/FIELD_REFERENCE.md#nsomsgdlg) |
| [`nso/NativeTextBoxListener.java`](source/src/main/java/nso/NativeTextBoxListener.java) | 26 | 2 | 2 | Nối callback text box MIDP với text field game. `commandAction()`. [API](docs/API_REFERENCE.md#nsonativetextboxlistener) / [field](docs/FIELD_REFERENCE.md#nsonativetextboxlistener) |
| [`nso/Scroll.java`](source/src/main/java/nso/Scroll.java) | 350 | 8 | 25 | State và tính toán cuộn/hit input. `clear()`, `setClip()`, `updateKey()`, `updatecm()`, `setStyle()`, `moveTo()`. [API](docs/API_REFERENCE.md#nsoscroll) / [field](docs/FIELD_REFERENCE.md#nsoscroll) |
| [`nso/ScrollResult.java`](source/src/main/java/nso/ScrollResult.java) | 13 | 1 | 3 | Kết quả thao tác scroll. [API](docs/API_REFERENCE.md#nsoscrollresult) / [field](docs/FIELD_REFERENCE.md#nsoscrollresult) |
| [`nso/TField.java`](source/src/main/java/nso/TField.java) | 407 | 16 | 33 | Text field: nội dung, con trỏ, input và paint. `showNativeTextBox()`, `setNormal()`, `clear()`, `setOffset()`, `keyPressedAscii()`, `keyPressed()`. [API](docs/API_REFERENCE.md#nsotfield) / [field](docs/FIELD_REFERENCE.md#nsotfield) |
| [`nso/TimecountDown.java`](source/src/main/java/nso/TimecountDown.java) | 92 | 4 | 6 | Dữ liệu countdown, update và paint. `paint()`, `update()`, `converSecon2hours()`. [API](docs/API_REFERENCE.md#nsotimecountdown) / [field](docs/FIELD_REFERENCE.md#nsotimecountdown) |
| [`nso/Timer.java`](source/src/main/java/nso/Timer.java) | 13 | 1 | 3 | Action được thực hiện theo thời gian trong loop. [API](docs/API_REFERENCE.md#nsotimer) / [field](docs/FIELD_REFERENCE.md#nsotimer) |

### Tiện ích và lưu trữ — 8 file

| File | Dòng | Khai báo | Field | Vai trò / hàm tiêu biểu |
|---|---:|---:|---:|---|
| [`nso/MyVector.java`](source/src/main/java/nso/MyVector.java) | 33 | 7 | 0 | Lớp chứa dữ liệu dựa trên Vector. `addElement()`, `elementAt()`, `removeAllElements()`, `removeElement()`, `insertElementAt()`, `removeElementAt()`. [API](docs/API_REFERENCE.md#nsomyvector) / [field](docs/FIELD_REFERENCE.md#nsomyvector) |
| [`nso/NinjaUtil.java`](source/src/main/java/nso/NinjaUtil.java) | 156 | 12 | 1 | Tiện ích được các class game gọi. `randomNumber()`, `random()`, `readByteArray_Int()`, `readByteArray()`, `replace()`, `numberToString()`. [API](docs/API_REFERENCE.md#nsoninjautil) / [field](docs/FIELD_REFERENCE.md#nsoninjautil) |
| [`nso/RMS.java`](source/src/main/java/nso/RMS.java) | 102 | 10 | 0 | Wrapper RecordStore cho byte/int/string/ảnh. `saveRMS()`, `loadRMS()`, `saveRMSInt()`, `saveRMSString()`, `loadRMSString()`, `loadRMSInt()`. [API](docs/API_REFERENCE.md#nsorms) / [field](docs/FIELD_REFERENCE.md#nsorms) |
| [`nso/Res.java`](source/src/main/java/nso/Res.java) | 211 | 15 | 4 | Toán, random, tách chuỗi, khoảng cách và countdown. `init()`, `sin()`, `cos()`, `angle()`, `fixangle()`, `xetVX()`. [API](docs/API_REFERENCE.md#nsores) / [field](docs/FIELD_REFERENCE.md#nsores) |
| [`nso/StaticObj.java`](source/src/main/java/nso/StaticObj.java) | 27 | 1 | 10 | Dữ liệu/hằng dùng chung. [API](docs/API_REFERENCE.md#nsostaticobj) / [field](docs/FIELD_REFERENCE.md#nsostaticobj) |
| [`nso/StringHashtable.java`](source/src/main/java/nso/StringHashtable.java) | 25 | 5 | 0 | Bảng tra với key String. `put()`, `clear()`, `remove()`, `get()`. [API](docs/API_REFERENCE.md#nsostringhashtable) / [field](docs/FIELD_REFERENCE.md#nsostringhashtable) |
| [`nso/mHashtable.java`](source/src/main/java/nso/mHashtable.java) | 23 | 4 | 1 | Lớp chứa dữ liệu dựa trên Hashtable. `get()`, `equals()`, `put()`. [API](docs/API_REFERENCE.md#nsomhashtable) / [field](docs/FIELD_REFERENCE.md#nsomhashtable) |
| [`nso/mResources.java`](source/src/main/java/nso/mResources.java) | 2072 | 3 | 508 | Chuỗi giao diện và dữ liệu ngôn ngữ. `loadLanguage()`, `replace()`. [API](docs/API_REFERENCE.md#nsomresources) / [field](docs/FIELD_REFERENCE.md#nsomresources) |

### Model và dữ liệu — 30 file

| File | Dòng | Khai báo | Field | Vai trò / hàm tiêu biểu |
|---|---:|---:|---:|---|
| [`nso/Arrowpaint.java`](source/src/main/java/nso/Arrowpaint.java) | 15 | 1 | 1 | Dữ liệu vẽ mũi tên. [API](docs/API_REFERENCE.md#nsoarrowpaint) / [field](docs/FIELD_REFERENCE.md#nsoarrowpaint) |
| [`nso/Clan.java`](source/src/main/java/nso/Clan.java) | 79 | 2 | 16 | Dữ liệu clan. `writeLog()`. [API](docs/API_REFERENCE.md#nsoclan) / [field](docs/FIELD_REFERENCE.md#nsoclan) |
| [`nso/Clan_ThanThu.java`](source/src/main/java/nso/Clan_ThanThu.java) | 37 | 1 | 10 | Dữ liệu thần thú clan. [API](docs/API_REFERENCE.md#nsoclan_thanthu) / [field](docs/FIELD_REFERENCE.md#nsoclan_thanthu) |
| [`nso/DunItem.java`](source/src/main/java/nso/DunItem.java) | 13 | 1 | 3 | Dữ liệu có các field `id`, `name1`, `name2`. [API](docs/API_REFERENCE.md#nsodunitem) / [field](docs/FIELD_REFERENCE.md#nsodunitem) |
| [`nso/EPosition.java`](source/src/main/java/nso/EPosition.java) | 28 | 3 | 5 | Dữ liệu vị trí dùng trong effect/game. [API](docs/API_REFERENCE.md#nsoeposition) / [field](docs/FIELD_REFERENCE.md#nsoeposition) |
| [`nso/Friend.java`](source/src/main/java/nso/Friend.java) | 13 | 1 | 2 | Dữ liệu bạn bè. [API](docs/API_REFERENCE.md#nsofriend) / [field](docs/FIELD_REFERENCE.md#nsofriend) |
| [`nso/Item.java`](source/src/main/java/nso/Item.java) | 231 | 23 | 21 | Vật phẩm instance, chỉ số/trang bị và thao tác liên quan. `clone()`, `viewNext()`, `isTypeBody()`, `isTypeMounts()`, `isTypeNgocKham()`, `getExpiresString()`. [API](docs/API_REFERENCE.md#nsoitem) / [field](docs/FIELD_REFERENCE.md#nsoitem) |
| [`nso/ItemOption.java`](source/src/main/java/nso/ItemOption.java) | 58 | 5 | 3 | Giá trị option của vật phẩm. `getOptionString()`, `getValuePercent()`, `getOptionShopString()`. [API](docs/API_REFERENCE.md#nsoitemoption) / [field](docs/FIELD_REFERENCE.md#nsoitemoption) |
| [`nso/ItemOptionTemplate.java`](source/src/main/java/nso/ItemOptionTemplate.java) | 13 | 1 | 3 | Template option vật phẩm. [API](docs/API_REFERENCE.md#nsoitemoptiontemplate) / [field](docs/FIELD_REFERENCE.md#nsoitemoptiontemplate) |
| [`nso/ItemStands.java`](source/src/main/java/nso/ItemStands.java) | 17 | 1 | 5 | Dữ liệu item trong giao diện/đối tượng ItemStands. [API](docs/API_REFERENCE.md#nsoitemstands) / [field](docs/FIELD_REFERENCE.md#nsoitemstands) |
| [`nso/ItemTemplate.java`](source/src/main/java/nso/ItemTemplate.java) | 34 | 1 | 9 | Dữ liệu template vật phẩm. [API](docs/API_REFERENCE.md#nsoitemtemplate) / [field](docs/FIELD_REFERENCE.md#nsoitemtemplate) |
| [`nso/ItemTemplates.java`](source/src/main/java/nso/ItemTemplates.java) | 21 | 4 | 1 | Bảng template vật phẩm và truy xuất theo ID. `add()`, `get()`, `getIcon()`. [API](docs/API_REFERENCE.md#nsoitemtemplates) / [field](docs/FIELD_REFERENCE.md#nsoitemtemplates) |
| [`nso/MainObject.java`](source/src/main/java/nso/MainObject.java) | 53 | 4 | 1 | Dữ liệu có các field `vecEFfect`. `paintTopDataEff()`, `paintBottomDataEff()`, `updateDataEff()`. [API](docs/API_REFERENCE.md#nsomainobject) / [field](docs/FIELD_REFERENCE.md#nsomainobject) |
| [`nso/Member.java`](source/src/main/java/nso/Member.java) | 48 | 1 | 7 | Dữ liệu thành viên. [API](docs/API_REFERENCE.md#nsomember) / [field](docs/FIELD_REFERENCE.md#nsomember) |
| [`nso/MobTemplate.java`](source/src/main/java/nso/MobTemplate.java) | 39 | 1 | 15 | Template mob. [API](docs/API_REFERENCE.md#nsomobtemplate) / [field](docs/FIELD_REFERENCE.md#nsomobtemplate) |
| [`nso/NClass.java`](source/src/main/java/nso/NClass.java) | 13 | 1 | 3 | Dữ liệu lớp nhân vật. [API](docs/API_REFERENCE.md#nsonclass) / [field](docs/FIELD_REFERENCE.md#nsonclass) |
| [`nso/NpcTemplate.java`](source/src/main/java/nso/NpcTemplate.java) | 19 | 1 | 6 | Template NPC. [API](docs/API_REFERENCE.md#nsonpctemplate) / [field](docs/FIELD_REFERENCE.md#nsonpctemplate) |
| [`nso/Party.java`](source/src/main/java/nso/Party.java) | 98 | 4 | 7 | Dữ liệu party. `refreshAll()`, `clear()`. [API](docs/API_REFERENCE.md#nsoparty) / [field](docs/FIELD_REFERENCE.md#nsoparty) |
| [`nso/Position.java`](source/src/main/java/nso/Position.java) | 26 | 2 | 6 | Dữ liệu tọa độ/vị trí. [API](docs/API_REFERENCE.md#nsoposition) / [field](docs/FIELD_REFERENCE.md#nsoposition) |
| [`nso/Ranked.java`](source/src/main/java/nso/Ranked.java) | 13 | 1 | 3 | Dữ liệu xếp hạng. [API](docs/API_REFERENCE.md#nsoranked) / [field](docs/FIELD_REFERENCE.md#nsoranked) |
| [`nso/Set.java`](source/src/main/java/nso/Set.java) | 14 | 0 | 5 | Dữ liệu thời gian và tọa độ mob/char. [API](docs/API_REFERENCE.md#nsoset) / [field](docs/FIELD_REFERENCE.md#nsoset) |
| [`nso/Skill.java`](source/src/main/java/nso/Skill.java) | 52 | 3 | 12 | Skill instance, hồi chiêu và dữ liệu hiển thị. `paint()`, `isCooldown()`. [API](docs/API_REFERENCE.md#nsoskill) / [field](docs/FIELD_REFERENCE.md#nsoskill) |
| [`nso/SkillInfoPaint.java`](source/src/main/java/nso/SkillInfoPaint.java) | 33 | 1 | 13 | Thông tin frame vẽ kỹ năng. [API](docs/API_REFERENCE.md#nsoskillinfopaint) / [field](docs/FIELD_REFERENCE.md#nsoskillinfopaint) |
| [`nso/SkillOption.java`](source/src/main/java/nso/SkillOption.java) | 25 | 2 | 3 | Giá trị option của skill. `getOptionString()`. [API](docs/API_REFERENCE.md#nsoskilloption) / [field](docs/FIELD_REFERENCE.md#nsoskilloption) |
| [`nso/SkillOptionTemplate.java`](source/src/main/java/nso/SkillOptionTemplate.java) | 11 | 1 | 2 | Template option của skill. [API](docs/API_REFERENCE.md#nsoskilloptiontemplate) / [field](docs/FIELD_REFERENCE.md#nsoskilloptiontemplate) |
| [`nso/SkillPaint.java`](source/src/main/java/nso/SkillPaint.java) | 13 | 1 | 3 | Dữ liệu vẽ kỹ năng. [API](docs/API_REFERENCE.md#nsoskillpaint) / [field](docs/FIELD_REFERENCE.md#nsoskillpaint) |
| [`nso/SkillTemplate.java`](source/src/main/java/nso/SkillTemplate.java) | 21 | 1 | 7 | Template kỹ năng. [API](docs/API_REFERENCE.md#nsoskilltemplate) / [field](docs/FIELD_REFERENCE.md#nsoskilltemplate) |
| [`nso/Skills.java`](source/src/main/java/nso/Skills.java) | 17 | 3 | 1 | Bảng skill và truy xuất theo ID. `add()`, `get()`. [API](docs/API_REFERENCE.md#nsoskills) / [field](docs/FIELD_REFERENCE.md#nsoskills) |
| [`nso/Task.java`](source/src/main/java/nso/Task.java) | 25 | 1 | 6 | Dữ liệu nhiệm vụ. [API](docs/API_REFERENCE.md#nsotask) / [field](docs/FIELD_REFERENCE.md#nsotask) |
| [`nso/TaskOrder.java`](source/src/main/java/nso/TaskOrder.java) | 28 | 1 | 7 | Dữ liệu bước/thứ tự nhiệm vụ. [API](docs/API_REFERENCE.md#nsotaskorder) / [field](docs/FIELD_REFERENCE.md#nsotaskorder) |
<!-- SOURCE_CATALOG_END -->

## Mapping, tên và biến cục bộ

### Định danh có thẩm quyền

Một method được nhận diện bằng **owner + name + descriptor đầy đủ**, không chỉ bằng tên source. Ví dụ overload có thể cùng tên và khác parameter; method ở hai class có thể trùng tên mà không liên quan. Mapping luôn giữ định danh gốc để đối chiếu với input.

| File | Dùng khi nào |
|---|---|
| `mapping/symbols.json` | Tìm định danh gốc, tên hiện tại, status và bằng chứng |
| `mapping/remap_config.json` | Theo tên class/member được áp dụng và resource rules |
| `mapping/classes.csv` | Lọc 130 class và tên tham chiếu |
| `mapping/methods.csv` | Lọc 1.349 method input theo descriptor/status |
| `mapping/fields.csv` | Lọc 2.322 field input |
| `mapping/locals.csv` | Đối chiếu 3.767 slot local bytecode |
| `mapping/source_index.json` | Tra khai báo source và vị trí dòng |
| `mapping/source_methods.csv` / `source_fields.csv` | Xuất bảng khai báo source |
| `mapping/source_locals.csv` | Tra tham số/local/catch trong source |
| `mapping/classes/*.md` | Đọc bảng mapping của một class trong trình duyệt |
| `mapping/call_graph.*` | Theo quan hệ gọi của input |
| `mapping/field_accesses.csv` | Theo vị trí truy cập field của input |
| `mapping/readable_name_changes.csv` | Theo lịch sử đổi các tên hash |

### Ý nghĩa status

- `preserved`: tên được giữ; không phải tên mới được đoán.
- `reference_proposal`: đề xuất từ đối chiếu vai trò/cấu trúc/hành vi với DLL tham chiếu.
- `behavioral_name`: tên mô tả điều nhìn thấy trong Java, không khẳng định đó là tên cũ.
- `unresolved`: phần chưa xác định đủ chắc; xuất hiện ở dữ liệu local-slot và các bảng liên quan.

Đợt đổi tên đã thay **461 field và 249 method** còn tên hash. Không còn mẫu member `field_*_<hash>` / `method_*_<hash>` trong source hiện tại. Việc không còn tên hash không đồng nghĩa đã phục hồi mọi tên gốc.

### Tại sao không thể hứa tên local gốc

Metadata input không có tên debug local gốc. Một slot bytecode có thể được dùng lại cho nhiều biến ở những đoạn khác nhau. Vì vậy 3.767 slot và 5.043 khai báo source là hai cách nhìn khác nhau; không có phép ghép một-một được bảo đảm chỉ từ chỉ số slot.

Các tên `index`, `value`, `text`, `data`, v.v. trong source có thể do decompiler hoặc bước đặt tên theo cách dùng tạo ra. Debug `-g` giúp xem những tên hiện tại đó; nó không phục hồi thông tin đã mất của JAR gốc.

Xem [hướng dẫn đọc mapping và kiểm chứng](docs/MAPPING_AND_VERIFICATION.md), [căn cứ đặt tên](mapping/NAMING_EVIDENCE.md) và [các giới hạn tên](mapping/UNRESOLVED_NAMES.md).

## Compiler, lock file và JAR

### Các bước builder thực hiện

1. Đọc dependency lock và kiểm tra SHA-256 của đủ 5 JAR trong `source/lib`.
2. Với build đầy đủ, đọc resource lock, kiểm tra đủ 239 file, size/hash, path an toàn và không có file lạ ngoài lock.
3. Đọc `classes.list`, yêu cầu 130 class; so tập tên với đủ 130 file `.java`.
4. Rà các marker decompiler hỏng và mẫu tên member hash mà builder đã cấu hình.
5. Tạo thư mục class tạm mới trong `.build/`; không lấy class từ output cũ làm đầu vào.
6. Gọi ECJ với source 1.3, UTF-8, CLDC/MIDP/WMA boot API và cờ debug tương ứng.
7. Kiểm tra tập class đúng `classes.list`, magic classfile và version 45.3.
8. Gộp 130 class + 239 resource + manifest; thứ tự entry và timestamp được cố định.
9. Mở lại JAR, đọc payload, so CRC và so byte; yêu cầu đúng 370 file entry.
10. Ghi JAR/JAD, report/log và copy class sang `bin/` cho Eclipse; dọn thư mục tạm khi thành công.

Nếu compile lỗi, log/thư mục làm việc được giữ để điều tra. Đừng dùng sự có mặt của một JAR cũ trong `dist` để kết luận lần build vừa lỗi đã thành công.

### Tham số compiler

```text
java -Dfile.encoding=UTF-8 -Xmx3g -jar lib/ecj-3.33.0.jar
  -1.3
  -encoding UTF-8
  -g:lines,source                   # release; debug dùng -g
  -proc:none
  -bootclasspath <cldcapi11;midpapi20;microemu-jsr-120>
  -classpath <cldcapi11;midpapi20;microemu-jsr-120>
  -d <thư-mục-class-tạm-mới>
  -maxProblems 3000
  -warn:none
  -log <compiler.xml>
  @<sources.args>
```

Đoạn trên mô tả argument list của builder, không phải lệnh để dán nguyên dấu `<...>` vào terminal. Đường dẫn có khoảng trắng được ghi vào response file đã quote.

### Dependency được khóa

<!-- DEPENDENCY_TABLE_START -->
| Artifact | SHA-256 |
|---|---|
| `ecj-3.33.0.jar` | `f7686c4960cf70c2ebc5c500a73a8cfc04541b730c18f1c5c21329889b137f45` |
| `cldcapi11-2.0.4.jar` | `f86f41bfb4097e4bd9cdfeca528960f6977cbda0f5785342adef9909a6a3baef` |
| `midpapi20-2.0.4.jar` | `b7f6ed5e0344c7000643ecc114e6edff3587e8e77face546af0e12ffd6dbe826` |
| `microemulator-2.0.4.jar` | `dbd5f3eb8365d3e839d6a203149e0e3776fc1a0585e16ac1fc23f76c9fcae1c6` |
| `microemu-jsr-120-2.0.4.jar` | `6d3f599901a297568c763e389c68aa921f4d5c03740e5c167b18159f0dac2c78` |
<!-- DEPENDENCY_TABLE_END -->

URL tải đầy đủ nằm trong [dependencies.lock.json](source/config/dependencies.lock.json). `prepare.ps1` không âm thầm thay một dependency đã tồn tại nhưng sai hash; nó dừng và chỉ rõ file. Các API/emulator nằm ngoài JAR game.

### Manifest và JAD

Manifest hiện tại giữ `MIDlet-Version: 1.0.0`, `MIDlet-Name: NinjaSchool Midlet Suite`, entry `main.GameMidlet`, CLDC-1.0 và MIDP-2.0. Chuỗi version nghiệp vụ `2.5.1` trong code là một giá trị khác; tài liệu không tự sửa manifest để làm hai thứ giống nhau.

Builder chuẩn hóa manifest sang CRLF khi đóng gói. JAD sinh từ cùng nội dung, bổ sung `MIDlet-Jar-URL` và `MIDlet-Jar-Size` theo JAR vừa tạo. `MicroEmulator`, ECJ, Gson/ASM của bộ audit và CLDC/MIDP API không được nhúng vào JAR game.

### Tính lặp lại

Timestamp ZIP cố định ở `1980-01-01`, entry được sắp thứ tự và dữ liệu đầu vào được khóa. Trong 10 vòng đã chạy trên môi trường JDK 17/ECJ đã ghi nhận, hash ổn định theo từng mode. Không suy rộng thành bảo đảm byte-for-byte cho mọi phiên bản JDK/ZIP implementation khác nhau.

## Kết quả kiểm chứng

| Kiểm tra | Kết quả đã ghi nhận | Không được suy ra |
|---|---|---|
| Source trước/sau chuyển bố cục | 130 file giữ nguyên nội dung; Git chuẩn hóa CRLF→LF | Phục hồi mọi tên gốc |
| Build sạch | 10 vòng × release/debug = 20 build thành công | Mọi hành vi gameplay đúng |
| Hash theo mode | Ổn định trong cả 10 vòng | Release/debug phải có cùng hash |
| JAR | Đủ 130 class + 239 resource + manifest, 370 entry | Toàn bộ dữ liệu online đều có trong JAR |
| Canonical bytecode | 130/130 class khớp baseline rebuilt trước đổi tên | Tương đương đầy đủ với JAR obfuscate gốc |
| Chi tiết canonical | 193.867 instruction, 1.479 exception handler | Debug attributes/stack-map frame cũng được so |
| Linkage từng JAR mới | 19.828 call site, 43.970 field site; `-Xverify:all` | Đã chạy initializer của mọi class |
| MicroEmulator | Splash, chọn server, phím DOWN/UP, form login, pause/resume/destroy | Đã đăng nhập thật vào server |
| Ảnh | 166 PNG giải mã thành công; framebuffer được kiểm tra bằng chương trình | Đã đánh giá hình ảnh bằng mắt |
| Debug runner | Listener và `JDWP-Handshake` thành công trên loopback | Mọi breakpoint/biến ở mọi nhánh đã thử |
| Checkout sạch | Tải 5 dependency theo hash, compile-only, import 239 resource, release/debug đúng hash | Build đã kiểm tra trên mọi hệ điều hành |
| Repo public | Đã clone không cần đăng nhập, so đúng commit/tree của lần xuất bản source | Tài nguyên game được commit sẵn |

### Hash của workflow hiện tại

Release:

```text
1d8a8672583143927ddd229453ed5df169a1922fbebf914590223d0431b3f4e0
```

Debug:

```text
3190c93cc994a02e6fbd5b4a698940d614765c821265d34428632991d2ebd35a
```

Các hash này áp dụng cho source/config đã kiểm chứng. Sửa code, asset hoặc manifest có thể làm hash thay đổi; đó không tự động là lỗi. Cần đối chiếu đúng phạm vi thay đổi.

### Các phần chưa được chứng minh

Audit heuristic giữa JAR gốc và bản rebuilt chỉ có 122/130 class khớp tập thao tác; còn 565 khác biệt theo method và 64 residual cấp class. Phép kiểm tra heuristic bỏ qua các chi tiết luồng điều khiển quan trọng, nên không dùng nó để tuyên bố “giống gốc 100%”.

Tám class còn gắn cờ trong audit gốc: `SessionConnector`, `ItemTree`, `SkillOption`, `Npc`, `mFont`, `GameScr`, `SessionReceiver`, `DataSkillEff`. Trong khi đó canonical comparison khớp toàn bộ **baseline rebuilt trước đổi tên**; hai kết quả có đối tượng so sánh khác nhau.

Đã gặp log `Creating thread with no MIDlet context` ở `SessionConnector.run` khi chạy MicroEmulator; giao diện vẫn tiếp tục chạy. Chưa kiểm thử đăng nhập thật, luồng server/network đầy đủ, chiến đấu, toàn bộ parser hoặc gameplay online dài hạn.

Bằng chứng: [báo cáo có phạm vi kiểm tra](reports/VERIFICATION.md) và [JSON kiểm chứng chọn lọc](reports/verification-summary.json). Các fixture binary, log thô, profile và đầu vào được giữ cục bộ.

## Lỗi thường gặp

| Triệu chứng/thông báo | Cần kiểm tra |
|---|---|
| `JDK 17+ not found` | `-JavaHome`, `JAVA_HOME`, `java` trong PATH; trỏ tới thư mục JDK |
| PowerShell chặn chạy script | Dùng đúng mẫu `powershell -NoProfile -ExecutionPolicy Bypass -File ...` |
| JAR đầu vào sai SHA-256 | Dùng đúng bản đầu vào của resource lock; đừng sửa lock chỉ để bỏ qua lỗi |
| `Missing resource` | Chạy build với `-OriginalJar` lần đầu |
| `Existing edited resource was NOT overwritten` | Có asset cục bộ bị sửa; sao lưu và đối chiếu trước khi phục hồi |
| Dependency sai hash | Không dùng JAR khác phiên bản; kiểm tra URL/hash trong dependency lock |
| `Expected exactly 239 locked resources` | Lock không đúng cấu trúc/số resource mong đợi |
| `Unexpected resource files outside the lock` | Có file thêm vào `src/main/resources`, kể cả file do công cụ khác sinh |
| Class/source coverage khác `classes.list` | Thiếu/đổi tên/thêm class mà chưa cập nhật cơ chế kiểm tra |
| Eclipse báo compliance 1.3 không hỗ trợ | Dùng external ECJ builder; xem output/log thay vì chỉ JDT marker |
| Chạy debug nhưng chưa có cửa sổ | Attach debugger đúng host/port và Resume; `suspend=y` đang chờ |
| Breakpoint không khớp/source khác JAR | Chọn đúng project/source, rebuild debug rồi restart đúng runner |
| Không giữ đăng nhập/cache sau khi tắt | Runner dùng `--rms memory` |
| Không kết nối được server | Kiểm tra host/port đang chọn và log; source chưa xác nhận server còn hoạt động |
| Màn hình khựng theo nhịp khoảng một giây | Xem exception bị bắt ở `GameCanvas.run`; có nhánh ngủ 1.000 ms |
| PNG/ảnh không hiện | So resource lock, đường dẫn `/x1/...`, giá trị `zoomLevel` và loader đang gọi |

Hướng dẫn từng tình huống, cách phân biệt lỗi build với JAR cũ và cách thu thập log: [TROUBLESHOOTING.md](docs/TROUBLESHOOTING.md).

## Sửa source và đọc tiếp

### Chọn điểm bắt đầu theo việc cần làm

| Việc | Nơi đọc trước |
|---|---|
| Hiểu từ Start đến màn đầu | `GameMidlet` → `GameCanvas` → `SplashScr` |
| Sửa form login/chọn server | `SelectServerScr`, `LoginScr`, `TField`, `Service.login` |
| Đọc giao thức | `Message`, `Service`, `Session_ME`, `SessionReceiver`, `Controller` |
| Sửa UI/chạm/phím | `MotherCanvas`, `GameCanvas`, `mScreen`, `Command`, screen cụ thể |
| Tìm lỗi map/nhân vật | Nhánh `Controller` liên quan → model → `GameScr`/`TileMap` |
| Tìm lỗi ảnh/font | `GameCanvas.loadImage`, `SmallImage`, `mFont`, `mGraphics` |
| Đổi tên an toàn | `symbols.json`, descriptor gốc, override family, source index và audit |
| Sửa tài nguyên | Resource lock, loader và nhánh cache/RMS/server |
| Kiểm tra một class | Danh mục source bên trên → API/field reference → mapping class |

### Nguyên tắc khi chỉnh tiếp

- Source đang dùng cú pháp tương thích với ECJ source 1.3; không thêm generics/lambda/API Java SE mới vào game rồi coi host JDK 17 là bảo đảm chạy trên Java ME.
- Chỉnh ít nhất có thể cho mục tiêu; tách thay đổi logic, rename và asset để dễ đối chiếu lỗi.
- Khi đổi tên method, kiểm tra overload, override và member reference bằng descriptor, không replace theo chữ trên toàn repo.
- Khi thêm/bớt class/resource, cập nhật cả lock/list và các số lượng/điều kiện hardcode liên quan trong builder. Sửa riêng `classes.list` là chưa đủ nếu vẫn giữ các kiểm tra 130/239/370.
- Không dùng một hàm rỗng hoặc một `return null` làm cách che lỗi decompile. Đồng thời không tự kết luận mọi hook rỗng/nhánh `return null` sẵn có là placeholder: phải đối chiếu bytecode và ngữ cảnh.
- Sau thay đổi source, build release/debug, kiểm tra scope thay đổi và chạy lại luồng liên quan. Các hash trong tài liệu là baseline, không phải hash bắt buộc cho mọi bản mod.
- Không commit JAR gốc, DLL, JDK, profile runtime, tài khoản hoặc credential vào repo để làm build “tiện hơn”.

### Bộ tài liệu

| Tài liệu | Nội dung |
|---|---|
| [BUILD_AND_DEBUG](docs/BUILD_AND_DEBUG.md) | Tham số script, JDK, clean clone, Eclipse, debug, Java trực tiếp |
| [ARCHITECTURE](docs/ARCHITECTURE.md) | Lifecycle, canvas/adapter, frame, screen, input, model và RMS |
| [NETWORK](docs/NETWORK.md) | Socket, queue, handshake, framing, Service/Controller và điểm quan sát |
| [RESOURCES](docs/RESOURCES.md) | Danh mục resource, loader, lock, cache và sửa asset |
| [MAPPING_AND_VERIFICATION](docs/MAPPING_AND_VERIFICATION.md) | Định danh JVM, status, locals, canonical audit và giới hạn |
| [TROUBLESHOOTING](docs/TROUBLESHOOTING.md) | Chẩn đoán lỗi theo triệu chứng và log |
| [API_REFERENCE](docs/API_REFERENCE.md) | Toàn bộ khai báo method/constructor, file/dòng và identity gốc |
| [FIELD_REFERENCE](docs/FIELD_REFERENCE.md) | Toàn bộ field, kiểu dữ liệu, file/dòng và identity gốc |
| [Mapping README](mapping/README.md) | Cách chọn export và bảng căn cứ từng class |
| [Source project](source/README.md) | Hướng dẫn nhanh khi đang đứng trong `source/` |

Tài liệu dùng bố cục hướng dẫn của repo NRO làm tham chiếu, nhưng số liệu, file, tham số, luồng khởi động, mạng và loader ở đây được lấy từ NSO. Các số 157 class/488 resource, hai session, frame 27 ms và XOR ảnh của NRO không áp dụng cho project này.

## Giấy phép và phân phối

Repository công khai không tự cấp quyền nguồn mở cho game, thương hiệu, hình ảnh, âm thanh hoặc JAR/DLL đầu vào. Repo chưa chọn một giấy phép nguồn mở chung cho toàn bộ nội dung.

Người phân phối cần kiểm tra quyền phù hợp đối với source và tài nguyên. Dependency giữ giấy phép của tác giả/nhà phát hành, không được xem là cùng giấy phép với nội dung game. Xem [LICENSE.md](LICENSE.md) và [THIRD_PARTY_NOTICES.md](THIRD_PARTY_NOTICES.md).
