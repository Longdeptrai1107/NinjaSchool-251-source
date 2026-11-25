# main.GameCanvas

Original JVM class: `main/a`.
CLR reference: `GameCanvas`.
Status: `reference_proposal`.

Source: `source/src/main/java/main/GameCanvas.java`.

## Fields (91)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| main/a.aZ | lowGraphic | GameCanvas.lowGraphic | reference_proposal | 45 |
| main/a.bLjavax/microedition/lcdui/Image; | testCapcha | GameCanvas.testCapcha | reference_proposal | 47 |
| main/a.cZ | isMoveNumberPad | GameCanvas.isMoveNumberPad | reference_proposal | 49 |
| main/a.dZ | isGPRS | GameCanvas.isGPRS | reference_proposal | 51 |
| main/a.eZ | isBallEffect | GameCanvas.isBallEffect | reference_proposal | 53 |
| main/a.fZ | isLoading | GameCanvas.isLoading | reference_proposal | 55 |
| main/a.gZ | isTouch | GameCanvas.isTouch | reference_proposal | 57 |
| main/a.hZ | isTouchControl | GameCanvas.isTouchControl | reference_proposal | 59 |
| main/a.iZ | isTouchControlSmallScreen | GameCanvas.isTouchControlSmallScreen | reference_proposal | 61 |
| main/a.jZ | isTouchControlLargeScreen | GameCanvas.isTouchControlLargeScreen | reference_proposal | 63 |
| main/a.kLmain/a; | instance | GameCanvas.instance | reference_proposal | 65 |
| main/a.lLda; | readMessenge | GameCanvas.readMessenge | reference_proposal | 67 |
| main/a.mZ | bRun | GameCanvas.bRun | reference_proposal | 69 |
| main/a.n[Z | keyPressedz | GameCanvas.keyPressedz | reference_proposal | 71 |
| main/a.aa[Z | keyReleasedz | GameCanvas.keyReleasedz | reference_proposal | 73 |
| main/a.o[Z | keyHold | GameCanvas.keyHold | reference_proposal | 75 |
| main/a.pZ | isPointerDown | GameCanvas.isPointerDown | reference_proposal | 77 |
| main/a.qZ | isPointerClick | GameCanvas.isPointerClick | reference_proposal | 79 |
| main/a.rZ | isPointerJustRelease | GameCanvas.isPointerJustRelease | reference_proposal | 81 |
| main/a.sI | px | GameCanvas.px | reference_proposal | 83 |
| main/a.tI | py | GameCanvas.py | reference_proposal | 85 |
| main/a.uI | pxLast | GameCanvas.pxLast | reference_proposal | 87 |
| main/a.vI | pyLast | GameCanvas.pyLast | reference_proposal | 89 |
| main/a.ab[Lck; | arrPos | GameCanvas.arrPos | reference_proposal | 91 |
| main/a.wI | gameTick | GameCanvas.gameTick | reference_proposal | 93 |
| main/a.xI | taskTick | GameCanvas.taskTick | reference_proposal | 95 |
| main/a.yZ | isEff1 | GameCanvas.isEff1 | reference_proposal | 97 |
| main/a.zZ | isEff2 | GameCanvas.isEff2 | reference_proposal | 99 |
| main/a.acJ | timeTickEff1 | GameCanvas.timeTickEff1 | reference_proposal | 101 |
| main/a.adJ | timeTickEff2 | GameCanvas.timeTickEff2 | reference_proposal | 103 |
| main/a.aeZ | isBlackBerry |  | behavioral_name | 105 |
| main/a.AI | w | GameCanvas.w | reference_proposal | 107 |
| main/a.BI | h | GameCanvas.h | reference_proposal | 109 |
| main/a.CI | hw | GameCanvas.hw | reference_proposal | 111 |
| main/a.DI | hh | GameCanvas.hh | reference_proposal | 113 |
| main/a.ELag; | currentScreen | GameCanvas.currentScreen | reference_proposal | 115 |
| main/a.FLds; | menu | GameCanvas.menu | reference_proposal | 117 |
| main/a.GLco; | selectsvScr | GameCanvas.selectsvScr | reference_proposal | 119 |
| main/a.HLdc; | loginScr | GameCanvas.loginScr | reference_proposal | 121 |
| main/a.ILl; | languageScr | GameCanvas.languageScr | reference_proposal | 123 |
| main/a.JLi; | currentDialog | GameCanvas.currentDialog | reference_proposal | 125 |
| main/a.KLbr; | msgdlg | GameCanvas.msgdlg | reference_proposal | 127 |
| main/a.LLp; | inputDlg | GameCanvas.inputDlg | reference_proposal | 129 |
| main/a.MLde; | input2Dlg | GameCanvas.input2Dlg | reference_proposal | 131 |
| main/a.NLay; | paintz | GameCanvas.paintz | reference_proposal | 133 |
| main/a.OLao; | regScr | GameCanvas.regScr | reference_proposal | 135 |
| main/a.af[Ljavax/microedition/lcdui/Image; | imgBG | GameCanvas.imgBG | reference_proposal | 137 |
| main/a.agI | skyColor | GameCanvas.skyColor | reference_proposal | 139 |
| main/a.ahI | curPos | GameCanvas.curPos | reference_proposal | 141 |
| main/a.PI | timeBallEffect | GameCanvas.timeBallEffect | reference_proposal | 143 |
| main/a.ai[I | imgBGWidth | GameCanvas.imgBGWidth | reference_proposal | 145 |
| main/a.ajLt; | g | GameCanvas.g | reference_proposal | 147 |
| main/a.akZ | paintBG | GameCanvas.paintBG | reference_proposal | 149 |
| main/a.alI | gsskyHeight | GameCanvas.gsskyHeight | reference_proposal | 151 |
| main/a.amI | gsgreenField1Y | GameCanvas.gsgreenField1Y | reference_proposal | 153 |
| main/a.anI | gsgreenField2Y | GameCanvas.gsgreenField2Y | reference_proposal | 155 |
| main/a.aoI | gshouseY | GameCanvas.gshouseY | reference_proposal | 157 |
| main/a.apI | gsmountainY | GameCanvas.gsmountainY | reference_proposal | 159 |
| main/a.aqI | bgLayer0y | GameCanvas.bgLayer0y | reference_proposal | 161 |
| main/a.arI | bgLayer1y | GameCanvas.bgLayer1y | reference_proposal | 163 |
| main/a.asLjavax/microedition/lcdui/Image; | imgCloud | GameCanvas.imgCloud | reference_proposal | 165 |
| main/a.atLjavax/microedition/lcdui/Image; | imgSun | GameCanvas.imgSun | reference_proposal | 167 |
| main/a.Q[Ljavax/microedition/lcdui/Image; | imgBorder | GameCanvas.imgBorder | reference_proposal | 169 |
| main/a.RI | borderCornerWidth |  | behavioral_name | 171 |
| main/a.SI | borderCornerHeight |  | behavioral_name | 173 |
| main/a.au[I | cloudX | GameCanvas.cloudX | reference_proposal | 175 |
| main/a.av[I | cloudY | GameCanvas.cloudY | reference_proposal | 177 |
| main/a.awI | sunX | GameCanvas.sunX | reference_proposal | 179 |
| main/a.axI | sunY | GameCanvas.sunY | reference_proposal | 181 |
| main/a.TI | typeBg | GameCanvas.typeBg | reference_proposal | 183 |
| main/a.ayJ | lastTimePress | GameCanvas.lastTimePress | reference_proposal | 185 |
| main/a.UI | keyAsciiPress | GameCanvas.keyAsciiPress | reference_proposal | 187 |
| main/a.az[I | bgSpeed | GameCanvas.bgSpeed | reference_proposal | 189 |
| main/a.aA[I | dustX | GameCanvas.dustX | reference_proposal | 191 |
| main/a.aB[I | dustY | GameCanvas.dustY | reference_proposal | 193 |
| main/a.aC[I | dustState | GameCanvas.dustState | reference_proposal | 195 |
| main/a.aD[I | wsX | GameCanvas.wsX | reference_proposal | 197 |
| main/a.aE[I | wsY | GameCanvas.wsY | reference_proposal | 199 |
| main/a.aF[I | wsState | GameCanvas.wsState | reference_proposal | 201 |
| main/a.aG[Ljavax/microedition/lcdui/Image; | imgWS | GameCanvas.imgWS | reference_proposal | 203 |
| main/a.aHLjavax/microedition/lcdui/Image; | imgShuriken | GameCanvas.imgShuriken | reference_proposal | 205 |
| main/a.aI[[Ljavax/microedition/lcdui/Image; | imgDust | GameCanvas.imgDust | reference_proposal | 207 |
| main/a.aJZ | resetToLoginScrz | GameCanvas.resetToLoginScrz | reference_proposal | 209 |
| main/a.VZ | isKiemduyet | GameCanvas.isKiemduyet | reference_proposal | 211 |
| main/a.WZ | isKiemduyet_info | GameCanvas.isKiemduyet_info | reference_proposal | 213 |
| main/a.XLjavax/microedition/lcdui/Image; | imgPlus12 | GameCanvas.imgPlus12 | reference_proposal | 215 |
| main/a.YLjavax/microedition/lcdui/Image; | backitem | GameCanvas.backitem | reference_proposal | 217 |
| main/a.Z[Ljavax/microedition/lcdui/Image; | imghealth | GameCanvas.imghealth | reference_proposal | 219 |
| main/a.aKI | xKd | GameCanvas.xKd | reference_proposal | 221 |
| main/a.aLI | yKd | GameCanvas.yKd | reference_proposal | 223 |
| main/a.aMI | wStr | GameCanvas.wStr | reference_proposal | 225 |

## Methods (45)

| Original identity | Source name | CLR reference | Evidence status | Source line |
|---|---|---|---|---:|
| main/a.<clinit>()V | <clinit> | GameCanvas::.cctor | preserved | static/field initializer |
| main/a.<init>()V | <init> | GameCanvas::.ctor | preserved | 232 |
| main/a.a()Lmain/a; | gI | GameCanvas::gI | reference_proposal | 298 |
| main/a.a(I)V | connect | GameCanvas::connect | reference_proposal | 305 |
| main/a.b()V | initGameCanvas | GameCanvas::initGameCanvas | reference_proposal | 318 |
| main/a.c()V | startGameLoop |  | behavioral_name | 330 |
| main/a.run()V | run |  | preserved | 334 |
| main/a.d()V | updateBallEffect | GameCanvas::updateBallEffect | reference_proposal | 433 |
| main/a.e()V | updateBG | GameCanvas::updateBG | reference_proposal | 439 |
| main/a.a(Lt;)V | paintBGGameScr | GameCanvas::paintBGGameScr | reference_proposal | 454 |
| main/a.f()V | freeBackgroundImages |  | behavioral_name | 587 |
| main/a.b(I)V | loadBG | GameCanvas::loadBG | reference_proposal | 593 |
| main/a.c(I)V | keyPressed | GameCanvas::keyPressed | reference_proposal | 819 |
| main/a.d(I)V | keyReleased | GameCanvas::keyReleased | reference_proposal | 945 |
| main/a.a(II)V | pointerDragged | GameCanvas::pointerDragged | reference_proposal | 1042 |
| main/a.g()Z | isHoldPress | GameCanvas::isHoldPress | reference_proposal | 1054 |
| main/a.b(II)V | pointerPressed | GameCanvas::pointerPressed | reference_proposal | 1058 |
| main/a.c(II)V | pointerReleased | GameCanvas::pointerReleased | reference_proposal | 1068 |
| main/a.a(IIII)Z | isPointerInGame | GameCanvas::isPointerInGame | reference_proposal | 1076 |
| main/a.a(IIIILbw;)Z | isPointerInRoll | GameCanvas::isPointerInRoll | reference_proposal | 1082 |
| main/a.b(IIII)Z | isPointerHoldIn | GameCanvas::isPointerHoldIn | reference_proposal | 1088 |
| main/a.h()V | clearKeyPressed | GameCanvas::clearKeyPressed | reference_proposal | 1092 |
| main/a.i()V | clearKeyHold | GameCanvas::clearKeyHold | reference_proposal | 1099 |
| main/a.a(Ljavax/microedition/lcdui/Graphics;)V | paint |  | behavioral_name | 1105 |
| main/a.j()V | endDlg | GameCanvas::endDlg | reference_proposal | 1136 |
| main/a.a(Ljava/lang/String;)V | startOKDlg | GameCanvas::startOKDlg | reference_proposal | 1147 |
| main/a.b(Ljava/lang/String;)V | startWaitDlg | GameCanvas::startWaitDlg | reference_proposal | 1152 |
| main/a.k()V | startWaitDlg | GameCanvas::startWaitDlg | reference_proposal | 1158 |
| main/a.l()V | startWaitDlgWithoutCancel | GameCanvas::startWaitDlgWithoutCancel | reference_proposal | 1162 |
| main/a.a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V | openWeb | GameCanvas::openWeb | reference_proposal | 1169 |
| main/a.a(Ljava/lang/String;Ljava/lang/String;SLjava/lang/String;Ljava/lang/String;)V | sendSms | GameCanvas::sendSms | reference_proposal | 1174 |
| main/a.a(Ljava/lang/String;ILjava/lang/Object;)V | startOK | GameCanvas::startOK | reference_proposal | 1182 |
| main/a.a(Ljava/lang/String;ILjava/lang/Object;ILjava/lang/Object;)V | startYesNoDlg | GameCanvas::startYesNoDlg | reference_proposal | 1188 |
| main/a.a(Ljava/lang/String;Lbd;Lbd;)V | startYesNoDlg | GameCanvas::startYesNoDlg | reference_proposal | 1195 |
| main/a.c(Ljava/lang/String;)Ljavax/microedition/lcdui/Image; | loadImage | GameCanvas::loadImage | reference_proposal | 1201 |
| main/a.a(III)Z | startDust | GameCanvas::startDust | reference_proposal | 1211 |
| main/a.o()V | loadWaterSplash | GameCanvas::loadWaterSplash | reference_proposal | 1225 |
| main/a.d(II)Z | startWaterSplash | GameCanvas::startWaterSplash | reference_proposal | 1237 |
| main/a.m()V | updateDust | GameCanvas::updateDust | reference_proposal | 1251 |
| main/a.e(II)Z | isPaint | GameCanvas::isPaint | reference_proposal | 1270 |
| main/a.b(Lt;)V | paintDust | GameCanvas::paintDust | reference_proposal | 1280 |
| main/a.a(IILt;Z)V | paintShukiren | GameCanvas::paintShukiren | reference_proposal | 1290 |
| main/a.n()V | resetToLoginScr | GameCanvas::resetToLoginScr | reference_proposal | 1295 |
| main/a.c(IIII)Z | isPointer | GameCanvas::isPointer | reference_proposal | 1300 |
| main/a.a(ILjava/lang/Object;)V | perform | GameCanvas::perform | reference_proposal | 1304 |
