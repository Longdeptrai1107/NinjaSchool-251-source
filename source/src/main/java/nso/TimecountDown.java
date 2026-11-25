package nso;

public final class TimecountDown {

    long mysecond;

    public String tile;

    public boolean wantdestroy;

    public short id;

    public short idIcon;

    private byte typeCount;

    public TimecountDown(short id1, short idIcon2, long second, String tile3, byte type) {
        this.mysecond = System.currentTimeMillis() + second * 1000L;
        this.tile = tile3;
        this.id = id1;
        this.idIcon = idIcon2;
        this.typeCount = type;
        if (this.typeCount == 0) {
            this.mysecond = second;
        }
    }

    public final void paint(mGraphics g, int x, int y) {
        if (this.idIcon == -1) {
            if (this.typeCount != 1) {
                mFont.tahoma_7.drawString(g, this.tile, x + 1, y + 1, 1);
                mFont.tahoma_7_white.drawString(g, this.tile, x, y, 1);
                return;
            }
            int value;
            if ((value = (int) ((this.mysecond - System.currentTimeMillis()) / 1000L)) > 0) {
                mFont.tahoma_7.drawString(g, this.tile + " : " + converSecon2hours(value), x - 5, y + 1, 1);
                mFont.tahoma_7_white.drawString(g, this.tile + " : " + converSecon2hours(value), x - 4, y, 1);
                return;
            }
        } else {
            MyImage myImage;
            if ((myImage = (MyImage) SmallImage.imgNew.get(String.valueOf(this.id))) == null) {
                myImage = new MyImage();
                SmallImage.imgNew.put(String.valueOf(this.id), myImage);
                myImage.img = Controller.createImage(RMS.loadRMS(String.valueOf(this.id)));
                if (myImage.img == null) {
                    myImage.timerequest = System.currentTimeMillis();
                    Service.gI().requestIcon(this.id);
                }
            } else if (myImage.img == null && System.currentTimeMillis() - myImage.timerequest > 60000L) {
                myImage.timerequest = System.currentTimeMillis();
                Service.gI().requestIcon(this.id);
            }
            if (myImage != null && myImage.img != null) {
                if (this.typeCount == 0) {
                    int value1 = mFont.tahoma_7.getWidth(this.tile + " : ");
                    g.drawImage(myImage.img, x - value1 - (myImage.img.getWidth() << 1), y + mGraphics.getImageHeight(myImage.img) / 4, 0);
                    mFont.tahoma_7.drawString(g, this.tile, x - value1 - (myImage.img.getWidth() << 1) + 1 + mGraphics.getImageWidth(myImage.img), y + 1 + mGraphics.getImageHeight(myImage.img) / 4, 0);
                    mFont.tahoma_7_white.drawString(g, this.tile, x - value1 - (myImage.img.getWidth() << 1) + mGraphics.getImageWidth(myImage.img), y + mGraphics.getImageHeight(myImage.img) / 4, 0);
                    return;
                }
                if (this.typeCount == 1) {
                    int value2 = (int) ((this.mysecond - System.currentTimeMillis()) / 1000L);
                    int value3 = mFont.tahoma_7.getWidth(converSecon2hours(value2) + ":");
                    g.drawImage(myImage.img, x - value3 - (myImage.img.getWidth() << 1), y + mGraphics.getImageHeight(myImage.img) / 4, 0);
                    mFont.tahoma_7.drawString(g, " : " + converSecon2hours(value2), x - value3 - (myImage.img.getWidth() << 1) + 1 + mGraphics.getImageWidth(myImage.img), y + 1 + mGraphics.getImageHeight(myImage.img) / 4, 0);
                    mFont.tahoma_7_white.drawString(g, " : " + converSecon2hours(value2), x - value3 - (myImage.img.getWidth() << 1) + mGraphics.getImageWidth(myImage.img), y + mGraphics.getImageHeight(myImage.img) / 4, 0);
                }
            }
        }
    }

    public final void update() {
        if (this.typeCount == 1 && System.currentTimeMillis() - this.mysecond >= 0L) {
            this.wantdestroy = true;
        }
    }

    private static String converSecon2hours(int totalSeconds) {
        int value = totalSeconds % 60;
        int value1;
        int value2 = (value1 = totalSeconds / 60) % 60;
        if ((totalSeconds = value1 / 60) > 0) {
            return totalSeconds + ":" + value2;
        } else if (value2 > 0) {
            return value2 + ":" + value;
        } else {
            return value < 0 ? "0:" + value : String.valueOf(value);
        }
    }
}
