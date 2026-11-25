package nso;

public final class Task {

    public int index;

    public short[] counts;

    public String[] names;

    public String[] details;

    public String[] subNames;

    public short count;

    public Task(short taskId, byte index1, String name, String detail, String[] subNames2, short[] counts3, short count4) {
        this.index = index1;
        this.names = mFont.tahoma_7b_white.splitFontArray(name, 155);
        this.details = mFont.tahoma_7.splitFontArray(detail, 155);
        this.subNames = subNames2;
        this.counts = counts3;
        this.count = count4;
    }
}
