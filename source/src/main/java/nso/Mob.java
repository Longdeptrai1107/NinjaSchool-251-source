package nso;

import javax.microedition.lcdui.Image;
import main.GameCanvas;

public final class Mob extends MainObject {

    public static MobTemplate[] arrMobTemplate;

    public int hp;

    public int maxHp;

    public int x;

    public int y;

    private int frame;

    public int dir = 1;

    private int dirV = 1;

    public int status;

    private int p1;

    private int p2;

    private int p3;

    public int xFirst;

    public int yFirst;

    public int w;

    public int h;

    private int timeStatus;

    public short mobId;

    public boolean isDisable;

    public boolean isDontMove;

    public boolean isFire;

    public boolean isIce;

    public boolean isWind;

    private MyVector vMobMove = new MyVector();

    public int templateId;

    private Char cFocus;

    private BuNhin bFocus;

    public int dame;

    public int dameMp;

    public int sys;

    private int typeAtt;

    public short levelBoss;

    public short level;

    private boolean isBoss;

    private long timeStartDie = 0L;

    private int frameIndex = 0;

    public static Char interestChar;

    public static MyVector vEggMonter = new MyVector();

    private static EggMonters egg;

    private static long timewait;

    private boolean removeWhenDie;

    public boolean isBusyAttackSomeOne = true;

    private long timeCurrent;

    public Char owner;

    private boolean isright;

    private boolean isleft;

    public Char injureBy;

    public boolean injureThenDie;

    private Mob mobToAttack;

    private Char charToAttack;

    private short idSkill_atk;

    private byte typeAtk;

    private byte typeTool;

    private byte indexlongden;

    private static byte[][] idframe = new byte[][] { { 3, 4, 5, 6 }, new byte[1], { 2, 2, 2, 2, 3, 3, 3, 3 }, { 0, 1 }, { 0, 1 }, { 3, 4, 5 }, new byte[1], { 3, 3, 4, 4, 5, 5 }, new byte[1], { 3, 4, 5 }, { 0, 1, 2, 3, 4 }, { 3, 4, 5 }, { 4, 5, 6 }, new byte[1], { 0, 1 }, { 0, 1 }, { 3, 3, 4, 4, 5, 5 }, { 0, 1, 2 }, { 0, 1, 2 }, { 5, 6, 7, 8 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 3, 4, 5, 6 }, { 0, 1, 2 }, { 0, 1, 2, 3 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, { 0, 1, 2 }, new byte[1], new byte[1], new byte[1], new byte[1], { 0, 1, 2 }, new byte[1], new byte[1], { 0, 0, 1, 1, 2, 2 }, { 0, 0, 1, 1, 2, 2, 3, 3, 4, 4 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 1 }, { 0, 1 }, new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1] };

    private static byte[][] idframeAppear = new byte[][] { { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1] };

    private static byte[][] idframeDisappear = new byte[][] { { 5, 4, 3, 2, 1 }, new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], { 5, 4, 3, 2, 1 }, { 5, 4, 3, 2, 1 }, { 5, 4, 3, 2, 1 }, new byte[0], { 5, 4, 3, 2, 1 }, new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], new byte[0], { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1], new byte[1] };

    private int bossMoveFrameIndex;

    public Mob(short mobId1, boolean isDisable2, boolean isDontMove3, boolean isFire4, boolean isIce5, boolean isWind6, int templateId7, int sys8, int hp9, int level10, int maxhp, short pointx, short pointy, byte status11, byte levelBoss12, boolean isBos, boolean removeWhenDie) {
        byte[] data = new byte[] { -1, 1 };
        this.injureThenDie = false;
        this.indexlongden = -1;
        this.bossMoveFrameIndex = 0;
        this.isDisable = isDisable2;
        this.isDontMove = isDontMove3;
        this.isFire = isFire4;
        this.isIce = isIce5;
        this.isWind = isWind6;
        this.sys = sys8;
        this.mobId = mobId1;
        this.templateId = templateId7;
        this.hp = hp9;
        this.level = (short) level10;
        this.xFirst = this.x = pointx;
        this.yFirst = this.y = pointy;
        if (templateId7 != 168 && templateId7 != 179 && templateId7 != 175 && templateId7 != 177 && templateId7 != 202) {
            this.status = status11;
        } else {
            this.status = 8;
        }
        this.maxHp = maxhp;
        this.levelBoss = levelBoss12;
        this.isBoss = isBos;
        if (templateId7 == 202) {
            egg = new EggMonters(this.xFirst, this.yFirst - 100);
            vEggMonter.addElement(egg);
            EggMonters.ownerEgg = this;
        }
        if (arrMobTemplate[templateId7].imgs == null) {
            arrMobTemplate[templateId7].imgs = new Image[0];
            Service.gI().requestModTemplate(templateId7);
        }
        timewait = Res.random(2000, 3500);
        this.removeWhenDie = removeWhenDie;
    }

    public final void updateMobAttack() {
        Mob mob = this;
        boolean flag;
        if (arrMobTemplate[mob.templateId] == null) {
            flag = false;
        } else if (arrMobTemplate[mob.templateId].imgs == null) {
            flag = false;
        } else {
            label979: {
                if (!mob.isBoss) {
                    if (mob.frame >= arrMobTemplate[mob.templateId].imgs.length) {
                        flag = false;
                        break label979;
                    }
                    if (arrMobTemplate[mob.templateId].imgs[mob.frame] == null) {
                        flag = false;
                        break label979;
                    }
                }
                flag = mob.status != 0;
            }
        }
        if (flag) {
            if (this.cFocus == null && (this.templateId == 168 || this.templateId == 179 || this.templateId == 175)) {
                this.status = 8;
            }
            if (this.vMobMove != null || arrMobTemplate[this.templateId].rangeMove == 0) {
                if (this.status != 3 && this.isBusyAttackSomeOne) {
                    if (this.cFocus != null) {
                        this.cFocus.doInjure(this.dame, this.dameMp, this.isBoss, this.getTemplate().mobTemplateId);
                        this.cFocus = null;
                    }
                    this.isBusyAttackSomeOne = false;
                }
                if (this.hp <= 0 && this.mobId != -1) {
                    this.status = 1;
                }
                label958: switch(this.status) {
                    case 1:
                        this.isDisable = false;
                        this.isDontMove = false;
                        this.isFire = false;
                        this.isIce = false;
                        this.isWind = false;
                        if (this.templateId != 98 && this.templateId != 99) {
                            this.p1++;
                            this.y = this.y + this.p1;
                            if (nso.Mob.interestChar != null) {
                                if (nso.Mob.interestChar.myskill != null) {
                                    if (nso.Mob.interestChar.myskill.template.id > 72) {
                                        if (GameCanvas.gameTick % 9 == 0) {
                                            if (this.p2 > 1) {
                                                this.p2 += 5;
                                            } else if (this.p2 < -1) {
                                                this.p2 -= 5;
                                            }
                                        }
                                    } else if (GameCanvas.gameTick % 2 == 0) {
                                        if (this.p2 > 1) {
                                            this.p2--;
                                        } else if (this.p2 < -1) {
                                            this.p2++;
                                        }
                                    }
                                }
                            } else if (Char.getMyChar() != null && Char.getMyChar().myskill != null) {
                                if (Char.getMyChar().myskill.template.id > 72) {
                                    if (GameCanvas.gameTick % 9 == 0) {
                                        if (this.p2 > 1) {
                                            this.p2 += 5;
                                        } else if (this.p2 < -1) {
                                            this.p2 -= 5;
                                        }
                                    }
                                } else if (GameCanvas.gameTick % 2 == 0) {
                                    if (this.p2 > 1) {
                                        this.p2--;
                                    } else if (this.p2 < -1) {
                                        this.p2++;
                                    }
                                }
                            }
                            this.x = this.x + this.p2;
                            Mob mob1;
                            byte byteValue;
                            if (this.templateId == 209 || this.templateId == 210) {
                                mob1 = this;
                                byteValue = 6;
                            } else if (this.templateId == 168 || this.templateId == 176 || this.templateId == 177 || this.templateId == 179 || this.templateId == 180 || this.templateId == 191) {
                                mob1 = this;
                                byteValue = 7;
                            } else if (this.templateId == 178 || this.templateId == 181 || this.templateId == 183 || this.templateId == 185 || this.templateId == 188 || this.templateId == 192 || this.templateId == 194) {
                                mob1 = this;
                                byteValue = 4;
                            } else if (this.templateId == 173 || this.templateId == 184) {
                                mob1 = this;
                                byteValue = 6;
                            } else if (this.templateId == 175) {
                                mob1 = this;
                                byteValue = 8;
                            } else if (this.templateId == 170 || this.templateId == 195 || this.templateId == 196 || this.templateId == 197 || this.templateId == 186 || this.templateId == 189 || this.templateId == 190) {
                                mob1 = this;
                                byteValue = 3;
                            } else if (this.templateId == 187) {
                                mob1 = this;
                                byteValue = 9;
                            } else if (this.templateId == 193) {
                                mob1 = this;
                                byteValue = 5;
                            } else if (this.templateId == 174) {
                                mob1 = this;
                                byteValue = 10;
                            } else {
                                mob1 = this;
                                byteValue = (byte) (this.isBoss ? 10 : 2);
                            }
                            mob1.frame = byteValue;
                            if (this.y > GameScr.gssye * 24 || this.x < GameScr.gssx * 24 || this.x > GameScr.gssxe * 24) {
                                this.p1 = 0;
                                this.p2 = 0;
                                this.x = this.y = 0;
                                this.hp = this.getTemplate().hp;
                                this.status = 0;
                                if (this.templateId < 168) {
                                    this.frame = 0;
                                } else {
                                    this.frame = this.setFrameAppear(GameCanvas.gameTick);
                                }
                                this.timeStatus = 0;
                                return;
                            }
                            if (this.p3 == 0 && (TileMap.tileTypeAtPixel(this.x, this.y) & 2) == 2) {
                                this.p1 = this.p1 > 4 ? -4 : -this.p1;
                                this.p3 = 16;
                            }
                            if (this.p3 > 0) {
                                this.p3--;
                            }
                        } else if (System.currentTimeMillis() - this.timeStartDie > 1200L) {
                            this.status = 0;
                        }
                        break;
                    case 2:
                        this.timeStatus = 0;
                        if (this.isBoss && this.templateId > 210) {
                            mob = this;
                            if (arrMobTemplate[mob.templateId].frameBossMove != null) {
                                mob.p1++;
                                if (GameCanvas.gameTick % 2 == 0) {
                                    mob.frameIndex++;
                                }
                                if (mob.frameIndex >= arrMobTemplate[mob.templateId].frameBossMove.length) {
                                    mob.frameIndex = 0;
                                }
                                mob.frame = arrMobTemplate[mob.templateId].frameBossMove[mob.frameIndex];
                                if (mob.p1 > 10 + mob.mobId % 10 && System.currentTimeMillis() - (mob.timeCurrent + timewait) >= 0L) {
                                    mob.status = 5;
                                    mob.p1 = 0;
                                }
                            }
                        } else {
                            mob = this;
                            switch(arrMobTemplate[mob.templateId].type) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                    if (mob.templateId == 209 || mob.templateId == 210) {
                                        mob.frame = 1;
                                    } else if (mob.templateId == 173 || mob.templateId == 175 || mob.templateId == 176 || mob.templateId == 177 || mob.templateId == 179 || mob.templateId == 180 || mob.templateId == 181 || mob.templateId == 183 || mob.templateId == 184 || mob.templateId == 185) {
                                        mob.frame = 1;
                                    } else if (mob.templateId == 168 || mob.templateId == 179) {
                                        mob.frame = 6;
                                    } else if (mob.templateId == 174) {
                                        mob.frame = 4;
                                    } else {
                                        short shortValue = 202;
                                        mob.frame = 0;
                                    }
                                    mob.p1++;
                                    if (mob.p1 > 10 + mob.mobId % 10 && System.currentTimeMillis() - (mob.timeCurrent + timewait) >= 0L) {
                                        mob.status = 5;
                                    }
                                    if (mob.isBoss) {
                                        mob.frame = GameCanvas.gameTick % 101 > 1 ? 0 : 1;
                                    }
                                    break label958;
                                case 4:
                                case 5:
                                    if (!mob.isBoss) {
                                        if (mob.templateId < 168) {
                                            mob.frame = GameCanvas.gameTick % 4 > 1 ? 0 : 1;
                                        } else {
                                            mob.frame = mob.setFrameMove(GameCanvas.gameTick);
                                        }
                                    } else {
                                        mob.frame = arrMobTemplate[mob.templateId].frameBossMove[mob.frameIndex];
                                    }
                                    mob.p1++;
                                    if (mob.p1 > mob.mobId % 3) {
                                        mob.status = 5;
                                    }
                            }
                        }
                        break;
                    case 3:
                        if (this.mobToAttack != null || this.charToAttack != null) {
                            this.updateAttk_Thunuoi();
                        } else if (this.idSkill_atk < 0) {
                            if (this.isBoss && this.templateId > 210) {
                                mob = this;
                                if (arrMobTemplate[mob.templateId].frameBossAttack != null) {
                                    if (mob.p1 == 0) {
                                        int value = 0;
                                        int value2 = 0;
                                        if (mob.typeAtt == 0) {
                                            value = mob.cFocus.cx;
                                            value2 = mob.cFocus.cy;
                                        } else if (mob.typeAtt == 1) {
                                            value = mob.bFocus.x;
                                            value2 = mob.bFocus.y;
                                        }
                                        if (GameCanvas.gameTick % 2 == 0) {
                                            mob.frameIndex++;
                                        }
                                        if (Res.abs(value - mob.x) >= 48 && Res.abs(value2 - mob.y) >= 10) {
                                            if (mob.frameIndex >= arrMobTemplate[mob.templateId].frameBossAttack[1].length) {
                                                mob.p1 = 1;
                                                mob.frameIndex = 0;
                                            }
                                            mob.frame = arrMobTemplate[mob.templateId].frameBossAttack[1][mob.frameIndex];
                                        } else {
                                            if (mob.frameIndex >= arrMobTemplate[mob.templateId].frameBossAttack[0].length) {
                                                mob.p1 = 1;
                                                mob.frameIndex = 0;
                                            }
                                            mob.frame = arrMobTemplate[mob.templateId].frameBossAttack[0][mob.frameIndex];
                                        }
                                    } else if (mob.p1 == 1) {
                                        if (arrMobTemplate[mob.templateId].type != 0 && !mob.isDontMove && !mob.isIce && !mob.isWind) {
                                            mob.x = mob.x + (mob.xFirst - mob.x) / 4;
                                            mob.y = mob.y + (mob.yFirst - mob.y) / 4;
                                        }
                                        if (Res.abs(mob.xFirst - mob.x) < 5 && Res.abs(mob.yFirst - mob.y) < 5) {
                                            mob.status = 2;
                                            mob.frameIndex = 0;
                                            mob.p1 = 0;
                                            mob.p2 = 0;
                                        }
                                    }
                                }
                            } else {
                                mob = this;
                                Mob mob3;
                                int value4;
                                if (this.templateId == 209 || mob.templateId == 210) {
                                    mob3 = mob;
                                    value4 = 6;
                                } else if (mob.templateId == 176 || mob.templateId == 177 || mob.templateId == 179) {
                                    mob3 = mob;
                                    value4 = 6;
                                } else if (mob.templateId == 175) {
                                    mob3 = mob;
                                    value4 = 7;
                                } else if (mob.templateId == 180 || mob.templateId == 181 || mob.templateId == 183 || mob.templateId == 184 || mob.templateId == 173 || mob.templateId == 188 || mob.templateId == 192 || mob.templateId == 194 || mob.templateId == 202) {
                                    mob3 = mob;
                                    value4 = 3;
                                } else if (mob.templateId == 193) {
                                    mob3 = mob;
                                    value4 = 4;
                                } else if (mob.templateId != 187 && mob.templateId != 168 && mob.templateId != 175 && mob.templateId != 176 && mob.templateId != 179 && mob.templateId != 174) {
                                    mob3 = mob;
                                    value4 = GameCanvas.gameTick % 4 > 1 ? (arrMobTemplate[mob.templateId].type == 5 ? 3 : 0) : 1;
                                } else {
                                    mob3 = mob;
                                    value4 = mob.setFrameAtt(GameCanvas.gameTick);
                                }
                                mob3.frame = value4;
                                if (mob.p1 == 0) {
                                    int value5 = 0;
                                    int value6 = 0;
                                    if (mob.typeAtt == 0) {
                                        value5 = mob.cFocus.cx;
                                        value6 = mob.cFocus.cy;
                                    } else if (mob.typeAtt == 1) {
                                        value5 = mob.bFocus.x;
                                        value6 = mob.bFocus.y;
                                    }
                                    if (Res.abs(value5 - mob.x) < 24 || Res.abs(value5 - mob.x) < 5 || arrMobTemplate[mob.templateId].type == 0) {
                                        Mob mob7;
                                        if (mob.templateId == 168 || mob.templateId == 176 || mob.templateId == 177 || mob.templateId == 179) {
                                            mob7 = mob;
                                            value4 = 6;
                                        } else if (mob.templateId == 175) {
                                            mob7 = mob;
                                            value4 = 7;
                                        } else {
                                            label1048: {
                                                if (mob.templateId != 180 && mob.templateId != 181 && mob.templateId != 183 && mob.templateId != 184 && mob.templateId != 173 && mob.templateId != 202) {
                                                    if (mob.templateId == 187 || mob.templateId == 168 || mob.templateId == 179 || mob.templateId == 174) {
                                                        mob7 = mob;
                                                        value4 = mob.setFrameAtt(GameCanvas.gameTick);
                                                        break label1048;
                                                    }
                                                    mob7 = mob;
                                                    if (arrMobTemplate[mob.templateId].imgs.length == 3) {
                                                        value4 = 0;
                                                        break label1048;
                                                    }
                                                } else {
                                                    mob7 = mob;
                                                }
                                                value4 = 3;
                                            }
                                        }
                                        mob7.frame = value4;
                                    }
                                    if (mob.isBoss && (Res.abs(value5 - mob.x) < 48 || Res.abs(value5 - mob.x) < 10 || arrMobTemplate[mob.templateId].type == 0)) {
                                        mob.frame = arrMobTemplate[mob.templateId].imgs.length == 3 ? 0 : 3;
                                    }
                                    if (mob.isBoss) {
                                        mob.frameIndex++;
                                        if (Res.abs(value5 - mob.x) >= 48 && Res.abs(value6 - mob.y) >= 10) {
                                            if (mob.frameIndex >= arrMobTemplate[mob.templateId].frameBossAttack[1].length) {
                                                mob.frameIndex = 0;
                                            }
                                            mob.frame = arrMobTemplate[mob.templateId].frameBossAttack[1][mob.frameIndex];
                                        } else {
                                            if (mob.frameIndex >= arrMobTemplate[mob.templateId].frameBossAttack[0].length) {
                                                mob.frameIndex = 0;
                                            }
                                            mob.frame = arrMobTemplate[mob.templateId].frameBossAttack[0][mob.frameIndex];
                                        }
                                    }
                                    if (mob.frame == 3 || mob.frame == 6 || mob.frame == 7) {
                                        mob.p1 = 1;
                                    }
                                    if (arrMobTemplate[mob.templateId].type != 0 && !mob.isDontMove && mob.isIce && mob.isWind) {
                                        mob.x = mob.x + (value5 - mob.x) / 3;
                                    }
                                    if (mob.x > mob.xFirst + arrMobTemplate[mob.templateId].rangeMove) {
                                        mob.p1 = 1;
                                    }
                                    if (mob.x < mob.xFirst - arrMobTemplate[mob.templateId].rangeMove) {
                                        mob.p1 = 1;
                                    }
                                    if ((arrMobTemplate[mob.templateId].type == 4 || arrMobTemplate[mob.templateId].type == 5) && !mob.isDontMove) {
                                        mob.y = mob.y + (value6 - mob.y) / 20;
                                    }
                                    mob.p2++;
                                    label802: if (mob.isBoss && Res.abs(value5 - mob.x) < 48 && Res.abs(value6 - mob.y) < 15 || Res.abs(value5 - mob.x) < 12 && Res.abs(value6 - mob.y) < 12 || mob.p2 > 12 || mob.p1 == 1 || arrMobTemplate != null && arrMobTemplate[mob.templateId].frameBossAttack != null && mob.frameIndex == arrMobTemplate[mob.templateId].frameBossAttack[0].length - 2 && (mob.getTemplate().mobTemplateId == 166 || mob.getTemplate().mobTemplateId == 167)) {
                                        mob.p1 = 1;
                                        if (mob.typeAtt == 0) {
                                            if (mob.isBoss && Res.abs(value5 - mob.x) < 48 && Res.abs(value6 - mob.y) < 15) {
                                                mob.cFocus.doInjure(mob.dame, mob.dameMp, mob.isBoss, mob.getTemplate().mobTemplateId);
                                                mob.isBusyAttackSomeOne = false;
                                                if (mob.getTemplate().mobTemplateId == 210) {
                                                    if (mob.cFocus.cx > mob.x) {
                                                        ServerEffect.addServerEffect(142, mob.x, mob.y, 1);
                                                    } else {
                                                        ServerEffect.addServerEffect(142, mob.x, mob.y, 1, (byte) -1);
                                                    }
                                                    break label802;
                                                }
                                                if (mob.getTemplate().mobTemplateId == 209) {
                                                    if (mob.cFocus.cx > mob.x) {
                                                        ServerEffect.addServerEffect(108, mob.x, mob.y, 1);
                                                    } else {
                                                        ServerEffect.addServerEffect(108, mob.x, mob.y, 1, (byte) -1);
                                                    }
                                                    break label802;
                                                }
                                                if (mob.getTemplate().mobTemplateId == 114) {
                                                    ServerEffect.addServerEffect(79, mob.cFocus, 3);
                                                    break label802;
                                                }
                                                if (mob.getTemplate().mobTemplateId == 115) {
                                                    if (mob.cFocus == Char.getMyChar()) {
                                                        GameScr.shaking = 1;
                                                    }
                                                    GameScr.count = 0;
                                                    ServerEffect.addServerEffect(81, mob.cFocus.cx, mob.yFirst + TileMap.size, 2);
                                                    ServerEffect.addServerEffect(81, mob.cFocus.cx - 40, mob.yFirst + TileMap.size, 2);
                                                    ServerEffect.addServerEffect(81, mob.cFocus.cx + 40, mob.yFirst + TileMap.size, 2);
                                                    break label802;
                                                }
                                                if (mob.getTemplate().mobTemplateId == 116) {
                                                    if (mob.cFocus == Char.getMyChar()) {
                                                        GameScr.shaking = 1;
                                                        GameScr.count = 0;
                                                    }
                                                    if (mob.cFocus.cx > mob.x) {
                                                        ServerEffect.addServerEffect(86, mob.x, mob.y - mob.h / 2 + 5, 1);
                                                    } else {
                                                        ServerEffect.addServerEffect(88, mob.x, mob.y - mob.h / 2 + 5, 1);
                                                    }
                                                    ServerEffect.addServerEffect(87, mob.cFocus.cx, mob.cFocus.cy - mob.cFocus.ch / 2, 2);
                                                    ServerEffect.addServerEffect(87, mob.cFocus.cx - 40, mob.cFocus.cy - mob.cFocus.ch / 2, 2);
                                                    ServerEffect.addServerEffect(87, mob.cFocus.cx + 40, mob.cFocus.cy - mob.cFocus.ch / 2, 2);
                                                    break label802;
                                                }
                                                if (mob.getTemplate().mobTemplateId == 138) {
                                                    if (mob.cFocus.cx > mob.x) {
                                                        ServerEffect.addServerEffect(89, mob.x + mob.w / 2, mob.y - mob.h / 2 - 5, 1);
                                                    } else {
                                                        ServerEffect.addServerEffect(89, mob.x - mob.w / 2, mob.y - mob.h / 2 - 5, 1, (byte) -1);
                                                    }
                                                    ServerEffect.addServerEffect(90, mob.cFocus, 2);
                                                    break label802;
                                                }
                                                if (mob.getTemplate().mobTemplateId == 139) {
                                                    if (mob.cFocus == Char.getMyChar()) {
                                                        GameScr.shaking = 1;
                                                        GameScr.count = 0;
                                                    }
                                                    ServerEffect.addServerEffect(91, mob.cFocus, 2);
                                                    break label802;
                                                }
                                                if (mob.getTemplate().mobTemplateId != 140 && mob.getTemplate().mobTemplateId != 161) {
                                                    if (mob.getTemplate().mobTemplateId != 141 && mob.getTemplate().mobTemplateId != 162) {
                                                        if (mob.getTemplate().mobTemplateId != 144 && mob.getTemplate().mobTemplateId != 163) {
                                                            if (mob.getTemplate().mobTemplateId == 160) {
                                                                if (mob.cFocus.cx > mob.x) {
                                                                    ServerEffect.addServerEffect(123, mob.x + mob.w / 2, mob.y - 5, 1);
                                                                } else {
                                                                    ServerEffect.addServerEffect(123, mob.x - mob.w / 2, mob.y - 5, 1, (byte) -1);
                                                                }
                                                                ServerEffect.addServerEffect(91, mob.cFocus, 1);
                                                                break label802;
                                                            }
                                                            if (mob.getTemplate().mobTemplateId != 164 && mob.getTemplate().mobTemplateId != 165) {
                                                                if (mob.getTemplate().mobTemplateId == 167) {
                                                                    if (mob.cFocus.cx > mob.x) {
                                                                        ServerEffect.addServerEffect(125, mob.x + mob.w / 2, mob.y, 1);
                                                                    } else {
                                                                        ServerEffect.addServerEffect(125, mob.x - mob.w / 2, mob.y, 1, (byte) -1);
                                                                    }
                                                                } else if (mob.getTemplate().mobTemplateId == 166) {
                                                                    if (mob.cFocus.cx > mob.x) {
                                                                        ServerEffect.addServerEffect(108, mob.x + mob.w / 2, mob.y, 1);
                                                                    } else {
                                                                        ServerEffect.addServerEffect(108, mob.x - mob.w / 2, mob.y, 1, (byte) -1);
                                                                    }
                                                                } else if (mob.getTemplate().mobTemplateId == 198) {
                                                                    if (mob.cFocus.cx > mob.x) {
                                                                        ServerEffect.addServerEffect(143, mob.x + mob.w / 2, mob.y, 1);
                                                                    } else {
                                                                        ServerEffect.addServerEffect(143, mob.x - mob.w / 2, mob.y, 1, (byte) -1);
                                                                    }
                                                                } else if (mob.getTemplate().mobTemplateId == 199) {
                                                                    if (mob.cFocus.cx > mob.x) {
                                                                        ServerEffect.addServerEffect(144, mob.x + mob.w / 2, mob.y, 1);
                                                                    } else {
                                                                        ServerEffect.addServerEffect(144, mob.x - mob.w / 2, mob.y, 1, (byte) -1);
                                                                    }
                                                                } else if (mob.getTemplate().mobTemplateId == 200) {
                                                                    if (mob.cFocus.cx > mob.x) {
                                                                        ServerEffect.addServerEffect(142, mob.x + mob.w / 2, mob.y, 1);
                                                                    } else {
                                                                        ServerEffect.addServerEffect(142, mob.x - mob.w / 2, mob.y, 1, (byte) -1);
                                                                    }
                                                                } else if (mob.getTemplate().mobTemplateId == 201) {
                                                                    if (mob.cFocus.cx > mob.x) {
                                                                        ServerEffect.addServerEffect(144, mob.x + mob.w / 2, mob.y, 1);
                                                                    } else {
                                                                        ServerEffect.addServerEffect(144, mob.x - mob.w / 2, mob.y, 1, (byte) -1);
                                                                    }
                                                                } else if (mob.getTemplate().mobTemplateId == 203) {
                                                                    if (mob.cFocus.cx > mob.x) {
                                                                        ServerEffect.addServerEffect(159, mob.x + mob.w / 2, mob.y, 1);
                                                                        ServerEffect.addServerEffect(156, mob.cFocus.cx, mob.cFocus.cy, 1);
                                                                    } else {
                                                                        ServerEffect.addServerEffect(159, mob.x - mob.w / 2, mob.y, 1, (byte) -1);
                                                                        ServerEffect.addServerEffect(156, mob.cFocus.cx, mob.cFocus.cy, -1);
                                                                    }
                                                                } else if (mob.getTemplate().mobTemplateId == 204) {
                                                                    if (mob.cFocus.cx > mob.x) {
                                                                        ServerEffect.addServerEffect(159, mob.x + mob.w / 2, mob.y, 1);
                                                                        ServerEffect.addServerEffect(173, mob.cFocus.cx, mob.cFocus.cy, 1);
                                                                    } else {
                                                                        ServerEffect.addServerEffect(159, mob.x - mob.w / 2, mob.y, 1, (byte) -1);
                                                                        ServerEffect.addServerEffect(173, mob.cFocus.cx, mob.cFocus.cy, -1);
                                                                    }
                                                                }
                                                                break label802;
                                                            }
                                                            if (mob.cFocus.cx > mob.x) {
                                                                ServerEffect.addServerEffect(125, mob.x + mob.w / 2, mob.y, 1);
                                                            } else {
                                                                ServerEffect.addServerEffect(125, mob.x - mob.w / 2, mob.y, 1, (byte) -1);
                                                            }
                                                            ServerEffect.addServerEffect(90, mob.cFocus, 1);
                                                            break label802;
                                                        }
                                                        if (mob.cFocus == Char.getMyChar()) {
                                                            GameScr.shaking = 1;
                                                            GameScr.count = 0;
                                                        }
                                                        ServerEffect.addServerEffect(112, mob.cFocus, 2);
                                                        ServerEffect.addServerEffect(109, mob.cFocus.cx - 40, mob.cFocus.cy - 40, 1);
                                                        ServerEffect.addServerEffect(109, mob.cFocus.cx + 40, mob.cFocus.cy - 40, 1);
                                                        ServerEffect.addServerEffect(109, mob.cFocus.cx - 20, mob.cFocus.cy, 2);
                                                        ServerEffect.addServerEffect(109, mob.cFocus.cx + 20, mob.cFocus.cy, 2);
                                                        break label802;
                                                    }
                                                    if (mob.cFocus.cx > mob.x) {
                                                        ServerEffect.addServerEffect(108, mob.x + mob.w / 2, mob.y, 1);
                                                    } else {
                                                        ServerEffect.addServerEffect(108, mob.x - mob.w / 2, mob.y, 1, (byte) -1);
                                                    }
                                                    ServerEffect.addServerEffect(122, mob.x, mob.y, 1, (byte) mob.dir);
                                                    ServerEffect.addServerEffect(91, mob.cFocus, 1);
                                                    break label802;
                                                }
                                                if (mob.cFocus == Char.getMyChar()) {
                                                    GameScr.shaking = 1;
                                                    GameScr.count = 0;
                                                }
                                                ServerEffect.addServerEffect(112, mob.cFocus, 2);
                                                ServerEffect.addServerEffect(109, mob.cFocus.cx - 40, mob.cFocus.cy - 40, 1);
                                                ServerEffect.addServerEffect(109, mob.cFocus.cx + 40, mob.cFocus.cy - 40, 1);
                                                ServerEffect.addServerEffect(109, mob.cFocus.cx - 20, mob.cFocus.cy, 2);
                                                ServerEffect.addServerEffect(109, mob.cFocus.cx + 20, mob.cFocus.cy, 2);
                                                break label802;
                                            }
                                            if (Res.abs(value5 - mob.x) >= 24 || Res.abs(value6 - mob.y) >= 15) {
                                                if (mob.isBoss) {
                                                    if (mob.getTemplate().mobTemplateId == 210) {
                                                        if (mob.cFocus.cx > mob.x) {
                                                            ServerEffect.addServerEffect(178, mob.cFocus.cx, mob.cFocus.cy, 1);
                                                        } else {
                                                            ServerEffect.addServerEffect(178, mob.cFocus.cx, mob.cFocus.cy, 1, (byte) -1);
                                                        }
                                                    } else if (mob.getTemplate().mobTemplateId == 209) {
                                                        if (mob.cFocus.cx > mob.x) {
                                                            ServerEffect.addServerEffect(179, mob.cFocus.cx, mob.cFocus.cy, 1);
                                                        } else {
                                                            ServerEffect.addServerEffect(179, mob.cFocus.cx, mob.cFocus.cy, 1, (byte) -1);
                                                        }
                                                    } else if (mob.getTemplate().mobTemplateId == 114 || mob.getTemplate().mobTemplateId == 115) {
                                                        MonsterDart.addMonsterDart(mob.x + (mob.dir - 1) * 15, mob.y - 20, mob.isBoss, mob.levelBoss, mob.getTemplate().mobTemplateId, mob.dame, mob.dameMp, mob.cFocus);
                                                    } else if (mob.getTemplate().mobTemplateId == 116) {
                                                        ServerEffect.addServerEffect(84, mob.cFocus, 2);
                                                        mob.isBusyAttackSomeOne = false;
                                                        mob.cFocus.doInjure(mob.dame, mob.dameMp, mob.isBoss, mob.getTemplate().mobTemplateId);
                                                    } else if (mob.getTemplate().mobTemplateId == 138) {
                                                        if (mob.cFocus == Char.getMyChar()) {
                                                            GameScr.shaking = 1;
                                                            GameScr.count = 0;
                                                        }
                                                        ServerEffect.addServerEffect(83, mob.cFocus, 2);
                                                        mob.isBusyAttackSomeOne = false;
                                                        mob.cFocus.doInjure(mob.dame, mob.dameMp, mob.isBoss, mob.getTemplate().mobTemplateId);
                                                    } else if (mob.getTemplate().mobTemplateId == 139) {
                                                        MonsterDart.addMonsterDart(mob.x + (mob.dir - 1) * 30, mob.y - 30, mob.isBoss, mob.levelBoss, mob.getTemplate().mobTemplateId, mob.dame, mob.dameMp, mob.cFocus);
                                                    } else if (mob.getTemplate().mobTemplateId == 140 || mob.getTemplate().mobTemplateId == 161) {
                                                        if (mob.cFocus == Char.getMyChar()) {
                                                            GameScr.shaking = 1;
                                                            GameScr.count = 0;
                                                        }
                                                        ServerEffect.addServerEffect(110, mob.cFocus, 2);
                                                        ServerEffect.addServerEffect(104, mob.cFocus.cx - 20, mob.cFocus.cy, 2);
                                                        ServerEffect.addServerEffect(104, mob.cFocus.cx + 20, mob.cFocus.cy, 2);
                                                        mob.isBusyAttackSomeOne = false;
                                                        mob.cFocus.doInjure(mob.dame, mob.dameMp, mob.isBoss, mob.getTemplate().mobTemplateId);
                                                    } else if (mob.getTemplate().mobTemplateId == 141 || mob.getTemplate().mobTemplateId == 162) {
                                                        if (mob.cFocus == Char.getMyChar()) {
                                                            GameScr.shaking = 1;
                                                            GameScr.count = 0;
                                                        }
                                                        ServerEffect.addServerEffect(121, mob.cFocus, 1);
                                                        mob.isBusyAttackSomeOne = false;
                                                        mob.cFocus.doInjure(mob.dame, mob.dameMp, mob.isBoss, mob.getTemplate().mobTemplateId);
                                                    } else if (mob.getTemplate().mobTemplateId == 144 || mob.getTemplate().mobTemplateId == 163) {
                                                        MonsterDart.addMonsterDart(mob.x + (mob.dir - 1) * 15, mob.y - 20, mob.isBoss, mob.levelBoss, mob.getTemplate().mobTemplateId, mob.dame, mob.dameMp, mob.cFocus);
                                                    } else if (mob.getTemplate().mobTemplateId == 160) {
                                                        ServerEffect.addServerEffect(124, mob.cFocus, 2);
                                                        mob.isBusyAttackSomeOne = false;
                                                        mob.cFocus.doInjure(mob.dame, mob.dameMp, mob.isBoss, mob.getTemplate().mobTemplateId);
                                                    } else if (mob.getTemplate().mobTemplateId == 164 || mob.getTemplate().mobTemplateId == 165) {
                                                        ServerEffect.addServerEffect(126, mob.cFocus, 1);
                                                        mob.isBusyAttackSomeOne = false;
                                                        mob.cFocus.doInjure(mob.dame, mob.dameMp, mob.isBoss, mob.getTemplate().mobTemplateId);
                                                    } else if (mob.getTemplate().mobTemplateId == 167) {
                                                        ServerEffect.addServerEffect(112, mob.cFocus.cx + 5, mob.cFocus.cy, 1);
                                                        ServerEffect.addServerEffect(112, mob.cFocus.cx - 5, mob.cFocus.cy, 1);
                                                        ServerEffect.addServerEffect(112, mob.cFocus, 1);
                                                        mob.isBusyAttackSomeOne = false;
                                                        mob.cFocus.doInjure(mob.dame, mob.dameMp, mob.isBoss, mob.getTemplate().mobTemplateId);
                                                    } else if (mob.getTemplate().mobTemplateId == 166) {
                                                        ServerEffect.addServerEffect(92, mob.cFocus.cx + 5, mob.cFocus.cy, 1);
                                                        ServerEffect.addServerEffect(92, mob.cFocus.cx - 5, mob.cFocus.cy, 1);
                                                        ServerEffect.addServerEffect(92, mob.cFocus, 1);
                                                        mob.isBusyAttackSomeOne = false;
                                                        mob.cFocus.doInjure(mob.dame, mob.dameMp, mob.isBoss, mob.getTemplate().mobTemplateId);
                                                    } else if (mob.getTemplate().mobTemplateId == 198) {
                                                        ServerEffect.addServerEffect(142, mob.cFocus.cx + 5, mob.cFocus.cy, 1);
                                                        ServerEffect.addServerEffect(142, mob.cFocus.cx - 5, mob.cFocus.cy, 1);
                                                        ServerEffect.addServerEffect(142, mob.cFocus, 1);
                                                        mob.isBusyAttackSomeOne = false;
                                                        mob.cFocus.doInjure(mob.dame, mob.dameMp, mob.isBoss, mob.getTemplate().mobTemplateId);
                                                    } else if (mob.getTemplate().mobTemplateId == 199) {
                                                        ServerEffect.addServerEffect(143, mob.cFocus.cx + 5, mob.cFocus.cy, 1);
                                                        ServerEffect.addServerEffect(143, mob.cFocus.cx - 5, mob.cFocus.cy, 1);
                                                        ServerEffect.addServerEffect(143, mob.cFocus, 1);
                                                        mob.isBusyAttackSomeOne = false;
                                                        mob.cFocus.doInjure(mob.dame, mob.dameMp, mob.isBoss, mob.getTemplate().mobTemplateId);
                                                    } else if (mob.getTemplate().mobTemplateId == 200) {
                                                        ServerEffect.addServerEffect(144, mob.cFocus.cx + 5, mob.cFocus.cy, 1);
                                                        ServerEffect.addServerEffect(144, mob.cFocus.cx - 5, mob.cFocus.cy, 1);
                                                        ServerEffect.addServerEffect(144, mob.cFocus, 1);
                                                        mob.isBusyAttackSomeOne = false;
                                                        mob.cFocus.doInjure(mob.dame, mob.dameMp, mob.isBoss, mob.getTemplate().mobTemplateId);
                                                    } else if (mob.getTemplate().mobTemplateId == 201) {
                                                        ServerEffect.addServerEffect(108, mob.cFocus.cx + 5, mob.cFocus.cy, 1);
                                                        ServerEffect.addServerEffect(108, mob.cFocus.cx - 5, mob.cFocus.cy, 1);
                                                        ServerEffect.addServerEffect(108, mob.cFocus, 1);
                                                        mob.isBusyAttackSomeOne = false;
                                                        mob.cFocus.doInjure(mob.dame, mob.dameMp, mob.isBoss, mob.getTemplate().mobTemplateId);
                                                    } else if (mob.getTemplate().mobTemplateId == 203) {
                                                        ServerEffect.addServerEffect(149, mob.cFocus.cx + 5, mob.cFocus.cy, 1);
                                                        ServerEffect.addServerEffect(149, mob.cFocus.cx - 5, mob.cFocus.cy, 1);
                                                        ServerEffect.addServerEffect(149, mob.cFocus, 1);
                                                        ServerEffect.addServerEffect(156, mob.cFocus, 1);
                                                        mob.isBusyAttackSomeOne = false;
                                                        mob.cFocus.doInjure(mob.dame, mob.dameMp, mob.isBoss, mob.getTemplate().mobTemplateId);
                                                    } else if (mob.getTemplate().mobTemplateId == 204) {
                                                        ServerEffect.addServerEffect(153, mob.cFocus.cx + 5, mob.cFocus.cy, 1);
                                                        ServerEffect.addServerEffect(153, mob.cFocus.cx - 5, mob.cFocus.cy, 1);
                                                        ServerEffect.addServerEffect(153, mob.cFocus, 1);
                                                        ServerEffect.addServerEffect(173, mob.cFocus, 1);
                                                        mob.isBusyAttackSomeOne = false;
                                                        mob.cFocus.doInjure(mob.dame, mob.dameMp, mob.isBoss, mob.getTemplate().mobTemplateId);
                                                    }
                                                } else {
                                                    MonsterDart.addMonsterDart(mob.x - 5, mob.y + mob.dir * 10, mob.isBoss, mob.level, mob.getTemplate().mobTemplateId, mob.dame, mob.dameMp, mob.cFocus);
                                                }
                                                mob.isBusyAttackSomeOne = false;
                                                break label802;
                                            }
                                            mob.cFocus.doInjure(mob.dame, mob.dameMp, mob.isBoss, mob.getTemplate().mobTemplateId);
                                        } else {
                                            if (mob.typeAtt != 1) {
                                                break label802;
                                            }
                                            if (Res.abs(value5 - mob.x) < 24 && Res.abs(value6 - mob.y) < 15) {
                                                BuNhin buNhin = mob.bFocus;
                                                mob.bFocus.isInjure = true;
                                            } else if (mob.isBoss) {
                                                MonsterDart.addMonsterDart(mob.x - 5, mob.y + mob.dir * 10 - 20, mob.bFocus);
                                            } else {
                                                MonsterDart.addMonsterDart(mob.x - 5, mob.y + mob.dir * 10, mob.bFocus);
                                            }
                                        }
                                        mob.isBusyAttackSomeOne = false;
                                    }
                                    mob.dir = mob.x < value5 ? 1 : -1;
                                } else if (mob.p1 == 1) {
                                    if (arrMobTemplate[mob.templateId].type != 0 && !mob.isDontMove && !mob.isIce && !mob.isWind) {
                                        mob.x = mob.x + (mob.xFirst - mob.x) / 4;
                                        mob.y = mob.y + (mob.yFirst - mob.y) / 4;
                                    }
                                    if (Res.abs(mob.xFirst - mob.x) < 5 && Res.abs(mob.yFirst - mob.y) < 5) {
                                        mob.status = 2;
                                        mob.p1 = 0;
                                        mob.p2 = 0;
                                    }
                                }
                            }
                        } else {
                            this.updateTypeMobAttk();
                        }
                        break;
                    case 4:
                        this.timeStatus = 0;
                        this.frame = 0;
                        this.p1++;
                        if (this.p1 > 40 + this.mobId % 5) {
                            this.y -= 2;
                            this.status = 5;
                            this.p1 = 0;
                        }
                        break;
                    case 5:
                        try {
                            if (GameCanvas.gameTick % 4 == 0 && this.isBoss) {
                                this.frameIndex++;
                                if (this.frameIndex > arrMobTemplate[this.templateId].frameBossMove.length - 1) {
                                    this.frameIndex = 0;
                                }
                            }
                        } catch (Exception exception) {
                        }
                        this.timeStatus = 0;
                        this.updateMobWalk();
                        break;
                    case 6:
                        this.timeStatus = 0;
                        this.p1++;
                        this.y = this.y + this.p1;
                        if (this.y >= this.yFirst) {
                            this.y = this.yFirst;
                            this.p1 = 0;
                            this.status = 5;
                        }
                        break;
                    case 7:
                        this.updateInjure();
                        break;
                    case 8:
                        this.frame = 0;
                        break;
                    case 9:
                        mob = this;
                        this.frame = mob.setFrameDisappear(GameCanvas.gameTick);
                        if (mob.frame == 1) {
                            mob.status = 8;
                        }
                }
                this.setatk_mob();
                if (this.removeWhenDie && this.hp <= 0) {
                    GameScr.vMob.removeElement(this);
                }
                this.updateDataEff((byte) 1, this.status);
            }
        }
    }

    public final void setInjure() {
        if (this.hp > 0) {
            this.timeStatus = 4;
            this.status = 7;
        }
    }

    public final void setAttack(Char cFocus1) {
        this.isBusyAttackSomeOne = true;
        this.cFocus = cFocus1;
        this.p1 = 0;
        this.p2 = 0;
        this.status = 3;
        if (this.templateId == 209 || this.templateId == 210) {
            this.frameIndex = 0;
        } else if (this.templateId == 168 || this.templateId == 176 || this.templateId == 177 || this.templateId == 179) {
            this.frameIndex = 6;
        } else if (this.templateId == 169 || this.templateId == 171 || this.templateId == 172 || this.templateId == 182) {
            this.frameIndex = 2;
        } else if (this.templateId == 175) {
            this.frameIndex = 7;
        } else if (this.templateId == 181 || this.templateId == 185 || this.templateId == 188 || this.templateId == 194 || this.templateId == 192) {
            this.frameIndex = 3;
        } else if (this.templateId == 183 || this.templateId == 170 || this.templateId == 193) {
            this.frameIndex = 4;
        } else if (this.templateId != 187 && this.templateId != 168 && this.templateId != 175 && this.templateId != 176 && this.templateId != 179 && this.templateId != 174) {
            this.frameIndex = 0;
        } else {
            this.frameIndex = this.setFrameAtt(GameCanvas.gameTick);
        }
        this.typeAtt = 0;
    }

    public final void setAttack(BuNhin bFocus1) {
        this.bFocus = bFocus1;
        this.p1 = 0;
        this.p2 = 0;
        this.status = 3;
        this.typeAtt = 1;
    }

    private void updateInjure() {
        this.frame = this.isBoss ? (this.getTemplate().mobTemplateId == 204 ? 9 : (this.getTemplate().mobTemplateId == 203 ? 9 : (this.getTemplate().mobTemplateId == 139 ? 4 : (this.getTemplate().mobTemplateId == 160 ? 12 : 10)))) : 2;
        if (this.getTemplate().mobTemplateId == 209 || this.getTemplate().mobTemplateId == 210) {
            this.frame = 3;
        } else if (this.getTemplate().mobTemplateId == 141) {
            this.frame = 13;
        } else if (this.getTemplate().mobTemplateId == 169 || this.getTemplate().mobTemplateId == 170 || this.getTemplate().mobTemplateId == 171 || this.getTemplate().mobTemplateId == 172 || this.getTemplate().mobTemplateId == 182) {
            this.frame = 3;
        } else if (this.getTemplate().mobTemplateId == 168 || this.getTemplate().mobTemplateId == 176 || this.getTemplate().mobTemplateId == 177 || this.getTemplate().mobTemplateId == 179 || this.getTemplate().mobTemplateId == 180) {
            this.frame = 7;
        } else if (this.getTemplate().mobTemplateId == 173 || this.getTemplate().mobTemplateId == 184) {
            this.frame = 6;
        } else if (this.getTemplate().mobTemplateId == 181 || this.getTemplate().mobTemplateId == 178 || this.getTemplate().mobTemplateId == 185 || this.getTemplate().mobTemplateId == 202) {
            this.frame = 4;
        } else if (this.getTemplate().mobTemplateId == 174) {
            this.frame = 10;
        } else if (this.getTemplate().mobTemplateId == 183) {
            this.frame = 5;
        } else if (this.getTemplate().mobTemplateId == 175) {
            this.frame = 8;
        }
        this.timeStatus--;
        if (this.timeStatus > 0) {
            if (arrMobTemplate[this.templateId].type != 0 && this.x > this.xFirst - arrMobTemplate[this.templateId].rangeMove) {
                arrMobTemplate[this.templateId].getClass();
            }
        } else {
            if ((this.injureBy == null || !this.injureThenDie) && this.hp != 0) {
                this.status = 5;
                if (this.injureBy != null) {
                    this.dir = -this.injureBy.cdir;
                    if (Res.abs(this.x - this.injureBy.cx) < 24) {
                        this.status = 2;
                    }
                }
                this.p1 = this.p2 = this.p3 = 0;
                this.timeStatus = 0;
            } else {
                this.status = 1;
                this.p2 = this.injureBy.cdir << 3;
                this.p1 = -5;
                this.p3 = 0;
            }
            this.injureBy = null;
        }
    }

    private void updateTypeMobAttk() {
        if (this.p1 == 0) {
            int value = 0;
            int value1 = 0;
            value = this.cFocus.cx;
            value1 = this.cFocus.cy;
            this.typeAtt = this.typeAtk;
            if (arrMobTemplate[this.templateId].speed > 0) {
                this.dir = this.x >= value ? 0 : 1;
            }
            if (this.isBoss) {
                this.frameIndex++;
                if (this.frameIndex >= arrMobTemplate[this.templateId].frameBossAttack[this.typeAtt].length) {
                    this.frameIndex = 0;
                    this.status = 2;
                    this.mobToAttack = null;
                    this.charToAttack = null;
                    this.p1 = 0;
                    this.p2 = 0;
                }
                if (this.frameIndex == arrMobTemplate[this.templateId].frameBossAttack[this.typeAtt].length - 1) {
                    if (this.typeTool == 0) {
                        ServerEffect.addServerEffect(this.idSkill_atk, value, value1, 1, (byte) (this.dir == 0 ? -1 : 1));
                    } else if (this.typeTool == 1 && this.idSkill_atk > -1) {
                        EffectAuto.addEffectAuto(this.idSkill_atk, value, value1, (byte) 1, (short) -1, this.dir == 0 ? -1 : 1);
                    }
                }
                this.frame = arrMobTemplate[this.templateId].frameBossAttack[this.typeAtk][this.frameIndex];
            } else {
                ServerEffect.addServerEffect(this.idSkill_atk, value, value1, 1, (byte) (this.dir == 0 ? -1 : 1));
            }
            if (arrMobTemplate[this.templateId].type != 0 && !this.isDontMove && this.isIce && this.isWind) {
                this.x = this.x + (value - this.x) / 3;
            }
            if (this.x > this.xFirst + arrMobTemplate[this.templateId].rangeMove) {
                this.p1 = 1;
            }
            if (this.x < this.xFirst - arrMobTemplate[this.templateId].rangeMove) {
                this.p1 = 1;
                return;
            }
        } else if (this.p1 == 1) {
            if (arrMobTemplate[this.templateId].type != 0 && !this.isDontMove && !this.isIce && !this.isWind) {
                this.x = this.x + (this.xFirst - this.x) / 4;
                this.y = this.y + (this.yFirst - this.y) / 4;
            }
            if (Res.abs(this.xFirst - this.x) < 5 && Res.abs(this.yFirst - this.y) < 5) {
                this.status = 2;
                this.frameIndex = 0;
                this.p1 = 0;
                this.p2 = 0;
            }
        }
    }

    public static int getDistance(int x1, int y2, int x2, int y23) {
        int value = x1 - x2;
        y2 -= y23;
        x1 = value;
        if ((x1 = value * x1 + y2 * y2) <= 0) {
            return 0;
        }
        y2 = (x1 + 1) / 2;
        do {
            x2 = y2;
            y2 = y2 / 2 + x1 / (y2 * 2);
        } while (Math.abs(x2 - y2) > 1);
        return y2;
    }

    private void updateMobWalk() {
        try {
            if (this.injureThenDie) {
                this.status = 1;
                this.p2 = this.injureBy.cdir << 3;
                this.p1 = -5;
                this.p3 = 0;
            }
            if (this.isIce) {
                return;
            }
            if (this.isDontMove || this.isWind) {
                this.frame = 0;
                return;
            }
            switch(arrMobTemplate[this.templateId].type) {
                case 0:
                    if (this.templateId == 176) {
                        this.status = 9;
                    }
                    this.frame = 0;
                    return;
                case 1:
                case 2:
                case 3:
                    byte byteValue = arrMobTemplate[this.templateId].speed;
                    if (arrMobTemplate[this.templateId].speed == 1) {
                        if (GameCanvas.gameTick % 2 == 1) {
                            return;
                        }
                    } else if (byteValue > 2) {
                        byteValue = (byte) (byteValue + this.mobId % 2);
                    } else if (GameCanvas.gameTick % 2 == 1 && arrMobTemplate[this.templateId].speed != 0) {
                        byteValue--;
                    }
                    this.x = this.x + byteValue * this.dir;
                    if (Res.random(0, arrMobTemplate[this.templateId].rangeMove) == arrMobTemplate[this.templateId].rangeMove / 3) {
                        this.status = 2;
                        this.timeCurrent = System.currentTimeMillis();
                    }
                    if (this.x > this.xFirst + arrMobTemplate[this.templateId].rangeMove) {
                        this.dir = -1;
                        if (this.templateId == 168 || this.templateId == 177) {
                            this.status = 9;
                            this.p1 = 0;
                        }
                    } else if (this.x < this.xFirst - arrMobTemplate[this.templateId].rangeMove) {
                        this.dir = 1;
                        if (this.templateId == 168 || this.templateId == 177) {
                            this.status = 9;
                            this.p1 = 0;
                        }
                    }
                    if (!this.isBoss) {
                        if (this.templateId < 168) {
                            this.frame = GameCanvas.gameTick % 4 > 1 ? 0 : 1;
                            return;
                        }
                        this.frame = this.setFrameMove(GameCanvas.gameTick);
                        return;
                    }
                    this.frame = arrMobTemplate[this.templateId].frameBossMove[this.frameIndex];
                    return;
                case 4:
                    if (this.templateId < 236) {
                        byte byteValue1 = arrMobTemplate[this.templateId].speed;
                        byteValue1 = (byte) (arrMobTemplate[this.templateId].speed + this.mobId % 2);
                        this.x = this.x + byteValue1 * this.dir;
                        if (GameCanvas.gameTick % 10 > 2 && this.templateId != 205 && this.templateId != 206 && this.templateId != 207 && this.templateId != 208) {
                            this.indexlongden = -1;
                            this.y = this.y + byteValue1 * this.dirV;
                        }
                        if (this.x > this.xFirst + arrMobTemplate[this.templateId].rangeMove) {
                            this.dir = -1;
                            if (this.templateId == 179 || this.templateId == 175) {
                                this.status = 9;
                            }
                            this.p1 = 0;
                        } else if (this.x < this.xFirst - arrMobTemplate[this.templateId].rangeMove) {
                            this.dir = 1;
                            if (this.templateId == 179 || this.templateId == 175) {
                                this.status = 9;
                            }
                            this.p1 = 0;
                        }
                        if (this.y > this.yFirst + 24) {
                            this.dirV = -1;
                        } else if (this.y < this.yFirst - (20 + GameCanvas.gameTick % 10)) {
                            this.dirV = 1;
                        }
                        if (this.isBoss) {
                            this.frame = arrMobTemplate[this.templateId].frameBossMove[this.frameIndex];
                            return;
                        }
                        if (this.templateId < 168) {
                            this.frame = GameCanvas.gameTick % 4 > 1 ? 0 : 1;
                        } else {
                            this.frame = this.setFrameMove(GameCanvas.gameTick);
                        }
                        break;
                    } else {
                        if (this.owner != null) {
                            byte byteValue2 = arrMobTemplate[this.templateId].speed;
                            byte byteValue3 = arrMobTemplate[this.templateId].speed;
                            if (this.owner.statusMe != 1 && this.owner.statusMe != 6 && getDistance(this.x, this.y, this.owner.cx, this.owner.cy) > arrMobTemplate[this.templateId].rangeMove) {
                                byteValue2 = (byte) (arrMobTemplate[this.templateId].speed + 2);
                            }
                            byteValue2 = (byte) (byteValue2 + this.mobId % 2);
                            byteValue3 = (byte) (byteValue3 + this.mobId % 2);
                            if (this.owner.statusMe != 1 && this.owner.statusMe != 6) {
                                this.isleft = false;
                                this.isright = false;
                                if (this.x > this.xFirst + arrMobTemplate[this.templateId].rangeMove) {
                                    this.dir = -1;
                                    if (this.templateId == 179 || this.templateId == 175) {
                                        this.status = 9;
                                    }
                                    this.p1 = 0;
                                } else if (this.x < this.xFirst - arrMobTemplate[this.templateId].rangeMove) {
                                    this.dir = 1;
                                    if (this.templateId == 179 || this.templateId == 175) {
                                        this.status = 9;
                                    }
                                    this.p1 = 0;
                                }
                            } else if (this.x - this.xFirst >= arrMobTemplate[this.templateId].rangeMove) {
                                this.isright = true;
                                this.isleft = false;
                            } else if (this.xFirst - this.x >= arrMobTemplate[this.templateId].rangeMove) {
                                this.isleft = true;
                                this.isright = false;
                            }
                            if (this.isright) {
                                this.dir = -1;
                            }
                            if (this.isleft) {
                                this.dir = 1;
                            }
                            this.x = this.x + byteValue2 * this.dir;
                            if (GameCanvas.gameTick % 10 > 2 && this.templateId != 205 && this.templateId != 206 && this.templateId != 207 && this.templateId != 208) {
                                this.indexlongden = -1;
                                this.y = this.y + byteValue3 * this.dirV;
                            }
                            if (this.y > this.yFirst + 24) {
                                this.dirV = -1;
                            } else if (this.y < this.yFirst - (20 + GameCanvas.gameTick % 10)) {
                                this.dirV = 1;
                            }
                            if (!this.isBoss) {
                                if (this.templateId < 168) {
                                    this.frame = GameCanvas.gameTick % 4 > 1 ? 0 : 1;
                                    break;
                                }
                                this.frame = this.setFrameMove(GameCanvas.gameTick);
                            }
                        }
                        return;
                    }
                case 5:
                    byte byteValue4 = arrMobTemplate[this.templateId].speed;
                    byteValue4 = (byte) (arrMobTemplate[this.templateId].speed + this.mobId % 2);
                    this.x = this.x + byteValue4 * this.dir;
                    byteValue4 = (byte) (byteValue4 + (GameCanvas.gameTick + this.mobId) % 2);
                    if (GameCanvas.gameTick % 10 > 2) {
                        this.y = this.y + byteValue4 * this.dirV;
                    }
                    if (this.x > this.xFirst + arrMobTemplate[this.templateId].rangeMove) {
                        this.dir = -1;
                        if (this.templateId != 179 && this.templateId != 175) {
                            this.status = 2;
                        } else {
                            this.status = 9;
                        }
                        this.p1 = 0;
                    } else if (this.x < this.xFirst - arrMobTemplate[this.templateId].rangeMove) {
                        this.dir = 1;
                        if (this.templateId != 179 && this.templateId != 175) {
                            this.status = 2;
                        } else {
                            this.status = 9;
                        }
                        this.p1 = 0;
                    }
                    if (this.y > this.yFirst + 24) {
                        this.dirV = -1;
                    } else if (this.y < this.yFirst - (20 + GameCanvas.gameTick % 10)) {
                        this.dirV = 1;
                    }
                    if (TileMap.tileTypeAt(this.x, this.y, 2)) {
                        if (GameCanvas.gameTick % 10 > 5) {
                            this.y = TileMap.tileYofPixel(this.y);
                            this.status = 4;
                            this.p1 = 0;
                        }
                        this.dirV = -1;
                    }
                    if (!this.isBoss) {
                        if (this.templateId < 168) {
                            this.frame = GameCanvas.gameTick % 4 > 1 ? 3 : 1;
                            return;
                        }
                        this.frame = this.setFrameMove(GameCanvas.gameTick);
                        return;
                    }
                    this.frame = arrMobTemplate[this.templateId].frameBossMove[this.frameIndex];
                default:
                    return;
            }
        } catch (Exception exception) {
        }
    }

    public final MobTemplate getTemplate() {
        return arrMobTemplate[this.templateId];
    }

    public final boolean isPaint() {
        if (this.x < GameScr.cmx) {
            return false;
        }
        if (this.x > GameScr.cmx + GameScr.gW) {
            return false;
        }
        if (this.y < GameScr.cmy) {
            return false;
        }
        if (this.y > GameScr.cmy + GameScr.gH + 30) {
            return false;
        }
        if (arrMobTemplate[this.templateId] == null) {
            return false;
        }
        if (!this.isBoss) {
            if (this.frame >= arrMobTemplate[this.templateId].imgs.length) {
                return false;
            }
            if (arrMobTemplate[this.templateId].imgs[this.frame] == null) {
                return false;
            }
            if (this.templateId != 179 && this.templateId != 175 && this.templateId != 202) {
                if (this.templateId == 176 && (this.frame == 1 || this.frame == 0)) {
                    return false;
                }
            } else if (this.status == 8) {
                return false;
            }
        }
        return this.status != 0;
    }

    public final void paint(mGraphics g) {
        try {
            if (arrMobTemplate[this.templateId].type == 7) {
                this.dir = 0;
            }
        } catch (Exception exception) {
        }
        if (this.isPaint()) {
            int value = this.y;
            if (this.templateId == 205 || this.templateId == 206 || this.templateId == 207 || this.templateId == 208) {
                this.indexlongden++;
                if (this.indexlongden > Char.locate.length - 1) {
                    this.indexlongden = 0;
                }
            }
            if (this.indexlongden > -1) {
                value += Char.locate[this.indexlongden];
            }
            MobTemplate mobTemplate = arrMobTemplate[this.templateId];
            if (!this.isBoss) {
                if (this.w == 0) {
                    this.w = mGraphics.getImageWidth(mobTemplate.imgs[0]);
                }
                if (this.h == 0) {
                    this.h = mGraphics.getImageHeight(mobTemplate.imgs[0]);
                }
            } else {
                this.w = 40;
                this.h = 40;
            }
            this.paintBottomDataEff(g, this.x, value, 0);
            try {
                int value1 = this.dir > 0 ? 0 : 2;
                if (this.templateId == 219) {
                    value1 = 0;
                }
                if ((this.templateId == 98 || this.templateId == 99) && this.status == 1) {
                    long longValue;
                    if ((longValue = System.currentTimeMillis()) - this.timeStartDie < 400L) {
                        g.drawRegion(mobTemplate.imgs[this.frame], 0, 0, mGraphics.getImageWidth(mobTemplate.imgs[this.frame]), mGraphics.getImageHeight(mobTemplate.imgs[this.frame]), value1, this.x, value, StaticObj.BOTTOM_HCENTER);
                    } else if (longValue - this.timeStartDie < 800L) {
                        g.drawRegion(mobTemplate.imgs[this.frame], 0, 0, mGraphics.getImageWidth(mobTemplate.imgs[this.frame]), 3 * mGraphics.getImageHeight(mobTemplate.imgs[this.frame]) / 5, value1, this.x, value, StaticObj.BOTTOM_HCENTER);
                    } else if (longValue - this.timeStartDie < 1200L) {
                        g.drawRegion(mobTemplate.imgs[this.frame], 0, 0, mGraphics.getImageWidth(mobTemplate.imgs[this.frame]), mGraphics.getImageHeight(mobTemplate.imgs[this.frame]) / 3, value1, this.x, value, StaticObj.BOTTOM_HCENTER);
                    }
                    if (GameCanvas.gameTick % 8 < 2) {
                        SmallImage.drawSmallImage(g, 457, this.x, value, 0, StaticObj.BOTTOM_HCENTER);
                    } else if (GameCanvas.gameTick % 8 < 4) {
                        SmallImage.drawSmallImage(g, 458, this.x, value, 0, StaticObj.BOTTOM_HCENTER);
                    } else if (GameCanvas.gameTick % 8 < 6) {
                        SmallImage.drawSmallImage(g, 459, this.x, value, 0, StaticObj.BOTTOM_HCENTER);
                    }
                } else if (this.isBoss) {
                    if (this.getTemplate().frameBoss != null) {
                        if (this.templateId < 236) {
                            Frame frame2 = this.getTemplate().frameBoss[this.frame];
                            for (int index = 0; index < frame2.dx.length; index++) {
                                MobTemplate mobTemplate3 = this.getTemplate();
                                byte byteValue = frame2.idImg[index];
                                ImageInfo imageInfo = mobTemplate3.imginfo[byteValue];
                                if (this.dir > 0) {
                                    g.drawRegion(this.getTemplate().imgs[0], imageInfo.x0, imageInfo.y0, imageInfo.w, imageInfo.h, 0, this.x + frame2.dx[index], value + frame2.dy[index] - 1, 20);
                                } else {
                                    g.drawRegion(this.getTemplate().imgs[0], imageInfo.x0, imageInfo.y0, imageInfo.w, imageInfo.h, 2, this.x - frame2.dx[index], value + frame2.dy[index] - 1, 24);
                                }
                            }
                        } else {
                            mGraphics graphics = g;
                            Mob mob = this;
                            try {
                                if (GameCanvas.gameTick % 2 == 0 && mob.status != 3) {
                                    mob.bossMoveFrameIndex++;
                                    if (mob.bossMoveFrameIndex > mob.getTemplate().frameBossMove.length - 1) {
                                        mob.bossMoveFrameIndex = 0;
                                    }
                                    mob.frame = mob.getTemplate().frameBossMove[mob.bossMoveFrameIndex];
                                }
                                Frame frame4 = mob.getTemplate().frameBoss[mob.frame];
                                for (int index5 = 0; index5 < frame4.dx.length; index5++) {
                                    if (frame4.onTop[index5] != 0) {
                                        MobTemplate mobTemplate6 = mob.getTemplate();
                                        int value7 = frame4.idImg[index5];
                                        ImageInfo imageInfo8;
                                        value7 = (imageInfo8 = mobTemplate6.imginfo[value7]).x0;
                                        int value9 = imageInfo8.y0;
                                        int value10 = imageInfo8.w;
                                        int value11 = imageInfo8.h;
                                        int value12 = frame4.dx[index5];
                                        short shortValue = frame4.dy[index5];
                                        if (value7 > mob.getTemplate().imgs[0].getWidth()) {
                                            value7 = 0;
                                        }
                                        if (value9 > mob.getTemplate().imgs[0].getHeight()) {
                                            value9 = 0;
                                        }
                                        if (value7 + value10 > mob.getTemplate().imgs[0].getWidth()) {
                                            value10 = mob.getTemplate().imgs[0].getWidth() - value7;
                                        }
                                        if (value9 + value11 > mob.getTemplate().imgs[0].getHeight()) {
                                            value11 = mob.getTemplate().imgs[0].getHeight() - value9;
                                        }
                                        int value13 = frame4.flip[index5] == 1 ? 2 : 0;
                                        if (mob.dir == 1) {
                                            if (value13 == 2) {
                                                value13 = 0;
                                                value12 += value10;
                                            } else {
                                                value13 = 2;
                                                value12 = -(value12 + value10);
                                            }
                                        }
                                        graphics.drawRegion(mob.getTemplate().imgs[0], value7, value9, value10, value11, value13, mob.x + value12, mob.y + shortValue, 0);
                                    }
                                }
                            } catch (Exception exception27) {
                                exception27.printStackTrace();
                                System.err.println("Err paintTopMobNew:" + mob.templateId);
                            }
                            this.paintBottomMobNew(g);
                        }
                    }
                } else if (this.templateId == 168 && this.status != 8) {
                    g.drawRegion(mobTemplate.imgs[this.frame], 0, 0, mGraphics.getImageWidth(mobTemplate.imgs[this.frame]), mGraphics.getImageHeight(mobTemplate.imgs[this.frame]), value1, this.x, value, StaticObj.BOTTOM_HCENTER);
                } else {
                    g.drawRegion(mobTemplate.imgs[this.frame], 0, 0, mGraphics.getImageWidth(mobTemplate.imgs[this.frame]), mGraphics.getImageHeight(mobTemplate.imgs[this.frame]), value1, this.x, value, StaticObj.BOTTOM_HCENTER);
                }
                this.paintTopDataEff(g, this.x, value, 0);
            } catch (Exception exception28) {
                exception28.printStackTrace();
            }
            int value14 = value;
            if (Char.getMyChar().mobFocus != null && Char.getMyChar().mobFocus.equals(this) && this.status != 1) {
                if (this.isBoss) {
                    int value15 = this.maxHp;
                    if (this.maxHp < this.hp) {
                        value15 = this.hp;
                    }
                    int value16 = (int) (this.hp * 100L / value15);
                    int value17 = this.w;
                    byte byteValue18 = 4;
                    if (this.levelBoss == 1 || this.levelBoss == 2 || this.levelBoss == 3 || this.isBoss) {
                        byteValue18 = 6;
                        value17 += value17 / 2;
                    }
                    int value19 = value17 + 2;
                    if ((value16 = value19 * value16 / 100) < 2) {
                        value16 = 2;
                    }
                    if (this.templateId == 140 || this.templateId == 160) {
                        value14 -= 20;
                    }
                    if (this.templateId != 142 && this.templateId != 143) {
                        g.setColor(16777215);
                        g.fillRect(this.x - value19 / 2 - 1, value14 - this.h - 12, value19, byteValue18);
                        g.setColor(this.getHPColor());
                        g.fillRect(this.x - value19 / 2 - 1, value14 - this.h - 12, value16, byteValue18);
                        g.setColor(0);
                        g.drawRect(this.x - value19 / 2 - 1, value14 - this.h - 12, value19, byteValue18);
                    } else {
                        SmallImage.drawSmallImage(g, 988, this.x, value14 - this.h, 0, 33);
                    }
                } else {
                    int value20 = this.maxHp;
                    if (this.maxHp < this.hp) {
                        value20 = this.hp;
                    }
                    int value21 = (int) (this.hp * 100L / value20);
                    int value22 = this.w;
                    if (this.templateId > 167) {
                        value22 = this.w / 2;
                    }
                    byte byteValue23 = 4;
                    if (this.levelBoss == 1 || this.levelBoss == 2 || this.levelBoss == 3 || this.isBoss) {
                        byteValue23 = 6;
                        value22 += value22 / 2;
                    }
                    int value24 = value22 + 2;
                    if ((value21 = value24 * value21 / 100) < 2) {
                        value21 = 2;
                    }
                    if (this.templateId == 140 || this.templateId == 160) {
                        value14 -= 20;
                    }
                    if (this.templateId != 142 && this.templateId != 143) {
                        g.setColor(16777215);
                        g.fillRect(this.x - value24 / 2 - 1, value14 - this.h - 12, value24, byteValue23);
                        g.setColor(this.getHPColor());
                        g.fillRect(this.x - value24 / 2 - 1, value14 - this.h - 12, value21, byteValue23);
                        g.setColor(0);
                        g.drawRect(this.x - value24 / 2 - 1, value14 - this.h - 12, value24, byteValue23);
                    } else {
                        SmallImage.drawSmallImage(g, 988, this.x, value14 - this.h, 0, 33);
                    }
                }
                if (this.levelBoss > 0) {
                    if (this.levelBoss == 1) {
                        mFont.tahoma_7_yellow.drawString(g, mResources.BOSS[this.levelBoss], this.x, value14 - this.h - 26, 2, mFont.tahoma_7_grey);
                    } else if (this.levelBoss == 2) {
                        mFont.tahoma_7_yellow.drawString(g, mResources.BOSS[this.levelBoss], this.x, value14 - this.h - 26, 2, mFont.tahoma_7_grey);
                    } else if (this.levelBoss == 3) {
                        mFont.tahoma_7_blue1.drawString(g, mResources.BOSS[this.levelBoss], this.x, value14 - this.h - 26, 2, mFont.tahoma_7_grey);
                    }
                    if (this.isDisable) {
                        SmallImage.drawSmallImage(g, 494, this.x, value14 - this.h - 28, 0, 33);
                    }
                } else if (this.isDisable) {
                    SmallImage.drawSmallImage(g, 494, this.x, value14 - this.h - 15, 0, 33);
                }
            } else if (this.levelBoss > 0) {
                if (this.levelBoss == 1) {
                    mFont.tahoma_7_yellow.drawString(g, mResources.BOSS[this.levelBoss], this.x, value14 - this.h - 20, 2, mFont.tahoma_7_grey);
                } else if (this.levelBoss == 2) {
                    mFont.tahoma_7_yellow.drawString(g, mResources.BOSS[this.levelBoss], this.x, value14 - this.h - 20, 2, mFont.tahoma_7_grey);
                } else if (this.levelBoss == 3) {
                    mFont.tahoma_7_blue1.drawString(g, mResources.BOSS[this.levelBoss], this.x, value14 - this.h - 20, 2, mFont.tahoma_7_grey);
                }
                if (this.isDisable) {
                    SmallImage.drawSmallImage(g, 494, this.x, value14 - this.h - 22, 0, 33);
                }
            } else if (this.isDisable) {
                SmallImage.drawSmallImage(g, 494, this.x, value - this.h - 5, 0, 33);
            }
            if (this.isDontMove) {
                if (GameCanvas.gameTick % 2 == 0) {
                    SmallImage.drawSmallImage(g, 1082, this.x, value - this.h / 2, 0, 3);
                } else {
                    SmallImage.drawSmallImage(g, 1084, this.x, value - this.h / 2, 0, 3);
                }
            }
            if (this.isIce) {
                SmallImage.drawSmallImage(g, 290, this.x, value, 0, 33);
            }
            if (this.isWind) {
                int value25;
                if ((value25 = GameCanvas.gameTick % 6) == 0 || value25 == 1) {
                    SmallImage.drawSmallImage(g, 998, this.x, value - this.h - 5, 0, 3);
                } else if (value25 == 2 || value25 == 3) {
                    SmallImage.drawSmallImage(g, 999, this.x, value - this.h - 5, 0, 3);
                } else if (value25 == 4 || value25 == 5) {
                    SmallImage.drawSmallImage(g, 1000, this.x, value - this.h - 5, 0, 3);
                }
            }
            if (this.isFire) {
                int value26;
                if ((value26 = GameCanvas.gameTick % 16) == 0) {
                    SmallImage.drawSmallImage(g, 1013, this.x - this.w / 2, value - this.h + this.h / 4, 0, 3);
                    return;
                }
                if (value26 == 1) {
                    SmallImage.drawSmallImage(g, 1014, this.x - this.w / 2, value - this.h + this.h / 4, 0, 3);
                    return;
                }
                if (value26 == 2) {
                    SmallImage.drawSmallImage(g, 1015, this.x - this.w / 2, value - this.h + this.h / 4, 0, 3);
                    return;
                }
                if (value26 == 3) {
                    SmallImage.drawSmallImage(g, 1016, this.x - this.w / 2, value - this.h + this.h / 4, 0, 3);
                    return;
                }
                if (value26 == 4) {
                    SmallImage.drawSmallImage(g, 1013, this.x + this.w / 2, value - this.h, 0, 3);
                    return;
                }
                if (value26 == 5) {
                    SmallImage.drawSmallImage(g, 1014, this.x + this.w / 2, value - this.h, 0, 3);
                    return;
                }
                if (value26 == 6) {
                    SmallImage.drawSmallImage(g, 1015, this.x + this.w / 2, value - this.h, 0, 3);
                    return;
                }
                if (value26 == 7) {
                    SmallImage.drawSmallImage(g, 1016, this.x + this.w / 2, value - this.h, 0, 3);
                    return;
                }
                if (value26 == 8) {
                    SmallImage.drawSmallImage(g, 1013, this.x - this.w / 2, value, 0, 3);
                    return;
                }
                if (value26 == 9) {
                    SmallImage.drawSmallImage(g, 1014, this.x - this.w / 2, value, 0, 3);
                    return;
                }
                if (value26 == 10) {
                    SmallImage.drawSmallImage(g, 1015, this.x - this.w / 2, value, 0, 3);
                    return;
                }
                if (value26 == 11) {
                    SmallImage.drawSmallImage(g, 1016, this.x - this.w / 2, value, 0, 3);
                    return;
                }
                if (value26 == 12) {
                    SmallImage.drawSmallImage(g, 1013, this.x + this.w / 2, value - this.h / 4, 0, 3);
                    return;
                }
                if (value26 == 13) {
                    SmallImage.drawSmallImage(g, 1014, this.x + this.w / 2, value - this.h / 4, 0, 3);
                    return;
                }
                if (value26 == 14) {
                    SmallImage.drawSmallImage(g, 1015, this.x + this.w / 2, value - this.h / 4, 0, 3);
                    return;
                }
                if (value26 == 15) {
                    SmallImage.drawSmallImage(g, 1016, this.x + this.w / 2, value - this.h / 4, 0, 3);
                }
            }
        }
    }

    public final int getHPColor() {
        if (this.sys <= 1) {
            return 16711680;
        } else if (this.sys == 2) {
            return 33023;
        } else {
            return this.sys == 3 ? 7443811 : 16711680;
        }
    }

    public final void startDie() {
        this.hp = 0;
        this.timeStartDie = System.currentTimeMillis();
        if (this.injureBy != null) {
            this.injureThenDie = true;
        } else {
            this.injureThenDie = true;
            this.hp = 0;
            this.status = 1;
            this.p1 = -5;
            this.p2 = -this.dir << 2;
            this.p3 = 0;
        }
    }

    public final void attackOtherMob(Mob mobToAttack1) {
        this.mobToAttack = mobToAttack1;
    }

    public final void attackOtherChar(Char character) {
        this.charToAttack = character;
    }

    private void setatk_mob() {
        if (this.mobToAttack != null) {
            if (this.isBoss) {
                this.status = 3;
            } else {
                int value = this.mobToAttack.x - this.x;
                int value1 = this.mobToAttack.y - this.y;
                this.x += value / 4;
                this.y += value1 / 4;
                this.dir = this.x >= this.mobToAttack.x ? 0 : 1;
                if (this.mobToAttack.status == 1 || this.mobToAttack.status == 0 || Res.abs(value) < 20 && Res.abs(value1) < 20) {
                    if (this.typeTool == 0) {
                        ServerEffect.addServerEffect(this.idSkill_atk == -1 ? 59 : this.idSkill_atk, this.mobToAttack.x, this.mobToAttack.y, this.dir == 0 ? -1 : 1);
                    } else if (this.typeTool == 1 && this.idSkill_atk > -1) {
                        EffectAuto.addEffectAuto(this.idSkill_atk, this.mobToAttack.x, this.mobToAttack.y, (byte) 1, (short) -1, this.dir == 0 ? -1 : 1);
                    }
                    this.mobToAttack = null;
                }
            }
        }
        if (this.charToAttack != null) {
            if (this.isBoss) {
                this.status = 3;
                return;
            }
            int value2 = this.charToAttack.cx - this.x;
            int value3 = this.charToAttack.cy - this.y;
            this.x += value2 / 4;
            this.y += value3 / 4;
            this.dir = this.x >= this.charToAttack.cx ? 0 : 1;
            if (this.charToAttack.statusMe == 5 || this.charToAttack.statusMe == 14 || Res.abs(value2) < 20 && Res.abs(value3) < 20) {
                if (this.typeTool == 0) {
                    ServerEffect.addServerEffect(this.idSkill_atk == -1 ? 59 : this.idSkill_atk, this.charToAttack.cx, this.charToAttack.cy, this.dir == 0 ? -1 : 1);
                } else if (this.typeTool == 1 && this.idSkill_atk > -1) {
                    EffectAuto.addEffectAuto(this.idSkill_atk, this.charToAttack.cx, this.charToAttack.cy, (byte) 1, (short) -1, this.dir == 0 ? -1 : 1);
                }
                this.charToAttack = null;
            }
        }
    }

    public final void setTypeAtk(short idSkill_atk1, byte typeAtk2, byte typeTool3) {
        this.idSkill_atk = idSkill_atk1;
        this.typeAtk = typeAtk2;
        this.typeTool = typeTool3;
    }

    public final void attackOtherInRange() {
        if (this.templateId == 116) {
            ServerEffect.addServerEffect(84, Char.getMyChar(), 1);
        } else if (this.templateId == 115) {
            ServerEffect.addServerEffect(81, Char.getMyChar(), 1);
        } else if (this.templateId == 138) {
            ServerEffect.addServerEffect(90, Char.getMyChar(), 1);
        } else if (this.templateId == 139) {
            ServerEffect.addServerEffect(91, Char.getMyChar(), 1);
        } else if (this.templateId == 140 || this.templateId == 161) {
            ServerEffect.addServerEffect(110, Char.getMyChar(), 2);
        } else if (this.templateId == 141 || this.templateId == 162) {
            ServerEffect.addServerEffect(121, Char.getMyChar(), 1);
        } else if (this.templateId == 144 || this.templateId == 163) {
            ServerEffect.addServerEffect(121, Char.getMyChar(), 1);
        } else if (this.templateId == 160) {
            ServerEffect.addServerEffect(124, Char.getMyChar(), 1);
        } else if (this.templateId == 164 || this.templateId == 165) {
            ServerEffect.addServerEffect(126, this.cFocus, 1);
        } else if (this.templateId == 166) {
            ServerEffect.addServerEffect(103, this.cFocus, 1);
        } else {
            if (this.templateId == 166) {
                ServerEffect.addServerEffect(105, this.cFocus, 1);
            }
        }
    }

    private int setFrameMove(int Gametick) {
        Gametick %= idframe[this.templateId - 168].length;
        return this.templateId != 198 && this.templateId != 199 && this.templateId != 200 && this.templateId != 201 && this.templateId != 203 && this.templateId != 204 ? idframe[this.templateId - 168][Gametick] : 0;
    }

    private int setFrameAppear(int value) {
        try {
            value %= nso.Mob.idframeAppear[this.templateId - 168].length;
            return nso.Mob.idframeAppear[this.templateId - 168][value];
        } catch (Exception exception) {
            return 0;
        }
    }

    private int setFrameAtt(int Gametick) {
        Gametick %= 5;
        if (this.templateId == 178) {
            switch(Gametick) {
                case 0:
                    return 5;
                case 1:
                    return 6;
                case 2:
                    return 7;
                case 3:
                    return 8;
            }
        } else if (this.templateId == 168) {
            switch(Gametick) {
                case 0:
                    return 1;
                case 1:
                    return 2;
                case 2:
                    return 3;
                case 3:
                    return 4;
                case 4:
                    return 5;
            }
        } else if (this.templateId == 179) {
            switch(Gametick) {
                case 0:
                    return 0;
                case 1:
                    return 2;
                case 2:
                    return 3;
                case 3:
                    return 4;
                case 4:
                    return 5;
            }
        } else if (this.templateId == 175) {
            switch(Gametick) {
                case 0:
                    return 0;
                case 1:
                    return 2;
                case 2:
                    return 3;
                case 3:
                    return 4;
                case 4:
                    return 5;
            }
        } else if (this.templateId == 176) {
            switch(Gametick) {
                case 0:
                    return 2;
                case 1:
                    return 3;
                case 2:
                    return 4;
                case 3:
                    return 5;
                case 4:
                    return 6;
            }
        } else if (this.templateId == 177) {
            switch(Gametick) {
                case 0:
                    return 1;
                case 1:
                    return 2;
                case 2:
                    return 3;
                case 3:
                    return 4;
                case 4:
                    return 5;
            }
        } else if (this.templateId == 174) {
            switch(Gametick) {
                case 0:
                    return 5;
                case 1:
                    return 6;
                case 2:
                    return 7;
                case 3:
                    return 8;
                case 4:
                    return 9;
            }
        }
        return 0;
    }

    private int setFrameDisappear(int value) {
        try {
            value %= nso.Mob.idframeDisappear[this.templateId - 168].length;
            return nso.Mob.idframeDisappear[this.templateId - 168][value];
        } catch (Exception exception) {
            return 0;
        }
    }

    private void updateAttk_Thunuoi() {
        if (this.p1 == 0) {
            int value = 0;
            int value1 = 0;
            if (this.mobToAttack != null) {
                value = this.mobToAttack.x;
                value1 = this.mobToAttack.y;
            }
            if (this.charToAttack != null) {
                value = this.charToAttack.cx;
                value1 = this.charToAttack.cy;
            }
            this.typeAtt = this.typeAtk;
            this.dir = this.x >= value ? 0 : 1;
            if (this.isBoss) {
                this.frameIndex++;
                if (this.frameIndex >= arrMobTemplate[this.templateId].frameBossAttack[this.typeAtt].length) {
                    this.frameIndex = 0;
                    this.status = 2;
                    this.mobToAttack = null;
                    this.charToAttack = null;
                    this.p1 = 0;
                    this.p2 = 0;
                }
                if (this.frameIndex == arrMobTemplate[this.templateId].frameBossAttack[this.typeAtt].length - 2) {
                    if (this.typeTool == 0) {
                        ServerEffect.addServerEffect(this.idSkill_atk == -1 ? 59 : this.idSkill_atk, value, value1, 1, (byte) (this.dir == 0 ? -1 : 1));
                    } else if (this.typeTool == 1 && this.idSkill_atk > -1) {
                        EffectAuto.addEffectAuto(this.idSkill_atk, value, value1, (byte) 1, (short) -1, this.dir == 0 ? -1 : 1);
                    }
                }
                this.frame = arrMobTemplate[this.templateId].frameBossAttack[this.typeAtk][this.frameIndex];
            }
            if (arrMobTemplate[this.templateId].type != 0 && !this.isDontMove && this.isIce && this.isWind) {
                this.x = this.x + (value - this.x) / 3;
            }
            if (this.x > this.xFirst + arrMobTemplate[this.templateId].rangeMove) {
                this.p1 = 1;
            }
            if (this.x < this.xFirst - arrMobTemplate[this.templateId].rangeMove) {
                this.p1 = 1;
                return;
            }
        } else if (this.p1 == 1) {
            if (arrMobTemplate[this.templateId].type != 0 && !this.isDontMove && !this.isIce && !this.isWind) {
                this.x = this.x + (this.xFirst - this.x) / 4;
                this.y = this.y + (this.yFirst - this.y) / 4;
            }
            if (Res.abs(this.xFirst - this.x) < 5 && Res.abs(this.yFirst - this.y) < 5) {
                this.status = 2;
                this.frameIndex = 0;
                this.p1 = 0;
                this.p2 = 0;
            }
        }
    }

    public static Mob get_Mob(int ID) {
        for (int index = GameScr.vMob.size() - 1; index >= 0; index--) {
            Mob mob;
            if ((mob = (Mob) GameScr.vMob.elementAt(index)) != null && mob.mobId == ID) {
                return mob;
            }
        }
        return null;
    }

    public final void paintBoTomMobNew(mGraphics g, int x1, int y2) {
        try {
            if (GameCanvas.gameTick % 2 == 0 && this.status != 3) {
                this.bossMoveFrameIndex++;
                if (this.bossMoveFrameIndex > this.getTemplate().frameBossMove.length - 1) {
                    this.bossMoveFrameIndex = 0;
                }
                this.frame = this.getTemplate().frameBossMove[this.bossMoveFrameIndex];
            }
            Frame frame3 = this.getTemplate().frameBoss[this.frame];
            for (int index = 0; index < frame3.dx.length; index++) {
                if (frame3.onTop[index] != 0) {
                    MobTemplate mobTemplate = this.getTemplate();
                    int value = frame3.idImg[index];
                    ImageInfo imageInfo;
                    value = (imageInfo = mobTemplate.imginfo[value]).x0;
                    int value4 = imageInfo.y0;
                    int value5 = imageInfo.w;
                    int value6 = imageInfo.h;
                    int value7 = frame3.dx[index];
                    short shortValue = frame3.dy[index];
                    if (value > this.getTemplate().imgs[0].getWidth()) {
                        value = 0;
                    }
                    if (value4 > this.getTemplate().imgs[0].getHeight()) {
                        value4 = 0;
                    }
                    if (value + value5 > this.getTemplate().imgs[0].getWidth()) {
                        value5 = this.getTemplate().imgs[0].getWidth() - value;
                    }
                    if (value4 + value6 > this.getTemplate().imgs[0].getHeight()) {
                        value6 = this.getTemplate().imgs[0].getHeight() - value4;
                    }
                    value7 = -(value7 + value5);
                    g.drawRegion(this.getTemplate().imgs[0], value, value4, value5, value6, 2, x1 + value7, y2 + shortValue, 0);
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.err.println("Err paintTopMobNew:" + this.templateId);
        }
    }

    public final void paintTopMobNew(mGraphics g, int x1, int y2) {
        try {
            Frame frame3 = this.getTemplate().frameBoss[this.frame];
            for (int index = 0; index < frame3.dx.length; index++) {
                if (frame3.onTop[index] == 0) {
                    MobTemplate mobTemplate = this.getTemplate();
                    int value = frame3.idImg[index];
                    ImageInfo imageInfo;
                    value = (imageInfo = mobTemplate.imginfo[value]).x0;
                    int value4 = imageInfo.y0;
                    int value5 = imageInfo.w;
                    int value6 = imageInfo.h;
                    int value7 = frame3.dx[index];
                    short shortValue = frame3.dy[index];
                    if (value > this.getTemplate().imgs[0].getWidth()) {
                        value = 0;
                    }
                    if (value4 > this.getTemplate().imgs[0].getHeight()) {
                        value4 = 0;
                    }
                    if (value + value5 > this.getTemplate().imgs[0].getWidth()) {
                        value5 = this.getTemplate().imgs[0].getWidth() - value;
                    }
                    if (value4 + value6 > this.getTemplate().imgs[0].getHeight()) {
                        value6 = this.getTemplate().imgs[0].getHeight() - value4;
                    }
                    value7 = -(value7 + value5);
                    g.drawRegion(this.getTemplate().imgs[0], value, value4, value5, value6, 2, x1 + value7, y2 + shortValue, 0);
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.err.println("Err DataSkillEff  paintBottomEff:" + this.templateId);
        }
    }

    private void paintBottomMobNew(mGraphics graphics) {
        try {
            Frame frame1 = this.getTemplate().frameBoss[this.frame];
            for (int index = 0; index < frame1.dx.length; index++) {
                if (frame1.onTop[index] == 0) {
                    MobTemplate mobTemplate = this.getTemplate();
                    int value = frame1.idImg[index];
                    ImageInfo imageInfo;
                    value = (imageInfo = mobTemplate.imginfo[value]).x0;
                    int value2 = imageInfo.y0;
                    int value3 = imageInfo.w;
                    int value4 = imageInfo.h;
                    int value5 = frame1.dx[index];
                    short shortValue = frame1.dy[index];
                    if (value > this.getTemplate().imgs[0].getWidth()) {
                        value = 0;
                    }
                    if (value2 > this.getTemplate().imgs[0].getHeight()) {
                        value2 = 0;
                    }
                    if (value + value3 > this.getTemplate().imgs[0].getWidth()) {
                        value3 = this.getTemplate().imgs[0].getWidth() - value;
                    }
                    if (value2 + value4 > this.getTemplate().imgs[0].getHeight()) {
                        value4 = this.getTemplate().imgs[0].getHeight() - value2;
                    }
                    int value6 = frame1.flip[index] == 1 ? 2 : 0;
                    if (this.dir == 1) {
                        if (value6 == 2) {
                            value6 = 0;
                            value5 += value3;
                        } else {
                            value6 = 2;
                            value5 = -(value5 + value3);
                        }
                    }
                    graphics.drawRegion(this.getTemplate().imgs[0], value, value2, value3, value4, value6, this.x + value5, this.y + shortValue, 0);
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.err.println("Err DataSkillEff  paintBottomEff:" + this.templateId);
        }
    }
}
