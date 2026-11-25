package main;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import nso.mGraphics;

public final class MotherCanvas extends Canvas {

    public static MotherCanvas instance;

    private CanvasAdapter canvasAdapter;

    private int zoomLevel = 1;

    private int newWidth;

    private int newHeight;

    private static boolean disableZoom = true;

    public MotherCanvas() {
        this.setFullScreenMode(true);
        mGraphics.zoomLevel = 1;
        if (!main.MotherCanvas.disableZoom) {
            if (this.getWidth() * this.getHeight() > 2073600) {
                mGraphics.zoomLevel = this.zoomLevel = 4;
                this.newWidth = this.getWidth() / this.zoomLevel + 2;
                this.newHeight = this.getHeight() / this.zoomLevel + 2;
                return;
            }
            if (this.getWidth() * this.getHeight() > 153600) {
                mGraphics.zoomLevel = this.zoomLevel = 3;
                this.newWidth = this.getWidth() / this.zoomLevel + 2;
                this.newHeight = this.getHeight() / this.zoomLevel + 2;
                return;
            }
            mGraphics.zoomLevel = this.zoomLevel = 1;
        }
    }

    public final void setCanvasAdapter(CanvasAdapter canvasAdapter) {
        this.canvasAdapter = canvasAdapter;
    }

    protected final void paint(Graphics graphics) {
        this.canvasAdapter.paint(graphics);
    }

    protected final void keyPressed(int keyCode) {
        this.canvasAdapter.keyPressed(keyCode);
    }

    protected final void keyReleased(int keyCode) {
        this.canvasAdapter.keyReleased(keyCode);
    }

    protected final void pointerDragged(int x, int y) {
        x /= this.zoomLevel;
        y /= this.zoomLevel;
        this.canvasAdapter.pointerDragged(x, y);
    }

    protected final void pointerPressed(int x, int y) {
        x /= this.zoomLevel;
        y /= this.zoomLevel;
        this.canvasAdapter.pointerPressed(x, y);
    }

    protected final void pointerReleased(int x, int y) {
        x /= this.zoomLevel;
        y /= this.zoomLevel;
        this.canvasAdapter.pointerReleased(x, y);
    }

    public final int getHeight_new() {
        return this.zoomLevel == 1 ? this.getHeight() : this.newHeight;
    }

    public final int getWidth_new() {
        return this.zoomLevel == 1 ? this.getWidth() : this.newWidth;
    }
}
