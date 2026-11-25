package nso;

import java.util.Vector;
import main.GameCanvas;

public final class MonsterDart extends Effect2 {

    private int angle;

    private int vx;

    private int vy;

    private short va = 256;

    private int x;

    private int y;

    private int life;

    private boolean isSpeedUp = false;

    private int dame;

    private int dameMp;

    private int typeAtt;

    private Char c;

    private BuNhin b;

    private boolean isBoss;

    private int idBoss;

    private int countangle = 1;

    private static int level;

    private static Vector vDomsang = new Vector();

    private static int regMirro = 0;

    private int frame = 0;

    private int index;

    private static byte[] FRAME = new byte[] { 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0 };

    private static int[] TRANSFORM = new int[] { 0, 0, 0, 7, 6, 6, 6, 2, 2, 3, 3, 4, 5, 5, 5, 1 };

    private static int[] ARROWINDEX = new int[] { 0, 15, 37, 52, 75, 105, 127, 142, 165, 195, 217, 232, 255, 285, 307, 322, 345, 370 };

    private void setAngle(int angle) {
        this.angle = angle;
        this.vx = this.va * Res.cos(angle) >> 10;
        this.vy = this.va * Res.sin(angle) >> 10;
    }

    public static void addMonsterDart(int x1, int y2, boolean isBoss3, short levelBoss, int idBoss4, int dame5, int dameMp6, Char c7) {
        level = levelBoss;
        Effect2.vEffect2.addElement(new MonsterDart(x1, y2, isBoss3, levelBoss, idBoss4, dame5, dameMp6, c7));
    }

    public static void addMonsterDart(int x1, int y2, BuNhin b3) {
        Effect2.vEffect2.addElement(new MonsterDart(x1, y2, b3));
    }

    private MonsterDart(int x1, int y2, boolean isBoss3, short levelBoss, int idBoss4, int dame5, int dameMp6, Char c7) {
        this.typeAtt = 0;
        this.x = x1;
        this.y = y2;
        this.isBoss = isBoss3;
        this.idBoss = idBoss4;
        this.dame = dame5;
        this.dameMp = dameMp6;
        this.c = c7;
        if (isBoss3) {
            this.setAngle(this.countangle * 90);
            this.countangle++;
            if (this.countangle > 3) {
                this.countangle = 1;
                return;
            }
        } else {
            if (x1 > c7.cx) {
                this.setAngle(240);
                return;
            }
            this.setAngle(300);
        }
    }

    private MonsterDart(int x1, int y2, BuNhin b3) {
        this.typeAtt = 1;
        this.x = x1;
        this.y = y2;
        this.b = b3;
        if (x1 > b3.x) {
            this.setAngle(240);
        } else {
            this.setAngle(300);
        }
        this.va = 256;
        this.angle = 180;
        this.vx = this.va * Res.cos(this.angle) >> 10;
        this.vy = this.va * Res.sin(this.angle) >> 10;
    }

    public final void update() {
        if (level > 100) {
            Domsang domsang = new Domsang(this.x, this.y, 2);
            vDomsang.addElement(domsang);
        } else if (level > 50 && level <= 100) {
            Domsang domsang1 = new Domsang(this.x, this.y, 5);
            vDomsang.addElement(domsang1);
        } else if (level > 30 && level <= 50) {
            Domsang domsang2 = new Domsang(this.x, this.y, 4);
            vDomsang.addElement(domsang2);
        } else if (level > 0 && level <= 30) {
            Domsang domsang3 = new Domsang(this.x, this.y, 3);
            vDomsang.addElement(domsang3);
        }
        MonsterDart monsterDart = this;
        if (this.c != null) {
            int value = monsterDart.c.cx - monsterDart.x;
            int value4 = monsterDart.c.cy - (monsterDart.c.ch >> 1) - monsterDart.y;
            monsterDart.life++;
            if ((Res.abs(value) >= 16 || Res.abs(value4) >= 16) && monsterDart.life <= 60) {
                int value5;
                if (Math.abs((value5 = Res.angle(value, value4)) - monsterDart.angle) < 90 || value * value + value4 * value4 > 4096) {
                    if (Math.abs(value5 - monsterDart.angle) < 15) {
                        monsterDart.angle = value5;
                    } else if ((value5 - monsterDart.angle < 0 || value5 - monsterDart.angle >= 180) && value5 - monsterDart.angle >= -180) {
                        monsterDart.angle = Res.fixangle(monsterDart.angle - 15);
                    } else {
                        monsterDart.angle = Res.fixangle(monsterDart.angle + 15);
                    }
                }
                if (monsterDart.va < 8192) {
                    monsterDart.va = (short) (monsterDart.va + 1024);
                }
                monsterDart.vx = monsterDart.va * Res.cos(monsterDart.angle) >> 10;
                monsterDart.vy = monsterDart.va * Res.sin(monsterDart.angle) >> 10;
                int value6;
                value = (value6 = value + monsterDart.vx) >> 10;
                monsterDart.x += value;
                int value7;
                value4 = (value7 = value4 + monsterDart.vy) >> 10;
                monsterDart.y += value4;
                value = Res.angle(value, -value4);
                value4 = 0;
                byte byteValue;
                while (true) {
                    if (value4 >= nso.MonsterDart.ARROWINDEX.length - 1) {
                        byteValue = 0;
                        break;
                    }
                    if (value >= nso.MonsterDart.ARROWINDEX[value4] && value <= nso.MonsterDart.ARROWINDEX[value4 + 1]) {
                        byteValue = (byte) (value4 >= 16 ? 0 : value4);
                        break;
                    }
                    value4++;
                }
                monsterDart.index = byteValue;
                monsterDart.frame = FRAME[monsterDart.index];
                regMirro = nso.MonsterDart.TRANSFORM[monsterDart.index];
            }
        }
        int value8 = 0;
        int value9 = 0;
        if (this.typeAtt != 0) {
            if (this.typeAtt == 1) {
                value8 = this.b.x - this.x;
                value9 = this.b.y - 10 - this.y;
                this.life++;
                if (Res.abs(value8) < 16 && Res.abs(value9) < 16 || this.life > 60) {
                    BuNhin buNhin = this.b;
                    this.b.isInjure = true;
                    Effect2.vEffect2.removeElement(this);
                    return;
                }
            }
        } else {
            value8 = this.c.cx - this.x;
            value9 = this.c.cy - 10 - this.y;
            this.life++;
            if (this.c.statusMe == 5 || this.c.statusMe == 14) {
                this.x = this.x + (this.c.cx - this.x) / 2;
                this.y = this.y + (this.c.cy - this.y) / 2;
            }
            if (Res.abs(value8) < 16 && Res.abs(value9) < 16 || this.life > 60) {
                this.c.doInjure(this.dame, this.dameMp, this.isBoss, this.idBoss);
                Effect2.vEffect2.removeElement(this);
                return;
            }
        }
        int value10;
        if (Math.abs((value10 = Res.angle(value8, value9)) - this.angle) < 90 || value8 * value8 + value9 * value9 > 4096) {
            if (Math.abs(value10 - this.angle) < 15) {
                this.angle = value10;
            } else if ((value10 - this.angle < 0 || value10 - this.angle >= 180) && value10 - this.angle >= -180) {
                this.angle = Res.fixangle(this.angle - 15);
            } else {
                this.angle = Res.fixangle(this.angle + 15);
            }
        }
        int value11;
        int value12 = (value11 = value8 + this.vx) >> 10;
        this.x += value12;
        int value13;
        int value14 = (value13 = value9 + this.vy) >> 10;
        this.y += value14;
        for (int index = 0; index < vDomsang.size(); index++) {
            Domsang domsang15;
            (domsang15 = (Domsang) vDomsang.elementAt(index)).update();
            if (domsang15.frame > 3) {
                vDomsang.removeElementAt(index);
            }
        }
    }

    public final void paint(mGraphics g) {
        if (this.isBoss) {
            int value = 7;
            value = GameCanvas.gameTick % value;
            if (this.idBoss == 114) {
                if (value < 4) {
                    SmallImage.drawSmallImage(g, 1299, this.x, this.y, 0, 3);
                    return;
                }
                SmallImage.drawSmallImage(g, 1307, this.x, this.y, 0, 3);
                return;
            }
            if (this.idBoss == 115) {
                int value1 = 20;
                if ((value1 = GameCanvas.gameTick % value1) < 4) {
                    SmallImage.drawSmallImage(g, 1379, this.x, this.y, 0, 3);
                    return;
                }
                if (value1 < 8) {
                    SmallImage.drawSmallImage(g, 1380, this.x, this.y, 0, 3);
                    return;
                }
                if (value1 < 12) {
                    SmallImage.drawSmallImage(g, 1379, this.x, this.y, 0, 3);
                    return;
                }
                if (value1 < 16) {
                    SmallImage.drawSmallImage(g, 1382, this.x, this.y, 0, 3);
                    return;
                }
            } else if (this.idBoss == 116) {
                int value2 = 17;
                if ((value2 = GameCanvas.gameTick % value2) < 4) {
                    SmallImage.drawSmallImage(g, 1399, this.x, this.y, 0, 3);
                    return;
                }
                if (value2 < 8) {
                    SmallImage.drawSmallImage(g, 1400, this.x, this.y, 0, 3);
                    return;
                }
                if (value2 < 12) {
                    SmallImage.drawSmallImage(g, 1401, this.x, this.y, 0, 3);
                    return;
                }
                if (value2 < 16) {
                    SmallImage.drawSmallImage(g, 1402, this.x, this.y, 0, 3);
                    return;
                }
            } else if (this.idBoss == 139) {
                int value3 = 20;
                if ((value3 = GameCanvas.gameTick % value3) < 4) {
                    SmallImage.drawSmallImage(g, 1459, this.x, this.y, 0, 3);
                    return;
                }
                if (value3 < 8) {
                    SmallImage.drawSmallImage(g, 1380, this.x, this.y, 0, 3);
                    return;
                }
                if (value3 < 12) {
                    SmallImage.drawSmallImage(g, 1461, this.x, this.y, 0, 3);
                    return;
                }
                if (value3 < 16) {
                    SmallImage.drawSmallImage(g, 1382, this.x, this.y, 0, 3);
                    return;
                }
            } else if (this.idBoss == 144 || this.idBoss == 163) {
                int value4 = 20;
                if ((value4 = GameCanvas.gameTick % value4) < 4) {
                    SmallImage.drawSmallImage(g, 1459, this.x, this.y, 0, 3);
                    return;
                }
                if (value4 < 8) {
                    SmallImage.drawSmallImage(g, 1380, this.x, this.y, 0, 3);
                    return;
                }
                if (value4 < 12) {
                    SmallImage.drawSmallImage(g, 1461, this.x, this.y, 0, 3);
                    return;
                }
                if (value4 < 16) {
                    SmallImage.drawSmallImage(g, 1382, this.x, this.y, 0, 3);
                    return;
                }
            }
        } else {
            if (level > 100) {
                g.drawRegion(GameScr.imgEffMob, 0, this.frame * 23, 31, 23, regMirro, this.x, this.y, 0);
            } else if (level > 50 && level <= 100) {
                g.drawRegion(GameScr.imgEffMob, 0, 0, 14, 14, regMirro, this.x, this.y, 0);
            } else if (level > 30 && level <= 50) {
                g.drawRegion(GameScr.imgEffMob, 0, 0, 8, 8, regMirro, this.x, this.y, 0);
            } else if (level > 0 && level <= 30) {
                g.drawRegion(GameScr.imgEffMob, 0, 0, 8, 8, regMirro, this.x, this.y, 0);
            }
            for (int index = 0; index < vDomsang.size(); index++) {
                Domsang domsang;
                if ((domsang = (Domsang) vDomsang.elementAt(index)) != null) {
                    domsang.paint(g);
                }
            }
        }
    }
}
