package nso;

import main.GameCanvas;

public final class Input2Dlg extends Dialog implements IActionListener {

    private String[] info;

    public TField tfInput;

    public TField tfInput2;

    private int padLeft;

    private int focus;

    private int line;

    private int titleLenght;

    public Input2Dlg() {
        new Command("", 1000, null);
        this.tfInput = new TField();
        this.tfInput2 = new TField();
    }

    public final void setTitle(String title, String title2) {
        this.titleLenght = mFont.tahoma_8b.getWidth(title) > mFont.tahoma_8b.getWidth(title2) ? mFont.tahoma_8b.getWidth(title) : mFont.tahoma_8b.getWidth(title2);
        this.padLeft = 40;
        this.focus = 0;
        if (GameCanvas.w <= 176) {
            this.padLeft = 10;
        }
        this.tfInput.x = this.padLeft + this.titleLenght + 10;
        this.tfInput.y = GameCanvas.h - 2 * mScreen.ITEM_HEIGHT - 50;
        this.tfInput.width = GameCanvas.w - 2 * this.padLeft - this.titleLenght - 20;
        this.tfInput.height = mScreen.ITEM_HEIGHT + 2;
        this.tfInput.isFocus = true;
        this.tfInput.title = title;
        this.tfInput2.x = this.padLeft + this.titleLenght + 10;
        this.tfInput2.y = GameCanvas.h - mScreen.ITEM_HEIGHT - 43;
        this.tfInput2.width = GameCanvas.w - 2 * this.padLeft - this.titleLenght - 20;
        this.tfInput2.height = mScreen.ITEM_HEIGHT + 2;
        this.tfInput2.title = title2;
        super.right = this.tfInput.cmdClear;
    }

    public final void show(String info1, Command left, Command ok, int type1, int type2) {
        this.tfInput.setText("");
        this.tfInput.setIputType(type1);
        this.tfInput2.setText("");
        this.tfInput2.setIputType(type2);
        this.info = mFont.tahoma_8b.splitFontArray(info1, GameCanvas.w - this.padLeft * 3);
        MyVector entries = mFont.tahoma_8b.splitFontVector(info1, GameCanvas.w - this.padLeft * 3);
        this.line = entries.size();
        super.left = left;
        super.center = ok;
        GameCanvas.currentDialog = this;
    }

    public final void paint(mGraphics g) {
        GameCanvas.paintz.paintInputDlg(g, this.padLeft, GameCanvas.h - 85 - mScreen.cmdH - this.line * 13, GameCanvas.w - (this.padLeft << 1), 80 + this.line * 13, this.info, null);
        mFont.tahoma_8b.drawString(g, this.tfInput.title + ": ", this.tfInput.x - this.titleLenght - 5, this.tfInput.y + 5, 0);
        this.tfInput.paint(g);
        g.setClip(0, 0, GameCanvas.w, GameCanvas.h);
        mFont.tahoma_8b.drawString(g, this.tfInput2.title + ": ", this.tfInput2.x - this.titleLenght - 5, this.tfInput2.y + 5, 0);
        this.tfInput2.paint(g);
        super.paint(g);
    }

    public final void keyPress(int keyCode) {
        if (this.focus == 0) {
            this.tfInput.keyPressed(keyCode);
        } else {
            this.tfInput2.keyPressed(keyCode);
        }
        super.keyPress(keyCode);
    }

    public final void update() {
        if (GameCanvas.keyPressedz[2]) {
            this.focus = 0;
        }
        if (GameCanvas.keyPressedz[8]) {
            this.focus = 1;
        }
        if (this.focus == 0) {
            this.tfInput.isFocus = true;
            this.tfInput2.isFocus = false;
            super.right = this.tfInput.cmdClear;
            this.tfInput.update();
        } else {
            this.tfInput.isFocus = false;
            this.tfInput2.isFocus = true;
            super.right = this.tfInput2.cmdClear;
            this.tfInput2.update();
        }
        if (GameCanvas.isTouch && GameCanvas.isPointerJustRelease && GameCanvas.isPointerClick) {
            if (GameCanvas.isPointerHoldIn(this.tfInput.x, this.tfInput.y, this.tfInput.width, this.tfInput.height)) {
                this.focus = 0;
            }
            if (GameCanvas.isPointerHoldIn(this.tfInput2.x, this.tfInput2.y, this.tfInput2.width, this.tfInput2.height)) {
                this.focus = 1;
            }
        }
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
        super.update();
    }

    public final void perform(int idAction, Object p) {
    }
}
