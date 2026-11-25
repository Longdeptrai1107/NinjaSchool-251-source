package nso;

public final class Party {

    public int charId;

    public int level;

    public short iconId;

    public String name;

    public boolean isLock;

    public Char c;

    public int size;

    public Party(byte classId, int level1, String name2, int size3) {
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
        this.name = name2;
        this.level = level1;
        this.size = size3;
    }

    public Party(int charId1, byte classId, String name2, boolean isLock3) {
        this.charId = charId1;
        this.isLock = isLock3;
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
        this.name = name2;
        if (charId1 == Char.getMyChar().charID) {
            this.c = Char.getMyChar();
        } else {
            this.c = GameScr.findCharInMap(charId1);
        }
    }

    public static void refreshAll() {
        for (int index = 0; index < GameScr.vParty.size(); index++) {
            Party party;
            if ((party = (Party) GameScr.vParty.elementAt(index)).charId != Char.getMyChar().charID) {
                party.c = GameScr.findCharInMap(party.charId);
            }
        }
    }

    public static void clear(int charId1) {
        for (int index = 0; index < GameScr.vParty.size(); index++) {
            Party party;
            if ((party = (Party) GameScr.vParty.elementAt(index)).charId == charId1) {
                party.c = null;
                return;
            }
        }
    }
}
