package nso;

public final class ItemOption {

    public int param;

    public byte active;

    public ItemOptionTemplate optionTemplate;

    public ItemOption() {
    }

    public ItemOption(int optionTemplateId, int param1) {
        this.param = param1;
        this.optionTemplate = GameScr.iOptionTemplates[optionTemplateId];
    }

    public final String getOptionString() {
        if (this.optionTemplate.type == 9) {
            String text = getValuePercent(this.param);
            return NinjaUtil.replace(this.optionTemplate.name, "#", text);
        } else {
            return NinjaUtil.replace(this.optionTemplate.name, "#", String.valueOf(this.param));
        }
    }

    private static String getValuePercent(int value) {
        if (value % 100 == 0) {
            return String.valueOf(value / 100);
        } else {
            return value % 10 == 0 ? value / 100 + "." + value % 100 / 10 : value / 100 + "." + value % 100 / 10 + value % 10;
        }
    }

    public final String getOptionShopString() {
        String text = null;
        if (this.optionTemplate.id == 0 || this.optionTemplate.id == 1 || this.optionTemplate.id == 21 || this.optionTemplate.id == 22 || this.optionTemplate.id == 23 || this.optionTemplate.id == 24 || this.optionTemplate.id == 25 || this.optionTemplate.id == 26) {
            int value = this.param - 50 + 1;
            text = NinjaUtil.replace(this.optionTemplate.name, "#", String.valueOf(this.param)) + " (" + value + "-" + this.param + ")";
        } else if (this.optionTemplate.id == 6 || this.optionTemplate.id == 7 || this.optionTemplate.id == 8 || this.optionTemplate.id == 9 || this.optionTemplate.id == 19) {
            int value1 = this.param - 10 + 1;
            text = NinjaUtil.replace(this.optionTemplate.name, "#", String.valueOf(this.param)) + " (" + value1 + "-" + this.param + ")";
        } else if (this.optionTemplate.id == 2 || this.optionTemplate.id == 3 || this.optionTemplate.id == 4 || this.optionTemplate.id == 5 || this.optionTemplate.id == 10 || this.optionTemplate.id == 11 || this.optionTemplate.id == 12 || this.optionTemplate.id == 13 || this.optionTemplate.id == 14 || this.optionTemplate.id == 15 || this.optionTemplate.id == 17 || this.optionTemplate.id == 18 || this.optionTemplate.id == 20) {
            int value2 = this.param - 5 + 1;
            text = NinjaUtil.replace(this.optionTemplate.name, "#", String.valueOf(this.param)) + " (" + value2 + "-" + this.param + ")";
        } else if (this.optionTemplate.id == 16) {
            int value3 = this.param - 3 + 1;
            text = NinjaUtil.replace(this.optionTemplate.name, "#", String.valueOf(this.param)) + " (" + value3 + "-" + this.param + ")";
        } else if (this.optionTemplate.type == 9) {
            text = getValuePercent(this.param);
            text = NinjaUtil.replace(this.optionTemplate.name, "#", text);
        } else {
            text = NinjaUtil.replace(this.optionTemplate.name, "#", String.valueOf(this.param));
        }
        return text;
    }
}
