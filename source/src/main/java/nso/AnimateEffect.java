package nso;

import javax.microedition.lcdui.Image;
import main.GameCanvas;

public final class AnimateEffect extends Effect2 {

    private static FrameImage img;

    private static FrameImage imgSnow;

    private static Image imgTuyet = GameCanvas.loadImage("/u/tuyet.png");

    private static Image imgCoBay = GameCanvas.loadImage("/u/cobay.png");

    private byte type = 0;

    private int number = 0;

    private MyVector list = new MyVector();

    static {
        new Scroll();
    }

    public AnimateEffect(byte byteValue, boolean flag, int value) {
        this.type = byteValue;
        this.number = value;
        switch(byteValue) {
            case 1:
                value = 10;
                if (nso.AnimateEffect.img == null) {
                    nso.AnimateEffect.img = new FrameImage(nso.AnimateEffect.imgCoBay, 16, 10);
                }
            case 2:
            default:
                break;
            case 3:
                if (nso.AnimateEffect.imgSnow == null) {
                    nso.AnimateEffect.imgSnow = new FrameImage(nso.AnimateEffect.imgTuyet, 5, 5);
                }
        }
        for (int index = 0; index < value; index++) {
            Position position = null;
            position = new Position((GameScr.cmx - 20 + Res.rnd((GameCanvas.w + 40) / 5) * 5) * 10, (GameScr.cmy - 20 + Res.rnd(GameCanvas.h / 5) * 5) * 10);
            if (byteValue == 3) {
                position.h = Res.rnd(3);
            } else {
                position.h = Res.rnd(4);
            }
            position.limitY = 16 + (Res.rnd(3) << 2);
            position.v = Res.random(-1, 1);
            position.color = Res.rnd(position.limitY);
            this.list.addElement(position);
        }
    }

    public final void paint(mGraphics graphics) {
        graphics.translate(-graphics.getTranslateX(), -graphics.getTranslateY());
        graphics.setClip(0, -200, GameCanvas.w, 200 + GameCanvas.h);
        switch(this.type) {
            case 1:
                graphics = graphics;
                for (int index = 0; index < this.number; index++) {
                    Position position = (Position) this.list.elementAt(index);
                    nso.AnimateEffect.img.drawFrame(position.color / (position.limitY / 4), position.x / 10 - GameScr.cmx, position.y / 10 - GameScr.cmy, 0, 3, graphics);
                }
                return;
            case 3:
                for (int index1 = 0; index1 < this.number; index1++) {
                    Position position2;
                    if ((position2 = (Position) this.list.elementAt(index1)).h > 0) {
                        GameScr.gI();
                        if (Scroll.me == null) {
                            Scroll.me = new Scroll();
                        }
                        int value = Scroll.me.cmx * (2 - position2.h) * 20 / 120 - GameScr.cmx;
                        nso.AnimateEffect.imgSnow.drawFrame(position2.h, value + position2.x / 10, position2.y / 10 - GameScr.cmy, 2, 0, graphics);
                    }
                }
            case 2:
        }
    }

    public final void update() {
        switch(this.type) {
            case 1:
                for (int index = 0; index < this.number; index++) {
                    Position position;
                    (position = (Position) this.list.elementAt(index)).y += 10;
                    position.x = position.x + position.v * 10;
                    position.color++;
                    if (position.color >= position.limitY) {
                        position.color = 0;
                    }
                    if (position.y / 10 > GameScr.cmy + GameCanvas.h - (3 - position.h) * 40 || position.x / 10 < GameScr.cmx - GameCanvas.hw || position.x / 10 > GameScr.cmx + GameCanvas.w + GameCanvas.hw) {
                        if (position.y / 10 > 24) {
                            int value = position.x / 10 + GameScr.cmx;
                            int value1 = position.y / 10 + GameScr.cmy;
                            int value2 = value;
                            AnimateEffect animateEffect = this;
                            Position position3;
                            (position3 = new Position(value2, value1)).limitY = 200;
                            Res.rnd(4);
                            new EmptyAnimationAction(animateEffect, position3, value2, value1);
                        }
                        this.rndPos(position);
                    }
                }
                return;
            case 3:
                for (int index4 = 0; index4 < this.number; index4++) {
                    Position position5;
                    Position position6 = position5 = (Position) this.list.elementAt(index4);
                    position6.y = position6.y + (position5.h + 1) * 5;
                    position5.x = position5.x + (position5.h + 1 << 1);
                    if (position5.y / 10 > GameScr.cmy + GameCanvas.h - (3 - position5.h) * 30) {
                        this.rndPos(position5);
                    }
                    Position position7 = position5;
                    int value8 = GameScr.cmx * (2 - position7.h) * 20 / 120;
                    if (position7.x / 10 + value8 < GameScr.cmx - 10) {
                        position7.x = position7.x + (GameCanvas.w + 20) * 10;
                    }
                    if (position7.x / 10 + value8 > GameScr.cmx + GameCanvas.w + 10) {
                        position7.x = position7.x - (GameCanvas.w + 20) * 10;
                    }
                }
            case 2:
        }
    }

    private void rndPos(Position position) {
        position.x = (GameScr.cmx - 20 + Res.rnd((GameCanvas.w + 40) / 5) * 5) * 10;
        position.y = (GameScr.cmy - GameCanvas.hh + Res.rnd(GameCanvas.h / 5) * 5) * 10;
        if (this.type == 3) {
            position.h = Res.rnd(3);
        } else {
            position.h = Res.rnd(4);
        }
    }
}
