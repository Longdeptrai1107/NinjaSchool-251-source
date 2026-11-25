package nso;

import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Image;
import main.GameCanvas;
import main.GameMidlet;
import main.MotherCanvas;

public final class LoginScr extends mScreen implements IActionListener {

    private TField tfUser;

    private TField tfPass;

    private TField tfRegPass;

    private TField tfEmail;

    private static LoginScr gI;

    private int focus;

    private int wC;

    private int yL;

    private int defYL;

    private boolean isCheck = false;

    private boolean isRes = false;

    private Command cmdLogin;

    private Command cmdCheck;

    private Command cmdRes;

    private Command cmdFogetPass;

    public static Image imgTitle = GameCanvas.loadImage("/tt.png");

    private int yt;

    private String[] currentTip;

    private int tipid = -1;

    private int v = 2;

    private int logoVelocity = 0;

    private int ylogo = -40;

    private int logoDirection = 1;

    public static boolean isLoggingIn;

    private String recoveryAccount = "";

    public final void switchToMe() {
        if (RMS.loadRMSString("random") == null) {
            RMS.saveRMSString("random", SelectServerScr.randomNumberlist());
        }
        this.yL = -50;
        this.isRes = false;
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
        if (GameCanvas.menu != null) {
            GameCanvas.menu = new Menu();
        }
        GameCanvas.isGPRS = false;
        super.left = this.cmdFogetPass = new Command(mResources.FORGETPASS, this, 2005, null);
        GameScr.VecTime.removeAllElements();
    }

    public final void switchToMe(boolean isRes1) {
        this.isRes = true;
        this.yL = -50;
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
        if (GameCanvas.menu != null) {
            GameCanvas.menu = new Menu();
        }
        GameCanvas.isGPRS = false;
        super.left = this.cmdFogetPass = new Command("Hủy", this, 20051, null);
    }

    public LoginScr() {
        gI = this;
        this.isRes = false;
        if ((TileMap.bgID = (byte) (System.currentTimeMillis() % 9L)) == 5 || TileMap.bgID == 6) {
            TileMap.bgID = 4;
        }
        GameScr.loadCamera(true);
        GameScr.cmx = 100;
        if (GameCanvas.h > 200) {
            this.defYL = GameCanvas.hh - 80;
        } else {
            this.defYL = GameCanvas.hh - 65;
        }
        this.yL = -50;
        this.wC = GameCanvas.w - 30;
        if (this.wC < 135) {
            this.wC = 135;
        }
        if (this.wC > 155) {
            this.wC = 155;
        }
        this.yt = GameCanvas.hh - mScreen.ITEM_HEIGHT - 5;
        if (GameCanvas.h <= 160) {
            this.yt = 20;
        }
        this.tfUser = new TField();
        this.tfUser.name = mResources.USERNAME;
        this.tfUser.x = GameCanvas.hw - 20 - 57;
        this.tfUser.y = this.yt;
        this.tfUser.width = this.wC;
        this.tfUser.height = mScreen.ITEM_HEIGHT + 2;
        this.tfUser.isFocus = true;
        this.tfUser.setIputType(3);
        TField.midlet = GameMidlet.instance;
        TField.returnCanvas = MotherCanvas.instance;
        this.tfPass = new TField();
        this.tfPass.name = mResources.PASSWORD;
        this.tfPass.x = GameCanvas.hw - 20 - 57;
        this.tfPass.y = this.yt += 35;
        this.tfPass.width = this.wC;
        this.tfPass.height = mScreen.ITEM_HEIGHT + 2;
        this.tfPass.isFocus = false;
        this.tfPass.setIputType(2);
        this.tfRegPass = new TField();
        this.tfRegPass.name = mResources.REPASSWORD;
        this.tfRegPass.x = GameCanvas.hw - 20 - 57;
        this.tfRegPass.y = this.yt += 35;
        this.tfRegPass.width = this.wC;
        this.tfRegPass.height = mScreen.ITEM_HEIGHT + 2;
        this.tfRegPass.isFocus = false;
        this.tfRegPass.setIputType(2);
        this.tfEmail = new TField();
        this.tfEmail.name = "Email/Số di động";
        this.tfEmail.x = GameCanvas.hw - 20 - 57;
        this.tfEmail.y = this.yt += 35;
        this.tfEmail.width = this.wC;
        this.tfEmail.height = mScreen.ITEM_HEIGHT + 2;
        this.tfEmail.isFocus = false;
        this.tfEmail.setIputType(3);
        this.isCheck = true;
        if (SelectServerScr.uname != null) {
            if (SelectServerScr.uname.startsWith("tmpusr")) {
                this.tfUser.setText("");
                this.tfPass.setText("");
            } else {
                this.tfUser.setText(SelectServerScr.uname);
                this.tfPass.setText(SelectServerScr.pass);
            }
        }
        this.focus = 0;
        this.cmdLogin = new Command(mResources.OK, this, 2000, null);
        this.cmdCheck = new Command(mResources.REMEMBER, this, 2001, null);
        this.cmdRes = new Command(mResources.REGISTER, this, 2002, null);
        new Command(mResources.FORGETPASS, this, 2004, null);
        if (!this.isRes) {
            super.left = this.cmdFogetPass = new Command(mResources.FORGETPASS, this, 2005, null);
        } else {
            super.left = this.cmdFogetPass = new Command(mResources.CANCEL, this, 20051, null);
        }
        if (GameCanvas.isTouch && GameCanvas.w >= 320) {
            super.center = null;
            super.right = this.cmdLogin;
        } else {
            super.center = this.cmdLogin;
            super.right = this.tfUser.cmdClear;
        }
    }

    public static LoginScr mgI() {
        return gI;
    }

    private static void doSetGPRS(boolean isGPRS) {
        GameCanvas.isGPRS = isGPRS;
        RMS.saveRMSInt("isGPRS", isGPRS ? 1 : 2);
    }

    private void doRegister(String user) {
        GameMidlet.IP = GameMidlet.ipList[GameMidlet.GetWorldIndex()];
        GameCanvas.startWaitDlg(mResources.CONNECTING);
        GameCanvas.connect(3);
        GameCanvas.startWaitDlg(mResources.REGISTERING);
        Service.gI().setClientType();
        Service.gI().requestRegisterNew(user, this.tfPass.getText(), this.tfEmail.getText());
    }

    public final void update() {
        if (++GameScr.cmx > GameCanvas.w * 3 + 100) {
            GameScr.cmx = 100;
        }
        this.tfUser.update();
        this.tfPass.update();
        if (this.isRes) {
            this.tfRegPass.update();
            this.tfEmail.update();
        }
        LoginScr loginScr = this;
        if (this.defYL != loginScr.yL) {
            loginScr.yL = loginScr.yL + (loginScr.defYL - loginScr.yL >> 1);
        }
        if (GameCanvas.isTouch) {
            super.center = null;
            if (this.isRes) {
                super.right = this.cmdRes;
            } else {
                super.right = this.cmdLogin;
            }
        } else if (this.isRes) {
            super.center = this.cmdRes;
        } else if (this.focus == 2) {
            super.center = this.cmdCheck;
            if (this.isCheck) {
                super.center.caption = mResources.UNCHECK;
            } else {
                super.center.caption = mResources.REMEMBER;
            }
        } else {
            super.center = this.cmdLogin;
        }
        if (this.logoVelocity >= 0) {
            this.ylogo = this.ylogo + this.logoDirection * this.logoVelocity;
            this.logoVelocity = this.logoVelocity + this.logoDirection * this.v;
            if (this.logoVelocity <= 0) {
                this.logoDirection = -this.logoDirection;
            }
            if (this.ylogo > 0) {
                this.logoDirection = -this.logoDirection;
                this.logoVelocity = this.logoVelocity - 2 * this.v;
            }
        }
        if (this.tipid >= 0 && GameCanvas.gameTick % 100 == 0) {
            this.tipid++;
            if (this.tipid >= mResources.tips.length) {
                this.tipid = 0;
            }
            this.currentTip = mFont.tahoma_7_white.splitFontArray(mResources.tips[this.tipid], GameCanvas.w - 40);
        }
    }

    public final void keyPress(int keyCode) {
        if (this.tfUser.isFocus) {
            this.tfUser.keyPressed(keyCode);
        } else if (this.tfPass.isFocus) {
            this.tfPass.keyPressed(keyCode);
        } else if (this.isRes && this.tfRegPass.isFocus) {
            this.tfRegPass.keyPressed(keyCode);
        } else if (this.isRes && this.tfEmail.isFocus) {
            this.tfEmail.keyPressed(keyCode);
        }
        super.keyPress(keyCode);
    }

    public final void unLoad() {
        super.unLoad();
    }

    public final void paint(mGraphics g) {
        g.setColor(0);
        g.fillRect(0, 0, GameCanvas.w, GameCanvas.h);
        GameCanvas.paintBGGameScr(g);
        int value = this.tfUser.y - 45;
        if (GameCanvas.h <= 220) {
            value += 5;
        }
        if (GameCanvas.currentDialog == null) {
            if (this.isRes) {
                Paint.paintFrame(GameCanvas.hw - 85, this.tfUser.y - 15, 170, 150, g);
            } else {
                Paint.paintFrame(GameCanvas.hw - 85, this.tfUser.y - 15, 170, 90, g);
            }
            if (GameCanvas.h > 160 && imgTitle != null) {
                g.drawImage(imgTitle, GameCanvas.hw, value - 2, 3);
            }
            this.tfUser.paint(g);
            this.tfPass.paint(g);
            if (this.isRes) {
                this.tfRegPass.paint(g);
                this.tfEmail.paint(g);
            }
            g.setClip(0, 0, GameCanvas.w, GameCanvas.h);
            boolean flag = false;
            if (GameCanvas.w > 200) {
                if (this.tfUser.getText().equals("")) {
                    if (!this.tfUser.isFocus) {
                        mFont.tahoma_7b_white.drawString(g, mResources.USERNAME, this.tfUser.x + 5, this.tfUser.y + 7, 0);
                    } else {
                        mFont.tahoma_7_grey.drawString(g, mResources.USERNAME, this.tfUser.x + 5, this.tfUser.y + 7, 0);
                    }
                }
                if (this.tfPass.getText().equals("")) {
                    if (!this.tfPass.isFocus) {
                        mFont.tahoma_7b_white.drawString(g, mResources.PASSWORD, this.tfPass.x + 5, this.tfPass.y + 7, 0);
                    } else {
                        mFont.tahoma_7_grey.drawString(g, mResources.PASSWORD, this.tfPass.x + 5, this.tfPass.y + 7, 0);
                    }
                }
                if (this.isRes) {
                    if (this.tfRegPass.getText().equals("")) {
                        if (!this.tfRegPass.isFocus) {
                            mFont.tahoma_7b_white.drawString(g, mResources.REPASS, this.tfRegPass.x + 5, this.tfRegPass.y + 7, 0);
                            mFont.tahoma_7b_white.drawString(g, mResources.PASSWORD, this.tfRegPass.x + 50, this.tfRegPass.y + 7, 0);
                        } else {
                            mFont.tahoma_7_grey.drawString(g, mResources.REPASS, this.tfRegPass.x + 5, this.tfRegPass.y + 7, 0);
                            mFont.tahoma_7_grey.drawString(g, mResources.PASSWORD, this.tfRegPass.x + 50, this.tfRegPass.y + 7, 0);
                        }
                    }
                    if (this.tfEmail.getText().equals("")) {
                        if (!this.tfEmail.isFocus) {
                            mFont.tahoma_7b_white.drawString(g, "Email/số di động", this.tfEmail.x + 5, this.tfEmail.y + 5, 0);
                        } else {
                            mFont.tahoma_7_grey.drawString(g, "Email/số di động", this.tfEmail.x + 5, this.tfEmail.y + 5, 0);
                        }
                    }
                }
            } else {
                if (this.tfUser.getText().equals("")) {
                    mFont.tahoma_7b_white.drawString(g, mResources.USER, this.tfUser.x - 35, this.tfUser.y + 7, 0);
                }
                if (this.tfPass.getText().equals("")) {
                    mFont.tahoma_7b_white.drawString(g, mResources.PASS, this.tfPass.x - 35, this.tfPass.y + 7, 0);
                }
                if (this.isRes) {
                    mFont.tahoma_7b_white.drawString(g, mResources.RE, this.tfRegPass.x - 35, this.tfRegPass.y - 1, 0);
                    mFont.tahoma_7b_white.drawString(g, mResources.PASS, this.tfRegPass.x - 35, this.tfRegPass.y + 13, 0);
                    mFont.tahoma_7b_white.drawString(g, "Email/số di động", this.tfEmail.x - 35, this.tfEmail.y + 5, 0);
                }
            }
        } else if (this.currentTip != null) {
            for (int index = 0; index < this.currentTip.length; index++) {
                mFont.tahoma_7_white.drawString(g, this.currentTip[index], GameCanvas.w / 2, this.tfUser.y - 15 + index * 10, 2, mFont.tahoma_7_grey);
            }
        }
        String text = "2.5.1";
        mFont.tahoma_7_grey.drawString(g, text, GameCanvas.w - 5, 5, 1);
        super.paint(g);
    }

    public final void updateKey() {
        if (GameCanvas.keyPressedz[2]) {
            this.focus--;
            if (this.focus < 0) {
                this.focus = 3;
            }
        } else if (GameCanvas.keyPressedz[8]) {
            this.focus++;
            if (this.focus > 3) {
                this.focus = 0;
            }
        }
        if (GameCanvas.keyPressedz[2] || GameCanvas.keyPressedz[8]) {
            GameCanvas.clearKeyPressed();
            if (this.focus == 1) {
                this.tfUser.isFocus = false;
                this.tfPass.isFocus = true;
                this.tfRegPass.isFocus = false;
                this.tfEmail.isFocus = false;
                super.right = this.tfPass.cmdClear;
            } else if (this.focus == 0) {
                this.tfUser.isFocus = true;
                this.tfPass.isFocus = false;
                this.tfRegPass.isFocus = false;
                this.tfEmail.isFocus = false;
                super.right = this.tfUser.cmdClear;
            } else {
                this.tfUser.isFocus = false;
                this.tfPass.isFocus = false;
                if (this.isRes) {
                    if (this.focus == 2) {
                        this.tfRegPass.isFocus = true;
                        this.tfEmail.isFocus = false;
                        super.right = this.tfRegPass.cmdClear;
                    } else if (this.focus == 3) {
                        this.tfEmail.isFocus = true;
                        this.tfRegPass.isFocus = false;
                        super.right = this.tfEmail.cmdClear;
                    }
                }
            }
        }
        if (GameCanvas.isPointerJustRelease) {
            if (GameCanvas.isPointerHoldIn(this.tfUser.x, this.tfUser.y, this.tfUser.width, this.tfUser.height)) {
                this.focus = 0;
            } else if (GameCanvas.isPointerHoldIn(this.tfPass.x, this.tfPass.y, this.tfPass.width, this.tfPass.height)) {
                this.focus = 1;
            } else {
                if (this.isRes) {
                    if (GameCanvas.isPointerHoldIn(this.tfRegPass.x, this.tfRegPass.y, this.tfRegPass.width, this.tfRegPass.height)) {
                        this.focus = 2;
                    } else if (GameCanvas.isPointerHoldIn(this.tfEmail.x, this.tfEmail.y, this.tfEmail.width, this.tfEmail.height)) {
                        this.focus = 3;
                    }
                } else if (GameCanvas.isPointerHoldIn(this.tfUser.x - 20, GameCanvas.hh + 40, 80, 20)) {
                    this.isCheck = !this.isCheck;
                }
                this.focus = 2;
            }
        }
        super.updateKey();
        GameCanvas.clearKeyPressed();
    }

    public final void perform(int idAction, Object p) {
        switch(idAction) {
            case 1002:
                LoginScr loginScr;
                (loginScr = this).isRes = true;
                loginScr.tfRegPass.isFocus = false;
                loginScr.tfEmail.isFocus = false;
                loginScr.tfPass.isFocus = false;
                loginScr.tfUser.isFocus = true;
                loginScr.right = loginScr.tfUser.cmdClear;
                loginScr.left = new Command(mResources.CANCEL, loginScr, 10021, null);
                return;
            case 1003:
                try {
                    GameMidlet.instance.platformRequest("http://ninjaschool.vn");
                    return;
                } catch (ConnectionNotFoundException connectionNotFoundException) {
                    connectionNotFoundException.printStackTrace();
                    return;
                }
            case 1004:
                MyVector entries = new MyVector();
                int value = RMS.loadRMSInt("lowGraphic");
                if (!GameCanvas.isTouch) {
                    if (value == 1) {
                        entries.addElement(new Command(mResources.HIGH_GRAPHIC, this, 10041, null));
                    } else {
                        entries.addElement(new Command(mResources.LOW_GRAPHIC, this, 10042, null));
                    }
                }
                entries.addElement(new Command(mResources.LANGUAGE, this, 1006, null));
                if (GameCanvas.currentScreen == this) {
                    entries.addElement(new Command(mResources.RMS, this, 1009, null));
                }
                GameCanvas.menu.startAt(entries);
                return;
            case 1005:
                GameCanvas.startYesNoDlg(mResources.ASK_NETWORK, new Command("3G/Wifi", this, 3000, null), new Command("GPRS", this, 3001, null));
                return;
            case 1006:
                GameCanvas.startYesNoDlg(mResources.SELECT_LANGUAGE, new Command(mResources.ACCEPT, this, 10061, null), new Command(mResources.NO, GameCanvas.gI(), 8882, null));
                return;
            case 1009:
                RMS.clearRMS();
                return;
            case 2000:
                if (!this.tfUser.getText().equals("") && !this.tfPass.getText().equals("")) {
                    SelectServerScr.unameChange = this.tfUser.getText();
                    SelectServerScr.passChange = this.tfPass.getText();
                }
                GameCanvas.selectsvScr.switchToMe();
                return;
            case 2001:
                if (this.isCheck) {
                    this.isCheck = false;
                    return;
                }
                this.isCheck = true;
                return;
            case 2002:
                if (this.tfUser.getText().equals("")) {
                    GameCanvas.startOKDlg(mResources.NOT_INPUT_USERNAME);
                } else {
                    char[] values = this.tfUser.getText().toCharArray();
                    for (int index = 0; index < values.length; index++) {
                        if (!TField.setNormal(values[index])) {
                            GameCanvas.startOKDlg(mResources.NOT_SPEC_CHARACTER);
                            return;
                        }
                    }
                    if (this.tfPass.getText().equals("")) {
                        GameCanvas.startOKDlg(mResources.NOT_INPUT_PASS1);
                    } else if (this.tfRegPass.getText().equals("")) {
                        GameCanvas.startOKDlg(mResources.NOT_INPUT_PASS2);
                    } else {
                        this.tfRegPass.getText().equals("");
                        if (this.tfUser.getText().length() < 5) {
                            GameCanvas.startOKDlg(mResources.USERNAME_LENGHT);
                        } else if (!this.tfPass.getText().equals(this.tfRegPass.getText())) {
                            GameCanvas.startOKDlg(mResources.WRONG_PASSWORD);
                        } else {
                            if (!this.tfEmail.getText().equals("")) {
                                GameCanvas.msgdlg.setInfo(mResources.REGISTER_TEXT[0] + " " + this.tfUser.getText() + ", " + mResources.REGISTER_TEXT[1], new Command(mResources.ACCEPT, this, 4000, null), null, new Command(mResources.NO, GameCanvas.instance, 8882, null));
                                GameCanvas.currentDialog = GameCanvas.msgdlg;
                                return;
                            }
                            GameCanvas.startYesNoDlg("Bạn chưa nhập Email/số di động, Email/số di động giúp bạn lấy lại mật khẩu khi mất mật khẩu", new Command(mResources.CONTINUE, this, 4001, null), new Command(mResources.NO, GameCanvas.instance, 8882, null));
                        }
                    }
                }
                break;
            case 2003:
                GameMidlet.openUrlAndExit("http://dd.ninjaschool.vn/app/index.php?for=event&do=resetpass");
                return;
            case 2004:
                GameCanvas.inputDlg.show(mResources.INPUT_NICK, new Command(mResources.OK, this, 20041, null), 0);
                return;
            case 2005:
                GameCanvas.startYesNoDlg("Bạn có muốn reset mật khẩu không?", new Command(mResources.OK, this, 20052, null), new Command(mResources.NO, GameCanvas.instance, 8882, null));
                return;
            case 3000:
                doSetGPRS(false);
                GameCanvas.endDlg();
                return;
            case 3001:
                doSetGPRS(true);
                GameCanvas.endDlg();
                return;
            case 4000:
                this.doRegister(this.tfUser.getText());
                return;
            case 4001:
                this.doRegister(this.tfUser.getText());
                break;
            case 10021:
                LoginScr loginScr1;
                (loginScr1 = this).isRes = false;
                loginScr1.tfRegPass.isFocus = false;
                loginScr1.tfPass.isFocus = false;
                loginScr1.tfUser.isFocus = true;
                loginScr1.right = loginScr1.tfUser.cmdClear;
                loginScr1.left = loginScr1.cmdFogetPass;
                return;
            case 10041:
                RMS.saveRMSInt("lowGraphic", 0);
                GameCanvas.startOK(mResources.RESTART, 8885, null);
                return;
            case 10042:
                RMS.saveRMSInt("lowGraphic", 1);
                GameCanvas.startOK(mResources.RESTART, 8885, null);
                return;
            case 10061:
                GameCanvas.endDlg();
                LanguageScr.saveLanguageID(-1);
                GameMidlet.instance.notifyDestroyed();
                return;
            case 20041:
                this.recoveryAccount = GameCanvas.inputDlg.tfInput.getText().toString();
                GameCanvas.endDlg();
                if (this.recoveryAccount.equals("")) {
                    GameCanvas.startOKDlg(mResources.NOT_INPUT_USERNAME);
                    return;
                }
                GameCanvas.startYesNoDlg(mResources.ASK_REG_NUM, new Command(mResources.YES, this, 200421, null), new Command(mResources.NO, this, 200422, null));
                return;
            case 20051:
                GameScr.gI().switchToMe();
                return;
            case 20052:
                GameMidlet.openUrlAndExit("http://dd.ninjaschool.vn/app/index.php?for=event&do=resetpass");
                return;
            case 200421:
                GameCanvas.endDlg();
                String text = this.recoveryAccount;
                GameMidlet.IP = GameMidlet.ipList[GameMidlet.GetWorldIndex()];
                GameCanvas.startWaitDlg(mResources.CONNECTING);
                GameCanvas.connect(1);
                GameCanvas.startWaitDlg(mResources.PLEASEWAIT);
                Service.gI().requestForgetPass(text);
                return;
            case 200422:
                GameCanvas.startOKDlg(mResources.replace(mResources.GETPASS_BY_NUMPHONE, this.recoveryAccount));
                return;
        }
    }
}
