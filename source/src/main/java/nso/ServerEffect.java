package nso;

import main.GameCanvas;

public final class ServerEffect extends Effect2 {

    private EffectCharPaint eff;

    private int i0;

    private int x;

    private int y;

    private int dir = 1;

    private Char c;

    private short loopCount = 0;

    private long endTime = 0L;

    public ServerEffect() {
    }

    public static void addServerEffect(int id, int cx, int cy, int loopCount1) {
        ServerEffect serverEffect;
        (serverEffect = new ServerEffect()).eff = GameScr.efs[id];
        serverEffect.x = cx;
        serverEffect.y = cy;
        serverEffect.loopCount = (short) loopCount1;
        Effect2.vEffect2.addElement(serverEffect);
    }

    public static void addServerEffect(int id, int cx, int cy, int loopCount1, byte dir2) {
        ServerEffect serverEffect;
        (serverEffect = new ServerEffect()).eff = GameScr.efs[id];
        serverEffect.x = cx;
        serverEffect.y = cy;
        serverEffect.loopCount = (short) loopCount1;
        serverEffect.dir = dir2;
        Effect2.vEffect2.addElement(serverEffect);
    }

    public static void addServerEffect(int id, Char c1, int loopCount2) {
        ServerEffect serverEffect;
        (serverEffect = new ServerEffect()).eff = GameScr.efs[id];
        serverEffect.c = c1;
        serverEffect.loopCount = (short) loopCount2;
        Effect2.vEffect2.addElement(serverEffect);
    }

    public static void addServerEffectWithTime(int value, Char character, int value1) {
        ServerEffect serverEffect;
        (serverEffect = new ServerEffect()).eff = GameScr.efs[value];
        serverEffect.c = character;
        serverEffect.endTime = System.currentTimeMillis() + value1 * 1000;
        Effect2.vEffect2.addElement(serverEffect);
    }

    public final void paint(mGraphics g) {
        if (this.c != null) {
            this.x = this.c.cx;
            this.y = this.c.cy;
        }
        int value = this.x + this.eff.arrEfInfo[this.i0].dx * this.dir;
        int value1 = this.y + this.eff.arrEfInfo[this.i0].dy;
        if (GameCanvas.isPaint(value, value1)) {
            SmallImage.drawSmallImage(g, this.eff.arrEfInfo[this.i0].idImg, value, value1, this.dir == 1 ? 0 : 2, 3);
        }
    }

    public final void update() {
        if (this.endTime != 0L) {
            this.i0++;
            if (this.i0 >= this.eff.arrEfInfo.length) {
                this.i0 = 0;
            }
            if (System.currentTimeMillis() - this.endTime > 0L) {
                if (this.eff.idEf == 120) {
                    GameCanvas.isBallEffect = false;
                }
                Effect2.vEffect2.removeElement(this);
            }
        } else {
            this.i0++;
            if (this.i0 >= this.eff.arrEfInfo.length) {
                this.loopCount--;
                if (this.loopCount <= 0) {
                    if (this.eff.idEf == 120) {
                        GameCanvas.isBallEffect = false;
                    }
                    Effect2.vEffect2.removeElement(this);
                } else {
                    this.i0 = 0;
                }
            }
        }
        if (GameCanvas.gameTick % 11 == 0 && this.c != null && this.c != Char.getMyChar() && !GameScr.vCharInMap.contains(this.c)) {
            Effect2.vEffect2.removeElement(this);
        }
    }
}
