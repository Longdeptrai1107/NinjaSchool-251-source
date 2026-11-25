package nso;

public final class ItemTemplate {

    public short id;

    public byte type;

    public byte gender;

    public String name;

    public String description;

    public byte level;

    public short iconID;

    public short part;

    public boolean isUpToUp;

    public ItemTemplate(short templateID, byte type1, byte gender2, String name3, String description4, byte level5, short iconID6, short part7, boolean isUpToUp8) {
        this.id = templateID;
        this.type = type1;
        this.gender = gender2;
        this.name = name3;
        this.description = description4;
        this.level = level5;
        this.iconID = iconID6;
        this.part = part7;
        this.isUpToUp = isUpToUp8;
    }
}
