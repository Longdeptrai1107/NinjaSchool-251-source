package nso;

public final class CharPartInfo {

    public static mHashtable head_jump = new mHashtable();

    public static mHashtable head_normal = new mHashtable();

    public static mHashtable head_boc_dau = new mHashtable();

    public static mHashtable body_jump = new mHashtable();

    public static mHashtable body_normal = new mHashtable();

    public static mHashtable body_boc_dau = new mHashtable();

    private static mHashtable leg = new mHashtable();

    public mHashtable item = new mHashtable();

    public static mHashtable newMount = new mHashtable();

    public int dx = 0;

    public int dy = 0;

    public int idSmall;

    public CharPartInfo() {
    }

    public static void doSetInfo(Message msg) {
        try {
            mHashtable mHashtable1 = head_boc_dau;
            head_boc_dau.h.clear();
            mHashtable1 = head_jump;
            head_jump.h.clear();
            mHashtable1 = head_normal;
            head_normal.h.clear();
            mHashtable1 = body_boc_dau;
            body_boc_dau.h.clear();
            mHashtable1 = body_jump;
            body_jump.h.clear();
            mHashtable1 = body_normal;
            body_normal.h.clear();
            mHashtable1 = newMount;
            newMount.h.clear();
            int unsignedByte = msg.reader().readUnsignedByte();
            for (int index = 0; index < unsignedByte; index++) {
                byte byteValue = msg.reader().readByte();
                short shortValue = msg.reader().readShort();
                short shortValue2 = msg.reader().readShort();
                CharPartInfo charPartInfo;
                (charPartInfo = new CharPartInfo()).idSmall = shortValue2;
                for (byte index3 = 0; index3 < byteValue - 2; index3 += 3) {
                    short shortValue4 = msg.reader().readShort();
                    short shortValue5 = msg.reader().readShort();
                    short shortValue6 = msg.reader().readShort();
                    CharPartInfo charPartInfo7;
                    (charPartInfo7 = new CharPartInfo()).dx = shortValue5;
                    charPartInfo7.dy = shortValue6;
                    charPartInfo.item.put(String.valueOf(shortValue4), charPartInfo7);
                }
                head_jump.put(String.valueOf(shortValue), charPartInfo);
            }
            for (int index8 = 0; index8 < unsignedByte; index8++) {
                byte byteValue9 = msg.reader().readByte();
                short shortValue10 = msg.reader().readShort();
                short shortValue11 = msg.reader().readShort();
                CharPartInfo charPartInfo12;
                (charPartInfo12 = new CharPartInfo()).idSmall = shortValue11;
                for (byte index13 = 0; index13 < byteValue9 - 2; index13 += 3) {
                    short shortValue14 = msg.reader().readShort();
                    short shortValue15 = msg.reader().readShort();
                    short shortValue16 = msg.reader().readShort();
                    CharPartInfo charPartInfo17;
                    (charPartInfo17 = new CharPartInfo()).dx = shortValue15;
                    charPartInfo17.dy = shortValue16;
                    charPartInfo12.item.put(String.valueOf(shortValue14), charPartInfo17);
                }
                head_normal.put(String.valueOf(shortValue10), charPartInfo12);
            }
            for (int index18 = 0; index18 < unsignedByte; index18++) {
                byte byteValue19 = msg.reader().readByte();
                short shortValue20 = msg.reader().readShort();
                short shortValue21 = msg.reader().readShort();
                CharPartInfo charPartInfo22;
                (charPartInfo22 = new CharPartInfo()).idSmall = shortValue21;
                for (byte index23 = 0; index23 < byteValue19 - 2; index23 += 3) {
                    short shortValue24 = msg.reader().readShort();
                    short shortValue25 = msg.reader().readShort();
                    short shortValue26 = msg.reader().readShort();
                    CharPartInfo charPartInfo27;
                    (charPartInfo27 = new CharPartInfo()).dx = shortValue25;
                    charPartInfo27.dy = shortValue26;
                    charPartInfo22.item.put(String.valueOf(shortValue24), charPartInfo27);
                }
                head_boc_dau.put(String.valueOf(shortValue20), charPartInfo22);
            }
            int unsignedByte28 = msg.reader().readUnsignedByte();
            for (byte index29 = 0; index29 < unsignedByte28; index29 += 2) {
                short shortValue30 = msg.reader().readShort();
                short shortValue31 = msg.reader().readShort();
                CharPartInfo charPartInfo32;
                (charPartInfo32 = new CharPartInfo()).idSmall = shortValue31;
                leg.put(String.valueOf(shortValue30), charPartInfo32);
            }
            int unsignedByte33 = msg.reader().readUnsignedByte();
            for (int index34 = 0; index34 < unsignedByte33; index34++) {
                byte byteValue35 = msg.reader().readByte();
                short shortValue36 = msg.reader().readShort();
                short shortValue37 = msg.reader().readShort();
                CharPartInfo charPartInfo38;
                (charPartInfo38 = new CharPartInfo()).idSmall = shortValue37;
                for (byte index39 = 0; index39 < byteValue35 - 2; index39 += 3) {
                    short shortValue40 = msg.reader().readShort();
                    short shortValue41 = msg.reader().readShort();
                    short shortValue42 = msg.reader().readShort();
                    CharPartInfo charPartInfo43;
                    (charPartInfo43 = new CharPartInfo()).dx = shortValue41;
                    charPartInfo43.dy = shortValue42;
                    charPartInfo38.item.put(String.valueOf(shortValue40), charPartInfo43);
                }
                body_jump.put(String.valueOf(shortValue36), charPartInfo38);
            }
            for (int index44 = 0; index44 < unsignedByte33; index44++) {
                byte byteValue45 = msg.reader().readByte();
                short shortValue46 = msg.reader().readShort();
                short shortValue47 = msg.reader().readShort();
                CharPartInfo charPartInfo48;
                (charPartInfo48 = new CharPartInfo()).idSmall = shortValue47;
                for (byte index49 = 0; index49 < byteValue45 - 2; index49 += 3) {
                    short shortValue50 = msg.reader().readShort();
                    short shortValue51 = msg.reader().readShort();
                    short shortValue52 = msg.reader().readShort();
                    CharPartInfo charPartInfo53;
                    (charPartInfo53 = new CharPartInfo()).dx = shortValue51;
                    charPartInfo53.dy = shortValue52;
                    charPartInfo48.item.put(String.valueOf(shortValue50), charPartInfo53);
                }
                body_normal.put(String.valueOf(shortValue46), charPartInfo48);
            }
            for (int index54 = 0; index54 < unsignedByte33; index54++) {
                byte byteValue55 = msg.reader().readByte();
                short shortValue56 = msg.reader().readShort();
                short shortValue57 = msg.reader().readShort();
                CharPartInfo charPartInfo58;
                (charPartInfo58 = new CharPartInfo()).idSmall = shortValue57;
                for (byte index59 = 0; index59 < byteValue55 - 2; index59 += 3) {
                    short shortValue60 = msg.reader().readShort();
                    short shortValue61 = msg.reader().readShort();
                    short shortValue62 = msg.reader().readShort();
                    CharPartInfo charPartInfo63;
                    (charPartInfo63 = new CharPartInfo()).dx = shortValue61;
                    charPartInfo63.dy = shortValue62;
                    charPartInfo58.item.put(String.valueOf(shortValue60), charPartInfo63);
                }
                body_boc_dau.put(String.valueOf(shortValue56), charPartInfo58);
            }
            byte byteValue64 = msg.reader().readByte();
            for (int index65 = 0; index65 < byteValue64; index65++) {
                short shortValue66 = msg.reader().readShort();
                int[][] values = new int[6][];
                for (int index67 = 0; index67 < 6; index67++) {
                    byte byteValue68 = msg.reader().readByte();
                    values[index67] = new int[byteValue68];
                    for (int index69 = 0; index69 < byteValue68; index69++) {
                        values[index67][index69] = msg.reader().readShort();
                    }
                }
                newMount.put(String.valueOf(shortValue66), values);
            }
        } catch (Exception exception) {
        }
    }
}
