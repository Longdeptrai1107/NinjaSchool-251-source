# Căn cứ đặt tên đọc được

- Đã đổi 461 field và 249 method còn tên hash; không còn tên `field_*_<hash>` / `method_*_<hash>` trong `src`.
- Trong đợt này: 626 tên là đề xuất vai trò tương ứng DLL (404 field, 222 method); 84 tên mô tả hành vi Java (57 field, 27 method). Không tự nhận đây là tên gốc trước obfuscation.
- Mỗi định danh JVM `(owner, name, descriptor)` vẫn được giữ trong `symbols.json` / `remap_config.json`; `previousMapped` giữ tên cũ để truy vết.
- Toàn bộ 130 class, 1.349 method, 2.322 field, 3.767 ô local bytecode và 5.043 khai báo tham số/local/catch trong source đều có bảng kiểm kê. Tên local gốc không có trong metadata.

## Hai field được yêu cầu

| JVM identity | Tên source | Căn cứ |
|---|---|---|
| `bp.cmI` | `Char.tickEffWolf` | Tick 0–5 chọn frame mắt sói; declaration/use-site DLL trùng vai trò. |
| `bp.cnI` | `Char.timeBocdau` | Đếm thời gian bốc đầu xe, tắt sau 20 tick; declaration/use-site DLL trùng vai trò. |

## Đối chiếu riêng đợt đổi tên

- 130/130 class có bytecode canonical khớp bản ECJ trước đổi tên sau khi quy tên về cùng định danh.
- So sánh 193,867 lệnh và 1,479 exception handler, giữ thứ tự lệnh, branch target, constants, member/access metadata và maxStack/maxLocals. Debug metadata không thuộc phép so sánh.
- Audit tự kiểm tra phát hiện 10 dạng thay đổi chủ động trên fixture (nhánh, operand, handler, field/call target, v.v.).
- Kết quả này xác nhận name-only refactor không đổi executable code so với baseline rebuilt; không phải bằng chứng toàn bộ bản decompile tương đương mọi nhánh của JAR gốc.

## Tên dựa trên hành vi Java

Có 62 field và 28 method trong toàn bộ mapping mang status `behavioral_name` (bao gồm các adapter đã đặt tên trước đợt này). Tất cả đều có khai báo/code; `unused...` mô tả field gốc được giữ lại, không phải stub.

| Loại | JVM identity | Tên source |
|---|---|---|
| fields | ad.mZ | nso/TField.unusedInputFlag |
| fields | ad.EI | nso/TField.unusedTypingModeAreaWidth |
| fields | ad.iLjavax/microedition/lcdui/Canvas; | nso/TField.returnCanvas |
| fields | ad.jLjavax/microedition/midlet/MIDlet; | nso/TField.midlet |
| fields | af.ELjavax/microedition/lcdui/Image; | nso/TileMap.imgTile |
| fields | aq.aLdh; | nso/SessionSender.session |
| fields | bb.aLad; | nso/NativeTextBoxListener.textField |
| fields | bb.bLjavax/microedition/lcdui/TextBox; | nso/NativeTextBoxListener.textBox |
| fields | bs.aLjava/lang/String; | nso/SessionConnector.connectionUrl |
| fields | bs.bLdh; | nso/SessionConnector.session |
| fields | ce.bLjava/io/ByteArrayOutputStream; | nso/Message.outputBuffer |
| fields | ce.dLjava/io/ByteArrayInputStream; | nso/Message.inputBuffer |
| fields | ci.agI | nso/Mob.bossMoveFrameIndex |
| fields | cp.a[B | nso/PacketBuffer.data |
| fields | dc.CI | nso/LoginScr.logoVelocity |
| fields | dc.EI | nso/LoginScr.logoDirection |
| fields | dc.FLjava/lang/String; | nso/LoginScr.recoveryAccount |
| fields | dd.zLjava/lang/String; | nso/mFont.FONT_CHARACTERS |
| fields | dd.ALjava/lang/String; | nso/mFont.fontImagePath |
| fields | df.cN[Ljava/lang/String; | nso/mResources.TITLECHEDO |
| fields | dg.dRZ | nso/GameScr.isPaintCheDo |
| fields | dg.efLjavax/microedition/lcdui/Image; | nso/GameScr.imgTransparent |
| fields | dg.eGB | nso/GameScr.menuCooldown |
| fields | dg.fzI | nso/GameScr.cmdBarLeftWidth |
| fields | dg.fAI | nso/GameScr.cmdBarRightWidth |
| fields | dg.fBI | nso/GameScr.cmdBarFillWidth |
| fields | dg.fHI | nso/GameScr.mpBarHeight |
| fields | dg.fI[Ljavax/microedition/lcdui/Image; | nso/GameScr.imgCmdBar |
| fields | dg.fKZ | nso/GameScr.unusedInterfaceFlag |
| fields | dg.gFI | nso/GameScr.scrollOffset |
| fields | dg.gGI | nso/GameScr.scrollTarget |
| fields | dg.gHI | nso/GameScr.scrollRemainder |
| fields | dg.gII | nso/GameScr.scrollVelocity |
| fields | dg.hcI | nso/GameScr.cardReportStep |
| fields | dg.hP[I | nso/GameScr.craftSlotX |
| fields | dg.hQ[I | nso/GameScr.craftSlotY |
| fields | dg.hRI | nso/GameScr.selectedCraftSlot |
| fields | dh.bZ | nso/Session_ME.unusedSessionFlag |
| fields | dh.uLaa; | nso/Session_ME.sendQueue |
| fields | dn.aLdh; | nso/SessionReceiver.session |
| fields | ds.kI | nso/Menu.renderY |
| fields | ds.sLjavax/microedition/lcdui/Image; | nso/Menu.imgButton |
| fields | ds.tLjavax/microedition/lcdui/Image; | nso/Menu.imgButtonFocus |
| fields | du.aLjava/lang/String; | nso/SmsSender.smsUrl |
| fields | du.bLjava/lang/String; | nso/SmsSender.messageText |
| fields | du.cLjava/lang/String; | nso/SmsSender.recipient |
| fields | du.dLbd; | nso/SmsSender.onSuccess |
| fields | du.eLbd; | nso/SmsSender.onFailure |
| fields | main/a.aeZ | main/GameCanvas.isBlackBerry |
| fields | main/a.RI | main/GameCanvas.borderCornerWidth |
| fields | main/a.SI | main/GameCanvas.borderCornerHeight |
| fields | main/b.bLmain/c; | main/MotherCanvas.canvasAdapter |
| fields | main/b.fZ | main/MotherCanvas.disableZoom |
| fields | main/GameMidlet.rLmain/a; | main/GameMidlet.gameCanvas |
| fields | t.aLjavax/microedition/lcdui/Graphics; | nso/mGraphics.graphics |
| fields | y.ALaa; | nso/DataSkillEff.actorFrameBuffer |
| fields | y.BLaa; | nso/DataSkillEff.standFrameBuffer |
| fields | y.CLaa; | nso/DataSkillEff.moveFrameBuffer |
| fields | y.DLaa; | nso/DataSkillEff.jumpFrameBuffer |
| fields | y.ELaa; | nso/DataSkillEff.fallFrameBuffer |
| fields | y.FLaa; | nso/DataSkillEff.charOffsetXBuffer |
| fields | y.GLaa; | nso/DataSkillEff.charOffsetYBuffer |
| methods | ad.a()V | nso/TField.showNativeTextBox |
| methods | af.c()V | nso/TileMap.freeTileImage |
| methods | af.f()V | nso/TileMap.reloadTileSheets |
| methods | an.b()V | nso/Controller.onConnectionError |
| methods | aw.a(Ljava/lang/String;)V | nso/ChatTextField.showChat |
| methods | ay.a(Lt;)V | nso/Paint.paintCommandBarBackground |
| methods | bm.a(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object; | nso/StringHashtable.put |
| methods | bm.a(Ljava/lang/String;)Ljava/lang/Object; | nso/StringHashtable.get |
| methods | dc.e()V | nso/LoginScr.unLoad |
| methods | dg.S(Lt;)V | nso/GameScr.paintCheDo |
| methods | dh.a(Ldh;Ljava/io/DataOutputStream;)V | nso/Session_ME.setOutputStream |
| methods | dh.a(Ldh;)Laq; | nso/Session_ME.getSender |
| methods | dh.a(Ldh;Lce;)V | nso/Session_ME.sendMessageNow |
| methods | dh.a(Ldh;Laa;)V | nso/Session_ME.setSendQueue |
| methods | dh.b(Ldh;)Laa; | nso/Session_ME.getSendQueue |
| methods | dh.c(Ldh;)V | nso/Session_ME.cleanNetwork |
| methods | dn.a(Lce;)V | nso/SessionReceiver.getKey |
| methods | f.a(Ljava/lang/String;Ljava/lang/String;Lbd;Lbd;)V | nso/SMS.sendSMS |
| methods | f.a()V | nso/SMS.startConnectionThread |
| methods | main/a.c()V | main/GameCanvas.startGameLoop |
| methods | main/a.f()V | main/GameCanvas.freeBackgroundImages |
| methods | main/a.a(Ljavax/microedition/lcdui/Graphics;)V | main/GameCanvas.paint |
| methods | main/b.a(Lmain/c;)V | main/MotherCanvas.setCanvasAdapter |
| methods | main/c.a(Ljavax/microedition/lcdui/Graphics;)V | main/CanvasAdapter.paint |
| methods | main/c.c(I)V | main/CanvasAdapter.keyPressed |
| methods | main/c.d(I)V | main/CanvasAdapter.keyReleased |
| methods | main/GameMidlet.a(Ljava/lang/String;)V | main/GameMidlet.openUrlAndExit |
| methods | main/GameMidlet.b()V | main/GameMidlet.sendGPS |
