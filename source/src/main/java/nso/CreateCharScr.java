package nso;

import main.GameCanvas;

public final class CreateCharScr extends mScreen implements IActionListener {

    private static CreateCharScr instance;

    private static TField tAddName;

    private static int indexGender;

    private static int indexHair;

    private static int selected;

    private static int[][] hairID = new int[][] { { 11, 26, 27, 28 }, { 2, 23, 24, 25 } };

    private static int[] defaultLeg = new int[] { 9, 0 };

    private static int[] defaultBody = new int[] { 10, 1 };

    private Command cmdGender;

    private Command cmdHair;

    private int curIndex = 0;

    public static CreateCharScr gI() {
        if (instance == null) {
            instance = new CreateCharScr();
        }
        return instance;
    }

    public CreateCharScr() {
        if (GameCanvas.w == 128) {
            GameScr.setPopupSize(128, 120);
            GameScr.popupX = (GameCanvas.w - 128) / 2;
            GameScr.popupY = 0;
        } else {
            GameScr.setPopupSize(170, 190);
            GameScr.popupX = (GameCanvas.w - 170) / 2;
            GameScr.popupY = (GameCanvas.h - 220) / 2;
        }
        indexGender = 1;
        (tAddName = new TField()).name = mResources.CHARNAME;
        tAddName.width = 100;
        tAddName.x = GameScr.popupX + 45;
        tAddName.x = GameScr.popupX + GameScr.popupW / 2 - tAddName.width / 2;
        tAddName.y = GameScr.popupY + 62;
        if (GameCanvas.w == 128) {
            tAddName.width = 60;
        }
        tAddName.height = 26;
        tAddName.isFocus = true;
        tAddName.setIputType(0);
        indexGender = 1;
        indexHair = 0;
        super.center = new Command(mResources.NEWCHAR, this, 8000, null);
        super.left = new Command(mResources.BACK, this, 8001, null);
        this.cmdGender = new Command("", this, 8002, null, GameScr.popupX + GameScr.popupW / 2 - mScreen.cmdW / 2, GameScr.popupY + 70 + 30);
        this.cmdHair = new Command("", this, 8003, null, GameScr.popupX + GameScr.popupW / 2 - mScreen.cmdW / 2, GameScr.popupY + 70 + 70);
        super.right = tAddName.cmdClear;
    }

    public final void switchToMe() {
        indexGender = GameCanvas.gameTick % 2;
        indexHair = GameCanvas.gameTick % 4;
        super.switchToMe();
    }

    public final void keyPress(int keyCode) {
        tAddName.keyPressed(keyCode);
    }

    public final void update() {
        if (++GameScr.cmx > GameCanvas.w * 3 + 100) {
            GameScr.cmx = 100;
        }
        if (GameCanvas.isTouch && GameCanvas.w >= 320) {
            if (super.left != null) {
                super.left.x = GameCanvas.w / 2 - 160;
                super.left.y = GameCanvas.h - 26;
            }
            if (super.center != null) {
                super.center.x = GameCanvas.w / 2 - 35;
                super.center.y = GameCanvas.h - 26;
            }
            if (super.right != null) {
                super.right.x = GameCanvas.w / 2 + 88;
                super.right.y = GameCanvas.h - 26;
            }
        }
        if (this.cmdHair != null) {
            this.cmdHair.updatePointer();
        }
        if (this.cmdGender != null) {
            this.cmdGender.updatePointer();
        }
    }

    public final void updateKey() {
        if (GameCanvas.keyPressedz[2] && --selected < 0) {
            selected = mResources.MENUNEWCHAR.length - 1;
        }
        if (GameCanvas.keyPressedz[8] && ++selected >= mResources.MENUNEWCHAR.length) {
            selected = 0;
        }
        if (selected == 0) {
            super.right = tAddName.cmdClear;
            tAddName.update();
        }
        if (selected == 1) {
            if (GameCanvas.keyPressedz[4] && --indexGender < 0) {
                indexGender = mResources.MENUGENDER.length - 1;
            }
            if (GameCanvas.keyPressedz[6] && ++indexGender > mResources.MENUGENDER.length - 1) {
                indexGender = 0;
            }
            super.right = null;
        }
        if (selected == 2) {
            if (GameCanvas.keyPressedz[4] && --indexHair < 0) {
                indexHair = mResources.HAIR_STYLE[0].length - 1;
            }
            if (GameCanvas.keyPressedz[6] && ++indexHair > mResources.HAIR_STYLE[0].length - 1) {
                indexHair = 0;
            }
        }
        if (GameCanvas.isPointerJustRelease && GameCanvas.isPointerHoldIn(GameScr.popupX + 5, GameScr.popupY + 65, GameScr.popupW - 5, mScreen.ITEM_HEIGHT)) {
            selected = 0;
        }
        super.updateKey();
        GameCanvas.clearKeyHold();
        GameCanvas.clearKeyPressed();
    }

    public final void paint(mGraphics g) {
        byte byteValue = 0;
        try {
            GameCanvas.paintBGGameScr(g);
            byteValue = 1;
            Paint.paintFrame(GameScr.popupX, GameScr.popupY, GameScr.popupW, GameScr.popupH, g);
            byte byteValue1 = 40;
            if (GameCanvas.w == 128) {
                byteValue1 = 20;
            }
            byteValue = 2;
            int value = hairID[indexGender][indexHair];
            int value2 = defaultLeg[indexGender];
            int value3 = defaultBody[indexGender];
            byteValue = 3;
            Part part = GameScr.parts[value];
            Part part4 = GameScr.parts[value2];
            Part part5 = GameScr.parts[value3];
            int value6 = GameCanvas.w / 2;
            int value7 = GameScr.popupY + 50;
            byteValue = 4;
            SmallImage.drawSmallImage(g, part4.pi[Char.CharInfo[0][1][0]].id, value6 + Char.CharInfo[0][1][1] + part4.pi[Char.CharInfo[0][1][0]].dx, value7 - Char.CharInfo[0][1][2] + part4.pi[Char.CharInfo[0][1][0]].dy, 0, 0);
            SmallImage.drawSmallImage(g, part5.pi[Char.CharInfo[0][2][0]].id, value6 + Char.CharInfo[0][2][1] + part5.pi[Char.CharInfo[0][2][0]].dx, value7 - Char.CharInfo[0][2][2] + part5.pi[Char.CharInfo[0][2][0]].dy, 0, 0);
            SmallImage.drawSmallImage(g, part.pi[Char.CharInfo[0][0][0]].id, value6 + Char.CharInfo[0][0][1] + part.pi[Char.CharInfo[0][0][0]].dx, value7 - Char.CharInfo[0][0][2] + part.pi[Char.CharInfo[0][0][0]].dy, 0, 0);
            byteValue = 5;
            if (!GameCanvas.isTouch) {
                for (int index = 0; index < mResources.MENUNEWCHAR.length; index++) {
                    if (selected == index) {
                        value2 = index > 0 ? -5 : 0;
                        SmallImage.drawSmallImage(g, 989, GameScr.popupX + 10 + (GameCanvas.gameTick % 7 > 3 ? 1 : 0), GameScr.popupY + 76 + index * byteValue1 + value2, 2, StaticObj.VCENTER_HCENTER);
                        SmallImage.drawSmallImage(g, 989, GameScr.popupX + GameScr.popupW - 15 - (GameCanvas.gameTick % 7 > 3 ? 1 : 0), GameScr.popupY + 76 + index * byteValue1 + value2, 0, StaticObj.VCENTER_HCENTER);
                    }
                }
            }
            byteValue = 7;
            if (GameCanvas.isTouch) {
                this.cmdGender.caption = mResources.MENUGENDER[indexGender];
                this.cmdGender.paint(g);
                this.cmdHair.caption = mResources.HAIR_STYLE[indexGender][indexHair];
                this.cmdHair.paint(g);
            } else {
                Paint.paintFrameBorder(this.cmdGender.x, this.cmdGender.y, this.cmdGender.w, this.cmdGender.h, g);
                if (selected == 1) {
                    g.setColor(Paint.COLORLIGHT);
                    g.fillRect(this.cmdGender.x, this.cmdGender.y, this.cmdGender.w, this.cmdGender.h);
                    Paint.paintFrameBorder(this.cmdGender.x, this.cmdGender.y, this.cmdGender.w, this.cmdGender.h, g);
                }
                Paint.paintFrameBorder(this.cmdHair.x, this.cmdHair.y, this.cmdHair.w, this.cmdHair.h, g);
                if (selected == 2) {
                    g.setColor(Paint.COLORLIGHT);
                    g.fillRect(this.cmdHair.x, this.cmdHair.y, this.cmdHair.w, this.cmdHair.h);
                    Paint.paintFrameBorder(this.cmdHair.x, this.cmdHair.y, this.cmdHair.w, this.cmdHair.h, g);
                }
                mFont.tahoma_7b_white.drawString(g, mResources.MENUGENDER[indexGender], GameScr.popupX + 85, GameScr.popupY + 66 + byteValue1 * 1, 2);
                mFont.tahoma_7b_white.drawString(g, mResources.HAIR_STYLE[indexGender][indexHair], GameScr.popupX + 85, GameScr.popupY + 66 + byteValue1 * 2, 2);
            }
            tAddName.x = GameScr.popupX + GameScr.popupW / 2 - tAddName.width / 2;
            tAddName.y = GameScr.popupY + 62;
            tAddName.title_Null = mResources.CHARNAME;
            tAddName.paint(g);
            super.paint(g);
            g.setColor(0);
        } catch (Exception exception) {
            System.out.println("CreateCharScr.paint(): " + byteValue);
            exception.printStackTrace();
        }
    }

    public final void perform(int idAction, Object p) {
        switch(idAction) {
            case 8000:
                Service.gI().createChar(tAddName.getText(), indexGender, hairID[indexGender][indexHair]);
                return;
            case 8001:
                if (SelectCharScr.gI().isNullChar) {
                    GameCanvas.selectsvScr.switchToMe();
                    return;
                }
                SelectCharScr.gI().switchToMe();
                return;
            case 8002:
                this.curIndex = 1;
                selected = 1;
                if (this.curIndex == selected && --indexGender < 0) {
                    indexGender = mResources.MENUGENDER.length - 1;
                    return;
                }
                break;
            case 8003:
                this.curIndex = 2;
                selected = 2;
                if (this.curIndex == selected && ++indexHair > mResources.HAIR_STYLE[0].length - 1) {
                    indexHair = 0;
                }
        }
    }
}
