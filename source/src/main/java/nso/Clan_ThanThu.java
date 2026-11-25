package nso;

public final class Clan_ThanThu {

    public String name = "";

    public byte stars;

    public short idIconItem;

    public short idThanThu;

    public int time_aptrung = -1;

    public String str_trungno = "";

    public MyVector vecInfo = new MyVector();

    public int curExp = -1;

    public int maxExp = -1;

    public long timeStartThanThu;

    public Clan_ThanThu(String name1, byte stars2, short idIconItem3, short idThanThu4, int time_aptrung5, String str_trungno6, MyVector vecInfo7, int curExp8, int maxExp9) {
        this.name = name1;
        this.idIconItem = idIconItem3;
        this.idThanThu = idThanThu4;
        this.time_aptrung = time_aptrung5;
        this.str_trungno = str_trungno6;
        this.vecInfo = vecInfo7;
        this.curExp = curExp8;
        this.maxExp = maxExp9;
        this.timeStartThanThu = System.currentTimeMillis();
        this.stars = stars2;
    }
}
