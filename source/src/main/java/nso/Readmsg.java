package nso;

public final class Readmsg {

    public Readmsg() {
    }

    public final void onVithuInfo(Message msg) {
        try {
            switch(msg.reader().readByte()) {
                case 0:
                    Message message = msg;
                    try {
                        Char character = null;
                        int value = message.reader().readInt();
                        if (Char.getMyChar().charID == value) {
                            character = Char.getMyChar();
                        } else {
                            character = GameScr.findCharInMap(value);
                        }
                        if (character != null) {
                            character.arrItemViThu = new Item[5];
                            for (int index = 0; index < character.arrItemViThu.length; index++) {
                                short shortValue;
                                if ((shortValue = message.reader().readShort()) > -1) {
                                    character.arrItemViThu[index] = new Item();
                                    character.arrItemViThu[index].indexUI = index;
                                    character.arrItemViThu[index].typeUI = 51;
                                    character.arrItemViThu[index].template = ItemTemplates.get(shortValue);
                                    character.arrItemViThu[index].upgrade = message.reader().readByte();
                                    character.arrItemViThu[index].expires = message.reader().readLong();
                                    character.arrItemViThu[index].sys = message.reader().readByte();
                                    byte byteValue = message.reader().readByte();
                                    character.arrItemViThu[index].options = new MyVector();
                                    for (int index1 = 0; index1 < byteValue; index1++) {
                                        character.arrItemViThu[index].options.addElement(new ItemOption(message.reader().readUnsignedByte(), message.reader().readInt()));
                                    }
                                }
                            }
                        }
                        break;
                    } catch (Exception exception) {
                        return;
                    }
                case 1:
                    Message message2 = msg;
                    try {
                        Char character3 = null;
                        int value4 = message2.reader().readInt();
                        if (Char.getMyChar().charID == value4) {
                            character3 = Char.getMyChar();
                        } else {
                            character3 = GameScr.findCharInMap(value4);
                        }
                        if (character3 != null) {
                            short shortValue5 = message2.reader().readShort();
                            byte byteValue6 = message2.reader().readByte();
                            if (shortValue5 > 0) {
                                short shortValue7 = (short) character3.cx;
                                short shortValue8 = (short) (character3.cy - 40);
                                character3.mobVithu = new Mob((short) -1, false, false, false, false, false, shortValue5, 1, 0, 0, 0, shortValue7, shortValue8, (byte) 4, (byte) 0, byteValue6 != 0, false);
                                character3.mobVithu.status = 5;
                            } else {
                                character3.mobVithu = null;
                            }
                        }
                        break;
                    } catch (Exception exception18) {
                        exception18.printStackTrace();
                        return;
                    }
                case 2:
                    msg = msg;
                    try {
                        short shortValue9 = msg.reader().readShort();
                        String text = msg.reader().readUTF();
                        int value10 = msg.reader().readInt();
                        short shortValue11 = msg.reader().readShort();
                        byte byteValue12 = msg.reader().readByte();
                        if (value10 >= 0) {
                            short shortValue13 = shortValue9;
                            int value14 = 0;
                            TimecountDown timecountDown;
                            while (true) {
                                if (value14 >= GameScr.VecTime.size()) {
                                    timecountDown = null;
                                    break;
                                }
                                TimecountDown timecountDown15;
                                if ((timecountDown15 = (TimecountDown) GameScr.VecTime.elementAt(value14)) != null && timecountDown15.id == shortValue13) {
                                    timecountDown = timecountDown15;
                                    break;
                                }
                                value14++;
                            }
                            TimecountDown timecountDown16 = timecountDown;
                            int value17 = value10;
                            if (timecountDown16 == null) {
                                timecountDown16 = new TimecountDown(shortValue9, shortValue11, value17, text, byteValue12);
                                GameScr.VecTime.addElement(timecountDown16);
                            }
                            if (timecountDown16 != null) {
                                timecountDown16.tile = text;
                                timecountDown16.idIcon = shortValue11;
                                long longValue = value17;
                                timecountDown16.mysecond = System.currentTimeMillis() + longValue * 1000L;
                                if (byteValue12 == -2) {
                                    timecountDown16.wantdestroy = true;
                                    break;
                                }
                            }
                        }
                    } catch (Exception exception19) {
                    }
                    return;
                default:
                    return;
            }
        } catch (Exception exception20) {
        }
    }
}
