package nso;

public final class InfoItem {

    public String s;

    mFont f;

    public int speed;

    public InfoItem(String s1) {
        this.f = mFont.tahoma_7_white;
        this.s = s1;
        this.speed = 20;
    }

    public InfoItem(String s1, mFont f2, int speed3) {
        this.f = f2;
        this.s = s1;
        this.speed = speed3;
    }
}
