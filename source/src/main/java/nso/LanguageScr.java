package nso;

import main.GameCanvas;
import main.GameMidlet;

public final class LanguageScr extends mScreen implements IActionListener {

    private int popupW;

    private int popupH;

    private int popupX;

    private int popupY;

    private int indexRow = -1;

    public LanguageScr() {
    }

    public final void switchToMe() {
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
        super.center = new Command(GameCanvas.isTouch ? "" : mResources.OK, this, 1000, null);
        super.right = new Command(mResources.EXIT, GameCanvas.instance, 8885, null);
        this.indexRow = -1;
        if (!GameCanvas.isTouch) {
            this.indexRow = 0;
        }
        if (GameCanvas.isTouch && GameCanvas.w >= 320) {
            super.center.x = GameCanvas.w / 2 - 35;
            super.right.x = GameCanvas.w / 2 + 88;
            super.center.y = super.right.y = GameCanvas.h - 26;
        }
    }

    public final void paint(mGraphics g) {
        g.setColor(0);
        g.fillRect(0, 0, GameCanvas.w, GameCanvas.h);
        GameCanvas.paintBGGameScr(g);
        Paint.paintFrame(this.popupX, this.popupY, this.popupW, this.popupH, g);
        g.setColor(Paint.COLORDARK);
        g.fillRoundRect(GameCanvas.hw - mFont.tahoma_8b.getWidth(mResources.LANGUAGE) / 2 - 12, this.popupY + 7, mFont.tahoma_8b.getWidth(mResources.LANGUAGE) + 22, 24, 6, 6);
        g.setColor(Paint.COLORLIGHT);
        g.drawRoundRect(GameCanvas.hw - mFont.tahoma_8b.getWidth(mResources.LANGUAGE) / 2 - 12, this.popupY + 7, mFont.tahoma_8b.getWidth(mResources.LANGUAGE) + 22, 24, 6, 6);
        mFont.tahoma_8b.drawString(g, mResources.LANGUAGE, GameCanvas.hw, this.popupY + 12, 2);
        String[] textLines = mResources.LANGUAGES;
        int value = this.popupY + 50;
        for (int index = 0; index < textLines.length; index++) {
            g.setColor(Paint.COLORDARK);
            g.fillRect(this.popupX + 10, value + index * 35, this.popupW - 20, 28);
            g.setColor(5720393);
            g.drawRect(this.popupX + 10, value + index * 35, this.popupW - 20, 28);
            if (index == this.indexRow) {
                g.setColor(Paint.COLORLIGHT);
                g.fillRect(this.popupX + 10, value + index * 35, this.popupW - 20, 28);
                g.setColor(11053224);
                g.drawRect(this.popupX + 10, value + index * 35, this.popupW - 20, 28);
            }
            mFont.tahoma_7b_white.drawString(g, textLines[index], this.popupX + this.popupW / 2, value + index * 35 + 8, 2);
        }
        super.paint(g);
        Paint.paintCmdBar(g, super.left, super.center, super.right);
    }

    public static void saveLanguageID(int languageID) {
        RMS.saveRMSInt("indLanguage", languageID);
    }

    public static int loadLanguageID() {
        boolean flag = false;
        return RMS.loadRMSInt("indLanguage");
    }

    public final void update() {
        if (++GameScr.cmx > GameCanvas.w * 3 + 100) {
            GameScr.cmx = 100;
        }
        super.update();
    }

    public final void updateKey() {
        if (GameCanvas.keyPressedz[2] || GameCanvas.keyPressedz[4] || GameCanvas.keyPressedz[6] || GameCanvas.keyPressedz[8]) {
            this.indexRow = this.indexRow == 0 ? 1 : 0;
        }
        if (GameCanvas.isPointerJustRelease && GameCanvas.isPointerHoldIn(this.popupX + 10, this.popupY + 45, this.popupW - 10, 70)) {
            if (GameCanvas.isPointerClick) {
                this.indexRow = (GameCanvas.py - (this.popupY + 45)) / 35;
            }
            this.perform(1000, null);
        }
        super.updateKey();
        GameCanvas.clearKeyPressed();
    }

    public final void perform(int idAction, Object p) {
        switch(idAction) {
            case 1000:
                GameCanvas.currentDialog = null;
                RMS.clearRMS();
                GameCanvas.initGameCanvas();
                GameMidlet.isWorldver = this.indexRow != 0;
                SelectServerScr.loadInfoIp(GameMidlet.GetWorldIndex());
                GameCanvas.selectsvScr.switchToMe();
        }
    }
}
