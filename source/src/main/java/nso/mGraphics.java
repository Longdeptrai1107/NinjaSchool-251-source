package nso;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class mGraphics {

    public Graphics graphics;

    public static int zoomLevel = 1;

    public mGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public mGraphics() {
    }

    public final void drawImage(Image image, int x, int y, int anchor) {
        x *= nso.mGraphics.zoomLevel;
        y *= nso.mGraphics.zoomLevel;
        this.graphics.drawImage(image, x, y, anchor);
    }

    public final void drawLine(int value, int value1, int value2, int value3) {
        value *= nso.mGraphics.zoomLevel;
        value1 *= nso.mGraphics.zoomLevel;
        value2 *= nso.mGraphics.zoomLevel;
        value3 *= nso.mGraphics.zoomLevel;
        this.graphics.drawLine(value, value1, value2, value3);
    }

    public final void drawRect(int value, int value1, int value2, int value3) {
        value *= nso.mGraphics.zoomLevel;
        value1 *= nso.mGraphics.zoomLevel;
        value2 *= nso.mGraphics.zoomLevel;
        value3 *= nso.mGraphics.zoomLevel;
        this.graphics.drawRect(value, value1, value2, value3);
    }

    public final void drawRegion(Image arg0, int x0, int y0, int w0, int h0, int arg5, int x, int y, int arg8) {
        x *= nso.mGraphics.zoomLevel;
        y *= nso.mGraphics.zoomLevel;
        x0 *= nso.mGraphics.zoomLevel;
        y0 *= nso.mGraphics.zoomLevel;
        w0 *= nso.mGraphics.zoomLevel;
        h0 *= nso.mGraphics.zoomLevel;
        this.graphics.drawRegion(arg0, x0, y0, w0, h0, arg5, x, y, arg8);
    }

    public final void drawRoundRect(int value, int value1, int value2, int value3, int value4, int value5) {
        value *= nso.mGraphics.zoomLevel;
        value1 *= nso.mGraphics.zoomLevel;
        value2 *= nso.mGraphics.zoomLevel;
        value3 *= nso.mGraphics.zoomLevel;
        value4 *= nso.mGraphics.zoomLevel;
        value5 *= nso.mGraphics.zoomLevel;
        this.graphics.drawRoundRect(value, value1, value2, value3, value4, value5);
    }

    public final void fillRect(int value, int value1, int value2, int value3) {
        value *= nso.mGraphics.zoomLevel;
        value1 *= nso.mGraphics.zoomLevel;
        value2 *= nso.mGraphics.zoomLevel;
        value3 *= nso.mGraphics.zoomLevel;
        this.graphics.fillRect(value, value1, value2, value3);
    }

    public final void fillRoundRect(int value, int value1, int value2, int value3, int value4, int value5) {
        value *= nso.mGraphics.zoomLevel;
        value1 *= nso.mGraphics.zoomLevel;
        value2 *= nso.mGraphics.zoomLevel;
        value3 *= nso.mGraphics.zoomLevel;
        value4 *= nso.mGraphics.zoomLevel;
        value5 *= nso.mGraphics.zoomLevel;
        this.graphics.fillRoundRect(value, value1, value2, value3, value4, value5);
    }

    public final int getTranslateX() {
        return this.graphics.getTranslateX() / nso.mGraphics.zoomLevel;
    }

    public final int getTranslateY() {
        return this.graphics.getTranslateY() / nso.mGraphics.zoomLevel;
    }

    public final void setClip(int value, int value1, int value2, int value3) {
        value *= nso.mGraphics.zoomLevel;
        value1 *= nso.mGraphics.zoomLevel;
        value2 *= nso.mGraphics.zoomLevel;
        value3 *= nso.mGraphics.zoomLevel;
        this.graphics.setClip(value, value1, value2, value3);
    }

    public final void setColor(int value) {
        this.graphics.setColor(value);
    }

    public final void translate(int tx, int ty) {
        tx *= nso.mGraphics.zoomLevel;
        ty *= nso.mGraphics.zoomLevel;
        this.graphics.translate(tx, ty);
    }

    public static int getImageWidth(Image image) {
        return image.getWidth() / nso.mGraphics.zoomLevel;
    }

    public static int getImageHeight(Image image) {
        return image.getHeight() / nso.mGraphics.zoomLevel;
    }
}
