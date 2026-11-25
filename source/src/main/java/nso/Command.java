package nso;

import javax.microedition.lcdui.Image;
import main.GameCanvas;

public final class Command {

    public String caption;

    public String[] subCaption;

    public IActionListener actionListener;

    public int idAction;

    private Image back;

    private Image focus;

    public Image img;

    public int x = 0;

    public int y = 0;

    public int w = mScreen.cmdW;

    public int h = mScreen.cmdH;

    public boolean isFocus = false;

    public Object p;

    public Command(String caption1, IActionListener actionListener2, int action, Object p3, int x4, int y5) {
        this.caption = caption1;
        this.idAction = action;
        this.actionListener = actionListener2;
        this.p = p3;
        this.x = x4;
        this.y = y5;
        this.w = mScreen.cmdW;
        this.h = mScreen.cmdH;
        this.back = null;
        this.focus = null;
    }

    public Command(String caption1, IActionListener actionListener2, int action, Object p3) {
        this.caption = caption1;
        this.idAction = action;
        this.actionListener = actionListener2;
        this.p = p3;
    }

    public Command(String caption1, int action, Object p2) {
        this.caption = caption1;
        this.idAction = action;
        this.p = p2;
    }

    public Command(String caption1, int action) {
        this.caption = caption1;
        this.idAction = action;
    }

    public Command(String caption1, int action, int x2, int y3) {
        this.caption = caption1;
        this.idAction = 0;
        this.x = x2;
        this.y = y3;
    }

    public final void performAction() {
        if (this.idAction > 0) {
            if (this.actionListener != null) {
                this.actionListener.perform(this.idAction, this.p);
                return;
            }
            GameScr.gI().actionPerform(this.idAction, this.p);
        }
    }

    public final void paint(mGraphics g) {
        if (this.img != null) {
            g.drawImage(this.img, this.x + mGraphics.getImageWidth(this.img) / 2, this.y + mGraphics.getImageHeight(this.img) / 2, 3);
        } else {
            if (this.caption != "") {
                if (!this.isFocus) {
                    g.drawImage(GameScr.imgLbtn, this.x, this.y, 0);
                } else {
                    g.drawImage(GameScr.imgLbtnFocus, this.x, this.y, 0);
                }
            }
            mFont.tahoma_7b_yellow.drawString(g, this.caption, this.x + 36, this.y + 6, 2);
        }
    }

    public final boolean input() {
        this.isFocus = false;
        if (GameCanvas.isPointerHoldIn(this.x - 3, this.y - 3, this.w + 6, this.h + 6)) {
            if (GameCanvas.isPointerDown) {
                this.isFocus = true;
            }
            if (GameCanvas.isPointerJustRelease && GameCanvas.isPointerClick) {
                return true;
            }
        }
        return false;
    }

    public final void updatePointer() {
        Command command = this;
        if (this.x > 0 && command.y > 0 && this.input()) {
            this.performAction();
            GameCanvas.isPointerDown = false;
            this.isFocus = false;
        }
    }
}
