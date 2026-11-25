package nso;

public final class MobAttack {

    private int x;

    private int y;

    private int vx;

    private int vy;

    private int indexM;

    private int xTo;

    private int yTo;

    private int d;

    private int statusM;

    private static int[] maxIndex = new int[] { 4, 1, 4 };

    static {
        int[] var10000 = new int[] { 10, 5, 11 };
        var10000 = new int[] { 10, 5, 11 };
    }

    public final void update() {
        if (this.statusM > 0 && this.statusM < 4) {
            this.x = this.x + this.vx;
            this.y = this.y + this.vy;
            this.vy += 2;
            if (this.vx < -2) {
                this.vx++;
            }
            if (this.vx > 2) {
                this.vx--;
            }
            if (this.vy == 6) {
                if (this.statusM == 2) {
                    this.statusM = 0;
                } else {
                    this.statusM = 4;
                }
                this.d = 11;
                this.vx = Res.xetVX(Res.angle(this.xTo - this.x, this.yTo - this.y), this.d);
                this.vy = Res.xetVY(Res.angle(this.xTo - this.x, this.yTo - this.y), this.d);
            }
        } else {
            Char character = null;
            character = (Char) GameScr.vCharInMap.elementAt(0);
            this.xTo = character.cx;
            this.yTo = character.cy - character.chh;
            this.x = this.x + this.vx;
            this.y = this.y + this.vy;
            this.d++;
            this.vx = Res.xetVX(Res.angle(this.xTo - this.x, this.yTo - this.y), this.d);
            this.vy = Res.xetVY(Res.angle(this.xTo - this.x, this.yTo - this.y), this.d);
            this.indexM++;
            if (this.indexM == maxIndex[0]) {
                this.indexM = 0;
            }
            if (this.x < this.xTo + character.chw && this.x > this.xTo - character.chw && this.y < this.yTo + character.chh && this.y > this.yTo - character.chh) {
                GameScr.vMobAttack.removeElement(this);
            }
        }
    }
}
