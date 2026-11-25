package nso;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import main.GameMidlet;

public final class EffectAuto extends Effect2 {

    private short id;

    private MyImage img;

    private int x;

    private int y;

    private int f;

    private int dir;

    private byte loopCount = 0;

    private long endTime = 0L;

    private static EffAtutoTemp[] arrEffAtutoTemplate = new EffAtutoTemp[20];

    private static Hashtable imgEffAuto = new Hashtable();

    private static Hashtable dataEffAuto = new Hashtable();

    private boolean isInfinite_loop;

    public EffectAuto() {
    }

    public static void addEffectAuto(short id1, int x2, int y3, byte loopCount4, short time, int dir5) {
        EffectAuto effectAuto;
        (effectAuto = new EffectAuto()).id = id1;
        effectAuto.x = x2;
        effectAuto.y = y3;
        effectAuto.loopCount = loopCount4;
        if (effectAuto.loopCount < 0) {
            effectAuto.isInfinite_loop = true;
        } else {
            effectAuto.isInfinite_loop = false;
        }
        if (time > 0) {
            effectAuto.endTime = System.currentTimeMillis() + time * 1000;
        } else {
            effectAuto.endTime = -1L;
        }
        effectAuto.dir = dir5;
        Effect2.vEffect2.addElement(effectAuto);
    }

    private EffAtutoTemp getTemplate() {
        return arrEffAtutoTemplate[this.id];
    }

    public final void paint(mGraphics g) {
        if (this.img != null && this.img.img != null && this.getTemplate().frameRunning != null) {
            Frame frame = this.getTemplate().frameEffAuto[this.getTemplate().frameRunning[this.f]];
            for (int index = 0; index < frame.dx.length; index++) {
                EffAtutoTemp effAtutoTemp = this.getTemplate();
                byte byteValue = frame.idImg[index];
                ImageInfo imageInfo = effAtutoTemp.imginfo[byteValue];
                if (this.dir > 0) {
                    g.drawRegion(this.img.img, imageInfo.x0, imageInfo.y0, imageInfo.w, imageInfo.h, 0, this.x + frame.dx[index], this.y + frame.dy[index] - 1, 20);
                } else {
                    g.drawRegion(this.img.img, imageInfo.x0, imageInfo.y0, imageInfo.w, imageInfo.h, 2, this.x - frame.dx[index], this.y + frame.dy[index] - 1, 24);
                }
            }
        }
    }

    public final void update() {
        try {
            arrEffAtutoTemplate[this.id] = (EffAtutoTemp) dataEffAuto.get(String.valueOf(this.id));
            if (arrEffAtutoTemplate[this.id] == null) {
                arrEffAtutoTemplate[this.id] = new EffAtutoTemp();
                dataEffAuto.put(String.valueOf(this.id), arrEffAtutoTemplate[this.id]);
                this.getTemplate().timerequest = System.currentTimeMillis();
                Service.gI().request_imgEffAuto((byte) 1, this.id);
            } else if (this.getTemplate().frameRunning == null && System.currentTimeMillis() - this.getTemplate().timerequest > 3000L) {
                this.getTemplate().timerequest = System.currentTimeMillis();
                Service.gI().request_imgEffAuto((byte) 1, this.id);
            }
            if (this.getTemplate().frameRunning != null) {
                this.img = (MyImage) imgEffAuto.get(String.valueOf(this.id));
                if (this.img == null) {
                    this.img = new MyImage();
                    imgEffAuto.put(String.valueOf(this.id), this.img);
                    this.img.img = Controller.createImage(RMS.loadRMS("effauto " + this.id));
                    if (this.img.img == null) {
                        this.img.timerequest = System.currentTimeMillis();
                        Service.gI().request_imgEffAuto((byte) 0, this.id);
                    }
                } else if (this.img.img == null && System.currentTimeMillis() - this.img.timerequest > 6000L) {
                    this.img.timerequest = System.currentTimeMillis();
                    Service.gI().request_imgEffAuto((byte) 0, this.id);
                }
            }
            if (this.img != null && this.img.img != null && this.getTemplate().frameRunning != null) {
                this.f++;
                if (this.f >= this.getTemplate().frameRunning.length) {
                    if (this.endTime != -1L) {
                        if (this.endTime - System.currentTimeMillis() <= 0L) {
                            Effect2.vEffect2.removeElement(this);
                        } else {
                            this.f = 0;
                        }
                    } else {
                        label62: {
                            if (!this.isInfinite_loop) {
                                this.loopCount--;
                                if (this.loopCount <= 0) {
                                    Effect2.vEffect2.removeElement(this);
                                    break label62;
                                }
                            }
                            this.f = 0;
                        }
                    }
                }
                this.img.timeUse = System.currentTimeMillis();
                return;
            }
        } catch (Exception exception) {
            System.out.println("Err update effauto:" + exception.toString());
        }
    }

    public static void reciveData(short id1, byte[] data) {
        if (((EffAtutoTemp) dataEffAuto.get(String.valueOf(id1))).frameRunning == null) {
            new EffAtutoTemp();
            EffAtutoTemp effAtutoTemp = creatDataEffauto(id1, data);
            dataEffAuto.put(String.valueOf(id1), effAtutoTemp);
        }
    }

    private static EffAtutoTemp creatDataEffauto(short idEff, byte[] data) {
        try {
            EffAtutoTemp effAtutoTemp = new EffAtutoTemp();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
            DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
            effAtutoTemp.imginfo = new ImageInfo[dataInputStream.readByte()];
            for (int index = 0; index < effAtutoTemp.imginfo.length; index++) {
                effAtutoTemp.imginfo[index] = new ImageInfo();
                dataInputStream.readByte();
                effAtutoTemp.imginfo[index].x0 = dataInputStream.readUnsignedByte();
                effAtutoTemp.imginfo[index].y0 = dataInputStream.readUnsignedByte();
                effAtutoTemp.imginfo[index].w = dataInputStream.readUnsignedByte();
                effAtutoTemp.imginfo[index].h = dataInputStream.readUnsignedByte();
            }
            effAtutoTemp.frameEffAuto = new Frame[dataInputStream.readShort()];
            for (int index1 = 0; index1 < effAtutoTemp.frameEffAuto.length; index1++) {
                effAtutoTemp.frameEffAuto[index1] = new Frame();
                byte byteValue = dataInputStream.readByte();
                effAtutoTemp.frameEffAuto[index1].dx = new short[byteValue];
                effAtutoTemp.frameEffAuto[index1].dy = new short[byteValue];
                effAtutoTemp.frameEffAuto[index1].idImg = new byte[byteValue];
                for (int index2 = 0; index2 < byteValue; index2++) {
                    effAtutoTemp.frameEffAuto[index1].dx[index2] = dataInputStream.readShort();
                    effAtutoTemp.frameEffAuto[index1].dy[index2] = dataInputStream.readShort();
                    effAtutoTemp.frameEffAuto[index1].idImg[index2] = dataInputStream.readByte();
                }
            }
            short shortValue = dataInputStream.readShort();
            effAtutoTemp.frameRunning = new short[shortValue];
            for (int index3 = 0; index3 < shortValue; index3++) {
                effAtutoTemp.frameRunning[index3] = dataInputStream.readShort();
            }
            return effAtutoTemp;
        } catch (Exception exception) {
            return null;
        }
    }

    public static void reciveImage(short id1, byte[] data) {
        MyImage myImage;
        if ((myImage = (MyImage) imgEffAuto.get(String.valueOf(id1))) == null) {
            myImage = new MyImage();
            imgEffAuto.put(String.valueOf(id1), myImage);
        }
        myImage.img = Controller.createImage(data);
        if (GameMidlet.CLIENT_TYPE != 1) {
            RMS.saveRMSImage("effauto " + id1, data);
        }
    }

    public static void checkTimeUseImg() {
        try {
            Enumeration enumeration = imgEffAuto.keys();
            while (enumeration.hasMoreElements()) {
                String text = (String) enumeration.nextElement();
                MyImage myImage = (MyImage) imgEffAuto.get(text);
                if (System.currentTimeMillis() - myImage.timeUse > 60000L) {
                    imgEffAuto.remove(text);
                }
            }
        } catch (Exception exception) {
        }
    }

    public static void checkTimeUseData() {
        try {
            Enumeration enumeration = dataEffAuto.keys();
            while (enumeration.hasMoreElements()) {
                String text = (String) enumeration.nextElement();
                EffAtutoTemp effAtutoTemp = (EffAtutoTemp) dataEffAuto.get(text);
                if (System.currentTimeMillis() - effAtutoTemp.timeUse > 600000L) {
                    dataEffAuto.remove(text);
                }
            }
        } catch (Exception exception) {
        }
    }
}
