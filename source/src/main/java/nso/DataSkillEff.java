package nso;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public final class DataSkillEff {

    public long timeRemove;

    public MyVector listFrame = new MyVector();

    private SmallImage[] smallImage;

    private byte[][] frameChar;

    public byte[] sequence;

    private byte Frame;

    private byte f;

    public boolean isLoadData;

    public short idEff;

    private byte typeupdate;

    private byte[] indexSplash;

    private boolean isHorse;

    public boolean isHead;

    public byte[] ActionStand;

    public byte[] ActionMove;

    public byte[] ActionJum;

    public byte[] ActionFall;

    public byte[] FrameChar;

    public byte[] Dx_Char;

    public byte[] Dy_Char;

    public byte nHorseFrame;

    public byte dxHorse;

    public byte dyHorse;

    private MyVector actorFrameBuffer;

    private MyVector standFrameBuffer;

    private MyVector moveFrameBuffer;

    private MyVector jumpFrameBuffer;

    private MyVector fallFrameBuffer;

    private MyVector charOffsetXBuffer;

    private MyVector charOffsetYBuffer;

    public long timelive;

    private long timeWait;

    public int miliSecondWait;

    public boolean wantDetroy;

    private boolean wait;

    static {
        new mHashtable();
    }

    public DataSkillEff() {
        new MyVector();
        this.frameChar = new byte[4][];
        new MyVector();
        this.idEff = 0;
        this.typeupdate = 0;
        this.indexSplash = new byte[4];
        this.isHead = false;
        this.actorFrameBuffer = new MyVector();
        this.standFrameBuffer = new MyVector();
        this.moveFrameBuffer = new MyVector();
        this.jumpFrameBuffer = new MyVector();
        this.fallFrameBuffer = new MyVector();
        this.charOffsetXBuffer = new MyVector();
        this.charOffsetYBuffer = new MyVector();
        new MyVector();
    }

    public DataSkillEff(short id, boolean isEff) {
        new MyVector();
        this.frameChar = new byte[4][];
        new MyVector();
        this.idEff = 0;
        this.typeupdate = 0;
        this.indexSplash = new byte[4];
        this.isHead = false;
        this.actorFrameBuffer = new MyVector();
        this.standFrameBuffer = new MyVector();
        this.moveFrameBuffer = new MyVector();
        this.jumpFrameBuffer = new MyVector();
        this.fallFrameBuffer = new MyVector();
        this.charOffsetXBuffer = new MyVector();
        this.charOffsetYBuffer = new MyVector();
        new MyVector();
        this.idEff = id;
        this.isHorse = isEff;
        this.loadnew(null);
    }

    private void loadnew(byte[] data) {
        try {
            PacketBuffer packetBuffer;
            if ((packetBuffer = (PacketBuffer) GameData.listbyteData.get("" + this.idEff)) != null && packetBuffer.data != null) {
                data = packetBuffer.data;
            }
            if (packetBuffer == null) {
                packetBuffer = new PacketBuffer();
                GameData.listbyteData.put("" + this.idEff, packetBuffer);
                Service.gI().doGetByteData(this.idEff);
                System.currentTimeMillis();
            }
            if (data != null && data.length > 0) {
                this.loadData(data);
                return;
            }
        } catch (Exception exception) {
        }
    }

    private void loadData(byte[] array) {
        if (array != null) {
            DataInputStream dataInputStream = null;
            try {
                this.listFrame.removeAllElements();
                this.smallImage = null;
                byte byteValue = (dataInputStream = new DataInputStream(new ByteArrayInputStream(array))).readByte();
                this.smallImage = new SmallImage[byteValue];
                for (int index = 0; index < byteValue; index++) {
                    this.smallImage[index] = new SmallImage(dataInputStream.readUnsignedByte(), dataInputStream.readUnsignedByte(), dataInputStream.readUnsignedByte(), dataInputStream.readUnsignedByte(), dataInputStream.readUnsignedByte());
                }
                short shortValue = dataInputStream.readShort();
                for (int index1 = 0; index1 < shortValue; index1++) {
                    byte byteValue2 = dataInputStream.readByte();
                    MyVector entries = new MyVector();
                    MyVector entries3 = new MyVector();
                    for (int index4 = 0; index4 < byteValue2; index4++) {
                        PartFrame partFrame;
                        (partFrame = new PartFrame(dataInputStream.readShort(), dataInputStream.readShort(), dataInputStream.readByte())).flip = dataInputStream.readByte();
                        partFrame.onTop = dataInputStream.readByte();
                        if (partFrame.onTop == 0) {
                            entries.addElement(partFrame);
                        } else {
                            entries3.addElement(partFrame);
                        }
                    }
                    this.listFrame.addElement(new FrameEff(entries, entries3));
                }
                short shortValue5 = (short) dataInputStream.readUnsignedByte();
                this.sequence = new byte[shortValue5];
                int value = 0;
                for (int index6 = 0; index6 < shortValue5; index6++) {
                    this.sequence[index6] = (byte) dataInputStream.readShort();
                    if (this.isHorse) {
                        if (value == 2 && this.sequence[index6] != -1) {
                            this.actorFrameBuffer.addElement(String.valueOf(this.sequence[index6]));
                        }
                        if (value == 3 && this.sequence[index6] != -1) {
                            this.standFrameBuffer.addElement(String.valueOf(this.sequence[index6]));
                        }
                        if (value == 4 && this.sequence[index6] != -1) {
                            this.moveFrameBuffer.addElement(String.valueOf(this.sequence[index6]));
                        }
                        if (value == 5 && this.sequence[index6] != -1) {
                            this.jumpFrameBuffer.addElement(String.valueOf(this.sequence[index6]));
                        }
                        if (value == 6 && this.sequence[index6] != -1) {
                            this.fallFrameBuffer.addElement(String.valueOf(this.sequence[index6]));
                        }
                        if (value == 7 && this.sequence[index6] != -1) {
                            this.charOffsetXBuffer.addElement(String.valueOf(this.sequence[index6]));
                        }
                        if (value == 8 && this.sequence[index6] != -1) {
                            this.charOffsetYBuffer.addElement(String.valueOf(this.sequence[index6]));
                        }
                        if (this.sequence[index6] == -1) {
                            value++;
                        }
                    }
                }
                if (this.isHorse) {
                    this.nHorseFrame = this.sequence[0];
                    this.dxHorse = this.sequence[2];
                    this.dyHorse = this.sequence[3];
                    this.FrameChar = vector2arr(this.actorFrameBuffer);
                    this.ActionStand = vector2arr(this.standFrameBuffer);
                    this.ActionMove = vector2arr(this.moveFrameBuffer);
                    this.ActionJum = vector2arr(this.jumpFrameBuffer);
                    this.ActionFall = vector2arr(this.fallFrameBuffer);
                    this.Dx_Char = vector2arr(this.charOffsetXBuffer);
                    if (this.Dx_Char == null || this.Dx_Char.length == 0) {
                        this.Dx_Char = new byte[this.nHorseFrame];
                    }
                    this.Dy_Char = vector2arr(this.charOffsetYBuffer);
                    if (this.Dy_Char == null || this.Dy_Char.length == 0) {
                        this.Dy_Char = new byte[this.nHorseFrame];
                    }
                    this.actorFrameBuffer.removeAllElements();
                    this.standFrameBuffer.removeAllElements();
                    this.moveFrameBuffer.removeAllElements();
                    this.jumpFrameBuffer.removeAllElements();
                    this.fallFrameBuffer.removeAllElements();
                    this.charOffsetXBuffer.removeAllElements();
                    this.charOffsetYBuffer.removeAllElements();
                }
                dataInputStream.readByte();
                byte byteValue7 = dataInputStream.readByte();
                this.frameChar[0] = new byte[byteValue7];
                for (int index8 = 0; index8 < byteValue7; index8++) {
                    this.frameChar[0][index8] = dataInputStream.readByte();
                }
                byteValue7 = dataInputStream.readByte();
                this.frameChar[1] = new byte[byteValue7];
                for (int index9 = 0; index9 < byteValue7; index9++) {
                    this.frameChar[1][index9] = dataInputStream.readByte();
                }
                byteValue7 = dataInputStream.readByte();
                this.frameChar[3] = new byte[byteValue7];
                for (int index10 = 0; index10 < byteValue7; index10++) {
                    this.frameChar[3][index10] = dataInputStream.readByte();
                }
                this.isLoadData = true;
                try {
                    this.indexSplash[0] = (byte) (this.frameChar[0].length - 7);
                    this.indexSplash[1] = (byte) (this.frameChar[1].length - 7);
                    this.indexSplash[2] = (byte) (this.frameChar[3].length - 7);
                    this.indexSplash[3] = (byte) (this.frameChar[3].length - 7);
                } catch (Exception exception) {
                }
                this.indexSplash[0] = dataInputStream.readByte();
                this.indexSplash[1] = dataInputStream.readByte();
                this.indexSplash[2] = dataInputStream.readByte();
                this.indexSplash[3] = this.indexSplash[2];
            } catch (Exception exception11) {
            } finally {
                try {
                    dataInputStream.close();
                } catch (Exception exception12) {
                }
            }
        }
    }

    public DataSkillEff(short id, long timelive1, int miliSecondWait2, boolean isHead) {
        new MyVector();
        this.frameChar = new byte[4][];
        new MyVector();
        this.idEff = 0;
        this.typeupdate = 0;
        this.indexSplash = new byte[4];
        this.isHead = false;
        this.actorFrameBuffer = new MyVector();
        this.standFrameBuffer = new MyVector();
        this.moveFrameBuffer = new MyVector();
        this.jumpFrameBuffer = new MyVector();
        this.fallFrameBuffer = new MyVector();
        this.charOffsetXBuffer = new MyVector();
        this.charOffsetYBuffer = new MyVector();
        new MyVector();
        this.idEff = id;
        this.timelive = timelive1;
        this.miliSecondWait = miliSecondWait2;
        this.isHead = isHead;
        this.loadnew(null);
        if (timelive1 == -1L) {
            this.typeupdate = 3;
        } else if (timelive1 == 0L) {
            this.typeupdate = 1;
        } else {
            this.timelive = this.timelive + System.currentTimeMillis();
            this.typeupdate = 2;
        }
    }

    public final void setTypeEff(long timelive1) {
        if (timelive1 == -1L) {
            this.typeupdate = 3;
        } else if (timelive1 == 0L) {
            this.typeupdate = 1;
        } else {
            this.typeupdate = 2;
        }
    }

    private static byte[] vector2arr(MyVector entries) {
        byte[] data = null;
        data = new byte[entries.size()];
        for (int index = 0; index < data.length; index++) {
            data[index] = Byte.parseByte((String) entries.elementAt(index));
        }
        return (byte[]) data;
    }

    private boolean isHavedata() {
        if (this.isLoadData) {
            return true;
        }
        this.loadnew(null);
        return false;
    }

    public final void paintBottomEff_new(mGraphics graphics, int value, int value1, int value2, int value3) {
        if (this.isHavedata()) {
            if (value2 < this.listFrame.size()) {
                FrameEff frameEff = (FrameEff) this.listFrame.elementAt(value2);
                try {
                    MyVector entries = frameEff.listPartBottom;
                    for (int index = 0; index < entries.size(); index++) {
                        PartFrame partFrame = (PartFrame) entries.elementAt(index);
                        SmallImage smallImage4 = this.smallImage[partFrame.idSmallImg];
                        ImageIcon imageIcon;
                        if ((imageIcon = GameData.getImgIcon((short) this.idEff)) != null && imageIcon.img != null) {
                            int value5 = partFrame.dx;
                            int value6 = smallImage4.w;
                            int value7 = smallImage4.h;
                            short shortValue = smallImage4.x;
                            short shortValue8 = smallImage4.y;
                            int value9 = imageIcon.img.getWidth();
                            int value10 = imageIcon.img.getHeight();
                            if (shortValue > value9) {
                                shortValue = 0;
                            }
                            if (shortValue8 > value10) {
                                shortValue8 = 0;
                            }
                            if (shortValue + value6 > value9) {
                                value6 = value9 - shortValue;
                            }
                            if (shortValue8 + value7 > value10) {
                                value7 = value10 - shortValue8;
                            }
                            value9 = partFrame.flip == 1 ? 2 : 0;
                            if (value3 == 2 || value3 == 6) {
                                if (value9 == 2) {
                                    value9 = 0;
                                } else {
                                    value9 = 2;
                                }
                                value5 = -(value5 + value6);
                            }
                            graphics.drawRegion(imageIcon.img, shortValue, shortValue8, value6, value7, value9, value + value5, value1 + partFrame.dy, 0);
                        }
                    }
                    return;
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public final void paintTopEff_new(mGraphics graphics, int value, int value1, int value2, int value3) {
        if (this.isHavedata()) {
            if (value2 < this.listFrame.size()) {
                FrameEff frameEff = (FrameEff) this.listFrame.elementAt(value2);
                try {
                    MyVector entries = frameEff.listPartTop;
                    for (int index = 0; index < entries.size(); index++) {
                        PartFrame partFrame = (PartFrame) entries.elementAt(index);
                        SmallImage smallImage4 = this.smallImage[partFrame.idSmallImg];
                        ImageIcon imageIcon;
                        if ((imageIcon = GameData.getImgIcon((short) this.idEff)) != null && imageIcon.img != null) {
                            int value5 = partFrame.dx;
                            int value6 = smallImage4.w;
                            int value7 = smallImage4.h;
                            short shortValue = smallImage4.x;
                            short shortValue8 = smallImage4.y;
                            int value9 = imageIcon.img.getWidth();
                            int value10 = imageIcon.img.getHeight();
                            if (shortValue > value9) {
                                shortValue = 0;
                            }
                            if (shortValue8 > value10) {
                                shortValue8 = 0;
                            }
                            if (shortValue + value6 > value9) {
                                value6 = value9 - shortValue;
                            }
                            if (shortValue8 + value7 > value10) {
                                value7 = value10 - shortValue8;
                            }
                            value9 = partFrame.flip == 1 ? 2 : 0;
                            if (value3 == 2 || value3 == 6) {
                                if (value9 == 2) {
                                    value9 = 0;
                                } else {
                                    value9 = 2;
                                }
                                value5 = -(value5 + value6);
                            }
                            graphics.drawRegion(imageIcon.img, shortValue, shortValue8, value6, value7, value9, value + value5, value1 + partFrame.dy, 0);
                        }
                    }
                    return;
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public final void paintTopEff(mGraphics graphics, int value, int value1) {
        try {
            if (!this.isHavedata()) {
                return;
            }
            if (this.wait) {
                return;
            }
            if (this.Frame < this.listFrame.size()) {
                MyVector entries = ((FrameEff) this.listFrame.elementAt(this.Frame)).listPartTop;
                for (int index = 0; index < entries.size(); index++) {
                    PartFrame partFrame = (PartFrame) entries.elementAt(index);
                    SmallImage smallImage2 = this.smallImage[partFrame.idSmallImg];
                    ImageIcon imageIcon;
                    if ((imageIcon = GameData.getImgIcon((short) this.idEff)) != null && imageIcon.img != null) {
                        short shortValue = partFrame.dx;
                        int value3 = smallImage2.w;
                        int value4 = smallImage2.h;
                        short shortValue5 = smallImage2.x;
                        short shortValue6 = smallImage2.y;
                        if (shortValue5 > imageIcon.img.getWidth()) {
                            shortValue5 = 0;
                        }
                        if (shortValue6 > imageIcon.img.getHeight()) {
                            shortValue6 = 0;
                        }
                        if (shortValue5 + value3 > imageIcon.img.getWidth()) {
                            value3 = imageIcon.img.getWidth() - shortValue5;
                        }
                        if (shortValue6 + value4 > imageIcon.img.getHeight()) {
                            value4 = imageIcon.img.getHeight() - shortValue6;
                        }
                        graphics.drawRegion(imageIcon.img, shortValue5, shortValue6, value3, value4, partFrame.flip == 1 ? 2 : 0, value + shortValue, value1 + partFrame.dy, 0);
                    }
                }
                return;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.err.println("Err DataSkillEff  paintBottomEff:" + this.idEff);
        }
    }

    public final void paintBottomEff(mGraphics graphics, int value, int value1) {
        try {
            if (!this.isHavedata()) {
                return;
            }
            if (this.wait) {
                return;
            }
            if (this.Frame < this.listFrame.size()) {
                MyVector entries = ((FrameEff) this.listFrame.elementAt(this.Frame)).listPartBottom;
                for (int index = 0; index < entries.size(); index++) {
                    PartFrame partFrame = (PartFrame) entries.elementAt(index);
                    SmallImage smallImage2 = this.smallImage[partFrame.idSmallImg];
                    ImageIcon imageIcon;
                    if ((imageIcon = GameData.getImgIcon((short) this.idEff)) != null && imageIcon.img != null) {
                        short shortValue = partFrame.dx;
                        int value3 = smallImage2.w;
                        int value4 = smallImage2.h;
                        short shortValue5 = smallImage2.x;
                        short shortValue6 = smallImage2.y;
                        if (shortValue5 > imageIcon.img.getWidth()) {
                            shortValue5 = 0;
                        }
                        if (shortValue6 > imageIcon.img.getHeight()) {
                            shortValue6 = 0;
                        }
                        if (shortValue5 + value3 > imageIcon.img.getWidth()) {
                            value3 = imageIcon.img.getWidth() - shortValue5;
                        }
                        if (shortValue6 + value4 > imageIcon.img.getHeight()) {
                            value4 = imageIcon.img.getHeight() - shortValue6;
                        }
                        graphics.drawRegion(imageIcon.img, shortValue5, shortValue6, value3, value4, partFrame.flip == 1 ? 2 : 0, value + shortValue, value1 + partFrame.dy, 0);
                    }
                }
                return;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.err.println("Err DataSkillEff  paintBottomEff:" + this.idEff);
        }
    }

    private void setWait(boolean iss) {
        if (this.miliSecondWait > 0) {
            this.wait = iss;
            if (this.wait) {
                this.timeWait = System.currentTimeMillis() + this.miliSecondWait;
                return;
            }
        } else {
            this.wait = false;
        }
    }

    public final void update() {
        if (this.listFrame.size() > 0) {
            try {
                if (!this.wait) {
                    switch(this.typeupdate) {
                        case 0:
                            this.f++;
                            if (this.f > this.sequence.length) {
                                this.wantDetroy = true;
                                this.f = 0;
                            }
                            this.Frame = this.sequence[this.f];
                            return;
                        case 1:
                            this.f++;
                            if (this.f > this.sequence.length) {
                                this.f = 0;
                                this.wantDetroy = true;
                            }
                            this.Frame = this.sequence[this.f];
                            return;
                        case 2:
                            this.f++;
                            if (this.timelive - System.currentTimeMillis() < 0L) {
                                this.wantDetroy = true;
                            }
                            if (this.f > this.sequence.length) {
                                this.f = 0;
                            }
                            this.Frame = this.sequence[this.f];
                            return;
                        case 3:
                            this.f++;
                            if (this.f > this.sequence.length) {
                                this.f = 0;
                                this.setWait(true);
                            }
                            this.Frame = this.sequence[this.f];
                            return;
                        default:
                            return;
                    }
                }
                if (this.timeWait - System.currentTimeMillis() < 0L) {
                    this.setWait(false);
                    return;
                }
            } catch (Exception exception) {
            }
        }
    }
}
