package nso;

import javax.microedition.lcdui.Image;

public final class FrameImage {

    private int frameWidth;

    private int frameHeight;

    private int nFrame;

    private Image imgFrame;

    private int[] pos;

    private int totalHeight;

    public FrameImage(Image img, int width, int height) {
        this.imgFrame = img;
        this.frameWidth = width;
        this.frameHeight = height;
        this.totalHeight = img.getHeight();
        this.nFrame = this.totalHeight / height;
        this.pos = new int[this.nFrame];
        for (int index = 0; index < this.nFrame; index++) {
            this.pos[index] = index * height;
        }
    }

    public final void drawFrame(int idx, int x, int y, int trans, int anchor, mGraphics g) {
        if (idx >= 0 && idx < this.nFrame) {
            g.drawRegion(this.imgFrame, 0, this.pos[idx], this.frameWidth, this.frameHeight, trans, x, y, anchor);
        }
    }
}
