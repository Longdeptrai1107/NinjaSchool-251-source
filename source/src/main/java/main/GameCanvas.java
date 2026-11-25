package main;

import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import nso.Char;
import nso.ChatPopup;
import nso.ChatTextField;
import nso.Command;
import nso.Dialog;
import nso.GameScr;
import nso.IActionListener;
import nso.InfoDlg;
import nso.InfoMe;
import nso.Input2Dlg;
import nso.InputDlg;
import nso.Item;
import nso.LanguageScr;
import nso.LoginScr;
import nso.Menu;
import nso.Position;
import nso.MsgDlg;
import nso.MyVector;
import nso.NinjaUtil;
import nso.Paint;
import nso.RMS;
import nso.Readmsg;
import nso.RegisterScr;
import nso.Res;
import nso.Scroll;
import nso.SelectServerScr;
import nso.Service;
import nso.Session_ME;
import nso.SmallImage;
import nso.StaticObj;
import nso.TileMap;
import nso.Timer;
import nso.mFont;
import nso.mGraphics;
import nso.mResources;
import nso.mScreen;

public final class GameCanvas extends CanvasAdapter implements IActionListener, Runnable {

    public static boolean lowGraphic = false;

    public static Image testCapcha = null;

    public static boolean isMoveNumberPad = true;

    public static boolean isGPRS = true;

    public static boolean isBallEffect = false;

    public static boolean isLoading;

    public static boolean isTouch = false;

    public static boolean isTouchControl;

    public static boolean isTouchControlSmallScreen;

    public static boolean isTouchControlLargeScreen;

    public static GameCanvas instance;

    public static Readmsg readMessenge;

    static boolean bRun;

    public static boolean[] keyPressedz = new boolean[14];

    private static boolean[] keyReleasedz = new boolean[14];

    public static boolean[] keyHold = new boolean[14];

    public static boolean isPointerDown;

    public static boolean isPointerClick;

    public static boolean isPointerJustRelease;

    public static int px;

    public static int py;

    public static int pxLast;

    public static int pyLast;

    private static Position[] arrPos = new Position[4];

    public static int gameTick;

    public static int taskTick;

    public static boolean isEff1;

    public static boolean isEff2;

    private static long timeTickEff1;

    private static long timeTickEff2;

    private static boolean isBlackBerry;

    public static int w;

    public static int h;

    public static int hw;

    public static int hh;

    public static mScreen currentScreen;

    public static Menu menu = new Menu();

    public static SelectServerScr selectsvScr;

    public static LoginScr loginScr;

    public static LanguageScr languageScr;

    public static Dialog currentDialog;

    public static MsgDlg msgdlg;

    public static InputDlg inputDlg;

    public static Input2Dlg input2Dlg;

    public static Paint paintz;

    public static RegisterScr regScr;

    private static Image[] imgBG;

    private static int skyColor;

    private static int curPos = 0;

    public static int timeBallEffect;

    private static int[] imgBGWidth;

    private mGraphics g = new mGraphics();

    private static boolean paintBG;

    private static int gsskyHeight;

    private static int gsgreenField1Y;

    private static int gsgreenField2Y;

    private static int gshouseY;

    private static int gsmountainY;

    private static int bgLayer0y;

    private static int bgLayer1y;

    private static Image imgCloud;

    private static Image imgSun;

    public static Image[] imgBorder = new Image[2];

    public static int borderCornerWidth;

    public static int borderCornerHeight;

    private static int[] cloudX;

    private static int[] cloudY;

    private static int sunX;

    private static int sunY;

    public static int typeBg = -1;

    private static long lastTimePress = 0L;

    public static int keyAsciiPress;

    private static int[] bgSpeed;

    private int[] dustX;

    private int[] dustY;

    private int[] dustState;

    private static int[] wsX;

    private static int[] wsY;

    private static int[] wsState;

    private static Image[] imgWS;

    private static Image imgShuriken;

    private static Image[][] imgDust;

    private boolean resetToLoginScrz;

    public static boolean isKiemduyet = false;

    public static boolean isKiemduyet_info = false;

    public static Image imgPlus12;

    public static Image backitem;

    public static Image[] imghealth;

    private static int xKd = w;

    private static int yKd = 0;

    private static int wStr;

    static {
        new MyVector();
        new MyVector();
    }

    public GameCanvas() {
        boolean flag = true;
        MotherCanvas.instance.setFullScreenMode(true);
        MotherCanvas.instance.setCanvasAdapter(this);
        w = MotherCanvas.instance.getWidth_new();
        h = MotherCanvas.instance.getHeight_new();
        hw = w / 2;
        main.GameCanvas.hh = h / 2;
        main.GameCanvas.isBlackBerry = System.getProperty("microedition.platform").indexOf("RIM") == 0;
        if (MotherCanvas.instance.hasPointerEvents()) {
            main.GameCanvas.isTouch = true;
            if (w >= 240) {
                isTouchControl = true;
            }
            if (w < 320) {
                main.GameCanvas.isTouchControlSmallScreen = true;
            }
            if (w >= 320) {
                isTouchControlLargeScreen = true;
            }
        }
        msgdlg = new MsgDlg();
        if (h <= 160) {
            Paint.hTab = 15;
            mScreen.cmdH = 17;
        }
        readMessenge = new Readmsg();
        instance = this;
        System.gc();
        paintz = new Paint();
        if (!main.GameCanvas.lowGraphic) {
            if (imgDust == null) {
                imgDust = new Image[2][5];
                for (int index = 0; index < 2; index++) {
                    for (int index1 = 0; index1 < 5; index1++) {
                        imgDust[index][index1] = loadImage("/e/d" + index + index1 + ".png");
                    }
                }
            }
            this.dustX = new int[2];
            this.dustY = new int[2];
            this.dustState = new int[2];
            this.dustState[0] = this.dustState[1] = -1;
        }
        loadWaterSplash();
        GameMidlet.loadLinkRMS();
        main.GameCanvas.imgShuriken = loadImage("/u/f.png");
        if (main.GameCanvas.isTouch) {
            for (int index2 = 0; index2 < 2; index2++) {
                main.GameCanvas.imgBorder[index2] = loadImage("/hd/bd" + index2 + ".png");
            }
            main.GameCanvas.borderCornerWidth = mGraphics.getImageWidth(main.GameCanvas.imgBorder[0]);
            main.GameCanvas.borderCornerHeight = mGraphics.getImageHeight(main.GameCanvas.imgBorder[0]);
            mGraphics.getImageWidth(main.GameCanvas.imgBorder[1]);
            mGraphics.getImageHeight(main.GameCanvas.imgBorder[1]);
        } else if (RMS.loadRMSInt("lowGraphic") == 1) {
            main.GameCanvas.lowGraphic = true;
        }
        SmallImage.loadBigImage();
        if (MotherCanvas.instance.hasPointerEvents()) {
            new MyVector();
        }
        mScreen.initPos();
        languageScr = new LanguageScr();
    }

    public static GameCanvas gI() {
        if (instance == null) {
            instance = new GameCanvas();
        }
        return instance;
    }

    public static void connect(int value) {
        String text = "socket://" + GameMidlet.IP + ":" + GameMidlet.PORT;
        System.out.println("connect: " + value + " | isWorldver: " + GameMidlet.isWorldver);
        if (main.GameCanvas.isBlackBerry) {
            if (!isGPRS) {
                text = text + ";interface=wifi";
            } else {
                text = text + ";deviceside=true";
            }
        }
        Session_ME.gI().connect(text);
    }

    public static void initGameCanvas() {
        w = MotherCanvas.instance.getWidth_new();
        h = MotherCanvas.instance.getHeight_new();
        hw = w / 2;
        main.GameCanvas.hh = h / 2;
        loginScr = new LoginScr();
        selectsvScr = new SelectServerScr();
        regScr = new RegisterScr();
        inputDlg = new InputDlg();
        input2Dlg = new Input2Dlg();
    }

    public final void startGameLoop() {
        new Thread(this).start();
    }

    public final void run() {
        try {
            Thread.sleep(10L);
        } catch (InterruptedException interruptedException) {
        }
        main.GameCanvas.bRun = true;
        while (main.GameCanvas.bRun) {
            try {
                long longValue;
                if ((longValue = System.currentTimeMillis()) - main.GameCanvas.timeTickEff1 >= 780L && !main.GameCanvas.isEff1) {
                    main.GameCanvas.timeTickEff1 = longValue;
                    main.GameCanvas.isEff1 = true;
                } else {
                    main.GameCanvas.isEff1 = false;
                }
                if (longValue - main.GameCanvas.timeTickEff2 >= 7800L && !main.GameCanvas.isEff2) {
                    main.GameCanvas.timeTickEff2 = longValue;
                    main.GameCanvas.isEff2 = true;
                } else {
                    main.GameCanvas.isEff2 = false;
                }
                if (taskTick > 0) {
                    taskTick--;
                }
                if (++gameTick > 10000) {
                    if (System.currentTimeMillis() - lastTimePress > 20000L && currentScreen == loginScr) {
                        GameMidlet.instance.notifyDestroyed();
                    }
                    gameTick = 0;
                }
                if (currentScreen != null) {
                    if (currentDialog != null) {
                        currentDialog.update();
                    } else if (menu.showMenu) {
                        menu.moveCamera();
                        menu.updateMenuKey();
                    }
                    if (!isLoading) {
                        currentScreen.update();
                    }
                    currentScreen.updateKey();
                }
                long longValue1 = System.currentTimeMillis();
                if (Timer.isON && longValue1 > Timer.timeExecute) {
                    Timer.isON = false;
                    try {
                        if (Timer.idAction > 0) {
                            GameScr.gI().perform(Timer.idAction, null);
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
                if (InfoDlg.delay > 0 && --InfoDlg.delay == 0) {
                    InfoDlg.hide();
                }
                if (this.resetToLoginScrz) {
                    this.resetToLoginScrz = false;
                    selectsvScr.switchToMe();
                    try {
                        Char.clearMyChar();
                        GameScr.clearGameScr();
                        GameScr.resetAllvector();
                        endDlg();
                        InfoDlg.hide();
                        GameScr.loadCamera(true);
                        GameScr.cmx = 100;
                        loadBG(TileMap.bgID);
                        GameScr.vParty.removeAllElements();
                        GameScr.vClan.removeAllElements();
                        GameScr.vFriend.removeAllElements();
                        GameScr.vEnemies.removeAllElements();
                        Char.clan = null;
                    } catch (Exception exception3) {
                        exception3.printStackTrace();
                    }
                }
                MotherCanvas.instance.repaint();
                MotherCanvas.instance.serviceRepaints();
                long longValue2 = System.currentTimeMillis() - longValue;
                try {
                    if (longValue2 < 40L) {
                        Thread.sleep(1L * (40L - longValue2));
                    } else {
                        Thread.sleep(1L);
                    }
                } catch (InterruptedException interruptedException4) {
                }
            } catch (Exception exception5) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException interruptedException6) {
                    interruptedException6.printStackTrace();
                }
                exception5.printStackTrace();
            }
        }
    }

    public static void updateBallEffect() {
        if (isBallEffect && --timeBallEffect < 0) {
            isBallEffect = false;
        }
    }

    public static void updateBG() {
        if (!main.GameCanvas.lowGraphic) {
            if (imgCloud != null) {
                for (int index = 0; index < main.GameCanvas.cloudX.length; index++) {
                    if (gameTick % (index + 2 << 3) == 0) {
                        main.GameCanvas.cloudX[index]++;
                        if (main.GameCanvas.cloudX[index] > GameScr.gW + (mGraphics.getImageWidth(imgCloud) >> 1)) {
                            main.GameCanvas.cloudX[index] = -(mGraphics.getImageWidth(imgCloud) >> 1);
                        }
                    }
                }
            }
        }
    }

    public static void paintBGGameScr(mGraphics g1) {
        if (isBallEffect) {
            if (gameTick % 10 > 7) {
                g1.setColor(16777215);
            } else {
                g1.setColor(0);
            }
            g1.fillRect(0, 0, GameScr.gW, GameScr.gH);
        } else {
            if (paintBG && !main.GameCanvas.lowGraphic && imgBG != null) {
                g1.setColor(main.GameCanvas.skyColor);
                g1.fillRect(0, 0, GameScr.gW, gsskyHeight);
                if (typeBg >= 0 && typeBg <= 1) {
                    if (imgBG[0] != null) {
                        for (int index = -((GameScr.cmx >> 1) % 24); index < GameScr.gW; index += 24) {
                            g1.drawImage(imgBG[0], index, main.GameCanvas.gsgreenField1Y, 0);
                        }
                    }
                    if (imgBG[1] != null) {
                        for (int index2 = -((GameScr.cmx >> 2) % 24); index2 < GameScr.gW; index2 += 24) {
                            g1.drawImage(imgBG[1], index2, main.GameCanvas.gsgreenField2Y, 0);
                        }
                    }
                    if (imgBG[3] != null) {
                        for (int index3 = -((GameScr.cmx >> 4) % 64); index3 < GameScr.gW; index3 += 64) {
                            g1.drawImage(imgBG[3], index3, gsmountainY, 0);
                        }
                    }
                    if (imgSun != null) {
                        g1.drawImage(imgSun, main.GameCanvas.sunX, main.GameCanvas.sunY, 3);
                    }
                    if (imgCloud != null) {
                        for (int index4 = 0; index4 < 2; index4++) {
                            g1.drawImage(imgCloud, main.GameCanvas.cloudX[index4], main.GameCanvas.cloudY[index4], 3);
                        }
                    }
                    if (imgBG[2] != null) {
                        for (int index5 = -((GameScr.cmx >> 3) % 192); index5 < GameScr.gW; index5 += 192) {
                            g1.drawImage(imgBG[2], index5, gshouseY, 0);
                        }
                        return;
                    }
                } else if (typeBg >= 2 && typeBg <= 6) {
                    if (imgSun != null) {
                        g1.drawImage(imgSun, main.GameCanvas.sunX, main.GameCanvas.sunY, 3);
                    }
                    if (imgCloud != null) {
                        for (int index6 = 0; index6 < main.GameCanvas.cloudX.length; index6++) {
                            g1.drawImage(imgCloud, main.GameCanvas.cloudX[index6], main.GameCanvas.cloudY[index6], 3);
                        }
                    }
                    if (typeBg != 2) {
                        if (imgBG[3] != null) {
                            for (int index7 = -((GameScr.cmx >> main.GameCanvas.bgSpeed[3]) % imgBGWidth[3]); index7 < GameScr.gW; index7 += imgBGWidth[3]) {
                                g1.drawImage(imgBG[3], index7, gsmountainY, 0);
                            }
                        }
                        if (imgBG[2] != null) {
                            for (int index8 = -((GameScr.cmx >> main.GameCanvas.bgSpeed[2]) % imgBGWidth[2]); index8 < GameScr.gW; index8 += imgBGWidth[2]) {
                                g1.drawImage(imgBG[2], index8, gshouseY, 0);
                            }
                        }
                        if (imgBG[1] != null) {
                            for (int index9 = -((GameScr.cmx >> main.GameCanvas.bgSpeed[1]) % imgBGWidth[1]); index9 < GameScr.gW; index9 += imgBGWidth[1]) {
                                g1.drawImage(imgBG[1], index9, main.GameCanvas.bgLayer1y, 0);
                            }
                        }
                        if (imgBG[0] != null) {
                            for (int index10 = -((GameScr.cmx >> main.GameCanvas.bgSpeed[0]) % imgBGWidth[0]); index10 < GameScr.gW; index10 += imgBGWidth[0]) {
                                g1.drawImage(imgBG[0], index10, main.GameCanvas.bgLayer0y, 0);
                            }
                            return;
                        }
                    }
                } else if (typeBg >= 7 && typeBg <= 16) {
                    g1.setColor(main.GameCanvas.skyColor);
                    g1.fillRect(0, 0, GameScr.gW, GameScr.gH);
                    if (typeBg != 8 && imgBG[3] != null) {
                        for (int index11 = -((GameScr.cmx >> main.GameCanvas.bgSpeed[3]) % imgBGWidth[3]); index11 < GameScr.gW; index11 += imgBGWidth[3]) {
                            if (typeBg != 11 && typeBg != 12) {
                                g1.drawImage(imgBG[3], index11, gsmountainY, 0);
                            } else {
                                g1.drawImage(imgBG[3], index11, GameScr.gH - mGraphics.getImageHeight(imgBG[3]), 0);
                            }
                        }
                    }
                    if (typeBg != 8 && typeBg != 11 && typeBg != 12 && imgBG[2] != null) {
                        if (TileMap.mapID == 45) {
                            g1.drawImage(imgBG[2], GameScr.gW, gshouseY, 0);
                        } else {
                            for (int index12 = -((GameScr.cmx >> main.GameCanvas.bgSpeed[2]) % imgBGWidth[2]); index12 < GameScr.gW; index12 += imgBGWidth[2]) {
                                if (typeBg == 14) {
                                    g1.drawImage(imgBG[2], index12, gshouseY + 12, 0);
                                } else {
                                    g1.drawImage(imgBG[2], index12, gshouseY, 0);
                                }
                            }
                        }
                    }
                    if (typeBg != 11 && typeBg != 12 && imgBG[1] != null && TileMap.mapID != 52) {
                        for (int index13 = -((GameScr.cmx >> main.GameCanvas.bgSpeed[1]) % imgBGWidth[1]); index13 < GameScr.gW; index13 += imgBGWidth[1]) {
                            g1.drawImage(imgBG[1], index13, main.GameCanvas.bgLayer1y, 0);
                        }
                    }
                    if (TileMap.mapID == 45 || TileMap.mapID == 55) {
                        g1.setColor(1114112);
                        g1.fillRect(0, main.GameCanvas.bgLayer0y + 20, GameScr.gW, GameScr.gH);
                    }
                    if (imgBG[0] != null) {
                        for (int index14 = -((GameScr.cmx >> main.GameCanvas.bgSpeed[0]) % imgBGWidth[0]); index14 < GameScr.gW; index14 += imgBGWidth[0]) {
                            g1.drawImage(imgBG[0], index14, main.GameCanvas.bgLayer0y, 0);
                        }
                    }
                    if (imgCloud != null) {
                        if (typeBg != 13 && typeBg != 15) {
                            for (int index15 = 0; index15 < 2; index15++) {
                                g1.drawImage(imgCloud, main.GameCanvas.cloudX[index15], main.GameCanvas.cloudY[index15], 3);
                            }
                            return;
                        }
                        for (int index16 = 0; index16 < 2; index16++) {
                            g1.drawImage(imgCloud, main.GameCanvas.cloudX[index16], main.GameCanvas.cloudY[index16] - 130, 3);
                        }
                        return;
                    }
                }
            } else {
                g1.setColor(main.GameCanvas.skyColor);
                g1.fillRect(0, 0, GameScr.gW, GameScr.gH);
            }
        }
    }

    public static void freeBackgroundImages() {
        imgBG = null;
        imgCloud = null;
        imgSun = null;
    }

    public static void loadBG(int typeBG) {
        byte byteValue;
        byte byteValue1;
        byte byteValue2;
        label215: {
            byteValue = 0;
            byteValue1 = 0;
            byteValue2 = 0;
            typeBg = typeBG;
            switch(typeBG) {
                case 0:
                case 1:
                default:
                    break label215;
                case 2:
                    main.GameCanvas.bgSpeed = new int[] { 1, 2, 3, 4 };
                    break label215;
                case 3:
                    main.GameCanvas.bgSpeed = new int[] { 1, 2, 3, 4 };
                    break label215;
                case 4:
                    byteValue = 9;
                    byteValue1 = 6;
                    break;
                case 5:
                    main.GameCanvas.bgSpeed = new int[] { 1, 1, 1, 1 };
                    break label215;
                case 6:
                    byteValue = 12;
                    break;
                case 7:
                    main.GameCanvas.bgSpeed = new int[] { 1, 2, 3, 4 };
                    break label215;
                case 8:
                    main.GameCanvas.bgSpeed = new int[] { 1, 2, 3, 4 };
                    break label215;
                case 9:
                    byteValue = 16;
                    byteValue1 = 10;
                    byteValue2 = 6;
                    break;
                case 10:
                    main.GameCanvas.bgSpeed = new int[] { 1, 1, 1, 1 };
                    break label215;
                case 11:
                    main.GameCanvas.bgSpeed = new int[] { 1, 2, 3, 4 };
                    break label215;
                case 12:
                    main.GameCanvas.bgSpeed = new int[] { 1, 2, 3, 4 };
                    break label215;
                case 13:
                    byteValue = 60;
                    break;
                case 14:
                    main.GameCanvas.bgSpeed = new int[] { 1, 2, 3, 4 };
                    break label215;
                case 15:
                    main.GameCanvas.bgSpeed = new int[] { 1, 2, 3, 4 };
                    break label215;
                case 16:
            }
            main.GameCanvas.bgSpeed = new int[] { 1, 2, 3, 4 };
        }
        main.GameCanvas.skyColor = StaticObj.SKYCOLOR[typeBg];
        try {
            if (!main.GameCanvas.lowGraphic) {
                imgBG = new Image[4];
                imgBGWidth = new int[4];
                for (int index = 0; index < 4; index++) {
                    try {
                        if (StaticObj.TYPEBG[typeBg][index] != -1) {
                            imgBG[index] = loadImage("/bg/bg" + index + StaticObj.TYPEBG[typeBg][index] + ".png");
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    if (imgBG[index] != null) {
                        imgBGWidth[index] = mGraphics.getImageWidth(imgBG[index]);
                    }
                }
                if (typeBg == 10) {
                    imgBG[1] = loadImage("/bg/bg09.png");
                    imgBG[2] = loadImage("/bg/bg09.png");
                    imgBGWidth[1] = mGraphics.getImageWidth(imgBG[1]);
                    imgBGWidth[2] = mGraphics.getImageWidth(imgBG[2]);
                }
                if (typeBg == 12) {
                    imgBG[3] = loadImage("/bg/bg39.png");
                    imgBGWidth[3] = mGraphics.getImageWidth(imgBG[3]);
                }
                if (typeBg == 14) {
                    if (main.GameCanvas.isTouch) {
                        main.GameCanvas.bgLayer1y = (main.GameCanvas.bgLayer0y = h - mGraphics.getImageHeight(imgBG[0])) - mGraphics.getImageHeight(imgBG[1]);
                    } else {
                        main.GameCanvas.bgLayer1y = (main.GameCanvas.bgLayer0y = h - mGraphics.getImageHeight(imgBG[0]) - 45) - mGraphics.getImageHeight(imgBG[1]);
                    }
                }
                if (typeBg == 15 && main.GameCanvas.isTouch) {
                    main.GameCanvas.bgLayer1y = (main.GameCanvas.bgLayer0y = h - mGraphics.getImageHeight(imgBG[0])) - mGraphics.getImageHeight(imgBG[1]) + 100;
                }
                if (typeBg == 16) {
                    if (main.GameCanvas.isTouch) {
                        main.GameCanvas.bgLayer1y = (main.GameCanvas.bgLayer0y = h - mGraphics.getImageHeight(imgBG[0])) - mGraphics.getImageHeight(imgBG[1]) + 100;
                    } else {
                        main.GameCanvas.bgLayer1y = (main.GameCanvas.bgLayer0y = h - mGraphics.getImageHeight(imgBG[0]) - 40) - mGraphics.getImageHeight(imgBG[1]) + 100;
                    }
                }
            }
            if (typeBg >= 0 && typeBg <= 1) {
                imgCloud = loadImage("/bg/cl0.png");
                imgSun = loadImage("/bg/sun0.png");
            } else {
                imgCloud = null;
                imgSun = null;
            }
            if (typeBg == 2) {
                imgCloud = loadImage("/bg/cl1.png");
                imgSun = loadImage("/bg/sun1.png");
            }
            if (typeBg == 7 || typeBg == 11 || typeBg == 12) {
                if (TileMap.mapID == 20) {
                    imgCloud = null;
                } else {
                    imgCloud = loadImage("/bg/cl0.png");
                }
            }
            if (typeBG == 13 || typeBG == 15) {
                imgCloud = loadImage("/bg/cl2.png");
            }
        } catch (Exception exception4) {
            exception4.printStackTrace();
        }
        paintBG = false;
        if (!main.GameCanvas.lowGraphic) {
            paintBG = true;
            if (imgBG[0] != null && imgBG[1] != null && imgBG[2] != null) {
                gsskyHeight = GameScr.gH - (mGraphics.getImageHeight(imgBG[0]) + mGraphics.getImageHeight(imgBG[1]) + mGraphics.getImageHeight(imgBG[2])) + 11;
            }
            if (imgBG[0] != null) {
                main.GameCanvas.gsgreenField1Y = GameScr.gH - mGraphics.getImageHeight(imgBG[0]);
            }
            if (imgBG[1] != null) {
                main.GameCanvas.gsgreenField2Y = main.GameCanvas.gsgreenField1Y - mGraphics.getImageHeight(imgBG[1]);
            }
            if (imgBG[2] != null) {
                gshouseY = main.GameCanvas.gsgreenField2Y - mGraphics.getImageHeight(imgBG[2]);
            }
            if (imgBG[3] != null) {
                gsmountainY = main.GameCanvas.gsgreenField2Y - mGraphics.getImageHeight(imgBG[3]) - 10;
            }
            if (typeBg >= 2 && typeBg <= 13) {
                int value;
                main.GameCanvas.bgLayer0y = value = GameScr.gH - mGraphics.getImageHeight(imgBG[0]);
                if (imgBG[1] != null) {
                    value = value - mGraphics.getImageHeight(imgBG[1]) + byteValue;
                }
                main.GameCanvas.bgLayer1y = value;
                if (imgBG[3] != null) {
                    value = value - mGraphics.getImageHeight(imgBG[3]) + byteValue2;
                }
                gsmountainY = value;
                gsskyHeight = value;
                if (imgBG[2] != null) {
                    gshouseY = main.GameCanvas.bgLayer1y - mGraphics.getImageHeight(imgBG[2]) + byteValue1;
                }
                if (typeBg == 2) {
                    gsskyHeight = h;
                }
            }
        }
        int value3 = 0;
        if (typeBg >= 2 && typeBg <= 12) {
            value3 = 2 * GameScr.gH / 3 - main.GameCanvas.bgLayer1y;
        } else {
            value3 = 2 * GameScr.gH / 3 - main.GameCanvas.gsgreenField2Y;
        }
        if (value3 < 0) {
            value3 = 0;
        }
        if (TileMap.mapID == 48 && TileMap.mapID == 51) {
            main.GameCanvas.bgLayer0y += value3;
        }
        if (typeBg >= 2 && typeBg <= 6) {
            main.GameCanvas.bgLayer1y += value3;
        }
        gsskyHeight += value3;
        main.GameCanvas.gsgreenField1Y += value3;
        main.GameCanvas.gsgreenField2Y += value3;
        gshouseY += value3;
        gsmountainY += value3;
        main.GameCanvas.sunX = 3 * GameScr.gW / 4;
        main.GameCanvas.sunY = gsskyHeight / 3;
        main.GameCanvas.cloudX = new int[2];
        main.GameCanvas.cloudY = new int[2];
        main.GameCanvas.cloudX[0] = GameScr.gW / 3;
        main.GameCanvas.cloudY[0] = gsskyHeight / 2 - 8;
        main.GameCanvas.cloudX[1] = 2 * GameScr.gW / 3;
        main.GameCanvas.cloudY[1] = gsskyHeight / 2 + 8;
        if (typeBg == 2) {
            main.GameCanvas.sunY = gsskyHeight / 5;
            main.GameCanvas.cloudX = new int[5];
            main.GameCanvas.cloudY = new int[5];
            main.GameCanvas.cloudX[0] = GameScr.gW / 3;
            main.GameCanvas.cloudY[0] = gsskyHeight / 3 - 35;
            main.GameCanvas.cloudX[1] = 3 * GameScr.gW / 4;
            main.GameCanvas.cloudY[1] = gsskyHeight / 3 + 12;
            main.GameCanvas.cloudX[2] = GameScr.gW / 3 - 15;
            main.GameCanvas.cloudY[2] = gsskyHeight / 3 + 12;
            main.GameCanvas.cloudX[3] = GameScr.gW / 15;
            main.GameCanvas.cloudY[3] = gsskyHeight / 2 + 12;
            main.GameCanvas.cloudX[4] = 2 * GameScr.gW / 3 + 25;
            main.GameCanvas.cloudY[4] = gsskyHeight / 3 + 12;
        }
        if (!main.GameCanvas.lowGraphic) {
            if (typeBg == 8) {
                main.GameCanvas.bgLayer0y = main.GameCanvas.bgLayer1y = GameScr.gH2 - 50;
            }
            if (typeBg == 10 && imgBG[3] != null) {
                gsmountainY = gshouseY - mGraphics.getImageHeight(imgBG[3]);
            }
            if (typeBg == 11 || typeBg == 12) {
                gsmountainY = 0;
            }
        }
    }

    protected final void keyPressed(int value) {
        lastTimePress = System.currentTimeMillis();
        if (value >= 48 && value <= 57 || value >= 65 && value <= 122 || value == 10 || value == 8 || value == 13 || value == 32) {
            main.GameCanvas.keyAsciiPress = value;
        }
        int value1 = value;
        if (currentDialog != null) {
            currentDialog.keyPress(value1);
            main.GameCanvas.keyAsciiPress = 0;
        } else {
            currentScreen.keyPress(value1);
            switch(value1) {
                case -39:
                case -2:
                    if (currentScreen instanceof GameScr) {
                        Char.getMyChar();
                    }
                    main.GameCanvas.keyHold[8] = true;
                    main.GameCanvas.keyPressedz[8] = true;
                    return;
                case -38:
                case -1:
                    if (currentScreen instanceof GameScr) {
                        Char.getMyChar();
                    }
                    main.GameCanvas.keyHold[2] = true;
                    main.GameCanvas.keyPressedz[2] = true;
                    return;
                case -22:
                case -7:
                    main.GameCanvas.keyHold[13] = true;
                    main.GameCanvas.keyPressedz[13] = true;
                    return;
                case -21:
                case -6:
                    main.GameCanvas.keyHold[12] = true;
                    main.GameCanvas.keyPressedz[12] = true;
                    return;
                case -5:
                case 10:
                    if (currentScreen instanceof GameScr) {
                        Char.getMyChar();
                    }
                    main.GameCanvas.keyHold[5] = true;
                    main.GameCanvas.keyPressedz[5] = true;
                    return;
                case -4:
                    if (currentScreen instanceof GameScr) {
                        Char.getMyChar();
                    }
                    main.GameCanvas.keyHold[6] = true;
                    main.GameCanvas.keyPressedz[6] = true;
                    return;
                case -3:
                    if (currentScreen instanceof GameScr) {
                        Char.getMyChar();
                    }
                    main.GameCanvas.keyHold[4] = true;
                    main.GameCanvas.keyPressedz[4] = true;
                    return;
                case 35:
                    main.GameCanvas.keyHold[11] = true;
                    main.GameCanvas.keyPressedz[11] = true;
                    return;
                case 42:
                    main.GameCanvas.keyHold[10] = true;
                    main.GameCanvas.keyPressedz[10] = true;
                    return;
                case 48:
                    main.GameCanvas.keyHold[0] = true;
                    main.GameCanvas.keyPressedz[0] = true;
                    return;
                case 49:
                    if (currentScreen == GameScr.instance && main.GameCanvas.isMoveNumberPad && !ChatTextField.gI().isShow) {
                        main.GameCanvas.keyHold[1] = true;
                        main.GameCanvas.keyPressedz[1] = true;
                    }
                    return;
                case 50:
                    if (currentScreen == GameScr.instance && main.GameCanvas.isMoveNumberPad && !ChatTextField.gI().isShow && !GameScr.isPaintAuctionSale) {
                        main.GameCanvas.keyHold[2] = true;
                        main.GameCanvas.keyPressedz[2] = true;
                    }
                    return;
                case 51:
                    if (currentScreen == GameScr.instance && main.GameCanvas.isMoveNumberPad && !ChatTextField.gI().isShow) {
                        main.GameCanvas.keyHold[3] = true;
                        main.GameCanvas.keyPressedz[3] = true;
                    }
                    return;
                case 52:
                    if (currentScreen == GameScr.instance && main.GameCanvas.isMoveNumberPad && !ChatTextField.gI().isShow && !GameScr.isPaintAuctionSale) {
                        main.GameCanvas.keyHold[4] = true;
                        main.GameCanvas.keyPressedz[4] = true;
                    }
                    return;
                case 53:
                    if (currentScreen == GameScr.instance && main.GameCanvas.isMoveNumberPad && !ChatTextField.gI().isShow && !GameScr.isPaintAuctionSale) {
                        main.GameCanvas.keyHold[5] = true;
                        main.GameCanvas.keyPressedz[5] = true;
                    }
                default:
                    return;
                case 54:
                    if (currentScreen == GameScr.instance && main.GameCanvas.isMoveNumberPad && !ChatTextField.gI().isShow && !GameScr.isPaintAuctionSale) {
                        main.GameCanvas.keyHold[6] = true;
                        main.GameCanvas.keyPressedz[6] = true;
                    }
                    return;
                case 55:
                    main.GameCanvas.keyHold[7] = true;
                    main.GameCanvas.keyPressedz[7] = true;
                    return;
                case 56:
                    if (currentScreen == GameScr.instance && main.GameCanvas.isMoveNumberPad && !ChatTextField.gI().isShow && !GameScr.isPaintAuctionSale) {
                        main.GameCanvas.keyHold[8] = true;
                        main.GameCanvas.keyPressedz[8] = true;
                    }
                    return;
                case 57:
                    main.GameCanvas.keyHold[9] = true;
                    main.GameCanvas.keyPressedz[9] = true;
            }
        }
    }

    protected final void keyReleased(int value) {
        main.GameCanvas.keyAsciiPress = 0;
        switch(value) {
            case -39:
            case -2:
                main.GameCanvas.keyHold[8] = false;
                return;
            case -38:
            case -1:
                main.GameCanvas.keyHold[2] = false;
                return;
            case -22:
            case -7:
                main.GameCanvas.keyHold[13] = false;
                main.GameCanvas.keyReleasedz[13] = true;
                return;
            case -21:
            case -6:
                main.GameCanvas.keyHold[12] = false;
                main.GameCanvas.keyReleasedz[12] = true;
                return;
            case -5:
            case 10:
                main.GameCanvas.keyHold[5] = false;
                main.GameCanvas.keyReleasedz[5] = true;
                return;
            case -4:
                main.GameCanvas.keyHold[6] = false;
                return;
            case -3:
                main.GameCanvas.keyHold[4] = false;
                return;
            case 35:
                main.GameCanvas.keyHold[11] = false;
                main.GameCanvas.keyReleasedz[11] = true;
                return;
            case 42:
                main.GameCanvas.keyHold[10] = false;
                main.GameCanvas.keyReleasedz[10] = true;
                return;
            case 48:
                main.GameCanvas.keyHold[0] = false;
                main.GameCanvas.keyReleasedz[0] = true;
                return;
            case 49:
                if (currentScreen == GameScr.instance && main.GameCanvas.isMoveNumberPad && !ChatTextField.gI().isShow) {
                    main.GameCanvas.keyHold[1] = false;
                    main.GameCanvas.keyReleasedz[1] = true;
                }
                return;
            case 50:
                if (currentScreen == GameScr.instance && main.GameCanvas.isMoveNumberPad && !ChatTextField.gI().isShow) {
                    main.GameCanvas.keyHold[2] = false;
                    main.GameCanvas.keyReleasedz[2] = true;
                }
                return;
            case 51:
                if (currentScreen == GameScr.instance && main.GameCanvas.isMoveNumberPad && !ChatTextField.gI().isShow) {
                    main.GameCanvas.keyHold[3] = false;
                    main.GameCanvas.keyReleasedz[3] = true;
                }
                return;
            case 52:
                if (currentScreen == GameScr.instance && main.GameCanvas.isMoveNumberPad && !ChatTextField.gI().isShow) {
                    main.GameCanvas.keyHold[4] = false;
                    main.GameCanvas.keyReleasedz[4] = true;
                }
                return;
            case 53:
                if (currentScreen == GameScr.instance && main.GameCanvas.isMoveNumberPad && !ChatTextField.gI().isShow) {
                    main.GameCanvas.keyHold[5] = false;
                    main.GameCanvas.keyReleasedz[5] = true;
                }
            default:
                return;
            case 54:
                if (currentScreen == GameScr.instance && main.GameCanvas.isMoveNumberPad && !ChatTextField.gI().isShow) {
                    main.GameCanvas.keyHold[6] = false;
                    main.GameCanvas.keyReleasedz[6] = true;
                }
                return;
            case 55:
                main.GameCanvas.keyHold[7] = false;
                main.GameCanvas.keyReleasedz[7] = true;
                return;
            case 56:
                if (currentScreen == GameScr.instance && main.GameCanvas.isMoveNumberPad && !ChatTextField.gI().isShow) {
                    main.GameCanvas.keyHold[8] = false;
                    main.GameCanvas.keyReleasedz[8] = true;
                }
                return;
            case 57:
                main.GameCanvas.keyHold[9] = false;
                main.GameCanvas.keyReleasedz[9] = true;
        }
    }

    protected final void pointerDragged(int x, int y) {
        if (Res.abs(x - main.GameCanvas.pxLast) >= 10 || Res.abs(y - main.GameCanvas.pyLast) >= 10) {
            isPointerClick = false;
        }
        px = x;
        py = y;
        if (++main.GameCanvas.curPos > 3) {
            main.GameCanvas.curPos = 0;
        }
        main.GameCanvas.arrPos[main.GameCanvas.curPos] = new Position(x, y);
    }

    public static boolean isHoldPress() {
        return System.currentTimeMillis() - lastTimePress >= 800L;
    }

    protected final void pointerPressed(int x, int y) {
        isPointerDown = true;
        isPointerClick = true;
        lastTimePress = System.currentTimeMillis();
        main.GameCanvas.pxLast = x;
        main.GameCanvas.pyLast = y;
        px = x;
        py = y;
    }

    protected final void pointerReleased(int x, int y) {
        isPointerDown = false;
        isPointerJustRelease = true;
        mScreen.keyTouch = -1;
        px = x;
        py = y;
    }

    public static boolean isPointerInGame(int value, int value1, int value2, int value3) {
        int value4 = px + GameScr.cmx;
        int value5 = GameScr.cmy + py;
        return !isPointerDown && !isPointerJustRelease ? false : value4 >= value && value4 <= value + value2 && value5 >= value1 && value5 <= value1 + value3;
    }

    public static boolean isPointerInRoll(int x, int y, int w1, int h2, Scroll scroll) {
        int value = px + scroll.cmx;
        int value3 = scroll.cmy + py;
        return !isPointerDown && !isPointerJustRelease ? false : value >= x && value <= x + w1 && value3 >= y && value3 <= y + h2;
    }

    public static boolean isPointerHoldIn(int value, int value1, int value2, int value3) {
        return !isPointerDown && !isPointerJustRelease ? false : px >= value && px <= value + value2 && py >= value1 && py <= value1 + value3;
    }

    public static void clearKeyPressed() {
        for (int index = 0; index < 14; index++) {
            main.GameCanvas.keyPressedz[index] = false;
        }
        isPointerJustRelease = false;
    }

    public static void clearKeyHold() {
        for (int index = 0; index < 14; index++) {
            main.GameCanvas.keyHold[index] = false;
        }
    }

    protected final void paint(Graphics graphics) {
        this.g.graphics = graphics;
        try {
            if (currentScreen != null && !isLoading) {
                currentScreen.paint(this.g);
                this.g.setClip(0, 0, w, h);
            }
            this.g.translate(-this.g.getTranslateX(), -this.g.getTranslateY());
            this.g.setClip(0, 0, w, h);
            InfoDlg.paint(this.g);
            if (currentDialog != null) {
                currentDialog.paint(this.g);
            } else if (menu.showMenu) {
                menu.paintMenu(this.g);
            }
            GameScr.resetTranslate(this.g);
            mGraphics graphics1 = this.g;
            if (isKiemduyet) {
                if ((main.GameCanvas.wStr = mFont.tahoma_7b_yellow.getWidth(mResources.kiemduyet)) > w && --main.GameCanvas.xKd < -440) {
                    main.GameCanvas.xKd = w;
                }
                graphics1.setColor(0);
                graphics1.fillRect(0, 0, w, 16);
                mFont.tahoma_7b_yellow.drawString(graphics1, mResources.kiemduyet, main.GameCanvas.xKd + 20, 3, 0);
                graphics1.drawImage(main.GameCanvas.imgPlus12, 0, 0, 0);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void endDlg() {
        if (inputDlg != null) {
            inputDlg.tfInput.setMaxTextLenght(500);
        }
        if (input2Dlg != null) {
            input2Dlg.tfInput.setMaxTextLenght(500);
            input2Dlg.tfInput2.setMaxTextLenght(500);
        }
        currentDialog = null;
    }

    public static void startOKDlg(String info) {
        msgdlg.setInfo(info, null, new Command(mResources.OK, instance, 8882, null), null);
        currentDialog = msgdlg;
    }

    public static void startWaitDlg(String info) {
        msgdlg.setInfo(info, null, new Command(mResources.CANCEL, instance, 8882, null), null);
        currentDialog = msgdlg;
        msgdlg.isWait = true;
    }

    public static void startWaitDlg() {
        startWaitDlg(mResources.PLEASEWAIT);
    }

    public static void startWaitDlgWithoutCancel() {
        msgdlg.timeShow = 500;
        msgdlg.setInfo(mResources.PLEASEWAIT, null, null, null);
        currentDialog = msgdlg;
        msgdlg.isWait = true;
    }

    public final void openWeb(String strLeft, String strRight, String url, String str) {
        msgdlg.setInfo(str, new Command(strLeft, this, 8881, url), null, new Command(strRight, this, 8882, null));
        currentDialog = msgdlg;
    }

    public final void sendSms(String strLeft, String strRight, short port, String syntax, String str) {
        MyVector entries;
        (entries = new MyVector()).addElement(new Short(port));
        entries.addElement(syntax);
        msgdlg.setInfo(str, new Command(strLeft, this, 8883, entries), null, new Command(strRight, this, 8882, null));
        currentDialog = msgdlg;
    }

    public static void startOK(String info, int actionID, Object p) {
        msgdlg.setInfo(info, null, new Command(mResources.OK, instance, actionID, null, w / 2 - 35, h - 50), null);
        MsgDlg msgDlg = msgdlg;
        currentDialog = msgdlg;
    }

    public static void startYesNoDlg(String info, int iYes, Object pYes, int iNo, Object pNo) {
        new StringBuffer("yeso no dilog ").append(iNo).toString();
        msgdlg.setInfo(info, new Command(mResources.YES, instance, iYes, pYes), new Command("", instance, iYes, pYes), new Command(mResources.NO, instance, iNo, pNo));
        MsgDlg msgDlg = msgdlg;
        currentDialog = msgdlg;
    }

    public static void startYesNoDlg(String info, Command cmdYes, Command cmdNo) {
        msgdlg.setInfo(info, cmdYes, null, cmdNo);
        MsgDlg msgDlg = msgdlg;
        currentDialog = msgdlg;
    }

    public static Image loadImage(String path) {
        path = "/x" + mGraphics.zoomLevel + path;
        Image image = null;
        try {
            image = Image.createImage(path);
        } catch (IOException iOException) {
        }
        return image;
    }

    public final boolean startDust(int dir, int x, int y) {
        if (main.GameCanvas.lowGraphic) {
            return false;
        }
        dir = dir == 1 ? 0 : 1;
        if (this.dustState[dir] != -1) {
            return false;
        }
        this.dustState[dir] = 0;
        this.dustX[dir] = x;
        this.dustY[dir] = y;
        return true;
    }

    private static void loadWaterSplash() {
        if (!main.GameCanvas.lowGraphic) {
            main.GameCanvas.imgWS = new Image[3];
            for (int index = 0; index < 3; index++) {
                main.GameCanvas.imgWS[index] = loadImage("/e/w" + index + ".png");
            }
            main.GameCanvas.wsX = new int[2];
            main.GameCanvas.wsY = new int[2];
            (main.GameCanvas.wsState = new int[2])[0] = main.GameCanvas.wsState[1] = -1;
        }
    }

    public static boolean startWaterSplash(int value, int value1) {
        if (main.GameCanvas.lowGraphic) {
            return false;
        }
        int value2 = main.GameCanvas.wsState[0] == -1 ? 0 : 1;
        if (main.GameCanvas.wsState[value2] != -1) {
            return false;
        }
        main.GameCanvas.wsState[value2] = 0;
        main.GameCanvas.wsX[value2] = value;
        main.GameCanvas.wsY[value2] = value1;
        return true;
    }

    public final void updateDust() {
        if (!main.GameCanvas.lowGraphic) {
            for (int index = 0; index < 2; index++) {
                if (this.dustState[index] != -1) {
                    this.dustState[index]++;
                    if (this.dustState[index] >= 5) {
                        this.dustState[index] = -1;
                    }
                    if (index == 0) {
                        this.dustX[index]--;
                    } else {
                        this.dustX[index]++;
                    }
                    this.dustY[index]--;
                }
            }
        }
    }

    public static boolean isPaint(int x, int y) {
        if (x < GameScr.cmx) {
            return false;
        } else if (x > GameScr.cmx + GameScr.gW) {
            return false;
        } else {
            return y < GameScr.cmy ? false : y <= GameScr.cmy + GameScr.gH + 30;
        }
    }

    public final void paintDust(mGraphics g1) {
        if (!main.GameCanvas.lowGraphic) {
            for (int index = 0; index < 2; index++) {
                if (this.dustState[index] != -1 && isPaint(this.dustX[index], this.dustY[index])) {
                    g1.drawImage(imgDust[index][this.dustState[index]], this.dustX[index], this.dustY[index], 3);
                }
            }
        }
    }

    public static void paintShukiren(int x, int y, mGraphics g1, boolean noRotate) {
        int value = gameTick % 3;
        g1.drawRegion(main.GameCanvas.imgShuriken, 0, value << 4, 16, 16, 0, x, y, 3);
    }

    public final void resetToLoginScr() {
        isLoading = false;
        this.resetToLoginScrz = true;
    }

    public static boolean isPointer(int value, int value1, int value2, int value3) {
        return !isPointerDown && !isPointerJustRelease ? false : px >= value && px <= value + value2 && py >= value1 && py <= value1 + value3;
    }

    public final void perform(int idAction, Object p) {
        switch(idAction) {
            case 1608:
                Service.gI().ChucTet(input2Dlg.tfInput.getText(), input2Dlg.tfInput2.getText(), (byte) 0);
                endDlg();
                return;
            case 1700:
                Service.gI().luckyDraw((short) 100, inputDlg.tfInput.getText(), GameScr.typeLucky_Draw);
                endDlg();
                break;
            case 8880:
                endDlg();
                languageScr.switchToMe();
                return;
            case 8881:
                String text;
                NinjaUtil.downloadGame(text = (String) p);
                currentDialog = null;
                return;
            case 8882:
                currentDialog = null;
                return;
            case 8883:
                short shortValue = ((Short) ((MyVector) p).elementAt(0)).shortValue();
                NinjaUtil.sendMsDK((String) ((MyVector) p).elementAt(0), shortValue);
                currentDialog = null;
                return;
            case 8884:
                endDlg();
                selectsvScr.switchToMe();
                return;
            case 8885:
                GameMidlet.instance.notifyDestroyed();
                return;
            case 8886:
                startYesNoDlg(mResources.NEW_ACC_ARLET, new Command(mResources.COUNTINUE, instance, 8880, null), new Command(mResources.NO, instance, 8882, null));
                return;
            case 8887:
                endDlg();
                int value = ((Integer) p).intValue();
                Service.gI().addPartyAccept(value);
                return;
            case 8888:
                int value1 = ((Integer) p).intValue();
                Service.gI().addPartyCancel(value1);
                endDlg();
                return;
            case 8889:
                String text2 = (String) p;
                endDlg();
                Service.gI().acceptPleaseParty(text2);
                return;
            case 8890:
                endDlg();
                Service.gI().sendUIConfirmID(((Integer) p).intValue());
                return;
            case 8891:
                Service.gI().sendUIConfirmID(0);
                currentDialog = null;
                return;
            case 16081:
                Service.gI().ChucTet(input2Dlg.tfInput.getText(), input2Dlg.tfInput2.getText(), (byte) 1);
                endDlg();
                return;
            case 88810:
                int value3 = ((Integer) p).intValue();
                endDlg();
                Service.gI().acceptInviteTrade(value3);
                return;
            case 88811:
                endDlg();
                Service.gI().cancelInviteTrade();
                return;
            case 88812:
                Char character = (Char) p;
                endDlg();
                Service.gI().acceptInviteTest(character.charID);
                return;
            case 88813:
                endDlg();
                Item[] values = (Item[]) p;
                Service.gI().crystalCollect(values);
                return;
            case 88814:
                Item[] values4 = (Item[]) p;
                endDlg();
                Service.gI().crystalCollectLock(values4);
                return;
            case 88815:
                GameScr.gI();
                GameScr.doUpgrade();
                return;
            case 88816:
                Service.gI().sendCardInfo(input2Dlg.tfInput.getText(), input2Dlg.tfInput2.getText());
                endDlg();
                return;
            case 88817:
                if (Char.getMyChar().npcFocus != null) {
                    Service.gI().menu((byte) 0, Char.getMyChar().npcFocus.template.npcTemplateId, menu.menuSelectedItem, 0);
                    return;
                }
                Service.gI().menu((byte) 0, 0, menu.menuSelectedItem, 0);
                return;
            case 88818:
                short shortValue5 = ((Short) p).shortValue();
                Service.gI().textBoxId(shortValue5, inputDlg.tfInput.getText());
                endDlg();
                return;
            case 88819:
                short shortValue6 = ((Short) p).shortValue();
                Service.gI().menuId(shortValue6);
                GameScr.gI().doCloseAlert();
                return;
            case 88820:
                String[] textLines = (String[]) p;
                if (Char.getMyChar().npcFocus == null) {
                    return;
                }
                Integer boxedValue = new Integer(menu.menuSelectedItem);
                if (textLines.length <= 1) {
                    ChatPopup.addChatPopup("", 1, Char.getMyChar().npcFocus);
                    Service.gI().menu((byte) 0, Char.getMyChar().npcFocus.template.npcTemplateId, (boxedValue).intValue(), 0);
                    return;
                }
                MyVector entries = new MyVector();
                for (int index = 0; index < textLines.length - 1; index++) {
                    entries.addElement(new Command(textLines[index + 1], instance, 88821, boxedValue));
                }
                menu.startAt(entries);
                return;
            case 88821:
                int value7 = ((Integer) p).intValue();
                ChatPopup.addChatPopup("", 1, Char.getMyChar().npcFocus);
                Service.gI().menu((byte) 0, Char.getMyChar().npcFocus.template.npcTemplateId, value7, menu.menuSelectedItem);
                return;
            case 88822:
                ChatPopup.addChatPopup("", 1, Char.getMyChar().npcFocus);
                Service.gI().menu((byte) 0, Char.getMyChar().npcFocus.template.npcTemplateId, menu.menuSelectedItem, 0);
                return;
            case 88823:
                startOKDlg(mResources.SENTMSG);
                return;
            case 88824:
                startOKDlg(mResources.NOSENDMSG);
                return;
            case 88825:
                String text8 = mResources.SENT_SUCCESS1;
                startOKDlg(mResources.SENT_SUCCESS1);
                return;
            case 88826:
                String text9 = mResources.NOT_SENT_SUCCESS;
                startOKDlg(mResources.NOT_SENT_SUCCESS);
                return;
            case 88827:
                startOKDlg(mResources.SENT_SUCCESS2);
                return;
            case 88828:
                startOKDlg(mResources.SENT_UNSUCCESS);
                return;
            case 88829:
                String text10;
                if ((text10 = inputDlg.tfInput.getText()).equals("")) {
                    return;
                }
                Service.gI().changeName(text10, ((Integer) p).intValue());
                startWaitDlg(mResources.PLEASEWAIT);
                return;
            case 88830:
                int value11 = ((Integer) p).intValue();
                endDlg();
                Service.gI().acceptInviteClan(value11);
                return;
            case 88831:
                int value12 = ((Integer) p).intValue();
                endDlg();
                Service.gI().acceptPleaseClan(value12);
                return;
            case 88832:
                String text13 = inputDlg.tfInput.getText();
                endDlg();
                if (!text13.equals("")) {
                    Service.gI().changeClanAlert(text13);
                    return;
                }
                break;
            case 88833:
                String text14 = inputDlg.tfInput.getText();
                endDlg();
                if (!text14.equals("")) {
                    try {
                        int value15 = Integer.parseInt(text14);
                        if (Char.getMyChar().xu >= value15 && value15 >= 0) {
                            Service.gI().inputCoinClan(value15);
                            return;
                        }
                        InfoMe.addInfo(mResources.NOT_ENOUGH_XU, 20, mFont.tahoma_7_yellow);
                        return;
                    } catch (Exception exception) {
                        return;
                    }
                }
                break;
            case 88834:
                String text16 = inputDlg.tfInput.getText();
                endDlg();
                if (!text16.equals("")) {
                    try {
                        int value17;
                        if ((value17 = Integer.parseInt(text16)) <= 0) {
                            return;
                        }
                        Service.gI().outputCoinClan(value17);
                        return;
                    } catch (Exception exception29) {
                        return;
                    }
                }
                break;
            case 88835:
                int value18 = Integer.parseInt((String) p);
                idAction = Integer.parseInt(inputDlg.tfInput.getText());
                currentDialog = null;
                if (idAction >= 1 && idAction < Char.getMyChar().arrItemBag[value18].quantity) {
                    Service.gI().inputNumSplit(value18, idAction);
                    return;
                }
                startOKDlg(mResources.INVALID_NUMSPLIT);
                return;
            case 88836:
                inputDlg.tfInput.setMaxTextLenght(6);
                inputDlg.show(mResources.INPUT_PRIVATE_PASS, new Command(mResources.ACCEPT, instance, 888361, null), 1);
                return;
            case 88837:
                String text19 = inputDlg.tfInput.getText();
                endDlg();
                try {
                    Service.gI().openLockAccProtect(Integer.parseInt(text19.trim()));
                    return;
                } catch (Exception exception30) {
                    return;
                }
            case 88838:
                String text20 = input2Dlg.tfInput.getText().trim();
                String text21 = input2Dlg.tfInput2.getText().trim();
                endDlg();
                if (text20.length() >= 6 && text21.length() >= 6) {
                    try {
                        int value22 = Integer.parseInt(text20);
                        idAction = Integer.parseInt(text21);
                        if (value22 >= 99999 && idAction >= 99999) {
                            Service.gI().updateActive(value22, idAction);
                            return;
                        }
                        startOKDlg(mResources.ALERT_PRIVATE_PASS_3);
                        return;
                    } catch (Exception exception31) {
                        startOKDlg(mResources.ALERT_PRIVATE_PASS_2);
                        return;
                    }
                }
                startOKDlg(mResources.ALERT_PRIVATE_PASS_1);
                return;
            case 88839:
                String text23 = inputDlg.tfInput.getText();
                endDlg();
                try {
                    Integer.parseInt(text23);
                    startYesNoDlg(mResources.CANCEL_PROTECT, 888391, text23, 8882, null);
                    return;
                } catch (Exception exception32) {
                    InfoMe.addInfo(mResources.ALERT_PRIVATE_PASS_4, 20, mFont.tahoma_7_yellow);
                    return;
                }
            case 88840:
                Char character24 = (Char) p;
                endDlg();
                Service.gI().acceptInviteTestDun(character24.charID);
                return;
            case 88841:
                Char character25 = (Char) p;
                endDlg();
                Service.gI().acceptInviteTestGT(character25.charID);
                return;
            case 88842:
                Service.gI().acceptClanBattlefield();
                return;
            case 88843:
                String text26 = inputDlg.tfInput.getText();
                endDlg();
                if (text26.equals("")) {
                    startOKDlg(mResources.INVALID_NUM);
                    return;
                }
                Service.gI().sendClanItem(text26);
                return;
            case 888181:
                short shortValue27 = ((Short) p).shortValue();
                Service.gI().SendCapcha(shortValue27, inputDlg.tfInput.getText());
                main.GameCanvas.testCapcha = null;
                endDlg();
                return;
            case 888361:
                String text28 = inputDlg.tfInput.getText();
                endDlg();
                if (text28.length() >= 6 && !text28.equals("")) {
                    try {
                        Service.gI().activeAccProtect(Integer.parseInt(text28));
                        return;
                    } catch (Exception exception33) {
                        startOKDlg(mResources.ALERT_PRIVATE_PASS_2);
                        return;
                    }
                }
                startOKDlg(mResources.ALERT_PRIVATE_PASS_1);
                return;
            case 888391:
                try {
                    endDlg();
                    idAction = Integer.parseInt((String) p);
                    Service.gI().clearAccProtect(idAction);
                    return;
                } catch (Exception exception34) {
                    return;
                }
        }
    }
}
