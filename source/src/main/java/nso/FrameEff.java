package nso;

public final class FrameEff {

    public MyVector listPartTop = new MyVector();

    public MyVector listPartBottom = new MyVector();

    public FrameEff(MyVector listtop, MyVector listbottom) {
        this.listPartTop = listtop;
        this.listPartBottom = listbottom;
    }
}
