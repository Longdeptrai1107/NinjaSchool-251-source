package nso;

public final class PartFrame {

    public short idSmallImg;

    public short dx;

    public short dy;

    public byte flip;

    public byte onTop = 0;

    public PartFrame(int dx1, int dy2, int idSmall) {
        this.idSmallImg = (short) idSmall;
        this.dx = (short) dx1;
        this.dy = (short) dy2;
    }
}
