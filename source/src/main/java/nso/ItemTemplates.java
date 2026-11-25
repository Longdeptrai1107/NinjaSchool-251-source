package nso;

public final class ItemTemplates {

    public static mHashtable itemTemplates = new mHashtable();

    public ItemTemplates() {
    }

    public static void add(ItemTemplate it) {
        itemTemplates.put(new Short(it.id), it);
    }

    public static ItemTemplate get(short id) {
        return (ItemTemplate) itemTemplates.get(new Short(id));
    }

    public static short getIcon(short shortValue) {
        return get(shortValue).iconID;
    }
}
