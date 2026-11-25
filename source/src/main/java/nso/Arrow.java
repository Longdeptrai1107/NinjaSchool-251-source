package nso;

public final class Arrow {

    public int life = 0;

    public int ax;

    public int ay;

    private int axTo;

    private int ayTo;

    private int avx;

    private int avy;

    private int adx;

    private int ady;

    private Char charBelong;

    private Arrowpaint arrp = null;

    private static byte[] FRAME = new byte[] { 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0 };

    private static int[] ARROWINDEX = new int[] { 0, 15, 37, 52, 75, 105, 127, 142, 165, 195, 217, 232, 255, 285, 307, 322, 345, 370 };

    private static int[] TRANSFORM = new int[] { 0, 0, 0, 7, 6, 6, 6, 2, 2, 3, 3, 4, 5, 5, 5, 1 };

    public Arrow(Char charBelong1, Arrowpaint arrp2) {
        this.charBelong = charBelong1;
        this.arrp = arrp2;
    }

    public final void update() {
        if (this.charBelong.mobFocus != null || this.charBelong.charFocus != null) {
            if (this.charBelong.mobFocus != null) {
                this.axTo = this.charBelong.mobFocus.x;
                this.ayTo = this.charBelong.mobFocus.y - this.charBelong.mobFocus.h / 4;
            } else if (this.charBelong.charFocus != null) {
                this.axTo = this.charBelong.charFocus.cx;
                this.ayTo = this.charBelong.charFocus.cy - this.charBelong.charFocus.ch / 4;
            }
            int value = this.axTo - this.ax;
            int value1 = this.ayTo - this.ay;
            int value2 = 4;
            if (value + value1 < 60) {
                value2 = 3;
            } else if (value + value1 < 30) {
                value2 = 2;
            }
            if (this.ax != this.axTo) {
                if (value > 0 && value < 5) {
                    this.ax = this.axTo;
                } else if (value < 0 && value > -5) {
                    this.ax = this.axTo;
                } else {
                    this.avx = this.axTo - this.ax << 2;
                    this.adx = this.adx + this.avx;
                    this.ax = this.ax + (this.adx >> value2);
                    this.adx &= 15;
                }
            }
            if (this.ay != this.ayTo) {
                if (value1 > 0 && value1 < 5) {
                    this.ay = this.ayTo;
                } else if (value1 < 0 && value1 > -5) {
                    this.ay = this.ayTo;
                } else {
                    this.avy = this.ayTo - this.ay << 2;
                    this.ady = this.ady + this.avy;
                    this.ay = this.ay + (this.ady >> value2);
                    this.ady &= 15;
                }
            }
            value = 0;
            value1 = 0;
            value2 = 0;
            int value3 = 0;
            if (this.charBelong.mobFocus != null) {
                value = this.axTo - this.charBelong.mobFocus.w / 4;
                value2 = this.axTo + this.charBelong.mobFocus.w / 4;
                value1 = this.ayTo - this.charBelong.mobFocus.h / 4;
                value3 = this.ayTo + this.charBelong.mobFocus.h / 4;
            } else if (this.charBelong.charFocus != null) {
                value = this.axTo - this.charBelong.charFocus.cw / 4;
                value2 = this.axTo + this.charBelong.charFocus.cw / 4;
                value1 = this.ayTo - this.charBelong.charFocus.ch / 4;
                value3 = this.ayTo + this.charBelong.charFocus.ch / 4;
            }
            if (this.life > 0) {
                this.life--;
            }
            if (this.life != 0 && (this.ax < value || this.ax > value2 || this.ay < value1 || this.ay > value3)) {
                return;
            }
        }
        this.endMe();
    }

    private void endMe() {
        this.charBelong.arr = null;
        this.ax = this.ay = this.axTo = this.ayTo = this.avx = this.avy = this.adx = this.ady = 0;
        this.charBelong.setAttack();
        if (this.charBelong.me) {
            this.charBelong.saveLoadPreviousSkill();
        }
    }

    public final void paint(mGraphics g) {
        int value = this.axTo - this.ax;
        int value1 = this.ayTo - this.ay;
        value = Res.angle(value, -value1);
        value1 = 0;
        byte byteValue;
        while (true) {
            if (value1 >= ARROWINDEX.length - 1) {
                byteValue = 0;
                break;
            }
            if (value >= ARROWINDEX[value1] && value <= ARROWINDEX[value1 + 1]) {
                byteValue = (byte) (value1 >= 16 ? 0 : value1);
                break;
            }
            value1++;
        }
        byte byteValue2 = byteValue;
        SmallImage.drawSmallImage(g, this.arrp.imgId[FRAME[byteValue2]], this.ax, this.ay, TRANSFORM[byteValue2], 3);
    }
}
