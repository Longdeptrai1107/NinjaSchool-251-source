package nso;

public final class Position {

    public int x;

    public int y;

    public int v;

    public int h;

    public int color = 0;

    public int limitY;

    public Position() {
        this.x = 0;
        this.y = 0;
    }

    public Position(int x1, int y2) {
        this.x = x1;
        this.y = y2;
    }
}
