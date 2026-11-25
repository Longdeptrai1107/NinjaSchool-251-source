package main;

import javax.microedition.lcdui.Graphics;

public abstract class CanvasAdapter {

    public CanvasAdapter() {
    }

    protected abstract void paint(Graphics graphics);

    protected abstract void keyPressed(int value);

    protected abstract void keyReleased(int value);

    protected abstract void pointerDragged(int value, int value1);

    protected abstract void pointerPressed(int value, int value1);

    protected abstract void pointerReleased(int value, int value1);
}
