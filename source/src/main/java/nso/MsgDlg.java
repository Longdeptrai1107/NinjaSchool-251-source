package nso;

import main.GameCanvas;

public final class MsgDlg extends Dialog {

    private String[] info;

    public boolean isWait;

    public int timeShow;

    private int h;

    private int padLeft = 30;

    public MsgDlg() {
        if (GameCanvas.w <= 176) {
            this.padLeft = 10;
        }
    }

    public final void pleasewait() {
        this.setInfo(mResources.PLEASEWAIT, null, null, null);
        GameCanvas.currentDialog = this;
    }

    public final void setInfo(String info1, Command left, Command center, Command right) {
        this.info = mFont.tahoma_8b.splitFontArray(info1, GameCanvas.w - ((this.padLeft << 1) + 40));
        super.left = left;
        super.center = center;
        super.right = right;
        if (center != null) {
            super.center.x = GameCanvas.w / 2 - 35;
            super.center.y = GameCanvas.h - 26;
            if (left != null) {
                super.left.x = GameCanvas.w / 2 - 115;
                super.left.y = GameCanvas.h - 26;
            }
            if (right != null) {
                super.right.x = GameCanvas.w / 2 + 45;
                super.right.y = GameCanvas.h - 26;
            }
        } else {
            if (left != null) {
                super.left.x = GameCanvas.w / 2 - 80;
                super.left.y = GameCanvas.h - 26;
            }
            if (right != null) {
                super.right.x = GameCanvas.w / 2 + 10;
                super.right.y = GameCanvas.h - 26;
            }
        }
        this.isWait = false;
        this.h = 80;
        if (this.info.length >= 5) {
            this.h = this.info.length * mFont.tahoma_8b.getHeight() + 20;
        }
    }

    public final void paint(mGraphics g) {
        int value = GameCanvas.h - this.h - 38;
        Paint.paintFrame(this.padLeft, value, GameCanvas.w - (this.padLeft << 1), this.h, g);
        value = value + (this.h - this.info.length * mFont.tahoma_8b.getHeight()) / 2 - 2;
        if (this.isWait) {
            value += 8;
            GameCanvas.paintShukiren(GameCanvas.hw, value - 12, g, false);
        }
        int value1 = 0;
        for (int index = value; value1 < this.info.length; index += mFont.tahoma_8b.getHeight()) {
            mFont.tahoma_8b.drawString(g, this.info[value1], GameCanvas.hw, index, 2);
            value1++;
        }
        super.paint(g);
    }

    public final void update() {
        if (this.timeShow > 0) {
            this.timeShow--;
            if (this.timeShow == 1) {
                GameCanvas.endDlg();
                this.timeShow = 0;
            }
        }
        super.update();
    }
}
