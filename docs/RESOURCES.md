# Tài nguyên và cache

[Về README](../README.md) · [Resource lock](../source/config/resources.lock.json) · [Build](BUILD_AND_DEBUG.md)

## 1. Những gì có và không có trong repo

`source/src/main/resources` được tạo cục bộ bằng cách nhập dữ liệu từ JAR đầu vào. Thư mục này không được commit. Repository lưu lock gồm path, size, SHA-256 của từng file và hash của JAR được phép dùng để import.

Tập đã kiểm kê có 239 file, tổng 541.878 byte, gồm 166 PNG và các file dữ liệu/metadata khác. Không nhầm số này với tất cả ảnh, map hoặc effect mà server có thể tải trong một phiên chơi.

## 2. Import đúng đầu vào

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\source\build.ps1 `
  -OriginalJar 'C:\path\NinjaSchool_251.jar'
```

Thứ tự kiểm tra:

1. Hash toàn bộ input JAR phải khớp `input_jar_sha256`.
2. Từng path trong lock phải có trong ZIP và không phải directory.
3. Payload phải đúng size/hash.
4. Path đích phải nằm trong thư mục resource.
5. Nếu đã có resource khác nội dung, import dừng và giữ file đang có.

Import không copy các classfile game từ JAR. Bản game output phải được compile từ source Java.

## 3. Loader trong source

### `GameCanvas.loadImage(String)`

Hàm thêm `/x` + `mGraphics.zoomLevel` trước path rồi gọi `Image.createImage(path)`. Với zoom 1, path `/bg/bg00.png` thành `/x1/bg/bg00.png`.

Khi không tìm thấy/đọc được ảnh, hàm bắt `IOException` và giữ kết quả `null`. Lỗi render sau đó có thể xảy ra ở nơi dùng ảnh, nên cần xem nguyên nhân load trước khi chỉ sửa paint.

### `Controller.createImage(byte[])`

Gọi `Image.createImage(arr, 0, arr.length)`, bắt exception và trả `null` khi không tạo được ảnh. Đây là đường byte array, có thể nhận dữ liệu từ RMS hoặc server tùy caller.

Hai loader này không thực hiện bước XOR ảnh như tài liệu NRO. Không chuyển key XOR của game khác sang resource NSO.

### `SmallImage`

Giữ dữ liệu ảnh nhỏ/atlas, có các đường đọc ảnh, nhận ảnh theo ID, lấy kích thước và vẽ region. Khi một ID vẽ sai, kiểm tra dữ liệu chỉ mục cùng atlas/cache, không chỉ file PNG độc lập.

### `GameData`

Giữ bảng icon và byte data. `getImgIcon` có thể thử ảnh trong RMS, thử path resource theo ID rồi yêu cầu server nếu đang kết nối. `setImgIcon` cập nhật dữ liệu nhận được.

Một resource không nằm trong JAR có thể vốn thuộc đường tải server. Hash resource lock không xác nhận các dữ liệu tải đó đã tồn tại hoặc đã được kiểm thử.

## 4. Font và zoom

`mFont` đo/vẽ/chia dòng bằng dữ liệu font và ảnh. Các nhóm `font` và `x1/font` có vai trò khác nhau tùy caller; xem đúng đường dẫn trong constructor/loader thay vì chỉ nhìn tên tương tự.

`MotherCanvas.disableZoom` hiện là `true`; đường mặc định giữ zoom 1. Tập lock có `x1`, không có bộ `x2/x3/x4` tương ứng. Bật nhánh zoom khác là thay đổi hành vi, cần có asset và kiểm tra tọa độ/input/render riêng.

## 5. Khi sửa asset có chủ đích

Resource lock được thiết kế để phát hiện thay đổi. Nếu cố ý chỉnh ảnh/dữ liệu:

1. Giữ bản gốc/copy làm căn cứ so sánh.
2. Xác nhận loader và định dạng thực sự của file.
3. Cập nhật size/hash cho đúng file trong lock nếu muốn build chấp nhận bản mới.
4. Khi thêm/bớt file, xem cả `resource_count` và các kiểm tra số lượng 239/370 trong builder.
5. Build rồi thử đường vẽ/load liên quan.

Không đổi `input_jar_sha256` chỉ để vượt qua lỗi import. Import từ input gốc và build từ bộ asset tùy biến là hai thao tác khác nhau; script import hiện sẽ không ghi đè một asset đã sửa.

## 6. Các tầng dữ liệu

| Tầng | Nơi quan sát |
|---|---|
| File nằm trong JAR | Resource lock, `GameCanvas.loadImage`, `getResourceAsStream` |
| Metadata/atlas | `SmallImage`, `mFont`, `Part`, các parser dữ liệu |
| Cache trong bộ nhớ | Hashtable/vector/image holder của class liên quan |
| Cache RMS | `RMS` và caller đặt tên record |
| Nội dung tải trong phiên | `Service` yêu cầu, `Controller` nhận và cập nhật |

Việc xóa một cache có thể làm code thử tải lại hoặc trả `null`; chưa có kết quả test mọi kịch bản cache/server. Runner memory RMS không mô phỏng sẵn một profile online lâu năm.

## 7. Kiểm tra ảnh đã làm

Smoke test của release/debug giải mã thành công 166 PNG và thu framebuffer 176×220 ở các phase khởi động, chọn server, input và login. Pixel/color/tick được kiểm tra bằng chương trình. Đây không phải xác nhận chất lượng render bằng mắt hoặc mọi sprite trong chiến đấu.

## 8. Danh mục resource đầy đủ

Danh sách dưới lấy từ lock; size là byte, SHA-256 là payload của file. Đây là **danh mục**, không phải các file game được commit.

<!-- RESOURCE_INVENTORY_START -->
| Path | Byte | SHA-256 |
|---|---:|---|
| `agent.txt` | 1 | `5feceb66ffc86f38d952786c6d696c79c2dbc239dd4e91b46729d73a27fb57e9` |
| `font/number` | 106 | `7121c6b532d634826db990f23c83b44361a32a8bd77e5100b06aee66ed84a669` |
| `font/tahoma_7` | 1794 | `495b0ee16171fc81dc21efcd6b84727df839b76faec397cdaa46a8bceef08c31` |
| `font/tahoma_7b` | 1794 | `b29e3ad7f7e9257fcbbc6066856519c434a9ecfd104a445897929af8d232e772` |
| `font/tahoma_8b` | 1794 | `e3cd4a35158d8985bbde7d5d8ec87cdc541f0998e99976a2bd3746ccd5143b22` |
| `icon.png` | 3308 | `a49ceb9f30a801fba7d95467e0e34cbd1e65ef826585e4a41f9d224452edfc48` |
| `map/1` | 1602 | `9ae2a376fe8c3ba3346ccc4f0bfe65881c79e29b81b496772bce742f33b01e51` |
| `map/10` | 1122 | `29f14388daea725ce622180698c72fe84a45e1ea3d1524b9751ff1c16d1a8659` |
| `map/11` | 1602 | `df3c55edee6e0cb870283452116380a5585f69092111ca015a0be1ee308f05ea` |
| `map/12` | 1262 | `1961cbec3e960eab54b4b046a1f1b1af8d1ff87b54bcd317ffb62584f8bb13bf` |
| `map/13` | 1002 | `886138a990c4c53c6352a924aef4166178bc9d6740cd2a951d2a2a086880b092` |
| `map/133` | 2160 | `0c4fd98c46201cede23e7463c639c091dc9044afcf8762f29c6ffa37ffe1b459` |
| `map/14` | 1122 | `b8a6bf147143ca0329d5dced40c4c7d1a2c53b5f04fec9c9f7f70b0a4bf0dcc4` |
| `map/15` | 962 | `cb11f26c2dd3f75c7199c63dfd76f0a73d3273467e621df9fbc97b67a83fa510` |
| `map/16` | 1082 | `36e0a3ed248fbd5b3cf6ff2f96eb8364358091c439cb00a924cc337844d33fa9` |
| `map/2` | 842 | `0b16be49ca580747c7902143482ca05450c6cb2dfcc06f14a213ca7b9d7b67ad` |
| `map/20` | 562 | `2b8822e290fd54d2751ae4052771b49a26e927a20d1bb1c06965ad6e7a33c55b` |
| `map/21` | 1542 | `84efd3ac68d7841b4fb22c2f0d3022cac003b3bee9d8b4da86c1371d34d5f4e5` |
| `map/22` | 1682 | `7401663d228ff726cda72b80a6dc7968960ff40981d3a496260abc1e1c22928e` |
| `map/23` | 2402 | `7a1d0aefc2dd9f68be0fe966a0bff1f564a4816cbf44baee84b795ff9b287d55` |
| `map/25` | 1402 | `4e7718d946252bcdbe12e22ba652ebbcbf087bbb86c409f7f6d3ff16e434f27e` |
| `map/26` | 1952 | `17faac6256b6921ea33ffa39ef8032c992e3871aa4d6e0b5a5cf75e0f154f579` |
| `map/27` | 2402 | `64c4f33b4c805ecbb85c09d40045416b1b98d9176c1f5d965a7f5e450cf43a95` |
| `map/28` | 702 | `a9a38012dc36dbf4de92306d0415bf6c2dda6eb1bb0177860207e425401868a6` |
| `map/29` | 2562 | `4bae2fefe96017e180c0686d99249d56022fbff57d40b1d2d293429dc91f009d` |
| `map/3` | 1022 | `53996a20bd56dd38d0656e8ceb19762c791657159ac6da9b0960513d1c701c5f` |
| `map/30` | 1802 | `a5717e2580603fe90aa9fb2754386e9e2a9a656b8b36dd921874bf97b9d6a795` |
| `map/31` | 1302 | `f5cc8a9e809511f8af8360f1d3df4dfbb91fd7297660d4ea42567191b35c4387` |
| `map/32` | 2438 | `5b99dc049b358111f0fa01fbe1d6b19fee30b298895423b0a2e13601db6938c2` |
| `map/33` | 1682 | `b9834d13e106d99d009381fdafa10632b7caf5ae4cd94bc0d3fa57fa10323ac8` |
| `map/34` | 1502 | `19a4991a2a6abce684bdf9f6d5e67960fa7e7fd27c1023a06b406c17bf30271d` |
| `map/35` | 2402 | `38066ce71352cf7a44457188200c9acbc4b842183d2672cb2873461dc8a616e5` |
| `map/38` | 1282 | `ae26b5a049185dca7c851067d6538c7e1bd8628ff75acf82273973d696b13c56` |
| `map/39` | 2027 | `bf56561718b517988298c20bee5809c0b1dd4ea6fbab60b89757eeb2f41a06dd` |
| `map/4` | 1442 | `d48a306d35462d41d7b9b1ac6a967efa14eb83bda75abcef1b05a765e231497d` |
| `map/40` | 2050 | `69877828a2ac9cd9bc573c992f3f318aaf82ec311498258a4f09a8af0847fa7a` |
| `map/41` | 2382 | `a61c15bbdf20d3952d057247a8368eaa985a28fcbe32b99b4a875e3cab6ef89b` |
| `map/42` | 1602 | `f6f3ef73062312adf43177baa2da7b11b90d309f0b0a56e93e17c65711543fe3` |
| `map/43` | 2333 | `29d843a162ddfd42e42f04618b4c6f66c51d45bfbd4bcb46b76fd9181fbf6533` |
| `map/44` | 2012 | `b67db474195b8076ce38d3ed78832ae19bb33bf7e90003022f1271fd9606bf57` |
| `map/46` | 1832 | `521311333e5f5d8f94526ec3cfc4bfa76c638ee374e29c330328343255be49e6` |
| `map/47` | 2402 | `9edda8bad3880e2874cfd4d72939cac9a9b20a01dd03e2a36924347058126cf2` |
| `map/48` | 2543 | `f4cf4fa760962d4ad59b2ebd05941b214968de11d9d6ebfcdbb1453471404f66` |
| `map/49` | 2402 | `d2005611419611ff06fb42be1f1fc829966068b5a72c856057c8e6b06c762ec5` |
| `map/5` | 1282 | `47d2e24814148d6697133487aca3d688b3df78d5dbd29c44e92d8220d5a77a59` |
| `map/50` | 2446 | `ab65d43da812255a6ab283958be36428ec58c3c56df6ad3699db2c13e8b9e19f` |
| `map/51` | 982 | `ec1ec18aaaa6df3dfd956b81dae7bda1689334f8cad8370a739651ec37a8ccc6` |
| `map/52` | 2422 | `6892cd4d66a54eef9a09007e977340fd4e805fe57ce665c3bc5201cf718d0d52` |
| `map/57` | 352 | `5225566f401856744bc28fc1cb478b0ba0a7b92a359be2c9d9915cac149f2906` |
| `map/6` | 1622 | `d2ca1f02645da5ce3caf6bb107039dbff68ca82bf1294cfb0607abaad70c96a0` |
| `map/60` | 302 | `8e49ee5423ebed67ec024b422b67cda072192920b038a38007222801ff5d51ed` |
| `map/61` | 702 | `5e1674ee07eeb32fbc03e9f2e9e017085198a2155a370e020da5e867dcea7c5d` |
| `map/62` | 722 | `b8029defcc62c051296128b175b069d3f0dd0a59f9ac13d4085db303eff744e2` |
| `map/63` | 1202 | `ebcb5313512002e6849f0da56d8d8a60704232bd2fe561614c085c367ef59962` |
| `map/64` | 1122 | `5f1804bd65c0bc0d8a2ac68e800cbc8508fe99986b9bd48bd4773846c7831bd4` |
| `map/65` | 347 | `e0d4fc3b7270e175008d8775359b66fa8fa5182900e5e074115ebabfbacbc41a` |
| `map/66` | 1432 | `10381ba796f121a43c4b8b08d72541fe4dffa8545b44496763c7827d2de0aca8` |
| `map/67` | 1202 | `f2dab5e5f06015c41b3b750a2405b62fde77ad5e8ab5de4ec3cedb5f5064a707` |
| `map/68` | 1652 | `1b5673cd1ef200cc3eae1445cee3bb04adb64e659719d7951563752b8848407c` |
| `map/69` | 1202 | `71db1966553bd149288bf863368486d9af0a146fff3c1ad1ff18be4d126cae97` |
| `map/7` | 3502 | `d2d5b0f3e1506e9619301deaca57601d2261f79612535d07db327d00ced70497` |
| `map/70` | 1752 | `0066823f4ccfbb040ff389d3cc9899f61c333f11b080ed3097f4c964c275ffd7` |
| `map/71` | 1402 | `92d4466a4c7ca8066f47fa28939feaef013c169ad775d35444d4bdf0a2e32fe5` |
| `map/72` | 2402 | `016913d76bf0f5814e4cdb9a8500634185ccdb49a75a414c9200b3d2327d266b` |
| `map/8` | 1122 | `f6ae3b898222e7707ca5b7be950e0d2a27f5c098640b1d54123a3e6d15b424f0` |
| `map/9` | 1122 | `f4d32087672e7a5a99176974c6af375b7f5021dcfed4f3ea4d2e7df1d927d472` |
| `map/newmap` | 2160 | `90683ead6070229bdb0c0f174746e05faedfa283ff290047e15ce3f1ad967edc` |
| `provider.txt` | 1 | `5feceb66ffc86f38d952786c6d696c79c2dbc239dd4e91b46729d73a27fb57e9` |
| `x1/Big4.png` | 163 | `daaa7653512e9d380d1e15b32f1471f448b96fcc575707196e3ec4cf14238eff` |
| `x1/bg/bg00.png` | 365 | `ecd88a1a554e25c1810825ae274334009f36a41b87654e1872ae1fb3a3d2b69b` |
| `x1/bg/bg01.png` | 360 | `62ffb37df5083fa9590e572e163ce1236bef4c2256fcdcebddf6e552d6ca7061` |
| `x1/bg/bg010.png` | 1353 | `47db35b9dfd81cefdf005a61dc43121c5b8c2203a911acef886bd991f0d397ae` |
| `x1/bg/bg011.png` | 1718 | `f5d327e0c1c6f6b443bc30e5c622a9f213d334622167f3d9de4348e748e455a9` |
| `x1/bg/bg013.png` | 9416 | `6f46a3c3be8b68ddecda0c8baa0a3214a9c18b47f8554c04efc7108d895ce445` |
| `x1/bg/bg014.png` | 2089 | `1068f01bbd595115e136475c8d0178323d5eece78d49fb05a16352f3726daf88` |
| `x1/bg/bg015.png` | 7626 | `84207c401c18b3a2d132bda97c53282fed2840fab05224635e2fe95bcff39970` |
| `x1/bg/bg016.png` | 7583 | `95e706a598e800df558141d50d6e593784bea491b72ed4b3b13a608111d2a3d1` |
| `x1/bg/bg02.png` | 809 | `3e33b7e0c2616a44e90afe5b124c80e0f6f4361c678f73b9d3b5848e1dd541ba` |
| `x1/bg/bg03.png` | 1001 | `9ee92932d299feb088ff36e6ff786cb694267b55af49f252e996c256ae6f8620` |
| `x1/bg/bg04.png` | 240 | `42402510e760e0aae32a6a750e64360ad39cdc4a88c06ea4d4735f0773a74b94` |
| `x1/bg/bg05.png` | 1290 | `08abf7fa12cc05eea6ff5da2f0bbb051bf71153fa8f03976041084c567d3e0d5` |
| `x1/bg/bg06.png` | 388 | `4cb6d4827d83e9e5198310e8b8516fa4ecbc4066157273694a248dacc5dbda7d` |
| `x1/bg/bg07.png` | 2656 | `bdc8803cf78b918faeca2df4bfbd349a5bf1a0952a9d5807a1ab99b741649021` |
| `x1/bg/bg08.png` | 1284 | `45b2269fbb00d02bade1d9b16ece4646e60b8e64d3d1c66f0b23358e9be144d9` |
| `x1/bg/bg09.png` | 282 | `94169d2514d01ced6abfb48e69e0464f63bccf7ac416dcef82c821dd41daf5ec` |
| `x1/bg/bg10.png` | 228 | `fbe8cc9a3fc41f7550dd218ca1c32566778cd084418f50d9f8ddc0696d6303ac` |
| `x1/bg/bg11.png` | 326 | `3c777d1cead433c19afbeab8db3e7a6ad86014bb3a427b55fdba0cbb032b8762` |
| `x1/bg/bg113.png` | 7823 | `70a9a11d80cb49b0d45a4ffc51e404ac5aad6805d646df1b25e942dc8fb41a69` |
| `x1/bg/bg114.png` | 2319 | `b64ffd53e1f9817fdb4f5a010eecd1f3ab6b1331199b8eb61c135876b68cd157` |
| `x1/bg/bg115.png` | 7430 | `12919bd77adcaa5aa360f7e60a960ed155371d534fc1a7fe02a2c8bcff7add13` |
| `x1/bg/bg116.png` | 3533 | `e1d82854a58739618647c077c1f47333362cfb8423b7534c049c0d7cadcd4a24` |
| `x1/bg/bg12.png` | 304 | `84d038e5a9be89633c6a645f0543eac37bb75c8d1bfd99b33a6ab013dcc5e781` |
| `x1/bg/bg13.png` | 1015 | `72d294a147e7d3572aa67bb38a8417705fe9f7a6d5c8d93a56b7ab047e05c2b8` |
| `x1/bg/bg15.png` | 208 | `5b756c5d4413ef40db796ebd89f2dd97c60164e885a9f2f646e06d3278e04e4c` |
| `x1/bg/bg16.png` | 251 | `0811bad7c155819aecc6649b3baffd4e60a3eb098b1b024c7032631640bc6009` |
| `x1/bg/bg17.png` | 931 | `4ca4cbfba02283d24d8c63c530bfb68e99426b5d331268db0124400df6eb9cdb` |
| `x1/bg/bg18.png` | 262 | `d2d2ab54da5ab364a27fbd16ded5b8e94e38625aefdbb04738ff2d0d2d7d81d3` |
| `x1/bg/bg20.png` | 842 | `5df72a1c22c4db133a4951dc147b4a7c13130ef304bbce61c4ee6140259bf1b5` |
| `x1/bg/bg21.png` | 859 | `24ac20de1d6f37268354a96f916bf696e823b64696abc7332e856a07f7690a89` |
| `x1/bg/bg214.png` | 4123 | `85a89f032767874da43ba92ecc3aab1e631414c211b7fd433d1b044f1a09a797` |
| `x1/bg/bg216.png` | 1437 | `74a60a857f7c84b928a6efcf25d3f107dc54afa893f9d26c592d3527190b94e9` |
| `x1/bg/bg22.png` | 763 | `022638a73532a0a41d97583b6a8f96100094d951ad5eddfdcd21c8a46316a7f1` |
| `x1/bg/bg23.png` | 583 | `9b1005009ddc696a3219cc055a19ec6ae5070d28db114b3585c7e219f73b4e38` |
| `x1/bg/bg25.png` | 356 | `c9f9111e62774121dbcceea36c81200eaf3d3be8e6898aa908f1c8b79ffa0c5e` |
| `x1/bg/bg26.png` | 856 | `7e5edd424fb6ed4e0a88fd0be322ae296253daf737d9c54f14784a9a06a54f6a` |
| `x1/bg/bg28.png` | 310 | `1432db3a74e4ff32fb26921e5e195cb0a4299fbfec7dcad8b3071eb5d613eb9a` |
| `x1/bg/bg30.png` | 511 | `a0f2b43985a3151c1f59ee6840cfa3e55ab9ff01a06cdf23e680a51ce9792f05` |
| `x1/bg/bg31.png` | 657 | `6d05bec7aa24ca8c36b4ba81b658f49f6d4796f52c6b85e26380d1c494721efe` |
| `x1/bg/bg314.png` | 2089 | `1068f01bbd595115e136475c8d0178323d5eece78d49fb05a16352f3726daf88` |
| `x1/bg/bg32.png` | 694 | `19a85bdb2a73508ed0c3c1d486c3e11ecc1a8911406a2055065fbc0ff6ea62eb` |
| `x1/bg/bg33.png` | 694 | `19a85bdb2a73508ed0c3c1d486c3e11ecc1a8911406a2055065fbc0ff6ea62eb` |
| `x1/bg/bg34.png` | 404 | `4fbac4e0064a2d2d2bedb9a4b6507baf70fe71344eb4d8225944e9f1b5e28f24` |
| `x1/bg/bg35.png` | 926 | `c9a681d643aa9a10d0e3b4a11672d9d943cb87c7348c949cbd069fa25d62f1e9` |
| `x1/bg/bg37.png` | 360 | `59d12741a08188ff391518976f08b1137b0e6982137e368fa22e796333e4772b` |
| `x1/bg/bg38.png` | 302 | `2f2bfe41563852ba4b5d138503b8dbb04a8053e90a423ac459987bb34138ed8f` |
| `x1/bg/bg39.png` | 703 | `6747abb5b675e5d23e6f5fd85c88e35cc2a3852c8d5a8ae87a0651908aba22a1` |
| `x1/bg/cl0.png` | 760 | `e19b819ad59837c0acde97dca726df20586bd54b7ada9abc375f678be880baab` |
| `x1/bg/cl1.png` | 667 | `13325d2df0318e3f3afe2c86b9fa282a71765f07f0f6c77416f26bd721626c36` |
| `x1/bg/cl2.png` | 2611 | `d30b27dd5b8f57edcb436afe9ed1966aaaed38dacefa34499f77559cfc7f29d1` |
| `x1/bg/cl3.png` | 2543 | `cd0f05dec7a89ddb1a650e5b67737c6077d42fbe2d8f0247652c6223f90377f9` |
| `x1/bg/sun0.png` | 291 | `4f086d99b98573a4bcd8b9ed002b4e3448d302b73b9f525e6f0ec3cb34ef933f` |
| `x1/bg/sun1.png` | 840 | `21cb7b8757293ed371c2c07c1e356ab87c25070859201f84fd901b12040829af` |
| `x1/del/10.png` | 10719 | `a9cab940027e04f1eea589a098b7de72d730345101b9cf4930505a84f31f46c8` |
| `x1/del/10_dataEff` | 682 | `46570ba9bdb8d1d38305cf5806821b317458137942356ecdc5acc424ae9e689a` |
| `x1/del/5.png` | 6476 | `68c39388c397022ea477dbf47364afb913ec1726d059778308b14ec56140a3b8` |
| `x1/del/5_dataEff` | 1138 | `f9d13d55676c09d20b8ca8d52ea61c62588b8b39d22a4dc4bb564af7626737e7` |
| `x1/del/9.png` | 5861 | `4c106344b55f4fa70bbf01f51de0240d9b0f8e8057cef5dbbe1cdfb87042a313` |
| `x1/del/9_dataEff` | 490 | `88df3a6841c32f8d9612f0bb55795c9c306d2bd5560076d2b50d01230ba97bcc` |
| `x1/e/d00.png` | 80 | `267dd371d839b9702139ce740a67b8ea23aa4a68ba8d0673a99de65a779fe321` |
| `x1/e/d01.png` | 97 | `89c5d93b27b74bbb1e56ae3064b4fef1de6650b3209cb3883ee7f29d6be36651` |
| `x1/e/d02.png` | 113 | `94fe3b8735b4a9611cf916b869f47fb6e1797e528ffd50532ee017d0ecae8bd7` |
| `x1/e/d03.png` | 95 | `5b724dc3f843dd98fec0f240b360ef21f72ed9625eb6f27577db68ae16333cc4` |
| `x1/e/d04.png` | 91 | `98eec64ca1e418eb666c66ea39fb08f6e4905d57bc1fd03f5117198ce57b4c24` |
| `x1/e/d10.png` | 79 | `2544f560055c5e51d94eda4c442862734eb8620349a377c063c632ef610e8ccd` |
| `x1/e/d11.png` | 95 | `e2113164c8d859d1601a0dcc627e176285d29efc10835b615e1a2b321278127c` |
| `x1/e/d12.png` | 108 | `c5327054d9914af613c880ae9f3670d068804db93e8341d953ac58e205709efb` |
| `x1/e/d13.png` | 94 | `f39e26e0f1536d267a10a88c139169f07f03814aae047e2937af8bbac40fa85c` |
| `x1/e/d14.png` | 91 | `00b4c640b8cb672db611ac62eed892ef7a0951445ca8c5bccd6c445446504a2b` |
| `x1/e/sp0.png` | 156 | `930fdaa8637a3dea26d54e90b648e03ba392670a687c62c7c516d16854d04303` |
| `x1/e/sp1.png` | 166 | `0851d8cb8abf276f703372ff41ed2b971bf0e34c4f73d804c58c9c61def84a68` |
| `x1/e/sp2.png` | 152 | `5b59588d959eadba56c6cb4e8656c1383d5d79a2e124e355d7daabb629605a72` |
| `x1/e/w0.png` | 116 | `48a8d305ba1e6d5b6bef1a88773c50c626257e66a0c9364970f2e14ad57aa267` |
| `x1/e/w1.png` | 128 | `258397883bebf7682832782661cf6ef2bcf4e18264d3c010c1cebe2d18200924` |
| `x1/e/w2.png` | 107 | `dbd994e801239cd5d331256c8ffdaf3f864bd5c4996b3be6b34a346e418d2dc9` |
| `x1/eff/g10.png` | 303 | `aeb77242aff4b35cfc603d805ce317a1bd15aa1645e059d59228ae121a9c99a9` |
| `x1/eff/g132.png` | 500 | `e8bd4edc9b6b7c87f170d876de04b19a4de383ef8125e7e961a6ac5c21e1a275` |
| `x1/eff/g15.png` | 917 | `85c6c4839fe8f45eea4029a2b27c2dc205c1668718af8fddb42eae2286d96e93` |
| `x1/eff/g6.png` | 303 | `702c91374fe03d8d9e2611df1a5b9b0a81536f512eb0d4f4c570ecbd99f22559` |
| `x1/eff/g9.png` | 262 | `366d5edb931cdb62553481d214c0cfa5ec3c53838fb75560b5deab97de1b834c` |
| `x1/eff/g97.png` | 259 | `adfa71ddba61d0a4a84caa86db5194b476e7217aa66b48f903e783e2823c0673` |
| `x1/eff/g99.png` | 244 | `74e031c7f08bcc6394ba8413ebc9cd62dbd02dc42edc3df38b99954f12eac5bb` |
| `x1/export/0` | 682 | `3580c87439084f30142c2f53261751dc91b236e97e9980f1889b57e201571f40` |
| `x1/export/1` | 732 | `19bf6fd2a96daceb8d579e91e075b0cd6b7eb276e35a4d41435a64e782bdc5ae` |
| `x1/export/2` | 666 | `5798fbb53b0d4529989f1bae44ad739dd246b7b20500e78c063d8a1456f30049` |
| `x1/export/_big0.png` | 1834 | `14b1e5c3823afcbc106d9768e1a15a98933b1337a7c2e3a976aff59c6ecb422c` |
| `x1/export/_big1.png` | 3015 | `792f66649b31c4763ecfc92e6edd074b059366dba48774ade4f9f7acc3fb559c` |
| `x1/export/_big2.png` | 1003 | `c4d867efbe3c4fd9e6904447dde3024405c88a49753db9fb54108837789cbbfc` |
| `x1/font/number_green.png` | 195 | `4ba3322a2dd3fc79436e5cf99d9a484832e89fd121299b55d1944a06016e1756` |
| `x1/font/number_orange.png` | 195 | `e0483c76c87d3c1a6a8c15c674c273ecf6e972718f9d6e6bb914b6e3462d87fe` |
| `x1/font/number_red.png` | 195 | `ff78e338d3745b8d4daccfa76336464376425f70000e65fc923f909b8164b3a0` |
| `x1/font/number_white.png` | 181 | `1c68e127e0e28e699e854db2717ef5843d0a36b6399ad629239f8007ae3d1da6` |
| `x1/font/number_yellow.png` | 195 | `ddeaee8bf5e3639befa17f6b41d5cec1482e1cec2e17ed6a40c6f81cf9fc83a9` |
| `x1/font/tahoma_7.png` | 1015 | `9445cfe658b4de682f2583816749ae7af48784f72ebf1dbb008739ac9bb867cb` |
| `x1/font/tahoma_7_blue.png` | 1015 | `13e3c6794952352bf3738899e0a224a5d44c970985103dea0dd500700e094361` |
| `x1/font/tahoma_7_blue1.png` | 1015 | `08616d9fa6d9e7e1cc0e4a33cbce1da185396ec6426618c8e3a5250c6fc6017a` |
| `x1/font/tahoma_7_green.png` | 1015 | `4575e6c2c1281fec9b0411eea64a71c6319ac9409259c5d368c28d9d81e8fbd3` |
| `x1/font/tahoma_7_grey.png` | 1015 | `517aac720d07cec1b0789807468e75be1827da70b631ac71a11a279e7b2f7146` |
| `x1/font/tahoma_7_red.png` | 1015 | `3458a0db5fea2fc51cfcf25c420155ce7166e2dd79f90c9eb725fba9f1ac023c` |
| `x1/font/tahoma_7_white.png` | 1015 | `223d3fe888324ee8cc45765e757a09aee9f247eaf63c74a69238c746de13ff25` |
| `x1/font/tahoma_7_yellow.png` | 1015 | `55f799e6cd9c318643eca90e970a8bae6aefd164b38b68ff3d87d124c6b0c28c` |
| `x1/font/tahoma_7b_blue.png` | 1038 | `4bdd854b5e6ab4b6f50c8b767762a4353f3cf319cd8d3e718ffbf50406c84e2e` |
| `x1/font/tahoma_7b_green.png` | 1038 | `028915255adc31d6d3fe80927c90c877c70be0a803db011c6bed5adec4e0b9cf` |
| `x1/font/tahoma_7b_purple.png` | 1038 | `69838824fc6d0029107b70cc20db97cf409807877ca16e00ff4e45174b7db403` |
| `x1/font/tahoma_7b_red.png` | 1038 | `9df475a8351945a65ebb8b707b682d594b68128a9bc5e5a8193bf5c488e5fe4a` |
| `x1/font/tahoma_7b_white.png` | 1038 | `daf96357ca2608d43e33620c498458e2aa5336b4aafea66c826dcab2c63b4f12` |
| `x1/font/tahoma_7b_yellow.png` | 1038 | `b1aabeb6b0851b956e3649b6b474b988aedab7b5c90effc552769fe3b3be45c6` |
| `x1/font/tahoma_8b.png` | 1220 | `7adda33454fc7413d9f81714e4670cd8f3cb4c9f89d16b1027128ad48b98a09e` |
| `x1/hd/analog1.png` | 2290 | `816f0d665cf860674968a20eaa4a3db53a58e9858ed642f5bef3de374e774628` |
| `x1/hd/analog2.png` | 1101 | `60df8b11c2cb73b2d6e1aa052d5dc7f4e746eff88565dedc4b2f8e35ccc62278` |
| `x1/hd/arrow.png` | 353 | `941305c54d866aac742236094a34b04f6efaddbb846616030f3d90728f3a5684` |
| `x1/hd/arrow2.png` | 515 | `241868b3dd6805b6027284af8f975e5479cb69389e38a16ad0682b810c761dbd` |
| `x1/hd/bd0.png` | 652 | `f23d4a582a5621c15fb1a7506b79e3c88ac4c009c63911d6cccd46e973caadd7` |
| `x1/hd/bd1.png` | 813 | `3a6a3ac2c4fd5eafa9d40545b4f9403b373d7e94bc560e3ea7bee262bc2d6c24` |
| `x1/hd/bd2.png` | 123 | `5528c33c1e4dcae4ce4457fd523e24314f148a3b49d03e02c7c264b09be2f199` |
| `x1/hd/btnl.png` | 1095 | `6c2c5aae5fb006185aad3725e8025f048de2a88e7b393306de190c41f22f58c9` |
| `x1/hd/btnlBig0.png` | 3024 | `67804d5f29f58bcf337051f4b80b76b04a479deeedefa5541477f0fa1c82a4e9` |
| `x1/hd/btnlBig1.png` | 3454 | `0b23aa1461b69e9cb5c94739f18436ce2866916dbe234eef740def57c31dad30` |
| `x1/hd/btnlf.png` | 1134 | `66ad27c2abd02adae00d844c7868d54b4488127a32214372940995aaa9b69e1c` |
| `x1/hd/button.png` | 1019 | `bb600baf03f2bcb95892066d9500e0a9ed28611ed5901cf42e9fa84dd76f879b` |
| `x1/hd/button2.png` | 980 | `2d1c1ccf12d8e022501ecb70dbf35601aae7a170002ff509e82f5a00f3a2e9f6` |
| `x1/hd/chat.png` | 936 | `60a4c49b54284f62b3263c9f2090f876adea8d7c15ccf44faaf5cedd71b21c9e` |
| `x1/hd/focus.png` | 954 | `83ec9ea3e632fff12bebdcd07f7d8e6cd336a2a475bc3ea5a68ecd9e61f68c7b` |
| `x1/hd/hpp.png` | 937 | `5ed1b06640a80272bf94d58ecee1fd1973f7cd9a127f4979d6430eadb9621977` |
| `x1/hd/lua.png` | 487 | `67243f7348d5c9e7e41e89b36bcf8f1fbf93aebb1ea95981c935b43a5350fda7` |
| `x1/hd/mapborder.png` | 226 | `4f47fc41e899488d6f6f80195f767cbb08297689ac9a2b4d79f1f978bcf2e401` |
| `x1/hd/mat.png` | 225 | `8d3f7e05b28151f89fa94de97709f325f9f7f5fac926d9f1f14bb10d16b097a1` |
| `x1/hd/menu.png` | 909 | `3a83a60c4c1e8e3ce444871e5c3a8715f2789caab3f659b7ba7aad4bca146290` |
| `x1/hd/mpp.png` | 958 | `c900a47792e5fd2502d04245f608a0196f895b565078b086065a51edbe02226a` |
| `x1/hd/right.png` | 1864 | `e5d86134a35daa0029fc8159fda562134f3a816f1db100f80db6944c520f9030` |
| `x1/hd/right2.png` | 1928 | `f6a1d465f228fe804aedbe555e9a321446ce9f73b09b667c387c82bf39604053` |
| `x1/hd/skill.png` | 808 | `5e302a078c00297f7b470a3811609a759d8a85ccd6ceab0843022ccc183f00be` |
| `x1/hd/tf.png` | 1534 | `676982cd69ec5cbcef0ce2482683e1dde3a384b4f9f97469e891b7388e3ecf3a` |
| `x1/hd/topbar.png` | 2315 | `3702672f86340973fd2d55e8b1dbf75edc9420e1e31e1405bf1fcd6191d5b28c` |
| `x1/hd/transparent.png` | 96 | `9c72ee36b43523a883d3f96d24850340df498ef7185c99a0734f504ed36f2b41` |
| `x1/img/Big0.png` | 22820 | `c9a87ea20a41bb4301ee8589a265c902e7fb50647b4905ade847d8a9fc72dd90` |
| `x1/img/Big1.png` | 23331 | `6c1325695ddbf3be0299cb1cbd850990f71b44d16242206d7d0a63ec2d1c1aca` |
| `x1/img/Big2.png` | 9240 | `e1b805841526be2f2fa43748b054ee2e374512c071c23c604a7185474c7bdf96` |
| `x1/img/Big3.png` | 14084 | `91d9b39fe6c7dcec8d7f9d191afe352f4812c2772b3e3954bbe17c98686f0516` |
| `x1/img/Big4.png` | 30726 | `60de4a040ef7c4cef4cb15e126a4e81b2fbe71df8d3825b162a76613a472e92f` |
| `x1/m1.png` | 246 | `5e4054070f1e1d1983339865f5676c2e0bab45275869d7e61f75d7f9c2627fc0` |
| `x1/m2.png` | 229 | `a33105e93e7a832e07efec0a3055aa42cfa0fb7f459e7f8eee35d27e4d5ee853` |
| `x1/plus12.png` | 528 | `9435310476b810e981241da45a21aeafab28bb2266ac93f778738db257144821` |
| `x1/t/1.png` | 10743 | `8349769253336261dc2ed0658fa84d0237a1a959e4eeae0be7f40bbe091c6858` |
| `x1/t/2.png` | 15623 | `ce14f6be27b429dce6343a9a60d95e599b41387dda5ec9e5e33f2210e3ea130a` |
| `x1/t/3.png` | 17009 | `84f656205286762c6b756d3097e1bed171d1121df0c99be31c2b82822b6b12e0` |
| `x1/t/4.png` | 43358 | `864a3b019d887a9fd36c67697614020d02e83473f9f9287e9b114d77c6e71531` |
| `x1/t/5.png` | 21839 | `57faa377f9c712450162b4e7328206f262378e25057812eec7881fb3194edc03` |
| `x1/t/mini_1.png` | 660 | `01ce2b8a23311fbe0eb89ff65b1fe12a4706c311999a2f79d097ea1366d0d442` |
| `x1/t/mini_2.png` | 819 | `a8336e4e4b4bb94e7cc61961018c12dd2e82193d06b3a05e07aeadcde6635d91` |
| `x1/t/mini_3.png` | 768 | `76fbf8aeac7c7ed259166c9dee11023e996c0ee7d0c524948a30ba67cc194df3` |
| `x1/t/mini_4.png` | 10311 | `89fa3856dbf2fd79b5a42a978cf8b7564a851545c21e30411e59ab9127c10794` |
| `x1/t/mini_5.png` | 1184 | `29afb34ed67c518f1769eed29a60ab90209b891d637323c3b305a11933692113` |
| `x1/t/twtf.png` | 2013 | `06772da82d2774fc7ac5a100e6c6006f17f8a94e8ae901f3dfe8634da22b63cc` |
| `x1/t/uwt.png` | 101 | `ee93810731368ef647f53bf508f941ec5d62b1a78433a89361b63a9cdcae8bf0` |
| `x1/t/wtf.png` | 1688 | `b3c4600b6f2b394ec91d3d6ad01752575bc553eca56f9460c5f14ad3cb4742a2` |
| `x1/t/wts.png` | 160 | `0bf45c9f9caeda24b1f72bb9c38d321caf79afc7ac741a41d74261d6696b304b` |
| `x1/t/wts1.png` | 224 | `eab5e1989a477809788b2c1bc7b6012a42c5fa7eeb1166ae1ad1974ed0eaa9c1` |
| `x1/trung1.png` | 3835 | `8b3702055b72ce56f77ea1c8222e9d144da0b04e3ca359a10e0d7b88d7156e1a` |
| `x1/tt.png` | 4782 | `0aa23a5cc70ce429105d2aa01add5a6a7a79219fcb3154f9aac20aa5192e697a` |
| `x1/u/c0.png` | 454 | `dc6b0ff3e4e2735f717ca79eacfbb96294f2619e3b096bf848bcd797bf4deb68` |
| `x1/u/c1.png` | 466 | `165077a73ba05ffe1a1850ddbd8766796820cb48f13e6dd15a9dff527501adeb` |
| `x1/u/cobay.png` | 185 | `8160d2948263a340b6e9b90f71d805e0815d1c25e392ad70cf045b2e28a30e98` |
| `x1/u/f.png` | 309 | `58df4ab6365264fc4b68ed41c93b719db898d41160ad20093ce4846b903d24cb` |
| `x1/u/fc.png` | 135 | `48e66f18248e22bb9e89d0659b849158f2384fdded92bb04d9a5260b26a34f8b` |
| `x1/u/select.png` | 304 | `65c3b6289c8a43cfd25574cd0eade1e2bcff513a3918e42c15915b67abbbfcbb` |
| `x1/u/tuyet.png` | 128 | `8333bf65272e67f0d21146dd26ae386cf9f9c0f686ead6996c104e837047c648` |
| `x1/u/wpt1.png` | 369 | `4be05d6029f15076a05307d0476bf7fb6565a370e6c1700b7ad30f05178c34a6` |
| `x1/u/x.png` | 591 | `10cabad36d7a6cdee5a8954e05fe3d8790e14b520144ec6f693f043d5ed29ae5` |
| `x1/wm.png` | 23393 | `dc6512173422109c4d59c825592f2549930bbdc984eaccf14317a5c2a61d705f` |
<!-- RESOURCE_INVENTORY_END -->
