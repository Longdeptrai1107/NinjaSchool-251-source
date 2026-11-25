package nso;

public final class EggMonters {

    public int x;

    public int y;

    public int frame = 0;

    public byte status = 0;

    public int vy;

    public static Mob ownerEgg;

    public final boolean isPaint() {
        if (this.x < GameScr.cmx) {
            return false;
        } else if (this.x > GameScr.cmx + GameScr.gW) {
            return false;
        } else if (this.y < GameScr.cmy) {
            return false;
        } else {
            return this.y > GameScr.cmy + GameScr.gH + 30 ? false : ownerEgg == null || ownerEgg.status != 8;
        }
    }

    public EggMonters(int x1, int y2) {
        this.x = x1;
        this.y = y2;
        for (int index = 0; index < GameScr.vMob.size(); index++) {
            Mob mob;
            if ((mob = (Mob) GameScr.vMob.elementAt(index)).templateId == 202) {
                ownerEgg = mob;
            }
        }
    }
}
