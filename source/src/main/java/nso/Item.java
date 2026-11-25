package nso;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.microedition.lcdui.Image;

public final class Item {

    public int indexFrame;

    public ItemTemplate template;

    public MyVector options;

    public int itemId;

    private int playerId;

    public int indexUI;

    public int quantity;

    public long expires;

    public boolean isLock;

    public int sys;

    public int upgrade;

    public int buyCoin;

    public int buyCoinLock;

    public int buyGold;

    private int buyGoldLock;

    public int saleCoinLock;

    public int typeUI;

    public boolean isExpires;

    public EffectCharPaint eff;

    public int indexEff;

    public Image img;

    public Item() {
    }

    public final Item clone() {
        Item item;
        (item = new Item()).template = this.template;
        if (this.options != null) {
            item.options = new MyVector();
            for (int index = 0; index < this.options.size(); index++) {
                ItemOption itemOption;
                (itemOption = new ItemOption()).optionTemplate = ((ItemOption) this.options.elementAt(index)).optionTemplate;
                itemOption.param = ((ItemOption) this.options.elementAt(index)).param;
                item.options.addElement(itemOption);
            }
        }
        item.itemId = this.itemId;
        item.playerId = this.playerId;
        item.indexUI = this.indexUI;
        item.quantity = this.quantity;
        item.expires = this.expires;
        item.isLock = this.isLock;
        item.sys = this.sys;
        item.upgrade = this.upgrade;
        item.buyCoin = this.buyCoin;
        item.buyCoinLock = this.buyCoinLock;
        item.buyGold = this.buyGold;
        item.buyGoldLock = this.buyGoldLock;
        item.saleCoinLock = this.saleCoinLock;
        item.typeUI = this.typeUI;
        item.isExpires = this.isExpires;
        return item;
    }

    public final Item viewNext(int up) {
        Item item;
        (item = this.clone()).isLock = true;
        int value;
        if ((value = up - item.upgrade) == 0) {
            return item;
        }
        item.upgrade = up;
        if (item.options != null) {
            for (int index = 0; index < item.options.size(); index++) {
                ItemOption itemOption;
                if ((itemOption = (ItemOption) item.options.elementAt(index)).optionTemplate.id == 6 || itemOption.optionTemplate.id == 7) {
                    itemOption.param += value * 15;
                } else if (itemOption.optionTemplate.id == 8 || itemOption.optionTemplate.id == 9 || itemOption.optionTemplate.id == 19) {
                    itemOption.param += value * 10;
                } else if (itemOption.optionTemplate.id == 10 || itemOption.optionTemplate.id == 11 || itemOption.optionTemplate.id == 12 || itemOption.optionTemplate.id == 13 || itemOption.optionTemplate.id == 14 || itemOption.optionTemplate.id == 15 || itemOption.optionTemplate.id == 17 || itemOption.optionTemplate.id == 18 || itemOption.optionTemplate.id == 20) {
                    itemOption.param += value * 5;
                } else if (itemOption.optionTemplate.id == 21 || itemOption.optionTemplate.id == 22 || itemOption.optionTemplate.id == 23 || itemOption.optionTemplate.id == 24 || itemOption.optionTemplate.id == 25 || itemOption.optionTemplate.id == 26) {
                    itemOption.param += value * 150;
                } else if (itemOption.optionTemplate.id == 16) {
                    itemOption.param += value * 3;
                }
            }
        }
        return item;
    }

    public final boolean isTypeBody() {
        return this.template.type >= 0 && this.template.type <= 15;
    }

    public final boolean isTypeMounts() {
        return 29 <= this.template.type && this.template.type <= 33;
    }

    public final boolean isTypeNgocKham() {
        return this.template.type == 34;
    }

    public final String getExpiresString() {
        if (this.expires <= 0L) {
            return mResources.FOREVER;
        }
        Calendar calendar;
        (calendar = Calendar.getInstance()).setTimeZone(TimeZone.getTimeZone("GMT+7"));
        calendar.setTime(new Date(this.expires));
        int value = calendar.get(11);
        int value1 = calendar.get(12);
        int value2 = calendar.get(5);
        int value3 = calendar.get(2) + 1;
        int value4 = calendar.get(1);
        return value2 + "/" + value3 + "/" + value4 + " " + value + "h" + value1 + "'";
    }

    public final String getExpiresShopString() {
        if (this.expires <= 0L) {
            return mResources.FOREVER;
        } else if (this.expires / 1000L >= 2592000L) {
            return this.expires / 1000L / 2592000L + " " + mResources.MONTH;
        } else if (this.expires / 1000L >= 604800L) {
            return this.expires / 1000L / 604800L + " " + mResources.WEEK;
        } else if (this.expires / 1000L >= 86400L) {
            return this.expires / 1000L / 86400L + " " + mResources.DAY;
        } else if (this.expires / 1000L >= 3600L) {
            return this.expires / 1000L / 3600L + " " + mResources.HOUR;
        } else {
            return this.expires / 1000L >= 60L ? this.expires / 1000L / 60L + " " + mResources.MINUTE : "";
        }
    }

    public final void clearExpire() {
        if (!this.isTypeMounts()) {
            this.expires = 0L;
        }
    }

    public final boolean isTypeUIMe() {
        return this.typeUI == 5 || this.typeUI == 3 || this.typeUI == 4 || this.typeUI == 39;
    }

    public final boolean isTypeUIShopView() {
        return this.isTypeUIShop() ? true : this.isTypeUIStore() || this.isTypeUIBook() || this.isTypeUIFashion() || this.isTypeUIClanShop();
    }

    public final boolean isTypeUIShop() {
        return this.typeUI == 20 || this.typeUI == 21 || this.typeUI == 22 || this.typeUI == 23 || this.typeUI == 24 || this.typeUI == 25 || this.typeUI == 26 || this.typeUI == 27 || this.typeUI == 28 || this.typeUI == 29 || this.typeUI == 16 || this.typeUI == 17 || this.typeUI == 18 || this.typeUI == 19 || this.typeUI == 2 || this.typeUI == 6 || this.typeUI == 8 || this.typeUI == 34;
    }

    public final boolean isTypeUIShopLock() {
        return this.typeUI == 7 || this.typeUI == 9;
    }

    public final boolean isTypeUIStore() {
        return this.typeUI == 14;
    }

    public final boolean isTypeUIBook() {
        return this.typeUI == 15;
    }

    public final boolean isTypeUIFashion() {
        return this.typeUI == 32;
    }

    public final boolean isTypeUIClanShop() {
        return this.typeUI == 34;
    }

    public final boolean isUpMax() {
        return this.getUpMax() == this.upgrade;
    }

    public final int getUpMax() {
        if (this.template.level >= 1 && this.template.level < 20) {
            return 4;
        } else if (this.template.level >= 20 && this.template.level < 40) {
            return 8;
        } else if (this.template.level >= 40 && this.template.level < 50) {
            return 12;
        } else {
            return this.template.level >= 50 && this.template.level < 60 ? 14 : 16;
        }
    }

    public final boolean isTypeClothe() {
        return this.template.type == 0 || this.template.type == 2 || this.template.type == 4 || this.template.type == 6 || this.template.type == 8;
    }

    public final boolean isTypeAdorn() {
        return this.template.type == 3 || this.template.type == 5 || this.template.type == 7 || this.template.type == 9;
    }

    public final boolean isTypeWeapon() {
        return this.template.type == 1;
    }

    public final boolean isNewitem() {
        if (this.options != null) {
            for (int index = 0; index < this.options.size(); index++) {
                if (((ItemOption) this.options.elementAt(index)).optionTemplate.id == 155) {
                    return true;
                }
            }
        }
        return false;
    }
}
