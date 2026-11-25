package nso;

public final class ItemMap {

    public int x;

    public int y;

    public int xEnd;

    public int yEnd;

    public int vx;

    public int vy;

    public int itemMapID;

    public ItemTemplate template;

    public byte status;

    public MyImage imgCaptcha;

    public ItemMap(short itemMapID1, short itemTemplateID, int x2, int y3, int xEnd4, int yEnd5) {
        this.itemMapID = itemMapID1;
        this.template = ItemTemplates.get(itemTemplateID);
        this.x = xEnd4;
        this.y = y3;
        this.xEnd = xEnd4;
        this.yEnd = yEnd5;
        this.vx = xEnd4 - x2 >> 2;
        this.vy = 5;
    }

    public ItemMap(short itemMapID1, short itemTemplateID, int x2, int y3) {
        this.itemMapID = itemMapID1;
        this.template = ItemTemplates.get(itemTemplateID);
        this.x = this.xEnd = x2;
        this.y = this.yEnd = y3;
        this.status = 1;
    }

    public final void setPoint(int xEnd1, int yEnd2) {
        this.xEnd = xEnd1;
        this.yEnd = yEnd2;
        this.vx = xEnd1 - this.x >> 2;
        this.vy = yEnd2 - this.y >> 2;
        this.status = 2;
    }
}
