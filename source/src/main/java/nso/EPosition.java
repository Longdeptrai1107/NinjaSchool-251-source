package nso;

public final class EPosition {

    public int x;

    public int y;

    public byte follow;

    public byte count = 0;

    public short index = -1;

    public EPosition(int x1, int y2) {
        this.x = x1;
        this.y = y2;
    }

    public EPosition(int x1, int y2, int fol) {
        this.x = x1;
        this.y = y2;
        this.follow = (byte) fol;
    }

    public EPosition() {
    }
}
