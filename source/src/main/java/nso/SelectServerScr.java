package nso;

import main.GameCanvas;
import main.GameMidlet;

public final class SelectServerScr extends mScreen implements IActionListener {

    private int popupW;

    private int popupH;

    private int popupX;

    private int popupY;

    private int indexRow = -1;

    private static String[] menu;

    public static String uname;

    public static String pass;

    public static String unameChange = "";

    public static String passChange = "";

    private static Command cmdChoiMoi = null;

    private static Command cmdDoiTaiKhoan = null;

    private static Command cmdChoiTiep = null;

    private static Command cmdChonServer = null;

    private static Command cmdUpdLinkSv = null;

    private static Command[][] cmd = null;

    private static int ipSelect;

    public SelectServerScr() {
    }

    public static void loadIP() {
        if ((ipSelect = RMS.loadRMSInt("indServer")) >= 0 && ipSelect <= GameMidlet.nameServer.length - 1) {
            loadInfoIp(ipSelect);
        } else {
            loadInfoIp(GameMidlet.GetWorldIndex());
        }
    }

    public static void loadInfoIp(int index) {
        if (Session_ME.gI().isConnected()) {
            Session_ME.gI().close();
        }
        ipSelect = index;
        index = index;
        RMS.saveRMSInt("indServer", index);
        GameMidlet.IP = GameMidlet.ipList[ipSelect];
        GameMidlet.PORT = GameMidlet.portList[ipSelect];
        GameMidlet.serverLogin = GameMidlet.serverLoginList[ipSelect];
        mResources.loadLanguage(GameMidlet.language[ipSelect]);
        GameCanvas.menu.menuSelectedItem = GameMidlet.serverST[ipSelect];
        GameCanvas.connect(7);
    }

    public final void switchToMe() {
        if (RMS.loadRMSInt("isKiemduyet") == 0) {
            GameCanvas.isKiemduyet = true;
        } else {
            GameCanvas.isKiemduyet = false;
        }
        GameScr.gH = GameCanvas.h;
        if (GameCanvas.typeBg == 2) {
            GameCanvas.loadBG(0);
        } else {
            GameCanvas.loadBG(TileMap.bgID);
        }
        super.switchToMe();
        if (GameScr.instance != null) {
            GameScr.instance = null;
        }
        if ((TileMap.bgID = (byte) (System.currentTimeMillis() % 9L)) == 5 || TileMap.bgID == 6) {
            TileMap.bgID = 4;
        }
        GameScr.loadCamera(true);
        GameScr.cmx = 100;
        this.popupW = 170;
        this.popupH = 175;
        if (GameCanvas.w == 128 || GameCanvas.h <= 208) {
            this.popupW = 126;
            this.popupH = 160;
        }
        this.popupX = GameCanvas.w / 2 - this.popupW / 2;
        this.popupY = GameCanvas.h / 2 - this.popupH / 2;
        if (GameCanvas.h <= 250) {
            this.popupY -= 10;
        }
        super.right = new Command(mResources.EXIT, GameCanvas.instance, 8885, null);
        super.left = new Command(mResources.LANGUAGE, GameCanvas.instance, 8886, null);
        this.indexRow = -1;
        if (!GameCanvas.isTouch) {
            this.indexRow = 0;
        }
        if (GameCanvas.isTouch && GameCanvas.w >= 320) {
            super.right.x = GameCanvas.w / 2 + 88;
        }
        if (nso.SelectServerScr.cmdChoiMoi == null) {
            nso.SelectServerScr.cmdChoiMoi = new Command(GameCanvas.isTouch ? "" : mResources.OK, this, 1000, null);
            nso.SelectServerScr.cmdDoiTaiKhoan = new Command(GameCanvas.isTouch ? "" : mResources.OK, this, 1001, null);
            nso.SelectServerScr.cmdChonServer = new Command(GameCanvas.isTouch ? "" : mResources.OK, this, 1002, null);
            nso.SelectServerScr.cmdChoiTiep = new Command(GameCanvas.isTouch ? "" : mResources.OK, this, 1003, null);
            nso.SelectServerScr.cmdUpdLinkSv = new Command(GameCanvas.isTouch ? "" : mResources.OK, this, 20100, null);
            cmd = new Command[][] { { nso.SelectServerScr.cmdChoiMoi, nso.SelectServerScr.cmdDoiTaiKhoan, nso.SelectServerScr.cmdChonServer, nso.SelectServerScr.cmdUpdLinkSv }, { nso.SelectServerScr.cmdChoiTiep, nso.SelectServerScr.cmdChoiMoi, nso.SelectServerScr.cmdDoiTaiKhoan, nso.SelectServerScr.cmdChonServer, nso.SelectServerScr.cmdUpdLinkSv } };
        }
        uname = RMS.loadRMSString("acc");
        pass = RMS.loadRMSString("pass");
        if (uname == null) {
            uname = "";
        }
        if (pass == null) {
            pass = "";
        }
        if ((uname == null || uname.equals("")) && unameChange.equals("")) {
            menu = new String[] { mResources.NEW_PLAY, mResources.CHANGE_ACC, mResources.SERVER, mResources.UPDATE_LINKSV };
        } else {
            menu = new String[] { mResources.COUNTINUE_PLAY, mResources.NEW_PLAY, mResources.CHANGE_ACC, mResources.SERVER, mResources.UPDATE_LINKSV };
        }
        GameCanvas.menu.menuSelectedItem = GameMidlet.GetWorldIndex();
        GameMidlet.IP = GameMidlet.ipList[GameMidlet.GetWorldIndex()];
        if (RMS.loadRMSInt("indServer") > -1 && RMS.loadRMSInt("indServer") < GameMidlet.ipList.length) {
            GameCanvas.menu.menuSelectedItem = RMS.loadRMSInt("indServer");
            GameMidlet.IP = GameMidlet.ipList[RMS.loadRMSInt("indServer")];
        }
        if (RMS.loadRMSString("random") == null) {
            RMS.saveRMSString("random", randomNumberlist());
        }
    }

    public final void paint(mGraphics g) {
        g.setColor(0);
        g.fillRect(0, 0, GameCanvas.w, GameCanvas.h);
        GameCanvas.paintBGGameScr(g);
        g.drawImage(LoginScr.imgTitle, GameCanvas.hw - LoginScr.imgTitle.getWidth() / 2, this.popupY + 10 - LoginScr.imgTitle.getHeight() / 2, 0);
        if (!GameCanvas.isTouch && GameCanvas.menu.menuSelectedItem == -1) {
            GameCanvas.menu.menuSelectedItem = 0;
        }
        int value = this.popupY + 50;
        for (int index = 0; index < menu.length; index++) {
            g.setColor(Paint.COLORDARK);
            g.fillRect(this.popupX + 10, value + index * 35, this.popupW - 20, 28);
            Paint.paintFrameBorder(this.popupX + 10, value + index * 35, this.popupW - 20, 28, g);
            if (index == this.indexRow) {
                g.setColor(Paint.COLORLIGHT);
                g.fillRect(this.popupX + 10, value + index * 35, this.popupW - 20, 28);
                Paint.paintFrameBorder(this.popupX + 10, value + index * 35, this.popupW - 20, 28, g);
            }
            if (index < menu.length) {
                if (uname.equals("") && unameChange.equals("")) {
                    if (index == 2) {
                        String text = GameMidlet.nameServer[RMS.loadRMSInt("indServer")];
                        mFont.tahoma_7b_white.drawString(g, menu[index] + text, this.popupX + this.popupW / 2, value + index * 35 + 8, 2);
                    } else {
                        mFont.tahoma_7b_white.drawString(g, menu[index], this.popupX + this.popupW / 2, value + index * 35 + 8, 2);
                    }
                } else if (index == 0) {
                    mFont.tahoma_7b_white.drawString(g, menu[index] + (!unameChange.equals("") ? ": " + unameChange : (uname.startsWith("tmpusr") ? "" : ": " + uname)), this.popupX + this.popupW / 2, value + index * 35 + 8, 2);
                } else if (index == 3) {
                    String text1 = GameMidlet.nameServer[RMS.loadRMSInt("indServer")];
                    mFont.tahoma_7b_white.drawString(g, menu[index] + text1, this.popupX + this.popupW / 2, value + index * 35 + 8, 2);
                } else {
                    mFont.tahoma_7b_white.drawString(g, menu[index], this.popupX + this.popupW / 2, value + index * 35 + 8, 2);
                }
            }
        }
        if (GameCanvas.currentDialog == null) {
            Paint.paintCmdBar(g, super.left, super.center, super.right);
        }
        super.paint(g);
    }

    public final void update() {
        if (uname.equals("") && unameChange.equals("")) {
            if (this.indexRow > -1 && this.indexRow < cmd[0].length) {
                super.center = cmd[0][this.indexRow];
            }
        } else if (this.indexRow > -1 && this.indexRow < cmd[1].length) {
            super.center = cmd[1][this.indexRow];
        }
        if (++GameScr.cmx > GameCanvas.w * 3 + 100) {
            GameScr.cmx = 100;
        }
        super.update();
    }

    public final void updateKey() {
        if (GameCanvas.keyPressedz[2] || GameCanvas.keyPressedz[4]) {
            this.indexRow--;
            if (this.indexRow < 0) {
                this.indexRow = menu.length - 1;
            }
        } else if (GameCanvas.keyPressedz[8] || GameCanvas.keyPressedz[6]) {
            this.indexRow++;
            if (this.indexRow > menu.length - 1) {
                this.indexRow = 0;
            }
        }
        if (GameCanvas.isPointerJustRelease && GameCanvas.isPointerHoldIn(this.popupX + 10, this.popupY + 45, this.popupW - 10, 170)) {
            if (GameCanvas.isPointerClick) {
                this.indexRow = (GameCanvas.py - (this.popupY + 45)) / 35;
            }
            if (uname.equals("") && unameChange.equals("")) {
                if (this.indexRow > -1 && this.indexRow < cmd[0].length) {
                    cmd[0][this.indexRow].performAction();
                }
            } else if (this.indexRow > -1 && this.indexRow < cmd[1].length) {
                cmd[1][this.indexRow].performAction();
            }
        }
        super.updateKey();
        GameCanvas.clearKeyPressed();
    }

    private void doViewFAQ() {
        if (!Session_ME.gI().connected) {
            GameCanvas.connect(5);
        }
        GameCanvas.startWaitDlg();
    }

    public static boolean isVirtualAcc() {
        return uname != null && (uname.startsWith("tmpusr") || uname.equals(""));
    }

    public static String randomNumberlist() {
        String text = "";
        for (int index = 0; index < 12; index++) {
            String text1 = Integer.toString(Res.random(0, 9));
            text = text + text1;
        }
        return text;
    }

    public final void perform(int idAction, Object p) {
        switch(idAction) {
            case 1000:
                if (isVirtualAcc() && !uname.equals("")) {
                    GameCanvas.startYesNoDlg(mResources.NEW_ACC_ARLET, new Command(mResources.COUNTINUE_PLAY, this, 10001, null), new Command(mResources.NO, GameCanvas.instance, 8882, null));
                    return;
                }
                this.doViewFAQ();
                Service.gI().login("-1", "12345", "2.5.1");
                return;
            case 1001:
                if (isVirtualAcc() && !uname.equals("") && unameChange.equals("")) {
                    GameCanvas.startYesNoDlg(mResources.NEW_ACC_ARLET, new Command(mResources.COUNTINUE, this, 10004, null), new Command(mResources.NO, GameCanvas.instance, 8882, null));
                    return;
                }
                GameCanvas.loginScr.switchToMe();
                return;
            case 1002:
                MyVector entries = new MyVector();
                if (GameMidlet.isWorldver) {
                    for (int index = GameMidlet.GetLastIndex() + 1; index <= GameMidlet.language.length - 1; index++) {
                        entries.addElement(new Command(GameMidlet.nameServer[index], this, index + 20000, null));
                    }
                } else {
                    for (int index1 = 0; index1 <= GameMidlet.GetLastIndex(); index1++) {
                        entries.addElement(new Command(GameMidlet.nameServer[index1], this, index1 + 20000, null));
                    }
                }
                GameCanvas.menu.startAt(entries);
                if (RMS.loadRMSInt("indServer") != -1) {
                    GameCanvas.menu.menuSelectedItem = GameMidlet.serverST[RMS.loadRMSInt("indServer")];
                }
                return;
            case 1003:
                this.doViewFAQ();
                if (!unameChange.equals("")) {
                    uname = unameChange;
                    pass = passChange;
                    unameChange = "";
                    passChange = "";
                    RMS.saveRMSString("acc", uname);
                    RMS.saveRMSString("pass", pass);
                }
                Service.gI().login(uname, pass, "2.5.1");
                return;
            case 10001:
                this.doViewFAQ();
                Service.gI().login("-1", "12345", "2.5.1");
                if (!unameChange.equals("")) {
                    uname = unameChange;
                    pass = passChange;
                    unameChange = "";
                    passChange = "";
                    RMS.saveRMSString("acc", uname);
                    RMS.saveRMSString("pass", pass);
                    return;
                }
                break;
            case 10004:
                GameCanvas.currentDialog = null;
                GameCanvas.loginScr.switchToMe();
                return;
            case 20000:
            case 20001:
            case 20002:
            case 20003:
            case 20004:
            case 20005:
            case 20006:
            case 20007:
            case 20008:
            case 20009:
            case 20010:
            case 20011:
            case 20012:
            case 20013:
            case 20014:
            case 20015:
            case 20016:
            case 20017:
            case 20018:
            case 20019:
                if (Session_ME.gI().isConnected()) {
                    Session_ME.gI().close();
                }
                int value = idAction - 20000;
                GameCanvas.menu.showMenu = false;
                GameMidlet.IP = GameMidlet.ipList[value];
                GameMidlet.PORT = GameMidlet.portList[value];
                GameMidlet.serverLogin = GameMidlet.serverLoginList[value];
                idAction = value;
                RMS.saveRMSInt("indServer", idAction);
                GameCanvas.menu.menuSelectedItem = GameMidlet.serverST[value];
                GameCanvas.connect(6);
                return;
            case 20100:
                GameCanvas.startWaitDlg();
                GameMidlet.getStrSv();
                GameCanvas.endDlg();
                break;
            case 100041:
                return;
        }
    }
}
