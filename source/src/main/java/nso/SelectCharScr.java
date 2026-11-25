package nso;

import main.GameCanvas;

public final class SelectCharScr extends mScreen implements IActionListener {

    private static SelectCharScr instance;

    private int w1char;

    private int h1char;

    private int padchar;

    private int x;

    private int y;

    public int indexSelect;

    public int[] parthead;

    public int[] partleg;

    public int[] partbody;

    public int[] partWp;

    public int[] level;

    public String[] name;

    public String[] phai;

    public byte[] gender;

    private Command cmdSelect;

    private int waitToPerform;

    public boolean isNullChar = true;

    private int moveUp = GameCanvas.h / 2 - 2;

    private int moveDow = GameCanvas.h / 2 + 2;

    public static SelectCharScr gI() {
        if (instance == null) {
            instance = new SelectCharScr();
        }
        return instance;
    }

    public SelectCharScr() {
        this.w1char = 48;
        this.h1char = 85;
        if (GameCanvas.w < 160) {
            this.w1char = 32;
        }
        this.padchar = 7;
        this.x = (GameCanvas.w - 3 * this.w1char >> 1) - 5;
        this.y = GameCanvas.hh - (this.h1char >> 1) + 10;
        if (GameCanvas.isTouch && GameCanvas.w > 200) {
            this.w1char = 74;
            this.padchar = 25;
            this.h1char = 110;
            this.x = (GameCanvas.w - 3 * this.w1char >> 1) - 20;
            this.y = GameCanvas.hh - (this.h1char >> 1);
            if (GameCanvas.w < 320) {
                this.padchar = 6;
                this.x = (GameCanvas.w - 3 * this.w1char >> 1) - 6;
            }
        }
        super.left = null;
        this.cmdSelect = new Command(mResources.SELECT, this, 1000, null);
        super.center = new Command("", this, 1000, null);
        super.right = new Command(mResources.EXIT, this, 1001, null);
        super.left = this.cmdSelect;
        if (GameCanvas.isTouch) {
            super.center = null;
            super.left = null;
        }
        if (GameCanvas.isTouch && GameCanvas.w >= 320) {
            super.right.x = GameCanvas.w / 2 + 88;
            super.right.y = GameCanvas.h - 26;
        }
    }

    private void doSelect() {
        if (this.name[this.indexSelect] != null) {
            Service.gI().selectCharToPlay(this.name[this.indexSelect]);
            GameCanvas.startWaitDlg(mResources.PLEASEWAIT);
            GameCanvas.isLoading = true;
        } else {
            CreateCharScr.gI().switchToMe();
        }
    }

    public final void updateKey() {
        super.updateKey();
        if (GameCanvas.keyPressedz[6]) {
            this.indexSelect++;
            if (this.indexSelect >= 3) {
                this.indexSelect = 0;
            }
        }
        if (GameCanvas.keyPressedz[4]) {
            this.indexSelect--;
            if (this.indexSelect < 0) {
                this.indexSelect = 2;
            }
        }
        if (GameCanvas.isPointerDown && GameCanvas.isPointerHoldIn(this.x, this.y, 3 * (this.w1char + this.padchar), this.h1char)) {
            int value;
            if ((value = (GameCanvas.px - this.x) / (this.w1char + this.padchar)) > 2) {
                value = 2;
            }
            if (value < 0) {
                value = 0;
            }
            this.indexSelect = value;
        }
        if (GameCanvas.isPointerJustRelease) {
            if (GameCanvas.isPointerHoldIn(this.x, this.y, 3 * (this.w1char + this.padchar), this.h1char)) {
                this.waitToPerform = 5;
            } else {
                this.indexSelect = -1;
            }
        }
        GameCanvas.clearKeyHold();
        GameCanvas.clearKeyPressed();
    }

    public final void update() {
        if (++GameScr.cmx > GameCanvas.w * 3 + 100) {
            GameScr.cmx = 100;
        }
        if (this.waitToPerform > 0) {
            this.waitToPerform--;
            if (this.waitToPerform == 0 && this.indexSelect >= 0) {
                this.doSelect();
            }
        }
    }

    public final void switchToMe() {
        TileMap.freeTileImage();
        System.gc();
        super.switchToMe();
        for (int index = 0; index < this.name.length; index++) {
            if (this.name[index] != null) {
                this.isNullChar = false;
                break;
            }
        }
        if (this.isNullChar) {
            CreateCharScr.gI().switchToMe();
        }
    }

    public final void paint(mGraphics g) {
        GameCanvas.paintBGGameScr(g);
        for (int index = 0; index < 3; index++) {
            if (this.indexSelect == index) {
                Paint.paintFrameInsideSelected(this.x + index * (this.w1char + this.padchar), this.y, this.w1char, this.h1char, g);
            } else {
                Paint.paintFrameInside(this.x + index * (this.w1char + this.padchar), this.y, this.w1char, this.h1char, g);
            }
            Paint.paintFrameBorder(this.x + index * (this.w1char + this.padchar), this.y, this.w1char, this.h1char, g);
        }
        for (int index1 = 0; index1 < 3; index1++) {
            if (this.name[index1] != null) {
                Part part = GameScr.parts[this.parthead[index1]];
                Part part2 = GameScr.parts[this.partleg[index1]];
                Part part3 = GameScr.parts[this.partbody[index1]];
                Part part4 = GameScr.parts[this.partWp[index1]];
                if (part.pi != null && part.pi.length >= 8) {
                    for (int index5 = 0; index5 < part.pi.length; index5++) {
                        if (part.pi[index5] == null || !SmallImage.isExitsImage(part.pi[index5].id)) {
                            Char.getMyChar();
                            part = Char.getDefaultHead(this.gender[index1]);
                            break;
                        }
                    }
                } else {
                    Char.getMyChar();
                    part = Char.getDefaultHead(this.gender[index1]);
                }
                int value = this.x + index1 * (this.w1char + this.padchar) + this.w1char / 2;
                int value6 = 0;
                if (!GameCanvas.isTouch) {
                    value6 = this.y + this.h1char / 2 + 16;
                    SmallImage.drawSmallImage(g, part4.pi[Char.CharInfo[0][3][0]].id, value + Char.CharInfo[0][3][1] + part4.pi[Char.CharInfo[0][3][0]].dx, value6 - Char.CharInfo[0][3][2] + part4.pi[Char.CharInfo[0][3][0]].dy, 0, 0);
                    SmallImage.drawSmallImage(g, part2.pi[Char.CharInfo[0][1][0]].id, value + Char.CharInfo[0][1][1] + part2.pi[Char.CharInfo[0][1][0]].dx, value6 - Char.CharInfo[0][1][2] + part2.pi[Char.CharInfo[0][1][0]].dy, 0, 0);
                    SmallImage.drawSmallImage(g, part3.pi[Char.CharInfo[0][2][0]].id, value + Char.CharInfo[0][2][1] + part3.pi[Char.CharInfo[0][2][0]].dx, value6 - Char.CharInfo[0][2][2] + part3.pi[Char.CharInfo[0][2][0]].dy, 0, 0);
                    SmallImage.drawSmallImage(g, part.pi[Char.CharInfo[0][0][0]].id, value + Char.CharInfo[0][0][1] + part.pi[Char.CharInfo[0][0][0]].dx, value6 - Char.CharInfo[0][0][2] + part.pi[Char.CharInfo[0][0][0]].dy, 0, 0);
                    if (this.indexSelect == index1) {
                        mFont.tahoma_8b.drawString(g, mResources.CHARINGFO[0] + ": " + this.name[index1], GameCanvas.hw, this.y - 45, 2);
                        mFont.tahoma_7b_white.drawString(g, mResources.CHARINGFO[1] + ": " + this.level[index1], GameCanvas.hw, this.y - 28, 2, mFont.tahoma_7b_blue);
                        mFont.tahoma_7b_white.drawString(g, this.phai[index1], GameCanvas.hw, this.y - 16, 2, mFont.tahoma_7b_blue);
                    }
                } else {
                    value6 = this.y + this.h1char / 2 - 5;
                    SmallImage.drawSmallImage(g, part4.pi[Char.CharInfo[0][3][0]].id, value + Char.CharInfo[0][3][1] + part4.pi[Char.CharInfo[0][3][0]].dx, value6 - Char.CharInfo[0][3][2] + part4.pi[Char.CharInfo[0][3][0]].dy, 0, 0);
                    SmallImage.drawSmallImage(g, part2.pi[Char.CharInfo[0][1][0]].id, value + Char.CharInfo[0][1][1] + part2.pi[Char.CharInfo[0][1][0]].dx, value6 - Char.CharInfo[0][1][2] + part2.pi[Char.CharInfo[0][1][0]].dy, 0, 0);
                    SmallImage.drawSmallImage(g, part3.pi[Char.CharInfo[0][2][0]].id, value + Char.CharInfo[0][2][1] + part3.pi[Char.CharInfo[0][2][0]].dx, value6 - Char.CharInfo[0][2][2] + part3.pi[Char.CharInfo[0][2][0]].dy, 0, 0);
                    SmallImage.drawSmallImage(g, part.pi[Char.CharInfo[0][0][0]].id, value + Char.CharInfo[0][0][1] + part.pi[Char.CharInfo[0][0][0]].dx, value6 - Char.CharInfo[0][0][2] + part.pi[Char.CharInfo[0][0][0]].dy, 0, 0);
                    mFont.tahoma_8b.drawString(g, this.name[index1], value, this.y + this.h1char / 2 + 5, 2);
                    mFont.tahoma_7b_white.drawString(g, mResources.CHARINGFO[1] + ": " + this.level[index1], value, this.y + this.h1char / 2 + 22, 2);
                    if (GameCanvas.w > 200) {
                        mFont.tahoma_7b_white.drawString(g, this.phai[index1], value, this.y + this.h1char / 2 + 34, 2);
                    }
                }
            }
        }
        super.paint(g);
    }

    public final void perform(int idAction, Object p) {
        switch(idAction) {
            case 1000:
                this.doSelect();
                return;
            case 1001:
                Session_ME.gI().close();
                GameCanvas.instance.resetToLoginScr();
        }
    }
}
