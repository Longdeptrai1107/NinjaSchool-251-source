package nso;

import main.GameCanvas;

public final class Lightning extends Effect2 {

    private int[] color = new int[] { 16579837, 11188220 };

    private MyVector listPos = new MyVector();

    private MyVector[] list;

    private EPosition posangle;

    private long timeDel = 0L;

    private boolean isContinue = false;

    private boolean isRemove = true;

    private int tick = 0;

    private int cou = 0;

    private int dem = 0;

    private int aa = 7;

    public static void addLight(MyVector position, EPosition firstPos, boolean isContinue1, int color2) {
        Lightning lightning;
        (lightning = new Lightning()).color[1] = color2;
        for (int index = 0; index < position.size(); index++) {
            EPosition ePosition;
            if ((ePosition = (EPosition) position.elementAt(index)) != null && (Res.abs(ePosition.x - firstPos.x) >= 100 || Res.abs(ePosition.y - firstPos.y) >= 50)) {
                position.removeElementAt(index);
            }
        }
        lightning.setInfo(position, firstPos, true);
        Effect2.vEffect2.addElement(lightning);
    }

    public Lightning() {
    }

    private void setInfo(MyVector position, EPosition angle, boolean isContinue1) {
        if (position.size() != 0) {
            this.isContinue = isContinue1;
            if (!isContinue1) {
                MyVector entries = position;
                int count = position.size();
                for (int index = 0; index < count - 1; index++) {
                    EPosition ePosition = (EPosition) entries.elementAt(index);
                    for (int index2 = index + 1; index2 < count; index2++) {
                        EPosition ePosition3 = (EPosition) entries.elementAt(index2);
                        if (ePosition.x > ePosition3.x) {
                            entries.setElementAt(ePosition, index2);
                            entries.setElementAt(ePosition3, index);
                            ePosition = ePosition3;
                        }
                    }
                }
            }
            this.listPos = position;
            this.posangle = angle;
            this.list = new MyVector[position.size()];
            for (int index4 = 0; index4 < this.list.length; index4++) {
                this.list[index4] = new MyVector();
            }
            angle.follow = -1;
            this.list[0].addElement(angle);
            int value = -1;
            int value5 = 0;
            while (value5 < position.size()) {
                int value6 = angle.x;
                int value7 = angle.y;
                if (isContinue1 && value != -1) {
                    EPosition ePosition8;
                    value6 = (ePosition8 = (EPosition) position.elementAt(value)).x;
                    value7 = ePosition8.y;
                }
                if (!isContinue1) {
                    MyVector entries9 = position;
                    int value10 = 0;
                    for (int index11 = 0; index11 < entries9.size(); index11++) {
                        if (((EPosition) entries9.elementAt(index11)).index == -1) {
                            value10++;
                        }
                    }
                    int value12;
                    if (value10 != 0) {
                        value10 = Res.rnd(value10);
                        int value13 = 0;
                        int value14 = 0;
                        while (true) {
                            if (value14 >= entries9.size()) {
                                value12 = -1;
                                break;
                            }
                            EPosition ePosition15;
                            if ((ePosition15 = (EPosition) entries9.elementAt(value14)).index == -1) {
                                if (value10 == value13) {
                                    ePosition15.index = 0;
                                    value12 = value14;
                                    break;
                                }
                                value13++;
                            }
                            value14++;
                        }
                    } else {
                        value12 = -1;
                    }
                    value = value12;
                } else {
                    value++;
                }
                int value16 = this.list[value].size() - 1;
                EPosition ePosition17;
                int value18 = Res.angle((ePosition17 = (EPosition) position.elementAt(value)).x - value6, -(ePosition17.y - value7));
                int value19 = Res.rnd(15) + 10;
                int value20 = 0;
                int value21 = 0;
                while (true) {
                    value21 = 0;
                    if (value20 != 0) {
                        value21 = value18 - 5 + Res.rnd(10);
                    }
                    value21 = Res.fixangle(value21);
                    int value22 = value19 * value20 * Res.cos(value21) >> 10;
                    int value23 = -(value19 * value20 * Res.sin(value21)) >> 10;
                    EPosition ePosition24 = new EPosition(value6 + value22, value7 + value23, value16++);
                    this.list[value].addElement(ePosition24);
                    if (Res.distance(value6, value7, value6 + value22, value7 + value23) >= Res.distance(value6, value7, ePosition17.x, ePosition17.y) - 20) {
                        value5++;
                        break;
                    }
                    value20++;
                }
            }
            for (int index25 = 0; index25 < this.list.length; index25++) {
                int count26 = this.list[index25].size();
                EPosition ePosition27;
                (ePosition27 = (EPosition) position.elementAt(index25)).follow = (byte) (this.list[index25].size() - 1);
                ePosition27.index = -1;
                EPosition ePosition28;
                (ePosition28 = new EPosition(ePosition27.x, ePosition27.y, ePosition27.follow)).index = -1;
                this.list[index25].addElement(ePosition28);
                for (int index29 = 1; index29 < count26; index29++) {
                    EPosition ePosition30 = (EPosition) this.list[index25].elementAt(index29);
                    int value31 = Res.rnd(2);
                    for (int index32 = 0; index32 < value31; index32++) {
                        int value33 = 180 + Res.rnd(180);
                        int value34;
                        int value35 = (value34 = 5 + Res.rnd(10)) * Res.cos(Res.fixangle(value33)) >> 10;
                        value33 = -(value34 * Res.sin(Res.fixangle(value33))) >> 10;
                        (angle = new EPosition(ePosition30.x + value35, ePosition30.y + value33, index29)).index = 0;
                        this.list[index25].addElement(angle);
                    }
                }
            }
        }
    }

    public final void update() {
        if (this.posangle == null) {
            Effect2.vRemoveEffect2.addElement(this);
        } else {
            try {
                if (GameCanvas.gameTick % 2 == 1) {
                    this.posangle.follow = -1;
                    this.posangle.index = -1;
                    for (int index = 0; index < this.listPos.size(); index++) {
                        EPosition ePosition;
                        (ePosition = (EPosition) this.listPos.elementAt(index)).index = -1;
                        ePosition.follow = -1;
                    }
                    if (this.isContinue && this.isRemove && this.listPos.size() > 1 && System.currentTimeMillis() / 10L - this.timeDel > 30L) {
                        this.timeDel = System.currentTimeMillis() / 10L;
                        this.posangle = (EPosition) this.listPos.elementAt(0);
                        this.listPos.removeElementAt(0);
                    }
                    this.setInfo(this.listPos, this.posangle, this.isContinue);
                    if (this.tick > 3) {
                        this.aa = 7;
                        Effect2.vEffect2.removeElement(this);
                    }
                    this.tick++;
                    return;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public final void paint(mGraphics g) {
        this.dem = 0;
        this.cou++;
        if (this.cou >= 12) {
            this.cou = 0;
        }
        if (this.list != null) {
            for (int index = 0; index < this.list.length; index++) {
                for (int index1 = 0; index1 < this.list[index].size(); index1++) {
                    EPosition ePosition;
                    if ((ePosition = (EPosition) this.list[index].elementAt(index1)).follow >= 0 && ePosition.follow < this.list[index].size()) {
                        EPosition ePosition2 = (EPosition) this.list[index].elementAt(ePosition.follow);
                        if (GameCanvas.isPaint(ePosition.x, ePosition.y) && GameCanvas.isPaint(ePosition2.x, ePosition2.y)) {
                            EPosition ePosition3 = ePosition2;
                            EPosition ePosition4 = ePosition;
                            mGraphics graphics = g;
                            Lightning lightning = this;
                            graphics.setColor(lightning.color[0]);
                            graphics.drawLine(ePosition4.x, ePosition4.y, ePosition3.x, ePosition3.y);
                            if (ePosition4.index == -1) {
                                graphics.setColor(lightning.color[1]);
                                graphics.drawLine(ePosition4.x - 1, ePosition4.y, ePosition3.x - 1, ePosition3.y);
                                if (lightning.isContinue && lightning.isRemove) {
                                    graphics.drawLine(ePosition4.x + 1, ePosition4.y, ePosition3.x + 1, ePosition3.y);
                                }
                            }
                        }
                        if (this.isContinue && this.isRemove) {
                            this.dem++;
                            if (this.dem >= this.aa) {
                                this.aa += 7;
                                return;
                            }
                        }
                    }
                }
                EPosition ePosition5;
                (ePosition5 = (EPosition) this.listPos.elementAt(index)).count++;
                if (ePosition5.count >= 12) {
                    ePosition5.count = 0;
                }
            }
        }
    }
}
