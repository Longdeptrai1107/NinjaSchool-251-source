package nso;

import main.GameCanvas;

public final class MobSoul {

    private int x;

    private int y;

    private int xdest;

    private int ydest;

    private int status;

    private int timeFollow;

    private int type;

    private Char c;

    private int[] x0;

    private int[] y0;

    private int[] dir;

    public MobSoul(int x1, int y2, Char c3) {
        this.x = x1;
        this.y = y2;
        this.xdest = x1;
        this.ydest = y2 - (Res.rnd(40) + 20);
        this.status = 1;
        this.type = 1;
        this.c = c3;
    }

    public MobSoul(int cx, int cy) {
        this.status = 1;
        this.type = 2;
        this.xdest = cx;
        this.ydest = cy;
        this.x0 = new int[5];
        this.y0 = new int[5];
        this.dir = new int[5];
        this.timeFollow = 300;
        for (int index = 0; index < this.x0.length; index++) {
            this.x0[index] = Res.random(cx - 20, cx + 20);
            this.y0[index] = cy - 10;
            this.dir[index] = index % 2 == 0 ? 1 : -1;
        }
    }

    public final void update() {
        if (this.type == 1) {
            if (this.c == null) {
                GameScr.vMobSoul.removeElement(this);
                return;
            }
            if (this.status == 1) {
                if (this.y > this.ydest) {
                    this.y -= 2;
                    this.x = this.x + (1 - GameCanvas.gameTick % 3);
                } else {
                    this.status = 2;
                }
                this.timeFollow = 100;
                return;
            }
            this.timeFollow--;
            if (Res.abs(this.c.cx - this.x) >= 50 && Res.abs(this.c.cy - this.y) >= 50) {
                this.x = this.x + (this.c.cx - this.x) / 10;
                this.y = this.y + (this.c.cy - this.y) / 10;
            } else {
                this.x = this.x + (this.c.cx - this.x) / 4;
                this.y = this.y + (this.c.cy - this.y) / 4;
            }
            if (this.timeFollow < 0) {
                this.x = this.c.cx;
                this.y = this.c.cy - this.c.ch / 2;
                if (this.timeFollow < -5) {
                    GameScr.vMobSoul.removeElement(this);
                    return;
                }
            } else if (Res.abs(this.c.cx - this.x) < 10 && Res.abs(this.c.cy - this.y) < 10) {
                GameScr.vMobSoul.removeElement(this);
                return;
            }
        } else if (this.type == 2) {
            for (int index = 0; index < this.x0.length; index++) {
                this.y0[index] = this.y0[index] - GameCanvas.gameTick % 5;
                if (this.dir[index] == -1) {
                    this.x0[index]--;
                } else {
                    this.x0[index]++;
                }
                if (this.x0[index] <= this.xdest - 20 || this.x0[index] >= this.xdest + 20) {
                    this.dir[index] = -this.dir[index];
                }
                if (this.y0[index] < 0) {
                    GameScr.vMobSoul.removeElement(this);
                }
            }
        }
    }

    public final void paint(mGraphics g) {
        if (this.type == 1) {
            if (GameCanvas.gameTick % 5 > 2) {
                SmallImage.drawSmallImage(g, 1433, this.x, this.y, 0, 3);
            } else {
                SmallImage.drawSmallImage(g, 1434, this.x, this.y, 0, 3);
            }
        } else {
            for (int index = 0; index < this.x0.length; index++) {
                if (GameCanvas.gameTick % 5 > 2) {
                    SmallImage.drawSmallImage(g, 1433, this.x0[index], this.y0[index], 0, 3);
                } else {
                    SmallImage.drawSmallImage(g, 1434, this.x0[index], this.y0[index], 0, 3);
                }
            }
        }
    }
}
