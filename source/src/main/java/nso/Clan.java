package nso;

public final class Clan {

    public String name = "";

    public int exp;

    public int expNext;

    public int level;

    public int itemLevel;

    public int openDun;

    public int coin;

    public int freeCoin;

    public int coinUp;

    public String main_name = "";

    public String reg_date = "";

    public String log = "";

    public String alert = "";

    public int total;

    public int use_card;

    public Item[] items;

    public Clan() {
        new MyVector();
    }

    public final void writeLog(String data) {
        String[] textLines = NinjaUtil.split(data, "\n");
        this.log = "";
        try {
            for (int index = 0; index < textLines.length; index++) {
                String text;
                if (!(text = textLines[index].trim()).equals("")) {
                    try {
                        String[] textLines1;
                        String text2 = (textLines1 = NinjaUtil.split(text, ","))[0];
                        int value;
                        if ((value = Integer.parseInt(textLines1[1])) == 0) {
                            text2 = "c0" + text2;
                            text2 = text2 + mResources.CLAN_ACTIVITY[1] + " " + NinjaUtil.numberToString(textLines1[2]) + " " + mResources.CLAN_ACTIVITY[0] + " " + textLines1[3];
                        } else if (value == 1) {
                            text2 = "c1" + text2;
                            text2 = text2 + " " + mResources.CLAN_ACTIVITY[2] + " " + NinjaUtil.numberToString(textLines1[2]) + " " + mResources.CLAN_ACTIVITY[0] + " " + textLines1[3];
                        } else if (value == 2) {
                            text2 = "c2" + text2;
                            text2 = text2 + " " + mResources.CLAN_ACTIVITY[3] + " " + NinjaUtil.numberToString(textLines1[2]) + " " + mResources.CLAN_ACTIVITY[0] + " " + textLines1[3];
                        } else if (value == 3) {
                            text2 = "c1" + text2;
                            text2 = text2 + " " + mResources.CLAN_ACTIVITY[4] + " " + NinjaUtil.numberToString(textLines1[2]) + " " + mResources.CLAN_ACTIVITY[0] + " " + textLines1[3];
                        } else if (value == 4) {
                            text2 = "c1" + text2;
                            text2 = text2 + mResources.CLAN_ACTIVITY[5] + " " + NinjaUtil.numberToString(textLines1[2]) + " " + mResources.CLAN_ACTIVITY[0] + " " + textLines1[3];
                        } else if (value == 5) {
                            text2 = "c2" + text2;
                            text2 = text2 + " " + mResources.CLAN_ACTIVITY[6] + " " + NinjaUtil.numberToString(textLines1[2]) + " " + mResources.CLAN_ACTIVITY[0] + " " + textLines1[3];
                        }
                        this.log = this.log + text2 + "\n";
                    } catch (Exception exception) {
                    }
                }
            }
        } catch (Exception exception3) {
        }
    }
}
