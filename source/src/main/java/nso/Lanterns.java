package nso;

public final class Lanterns {

    public int x;

    public int y;

    public int dy = 3;

    public int yStart;

    public boolean isEnd;

    public Lanterns(int x1, int y2) {
        this.x = x1;
        this.y = this.yStart = y2;
        this.isEnd = false;
    }
}
