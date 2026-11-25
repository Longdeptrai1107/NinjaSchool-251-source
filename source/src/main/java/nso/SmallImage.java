package nso;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.microedition.lcdui.Image;
import main.GameCanvas;
import main.GameMidlet;

public final class SmallImage {

    public static int[][] smallImg;

    private static Image[] imgbig;

    public static Hashtable imgNew = new Hashtable();

    public short x;

    public short y;

    public short w;

    public short h;

    public SmallImage(int id, int x, int y, int w, int h) {
        this.x = (short) x;
        this.y = (short) y;
        this.w = (short) w;
        this.h = (short) h;
    }

    public static void checkTimeUseImg() {
        try {
            Enumeration enumeration = imgNew.keys();
            while (enumeration.hasMoreElements()) {
                String text = (String) enumeration.nextElement();
                MyImage myImage = (MyImage) imgNew.get(text);
                if (System.currentTimeMillis() - myImage.timeUse > 180000L) {
                    imgNew.remove(text);
                }
            }
        } catch (Exception exception) {
        }
    }

    public static void freeBig() {
        imgbig = null;
        System.gc();
    }

    public static void loadBigImage() {
        imgbig = null;
        System.gc();
        imgbig = new Image[] { GameCanvas.loadImage("/img/Big0.png"), GameCanvas.loadImage("/img/Big1.png"), GameCanvas.loadImage("/img/Big2.png"), GameCanvas.loadImage("/img/Big3.png"), GameCanvas.loadImage("/img/Big4.png") };
        Image.createRGBImage(new int[] { -2013265920 }, 1, 1, true);
    }

    public SmallImage() {
        readImage();
    }

    public static void init() {
        new SmallImage();
    }

    private static void readImage() {
        try {
            DataInputStream dataInputStream;
            short shortValue;
            smallImg = new int[shortValue = (dataInputStream = new DataInputStream(new ByteArrayInputStream(RMS.loadRMS("nj_image")))).readShort()][5];
            for (int index = 0; index < shortValue; index++) {
                smallImg[index][0] = dataInputStream.readUnsignedByte();
                smallImg[index][1] = dataInputStream.readShort();
                smallImg[index][2] = dataInputStream.readShort();
                smallImg[index][3] = dataInputStream.readShort();
                smallImg[index][4] = dataInputStream.readShort();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void reciveImage(int id, byte[] data) {
        MyImage myImage;
        if ((myImage = (MyImage) imgNew.get(String.valueOf(id))) == null) {
            myImage = new MyImage();
            imgNew.put(String.valueOf(id), myImage);
        }
        myImage.img = Controller.createImage(data);
        if (GameMidlet.CLIENT_TYPE != 1) {
            RMS.saveRMSImage(String.valueOf(id), data);
        }
    }

    public static boolean isExitsImage(int id) {
        if (id >= smallImg.length || smallImg[id][1] >= imgbig[smallImg[id][0]].getWidth() || smallImg[id][3] >= imgbig[smallImg[id][0]].getWidth() || smallImg[id][2] >= imgbig[smallImg[id][0]].getHeight() || smallImg[id][4] >= imgbig[smallImg[id][0]].getHeight()) {
            MyImage myImage;
            if ((myImage = (MyImage) imgNew.get(String.valueOf(id))) == null) {
                myImage = new MyImage();
                imgNew.put(String.valueOf(id), myImage);
                myImage.img = Controller.createImage(RMS.loadRMS(String.valueOf(id)));
                if (myImage.img == null) {
                    myImage.timerequest = System.currentTimeMillis();
                    Service.gI().requestIcon(id);
                }
                return false;
            }
            if (myImage.img != null) {
                return true;
            }
            if (myImage.img == null && System.currentTimeMillis() - myImage.timerequest > 60000L) {
                myImage.timerequest = System.currentTimeMillis();
                Service.gI().requestIcon(id);
                return false;
            }
        }
        return true;
    }

    public static int getHeight(int value) {
        return smallImg[value][4];
    }

    public static void drawSmallImage(mGraphics g, int id, int x, int y, int transform, int anchor) {
        if (id < smallImg.length && smallImg[id][1] < imgbig[smallImg[id][0]].getWidth() && smallImg[id][3] < imgbig[smallImg[id][0]].getWidth() && smallImg[id][2] < imgbig[smallImg[id][0]].getHeight() && smallImg[id][4] < imgbig[smallImg[id][0]].getHeight()) {
            g.drawRegion(imgbig[smallImg[id][0]], smallImg[id][1], smallImg[id][2], smallImg[id][3], smallImg[id][4], transform, x, y, anchor);
        } else {
            MyImage myImage;
            if ((myImage = (MyImage) imgNew.get(String.valueOf(id))) == null) {
                myImage = new MyImage();
                imgNew.put(String.valueOf(id), myImage);
                myImage.img = Controller.createImage(RMS.loadRMS(String.valueOf(id)));
                if (myImage.img == null) {
                    myImage.timerequest = System.currentTimeMillis();
                    Service.gI().requestIcon(id);
                }
            } else if (myImage.img == null && System.currentTimeMillis() - myImage.timerequest > 60000L) {
                myImage.timerequest = System.currentTimeMillis();
                Service.gI().requestIcon(id);
            }
            if (myImage != null) {
                if (myImage.img != null) {
                    g.drawRegion(myImage.img, 0, 0, myImage.img.getWidth(), myImage.img.getHeight(), transform, x, y, anchor);
                }
                myImage.timeUse = System.currentTimeMillis();
                return;
            }
        }
    }

    public static void drawSmallImageNew(mGraphics g, int id, int x, int y, int transform, int anchor, int indexFrame) {
        if (id < smallImg.length && smallImg[id][1] < imgbig[smallImg[id][0]].getWidth() && smallImg[id][3] < imgbig[smallImg[id][0]].getWidth() && smallImg[id][2] < imgbig[smallImg[id][0]].getHeight() && smallImg[id][4] < imgbig[smallImg[id][0]].getHeight()) {
            g.drawRegion(imgbig[smallImg[id][0]], smallImg[id][1], smallImg[id][2], smallImg[id][3], smallImg[id][4], 0, x, y, 3);
        } else {
            MyImage myImage;
            if ((myImage = (MyImage) imgNew.get(String.valueOf(id))) == null) {
                myImage = new MyImage();
                imgNew.put(String.valueOf(id), myImage);
                myImage.img = Controller.createImage(RMS.loadRMS(String.valueOf(id)));
                if (myImage.img == null) {
                    myImage.timerequest = System.currentTimeMillis();
                    Service.gI().requestIcon(id);
                }
            } else if (myImage.img == null && System.currentTimeMillis() - myImage.timerequest > 60000L) {
                myImage.timerequest = System.currentTimeMillis();
                Service.gI().requestIcon(id);
            }
            if (myImage != null) {
                if (myImage.img != null) {
                    if (myImage.img.getHeight() > 35) {
                        id = myImage.img.getWidth();
                        anchor = myImage.img.getHeight() / 3;
                        g.drawRegion(myImage.img, 0, indexFrame * anchor, id, anchor, 0, x, y, 3);
                    } else {
                        g.drawRegion(myImage.img, 0, 0, myImage.img.getWidth(), myImage.img.getHeight(), 0, x, y, 3);
                    }
                }
                myImage.timeUse = System.currentTimeMillis();
                return;
            }
        }
    }
}
