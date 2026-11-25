package nso;

public final class Member {

    public int iconId;

    public int level;

    public int type;

    public String name;

    public boolean isOnline;

    public int pointClan;

    public int pointClanWeek;

    public Member(int classId, int level1, int type2, String name3, int pointClan4, boolean isOnline5) {
        switch(classId) {
            case 0:
                this.iconId = 647;
                break;
            case 1:
                this.iconId = 1182;
                break;
            case 2:
                this.iconId = 1181;
                break;
            case 3:
                this.iconId = 643;
                break;
            case 4:
                this.iconId = 645;
                break;
            case 5:
                this.iconId = 676;
                break;
            case 6:
                this.iconId = 1119;
        }
        this.level = level1;
        this.type = type2;
        this.name = name3;
        this.pointClan = pointClan4;
        this.isOnline = isOnline5;
    }
}
