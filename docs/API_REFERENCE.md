# API source — 130 class, 1.311 khai báo

[Về README](../README.md) · [Field reference](FIELD_REFERENCE.md) · [Cách đọc mapping](MAPPING_AND_VERIFICATION.md)

Danh mục lấy từ source index đã kiểm chứng. Có cả method và constructor viết trong source; initializer/constructor implicit không nhất thiết xuất hiện như một declaration ở đây. Số dòng dẫn đến source hiện tại, không phải line number của input obfuscate.

Cột status là mức bằng chứng đặt tên; không tự khẳng định mọi tên đều là tên gốc. Các class không có declaration viết tường minh vẫn có thể nhận constructor mặc định từ compiler.

## nso.AnimateEffect

Đối tượng animation effect với update/paint.

[Source](../source/src/main/java/nso/AnimateEffect.java) · [Mapping](../mapping/classes/nso_AnimateEffect.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoanimateeffect)

`public final class AnimateEffect extends Effect2`

Identity class: `az`; status: `reference_proposal`; source: **142 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public AnimateEffect(byte byteValue, boolean flag, int value)`](../source/src/main/java/nso/AnimateEffect.java#L26) | 26–56 | `az.<init>(BZI)V` | `preserved` |
| [`public final void paint(mGraphics graphics)`](../source/src/main/java/nso/AnimateEffect.java#L58) | 58–83 | `az.a(Lt;)V` | `reference_proposal` |
| [`public final void update()`](../source/src/main/java/nso/AnimateEffect.java#L85) | 85–131 | `az.a()V` | `reference_proposal` |
| [`private void rndPos(Position position)`](../source/src/main/java/nso/AnimateEffect.java#L133) | 133–141 | `az.a(Lck;)V` | `reference_proposal` |

## nso.AnimationAction

Base action của animation.

[Source](../source/src/main/java/nso/AnimationAction.java) · [Mapping](../mapping/classes/nso_AnimationAction.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoanimationaction)

`public class AnimationAction`

Identity class: `bo`; status: `behavioral_name`; source: **7 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public AnimationAction()`](../source/src/main/java/nso/AnimationAction.java#L5) | 5–6 | `bo.<init>()V` | `preserved` |

## nso.DataSkillEff

Dữ liệu frame, vị trí và cập nhật effect kỹ năng.

[Source](../source/src/main/java/nso/DataSkillEff.java) · [Mapping](../mapping/classes/nso_DataSkillEff.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsodataskilleff)

`public final class DataSkillEff`

Identity class: `y`; status: `reference_proposal`; source: **571 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public DataSkillEff()`](../source/src/main/java/nso/DataSkillEff.java#L82) | 82–98 | `y.<init>()V` | `preserved` |
| [`public DataSkillEff(short id, boolean isEff)`](../source/src/main/java/nso/DataSkillEff.java#L100) | 100–119 | `y.<init>(SZ)V` | `preserved` |
| [`private void loadnew(byte[] data)`](../source/src/main/java/nso/DataSkillEff.java#L121) | 121–139 | `y.a([B)V` | `reference_proposal` |
| [`private void loadData(byte[] array)`](../source/src/main/java/nso/DataSkillEff.java#L141) | 141–262 | `y.b([B)V` | `reference_proposal` |
| [`public DataSkillEff(short id, long timelive1, int miliSecondWait2, boolean isHead)`](../source/src/main/java/nso/DataSkillEff.java#L264) | 264–293 | `y.<init>(SJIZ)V` | `preserved` |
| [`public final void setTypeEff(long timelive1)`](../source/src/main/java/nso/DataSkillEff.java#L295) | 295–303 | `y.a(J)V` | `reference_proposal` |
| [`private static byte[] vector2arr(MyVector entries)`](../source/src/main/java/nso/DataSkillEff.java#L305) | 305–312 | `y.a(Laa;)[B` | `reference_proposal` |
| [`private boolean isHavedata()`](../source/src/main/java/nso/DataSkillEff.java#L314) | 314–320 | `y.b()Z` | `reference_proposal` |
| [`public final void paintBottomEff_new(mGraphics graphics, int value, int value1, int value2, int value3)`](../source/src/main/java/nso/DataSkillEff.java#L322) | 322–370 | `y.a(Lt;IIII)V` | `reference_proposal` |
| [`public final void paintTopEff_new(mGraphics graphics, int value, int value1, int value2, int value3)`](../source/src/main/java/nso/DataSkillEff.java#L372) | 372–420 | `y.b(Lt;IIII)V` | `reference_proposal` |
| [`public final void paintTopEff(mGraphics graphics, int value, int value1)`](../source/src/main/java/nso/DataSkillEff.java#L422) | 422–463 | `y.a(Lt;II)V` | `reference_proposal` |
| [`public final void paintBottomEff(mGraphics graphics, int value, int value1)`](../source/src/main/java/nso/DataSkillEff.java#L465) | 465–506 | `y.b(Lt;II)V` | `reference_proposal` |
| [`private void setWait(boolean iss)`](../source/src/main/java/nso/DataSkillEff.java#L508) | 508–518 | `y.a(Z)V` | `reference_proposal` |
| [`public final void update()`](../source/src/main/java/nso/DataSkillEff.java#L520) | 520–570 | `y.a()V` | `reference_proposal` |

## nso.Domsang

Hiệu ứng vị trí có update/paint.

[Source](../source/src/main/java/nso/Domsang.java) · [Mapping](../mapping/classes/nso_Domsang.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsodomsang)

`public final class Domsang`

Identity class: `v`; status: `reference_proposal`; source: **59 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Domsang(int x, int y, int type)`](../source/src/main/java/nso/Domsang.java#L15) | 15–19 | `v.<init>(III)V` | `preserved` |
| [`public final void update()`](../source/src/main/java/nso/Domsang.java#L21) | 21–40 | `v.a()V` | `reference_proposal` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/Domsang.java#L42) | 42–58 | `v.a(Lt;)V` | `reference_proposal` |

## nso.EffAtutoTemp

Dữ liệu có các field `imginfo`, `frameEffAuto`, `frameRunning`, `timerequest`.

[Source](../source/src/main/java/nso/EffAtutoTemp.java) · [Mapping](../mapping/classes/nso_EffAtutoTemp.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoeffatutotemp)

`public final class EffAtutoTemp`

Identity class: `cc`; status: `reference_proposal`; source: **17 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public EffAtutoTemp()`](../source/src/main/java/nso/EffAtutoTemp.java#L15) | 15–16 | `cc.<init>()V` | `preserved` |

## nso.Effect

Dữ liệu và thao tác effect.

[Source](../source/src/main/java/nso/Effect.java) · [Mapping](../mapping/classes/nso_Effect.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoeffect)

`public final class Effect`

Identity class: `m`; status: `reference_proposal`; source: **21 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Effect(byte templateId, int timeStart1, int timeLenght2, short param3)`](../source/src/main/java/nso/Effect.java#L15) | 15–20 | `m.<init>(BIIS)V` | `preserved` |

## nso.Effect2

Base effect với hợp đồng update/paint.

[Source](../source/src/main/java/nso/Effect2.java) · [Mapping](../mapping/classes/nso_Effect2.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoeffect2)

`public abstract class Effect2`

Identity class: `au`; status: `reference_proposal`; source: **19 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Effect2()`](../source/src/main/java/nso/Effect2.java#L13) | 13–14 | `au.<init>()V` | `preserved` |
| [`public abstract void update()`](../source/src/main/java/nso/Effect2.java#L16) | 16–16 | `au.a()V` | `reference_proposal` |
| [`public abstract void paint(mGraphics g)`](../source/src/main/java/nso/Effect2.java#L18) | 18–18 | `au.a(Lt;)V` | `reference_proposal` |

## nso.EffectAuto

Effect theo dữ liệu/frame và vòng đời tự cập nhật.

[Source](../source/src/main/java/nso/EffectAuto.java) · [Mapping](../mapping/classes/nso_EffectAuto.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoeffectauto)

`public final class EffectAuto extends Effect2`

Identity class: `bl`; status: `reference_proposal`; source: **220 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public EffectAuto()`](../source/src/main/java/nso/EffectAuto.java#L35) | 35–36 | `bl.<init>()V` | `preserved` |
| [`public static void addEffectAuto(short id1, int x2, int y3, byte loopCount4, short time, int dir5)`](../source/src/main/java/nso/EffectAuto.java#L38) | 38–56 | `bl.a(SIIBSI)V` | `reference_proposal` |
| [`private EffAtutoTemp getTemplate()`](../source/src/main/java/nso/EffectAuto.java#L58) | 58–60 | `bl.d()Lcc;` | `reference_proposal` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/EffectAuto.java#L62) | 62–76 | `bl.a(Lt;)V` | `reference_proposal` |
| [`public final void update()`](../source/src/main/java/nso/EffectAuto.java#L78) | 78–133 | `bl.a()V` | `reference_proposal` |
| [`public static void reciveData(short id1, byte[] data)`](../source/src/main/java/nso/EffectAuto.java#L135) | 135–141 | `bl.a(S[B)V` | `reference_proposal` |
| [`private static EffAtutoTemp creatDataEffauto(short idEff, byte[] data)`](../source/src/main/java/nso/EffectAuto.java#L143) | 143–179 | `bl.c(S[B)Lcc;` | `reference_proposal` |
| [`public static void reciveImage(short id1, byte[] data)`](../source/src/main/java/nso/EffectAuto.java#L181) | 181–191 | `bl.b(S[B)V` | `reference_proposal` |
| [`public static void checkTimeUseImg()`](../source/src/main/java/nso/EffectAuto.java#L193) | 193–205 | `bl.b()V` | `reference_proposal` |
| [`public static void checkTimeUseData()`](../source/src/main/java/nso/EffectAuto.java#L207) | 207–219 | `bl.c()V` | `reference_proposal` |

## nso.EffectCharPaint

Dữ liệu effect gắn với nhân vật.

[Source](../source/src/main/java/nso/EffectCharPaint.java) · [Mapping](../mapping/classes/nso_EffectCharPaint.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoeffectcharpaint)

`public final class EffectCharPaint`

Identity class: `g`; status: `reference_proposal`; source: **11 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public EffectCharPaint()`](../source/src/main/java/nso/EffectCharPaint.java#L9) | 9–10 | `g.<init>()V` | `preserved` |

## nso.EffectInfoPaint

Thông tin vẽ effect.

[Source](../source/src/main/java/nso/EffectInfoPaint.java) · [Mapping](../mapping/classes/nso_EffectInfoPaint.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoeffectinfopaint)

`public final class EffectInfoPaint`

Identity class: `di`; status: `reference_proposal`; source: **13 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public EffectInfoPaint()`](../source/src/main/java/nso/EffectInfoPaint.java#L11) | 11–12 | `di.<init>()V` | `preserved` |

## nso.EffectPaint

Dữ liệu frame/ảnh để vẽ effect.

[Source](../source/src/main/java/nso/EffectPaint.java) · [Mapping](../mapping/classes/nso_EffectPaint.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoeffectpaint)

`public final class EffectPaint`

Identity class: `be`; status: `reference_proposal`; source: **21 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public EffectPaint()`](../source/src/main/java/nso/EffectPaint.java#L15) | 15–16 | `be.<init>()V` | `preserved` |
| [`public final int getImgId()`](../source/src/main/java/nso/EffectPaint.java#L18) | 18–20 | `be.a()I` | `reference_proposal` |

## nso.EffectTemplate

Template effect.

[Source](../source/src/main/java/nso/EffectTemplate.java) · [Mapping](../mapping/classes/nso_EffectTemplate.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoeffecttemplate)

`public final class EffectTemplate`

Identity class: `dj`; status: `reference_proposal`; source: **13 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public EffectTemplate()`](../source/src/main/java/nso/EffectTemplate.java#L11) | 11–12 | `dj.<init>()V` | `preserved` |

## nso.EmptyAnimationAction

Biến thể action có constructor rỗng đang được giữ theo baseline.

[Source](../source/src/main/java/nso/EmptyAnimationAction.java) · [Mapping](../mapping/classes/nso_EmptyAnimationAction.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoemptyanimationaction)

`final class EmptyAnimationAction extends AnimationAction`

Identity class: `bj`; status: `behavioral_name`; source: **7 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`EmptyAnimationAction(AnimateEffect animateEffect, Position position, int value, int value1)`](../source/src/main/java/nso/EmptyAnimationAction.java#L5) | 5–6 | `bj.<init>(Laz;Lck;II)V` | `preserved` |

## nso.FrameEff

Dữ liệu frame effect.

[Source](../source/src/main/java/nso/FrameEff.java) · [Mapping](../mapping/classes/nso_FrameEff.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoframeeff)

`public final class FrameEff`

Identity class: `ai`; status: `reference_proposal`; source: **13 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public FrameEff(MyVector listtop, MyVector listbottom)`](../source/src/main/java/nso/FrameEff.java#L9) | 9–12 | `ai.<init>(Laa;Laa;)V` | `preserved` |

## nso.Lightning

Hiệu ứng Lightning và các điểm/frame để vẽ.

[Source](../source/src/main/java/nso/Lightning.java) · [Mapping](../mapping/classes/nso_Lightning.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsolightning)

`public final class Lightning extends Effect2`

Identity class: `c`; status: `reference_proposal`; source: **240 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public static void addLight(MyVector position, EPosition firstPos, boolean isContinue1, int color2)`](../source/src/main/java/nso/Lightning.java#L29) | 29–40 | `c.a(Laa;Lba;ZI)V` | `reference_proposal` |
| [`public Lightning()`](../source/src/main/java/nso/Lightning.java#L42) | 42–43 | `c.<init>()V` | `preserved` |
| [`private void setInfo(MyVector position, EPosition angle, boolean isContinue1)`](../source/src/main/java/nso/Lightning.java#L45) | 45–162 | `c.a(Laa;Lba;Z)V` | `reference_proposal` |
| [`public final void update()`](../source/src/main/java/nso/Lightning.java#L164) | 164–194 | `c.a()V` | `reference_proposal` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/Lightning.java#L196) | 196–239 | `c.a(Lt;)V` | `reference_proposal` |

## nso.ServerEffect

Effect có điểm gọi/tham số liên quan dữ liệu server.

[Source](../source/src/main/java/nso/ServerEffect.java) · [Mapping](../mapping/classes/nso_ServerEffect.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoservereffect)

`public final class ServerEffect extends Effect2`

Identity class: `ap`; status: `reference_proposal`; source: **103 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public ServerEffect()`](../source/src/main/java/nso/ServerEffect.java#L23) | 23–24 | `ap.<init>()V` | `preserved` |
| [`public static void addServerEffect(int id, int cx, int cy, int loopCount1)`](../source/src/main/java/nso/ServerEffect.java#L26) | 26–33 | `ap.a(IIII)V` | `reference_proposal` |
| [`public static void addServerEffect(int id, int cx, int cy, int loopCount1, byte dir2)`](../source/src/main/java/nso/ServerEffect.java#L35) | 35–43 | `ap.a(IIIIB)V` | `reference_proposal` |
| [`public static void addServerEffect(int id, Char c1, int loopCount2)`](../source/src/main/java/nso/ServerEffect.java#L45) | 45–51 | `ap.a(ILbp;I)V` | `reference_proposal` |
| [`public static void addServerEffectWithTime(int value, Char character, int value1)`](../source/src/main/java/nso/ServerEffect.java#L53) | 53–59 | `ap.b(ILbp;I)V` | `reference_proposal` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/ServerEffect.java#L61) | 61–71 | `ap.a(Lt;)V` | `reference_proposal` |
| [`public final void update()`](../source/src/main/java/nso/ServerEffect.java#L73) | 73–102 | `ap.a()V` | `reference_proposal` |

## main.CanvasAdapter

Hợp đồng callback paint/key/pointer giữa Canvas và game.

[Source](../source/src/main/java/main/CanvasAdapter.java) · [Mapping](../mapping/classes/main_CanvasAdapter.md) · [Bảng còn lại](FIELD_REFERENCE.md#maincanvasadapter)

`public abstract class CanvasAdapter`

Identity class: `main/c`; status: `behavioral_name`; source: **21 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public CanvasAdapter()`](../source/src/main/java/main/CanvasAdapter.java#L7) | 7–8 | `main/c.<init>()V` | `preserved` |
| [`protected abstract void paint(Graphics graphics)`](../source/src/main/java/main/CanvasAdapter.java#L10) | 10–10 | `main/c.a(Ljavax/microedition/lcdui/Graphics;)V` | `behavioral_name` |
| [`protected abstract void keyPressed(int value)`](../source/src/main/java/main/CanvasAdapter.java#L12) | 12–12 | `main/c.c(I)V` | `behavioral_name` |
| [`protected abstract void keyReleased(int value)`](../source/src/main/java/main/CanvasAdapter.java#L14) | 14–14 | `main/c.d(I)V` | `behavioral_name` |
| [`protected abstract void pointerDragged(int value, int value1)`](../source/src/main/java/main/CanvasAdapter.java#L16) | 16–16 | `main/c.a(II)V` | `reference_proposal` |
| [`protected abstract void pointerPressed(int value, int value1)`](../source/src/main/java/main/CanvasAdapter.java#L18) | 18–18 | `main/c.b(II)V` | `reference_proposal` |
| [`protected abstract void pointerReleased(int value, int value1)`](../source/src/main/java/main/CanvasAdapter.java#L20) | 20–20 | `main/c.c(II)V` | `reference_proposal` |

## main.GameCanvas

Loop 40 ms, input, screen/dialog/menu, background và tiện ích chung.

[Source](../source/src/main/java/main/GameCanvas.java) · [Mapping](../mapping/classes/main_GameCanvas.md) · [Bảng còn lại](FIELD_REFERENCE.md#maingamecanvas)

`public final class GameCanvas extends CanvasAdapter implements IActionListener, Runnable`

Identity class: `main/a`; status: `reference_proposal`; source: **1630 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public GameCanvas()`](../source/src/main/java/main/GameCanvas.java#L232) | 232–296 | `main/a.<init>()V` | `preserved` |
| [`public static GameCanvas gI()`](../source/src/main/java/main/GameCanvas.java#L298) | 298–303 | `main/a.a()Lmain/a;` | `reference_proposal` |
| [`public static void connect(int value)`](../source/src/main/java/main/GameCanvas.java#L305) | 305–316 | `main/a.a(I)V` | `reference_proposal` |
| [`public static void initGameCanvas()`](../source/src/main/java/main/GameCanvas.java#L318) | 318–328 | `main/a.b()V` | `reference_proposal` |
| [`public final void startGameLoop()`](../source/src/main/java/main/GameCanvas.java#L330) | 330–332 | `main/a.c()V` | `behavioral_name` |
| [`public final void run()`](../source/src/main/java/main/GameCanvas.java#L334) | 334–431 | `main/a.run()V` | `preserved` |
| [`public static void updateBallEffect()`](../source/src/main/java/main/GameCanvas.java#L433) | 433–437 | `main/a.d()V` | `reference_proposal` |
| [`public static void updateBG()`](../source/src/main/java/main/GameCanvas.java#L439) | 439–452 | `main/a.e()V` | `reference_proposal` |
| [`public static void paintBGGameScr(mGraphics g1)`](../source/src/main/java/main/GameCanvas.java#L454) | 454–585 | `main/a.a(Lt;)V` | `reference_proposal` |
| [`public static void freeBackgroundImages()`](../source/src/main/java/main/GameCanvas.java#L587) | 587–591 | `main/a.f()V` | `behavioral_name` |
| [`public static void loadBG(int typeBG)`](../source/src/main/java/main/GameCanvas.java#L593) | 593–817 | `main/a.b(I)V` | `reference_proposal` |
| [`protected final void keyPressed(int value)`](../source/src/main/java/main/GameCanvas.java#L819) | 819–943 | `main/a.c(I)V` | `reference_proposal` |
| [`protected final void keyReleased(int value)`](../source/src/main/java/main/GameCanvas.java#L945) | 945–1040 | `main/a.d(I)V` | `reference_proposal` |
| [`protected final void pointerDragged(int x, int y)`](../source/src/main/java/main/GameCanvas.java#L1042) | 1042–1052 | `main/a.a(II)V` | `reference_proposal` |
| [`public static boolean isHoldPress()`](../source/src/main/java/main/GameCanvas.java#L1054) | 1054–1056 | `main/a.g()Z` | `reference_proposal` |
| [`protected final void pointerPressed(int x, int y)`](../source/src/main/java/main/GameCanvas.java#L1058) | 1058–1066 | `main/a.b(II)V` | `reference_proposal` |
| [`protected final void pointerReleased(int x, int y)`](../source/src/main/java/main/GameCanvas.java#L1068) | 1068–1074 | `main/a.c(II)V` | `reference_proposal` |
| [`public static boolean isPointerInGame(int value, int value1, int value2, int value3)`](../source/src/main/java/main/GameCanvas.java#L1076) | 1076–1080 | `main/a.a(IIII)Z` | `reference_proposal` |
| [`public static boolean isPointerInRoll(int x, int y, int w1, int h2, Scroll scroll)`](../source/src/main/java/main/GameCanvas.java#L1082) | 1082–1086 | `main/a.a(IIIILbw;)Z` | `reference_proposal` |
| [`public static boolean isPointerHoldIn(int value, int value1, int value2, int value3)`](../source/src/main/java/main/GameCanvas.java#L1088) | 1088–1090 | `main/a.b(IIII)Z` | `reference_proposal` |
| [`public static void clearKeyPressed()`](../source/src/main/java/main/GameCanvas.java#L1092) | 1092–1097 | `main/a.h()V` | `reference_proposal` |
| [`public static void clearKeyHold()`](../source/src/main/java/main/GameCanvas.java#L1099) | 1099–1103 | `main/a.i()V` | `reference_proposal` |
| [`protected final void paint(Graphics graphics)`](../source/src/main/java/main/GameCanvas.java#L1105) | 1105–1134 | `main/a.a(Ljavax/microedition/lcdui/Graphics;)V` | `behavioral_name` |
| [`public static void endDlg()`](../source/src/main/java/main/GameCanvas.java#L1136) | 1136–1145 | `main/a.j()V` | `reference_proposal` |
| [`public static void startOKDlg(String info)`](../source/src/main/java/main/GameCanvas.java#L1147) | 1147–1150 | `main/a.a(Ljava/lang/String;)V` | `reference_proposal` |
| [`public static void startWaitDlg(String info)`](../source/src/main/java/main/GameCanvas.java#L1152) | 1152–1156 | `main/a.b(Ljava/lang/String;)V` | `reference_proposal` |
| [`public static void startWaitDlg()`](../source/src/main/java/main/GameCanvas.java#L1158) | 1158–1160 | `main/a.k()V` | `reference_proposal` |
| [`public static void startWaitDlgWithoutCancel()`](../source/src/main/java/main/GameCanvas.java#L1162) | 1162–1167 | `main/a.l()V` | `reference_proposal` |
| [`public final void openWeb(String strLeft, String strRight, String url, String str)`](../source/src/main/java/main/GameCanvas.java#L1169) | 1169–1172 | `main/a.a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void sendSms(String strLeft, String strRight, short port, String syntax, String str)`](../source/src/main/java/main/GameCanvas.java#L1174) | 1174–1180 | `main/a.a(Ljava/lang/String;Ljava/lang/String;SLjava/lang/String;Ljava/lang/String;)V` | `reference_proposal` |
| [`public static void startOK(String info, int actionID, Object p)`](../source/src/main/java/main/GameCanvas.java#L1182) | 1182–1186 | `main/a.a(Ljava/lang/String;ILjava/lang/Object;)V` | `reference_proposal` |
| [`public static void startYesNoDlg(String info, int iYes, Object pYes, int iNo, Object pNo)`](../source/src/main/java/main/GameCanvas.java#L1188) | 1188–1193 | `main/a.a(Ljava/lang/String;ILjava/lang/Object;ILjava/lang/Object;)V` | `reference_proposal` |
| [`public static void startYesNoDlg(String info, Command cmdYes, Command cmdNo)`](../source/src/main/java/main/GameCanvas.java#L1195) | 1195–1199 | `main/a.a(Ljava/lang/String;Lbd;Lbd;)V` | `reference_proposal` |
| [`public static Image loadImage(String path)`](../source/src/main/java/main/GameCanvas.java#L1201) | 1201–1209 | `main/a.c(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;` | `reference_proposal` |
| [`public final boolean startDust(int dir, int x, int y)`](../source/src/main/java/main/GameCanvas.java#L1211) | 1211–1223 | `main/a.a(III)Z` | `reference_proposal` |
| [`private static void loadWaterSplash()`](../source/src/main/java/main/GameCanvas.java#L1225) | 1225–1235 | `main/a.o()V` | `reference_proposal` |
| [`public static boolean startWaterSplash(int value, int value1)`](../source/src/main/java/main/GameCanvas.java#L1237) | 1237–1249 | `main/a.d(II)Z` | `reference_proposal` |
| [`public final void updateDust()`](../source/src/main/java/main/GameCanvas.java#L1251) | 1251–1268 | `main/a.m()V` | `reference_proposal` |
| [`public static boolean isPaint(int x, int y)`](../source/src/main/java/main/GameCanvas.java#L1270) | 1270–1278 | `main/a.e(II)Z` | `reference_proposal` |
| [`public final void paintDust(mGraphics g1)`](../source/src/main/java/main/GameCanvas.java#L1280) | 1280–1288 | `main/a.b(Lt;)V` | `reference_proposal` |
| [`public static void paintShukiren(int x, int y, mGraphics g1, boolean noRotate)`](../source/src/main/java/main/GameCanvas.java#L1290) | 1290–1293 | `main/a.a(IILt;Z)V` | `reference_proposal` |
| [`public final void resetToLoginScr()`](../source/src/main/java/main/GameCanvas.java#L1295) | 1295–1298 | `main/a.n()V` | `reference_proposal` |
| [`public static boolean isPointer(int value, int value1, int value2, int value3)`](../source/src/main/java/main/GameCanvas.java#L1300) | 1300–1302 | `main/a.c(IIII)Z` | `reference_proposal` |
| [`public final void perform(int idAction, Object p)`](../source/src/main/java/main/GameCanvas.java#L1304) | 1304–1629 | `main/a.a(ILjava/lang/Object;)V` | `reference_proposal` |

## main.GameMidlet

MIDlet entry, Display, server list và cache danh sách server.

[Source](../source/src/main/java/main/GameMidlet.java) · [Mapping](../mapping/classes/main_GameMidlet.md) · [Bảng còn lại](FIELD_REFERENCE.md#maingamemidlet)

`public class GameMidlet extends MIDlet`

Identity class: `main/GameMidlet`; status: `preserved`; source: **264 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public GameMidlet()`](../source/src/main/java/main/GameMidlet.java#L65) | 65–75 | `main/GameMidlet.<init>()V` | `preserved` |
| [`protected void destroyApp(boolean flag)`](../source/src/main/java/main/GameMidlet.java#L77) | 77–78 | `main/GameMidlet.destroyApp(Z)V` | `preserved` |
| [`protected void pauseApp()`](../source/src/main/java/main/GameMidlet.java#L80) | 80–81 | `main/GameMidlet.pauseApp()V` | `preserved` |
| [`protected void startApp()`](../source/src/main/java/main/GameMidlet.java#L83) | 83–85 | `main/GameMidlet.startApp()V` | `preserved` |
| [`public final void exit()`](../source/src/main/java/main/GameMidlet.java#L87) | 87–91 | `main/GameMidlet.a()V` | `reference_proposal` |
| [`public static void openUrlAndExit(String text)`](../source/src/main/java/main/GameMidlet.java#L93) | 93–102 | `main/GameMidlet.a(Ljava/lang/String;)V` | `behavioral_name` |
| [`private String readFileText(String fileName)`](../source/src/main/java/main/GameMidlet.java#L104) | 104–115 | `main/GameMidlet.b(Ljava/lang/String;)Ljava/lang/String;` | `reference_proposal` |
| [`public final void sendGPS()`](../source/src/main/java/main/GameMidlet.java#L117) | 117–119 | `main/GameMidlet.b()V` | `behavioral_name` |
| [`private static void saveIP()`](../source/src/main/java/main/GameMidlet.java#L121) | 121–140 | `main/GameMidlet.g()V` | `reference_proposal` |
| [`public static void getStrSv()`](../source/src/main/java/main/GameMidlet.java#L142) | 142–190 | `main/GameMidlet.c()V` | `reference_proposal` |
| [`public static void loadLinkRMS()`](../source/src/main/java/main/GameMidlet.java#L192) | 192–221 | `main/GameMidlet.d()V` | `reference_proposal` |
| [`public static int GetWorldIndex()`](../source/src/main/java/main/GameMidlet.java#L223) | 223–234 | `main/GameMidlet.e()I` | `reference_proposal` |
| [`public static int GetLastIndex()`](../source/src/main/java/main/GameMidlet.java#L236) | 236–243 | `main/GameMidlet.f()I` | `reference_proposal` |
| [`private static String connectHTTP(String link)`](../source/src/main/java/main/GameMidlet.java#L245) | 245–263 | `main/GameMidlet.c(Ljava/lang/String;)Ljava/lang/String;` | `reference_proposal` |

## main.MotherCanvas

Canvas MIDP thật; chuyển paint/key/pointer sang adapter.

[Source](../source/src/main/java/main/MotherCanvas.java) · [Mapping](../mapping/classes/main_MotherCanvas.md) · [Bảng còn lại](FIELD_REFERENCE.md#mainmothercanvas)

`public final class MotherCanvas extends Canvas`

Identity class: `main/b`; status: `reference_proposal`; source: **82 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public MotherCanvas()`](../source/src/main/java/main/MotherCanvas.java#L21) | 21–39 | `main/b.<init>()V` | `preserved` |
| [`public final void setCanvasAdapter(CanvasAdapter canvasAdapter)`](../source/src/main/java/main/MotherCanvas.java#L41) | 41–43 | `main/b.a(Lmain/c;)V` | `behavioral_name` |
| [`protected final void paint(Graphics graphics)`](../source/src/main/java/main/MotherCanvas.java#L45) | 45–47 | `main/b.paint(Ljavax/microedition/lcdui/Graphics;)V` | `preserved` |
| [`protected final void keyPressed(int keyCode)`](../source/src/main/java/main/MotherCanvas.java#L49) | 49–51 | `main/b.keyPressed(I)V` | `preserved` |
| [`protected final void keyReleased(int keyCode)`](../source/src/main/java/main/MotherCanvas.java#L53) | 53–55 | `main/b.keyReleased(I)V` | `preserved` |
| [`protected final void pointerDragged(int x, int y)`](../source/src/main/java/main/MotherCanvas.java#L57) | 57–61 | `main/b.pointerDragged(II)V` | `preserved` |
| [`protected final void pointerPressed(int x, int y)`](../source/src/main/java/main/MotherCanvas.java#L63) | 63–67 | `main/b.pointerPressed(II)V` | `preserved` |
| [`protected final void pointerReleased(int x, int y)`](../source/src/main/java/main/MotherCanvas.java#L69) | 69–73 | `main/b.pointerReleased(II)V` | `preserved` |
| [`public final int getHeight_new()`](../source/src/main/java/main/MotherCanvas.java#L75) | 75–77 | `main/b.a()I` | `reference_proposal` |
| [`public final int getWidth_new()`](../source/src/main/java/main/MotherCanvas.java#L79) | 79–81 | `main/b.b()I` | `reference_proposal` |

## nso.Arrowpaint

Dữ liệu vẽ mũi tên.

[Source](../source/src/main/java/nso/Arrowpaint.java) · [Mapping](../mapping/classes/nso_Arrowpaint.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoarrowpaint)

`public final class Arrowpaint`

Identity class: `bx`; status: `reference_proposal`; source: **15 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Arrowpaint()`](../source/src/main/java/nso/Arrowpaint.java#L13) | 13–14 | `bx.<init>()V` | `preserved` |

## nso.Clan

Dữ liệu clan.

[Source](../source/src/main/java/nso/Clan.java) · [Mapping](../mapping/classes/nso_Clan.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoclan)

`public final class Clan`

Identity class: `r`; status: `reference_proposal`; source: **79 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Clan()`](../source/src/main/java/nso/Clan.java#L37) | 37–39 | `r.<init>()V` | `preserved` |
| [`public final void writeLog(String data)`](../source/src/main/java/nso/Clan.java#L41) | 41–78 | `r.a(Ljava/lang/String;)V` | `reference_proposal` |

## nso.Clan_ThanThu

Dữ liệu thần thú clan.

[Source](../source/src/main/java/nso/Clan_ThanThu.java) · [Mapping](../mapping/classes/nso_Clan_ThanThu.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoclan_thanthu)

`public final class Clan_ThanThu`

Identity class: `o`; status: `reference_proposal`; source: **37 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Clan_ThanThu(String name1, byte stars2, short idIconItem3, short idThanThu4, int time_aptrung5, String str_trungno6, MyVector vecInfo7, int curExp8, int maxExp9)`](../source/src/main/java/nso/Clan_ThanThu.java#L25) | 25–36 | `o.<init>(Ljava/lang/String;BSSILjava/lang/String;Laa;II)V` | `preserved` |

## nso.DunItem

Dữ liệu có các field `id`, `name1`, `name2`.

[Source](../source/src/main/java/nso/DunItem.java) · [Mapping](../mapping/classes/nso_DunItem.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsodunitem)

`public final class DunItem`

Identity class: `dv`; status: `reference_proposal`; source: **13 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public DunItem()`](../source/src/main/java/nso/DunItem.java#L11) | 11–12 | `dv.<init>()V` | `preserved` |

## nso.EPosition

Dữ liệu vị trí dùng trong effect/game.

[Source](../source/src/main/java/nso/EPosition.java) · [Mapping](../mapping/classes/nso_EPosition.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoeposition)

`public final class EPosition`

Identity class: `ba`; status: `reference_proposal`; source: **28 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public EPosition(int x1, int y2)`](../source/src/main/java/nso/EPosition.java#L15) | 15–18 | `ba.<init>(II)V` | `preserved` |
| [`public EPosition(int x1, int y2, int fol)`](../source/src/main/java/nso/EPosition.java#L20) | 20–24 | `ba.<init>(III)V` | `preserved` |
| [`public EPosition()`](../source/src/main/java/nso/EPosition.java#L26) | 26–27 | `ba.<init>()V` | `preserved` |

## nso.Friend

Dữ liệu bạn bè.

[Source](../source/src/main/java/nso/Friend.java) · [Mapping](../mapping/classes/nso_Friend.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsofriend)

`public final class Friend`

Identity class: `cz`; status: `reference_proposal`; source: **13 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Friend(String friendName1, byte type2)`](../source/src/main/java/nso/Friend.java#L9) | 9–12 | `cz.<init>(Ljava/lang/String;B)V` | `preserved` |

## nso.Item

Vật phẩm instance, chỉ số/trang bị và thao tác liên quan.

[Source](../source/src/main/java/nso/Item.java) · [Mapping](../mapping/classes/nso_Item.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoitem)

`public final class Item`

Identity class: `by`; status: `reference_proposal`; source: **231 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Item()`](../source/src/main/java/nso/Item.java#L52) | 52–53 | `by.<init>()V` | `preserved` |
| [`public final Item clone()`](../source/src/main/java/nso/Item.java#L55) | 55–83 | `by.a()Lby;` | `reference_proposal` |
| [`public final Item viewNext(int up)`](../source/src/main/java/nso/Item.java#L85) | 85–110 | `by.a(I)Lby;` | `reference_proposal` |
| [`public final boolean isTypeBody()`](../source/src/main/java/nso/Item.java#L112) | 112–114 | `by.b()Z` | `reference_proposal` |
| [`public final boolean isTypeMounts()`](../source/src/main/java/nso/Item.java#L116) | 116–118 | `by.c()Z` | `reference_proposal` |
| [`public final boolean isTypeNgocKham()`](../source/src/main/java/nso/Item.java#L120) | 120–122 | `by.d()Z` | `reference_proposal` |
| [`public final String getExpiresString()`](../source/src/main/java/nso/Item.java#L124) | 124–137 | `by.e()Ljava/lang/String;` | `reference_proposal` |
| [`public final String getExpiresShopString()`](../source/src/main/java/nso/Item.java#L139) | 139–153 | `by.f()Ljava/lang/String;` | `reference_proposal` |
| [`public final void clearExpire()`](../source/src/main/java/nso/Item.java#L155) | 155–159 | `by.g()V` | `reference_proposal` |
| [`public final boolean isTypeUIMe()`](../source/src/main/java/nso/Item.java#L161) | 161–163 | `by.h()Z` | `reference_proposal` |
| [`public final boolean isTypeUIShopView()`](../source/src/main/java/nso/Item.java#L165) | 165–167 | `by.i()Z` | `reference_proposal` |
| [`public final boolean isTypeUIShop()`](../source/src/main/java/nso/Item.java#L169) | 169–171 | `by.j()Z` | `reference_proposal` |
| [`public final boolean isTypeUIShopLock()`](../source/src/main/java/nso/Item.java#L173) | 173–175 | `by.k()Z` | `reference_proposal` |
| [`public final boolean isTypeUIStore()`](../source/src/main/java/nso/Item.java#L177) | 177–179 | `by.l()Z` | `reference_proposal` |
| [`public final boolean isTypeUIBook()`](../source/src/main/java/nso/Item.java#L181) | 181–183 | `by.m()Z` | `reference_proposal` |
| [`public final boolean isTypeUIFashion()`](../source/src/main/java/nso/Item.java#L185) | 185–187 | `by.n()Z` | `reference_proposal` |
| [`public final boolean isTypeUIClanShop()`](../source/src/main/java/nso/Item.java#L189) | 189–191 | `by.o()Z` | `reference_proposal` |
| [`public final boolean isUpMax()`](../source/src/main/java/nso/Item.java#L193) | 193–195 | `by.p()Z` | `reference_proposal` |
| [`public final int getUpMax()`](../source/src/main/java/nso/Item.java#L197) | 197–207 | `by.q()I` | `reference_proposal` |
| [`public final boolean isTypeClothe()`](../source/src/main/java/nso/Item.java#L209) | 209–211 | `by.r()Z` | `reference_proposal` |
| [`public final boolean isTypeAdorn()`](../source/src/main/java/nso/Item.java#L213) | 213–215 | `by.s()Z` | `reference_proposal` |
| [`public final boolean isTypeWeapon()`](../source/src/main/java/nso/Item.java#L217) | 217–219 | `by.t()Z` | `reference_proposal` |
| [`public final boolean isNewitem()`](../source/src/main/java/nso/Item.java#L221) | 221–230 | `by.u()Z` | `reference_proposal` |

## nso.ItemOption

Giá trị option của vật phẩm.

[Source](../source/src/main/java/nso/ItemOption.java) · [Mapping](../mapping/classes/nso_ItemOption.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoitemoption)

`public final class ItemOption`

Identity class: `cg`; status: `reference_proposal`; source: **58 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public ItemOption()`](../source/src/main/java/nso/ItemOption.java#L11) | 11–12 | `cg.<init>()V` | `preserved` |
| [`public ItemOption(int optionTemplateId, int param1)`](../source/src/main/java/nso/ItemOption.java#L14) | 14–17 | `cg.<init>(II)V` | `preserved` |
| [`public final String getOptionString()`](../source/src/main/java/nso/ItemOption.java#L19) | 19–26 | `cg.a()Ljava/lang/String;` | `reference_proposal` |
| [`private static String getValuePercent(int value)`](../source/src/main/java/nso/ItemOption.java#L28) | 28–34 | `cg.a(I)Ljava/lang/String;` | `reference_proposal` |
| [`public final String getOptionShopString()`](../source/src/main/java/nso/ItemOption.java#L36) | 36–57 | `cg.b()Ljava/lang/String;` | `reference_proposal` |

## nso.ItemOptionTemplate

Template option vật phẩm.

[Source](../source/src/main/java/nso/ItemOptionTemplate.java) · [Mapping](../mapping/classes/nso_ItemOptionTemplate.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoitemoptiontemplate)

`public final class ItemOptionTemplate`

Identity class: `do`; status: `reference_proposal`; source: **13 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public ItemOptionTemplate()`](../source/src/main/java/nso/ItemOptionTemplate.java#L11) | 11–12 | `do.<init>()V` | `preserved` |

## nso.ItemStands

Dữ liệu item trong giao diện/đối tượng ItemStands.

[Source](../source/src/main/java/nso/ItemStands.java) · [Mapping](../mapping/classes/nso_ItemStands.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoitemstands)

`public final class ItemStands`

Identity class: `bu`; status: `reference_proposal`; source: **17 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public ItemStands()`](../source/src/main/java/nso/ItemStands.java#L15) | 15–16 | `bu.<init>()V` | `preserved` |

## nso.ItemTemplate

Dữ liệu template vật phẩm.

[Source](../source/src/main/java/nso/ItemTemplate.java) · [Mapping](../mapping/classes/nso_ItemTemplate.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoitemtemplate)

`public final class ItemTemplate`

Identity class: `bz`; status: `reference_proposal`; source: **34 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public ItemTemplate(short templateID, byte type1, byte gender2, String name3, String description4, byte level5, short iconID6, short part7, boolean isUpToUp8)`](../source/src/main/java/nso/ItemTemplate.java#L23) | 23–33 | `bz.<init>(SBBLjava/lang/String;Ljava/lang/String;BSSZ)V` | `preserved` |

## nso.ItemTemplates

Bảng template vật phẩm và truy xuất theo ID.

[Source](../source/src/main/java/nso/ItemTemplates.java) · [Mapping](../mapping/classes/nso_ItemTemplates.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoitemtemplates)

`public final class ItemTemplates`

Identity class: `e`; status: `reference_proposal`; source: **21 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public ItemTemplates()`](../source/src/main/java/nso/ItemTemplates.java#L7) | 7–8 | `e.<init>()V` | `preserved` |
| [`public static void add(ItemTemplate it)`](../source/src/main/java/nso/ItemTemplates.java#L10) | 10–12 | `e.a(Lbz;)V` | `reference_proposal` |
| [`public static ItemTemplate get(short id)`](../source/src/main/java/nso/ItemTemplates.java#L14) | 14–16 | `e.a(S)Lbz;` | `reference_proposal` |
| [`public static short getIcon(short shortValue)`](../source/src/main/java/nso/ItemTemplates.java#L18) | 18–20 | `e.b(S)S` | `reference_proposal` |

## nso.MainObject

Dữ liệu có các field `vecEFfect`.

[Source](../source/src/main/java/nso/MainObject.java) · [Mapping](../mapping/classes/nso_MainObject.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsomainobject)

`public class MainObject`

Identity class: `as`; status: `reference_proposal`; source: **53 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public MainObject()`](../source/src/main/java/nso/MainObject.java#L7) | 7–8 | `as.<init>()V` | `preserved` |
| [`public final void paintTopDataEff(mGraphics graphics, int value, int value1, int value2)`](../source/src/main/java/nso/MainObject.java#L10) | 10–21 | `as.a(Lt;III)V` | `reference_proposal` |
| [`public final void paintBottomDataEff(mGraphics graphics, int value, int value1, int value2)`](../source/src/main/java/nso/MainObject.java#L23) | 23–34 | `as.b(Lt;III)V` | `reference_proposal` |
| [`public final void updateDataEff(byte type, int statusMe)`](../source/src/main/java/nso/MainObject.java#L36) | 36–52 | `as.a(BI)V` | `reference_proposal` |

## nso.Member

Dữ liệu thành viên.

[Source](../source/src/main/java/nso/Member.java) · [Mapping](../mapping/classes/nso_Member.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsomember)

`public final class Member`

Identity class: `bn`; status: `reference_proposal`; source: **48 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Member(int classId, int level1, int type2, String name3, int pointClan4, boolean isOnline5)`](../source/src/main/java/nso/Member.java#L19) | 19–47 | `bn.<init>(IIILjava/lang/String;IZ)V` | `preserved` |

## nso.MobTemplate

Template mob.

[Source](../source/src/main/java/nso/MobTemplate.java) · [Mapping](../mapping/classes/nso_MobTemplate.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsomobtemplate)

`public final class MobTemplate`

Identity class: `a`; status: `reference_proposal`; source: **39 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public MobTemplate()`](../source/src/main/java/nso/MobTemplate.java#L37) | 37–38 | `a.<init>()V` | `preserved` |

## nso.NClass

Dữ liệu lớp nhân vật.

[Source](../source/src/main/java/nso/NClass.java) · [Mapping](../mapping/classes/nso_NClass.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsonclass)

`public final class NClass`

Identity class: `cx`; status: `reference_proposal`; source: **13 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public NClass()`](../source/src/main/java/nso/NClass.java#L11) | 11–12 | `cx.<init>()V` | `preserved` |

## nso.NpcTemplate

Template NPC.

[Source](../source/src/main/java/nso/NpcTemplate.java) · [Mapping](../mapping/classes/nso_NpcTemplate.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsonpctemplate)

`public final class NpcTemplate`

Identity class: `bi`; status: `reference_proposal`; source: **19 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public NpcTemplate()`](../source/src/main/java/nso/NpcTemplate.java#L17) | 17–18 | `bi.<init>()V` | `preserved` |

## nso.Party

Dữ liệu party.

[Source](../source/src/main/java/nso/Party.java) · [Mapping](../mapping/classes/nso_Party.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoparty)

`public final class Party`

Identity class: `db`; status: `reference_proposal`; source: **98 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Party(byte classId, int level1, String name2, int size3)`](../source/src/main/java/nso/Party.java#L19) | 19–45 | `db.<init>(BILjava/lang/String;I)V` | `preserved` |
| [`public Party(int charId1, byte classId, String name2, boolean isLock3)`](../source/src/main/java/nso/Party.java#L47) | 47–78 | `db.<init>(IBLjava/lang/String;Z)V` | `preserved` |
| [`public static void refreshAll()`](../source/src/main/java/nso/Party.java#L80) | 80–87 | `db.a()V` | `reference_proposal` |
| [`public static void clear(int charId1)`](../source/src/main/java/nso/Party.java#L89) | 89–97 | `db.a(I)V` | `reference_proposal` |

## nso.Position

Dữ liệu tọa độ/vị trí.

[Source](../source/src/main/java/nso/Position.java) · [Mapping](../mapping/classes/nso_Position.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoposition)

`public final class Position`

Identity class: `ck`; status: `reference_proposal`; source: **26 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Position()`](../source/src/main/java/nso/Position.java#L17) | 17–20 | `ck.<init>()V` | `preserved` |
| [`public Position(int x1, int y2)`](../source/src/main/java/nso/Position.java#L22) | 22–25 | `ck.<init>(II)V` | `preserved` |

## nso.Ranked

Dữ liệu xếp hạng.

[Source](../source/src/main/java/nso/Ranked.java) · [Mapping](../mapping/classes/nso_Ranked.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoranked)

`public final class Ranked`

Identity class: `cf`; status: `reference_proposal`; source: **13 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Ranked()`](../source/src/main/java/nso/Ranked.java#L11) | 11–12 | `cf.<init>()V` | `preserved` |

## nso.Set

Dữ liệu thời gian và tọa độ mob/char.

[Source](../source/src/main/java/nso/Set.java) · [Mapping](../mapping/classes/nso_Set.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoset)

`public final class Set`

Identity class: `k`; status: `reference_proposal`; source: **14 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| Không có method/constructor khai báo tường minh trong source index | — | Xem method table input trong mapping | — |

## nso.Skill

Skill instance, hồi chiêu và dữ liệu hiển thị.

[Source](../source/src/main/java/nso/Skill.java) · [Mapping](../mapping/classes/nso_Skill.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoskill)

`public final class Skill`

Identity class: `z`; status: `reference_proposal`; source: **52 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Skill()`](../source/src/main/java/nso/Skill.java#L31) | 31–32 | `z.<init>()V` | `preserved` |
| [`public final void paint(int x, int y, mGraphics g)`](../source/src/main/java/nso/Skill.java#L34) | 34–47 | `z.a(IILt;)V` | `reference_proposal` |
| [`public final boolean isCooldown()`](../source/src/main/java/nso/Skill.java#L49) | 49–51 | `z.a()Z` | `reference_proposal` |

## nso.SkillInfoPaint

Thông tin frame vẽ kỹ năng.

[Source](../source/src/main/java/nso/SkillInfoPaint.java) · [Mapping](../mapping/classes/nso_SkillInfoPaint.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoskillinfopaint)

`public final class SkillInfoPaint`

Identity class: `ar`; status: `reference_proposal`; source: **33 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public SkillInfoPaint()`](../source/src/main/java/nso/SkillInfoPaint.java#L31) | 31–32 | `ar.<init>()V` | `preserved` |

## nso.SkillOption

Giá trị option của skill.

[Source](../source/src/main/java/nso/SkillOption.java) · [Mapping](../mapping/classes/nso_SkillOption.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoskilloption)

`public final class SkillOption`

Identity class: `cr`; status: `reference_proposal`; source: **25 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public SkillOption()`](../source/src/main/java/nso/SkillOption.java#L11) | 11–12 | `cr.<init>()V` | `preserved` |
| [`public final String getOptionString()`](../source/src/main/java/nso/SkillOption.java#L14) | 14–24 | `cr.a()Ljava/lang/String;` | `reference_proposal` |

## nso.SkillOptionTemplate

Template option của skill.

[Source](../source/src/main/java/nso/SkillOptionTemplate.java) · [Mapping](../mapping/classes/nso_SkillOptionTemplate.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoskilloptiontemplate)

`public final class SkillOptionTemplate`

Identity class: `cm`; status: `reference_proposal`; source: **11 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public SkillOptionTemplate()`](../source/src/main/java/nso/SkillOptionTemplate.java#L9) | 9–10 | `cm.<init>()V` | `preserved` |

## nso.SkillPaint

Dữ liệu vẽ kỹ năng.

[Source](../source/src/main/java/nso/SkillPaint.java) · [Mapping](../mapping/classes/nso_SkillPaint.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoskillpaint)

`public final class SkillPaint`

Identity class: `n`; status: `reference_proposal`; source: **13 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public SkillPaint()`](../source/src/main/java/nso/SkillPaint.java#L11) | 11–12 | `n.<init>()V` | `preserved` |

## nso.SkillTemplate

Template kỹ năng.

[Source](../source/src/main/java/nso/SkillTemplate.java) · [Mapping](../mapping/classes/nso_SkillTemplate.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoskilltemplate)

`public final class SkillTemplate`

Identity class: `j`; status: `reference_proposal`; source: **21 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public SkillTemplate()`](../source/src/main/java/nso/SkillTemplate.java#L19) | 19–20 | `j.<init>()V` | `preserved` |

## nso.Skills

Bảng skill và truy xuất theo ID.

[Source](../source/src/main/java/nso/Skills.java) · [Mapping](../mapping/classes/nso_Skills.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoskills)

`public final class Skills`

Identity class: `bc`; status: `reference_proposal`; source: **17 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Skills()`](../source/src/main/java/nso/Skills.java#L7) | 7–8 | `bc.<init>()V` | `preserved` |
| [`public static void add(Skill skill)`](../source/src/main/java/nso/Skills.java#L10) | 10–12 | `bc.a(Lz;)V` | `reference_proposal` |
| [`public static Skill get(short skillId)`](../source/src/main/java/nso/Skills.java#L14) | 14–16 | `bc.a(S)Lz;` | `reference_proposal` |

## nso.Task

Dữ liệu nhiệm vụ.

[Source](../source/src/main/java/nso/Task.java) · [Mapping](../mapping/classes/nso_Task.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsotask)

`public final class Task`

Identity class: `h`; status: `reference_proposal`; source: **25 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Task(short taskId, byte index1, String name, String detail, String[] subNames2, short[] counts3, short count4)`](../source/src/main/java/nso/Task.java#L17) | 17–24 | `h.<init>(SBLjava/lang/String;Ljava/lang/String;[Ljava/lang/String;[SS)V` | `preserved` |

## nso.TaskOrder

Dữ liệu bước/thứ tự nhiệm vụ.

[Source](../source/src/main/java/nso/TaskOrder.java) · [Mapping](../mapping/classes/nso_TaskOrder.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsotaskorder)

`public final class TaskOrder`

Identity class: `av`; status: `reference_proposal`; source: **28 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public TaskOrder(byte taskId1, int count2, int maxCount3, String name4, String description5, int killId6, int mapId7)`](../source/src/main/java/nso/TaskOrder.java#L19) | 19–27 | `av.<init>(BIILjava/lang/String;Ljava/lang/String;II)V` | `preserved` |

## nso.CreateCharScr

Màn tạo nhân vật.

[Source](../source/src/main/java/nso/CreateCharScr.java) · [Mapping](../mapping/classes/nso_CreateCharScr.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsocreatecharscr)

`public final class CreateCharScr extends mScreen implements IActionListener`

Identity class: `bh`; status: `reference_proposal`; source: **235 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public static CreateCharScr gI()`](../source/src/main/java/nso/CreateCharScr.java#L29) | 29–34 | `bh.b()Lbh;` | `reference_proposal` |
| [`public CreateCharScr()`](../source/src/main/java/nso/CreateCharScr.java#L36) | 36–65 | `bh.<init>()V` | `preserved` |
| [`public final void switchToMe()`](../source/src/main/java/nso/CreateCharScr.java#L67) | 67–71 | `bh.a()V` | `reference_proposal` |
| [`public final void keyPress(int keyCode)`](../source/src/main/java/nso/CreateCharScr.java#L73) | 73–75 | `bh.b(I)V` | `reference_proposal` |
| [`public final void update()`](../source/src/main/java/nso/CreateCharScr.java#L77) | 77–101 | `bh.c()V` | `reference_proposal` |
| [`public final void updateKey()`](../source/src/main/java/nso/CreateCharScr.java#L103) | 103–137 | `bh.d()V` | `reference_proposal` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/CreateCharScr.java#L139) | 139–205 | `bh.a(Lt;)V` | `reference_proposal` |
| [`public final void perform(int idAction, Object p)`](../source/src/main/java/nso/CreateCharScr.java#L207) | 207–234 | `bh.a(ILjava/lang/Object;)V` | `reference_proposal` |

## nso.GameScr

Màn chơi: camera, đối tượng, combat, UI và render.

[Source](../source/src/main/java/nso/GameScr.java) · [Mapping](../mapping/classes/nso_GameScr.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsogamescr)

`public final class GameScr extends mScreen implements IActionListener`

Identity class: `dg`; status: `reference_proposal`; source: **17216 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public static long getMaxExp(int level)`](../source/src/main/java/nso/GameScr.java#L993) | 993–999 | `dg.a(I)J` | `reference_proposal` |
| [`public static void resetAllvector()`](../source/src/main/java/nso/GameScr.java#L1001) | 1001–1014 | `dg.b()V` | `reference_proposal` |
| [`public static void loadSkillShortcut()`](../source/src/main/java/nso/GameScr.java#L1016) | 1016–1020 | `dg.g()V` | `reference_proposal` |
| [`public static void loadSkillShortcutNhanban()`](../source/src/main/java/nso/GameScr.java#L1022) | 1022–1026 | `dg.h()V` | `reference_proposal` |
| [`public final void onOSkill(byte[] oSkillID)`](../source/src/main/java/nso/GameScr.java#L1028) | 1028–1047 | `dg.a([B)V` | `reference_proposal` |
| [`public final void onKSkill(byte[] kSkillID)`](../source/src/main/java/nso/GameScr.java#L1049) | 1049–1068 | `dg.b([B)V` | `reference_proposal` |
| [`public final void onCSkill(byte[] cSkillID)`](../source/src/main/java/nso/GameScr.java#L1070) | 1070–1087 | `dg.c([B)V` | `reference_proposal` |
| [`private static void doSetOnScreenSkill(SkillTemplate skillTemplate)`](../source/src/main/java/nso/GameScr.java#L1089) | 1089–1106 | `dg.a(Lj;)V` | `reference_proposal` |
| [`private static void doSetKeySkill(SkillTemplate skillTemplate)`](../source/src/main/java/nso/GameScr.java#L1108) | 1108–1119 | `dg.b(Lj;)V` | `reference_proposal` |
| [`private static void saveOnScreenSkillToRMS()`](../source/src/main/java/nso/GameScr.java#L1121) | 1121–1135 | `dg.P()V` | `reference_proposal` |
| [`private static void saveKeySkillToRMS()`](../source/src/main/java/nso/GameScr.java#L1137) | 1137–1151 | `dg.Q()V` | `reference_proposal` |
| [`public final void addSkillShortcut(Skill skill)`](../source/src/main/java/nso/GameScr.java#L1153) | 1153–1173 | `dg.a(Lz;)V` | `reference_proposal` |
| [`public static boolean isBagFull()`](../source/src/main/java/nso/GameScr.java#L1175) | 1175–1182 | `dg.i()Z` | `reference_proposal` |
| [`public static void createMenu(String[] menu1, Npc npc)`](../source/src/main/java/nso/GameScr.java#L1184) | 1184–1190 | `dg.a([Ljava/lang/String;Lcy;)V` | `reference_proposal` |
| [`private void doBag()`](../source/src/main/java/nso/GameScr.java#L1192) | 1192–1196 | `dg.R()V` | `reference_proposal` |
| [`private void doskill()`](../source/src/main/java/nso/GameScr.java#L1198) | 1198–1202 | `dg.S()V` | `reference_proposal` |
| [`private void doTiemnangMe()`](../source/src/main/java/nso/GameScr.java#L1204) | 1204–1208 | `dg.T()V` | `reference_proposal` |
| [`private void doInfo()`](../source/src/main/java/nso/GameScr.java#L1210) | 1210–1214 | `dg.U()V` | `reference_proposal` |
| [`private void doTrangbi()`](../source/src/main/java/nso/GameScr.java#L1216) | 1216–1220 | `dg.V()V` | `reference_proposal` |
| [`private void doThucuoi()`](../source/src/main/java/nso/GameScr.java#L1222) | 1222–1226 | `dg.W()V` | `reference_proposal` |
| [`private void doBiJuu()`](../source/src/main/java/nso/GameScr.java#L1228) | 1228–1233 | `dg.X()V` | `reference_proposal` |
| [`private void doBiJuu_Point()`](../source/src/main/java/nso/GameScr.java#L1235) | 1235–1240 | `dg.Y()V` | `reference_proposal` |
| [`private void doBiJuu_Skill()`](../source/src/main/java/nso/GameScr.java#L1242) | 1242–1247 | `dg.Z()V` | `reference_proposal` |
| [`public static void readPart()`](../source/src/main/java/nso/GameScr.java#L1249) | 1249–1273 | `dg.j()V` | `reference_proposal` |
| [`public static void readEfect()`](../source/src/main/java/nso/GameScr.java#L1275) | 1275–1300 | `dg.k()V` | `reference_proposal` |
| [`public static void readArrow()`](../source/src/main/java/nso/GameScr.java#L1302) | 1302–1323 | `dg.l()V` | `reference_proposal` |
| [`public static void readSkill()`](../source/src/main/java/nso/GameScr.java#L1325) | 1325–1383 | `dg.m()V` | `reference_proposal` |
| [`public static void setLevel_Exp(long exp, boolean value)`](../source/src/main/java/nso/GameScr.java#L1385) | 1385–1395 | `dg.a(JZ)V` | `reference_proposal` |
| [`public static GameScr gI()`](../source/src/main/java/nso/GameScr.java#L1397) | 1397–1402 | `dg.n()Ldg;` | `reference_proposal` |
| [`public static void clearGameScr()`](../source/src/main/java/nso/GameScr.java#L1404) | 1404–1413 | `dg.o()V` | `reference_proposal` |
| [`public final void loadSplash()`](../source/src/main/java/nso/GameScr.java#L1415) | 1415–1430 | `dg.p()V` | `reference_proposal` |
| [`public GameScr()`](../source/src/main/java/nso/GameScr.java#L1432) | 1432–1536 | `dg.<init>()V` | `preserved` |
| [`private void doCloseItemInfo()`](../source/src/main/java/nso/GameScr.java#L1538) | 1538–1549 | `dg.aa()V` | `reference_proposal` |
| [`private void doUpPotential()`](../source/src/main/java/nso/GameScr.java#L1551) | 1551–1555 | `dg.ab()V` | `reference_proposal` |
| [`private void doUpSkill()`](../source/src/main/java/nso/GameScr.java#L1557) | 1557–1561 | `dg.ac()V` | `reference_proposal` |
| [`private void doAddFriend()`](../source/src/main/java/nso/GameScr.java#L1563) | 1563–1567 | `dg.ad()V` | `reference_proposal` |
| [`private void doMiniMenuInforMe()`](../source/src/main/java/nso/GameScr.java#L1569) | 1569–1609 | `dg.ae()V` | `reference_proposal` |
| [`private void doMenuInforMe()`](../source/src/main/java/nso/GameScr.java#L1611) | 1611–1630 | `dg.af()V` | `reference_proposal` |
| [`private static void doMenusynthesis()`](../source/src/main/java/nso/GameScr.java#L1632) | 1632–1640 | `dg.ag()V` | `reference_proposal` |
| [`private static void actMenu()`](../source/src/main/java/nso/GameScr.java#L1642) | 1642–1675 | `dg.ah()V` | `reference_proposal` |
| [`private void doShowTaskUI()`](../source/src/main/java/nso/GameScr.java#L1677) | 1677–1686 | `dg.ai()V` | `reference_proposal` |
| [`private void doShowFindTeamUI()`](../source/src/main/java/nso/GameScr.java#L1688) | 1688–1696 | `dg.aj()V` | `reference_proposal` |
| [`private void doShowCharInMap()`](../source/src/main/java/nso/GameScr.java#L1698) | 1698–1710 | `dg.ak()V` | `reference_proposal` |
| [`private void doShowTeamUI()`](../source/src/main/java/nso/GameScr.java#L1712) | 1712–1719 | `dg.al()V` | `reference_proposal` |
| [`public final void doShowRankedListUI()`](../source/src/main/java/nso/GameScr.java#L1721) | 1721–1729 | `dg.q()V` | `reference_proposal` |
| [`public final void doShowListUI()`](../source/src/main/java/nso/GameScr.java#L1731) | 1731–1739 | `dg.r()V` | `reference_proposal` |
| [`private void doShowFriendUI()`](../source/src/main/java/nso/GameScr.java#L1741) | 1741–1751 | `dg.am()V` | `reference_proposal` |
| [`private void doShowEnemiesUI()`](../source/src/main/java/nso/GameScr.java#L1753) | 1753–1763 | `dg.an()V` | `reference_proposal` |
| [`public final void refreshFindTeam()`](../source/src/main/java/nso/GameScr.java#L1765) | 1765–1774 | `dg.s()V` | `reference_proposal` |
| [`public final void refreshTeam()`](../source/src/main/java/nso/GameScr.java#L1776) | 1776–1792 | `dg.t()V` | `reference_proposal` |
| [`private static void doShowMap()`](../source/src/main/java/nso/GameScr.java#L1794) | 1794–1798 | `dg.ao()V` | `reference_proposal` |
| [`public final void openUIZone(Message message)`](../source/src/main/java/nso/GameScr.java#L1800) | 1800–1821 | `dg.a(Lce;)V` | `reference_proposal` |
| [`public final void openUITrade()`](../source/src/main/java/nso/GameScr.java#L1823) | 1823–1837 | `dg.u()V` | `reference_proposal` |
| [`public static final void loadCamera(boolean fullScreen)`](../source/src/main/java/nso/GameScr.java#L1839) | 1839–2007 | `dg.a(Z)V` | `reference_proposal` |
| [`private static boolean checkSkillValid()`](../source/src/main/java/nso/GameScr.java#L2009) | 2009–2025 | `dg.ap()Z` | `reference_proposal` |
| [`public final void resetButton()`](../source/src/main/java/nso/GameScr.java#L2027) | 2027–2227 | `dg.v()V` | `reference_proposal` |
| [`public final void keyPress(int keyCode)`](../source/src/main/java/nso/GameScr.java#L2229) | 2229–2234 | `dg.b(I)V` | `reference_proposal` |
| [`public final void updateKey()`](../source/src/main/java/nso/GameScr.java#L2236) | 2236–3335 | `dg.d()V` | `reference_proposal` |
| [`private void resetAuto()`](../source/src/main/java/nso/GameScr.java#L3337) | 3337–3340 | `dg.aq()V` | `reference_proposal` |
| [`public static void doUseMP()`](../source/src/main/java/nso/GameScr.java#L3342) | 3342–3354 | `dg.w()V` | `reference_proposal` |
| [`public static void doUseHP()`](../source/src/main/java/nso/GameScr.java#L3356) | 3356–3375 | `dg.x()V` | `reference_proposal` |
| [`private static boolean isMobSameParty()`](../source/src/main/java/nso/GameScr.java#L3377) | 3377–3379 | `dg.ar()Z` | `reference_proposal` |
| [`private void doFire(boolean isFireByShortCut)`](../source/src/main/java/nso/GameScr.java#L3381) | 3381–3641 | `dg.b(Z)V` | `reference_proposal` |
| [`private void doChangeSkill()`](../source/src/main/java/nso/GameScr.java#L3643) | 3643–3671 | `dg.as()V` | `reference_proposal` |
| [`public final void doUseSkill(Skill skill, boolean isShortcut, boolean isSelectSkill)`](../source/src/main/java/nso/GameScr.java#L3673) | 3673–3702 | `dg.a(Lz;ZZ)V` | `reference_proposal` |
| [`public static void sortList(int type)`](../source/src/main/java/nso/GameScr.java#L3704) | 3704–3725 | `dg.c(I)V` | `reference_proposal` |
| [`public static void sortClan()`](../source/src/main/java/nso/GameScr.java#L3727) | 3727–3885 | `dg.y()V` | `reference_proposal` |
| [`public static void sortSkill()`](../source/src/main/java/nso/GameScr.java#L3887) | 3887–3901 | `dg.z()V` | `reference_proposal` |
| [`private static void setCharJump(int cvx)`](../source/src/main/java/nso/GameScr.java#L3903) | 3903–3908 | `dg.h(I)V` | `reference_proposal` |
| [`public final void update()`](../source/src/main/java/nso/GameScr.java#L3910) | 3910–4233 | `dg.c()V` | `reference_proposal` |
| [`private static void paintTime(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L4235) | 4235–4242 | `dg.c(Lt;)V` | `reference_proposal` |
| [`public final void paint(mGraphics graphics)`](../source/src/main/java/nso/GameScr.java#L4244) | 4244–5048 | `dg.a(Lt;)V` | `reference_proposal` |
| [`private void paintUIAuto(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L5050) | 5050–5100 | `dg.d(Lt;)V` | `reference_proposal` |
| [`private static void paintCheckBox(mGraphics graphics, String text, boolean flag, String text1, int value, int value2)`](../source/src/main/java/nso/GameScr.java#L5102) | 5102–5119 | `dg.a(Lt;Ljava/lang/String;ZLjava/lang/String;II)V` | `reference_proposal` |
| [`private void paintList(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L5121) | 5121–5162 | `dg.e(Lt;)V` | `reference_proposal` |
| [`private void paintCharInMap(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L5164) | 5164–5212 | `dg.f(Lt;)V` | `reference_proposal` |
| [`private void paintFoodEffect(mGraphics graphics)`](../source/src/main/java/nso/GameScr.java#L5214) | 5214–5278 | `dg.g(Lt;)V` | `reference_proposal` |
| [`public static void resetTranslate(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L5280) | 5280–5283 | `dg.b(Lt;)V` | `reference_proposal` |
| [`private void paintDebugInfo(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L5285) | 5285–5471 | `dg.h(Lt;)V` | `reference_proposal` |
| [`private void paintTouchControl(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L5473) | 5473–5525 | `dg.i(Lt;)V` | `reference_proposal` |
| [`private void paintSelectedSkill(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L5527) | 5527–5564 | `dg.j(Lt;)V` | `reference_proposal` |
| [`public static final void startFlyText(String flyString, int x, int y, int dx, int dy, int color1)`](../source/src/main/java/nso/GameScr.java#L5566) | 5566–5583 | `dg.a(Ljava/lang/String;IIIII)V` | `reference_proposal` |
| [`public static final void startLanterns(int value, int value1)`](../source/src/main/java/nso/GameScr.java#L5585) | 5585–5587 | `dg.a(II)V` | `reference_proposal` |
| [`public static final boolean startSplash(int x, int y, int dir)`](../source/src/main/java/nso/GameScr.java#L5589) | 5589–5599 | `dg.a(III)Z` | `reference_proposal` |
| [`private void loadCmdBar()`](../source/src/main/java/nso/GameScr.java#L5601) | 5601–5624 | `dg.at()V` | `reference_proposal` |
| [`private void loadInforBar()`](../source/src/main/java/nso/GameScr.java#L5626) | 5626–5643 | `dg.au()V` | `reference_proposal` |
| [`private void paintTrangbi(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L5645) | 5645–5902 | `dg.k(Lt;)V` | `reference_proposal` |
| [`private void paintThuCuoi(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L5904) | 5904–6085 | `dg.l(Lt;)V` | `reference_proposal` |
| [`private void paintClanInfo(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L6087) | 6087–6289 | `dg.m(Lt;)V` | `reference_proposal` |
| [`private static void paintNumCount(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L6291) | 6291–6301 | `dg.n(Lt;)V` | `reference_proposal` |
| [`private void updateKeyUIInforMe()`](../source/src/main/java/nso/GameScr.java#L6303) | 6303–6834 | `dg.av()V` | `reference_proposal` |
| [`private static Member curMemberSelected()`](../source/src/main/java/nso/GameScr.java#L6836) | 6836–6838 | `dg.aw()Lbn;` | `reference_proposal` |
| [`private void setClanComand()`](../source/src/main/java/nso/GameScr.java#L6840) | 6840–6888 | `dg.ax()V` | `reference_proposal` |
| [`private void updateKeyAlert()`](../source/src/main/java/nso/GameScr.java#L6890) | 6890–6956 | `dg.ay()V` | `reference_proposal` |
| [`private void updateKeyMessage()`](../source/src/main/java/nso/GameScr.java#L6958) | 6958–6982 | `dg.az()V` | `reference_proposal` |
| [`private void setCharFocusCommand()`](../source/src/main/java/nso/GameScr.java#L6984) | 6984–6995 | `dg.aA()V` | `reference_proposal` |
| [`private void setRankedListCommand()`](../source/src/main/java/nso/GameScr.java#L6997) | 6997–7005 | `dg.aB()V` | `reference_proposal` |
| [`private void setDunListCommand()`](../source/src/main/java/nso/GameScr.java#L7007) | 7007–7013 | `dg.aC()V` | `reference_proposal` |
| [`private void setEnemiesCommand()`](../source/src/main/java/nso/GameScr.java#L7015) | 7015–7021 | `dg.aD()V` | `reference_proposal` |
| [`private void setFriendCommand()`](../source/src/main/java/nso/GameScr.java#L7023) | 7023–7030 | `dg.aE()V` | `reference_proposal` |
| [`private void setPartyCommand()`](../source/src/main/java/nso/GameScr.java#L7032) | 7032–7048 | `dg.aF()V` | `reference_proposal` |
| [`private static boolean isPaintPopup()`](../source/src/main/java/nso/GameScr.java#L7050) | 7050–7052 | `dg.aG()Z` | `reference_proposal` |
| [`private boolean isNotPaintTouchControl()`](../source/src/main/java/nso/GameScr.java#L7054) | 7054–7062 | `dg.aH()Z` | `reference_proposal` |
| [`public static boolean isPaintUI()`](../source/src/main/java/nso/GameScr.java#L7064) | 7064–7066 | `dg.A()Z` | `reference_proposal` |
| [`private static boolean isOpenUI()`](../source/src/main/java/nso/GameScr.java#L7068) | 7068–7070 | `dg.aI()Z` | `reference_proposal` |
| [`private static boolean isSmallUI()`](../source/src/main/java/nso/GameScr.java#L7072) | 7072–7074 | `dg.aJ()Z` | `reference_proposal` |
| [`private static void actionBuy(Item item)`](../source/src/main/java/nso/GameScr.java#L7076) | 7076–7079 | `dg.a(Lby;)V` | `reference_proposal` |
| [`private static void actionSale(Item item)`](../source/src/main/java/nso/GameScr.java#L7081) | 7081–7088 | `dg.b(Lby;)V` | `reference_proposal` |
| [`private static void actionCoinOut()`](../source/src/main/java/nso/GameScr.java#L7090) | 7090–7093 | `dg.aK()V` | `reference_proposal` |
| [`private static void actionCoinTrade()`](../source/src/main/java/nso/GameScr.java#L7095) | 7095–7098 | `dg.aL()V` | `reference_proposal` |
| [`private static void actionCoinIn()`](../source/src/main/java/nso/GameScr.java#L7100) | 7100–7103 | `dg.aM()V` | `reference_proposal` |
| [`public final void updateKeyBuyItemUI()`](../source/src/main/java/nso/GameScr.java#L7105) | 7105–7974 | `dg.B()V` | `reference_proposal` |
| [`private static int getMaxIndexForCurrentStore()`](../source/src/main/java/nso/GameScr.java#L7976) | 7976–8143 | `dg.aN()I` | `reference_proposal` |
| [`private static void getCurrentStoreData()`](../source/src/main/java/nso/GameScr.java#L8145) | 8145–8159 | `dg.aO()V` | `reference_proposal` |
| [`private void saleItem()`](../source/src/main/java/nso/GameScr.java#L8161) | 8161–8167 | `dg.aP()V` | `reference_proposal` |
| [`public final void updateCommandForUI()`](../source/src/main/java/nso/GameScr.java#L8169) | 8169–9107 | `dg.C()V` | `reference_proposal` |
| [`public static void setPopupSize(int w, int h)`](../source/src/main/java/nso/GameScr.java#L9109) | 9109–9134 | `dg.b(II)V` | `reference_proposal` |
| [`private void paintSkillInfo(mGraphics g, Skill skill)`](../source/src/main/java/nso/GameScr.java#L9136) | 9136–9160 | `dg.a(Lt;Lz;)V` | `reference_proposal` |
| [`private void paintSkillOption(mGraphics g, Skill skill)`](../source/src/main/java/nso/GameScr.java#L9162) | 9162–9177 | `dg.b(Lt;Lz;)V` | `reference_proposal` |
| [`private void paintKyNang(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L9179) | 9179–9267 | `dg.o(Lt;)V` | `reference_proposal` |
| [`private void paintBag(mGraphics g, String[] titles)`](../source/src/main/java/nso/GameScr.java#L9269) | 9269–9277 | `dg.a(Lt;[Ljava/lang/String;)V` | `reference_proposal` |
| [`private void paintBagItem(mGraphics g, Item[] items)`](../source/src/main/java/nso/GameScr.java#L9279) | 9279–9308 | `dg.a(Lt;[Lby;)V` | `reference_proposal` |
| [`private static void paintSelectHighlight(int value, int value1, mGraphics graphics)`](../source/src/main/java/nso/GameScr.java#L9310) | 9310–9312 | `dg.a(IILt;)V` | `reference_proposal` |
| [`private static int upgradeEffectY(int value)`](../source/src/main/java/nso/GameScr.java#L9314) | 9314–9323 | `dg.i(I)I` | `reference_proposal` |
| [`private static int upgradeEffectX(int value)`](../source/src/main/java/nso/GameScr.java#L9325) | 9325–9334 | `dg.j(I)I` | `reference_proposal` |
| [`private void paintShopOnline(mGraphics g, Item[] items)`](../source/src/main/java/nso/GameScr.java#L9336) | 9336–9409 | `dg.b(Lt;[Lby;)V` | `reference_proposal` |
| [`private void paintItemList(mGraphics g, String[] titles, Item[] items)`](../source/src/main/java/nso/GameScr.java#L9411) | 9411–9465 | `dg.a(Lt;[Ljava/lang/String;[Lby;)V` | `reference_proposal` |
| [`private void paintItemFrame(mGraphics g, String[] titles, boolean paintMoney)`](../source/src/main/java/nso/GameScr.java#L9467) | 9467–9493 | `dg.a(Lt;[Ljava/lang/String;Z)V` | `reference_proposal` |
| [`private void paintItem(mGraphics g, Item item, int x, int y)`](../source/src/main/java/nso/GameScr.java#L9495) | 9495–9497 | `dg.a(Lt;Lby;II)V` | `reference_proposal` |
| [`private void paintItem(mGraphics g, Item item, int x, int y, int dUpgrade, int dR)`](../source/src/main/java/nso/GameScr.java#L9499) | 9499–9568 | `dg.a(Lt;Lby;IIII)V` | `reference_proposal` |
| [`private static void paintItemBackground(mGraphics g, Item item, int x, int y, int dR)`](../source/src/main/java/nso/GameScr.java#L9570) | 9570–9578 | `dg.a(Lt;Lby;III)V` | `reference_proposal` |
| [`private void paintSplit(mGraphics g, String[] titles)`](../source/src/main/java/nso/GameScr.java#L9580) | 9580–9655 | `dg.b(Lt;[Ljava/lang/String;)V` | `reference_proposal` |
| [`private void paintUpPearl(mGraphics g, String[] titles)`](../source/src/main/java/nso/GameScr.java#L9657) | 9657–9759 | `dg.c(Lt;[Ljava/lang/String;)V` | `reference_proposal` |
| [`private void paintUILuckySprin(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L9761) | 9761–9858 | `dg.p(Lt;)V` | `reference_proposal` |
| [`private void paintThuoc(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L9860) | 9860–9870 | `dg.q(Lt;)V` | `reference_proposal` |
| [`private void paintThuocKhoa(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L9872) | 9872–9882 | `dg.r(Lt;)V` | `reference_proposal` |
| [`private void paintTaphoa(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L9884) | 9884–9894 | `dg.s(Lt;)V` | `reference_proposal` |
| [`private void paintTaphoakhoa(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L9896) | 9896–9906 | `dg.t(Lt;)V` | `reference_proposal` |
| [`private void paintCuonghoa(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L9908) | 9908–10118 | `dg.u(Lt;)V` | `reference_proposal` |
| [`private void paintGianHang(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L10120) | 10120–10173 | `dg.v(Lt;)V` | `reference_proposal` |
| [`private void paintChuyenHoa(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L10175) | 10175–10274 | `dg.w(Lt;)V` | `reference_proposal` |
| [`private void paintTachHT(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L10276) | 10276–10286 | `dg.x(Lt;)V` | `reference_proposal` |
| [`private void paintLuyenThu(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L10288) | 10288–10298 | `dg.y(Lt;)V` | `reference_proposal` |
| [`private void paintLuyenAo(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L10300) | 10300–10310 | `dg.z(Lt;)V` | `reference_proposal` |
| [`private void paintItemTrade(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L10312) | 10312–10488 | `dg.A(Lt;)V` | `reference_proposal` |
| [`private void paintGhepngoc(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L10490) | 10490–10500 | `dg.B(Lt;)V` | `reference_proposal` |
| [`private void paintLuyenThach(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L10502) | 10502–10512 | `dg.C(Lt;)V` | `reference_proposal` |
| [`private void paintRuong(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L10514) | 10514–10538 | `dg.D(Lt;)V` | `reference_proposal` |
| [`private void paintTiemNang(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L10540) | 10540–10576 | `dg.E(Lt;)V` | `reference_proposal` |
| [`private static Item getItemFocus(int typeUI)`](../source/src/main/java/nso/GameScr.java#L10578) | 10578–10752 | `dg.k(I)Lby;` | `reference_proposal` |
| [`public static void loadImg()`](../source/src/main/java/nso/GameScr.java#L10754) | 10754–10756 | `dg.D()V` | `reference_proposal` |
| [`private static void paintTitle(mGraphics g, String title, boolean arrow)`](../source/src/main/java/nso/GameScr.java#L10758) | 10758–10777 | `dg.a(Lt;Ljava/lang/String;Z)V` | `reference_proposal` |
| [`private void paintZone(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L10779) | 10779–10821 | `dg.F(Lt;)V` | `reference_proposal` |
| [`private static void upPearl()`](../source/src/main/java/nso/GameScr.java#L10823) | 10823–10878 | `dg.aQ()V` | `reference_proposal` |
| [`private static void doLuyenThach()`](../source/src/main/java/nso/GameScr.java#L10880) | 10880–10911 | `dg.aR()V` | `reference_proposal` |
| [`public static byte getTaskMapId()`](../source/src/main/java/nso/GameScr.java#L10913) | 10913–10935 | `dg.E()B` | `reference_proposal` |
| [`public static byte getTaskNpcId()`](../source/src/main/java/nso/GameScr.java#L10937) | 10937–10963 | `dg.F()B` | `reference_proposal` |
| [`private void upGrade()`](../source/src/main/java/nso/GameScr.java#L10965) | 10965–11003 | `dg.aS()V` | `reference_proposal` |
| [`public static void doUpgrade()`](../source/src/main/java/nso/GameScr.java#L11005) | 11005–11011 | `dg.G()V` | `reference_proposal` |
| [`private static void split()`](../source/src/main/java/nso/GameScr.java#L11013) | 11013–11053 | `dg.aT()V` | `reference_proposal` |
| [`private void updateItemInfo(int typeUI, Item item, Command left, Command right)`](../source/src/main/java/nso/GameScr.java#L11055) | 11055–11060 | `dg.a(ILby;Lbd;Lbd;)V` | `reference_proposal` |
| [`private void updateItemInfo(int typeUI, Item item)`](../source/src/main/java/nso/GameScr.java#L11062) | 11062–11096 | `dg.a(ILby;)V` | `reference_proposal` |
| [`public final void showAlert(String title, String str, boolean withMenuShow)`](../source/src/main/java/nso/GameScr.java#L11098) | 11098–11111 | `dg.a(Ljava/lang/String;Ljava/lang/String;Z)V` | `reference_proposal` |
| [`public final void doCloseAlert()`](../source/src/main/java/nso/GameScr.java#L11113) | 11113–11119 | `dg.H()V` | `reference_proposal` |
| [`public final void scrollDownAlert()`](../source/src/main/java/nso/GameScr.java#L11121) | 11121–11126 | `dg.I()V` | `reference_proposal` |
| [`private void paintAlert(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L11128) | 11128–11186 | `dg.G(Lt;)V` | `reference_proposal` |
| [`private void paintFindTeam(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L11188) | 11188–11222 | `dg.H(Lt;)V` | `reference_proposal` |
| [`private void paintTeam(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L11224) | 11224–11264 | `dg.I(Lt;)V` | `reference_proposal` |
| [`private void PaintAuctionBuy(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L11266) | 11266–11339 | `dg.J(Lt;)V` | `reference_proposal` |
| [`private void paintFriend(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L11341) | 11341–11401 | `dg.K(Lt;)V` | `reference_proposal` |
| [`private void paintTask(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L11403) | 11403–11580 | `dg.L(Lt;)V` | `reference_proposal` |
| [`private static String[] splitMultiLine(mFont font, String text)`](../source/src/main/java/nso/GameScr.java#L11582) | 11582–11584 | `dg.a(Ldd;Ljava/lang/String;)[Ljava/lang/String;` | `reference_proposal` |
| [`private void paintMultiLine(mGraphics g, mFont f, String[] arr, int x, int y, int align)`](../source/src/main/java/nso/GameScr.java#L11586) | 11586–11615 | `dg.a(Lt;Ldd;[Ljava/lang/String;III)V` | `reference_proposal` |
| [`private void paintMultiLine(mGraphics g, mFont f, String str, int x, int y, int align)`](../source/src/main/java/nso/GameScr.java#L11617) | 11617–11640 | `dg.a(Lt;Ldd;Ljava/lang/String;III)V` | `reference_proposal` |
| [`private void paintMultiLine(mGraphics g, mFont f, String str, int x, int y, int align, int width)`](../source/src/main/java/nso/GameScr.java#L11642) | 11642–11660 | `dg.a(Lt;Ldd;Ljava/lang/String;IIII)V` | `reference_proposal` |
| [`private void paintItemInfo(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L11662) | 11662–12087 | `dg.M(Lt;)V` | `reference_proposal` |
| [`private static void paintInforFrame(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L12089) | 12089–12097 | `dg.N(Lt;)V` | `reference_proposal` |
| [`private static void setInfoFrameForLargeScreen()`](../source/src/main/java/nso/GameScr.java#L12099) | 12099–12122 | `dg.aU()V` | `reference_proposal` |
| [`public final void setLCR()`](../source/src/main/java/nso/GameScr.java#L12124) | 12124–12258 | `dg.J()V` | `reference_proposal` |
| [`public final void doOpenUI(int typeUI)`](../source/src/main/java/nso/GameScr.java#L12260) | 12260–12581 | `dg.d(I)V` | `reference_proposal` |
| [`public static Char findCharInMap(int charId)`](../source/src/main/java/nso/GameScr.java#L12583) | 12583–12591 | `dg.e(I)Lbp;` | `reference_proposal` |
| [`public static BuNhin findBuNhinInMap(int index)`](../source/src/main/java/nso/GameScr.java#L12593) | 12593–12595 | `dg.f(I)Ldk;` | `reference_proposal` |
| [`public final void onChatFromMe(String text, String to)`](../source/src/main/java/nso/GameScr.java#L12597) | 12597–12624 | `dg.a(Ljava/lang/String;Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void onCancelChat()`](../source/src/main/java/nso/GameScr.java#L12626) | 12626–12632 | `dg.K()V` | `reference_proposal` |
| [`private void indexPointer(int x, int y, int numCols, int numRows, int title)`](../source/src/main/java/nso/GameScr.java#L12634) | 12634–12658 | `dg.a(IIIII)V` | `reference_proposal` |
| [`public final void actionPerform(int idAction, Object p)`](../source/src/main/java/nso/GameScr.java#L12660) | 12660–14227 | `dg.b(ILjava/lang/Object;)V` | `reference_proposal` |
| [`private void actDichChuyenTrangBiLeft()`](../source/src/main/java/nso/GameScr.java#L14229) | 14229–14265 | `dg.aV()V` | `reference_proposal` |
| [`private void actTinhLuyenMoveOut()`](../source/src/main/java/nso/GameScr.java#L14267) | 14267–14273 | `dg.aW()V` | `reference_proposal` |
| [`private static void doAutoSelect()`](../source/src/main/java/nso/GameScr.java#L14275) | 14275–14329 | `dg.aX()V` | `reference_proposal` |
| [`private void doviewCardsInfo()`](../source/src/main/java/nso/GameScr.java#L14331) | 14331–14337 | `dg.aY()V` | `reference_proposal` |
| [`private void sortItemStand()`](../source/src/main/java/nso/GameScr.java#L14339) | 14339–14379 | `dg.aZ()V` | `reference_proposal` |
| [`private static void domenuSortItemStand()`](../source/src/main/java/nso/GameScr.java#L14381) | 14381–14387 | `dg.ba()V` | `reference_proposal` |
| [`private static void domenuItemStand()`](../source/src/main/java/nso/GameScr.java#L14389) | 14389–14394 | `dg.bb()V` | `reference_proposal` |
| [`private void doStandToBag()`](../source/src/main/java/nso/GameScr.java#L14396) | 14396–14400 | `dg.bc()V` | `reference_proposal` |
| [`private static void doBagToStand()`](../source/src/main/java/nso/GameScr.java#L14402) | 14402–14417 | `dg.bd()V` | `reference_proposal` |
| [`private static void actClanStoreBuy()`](../source/src/main/java/nso/GameScr.java#L14419) | 14419–14424 | `dg.be()V` | `reference_proposal` |
| [`private static void domenuErrorAdim()`](../source/src/main/java/nso/GameScr.java#L14426) | 14426–14431 | `dg.bf()V` | `reference_proposal` |
| [`private void doShowErrorInput()`](../source/src/main/java/nso/GameScr.java#L14433) | 14433–14441 | `dg.bg()V` | `reference_proposal` |
| [`public static void actRemoveWaitAcceptFriend(String strFWname)`](../source/src/main/java/nso/GameScr.java#L14443) | 14443–14457 | `dg.a(Ljava/lang/String;)V` | `reference_proposal` |
| [`private static void domenuClanConfig()`](../source/src/main/java/nso/GameScr.java#L14459) | 14459–14464 | `dg.bh()V` | `reference_proposal` |
| [`private static void domenuEnemieLeft()`](../source/src/main/java/nso/GameScr.java#L14466) | 14466–14470 | `dg.bi()V` | `reference_proposal` |
| [`private static void domenuFriendLeft()`](../source/src/main/java/nso/GameScr.java#L14472) | 14472–14477 | `dg.bj()V` | `reference_proposal` |
| [`private static void domenuPrivateLock()`](../source/src/main/java/nso/GameScr.java#L14479) | 14479–14491 | `dg.bk()V` | `reference_proposal` |
| [`private static void domenuTeamLeft()`](../source/src/main/java/nso/GameScr.java#L14493) | 14493–14498 | `dg.bl()V` | `reference_proposal` |
| [`private static void Convert()`](../source/src/main/java/nso/GameScr.java#L14500) | 14500–14503 | `dg.bm()V` | `reference_proposal` |
| [`private static void domenuClanNotice()`](../source/src/main/java/nso/GameScr.java#L14505) | 14505–14519 | `dg.bn()V` | `reference_proposal` |
| [`private static void domenuFindTeamCenter()`](../source/src/main/java/nso/GameScr.java#L14521) | 14521–14530 | `dg.bo()V` | `reference_proposal` |
| [`private static void domenuFindTeam()`](../source/src/main/java/nso/GameScr.java#L14532) | 14532–14539 | `dg.bp()V` | `reference_proposal` |
| [`private static void domenuClanPermission()`](../source/src/main/java/nso/GameScr.java#L14541) | 14541–14547 | `dg.bq()V` | `reference_proposal` |
| [`private void viewMemberClanInfo()`](../source/src/main/java/nso/GameScr.java#L14549) | 14549–14556 | `dg.br()V` | `reference_proposal` |
| [`private void domenuClanLeader()`](../source/src/main/java/nso/GameScr.java#L14558) | 14558–14592 | `dg.bs()V` | `reference_proposal` |
| [`private static boolean isHaveVanBienLenh()`](../source/src/main/java/nso/GameScr.java#L14594) | 14594–14602 | `dg.bt()Z` | `reference_proposal` |
| [`private static void actSetClanCommand(String mName)`](../source/src/main/java/nso/GameScr.java#L14604) | 14604–14612 | `dg.b(Ljava/lang/String;)V` | `reference_proposal` |
| [`private void doShowClan()`](../source/src/main/java/nso/GameScr.java#L14614) | 14614–14623 | `dg.bu()V` | `reference_proposal` |
| [`private static void domenuClan()`](../source/src/main/java/nso/GameScr.java#L14625) | 14625–14633 | `dg.bv()V` | `reference_proposal` |
| [`private void doUnfocusChar()`](../source/src/main/java/nso/GameScr.java#L14635) | 14635–14641 | `dg.bw()V` | `reference_proposal` |
| [`private void doCharFocusList()`](../source/src/main/java/nso/GameScr.java#L14643) | 14643–14656 | `dg.bx()V` | `reference_proposal` |
| [`private void changeTaskInfo()`](../source/src/main/java/nso/GameScr.java#L14658) | 14658–14666 | `dg.by()V` | `reference_proposal` |
| [`private static void viewMemberInfo()`](../source/src/main/java/nso/GameScr.java#L14668) | 14668–14675 | `dg.bz()V` | `reference_proposal` |
| [`private static void actBuyItemLeft2()`](../source/src/main/java/nso/GameScr.java#L14677) | 14677–14682 | `dg.bA()V` | `reference_proposal` |
| [`private static void actBuyItemUILeft()`](../source/src/main/java/nso/GameScr.java#L14684) | 14684–14689 | `dg.bB()V` | `reference_proposal` |
| [`private void actgetLuyenThachItems()`](../source/src/main/java/nso/GameScr.java#L14691) | 14691–14741 | `dg.bC()V` | `reference_proposal` |
| [`private void actUpPearlItems()`](../source/src/main/java/nso/GameScr.java#L14743) | 14743–14762 | `dg.bD()V` | `reference_proposal` |
| [`private void actUpPearlMoveOut()`](../source/src/main/java/nso/GameScr.java#L14764) | 14764–14770 | `dg.bE()V` | `reference_proposal` |
| [`private static void actLuyenThachSelect()`](../source/src/main/java/nso/GameScr.java#L14772) | 14772–14782 | `dg.bF()V` | `reference_proposal` |
| [`private static void actUpPearlSelect()`](../source/src/main/java/nso/GameScr.java#L14784) | 14784–14794 | `dg.bG()V` | `reference_proposal` |
| [`private void actSplitItemBag()`](../source/src/main/java/nso/GameScr.java#L14796) | 14796–14892 | `dg.bH()V` | `reference_proposal` |
| [`private void actSplitItem()`](../source/src/main/java/nso/GameScr.java#L14894) | 14894–14901 | `dg.bI()V` | `reference_proposal` |
| [`private void actUpgrade_HanhTrang()`](../source/src/main/java/nso/GameScr.java#L14903) | 14903–14957 | `dg.bJ()V` | `reference_proposal` |
| [`private void convert(int index)`](../source/src/main/java/nso/GameScr.java#L14959) | 14959–14971 | `dg.l(I)V` | `reference_proposal` |
| [`private void actConvert_HanhTrang()`](../source/src/main/java/nso/GameScr.java#L14973) | 14973–14987 | `dg.bK()V` | `reference_proposal` |
| [`private void actItemConvertMoveOut2()`](../source/src/main/java/nso/GameScr.java#L14989) | 14989–14996 | `dg.bL()V` | `reference_proposal` |
| [`private void actItemConvertMoveOut()`](../source/src/main/java/nso/GameScr.java#L14998) | 14998–15005 | `dg.bM()V` | `reference_proposal` |
| [`private void actItemUpgradeMoveOut()`](../source/src/main/java/nso/GameScr.java#L15007) | 15007–15013 | `dg.bN()V` | `reference_proposal` |
| [`private static void actUpgradeBag()`](../source/src/main/java/nso/GameScr.java#L15015) | 15015–15027 | `dg.bO()V` | `reference_proposal` |
| [`private void actConvertLeft()`](../source/src/main/java/nso/GameScr.java#L15029) | 15029–15042 | `dg.bP()V` | `reference_proposal` |
| [`private void actUpgradeLeft()`](../source/src/main/java/nso/GameScr.java#L15044) | 15044–15054 | `dg.bQ()V` | `reference_proposal` |
| [`private static void actBuyLeft(Item itemBuy)`](../source/src/main/java/nso/GameScr.java#L15056) | 15056–15061 | `dg.c(Lby;)V` | `reference_proposal` |
| [`private static void actTrangBiCenter()`](../source/src/main/java/nso/GameScr.java#L15063) | 15063–15071 | `dg.bR()V` | `reference_proposal` |
| [`private void actTrangBiRight()`](../source/src/main/java/nso/GameScr.java#L15073) | 15073–15082 | `dg.bS()V` | `reference_proposal` |
| [`private static void actBuyQuanNam()`](../source/src/main/java/nso/GameScr.java#L15084) | 15084–15089 | `dg.bT()V` | `reference_proposal` |
| [`private static void actdoUpPoint()`](../source/src/main/java/nso/GameScr.java#L15091) | 15091–15096 | `dg.bU()V` | `reference_proposal` |
| [`private static void actTrangBiSelect()`](../source/src/main/java/nso/GameScr.java#L15098) | 15098–15109 | `dg.bV()V` | `reference_proposal` |
| [`private static void actdoGan()`](../source/src/main/java/nso/GameScr.java#L15111) | 15111–15116 | `dg.bW()V` | `reference_proposal` |
| [`private static void actSetPartyCommand(String partyName)`](../source/src/main/java/nso/GameScr.java#L15118) | 15118–15126 | `dg.c(Ljava/lang/String;)V` | `reference_proposal` |
| [`private static void actdoKyNang()`](../source/src/main/java/nso/GameScr.java#L15128) | 15128–15133 | `dg.bX()V` | `reference_proposal` |
| [`private static void actSetDeleteFriend(String friendName)`](../source/src/main/java/nso/GameScr.java#L15135) | 15135–15137 | `dg.d(Ljava/lang/String;)V` | `reference_proposal` |
| [`private static void actSetFriendCommand()`](../source/src/main/java/nso/GameScr.java#L15139) | 15139–15153 | `dg.bY()V` | `reference_proposal` |
| [`private void actSetRankedListCommand(byte index)`](../source/src/main/java/nso/GameScr.java#L15155) | 15155–15171 | `dg.a(B)V` | `reference_proposal` |
| [`private static void actSetDunListCommand()`](../source/src/main/java/nso/GameScr.java#L15173) | 15173–15178 | `dg.bZ()V` | `reference_proposal` |
| [`private static void actSetEnemiesCommand()`](../source/src/main/java/nso/GameScr.java#L15180) | 15180–15189 | `dg.ca()V` | `reference_proposal` |
| [`private static void actConfirmRemoveFriend(String strFriendNameDel)`](../source/src/main/java/nso/GameScr.java#L15191) | 15191–15193 | `dg.e(Ljava/lang/String;)V` | `reference_proposal` |
| [`private void actSendSMSRight()`](../source/src/main/java/nso/GameScr.java#L15195) | 15195–15201 | `dg.cb()V` | `reference_proposal` |
| [`private void actSendSMSLeft(short port, String syntax)`](../source/src/main/java/nso/GameScr.java#L15203) | 15203–15210 | `dg.a(SLjava/lang/String;)V` | `reference_proposal` |
| [`private static void actSaleItem()`](../source/src/main/java/nso/GameScr.java#L15212) | 15212–15218 | `dg.cc()V` | `reference_proposal` |
| [`private static void actRefresh_TeamLeader(Party pt)`](../source/src/main/java/nso/GameScr.java#L15220) | 15220–15229 | `dg.a(Ldb;)V` | `reference_proposal` |
| [`private void actOpenWebCancel()`](../source/src/main/java/nso/GameScr.java#L15231) | 15231–15237 | `dg.cd()V` | `reference_proposal` |
| [`private void actOpenWeb(String url)`](../source/src/main/java/nso/GameScr.java#L15239) | 15239–15246 | `dg.f(Ljava/lang/String;)V` | `reference_proposal` |
| [`private static void actConfirmUpgrade()`](../source/src/main/java/nso/GameScr.java#L15248) | 15248–15251 | `dg.ce()V` | `reference_proposal` |
| [`private static void actSaleConfirm(Item item)`](../source/src/main/java/nso/GameScr.java#L15253) | 15253–15256 | `dg.d(Lby;)V` | `reference_proposal` |
| [`private void actdoMiniInfo()`](../source/src/main/java/nso/GameScr.java#L15258) | 15258–15265 | `dg.cf()V` | `reference_proposal` |
| [`private void actdoChooseSkill()`](../source/src/main/java/nso/GameScr.java#L15267) | 15267–15272 | `dg.cg()V` | `reference_proposal` |
| [`private static void doActionSaleOk(Item item)`](../source/src/main/java/nso/GameScr.java#L15274) | 15274–15293 | `dg.e(Lby;)V` | `reference_proposal` |
| [`private static void doActionBuy(Item item)`](../source/src/main/java/nso/GameScr.java#L15295) | 15295–15316 | `dg.f(Lby;)V` | `reference_proposal` |
| [`private void doOpenUIZone()`](../source/src/main/java/nso/GameScr.java#L15318) | 15318–15323 | `dg.ch()V` | `reference_proposal` |
| [`private static void doItemChangeMap(Item itemBag)`](../source/src/main/java/nso/GameScr.java#L15325) | 15325–15331 | `dg.g(Lby;)V` | `reference_proposal` |
| [`private static void doShowBlockMessageMenu()`](../source/src/main/java/nso/GameScr.java#L15333) | 15333–15338 | `dg.ci()V` | `reference_proposal` |
| [`private static void doShowListChatTab()`](../source/src/main/java/nso/GameScr.java#L15340) | 15340–15350 | `dg.cj()V` | `reference_proposal` |
| [`private void openUIChatTab()`](../source/src/main/java/nso/GameScr.java#L15352) | 15352–15382 | `dg.ck()V` | `reference_proposal` |
| [`private void doShowChatTextFieldInMessage()`](../source/src/main/java/nso/GameScr.java#L15384) | 15384–15401 | `dg.cl()V` | `reference_proposal` |
| [`private void actOpenAlertURL()`](../source/src/main/java/nso/GameScr.java#L15403) | 15403–15409 | `dg.cm()V` | `reference_proposal` |
| [`private static void actUseItem()`](../source/src/main/java/nso/GameScr.java#L15411) | 15411–15414 | `dg.cn()V` | `reference_proposal` |
| [`private static void actBoxSort()`](../source/src/main/java/nso/GameScr.java#L15416) | 15416–15418 | `dg.co()V` | `reference_proposal` |
| [`private static void actCreateTeam()`](../source/src/main/java/nso/GameScr.java#L15420) | 15420–15422 | `dg.cp()V` | `reference_proposal` |
| [`private static void actRefreshFindTeam()`](../source/src/main/java/nso/GameScr.java#L15424) | 15424–15427 | `dg.cq()V` | `reference_proposal` |
| [`private static void actInputTeam()`](../source/src/main/java/nso/GameScr.java#L15429) | 15429–15434 | `dg.cr()V` | `reference_proposal` |
| [`private static void actsubMenuOrder_PK(int value)`](../source/src/main/java/nso/GameScr.java#L15436) | 15436–15447 | `dg.m(I)V` | `reference_proposal` |
| [`private static void actCoinIn()`](../source/src/main/java/nso/GameScr.java#L15449) | 15449–15470 | `dg.cs()V` | `reference_proposal` |
| [`private void actionCoinTradeAccept()`](../source/src/main/java/nso/GameScr.java#L15472) | 15472–15494 | `dg.ct()V` | `reference_proposal` |
| [`private static void actCoinOut()`](../source/src/main/java/nso/GameScr.java#L15496) | 15496–15517 | `dg.cu()V` | `reference_proposal` |
| [`private static void actsubMenuOrder()`](../source/src/main/java/nso/GameScr.java#L15519) | 15519–15525 | `dg.cv()V` | `reference_proposal` |
| [`private static void actOrder()`](../source/src/main/java/nso/GameScr.java#L15527) | 15527–15536 | `dg.cw()V` | `reference_proposal` |
| [`private void actrightItemInfo()`](../source/src/main/java/nso/GameScr.java#L15538) | 15538–15543 | `dg.cx()V` | `reference_proposal` |
| [`private void actleftItemInfo()`](../source/src/main/java/nso/GameScr.java#L15545) | 15545–15550 | `dg.cy()V` | `reference_proposal` |
| [`private void actmenuAttack(int idAction)`](../source/src/main/java/nso/GameScr.java#L15552) | 15552–15588 | `dg.n(I)V` | `reference_proposal` |
| [`public final void doRescuedOtherChar(int charID)`](../source/src/main/java/nso/GameScr.java#L15590) | 15590–15600 | `dg.g(I)V` | `reference_proposal` |
| [`private static void actMenu41()`](../source/src/main/java/nso/GameScr.java#L15602) | 15602–15611 | `dg.cz()V` | `reference_proposal` |
| [`private static void actMenu4()`](../source/src/main/java/nso/GameScr.java#L15613) | 15613–15615 | `dg.cA()V` | `reference_proposal` |
| [`private static void actDead()`](../source/src/main/java/nso/GameScr.java#L15617) | 15617–15623 | `dg.cB()V` | `reference_proposal` |
| [`private static void actBagSortItem()`](../source/src/main/java/nso/GameScr.java#L15625) | 15625–15627 | `dg.cC()V` | `reference_proposal` |
| [`private void actTradeMoveOut()`](../source/src/main/java/nso/GameScr.java#L15629) | 15629–15635 | `dg.cD()V` | `reference_proposal` |
| [`private void actSplitMoveOut()`](../source/src/main/java/nso/GameScr.java#L15637) | 15637–15648 | `dg.cE()V` | `reference_proposal` |
| [`private void actUpgradeMoveOut()`](../source/src/main/java/nso/GameScr.java#L15650) | 15650–15656 | `dg.cF()V` | `reference_proposal` |
| [`private void actConvertMoveOut()`](../source/src/main/java/nso/GameScr.java#L15658) | 15658–15664 | `dg.cG()V` | `reference_proposal` |
| [`private void actTradeAccept()`](../source/src/main/java/nso/GameScr.java#L15666) | 15666–15672 | `dg.cH()V` | `reference_proposal` |
| [`private void actTradeLock()`](../source/src/main/java/nso/GameScr.java#L15674) | 15674–15681 | `dg.cI()V` | `reference_proposal` |
| [`private void actTradeViewItemInfo()`](../source/src/main/java/nso/GameScr.java#L15683) | 15683–15686 | `dg.cJ()V` | `reference_proposal` |
| [`private void actTradeSelectItem()`](../source/src/main/java/nso/GameScr.java#L15688) | 15688–15707 | `dg.cK()V` | `reference_proposal` |
| [`private void actTradeSelectInBag()`](../source/src/main/java/nso/GameScr.java#L15709) | 15709–15714 | `dg.cL()V` | `reference_proposal` |
| [`private void actTradeSelectInList()`](../source/src/main/java/nso/GameScr.java#L15716) | 15716–15725 | `dg.cM()V` | `reference_proposal` |
| [`private static void actBagUseItem()`](../source/src/main/java/nso/GameScr.java#L15727) | 15727–15759 | `dg.cN()V` | `reference_proposal` |
| [`private static void actBagSplitItem()`](../source/src/main/java/nso/GameScr.java#L15761) | 15761–15765 | `dg.cO()V` | `reference_proposal` |
| [`private static void actBagThrowItem()`](../source/src/main/java/nso/GameScr.java#L15767) | 15767–15775 | `dg.cP()V` | `reference_proposal` |
| [`private void actBagViewItemInfo()`](../source/src/main/java/nso/GameScr.java#L15777) | 15777–15786 | `dg.cQ()V` | `reference_proposal` |
| [`private void actBagSelectItem()`](../source/src/main/java/nso/GameScr.java#L15788) | 15788–15797 | `dg.cR()V` | `reference_proposal` |
| [`private static void actEliteShopBuy()`](../source/src/main/java/nso/GameScr.java#L15799) | 15799–15804 | `dg.cS()V` | `reference_proposal` |
| [`private static void actStoreBuy()`](../source/src/main/java/nso/GameScr.java#L15806) | 15806–15811 | `dg.cT()V` | `reference_proposal` |
| [`private static void actStoreLockBuy()`](../source/src/main/java/nso/GameScr.java#L15813) | 15813–15818 | `dg.cU()V` | `reference_proposal` |
| [`private static void actStoreFashionBuy()`](../source/src/main/java/nso/GameScr.java#L15820) | 15820–15825 | `dg.cV()V` | `reference_proposal` |
| [`private static void actNonNamBuy()`](../source/src/main/java/nso/GameScr.java#L15827) | 15827–15832 | `dg.cW()V` | `reference_proposal` |
| [`private static void actNonNuBuy()`](../source/src/main/java/nso/GameScr.java#L15834) | 15834–15839 | `dg.cX()V` | `reference_proposal` |
| [`private static void actAoNamBuy()`](../source/src/main/java/nso/GameScr.java#L15841) | 15841–15846 | `dg.cY()V` | `reference_proposal` |
| [`private static void actAoNuBuy()`](../source/src/main/java/nso/GameScr.java#L15848) | 15848–15853 | `dg.cZ()V` | `reference_proposal` |
| [`private static void actGangTayNamBuy()`](../source/src/main/java/nso/GameScr.java#L15855) | 15855–15860 | `dg.da()V` | `reference_proposal` |
| [`private static void actGangTayNuBuy()`](../source/src/main/java/nso/GameScr.java#L15862) | 15862–15867 | `dg.db()V` | `reference_proposal` |
| [`private static void actBuy(byte itembuy)`](../source/src/main/java/nso/GameScr.java#L15869) | 15869–15872 | `dg.b(B)V` | `reference_proposal` |
| [`private void actBuys(byte byteValue)`](../source/src/main/java/nso/GameScr.java#L15874) | 15874–15876 | `dg.c(B)V` | `reference_proposal` |
| [`private void actView(byte itemview)`](../source/src/main/java/nso/GameScr.java#L15878) | 15878–15881 | `dg.d(B)V` | `reference_proposal` |
| [`private static void actAddPotential()`](../source/src/main/java/nso/GameScr.java#L15883) | 15883–15904 | `dg.dc()V` | `reference_proposal` |
| [`private static void actSkillUpPoint()`](../source/src/main/java/nso/GameScr.java#L15906) | 15906–15927 | `dg.dd()V` | `reference_proposal` |
| [`private static void actAddFriendAccept()`](../source/src/main/java/nso/GameScr.java#L15929) | 15929–15937 | `dg.de()V` | `reference_proposal` |
| [`public final void perform(int value, Object argument)`](../source/src/main/java/nso/GameScr.java#L15939) | 15939–15943 | `dg.a(ILjava/lang/Object;)V` | `reference_proposal` |
| [`public final void showViewInfo()`](../source/src/main/java/nso/GameScr.java#L15945) | 15945–15951 | `dg.L()V` | `reference_proposal` |
| [`public static void moveFast()`](../source/src/main/java/nso/GameScr.java#L15953) | 15953–15997 | `dg.M()V` | `reference_proposal` |
| [`private void paintListRanked(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L15999) | 15999–16040 | `dg.O(Lt;)V` | `reference_proposal` |
| [`private static void domenuLucky_Draw()`](../source/src/main/java/nso/GameScr.java#L16042) | 16042–16044 | `dg.df()V` | `reference_proposal` |
| [`private void luckyDraw_refresh()`](../source/src/main/java/nso/GameScr.java#L16046) | 16046–16049 | `dg.dg()V` | `reference_proposal` |
| [`private static void luckyDraw_Tf()`](../source/src/main/java/nso/GameScr.java#L16051) | 16051–16054 | `dg.dh()V` | `reference_proposal` |
| [`public final void showLucky_Draw(String title, short time, String totalMoney, short percentWin1, String percentWin2, short numPlayer, String winnerInfo, String myMoney, byte typeLucky)`](../source/src/main/java/nso/GameScr.java#L16056) | 16056–16080 | `dg.a(Ljava/lang/String;SLjava/lang/String;SLjava/lang/String;SLjava/lang/String;Ljava/lang/String;B)V` | `reference_proposal` |
| [`private static String getTimeCountDown(long timeStart, int secondCount)`](../source/src/main/java/nso/GameScr.java#L16082) | 16082–16091 | `dg.a(JI)Ljava/lang/String;` | `reference_proposal` |
| [`private void doCloseLucky_Draw()`](../source/src/main/java/nso/GameScr.java#L16093) | 16093–16101 | `dg.di()V` | `reference_proposal` |
| [`private void paintLucky_Draw(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L16103) | 16103–16201 | `dg.P(Lt;)V` | `reference_proposal` |
| [`public final void switchToMe()`](../source/src/main/java/nso/GameScr.java#L16203) | 16203–16205 | `dg.a()V` | `reference_proposal` |
| [`public final void resetCaptcha()`](../source/src/main/java/nso/GameScr.java#L16207) | 16207–16209 | `dg.N()V` | `reference_proposal` |
| [`private void updateKeyCaptcha()`](../source/src/main/java/nso/GameScr.java#L16211) | 16211–16224 | `dg.dj()V` | `reference_proposal` |
| [`private void doClickCaptcha(byte typeKey)`](../source/src/main/java/nso/GameScr.java#L16226) | 16226–16235 | `dg.e(B)V` | `reference_proposal` |
| [`private void paintThanThu_Clan(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L16237) | 16237–16327 | `dg.Q(Lt;)V` | `reference_proposal` |
| [`public final void addInfo_ThanThu(Clan_ThanThu thanthu)`](../source/src/main/java/nso/GameScr.java#L16329) | 16329–16331 | `dg.a(Lo;)V` | `reference_proposal` |
| [`public final void clearVecThanThu()`](../source/src/main/java/nso/GameScr.java#L16333) | 16333–16335 | `dg.O()V` | `reference_proposal` |
| [`private void actSplitItemBag_luyenngoc()`](../source/src/main/java/nso/GameScr.java#L16337) | 16337–16374 | `dg.dk()V` | `reference_proposal` |
| [`private void act_update_khamngoc()`](../source/src/main/java/nso/GameScr.java#L16376) | 16376–16430 | `dg.dl()V` | `reference_proposal` |
| [`private void setCMD_act_KhamNgoc(int type)`](../source/src/main/java/nso/GameScr.java#L16432) | 16432–16450 | `dg.o(I)V` | `reference_proposal` |
| [`private void actKhamNgocMoveOut(int i)`](../source/src/main/java/nso/GameScr.java#L16452) | 16452–16466 | `dg.p(I)V` | `reference_proposal` |
| [`private void khamngoc()`](../source/src/main/java/nso/GameScr.java#L16468) | 16468–16496 | `dg.dm()V` | `reference_proposal` |
| [`private static void actConfirmKhamNgoc()`](../source/src/main/java/nso/GameScr.java#L16498) | 16498–16503 | `dg.dn()V` | `reference_proposal` |
| [`private void paintLuyenNgoc(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L16505) | 16505–16630 | `dg.R(Lt;)V` | `reference_proposal` |
| [`private void paintCheDo(mGraphics graphics)`](../source/src/main/java/nso/GameScr.java#L16632) | 16632–16693 | `dg.S(Lt;)V` | `behavioral_name` |
| [`private void paintKhamNgoc(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L16695) | 16695–16837 | `dg.T(Lt;)V` | `reference_proposal` |
| [`private void paintGotNgoc(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L16839) | 16839–16849 | `dg.U(Lt;)V` | `reference_proposal` |
| [`private void paintThaoNgoc(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L16851) | 16851–16861 | `dg.V(Lt;)V` | `reference_proposal` |
| [`private void paintGotNgoc(mGraphics g, String[] titles, byte typemoney)`](../source/src/main/java/nso/GameScr.java#L16863) | 16863–16922 | `dg.a(Lt;[Ljava/lang/String;B)V` | `reference_proposal` |
| [`private static void actSplitItemBag_gotngoc()`](../source/src/main/java/nso/GameScr.java#L16924) | 16924–16942 | `dg.do()V` | `reference_proposal` |
| [`private void paintGiaoDo(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L16944) | 16944–17006 | `dg.W(Lt;)V` | `reference_proposal` |
| [`private void act_update_giaodo()`](../source/src/main/java/nso/GameScr.java#L17008) | 17008–17018 | `dg.dp()V` | `reference_proposal` |
| [`private void setCMD_act_GiaoDo()`](../source/src/main/java/nso/GameScr.java#L17020) | 17020–17032 | `dg.dq()V` | `reference_proposal` |
| [`private void actGiaoDoMoveOut()`](../source/src/main/java/nso/GameScr.java#L17034) | 17034–17040 | `dg.dr()V` | `reference_proposal` |
| [`private static void sendGiaoDo()`](../source/src/main/java/nso/GameScr.java#L17042) | 17042–17044 | `dg.ds()V` | `reference_proposal` |
| [`private void paintBijuu(mGraphics g)`](../source/src/main/java/nso/GameScr.java#L17046) | 17046–17125 | `dg.X(Lt;)V` | `reference_proposal` |
| [`private void actBijuuSelect()`](../source/src/main/java/nso/GameScr.java#L17127) | 17127–17143 | `dg.dt()V` | `reference_proposal` |
| [`private static void actBijuuMenuPoint()`](../source/src/main/java/nso/GameScr.java#L17145) | 17145–17150 | `dg.du()V` | `reference_proposal` |
| [`private void doBijuuUpPoint()`](../source/src/main/java/nso/GameScr.java#L17152) | 17152–17156 | `dg.dv()V` | `reference_proposal` |
| [`private static void actBijuuUpPoint()`](../source/src/main/java/nso/GameScr.java#L17158) | 17158–17179 | `dg.dw()V` | `reference_proposal` |
| [`private static void actBijuuKyNang()`](../source/src/main/java/nso/GameScr.java#L17181) | 17181–17186 | `dg.dx()V` | `reference_proposal` |
| [`private void doBijuuUpSkill()`](../source/src/main/java/nso/GameScr.java#L17188) | 17188–17192 | `dg.dy()V` | `reference_proposal` |
| [`private static void actBijSkillUpPoint()`](../source/src/main/java/nso/GameScr.java#L17194) | 17194–17215 | `dg.dz()V` | `reference_proposal` |

## nso.LanguageScr

Screen ngôn ngữ.

[Source](../source/src/main/java/nso/LanguageScr.java) · [Mapping](../mapping/classes/nso_LanguageScr.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsolanguagescr)

`public final class LanguageScr extends mScreen implements IActionListener`

Identity class: `l`; status: `reference_proposal`; source: **131 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public LanguageScr()`](../source/src/main/java/nso/LanguageScr.java#L18) | 18–19 | `l.<init>()V` | `preserved` |
| [`public final void switchToMe()`](../source/src/main/java/nso/LanguageScr.java#L21) | 21–59 | `l.a()V` | `reference_proposal` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/LanguageScr.java#L61) | 61–88 | `l.a(Lt;)V` | `reference_proposal` |
| [`public static void saveLanguageID(int languageID)`](../source/src/main/java/nso/LanguageScr.java#L90) | 90–92 | `l.a(I)V` | `reference_proposal` |
| [`public static int loadLanguageID()`](../source/src/main/java/nso/LanguageScr.java#L94) | 94–97 | `l.b()I` | `reference_proposal` |
| [`public final void update()`](../source/src/main/java/nso/LanguageScr.java#L99) | 99–104 | `l.c()V` | `reference_proposal` |
| [`public final void updateKey()`](../source/src/main/java/nso/LanguageScr.java#L106) | 106–118 | `l.d()V` | `reference_proposal` |
| [`public final void perform(int idAction, Object p)`](../source/src/main/java/nso/LanguageScr.java#L120) | 120–130 | `l.a(ILjava/lang/Object;)V` | `reference_proposal` |

## nso.LoginScr

Form đăng nhập, nhập liệu và các command liên quan.

[Source](../source/src/main/java/nso/LoginScr.java) · [Mapping](../mapping/classes/nso_LoginScr.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsologinscr)

`public final class LoginScr extends mScreen implements IActionListener`

Identity class: `dc`; status: `reference_proposal`; source: **591 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public final void switchToMe()`](../source/src/main/java/nso/LoginScr.java#L61) | 61–83 | `dc.a()V` | `reference_proposal` |
| [`public final void switchToMe(boolean isRes1)`](../source/src/main/java/nso/LoginScr.java#L85) | 85–103 | `dc.a(Z)V` | `reference_proposal` |
| [`public LoginScr()`](../source/src/main/java/nso/LoginScr.java#L105) | 105–191 | `dc.<init>()V` | `preserved` |
| [`public static LoginScr mgI()`](../source/src/main/java/nso/LoginScr.java#L193) | 193–195 | `dc.b()Ldc;` | `reference_proposal` |
| [`private static void doSetGPRS(boolean isGPRS)`](../source/src/main/java/nso/LoginScr.java#L197) | 197–200 | `dc.b(Z)V` | `reference_proposal` |
| [`private void doRegister(String user)`](../source/src/main/java/nso/LoginScr.java#L202) | 202–209 | `dc.a(Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void update()`](../source/src/main/java/nso/LoginScr.java#L211) | 211–262 | `dc.c()V` | `reference_proposal` |
| [`public final void keyPress(int keyCode)`](../source/src/main/java/nso/LoginScr.java#L264) | 264–275 | `dc.b(I)V` | `reference_proposal` |
| [`public final void unLoad()`](../source/src/main/java/nso/LoginScr.java#L277) | 277–279 | `dc.e()V` | `behavioral_name` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/LoginScr.java#L281) | 281–360 | `dc.a(Lt;)V` | `reference_proposal` |
| [`public final void updateKey()`](../source/src/main/java/nso/LoginScr.java#L362) | 362–424 | `dc.d()V` | `reference_proposal` |
| [`public final void perform(int idAction, Object p)`](../source/src/main/java/nso/LoginScr.java#L426) | 426–590 | `dc.a(ILjava/lang/Object;)V` | `reference_proposal` |

## nso.MapScr

Giao diện map.

[Source](../source/src/main/java/nso/MapScr.java) · [Mapping](../mapping/classes/nso_MapScr.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsomapscr)

`public final class MapScr extends mScreen implements IActionListener`

Identity class: `q`; status: `reference_proposal`; source: **466 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public MapScr()`](../source/src/main/java/nso/MapScr.java#L76) | 76–81 | `q.<init>()V` | `preserved` |
| [`private void resetCMLim()`](../source/src/main/java/nso/MapScr.java#L83) | 83–128 | `q.g()V` | `reference_proposal` |
| [`public static MapScr gI()`](../source/src/main/java/nso/MapScr.java#L130) | 130–135 | `q.b()Lq;` | `reference_proposal` |
| [`public final void switchToMe()`](../source/src/main/java/nso/MapScr.java#L137) | 137–176 | `q.a()V` | `reference_proposal` |
| [`public final void unLoad()`](../source/src/main/java/nso/MapScr.java#L178) | 178–200 | `q.e()V` | `reference_proposal` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/MapScr.java#L202) | 202–327 | `q.a(Lt;)V` | `reference_proposal` |
| [`public final void updateKey()`](../source/src/main/java/nso/MapScr.java#L329) | 329–430 | `q.d()V` | `reference_proposal` |
| [`private static void findMapNearestPoint()`](../source/src/main/java/nso/MapScr.java#L432) | 432–447 | `q.h()V` | `reference_proposal` |
| [`public final void perform(int idAction, Object p)`](../source/src/main/java/nso/MapScr.java#L449) | 449–465 | `q.a(ILjava/lang/Object;)V` | `reference_proposal` |

## nso.RegisterScr

Form đăng ký tài khoản.

[Source](../source/src/main/java/nso/RegisterScr.java) · [Mapping](../mapping/classes/nso_RegisterScr.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoregisterscr)

`public final class RegisterScr extends mScreen implements IActionListener`

Identity class: `ao`; status: `reference_proposal`; source: **156 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public RegisterScr()`](../source/src/main/java/nso/RegisterScr.java#L31) | 31–54 | `ao.<init>()V` | `preserved` |
| [`public final void update()`](../source/src/main/java/nso/RegisterScr.java#L56) | 56–76 | `ao.c()V` | `reference_proposal` |
| [`public final void keyPress(int keyCode)`](../source/src/main/java/nso/RegisterScr.java#L78) | 78–85 | `ao.b(I)V` | `reference_proposal` |
| [`public final void updateKey()`](../source/src/main/java/nso/RegisterScr.java#L87) | 87–120 | `ao.d()V` | `reference_proposal` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/RegisterScr.java#L122) | 122–141 | `ao.a(Lt;)V` | `reference_proposal` |
| [`public final void switchToMe()`](../source/src/main/java/nso/RegisterScr.java#L143) | 143–146 | `ao.a()V` | `reference_proposal` |
| [`public final void perform(int idAction, Object p)`](../source/src/main/java/nso/RegisterScr.java#L148) | 148–155 | `ao.a(ILjava/lang/Object;)V` | `reference_proposal` |

## nso.SelectCharScr

Màn chọn nhân vật.

[Source](../source/src/main/java/nso/SelectCharScr.java) · [Mapping](../mapping/classes/nso_SelectCharScr.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoselectcharscr)

`public final class SelectCharScr extends mScreen implements IActionListener`

Identity class: `u`; status: `reference_proposal`; source: **229 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public static SelectCharScr gI()`](../source/src/main/java/nso/SelectCharScr.java#L47) | 47–52 | `u.b()Lu;` | `reference_proposal` |
| [`public SelectCharScr()`](../source/src/main/java/nso/SelectCharScr.java#L54) | 54–87 | `u.<init>()V` | `preserved` |
| [`private void doSelect()`](../source/src/main/java/nso/SelectCharScr.java#L89) | 89–97 | `u.g()V` | `reference_proposal` |
| [`public final void updateKey()`](../source/src/main/java/nso/SelectCharScr.java#L99) | 99–132 | `u.d()V` | `reference_proposal` |
| [`public final void update()`](../source/src/main/java/nso/SelectCharScr.java#L134) | 134–144 | `u.c()V` | `reference_proposal` |
| [`public final void switchToMe()`](../source/src/main/java/nso/SelectCharScr.java#L146) | 146–159 | `u.a()V` | `reference_proposal` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/SelectCharScr.java#L161) | 161–217 | `u.a(Lt;)V` | `reference_proposal` |
| [`public final void perform(int idAction, Object p)`](../source/src/main/java/nso/SelectCharScr.java#L219) | 219–228 | `u.a(ILjava/lang/Object;)V` | `reference_proposal` |

## nso.SelectServerScr

Chọn server, đọc thông tin server và xử lý action.

[Source](../source/src/main/java/nso/SelectServerScr.java) · [Mapping](../mapping/classes/nso_SelectServerScr.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoselectserverscr)

`public final class SelectServerScr extends mScreen implements IActionListener`

Identity class: `co`; status: `reference_proposal`; source: **349 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public SelectServerScr()`](../source/src/main/java/nso/SelectServerScr.java#L42) | 42–43 | `co.<init>()V` | `preserved` |
| [`public static void loadIP()`](../source/src/main/java/nso/SelectServerScr.java#L45) | 45–51 | `co.b()V` | `reference_proposal` |
| [`public static void loadInfoIp(int index)`](../source/src/main/java/nso/SelectServerScr.java#L53) | 53–66 | `co.a(I)V` | `reference_proposal` |
| [`public final void switchToMe()`](../source/src/main/java/nso/SelectServerScr.java#L68) | 68–139 | `co.a()V` | `reference_proposal` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/SelectServerScr.java#L141) | 141–181 | `co.a(Lt;)V` | `reference_proposal` |
| [`public final void update()`](../source/src/main/java/nso/SelectServerScr.java#L183) | 183–195 | `co.c()V` | `reference_proposal` |
| [`public final void updateKey()`](../source/src/main/java/nso/SelectServerScr.java#L197) | 197–223 | `co.d()V` | `reference_proposal` |
| [`private void doViewFAQ()`](../source/src/main/java/nso/SelectServerScr.java#L225) | 225–230 | `co.i()V` | `reference_proposal` |
| [`public static boolean isVirtualAcc()`](../source/src/main/java/nso/SelectServerScr.java#L232) | 232–234 | `co.g()Z` | `reference_proposal` |
| [`public static String randomNumberlist()`](../source/src/main/java/nso/SelectServerScr.java#L236) | 236–243 | `co.h()Ljava/lang/String;` | `reference_proposal` |
| [`public final void perform(int idAction, Object p)`](../source/src/main/java/nso/SelectServerScr.java#L245) | 245–348 | `co.a(ILjava/lang/Object;)V` | `reference_proposal` |

## nso.SplashScr

Screen khởi động và chuyển trạng thái ban đầu.

[Source](../source/src/main/java/nso/SplashScr.java) · [Mapping](../mapping/classes/nso_SplashScr.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsosplashscr)

`public final class SplashScr extends mScreen`

Identity class: `cj`; status: `reference_proposal`; source: **24 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public SplashScr()`](../source/src/main/java/nso/SplashScr.java#L9) | 9–10 | `cj.<init>()V` | `preserved` |
| [`public final void update()`](../source/src/main/java/nso/SplashScr.java#L12) | 12–23 | `cj.c()V` | `reference_proposal` |

## nso.mScreen

Base màn hình: chuyển screen, update, input và paint.

[Source](../source/src/main/java/nso/mScreen.java) · [Mapping](../mapping/classes/nso_mScreen.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsomscreen)

`public class mScreen`

Identity class: `ag`; status: `reference_proposal`; source: **152 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public mScreen()`](../source/src/main/java/nso/mScreen.java#L22) | 22–23 | `ag.<init>()V` | `preserved` |
| [`public void switchToMe()`](../source/src/main/java/nso/mScreen.java#L25) | 25–34 | `ag.a()V` | `reference_proposal` |
| [`public void unLoad()`](../source/src/main/java/nso/mScreen.java#L36) | 36–37 | `ag.e()V` | `reference_proposal` |
| [`public static void initPos()`](../source/src/main/java/nso/mScreen.java#L39) | 39–45 | `ag.f()V` | `reference_proposal` |
| [`public void keyPress(int keyCode)`](../source/src/main/java/nso/mScreen.java#L47) | 47–48 | `ag.b(I)V` | `reference_proposal` |
| [`public void update()`](../source/src/main/java/nso/mScreen.java#L50) | 50–51 | `ag.c()V` | `reference_proposal` |
| [`public void updateKey()`](../source/src/main/java/nso/mScreen.java#L53) | 53–87 | `ag.d()V` | `reference_proposal` |
| [`public static boolean getCmdPointerLast(Command cmd)`](../source/src/main/java/nso/mScreen.java#L89) | 89–136 | `ag.a(Lbd;)Z` | `reference_proposal` |
| [`public void paint(mGraphics g)`](../source/src/main/java/nso/mScreen.java#L138) | 138–151 | `ag.a(Lt;)V` | `reference_proposal` |

## nso.ConnectionTimeout

Runnable timeout liên quan quá trình kết nối.

[Source](../source/src/main/java/nso/ConnectionTimeout.java) · [Mapping](../mapping/classes/nso_ConnectionTimeout.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoconnectiontimeout)

`final class ConnectionTimeout implements Runnable`

Identity class: `dt`; status: `behavioral_name`; source: **24 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`ConnectionTimeout()`](../source/src/main/java/nso/ConnectionTimeout.java#L5) | 5–6 | `dt.<init>()V` | `preserved` |
| [`public final void run()`](../source/src/main/java/nso/ConnectionTimeout.java#L8) | 8–23 | `dt.run()V` | `preserved` |

## nso.Controller

Dispatch message và parse dữ liệu server vào model/UI.

[Source](../source/src/main/java/nso/Controller.java) · [Mapping](../mapping/classes/nso_Controller.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsocontroller)

`public final class Controller`

Identity class: `an`; status: `reference_proposal`; source: **5007 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Controller()`](../source/src/main/java/nso/Controller.java#L16) | 16–17 | `an.<init>()V` | `preserved` |
| [`public static Controller gI()`](../source/src/main/java/nso/Controller.java#L19) | 19–24 | `an.a()Lan;` | `reference_proposal` |
| [`public final void onConnectionError()`](../source/src/main/java/nso/Controller.java#L26) | 26–28 | `an.b()V` | `behavioral_name` |
| [`private static void requestItemPlayer(Message msg)`](../source/src/main/java/nso/Controller.java#L30) | 30–47 | `an.b(Lce;)V` | `reference_proposal` |
| [`private static void viewItemAuction(Message msg)`](../source/src/main/java/nso/Controller.java#L49) | 49–77 | `an.c(Lce;)V` | `reference_proposal` |
| [`public final void onMessage(Message msg)`](../source/src/main/java/nso/Controller.java#L79) | 79–2373 | `an.a(Lce;)V` | `reference_proposal` |
| [`private static void createItem(DataInputStream d) throws IOException`](../source/src/main/java/nso/Controller.java#L2375) | 2375–2388 | `an.a(Ljava/io/DataInputStream;)V` | `reference_proposal` |
| [`private static void createSkill(DataInputStream d) throws IOException`](../source/src/main/java/nso/Controller.java#L2390) | 2390–2438 | `an.b(Ljava/io/DataInputStream;)V` | `reference_proposal` |
| [`private static void createMap(DataInputStream d) throws IOException`](../source/src/main/java/nso/Controller.java#L2440) | 2440–2473 | `an.c(Ljava/io/DataInputStream;)V` | `reference_proposal` |
| [`private static void createData(DataInputStream d) throws IOException`](../source/src/main/java/nso/Controller.java#L2475) | 2475–2543 | `an.d(Ljava/io/DataInputStream;)V` | `reference_proposal` |
| [`public static Image createImage(byte[] arr)`](../source/src/main/java/nso/Controller.java#L2545) | 2545–2551 | `an.a([B)Ljavax/microedition/lcdui/Image;` | `reference_proposal` |
| [`private void loadInfoMap(Message msg)`](../source/src/main/java/nso/Controller.java#L2553) | 2553–2637 | `an.d(Lce;)V` | `reference_proposal` |
| [`private void messageNotMap(Message msg)`](../source/src/main/java/nso/Controller.java#L2639) | 2639–3205 | `an.e(Lce;)V` | `reference_proposal` |
| [`private static void messageNotLogin(Message msg)`](../source/src/main/java/nso/Controller.java#L3207) | 3207–3224 | `an.f(Lce;)V` | `reference_proposal` |
| [`private void messageSubCommand(Message msg)`](../source/src/main/java/nso/Controller.java#L3226) | 3226–4396 | `an.g(Lce;)V` | `reference_proposal` |
| [`private static boolean readCharInfo(Char c, Message msg)`](../source/src/main/java/nso/Controller.java#L4398) | 4398–4511 | `an.a(Lbp;Lce;)Z` | `reference_proposal` |
| [`private static void requestItemInfo(Message msg)`](../source/src/main/java/nso/Controller.java#L4513) | 4513–4701 | `an.h(Lce;)V` | `reference_proposal` |
| [`private static void addMob(Message msg)`](../source/src/main/java/nso/Controller.java#L4703) | 4703–4738 | `an.i(Lce;)V` | `reference_proposal` |
| [`private static void addEffAuto(Message message)`](../source/src/main/java/nso/Controller.java#L4740) | 4740–4752 | `an.j(Lce;)V` | `reference_proposal` |
| [`private static void getDataEffAuto(Message message)`](../source/src/main/java/nso/Controller.java#L4754) | 4754–4768 | `an.k(Lce;)V` | `reference_proposal` |
| [`private static void getImgEffAuto(Message message)`](../source/src/main/java/nso/Controller.java#L4770) | 4770–4779 | `an.l(Lce;)V` | `reference_proposal` |
| [`private static void khamngoc(Message msg)`](../source/src/main/java/nso/Controller.java#L4781) | 4781–4820 | `an.m(Lce;)V` | `reference_proposal` |
| [`private static void addEffect(Message message)`](../source/src/main/java/nso/Controller.java#L4822) | 4822–4868 | `an.n(Lce;)V` | `reference_proposal` |
| [`private static void getImgEffect(Message msg)`](../source/src/main/java/nso/Controller.java#L4870) | 4870–4889 | `an.o(Lce;)V` | `reference_proposal` |
| [`private static void getDataEffect(Message msg)`](../source/src/main/java/nso/Controller.java#L4891) | 4891–4913 | `an.p(Lce;)V` | `reference_proposal` |
| [`private static void readDataMobOld(Message msg, int mobTemplateId)`](../source/src/main/java/nso/Controller.java#L4915) | 4915–4945 | `an.a(Lce;I)V` | `reference_proposal` |
| [`private static void readDataMobNew(Message msg, int mobTemplateId)`](../source/src/main/java/nso/Controller.java#L4947) | 4947–5006 | `an.b(Lce;I)V` | `reference_proposal` |

## nso.Message

Command và buffer payload; cung cấp reader/writer/cleanup.

[Source](../source/src/main/java/nso/Message.java) · [Mapping](../mapping/classes/nso_Message.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsomessage)

`public final class Message`

Identity class: `ce`; status: `reference_proposal`; source: **60 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Message()`](../source/src/main/java/nso/Message.java#L21) | 21–22 | `ce.<init>()V` | `preserved` |
| [`public Message(byte command1)`](../source/src/main/java/nso/Message.java#L24) | 24–28 | `ce.<init>(B)V` | `preserved` |
| [`public Message(byte command1, byte[] data)`](../source/src/main/java/nso/Message.java#L30) | 30–34 | `ce.<init>(B[B)V` | `preserved` |
| [`public final byte[] getData()`](../source/src/main/java/nso/Message.java#L36) | 36–38 | `ce.a()[B` | `reference_proposal` |
| [`public final DataInputStream reader()`](../source/src/main/java/nso/Message.java#L40) | 40–42 | `ce.b()Ljava/io/DataInputStream;` | `reference_proposal` |
| [`public final DataOutputStream writer()`](../source/src/main/java/nso/Message.java#L44) | 44–46 | `ce.c()Ljava/io/DataOutputStream;` | `reference_proposal` |
| [`public final void cleanup()`](../source/src/main/java/nso/Message.java#L48) | 48–59 | `ce.d()V` | `reference_proposal` |

## nso.PacketBuffer

Buffer byte và thao tác đọc dữ liệu theo source.

[Source](../source/src/main/java/nso/PacketBuffer.java) · [Mapping](../mapping/classes/nso_PacketBuffer.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsopacketbuffer)

`public final class PacketBuffer`

Identity class: `cp`; status: `behavioral_name`; source: **11 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public PacketBuffer()`](../source/src/main/java/nso/PacketBuffer.java#L7) | 7–10 | `cp.<init>()V` | `preserved` |

## nso.Readmsg

Đọc nhánh thông tin vĩ thú và dữ liệu countdown.

[Source](../source/src/main/java/nso/Readmsg.java) · [Mapping](../mapping/classes/nso_Readmsg.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoreadmsg)

`public final class Readmsg`

Identity class: `da`; status: `reference_proposal`; source: **122 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Readmsg()`](../source/src/main/java/nso/Readmsg.java#L5) | 5–6 | `da.<init>()V` | `preserved` |
| [`public final void onVithuInfo(Message msg)`](../source/src/main/java/nso/Readmsg.java#L8) | 8–121 | `da.a(Lce;)V` | `reference_proposal` |

## nso.SMS

Điểm gọi gửi SMS và khởi động đường kết nối theo source.

[Source](../source/src/main/java/nso/SMS.java) · [Mapping](../mapping/classes/nso_SMS.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsosms)

`public final class SMS`

Identity class: `f`; status: `reference_proposal`; source: **16 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public SMS()`](../source/src/main/java/nso/SMS.java#L5) | 5–6 | `f.<init>()V` | `preserved` |
| [`public static void sendSMS(String text, String text1, Command command, Command command2)`](../source/src/main/java/nso/SMS.java#L8) | 8–11 | `f.a(Ljava/lang/String;Ljava/lang/String;Lbd;Lbd;)V` | `behavioral_name` |
| [`public static void startConnectionThread()`](../source/src/main/java/nso/SMS.java#L13) | 13–15 | `f.a()V` | `behavioral_name` |

## nso.Service

Dựng payload gửi cho các thao tác game.

[Source](../source/src/main/java/nso/Service.java) · [Mapping](../mapping/classes/nso_Service.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoservice)

`public final class Service`

Identity class: `dq`; status: `reference_proposal`; source: **1990 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Service()`](../source/src/main/java/nso/Service.java#L17) | 17–18 | `dq.<init>()V` | `preserved` |
| [`public static Service gI()`](../source/src/main/java/nso/Service.java#L20) | 20–25 | `dq.a()Ldq;` | `reference_proposal` |
| [`private static Message messageNotLogin(byte command) throws IOException`](../source/src/main/java/nso/Service.java#L27) | 27–32 | `dq.b(B)Lce;` | `reference_proposal` |
| [`private static Message messageNotMap(byte command) throws IOException`](../source/src/main/java/nso/Service.java#L34) | 34–39 | `dq.c(B)Lce;` | `reference_proposal` |
| [`private static Message messageSubCommand(byte command) throws IOException`](../source/src/main/java/nso/Service.java#L41) | 41–46 | `dq.d(B)Lce;` | `reference_proposal` |
| [`public final void setClientType()`](../source/src/main/java/nso/Service.java#L48) | 48–69 | `dq.b()V` | `reference_proposal` |
| [`public final void login(String username, String pass, String version)`](../source/src/main/java/nso/Service.java#L71) | 71–87 | `dq.a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void requestRegisterNew(String username, String pass, String email)`](../source/src/main/java/nso/Service.java#L89) | 89–100 | `dq.b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void requestForgetPass(String username)`](../source/src/main/java/nso/Service.java#L102) | 102–111 | `dq.a(Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void requestChangeMap()`](../source/src/main/java/nso/Service.java#L113) | 113–117 | `dq.c()V` | `reference_proposal` |
| [`public final void requestChangeZone(int zoneId, int indexUI)`](../source/src/main/java/nso/Service.java#L119) | 119–128 | `dq.a(II)V` | `reference_proposal` |
| [`public final void charMove(int value, int value1)`](../source/src/main/java/nso/Service.java#L130) | 130–145 | `dq.b(II)V` | `reference_proposal` |
| [`public final void selectCharToPlay(String charname)`](../source/src/main/java/nso/Service.java#L147) | 147–156 | `dq.b(Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void createChar(String name, int gender, int hair)`](../source/src/main/java/nso/Service.java#L158) | 158–169 | `dq.a(Ljava/lang/String;II)V` | `reference_proposal` |
| [`public final void requestModTemplate(int modTemplateId)`](../source/src/main/java/nso/Service.java#L171) | 171–181 | `dq.a(I)V` | `reference_proposal` |
| [`public final void requestItemInfo(int typeUI, int indexUI)`](../source/src/main/java/nso/Service.java#L183) | 183–194 | `dq.c(II)V` | `reference_proposal` |
| [`public final void requestItemPlayer(int charId, int indexUI)`](../source/src/main/java/nso/Service.java#L196) | 196–207 | `dq.d(II)V` | `reference_proposal` |
| [`public final void upPotential(int index, int point)`](../source/src/main/java/nso/Service.java#L209) | 209–220 | `dq.e(II)V` | `reference_proposal` |
| [`public final void upSkill(int skillTemplateId, int point)`](../source/src/main/java/nso/Service.java#L222) | 222–233 | `dq.f(II)V` | `reference_proposal` |
| [`public final void itemBodyToBag(int indexUI)`](../source/src/main/java/nso/Service.java#L235) | 235–245 | `dq.b(I)V` | `reference_proposal` |
| [`public final void itemMonToBag(int indexUI)`](../source/src/main/java/nso/Service.java#L247) | 247–257 | `dq.c(I)V` | `reference_proposal` |
| [`public final void itemBoxToBag(int indexUI)`](../source/src/main/java/nso/Service.java#L259) | 259–269 | `dq.d(I)V` | `reference_proposal` |
| [`public final void itemBagToBox(int indexUI)`](../source/src/main/java/nso/Service.java#L271) | 271–281 | `dq.e(I)V` | `reference_proposal` |
| [`public final void useItem(int indexUI)`](../source/src/main/java/nso/Service.java#L283) | 283–297 | `dq.f(I)V` | `reference_proposal` |
| [`public final void saleItem(int indexUI, int quantity)`](../source/src/main/java/nso/Service.java#L299) | 299–313 | `dq.g(II)V` | `reference_proposal` |
| [`public final void buyItem(int typeUI, int indexUI, int quantity)`](../source/src/main/java/nso/Service.java#L315) | 315–330 | `dq.a(III)V` | `reference_proposal` |
| [`public final void selectSkill(int skillTemplateId)`](../source/src/main/java/nso/Service.java#L332) | 332–342 | `dq.g(I)V` | `reference_proposal` |
| [`public final void openFindParty()`](../source/src/main/java/nso/Service.java#L344) | 344–354 | `dq.d()V` | `reference_proposal` |
| [`public final void openUIZone()`](../source/src/main/java/nso/Service.java#L356) | 356–366 | `dq.e()V` | `reference_proposal` |
| [`public final void useItemChangeMap(int indexUI, int indexMenu)`](../source/src/main/java/nso/Service.java#L368) | 368–379 | `dq.h(II)V` | `reference_proposal` |
| [`public final void openMenu(int npcId)`](../source/src/main/java/nso/Service.java#L381) | 381–391 | `dq.h(I)V` | `reference_proposal` |
| [`public final void menu(byte typeclose, int npcId, int menuId, int optionId)`](../source/src/main/java/nso/Service.java#L393) | 393–406 | `dq.a(BIII)V` | `reference_proposal` |
| [`public final void menuId(short menuId)`](../source/src/main/java/nso/Service.java#L408) | 408–418 | `dq.a(S)V` | `reference_proposal` |
| [`public final void textBoxId(short menuId, String str)`](../source/src/main/java/nso/Service.java#L420) | 420–431 | `dq.a(SLjava/lang/String;)V` | `reference_proposal` |
| [`public final void requestItem(int typeUI)`](../source/src/main/java/nso/Service.java#L433) | 433–443 | `dq.i(I)V` | `reference_proposal` |
| [`public final void bagSort()`](../source/src/main/java/nso/Service.java#L445) | 445–455 | `dq.f()V` | `reference_proposal` |
| [`public final void boxSort()`](../source/src/main/java/nso/Service.java#L457) | 457–467 | `dq.g()V` | `reference_proposal` |
| [`public final void boxCoinIn(int coinIn)`](../source/src/main/java/nso/Service.java#L469) | 469–479 | `dq.j(I)V` | `reference_proposal` |
| [`public final void boxCoinOut(int coinOut)`](../source/src/main/java/nso/Service.java#L481) | 481–491 | `dq.k(I)V` | `reference_proposal` |
| [`public final void crystalCollect(Item[] items)`](../source/src/main/java/nso/Service.java#L493) | 493–509 | `dq.a([Lby;)V` | `reference_proposal` |
| [`public final void upgradeItem(Item item, Item[] items, boolean isGold)`](../source/src/main/java/nso/Service.java#L511) | 511–528 | `dq.a(Lby;[Lby;Z)V` | `reference_proposal` |
| [`public final void crystalCollectLock(Item[] items)`](../source/src/main/java/nso/Service.java#L530) | 530–546 | `dq.b([Lby;)V` | `reference_proposal` |
| [`public final void splitItem(Item item)`](../source/src/main/java/nso/Service.java#L548) | 548–559 | `dq.a(Lby;)V` | `reference_proposal` |
| [`public final void acceptInviteTrade(int playerMapId)`](../source/src/main/java/nso/Service.java#L561) | 561–571 | `dq.l(I)V` | `reference_proposal` |
| [`public final void acceptInviteTestDun(int playerMapId)`](../source/src/main/java/nso/Service.java#L573) | 573–583 | `dq.m(I)V` | `reference_proposal` |
| [`public final void acceptInviteTestGT(int playerMapId)`](../source/src/main/java/nso/Service.java#L585) | 585–595 | `dq.n(I)V` | `reference_proposal` |
| [`public final void sendUIConfirmID(int Id)`](../source/src/main/java/nso/Service.java#L597) | 597–607 | `dq.o(I)V` | `reference_proposal` |
| [`public final void acceptInviteTest(int playerMapId)`](../source/src/main/java/nso/Service.java#L609) | 609–619 | `dq.p(I)V` | `reference_proposal` |
| [`public final void cancelInviteTrade()`](../source/src/main/java/nso/Service.java#L621) | 621–631 | `dq.h()V` | `reference_proposal` |
| [`public final void cancelTrade()`](../source/src/main/java/nso/Service.java#L633) | 633–643 | `dq.i()V` | `reference_proposal` |
| [`public final void tradeAccept()`](../source/src/main/java/nso/Service.java#L645) | 645–655 | `dq.j()V` | `reference_proposal` |
| [`public final void tradeItemLock(int coin, Item[] items)`](../source/src/main/java/nso/Service.java#L657) | 657–679 | `dq.a(I[Lby;)V` | `reference_proposal` |
| [`public final void sendPlayerAttack(MyVector vMob, MyVector vChar, int type)`](../source/src/main/java/nso/Service.java#L681) | 681–723 | `dq.a(Laa;Laa;I)V` | `reference_proposal` |
| [`public final void pickItem(int itemMapId)`](../source/src/main/java/nso/Service.java#L725) | 725–738 | `dq.q(I)V` | `reference_proposal` |
| [`public final void throwItem(int index)`](../source/src/main/java/nso/Service.java#L740) | 740–750 | `dq.r(I)V` | `reference_proposal` |
| [`public final void returnTownFromDead()`](../source/src/main/java/nso/Service.java#L752) | 752–762 | `dq.k()V` | `reference_proposal` |
| [`public final void wakeUpFromDead()`](../source/src/main/java/nso/Service.java#L764) | 764–774 | `dq.l()V` | `reference_proposal` |
| [`public final void getTask(int npcTemplateId, int menuId, int optionId)`](../source/src/main/java/nso/Service.java#L776) | 776–787 | `dq.b(III)V` | `reference_proposal` |
| [`public final void chat(String text)`](../source/src/main/java/nso/Service.java#L789) | 789–799 | `dq.c(Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void adminChat(String text)`](../source/src/main/java/nso/Service.java#L801) | 801–811 | `dq.d(Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void updateData()`](../source/src/main/java/nso/Service.java#L813) | 813–823 | `dq.m()V` | `reference_proposal` |
| [`public final void updateMap()`](../source/src/main/java/nso/Service.java#L825) | 825–835 | `dq.n()V` | `reference_proposal` |
| [`public final void updateSkill()`](../source/src/main/java/nso/Service.java#L837) | 837–847 | `dq.o()V` | `reference_proposal` |
| [`public final void updateItem()`](../source/src/main/java/nso/Service.java#L849) | 849–859 | `dq.p()V` | `reference_proposal` |
| [`public final void clientOk()`](../source/src/main/java/nso/Service.java#L861) | 861–871 | `dq.q()V` | `reference_proposal` |
| [`public final void tradeInvite(int charId)`](../source/src/main/java/nso/Service.java#L873) | 873–883 | `dq.s(I)V` | `reference_proposal` |
| [`public final void addFriend(String name)`](../source/src/main/java/nso/Service.java#L885) | 885–895 | `dq.e(Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void addPartyAccept(int charId)`](../source/src/main/java/nso/Service.java#L897) | 897–907 | `dq.t(I)V` | `reference_proposal` |
| [`public final void addPartyCancel(int charId)`](../source/src/main/java/nso/Service.java#L909) | 909–919 | `dq.u(I)V` | `reference_proposal` |
| [`public final void testInvite(int charId)`](../source/src/main/java/nso/Service.java#L921) | 921–931 | `dq.v(I)V` | `reference_proposal` |
| [`public final void addCuuSat(int charId)`](../source/src/main/java/nso/Service.java#L933) | 933–943 | `dq.w(I)V` | `reference_proposal` |
| [`public final void buffLive(int charId)`](../source/src/main/java/nso/Service.java#L945) | 945–955 | `dq.x(I)V` | `reference_proposal` |
| [`public final void addParty(String name)`](../source/src/main/java/nso/Service.java#L957) | 957–967 | `dq.f(Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void requestMaptemplate(int maptemplateId)`](../source/src/main/java/nso/Service.java#L969) | 969–979 | `dq.y(I)V` | `reference_proposal` |
| [`public final void changePk(int typePk)`](../source/src/main/java/nso/Service.java#L981) | 981–991 | `dq.z(I)V` | `reference_proposal` |
| [`public final void changeTeamLeader(int index)`](../source/src/main/java/nso/Service.java#L993) | 993–1003 | `dq.A(I)V` | `reference_proposal` |
| [`public final void moveMember(int index)`](../source/src/main/java/nso/Service.java#L1005) | 1005–1015 | `dq.B(I)V` | `reference_proposal` |
| [`public final void sendUseSkillMyBuff()`](../source/src/main/java/nso/Service.java#L1017) | 1017–1027 | `dq.r()V` | `reference_proposal` |
| [`public final void createParty()`](../source/src/main/java/nso/Service.java#L1029) | 1029–1039 | `dq.s()V` | `reference_proposal` |
| [`public final void lockParty(boolean isLock)`](../source/src/main/java/nso/Service.java#L1041) | 1041–1051 | `dq.a(Z)V` | `reference_proposal` |
| [`public final void outParty()`](../source/src/main/java/nso/Service.java#L1053) | 1053–1063 | `dq.t()V` | `reference_proposal` |
| [`public final void requestFriend()`](../source/src/main/java/nso/Service.java#L1065) | 1065–1075 | `dq.u()V` | `reference_proposal` |
| [`public final void requestMatchInfo(int zoneid)`](../source/src/main/java/nso/Service.java#L1077) | 1077–1087 | `dq.C(I)V` | `reference_proposal` |
| [`public final void requestPlayerInfo(MyVector chars)`](../source/src/main/java/nso/Service.java#L1089) | 1089–1103 | `dq.a(Laa;)V` | `reference_proposal` |
| [`public final void requestEnemies()`](../source/src/main/java/nso/Service.java#L1105) | 1105–1115 | `dq.v()V` | `reference_proposal` |
| [`public final void removeFriend(String name)`](../source/src/main/java/nso/Service.java#L1117) | 1117–1127 | `dq.g(Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void pleaseInputParty(String str)`](../source/src/main/java/nso/Service.java#L1129) | 1129–1139 | `dq.h(Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void acceptPleaseParty(String str)`](../source/src/main/java/nso/Service.java#L1141) | 1141–1151 | `dq.i(Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void viewInfo(String text, int value)`](../source/src/main/java/nso/Service.java#L1153) | 1153–1164 | `dq.a(Ljava/lang/String;I)V` | `reference_proposal` |
| [`public final void chatParty(String text)`](../source/src/main/java/nso/Service.java#L1166) | 1166–1176 | `dq.j(Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void chatGlobal(String text)`](../source/src/main/java/nso/Service.java#L1178) | 1178–1188 | `dq.k(Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void chatPrivate(String to, String text)`](../source/src/main/java/nso/Service.java#L1190) | 1190–1201 | `dq.a(Ljava/lang/String;Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void chatClan(String text)`](../source/src/main/java/nso/Service.java#L1203) | 1203–1213 | `dq.l(Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void sendCardInfo(String NAP, String PIN)`](../source/src/main/java/nso/Service.java#L1215) | 1215–1226 | `dq.b(Ljava/lang/String;Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void saveRms(String key, byte[] data, byte type)`](../source/src/main/java/nso/Service.java#L1228) | 1228–1241 | `dq.a(Ljava/lang/String;[BB)V` | `reference_proposal` |
| [`public final void loadRMS(String key)`](../source/src/main/java/nso/Service.java#L1243) | 1243–1253 | `dq.m(Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void adminMove(int mapId)`](../source/src/main/java/nso/Service.java#L1255) | 1255–1265 | `dq.D(I)V` | `reference_proposal` |
| [`public final void changeName(String name, int id)`](../source/src/main/java/nso/Service.java#L1267) | 1267–1278 | `dq.b(Ljava/lang/String;I)V` | `reference_proposal` |
| [`public final void requestIcon(int id)`](../source/src/main/java/nso/Service.java#L1280) | 1280–1290 | `dq.E(I)V` | `reference_proposal` |
| [`public final void requestClanInfo()`](../source/src/main/java/nso/Service.java#L1292) | 1292–1302 | `dq.w()V` | `reference_proposal` |
| [`public final void requestClanMember()`](../source/src/main/java/nso/Service.java#L1304) | 1304–1314 | `dq.x()V` | `reference_proposal` |
| [`public final void requestClanItem()`](../source/src/main/java/nso/Service.java#L1316) | 1316–1326 | `dq.y()V` | `reference_proposal` |
| [`public final void requestClanLog()`](../source/src/main/java/nso/Service.java#L1328) | 1328–1338 | `dq.z()V` | `reference_proposal` |
| [`public final void clanInvite(int charId)`](../source/src/main/java/nso/Service.java#L1340) | 1340–1350 | `dq.F(I)V` | `reference_proposal` |
| [`public final void clanPlease(int charId)`](../source/src/main/java/nso/Service.java#L1352) | 1352–1362 | `dq.G(I)V` | `reference_proposal` |
| [`public final void acceptInviteClan(int playerMapId)`](../source/src/main/java/nso/Service.java#L1364) | 1364–1374 | `dq.H(I)V` | `reference_proposal` |
| [`public final void acceptPleaseClan(int playerMapId)`](../source/src/main/java/nso/Service.java#L1376) | 1376–1386 | `dq.I(I)V` | `reference_proposal` |
| [`public final void changeClanAlert(String str)`](../source/src/main/java/nso/Service.java#L1388) | 1388–1398 | `dq.n(Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void changeClanType(String name, int type)`](../source/src/main/java/nso/Service.java#L1400) | 1400–1411 | `dq.c(Ljava/lang/String;I)V` | `reference_proposal` |
| [`public final void moveOutClan(String name)`](../source/src/main/java/nso/Service.java#L1413) | 1413–1423 | `dq.o(Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void outClan()`](../source/src/main/java/nso/Service.java#L1425) | 1425–1435 | `dq.A()V` | `reference_proposal` |
| [`public final void inputCoinClan(int coin)`](../source/src/main/java/nso/Service.java#L1437) | 1437–1447 | `dq.J(I)V` | `reference_proposal` |
| [`public final void outputCoinClan(int coin)`](../source/src/main/java/nso/Service.java#L1449) | 1449–1459 | `dq.K(I)V` | `reference_proposal` |
| [`public final void clanUpLevel()`](../source/src/main/java/nso/Service.java#L1461) | 1461–1471 | `dq.B()V` | `reference_proposal` |
| [`public final void doConvertUpgrade(int index1, int index2, int index3)`](../source/src/main/java/nso/Service.java#L1473) | 1473–1485 | `dq.c(III)V` | `reference_proposal` |
| [`public final void inviteClanDun(String name)`](../source/src/main/java/nso/Service.java#L1487) | 1487–1497 | `dq.p(Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void inviteClanBattlefield(String name)`](../source/src/main/java/nso/Service.java#L1499) | 1499–1509 | `dq.q(Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void acceptClanBattlefield()`](../source/src/main/java/nso/Service.java#L1511) | 1511–1521 | `dq.C()V` | `reference_proposal` |
| [`public final void inviteClanBattlefieldAll()`](../source/src/main/java/nso/Service.java#L1523) | 1523–1533 | `dq.D()V` | `reference_proposal` |
| [`public final void unlockClanItem()`](../source/src/main/java/nso/Service.java#L1535) | 1535–1545 | `dq.E()V` | `reference_proposal` |
| [`public final void inputNumSplit(int indexItem, int numSplit)`](../source/src/main/java/nso/Service.java#L1547) | 1547–1558 | `dq.i(II)V` | `reference_proposal` |
| [`public final void activeAccProtect(int pass)`](../source/src/main/java/nso/Service.java#L1560) | 1560–1570 | `dq.L(I)V` | `reference_proposal` |
| [`public final void clearAccProtect(int pass)`](../source/src/main/java/nso/Service.java#L1572) | 1572–1582 | `dq.M(I)V` | `reference_proposal` |
| [`public final void updateActive(int passOld, int passNew)`](../source/src/main/java/nso/Service.java#L1584) | 1584–1595 | `dq.j(II)V` | `reference_proposal` |
| [`public final void openLockAccProtect(int pass2)`](../source/src/main/java/nso/Service.java#L1597) | 1597–1607 | `dq.N(I)V` | `reference_proposal` |
| [`public final void rewardPB()`](../source/src/main/java/nso/Service.java#L1609) | 1609–1619 | `dq.F()V` | `reference_proposal` |
| [`public final void rewardCT()`](../source/src/main/java/nso/Service.java#L1621) | 1621–1631 | `dq.G()V` | `reference_proposal` |
| [`public final void sendToSaleItem(Item item, int value)`](../source/src/main/java/nso/Service.java#L1633) | 1633–1644 | `dq.a(Lby;I)V` | `reference_proposal` |
| [`public final void requestItemAuction(int itemId)`](../source/src/main/java/nso/Service.java#L1646) | 1646–1656 | `dq.O(I)V` | `reference_proposal` |
| [`public final void buyItemAuction(int itemId)`](../source/src/main/java/nso/Service.java#L1658) | 1658–1668 | `dq.P(I)V` | `reference_proposal` |
| [`public final void selectCard()`](../source/src/main/java/nso/Service.java#L1670) | 1670–1680 | `dq.H()V` | `reference_proposal` |
| [`public final void sendClanItem(String name)`](../source/src/main/java/nso/Service.java#L1682) | 1682–1693 | `dq.r(Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void useClanItem()`](../source/src/main/java/nso/Service.java#L1695) | 1695–1705 | `dq.I()V` | `reference_proposal` |
| [`public final void luyenthach(Item[] items)`](../source/src/main/java/nso/Service.java#L1707) | 1707–1729 | `dq.c([Lby;)V` | `reference_proposal` |
| [`public final void tinhluyen(Item it, Item[] items)`](../source/src/main/java/nso/Service.java#L1731) | 1731–1747 | `dq.a(Lby;[Lby;)V` | `reference_proposal` |
| [`public final void dichchuyen(Item it, Item[] items)`](../source/src/main/java/nso/Service.java#L1749) | 1749–1772 | `dq.b(Lby;[Lby;)V` | `reference_proposal` |
| [`public final void sendCatkeo(int id)`](../source/src/main/java/nso/Service.java#L1774) | 1774–1784 | `dq.Q(I)V` | `reference_proposal` |
| [`public final void ChucTet(String to, String loichuc, byte type)`](../source/src/main/java/nso/Service.java#L1786) | 1786–1797 | `dq.a(Ljava/lang/String;Ljava/lang/String;B)V` | `reference_proposal` |
| [`public final void SendCapcha(short idRe, String capcha)`](../source/src/main/java/nso/Service.java#L1799) | 1799–1810 | `dq.b(SLjava/lang/String;)V` | `reference_proposal` |
| [`public final void sendAttackMobFast(short idMonter)`](../source/src/main/java/nso/Service.java#L1812) | 1812–1822 | `dq.b(S)V` | `reference_proposal` |
| [`public final void requestRanked(byte index, String name)`](../source/src/main/java/nso/Service.java#L1824) | 1824–1835 | `dq.a(BLjava/lang/String;)V` | `reference_proposal` |
| [`public final void request_imgEffAuto(byte type, short id)`](../source/src/main/java/nso/Service.java#L1837) | 1837–1848 | `dq.a(BS)V` | `reference_proposal` |
| [`public final void luckyDraw(short type, String money, byte typeLucky)`](../source/src/main/java/nso/Service.java#L1850) | 1850–1862 | `dq.a(SLjava/lang/String;B)V` | `reference_proposal` |
| [`public final void info_Kiemduyet(String name, String ngaysinh, String diachi, String cmnd, String ngaycap, String noicap, String email)`](../source/src/main/java/nso/Service.java#L1864) | 1864–1879 | `dq.a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void send_Captcha(byte type)`](../source/src/main/java/nso/Service.java#L1881) | 1881–1892 | `dq.a(B)V` | `reference_proposal` |
| [`public final void ngockham(byte type, Item item, Item ngoc, Item[] items)`](../source/src/main/java/nso/Service.java#L1894) | 1894–1923 | `dq.a(BLby;Lby;[Lby;)V` | `reference_proposal` |
| [`public final void giaodo(Item[] items)`](../source/src/main/java/nso/Service.java#L1925) | 1925–1941 | `dq.d([Lby;)V` | `reference_proposal` |
| [`public final void doGetImgIcon(short id)`](../source/src/main/java/nso/Service.java#L1943) | 1943–1954 | `dq.c(S)V` | `reference_proposal` |
| [`public final void doGetByteData(int id)`](../source/src/main/java/nso/Service.java#L1956) | 1956–1967 | `dq.R(I)V` | `reference_proposal` |
| [`public final void sendGPS()`](../source/src/main/java/nso/Service.java#L1969) | 1969–1978 | `dq.J()V` | `reference_proposal` |
| [`public final void doRemoveVithu(int id)`](../source/src/main/java/nso/Service.java#L1980) | 1980–1989 | `dq.S(I)V` | `reference_proposal` |

## nso.SessionConnector

Runnable mở kết nối, khởi động stream/thread và gửi handshake.

[Source](../source/src/main/java/nso/SessionConnector.java) · [Mapping](../mapping/classes/nso_SessionConnector.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsosessionconnector)

`final class SessionConnector implements Runnable`

Identity class: `bs`; status: `behavioral_name`; source: **50 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`SessionConnector(Session_ME sessionME, String text)`](../source/src/main/java/nso/SessionConnector.java#L12) | 12–15 | `bs.<init>(Ldh;Ljava/lang/String;)V` | `preserved` |
| [`public final void run()`](../source/src/main/java/nso/SessionConnector.java#L17) | 17–49 | `bs.run()V` | `preserved` |

## nso.SessionReceiver

Runnable đọc command/length/payload, key và dispatch message.

[Source](../source/src/main/java/nso/SessionReceiver.java) · [Mapping](../mapping/classes/nso_SessionReceiver.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsosessionreceiver)

`final class SessionReceiver implements Runnable`

Identity class: `dn`; status: `behavioral_name`; source: **95 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`SessionReceiver(Session_ME sessionME)`](../source/src/main/java/nso/SessionReceiver.java#L10) | 10–12 | `dn.<init>(Ldh;)V` | `preserved` |
| [`public final void run()`](../source/src/main/java/nso/SessionReceiver.java#L14) | 14–82 | `dn.run()V` | `preserved` |
| [`private void getKey(Message message) throws IOException`](../source/src/main/java/nso/SessionReceiver.java#L84) | 84–94 | `dn.a(Lce;)V` | `behavioral_name` |

## nso.SessionSender

Runnable lấy message đã xếp hàng và gửi sau handshake.

[Source](../source/src/main/java/nso/SessionSender.java) · [Mapping](../mapping/classes/nso_SessionSender.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsosessionsender)

`final class SessionSender implements Runnable`

Identity class: `aq`; status: `behavioral_name`; source: **34 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public SessionSender(Session_ME sessionME)`](../source/src/main/java/nso/SessionSender.java#L9) | 9–12 | `aq.<init>(Ldh;)V` | `preserved` |
| [`public final void run()`](../source/src/main/java/nso/SessionSender.java#L14) | 14–33 | `aq.run()V` | `preserved` |

## nso.Session_ME

Singleton socket session, stream, queue và key XOR.

[Source](../source/src/main/java/nso/Session_ME.java) · [Mapping](../mapping/classes/nso_Session_ME.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsosession_me)

`public final class Session_ME`

Identity class: `dh`; status: `reference_proposal`; source: **192 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Session_ME()`](../source/src/main/java/nso/Session_ME.java#L53) | 53–54 | `dh.<init>()V` | `preserved` |
| [`public static Session_ME gI()`](../source/src/main/java/nso/Session_ME.java#L56) | 56–58 | `dh.a()Ldh;` | `reference_proposal` |
| [`public final boolean isConnected()`](../source/src/main/java/nso/Session_ME.java#L60) | 60–62 | `dh.b()Z` | `reference_proposal` |
| [`public final void setHandler(Controller controller)`](../source/src/main/java/nso/Session_ME.java#L64) | 64–66 | `dh.a(Lan;)V` | `reference_proposal` |
| [`public final void connect(String text)`](../source/src/main/java/nso/Session_ME.java#L68) | 68–76 | `dh.a(Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void sendMessage(Message message)`](../source/src/main/java/nso/Session_ME.java#L78) | 78–82 | `dh.a(Lce;)V` | `reference_proposal` |
| [`private synchronized void doSendMessage(Message m)`](../source/src/main/java/nso/Session_ME.java#L84) | 84–119 | `dh.b(Lce;)V` | `reference_proposal` |
| [`private byte writeKey(byte byteValue)`](../source/src/main/java/nso/Session_ME.java#L121) | 121–127 | `dh.a(B)B` | `reference_proposal` |
| [`public final void close()`](../source/src/main/java/nso/Session_ME.java#L129) | 129–131 | `dh.c()V` | `reference_proposal` |
| [`private void cleanNetwork()`](../source/src/main/java/nso/Session_ME.java#L133) | 133–157 | `dh.d()V` | `reference_proposal` |
| [`static void setOutputStream(Session_ME sessionME, DataOutputStream dataOutputStream)`](../source/src/main/java/nso/Session_ME.java#L159) | 159–161 | `dh.a(Ldh;Ljava/io/DataOutputStream;)V` | `behavioral_name` |
| [`static SessionSender getSender(Session_ME sessionME)`](../source/src/main/java/nso/Session_ME.java#L163) | 163–165 | `dh.a(Ldh;)Laq;` | `behavioral_name` |
| [`static void sendMessageNow(Session_ME sessionME, Message message) throws IOException`](../source/src/main/java/nso/Session_ME.java#L167) | 167–169 | `dh.a(Ldh;Lce;)V` | `behavioral_name` |
| [`static void setSendQueue(Session_ME sessionME, MyVector entries)`](../source/src/main/java/nso/Session_ME.java#L171) | 171–173 | `dh.a(Ldh;Laa;)V` | `behavioral_name` |
| [`static MyVector getSendQueue(Session_ME sessionME)`](../source/src/main/java/nso/Session_ME.java#L175) | 175–177 | `dh.b(Ldh;)Laa;` | `behavioral_name` |
| [`static void cleanNetwork(Session_ME sessionME)`](../source/src/main/java/nso/Session_ME.java#L179) | 179–181 | `dh.c(Ldh;)V` | `behavioral_name` |
| [`static byte readKey(Session_ME sessionME, byte byteValue)`](../source/src/main/java/nso/Session_ME.java#L183) | 183–191 | `dh.a(Ldh;B)B` | `reference_proposal` |

## nso.SmsSender

Runnable gửi tin nhắn qua WMA, gọi command kết quả.

[Source](../source/src/main/java/nso/SmsSender.java) · [Mapping](../mapping/classes/nso_SmsSender.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsosmssender)

`final class SmsSender implements Runnable`

Identity class: `du`; status: `behavioral_name`; source: **40 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`SmsSender(String text, String text1, String text2, Command command, Command command3)`](../source/src/main/java/nso/SmsSender.java#L19) | 19–25 | `du.<init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lbd;Lbd;)V` | `preserved` |
| [`public final void run()`](../source/src/main/java/nso/SmsSender.java#L27) | 27–39 | `du.run()V` | `preserved` |

## nso.Arrow

Đối tượng mũi tên, update và paint.

[Source](../source/src/main/java/nso/Arrow.java) · [Mapping](../mapping/classes/nso_Arrow.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoarrow)

`public final class Arrow`

Identity class: `ax`; status: `reference_proposal`; source: **133 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Arrow(Char charBelong1, Arrowpaint arrp2)`](../source/src/main/java/nso/Arrow.java#L33) | 33–36 | `ax.<init>(Lbp;Lbx;)V` | `preserved` |
| [`public final void update()`](../source/src/main/java/nso/Arrow.java#L38) | 38–102 | `ax.a()V` | `reference_proposal` |
| [`private void endMe()`](../source/src/main/java/nso/Arrow.java#L104) | 104–111 | `ax.b()V` | `reference_proposal` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/Arrow.java#L113) | 113–132 | `ax.a(Lt;)V` | `reference_proposal` |

## nso.BuNhin

Đối tượng bù nhìn và dữ liệu của nó.

[Source](../source/src/main/java/nso/BuNhin.java) · [Mapping](../mapping/classes/nso_BuNhin.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsobunhin)

`public final class BuNhin`

Identity class: `dk`; status: `reference_proposal`; source: **18 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public BuNhin(String name1, short x2, short y3)`](../source/src/main/java/nso/BuNhin.java#L13) | 13–17 | `dk.<init>(Ljava/lang/String;SS)V` | `preserved` |

## nso.Char

State, chỉ số, di chuyển, skill/effect và render nhân vật.

[Source](../source/src/main/java/nso/Char.java) · [Mapping](../mapping/classes/nso_Char.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsochar)

`public class Char extends MainObject`

Identity class: `bp`; status: `reference_proposal`; source: **8860 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`private int getdxSkill()`](../source/src/main/java/nso/Char.java#L567) | 567–569 | `bp.E()I` | `reference_proposal` |
| [`private int getdySkill()`](../source/src/main/java/nso/Char.java#L571) | 571–573 | `bp.F()I` | `reference_proposal` |
| [`public Char()`](../source/src/main/java/nso/Char.java#L575) | 575–649 | `bp.<init>()V` | `preserved` |
| [`public final int getSys()`](../source/src/main/java/nso/Char.java#L651) | 651–659 | `bp.a()I` | `reference_proposal` |
| [`public final int getSpeed()`](../source/src/main/java/nso/Char.java#L661) | 661–663 | `bp.b()I` | `reference_proposal` |
| [`public final boolean isUseLongRangeWeapon()`](../source/src/main/java/nso/Char.java#L665) | 665–667 | `bp.c()Z` | `reference_proposal` |
| [`public static Char getMyChar()`](../source/src/main/java/nso/Char.java#L669) | 669–676 | `bp.d()Lbp;` | `reference_proposal` |
| [`public static void clearMyChar()`](../source/src/main/java/nso/Char.java#L678) | 678–690 | `bp.e()V` | `reference_proposal` |
| [`public final void readParam(Message message)`](../source/src/main/java/nso/Char.java#L692) | 692–701 | `bp.a(Lce;)V` | `reference_proposal` |
| [`public final void bagSort()`](../source/src/main/java/nso/Char.java#L703) | 703–741 | `bp.f()V` | `reference_proposal` |
| [`public final void boxSort()`](../source/src/main/java/nso/Char.java#L743) | 743–781 | `bp.g()V` | `reference_proposal` |
| [`public final void useItem(int indexUI)`](../source/src/main/java/nso/Char.java#L783) | 783–832 | `bp.a(I)V` | `reference_proposal` |
| [`public final Skill getSkill(SkillTemplate skillTemplate)`](../source/src/main/java/nso/Char.java#L834) | 834–842 | `bp.a(Lj;)Lz;` | `reference_proposal` |
| [`private boolean isInWaypoint()`](../source/src/main/java/nso/Char.java#L844) | 844–853 | `bp.G()Z` | `reference_proposal` |
| [`private static int getDistance(int x, int x2)`](../source/src/main/java/nso/Char.java#L855) | 855–857 | `bp.b(II)I` | `reference_proposal` |
| [`private void updateFramecharByhorse()`](../source/src/main/java/nso/Char.java#L859) | 859–892 | `bp.H()V` | `reference_proposal` |
| [`public void update()`](../source/src/main/java/nso/Char.java#L894) | 894–1847 | `bp.h()V` | `reference_proposal` |
| [`private void fixMove()`](../source/src/main/java/nso/Char.java#L1849) | 1849–1888 | `bp.I()V` | `reference_proposal` |
| [`private void updateSkillPaint()`](../source/src/main/java/nso/Char.java#L1890) | 1890–1938 | `bp.J()V` | `reference_proposal` |
| [`public final void saveLoadPreviousSkill()`](../source/src/main/java/nso/Char.java#L1940) | 1940–1956 | `bp.i()V` | `reference_proposal` |
| [`private void updateCharDeadFly()`](../source/src/main/java/nso/Char.java#L1958) | 1958–1976 | `bp.K()V` | `reference_proposal` |
| [`private void setAttk()`](../source/src/main/java/nso/Char.java#L1978) | 1978–2044 | `bp.L()V` | `reference_proposal` |
| [`private void updateCharAutoJump()`](../source/src/main/java/nso/Char.java#L2046) | 2046–2072 | `bp.M()V` | `reference_proposal` |
| [`private void stop()`](../source/src/main/java/nso/Char.java#L2074) | 2074–2079 | `bp.N()V` | `reference_proposal` |
| [`private static int abs(int value)`](../source/src/main/java/nso/Char.java#L2081) | 2081–2083 | `bp.f(I)I` | `reference_proposal` |
| [`private void updateCharJump()`](../source/src/main/java/nso/Char.java#L2085) | 2085–2193 | `bp.O()V` | `reference_proposal` |
| [`private void updateCharFall()`](../source/src/main/java/nso/Char.java#L2195) | 2195–2293 | `bp.P()V` | `reference_proposal` |
| [`private void updateCharWaterRun()`](../source/src/main/java/nso/Char.java#L2295) | 2295–2329 | `bp.Q()V` | `reference_proposal` |
| [`private void updateCharWaterDown()`](../source/src/main/java/nso/Char.java#L2331) | 2331–2351 | `bp.R()V` | `reference_proposal` |
| [`public final void setDefaultPart()`](../source/src/main/java/nso/Char.java#L2353) | 2353–2357 | `bp.j()V` | `reference_proposal` |
| [`public final void setDefaultWeapon()`](../source/src/main/java/nso/Char.java#L2359) | 2359–2361 | `bp.k()V` | `reference_proposal` |
| [`public static Part getDefaultHead(int value)`](../source/src/main/java/nso/Char.java#L2363) | 2363–2369 | `bp.b(I)Ldr;` | `reference_proposal` |
| [`public final void setDefaultBody()`](../source/src/main/java/nso/Char.java#L2371) | 2371–2377 | `bp.l()V` | `reference_proposal` |
| [`public final void setDefaultLeg()`](../source/src/main/java/nso/Char.java#L2379) | 2379–2385 | `bp.m()V` | `reference_proposal` |
| [`public final void setSkillPaint(SkillPaint skillPaint1, int sType2)`](../source/src/main/java/nso/Char.java#L2387) | 2387–2401 | `bp.a(Ln;I)V` | `reference_proposal` |
| [`private void setAutoSkillPaint(SkillPaint skillPaint1, int sType2)`](../source/src/main/java/nso/Char.java#L2403) | 2403–2411 | `bp.b(Ln;I)V` | `reference_proposal` |
| [`private SkillInfoPaint[] skillInfoPaint1()`](../source/src/main/java/nso/Char.java#L2413) | 2413–2419 | `bp.S()[Lar;` | `reference_proposal` |
| [`public final void setAttack()`](../source/src/main/java/nso/Char.java#L2421) | 2421–2565 | `bp.n()V` | `reference_proposal` |
| [`public final boolean isHaveWolf()`](../source/src/main/java/nso/Char.java#L2567) | 2567–2569 | `bp.o()Z` | `reference_proposal` |
| [`public final boolean isHaveMoto()`](../source/src/main/java/nso/Char.java#L2571) | 2571–2573 | `bp.p()Z` | `reference_proposal` |
| [`public final boolean isPaint()`](../source/src/main/java/nso/Char.java#L2575) | 2575–2583 | `bp.q()Z` | `reference_proposal` |
| [`private static DataSkillEff getPartEff(short id, boolean ishorse)`](../source/src/main/java/nso/Char.java#L2585) | 2585–2598 | `bp.a(SZ)Ly;` | `reference_proposal` |
| [`public static void SetRemove()`](../source/src/main/java/nso/Char.java#L2600) | 2600–2612 | `bp.r()V` | `reference_proposal` |
| [`public void paint(mGraphics graphics)`](../source/src/main/java/nso/Char.java#L2614) | 2614–2848 | `bp.a(Lt;)V` | `reference_proposal` |
| [`public final void paintHp(mGraphics g, int px, int py)`](../source/src/main/java/nso/Char.java#L2850) | 2850–2866 | `bp.a(Lt;II)V` | `reference_proposal` |
| [`private int[] geteffOngbo()`](../source/src/main/java/nso/Char.java#L2868) | 2868–2874 | `bp.T()[I` | `reference_proposal` |
| [`private int[] getEffmoto()`](../source/src/main/java/nso/Char.java#L2876) | 2876–2882 | `bp.U()[I` | `reference_proposal` |
| [`private int[] getEffwolf()`](../source/src/main/java/nso/Char.java#L2884) | 2884–2890 | `bp.V()[I` | `reference_proposal` |
| [`public final int[] getClassCoat()`](../source/src/main/java/nso/Char.java#L2892) | 2892–2925 | `bp.s()[I` | `reference_proposal` |
| [`public final int getClassColor()`](../source/src/main/java/nso/Char.java#L2927) | 2927–2937 | `bp.t()I` | `reference_proposal` |
| [`public final void paintNameInSameParty(mGraphics g)`](../source/src/main/java/nso/Char.java#L2939) | 2939–2949 | `bp.b(Lt;)V` | `reference_proposal` |
| [`public final void paintCharName_HP_MP_Overhead(mGraphics g)`](../source/src/main/java/nso/Char.java#L2951) | 2951–3111 | `bp.c(Lt;)V` | `reference_proposal` |
| [`private byte getFrameHores()`](../source/src/main/java/nso/Char.java#L3113) | 3113–3131 | `bp.W()B` | `reference_proposal` |
| [`private int getFrameHorseui(int value)`](../source/src/main/java/nso/Char.java#L3133) | 3133–3135 | `bp.g(I)I` | `reference_proposal` |
| [`public final void paintHorseUI(mGraphics g, int x, int y)`](../source/src/main/java/nso/Char.java#L3137) | 3137–3150 | `bp.b(Lt;II)V` | `reference_proposal` |
| [`private int getFrameBienHinh()`](../source/src/main/java/nso/Char.java#L3152) | 3152–3158 | `bp.X()I` | `reference_proposal` |
| [`private int getFrameLeg()`](../source/src/main/java/nso/Char.java#L3160) | 3160–3166 | `bp.Y()I` | `reference_proposal` |
| [`private int getFrameMatna()`](../source/src/main/java/nso/Char.java#L3168) | 3168–3174 | `bp.Z()I` | `reference_proposal` |
| [`private int getFrameWeapone()`](../source/src/main/java/nso/Char.java#L3176) | 3176–3182 | `bp.aa()I` | `reference_proposal` |
| [`private int getFrameBody()`](../source/src/main/java/nso/Char.java#L3184) | 3184–3190 | `bp.ab()I` | `reference_proposal` |
| [`private int getFrameHair()`](../source/src/main/java/nso/Char.java#L3192) | 3192–3198 | `bp.ac()I` | `reference_proposal` |
| [`private int getFramePP()`](../source/src/main/java/nso/Char.java#L3200) | 3200–3206 | `bp.ad()I` | `reference_proposal` |
| [`private int getFramePP(int value)`](../source/src/main/java/nso/Char.java#L3208) | 3208–3210 | `bp.h(I)I` | `reference_proposal` |
| [`private int getFrameHeadUI(int value)`](../source/src/main/java/nso/Char.java#L3212) | 3212–3214 | `bp.i(I)I` | `reference_proposal` |
| [`private int getFrameBodyUI(int value)`](../source/src/main/java/nso/Char.java#L3216) | 3216–3218 | `bp.j(I)I` | `reference_proposal` |
| [`private int getFrameLegUI(int value)`](../source/src/main/java/nso/Char.java#L3220) | 3220–3222 | `bp.k(I)I` | `reference_proposal` |
| [`public final void paintPPUIBot(mGraphics graphics, int value, int value1, int value2)`](../source/src/main/java/nso/Char.java#L3224) | 3224–3229 | `bp.c(Lt;III)V` | `reference_proposal` |
| [`public final void paintPPUITop(mGraphics g, int cx1, int cy2, int f)`](../source/src/main/java/nso/Char.java#L3231) | 3231–3243 | `bp.d(Lt;III)V` | `reference_proposal` |
| [`private int getFrameWeaponUI(int value)`](../source/src/main/java/nso/Char.java#L3245) | 3245–3247 | `bp.l(I)I` | `reference_proposal` |
| [`private int getFrameMatNaUI(int value)`](../source/src/main/java/nso/Char.java#L3249) | 3249–3251 | `bp.m(I)I` | `reference_proposal` |
| [`public final void paintMatNaUI(mGraphics g, int cx1, int cy2, int f)`](../source/src/main/java/nso/Char.java#L3253) | 3253–3266 | `bp.e(Lt;III)V` | `reference_proposal` |
| [`public final void paintWeaponUITop(mGraphics graphics, int value, int value1, int value2)`](../source/src/main/java/nso/Char.java#L3268) | 3268–3280 | `bp.f(Lt;III)V` | `reference_proposal` |
| [`public final void paintWeaponUIBot(mGraphics graphics, int value, int value1, int value2)`](../source/src/main/java/nso/Char.java#L3282) | 3282–3294 | `bp.g(Lt;III)V` | `reference_proposal` |
| [`public final void paintHeadUI(mGraphics g, int cx1, int cy2, int f)`](../source/src/main/java/nso/Char.java#L3296) | 3296–3309 | `bp.h(Lt;III)V` | `reference_proposal` |
| [`public final void paintLegUI(mGraphics g, int cx1, int cy2, int f)`](../source/src/main/java/nso/Char.java#L3311) | 3311–3324 | `bp.i(Lt;III)V` | `reference_proposal` |
| [`public final void paintBodyUI(mGraphics g, int cx1, int cy2, int f)`](../source/src/main/java/nso/Char.java#L3326) | 3326–3339 | `bp.j(Lt;III)V` | `reference_proposal` |
| [`private void paintWeaponBot(mGraphics graphics, int value, int value1, int value2, DataSkillEff dataSkillEff)`](../source/src/main/java/nso/Char.java#L3341) | 3341–3372 | `bp.a(Lt;IIILy;)V` | `reference_proposal` |
| [`private void paintWeaponTop(mGraphics graphics, int value, int value1, int value2, DataSkillEff dataSkillEff)`](../source/src/main/java/nso/Char.java#L3374) | 3374–3405 | `bp.b(Lt;IIILy;)V` | `reference_proposal` |
| [`private void paintBody(mGraphics graphics, int value, int value1, int value2)`](../source/src/main/java/nso/Char.java#L3407) | 3407–3417 | `bp.k(Lt;III)V` | `reference_proposal` |
| [`private int getys()`](../source/src/main/java/nso/Char.java#L3419) | 3419–3435 | `bp.ae()I` | `reference_proposal` |
| [`private int getxs()`](../source/src/main/java/nso/Char.java#L3437) | 3437–3465 | `bp.af()I` | `reference_proposal` |
| [`private void paintHair(mGraphics graphics, int value, int value1, int value2)`](../source/src/main/java/nso/Char.java#L3467) | 3467–3477 | `bp.l(Lt;III)V` | `reference_proposal` |
| [`private void paintMatna(mGraphics g, int cx1, int cy2, int f)`](../source/src/main/java/nso/Char.java#L3479) | 3479–3507 | `bp.m(Lt;III)V` | `reference_proposal` |
| [`private void paintPP_Bot(mGraphics graphics)`](../source/src/main/java/nso/Char.java#L3509) | 3509–3576 | `bp.d(Lt;)V` | `reference_proposal` |
| [`private void paintPP_Top(mGraphics graphics)`](../source/src/main/java/nso/Char.java#L3578) | 3578–3645 | `bp.e(Lt;)V` | `reference_proposal` |
| [`private int getDyHorse()`](../source/src/main/java/nso/Char.java#L3647) | 3647–3654 | `bp.ag()I` | `reference_proposal` |
| [`private void paintCharWithoutSkill(mGraphics g)`](../source/src/main/java/nso/Char.java#L3656) | 3656–4505 | `bp.f(Lt;)V` | `reference_proposal` |
| [`private int getLegId()`](../source/src/main/java/nso/Char.java#L4507) | 4507–4552 | `bp.ah()I` | `reference_proposal` |
| [`private int getBodyPaintId()`](../source/src/main/java/nso/Char.java#L4554) | 4554–5851 | `bp.ai()I` | `reference_proposal` |
| [`private int getHeadId()`](../source/src/main/java/nso/Char.java#L5853) | 5853–7519 | `bp.aj()I` | `reference_proposal` |
| [`private int[] getClanEffect()`](../source/src/main/java/nso/Char.java#L7521) | 7521–7549 | `bp.ak()[I` | `reference_proposal` |
| [`public final void paintClanEffect(mGraphics graphics, int value, int value1)`](../source/src/main/java/nso/Char.java#L7551) | 7551–7565 | `bp.c(Lt;II)V` | `reference_proposal` |
| [`private void paintClanEffectRun(mGraphics g, int x, int y)`](../source/src/main/java/nso/Char.java#L7567) | 7567–7583 | `bp.e(Lt;II)V` | `reference_proposal` |
| [`public final void paintClanEffect2(mGraphics graphics, int value, int value1)`](../source/src/main/java/nso/Char.java#L7585) | 7585–7590 | `bp.d(Lt;II)V` | `reference_proposal` |
| [`private void callEff(int value)`](../source/src/main/java/nso/Char.java#L7592) | 7592–7595 | `bp.n(I)V` | `reference_proposal` |
| [`public final void callEffTask(int value)`](../source/src/main/java/nso/Char.java#L7597) | 7597–7600 | `bp.c(I)V` | `reference_proposal` |
| [`public static int getIndexChar(int ID)`](../source/src/main/java/nso/Char.java#L7602) | 7602–7609 | `bp.d(I)I` | `reference_proposal` |
| [`public final void moveTo(int toX, int toY)`](../source/src/main/java/nso/Char.java#L7611) | 7611–7656 | `bp.a(II)V` | `reference_proposal` |
| [`private void searchFocus()`](../source/src/main/java/nso/Char.java#L7658) | 7658–8072 | `bp.al()V` | `reference_proposal` |
| [`private void clearFocus(int index)`](../source/src/main/java/nso/Char.java#L8074) | 8074–8094 | `bp.o(I)V` | `reference_proposal` |
| [`public static boolean isCharInScreen(Char c)`](../source/src/main/java/nso/Char.java#L8096) | 8096–8102 | `bp.a(Lbp;)Z` | `reference_proposal` |
| [`public final void findNextFocusByKey()`](../source/src/main/java/nso/Char.java#L8104) | 8104–8322 | `bp.u()V` | `reference_proposal` |
| [`public final void deFocusNPC()`](../source/src/main/java/nso/Char.java#L8324) | 8324–8329 | `bp.v()V` | `reference_proposal` |
| [`private void updateCharInBridge()`](../source/src/main/java/nso/Char.java#L8331) | 8331–8346 | `bp.am()V` | `reference_proposal` |
| [`public final void itemMonToBag(Message msg)`](../source/src/main/java/nso/Char.java#L8348) | 8348–8367 | `bp.b(Lce;)V` | `reference_proposal` |
| [`public final void itemBodyToBag(Message msg)`](../source/src/main/java/nso/Char.java#L8369) | 8369–8393 | `bp.c(Lce;)V` | `reference_proposal` |
| [`public final void itemBagToBox(Message msg)`](../source/src/main/java/nso/Char.java#L8395) | 8395–8422 | `bp.d(Lce;)V` | `reference_proposal` |
| [`public final void itemBoxToBag(Message msg)`](../source/src/main/java/nso/Char.java#L8424) | 8424–8451 | `bp.e(Lce;)V` | `reference_proposal` |
| [`public static void crystalCollect(Message msg, boolean isCoin)`](../source/src/main/java/nso/Char.java#L8453) | 8453–8490 | `bp.a(Lce;Z)V` | `reference_proposal` |
| [`private static void kickOption(Item item, int maxKick)`](../source/src/main/java/nso/Char.java#L8492) | 8492–8516 | `bp.a(Lby;I)V` | `reference_proposal` |
| [`public final void updateKickOption()`](../source/src/main/java/nso/Char.java#L8518) | 8518–8577 | `bp.w()V` | `reference_proposal` |
| [`public final void doInjure(int HPShow, int MPShow, boolean isBoss, int idBoss)`](../source/src/main/java/nso/Char.java#L8579) | 8579–8628 | `bp.a(IIZI)V` | `reference_proposal` |
| [`private void startDie(short toX, short toY)`](../source/src/main/java/nso/Char.java#L8630) | 8630–8644 | `bp.b(SS)V` | `reference_proposal` |
| [`public final void waitToDie(short shortValue, short shortValue1)`](../source/src/main/java/nso/Char.java#L8646) | 8646–8649 | `bp.a(SS)V` | `reference_proposal` |
| [`private void changeStatusStand()`](../source/src/main/java/nso/Char.java#L8651) | 8651–8655 | `bp.an()V` | `reference_proposal` |
| [`public final void liveFromDead()`](../source/src/main/java/nso/Char.java#L8657) | 8657–8664 | `bp.x()V` | `reference_proposal` |
| [`public final boolean doUsePotion(int type)`](../source/src/main/java/nso/Char.java#L8666) | 8666–8677 | `bp.e(I)Z` | `reference_proposal` |
| [`private static boolean isLang()`](../source/src/main/java/nso/Char.java#L8679) | 8679–8681 | `bp.ao()Z` | `reference_proposal` |
| [`public final boolean isMeCanAttackOtherPlayer(Char cAtt)`](../source/src/main/java/nso/Char.java#L8683) | 8683–8716 | `bp.b(Lbp;)Z` | `reference_proposal` |
| [`private static boolean isTeam(Char c)`](../source/src/main/java/nso/Char.java#L8718) | 8718–8726 | `bp.c(Lbp;)Z` | `reference_proposal` |
| [`public static void clearTask()`](../source/src/main/java/nso/Char.java#L8728) | 8728–8737 | `bp.y()V` | `reference_proposal` |
| [`public static int getCT()`](../source/src/main/java/nso/Char.java#L8739) | 8739–8749 | `bp.z()I` | `reference_proposal` |
| [`public final boolean isHumanz()`](../source/src/main/java/nso/Char.java#L8751) | 8751–8753 | `bp.A()Z` | `reference_proposal` |
| [`public final boolean isNhanbanz()`](../source/src/main/java/nso/Char.java#L8755) | 8755–8757 | `bp.B()Z` | `reference_proposal` |
| [`public final void GetNewMount()`](../source/src/main/java/nso/Char.java#L8759) | 8759–8761 | `bp.C()V` | `reference_proposal` |
| [`public final boolean isHaveNewMount()`](../source/src/main/java/nso/Char.java#L8763) | 8763–8765 | `bp.D()Z` | `reference_proposal` |
| [`private void updNewMount()`](../source/src/main/java/nso/Char.java#L8767) | 8767–8800 | `bp.ap()V` | `reference_proposal` |
| [`private void paintBehindNewMount(mGraphics g)`](../source/src/main/java/nso/Char.java#L8802) | 8802–8808 | `bp.g(Lt;)V` | `reference_proposal` |
| [`private void paintNewMount(mGraphics graphics, Part part, Part part1, int[] values)`](../source/src/main/java/nso/Char.java#L8810) | 8810–8841 | `bp.a(Lt;Ldr;Ldr;[I)V` | `reference_proposal` |
| [`public final void setThoiTrang(short[] arr1)`](../source/src/main/java/nso/Char.java#L8843) | 8843–8859 | `bp.a([S)V` | `reference_proposal` |

## nso.EggMonters

Dữ liệu có các field `x`, `y`, `frame`, `status`.

[Source](../source/src/main/java/nso/EggMonters.java) · [Mapping](../mapping/classes/nso_EggMonters.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoeggmonters)

`public final class EggMonters`

Identity class: `bt`; status: `reference_proposal`; source: **39 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public final boolean isPaint()`](../source/src/main/java/nso/EggMonters.java#L17) | 17–27 | `bt.a()Z` | `reference_proposal` |
| [`public EggMonters(int x1, int y2)`](../source/src/main/java/nso/EggMonters.java#L29) | 29–38 | `bt.<init>(II)V` | `preserved` |

## nso.ItemMap

Vật phẩm nằm trên map.

[Source](../source/src/main/java/nso/ItemMap.java) · [Mapping](../mapping/classes/nso_ItemMap.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoitemmap)

`public final class ItemMap`

Identity class: `dl`; status: `reference_proposal`; source: **51 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public ItemMap(short itemMapID1, short itemTemplateID, int x2, int y3, int xEnd4, int yEnd5)`](../source/src/main/java/nso/ItemMap.java#L25) | 25–34 | `dl.<init>(SSIIII)V` | `preserved` |
| [`public ItemMap(short itemMapID1, short itemTemplateID, int x2, int y3)`](../source/src/main/java/nso/ItemMap.java#L36) | 36–42 | `dl.<init>(SSII)V` | `preserved` |
| [`public final void setPoint(int xEnd1, int yEnd2)`](../source/src/main/java/nso/ItemMap.java#L44) | 44–50 | `dl.a(II)V` | `reference_proposal` |

## nso.ItemTree

Đối tượng ItemTree có dữ liệu/vẽ riêng.

[Source](../source/src/main/java/nso/ItemTree.java) · [Mapping](../mapping/classes/nso_ItemTree.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoitemtree)

`public final class ItemTree`

Identity class: `ca`; status: `reference_proposal`; source: **31 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public ItemTree(int x, int y)`](../source/src/main/java/nso/ItemTree.java#L14) | 14–17 | `ca.<init>(II)V` | `preserved` |
| [`private Object getImageFromHash()`](../source/src/main/java/nso/ItemTree.java#L19) | 19–22 | `ca.a()Ljava/lang/Object;` | `reference_proposal` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/ItemTree.java#L24) | 24–30 | `ca.a(Lt;)V` | `reference_proposal` |

## nso.Lanterns

Dữ liệu có các field `x`, `y`, `dy`, `yStart`.

[Source](../source/src/main/java/nso/Lanterns.java) · [Mapping](../mapping/classes/nso_Lanterns.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsolanterns)

`public final class Lanterns`

Identity class: `ac`; status: `reference_proposal`; source: **20 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Lanterns(int x1, int y2)`](../source/src/main/java/nso/Lanterns.java#L15) | 15–19 | `ac.<init>(II)V` | `preserved` |

## nso.Mob

Dữ liệu, trạng thái, cập nhật và render quái.

[Source](../source/src/main/java/nso/Mob.java) · [Mapping](../mapping/classes/nso_Mob.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsomob)

`public final class Mob extends MainObject`

Identity class: `ci`; status: `reference_proposal`; source: **2025 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Mob(short mobId1, boolean isDisable2, boolean isDontMove3, boolean isFire4, boolean isIce5, boolean isWind6, int templateId7, int sys8, int hp9, int level10, int maxhp, short pointx, short pointy, byte status11, byte levelBoss12, boolean isBos, boolean removeWhenDie)`](../source/src/main/java/nso/Mob.java#L124) | 124–160 | `ci.<init>(SZZZZZIIIIISSBBZZ)V` | `preserved` |
| [`public final void updateMobAttack()`](../source/src/main/java/nso/Mob.java#L162) | 162–888 | `ci.a()V` | `reference_proposal` |
| [`public final void setInjure()`](../source/src/main/java/nso/Mob.java#L890) | 890–895 | `ci.b()V` | `reference_proposal` |
| [`public final void setAttack(Char cFocus1)`](../source/src/main/java/nso/Mob.java#L897) | 897–921 | `ci.a(Lbp;)V` | `reference_proposal` |
| [`public final void setAttack(BuNhin bFocus1)`](../source/src/main/java/nso/Mob.java#L923) | 923–929 | `ci.a(Ldk;)V` | `reference_proposal` |
| [`private void updateInjure()`](../source/src/main/java/nso/Mob.java#L931) | 931–976 | `ci.h()V` | `reference_proposal` |
| [`private void updateTypeMobAttk()`](../source/src/main/java/nso/Mob.java#L978) | 978–1031 | `ci.i()V` | `reference_proposal` |
| [`public static int getDistance(int x1, int y2, int x2, int y23)`](../source/src/main/java/nso/Mob.java#L1033) | 1033–1046 | `ci.a(IIII)I` | `reference_proposal` |
| [`private void updateMobWalk()`](../source/src/main/java/nso/Mob.java#L1048) | 1048–1258 | `ci.j()V` | `reference_proposal` |
| [`public final MobTemplate getTemplate()`](../source/src/main/java/nso/Mob.java#L1260) | 1260–1262 | `ci.c()La;` | `reference_proposal` |
| [`public final boolean isPaint()`](../source/src/main/java/nso/Mob.java#L1264) | 1264–1296 | `ci.d()Z` | `reference_proposal` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/Mob.java#L1298) | 1298–1607 | `ci.a(Lt;)V` | `reference_proposal` |
| [`public final int getHPColor()`](../source/src/main/java/nso/Mob.java#L1609) | 1609–1617 | `ci.e()I` | `reference_proposal` |
| [`public final void startDie()`](../source/src/main/java/nso/Mob.java#L1619) | 1619–1632 | `ci.f()V` | `reference_proposal` |
| [`public final void attackOtherMob(Mob mobToAttack1)`](../source/src/main/java/nso/Mob.java#L1634) | 1634–1636 | `ci.a(Lci;)V` | `reference_proposal` |
| [`public final void attackOtherChar(Char character)`](../source/src/main/java/nso/Mob.java#L1638) | 1638–1640 | `ci.b(Lbp;)V` | `reference_proposal` |
| [`private void setatk_mob()`](../source/src/main/java/nso/Mob.java#L1642) | 1642–1681 | `ci.k()V` | `reference_proposal` |
| [`public final void setTypeAtk(short idSkill_atk1, byte typeAtk2, byte typeTool3)`](../source/src/main/java/nso/Mob.java#L1683) | 1683–1687 | `ci.a(SBB)V` | `reference_proposal` |
| [`public final void attackOtherInRange()`](../source/src/main/java/nso/Mob.java#L1689) | 1689–1715 | `ci.g()V` | `reference_proposal` |
| [`private int setFrameMove(int Gametick)`](../source/src/main/java/nso/Mob.java#L1717) | 1717–1720 | `ci.b(I)I` | `reference_proposal` |
| [`private int setFrameAppear(int value)`](../source/src/main/java/nso/Mob.java#L1722) | 1722–1729 | `ci.c(I)I` | `reference_proposal` |
| [`private int setFrameAtt(int Gametick)`](../source/src/main/java/nso/Mob.java#L1731) | 1731–1824 | `ci.d(I)I` | `reference_proposal` |
| [`private int setFrameDisappear(int value)`](../source/src/main/java/nso/Mob.java#L1826) | 1826–1833 | `ci.e(I)I` | `reference_proposal` |
| [`private void updateAttk_Thunuoi()`](../source/src/main/java/nso/Mob.java#L1835) | 1835–1890 | `ci.l()V` | `reference_proposal` |
| [`public static Mob get_Mob(int ID)`](../source/src/main/java/nso/Mob.java#L1892) | 1892–1900 | `ci.a(I)Lci;` | `reference_proposal` |
| [`public final void paintBoTomMobNew(mGraphics g, int x1, int y2)`](../source/src/main/java/nso/Mob.java#L1902) | 1902–1943 | `ci.a(Lt;II)V` | `reference_proposal` |
| [`public final void paintTopMobNew(mGraphics g, int x1, int y2)`](../source/src/main/java/nso/Mob.java#L1945) | 1945–1979 | `ci.b(Lt;II)V` | `reference_proposal` |
| [`private void paintBottomMobNew(mGraphics graphics)`](../source/src/main/java/nso/Mob.java#L1981) | 1981–2024 | `ci.b(Lt;)V` | `reference_proposal` |

## nso.MobAttack

Dữ liệu/cập nhật đòn tấn công của mob.

[Source](../source/src/main/java/nso/MobAttack.java) · [Mapping](../mapping/classes/nso_MobAttack.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsomobattack)

`public final class MobAttack`

Identity class: `al`; status: `reference_proposal`; source: **70 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public final void update()`](../source/src/main/java/nso/MobAttack.java#L30) | 30–69 | `al.a()V` | `reference_proposal` |

## nso.MobSoul

Đối tượng MobSoul có update/paint.

[Source](../source/src/main/java/nso/MobSoul.java) · [Mapping](../mapping/classes/nso_MobSoul.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsomobsoul)

`public final class MobSoul`

Identity class: `bk`; status: `reference_proposal`; source: **125 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public MobSoul(int x1, int y2, Char c3)`](../source/src/main/java/nso/MobSoul.java#L29) | 29–37 | `bk.<init>(IILbp;)V` | `preserved` |
| [`public MobSoul(int cx, int cy)`](../source/src/main/java/nso/MobSoul.java#L39) | 39–53 | `bk.<init>(II)V` | `preserved` |
| [`public final void update()`](../source/src/main/java/nso/MobSoul.java#L55) | 55–106 | `bk.a()V` | `reference_proposal` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/MobSoul.java#L108) | 108–124 | `bk.a(Lt;)V` | `reference_proposal` |

## nso.MonsterDart

Đạn/phi tiêu từ mob và logic frame liên quan.

[Source](../source/src/main/java/nso/MonsterDart.java) · [Mapping](../mapping/classes/nso_MonsterDart.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsomonsterdart)

`public final class MonsterDart extends Effect2`

Identity class: `dp`; status: `reference_proposal`; source: **328 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`private void setAngle(int angle)`](../source/src/main/java/nso/MonsterDart.java#L56) | 56–60 | `dp.a(I)V` | `reference_proposal` |
| [`public static void addMonsterDart(int x1, int y2, boolean isBoss3, short levelBoss, int idBoss4, int dame5, int dameMp6, Char c7)`](../source/src/main/java/nso/MonsterDart.java#L62) | 62–65 | `dp.a(IIZSIIILbp;)V` | `reference_proposal` |
| [`public static void addMonsterDart(int x1, int y2, BuNhin b3)`](../source/src/main/java/nso/MonsterDart.java#L67) | 67–69 | `dp.a(IILdk;)V` | `reference_proposal` |
| [`private MonsterDart(int x1, int y2, boolean isBoss3, short levelBoss, int idBoss4, int dame5, int dameMp6, Char c7)`](../source/src/main/java/nso/MonsterDart.java#L71) | 71–94 | `dp.<init>(IIZSIIILbp;)V` | `preserved` |
| [`private MonsterDart(int x1, int y2, BuNhin b3)`](../source/src/main/java/nso/MonsterDart.java#L96) | 96–110 | `dp.<init>(IILdk;)V` | `preserved` |
| [`public final void update()`](../source/src/main/java/nso/MonsterDart.java#L112) | 112–223 | `dp.a()V` | `reference_proposal` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/MonsterDart.java#L225) | 225–327 | `dp.a(Lt;)V` | `reference_proposal` |

## nso.MovePoint

Điểm di chuyển.

[Source](../source/src/main/java/nso/MovePoint.java) · [Mapping](../mapping/classes/nso_MovePoint.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsomovepoint)

`public final class MovePoint`

Identity class: `cd`; status: `reference_proposal`; source: **21 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public MovePoint(int xEnd1, int yEnd2, int act, int dir)`](../source/src/main/java/nso/MovePoint.java#L11) | 11–15 | `cd.<init>(IIII)V` | `preserved` |
| [`public MovePoint(int xEnd1, int yEnd2)`](../source/src/main/java/nso/MovePoint.java#L17) | 17–20 | `cd.<init>(II)V` | `preserved` |

## nso.Npc

Thực thể NPC kế thừa Char, update/paint và tương tác.

[Source](../source/src/main/java/nso/Npc.java) · [Mapping](../mapping/classes/nso_Npc.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsonpc)

`public final class Npc extends Char`

Identity class: `cy`; status: `reference_proposal`; source: **113 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Npc(int npcId, int status, int cx, int cy, int templateId)`](../source/src/main/java/nso/Npc.java#L11) | 11–16 | `cy.<init>(IIIII)V` | `preserved` |
| [`public static void clearEffTask()`](../source/src/main/java/nso/Npc.java#L18) | 18–24 | `cy.E()V` | `reference_proposal` |
| [`public final void update()`](../source/src/main/java/nso/Npc.java#L26) | 26–56 | `cy.h()V` | `reference_proposal` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/Npc.java#L58) | 58–112 | `cy.a(Lt;)V` | `reference_proposal` |

## nso.Waypoint

Dữ liệu cổng/vùng chuyển map.

[Source](../source/src/main/java/nso/Waypoint.java) · [Mapping](../mapping/classes/nso_Waypoint.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsowaypoint)

`public final class Waypoint`

Identity class: `ah`; status: `reference_proposal`; source: **19 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Waypoint(short minX1, short minY2, short maxX3, short maxY4)`](../source/src/main/java/nso/Waypoint.java#L13) | 13–18 | `ah.<init>(SSSS)V` | `preserved` |

## nso.MyVector

Lớp chứa dữ liệu dựa trên Vector.

[Source](../source/src/main/java/nso/MyVector.java) · [Mapping](../mapping/classes/nso_MyVector.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsomyvector)

`public final class MyVector extends Vector`

Identity class: `aa`; status: `reference_proposal`; source: **33 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public MyVector()`](../source/src/main/java/nso/MyVector.java#L7) | 7–8 | `aa.<init>()V` | `preserved` |
| [`public final synchronized void addElement(Object o)`](../source/src/main/java/nso/MyVector.java#L10) | 10–12 | `aa.addElement(Ljava/lang/Object;)V` | `preserved` |
| [`public final synchronized Object elementAt(int index)`](../source/src/main/java/nso/MyVector.java#L14) | 14–16 | `aa.elementAt(I)Ljava/lang/Object;` | `preserved` |
| [`public final synchronized void removeAllElements()`](../source/src/main/java/nso/MyVector.java#L18) | 18–20 | `aa.removeAllElements()V` | `preserved` |
| [`public final synchronized boolean removeElement(Object o)`](../source/src/main/java/nso/MyVector.java#L22) | 22–24 | `aa.removeElement(Ljava/lang/Object;)Z` | `preserved` |
| [`public final synchronized void insertElementAt(Object o, int i)`](../source/src/main/java/nso/MyVector.java#L26) | 26–28 | `aa.insertElementAt(Ljava/lang/Object;I)V` | `preserved` |
| [`public final synchronized void removeElementAt(int index)`](../source/src/main/java/nso/MyVector.java#L30) | 30–32 | `aa.removeElementAt(I)V` | `preserved` |

## nso.NinjaUtil

Tiện ích được các class game gọi.

[Source](../source/src/main/java/nso/NinjaUtil.java) · [Mapping](../mapping/classes/nso_NinjaUtil.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoninjautil)

`public final class NinjaUtil`

Identity class: `at`; status: `reference_proposal`; source: **156 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public NinjaUtil()`](../source/src/main/java/nso/NinjaUtil.java#L12) | 12–13 | `at.<init>()V` | `preserved` |
| [`public static int randomNumber(int max)`](../source/src/main/java/nso/NinjaUtil.java#L15) | 15–17 | `at.a(I)I` | `reference_proposal` |
| [`public static int random(int a, int b)`](../source/src/main/java/nso/NinjaUtil.java#L19) | 19–21 | `at.a(II)I` | `reference_proposal` |
| [`public static byte[] readByteArray_Int(Message message)`](../source/src/main/java/nso/NinjaUtil.java#L23) | 23–32 | `at.a(Lce;)[B` | `reference_proposal` |
| [`public static byte[] readByteArray(Message message)`](../source/src/main/java/nso/NinjaUtil.java#L34) | 34–43 | `at.b(Lce;)[B` | `reference_proposal` |
| [`public static byte[] readByteArray(DataInputStream dos)`](../source/src/main/java/nso/NinjaUtil.java#L45) | 45–54 | `at.a(Ljava/io/DataInputStream;)[B` | `reference_proposal` |
| [`public static String replace(String text, String regex, String replacement)`](../source/src/main/java/nso/NinjaUtil.java#L56) | 56–65 | `at.a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;` | `reference_proposal` |
| [`public static String numberToString(String number)`](../source/src/main/java/nso/NinjaUtil.java#L67) | 67–85 | `at.a(Ljava/lang/String;)Ljava/lang/String;` | `reference_proposal` |
| [`public static void sendMsDK(String syntax, short port)`](../source/src/main/java/nso/NinjaUtil.java#L87) | 87–89 | `at.a(Ljava/lang/String;S)V` | `reference_proposal` |
| [`public static void downloadGame(String url)`](../source/src/main/java/nso/NinjaUtil.java#L91) | 91–99 | `at.b(Ljava/lang/String;)V` | `reference_proposal` |
| [`public static String getTime(int timeRemainS)`](../source/src/main/java/nso/NinjaUtil.java#L101) | 101–140 | `at.b(I)Ljava/lang/String;` | `reference_proposal` |
| [`public static String[] split(String _text, String _searchStr)`](../source/src/main/java/nso/NinjaUtil.java#L142) | 142–155 | `at.a(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;` | `reference_proposal` |

## nso.RMS

Wrapper RecordStore cho byte/int/string/ảnh.

[Source](../source/src/main/java/nso/RMS.java) · [Mapping](../mapping/classes/nso_RMS.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsorms)

`public final class RMS`

Identity class: `w`; status: `reference_proposal`; source: **102 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public RMS()`](../source/src/main/java/nso/RMS.java#L7) | 7–8 | `w.<init>()V` | `preserved` |
| [`public static void saveRMS(String text, byte[] data)`](../source/src/main/java/nso/RMS.java#L10) | 10–21 | `w.a(Ljava/lang/String;[B)V` | `reference_proposal` |
| [`public static byte[] loadRMS(String text)`](../source/src/main/java/nso/RMS.java#L23) | 23–32 | `w.a(Ljava/lang/String;)[B` | `reference_proposal` |
| [`public static void saveRMSInt(String file, int x)`](../source/src/main/java/nso/RMS.java#L34) | 34–39 | `w.a(Ljava/lang/String;I)V` | `reference_proposal` |
| [`public static void saveRMSString(String filename, String data)`](../source/src/main/java/nso/RMS.java#L41) | 41–47 | `w.a(Ljava/lang/String;Ljava/lang/String;)V` | `reference_proposal` |
| [`public static String loadRMSString(String fileName)`](../source/src/main/java/nso/RMS.java#L49) | 49–59 | `w.b(Ljava/lang/String;)Ljava/lang/String;` | `reference_proposal` |
| [`public static int loadRMSInt(String file)`](../source/src/main/java/nso/RMS.java#L61) | 61–64 | `w.c(Ljava/lang/String;)I` | `reference_proposal` |
| [`private static void deleteRecord(String name)`](../source/src/main/java/nso/RMS.java#L66) | 66–71 | `w.d(Ljava/lang/String;)V` | `reference_proposal` |
| [`public static void saveRMSImage(String text, byte[] data)`](../source/src/main/java/nso/RMS.java#L73) | 73–85 | `w.b(Ljava/lang/String;[B)V` | `reference_proposal` |
| [`public static void clearRMS()`](../source/src/main/java/nso/RMS.java#L87) | 87–101 | `w.a()V` | `reference_proposal` |

## nso.Res

Toán, random, tách chuỗi, khoảng cách và countdown.

[Source](../source/src/main/java/nso/Res.java) · [Mapping](../mapping/classes/nso_Res.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsores)

`public final class Res`

Identity class: `am`; status: `reference_proposal`; source: **211 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Res()`](../source/src/main/java/nso/Res.java#L16) | 16–17 | `am.<init>()V` | `preserved` |
| [`public static void init()`](../source/src/main/java/nso/Res.java#L19) | 19–30 | `am.a()V` | `reference_proposal` |
| [`public static final int sin(int a)`](../source/src/main/java/nso/Res.java#L32) | 32–40 | `am.a(I)I` | `reference_proposal` |
| [`public static final int cos(int a)`](../source/src/main/java/nso/Res.java#L42) | 42–50 | `am.b(I)I` | `reference_proposal` |
| [`public static final int angle(int value, int value1)`](../source/src/main/java/nso/Res.java#L52) | 52–80 | `am.a(II)I` | `reference_proposal` |
| [`public static final int fixangle(int value)`](../source/src/main/java/nso/Res.java#L82) | 82–90 | `am.c(I)I` | `reference_proposal` |
| [`public static int xetVX(int value, int value1)`](../source/src/main/java/nso/Res.java#L92) | 92–94 | `am.b(II)I` | `reference_proposal` |
| [`public static int xetVY(int value, int value1)`](../source/src/main/java/nso/Res.java#L96) | 96–98 | `am.c(II)I` | `reference_proposal` |
| [`public static int random(int value, int value1)`](../source/src/main/java/nso/Res.java#L100) | 100–102 | `am.d(II)I` | `reference_proposal` |
| [`public static int distance(int x1, int y1, int x2, int y2)`](../source/src/main/java/nso/Res.java#L104) | 104–114 | `am.a(IIII)I` | `reference_proposal` |
| [`public static int rnd(int value)`](../source/src/main/java/nso/Res.java#L116) | 116–118 | `am.d(I)I` | `reference_proposal` |
| [`public static int abs(int value)`](../source/src/main/java/nso/Res.java#L120) | 120–122 | `am.e(I)I` | `reference_proposal` |
| [`public static void resetTrans(mGraphics g)`](../source/src/main/java/nso/Res.java#L124) | 124–127 | `am.a(Lt;)V` | `reference_proposal` |
| [`public static String[] split(String original, String separator, int count)`](../source/src/main/java/nso/Res.java#L129) | 129–140 | `am.a(Ljava/lang/String;Ljava/lang/String;I)[Ljava/lang/String;` | `reference_proposal` |
| [`public static String getTimeCountDown(long timeStart, int milisecondCount)`](../source/src/main/java/nso/Res.java#L142) | 142–210 | `am.a(JI)Ljava/lang/String;` | `reference_proposal` |

## nso.StaticObj

Dữ liệu/hằng dùng chung.

[Source](../source/src/main/java/nso/StaticObj.java) · [Mapping](../mapping/classes/nso_StaticObj.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsostaticobj)

`public final class StaticObj`

Identity class: `ch`; status: `reference_proposal`; source: **27 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public StaticObj()`](../source/src/main/java/nso/StaticObj.java#L25) | 25–26 | `ch.<init>()V` | `preserved` |

## nso.StringHashtable

Bảng tra với key String.

[Source](../source/src/main/java/nso/StringHashtable.java) · [Mapping](../mapping/classes/nso_StringHashtable.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsostringhashtable)

`public final class StringHashtable extends Hashtable`

Identity class: `bm`; status: `behavioral_name`; source: **25 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public StringHashtable()`](../source/src/main/java/nso/StringHashtable.java#L7) | 7–8 | `bm.<init>()V` | `preserved` |
| [`public final synchronized Object put(String text, Object argument)`](../source/src/main/java/nso/StringHashtable.java#L10) | 10–12 | `bm.a(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;` | `behavioral_name` |
| [`public final synchronized void clear()`](../source/src/main/java/nso/StringHashtable.java#L14) | 14–16 | `bm.clear()V` | `preserved` |
| [`public final synchronized Object remove(Object argument)`](../source/src/main/java/nso/StringHashtable.java#L18) | 18–20 | `bm.remove(Ljava/lang/Object;)Ljava/lang/Object;` | `preserved` |
| [`public final synchronized Object get(String text)`](../source/src/main/java/nso/StringHashtable.java#L22) | 22–24 | `bm.a(Ljava/lang/String;)Ljava/lang/Object;` | `behavioral_name` |

## nso.mHashtable

Lớp chứa dữ liệu dựa trên Hashtable.

[Source](../source/src/main/java/nso/mHashtable.java) · [Mapping](../mapping/classes/nso_mHashtable.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsomhashtable)

`public final class mHashtable`

Identity class: `cq`; status: `reference_proposal`; source: **23 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public mHashtable()`](../source/src/main/java/nso/mHashtable.java#L9) | 9–10 | `cq.<init>()V` | `preserved` |
| [`public final Object get(Object k)`](../source/src/main/java/nso/mHashtable.java#L12) | 12–14 | `cq.a(Ljava/lang/Object;)Ljava/lang/Object;` | `reference_proposal` |
| [`public final boolean equals(Object argument)`](../source/src/main/java/nso/mHashtable.java#L16) | 16–18 | `cq.equals(Ljava/lang/Object;)Z` | `preserved` |
| [`public final void put(Object k, Object v)`](../source/src/main/java/nso/mHashtable.java#L20) | 20–22 | `cq.a(Ljava/lang/Object;Ljava/lang/Object;)V` | `reference_proposal` |

## nso.mResources

Chuỗi giao diện và dữ liệu ngôn ngữ.

[Source](../source/src/main/java/nso/mResources.java) · [Mapping](../mapping/classes/nso_mResources.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsomresources)

`public final class mResources`

Identity class: `df`; status: `reference_proposal`; source: **2072 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public mResources()`](../source/src/main/java/nso/mResources.java#L1027) | 1027–1028 | `df.<init>()V` | `preserved` |
| [`public static void loadLanguage(int languageID)`](../source/src/main/java/nso/mResources.java#L1030) | 1030–2067 | `df.a(I)V` | `reference_proposal` |
| [`public static String replace(String str, String replacement)`](../source/src/main/java/nso/mResources.java#L2069) | 2069–2071 | `df.a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;` | `reference_proposal` |

## nso.ChatManager

Quản lý dữ liệu/tab chat.

[Source](../source/src/main/java/nso/ChatManager.java) · [Mapping](../mapping/classes/nso_ChatManager.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsochatmanager)

`public final class ChatManager`

Identity class: `bg`; status: `reference_proposal`; source: **129 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public final void switchToNextTab()`](../source/src/main/java/nso/ChatManager.java#L23) | 23–28 | `bg.a()V` | `reference_proposal` |
| [`public final void switchToPreviousTab()`](../source/src/main/java/nso/ChatManager.java#L30) | 30–35 | `bg.b()V` | `reference_proposal` |
| [`public final void switchToTab(int index)`](../source/src/main/java/nso/ChatManager.java#L37) | 37–39 | `bg.a(I)V` | `reference_proposal` |
| [`public final void switchToTab(ChatTab t)`](../source/src/main/java/nso/ChatManager.java#L41) | 41–43 | `bg.a(Lbq;)V` | `reference_proposal` |
| [`public final void switchToLastTab()`](../source/src/main/java/nso/ChatManager.java#L45) | 45–47 | `bg.c()V` | `reference_proposal` |
| [`public static ChatManager gI()`](../source/src/main/java/nso/ChatManager.java#L49) | 49–51 | `bg.d()Lbg;` | `reference_proposal` |
| [`public ChatManager()`](../source/src/main/java/nso/ChatManager.java#L53) | 53–66 | `bg.<init>()V` | `preserved` |
| [`public final ChatTab findTab(String ownerName)`](../source/src/main/java/nso/ChatManager.java#L68) | 68–76 | `bg.a(Ljava/lang/String;)Lbq;` | `reference_proposal` |
| [`public final void addChat(String ownerName, String whoChat, String text)`](../source/src/main/java/nso/ChatManager.java#L78) | 78–84 | `bg.a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V` | `reference_proposal` |
| [`public final ChatTab getCurrentChatTab()`](../source/src/main/java/nso/ChatManager.java#L86) | 86–88 | `bg.e()Lbq;` | `reference_proposal` |
| [`public final ChatTab addNewTab(String friendName)`](../source/src/main/java/nso/ChatManager.java#L90) | 90–97 | `bg.b(Ljava/lang/String;)Lbq;` | `reference_proposal` |
| [`public final void addWaitList(String nick)`](../source/src/main/java/nso/ChatManager.java#L99) | 99–106 | `bg.c(Ljava/lang/String;)V` | `reference_proposal` |
| [`public final boolean findWaitPerson(String nick)`](../source/src/main/java/nso/ChatManager.java#L108) | 108–115 | `bg.d(Ljava/lang/String;)Z` | `reference_proposal` |
| [`public final void removeFromWaitList(String nick)`](../source/src/main/java/nso/ChatManager.java#L117) | 117–124 | `bg.e(Ljava/lang/String;)V` | `reference_proposal` |
| [`public static void clear()`](../source/src/main/java/nso/ChatManager.java#L126) | 126–128 | `bg.f()V` | `reference_proposal` |

## nso.ChatPopup

Bong bóng/nội dung chat có vòng đời và paint.

[Source](../source/src/main/java/nso/ChatPopup.java) · [Mapping](../mapping/classes/nso_ChatPopup.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsochatpopup)

`public final class ChatPopup extends Effect2 implements IActionListener`

Identity class: `cb`; status: `reference_proposal`; source: **112 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public ChatPopup()`](../source/src/main/java/nso/ChatPopup.java#L33) | 33–34 | `cb.<init>()V` | `preserved` |
| [`public static void addChatPopupMultiLine(String chat, int howLong, Char c1)`](../source/src/main/java/nso/ChatPopup.java#L36) | 36–45 | `cb.a(Ljava/lang/String;ILbp;)V` | `reference_proposal` |
| [`public static ChatPopup addChatPopup(String chat, int howLong, Char c1)`](../source/src/main/java/nso/ChatPopup.java#L47) | 47–64 | `cb.b(Ljava/lang/String;ILbp;)Lcb;` | `reference_proposal` |
| [`public final void update()`](../source/src/main/java/nso/ChatPopup.java#L66) | 66–82 | `cb.a()V` | `reference_proposal` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/ChatPopup.java#L84) | 84–95 | `cb.a(Lt;)V` | `reference_proposal` |
| [`public final void perform(int idAction, Object p)`](../source/src/main/java/nso/ChatPopup.java#L97) | 97–111 | `cb.a(ILjava/lang/Object;)V` | `reference_proposal` |

## nso.ChatTab

Dữ liệu một tab chat.

[Source](../source/src/main/java/nso/ChatTab.java) · [Mapping](../mapping/classes/nso_ChatTab.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsochattab)

`public final class ChatTab`

Identity class: `bq`; status: `reference_proposal`; source: **55 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public ChatTab(String ownerName1, int type2)`](../source/src/main/java/nso/ChatTab.java#L11) | 11–14 | `bq.<init>(Ljava/lang/String;I)V` | `preserved` |
| [`public ChatTab()`](../source/src/main/java/nso/ChatTab.java#L16) | 16–17 | `bq.<init>()V` | `preserved` |
| [`public final void addChat(String whoChat, String text)`](../source/src/main/java/nso/ChatTab.java#L19) | 19–33 | `bq.a(Ljava/lang/String;Ljava/lang/String;)V` | `reference_proposal` |
| [`private void clear()`](../source/src/main/java/nso/ChatTab.java#L35) | 35–39 | `bq.a()V` | `reference_proposal` |
| [`public final void addInfo(String text)`](../source/src/main/java/nso/ChatTab.java#L41) | 41–54 | `bq.a(Ljava/lang/String;)V` | `reference_proposal` |

## nso.ChatTextField

Ô nhập và gửi chat.

[Source](../source/src/main/java/nso/ChatTextField.java) · [Mapping](../mapping/classes/nso_ChatTextField.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsochattextfield)

`public final class ChatTextField implements IActionListener`

Identity class: `aw`; status: `reference_proposal`; source: **92 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public static ChatTextField gI()`](../source/src/main/java/nso/ChatTextField.java#L26) | 26–28 | `aw.a()Law;` | `reference_proposal` |
| [`protected ChatTextField()`](../source/src/main/java/nso/ChatTextField.java#L30) | 30–38 | `aw.<init>()V` | `preserved` |
| [`public final void startChat(int value, GameScr gameScr, String text)`](../source/src/main/java/nso/ChatTextField.java#L40) | 40–49 | `aw.a(ILdg;Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void showChat(String str)`](../source/src/main/java/nso/ChatTextField.java#L51) | 51–61 | `aw.a(Ljava/lang/String;)V` | `behavioral_name` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/ChatTextField.java#L63) | 63–67 | `aw.a(Lt;)V` | `reference_proposal` |
| [`public final void perform(int idAction, Object p)`](../source/src/main/java/nso/ChatTextField.java#L69) | 69–91 | `aw.a(ILjava/lang/Object;)V` | `reference_proposal` |

## nso.Command

Nhãn/action, đối tượng xử lý và vẽ nút/lệnh.

[Source](../source/src/main/java/nso/Command.java) · [Mapping](../mapping/classes/nso_Command.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsocommand)

`public final class Command`

Identity class: `bd`; status: `reference_proposal`; source: **118 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Command(String caption1, IActionListener actionListener2, int action, Object p3, int x4, int y5)`](../source/src/main/java/nso/Command.java#L34) | 34–45 | `bd.<init>(Ljava/lang/String;Lcs;ILjava/lang/Object;II)V` | `preserved` |
| [`public Command(String caption1, IActionListener actionListener2, int action, Object p3)`](../source/src/main/java/nso/Command.java#L47) | 47–52 | `bd.<init>(Ljava/lang/String;Lcs;ILjava/lang/Object;)V` | `preserved` |
| [`public Command(String caption1, int action, Object p2)`](../source/src/main/java/nso/Command.java#L54) | 54–58 | `bd.<init>(Ljava/lang/String;ILjava/lang/Object;)V` | `preserved` |
| [`public Command(String caption1, int action)`](../source/src/main/java/nso/Command.java#L60) | 60–63 | `bd.<init>(Ljava/lang/String;I)V` | `preserved` |
| [`public Command(String caption1, int action, int x2, int y3)`](../source/src/main/java/nso/Command.java#L65) | 65–70 | `bd.<init>(Ljava/lang/String;III)V` | `preserved` |
| [`public final void performAction()`](../source/src/main/java/nso/Command.java#L72) | 72–80 | `bd.a()V` | `reference_proposal` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/Command.java#L82) | 82–95 | `bd.a(Lt;)V` | `reference_proposal` |
| [`public final boolean input()`](../source/src/main/java/nso/Command.java#L97) | 97–108 | `bd.b()Z` | `reference_proposal` |
| [`public final void updatePointer()`](../source/src/main/java/nso/Command.java#L110) | 110–117 | `bd.c()V` | `reference_proposal` |

## nso.Dialog

Base dialog và các hook input/update/paint.

[Source](../source/src/main/java/nso/Dialog.java) · [Mapping](../mapping/classes/nso_Dialog.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsodialog)

`public abstract class Dialog`

Identity class: `i`; status: `reference_proposal`; source: **87 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Dialog()`](../source/src/main/java/nso/Dialog.java#L13) | 13–14 | `i.<init>()V` | `preserved` |
| [`public void paint(mGraphics g)`](../source/src/main/java/nso/Dialog.java#L16) | 16–21 | `i.a(Lt;)V` | `reference_proposal` |
| [`public void keyPress(int keyCode)`](../source/src/main/java/nso/Dialog.java#L23) | 23–51 | `i.a(I)V` | `reference_proposal` |
| [`public void update()`](../source/src/main/java/nso/Dialog.java#L53) | 53–86 | `i.a()V` | `reference_proposal` |

## nso.IActionListener

Interface nhận action từ command.

[Source](../source/src/main/java/nso/IActionListener.java) · [Mapping](../mapping/classes/nso_IActionListener.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoiactionlistener)

`public interface IActionListener`

Identity class: `cs`; status: `reference_proposal`; source: **6 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`void perform(int idAction, Object p)`](../source/src/main/java/nso/IActionListener.java#L5) | 5–5 | `cs.a(ILjava/lang/Object;)V` | `reference_proposal` |

## nso.Info

Thông tin hiển thị dùng chung.

[Source](../source/src/main/java/nso/Info.java) · [Mapping](../mapping/classes/nso_Info.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoinfo)

`public final class Info`

Identity class: `x`; status: `reference_proposal`; source: **152 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Info()`](../source/src/main/java/nso/Info.java#L23) | 23–24 | `x.<init>()V` | `preserved` |
| [`public static void paint(mGraphics g)`](../source/src/main/java/nso/Info.java#L26) | 26–40 | `x.a(Lt;)V` | `reference_proposal` |
| [`public static void update()`](../source/src/main/java/nso/Info.java#L42) | 42–95 | `x.a()V` | `reference_proposal` |
| [`public static void addInfo(String s, int speed, mFont f)`](../source/src/main/java/nso/Info.java#L97) | 97–151 | `x.a(Ljava/lang/String;ILdd;)V` | `reference_proposal` |

## nso.InfoDlg

Overlay thông tin/chờ với thời hạn.

[Source](../source/src/main/java/nso/InfoDlg.java) · [Mapping](../mapping/classes/nso_InfoDlg.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoinfodlg)

`public final class InfoDlg`

Identity class: `b`; status: `reference_proposal`; source: **69 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public InfoDlg()`](../source/src/main/java/nso/InfoDlg.java#L17) | 17–18 | `b.<init>()V` | `preserved` |
| [`public static void show(String title1, String subtitle, int delay2)`](../source/src/main/java/nso/InfoDlg.java#L20) | 20–27 | `b.a(Ljava/lang/String;Ljava/lang/String;I)V` | `reference_proposal` |
| [`public static void showWait()`](../source/src/main/java/nso/InfoDlg.java#L29) | 29–32 | `b.a()V` | `reference_proposal` |
| [`public static void showWait(String str)`](../source/src/main/java/nso/InfoDlg.java#L34) | 34–37 | `b.a(Ljava/lang/String;)V` | `reference_proposal` |
| [`public static void paint(mGraphics g)`](../source/src/main/java/nso/InfoDlg.java#L39) | 39–60 | `b.a(Lt;)V` | `reference_proposal` |
| [`public static void hide()`](../source/src/main/java/nso/InfoDlg.java#L62) | 62–68 | `b.b()V` | `reference_proposal` |

## nso.InfoItem

Dữ liệu một mục thông tin.

[Source](../source/src/main/java/nso/InfoItem.java) · [Mapping](../mapping/classes/nso_InfoItem.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoinfoitem)

`public final class InfoItem`

Identity class: `cw`; status: `reference_proposal`; source: **22 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public InfoItem(String s1)`](../source/src/main/java/nso/InfoItem.java#L11) | 11–15 | `cw.<init>(Ljava/lang/String;)V` | `preserved` |
| [`public InfoItem(String s1, mFont f2, int speed3)`](../source/src/main/java/nso/InfoItem.java#L17) | 17–21 | `cw.<init>(Ljava/lang/String;Ldd;I)V` | `preserved` |

## nso.InfoMe

Thông tin/hiển thị liên quan người chơi.

[Source](../source/src/main/java/nso/InfoMe.java) · [Mapping](../mapping/classes/nso_InfoMe.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoinfome)

`public final class InfoMe`

Identity class: `ae`; status: `reference_proposal`; source: **174 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public InfoMe()`](../source/src/main/java/nso/InfoMe.java#L23) | 23–24 | `ae.<init>()V` | `preserved` |
| [`public static void paint(mGraphics g)`](../source/src/main/java/nso/InfoMe.java#L26) | 26–54 | `ae.a(Lt;)V` | `reference_proposal` |
| [`public static void update()`](../source/src/main/java/nso/InfoMe.java#L56) | 56–103 | `ae.a()V` | `reference_proposal` |
| [`public static void addInfo(String s)`](../source/src/main/java/nso/InfoMe.java#L105) | 105–115 | `ae.a(Ljava/lang/String;)V` | `reference_proposal` |
| [`private static boolean canMergeString(String s)`](../source/src/main/java/nso/InfoMe.java#L117) | 117–157 | `ae.b(Ljava/lang/String;)Z` | `reference_proposal` |
| [`public static void addInfo(String s, int speed, mFont f)`](../source/src/main/java/nso/InfoMe.java#L159) | 159–169 | `ae.a(Ljava/lang/String;ILdd;)V` | `reference_proposal` |
| [`public static boolean isEmpty()`](../source/src/main/java/nso/InfoMe.java#L171) | 171–173 | `ae.b()Z` | `reference_proposal` |

## nso.Input2Dlg

Dialog nhập hai trường text.

[Source](../source/src/main/java/nso/Input2Dlg.java) · [Mapping](../mapping/classes/nso_Input2Dlg.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoinput2dlg)

`public final class Input2Dlg extends Dialog implements IActionListener`

Identity class: `de`; status: `reference_proposal`; source: **123 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Input2Dlg()`](../source/src/main/java/nso/Input2Dlg.java#L21) | 21–25 | `de.<init>()V` | `preserved` |
| [`public final void setTitle(String title, String title2)`](../source/src/main/java/nso/Input2Dlg.java#L27) | 27–46 | `de.a(Ljava/lang/String;Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void show(String info1, Command left, Command ok, int type1, int type2)`](../source/src/main/java/nso/Input2Dlg.java#L48) | 48–59 | `de.a(Ljava/lang/String;Lbd;Lbd;II)V` | `reference_proposal` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/Input2Dlg.java#L61) | 61–69 | `de.a(Lt;)V` | `reference_proposal` |
| [`public final void keyPress(int keyCode)`](../source/src/main/java/nso/Input2Dlg.java#L71) | 71–78 | `de.a(I)V` | `reference_proposal` |
| [`public final void update()`](../source/src/main/java/nso/Input2Dlg.java#L80) | 80–119 | `de.a()V` | `reference_proposal` |
| [`public final void perform(int idAction, Object p)`](../source/src/main/java/nso/Input2Dlg.java#L121) | 121–122 | `de.a(ILjava/lang/Object;)V` | `reference_proposal` |

## nso.InputDlg

Dialog nhập một trường text.

[Source](../source/src/main/java/nso/InputDlg.java) · [Mapping](../mapping/classes/nso_InputDlg.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoinputdlg)

`public final class InputDlg extends Dialog`

Identity class: `p`; status: `reference_proposal`; source: **66 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public InputDlg()`](../source/src/main/java/nso/InputDlg.java#L13) | 13–24 | `p.<init>()V` | `preserved` |
| [`public final void show(String info1, Command ok, int type)`](../source/src/main/java/nso/InputDlg.java#L26) | 26–49 | `p.a(Ljava/lang/String;Lbd;I)V` | `reference_proposal` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/InputDlg.java#L51) | 51–55 | `p.a(Lt;)V` | `reference_proposal` |
| [`public final void keyPress(int keyCode)`](../source/src/main/java/nso/InputDlg.java#L57) | 57–60 | `p.a(I)V` | `reference_proposal` |
| [`public final void update()`](../source/src/main/java/nso/InputDlg.java#L62) | 62–65 | `p.a()V` | `reference_proposal` |

## nso.Menu

Danh sách command, lựa chọn, cuộn và vẽ menu.

[Source](../source/src/main/java/nso/Menu.java) · [Mapping](../mapping/classes/nso_Menu.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsomenu)

`public final class Menu implements IActionListener`

Identity class: `ds`; status: `reference_proposal`; source: **407 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Menu()`](../source/src/main/java/nso/Menu.java#L68) | 68–69 | `ds.<init>()V` | `preserved` |
| [`public final void startAt(MyVector entries)`](../source/src/main/java/nso/Menu.java#L71) | 71–111 | `ds.a(Laa;)V` | `reference_proposal` |
| [`public final void updateMenuKey()`](../source/src/main/java/nso/Menu.java#L113) | 113–264 | `ds.a()V` | `reference_proposal` |
| [`public final void paintMenu(mGraphics g)`](../source/src/main/java/nso/Menu.java#L266) | 266–331 | `ds.a(Lt;)V` | `reference_proposal` |
| [`public final void moveCamera()`](../source/src/main/java/nso/Menu.java#L333) | 333–375 | `ds.b()V` | `reference_proposal` |
| [`public final void perform(int idAction, Object p)`](../source/src/main/java/nso/Menu.java#L377) | 377–406 | `ds.a(ILjava/lang/Object;)V` | `reference_proposal` |

## nso.MsgDlg

Dialog thông báo/chờ.

[Source](../source/src/main/java/nso/MsgDlg.java) · [Mapping](../mapping/classes/nso_MsgDlg.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsomsgdlg)

`public final class MsgDlg extends Dialog`

Identity class: `br`; status: `reference_proposal`; source: **87 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public MsgDlg()`](../source/src/main/java/nso/MsgDlg.java#L17) | 17–21 | `br.<init>()V` | `preserved` |
| [`public final void pleasewait()`](../source/src/main/java/nso/MsgDlg.java#L23) | 23–26 | `br.b()V` | `reference_proposal` |
| [`public final void setInfo(String info1, Command left, Command center, Command right)`](../source/src/main/java/nso/MsgDlg.java#L28) | 28–59 | `br.a(Ljava/lang/String;Lbd;Lbd;Lbd;)V` | `reference_proposal` |
| [`public final void paint(mGraphics g)`](../source/src/main/java/nso/MsgDlg.java#L61) | 61–75 | `br.a(Lt;)V` | `reference_proposal` |
| [`public final void update()`](../source/src/main/java/nso/MsgDlg.java#L77) | 77–86 | `br.a()V` | `reference_proposal` |

## nso.NativeTextBoxListener

Nối callback text box MIDP với text field game.

[Source](../source/src/main/java/nso/NativeTextBoxListener.java) · [Mapping](../mapping/classes/nso_NativeTextBoxListener.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsonativetextboxlistener)

`final class NativeTextBoxListener implements CommandListener`

Identity class: `bb`; status: `behavioral_name`; source: **26 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`NativeTextBoxListener(TField textField, TextBox textBox)`](../source/src/main/java/nso/NativeTextBoxListener.java#L14) | 14–17 | `bb.<init>(Lad;Ljavax/microedition/lcdui/TextBox;)V` | `preserved` |
| [`public final void commandAction(javax.microedition.lcdui.Command javaxmicroeditionlcduiCommand, Displayable displayable)`](../source/src/main/java/nso/NativeTextBoxListener.java#L19) | 19–25 | `bb.commandAction(Ljavax/microedition/lcdui/Command;Ljavax/microedition/lcdui/Displayable;)V` | `preserved` |

## nso.Scroll

State và tính toán cuộn/hit input.

[Source](../source/src/main/java/nso/Scroll.java) · [Mapping](../mapping/classes/nso_Scroll.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoscroll)

`public final class Scroll`

Identity class: `bw`; status: `reference_proposal`; source: **350 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Scroll()`](../source/src/main/java/nso/Scroll.java#L57) | 57–58 | `bw.<init>()V` | `preserved` |
| [`public final void clear()`](../source/src/main/java/nso/Scroll.java#L60) | 60–73 | `bw.a()V` | `reference_proposal` |
| [`public final void setClip(mGraphics g, int x, int y, int w, int h)`](../source/src/main/java/nso/Scroll.java#L75) | 75–79 | `bw.a(Lt;IIII)V` | `reference_proposal` |
| [`public final void setClip(mGraphics g)`](../source/src/main/java/nso/Scroll.java#L81) | 81–85 | `bw.a(Lt;)V` | `reference_proposal` |
| [`public final ScrollResult updateKey()`](../source/src/main/java/nso/Scroll.java#L87) | 87–265 | `bw.b()Lcn;` | `reference_proposal` |
| [`public final void updatecm()`](../source/src/main/java/nso/Scroll.java#L267) | 267–305 | `bw.c()V` | `reference_proposal` |
| [`public final void setStyle(int nItem, int ITEM_SIZE1, int xPos, int yPos, int width2, int height3, boolean styleUPDOWN4, int ITEM_PER_LINE)`](../source/src/main/java/nso/Scroll.java#L307) | 307–326 | `bw.a(IIIIIIZI)V` | `reference_proposal` |
| [`public final void moveTo(int to)`](../source/src/main/java/nso/Scroll.java#L328) | 328–349 | `bw.a(I)V` | `reference_proposal` |

## nso.ScrollResult

Kết quả thao tác scroll.

[Source](../source/src/main/java/nso/ScrollResult.java) · [Mapping](../mapping/classes/nso_ScrollResult.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoscrollresult)

`public final class ScrollResult`

Identity class: `cn`; status: `reference_proposal`; source: **13 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public ScrollResult()`](../source/src/main/java/nso/ScrollResult.java#L11) | 11–12 | `cn.<init>()V` | `preserved` |

## nso.TField

Text field: nội dung, con trỏ, input và paint.

[Source](../source/src/main/java/nso/TField.java) · [Mapping](../mapping/classes/nso_TField.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsotfield)

`public final class TField implements IActionListener`

Identity class: `ad`; status: `reference_proposal`; source: **407 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public final void showNativeTextBox()`](../source/src/main/java/nso/TField.java#L82) | 82–101 | `ad.a()V` | `behavioral_name` |
| [`public static boolean setNormal(char ch)`](../source/src/main/java/nso/TField.java#L103) | 103–105 | `ad.a(C)Z` | `reference_proposal` |
| [`public TField()`](../source/src/main/java/nso/TField.java#L107) | 107–115 | `ad.<init>()V` | `preserved` |
| [`public final void clear()`](../source/src/main/java/nso/TField.java#L117) | 117–124 | `ad.b()V` | `reference_proposal` |
| [`private void setOffset()`](../source/src/main/java/nso/TField.java#L126) | 126–144 | `ad.e()V` | `reference_proposal` |
| [`private void keyPressedAscii(int keyCode)`](../source/src/main/java/nso/TField.java#L146) | 146–159 | `ad.d(I)V` | `reference_proposal` |
| [`public final boolean keyPressed(int keyCode)`](../source/src/main/java/nso/TField.java#L161) | 161–287 | `ad.a(I)Z` | `reference_proposal` |
| [`public final void paint(mGraphics graphics)`](../source/src/main/java/nso/TField.java#L289) | 289–307 | `ad.a(Lt;)V` | `reference_proposal` |
| [`public final void paint_NonSetClip(mGraphics graphics)`](../source/src/main/java/nso/TField.java#L309) | 309–325 | `ad.b(Lt;)V` | `reference_proposal` |
| [`private void setPasswordTest()`](../source/src/main/java/nso/TField.java#L327) | 327–337 | `ad.f()V` | `reference_proposal` |
| [`public final void update()`](../source/src/main/java/nso/TField.java#L339) | 339–374 | `ad.c()V` | `reference_proposal` |
| [`public final String getText()`](../source/src/main/java/nso/TField.java#L376) | 376–378 | `ad.d()Ljava/lang/String;` | `reference_proposal` |
| [`public final void setText(String text1)`](../source/src/main/java/nso/TField.java#L380) | 380–391 | `ad.a(Ljava/lang/String;)V` | `reference_proposal` |
| [`public final void setMaxTextLenght(int value)`](../source/src/main/java/nso/TField.java#L393) | 393–395 | `ad.b(I)V` | `reference_proposal` |
| [`public final void setIputType(int value)`](../source/src/main/java/nso/TField.java#L397) | 397–399 | `ad.c(I)V` | `reference_proposal` |
| [`public final void perform(int idAction, Object p)`](../source/src/main/java/nso/TField.java#L401) | 401–406 | `ad.a(ILjava/lang/Object;)V` | `reference_proposal` |

## nso.TimecountDown

Dữ liệu countdown, update và paint.

[Source](../source/src/main/java/nso/TimecountDown.java) · [Mapping](../mapping/classes/nso_TimecountDown.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsotimecountdown)

`public final class TimecountDown`

Identity class: `s`; status: `reference_proposal`; source: **92 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public TimecountDown(short id1, short idIcon2, long second, String tile3, byte type)`](../source/src/main/java/nso/TimecountDown.java#L17) | 17–26 | `s.<init>(SSJLjava/lang/String;B)V` | `preserved` |
| [`public final void paint(mGraphics g, int x, int y)`](../source/src/main/java/nso/TimecountDown.java#L28) | 28–72 | `s.a(Lt;II)V` | `reference_proposal` |
| [`public final void update()`](../source/src/main/java/nso/TimecountDown.java#L74) | 74–78 | `s.a()V` | `reference_proposal` |
| [`private static String converSecon2hours(int totalSeconds)`](../source/src/main/java/nso/TimecountDown.java#L80) | 80–91 | `s.a(I)Ljava/lang/String;` | `reference_proposal` |

## nso.Timer

Action được thực hiện theo thời gian trong loop.

[Source](../source/src/main/java/nso/Timer.java) · [Mapping](../mapping/classes/nso_Timer.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsotimer)

`public final class Timer`

Identity class: `bf`; status: `reference_proposal`; source: **13 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Timer()`](../source/src/main/java/nso/Timer.java#L11) | 11–12 | `bf.<init>()V` | `preserved` |

## nso.CharPartInfo

Thông tin part của nhân vật.

[Source](../source/src/main/java/nso/CharPartInfo.java) · [Mapping](../mapping/classes/nso_CharPartInfo.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsocharpartinfo)

`public final class CharPartInfo`

Identity class: `dm`; status: `reference_proposal`; source: **176 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public CharPartInfo()`](../source/src/main/java/nso/CharPartInfo.java#L29) | 29–30 | `dm.<init>()V` | `preserved` |
| [`public static void doSetInfo(Message msg)`](../source/src/main/java/nso/CharPartInfo.java#L32) | 32–175 | `dm.a(Lce;)V` | `reference_proposal` |

## nso.Frame

Dữ liệu frame.

[Source](../source/src/main/java/nso/Frame.java) · [Mapping](../mapping/classes/nso_Frame.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoframe)

`public final class Frame`

Identity class: `ct`; status: `reference_proposal`; source: **17 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Frame()`](../source/src/main/java/nso/Frame.java#L15) | 15–16 | `ct.<init>()V` | `preserved` |

## nso.FrameImage

Vẽ sprite nhiều frame.

[Source](../source/src/main/java/nso/FrameImage.java) · [Mapping](../mapping/classes/nso_FrameImage.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoframeimage)

`public final class FrameImage`

Identity class: `aj`; status: `reference_proposal`; source: **36 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public FrameImage(Image img, int width, int height)`](../source/src/main/java/nso/FrameImage.java#L19) | 19–29 | `aj.<init>(Ljavax/microedition/lcdui/Image;II)V` | `preserved` |
| [`public final void drawFrame(int idx, int x, int y, int trans, int anchor, mGraphics g)`](../source/src/main/java/nso/FrameImage.java#L31) | 31–35 | `aj.a(IIIIILt;)V` | `reference_proposal` |

## nso.GameData

Cache icon/byte data; thử RMS/resource và yêu cầu server.

[Source](../source/src/main/java/nso/GameData.java) · [Mapping](../mapping/classes/nso_GameData.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsogamedata)

`public final class GameData`

Identity class: `cu`; status: `reference_proposal`; source: **62 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public GameData()`](../source/src/main/java/nso/GameData.java#L14) | 14–15 | `cu.<init>()V` | `preserved` |
| [`public static ImageIcon getImgIcon(short id)`](../source/src/main/java/nso/GameData.java#L17) | 17–44 | `cu.a(S)Ld;` | `reference_proposal` |
| [`public static void setImgIcon(short id, byte[] data)`](../source/src/main/java/nso/GameData.java#L46) | 46–61 | `cu.a(S[B)V` | `reference_proposal` |

## nso.ImageIcon

Dữ liệu ảnh/icon và trạng thái thời gian liên quan.

[Source](../source/src/main/java/nso/ImageIcon.java) · [Mapping](../mapping/classes/nso_ImageIcon.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoimageicon)

`public final class ImageIcon`

Identity class: `d`; status: `reference_proposal`; source: **13 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public ImageIcon()`](../source/src/main/java/nso/ImageIcon.java#L11) | 11–12 | `d.<init>()V` | `preserved` |

## nso.ImageInfo

Thông tin/metadata ảnh.

[Source](../source/src/main/java/nso/ImageInfo.java) · [Mapping](../mapping/classes/nso_ImageInfo.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsoimageinfo)

`public final class ImageInfo`

Identity class: `cv`; status: `reference_proposal`; source: **15 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public ImageInfo()`](../source/src/main/java/nso/ImageInfo.java#L13) | 13–14 | `cv.<init>()V` | `preserved` |

## nso.MyImage

Dữ liệu có các field `img`, `timerequest`, `timeUse`.

[Source](../source/src/main/java/nso/MyImage.java) · [Mapping](../mapping/classes/nso_MyImage.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsomyimage)

`public final class MyImage`

Identity class: `ak`; status: `reference_proposal`; source: **15 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public MyImage()`](../source/src/main/java/nso/MyImage.java#L13) | 13–14 | `ak.<init>()V` | `preserved` |

## nso.Paint

Các hàm vẽ khung và thành phần UI.

[Source](../source/src/main/java/nso/Paint.java) · [Mapping](../mapping/classes/nso_Paint.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsopaint)

`public final class Paint`

Identity class: `ay`; status: `reference_proposal`; source: **198 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Paint()`](../source/src/main/java/nso/Paint.java#L22) | 22–24 | `ay.<init>()V` | `preserved` |
| [`public static void paintCmdBar(mGraphics graphics, Command command, Command command1, Command command2)`](../source/src/main/java/nso/Paint.java#L26) | 26–82 | `ay.a(Lt;Lbd;Lbd;Lbd;)V` | `reference_proposal` |
| [`public static void paintCommandBarBackground(mGraphics graphics)`](../source/src/main/java/nso/Paint.java#L84) | 84–91 | `ay.a(Lt;)V` | `behavioral_name` |
| [`public static void paintInputTf(mGraphics graphics, boolean flag, int value, int value1, int value2, int value3, int value4, int value5, String text)`](../source/src/main/java/nso/Paint.java#L93) | 93–112 | `ay.a(Lt;ZIIIIIILjava/lang/String;)V` | `reference_proposal` |
| [`public static void paintInputTf_new(mGraphics graphics, boolean flag, int value, int value1, int value2, int value3, int value4, String text)`](../source/src/main/java/nso/Paint.java#L114) | 114–132 | `ay.a(Lt;ZIIIIILjava/lang/String;)V` | `reference_proposal` |
| [`public final void paintInputDlg(mGraphics g, int x, int y, int w, int h, String[] str, Image imgCapcha)`](../source/src/main/java/nso/Paint.java#L134) | 134–153 | `ay.a(Lt;IIII[Ljava/lang/String;Ljavax/microedition/lcdui/Image;)V` | `reference_proposal` |
| [`public static void paintFrame(int value, int value1, int value2, int value3, mGraphics graphics)`](../source/src/main/java/nso/Paint.java#L155) | 155–171 | `ay.a(IIIILt;)V` | `reference_proposal` |
| [`public static void paintFrameBorder(int value, int value1, int value2, int value3, mGraphics graphics)`](../source/src/main/java/nso/Paint.java#L173) | 173–187 | `ay.b(IIIILt;)V` | `reference_proposal` |
| [`public static void paintFrameInside(int value, int value1, int value2, int value3, mGraphics graphics)`](../source/src/main/java/nso/Paint.java#L189) | 189–192 | `ay.c(IIIILt;)V` | `reference_proposal` |
| [`public static void paintFrameInsideSelected(int value, int value1, int value2, int value3, mGraphics graphics)`](../source/src/main/java/nso/Paint.java#L194) | 194–197 | `ay.d(IIIILt;)V` | `reference_proposal` |

## nso.Part

Dữ liệu part dùng để ghép hình nhân vật.

[Source](../source/src/main/java/nso/Part.java) · [Mapping](../mapping/classes/nso_Part.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsopart)

`public final class Part`

Identity class: `dr`; status: `reference_proposal`; source: **21 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public Part(int type)`](../source/src/main/java/nso/Part.java#L7) | 7–20 | `dr.<init>(I)V` | `preserved` |

## nso.PartFrame

Dữ liệu frame của part.

[Source](../source/src/main/java/nso/PartFrame.java) · [Mapping](../mapping/classes/nso_PartFrame.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsopartframe)

`public final class PartFrame`

Identity class: `cl`; status: `reference_proposal`; source: **20 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public PartFrame(int dx1, int dy2, int idSmall)`](../source/src/main/java/nso/PartFrame.java#L15) | 15–19 | `cl.<init>(III)V` | `preserved` |

## nso.PartImage

Dữ liệu một ảnh part.

[Source](../source/src/main/java/nso/PartImage.java) · [Mapping](../mapping/classes/nso_PartImage.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsopartimage)

`public final class PartImage`

Identity class: `bv`; status: `reference_proposal`; source: **13 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public PartImage()`](../source/src/main/java/nso/PartImage.java#L11) | 11–12 | `bv.<init>()V` | `preserved` |

## nso.SmallImage

Ảnh nhỏ/atlas, cache theo ID và vẽ region.

[Source](../source/src/main/java/nso/SmallImage.java) · [Mapping](../mapping/classes/nso_SmallImage.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsosmallimage)

`public final class SmallImage`

Identity class: `ab`; status: `reference_proposal`; source: **185 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public SmallImage(int id, int x, int y, int w, int h)`](../source/src/main/java/nso/SmallImage.java#L27) | 27–32 | `ab.<init>(IIIII)V` | `preserved` |
| [`public static void checkTimeUseImg()`](../source/src/main/java/nso/SmallImage.java#L34) | 34–46 | `ab.a()V` | `reference_proposal` |
| [`public static void freeBig()`](../source/src/main/java/nso/SmallImage.java#L48) | 48–51 | `ab.b()V` | `reference_proposal` |
| [`public static void loadBigImage()`](../source/src/main/java/nso/SmallImage.java#L53) | 53–58 | `ab.c()V` | `reference_proposal` |
| [`public SmallImage()`](../source/src/main/java/nso/SmallImage.java#L60) | 60–62 | `ab.<init>()V` | `preserved` |
| [`public static void init()`](../source/src/main/java/nso/SmallImage.java#L64) | 64–66 | `ab.d()V` | `reference_proposal` |
| [`private static void readImage()`](../source/src/main/java/nso/SmallImage.java#L68) | 68–83 | `ab.e()V` | `reference_proposal` |
| [`public static void reciveImage(int id, byte[] data)`](../source/src/main/java/nso/SmallImage.java#L85) | 85–95 | `ab.a(I[B)V` | `reference_proposal` |
| [`public static boolean isExitsImage(int id)`](../source/src/main/java/nso/SmallImage.java#L97) | 97–120 | `ab.a(I)Z` | `reference_proposal` |
| [`public static int getHeight(int value)`](../source/src/main/java/nso/SmallImage.java#L122) | 122–124 | `ab.b(I)I` | `reference_proposal` |
| [`public static void drawSmallImage(mGraphics g, int id, int x, int y, int transform, int anchor)`](../source/src/main/java/nso/SmallImage.java#L126) | 126–151 | `ab.a(Lt;IIIII)V` | `reference_proposal` |
| [`public static void drawSmallImageNew(mGraphics g, int id, int x, int y, int transform, int anchor, int indexFrame)`](../source/src/main/java/nso/SmallImage.java#L153) | 153–184 | `ab.a(Lt;IIIIII)V` | `reference_proposal` |

## nso.TileMap

Map, tile, vật cản và tài nguyên nền.

[Source](../source/src/main/java/nso/TileMap.java) · [Mapping](../mapping/classes/nso_TileMap.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsotilemap)

`public final class TileMap`

Identity class: `af`; status: `reference_proposal`; source: **711 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public TileMap()`](../source/src/main/java/nso/TileMap.java#L115) | 115–116 | `af.<init>()V` | `preserved` |
| [`public static void setPosMiniMap(int x, int y, int w, int h)`](../source/src/main/java/nso/TileMap.java#L118) | 118–123 | `af.a(IIII)V` | `reference_proposal` |
| [`public static void updateMiniMap()`](../source/src/main/java/nso/TileMap.java#L125) | 125–143 | `af.a()V` | `reference_proposal` |
| [`public static void updateCmMiniMap()`](../source/src/main/java/nso/TileMap.java#L145) | 145–160 | `af.b()V` | `reference_proposal` |
| [`public static void freeTileImage()`](../source/src/main/java/nso/TileMap.java#L162) | 162–165 | `af.c()V` | `behavioral_name` |
| [`static final void loadTileImage()`](../source/src/main/java/nso/TileMap.java#L167) | 167–184 | `af.d()V` | `reference_proposal` |
| [`public static void loadMap(int tileId)`](../source/src/main/java/nso/TileMap.java#L186) | 186–412 | `af.a(I)V` | `reference_proposal` |
| [`public static final void paintTilemap(mGraphics g)`](../source/src/main/java/nso/TileMap.java#L414) | 414–540 | `af.a(Lt;)V` | `reference_proposal` |
| [`public static final void paintMiniMap(mGraphics g)`](../source/src/main/java/nso/TileMap.java#L542) | 542–594 | `af.b(Lt;)V` | `reference_proposal` |
| [`public static final void paintOutTilemap(mGraphics g)`](../source/src/main/java/nso/TileMap.java#L596) | 596–641 | `af.c(Lt;)V` | `reference_proposal` |
| [`private static int tileAt(int x, int y)`](../source/src/main/java/nso/TileMap.java#L643) | 643–649 | `af.b(II)I` | `reference_proposal` |
| [`private static int tileTypeAt(int x, int y)`](../source/src/main/java/nso/TileMap.java#L651) | 651–657 | `af.c(II)I` | `reference_proposal` |
| [`public static final int tileTypeAtPixel(int px, int py)`](../source/src/main/java/nso/TileMap.java#L659) | 659–665 | `af.a(II)I` | `reference_proposal` |
| [`public static final boolean tileTypeAt(int px, int py, int t)`](../source/src/main/java/nso/TileMap.java#L667) | 667–673 | `af.a(III)Z` | `reference_proposal` |
| [`public static final void setTileTypeAtPixel(int value, int value1, int value2)`](../source/src/main/java/nso/TileMap.java#L675) | 675–677 | `af.b(III)V` | `reference_proposal` |
| [`public static final void killTileTypeAt(int value, int value1, int value2)`](../source/src/main/java/nso/TileMap.java#L679) | 679–681 | `af.c(III)V` | `reference_proposal` |
| [`public static final int tileYofPixel(int value)`](../source/src/main/java/nso/TileMap.java#L683) | 683–685 | `af.b(I)I` | `reference_proposal` |
| [`public static final int tileXofPixel(int value)`](../source/src/main/java/nso/TileMap.java#L687) | 687–689 | `af.c(I)I` | `reference_proposal` |
| [`public static void loadMapFromResource() throws IOException`](../source/src/main/java/nso/TileMap.java#L691) | 691–703 | `af.e()V` | `reference_proposal` |
| [`public static void reloadTileSheets()`](../source/src/main/java/nso/TileMap.java#L705) | 705–710 | `af.f()V` | `behavioral_name` |

## nso.mFont

Font bitmap, đo chữ, vẽ chữ và chia dòng.

[Source](../source/src/main/java/nso/mFont.java) · [Mapping](../mapping/classes/nso_mFont.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsomfont)

`public final class mFont`

Identity class: `dd`; status: `reference_proposal`; source: **199 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`private mFont(String text, String text1, String text2, int value, byte byteValue)`](../source/src/main/java/nso/mFont.java#L64) | 64–93 | `dd.<init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IB)V` | `preserved` |
| [`public final void reloadImage()`](../source/src/main/java/nso/mFont.java#L95) | 95–97 | `dd.a()V` | `reference_proposal` |
| [`public final void freeImage()`](../source/src/main/java/nso/mFont.java#L99) | 99–101 | `dd.b()V` | `reference_proposal` |
| [`public final int getHeight()`](../source/src/main/java/nso/mFont.java#L103) | 103–105 | `dd.c()I` | `reference_proposal` |
| [`public final int getWidth(String text)`](../source/src/main/java/nso/mFont.java#L107) | 107–117 | `dd.a(Ljava/lang/String;)I` | `reference_proposal` |
| [`public final void drawString(mGraphics graphics, String text, int value, int value1, int value2)`](../source/src/main/java/nso/mFont.java#L119) | 119–137 | `dd.a(Lt;Ljava/lang/String;III)V` | `reference_proposal` |
| [`public final void drawString(mGraphics g, String st, int x, int y, int align, mFont font)`](../source/src/main/java/nso/mFont.java#L139) | 139–159 | `dd.a(Lt;Ljava/lang/String;IIILdd;)V` | `reference_proposal` |
| [`public final MyVector splitFontVector(String src, int lineWidth)`](../source/src/main/java/nso/mFont.java#L161) | 161–189 | `dd.a(Ljava/lang/String;I)Laa;` | `reference_proposal` |
| [`public final String[] splitFontArray(String text, int value)`](../source/src/main/java/nso/mFont.java#L191) | 191–198 | `dd.b(Ljava/lang/String;I)[Ljava/lang/String;` | `reference_proposal` |

## nso.mGraphics

Wrapper Graphics: draw, clip, translate, màu và zoom.

[Source](../source/src/main/java/nso/mGraphics.java) · [Mapping](../mapping/classes/nso_mGraphics.md) · [Bảng còn lại](FIELD_REFERENCE.md#nsomgraphics)

`public final class mGraphics`

Identity class: `t`; status: `reference_proposal`; source: **112 dòng**.

| Declaration source | Dòng | JVM identity gốc | Status tên |
|---|---:|---|---|
| [`public mGraphics(Graphics graphics)`](../source/src/main/java/nso/mGraphics.java#L12) | 12–14 | `t.<init>(Ljavax/microedition/lcdui/Graphics;)V` | `preserved` |
| [`public mGraphics()`](../source/src/main/java/nso/mGraphics.java#L16) | 16–17 | `t.<init>()V` | `preserved` |
| [`public final void drawImage(Image image, int x, int y, int anchor)`](../source/src/main/java/nso/mGraphics.java#L19) | 19–23 | `t.a(Ljavax/microedition/lcdui/Image;III)V` | `reference_proposal` |
| [`public final void drawLine(int value, int value1, int value2, int value3)`](../source/src/main/java/nso/mGraphics.java#L25) | 25–31 | `t.a(IIII)V` | `reference_proposal` |
| [`public final void drawRect(int value, int value1, int value2, int value3)`](../source/src/main/java/nso/mGraphics.java#L33) | 33–39 | `t.b(IIII)V` | `reference_proposal` |
| [`public final void drawRegion(Image arg0, int x0, int y0, int w0, int h0, int arg5, int x, int y, int arg8)`](../source/src/main/java/nso/mGraphics.java#L41) | 41–49 | `t.a(Ljavax/microedition/lcdui/Image;IIIIIIII)V` | `reference_proposal` |
| [`public final void drawRoundRect(int value, int value1, int value2, int value3, int value4, int value5)`](../source/src/main/java/nso/mGraphics.java#L51) | 51–59 | `t.a(IIIIII)V` | `reference_proposal` |
| [`public final void fillRect(int value, int value1, int value2, int value3)`](../source/src/main/java/nso/mGraphics.java#L61) | 61–67 | `t.c(IIII)V` | `reference_proposal` |
| [`public final void fillRoundRect(int value, int value1, int value2, int value3, int value4, int value5)`](../source/src/main/java/nso/mGraphics.java#L69) | 69–77 | `t.b(IIIIII)V` | `reference_proposal` |
| [`public final int getTranslateX()`](../source/src/main/java/nso/mGraphics.java#L79) | 79–81 | `t.a()I` | `reference_proposal` |
| [`public final int getTranslateY()`](../source/src/main/java/nso/mGraphics.java#L83) | 83–85 | `t.b()I` | `reference_proposal` |
| [`public final void setClip(int value, int value1, int value2, int value3)`](../source/src/main/java/nso/mGraphics.java#L87) | 87–93 | `t.d(IIII)V` | `reference_proposal` |
| [`public final void setColor(int value)`](../source/src/main/java/nso/mGraphics.java#L95) | 95–97 | `t.a(I)V` | `reference_proposal` |
| [`public final void translate(int tx, int ty)`](../source/src/main/java/nso/mGraphics.java#L99) | 99–103 | `t.a(II)V` | `reference_proposal` |
| [`public static int getImageWidth(Image image)`](../source/src/main/java/nso/mGraphics.java#L105) | 105–107 | `t.a(Ljavax/microedition/lcdui/Image;)I` | `reference_proposal` |
| [`public static int getImageHeight(Image image)`](../source/src/main/java/nso/mGraphics.java#L109) | 109–111 | `t.b(Ljavax/microedition/lcdui/Image;)I` | `reference_proposal` |
