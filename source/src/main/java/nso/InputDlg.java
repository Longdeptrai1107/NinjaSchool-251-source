package nso;

import main.GameCanvas;

public final class InputDlg extends Dialog {

    private String[] info;

    public TField tfInput;

    private int padLeft = 40;

    public InputDlg() {
        if (GameCanvas.w <= 176) {
            this.padLeft = 10;
        }
        this.tfInput = new TField();
        this.tfInput.x = this.padLeft + 10;
        this.tfInput.y = GameCanvas.h - mScreen.ITEM_HEIGHT - 43;
        this.tfInput.width = GameCanvas.w - 2 * (this.padLeft + 10);
        this.tfInput.height = mScreen.ITEM_HEIGHT + 2;
        this.tfInput.isFocus = true;
        super.right = this.tfInput.cmdClear;
    }

    public final void show(String info1, Command ok, int type) {
        try {
            this.tfInput.setText("");
            this.tfInput.setIputType(type);
            this.info = mFont.tahoma_8b.splitFontArray(info1, GameCanvas.w - (this.padLeft << 1));
            super.left = new Command(mResources.CLOSE, GameCanvas.gI(), 8882, null);
            super.center = ok;
            if (this.left != null) {
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
            GameCanvas.currentDialog = this;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public final void paint(mGraphics g) {
        GameCanvas.paintz.paintInputDlg(g, this.padLeft, GameCanvas.h - 77 - mScreen.cmdH, GameCanvas.w - (this.padLeft << 1), 69, this.info, null);
        this.tfInput.paint(g);
        super.paint(g);
    }

    public final void keyPress(int keyCode) {
        this.tfInput.keyPressed(keyCode);
        super.keyPress(keyCode);
    }

    public final void update() {
        this.tfInput.update();
        super.update();
    }
}
