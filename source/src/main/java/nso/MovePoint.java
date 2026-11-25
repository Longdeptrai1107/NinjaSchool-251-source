package nso;

public final class MovePoint {

    public int xEnd;

    public int yEnd;

    public int status;

    public MovePoint(int xEnd1, int yEnd2, int act, int dir) {
        this.xEnd = xEnd1;
        this.yEnd = yEnd2;
        this.status = act;
    }

    public MovePoint(int xEnd1, int yEnd2) {
        this.xEnd = xEnd1;
        this.yEnd = yEnd2;
    }
}
