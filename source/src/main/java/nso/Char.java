package nso;

import java.util.Enumeration;
import main.GameCanvas;

public class Char extends MainObject {

    public boolean isHuman;

    public boolean isNhanban;

    public boolean isCaptcha;

    private int tickEffWolf;

    private int timeBocdau;

    public long lastUpdateTime;

    public ChatPopup chatPopup;

    public long cEXP;

    public long cExpDown;

    private int lcx;

    private int lcy;

    public int cx;

    public int cy;

    public int cvx;

    public int cvy;

    public int cp1;

    private int cp2;

    private int cp3;

    public int statusMe;

    public int cdir;

    public int charID;

    public int cgender;

    public int ctaskId;

    public int cBonusSpeed;

    public int cspeed;

    public int cdame;

    public int cdameDown;

    public int clevel;

    public int cMP;

    public int cMaxMP;

    public int cHP;

    public int cHpNew;

    public int cMaxHP;

    private int cyStartFall;

    public int eff5BuffHp;

    public int eff5BuffMp;

    public long cExpR;

    public int pPoint;

    public int sPoint;

    public int pointUydanh;

    public int pointNon;

    public int pointVukhi;

    public int pointAo;

    public int pointLien;

    public int pointGangtay;

    public int pointNhan;

    public int pointQuan;

    public int pointNgocboi;

    public int pointGiay;

    public int pointPhu;

    public int pointTinhTu;

    public int countFinishDay;

    public int countLoopBoos;

    public int limitTiemnangso;

    public int limitKynangso;

    public int limitPhongLoi;

    public int limitBangHoa;

    public int countPB;

    public int[] potential;

    public String cName;

    public String cClanName;

    public byte ctypeClan;

    public static Clan clan;

    public int cw;

    public int ch;

    public int chw;

    public int chh;

    public boolean canJumpHigh;

    private boolean cmtoChar;

    public boolean me;

    public boolean isAttack;

    private boolean isAttFly;

    public int cf;

    private int tick;

    public boolean isMoto;

    public boolean isWolf;

    public boolean isMotoBehind;

    private boolean isBocdau;

    public boolean isNewMount;

    public int xu;

    public int xuInBox;

    public int yen;

    public int luong;

    public NClass nClass;

    public MyVector vSkill;

    public MyVector vSkillFight;

    public MyVector vEff;

    private MyVector vDomsang;

    public Skill myskill;

    public Task taskMaint;

    private boolean paintName;

    public Item[] arrItemBag;

    public Item[] arrItemBox;

    public Item[] arrItemBody;

    public Item[] arrItemMounts;

    public Item[] arrItemViThu;

    public short cResFire;

    public short cResIce;

    public short cResWind;

    public short cMiss;

    public short cExactly;

    public short cFatal;

    public byte cPk;

    public byte cTypePk;

    public short cReactDame;

    public short sysUp;

    public short sysDown;

    public Mob mobFocus;

    public Mob mobMe;

    public Mob mobVithu;

    public Npc npcFocus;

    public Char charFocus;

    public ItemMap itemFocus;

    public MyVector focus;

    public Mob[] attMobs;

    public Char[] attChars;

    public short[] moveFast;

    public int testCharId;

    public int killCharId;

    public byte resultTest;

    public int countKill;

    public int countKillMax;

    public int tickCoat;

    private int tickEffmoto;

    private int tickEffFireW;

    public boolean isInvisible;

    public static boolean isAHP;

    public static boolean isAMP;

    public static boolean isAFood;

    public static boolean isABuff;

    public static boolean isAPickYen;

    public static boolean isAPickYHM;

    public static boolean isAPickYHMS;

    public static boolean isANoPick;

    public static boolean isAResuscitate;

    public static boolean isAFocusDie;

    public static int aHpValue = 20;

    public static int aMpValue = 20;

    public static int aFoodValue = 70;

    public static int aCID;

    private long lastTimeUseSkill;

    public MyVector taskOrders;

    public static int pointPB;

    public static int pointChienTruong;

    private long timeStartBlink;

    public long timeSummon;

    public static final int[][][] CharInfo = new int[][][] { { { 0, -10, 32 }, { 1, -7, 7 }, { 1, -11, 15 }, { 1, -9, 45 } }, { { 0, -10, 33 }, { 1, -7, 7 }, { 1, -11, 16 }, { 1, -9, 46 } }, { { 1, -10, 33 }, { 2, -10, 11 }, { 2, -9, 16 }, { 1, -12, 49 } }, { { 1, -10, 32 }, { 3, -11, 9 }, { 3, -11, 16 }, { 1, -13, 47 } }, { { 1, -10, 34 }, { 4, -9, 9 }, { 4, -8, 16 }, { 1, -12, 47 } }, { { 1, -10, 34 }, { 5, -11, 11 }, { 5, -10, 17 }, { 1, -13, 49 } }, { { 1, -10, 33 }, { 6, -9, 9 }, { 6, -8, 16 }, { 1, -12, 47 } }, { { 0, -9, 36 }, { 7, -5, 15 }, { 7, -10, 21 }, { 1, -8, 49 } }, { { 4, -13, 26 }, new int[3], new int[3], new int[3] }, { { 5, -13, 25 }, new int[3], new int[3], new int[3] }, { { 6, -12, 26 }, new int[3], new int[3], new int[3] }, { { 7, -13, 25 }, new int[3], new int[3], new int[3] }, { { 0, -9, 35 }, { 8, -4, 13 }, { 8, -14, 27 }, { 1, -9, 49 } }, { { 0, -9, 31 }, { 9, -11, 8 }, { 10, -10, 17 }, new int[3] }, { { 2, -7, 33 }, { 9, -11, 8 }, { 11, -8, 15 }, new int[3] }, { { 2, -8, 32 }, { 9, -11, 8 }, { 12, -8, 14 }, new int[3] }, { { 2, -7, 32 }, { 9, -11, 8 }, { 13, -12, 15 }, new int[3] }, { { 0, -11, 31 }, { 9, -11, 8 }, { 14, -15, 18 }, new int[3] }, { { 2, -9, 32 }, { 9, -11, 8 }, { 15, -13, 19 }, new int[3] }, { { 2, -9, 31 }, { 9, -11, 8 }, { 16, -7, 22 }, new int[3] }, { { 2, -9, 32 }, { 9, -11, 8 }, { 17, -11, 18 }, new int[3] }, { { 3, -12, 34 }, { 8, -4, 13 }, { 8, -15, 25 }, { 1, -10, 46 } }, { { 0, -9, 32 }, { 8, -4, 9 }, { 10, -10, 18 }, new int[3] }, { { 2, -7, 34 }, { 8, -4, 9 }, { 11, -8, 16 }, new int[3] }, { { 2, -8, 33 }, { 8, -4, 9 }, { 12, -8, 15 }, new int[3] }, { { 2, -7, 33 }, { 8, -4, 9 }, { 13, -12, 16 }, new int[3] }, { { 0, -11, 32 }, { 7, -5, 9 }, { 14, -15, 19 }, new int[3] }, { { 2, -9, 33 }, { 7, -5, 9 }, { 15, -13, 20 }, new int[3] }, { { 2, -9, 32 }, { 7, -5, 9 }, { 16, -7, 23 }, new int[3] }, { { 2, -9, 33 }, { 7, -5, 9 }, { 17, -11, 19 }, new int[3] } };

    private static Char myChar;

    private int cvyJump;

    public int cxSend;

    public int cySend;

    public int cxMoveLast;

    public int cyMoveLast;

    public MyVector vMovePoints;

    public static boolean ischangingMap;

    public static boolean isLockKey;

    public boolean isLockMove;

    public boolean isLockAttack;

    public boolean isBlinking;

    public MovePoint currentMovePoint;

    private int count;

    private boolean isEffBatTu;

    private long lastUseHP;

    public int vitaWolf;

    private long timeSendmove;

    private static boolean isSendMove = true;

    private int cX0;

    private int cY0;

    private int FramecharRideHorse;

    private int inAir;

    private long currMove;

    private boolean isLastMove;

    public static byte[] locate = new byte[] { 0, 0, 0, -1, -1, -1, -2, -2, -2, -1, -1, -1 };

    private long timeLastCheck;

    private long timelastSendmove;

    private static short delaySendmove = 250;

    public short head;

    public short leg;

    public short body;

    public short wp;

    public short coat;

    public short glove;

    private int indexEff;

    public int indexEffTask;

    private EffectCharPaint eff;

    public EffectCharPaint effTask;

    private int indexSkill;

    private int i0;

    private int i1;

    private int i2;

    private int dx0;

    private int dx1;

    private int dx2;

    private int dy0;

    private int dy1;

    private int dy2;

    private EffectCharPaint eff0;

    private EffectCharPaint eff1;

    private EffectCharPaint eff2;

    public Arrow arr;

    public SkillPaint skillPaint;

    private EffectPaint[] effPaints;

    private int sType;

    private byte isInjure;

    private static mHashtable ALL_PART_EFF = new mHashtable();

    private int heightCharName;

    private int dxHead;

    private int dyHead;

    private int dxBody;

    private int dyBody;

    private int tickWolf;

    private int dy;

    private int hdx;

    private int hdy;

    private int[] idWolfW;

    private int FrameName;

    private int fName;

    private int FrameRank;

    private int fRank;

    private int FrameMatna;

    private int fMatNa;

    private int FrameBienHinh;

    private int fBienhinh;

    private int FrameWeaPone;

    private int fWeapone;

    private int FrameSusan;

    private int fsusan;

    private int FrameLeg;

    private int fLeg;

    private int FrameBody;

    private int fBody;

    private int FrameHair;

    private int fHair;

    public short ID_Body;

    public short ID_PP;

    public short ID_HAIR;

    public short ID_LEG;

    public short ID_HORSE;

    private short ID_NAME;

    private short ID_RANK;

    public short ID_MAT_NA;

    private short ID_Bien_Hinh;

    public short ID_WEA_PONE;

    public short ID_SUSANO;

    private byte ColorName;

    private static mFont[] color_font_name = new mFont[] { mFont.tahoma_7_white, mFont.tahoma_7_blue1, mFont.tahoma_7b_purple, mFont.tahoma_7b_yellow };

    private int FramePP;

    private int fPP;

    private int FrameHorse;

    private int fho;

    private byte[] ActionHorse;

    private int fHorseUI;

    private int fhorsetrangbi;

    private short[] fRun_PP;

    private int FbodyUI;

    private int FlegUI;

    private int fHeadUI;

    private int fPPUI;

    private byte fWeaponUI;

    private byte fMatNaUI;

    private int dynewhhorse;

    private int dxnewhorse;

    private byte frameFix;

    public static boolean isManualFocus = false;

    public short wdx;

    public short wdy;

    public boolean isDirtyPostion;

    public Skill lastNormalSkill;

    public boolean currentFireByShortcut;

    private int EffdefautX;

    private int EffdefautY;

    private int EffdefautX1;

    private int EffdefautY1;

    private int[][] frameMount;

    private int tickNewMount;

    private int fNewMount;

    private int dyMount;

    static {
        int[] var10000 = new int[] { -2, -6, 22, 21, 19, 22, 10, -2, -2, 5, 19 };
        var10000 = new int[] { 9, 22, 25, 17, 26, 37, 36, 49, 50, 52, 36 };
    }

    private int getdxSkill() {
        return this.myskill != null ? this.myskill.dx : 0;
    }

    private int getdySkill() {
        return this.myskill != null ? this.myskill.dy : 0;
    }

    public Char() {
        short[] values = new short[] { -1, -1, -1, -1 };
        this.tickEffWolf = 0;
        this.timeBocdau = 0;
        this.cx = 24;
        this.cy = 24;
        this.statusMe = 5;
        this.cdir = 1;
        this.potential = new int[4];
        new MyVector();
        this.cClanName = "";
        this.cw = 22;
        this.ch = 32;
        this.chw = 11;
        this.chh = 16;
        this.canJumpHigh = true;
        this.isMoto = false;
        this.isWolf = false;
        this.isBocdau = false;
        this.isNewMount = false;
        this.vSkill = new MyVector();
        this.vSkillFight = new MyVector();
        this.vEff = new MyVector();
        this.vDomsang = new MyVector();
        this.paintName = true;
        this.arrItemMounts = new Item[5];
        this.arrItemViThu = new Item[5];
        this.focus = new MyVector();
        this.testCharId = -9999;
        this.killCharId = -9999;
        this.lastTimeUseSkill = 0L;
        this.taskOrders = new MyVector();
        this.vMovePoints = new MyVector();
        this.count = 0;
        this.lastUseHP = System.currentTimeMillis();
        this.vitaWolf = 0;
        this.currMove = 0L;
        this.isLastMove = false;
        this.coat = -1;
        this.glove = -1;
        this.indexEff = -1;
        this.indexEffTask = -1;
        this.eff0 = null;
        this.eff1 = null;
        this.eff2 = null;
        this.arr = null;
        this.heightCharName = 0;
        this.dxHead = 0;
        this.dyHead = 0;
        this.dxBody = 0;
        this.dyBody = 0;
        this.tickWolf = 0;
        this.dy = 0;
        this.hdx = 0;
        this.hdy = 0;
        this.idWolfW = new int[] { 1715, 1737, 1714, 1738 };
        this.ID_Body = -1;
        this.ID_PP = -1;
        this.ID_HAIR = -1;
        this.ID_LEG = -1;
        this.ID_HORSE = -1;
        this.ID_NAME = -1;
        this.ID_RANK = -1;
        this.ID_MAT_NA = -1;
        this.ID_Bien_Hinh = -1;
        this.ID_WEA_PONE = -1;
        this.ID_SUSANO = -1;
        this.ColorName = 0;
        this.fRun_PP = new short[] { 2, 2, 3, 3, 4, 4, 5, 5, 6, 6 };
        this.dynewhhorse = 0;
        this.dxnewhorse = 0;
        this.frameFix = 2;
        this.frameMount = new int[][] { { 3049, 3050 }, { 3051, 3051, 3052, 3052, 3053, 3053 }, { 3054 }, { 3055 }, { 3056 }, { 3049, 3049, 3049, 3050, 3050, 3050 } };
        this.statusMe = 6;
    }

    public final int getSys() {
        if (this.nClass.classId == 1 || this.nClass.classId == 2) {
            return 1;
        } else if (this.nClass.classId == 3 || this.nClass.classId == 4) {
            return 2;
        } else {
            return this.nClass.classId != 5 && this.nClass.classId != 6 ? 0 : 3;
        }
    }

    public final int getSpeed() {
        return !this.isWolf && !this.isMoto ? this.cspeed : this.cspeed + 2;
    }

    public final boolean isUseLongRangeWeapon() {
        return this.nClass.classId == 2 || this.nClass.classId == 4 || this.nClass.classId == 6;
    }

    public static Char getMyChar() {
        if (myChar == null) {
            (myChar = new Char()).me = true;
            myChar.cmtoChar = true;
            myChar.timelastSendmove = System.currentTimeMillis();
        }
        return myChar;
    }

    public static void clearMyChar() {
        nso.Char.isAResuscitate = false;
        nso.Char.isAPickYHMS = false;
        nso.Char.isAPickYHM = false;
        nso.Char.isAPickYen = false;
        nso.Char.isANoPick = false;
        nso.Char.isAMP = false;
        nso.Char.isAHP = false;
        nso.Char.isAFood = false;
        isAFocusDie = false;
        nso.Char.isABuff = false;
        myChar = null;
    }

    public final void readParam(Message message) {
        try {
            this.cspeed = message.reader().readByte();
            this.cMaxHP = message.reader().readInt();
            this.cMaxMP = message.reader().readInt();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Char.readParam()");
        }
    }

    public final void bagSort() {
        try {
            MyVector entries = new MyVector();
            for (int index = 0; index < this.arrItemBag.length; index++) {
                Item item;
                if ((item = this.arrItemBag[index]) != null && item.template.isUpToUp && !item.isExpires) {
                    entries.addElement(item);
                }
            }
            for (int index1 = 0; index1 < entries.size(); index1++) {
                Item item2;
                if ((item2 = (Item) entries.elementAt(index1)) != null) {
                    for (int index3 = index1 + 1; index3 < entries.size(); index3++) {
                        Item item4;
                        if ((item4 = (Item) entries.elementAt(index3)) != null && item2.template.equals(item4.template) && item2.isLock == item4.isLock) {
                            item2.quantity = item2.quantity + item4.quantity;
                            this.arrItemBag[item4.indexUI] = null;
                            entries.setElementAt(null, index3);
                        }
                    }
                }
            }
            for (int index5 = 0; index5 < this.arrItemBag.length; index5++) {
                if (this.arrItemBag[index5] != null) {
                    for (int index6 = 0; index6 <= index5; index6++) {
                        if (this.arrItemBag[index6] == null) {
                            this.arrItemBag[index6] = this.arrItemBag[index5];
                            this.arrItemBag[index6].indexUI = index6;
                            this.arrItemBag[index5] = null;
                            break;
                        }
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Char.bagSort()");
        }
    }

    public final void boxSort() {
        try {
            MyVector entries = new MyVector();
            for (int index = 0; index < this.arrItemBox.length; index++) {
                Item item;
                if ((item = this.arrItemBox[index]) != null && item.template.isUpToUp && !item.isExpires) {
                    entries.addElement(item);
                }
            }
            for (int index1 = 0; index1 < entries.size(); index1++) {
                Item item2;
                if ((item2 = (Item) entries.elementAt(index1)) != null) {
                    for (int index3 = index1 + 1; index3 < entries.size(); index3++) {
                        Item item4;
                        if ((item4 = (Item) entries.elementAt(index3)) != null && item2.template.equals(item4.template) && item2.isLock == item4.isLock) {
                            item2.quantity = item2.quantity + item4.quantity;
                            this.arrItemBox[item4.indexUI] = null;
                            entries.setElementAt(null, index3);
                        }
                    }
                }
            }
            for (int index5 = 0; index5 < this.arrItemBox.length; index5++) {
                if (this.arrItemBox[index5] != null) {
                    for (int index6 = 0; index6 <= index5; index6++) {
                        if (this.arrItemBox[index6] == null) {
                            this.arrItemBox[index6] = this.arrItemBox[index5];
                            this.arrItemBox[index6].indexUI = index6;
                            this.arrItemBox[index5] = null;
                            break;
                        }
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Char.boxSort()");
        }
    }

    public final void useItem(int indexUI) {
        Item item;
        if ((item = this.arrItemBag[indexUI]).isTypeBody()) {
            item.isLock = true;
            item.typeUI = 5;
            Item item1 = this.arrItemBody[item.template.type];
            this.arrItemBag[indexUI] = null;
            if (item1 != null) {
                item1.typeUI = 3;
                this.arrItemBody[item.template.type] = null;
                item1.indexUI = indexUI;
                this.arrItemBag[indexUI] = item1;
            }
            item.indexUI = item.template.type;
            this.arrItemBody[item.indexUI] = item;
            for (int index = 0; index < this.arrItemBody.length; index++) {
                Item item2;
                if ((item2 = this.arrItemBody[index]) != null) {
                    if (item2.template.type == 1) {
                        this.wp = item2.template.part;
                    } else if (item2.template.type == 2) {
                        this.body = item2.template.part;
                    } else if (item2.template.type == 6) {
                        this.leg = item2.template.part;
                    }
                }
            }
        } else {
            if (item.isTypeMounts()) {
                item.isLock = true;
                item.typeUI = 41;
                this.arrItemBag[indexUI] = null;
                for (int index3 = 0; index3 < this.arrItemMounts.length; index3++) {
                    int value;
                    if ((value = item.template.type - 29) == index3) {
                        Item item4;
                        if ((item4 = this.arrItemMounts[value]) != null) {
                            item4.typeUI = 41;
                            this.arrItemMounts[value] = null;
                            item4.indexUI = indexUI;
                            this.arrItemBag[indexUI] = item4;
                        }
                        item.indexUI = item.template.type;
                        this.arrItemMounts[value] = item;
                        return;
                    }
                }
            }
        }
    }

    public final Skill getSkill(SkillTemplate skillTemplate) {
        for (int index = 0; index < this.vSkill.size(); index++) {
            Skill skill;
            if ((skill = (Skill) this.vSkill.elementAt(index)).template.equals(skillTemplate)) {
                return skill;
            }
        }
        return null;
    }

    private boolean isInWaypoint() {
        int count = TileMap.vGo.size();
        for (byte index = 0; index < count; index++) {
            Waypoint waypoint = (Waypoint) TileMap.vGo.elementAt(index);
            if (this.cx >= waypoint.minX && this.cx <= waypoint.maxX && this.cy >= waypoint.minY && this.cy <= waypoint.maxY) {
                return true;
            }
        }
        return false;
    }

    private static int getDistance(int x, int x2) {
        return Res.abs(x - x2);
    }

    private void updateFramecharByhorse() {
        if (this.ID_HORSE == -1) {
            this.dynewhhorse = 0;
            this.dxnewhorse = 0;
        } else {
            DataSkillEff dataSkillEff;
            if ((dataSkillEff = getPartEff(this.ID_HORSE, true)) != null && dataSkillEff.isLoadData) {
                if (this.ActionHorse == null) {
                    this.ActionHorse = dataSkillEff.ActionStand;
                }
                this.dynewhhorse = dataSkillEff.dyHorse + dataSkillEff.Dy_Char[this.getFrameHores()];
                this.dxnewhorse = dataSkillEff.dxHorse + dataSkillEff.Dx_Char[this.getFrameHores()];
                if (this.cdir == 1) {
                    this.dxnewhorse = -this.dxnewhorse;
                }
                if (this.statusMe == 1 || this.statusMe == 6) {
                    this.ActionHorse = dataSkillEff.ActionStand;
                } else if (this.statusMe == 2 || this.statusMe == 10) {
                    this.ActionHorse = dataSkillEff.ActionMove;
                } else if (this.statusMe == 4) {
                    this.ActionHorse = dataSkillEff.ActionFall;
                } else if (this.statusMe == 3) {
                    this.ActionHorse = dataSkillEff.ActionJum;
                } else {
                    this.ActionHorse = dataSkillEff.ActionStand;
                }
                if (GameCanvas.gameTick % 3 == 0) {
                    this.fho = (this.fho + 1) % this.ActionHorse.length;
                    this.FramecharRideHorse = dataSkillEff.FrameChar[this.getFrameHores()];
                }
                this.cf = this.FramecharRideHorse;
            }
        }
    }

    public void update() {
        Char character = this;
        DataSkillEff dataSkillEff;
        if (this.ID_NAME > -1 && (dataSkillEff = getPartEff(character.ID_NAME, false)) != null && dataSkillEff.sequence != null) {
            character.fName++;
            if (character.fName > dataSkillEff.sequence.length - 1) {
                character.fName = 0;
            }
            character.FrameName = dataSkillEff.sequence[character.fName];
        }
        character = this;
        if (this.ID_RANK > -1 && (dataSkillEff = getPartEff(character.ID_RANK, false)) != null && dataSkillEff.sequence != null) {
            character.fRank++;
            if (character.fRank > dataSkillEff.sequence.length - 1) {
                character.fRank = 0;
            }
            character.FrameRank = dataSkillEff.sequence[character.fRank];
        }
        character = this;
        if (this.ID_SUSANO > -1 && (dataSkillEff = getPartEff(character.ID_SUSANO, false)) != null && dataSkillEff.sequence != null) {
            character.fsusan++;
            if (character.fsusan > dataSkillEff.sequence.length - 1) {
                character.fsusan = 0;
            }
            character.FrameSusan = dataSkillEff.sequence[character.fsusan];
        }
        this.cX0 = this.cx;
        this.cY0 = this.cy;
        character = this;
        if (GameCanvas.gameTick % 3 == 0 && (dataSkillEff = getPartEff(character.ID_HORSE, true)) != null && dataSkillEff.isLoadData) {
            character.fhorsetrangbi = (character.fhorsetrangbi + 1) % dataSkillEff.ActionStand.length;
        }
        if (this.arrItemBody != null && this.arrItemBody[10] == null && this.mobMe != null) {
            this.mobMe = null;
        }
        if (this.ID_Bien_Hinh > -1) {
            this.fBienhinh = (this.fBienhinh + 1) % 10;
        }
        if (this.ID_MAT_NA > -1) {
            this.fMatNa = (this.fMatNa + 1) % 9;
        }
        if (this.ID_WEA_PONE > -1) {
            this.fWeapone = (this.fWeapone + 1) % 10;
        }
        if (this.ID_LEG > -1) {
            this.fLeg = (this.fLeg + 1) % 10;
        }
        if (this.ID_Body > -1) {
            this.fBody = (this.fBody + 1) % 10;
        }
        if (this.ID_HAIR > -1) {
            this.fHair = (this.fHair + 1) % 10;
        }
        if (this.ID_PP > -1) {
            this.fPP = (this.fPP + 1) % 10;
        }
        character = this;
        if (this.me && character.cHP > 0) {
            int value = getDistance(character.cxSend, character.cx);
            int value1 = getDistance(character.cySend, character.cy);
            if ((value > 0 || value1 > 0) && System.currentTimeMillis() - character.timeSendmove >= 250L) {
                nso.Char.isSendMove = true;
            }
            if (nso.Char.isSendMove) {
                nso.Char.isSendMove = false;
                Service.gI().charMove(character.cx, character.cy);
                character.timeSendmove = System.currentTimeMillis();
                character.cxSend = character.cx;
                character.cySend = character.cy;
            }
        }
        if (this.ID_HORSE <= 0) {
            this.dxnewhorse = 0;
            this.dynewhhorse = 0;
        }
        if (this.mobVithu != null) {
            character = this;
            if (this.mobVithu != null) {
                character.mobVithu.owner = character;
            }
            if (character.mobVithu.getTemplate() != null && character.mobVithu.getTemplate().typeFly == 1) {
                if (Mob.getDistance(character.mobVithu.x, character.mobVithu.y, character.cx, character.cy) > Mob.arrMobTemplate[character.mobVithu.templateId].rangeMove + 100) {
                    character.mobVithu.xFirst = character.cx + (3 - GameCanvas.gameTick % 6) * 6;
                    character.mobVithu.yFirst = character.cy - 60;
                    int value2 = character.mobVithu.xFirst - character.mobVithu.x;
                    int value3 = character.mobVithu.yFirst - character.mobVithu.y;
                    if (value2 > 50 || value2 < -50) {
                        character.mobVithu.x += value2 / 10;
                    }
                    if (value3 > 50 || value3 < -50) {
                        character.mobVithu.y += value3 / 10;
                    }
                }
                character.mobVithu.updateMobAttack();
            } else {
                if (character.mobVithu.status != 3) {
                    if (character.cdir == -1) {
                        character.mobVithu.xFirst = character.cx + 20;
                        character.mobVithu.yFirst = character.cy;
                        character.mobVithu.dir = character.cdir;
                        character.mobVithu.y = character.cy - 20;
                    } else {
                        character.mobVithu.xFirst = character.cx - 20;
                        character.mobVithu.yFirst = character.cy;
                        character.mobVithu.dir = character.cdir;
                        character.mobVithu.y = character.cy - 20;
                    }
                    int value4 = character.mobVithu.xFirst - character.mobVithu.x;
                    int value5 = character.mobVithu.yFirst - character.mobVithu.y;
                    if (value4 <= 50 && value4 >= -50) {
                        character.mobVithu.x += value4;
                    } else {
                        character.mobVithu.x += value4 / 10;
                    }
                    if (value5 > 50 || value5 < -50) {
                        character.mobVithu.y += value5 / 10;
                    }
                }
                character.mobVithu.updateMobAttack();
            }
        }
        if (this.mobMe != null) {
            character = this;
            if (this.mobMe != null && character.mobMe.templateId >= 236) {
                if ((character = character).mobMe != null) {
                    character.mobMe.owner = character;
                }
                if (character.mobMe.templateId != 122 && character.mobMe.templateId != 70 && (character.mobMe.getTemplate() == null || character.mobMe.getTemplate().typeFly != 1)) {
                    if (character.mobMe.status != 3) {
                        if (character.cdir == -1) {
                            character.mobMe.xFirst = character.cx + 20;
                            character.mobMe.yFirst = character.cy;
                            character.mobMe.dir = character.cdir;
                            character.mobMe.y = character.cy - 20;
                        } else {
                            character.mobMe.xFirst = character.cx - 20;
                            character.mobMe.yFirst = character.cy;
                            character.mobMe.dir = character.cdir;
                            character.mobMe.y = character.cy - 20;
                        }
                        int value6 = character.mobMe.xFirst - character.mobMe.x;
                        int value7 = character.mobMe.yFirst - character.mobMe.y;
                        if (value6 <= 50 && value6 >= -50) {
                            character.mobMe.x += value6;
                        } else {
                            character.mobMe.x += value6 / 10;
                        }
                        if (value7 > 50 || value7 < -50) {
                            character.mobMe.y += value7 / 10;
                        }
                    }
                    character.mobMe.updateMobAttack();
                } else {
                    if (character.mobMe.status != 3) {
                        character.mobMe.xFirst = character.cx + (3 - GameCanvas.gameTick % 6) * 6;
                        character.mobMe.yFirst = character.cy - 60;
                    }
                    character.mobMe.updateMobAttack();
                }
            } else if (character.mobMe.templateId == 122 || character.mobMe.templateId == 70 || character.mobMe.getTemplate() != null && character.mobMe.getTemplate().typeFly == 1) {
                if (character.mobMe.status != 3) {
                    character.mobMe.xFirst = character.cx + (3 - GameCanvas.gameTick % 6) * 6;
                    character.mobMe.yFirst = character.cy - 60;
                    int value8 = character.mobMe.xFirst - character.mobMe.x;
                    int value9 = character.mobMe.yFirst - character.mobMe.y;
                    if (value8 > 50 || value8 < -50) {
                        character.mobMe.x += value8 / 10;
                    }
                    if (value9 > 50 || value9 < -50) {
                        character.mobMe.y += value9 / 10;
                    }
                }
                character.mobMe.updateMobAttack();
            } else {
                if (character.mobMe.status != 3) {
                    if (character.cdir == -1) {
                        character.mobMe.xFirst = character.cx + 20;
                        character.mobMe.yFirst = character.cy;
                        character.mobMe.dir = character.cdir;
                        character.mobMe.y = character.cy - 20;
                    } else {
                        character.mobMe.xFirst = character.cx - 20;
                        character.mobMe.yFirst = character.cy;
                        character.mobMe.dir = character.cdir;
                        character.mobMe.y = character.cy - 20;
                    }
                    int value10 = character.mobMe.xFirst - character.mobMe.x;
                    int value11 = character.mobMe.yFirst - character.mobMe.y;
                    if (value10 <= 50 && value10 >= -50) {
                        character.mobMe.x += value10;
                    } else {
                        character.mobMe.x += value10 / 10;
                    }
                    if (value11 > 50 || value11 < -50) {
                        character.mobMe.y += value11 / 10;
                    }
                }
                character.mobMe.updateMobAttack();
            }
        }
        this.isEffBatTu = false;
        if (this.resultTest > 0 && GameCanvas.gameTick % 2 == 0) {
            this.resultTest--;
            if (this.resultTest == 30 || this.resultTest == 60) {
                this.resultTest = 0;
            }
        }
        if (this.myskill != null && (this.myskill.template.id == 77 || this.myskill.template.id == 73)) {
            this.updateSkillPaint();
        }
        this.updateSkillPaint();
        if (this.mobMe != null) {
            this.mobMe.updateMobAttack();
        }
        if (this.mobVithu != null) {
            this.mobVithu.updateMobAttack();
        }
        if (this.arr != null) {
            this.arr.update();
        }
        if (this.arrItemMounts[4] != null && this.arrItemMounts[4].options != null) {
            for (int index = 0; index < this.arrItemMounts[4].options.size(); index++) {
                ItemOption itemOption;
                if ((itemOption = (ItemOption) this.arrItemMounts[4].options.elementAt(index)).optionTemplate.id == 66) {
                    this.vitaWolf = itemOption.param;
                }
            }
        }
        if (this.isWolf && this.vitaWolf < 500) {
            this.isWolf = false;
        }
        if (this.isWolf) {
            character = this;
            if (this.arrItemMounts[4].template.id == 443 && character.arrItemMounts[4].sys >= 2) {
                if (character.idWolfW[1] == 1737) {
                    boolean flag = true;
                    character.EffdefautY -= 5;
                }
                Domsang domsang;
                Domsang domsang12;
                if (character.cdir != 1) {
                    domsang = new Domsang(character.EffdefautX - 4, character.EffdefautY, 0);
                    domsang12 = new Domsang(character.EffdefautX - 1, character.EffdefautY, 0);
                } else {
                    domsang = new Domsang(character.EffdefautX + 4, character.EffdefautY, 0);
                    domsang12 = new Domsang(character.EffdefautX + 1, character.EffdefautY, 0);
                }
                if (character.statusMe != 1 || character.statusMe != 6) {
                    character.vDomsang.addElement(domsang);
                    character.vDomsang.addElement(domsang12);
                }
            }
            for (int index13 = 0; index13 < this.vDomsang.size(); index13++) {
                Domsang domsang14;
                (domsang14 = (Domsang) this.vDomsang.elementAt(index13)).update();
                if (domsang14.frame >= 6) {
                    this.vDomsang.removeElementAt(index13);
                }
            }
        } else if (this.isMoto) {
            character = this;
            if (this.arrItemMounts[4].template.id == 524 && character.arrItemMounts[4].sys >= 2) {
                Domsang domsang15;
                Domsang domsang16;
                if (character.cdir != 1) {
                    domsang15 = new Domsang(character.EffdefautX, character.EffdefautY, 1);
                    domsang16 = new Domsang(character.EffdefautX1, character.EffdefautY1, 1);
                } else {
                    domsang15 = new Domsang(character.EffdefautX, character.EffdefautY, 1);
                    domsang16 = new Domsang(character.EffdefautX1, character.EffdefautY1, 1);
                }
                if ((character.statusMe == 2 || character.statusMe == 10) && GameCanvas.gameTick % 3 == 0) {
                    character.vDomsang.addElement(domsang15);
                    character.vDomsang.addElement(domsang16);
                }
            }
            for (int index17 = 0; index17 < this.vDomsang.size(); index17++) {
                Domsang domsang18;
                (domsang18 = (Domsang) this.vDomsang.elementAt(index17)).update();
                if (domsang18.frame >= 6) {
                    this.vDomsang.removeElementAt(index17);
                }
            }
        } else {
            for (int index19 = 0; index19 < this.vDomsang.size(); index19++) {
                Domsang domsang20;
                (domsang20 = (Domsang) this.vDomsang.elementAt(index19)).update();
                if (domsang20.frame >= 6) {
                    this.vDomsang.removeElementAt(index19);
                }
            }
        }
        if (this.me && nso.Char.isAHP && this.cHP < this.cMaxHP * nso.Char.aHpValue / 100 && System.currentTimeMillis() - this.lastUseHP > 5000L && this.statusMe != 14 && this.statusMe != 5 && this.cHP > 0) {
            if (this.vEff.size() == 0) {
                for (int index21 = 0; index21 < this.arrItemBag.length; index21++) {
                    Item item;
                    if ((item = this.arrItemBag[index21]) != null && item.template.type == 16 && item.template.level == nso.Char.aHpValue) {
                        GameScr.gI();
                        GameScr.doUseHP();
                        this.lastUseHP = System.currentTimeMillis();
                        break;
                    }
                }
            } else {
                for (int index22 = 0; index22 < this.vEff.size() && ((Effect) getMyChar().vEff.elementAt(index22)).template.type != 17; index22++) {
                    if (index22 == this.vEff.size() - 1) {
                        GameScr.gI();
                        GameScr.doUseHP();
                        this.lastUseHP = System.currentTimeMillis();
                    }
                }
            }
        }
        if (this.me && nso.Char.isAFood && GameCanvas.gameTick % 10 == 0 && !GameScr.isPaintAuto && this.statusMe != 14 && this.statusMe != 5 && this.cHP > 0) {
            if (this.vEff.size() == 0) {
                for (int index23 = 0; index23 < this.arrItemBag.length; index23++) {
                    Item item24;
                    if ((item24 = this.arrItemBag[index23]) != null && item24.template.type == 18 && item24.template.level == aFoodValue) {
                        Service.gI().useItem(index23);
                        break;
                    }
                }
            } else {
                for (int index25 = 0; index25 < this.vEff.size() && ((Effect) getMyChar().vEff.elementAt(index25)).template.type != 0; index25++) {
                    if (index25 == this.vEff.size() - 1) {
                        for (int index26 = 0; index26 < this.arrItemBag.length; index26++) {
                            Item item27;
                            if ((item27 = this.arrItemBag[index26]) != null && item27.template.type == 18 && item27.template.level == aFoodValue) {
                                Service.gI().useItem(index26);
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (this.me && nso.Char.isABuff && getMyChar().statusMe != 14 && getMyChar().statusMe != 5 && this.cHP > 0 && System.currentTimeMillis() - this.lastTimeUseSkill > 500L) {
            for (int index28 = 0; index28 < this.vSkill.size(); index28++) {
                boolean flag29 = false;
                Skill skill;
                if (((skill = (Skill) this.vSkill.elementAt(index28)).template.id < 67 || skill.template.id > 72) && skill != null && skill.template.type == 2 && !skill.isCooldown()) {
                    for (int index30 = 0; index30 < this.vEff.size(); index30++) {
                        Effect effect;
                        if ((effect = (Effect) this.vEff.elementAt(index30)) != null && effect.template.iconId == skill.template.iconId) {
                            flag29 = true;
                            break;
                        }
                    }
                    if (!flag29) {
                        GameScr.gI().doUseSkill(skill, true, false);
                        Service.gI().sendUseSkillMyBuff();
                        this.saveLoadPreviousSkill();
                        this.lastTimeUseSkill = System.currentTimeMillis();
                        break;
                    }
                }
            }
        }
        if (this.me && nso.Char.isAMP && this.cMP < this.cMaxMP * nso.Char.aMpValue / 100 && GameCanvas.gameTick % 4 == 0 && this.statusMe != 14 && this.statusMe != 5 && this.cHP > 0) {
            GameScr.gI();
            GameScr.doUseMP();
        }
        if (this.me && nso.Char.isAResuscitate && this.nClass.classId == 6 && aCID > 0 && getMyChar().statusMe != 14 && getMyChar().statusMe != 5 && (character = GameScr.findCharInMap(aCID)) != null && (character.cHP <= 0 || character.statusMe == 14 || character.statusMe == 5 || isAFocusDie)) {
            for (int index31 = 0; index31 < this.vSkill.size(); index31++) {
                Skill skill32;
                if ((skill32 = (Skill) getMyChar().vSkill.elementAt(index31)) != null && skill32.template.type == 4) {
                    if (Res.abs(this.cx - character.cx) < skill32.dx && Res.abs(this.cy - character.cy) < skill32.dy) {
                        getMyChar().myskill = skill32;
                        GameScr.gI().doRescuedOtherChar(aCID);
                        isAFocusDie = false;
                        this.saveLoadPreviousSkill();
                    } else {
                        InfoMe.addInfo(mResources.LIVE_TEXT, 20, mFont.tahoma_7_white);
                    }
                    break;
                }
            }
        }
        if (this.cHP > 0) {
            for (int index33 = 0; index33 < this.vEff.size(); index33++) {
                Effect effect34;
                if ((effect34 = (Effect) this.vEff.elementAt(index33)).template.type != 0 && effect34.template.type != 12) {
                    if (effect34.template.type != 4 && effect34.template.type != 17) {
                        if (effect34.template.type == 13) {
                            if (GameCanvas.isEff1) {
                                this.cHP = this.cHP - this.cMaxHP * 3 / 100;
                                if (this.cHP < 1) {
                                    this.cHP = 1;
                                }
                            }
                        } else if (effect34.template.type == 7) {
                            this.isEffBatTu = true;
                        } else if (effect34.template.type == 1) {
                            this.cHP = this.cHP;
                        }
                    } else if (GameCanvas.isEff1) {
                        this.cHP = this.cHP + effect34.param;
                    }
                } else if (GameCanvas.isEff1) {
                    this.cHP = this.cHP + effect34.param;
                    this.cMP = this.cMP + effect34.param;
                }
            }
            if (this.isEffBatTu) {
                this.count++;
            } else {
                this.count = 0;
            }
            if (this.eff5BuffHp > 0 && GameCanvas.isEff2) {
                this.cHP = this.cHP + this.eff5BuffHp;
            }
            if (this.eff5BuffMp > 0 && GameCanvas.isEff2) {
                this.cMP = this.cMP + this.eff5BuffMp;
            }
            if (this.cHP > this.cMaxHP) {
                this.cHP = this.cMaxHP;
            }
            if (this.cMP > this.cMaxMP) {
                this.cMP = this.cMaxMP;
            }
        }
        if (this.cmtoChar) {
            GameScr.cmtoX = this.cx - GameScr.gW2 + GameScr.gW6 * this.cdir;
            GameScr.cmtoY = this.cy - GameScr.gH23;
        }
        this.tick = (this.tick + 1) % 100;
        if (this.me) {
            if (this.charFocus != null && (this.charFocus.isNhanbanz() || !GameScr.vCharInMap.contains(this.charFocus))) {
                this.charFocus = null;
            }
            if (this.cx < 10) {
                this.cvx = 0;
                this.cx = 10;
            } else if (this.cx > TileMap.pxw - 10) {
                this.cx = TileMap.pxw - 10;
                this.cvx = 0;
            }
            if (!ischangingMap && this.isInWaypoint()) {
                nso.Char.isSendMove = true;
                Service.gI().requestChangeMap();
                isLockKey = true;
                ischangingMap = true;
                GameCanvas.clearKeyHold();
                GameCanvas.clearKeyPressed();
                return;
            }
            if (this.isBlinking) {
                this.isBlinking = System.currentTimeMillis() - this.timeStartBlink < 2000L;
            }
            if (this.isLockMove) {
                this.currentMovePoint = null;
            }
            if (this.currentMovePoint != null && (this.statusMe == 1 || this.statusMe == 2)) {
                this.statusMe = 2;
                if (this.cx - this.currentMovePoint.xEnd > 0) {
                    this.cdir = -1;
                    if (this.cx - this.currentMovePoint.xEnd <= 10) {
                        this.currentMovePoint = null;
                    }
                } else {
                    this.cdir = 1;
                    if (this.cx - this.currentMovePoint.xEnd >= -10) {
                        this.currentMovePoint = null;
                    }
                }
                if (this.currentMovePoint != null) {
                    this.cvx = this.getSpeed() * this.cdir;
                    this.cvy = 0;
                }
            }
            this.searchFocus();
            if (this.statusMe != 1 && this.statusMe != 6) {
                this.currMove = System.currentTimeMillis();
                this.isLastMove = true;
            } else if (System.currentTimeMillis() - this.currMove > 500L && this.isLastMove) {
                nso.Char.isSendMove = true;
                this.isLastMove = false;
                this.currMove = System.currentTimeMillis();
            }
        } else {
            if (GameCanvas.gameTick % 20 == 0 && this.charID >= 0) {
                for (int index35 = 0; index35 < GameScr.vCharInMap.size(); index35++) {
                    Char character36 = null;
                    try {
                        character36 = (Char) GameScr.vCharInMap.elementAt(index35);
                    } catch (Exception exception) {
                    }
                    if (character36 != null) {
                        character36.equals(this);
                    }
                }
            }
            if (this.statusMe == 1 || this.statusMe == 6) {
                boolean flag37 = false;
                if (this.currentMovePoint != null) {
                    if (abs(this.currentMovePoint.xEnd - this.cx) < 4 && abs(this.currentMovePoint.yEnd - this.cy) < 4) {
                        this.cx = this.currentMovePoint.xEnd;
                        this.cy = this.currentMovePoint.yEnd;
                        this.currentMovePoint = null;
                        if ((TileMap.tileTypeAtPixel(this.cx, this.cy) & 2) == 2) {
                            this.changeStatusStand();
                            GameCanvas.gI().startDust(-1, this.cx - -8, this.cy);
                            GameCanvas.gI().startDust(1, this.cx - 8, this.cy);
                        } else {
                            this.statusMe = 4;
                            this.cvy = 0;
                        }
                        flag37 = true;
                    } else if (this.cy == this.currentMovePoint.yEnd) {
                        if (this.cx != this.currentMovePoint.xEnd) {
                            this.cx = (this.cx + this.currentMovePoint.xEnd) / 2;
                            this.cf = GameCanvas.gameTick % 5 + 2;
                        }
                    } else if (this.cy < this.currentMovePoint.yEnd) {
                        this.cf = 12;
                        this.cx = (this.cx + this.currentMovePoint.xEnd) / 2;
                        if (this.cvy < 0) {
                            this.cvy = 0;
                        }
                        this.cy = this.cy + this.cvy;
                        if ((TileMap.tileTypeAtPixel(this.cx, this.cy) & 2) == 2) {
                            GameCanvas.gI().startDust(-1, this.cx - -8, this.cy);
                            GameCanvas.gI().startDust(1, this.cx - 8, this.cy);
                        }
                        this.cvy++;
                        if (this.cvy > 16) {
                            this.cy = (this.cy + this.currentMovePoint.yEnd) / 2;
                        }
                    } else {
                        this.cf = 7;
                        this.cx = (this.cx + this.currentMovePoint.xEnd) / 2;
                        this.cy = (this.cy + this.currentMovePoint.yEnd) / 2;
                    }
                } else {
                    flag37 = true;
                }
                if (flag37 && this.vMovePoints.size() > 0) {
                    if (this.vMovePoints.size() > 5) {
                        this.currentMovePoint = (MovePoint) this.vMovePoints.lastElement();
                        this.vMovePoints.removeElementAt(0);
                        this.cx = this.currentMovePoint.xEnd;
                        this.cy = this.currentMovePoint.yEnd;
                        this.vMovePoints.removeAllElements();
                        this.statusMe = 6;
                        this.currentMovePoint = null;
                        return;
                    }
                    this.currentMovePoint = (MovePoint) this.vMovePoints.firstElement();
                    this.vMovePoints.removeElementAt(0);
                    if (this.currentMovePoint.status == 2) {
                        this.statusMe = 2;
                        if (this.cx - this.currentMovePoint.xEnd > 0) {
                            this.cdir = -1;
                        } else if (this.cx - this.currentMovePoint.xEnd < 0) {
                            this.cdir = 1;
                        }
                        this.cvx = 5 * this.cdir;
                        this.cvy = 0;
                    } else if (this.currentMovePoint.status == 3) {
                        this.statusMe = 3;
                        GameCanvas.gI().startDust(-1, this.cx - -8, this.cy);
                        GameCanvas.gI().startDust(1, this.cx - 8, this.cy);
                        if (this.cx - this.currentMovePoint.xEnd > 0) {
                            this.cdir = -1;
                        } else if (this.cx - this.currentMovePoint.xEnd < 0) {
                            this.cdir = 1;
                        }
                        this.cvx = abs(this.cx - this.currentMovePoint.xEnd) / 9 * this.cdir;
                        this.cvy = -10;
                    } else if (this.currentMovePoint.status == 4) {
                        this.statusMe = 4;
                        if (this.cx - this.currentMovePoint.xEnd > 0) {
                            this.cdir = -1;
                        } else if (this.cx - this.currentMovePoint.xEnd < 0) {
                            this.cdir = 1;
                        }
                        this.cvx = abs(this.cx - this.currentMovePoint.xEnd) / 9 * this.cdir;
                        this.cvy = 0;
                    } else {
                        this.cx = this.currentMovePoint.xEnd;
                        this.cy = this.currentMovePoint.yEnd;
                        this.currentMovePoint = null;
                    }
                }
                if (this.statusMe == 6) {
                    if (this.cf >= 8 && this.cf <= 11) {
                        this.cf++;
                        this.cp1++;
                        if (this.cf > 11) {
                            this.cf = 8;
                        }
                        if (this.cp1 > 5) {
                            this.cf = 0;
                        }
                    }
                    if (this.cf <= 1) {
                        this.cp1++;
                        if (this.cp1 > 6) {
                            this.cf = 0;
                        } else {
                            this.cf = 1;
                        }
                        if (this.cp1 > 10) {
                            this.cp1 = 0;
                        }
                    }
                }
                this.lcx = this.cx;
                this.lcy = this.cy;
                if (System.currentTimeMillis() - this.timeSummon > 7000L) {
                    if (!this.isWolf && this.isHaveWolf() && this.vitaWolf >= 500) {
                        this.isWolf = true;
                        ServerEffect.addServerEffect(60, this, 1);
                    }
                    if (this.isMoto && this.isHaveMoto()) {
                        this.isMoto = false;
                        this.isMotoBehind = true;
                    }
                }
            }
        }
        if (this.isInjure > 0) {
            this.cf = 21;
            this.isInjure--;
        } else {
            switch(this.statusMe) {
                case 1:
                    this.isBocdau = false;
                    this.timeBocdau = 0;
                    if (this.isWolf) {
                        if (this.cdir == 1) {
                            this.EffdefautX = this.cx + 21 + 4;
                            this.EffdefautY = this.cy - 15;
                        } else {
                            this.EffdefautX = this.cx - 24 - 4;
                            this.EffdefautY = this.cy - 15;
                        }
                    }
                    character = this;
                    for (int index38 = 0; index38 < character.vDomsang.size(); index38++) {
                        Domsang domsang39;
                        (domsang39 = (Domsang) character.vDomsang.elementAt(index38)).update();
                        if (domsang39.frame >= 6) {
                            character.vDomsang.removeElementAt(index38);
                        }
                    }
                    character.isAttack = false;
                    character.isAttFly = false;
                    character.cvx = 0;
                    character.cvy = 0;
                    character.cp1++;
                    character.lcx = character.cx;
                    character.lcy = character.cy;
                    if (character.cp1 > 30) {
                        character.cp1 = 0;
                    }
                    if (character.cp1 % 15 < 5) {
                        character.cf = 0;
                    } else {
                        character.cf = 1;
                    }
                    character.updateCharInBridge();
                    if (System.currentTimeMillis() - character.timeSummon > 7000L) {
                        if (!character.isWolf && character.isHaveWolf() && character.vitaWolf >= 500) {
                            character.isWolf = true;
                            ServerEffect.addServerEffect(60, character, 1);
                        }
                        if (character.isMoto && character.isHaveMoto()) {
                            character.isMoto = false;
                            character.isMotoBehind = true;
                        }
                    }
                    break;
                case 2:
                    if (this.isMoto) {
                        this.timeBocdau++;
                        if (this.arrItemMounts[4].template.id == 485 && this.arrItemMounts[4].sys >= 4) {
                            this.isBocdau = true;
                        }
                        if (this.timeBocdau > 20) {
                            this.isBocdau = false;
                        }
                    }
                    if (this.isWolf) {
                        if (this.cdir == 1) {
                            if (this.idWolfW[this.tickWolf] == 1737) {
                                this.EffdefautX = this.cx + 21 + 4;
                                this.EffdefautY = this.cy - 19;
                            } else {
                                this.EffdefautX = this.cx + 21 + 4;
                                this.EffdefautY = this.cy - 16;
                            }
                        } else if (this.idWolfW[this.tickWolf] == 1737) {
                            this.EffdefautX = this.cx - 24 - 4;
                            this.EffdefautY = this.cy - 19;
                        } else {
                            this.EffdefautX = this.cx - 24 - 4;
                            this.EffdefautY = this.cy - 16;
                        }
                    } else if (this.isMoto) {
                        if (this.cdir == 1) {
                            this.EffdefautX = this.cx + 15;
                            this.EffdefautX1 = this.cx - 25;
                            this.EffdefautY = this.cy;
                            this.EffdefautY1 = this.cy;
                        } else {
                            this.EffdefautX = this.cx - 18;
                            this.EffdefautX1 = this.cx + 25;
                            this.EffdefautY = this.cy;
                            this.EffdefautY1 = this.cy;
                        }
                    }
                    character = this;
                    int value40 = 0;
                    if (!character.me && character.currentMovePoint != null) {
                        value40 = abs(character.cx - character.currentMovePoint.xEnd);
                    }
                    character.cp1++;
                    if (character.cp1 >= 10) {
                        character.cp1 = 0;
                        character.cBonusSpeed = 0;
                    }
                    character.cf = (character.cp1 >> 1) + 2;
                    if ((TileMap.tileTypeAtPixel(character.cx, character.cy - 1) & 64) == 64) {
                        character.cx = character.cx + (character.cvx >> 1);
                    } else {
                        character.cx = character.cx + character.cvx;
                    }
                    if (character.cdir == 1) {
                        if (GameScr.auto != 1) {
                            if (TileMap.tileTypeAt(character.cx + character.chw, character.cy - character.chh, 4)) {
                                if (character.me) {
                                    character.cvx = 0;
                                    character.cx = TileMap.tileXofPixel(character.cx + character.chw) - character.chw;
                                } else {
                                    character.stop();
                                }
                            }
                        } else if (TileMap.tileTypeAt(character.cx + character.chw, character.cy - character.chh, 4)) {
                            if (character.me) {
                                character.statusMe = 3;
                                if (character.statusMe == 3) {
                                    character.cvy -= 10;
                                }
                            } else {
                                character.stop();
                            }
                        }
                    } else if (GameScr.auto != 1) {
                        if (TileMap.tileTypeAt(character.cx - character.chw - 1, character.cy - character.chh, 8)) {
                            if (character.me) {
                                character.cvx = 0;
                                character.cx = TileMap.tileXofPixel(character.cx - character.chw - 1) + TileMap.size + character.chw;
                            } else {
                                character.stop();
                            }
                        }
                    } else if (TileMap.tileTypeAt(character.cx - character.chw - 1, character.cy - character.chh, 8)) {
                        if (character.me) {
                            character.statusMe = 3;
                            if (character.statusMe == 3) {
                                character.cvy -= 10;
                            }
                        } else {
                            character.stop();
                        }
                    }
                    if (!character.isNewMount && character.isHaveNewMount()) {
                        character.isNewMount = true;
                        character.isMotoBehind = false;
                    }
                    if (!character.isMoto && character.isHaveMoto()) {
                        character.isMoto = true;
                        character.isMotoBehind = false;
                    }
                    if (!character.isWolf && character.isHaveWolf() && character.vitaWolf >= 500) {
                        character.dx0 = Res.abs(character.cx - character.lcx);
                        character.dy0 = Res.abs(character.cy - character.lcy);
                        character.dx0 = character.dx0 > character.dy0 ? character.dx0 : character.dy0;
                        if (character.me && character.dx0 > 150 || !character.me && character.dx0 > 40) {
                            character.isWolf = true;
                            ServerEffect.addServerEffect(60, character, 1);
                        }
                        character.dx0 = character.dy0 = 0;
                    }
                    if (character.me) {
                        if (character.cvx > 0) {
                            character.cvx--;
                        } else if (character.cvx < 0) {
                            character.cvx++;
                        } else {
                            character.changeStatusStand();
                            character.cBonusSpeed = 0;
                        }
                    }
                    if ((TileMap.tileTypeAtPixel(character.cx, character.cy) & 2) != 2) {
                        if (character.me) {
                            if ((character.cx - character.cxSend != 0 || character.cy - character.cySend != 0) && character.me) {
                                character.cf = 7;
                                character.statusMe = 4;
                                character.cvx = 3 * character.cdir;
                                character.cp2 = 0;
                            }
                        } else {
                            character.stop();
                        }
                    }
                    if (!character.me && character.currentMovePoint != null && abs(character.cx - character.currentMovePoint.xEnd) > value40) {
                        character.stop();
                    }
                    if (!character.isMoto && !character.isNewMount) {
                        GameCanvas.gI().startDust(character.cdir, character.cx - (character.cdir << 3), character.cy);
                    } else if (GameCanvas.gameTick % 5 == 0) {
                        ServerEffect.addServerEffect(120, character.cx - (character.cdir << 5), character.cy, 0, (byte) character.cdir);
                    }
                    character.updateCharInBridge();
                    int value41 = character.cx - (character.cdir << 4);
                    int value42 = character.cy;
                    int value43 = value41;
                    character = character;
                    if (character.isWolf && character.arrItemMounts[4].sys >= 4 && character.getSys() > 0 && GameCanvas.gameTick % 8 == 0) {
                        if (character.getSys() == 1) {
                            ServerEffect.addServerEffect(116, value43, value42, 2);
                        } else if (character.getSys() == 2) {
                            ServerEffect.addServerEffect(117, value43, value42, 2);
                        } else if (character.getSys() == 3) {
                            ServerEffect.addServerEffect(118, value43, value42, 2);
                        }
                    }
                    break;
                case 3:
                    this.isBocdau = false;
                    this.timeBocdau = 0;
                    if (this.isWolf) {
                        if (this.cdir == 1) {
                            this.EffdefautX = this.cx + 21 + 4;
                            this.EffdefautY = this.cy - 30;
                        } else {
                            this.EffdefautX = this.cx - 23 - 4;
                            this.EffdefautY = this.cy - 30;
                        }
                    }
                    this.updateCharJump();
                    break;
                case 4:
                    this.isBocdau = false;
                    this.timeBocdau = 0;
                    if (this.isWolf) {
                        if (this.cdir == 1) {
                            this.EffdefautX = this.cx + 21 + 4;
                            this.EffdefautY = this.cy - 19;
                        } else {
                            this.EffdefautX = this.cx - 24;
                            this.EffdefautY = this.cy - 20;
                        }
                    }
                    this.updateCharFall();
                    break;
                case 5:
                    this.isBocdau = false;
                    this.timeBocdau = 0;
                    this.updateCharDeadFly();
                    break;
                case 6:
                    this.isBocdau = false;
                    this.timeBocdau = 0;
                    if (this.cf == 21 && this.isInjure <= 0) {
                        this.cf = 0;
                    }
                case 7:
                case 8:
                default:
                    break;
                case 9:
                    this.isBocdau = false;
                    this.timeBocdau = 0;
                    this.updateCharAutoJump();
                    break;
                case 10:
                    this.isBocdau = false;
                    this.timeBocdau = 0;
                    this.updateCharWaterRun();
                    break;
                case 11:
                    this.isBocdau = false;
                    this.timeBocdau = 0;
                    this.updateCharWaterDown();
                    break;
                case 12:
                    this.isBocdau = false;
                    this.timeBocdau = 0;
                    this.setAttk();
                    break;
                case 13:
                    this.isBocdau = false;
                    this.timeBocdau = 0;
                    break;
                case 14:
                    this.isBocdau = false;
                    this.timeBocdau = 0;
            }
        }
        if (this.wdx != 0 || this.wdy != 0) {
            this.startDie(this.wdx, this.wdy);
            this.wdx = 0;
            this.wdy = 0;
        }
        if (this.moveFast != null) {
            if (this.moveFast[0] == 0) {
                this.moveFast[0]++;
                ServerEffect.addServerEffect(60, this, 1);
            } else if (this.moveFast[0] < 10) {
                this.moveFast[0]++;
            } else {
                this.cx = this.moveFast[1];
                this.cy = this.moveFast[2];
                this.moveFast = null;
                ServerEffect.addServerEffect(60, this, 1);
                if (this.me) {
                    if ((TileMap.tileTypeAtPixel(this.cx, this.cy) & 2) != 2) {
                        this.statusMe = 4;
                        getMyChar().setAutoSkillPaint(GameScr.sks[38], 1);
                    } else {
                        getMyChar().setAutoSkillPaint(GameScr.sks[38], 0);
                    }
                }
            }
        }
        if (!this.me && this.vMovePoints.size() == 0 && this.cxMoveLast != 0 && this.cyMoveLast != 0 && this.currentMovePoint == null) {
            if (this.cxMoveLast != this.cx) {
                this.cx = this.cxMoveLast;
            }
            if (this.cyMoveLast != this.cy) {
                this.cy = this.cyMoveLast;
            }
            if (this.cHP > 0) {
                this.statusMe = 6;
            }
        }
        character = this;
        this.tickEffWolf++;
        if (character.tickEffWolf > 5) {
            character.tickEffWolf = 0;
        }
        this.fixMove();
        this.updateDataEff((byte) 0, this.statusMe);
        if (this.ID_HORSE > 0) {
            this.isNewMount = false;
            this.isMoto = false;
            this.isWolf = false;
        }
        this.updNewMount();
        this.updateFramecharByhorse();
    }

    private void fixMove() {
        if (!this.me) {
            if (this.cf == 12 && this.cX0 == this.cx && this.cY0 == this.cy) {
                this.inAir++;
            } else if (this.cf == 0 && (TileMap.tileTypeAtPixel(this.cx, this.cy) & 2) != 2) {
                this.inAir++;
            } else {
                this.inAir = 0;
            }
            if (this.inAir > 1) {
                for (int index = this.cy; index < this.cy + 150; index += 24) {
                    if ((TileMap.tileTypeAtPixel(this.cx, index) & 2) != 2) {
                        if ((index = TileMap.tileYofPixel(index) + 24) - this.cy > 24) {
                            this.cy = this.cy + (index - this.cy) / 2;
                            if (!this.isMoto && !this.isWolf && !this.isNewMount) {
                                this.cf = 12;
                            }
                            this.vMovePoints.removeAllElements();
                            this.currentMovePoint = null;
                        } else {
                            this.statusMe = 1;
                            this.vMovePoints.removeAllElements();
                            this.currentMovePoint = null;
                            this.cvx = 0;
                            this.cvy = 0;
                            this.cp1 = 0;
                            this.cp2 = 0;
                            this.cp3 = 0;
                            this.inAir = 0;
                            this.cxMoveLast = 0;
                            this.cyMoveLast = 0;
                            this.cy = index;
                        }
                        this.lcy = this.cy;
                        return;
                    }
                }
            }
        }
    }

    private void updateSkillPaint() {
        if (this.statusMe != 14 && this.statusMe != 5) {
            if (this.skillPaint != null && this.mobFocus != null && this.mobFocus.status == 0) {
                if (!this.me) {
                    if ((TileMap.tileTypeAtPixel(this.cx, this.cy) & 2) == 2) {
                        this.changeStatusStand();
                    } else {
                        this.statusMe = 6;
                    }
                }
                this.indexSkill = 0;
                this.skillPaint = null;
                this.eff0 = this.eff1 = this.eff2 = null;
                this.i0 = this.i1 = this.i2 = 0;
                this.mobFocus = null;
                this.effPaints = null;
                this.arr = null;
            }
            if (this.skillPaint != null && this.arr == null && this.indexSkill >= this.skillInfoPaint1().length) {
                if (!this.me) {
                    if ((TileMap.tileTypeAtPixel(this.cx, this.cy) & 2) == 2) {
                        this.changeStatusStand();
                    } else {
                        this.statusMe = 6;
                    }
                }
                this.indexSkill = 0;
                this.skillPaint = null;
                this.eff0 = this.eff1 = this.eff2 = null;
                this.i0 = this.i1 = this.i2 = 0;
                this.arr = null;
            }
            SkillInfoPaint[] values;
            if ((values = this.skillInfoPaint1()) != null) {
                if (this.me && this.myskill.template.type == 2) {
                    if (this.indexSkill == values.length - values.length / 3) {
                        Service.gI().sendUseSkillMyBuff();
                        this.saveLoadPreviousSkill();
                        return;
                    }
                } else if ((this.mobFocus != null || !this.me && this.charFocus != null || this.me && this.charFocus != null && this.isMeCanAttackOtherPlayer(this.charFocus)) && this.arr == null && this.indexSkill == values.length - values.length / 3) {
                    this.setAttack();
                    if (this.me) {
                        this.saveLoadPreviousSkill();
                    }
                }
            }
        }
    }

    public final void saveLoadPreviousSkill() {
        if (System.currentTimeMillis() - this.timeLastCheck > 500L) {
            if (this.myskill.template.type != 1 && this.lastNormalSkill != null) {
                this.myskill = this.lastNormalSkill;
                Service.gI().selectSkill(this.myskill.template.id);
            }
            if (this.currentFireByShortcut) {
                if (this.lastNormalSkill != null) {
                    this.myskill = this.lastNormalSkill;
                    Service.gI().selectSkill(this.myskill.template.id);
                }
            } else if (GameScr.auto != 1) {
                this.lastNormalSkill = this.myskill;
            }
            this.timeLastCheck = System.currentTimeMillis();
        }
    }

    private void updateCharDeadFly() {
        this.cp1++;
        this.cx = this.cx + (this.cp2 - this.cx) / 4;
        if (this.cp1 > 7) {
            this.cy = this.cy + (this.cp3 - this.cy) / 4;
        } else {
            this.cy = this.cy + (this.cp1 - 10);
        }
        if (Res.abs(this.cp2 - this.cx) < 4 && Res.abs(this.cp3 - this.cy) < 10) {
            this.cx = this.cp2;
            this.cy = this.cp3;
            this.statusMe = 14;
            this.callEff(60);
            if (this.me) {
                GameScr.gI().resetButton();
            }
        }
        this.cf = 21;
    }

    private void setAttk() {
        this.cp1++;
        if (this.cdir == 1) {
            if ((TileMap.tileTypeAtPixel(this.cx + this.chw, this.cy - this.chh) & 4) == 4) {
                this.cvx = 0;
            }
        } else if ((TileMap.tileTypeAtPixel(this.cx - this.chw, this.cy - this.chh) & 8) == 8) {
            this.cvx = 0;
        }
        if (this.cy > this.ch && TileMap.tileTypeAt(this.cx, this.cy - this.ch, 8192)) {
            if (!TileMap.tileTypeAt(this.cx, this.cy, 2)) {
                this.statusMe = 4;
                this.cp1 = 0;
                this.cp2 = 0;
                this.cvy = 1;
            } else {
                this.cy = TileMap.tileYofPixel(this.cy);
            }
        }
        this.cx = this.cx + this.cvx;
        this.cy = this.cy + this.cvy;
        if (this.cy < 0) {
            this.cy = this.cvy = 0;
        }
        if (this.cvy == 0) {
            if ((TileMap.tileTypeAtPixel(this.cx, this.cy) & 2) != 2) {
                this.statusMe = 4;
                this.cvx = (this.getSpeed() >> 1) * this.cdir;
                this.cp1 = this.cp2 = 0;
            }
        } else if (this.cvy < 0) {
            this.cvy++;
            if (this.cvy == 0) {
                this.cvy = 1;
            }
        } else {
            if (this.cvy < 20 && this.cp1 % 5 == 0) {
                this.cvy++;
            }
            if (this.cvy > 3) {
                this.cvy = 3;
            }
            if ((TileMap.tileTypeAtPixel(this.cx, this.cy + 3) & 2) == 2 && this.cy <= TileMap.tileXofPixel(this.cy + 3)) {
                this.cvx = this.cvy = 0;
                this.cy = TileMap.tileXofPixel(this.cy + 3);
            }
            if (TileMap.tileTypeAt(this.cx, this.cy, 64) && this.cy % TileMap.size > 8) {
                this.statusMe = 10;
                this.cvx = this.cdir << 1;
                this.cvy >>= 2;
                this.cy = TileMap.tileYofPixel(this.cy) + 12;
                this.statusMe = 11;
                return;
            }
            if (TileMap.tileTypeAt(this.cx, this.cy, 2048)) {
                this.statusMe = 11;
                return;
            }
        }
        if (this.cvx > 0) {
            this.cvx--;
        } else {
            if (this.cvx < 0) {
                this.cvx++;
            }
        }
    }

    private void updateCharAutoJump() {
        this.cx = this.cx + this.cvx * this.cdir;
        this.cy = this.cy + this.cvyJump;
        this.cvyJump++;
        if (this.cp1 == 0) {
            this.cf = 7;
        } else {
            this.cf = 23;
        }
        if (this.canJumpHigh) {
            if (this.cvyJump == -3) {
                this.cf = 8;
            } else if (this.cvyJump == -2) {
                this.cf = 9;
            } else if (this.cvyJump == -1) {
                this.cf = 10;
            } else if (this.cvyJump == 0) {
                this.cf = 11;
            }
        }
        if (this.cvyJump == 0) {
            this.statusMe = 6;
            ((MovePoint) this.vMovePoints.firstElement()).status = 4;
            this.cp1 = 0;
            this.cvy = 1;
        }
    }

    private void stop() {
        this.statusMe = 6;
        this.cvx = 0;
        this.cvy = 0;
        this.cp1 = this.cp2 = 0;
    }

    private static int abs(int value) {
        return value > 0 ? value : -value;
    }

    private void updateCharJump() {
        if (GameScr.auto == 1) {
            if (this.cdir == 1) {
                this.cvx = 5;
            } else {
                this.cvx = -5;
            }
        }
        if (this.isHaveNewMount()) {
            this.isNewMount = true;
            this.isMotoBehind = false;
        }
        if (this.isHaveMoto()) {
            this.isMoto = true;
            this.isMotoBehind = false;
        }
        this.cx = this.cx + this.cvx;
        this.cy = this.cy + this.cvy;
        if (this.cy < 0) {
            this.cy = 0;
            this.cvy = -1;
        }
        this.cvy++;
        label115: if (!this.me && this.currentMovePoint != null) {
            int value;
            if ((value = this.currentMovePoint.xEnd - this.cx) > 0) {
                if (this.cvx > value) {
                    this.cvx = value;
                }
                if (this.cvx >= 0) {
                    break label115;
                }
            } else if (value < 0) {
                if (this.cvx < value) {
                    this.cvx = value;
                }
                if (this.cvx <= 0) {
                    break label115;
                }
            }
            this.cvx = value;
        }
        if (this.cp1 == 0) {
            this.cf = 7;
        } else {
            this.cf = 23;
        }
        if (this.canJumpHigh) {
            if (this.cvy == -3) {
                this.cf = 8;
            } else if (this.cvy == -2) {
                this.cf = 9;
            } else if (this.cvy == -1) {
                this.cf = 10;
            } else if (this.cvy == 0) {
                this.cf = 11;
            }
        }
        if (this.cdir == 1) {
            if ((TileMap.tileTypeAtPixel(this.cx + this.chw, this.cy - 1) & 4) == 4 && this.cx <= TileMap.tileXofPixel(this.cx + this.chw) + 12) {
                this.cx = TileMap.tileXofPixel(this.cx + this.chw) - this.chw;
                this.cvx = 0;
            }
        } else if ((TileMap.tileTypeAtPixel(this.cx - this.chw, this.cy - 1) & 8) == 8 && this.cx >= TileMap.tileXofPixel(this.cx - this.chw) + 12) {
            this.cx = TileMap.tileXofPixel(this.cx + 24 - this.chw) + this.chw;
            this.cvx = 0;
        }
        if (this.cvy == 0) {
            if (this.me) {
                Char character = this;
                this.cyStartFall = character.cy;
                character.statusMe = 4;
                character.cp1 = 0;
                if (character.canJumpHigh) {
                    character.cp2 = 1;
                } else {
                    character.cp2 = 0;
                }
                character.cvy = 1;
            } else {
                this.stop();
            }
        }
        if (this.me && !ischangingMap && this.isInWaypoint()) {
            ischangingMap = true;
            nso.Char.isSendMove = true;
            Service.gI().requestChangeMap();
            isLockKey = true;
            GameCanvas.clearKeyHold();
            GameCanvas.clearKeyPressed();
        } else {
            if (this.cp3 < 0) {
                this.cp3++;
            }
            if (this.cy > this.ch && TileMap.tileTypeAt(this.cx, this.cy - this.ch, 8192)) {
                if (this.me) {
                    this.statusMe = 4;
                    this.cp1 = 0;
                    this.cp2 = 0;
                    this.cvy = 1;
                } else {
                    this.stop();
                }
            }
            if (!this.me && this.currentMovePoint != null && this.cy < this.currentMovePoint.yEnd) {
                this.stop();
            }
        }
    }

    private void updateCharFall() {
        if (this.cy + 4 >= TileMap.pxh) {
            this.changeStatusStand();
            this.cvx = this.cvy = 0;
        } else {
            if (this.cy % 24 == 0 && (TileMap.tileTypeAtPixel(this.cx, this.cy) & 2) == 2) {
                if (this.me) {
                    this.cvx = this.cvy = 0;
                    this.cp1 = this.cp2 = 0;
                    this.changeStatusStand();
                    return;
                }
                this.stop();
                this.cf = 0;
                GameCanvas.gI().startDust(-1, this.cx - -8, this.cy);
                GameCanvas.gI().startDust(1, this.cx - 8, this.cy);
            }
            this.cf = 12;
            this.cx = this.cx + this.cvx;
            label108: if (!this.me && this.currentMovePoint != null) {
                int value;
                if ((value = this.currentMovePoint.xEnd - this.cx) > 0) {
                    if (this.cvx > value) {
                        this.cvx = value;
                    }
                    if (this.cvx >= 0) {
                        break label108;
                    }
                } else if (value < 0) {
                    if (this.cvx < value) {
                        this.cvx = value;
                    }
                    if (this.cvx <= 0) {
                        break label108;
                    }
                }
                this.cvx = value;
            }
            this.cy = this.cy + this.cvy;
            if (this.cvy < 20) {
                this.cvy++;
            }
            if (this.cdir == 1) {
                if ((TileMap.tileTypeAtPixel(this.cx + this.chw, this.cy - 1) & 4) == 4 && this.cx <= TileMap.tileXofPixel(this.cx + this.chw) + 12) {
                    this.cx = TileMap.tileXofPixel(this.cx + this.chw) - this.chw;
                    this.cvx = 0;
                }
            } else if ((TileMap.tileTypeAtPixel(this.cx - this.chw, this.cy - 1) & 8) == 8 && this.cx >= TileMap.tileXofPixel(this.cx - this.chw) + 12) {
                this.cx = TileMap.tileXofPixel(this.cx + 24 - this.chw) + this.chw;
                this.cvx = 0;
            }
            if (this.cvy > 4 && (this.cyStartFall == 0 || this.cyStartFall <= TileMap.tileYofPixel(this.cy + 3)) && (TileMap.tileTypeAtPixel(this.cx, this.cy + 3) & 2) == 2) {
                if (this.me) {
                    this.cyStartFall = 0;
                    this.cvx = this.cvy = 0;
                    this.cp1 = this.cp2 = 0;
                    this.cy = TileMap.tileXofPixel(this.cy + 3);
                    this.changeStatusStand();
                    GameCanvas.gI().startDust(-1, this.cx - -8, this.cy);
                    GameCanvas.gI().startDust(1, this.cx - 8, this.cy);
                } else {
                    this.stop();
                    this.cy = TileMap.tileXofPixel(this.cy + 3);
                    this.cf = 0;
                    GameCanvas.gI().startDust(-1, this.cx - -8, this.cy);
                    GameCanvas.gI().startDust(1, this.cx - 8, this.cy);
                }
            } else {
                if (this.cp2 == 1) {
                    if (this.cvy == 3) {
                        this.cf = 11;
                    } else if (this.cvy == 2) {
                        this.cf = 8;
                    } else if (this.cvy == 1) {
                        this.cf = 9;
                    } else if (this.cvy == 0) {
                        this.cf = 10;
                    }
                } else {
                    this.cf = 12;
                }
                if (this.cvy > 6 && TileMap.tileTypeAt(this.cx, this.cy, 64) && this.cy % TileMap.size > 8) {
                    this.cy = TileMap.tileYofPixel(this.cy) + 8;
                    this.statusMe = 10;
                    this.cvx = this.cdir << 1;
                    this.cvy >>= 2;
                    this.cy = TileMap.tileYofPixel(this.cy) + 12;
                }
                if (!this.me) {
                    if ((TileMap.tileTypeAtPixel(this.cx, this.cy + 1) & 2) == 2) {
                        this.cf = 0;
                    }
                    if (this.currentMovePoint != null && this.cy > this.currentMovePoint.yEnd) {
                        this.stop();
                    }
                }
            }
        }
    }

    private void updateCharWaterRun() {
        if (!TileMap.tileTypeAt(this.cx, this.cy, 64)) {
            this.statusMe = 4;
        }
        this.cp1++;
        if (this.cp1 >= 5) {
            this.cp1 = 0;
            this.cBonusSpeed = 0;
        }
        this.cf = this.cp1 + 2;
        if (this.cdir == 1) {
            if (TileMap.tileTypeAt(this.cx + this.chw, this.cy - 1, 4)) {
                this.cvx = 0;
                this.cx = TileMap.tileXofPixel(this.cx + this.chw) - this.chw;
            }
        } else if (TileMap.tileTypeAt(this.cx - this.chw - 1, this.cy - 1, 8)) {
            this.cvx = 0;
            this.cx = TileMap.tileXofPixel(this.cx - this.chw - 1) + TileMap.size + this.chw;
        }
        this.cx = this.cx + this.cvx;
        if (this.cvx > 0) {
            this.cvx--;
        } else if (this.cvx < 0) {
            this.cvx++;
        } else if (this.cx - this.cxSend != 0) {
            if (this.me && System.currentTimeMillis() - (this.timelastSendmove + delaySendmove) >= 0L) {
                nso.Char.isSendMove = true;
            }
            this.statusMe = 11;
            this.cBonusSpeed = 0;
        }
        GameCanvas.gI();
        GameCanvas.startWaterSplash(this.cx, this.cy);
        GameCanvas.gI().startDust(this.cdir, this.cx - (this.cdir << 3), this.cy);
    }

    private void updateCharWaterDown() {
        this.cy = this.cy + this.cvy;
        if (this.cvy < 20 && GameCanvas.gameTick % 2 == 0) {
            this.cvy++;
        }
        this.cf = 7;
        if (this.cy >= TileMap.pxh) {
            this.cHP = 0;
            this.statusMe = 5;
        } else if (TileMap.tileTypeAt(this.cx, this.cy, 2)) {
            this.changeStatusStand();
            this.cvx = this.cvy = 0;
            this.cp1 = this.cp2 = 0;
            this.cy = TileMap.tileXofPixel(this.cy);
        } else {
            if (TileMap.tileTypeAt(this.cx, this.cy, 2048)) {
                this.cHP = 0;
                this.statusMe = 5;
            }
        }
    }

    public final void setDefaultPart() {
        this.wp = 15;
        this.setDefaultBody();
        this.setDefaultLeg();
    }

    public final void setDefaultWeapon() {
        this.wp = 15;
    }

    public static Part getDefaultHead(int value) {
        try {
            return value == 0 ? GameScr.parts[27] : GameScr.parts[2];
        } catch (Exception exception) {
            return null;
        }
    }

    public final void setDefaultBody() {
        if (this.cgender == 0) {
            this.body = 10;
        } else {
            this.body = 1;
        }
    }

    public final void setDefaultLeg() {
        if (this.cgender == 0) {
            this.leg = 9;
        } else {
            this.leg = 0;
        }
    }

    public final void setSkillPaint(SkillPaint skillPaint1, int sType2) {
        long longValue = System.currentTimeMillis();
        if (this.me) {
            if (longValue - this.myskill.lastTimeUseThisSkill < this.myskill.coolDown) {
                this.myskill.paintCanNotUseSkill = true;
                return;
            }
            this.myskill.lastTimeUseThisSkill = longValue;
            this.cMP = this.cMP - this.myskill.manaUse;
            if (this.cMP < 0) {
                this.cMP = 0;
            }
        }
        this.setAutoSkillPaint(skillPaint1, sType2);
    }

    private void setAutoSkillPaint(SkillPaint skillPaint1, int sType2) {
        this.skillPaint = skillPaint1;
        this.sType = sType2;
        this.indexSkill = 0;
        this.i0 = this.i1 = this.i2 = this.dx0 = this.dx1 = this.dx2 = this.dy0 = this.dy1 = this.dy2 = 0;
        this.eff0 = null;
        this.eff1 = null;
        this.eff2 = null;
    }

    private SkillInfoPaint[] skillInfoPaint1() {
        if (this.skillPaint == null) {
            return null;
        } else {
            return this.sType == 0 ? this.skillPaint.skillStand : this.skillPaint.skillfly;
        }
    }

    public final void setAttack() {
        try {
            if (this.me) {
                if (this.myskill.template.type == 2) {
                    return;
                }
                if (this.myskill.template.id == 42 && !this.myskill.isCooldown()) {
                    this.isBlinking = true;
                    this.timeStartBlink = System.currentTimeMillis();
                }
                if (this.skillPaint != null && (this.mobFocus != null || this.charFocus != null && this.isMeCanAttackOtherPlayer(this.charFocus))) {
                    this.isUseLongRangeWeapon();
                    int value = this.myskill.dx;
                    int value1 = this.myskill.dy;
                    MyVector entries = new MyVector();
                    MyVector entries2 = new MyVector();
                    if (this.charFocus != null) {
                        entries2.addElement(this.charFocus);
                        for (int index = 0; index < GameScr.vCharInMap.size() && entries.size() + entries2.size() < this.myskill.maxFight; index++) {
                            Char character;
                            if ((character = (Char) GameScr.vCharInMap.elementAt(index)).statusMe != 14 && character.statusMe != 5 && character.statusMe != 15 && !character.isInvisible && !character.equals(this.charFocus) && this.isMeCanAttackOtherPlayer(character) && this.charFocus.cx - value <= character.cx && character.cx <= this.charFocus.cx + value && this.charFocus.cy - value1 <= character.cy && character.cy <= this.charFocus.cy + value1 && (this.cdir == -1 && character.cx <= this.cx || this.cdir == 1 && character.cx >= this.cx)) {
                                entries2.addElement(character);
                            }
                        }
                        for (int index3 = 0; index3 < GameScr.vMob.size() && entries.size() + entries2.size() < this.myskill.maxFight; index3++) {
                            Mob mob;
                            if ((mob = (Mob) GameScr.vMob.elementAt(index3)).status != 1 && mob.status != 0 && this.charFocus.cx - value <= mob.x && mob.x <= this.charFocus.cx + value && this.charFocus.cy - value1 <= mob.y && mob.y <= this.charFocus.cy + value1 && (this.cdir == -1 && mob.x <= this.cx || this.cdir == 1 && mob.x >= this.cx)) {
                                entries.addElement(mob);
                            }
                        }
                    } else if (this.mobFocus != null && this.mobFocus.status != 1 && this.mobFocus.status != 0) {
                        entries.addElement(this.mobFocus);
                        for (int index4 = 0; index4 < GameScr.vMob.size() && entries.size() + entries2.size() < this.myskill.maxFight; index4++) {
                            Mob mob5;
                            if ((mob5 = (Mob) GameScr.vMob.elementAt(index4)).status != 1 && mob5.status != 0 && !mob5.equals(this.mobFocus) && this.mobFocus.x - 100 <= mob5.x && mob5.x <= this.mobFocus.x + 100 && this.mobFocus.y - 50 <= mob5.y && mob5.y <= this.mobFocus.y + 50) {
                                entries.addElement(mob5);
                            }
                        }
                        for (int index6 = 0; index6 < GameScr.vCharInMap.size() && entries.size() + entries2.size() < this.myskill.maxFight; index6++) {
                            Char character7;
                            if ((character7 = (Char) GameScr.vCharInMap.elementAt(index6)).statusMe != 14 && character7.statusMe != 5 && character7.statusMe != 15 && !character7.isInvisible && (this.cTypePk >= 4 && this.cTypePk <= 6 && character7.cTypePk >= 4 && character7.cTypePk <= 6 && this.cTypePk != character7.cTypePk || character7.cTypePk == 3 || this.cTypePk == 3 || character7.cTypePk == 1 && this.cTypePk == 1 || this.testCharId >= 0 && this.testCharId == character7.charID || this.killCharId >= 0 && this.killCharId == character7.charID) && this.mobFocus.x - value <= character7.cx && character7.cx <= this.mobFocus.x + value && this.mobFocus.y - value1 <= character7.cy && character7.cy <= this.mobFocus.y + value1 && (this.cdir == -1 && character7.cx <= this.cx || this.cdir == 1 && character7.cx >= this.cx)) {
                                entries2.addElement(character7);
                            }
                        }
                    }
                    this.effPaints = new EffectPaint[entries.size() + entries2.size()];
                    for (int index8 = 0; index8 < entries.size(); index8++) {
                        this.effPaints[index8] = new EffectPaint();
                        this.effPaints[index8].effCharPaint = GameScr.efs[this.skillPaint.effId - 1];
                        this.effPaints[index8].eMob = (Mob) entries.elementAt(index8);
                    }
                    for (int index9 = 0; index9 < entries2.size(); index9++) {
                        this.effPaints[index9 + entries.size()] = new EffectPaint();
                        this.effPaints[index9 + entries.size()].effCharPaint = GameScr.efs[this.skillPaint.effId - 1];
                        this.effPaints[index9 + entries.size()].eChar = (Char) entries2.elementAt(index9);
                    }
                    if (this.effPaints.length > 1) {
                        EPosition ePosition = new EPosition();
                        if (this.effPaints[0].eMob != null) {
                            ePosition = new EPosition(this.effPaints[0].eMob.x, this.effPaints[0].eMob.y);
                        } else if (this.effPaints[0].eChar != null) {
                            ePosition = new EPosition(this.effPaints[0].eChar.cx, this.effPaints[0].eChar.cy);
                        }
                        MyVector entries10 = new MyVector();
                        for (int index11 = 1; index11 < this.effPaints.length; index11++) {
                            if (this.effPaints[index11].eMob != null) {
                                entries10.addElement(new EPosition(this.effPaints[index11].eMob.x, this.effPaints[index11].eMob.y));
                            } else if (this.effPaints[index11].eChar != null) {
                                entries10.addElement(new EPosition(this.effPaints[index11].eChar.cx, this.effPaints[index11].eChar.cy));
                            }
                            if (index11 > 5) {
                                break;
                            }
                        }
                        Lightning.addLight(entries10, ePosition, true, this.getClassColor());
                    }
                    byte byteValue = 0;
                    if (this.mobFocus != null) {
                        byteValue = 1;
                    } else if (this.charFocus != null) {
                        byteValue = 2;
                    }
                    if (this.me) {
                        Service.gI().sendPlayerAttack(entries, entries2, byteValue);
                        return;
                    }
                }
            } else if (this.skillPaint != null && (this.mobFocus != null || this.charFocus != null)) {
                if (this.attMobs != null && this.attChars != null) {
                    this.effPaints = new EffectPaint[this.attMobs.length + this.attChars.length];
                    for (int index12 = 0; index12 < this.attMobs.length; index12++) {
                        this.effPaints[index12] = new EffectPaint();
                        this.effPaints[index12].effCharPaint = GameScr.efs[this.skillPaint.effId - 1];
                        this.effPaints[index12].eMob = this.attMobs[index12];
                    }
                    for (int index13 = 0; index13 < this.attChars.length; index13++) {
                        this.effPaints[index13 + this.attMobs.length] = new EffectPaint();
                        this.effPaints[index13 + this.attMobs.length].effCharPaint = GameScr.efs[this.skillPaint.effId - 1];
                        this.effPaints[index13 + this.attMobs.length].eChar = this.attChars[index13];
                    }
                    this.attMobs = null;
                    this.attChars = null;
                } else if (this.attMobs != null) {
                    this.effPaints = new EffectPaint[this.attMobs.length];
                    for (int index14 = 0; index14 < this.attMobs.length; index14++) {
                        this.effPaints[index14] = new EffectPaint();
                        this.effPaints[index14].effCharPaint = GameScr.efs[this.skillPaint.effId - 1];
                        this.effPaints[index14].eMob = this.attMobs[index14];
                    }
                    this.attMobs = null;
                } else if (this.attChars != null) {
                    this.effPaints = new EffectPaint[this.attChars.length];
                    for (int index15 = 0; index15 < this.attChars.length; index15++) {
                        this.effPaints[index15] = new EffectPaint();
                        this.effPaints[index15].effCharPaint = GameScr.efs[this.skillPaint.effId - 1];
                        this.effPaints[index15].eChar = this.attChars[index15];
                    }
                    this.attChars = null;
                }
                if (this.effPaints.length > 1 && this.effPaints[0] != null) {
                    EPosition ePosition16 = new EPosition();
                    if (this.effPaints[0].eMob != null) {
                        ePosition16 = new EPosition(this.effPaints[0].eMob.x, this.effPaints[0].eMob.y);
                    } else if (this.effPaints[0].eChar != null) {
                        ePosition16 = new EPosition(this.effPaints[0].eChar.cx, this.effPaints[0].eChar.cy);
                    }
                    MyVector entries17 = new MyVector();
                    for (int index18 = 1; index18 < this.effPaints.length; index18++) {
                        if (this.effPaints[index18].eMob != null) {
                            entries17.addElement(new EPosition(this.effPaints[index18].eMob.x, this.effPaints[index18].eMob.y));
                        } else if (this.effPaints[index18].eChar != null) {
                            entries17.addElement(new EPosition(this.effPaints[index18].eChar.cx, this.effPaints[index18].eChar.cy));
                        }
                        if (index18 > 5) {
                            break;
                        }
                    }
                    Lightning.addLight(entries17, ePosition16, true, this.getClassColor());
                    return;
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public final boolean isHaveWolf() {
        return this.ID_HORSE > -1 ? false : this.arrItemMounts != null && this.arrItemMounts[4] != null && this.arrItemMounts[4].template != null && (this.arrItemMounts[4].template.id == 443 || this.arrItemMounts[4].template.id == 523);
    }

    public final boolean isHaveMoto() {
        return this.ID_HORSE > -1 ? false : this.arrItemMounts != null && this.arrItemMounts[4] != null && this.arrItemMounts[4].template != null && (this.arrItemMounts[4].template.id == 485 || this.arrItemMounts[4].template.id == 524);
    }

    public final boolean isPaint() {
        if (this.cx < GameScr.cmx) {
            return false;
        } else if (this.cx > GameScr.cmx + GameScr.gW) {
            return false;
        } else {
            return this.cy < GameScr.cmy ? false : this.cy <= GameScr.cmy + GameScr.gH + 30;
        }
    }

    private static DataSkillEff getPartEff(short id, boolean ishorse) {
        if (id == -1) {
            return null;
        }
        DataSkillEff dataSkillEff;
        if ((dataSkillEff = (DataSkillEff) ALL_PART_EFF.get(String.valueOf(id))) == null) {
            dataSkillEff = new DataSkillEff(id, ishorse);
            ALL_PART_EFF.put(String.valueOf(id), dataSkillEff);
            dataSkillEff.timeRemove = (int) (System.currentTimeMillis() / 1000L);
        } else {
            dataSkillEff.timeRemove = System.currentTimeMillis();
        }
        return dataSkillEff;
    }

    public static void SetRemove() {
        mHashtable mHashtable1 = ALL_PART_EFF;
        Enumeration enumeration = ALL_PART_EFF.h.keys();
        while (enumeration.hasMoreElements()) {
            String text = (String) enumeration.nextElement();
            DataSkillEff dataSkillEff = (DataSkillEff) ALL_PART_EFF.get(text);
            if ((System.currentTimeMillis() - dataSkillEff.timeRemove) / 1000L > 200L) {
                String text2 = text;
                mHashtable1 = ALL_PART_EFF;
                ALL_PART_EFF.h.remove(text2);
            }
        }
    }

    public void paint(mGraphics graphics) {
        if (!this.isPaint()) {
            if (this.skillPaint != null) {
                this.indexSkill = this.skillInfoPaint1().length;
                this.skillPaint = null;
                this.effPaints = null;
                this.eff = null;
                this.effTask = null;
                this.indexEff = -1;
                this.indexEffTask = -1;
            }
        } else {
            this.paintBottomDataEff(graphics, this.cx, this.cy - this.getDyHorse(), -this.heightCharName);
            if (this.statusMe != 15 && (this.moveFast == null || this.moveFast[0] <= 0)) {
                this.paintCharName_HP_MP_Overhead(graphics);
                if (this.skillPaint != null && this.indexSkill < this.skillInfoPaint1().length) {
                    mGraphics graphics1 = graphics;
                    Char character = this;
                    try {
                        SkillInfoPaint[] values = character.skillInfoPaint1();
                        character.cf = values[character.indexSkill].status;
                        if (values[character.indexSkill].effS0Id != 0) {
                            character.eff0 = GameScr.efs[values[character.indexSkill].effS0Id - 1];
                            character.i0 = character.dx0 = character.dy0 = 0;
                        }
                        if (values[character.indexSkill].effS1Id != 0) {
                            character.eff1 = GameScr.efs[values[character.indexSkill].effS1Id - 1];
                            character.i1 = character.dx1 = character.dy1 = 0;
                        }
                        if (values[character.indexSkill].effS2Id != 0) {
                            character.eff2 = GameScr.efs[values[character.indexSkill].effS2Id - 1];
                            character.i2 = character.dx2 = character.dy2 = 0;
                        }
                        SkillInfoPaint[] values2 = values;
                        if (values != null && values2[character.indexSkill] != null && values2[character.indexSkill].arrowId != 0) {
                            character.arr = new Arrow(character, GameScr.arrs[values2[character.indexSkill].arrowId - 1]);
                            character.arr.life = 10;
                            character.arr.ax = character.cx + values2[character.indexSkill].adx;
                            character.arr.ay = character.cy + values2[character.indexSkill].ady;
                        }
                        character.paintCharWithoutSkill(graphics1);
                        if (character.cdir == 1) {
                            if (character.eff0 != null) {
                                if (character.dx0 == 0) {
                                    character.dx0 = values[character.indexSkill].e0dx;
                                }
                                if (character.dy0 == 0) {
                                    character.dy0 = values[character.indexSkill].e0dy;
                                }
                                SmallImage.drawSmallImage(graphics1, character.eff0.arrEfInfo[character.i0].idImg, character.cx + character.dx0 + character.eff0.arrEfInfo[character.i0].dx, character.cy + character.dy0 + character.eff0.arrEfInfo[character.i0].dy, 0, 3);
                                character.i0++;
                                if (character.i0 >= character.eff0.arrEfInfo.length) {
                                    character.eff0 = null;
                                    character.i0 = character.dx0 = character.dy0 = 0;
                                }
                            }
                            if (character.eff1 != null) {
                                if (character.dx1 == 0) {
                                    character.dx1 = values[character.indexSkill].e1dx;
                                }
                                if (character.dy1 == 0) {
                                    character.dy1 = values[character.indexSkill].e1dy;
                                }
                                SmallImage.drawSmallImage(graphics1, character.eff1.arrEfInfo[character.i1].idImg, character.cx + character.dx1 + character.eff1.arrEfInfo[character.i1].dx, character.cy + character.dy1 + character.eff1.arrEfInfo[character.i1].dy, 0, 3);
                                character.i1++;
                                if (character.i1 >= character.eff1.arrEfInfo.length) {
                                    character.eff1 = null;
                                    character.i1 = character.dx1 = character.dy1 = 0;
                                }
                            }
                            if (character.eff2 != null) {
                                if (character.dx2 == 0) {
                                    character.dx2 = values[character.indexSkill].e2dx;
                                }
                                if (character.dy2 == 0) {
                                    character.dy2 = values[character.indexSkill].e2dy;
                                }
                                SmallImage.drawSmallImage(graphics1, character.eff2.arrEfInfo[character.i2].idImg, character.cx + character.dx2 + character.eff2.arrEfInfo[character.i2].dx, character.cy + character.dy2 + character.eff2.arrEfInfo[character.i2].dy, 0, 3);
                                character.i2++;
                                if (character.eff2.arrEfInfo != null && character.i2 >= character.eff2.arrEfInfo.length) {
                                    character.eff2 = null;
                                    character.i2 = character.dx2 = character.dy2 = 0;
                                }
                            }
                        } else {
                            if (character.eff0 != null) {
                                if (character.dx0 == 0) {
                                    character.dx0 = values[character.indexSkill].e0dx;
                                }
                                if (character.dy0 == 0) {
                                    character.dy0 = values[character.indexSkill].e0dy;
                                }
                                SmallImage.drawSmallImage(graphics1, character.eff0.arrEfInfo[character.i0].idImg, character.cx - character.dx0 - character.eff0.arrEfInfo[character.i0].dx, character.cy + character.dy0 + character.eff0.arrEfInfo[character.i0].dy, 2, 3);
                                character.i0++;
                                if (character.i0 >= character.eff0.arrEfInfo.length) {
                                    character.eff0 = null;
                                    character.i0 = 0;
                                    character.dx0 = 0;
                                    character.dy0 = 0;
                                }
                            }
                            if (character.eff1 != null) {
                                if (character.dx1 == 0) {
                                    character.dx1 = values[character.indexSkill].e1dx;
                                }
                                if (character.dy1 == 0) {
                                    character.dy1 = values[character.indexSkill].e1dy;
                                }
                                SmallImage.drawSmallImage(graphics1, character.eff1.arrEfInfo[character.i1].idImg, character.cx - character.dx1 - character.eff1.arrEfInfo[character.i1].dx, character.cy + character.dy1 + character.eff1.arrEfInfo[character.i1].dy, 2, 3);
                                character.i1++;
                                if (character.i1 >= character.eff1.arrEfInfo.length) {
                                    character.eff1 = null;
                                    character.i1 = 0;
                                    character.dx1 = 0;
                                    character.dy1 = 0;
                                }
                            }
                            if (character.eff2 != null) {
                                if (character.dx2 == 0) {
                                    character.dx2 = values[character.indexSkill].e2dx;
                                }
                                if (character.dy2 == 0) {
                                    character.dy2 = values[character.indexSkill].e2dy;
                                }
                                SmallImage.drawSmallImage(graphics1, character.eff2.arrEfInfo[character.i2].idImg, character.cx - character.dx2 - character.eff2.arrEfInfo[character.i2].dx, character.cy + character.dy2 + character.eff2.arrEfInfo[character.i2].dy, 2, 3);
                                character.i2++;
                                if (character.eff2.arrEfInfo != null && character.i2 >= character.eff2.arrEfInfo.length) {
                                    character.eff2 = null;
                                    character.i2 = 0;
                                    character.dx2 = 0;
                                    character.dy2 = 0;
                                }
                            }
                        }
                        character.indexSkill++;
                    } catch (Exception exception) {
                        System.out.println("loi paint charskill");
                    }
                } else {
                    this.paintCharWithoutSkill(graphics);
                }
                mGraphics graphics3 = graphics;
                Char character4 = this;
                if (this.arr != null) {
                    character4.arr.paint(graphics3);
                }
                if (this.effPaints != null) {
                    for (int index = 0; index < this.effPaints.length; index++) {
                        if (this.effPaints[index] != null) {
                            if (this.effPaints[index].eMob != null) {
                                if (!this.effPaints[index].isFly) {
                                    this.effPaints[index].eMob.setInjure();
                                    this.effPaints[index].eMob.injureBy = this;
                                    if (this.me) {
                                        getMyChar();
                                        getMyChar();
                                        NinjaUtil.randomNumber(11);
                                    }
                                    if (this.effPaints[index].eMob.templateId != 98 && this.effPaints[index].eMob.templateId != 99) {
                                        GameScr.startSplash(this.effPaints[index].eMob.x, this.effPaints[index].eMob.y - (this.effPaints[index].eMob.h >> 1), this.cdir);
                                    }
                                    this.effPaints[index].isFly = true;
                                }
                                SmallImage.drawSmallImage(graphics, this.effPaints[index].getImgId(), this.effPaints[index].eMob.x, this.effPaints[index].eMob.y, 0, 33);
                            } else if (this.effPaints[index].eChar != null) {
                                if (!this.effPaints[index].isFly) {
                                    if (this.effPaints[index].eChar.charID >= 0) {
                                        character4 = this.effPaints[index].eChar;
                                        this.effPaints[index].eChar.isInjure = 4;
                                        character4.callEff(49);
                                    }
                                    GameScr.startSplash(this.effPaints[index].eChar.cx, this.effPaints[index].eChar.cy - (this.effPaints[index].eChar.ch >> 1), this.cdir);
                                    this.effPaints[index].isFly = true;
                                }
                                SmallImage.drawSmallImage(graphics, this.effPaints[index].getImgId(), this.effPaints[index].eChar.cx, this.effPaints[index].eChar.cy, 0, 33);
                            }
                            this.effPaints[index].index++;
                            if (this.effPaints[index].index >= this.effPaints[index].effCharPaint.arrEfInfo.length) {
                                this.effPaints[index] = null;
                            }
                        }
                    }
                }
                if (this.indexEff >= 0 && this.eff != null) {
                    SmallImage.drawSmallImage(graphics, this.eff.arrEfInfo[this.indexEff].idImg, this.cx + this.eff.arrEfInfo[this.indexEff].dx, this.cy + this.eff.arrEfInfo[this.indexEff].dy, 0, 3);
                    if (GameCanvas.gameTick % 2 == 0) {
                        this.indexEff++;
                        if (this.indexEff >= this.eff.arrEfInfo.length) {
                            this.indexEff = -1;
                            this.eff = null;
                        }
                    }
                }
                if (this.indexEffTask >= 0 && this.effTask != null) {
                    SmallImage.drawSmallImage(graphics, this.effTask.arrEfInfo[this.indexEffTask].idImg, this.cx + this.effTask.arrEfInfo[this.indexEffTask].dx, this.cy + this.effTask.arrEfInfo[this.indexEffTask].dy, 0, 3);
                    if (GameCanvas.gameTick % 2 == 0) {
                        this.indexEffTask++;
                        if (this.indexEffTask >= this.effTask.arrEfInfo.length) {
                            this.indexEffTask = -1;
                            this.effTask = null;
                        }
                    }
                }
                if (this.isEffBatTu) {
                    if (this.count < 2) {
                        SmallImage.drawSmallImage(graphics, 1366, this.cx, this.cy - this.chh, 0, 3);
                    } else if (this.count < 4) {
                        SmallImage.drawSmallImage(graphics, 1367, this.cx, this.cy - this.chh, 0, 3);
                    } else if (this.count < 8) {
                        SmallImage.drawSmallImage(graphics, 1368, this.cx, this.cy - this.chh, 0, 3);
                    } else if (GameCanvas.gameTick % 2 == 0) {
                        SmallImage.drawSmallImage(graphics, 1369, this.cx, this.cy - this.chh, 0, 3);
                    } else {
                        SmallImage.drawSmallImage(graphics, 1370, this.cx, this.cy - this.chh, 0, 3);
                    }
                }
                try {
                    if (this.mobMe != null) {
                        this.mobMe.paint(graphics);
                    }
                } catch (Exception exception6) {
                    exception6.printStackTrace();
                }
                if (this.mobVithu != null) {
                    this.mobVithu.paint(graphics);
                }
                if (this.statusMe != 1 && this.statusMe != 6) {
                    for (int index5 = 0; index5 < this.vDomsang.size(); index5++) {
                        ((Domsang) this.vDomsang.elementAt(index5)).paint(graphics);
                    }
                }
                this.paintTopDataEff(graphics, this.cx, this.cy - this.getDyHorse(), -this.heightCharName);
            }
        }
    }

    public final void paintHp(mGraphics g, int px, int py) {
        int value = this.cHP * 26 / this.cMaxHP;
        if (this.statusMe != 5 && this.statusMe != 14 && value < 2) {
            value = 2;
        } else if (this.statusMe == 5 || this.statusMe == 14) {
            value = 0;
        }
        if (value > 26) {
            value = 0;
        }
        g.setColor(16777215);
        g.fillRect(px, py, 26, 4);
        g.setColor(this.getClassColor());
        g.fillRect(px, py, value, 4);
        g.setColor(0);
        g.drawRect(px, py, 26, 4);
    }

    private int[] geteffOngbo() {
        int[] values = null;
        if (this.isMoto && this.arrItemMounts[4].template.id == 485 && this.arrItemMounts[4].sys >= 3) {
            values = new int[] { 2094, 2095, 2096 };
        }
        return values;
    }

    private int[] getEffmoto() {
        int[] values = null;
        if (this.isMoto) {
            values = new int[] { 2082, 2082, 2083, 2083, 2084, 2084, 2089, 2089, 2082, 2082, 2083, 2083 };
        }
        return values;
    }

    private int[] getEffwolf() {
        int[] values = null;
        if (this.isWolf) {
            values = new int[] { 2085, 2086, 2087, 2088 };
        }
        return values;
    }

    public final int[] getClassCoat() {
        int[] values = null;
        short shortValue = -1;
        if (this.me) {
            if (this.arrItemBody[12] != null) {
                shortValue = this.arrItemBody[12].template.id;
            }
        } else {
            shortValue = this.coat;
        }
        if (shortValue == -1) {
            return null;
        }
        if (shortValue == 420) {
            if (!this.isWolf && !this.isMoto && !this.isNewMount) {
                values = new int[] { 1635, 1636, 1637, 1636 };
            } else {
                values = new int[] { 2029, 2030, 2031, 2030 };
            }
        } else if (shortValue == 421) {
            if (!this.isWolf && !this.isMoto && !this.isNewMount) {
                values = new int[] { 1652, 1653, 1654, 1653 };
            } else {
                values = new int[] { 2035, 2036, 2037, 2036 };
            }
        } else if (shortValue == 422) {
            if (!this.isWolf && !this.isMoto && !this.isNewMount) {
                values = new int[] { 1655, 1656, 1657, 1656 };
            } else {
                values = new int[] { 2032, 2033, 2034, 2033 };
            }
        }
        return values;
    }

    public final int getClassColor() {
        int value = 9145227;
        if (this.nClass.classId == 1 || this.nClass.classId == 2) {
            value = 16711680;
        } else if (this.nClass.classId == 3 || this.nClass.classId == 4) {
            value = 33023;
        } else if (this.nClass.classId == 5 || this.nClass.classId == 6) {
            value = 7443811;
        }
        return value;
    }

    public final void paintNameInSameParty(mGraphics g) {
        if (this.isPaint()) {
            if (getMyChar().charFocus == null || !getMyChar().charFocus.equals(this)) {
                mFont.tahoma_7_yellow.drawString(g, this.cName, this.cx, this.cy - this.ch - mFont.tahoma_7_green.getHeight() - 5, 2, mFont.tahoma_7_grey);
                return;
            }
            if (getMyChar().charFocus != null && getMyChar().charFocus.equals(this)) {
                mFont.tahoma_7_yellow.drawString(g, this.cName, this.cx, this.cy - this.ch - mFont.tahoma_7_green.getHeight() - 10, 2, mFont.tahoma_7_grey);
            }
        }
    }

    public final void paintCharName_HP_MP_Overhead(mGraphics g) {
        boolean flag;
        this.heightCharName = this.ch + 5;
        this.heightCharName = this.heightCharName + (!this.isWolf && !this.isMoto && !this.isNewMount ? 0 : 15);
        DataSkillEff dataSkillEff;
        if (this.ID_HORSE > -1 && (dataSkillEff = getPartEff(this.ID_HORSE, true)) != null && dataSkillEff.isLoadData) {
            this.heightCharName = this.heightCharName + dataSkillEff.dyHorse;
        }
        if (!this.isInvisible || this.me) {
            label152: {
                flag = false;
                if (this.me) {
                    GameScr.gI();
                    if (GameScr.auto != 1) {
                        if (this.ColorName > 0) {
                            flag = true;
                            this.heightCharName = this.heightCharName + mFont.tahoma_7.getHeight();
                            if (!this.isHuman) {
                                mFont.tahoma_7_blue1.drawString(g, this.cName, this.cx, this.cy - this.heightCharName, 2, mFont.tahoma_7_grey);
                            } else {
                                color_font_name[this.ColorName].drawString(g, this.cName, this.cx, this.cy - this.heightCharName, 2, mFont.tahoma_7_grey);
                            }
                            this.heightCharName++;
                        } else if (this.npcFocus == null && this.charFocus == null && this.mobFocus == null && this.itemFocus == null) {
                            flag = true;
                            this.heightCharName = this.heightCharName + mFont.tahoma_7.getHeight();
                            if (!this.isHuman) {
                                mFont.tahoma_7_blue1.drawString(g, this.cName, this.cx, this.cy - this.heightCharName, 2, mFont.tahoma_7_grey);
                            } else {
                                color_font_name[this.ColorName].drawString(g, this.cName, this.cx, this.cy - this.heightCharName, 2, mFont.tahoma_7_grey);
                            }
                            this.heightCharName++;
                        }
                        break label152;
                    }
                    if (!GameScr.gI().lockAutoMove) {
                        this.heightCharName = this.heightCharName + mFont.tahoma_7.getHeight();
                        mFont.tahoma_7_yellow.drawString(g, mResources.AUTO_FIRE, this.cx, this.cy - this.heightCharName, 2, mFont.tahoma_7_grey);
                    } else {
                        this.heightCharName = this.heightCharName + mFont.tahoma_7.getHeight();
                        mFont.tahoma_7_yellow.drawString(g, mResources.UNMOVE, this.cx, this.cy - this.heightCharName, 2, mFont.tahoma_7_grey);
                    }
                } else {
                    if (getMyChar().charFocus != null && getMyChar().charFocus.equals(this)) {
                        flag = true;
                        this.heightCharName += 5;
                        this.paintHp(g, this.cx - 13, this.cy - this.heightCharName);
                        this.heightCharName = this.heightCharName + mFont.tahoma_7.getHeight();
                        if (!this.isHuman) {
                            mFont.tahoma_7_blue1.drawString(g, this.cName, this.cx, this.cy - this.heightCharName, 2, mFont.tahoma_7_grey);
                        } else {
                            color_font_name[this.ColorName].drawString(g, this.cName, this.cx, this.cy - this.heightCharName, 2, mFont.tahoma_7_grey);
                        }
                        this.heightCharName++;
                        break label152;
                    }
                    if (!this.paintName) {
                        break label152;
                    }
                    flag = true;
                    this.heightCharName = this.heightCharName + mFont.tahoma_7.getHeight();
                    if (!this.isHuman) {
                        mFont.tahoma_7_blue1.drawString(g, this.cName, this.cx, this.cy - this.heightCharName, 2, mFont.tahoma_7_grey);
                    } else {
                        color_font_name[this.ColorName].drawString(g, this.cName, this.cx, this.cy - this.heightCharName, 2, mFont.tahoma_7_grey);
                    }
                }
                this.heightCharName++;
            }
            if (this.charID == -getMyChar().charID) {
                this.heightCharName = this.heightCharName + color_font_name[this.ColorName].getHeight();
                color_font_name[this.ColorName].drawString(g, mResources.BY + " " + getMyChar().cName + " " + mResources.PROTECT, this.cx, this.cy - this.heightCharName, 2, mFont.tahoma_7_grey);
                this.heightCharName++;
            }
            if (!this.cClanName.equals("") && flag) {
                this.heightCharName = this.heightCharName + (mFont.tahoma_7.getHeight() - 1);
                byte byteValue = 0;
                if (this.ctypeClan > 0) {
                    byteValue = 5;
                }
                mFont.tahoma_7_white.drawString(g, this.cClanName, this.cx + byteValue, this.cy - this.heightCharName, 2, mFont.tahoma_7_blue);
                if (this.ctypeClan == 3) {
                    SmallImage.drawSmallImage(g, 1215, this.cx - (mFont.tahoma_7_white.getWidth(this.cClanName) / 2 + (7 - byteValue)), this.cy - this.heightCharName + 1, 0, 17);
                } else if (this.ctypeClan == 4) {
                    SmallImage.drawSmallImage(g, 1216, this.cx - (mFont.tahoma_7_white.getWidth(this.cClanName) / 2 + (7 - byteValue)), this.cy - this.heightCharName + 1, 0, 17);
                } else if (this.ctypeClan == 2) {
                    SmallImage.drawSmallImage(g, 1217, this.cx - (mFont.tahoma_7_white.getWidth(this.cClanName) / 2 + (7 - byteValue)), this.cy - this.heightCharName + 1, 0, 17);
                }
                this.heightCharName++;
            }
            if (this.resultTest > 0 && this.resultTest < 30) {
                this.heightCharName = this.heightCharName + SmallImage.smallImg[1117][4];
                SmallImage.drawSmallImage(g, 1117, this.cx, this.cy - this.heightCharName, 0, 17);
                this.heightCharName++;
            } else if (this.resultTest > 30 && this.resultTest < 60) {
                this.heightCharName = this.heightCharName + SmallImage.smallImg[1117][4];
                SmallImage.drawSmallImage(g, 1126, this.cx, this.cy - this.heightCharName, 0, 17);
                this.heightCharName++;
            } else if (this.resultTest > 60 && this.resultTest < 90) {
                this.heightCharName = this.heightCharName + SmallImage.smallImg[1117][4];
                SmallImage.drawSmallImage(g, 1118, this.cx, this.cy - this.heightCharName, 0, 17);
                this.heightCharName++;
            } else {
                if (this.charID >= 0) {
                    if (this.killCharId >= 0) {
                        this.heightCharName = this.heightCharName + SmallImage.smallImg[1122][4];
                        SmallImage.drawSmallImage(g, 1122, this.cx, this.cy - this.heightCharName, 0, 17);
                        this.heightCharName++;
                        return;
                    }
                    if (this.cTypePk == 3) {
                        this.heightCharName = this.heightCharName + SmallImage.smallImg[1121][4];
                        SmallImage.drawSmallImage(g, 1121, this.cx, this.cy - this.heightCharName, 0, 17);
                        this.heightCharName++;
                        return;
                    }
                    if (this.cTypePk == 2) {
                        this.heightCharName = this.heightCharName + SmallImage.smallImg[1124][4];
                        SmallImage.drawSmallImage(g, 1124, this.cx, this.cy - this.heightCharName, 0, 17);
                        this.heightCharName++;
                        return;
                    }
                    if (this.cTypePk == 1) {
                        this.heightCharName = this.heightCharName + SmallImage.smallImg[1123][4];
                        SmallImage.drawSmallImage(g, 1123, this.cx, this.cy - this.heightCharName, 0, 17);
                        this.heightCharName++;
                        return;
                    }
                    if (this.cTypePk == 4) {
                        this.heightCharName = this.heightCharName + SmallImage.smallImg[1240][4];
                        SmallImage.drawSmallImage(g, 1240, this.cx, this.cy - this.heightCharName, 0, 17);
                        this.heightCharName++;
                        return;
                    }
                    if (this.cTypePk == 5) {
                        this.heightCharName = this.heightCharName + SmallImage.smallImg[1241][4];
                        SmallImage.drawSmallImage(g, 1241, this.cx, this.cy - this.heightCharName, 0, 17);
                        this.heightCharName++;
                        return;
                    }
                    if (this.cTypePk == 6) {
                        this.heightCharName = this.heightCharName + SmallImage.smallImg[1241][4];
                        SmallImage.drawSmallImage(g, 1123, this.cx, this.cy - this.heightCharName, 0, 17);
                        this.heightCharName++;
                        return;
                    }
                    if (this.cTypePk == 7) {
                        this.heightCharName = this.heightCharName + SmallImage.smallImg[1241][4];
                        SmallImage.drawSmallImage(g, 3410, this.cx, this.cy - this.heightCharName, 0, 17);
                        this.heightCharName++;
                        return;
                    }
                    if (this.testCharId > 0) {
                        this.heightCharName = this.heightCharName + SmallImage.smallImg[1116][4];
                        SmallImage.drawSmallImage(g, 1116, this.cx, this.cy - this.heightCharName, 0, 17);
                        this.heightCharName++;
                    }
                }
            }
        }
    }

    private byte getFrameHores() {
        DataSkillEff dataSkillEff;
        if ((dataSkillEff = getPartEff(this.ID_HORSE, true)) != null && dataSkillEff.isLoadData) {
            if (this.statusMe == 1 || this.statusMe == 6) {
                this.ActionHorse = dataSkillEff.ActionStand;
            } else if (this.statusMe == 2 || this.statusMe == 10) {
                this.ActionHorse = dataSkillEff.ActionMove;
            } else if (this.statusMe == 4) {
                this.ActionHorse = dataSkillEff.ActionFall;
            } else if (this.statusMe == 3) {
                this.ActionHorse = dataSkillEff.ActionJum;
            } else {
                this.ActionHorse = dataSkillEff.ActionStand;
            }
            return this.fho >= this.ActionHorse.length ? (byte) (this.ActionHorse[this.ActionHorse.length - 1] + this.FrameHorse * dataSkillEff.nHorseFrame) : (byte) (this.ActionHorse[this.fho] + this.FrameHorse * dataSkillEff.nHorseFrame);
        } else {
            return 0;
        }
    }

    private int getFrameHorseui(int value) {
        return value + this.fHorseUI * 30;
    }

    public final void paintHorseUI(mGraphics g, int x, int y) {
        DataSkillEff dataSkillEff;
        if ((dataSkillEff = getPartEff(this.ID_HORSE, true)) != null && dataSkillEff.isLoadData) {
            if (GameCanvas.gameTick % 10 == 0) {
                int value;
                if ((value = dataSkillEff.listFrame.size() / dataSkillEff.sequence.length) == 0) {
                    value = 1;
                }
                this.fHorseUI = (byte) ((this.fHorseUI + 1) % value);
            }
            dataSkillEff.paintBottomEff_new(g, x, y, this.getFrameHorseui(dataSkillEff.ActionStand[this.fhorsetrangbi]), 2);
            dataSkillEff.paintTopEff_new(g, x, y, this.getFrameHorseui(dataSkillEff.ActionStand[this.fhorsetrangbi]), 2);
        }
    }

    private int getFrameBienHinh() {
        if (!this.isMoto && !this.isWolf && !this.isNewMount && this.ID_HORSE <= -1) {
            return this.cf + this.FrameBienHinh * 30;
        } else {
            return this.statusMe != 1 && this.statusMe != 6 ? this.fRun_PP[this.fBienhinh] + this.FrameBienHinh * 30 : this.cf + this.FrameBienHinh * 30;
        }
    }

    private int getFrameLeg() {
        if (!this.isMoto && !this.isWolf && !this.isNewMount && this.ID_HORSE <= -1) {
            return this.cf + this.FrameLeg * 30;
        } else {
            return this.statusMe != 1 && this.statusMe != 6 ? this.fRun_PP[this.fLeg] + this.FrameLeg * 30 : this.cf + this.FrameLeg * 30;
        }
    }

    private int getFrameMatna() {
        if (!this.isMoto && !this.isWolf && !this.isNewMount) {
            return this.cf + this.FrameMatna * 30;
        } else {
            return this.statusMe != 1 && this.statusMe != 6 ? this.fRun_PP[this.fMatNa] + this.FrameMatna * 30 : this.cf + this.FrameMatna * 30;
        }
    }

    private int getFrameWeapone() {
        if (!this.isMoto && !this.isWolf && !this.isNewMount) {
            return this.cf + this.FrameWeaPone * 30;
        } else {
            return this.statusMe != 1 && this.statusMe != 6 ? this.fRun_PP[this.fWeapone] + this.FrameWeaPone * 30 : this.cf + this.FrameWeaPone * 30;
        }
    }

    private int getFrameBody() {
        if (!this.isMoto && !this.isWolf && !this.isNewMount) {
            return this.cf + this.FrameBody * 30;
        } else {
            return this.statusMe != 1 && this.statusMe != 6 ? this.fRun_PP[this.fBody] + this.FrameBody * 30 : this.cf + this.FrameBody * 30;
        }
    }

    private int getFrameHair() {
        if (!this.isMoto && !this.isWolf && !this.isNewMount) {
            return this.cf + this.FrameHair * 30;
        } else {
            return this.statusMe != 1 && this.statusMe != 6 ? this.fRun_PP[this.fHair] + this.FrameHair * 30 : this.cf + this.FrameHair * 30;
        }
    }

    private int getFramePP() {
        if (!this.isMoto && !this.isWolf && !this.isNewMount && this.ID_HORSE <= -1) {
            return this.cf + this.FramePP * 30;
        } else {
            return this.statusMe != 1 && this.statusMe != 6 ? this.fRun_PP[this.fPP] + this.FramePP * 30 : this.cf + this.FramePP * 30;
        }
    }

    private int getFramePP(int value) {
        return value + this.fPPUI * 30;
    }

    private int getFrameHeadUI(int value) {
        return value + this.fHeadUI * 30;
    }

    private int getFrameBodyUI(int value) {
        return value + this.FbodyUI * 30;
    }

    private int getFrameLegUI(int value) {
        return value + this.FlegUI * 30;
    }

    public final void paintPPUIBot(mGraphics graphics, int value, int value1, int value2) {
        DataSkillEff dataSkillEff;
        if ((dataSkillEff = getPartEff(this.ID_PP, false)) != null) {
            dataSkillEff.paintBottomEff_new(graphics, value, value1, this.getFramePP(value2), 0);
        }
    }

    public final void paintPPUITop(mGraphics g, int cx1, int cy2, int f) {
        DataSkillEff dataSkillEff;
        if ((dataSkillEff = getPartEff(this.ID_PP, false)) != null) {
            if (GameCanvas.gameTick % 10 == 0) {
                int value;
                if ((value = dataSkillEff.listFrame.size() / 30) == 0) {
                    value = 1;
                }
                this.fPPUI = (byte) ((this.fPPUI + 1) % value);
            }
            dataSkillEff.paintTopEff_new(g, cx1, cy2, this.getFramePP(f), 0);
        }
    }

    private int getFrameWeaponUI(int value) {
        return value + this.fWeaponUI * 30;
    }

    private int getFrameMatNaUI(int value) {
        return value + this.fMatNaUI * 30;
    }

    public final void paintMatNaUI(mGraphics g, int cx1, int cy2, int f) {
        DataSkillEff dataSkillEff;
        if ((dataSkillEff = getPartEff(this.ID_MAT_NA, false)) != null) {
            if (GameCanvas.gameTick % 6 == 0) {
                int value;
                if ((value = dataSkillEff.listFrame.size() / 30) == 0) {
                    value = 1;
                }
                this.fMatNaUI = (byte) ((this.fMatNaUI + 1) % value);
            }
            dataSkillEff.paintTopEff_new(g, cx1, cy2, this.getFrameMatNaUI(f), 0);
            dataSkillEff.paintBottomEff_new(g, cx1, cy2, this.getFrameMatNaUI(f), 0);
        }
    }

    public final void paintWeaponUITop(mGraphics graphics, int value, int value1, int value2) {
        DataSkillEff dataSkillEff;
        if ((dataSkillEff = getPartEff(this.ID_WEA_PONE, false)) != null) {
            if (GameCanvas.gameTick % 6 == 0) {
                int value3;
                if ((value3 = dataSkillEff.listFrame.size() / 30) == 0) {
                    value3 = 1;
                }
                this.fWeaponUI = (byte) ((this.fWeaponUI + 1) % value3);
            }
            dataSkillEff.paintTopEff_new(graphics, value, value1, this.getFrameWeaponUI(value2), 0);
        }
    }

    public final void paintWeaponUIBot(mGraphics graphics, int value, int value1, int value2) {
        DataSkillEff dataSkillEff;
        if ((dataSkillEff = getPartEff(this.ID_WEA_PONE, false)) != null) {
            if (GameCanvas.gameTick % 6 == 0) {
                int value3;
                if ((value3 = dataSkillEff.listFrame.size() / 30) == 0) {
                    value3 = 1;
                }
                this.fWeaponUI = (byte) ((this.fWeaponUI + 1) % value3);
            }
            dataSkillEff.paintBottomEff_new(graphics, value, value1, this.getFrameWeaponUI(value2), 0);
        }
    }

    public final void paintHeadUI(mGraphics g, int cx1, int cy2, int f) {
        DataSkillEff dataSkillEff;
        if ((dataSkillEff = getPartEff(this.ID_HAIR, false)) != null) {
            if (GameCanvas.gameTick % 6 == 0) {
                int value;
                if ((value = dataSkillEff.listFrame.size() / 30) == 0) {
                    value = 1;
                }
                this.fHeadUI = (byte) ((this.fHeadUI + 1) % value);
            }
            dataSkillEff.paintBottomEff_new(g, cx1, cy2, this.getFrameHeadUI(f), 0);
            dataSkillEff.paintTopEff_new(g, cx1, cy2, this.getFrameHeadUI(f), 0);
        }
    }

    public final void paintLegUI(mGraphics g, int cx1, int cy2, int f) {
        DataSkillEff dataSkillEff;
        if ((dataSkillEff = getPartEff(this.ID_LEG, false)) != null) {
            if (GameCanvas.gameTick % 6 == 0) {
                int value;
                if ((value = dataSkillEff.listFrame.size() / 30) == 0) {
                    value = 1;
                }
                this.FlegUI = (byte) ((this.FlegUI + 1) % value);
            }
            dataSkillEff.paintBottomEff_new(g, cx1, cy2, this.getFrameLegUI(f), 0);
            dataSkillEff.paintTopEff_new(g, cx1, cy2, this.getFrameLegUI(f), 0);
        }
    }

    public final void paintBodyUI(mGraphics g, int cx1, int cy2, int f) {
        DataSkillEff dataSkillEff;
        if ((dataSkillEff = getPartEff(this.ID_Body, false)) != null) {
            if (GameCanvas.gameTick % 6 == 0) {
                int value;
                if ((value = dataSkillEff.listFrame.size() / 30) == 0) {
                    value = 1;
                }
                this.FbodyUI = (byte) ((this.FbodyUI + 1) % value);
            }
            dataSkillEff.paintBottomEff_new(g, cx1, cy2, this.getFrameBodyUI(f), 0);
            dataSkillEff.paintTopEff_new(g, cx1, cy2, this.getFrameBodyUI(f), 0);
        }
    }

    private void paintWeaponBot(mGraphics graphics, int value, int value1, int value2, DataSkillEff dataSkillEff) {
        value2 = 0;
        if ((this.statusMe == 1 || this.statusMe == 6) && this.cf <= 1) {
            value2 = this.cf << 1;
        }
        if (dataSkillEff != null) {
            if (this.isNewMount) {
                byte byteValue = -2;
                if (this.cdir == 1) {
                    byteValue = 2;
                }
                if ((this.statusMe == 1 || this.statusMe == 6) && this.cf <= 1) {
                    value2 = this.cf;
                }
                dataSkillEff.paintBottomEff_new(graphics, value + this.getxs() + byteValue, value1 + value2 - this.getDyHorse() + this.dyMount - this.getys(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.FrameWeaPone * 30 : this.getFrameWeapone(), this.cdir == 1 ? 0 : 2);
                return;
            }
            if (this.isWolf) {
                dataSkillEff.paintBottomEff_new(graphics, value + this.getxs(), value1 + value2 - this.getDyHorse() - this.getys(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.FrameWeaPone * 30 : this.getFrameWeapone(), this.cdir == 1 ? 0 : 2);
                return;
            }
            if (this.isMoto) {
                dataSkillEff.paintBottomEff_new(graphics, value + this.getxs(), value1 + value2 - this.getDyHorse() - this.getys(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.FrameWeaPone * 30 : this.getFrameWeapone(), this.cdir == 1 ? 0 : 2);
                return;
            }
            if (this.ID_HORSE > -1) {
                dataSkillEff.paintBottomEff_new(graphics, value + this.getxs() + this.dxnewhorse, value1 - this.getys() - this.getDyHorse(), this.getFrameWeapone(), this.cdir == 1 ? 0 : 2);
                return;
            }
            dataSkillEff.paintBottomEff_new(graphics, value + this.getxs(), value1 - this.getys(), this.getFrameWeapone(), this.cdir == 1 ? 0 : 2);
        }
    }

    private void paintWeaponTop(mGraphics graphics, int value, int value1, int value2, DataSkillEff dataSkillEff) {
        value2 = 0;
        if ((this.statusMe == 1 || this.statusMe == 6) && this.cf <= 1) {
            value2 = this.cf << 1;
        }
        if (dataSkillEff != null) {
            if (this.isNewMount) {
                byte byteValue = -2;
                if (this.cdir == 1) {
                    byteValue = 2;
                }
                if ((this.statusMe == 1 || this.statusMe == 6) && this.cf <= 1) {
                    value2 = this.cf;
                }
                dataSkillEff.paintTopEff_new(graphics, value + this.getxs() + byteValue, value1 + value2 - this.getDyHorse() + this.dyMount - this.getys(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.FrameWeaPone * 30 : this.getFrameWeapone(), this.cdir == 1 ? 0 : 2);
                return;
            }
            if (this.isWolf) {
                dataSkillEff.paintTopEff_new(graphics, value + this.getxs(), value1 + value2 - this.getDyHorse() - this.getys(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.FrameWeaPone * 30 : this.getFrameWeapone(), this.cdir == 1 ? 0 : 2);
                return;
            }
            if (this.isMoto) {
                dataSkillEff.paintTopEff_new(graphics, value + this.getxs(), value1 + value2 - this.getDyHorse() - this.getys(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.FrameWeaPone * 30 : this.getFrameWeapone(), this.cdir == 1 ? 0 : 2);
                return;
            }
            if (this.ID_HORSE > -1) {
                dataSkillEff.paintTopEff_new(graphics, value + this.getxs() + this.dxnewhorse, value1 - this.getys() - this.getDyHorse(), this.getFrameWeapone(), this.cdir == 1 ? 0 : 2);
                return;
            }
            dataSkillEff.paintTopEff_new(graphics, value + this.getxs(), value1 - this.getys(), this.getFrameWeapone(), this.cdir == 1 ? 0 : 2);
        }
    }

    private void paintBody(mGraphics graphics, int value, int value1, int value2) {
        DataSkillEff dataSkillEff = getPartEff(this.ID_Body, false);
        int value3 = 0;
        if ((this.statusMe == 1 || this.statusMe == 6) && this.cf <= 1) {
            value3 = this.cf * value2;
        }
        if (dataSkillEff != null) {
            dataSkillEff.paintBottomEff_new(graphics, value + this.getxs(), value1 + value3 - this.getys(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.FrameBody * 30 : this.getFrameBody(), this.cdir == 1 ? 0 : 2);
            dataSkillEff.paintTopEff_new(graphics, value + this.getxs(), value1 + value3 - this.getys(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.FrameBody * 30 : this.getFrameBody(), this.cdir == 1 ? 0 : 2);
        }
    }

    private int getys() {
        byte byteValue = 0;
        if (this.isMoto) {
            if (this.arrItemMounts[4].template.id == 485) {
                byteValue = 4;
            } else {
                byteValue = 6;
            }
        }
        if (this.isNewMount) {
            byteValue = 2;
            if (this.statusMe == 3) {
                byteValue = 4;
            }
        }
        return byteValue;
    }

    private int getxs() {
        byte byteValue = 0;
        if (this.isWolf) {
            byteValue = 3;
            if (this.cdir == 1) {
                byteValue = -3;
            }
        }
        if (this.isMoto) {
            if (this.arrItemMounts[4].template.id == 485) {
                byteValue = 4;
                if (this.cdir == 1) {
                    byteValue = -4;
                }
            } else {
                byteValue = 7;
                if (this.cdir == 1) {
                    byteValue = -7;
                }
            }
        }
        if (this.isNewMount) {
            byteValue = 1;
            if (this.cdir == 1) {
                byteValue = -1;
            }
        }
        return byteValue;
    }

    private void paintHair(mGraphics graphics, int value, int value1, int value2) {
        DataSkillEff dataSkillEff = getPartEff(this.ID_HAIR, false);
        int value3 = 0;
        if ((this.statusMe == 1 || this.statusMe == 6) && this.cf <= 1) {
            value3 = this.cf * value2;
        }
        if (dataSkillEff != null) {
            dataSkillEff.paintBottomEff_new(graphics, value + this.getxs(), value1 + value3 - this.getys(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.FrameHair * 30 : this.getFrameHair(), this.cdir == 1 ? 0 : 2);
            dataSkillEff.paintTopEff_new(graphics, value + this.getxs(), value1 + value3 - this.getys(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.FrameHair * 30 : this.getFrameHair(), this.cdir == 1 ? 0 : 2);
        }
    }

    private void paintMatna(mGraphics g, int cx1, int cy2, int f) {
        if (this.ID_MAT_NA >= 0) {
            DataSkillEff dataSkillEff = getPartEff(this.ID_MAT_NA, false);
            int value = 0;
            if ((this.statusMe == 1 || this.statusMe == 6) && this.cf <= 1) {
                value = this.cf * f;
            }
            if (dataSkillEff != null) {
                if (this.isWolf && (this.arrItemMounts[4].template.id == 443 || this.arrItemMounts[4].template.id == 523)) {
                    byte byteValue = -2;
                    if (this.statusMe == 1 || this.statusMe == 6) {
                        byteValue = 0;
                    }
                    byte byteValue3 = 0;
                    if (this.cgender == 1) {
                        byteValue3 = 3;
                    }
                    if (this.statusMe == 1 || this.statusMe == 6) {
                        byteValue3 = 0;
                    }
                    dataSkillEff.paintBottomEff_new(g, cx1 + byteValue, cy2 + value - this.getys() - byteValue3, this.statusMe != 1 && this.statusMe != 6 ? 5 + this.FrameMatna * 30 : this.getFrameMatna(), this.cdir == 1 ? 0 : 2);
                    dataSkillEff.paintTopEff_new(g, cx1 + byteValue, cy2 + value - this.getys() - byteValue3, this.statusMe != 1 && this.statusMe != 6 ? 5 + this.FrameMatna * 30 : this.getFrameMatna(), this.cdir == 1 ? 0 : 2);
                    return;
                }
                dataSkillEff.paintBottomEff_new(g, cx1 + this.getxs(), cy2 + value - this.getys(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.FrameMatna * 30 : this.getFrameMatna(), this.cdir == 1 ? 0 : 2);
                dataSkillEff.paintTopEff_new(g, cx1 + this.getxs(), cy2 + value - this.getys(), this.statusMe != 1 && this.statusMe != 6 ? 5 + this.FrameMatna * 30 : this.getFrameMatna(), this.cdir == 1 ? 0 : 2);
            }
        }
    }

    private void paintPP_Bot(mGraphics graphics) {
        DataSkillEff dataSkillEff = getPartEff(this.ID_PP, false);
        byte byteValue = 0;
        int value = 0;
        if (this.isMoto) {
            if (this.arrItemMounts[4].template.id == 485) {
                if ((this.statusMe == 1 || this.statusMe == 6) && this.cf <= 1) {
                    value = this.cf << 1;
                }
                if (dataSkillEff != null) {
                    dataSkillEff.paintBottomEff_new(graphics, this.cx + this.getxs(), this.cy - 9 + value - this.getys(), this.getFramePP(), this.cdir == 1 ? 0 : 2);
                }
            }
            if (this.arrItemMounts[4].template.id == 524) {
                byteValue = 2;
                if ((this.statusMe == 1 || this.statusMe == 6) && this.cf <= 1) {
                    value = this.cf << 1;
                }
                if (this.cdir == 1) {
                    byteValue = -2;
                }
                if (dataSkillEff != null) {
                    dataSkillEff.paintBottomEff_new(graphics, this.cx + byteValue + this.getxs(), this.cy - 12 + value - this.getys(), this.getFramePP(), this.cdir == 1 ? 0 : 2);
                    return;
                }
            }
        } else if (this.isWolf) {
            if (this.arrItemMounts[4].template.id == 523) {
                if ((this.statusMe == 1 || this.statusMe == 6) && this.cf <= 1) {
                    value = this.cf << 1;
                }
                byteValue = 2;
                if (this.cdir == 1) {
                    byteValue = -2;
                }
                if (dataSkillEff != null) {
                    dataSkillEff.paintBottomEff_new(graphics, this.cx + byteValue + this.getxs(), this.cy - 15 + value - this.getys(), this.getFramePP(), this.cdir == 1 ? 0 : 2);
                    return;
                }
            } else if (this.arrItemMounts[4].template.id == 443) {
                if ((this.statusMe == 1 || this.statusMe == 6) && this.cf <= 1) {
                    value = this.cf << 1;
                }
                byteValue = 2;
                if (this.cdir == 1) {
                    byteValue = -2;
                }
                if (dataSkillEff != null) {
                    dataSkillEff.paintBottomEff_new(graphics, this.cx + byteValue + this.getxs(), this.cy - 15 + value - this.getys(), this.getFramePP(), this.cdir == 1 ? 0 : 2);
                    return;
                }
            }
        } else if (this.isNewMount) {
            byteValue = -4;
            if ((this.statusMe == 1 || this.statusMe == 6) && this.cf <= 1) {
                value = this.cf;
            }
            if (this.cdir == 1) {
                byteValue = 4;
            }
            if (dataSkillEff != null) {
                dataSkillEff.paintBottomEff_new(graphics, this.cx + byteValue + this.getxs(), this.cy - 18 + this.dyMount + value - this.getys(), this.getFramePP(), this.cdir == 1 ? 0 : 2);
                return;
            }
        } else if (dataSkillEff != null) {
            dataSkillEff.paintBottomEff_new(graphics, this.cx + this.dxnewhorse + this.getxs(), this.cy - this.dynewhhorse - this.getys(), this.getFramePP(), this.cdir == 1 ? 0 : 2);
        }
    }

    private void paintPP_Top(mGraphics graphics) {
        DataSkillEff dataSkillEff = getPartEff(this.ID_PP, false);
        byte byteValue = 0;
        int value = 0;
        if (this.isMoto) {
            if (this.arrItemMounts[4].template.id == 485) {
                if ((this.statusMe == 1 || this.statusMe == 6) && this.cf <= 1) {
                    value = this.cf << 1;
                }
                if (dataSkillEff != null) {
                    dataSkillEff.paintTopEff_new(graphics, this.cx + this.getxs(), this.cy - 9 + value - this.getys(), this.getFramePP(), this.cdir == 1 ? 0 : 2);
                }
            }
            if (this.arrItemMounts[4].template.id == 524) {
                byteValue = 2;
                if ((this.statusMe == 1 || this.statusMe == 6) && this.cf <= 1) {
                    value = this.cf << 1;
                }
                if (this.cdir == 1) {
                    byteValue = -2;
                }
                if (dataSkillEff != null) {
                    dataSkillEff.paintTopEff_new(graphics, this.cx + byteValue + this.getxs(), this.cy - 12 + value - this.getys(), this.getFramePP(), this.cdir == 1 ? 0 : 2);
                    return;
                }
            }
        } else if (this.isWolf) {
            if (this.arrItemMounts[4].template.id == 523) {
                byteValue = 2;
                if ((this.statusMe == 1 || this.statusMe == 6) && this.cf <= 1) {
                    value = this.cf << 1;
                }
                if (this.cdir == 1) {
                    byteValue = -2;
                }
                if (dataSkillEff != null) {
                    dataSkillEff.paintTopEff_new(graphics, this.cx + byteValue + this.getxs(), this.cy - 15 + value - this.getys(), this.getFramePP(), this.cdir == 1 ? 0 : 2);
                    return;
                }
            } else if (this.arrItemMounts[4].template.id == 443) {
                if ((this.statusMe == 1 || this.statusMe == 6) && this.cf <= 1) {
                    value = this.cf << 1;
                }
                byteValue = 2;
                if (this.cdir == 1) {
                    byteValue = -2;
                }
                if (dataSkillEff != null) {
                    dataSkillEff.paintTopEff_new(graphics, this.cx + byteValue + this.getxs(), this.cy - 15 + value - this.getys(), this.getFramePP(), this.cdir == 1 ? 0 : 2);
                    return;
                }
            }
        } else if (this.isNewMount) {
            byteValue = -4;
            if ((this.statusMe == 1 || this.statusMe == 6) && this.cf <= 1) {
                value = this.cf;
            }
            if (this.cdir == 1) {
                byteValue = 4;
            }
            if (dataSkillEff != null) {
                dataSkillEff.paintTopEff_new(graphics, this.cx + byteValue + this.getxs(), this.cy - 18 + this.dyMount + value - this.getys(), this.getFramePP(), this.cdir == 1 ? 0 : 2);
                return;
            }
        } else if (dataSkillEff != null) {
            dataSkillEff.paintTopEff_new(graphics, this.cx + this.dxnewhorse + this.getxs(), this.cy - this.dynewhhorse - this.getys(), this.getFramePP(), this.cdir == 1 ? 0 : 2);
        }
    }

    private int getDyHorse() {
        DataSkillEff dataSkillEff;
        if (this.ID_HORSE > -1 && (dataSkillEff = getPartEff(this.ID_HORSE, true)) != null && dataSkillEff.isLoadData) {
            return dataSkillEff.dyHorse + dataSkillEff.Dy_Char[this.getFrameHores()];
        } else {
            return !this.isWolf && !this.isMoto && !this.isNewMount ? 0 : 12;
        }
    }

    private void paintCharWithoutSkill(mGraphics g) {
        try {
            DataSkillEff dataSkillEff;
            if ((dataSkillEff = getPartEff(this.ID_WEA_PONE, false)) != null && GameCanvas.gameTick % 3 == 0) {
                int value;
                if ((value = dataSkillEff.listFrame.size() / 30) == 0) {
                    value = 1;
                }
                this.FrameWeaPone = (byte) ((this.FrameWeaPone + 1) % value);
            }
            DataSkillEff dataSkillEff1;
            if ((dataSkillEff1 = getPartEff(this.ID_Bien_Hinh, false)) != null && GameCanvas.gameTick % 6 == 0) {
                int value2;
                if ((value2 = dataSkillEff1.listFrame.size() / 30) == 0) {
                    value2 = 1;
                }
                this.FrameBienHinh = (byte) ((this.FrameBienHinh + 1) % value2);
            }
            DataSkillEff dataSkillEff3;
            if ((dataSkillEff3 = getPartEff(this.ID_MAT_NA, false)) != null && GameCanvas.gameTick % 6 == 0) {
                int value4;
                if ((value4 = dataSkillEff3.listFrame.size() / 30) == 0) {
                    value4 = 1;
                }
                this.FrameMatna = (byte) ((this.FrameMatna + 1) % value4);
            }
            DataSkillEff dataSkillEff5 = getPartEff(this.ID_SUSANO, false);
            DataSkillEff dataSkillEff6 = getPartEff(this.ID_RANK, false);
            DataSkillEff dataSkillEff7 = getPartEff(this.ID_NAME, false);
            DataSkillEff dataSkillEff8;
            if ((dataSkillEff8 = getPartEff(this.ID_LEG, false)) != null && GameCanvas.gameTick % 6 == 0) {
                int value9;
                if ((value9 = dataSkillEff8.listFrame.size() / 30) == 0) {
                    value9 = 1;
                }
                this.FrameLeg = (byte) ((this.FrameLeg + 1) % value9);
            }
            DataSkillEff dataSkillEff10;
            if ((dataSkillEff10 = getPartEff(this.ID_HORSE, true)) != null && dataSkillEff10.isLoadData && GameCanvas.gameTick % 10 == 0) {
                int value11;
                if ((value11 = dataSkillEff10.listFrame.size() / dataSkillEff10.sequence.length) == 0) {
                    value11 = 1;
                }
                this.FrameHorse = (byte) ((this.FrameHorse + 1) % value11);
            }
            DataSkillEff dataSkillEff12;
            if ((dataSkillEff12 = getPartEff(this.ID_Body, false)) != null && GameCanvas.gameTick % 6 == 0) {
                int value13;
                if ((value13 = dataSkillEff12.listFrame.size() / 30) == 0) {
                    value13 = 1;
                }
                this.FrameBody = (byte) ((this.FrameBody + 1) % value13);
            }
            DataSkillEff dataSkillEff14;
            if ((dataSkillEff14 = getPartEff(this.ID_HAIR, false)) != null && GameCanvas.gameTick % 6 == 0) {
                int value15;
                if ((value15 = dataSkillEff14.listFrame.size() / 30) == 0) {
                    value15 = 1;
                }
                this.FrameHair = (byte) ((this.FrameHair + 1) % value15);
            }
            DataSkillEff dataSkillEff16;
            if ((dataSkillEff16 = getPartEff(this.ID_PP, false)) != null && GameCanvas.gameTick % 6 == 0) {
                int value17;
                if ((value17 = dataSkillEff16.listFrame.size() / 30) == 0) {
                    value17 = 1;
                }
                this.FramePP = (byte) ((this.FramePP + 1) % value17);
            }
            int[] values = null;
            Part part = GameScr.parts[this.head];
            Part part18 = GameScr.parts[this.leg];
            Part part19 = GameScr.parts[this.body];
            Part part20 = GameScr.parts[this.wp];
            if (dataSkillEff != null) {
                part20 = null;
            }
            if (this.arrItemBody != null && this.arrItemBody[11] != null) {
                part = GameScr.parts[this.arrItemBody[11].template.part];
                this.head = this.arrItemBody[11].template.part;
            }
            if (part.pi != null && part.pi.length >= 8) {
                for (int index = 0; index < part.pi.length; index++) {
                    if (part.pi[index] == null || !SmallImage.isExitsImage(part.pi[index].id)) {
                        part = getDefaultHead(this.cgender);
                        break;
                    }
                }
            } else {
                part = getDefaultHead(this.cgender);
            }
            values = part.pi[CharInfo[this.cf][0][0]].id <= 4 ? null : this.getClassCoat();
            if (((this.statusMe == 1 || this.statusMe == 6) && GameCanvas.gameTick % 10 == 0 || (this.statusMe == 2 || this.statusMe == 10) && GameCanvas.gameTick % 2 == 0 || (this.statusMe == 4 || this.statusMe == 3) && GameCanvas.gameTick % 3 == 0) && values != null) {
                this.tickCoat++;
                if (this.tickCoat > values.length - 1) {
                    this.tickCoat = 0;
                }
            }
            if (this.statusMe == 14) {
                if (this.isHaveNewMount()) {
                    this.paintBehindNewMount(g);
                } else if (this.isHaveMoto()) {
                    if (this.arrItemMounts[4].template.id == 485) {
                        if (this.arrItemMounts[4].sys < 2) {
                            SmallImage.drawSmallImage(g, 1800, this.lcx, this.lcy, 2, 33);
                        } else {
                            SmallImage.drawSmallImage(g, 2063, this.lcx, this.lcy, 2, 33);
                        }
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        if (this.arrItemMounts[4].sys < 2) {
                            SmallImage.drawSmallImage(g, 2064, this.lcx, this.lcy, 2, 33);
                        } else {
                            SmallImage.drawSmallImage(g, 2068, this.lcx, this.lcy, 2, 33);
                        }
                    }
                }
                SmallImage.drawSmallImage(g, 1040, this.cx, this.cy, 0, 33);
            } else if (this.isInvisible) {
                if (this.me) {
                    if (GameCanvas.gameTick % 50 != 48 && GameCanvas.gameTick % 50 != 90) {
                        SmallImage.drawSmallImage(g, 1195, this.cx, this.cy - 18, 0, 3);
                    } else {
                        SmallImage.drawSmallImage(g, 1196, this.cx, this.cy - 18, 0, 3);
                    }
                }
            } else {
                if (dataSkillEff5 != null) {
                    dataSkillEff5.paintBottomEff_new(g, this.cx, this.cy - this.getDyHorse(), this.FrameSusan, this.cdir == 1 ? 0 : 2);
                }
                if (dataSkillEff != null) {
                    this.paintWeaponBot(g, this.cx, this.cy, 2, dataSkillEff);
                }
                if (dataSkillEff1 != null) {
                    dataSkillEff1.paintBottomEff_new(g, this.cx, this.cy, this.getFrameBienHinh(), this.cdir == 1 ? 0 : 2);
                    dataSkillEff1.paintTopEff_new(g, this.cx, this.cy, this.getFrameBienHinh(), this.cdir == 1 ? 0 : 2);
                }
                if (dataSkillEff10 != null) {
                    dataSkillEff10.paintBottomEff_new(g, this.cx, this.cy, this.getFrameHores(), this.cdir == 1 ? 2 : 0);
                }
                if (dataSkillEff6 != null) {
                    dataSkillEff6.paintBottomEff_new(g, this.cx, this.cy - this.getDyHorse(), this.FrameRank, this.cdir == 1 ? 0 : 2);
                }
                if (dataSkillEff7 != null) {
                    dataSkillEff7.paintBottomEff_new(g, this.cx, this.cy - this.getDyHorse(), this.FrameName, 0);
                }
                this.paintPP_Bot(g);
                if (this.isMoto) {
                    int value21 = 0;
                    boolean flag = false;
                    int value22 = 0;
                    boolean flag23 = false;
                    int[] values24;
                    if ((values24 = this.geteffOngbo()) != null) {
                        this.tickEffmoto++;
                        if (this.tickEffmoto >= values24.length) {
                            this.tickEffmoto = 0;
                        }
                    }
                    if (this.arrItemMounts[4].template.id == 485) {
                        if (this.arrItemMounts[4].sys < 2) {
                            label1570: {
                                int value25;
                                if (this.statusMe != 1 && this.statusMe != 6) {
                                    if (this.statusMe != 2 && this.statusMe != 10) {
                                        break label1570;
                                    }
                                    value25 = GameCanvas.gameTick % 6 > 3 ? 1 : 0;
                                } else {
                                    value21 = GameCanvas.gameTick % 20 > 12 ? 1 : 0;
                                    if (dataSkillEff16 == null && dataSkillEff12 == null && dataSkillEff14 == null && dataSkillEff == null && dataSkillEff3 == null || this.cf > 1) {
                                        break label1570;
                                    }
                                    value25 = this.cf;
                                }
                                value21 = value25;
                            }
                            if (this.statusMe == 3) {
                                value22 = -5 * this.cdir;
                            }
                            if (this.cdir == 1) {
                                if (this.statusMe == 3) {
                                    SmallImage.drawSmallImage(g, 1711, this.cx, this.cy + 2, 0, 33);
                                } else {
                                    SmallImage.drawSmallImage(g, value21 == 0 ? 1709 : 1710, this.cx, this.cy, 0, 33);
                                }
                                if (dataSkillEff14 != null) {
                                    this.paintHair(g, this.cx, this.cy - 8, 2);
                                } else {
                                    SmallImage.drawSmallImage(g, this.getHeadId(), this.cx + value22 + this.dxHead * this.cdir, this.cy - CharInfo[0][0][2] + part.pi[CharInfo[0][0][0]].dy - 12 + value21 + this.dyHead, 0, 17);
                                }
                                if (dataSkillEff12 != null) {
                                    this.paintBody(g, this.cx, this.cy - 8, 2);
                                } else {
                                    SmallImage.drawSmallImage(g, this.getBodyPaintId(), this.cx + this.dxBody * this.cdir, this.cy - SmallImage.getHeight(this.getLegId()) - 8 + value21 + this.dyBody, 0, 33);
                                }
                                this.paintMatna(g, this.cx, this.cy - 8, 2);
                            } else {
                                if (this.statusMe == 3) {
                                    SmallImage.drawSmallImage(g, 1711, this.cx, this.cy + 2, 2, 33);
                                } else {
                                    SmallImage.drawSmallImage(g, value21 == 0 ? 1709 : 1710, this.cx, this.cy, 2, 33);
                                }
                                if (dataSkillEff14 != null) {
                                    this.paintHair(g, this.cx, this.cy - 8, 2);
                                } else {
                                    SmallImage.drawSmallImage(g, this.getHeadId(), this.cx + value22 + this.dxHead * this.cdir, this.cy - CharInfo[0][0][2] + part.pi[CharInfo[0][0][0]].dy - 12 + value21 + this.dyHead, 2, 17);
                                }
                                if (dataSkillEff12 != null) {
                                    this.paintBody(g, this.cx, this.cy - 8, 2);
                                } else {
                                    SmallImage.drawSmallImage(g, this.getBodyPaintId(), this.cx + this.dxBody * this.cdir, this.cy - SmallImage.getHeight(this.getLegId()) - 8 + value21 + this.dyBody, 2, 33);
                                }
                                this.paintMatna(g, this.cx, this.cy - 8, 2);
                            }
                        } else {
                            label1571: {
                                int value26;
                                if (this.statusMe != 1 && this.statusMe != 6) {
                                    if (this.statusMe != 2 && this.statusMe != 10) {
                                        break label1571;
                                    }
                                    value26 = GameCanvas.gameTick % 6 > 3 ? 1 : 0;
                                } else {
                                    value21 = GameCanvas.gameTick % 20 > 12 ? 1 : 0;
                                    if (dataSkillEff16 == null && dataSkillEff12 == null && dataSkillEff14 == null && dataSkillEff == null && dataSkillEff3 == null || this.cf > 1) {
                                        break label1571;
                                    }
                                    value26 = this.cf;
                                }
                                value21 = value26;
                            }
                            if (this.statusMe == 3) {
                                value22 = -5 * this.cdir;
                            }
                            if (this.cdir == 1) {
                                if (this.statusMe == 3) {
                                    SmallImage.drawSmallImage(g, 2057, this.cx, this.cy + 2, 0, 33);
                                } else if (!this.isBocdau) {
                                    SmallImage.drawSmallImage(g, value21 == 0 ? 2056 : 2055, this.cx, this.cy, 0, 33);
                                } else {
                                    SmallImage.drawSmallImage(g, 2057, this.cx, this.cy, 0, 33);
                                }
                                if (this.statusMe == 2 && values24 != null) {
                                    SmallImage.drawSmallImage(g, values24[this.tickEffmoto], this.cx - 25, this.cy - 2, 0, 33);
                                }
                                if (!this.isBocdau) {
                                    if (dataSkillEff14 != null) {
                                        this.paintHair(g, this.cx, this.cy - 8, 2);
                                    } else {
                                        SmallImage.drawSmallImage(g, this.getHeadId(), this.cx + value22 + this.dxHead * this.cdir, this.cy - CharInfo[0][0][2] + part.pi[CharInfo[0][0][0]].dy - 12 + value21 + this.dyHead, 0, 17);
                                    }
                                    if (dataSkillEff12 != null) {
                                        this.paintBody(g, this.cx, this.cy - 8, 2);
                                    } else {
                                        SmallImage.drawSmallImage(g, this.getBodyPaintId(), this.cx + this.dxBody * this.cdir, this.cy - SmallImage.getHeight(this.getLegId()) - 8 + value21 + this.dyBody, 0, 33);
                                    }
                                    this.paintMatna(g, this.cx, this.cy - 8, 2);
                                } else {
                                    if (dataSkillEff14 != null) {
                                        this.paintHair(g, this.cx, this.cy - 8, 2);
                                    } else {
                                        SmallImage.drawSmallImage(g, this.getHeadId(), this.cx + value22 + this.dxHead * this.cdir - 3, this.cy - 1 - CharInfo[0][0][2] + part.pi[CharInfo[0][0][0]].dy - 12 + value21 + this.dyHead, 0, 17);
                                    }
                                    if (dataSkillEff12 != null) {
                                        this.paintBody(g, this.cx, this.cy - 8, 2);
                                    } else {
                                        SmallImage.drawSmallImage(g, this.getBodyPaintId(), this.cx - 3 + this.dxBody * this.cdir, this.cy - 1 - SmallImage.getHeight(this.getLegId()) - 8 + value21 + this.dyBody, 0, 33);
                                    }
                                    this.paintMatna(g, this.cx, this.cy - 8, 2);
                                }
                            } else {
                                if (this.statusMe == 3) {
                                    SmallImage.drawSmallImage(g, 2057, this.cx, this.cy + 2, 2, 33);
                                } else if (!this.isBocdau) {
                                    SmallImage.drawSmallImage(g, value21 == 0 ? 2056 : 2055, this.cx, this.cy, 2, 33);
                                } else {
                                    SmallImage.drawSmallImage(g, 2057, this.cx, this.cy, 2, 33);
                                }
                                if (this.statusMe == 2 && values24 != null) {
                                    SmallImage.drawSmallImage(g, values24[this.tickEffmoto], this.cx + 25, this.cy - 2, 2, 33);
                                }
                                if (dataSkillEff14 != null) {
                                    this.paintHair(g, this.cx, this.cy - 8, 2);
                                } else {
                                    SmallImage.drawSmallImage(g, this.getHeadId(), this.cx + value22 + this.dxHead * this.cdir, this.cy - CharInfo[0][0][2] + part.pi[CharInfo[0][0][0]].dy - 12 + value21 + this.dyHead, 2, 17);
                                }
                                if (dataSkillEff12 != null) {
                                    this.paintBody(g, this.cx, this.cy - 8, 2);
                                } else {
                                    SmallImage.drawSmallImage(g, this.getBodyPaintId(), this.cx + this.dxBody * this.cdir, this.cy - SmallImage.getHeight(this.getLegId()) - 8 + value21 + this.dyBody, 2, 33);
                                }
                                this.paintMatna(g, this.cx, this.cy - 8, 2);
                            }
                        }
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        if (this.arrItemMounts[4].sys < 2) {
                            label1572: {
                                int value27;
                                if (this.statusMe != 1 && this.statusMe != 6) {
                                    if (this.statusMe != 2 && this.statusMe != 10) {
                                        break label1572;
                                    }
                                    value27 = GameCanvas.gameTick % 6 > 3 ? 1 : 0;
                                } else {
                                    value21 = GameCanvas.gameTick % 20 > 12 ? 1 : 0;
                                    if (dataSkillEff16 == null && dataSkillEff12 == null && dataSkillEff14 == null && dataSkillEff == null && dataSkillEff3 == null || this.cf > 1) {
                                        break label1572;
                                    }
                                    value27 = this.cf;
                                }
                                value21 = value27;
                            }
                            if (this.statusMe == 3) {
                                value22 = -5 * this.cdir;
                            }
                            if (this.cdir == 1) {
                                if (this.statusMe == 3) {
                                    SmallImage.drawSmallImage(g, 2066, this.cx, this.cy + 2, 0, 33);
                                } else {
                                    SmallImage.drawSmallImage(g, value21 == 0 ? 2064 : 2065, this.cx, this.cy, 0, 33);
                                }
                                if (dataSkillEff14 != null) {
                                    this.paintHair(g, this.cx, this.cy - 8, 2);
                                } else {
                                    SmallImage.drawSmallImage(g, this.getHeadId(), this.cx + value22 + this.dxHead * this.cdir, this.cy - CharInfo[0][0][2] + part.pi[CharInfo[0][0][0]].dy - 12 + value21 + this.dyHead, 0, 17);
                                }
                                if (dataSkillEff12 != null) {
                                    this.paintBody(g, this.cx, this.cy - 8, 2);
                                } else {
                                    SmallImage.drawSmallImage(g, this.getBodyPaintId(), this.cx + this.dxBody * this.cdir, this.cy - SmallImage.getHeight(this.getLegId()) - 8 + value21 + this.dyBody, 0, 33);
                                }
                                this.paintMatna(g, this.cx, this.cy - 8, 2);
                            } else {
                                if (this.statusMe == 3) {
                                    SmallImage.drawSmallImage(g, 2066, this.cx, this.cy + 2, 2, 33);
                                } else {
                                    SmallImage.drawSmallImage(g, value21 == 0 ? 2064 : 2065, this.cx, this.cy, 2, 33);
                                }
                                if (dataSkillEff14 != null) {
                                    this.paintHair(g, this.cx, this.cy - 8, 2);
                                } else {
                                    SmallImage.drawSmallImage(g, this.getHeadId(), this.cx + value22 + this.dxHead * this.cdir, this.cy - CharInfo[0][0][2] + part.pi[CharInfo[0][0][0]].dy - 12 + value21 + this.dyHead, 2, 17);
                                }
                                if (dataSkillEff12 != null) {
                                    this.paintBody(g, this.cx, this.cy - 8, 2);
                                } else {
                                    SmallImage.drawSmallImage(g, this.getBodyPaintId(), this.cx + this.dxBody * this.cdir, this.cy - SmallImage.getHeight(this.getLegId()) - 8 + value21 + this.dyBody, 2, 33);
                                }
                                this.paintMatna(g, this.cx, this.cy - 8, 2);
                            }
                        } else if (this.arrItemMounts[4].sys >= 2 && this.arrItemMounts[4].sys < 4) {
                            int[] values28;
                            if ((values28 = this.getEffmoto()) != null) {
                                this.tickEffmoto++;
                                if (this.tickEffmoto >= values28.length) {
                                    this.tickEffmoto = 0;
                                }
                            }
                            label1573: {
                                int value29;
                                if (this.statusMe != 1 && this.statusMe != 6) {
                                    if (this.statusMe != 2 && this.statusMe != 10) {
                                        break label1573;
                                    }
                                    value29 = GameCanvas.gameTick % 6 > 3 ? 1 : 0;
                                } else {
                                    value21 = GameCanvas.gameTick % 20 > 12 ? 1 : 0;
                                    if (dataSkillEff16 == null && dataSkillEff12 == null && dataSkillEff14 == null && dataSkillEff == null && dataSkillEff3 == null || this.cf > 1) {
                                        break label1573;
                                    }
                                    value29 = this.cf;
                                }
                                value21 = value29;
                            }
                            if (this.statusMe == 3) {
                                value22 = -5 * this.cdir;
                            }
                            if (this.cdir == 1) {
                                if (this.statusMe == 3) {
                                    SmallImage.drawSmallImage(g, 2070, this.cx, this.cy + 2, 0, 33);
                                } else if (this.statusMe == 4) {
                                    SmallImage.drawSmallImage(g, value21 == 0 ? 2068 : 2069, this.cx, this.cy, 0, 33);
                                } else if (this.statusMe == 2 || this.statusMe == 10) {
                                    SmallImage.drawSmallImage(g, value21 == 0 ? 2068 : 2069, this.cx, this.cy, 0, 33);
                                } else if (this.statusMe == 1 || this.statusMe == 6) {
                                    SmallImage.drawSmallImage(g, value21 == 0 ? 2068 : 2069, this.cx, this.cy, 0, 33);
                                }
                                if (dataSkillEff14 != null) {
                                    this.paintHair(g, this.cx, this.cy - 8, 2);
                                } else {
                                    SmallImage.drawSmallImage(g, this.getHeadId(), this.cx + value22 + this.dxHead * this.cdir, this.cy - CharInfo[0][0][2] + part.pi[CharInfo[0][0][0]].dy - 12 + value21 + this.dyHead, 0, 17);
                                }
                                if (dataSkillEff12 != null) {
                                    this.paintBody(g, this.cx, this.cy - 8, 2);
                                } else {
                                    SmallImage.drawSmallImage(g, this.getBodyPaintId(), this.cx + this.dxBody * this.cdir, this.cy - SmallImage.getHeight(this.getLegId()) - 8 + value21 + this.dyBody, 0, 33);
                                }
                                this.paintMatna(g, this.cx, this.cy - 8, 2);
                            } else {
                                if (this.statusMe == 3) {
                                    SmallImage.drawSmallImage(g, 2070, this.cx, this.cy + 2, 2, 33);
                                }
                                if (this.statusMe == 4) {
                                    SmallImage.drawSmallImage(g, value21 == 0 ? 2068 : 2069, this.cx, this.cy, 2, 33);
                                } else if (this.statusMe == 2 || this.statusMe == 10) {
                                    SmallImage.drawSmallImage(g, value21 == 0 ? 2068 : 2069, this.cx, this.cy, 2, 33);
                                } else if (this.statusMe == 1 || this.statusMe == 6) {
                                    SmallImage.drawSmallImage(g, value21 == 0 ? 2068 : 2069, this.cx, this.cy, 2, 33);
                                }
                                if (dataSkillEff14 != null) {
                                    this.paintHair(g, this.cx, this.cy - 8, 2);
                                } else {
                                    SmallImage.drawSmallImage(g, this.getHeadId(), this.cx + value22 + this.dxHead * this.cdir, this.cy - CharInfo[0][0][2] + part.pi[CharInfo[0][0][0]].dy - 12 + value21 + this.dyHead, 2, 17);
                                }
                                if (dataSkillEff12 != null) {
                                    this.paintBody(g, this.cx, this.cy - 8, 2);
                                } else {
                                    SmallImage.drawSmallImage(g, this.getBodyPaintId(), this.cx + this.dxBody * this.cdir, this.cy - SmallImage.getHeight(this.getLegId()) - 8 + value21 + this.dyBody, 2, 33);
                                }
                                this.paintMatna(g, this.cx, this.cy - 8, 2);
                            }
                        } else {
                            int[] values30;
                            if ((values30 = this.getEffmoto()) != null) {
                                this.tickEffmoto++;
                                if (this.tickEffmoto >= values30.length) {
                                    this.tickEffmoto = 0;
                                }
                            }
                            label1574: {
                                int value31;
                                if (this.statusMe != 1 && this.statusMe != 6) {
                                    if (this.statusMe != 2 && this.statusMe != 10) {
                                        break label1574;
                                    }
                                    value31 = GameCanvas.gameTick % 6 > 3 ? 1 : 0;
                                } else {
                                    value21 = GameCanvas.gameTick % 20 > 12 ? 1 : 0;
                                    if (dataSkillEff16 == null && dataSkillEff12 == null && dataSkillEff14 == null && dataSkillEff == null && dataSkillEff3 == null || this.cf > 1) {
                                        break label1574;
                                    }
                                    value31 = this.cf;
                                }
                                value21 = value31;
                            }
                            if (this.statusMe == 3) {
                                value22 = -5 * this.cdir;
                            }
                            if (this.cdir == 1) {
                                if (this.statusMe == 3) {
                                    SmallImage.drawSmallImage(g, 2070, this.cx, this.cy + 2, 0, 33);
                                    SmallImage.drawSmallImage(g, values30[this.tickEffmoto], this.cx + 13, this.cy - 17, 0, 33);
                                    SmallImage.drawSmallImage(g, values30[this.tickEffmoto], this.cx - 24, this.cy + 2, 0, 33);
                                } else if (this.statusMe == 4) {
                                    SmallImage.drawSmallImage(g, value21 == 0 ? 2068 : 2069, this.cx, this.cy, 0, 33);
                                    SmallImage.drawSmallImage(g, values30[this.tickEffmoto], this.cx + 15, this.cy, 0, 33);
                                    SmallImage.drawSmallImage(g, values30[this.tickEffmoto], this.cx - 27, this.cy, 0, 33);
                                } else if (this.statusMe == 2 || this.statusMe == 10) {
                                    SmallImage.drawSmallImage(g, value21 == 0 ? 2068 : 2069, this.cx, this.cy, 0, 33);
                                    SmallImage.drawSmallImage(g, values30[this.tickEffmoto], this.cx + 15, this.cy, 0, 33);
                                    SmallImage.drawSmallImage(g, values30[this.tickEffmoto], this.cx - 27, this.cy, 0, 33);
                                } else if (this.statusMe == 1 || this.statusMe == 6) {
                                    SmallImage.drawSmallImage(g, value21 == 0 ? 2068 : 2069, this.cx, this.cy, 0, 33);
                                    SmallImage.drawSmallImage(g, values30[this.tickEffmoto], this.cx + 15, this.cy, 0, 33);
                                    SmallImage.drawSmallImage(g, values30[this.tickEffmoto], this.cx - 27, this.cy, 0, 33);
                                }
                                if (dataSkillEff14 != null) {
                                    this.paintHair(g, this.cx, this.cy - 8, 2);
                                } else {
                                    SmallImage.drawSmallImage(g, this.getHeadId(), this.cx + value22 + this.dxHead * this.cdir, this.cy - CharInfo[0][0][2] + part.pi[CharInfo[0][0][0]].dy - 12 + value21 + this.dyHead, 0, 17);
                                }
                                if (dataSkillEff12 != null) {
                                    this.paintBody(g, this.cx, this.cy - 8, 2);
                                } else {
                                    SmallImage.drawSmallImage(g, this.getBodyPaintId(), this.cx + this.dxBody * this.cdir, this.cy - SmallImage.getHeight(this.getLegId()) - 8 + value21 + this.dyBody, 0, 33);
                                }
                                this.paintMatna(g, this.cx, this.cy - 8, 2);
                            } else {
                                if (this.statusMe == 3) {
                                    SmallImage.drawSmallImage(g, 2070, this.cx, this.cy + 2, 2, 33);
                                    SmallImage.drawSmallImage(g, values30[this.tickEffmoto], this.cx - 12, this.cy - 17, 2, 33);
                                    SmallImage.drawSmallImage(g, values30[this.tickEffmoto], this.cx + 25, this.cy + 3, 2, 33);
                                }
                                if (this.statusMe == 4) {
                                    SmallImage.drawSmallImage(g, value21 == 0 ? 2068 : 2069, this.cx, this.cy, 2, 33);
                                    SmallImage.drawSmallImage(g, values30[this.tickEffmoto], this.cx - 15, this.cy, 2, 33);
                                    SmallImage.drawSmallImage(g, values30[this.tickEffmoto], this.cx + 27, this.cy, 2, 33);
                                } else if (this.statusMe == 2 || this.statusMe == 10) {
                                    SmallImage.drawSmallImage(g, value21 == 0 ? 2068 : 2069, this.cx, this.cy, 2, 33);
                                    SmallImage.drawSmallImage(g, values30[this.tickEffmoto], this.cx - 15, this.cy, 2, 33);
                                    SmallImage.drawSmallImage(g, values30[this.tickEffmoto], this.cx + 27, this.cy, 2, 33);
                                } else if (this.statusMe == 1 || this.statusMe == 6) {
                                    SmallImage.drawSmallImage(g, value21 == 0 ? 2068 : 2069, this.cx, this.cy, 2, 33);
                                    SmallImage.drawSmallImage(g, values30[this.tickEffmoto], this.cx - 15, this.cy, 2, 33);
                                    SmallImage.drawSmallImage(g, values30[this.tickEffmoto], this.cx + 27, this.cy, 2, 33);
                                }
                                if (dataSkillEff14 != null) {
                                    this.paintHair(g, this.cx, this.cy - 8, 2);
                                } else {
                                    SmallImage.drawSmallImage(g, this.getHeadId(), this.cx + value22 + this.dxHead * this.cdir, this.cy - CharInfo[0][0][2] + part.pi[CharInfo[0][0][0]].dy - 12 + value21 + this.dyHead, 2, 17);
                                }
                                if (dataSkillEff12 != null) {
                                    this.paintBody(g, this.cx, this.cy - 8, 2);
                                } else {
                                    SmallImage.drawSmallImage(g, this.getBodyPaintId(), this.cx + this.dxBody * this.cdir, this.cy - SmallImage.getHeight(this.getLegId()) - 8 + value21 + this.dyBody, 2, 33);
                                }
                                this.paintMatna(g, this.cx, this.cy - 8, 2);
                            }
                        }
                    }
                } else if (this.isWolf) {
                    int[] values32;
                    if ((values32 = this.getEffwolf()) != null) {
                        this.tickEffFireW++;
                        if (this.tickEffFireW >= values32.length) {
                            this.tickEffFireW = 0;
                        }
                    }
                    if (this.statusMe == 1 || this.statusMe == 6) {
                        this.tickWolf = GameCanvas.gameTick % 20 > 12 ? 1 : 0;
                        if ((dataSkillEff16 != null || dataSkillEff12 != null || dataSkillEff14 != null || dataSkillEff != null || dataSkillEff3 != null) && this.cf <= 1) {
                            this.tickWolf = this.cf;
                        }
                        this.dy = -this.tickWolf;
                    } else if (this.statusMe == 2 || this.statusMe == 10) {
                        if (GameCanvas.gameTick % 12 <= 3) {
                            this.tickWolf = 0;
                        } else if (GameCanvas.gameTick % 12 <= 6) {
                            this.tickWolf = 1;
                            this.dy = 2;
                        } else if (GameCanvas.gameTick % 12 <= 9) {
                            this.tickWolf = 2;
                            this.dy = 4;
                        } else {
                            this.tickWolf = 3;
                            this.dy = 2;
                        }
                    }
                    int[] values33 = new int[] { 2050, 2053, 2049, 2052 };
                    int[] values34 = new int[] { 2075, 2078, 2074, 2079 };
                    values = new int[] { this.cy - 22, this.cy - 23, this.cy - 22, this.cy - 23 };
                    int[] values35 = new int[] { this.cy - 22, this.cy - 23, this.cy - 22, this.cy - 22 };
                    if (this.statusMe == 3) {
                        this.hdx = -5 * this.cdir;
                        this.hdy = 0;
                    } else {
                        this.hdx = -3 * this.cdir;
                        this.hdy = 0;
                    }
                    if (this.arrItemMounts[4].template.id == 523) {
                        if (this.cdir == 1) {
                            if (part20 != null) {
                                SmallImage.drawSmallImage(g, part20.pi[CharInfo[this.cf][3][0]].id, this.cx + CharInfo[this.cf][3][1] + part20.pi[CharInfo[this.cf][3][0]].dx, this.cy - CharInfo[this.cf][3][2] + part20.pi[CharInfo[this.cf][3][0]].dy - 10, 0, 0);
                            }
                            if (this.statusMe == 3) {
                                SmallImage.drawSmallImage(g, 2051, this.cx, this.cy, 0, 33);
                            } else if (this.statusMe == 4) {
                                SmallImage.drawSmallImage(g, 2052, this.cx, this.cy, 0, 33);
                            } else if (this.statusMe == 1 || this.statusMe == 6) {
                                SmallImage.drawSmallImage(g, this.tickWolf == 0 ? 2047 : 2048, this.cx, this.cy, 0, 33);
                            } else if (this.statusMe == 2 || this.statusMe == 10) {
                                SmallImage.drawSmallImage(g, values33[this.tickWolf], this.cx, this.cy - this.dy, 0, 33);
                            }
                            byte byteValue = 2;
                            if (this.cdir == 1) {
                                byteValue = -2;
                            }
                            if (dataSkillEff14 != null) {
                                this.paintHair(g, this.cx + byteValue, this.cy - 15, 2);
                            } else {
                                SmallImage.drawSmallImage(g, this.getHeadId(), this.cx + this.hdx + this.dxHead * this.cdir, this.cy - CharInfo[0][0][2] + part.pi[CharInfo[0][0][0]].dy - 12 - this.dy + this.dyHead, 0, 17);
                            }
                            if (dataSkillEff12 != null) {
                                this.paintBody(g, this.cx + byteValue, this.cy - 15, 2);
                            } else {
                                SmallImage.drawSmallImage(g, this.getBodyPaintId(), this.cx + this.hdx + this.dxBody * this.cdir, this.cy - SmallImage.getHeight(this.getLegId()) - 9 - this.dy + this.dyBody, 0, 33);
                            }
                            this.paintMatna(g, this.cx + byteValue, this.cy - 15, 2);
                        } else {
                            if (part20 != null) {
                                SmallImage.drawSmallImage(g, part20.pi[CharInfo[this.cf][3][0]].id, this.cx - CharInfo[this.cf][3][1] - part20.pi[CharInfo[this.cf][3][0]].dx, this.cy - CharInfo[this.cf][3][2] + part20.pi[CharInfo[this.cf][3][0]].dy - 10, 2, 24);
                            }
                            if (this.statusMe == 3) {
                                SmallImage.drawSmallImage(g, 2051, this.cx, this.cy, 2, 33);
                            } else if (this.statusMe == 4) {
                                SmallImage.drawSmallImage(g, 2052, this.cx, this.cy, 2, 33);
                            } else if (this.statusMe == 1 || this.statusMe == 6) {
                                SmallImage.drawSmallImage(g, this.tickWolf == 0 ? 2047 : 2048, this.cx, this.cy, 2, 33);
                            } else if (this.statusMe == 2 || this.statusMe == 10) {
                                SmallImage.drawSmallImage(g, values33[this.tickWolf], this.cx, this.cy - this.dy, 2, 33);
                            }
                            byte byteValue36 = 2;
                            if (this.cdir == 1) {
                                byteValue36 = -2;
                            }
                            if (dataSkillEff14 != null) {
                                this.paintHair(g, this.cx + byteValue36, this.cy - 15, 2);
                            } else {
                                SmallImage.drawSmallImage(g, this.getHeadId(), this.cx + this.hdx + this.dxHead * this.cdir, this.cy - CharInfo[0][0][2] + part.pi[CharInfo[0][0][0]].dy - 12 - this.dy + this.dyHead, 2, 17);
                            }
                            if (dataSkillEff12 != null) {
                                this.paintBody(g, this.cx + byteValue36, this.cy - 15, 2);
                            } else {
                                SmallImage.drawSmallImage(g, this.getBodyPaintId(), this.cx + this.hdx + this.dxBody * this.cdir, this.cy - SmallImage.getHeight(this.getLegId()) - 9 - this.dy + this.dyBody, 2, 33);
                            }
                            this.paintMatna(g, this.cx + byteValue36, this.cy - 15, 2);
                        }
                    } else if (this.arrItemMounts[4].template.id == 443) {
                        if (this.arrItemMounts[4].sys >= 3) {
                            if (this.cdir == 1) {
                                if (part20 != null) {
                                    SmallImage.drawSmallImage(g, part20.pi[CharInfo[this.cf][3][0]].id, this.cx + CharInfo[this.cf][3][1] + part20.pi[CharInfo[this.cf][3][0]].dx, this.cy - CharInfo[this.cf][3][2] + part20.pi[CharInfo[this.cf][3][0]].dy - 10, 0, 0);
                                }
                                if (this.statusMe == 3) {
                                    SmallImage.drawSmallImage(g, 2077, this.cx, this.cy, 0, 33);
                                    g.drawRegion(GameScr.imgMatcho, 0, this.tickEffWolf * 3, 3, 3, 0, this.cx + 21, this.cy - 30, 0);
                                } else if (this.statusMe == 4) {
                                    SmallImage.drawSmallImage(g, 2076, this.cx, this.cy, 0, 33);
                                    g.drawRegion(GameScr.imgMatcho, 0, this.tickEffWolf * 3, 3, 3, 0, this.cx + 21, this.cy - 19, 0);
                                } else if (this.statusMe == 1 || this.statusMe == 6) {
                                    SmallImage.drawSmallImage(g, this.tickWolf == 0 ? 2073 : 2072, this.cx, this.cy, 0, 33);
                                    g.drawRegion(GameScr.imgMatcho, 0, this.tickEffWolf * 3, 3, 3, 0, this.cx + 21, this.cy - 19, 0);
                                } else if (this.statusMe == 2 || this.statusMe == 10) {
                                    SmallImage.drawSmallImage(g, values34[this.tickWolf], this.cx, this.cy - this.dy, 0, 33);
                                    g.drawRegion(GameScr.imgMatcho, 0, this.tickEffWolf * 3, 3, 3, 0, this.cx + 21, values[this.tickWolf], 0);
                                }
                                byte byteValue37 = 2;
                                if (this.cdir == 1) {
                                    byteValue37 = -2;
                                }
                                if (dataSkillEff14 != null) {
                                    this.paintHair(g, this.cx + byteValue37, this.cy - 15, 2);
                                } else {
                                    SmallImage.drawSmallImage(g, this.getHeadId(), this.cx + this.hdx + this.dxHead * this.cdir, this.cy - CharInfo[0][0][2] + part.pi[CharInfo[0][0][0]].dy - 12 - this.dy + this.dyHead, 0, 17);
                                }
                                if (dataSkillEff12 != null) {
                                    this.paintBody(g, this.cx + byteValue37, this.cy - 15, 2);
                                } else {
                                    SmallImage.drawSmallImage(g, this.getBodyPaintId(), this.cx + this.hdx + this.dxBody * this.cdir, this.cy - SmallImage.getHeight(this.getLegId()) - 9 - this.dy + this.dyBody, 0, 33);
                                }
                                this.paintMatna(g, this.cx + byteValue37, this.cy - 15, 2);
                            } else {
                                if (part20 != null) {
                                    SmallImage.drawSmallImage(g, part20.pi[CharInfo[this.cf][3][0]].id, this.cx - CharInfo[this.cf][3][1] - part20.pi[CharInfo[this.cf][3][0]].dx, this.cy - CharInfo[this.cf][3][2] + part20.pi[CharInfo[this.cf][3][0]].dy - 10, 2, 24);
                                }
                                if (this.statusMe == 3) {
                                    SmallImage.drawSmallImage(g, 2077, this.cx, this.cy, 2, 33);
                                    g.drawRegion(GameScr.imgMatcho, 0, this.tickEffWolf * 3, 3, 3, 0, this.cx - 23, this.cy - 30, 0);
                                } else if (this.statusMe == 4) {
                                    SmallImage.drawSmallImage(g, 2076, this.cx, this.cy, 2, 33);
                                    g.drawRegion(GameScr.imgMatcho, 0, this.tickEffWolf * 3, 3, 3, 0, this.cx - 24, this.cy - 20, 0);
                                } else if (this.statusMe == 1 || this.statusMe == 6) {
                                    SmallImage.drawSmallImage(g, this.tickWolf == 0 ? 2073 : 2072, this.cx, this.cy, 2, 33);
                                    g.drawRegion(GameScr.imgMatcho, 0, this.tickEffWolf * 3, 3, 3, 0, this.cx - 24, this.cy - 20, 0);
                                } else if (this.statusMe == 2 || this.statusMe == 10) {
                                    SmallImage.drawSmallImage(g, values34[this.tickWolf], this.cx, this.cy - this.dy, 2, 33);
                                    g.drawRegion(GameScr.imgMatcho, 0, this.tickEffWolf * 3, 3, 3, 0, this.cx - 24, values35[this.tickWolf], 0);
                                }
                                byte byteValue38 = 2;
                                if (this.cdir == 1) {
                                    byteValue38 = -2;
                                }
                                if (dataSkillEff14 != null) {
                                    this.paintHair(g, this.cx + byteValue38, this.cy - 15, 2);
                                } else {
                                    SmallImage.drawSmallImage(g, this.getHeadId(), this.cx + this.hdx + this.dxHead * this.cdir, this.cy - CharInfo[0][0][2] + part.pi[CharInfo[0][0][0]].dy - 12 - this.dy + this.dyHead, 2, 17);
                                }
                                if (dataSkillEff12 != null) {
                                    this.paintBody(g, this.cx + byteValue38, this.cy - 15, 2);
                                } else {
                                    SmallImage.drawSmallImage(g, this.getBodyPaintId(), this.cx + this.hdx + this.dxBody * this.cdir, this.cy - SmallImage.getHeight(this.getLegId()) - 9 - this.dy + this.dyBody, 2, 33);
                                }
                                this.paintMatna(g, this.cx + byteValue38, this.cy - 15, 2);
                            }
                        } else if (this.cdir == 1) {
                            if (part20 != null) {
                                SmallImage.drawSmallImage(g, part20.pi[CharInfo[this.cf][3][0]].id, this.cx + CharInfo[this.cf][3][1] + part20.pi[CharInfo[this.cf][3][0]].dx, this.cy - CharInfo[this.cf][3][2] + part20.pi[CharInfo[this.cf][3][0]].dy - 10, 0, 0);
                            }
                            if (this.statusMe == 3) {
                                SmallImage.drawSmallImage(g, 1716, this.cx, this.cy, 0, 33);
                            } else if (this.statusMe == 4) {
                                SmallImage.drawSmallImage(g, 1717, this.cx, this.cy, 0, 33);
                            } else if (this.statusMe == 1 || this.statusMe == 6) {
                                SmallImage.drawSmallImage(g, this.tickWolf == 0 ? 1712 : 1713, this.cx, this.cy, 0, 33);
                            } else if (this.statusMe == 2 || this.statusMe == 10) {
                                SmallImage.drawSmallImage(g, this.idWolfW[this.tickWolf], this.cx, this.cy - this.dy, 0, 33);
                            }
                            byte byteValue39 = 2;
                            if (this.cdir == 1) {
                                byteValue39 = -2;
                            }
                            if (dataSkillEff14 != null) {
                                this.paintHair(g, this.cx + byteValue39, this.cy - 14, 2);
                            } else {
                                SmallImage.drawSmallImage(g, this.getHeadId(), this.cx + this.hdx + this.dxHead * this.cdir, this.cy - CharInfo[0][0][2] + part.pi[CharInfo[0][0][0]].dy - 12 - this.dy + this.dyHead, 0, 17);
                            }
                            if (dataSkillEff12 != null) {
                                this.paintBody(g, this.cx + byteValue39, this.cy - 14, 2);
                            } else {
                                SmallImage.drawSmallImage(g, this.getBodyPaintId(), this.cx + this.hdx + this.dxBody * this.cdir, this.cy - SmallImage.getHeight(this.getLegId()) - 9 - this.dy + this.dyBody, 0, 33);
                            }
                            this.paintMatna(g, this.cx + byteValue39, this.cy - 14, 2);
                        } else {
                            if (part20 != null) {
                                SmallImage.drawSmallImage(g, part20.pi[CharInfo[this.cf][3][0]].id, this.cx - CharInfo[this.cf][3][1] - part20.pi[CharInfo[this.cf][3][0]].dx, this.cy - CharInfo[this.cf][3][2] + part20.pi[CharInfo[this.cf][3][0]].dy - 10, 2, 24);
                            }
                            if (this.statusMe == 3) {
                                SmallImage.drawSmallImage(g, 1716, this.cx, this.cy, 2, 33);
                            } else if (this.statusMe == 4) {
                                SmallImage.drawSmallImage(g, 1717, this.cx, this.cy, 2, 33);
                            } else if (this.statusMe == 1 || this.statusMe == 6) {
                                SmallImage.drawSmallImage(g, this.tickWolf == 0 ? 1712 : 1713, this.cx, this.cy, 2, 33);
                            } else if (this.statusMe == 2 || this.statusMe == 10) {
                                SmallImage.drawSmallImage(g, this.idWolfW[this.tickWolf], this.cx, this.cy - this.dy, 2, 33);
                            }
                            byte byteValue40 = 2;
                            if (this.cdir == 1) {
                                byteValue40 = -2;
                            }
                            if (dataSkillEff14 != null) {
                                this.paintHair(g, this.cx - byteValue40, this.cy - 14, 2);
                            } else {
                                SmallImage.drawSmallImage(g, this.getHeadId(), this.cx + this.hdx + this.dxHead * this.cdir, this.cy - CharInfo[0][0][2] + part.pi[CharInfo[0][0][0]].dy - 12 - this.dy + this.dyHead, 2, 17);
                            }
                            if (dataSkillEff12 != null) {
                                this.paintBody(g, this.cx + byteValue40, this.cy - 14, 2);
                            } else {
                                SmallImage.drawSmallImage(g, this.getBodyPaintId(), this.cx + this.hdx + this.dxBody * this.cdir, this.cy - SmallImage.getHeight(this.getLegId()) - 9 - this.dy + this.dyBody, 2, 33);
                            }
                            this.paintMatna(g, this.cx + byteValue40, this.cy - 14, 2);
                        }
                    }
                } else {
                    byte byteValue41 = 2;
                    byte byteValue42 = 24;
                    if (this.cdir == 1) {
                        byteValue41 = 0;
                        byteValue42 = 0;
                    }
                    if (this.isNewMount) {
                        this.paintNewMount(g, part20, part, values);
                        if (dataSkillEff5 != null) {
                            dataSkillEff5.paintTopEff_new(g, this.cx, this.cy - this.getDyHorse(), this.FrameSusan, this.cdir == 1 ? 0 : 2);
                        }
                        this.paintPP_Top(g);
                        if (dataSkillEff7 != null) {
                            dataSkillEff7.paintTopEff_new(g, this.cx, this.cy - this.getDyHorse(), this.FrameName, 0);
                        }
                        if (dataSkillEff6 != null) {
                            dataSkillEff6.paintTopEff_new(g, this.cx, this.cy - this.getDyHorse(), this.FrameRank, this.cdir == 1 ? 0 : 2);
                        }
                        if (dataSkillEff != null) {
                            this.paintWeaponTop(g, this.cx, this.cy, 2, dataSkillEff);
                        }
                        return;
                    }
                    if (this.isMotoBehind) {
                        if (this.isHaveNewMount()) {
                            this.paintBehindNewMount(g);
                        } else if (!this.isMoto && !this.isWolf) {
                            if (this.arrItemMounts[4].template.id == 485) {
                                if (this.arrItemMounts[4].sys <= 1) {
                                    SmallImage.drawSmallImage(g, 1800, this.lcx, this.lcy, 2, 33);
                                } else {
                                    SmallImage.drawSmallImage(g, 2063, this.lcx, this.lcy, 2, 33);
                                }
                            } else if (this.arrItemMounts[4].template.id == 524) {
                                if (this.arrItemMounts[4].sys <= 1) {
                                    SmallImage.drawSmallImage(g, 2067, this.lcx, this.lcy, 2, 33);
                                } else {
                                    SmallImage.drawSmallImage(g, 2071, this.lcx, this.lcy, 2, 33);
                                }
                            }
                        }
                    }
                    if (values != null && dataSkillEff16 == null) {
                        SmallImage.drawSmallImage(g, values[this.tickCoat], this.cx + this.dxnewhorse - 7 * this.cdir, this.cy - this.dynewhhorse - 18, byteValue41, 17);
                    }
                    if (part20 != null) {
                        SmallImage.drawSmallImage(g, part20.pi[CharInfo[this.cf][3][0]].id, this.cx + this.dxnewhorse + (CharInfo[this.cf][3][1] + part20.pi[CharInfo[this.cf][3][0]].dx) * this.cdir, this.cy - this.dynewhhorse - CharInfo[this.cf][3][2] + part20.pi[CharInfo[this.cf][3][0]].dy, byteValue41, byteValue42);
                    }
                    if (dataSkillEff10 == null) {
                        if (dataSkillEff8 != null) {
                            dataSkillEff8.paintBottomEff_new(g, this.cx, this.cy, this.getFrameLeg(), this.cdir == 1 ? 0 : 2);
                            dataSkillEff8.paintTopEff_new(g, this.cx, this.cy, this.getFrameLeg(), this.cdir == 1 ? 0 : 2);
                        } else {
                            SmallImage.drawSmallImage(g, part18.pi[CharInfo[this.cf][1][0]].id, this.cx + (CharInfo[this.cf][1][1] + part18.pi[CharInfo[this.cf][1][0]].dx) * this.cdir, this.cy - CharInfo[this.cf][1][2] + part18.pi[CharInfo[this.cf][1][0]].dy, byteValue41, byteValue42);
                        }
                    }
                    if (this.statusMe != 2) {
                        this.paintClanEffect(g, this.cx + 7 * this.cdir, this.cy - 2 - this.getDyHorse());
                    }
                    if (this.statusMe != 1 && this.statusMe != 6) {
                        if (dataSkillEff14 != null) {
                            dataSkillEff14.paintBottomEff_new(g, this.cx + this.dxnewhorse, this.cy - this.dynewhhorse, this.getFrameHair(), this.cdir == 1 ? 0 : 2);
                            dataSkillEff14.paintTopEff_new(g, this.cx + this.dxnewhorse, this.cy - this.dynewhhorse, this.getFrameHair(), this.cdir == 1 ? 0 : 2);
                        } else {
                            SmallImage.drawSmallImage(g, part.pi[CharInfo[this.cf][0][0]].id, this.cx + this.dxnewhorse + (CharInfo[this.cf][0][1] + part.pi[CharInfo[this.cf][0][0]].dx) * this.cdir, this.cy - this.dynewhhorse - CharInfo[this.cf][0][2] + part.pi[CharInfo[this.cf][0][0]].dy, byteValue41, byteValue42);
                        }
                    }
                    if (dataSkillEff12 != null) {
                        dataSkillEff12.paintBottomEff_new(g, this.cx + this.dxnewhorse, this.cy - this.dynewhhorse, this.getFrameBody(), this.cdir == 1 ? 0 : 2);
                        dataSkillEff12.paintTopEff_new(g, this.cx + this.dxnewhorse, this.cy - this.dynewhhorse, this.getFrameBody(), this.cdir == 1 ? 0 : 2);
                    } else {
                        SmallImage.drawSmallImage(g, part19.pi[CharInfo[this.cf][2][0]].id, this.cx + this.dxnewhorse + (CharInfo[this.cf][2][1] + part19.pi[CharInfo[this.cf][2][0]].dx) * this.cdir, this.cy - CharInfo[this.cf][2][2] + part19.pi[CharInfo[this.cf][2][0]].dy - this.dynewhhorse, byteValue41, byteValue42);
                    }
                    if (this.statusMe == 1 || this.statusMe == 6) {
                        if (dataSkillEff14 != null) {
                            dataSkillEff14.paintBottomEff_new(g, this.cx + this.dxnewhorse, this.cy - this.dynewhhorse, this.getFrameHair(), this.cdir == 1 ? 0 : 2);
                            dataSkillEff14.paintTopEff_new(g, this.cx + this.dxnewhorse, this.cy - this.dynewhhorse, this.getFrameHair(), this.cdir == 1 ? 0 : 2);
                        } else {
                            SmallImage.drawSmallImage(g, part.pi[CharInfo[this.cf][0][0]].id, this.cx + this.dxnewhorse + (CharInfo[this.cf][0][1] + part.pi[CharInfo[this.cf][0][0]].dx) * this.cdir, this.cy - this.dynewhhorse - CharInfo[this.cf][0][2] + part.pi[CharInfo[this.cf][0][0]].dy, byteValue41, byteValue42);
                        }
                    }
                    if (dataSkillEff3 != null) {
                        dataSkillEff3.paintBottomEff_new(g, this.cx + this.dxnewhorse, this.cy - this.dynewhhorse, this.getFrameMatna(), this.cdir == 1 ? 0 : 2);
                        dataSkillEff3.paintTopEff_new(g, this.cx + this.dxnewhorse, this.cy - this.dynewhhorse, this.getFrameMatna(), this.cdir == 1 ? 0 : 2);
                    }
                    if (this.statusMe == 2) {
                        this.paintClanEffectRun(g, this.cx - 14 * this.cdir, this.cy - 2 - this.getDyHorse());
                        this.paintClanEffect2(g, this.cx + 7 * this.cdir, this.cy - 2 - this.getDyHorse());
                    } else {
                        this.paintClanEffect(g, this.cx - 7 * this.cdir, this.cy - 2 - this.getDyHorse());
                        this.paintClanEffect2(g, this.cx + 11 * this.cdir, this.cy - 2 - this.getDyHorse());
                    }
                }
                if (dataSkillEff10 != null) {
                    dataSkillEff10.paintTopEff_new(g, this.cx, this.cy, this.getFrameHores(), this.cdir == 1 ? 2 : 0);
                }
                if (dataSkillEff5 != null) {
                    dataSkillEff5.paintTopEff_new(g, this.cx, this.cy - this.getDyHorse(), this.FrameSusan, this.cdir == 1 ? 0 : 2);
                }
                this.paintPP_Top(g);
                if (dataSkillEff7 != null) {
                    dataSkillEff7.paintTopEff_new(g, this.cx, this.cy - this.getDyHorse(), this.FrameName, 0);
                }
                if (dataSkillEff6 != null) {
                    dataSkillEff6.paintTopEff_new(g, this.cx, this.cy - this.getDyHorse(), this.FrameRank, this.cdir == 1 ? 0 : 2);
                }
                if (dataSkillEff != null) {
                    this.paintWeaponTop(g, this.cx, this.cy, 2, dataSkillEff);
                }
            }
            if (this.isLockAttack) {
                SmallImage.drawSmallImage(g, 290, this.cx, this.cy, 0, 33);
                return;
            }
        } catch (Exception exception) {
        }
    }

    private int getLegId() {
        CharPartInfo charPartInfo;
        if ((charPartInfo = (CharPartInfo) CharPartInfo.head_jump.get(String.valueOf(this.leg))) != null) {
            return charPartInfo.idSmall;
        }
        switch(this.leg) {
            case 0:
                return 26;
            case 4:
                return 58;
            case 6:
                return 86;
            case 8:
                return 114;
            case 9:
                return 123;
            case 17:
                return 353;
            case 19:
                return 379;
            case 21:
                return 405;
            case 30:
                return 484;
            case 33:
                return 518;
            case 35:
                return 544;
            case 37:
                return 571;
            case 39:
                return 810;
            case 43:
                return 982;
            case 95:
                return 1156;
            case 142:
                return 1360;
            case 155:
                return 1494;
            case 157:
                return 1519;
            default:
                return 26;
        }
    }

    private int getBodyPaintId() {
        this.dxBody = 0;
        this.dyBody = 0;
        Object argument = null;
        Part part = GameScr.parts[this.body];
        if (this.statusMe == 3) {
            CharPartInfo charPartInfo;
            if ((argument = (CharPartInfo) CharPartInfo.body_jump.get(String.valueOf(this.body))) != null && (charPartInfo = (CharPartInfo) ((CharPartInfo) argument).item.get(String.valueOf(this.arrItemMounts[4].template.id))) != null) {
                this.dxBody = charPartInfo.dx;
                this.dyBody = charPartInfo.dy;
                return part != null ? part.pi[this.frameFix].id : ((CharPartInfo) argument).idSmall;
            }
            switch(this.body) {
                case 1:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -8;
                        this.dyBody = -6;
                    }
                    return 13;
                case 3:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -8;
                        this.dyBody = -6;
                    }
                    return 45;
                case 5:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -9;
                        this.dyBody = -7;
                    }
                    return 73;
                case 7:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -9;
                        this.dyBody = -7;
                    }
                    return 101;
                case 10:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -9;
                        this.dyBody = -7;
                    }
                    return 137;
                case 18:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -9;
                        this.dyBody = -7;
                    }
                    return 365;
                case 20:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -9;
                        this.dyBody = -7;
                    }
                    return 391;
                case 22:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -9;
                        this.dyBody = -7;
                    }
                    return 417;
                case 29:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 1;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 1;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -11;
                        this.dyBody = -6;
                    }
                    return 472;
                case 32:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 1;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 1;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -11;
                        this.dyBody = -6;
                    }
                    return 506;
                case 34:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -8;
                        this.dyBody = -7;
                    }
                    return 531;
                case 36:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -8;
                        this.dyBody = -7;
                    }
                    return 559;
                case 38:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -8;
                        this.dyBody = -7;
                    }
                    return 798;
                case 42:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -8;
                        this.dyBody = -7;
                    }
                    return 970;
                case 94:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -12;
                        this.dyBody = -7;
                    }
                    return 1142;
                case 141:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 3;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 3;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -9;
                        this.dyBody = -7;
                    }
                    return 1348;
                case 154:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = -3;
                        this.dyBody = 0;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = -3;
                        this.dyBody = 0;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -8;
                        this.dyBody = 0;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -15;
                        this.dyBody = -3;
                    }
                    return 1487;
                case 156:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 1;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 1;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -10;
                        this.dyBody = -7;
                    }
                    return 1507;
                case 157:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -8;
                        this.dyBody = -7;
                    }
                    return 1812;
                case 173:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -8;
                        this.dyBody = -7;
                    }
                    return 1838;
                case 180:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -8;
                        this.dyBody = -7;
                    }
                    return 1959;
                case 183:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -8;
                        this.dyBody = -7;
                    }
                    return 1987;
                case 186:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = -3;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = -3;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -6;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -14;
                        this.dyBody = -5;
                    }
                    return 2117;
                case 189:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = -3;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = -3;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -6;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -14;
                        this.dyBody = -5;
                    }
                    return 2144;
                case 197:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -5;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -10;
                        this.dyBody = -6;
                    }
                    return 2342;
                case 199:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -5;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -10;
                        this.dyBody = -6;
                    }
                    return 2373;
                case 206:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -5;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -10;
                        this.dyBody = -6;
                    }
                    return 2459;
                default:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = 0;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -7;
                        this.dyBody = -6;
                    }
                    return 13;
            }
        } else if (!this.isBocdau) {
            CharPartInfo charPartInfo1;
            if ((argument = (CharPartInfo) CharPartInfo.body_normal.get(String.valueOf(this.body))) != null && (charPartInfo1 = (CharPartInfo) ((CharPartInfo) argument).item.get(String.valueOf(this.arrItemMounts[4].template.id))) != null) {
                this.dxBody = charPartInfo1.dx;
                this.dyBody = charPartInfo1.dy;
                return part != null ? part.pi[this.frameFix].id : ((CharPartInfo) argument).idSmall;
            }
            switch(this.body) {
                case 1:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 2;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 2;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = 0;
                        this.dyBody = 0;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -5;
                        this.dyBody = -2;
                    }
                    return 9;
                case 3:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = 0;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -5;
                        this.dyBody = -3;
                    }
                    return 41;
                case 5:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -6;
                        this.dyBody = -2;
                    }
                    return 70;
                case 7:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -6;
                        this.dyBody = -2;
                    }
                    return 97;
                case 10:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -6;
                        this.dyBody = -2;
                    }
                    return 133;
                case 18:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -6;
                        this.dyBody = -2;
                    }
                    return 369;
                case 20:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -6;
                        this.dyBody = -2;
                    }
                    return 395;
                case 22:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -6;
                        this.dyBody = -2;
                    }
                    return 421;
                case 29:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = 0;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -6;
                        this.dyBody = -2;
                    }
                    return 468;
                case 32:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = 0;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -6;
                        this.dyBody = -2;
                    }
                    return 502;
                case 34:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = 0;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -5;
                        this.dyBody = -2;
                    }
                    return 540;
                case 36:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = 0;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -5;
                        this.dyBody = -2;
                    }
                    return 555;
                case 38:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = 0;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -5;
                        this.dyBody = -2;
                    }
                    return 794;
                case 42:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = 0;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -5;
                        this.dyBody = -2;
                    }
                    return 966;
                case 94:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = 0;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -5;
                        this.dyBody = -2;
                    }
                    return 1139;
                case 141:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = -2;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = -2;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -3;
                        this.dyBody = 0;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -7;
                        this.dyBody = -1;
                    }
                    return 1343;
                case 154:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = 0;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = 0;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = 0;
                        this.dyBody = 1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -3;
                        this.dyBody = -1;
                    }
                    return 1479;
                case 156:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 3;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 3;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = 0;
                        this.dyBody = 2;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -3;
                        this.dyBody = 0;
                    }
                    return 1502;
                case 157:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -6;
                        this.dyBody = -2;
                    }
                    return 1808;
                case 173:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -6;
                        this.dyBody = -2;
                    }
                    return 1834;
                case 180:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -6;
                        this.dyBody = -2;
                    }
                    return 1955;
                case 183:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -6;
                        this.dyBody = -2;
                    }
                    return 1983;
                case 186:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -2;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -8;
                        this.dyBody = -2;
                    }
                    return 2135;
                case 189:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -2;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -8;
                        this.dyBody = -2;
                    }
                    return 2135;
                case 197:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = -3;
                        this.dyBody = 0;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = -3;
                        this.dyBody = 0;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -4;
                        this.dyBody = 0;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -5;
                        this.dyBody = -1;
                    }
                    return 2337;
                case 199:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = -3;
                        this.dyBody = 0;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = -3;
                        this.dyBody = 0;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -4;
                        this.dyBody = 0;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -5;
                        this.dyBody = -1;
                    }
                    return 2363;
                case 206:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = -3;
                        this.dyBody = 0;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = -3;
                        this.dyBody = 0;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -4;
                        this.dyBody = 0;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -9;
                        this.dyBody = -1;
                    }
                    return 2456;
                default:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 2;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 2;
                        this.dyBody = -1;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = 0;
                        this.dyBody = 0;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -5;
                        this.dyBody = -2;
                    }
                    return 9;
            }
        } else {
            CharPartInfo charPartInfo2;
            if ((argument = (CharPartInfo) CharPartInfo.body_boc_dau.get(String.valueOf(this.body))) != null && (charPartInfo2 = (CharPartInfo) ((CharPartInfo) argument).item.get(String.valueOf(this.arrItemMounts[4].template.id))) != null) {
                this.dxBody = charPartInfo2.dx;
                this.dyBody = charPartInfo2.dy;
                return part != null ? part.pi[this.frameFix].id : ((CharPartInfo) argument).idSmall;
            }
            switch(this.body) {
                case 1:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 3;
                        this.dyBody = -3;
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 3;
                        this.dyBody = -3;
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -8;
                        this.dyBody = -6;
                    }
                    return 13;
                case 3:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -8;
                        this.dyBody = -6;
                    }
                    return 45;
                case 5:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -9;
                        this.dyBody = -7;
                    }
                    return 73;
                case 7:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -9;
                        this.dyBody = -7;
                    }
                    return 101;
                case 10:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -9;
                        this.dyBody = -7;
                    }
                    return 137;
                case 18:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -9;
                        this.dyBody = -7;
                    }
                    return 365;
                case 20:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -9;
                        this.dyBody = -7;
                    }
                    return 391;
                case 22:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -9;
                        this.dyBody = -7;
                    }
                    return 417;
                case 29:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 1;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 1;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -11;
                        this.dyBody = -6;
                    }
                    return 472;
                case 32:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 1;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 1;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -11;
                        this.dyBody = -6;
                    }
                    return 506;
                case 34:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -8;
                        this.dyBody = -7;
                    }
                    return 531;
                case 36:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -8;
                        this.dyBody = -7;
                    }
                    return 559;
                case 38:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -8;
                        this.dyBody = -7;
                    }
                    return 798;
                case 42:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -8;
                        this.dyBody = -7;
                    }
                    return 970;
                case 94:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 0;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 0;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -12;
                        this.dyBody = -7;
                    }
                    return 1142;
                case 141:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 3;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 3;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -9;
                        this.dyBody = -7;
                    }
                    return 1348;
                case 154:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = -3;
                        this.dyBody = 0;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = -3;
                        this.dyBody = 0;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -8;
                        this.dyBody = 0;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -15;
                        this.dyBody = -3;
                    }
                    return 1487;
                case 156:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 1;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 1;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -4;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -10;
                        this.dyBody = -7;
                    }
                    return 1507;
                case 157:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -8;
                        this.dyBody = -7;
                    }
                    return 1812;
                case 173:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -8;
                        this.dyBody = -7;
                    }
                    return 1838;
                case 180:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -8;
                        this.dyBody = -7;
                    }
                    return 1959;
                case 183:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 4;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -8;
                        this.dyBody = -7;
                    }
                    return 1987;
                case 186:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = -3;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = -3;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -6;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -14;
                        this.dyBody = -5;
                    }
                    return 2117;
                case 189:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = -3;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = -3;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -6;
                        this.dyBody = -2;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -14;
                        this.dyBody = -5;
                    }
                    return 2144;
                case 197:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -5;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -10;
                        this.dyBody = -6;
                    }
                    return 2342;
                case 199:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -5;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -10;
                        this.dyBody = -6;
                    }
                    return 2373;
                case 206:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = -1;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = -5;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -10;
                        this.dyBody = -6;
                    }
                    return 2459;
                default:
                    if (this.arrItemMounts[4].template.id == 443) {
                        this.dxBody = 3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 523) {
                        this.dxBody = 3;
                        this.dyBody = -3;
                    } else if (this.arrItemMounts[4].template.id == 485) {
                        this.dxBody = 0;
                        this.dyBody = -4;
                    } else if (this.arrItemMounts[4].template.id == 524) {
                        this.dxBody = -7;
                        this.dyBody = -6;
                    }
                    return 13;
            }
        }
    }

    private int getHeadId() {
        this.dxHead = this.dyHead = 0;
        Part part = GameScr.parts[this.head];
        Object argument = null;
        if (this.statusMe == 3) {
            CharPartInfo charPartInfo;
            if ((argument = (CharPartInfo) CharPartInfo.head_jump.get(String.valueOf(this.head))) != null && (charPartInfo = (CharPartInfo) ((CharPartInfo) argument).item.get(String.valueOf(this.arrItemMounts[4].template.id))) != null) {
                this.dxHead = charPartInfo.dx;
                this.dyHead = charPartInfo.dy;
                return part != null ? part.pi[this.frameFix].id : ((CharPartInfo) argument).idSmall;
            }
            switch(this.head) {
                case 2:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 33;
                case 11:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 147;
                case 23:
                    this.dxHead = 1;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 427;
                case 24:
                    this.dxHead = 1;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 430;
                case 25:
                    this.dxHead = 3;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 433;
                case 26:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 436;
                case 27:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 439;
                case 28:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 442;
                case 112:
                    this.dxHead = 1;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 148;
                case 113:
                    this.dxHead = -1;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 443;
                case 124:
                    this.dxHead = 1;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1235;
                case 125:
                    this.dxHead = -1;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1237;
                case 126:
                    this.dxHead = -1;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1255;
                case 127:
                    this.dxHead = -1;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1257;
                case 137:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1309;
                case 138:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1311;
                case 139:
                    this.dxHead = 2;
                    this.dyHead = -5;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1315;
                case 140:
                    this.dxHead = 3;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1313;
                case 146:
                    this.dxHead = 1;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1416;
                case 147:
                    this.dxHead = -2;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1418;
                case 148:
                    this.dxHead = 0;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1422;
                case 149:
                    this.dxHead = -2;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1424;
                case 150:
                    this.dxHead = 0;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1441;
                case 151:
                    this.dxHead = -2;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1439;
                case 152:
                    this.dxHead = 1;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1447;
                case 153:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1445;
                case 158:
                    this.dxHead = -2;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1585;
                case 159:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1589;
                case 160:
                    this.dxHead = 2;
                    this.dyHead = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1587;
                case 161:
                    this.dxHead = 3;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1595;
                case 162:
                    this.dxHead = -5;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1597;
                case 163:
                    this.dxHead = -3;
                    this.dyHead = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1604;
                case 179:
                    this.dxHead = 3;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1978;
                case 182:
                    this.dxHead = 3;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 2006;
                case 185:
                    this.dxHead = -4;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 2129;
                case 188:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 2156;
                case 205:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 2451;
                case 210:
                    this.dxHead = 0;
                    this.dyHead = -5;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 2519;
                case 211:
                    this.dxHead = -1;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 2521;
                case 212:
                    this.dxHead = -2;
                    this.dyHead = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 2523;
                case 213:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 2525;
                case 214:
                    this.dxHead = 1;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 2526;
                default:
                    this.dxHead = 2;
                    this.dyHead = -5;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 33;
            }
        } else if (!this.isBocdau) {
            CharPartInfo charPartInfo1;
            if ((argument = (CharPartInfo) CharPartInfo.head_normal.get(String.valueOf(this.head))) != null && (charPartInfo1 = (CharPartInfo) ((CharPartInfo) argument).item.get(String.valueOf(this.arrItemMounts[4].template.id))) != null) {
                this.dxHead = charPartInfo1.dx;
                this.dyHead = charPartInfo1.dy;
                return part != null ? part.pi[this.frameFix].id : ((CharPartInfo) argument).idSmall;
            }
            switch(this.head) {
                case 2:
                    this.dxHead = -1;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 33;
                case 11:
                    this.dxHead = -2;
                    this.dyHead = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 147;
                case 23:
                    this.dxHead = -1;
                    this.dyHead = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 427;
                case 24:
                    this.dxHead = -1;
                    this.dyHead = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 430;
                case 25:
                    this.dxHead = 1;
                    this.dyHead = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 433;
                case 26:
                    this.dxHead = -2;
                    this.dyHead = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 436;
                case 27:
                    this.dxHead = -2;
                    this.dyHead = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 439;
                case 28:
                    this.dxHead = -2;
                    this.dyHead = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 442;
                case 112:
                    this.dxHead = -1;
                    this.dyHead = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 148;
                case 113:
                    this.dxHead = -3;
                    this.dyHead = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 443;
                case 124:
                    this.dxHead = -1;
                    this.dyHead = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1235;
                case 125:
                    this.dxHead = -1;
                    this.dyHead = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1237;
                case 126:
                    this.dxHead = -1;
                    this.dyHead = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1255;
                case 127:
                    this.dxHead = -3;
                    this.dyHead = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1257;
                case 137:
                    this.dxHead = -2;
                    this.dyHead = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1309;
                case 138:
                    this.dxHead = -2;
                    this.dyHead = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1311;
                case 139:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1315;
                case 140:
                    this.dxHead = 1;
                    this.dyHead = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1313;
                case 146:
                    this.dxHead = -1;
                    this.dyHead = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1416;
                case 147:
                    this.dxHead = -4;
                    this.dyHead = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1418;
                case 148:
                    this.dxHead = -2;
                    this.dyHead = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1422;
                case 149:
                    this.dxHead = -4;
                    this.dyHead = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1424;
                case 150:
                    this.dxHead = -2;
                    this.dyHead = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1441;
                case 151:
                    this.dxHead = -4;
                    this.dyHead = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1439;
                case 152:
                    this.dxHead = -1;
                    this.dyHead = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1447;
                case 153:
                    this.dxHead = -2;
                    this.dyHead = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1445;
                case 158:
                    this.dxHead = -4;
                    this.dyHead = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1585;
                case 159:
                    this.dxHead = -2;
                    this.dyHead = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1589;
                case 160:
                    this.dxHead = 0;
                    this.dyHead = 0;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1587;
                case 161:
                    this.dxHead = 1;
                    this.dyHead = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1595;
                case 162:
                    this.dxHead = -7;
                    this.dyHead = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1597;
                case 163:
                    this.dxHead = -5;
                    this.dyHead = 0;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1604;
                case 179:
                    this.dxHead = 1;
                    this.dyHead = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 1978;
                case 182:
                    this.dxHead = 1;
                    this.dyHead = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 2006;
                case 185:
                    this.dxHead = -6;
                    this.dyHead = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 2129;
                case 188:
                    this.dxHead = -2;
                    this.dyHead = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 2156;
                case 205:
                    this.dxHead = -2;
                    this.dyHead = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 2451;
                case 210:
                    this.dxHead = -2;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 2519;
                case 211:
                    this.dxHead = -3;
                    this.dyHead = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 2521;
                case 212:
                    this.dxHead = -4;
                    this.dyHead = 0;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 2523;
                case 213:
                    this.dxHead = 0;
                    this.dyHead = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 2525;
                case 214:
                    this.dxHead = -1;
                    this.dyHead = -1;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 2526;
                default:
                    this.dxHead = -1;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 5;
                            this.dyHead--;
                        }
                    }
                    return 33;
            }
        } else {
            CharPartInfo charPartInfo2;
            if ((argument = (CharPartInfo) CharPartInfo.head_boc_dau.get(String.valueOf(this.head))) != null && (charPartInfo2 = (CharPartInfo) ((CharPartInfo) argument).item.get(String.valueOf(this.arrItemMounts[4].template.id))) != null) {
                this.dxHead = charPartInfo2.dx;
                this.dyHead = charPartInfo2.dy;
                return part != null ? part.pi[this.frameFix].id : ((CharPartInfo) argument).idSmall;
            }
            switch(this.head) {
                case 2:
                    this.dxHead = 2;
                    this.dyHead = -5;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 33;
                case 11:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 147;
                case 23:
                    this.dxHead = 1;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 427;
                case 24:
                    this.dxHead = 1;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 430;
                case 25:
                    this.dxHead = 3;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 433;
                case 26:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 436;
                case 27:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 439;
                case 28:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 442;
                case 112:
                    this.dxHead = 1;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 148;
                case 113:
                    this.dxHead = -1;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 443;
                case 124:
                    this.dxHead = 1;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1235;
                case 125:
                    this.dxHead = -1;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1237;
                case 126:
                    this.dxHead = -1;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1255;
                case 127:
                    this.dxHead = -1;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1257;
                case 137:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1309;
                case 138:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1311;
                case 139:
                    this.dxHead = 2;
                    this.dyHead = -5;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1315;
                case 140:
                    this.dxHead = 3;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1313;
                case 146:
                    this.dxHead = 1;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1416;
                case 147:
                    this.dxHead = -2;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1418;
                case 148:
                    this.dxHead = 0;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1422;
                case 149:
                    this.dxHead = -2;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1424;
                case 150:
                    this.dxHead = 0;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1441;
                case 151:
                    this.dxHead = -2;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1439;
                case 152:
                    this.dxHead = 1;
                    this.dyHead = -4;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1447;
                case 153:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1445;
                case 158:
                    this.dxHead = -2;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1585;
                case 159:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1589;
                case 160:
                    this.dxHead = 2;
                    this.dyHead = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1587;
                case 161:
                    this.dxHead = 3;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1595;
                case 162:
                    this.dxHead = -5;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1597;
                case 163:
                    this.dxHead = -3;
                    this.dyHead = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1604;
                case 179:
                    this.dxHead = 3;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 1978;
                case 182:
                    this.dxHead = 3;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 2006;
                case 185:
                    this.dxHead = -4;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 2129;
                case 188:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 2156;
                case 205:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 2451;
                case 210:
                    this.dxHead = 0;
                    this.dyHead = -5;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 2519;
                case 211:
                    this.dxHead = -1;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 2521;
                case 212:
                    this.dxHead = -2;
                    this.dyHead = -2;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 2523;
                case 213:
                    this.dxHead = 0;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 2525;
                case 214:
                    this.dxHead = 1;
                    this.dyHead = -3;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 2526;
                default:
                    this.dxHead = 2;
                    this.dyHead = -5;
                    if (this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523) {
                        if (this.arrItemMounts[4].template.id == 485) {
                            this.dxHead -= 2;
                            this.dyHead++;
                        } else if (this.arrItemMounts[4].template.id == 524) {
                            this.dxHead -= 7;
                            this.dyHead--;
                        }
                    }
                    return 33;
            }
        }
    }

    private int[] getClanEffect() {
        if (this.statusMe != 6 && this.statusMe != 1 && this.statusMe != 2 && this.statusMe != 10 && this.statusMe != 11) {
            return null;
        }
        int[] values = null;
        if (this.me) {
            if (this.arrItemBody[13] != null) {
                if (this.arrItemBody[13].template.id == 425) {
                    values = new int[] { 1687, 1688, 1689, 1690, 1691 };
                } else if (this.arrItemBody[13].template.id == 426) {
                    values = new int[] { 1682, 1683, 1684, 1685, 1686 };
                } else if (this.arrItemBody[13].template.id == 427) {
                    values = new int[] { 1677, 1678, 1679, 1680, 1681 };
                }
            }
        } else {
            if (this.glove == -1) {
                return null;
            }
            if (this.glove == 425) {
                values = new int[] { 1687, 1688, 1689, 1690, 1691 };
            } else if (this.glove == 426) {
                values = new int[] { 1682, 1683, 1684, 1685, 1686 };
            } else if (this.glove == 427) {
                values = new int[] { 1677, 1678, 1679, 1680, 1681 };
            }
        }
        return values;
    }

    public final void paintClanEffect(mGraphics graphics, int value, int value1) {
        int[] values;
        if ((values = this.getClanEffect()) != null) {
            int value2;
            if ((value2 = GameCanvas.gameTick % 13) > 9) {
                SmallImage.drawSmallImage(graphics, values[0], value, value1, 0, 33);
            } else if (value2 > 6) {
                SmallImage.drawSmallImage(graphics, values[1], value, value1 + 2, 0, 33);
            } else if (value2 > 3) {
                SmallImage.drawSmallImage(graphics, values[2], value - 2, value1 + 1, 0, 33);
            } else {
                SmallImage.drawSmallImage(graphics, values[3], value - 2, value1, 0, 33);
            }
        }
    }

    private void paintClanEffectRun(mGraphics g, int x, int y) {
        int[] values;
        if ((values = this.getClanEffect()) != null) {
            int value = this.cdir == 1 ? 6 : 5;
            int value1 = this.cdir == -1 ? 40 : 36;
            int value2;
            if ((value2 = GameCanvas.gameTick % 13) > 9) {
                SmallImage.drawSmallImage(g, values[0], x, y, value, value1);
            } else if (value2 > 6) {
                SmallImage.drawSmallImage(g, values[1], x, y, value, value1);
            } else if (value2 > 3) {
                SmallImage.drawSmallImage(g, values[2], x, y, value, value1);
            } else {
                SmallImage.drawSmallImage(g, values[3], x, y, value, value1);
            }
        }
    }

    public final void paintClanEffect2(mGraphics graphics, int value, int value1) {
        int[] values;
        if ((values = this.getClanEffect()) != null) {
            SmallImage.drawSmallImage(graphics, values[4], value - 2, value1, 0, 33);
        }
    }

    private void callEff(int value) {
        this.indexEff = 0;
        this.eff = GameScr.efs[value];
    }

    public final void callEffTask(int value) {
        this.indexEffTask = 0;
        this.effTask = GameScr.efs[value];
    }

    public static int getIndexChar(int ID) {
        for (int index = 0; index < GameScr.vCharInMap.size(); index++) {
            if (((Char) GameScr.vCharInMap.elementAt(index)).charID == ID) {
                return index;
            }
        }
        return -1;
    }

    public final void moveTo(int toX, int toY) {
        byte byteValue = 0;
        byte byteValue1 = 0;
        toX -= this.cx;
        toY -= this.cy;
        if (toX == 0 && toY == 0) {
            byteValue1 = 1;
        } else if (toY == 0) {
            byteValue1 = 2;
            if (this.vMovePoints.size() > 0) {
                MovePoint movePoint = null;
                try {
                    movePoint = (MovePoint) this.vMovePoints.lastElement();
                } catch (Exception exception) {
                }
                if (movePoint != null && TileMap.tileTypeAt(movePoint.xEnd, movePoint.yEnd, 64) && movePoint.yEnd % TileMap.size > 8) {
                    byteValue1 = 10;
                }
            }
            if (toX > 0) {
                byteValue = 1;
            }
            if (toX < 0) {
                byteValue = -1;
            }
        } else if (toY != 0) {
            if (toY < 0) {
                byteValue1 = 3;
            }
            if (toY > 0) {
                byteValue1 = 4;
            }
            if (toX < 0) {
                byteValue = -1;
            }
            if (toX > 0) {
                byteValue = 1;
            }
        }
        int value = 0;
        int value2 = 0;
        value = this.cx + toX;
        value2 = this.cy + toY;
        this.vMovePoints.addElement(new MovePoint(value, value2, byteValue1, byteValue));
        this.statusMe = 6;
    }

    private void searchFocus() {
        if (this.charFocus != null && this.charFocus.isNhanban) {
            this.charFocus = null;
        }
        if (isManualFocus && this.charFocus != null && (this.charFocus.statusMe == 15 || this.charFocus.isInvisible)) {
            this.charFocus = null;
        }
        if (GameCanvas.gameTick % 2 != 0) {
            if (!this.isMeCanAttackOtherPlayer(this.charFocus)) {
                byte byteValue = 0;
                if (this.nClass.classId == 0 || this.nClass.classId == 1 || this.nClass.classId == 3 || this.nClass.classId == 5) {
                    if (GameScr.auto != 1) {
                        byteValue = 40;
                    } else {
                        byteValue = 0;
                    }
                }
                int[] values = new int[] { -1, -1, -1, -1 };
                int value = GameScr.cmx - 10;
                int value1 = GameScr.cmx + GameCanvas.w + 10;
                int value2 = GameScr.cmy;
                int value3 = GameScr.cmy + GameCanvas.h - GameScr.cmdBarH + 10;
                if (isManualFocus) {
                    if (this.mobFocus != null && this.mobFocus.status != 1 && this.mobFocus.status != 8 && this.mobFocus.status != 0 && value <= this.mobFocus.x && this.mobFocus.x <= value1 && value2 <= this.mobFocus.y && this.mobFocus.y <= value3 || this.npcFocus != null && value <= this.npcFocus.cx && this.npcFocus.cx <= value1 && value2 <= this.npcFocus.cy && this.npcFocus.cy <= value3 || this.charFocus != null && value <= this.charFocus.cx && this.charFocus.cx <= value1 && value2 <= this.charFocus.cy && this.charFocus.cy <= value3 || this.itemFocus != null && value <= this.itemFocus.x && this.itemFocus.x <= value1 && value2 <= this.itemFocus.y && this.itemFocus.y <= value3) {
                        return;
                    }
                    isManualFocus = false;
                }
                if (this.itemFocus == null) {
                    for (int index = 0; index < GameScr.vItemMap.size(); index++) {
                        ItemMap itemMap = (ItemMap) GameScr.vItemMap.elementAt(index);
                        int value4 = Math.abs(getMyChar().cx - itemMap.x);
                        int value5 = Math.abs(getMyChar().cy - itemMap.y);
                        int value6 = value4 > value5 ? value4 : value5;
                        if (value4 <= 48 && value5 <= 48 && (this.itemFocus == null || value6 < values[3])) {
                            GameScr.gI();
                            if (GameScr.auto != 0) {
                                GameScr.gI();
                                if (GameScr.isBagFull()) {
                                    if (itemMap.template.type == 19) {
                                        if (GameScr.isUseitemAuto) {
                                            this.itemFocus = null;
                                        } else {
                                            this.itemFocus = itemMap;
                                        }
                                        values[3] = value6;
                                    }
                                    continue;
                                }
                            }
                            if (!nso.Char.isAPickYen && !nso.Char.isAPickYHM && !nso.Char.isAPickYHMS && !nso.Char.isANoPick) {
                                if (GameScr.isUseitemAuto) {
                                    this.itemFocus = null;
                                } else {
                                    this.itemFocus = itemMap;
                                }
                                values[3] = value6;
                            } else if (nso.Char.isAPickYen && itemMap.template.type == 19 || nso.Char.isAPickYHM && (itemMap.template.type == 19 || itemMap.template.type == 16 || itemMap.template.type == 17) || nso.Char.isAPickYHMS && (itemMap.template.type == 19 || itemMap.template.type == 16 || itemMap.template.type == 17 || itemMap.template.type == 26)) {
                                if (GameScr.isUseitemAuto) {
                                    this.itemFocus = null;
                                } else {
                                    this.itemFocus = itemMap;
                                }
                                values[3] = value6;
                            }
                        }
                    }
                } else {
                    if (value <= this.itemFocus.x && this.itemFocus.x <= value1 && value2 <= this.itemFocus.y && this.itemFocus.y <= value3) {
                        this.clearFocus(3);
                        return;
                    }
                    this.itemFocus = null;
                    for (int index7 = 0; index7 < GameScr.vItemMap.size(); index7++) {
                        ItemMap itemMap8 = (ItemMap) GameScr.vItemMap.elementAt(index7);
                        int value9 = Math.abs(getMyChar().cx - itemMap8.x);
                        int value10 = Math.abs(getMyChar().cy - itemMap8.y);
                        int value11 = value9 > value10 ? value9 : value10;
                        if (value <= itemMap8.x && itemMap8.x <= value1 && value2 <= itemMap8.y && itemMap8.y <= value3 && (this.itemFocus == null || value11 < values[3])) {
                            GameScr.gI();
                            if (GameScr.auto != 0) {
                                GameScr.gI();
                                if (GameScr.isBagFull()) {
                                    if (itemMap8.template.type == 19) {
                                        if (GameScr.isUseitemAuto) {
                                            this.itemFocus = null;
                                        } else {
                                            this.itemFocus = itemMap8;
                                        }
                                        values[3] = value11;
                                    }
                                    continue;
                                }
                            }
                            if (!nso.Char.isAPickYen && !nso.Char.isAPickYHM && !nso.Char.isAPickYHMS && !nso.Char.isANoPick) {
                                if (GameScr.isUseitemAuto) {
                                    this.itemFocus = null;
                                } else {
                                    this.itemFocus = itemMap8;
                                }
                                values[3] = value11;
                            } else if (nso.Char.isAPickYen && itemMap8.template.type == 19 || nso.Char.isAPickYHM && (itemMap8.template.type == 19 || itemMap8.template.type == 16 || itemMap8.template.type == 17) || nso.Char.isAPickYHMS && (itemMap8.template.type == 19 || itemMap8.template.type == 16 || itemMap8.template.type == 17 || itemMap8.template.type == 26)) {
                                if (GameScr.isUseitemAuto) {
                                    this.itemFocus = null;
                                } else {
                                    this.itemFocus = itemMap8;
                                }
                                values[3] = value11;
                            }
                        }
                    }
                }
                int value12;
                if (TileMap.typeMap != 3 && TileMap.mapID != 111) {
                    value = getMyChar().cx - getMyChar().getdxSkill() - 10;
                    value1 = getMyChar().cx + getMyChar().getdxSkill() + 10;
                    value2 = getMyChar().cy - getMyChar().getdySkill() - byteValue;
                    if ((value3 = getMyChar().cy + getMyChar().getdySkill()) > getMyChar().cy + 30) {
                        value3 = getMyChar().cy + 30;
                    }
                    if (this.mobFocus == null) {
                        for (int index13 = 0; index13 < GameScr.vMob.size(); index13++) {
                            Mob mob = (Mob) GameScr.vMob.elementAt(index13);
                            int value14 = Math.abs(getMyChar().cx - mob.x);
                            int value15 = Math.abs(getMyChar().cy - mob.y);
                            int value16 = value14 > value15 ? value14 : value15;
                            if ((mob.templateId != 97 || getMyChar().cTypePk != 4) && (mob.templateId != 98 || getMyChar().cTypePk != 4) && (mob.templateId != 167 || getMyChar().cTypePk != 4) && (mob.templateId != 99 || getMyChar().cTypePk != 5) && (mob.templateId != 96 || getMyChar().cTypePk != 5) && (mob.templateId != 166 || getMyChar().cTypePk != 5) && (mob.templateId != 200 || getMyChar().cTypePk != 4) && (mob.templateId != 199 || getMyChar().cTypePk != 5) && (mob.templateId != 198 || getMyChar().cTypePk != 6) && (mob.templateId != 202 || mob.status != 8 || mob.isPaint()) && (!GameScr.isUseitemAuto || mob.levelBoss != 3) && mob.templateId != 202 && value <= mob.x && mob.x <= value1 && value2 <= mob.y && mob.y <= value3 && mob.status != 0 && mob.status != 1 && (this.mobFocus == null || value16 < values[0])) {
                                this.mobFocus = mob;
                                values[0] = value16;
                            }
                        }
                    } else {
                        if (this.mobFocus.status != 1 && this.mobFocus.status != 0 && value <= this.mobFocus.x && this.mobFocus.x <= value1 && value2 <= this.mobFocus.y && this.mobFocus.y <= value3) {
                            this.clearFocus(0);
                            return;
                        }
                        this.mobFocus = null;
                        for (int index17 = 0; index17 < GameScr.vMob.size(); index17++) {
                            Mob mob18 = (Mob) GameScr.vMob.elementAt(index17);
                            int value19 = Math.abs(getMyChar().cx - mob18.x);
                            int value20 = Math.abs(getMyChar().cy - mob18.y);
                            int value21 = value19 > value20 ? value19 : value20;
                            if ((mob18.templateId != 97 || getMyChar().cTypePk != 4) && (mob18.templateId != 96 || getMyChar().cTypePk != 5) && (mob18.templateId != 98 || getMyChar().cTypePk != 4) && (mob18.templateId != 167 || getMyChar().cTypePk != 4) && (mob18.templateId != 99 || getMyChar().cTypePk != 5) && (mob18.templateId != 166 || getMyChar().cTypePk != 5) && (mob18.templateId != 96 || getMyChar().cTypePk != 6) && (mob18.templateId != 99 || getMyChar().cTypePk != 6) && (mob18.templateId != 166 || getMyChar().cTypePk != 6) && (mob18.templateId != 202 || mob18.status != 8 || mob18.isPaint()) && (!GameScr.isUseitemAuto || mob18.levelBoss != 3) && mob18.templateId != 202 && value <= mob18.x && mob18.x <= value1 && value2 <= mob18.y && mob18.y <= value3 && mob18.status != 0 && mob18.status != 1 && (this.mobFocus == null || value21 < values[0])) {
                                this.mobFocus = mob18;
                                values[0] = value21;
                            }
                        }
                    }
                    value = getMyChar().cx - 80;
                    value1 = getMyChar().cx + 80;
                    value2 = getMyChar().cy - 30;
                    value3 = getMyChar().cy + 30;
                    if (this.npcFocus != null && this.npcFocus.template.npcTemplateId == 13) {
                        value = getMyChar().cx - 20;
                        value1 = getMyChar().cx + 20;
                        value2 = getMyChar().cy - 10;
                        value3 = getMyChar().cy + 10;
                    }
                    if (this.npcFocus == null) {
                        for (int index22 = 0; index22 < GameScr.vNpc.size(); index22++) {
                            Npc npc;
                            if ((npc = (Npc) GameScr.vNpc.elementAt(index22)).statusMe != 15 && TileMap.typeMap != 1) {
                                int value23 = Math.abs(getMyChar().cx - npc.cx);
                                int value24 = Math.abs(getMyChar().cy - npc.cy);
                                int value25 = value23 > value24 ? value23 : value24;
                                value = getMyChar().cx - 80;
                                value1 = getMyChar().cx + 80;
                                value2 = getMyChar().cy - 30;
                                value3 = getMyChar().cy + 30;
                                if (npc.template.npcTemplateId == 13) {
                                    value = getMyChar().cx - 20;
                                    value1 = getMyChar().cx + 20;
                                    value2 = getMyChar().cy - 10;
                                    value3 = getMyChar().cy + 10;
                                }
                                if (value <= npc.cx && npc.cx <= value1 && value2 <= npc.cy && npc.cy <= value3 && (this.npcFocus == null || value25 < values[1])) {
                                    if (GameScr.isUseitemAuto && GameScr.auto == 1) {
                                        break;
                                    }
                                    this.npcFocus = npc;
                                    values[1] = value25;
                                }
                            }
                        }
                    } else {
                        if (value <= this.npcFocus.cx && this.npcFocus.cx <= value1 && value2 <= this.npcFocus.cy && this.npcFocus.cy <= value3) {
                            this.clearFocus(1);
                            return;
                        }
                        this.deFocusNPC();
                        for (int index26 = 0; index26 < GameScr.vNpc.size(); index26++) {
                            Npc npc27;
                            if ((npc27 = (Npc) GameScr.vNpc.elementAt(index26)).statusMe != 15 && TileMap.typeMap != 1) {
                                int value28 = Math.abs(getMyChar().cx - npc27.cx);
                                int value29 = Math.abs(getMyChar().cy - npc27.cy);
                                int value30 = value28 > value29 ? value28 : value29;
                                value = getMyChar().cx - 80;
                                value1 = getMyChar().cx + 80;
                                value2 = getMyChar().cy - 30;
                                value3 = getMyChar().cy + 30;
                                if (npc27.template.npcTemplateId == 13) {
                                    value = getMyChar().cx - 20;
                                    value1 = getMyChar().cx + 20;
                                    value2 = getMyChar().cy - 10;
                                    value3 = getMyChar().cy + 10;
                                }
                                if (value <= npc27.cx && npc27.cx <= value1 && value2 <= npc27.cy && npc27.cy <= value3 && (this.npcFocus == null || value30 < values[1])) {
                                    if (GameScr.isUseitemAuto && GameScr.auto == 1) {
                                        break;
                                    }
                                    this.npcFocus = npc27;
                                    values[1] = value30;
                                }
                            }
                        }
                    }
                    if (this.charFocus == null) {
                        for (int index31 = 0; index31 < GameScr.vCharInMap.size(); index31++) {
                            Char character;
                            if (!(character = (Char) GameScr.vCharInMap.elementAt(index31)).isNhanban && character.statusMe != 15 && !character.isInvisible && character.charID < -1 && this.wdx == 0 && this.wdy == 0 && character.statusMe != 14 && character.statusMe != 5) {
                                int value32 = Math.abs(getMyChar().cx - character.cx);
                                int value33 = Math.abs(getMyChar().cy - character.cy);
                                int value34 = value32 > value33 ? value32 : value33;
                                if (value <= character.cx && character.cx <= value1 && value2 <= character.cy && character.cy <= value3 && (this.charFocus == null || value34 < values[2])) {
                                    this.charFocus = character;
                                    values[2] = value34;
                                }
                            }
                        }
                    } else {
                        if (value <= this.charFocus.cx && this.charFocus.cx <= value1 && value2 <= this.charFocus.cy && this.charFocus.cy <= value3 && this.charFocus.statusMe != 15 && !this.charFocus.isInvisible) {
                            this.clearFocus(2);
                            return;
                        }
                        this.charFocus = null;
                        for (int index35 = 0; index35 < GameScr.vCharInMap.size(); index35++) {
                            Char character36;
                            if (!(character36 = (Char) GameScr.vCharInMap.elementAt(index35)).isNhanban && character36.statusMe != 15 && !character36.isInvisible && character36.charID < 0 && this.wdx == 0 && this.wdy == 0 && character36.statusMe != 14 && character36.statusMe != 5) {
                                int value37 = Math.abs(getMyChar().cx - character36.cx);
                                int value38 = Math.abs(getMyChar().cy - character36.cy);
                                int value39 = value37 > value38 ? value37 : value38;
                                if (value <= character36.cx && character36.cx <= value1 && value2 <= character36.cy && character36.cy <= value3 && (this.charFocus == null || value39 < values[2])) {
                                    this.charFocus = character36;
                                    values[2] = value39;
                                }
                            }
                        }
                    }
                    value12 = -1;
                    for (int index40 = 0; index40 < values.length; index40++) {
                        if (value12 == -1) {
                            if (values[index40] != -1) {
                                value12 = index40;
                            }
                        } else if (values[index40] < values[value12] && values[index40] != -1) {
                            value12 = index40;
                        }
                    }
                    if (GameScr.isUseitemAuto && GameScr.auto == 1 && !GameScr.gI().lockAutoMove) {
                        GameScr.moveFast();
                    }
                } else {
                    value = getMyChar().cx - getMyChar().getdxSkill();
                    value1 = getMyChar().cx + getMyChar().getdxSkill();
                    value2 = getMyChar().cy - getMyChar().getdySkill() - byteValue;
                    if ((value3 = getMyChar().cy + getMyChar().getdySkill()) > getMyChar().cy + 30) {
                        value3 = getMyChar().cy + 30;
                    }
                    if (this.mobFocus == null) {
                        for (int index41 = 0; index41 < GameScr.vMob.size(); index41++) {
                            Mob mob42 = (Mob) GameScr.vMob.elementAt(index41);
                            int value43 = Math.abs(getMyChar().cx - mob42.x);
                            int value44 = Math.abs(getMyChar().cy - mob42.y);
                            int value45 = value43 > value44 ? value43 : value44;
                            if ((mob42.templateId != 97 || getMyChar().cTypePk != 4) && (mob42.templateId != 96 || getMyChar().cTypePk != 5) && (mob42.templateId != 98 || getMyChar().cTypePk != 4) && (mob42.templateId != 167 || getMyChar().cTypePk != 4) && (mob42.templateId != 99 || getMyChar().cTypePk != 5) && (mob42.templateId != 166 || getMyChar().cTypePk != 5) && (mob42.templateId != 200 || getMyChar().cTypePk != 4) && (mob42.templateId != 199 || getMyChar().cTypePk != 5) && (mob42.templateId != 198 || getMyChar().cTypePk != 6) && (mob42.templateId != 202 || mob42.status != 8 || mob42.isPaint()) && (!GameScr.isUseitemAuto || mob42.levelBoss != 3) && value <= mob42.x && mob42.x <= value1 && value2 <= mob42.y && mob42.y <= value3 && mob42.status != 0 && mob42.status != 1 && (this.mobFocus == null || value45 < values[0])) {
                                this.mobFocus = mob42;
                                values[0] = value45;
                            }
                        }
                    } else {
                        if (this.mobFocus.status != 1 && this.mobFocus.status != 0 && value <= this.mobFocus.x && this.mobFocus.x <= value1 && value2 <= this.mobFocus.y && this.mobFocus.y <= value3) {
                            this.clearFocus(0);
                            return;
                        }
                        this.mobFocus = null;
                        for (int index46 = 0; index46 < GameScr.vMob.size(); index46++) {
                            Mob mob47 = (Mob) GameScr.vMob.elementAt(index46);
                            int value48 = Math.abs(getMyChar().cx - mob47.x);
                            int value49 = Math.abs(getMyChar().cy - mob47.y);
                            int value50 = value48 > value49 ? value48 : value49;
                            if ((mob47.templateId != 97 || getMyChar().cTypePk != 4) && (mob47.templateId != 96 || getMyChar().cTypePk != 5) && (mob47.templateId != 98 || getMyChar().cTypePk != 4) && (mob47.templateId != 167 || getMyChar().cTypePk != 4) && (mob47.templateId != 99 || getMyChar().cTypePk != 5) && (mob47.templateId != 166 || getMyChar().cTypePk != 5) && (mob47.templateId != 200 || getMyChar().cTypePk != 4) && (mob47.templateId != 199 || getMyChar().cTypePk != 5) && (mob47.templateId != 198 || getMyChar().cTypePk != 6) && (mob47.templateId != 202 || mob47.status != 8 || mob47.isPaint()) && (!GameScr.isUseitemAuto || mob47.levelBoss != 3) && value <= mob47.x && mob47.x <= value1 && value2 <= mob47.y && mob47.y <= value3 && mob47.status != 0 && mob47.status != 1 && (this.mobFocus == null || value50 < values[0])) {
                                this.mobFocus = mob47;
                                values[0] = value50;
                            }
                        }
                    }
                    value = getMyChar().cx - 80;
                    value1 = getMyChar().cx + 80;
                    value2 = getMyChar().cy - 30;
                    value3 = getMyChar().cy + 30;
                    if (this.npcFocus != null && this.npcFocus.template.npcTemplateId == 13) {
                        value = getMyChar().cx - 20;
                        value1 = getMyChar().cx + 20;
                        value2 = getMyChar().cy - 10;
                        value3 = getMyChar().cy + 10;
                    }
                    if (this.npcFocus == null) {
                        for (int index51 = 0; index51 < GameScr.vNpc.size(); index51++) {
                            Npc npc52;
                            if ((npc52 = (Npc) GameScr.vNpc.elementAt(index51)).statusMe != 15) {
                                int value53 = Math.abs(getMyChar().cx - npc52.cx);
                                int value54 = Math.abs(getMyChar().cy - npc52.cy);
                                int value55 = value53 > value54 ? value53 : value54;
                                value = getMyChar().cx - 80;
                                value1 = getMyChar().cx + 80;
                                value2 = getMyChar().cy - 30;
                                value3 = getMyChar().cy + 30;
                                if (npc52.template.npcTemplateId == 13) {
                                    value = getMyChar().cx - 20;
                                    value1 = getMyChar().cx + 20;
                                    value2 = getMyChar().cy - 10;
                                    value3 = getMyChar().cy + 10;
                                }
                                if (value <= npc52.cx && npc52.cx <= value1 && value2 <= npc52.cy && npc52.cy <= value3 && (this.npcFocus == null || value55 < values[1])) {
                                    if (GameScr.isUseitemAuto && GameScr.auto == 1) {
                                        break;
                                    }
                                    this.npcFocus = npc52;
                                    values[1] = value55;
                                }
                            }
                        }
                    } else {
                        if (value <= this.npcFocus.cx && this.npcFocus.cx <= value1 && value2 <= this.npcFocus.cy && this.npcFocus.cy <= value3) {
                            this.clearFocus(1);
                            return;
                        }
                        this.deFocusNPC();
                        for (int index56 = 0; index56 < GameScr.vNpc.size(); index56++) {
                            Npc npc57;
                            if ((npc57 = (Npc) GameScr.vNpc.elementAt(index56)).statusMe != 15) {
                                int value58 = Math.abs(getMyChar().cx - npc57.cx);
                                int value59 = Math.abs(getMyChar().cy - npc57.cy);
                                int value60 = value58 > value59 ? value58 : value59;
                                value = getMyChar().cx - 80;
                                value1 = getMyChar().cx + 80;
                                value2 = getMyChar().cy - 30;
                                value3 = getMyChar().cy + 30;
                                if (npc57.template.npcTemplateId == 13) {
                                    value = getMyChar().cx - 20;
                                    value1 = getMyChar().cx + 20;
                                    value2 = getMyChar().cy - 10;
                                    value3 = getMyChar().cy + 10;
                                }
                                if (value <= npc57.cx && npc57.cx <= value1 && value2 <= npc57.cy && npc57.cy <= value3 && (this.npcFocus == null || value60 < values[1])) {
                                    if (GameScr.isUseitemAuto && GameScr.auto == 1) {
                                        break;
                                    }
                                    this.npcFocus = npc57;
                                    values[1] = value60;
                                }
                            }
                        }
                    }
                    value = getMyChar().cx - 40;
                    value1 = getMyChar().cx + 40;
                    value2 = getMyChar().cy - 30;
                    value3 = getMyChar().cy + 30;
                    if (this.charFocus == null) {
                        for (int index61 = 0; index61 < GameScr.vCharInMap.size(); index61++) {
                            Char character62;
                            if (!(character62 = (Char) GameScr.vCharInMap.elementAt(index61)).isNhanban && (TileMap.mapID != 111 ? character62.statusMe != 15 && !character62.isInvisible && character62.cTypePk != myChar.cTypePk && this.wdx == 0 && this.wdy == 0 && character62.statusMe != 14 && character62.statusMe != 5 : character62.statusMe != 15 && !character62.isInvisible && this.wdx == 0 && this.wdy == 0 && (myChar.nClass.classId == 6 ? (myChar.cTypePk == character62.cTypePk ? character62.statusMe == 14 && character62.statusMe == 5 : character62.statusMe != 14 && character62.statusMe != 5) : myChar.cTypePk != character62.cTypePk && character62.statusMe != 14 && character62.statusMe != 5))) {
                                int value63 = Math.abs(getMyChar().cx - character62.cx);
                                int value64 = Math.abs(getMyChar().cy - character62.cy);
                                int value65 = value63 > value64 ? value63 : value64;
                                if (value <= character62.cx && character62.cx <= value1 && value2 <= character62.cy && character62.cy <= value3 && (this.charFocus == null || value65 < values[2])) {
                                    this.charFocus = character62;
                                    values[2] = value65;
                                }
                            }
                        }
                    } else {
                        if (value <= this.charFocus.cx && this.charFocus.cx <= value1 && value2 <= this.charFocus.cy && this.charFocus.cy <= value3 && this.charFocus.statusMe != 15 && !this.charFocus.isInvisible && this.charFocus.statusMe != 14 && this.charFocus.statusMe != 5) {
                            this.clearFocus(2);
                            return;
                        }
                        this.charFocus = null;
                        for (int index66 = 0; index66 < GameScr.vCharInMap.size(); index66++) {
                            Char character67;
                            if (!(character67 = (Char) GameScr.vCharInMap.elementAt(index66)).isNhanban && (TileMap.mapID != 111 ? character67.statusMe != 15 && !character67.isInvisible && character67.cTypePk != myChar.cTypePk && this.wdx == 0 && this.wdy == 0 && character67.statusMe != 14 && character67.statusMe != 5 : character67.statusMe != 15 && !character67.isInvisible && this.wdx == 0 && this.wdy == 0 && (myChar.nClass.classId == 6 ? (myChar.cTypePk == character67.cTypePk ? character67.statusMe == 14 && character67.statusMe == 5 : character67.statusMe != 14 && character67.statusMe != 5) : myChar.cTypePk != character67.cTypePk && character67.statusMe != 14 && character67.statusMe != 5))) {
                                int value68 = Math.abs(getMyChar().cx - character67.cx);
                                int value69 = Math.abs(getMyChar().cy - character67.cy);
                                int value70 = value68 > value69 ? value68 : value69;
                                if (value <= character67.cx && character67.cx <= value1 && value2 <= character67.cy && character67.cy <= value3 && (this.charFocus == null || value70 < values[2])) {
                                    this.charFocus = character67;
                                    values[2] = value70;
                                }
                            }
                        }
                    }
                    value12 = -1;
                    for (int index71 = 0; index71 < values.length; index71++) {
                        if (value12 == -1) {
                            if (values[index71] != -1) {
                                value12 = index71;
                            }
                        } else if (values[index71] < values[value12] && values[index71] != -1) {
                            value12 = index71;
                        }
                    }
                }
                this.clearFocus(value12);
            }
        }
    }

    private void clearFocus(int index) {
        if (index == 0) {
            this.deFocusNPC();
            this.charFocus = null;
            this.itemFocus = null;
        } else if (index == 1) {
            this.mobFocus = null;
            this.charFocus = null;
            this.itemFocus = null;
        } else if (index == 2) {
            this.mobFocus = null;
            this.deFocusNPC();
            this.itemFocus = null;
        } else {
            if (index == 3) {
                this.mobFocus = null;
                this.deFocusNPC();
                this.charFocus = null;
            }
        }
    }

    public static boolean isCharInScreen(Char c) {
        int value = GameScr.cmx;
        int value1 = GameScr.cmx + GameCanvas.w;
        int value2 = GameScr.cmy + 10;
        int value3 = GameScr.cmy + GameScr.gH;
        return c.statusMe != 15 && !c.isInvisible && value <= c.cx && c.cx <= value1 && value2 <= c.cy && c.cy <= value3;
    }

    public final void findNextFocusByKey() {
        if (this.charFocus != null) {
            Char character = this.charFocus;
            if (this.charFocus.isNhanban) {
                this.charFocus = null;
            }
        }
        if (getMyChar().skillPaint == null && getMyChar().arr == null) {
            this.focus.removeAllElements();
            int value = 0;
            int value1 = GameScr.cmx + 10;
            int value2 = GameScr.cmx + GameCanvas.w - 10;
            int value3 = GameScr.cmy + 10;
            int value4 = GameScr.cmy + GameScr.gH;
            if (TileMap.typeMap != 3 && TileMap.mapID != 111) {
                for (int index = 0; index < GameScr.vItemMap.size(); index++) {
                    ItemMap itemMap = (ItemMap) GameScr.vItemMap.elementAt(index);
                    if (value1 <= itemMap.x && itemMap.x <= value2 && value3 <= itemMap.y && itemMap.y <= value4) {
                        this.focus.addElement(itemMap);
                        if (this.itemFocus != null && itemMap.equals(this.itemFocus)) {
                            value = this.focus.size();
                        }
                    }
                }
                for (int index5 = 0; index5 < GameScr.vMob.size(); index5++) {
                    Mob mob;
                    if (((mob = (Mob) GameScr.vMob.elementAt(index5)).templateId != 97 || getMyChar().cTypePk != 4) && (mob.templateId != 96 || getMyChar().cTypePk != 5) && (mob.templateId != 98 || getMyChar().cTypePk != 4) && (mob.templateId != 167 || getMyChar().cTypePk != 4) && (mob.templateId != 99 || getMyChar().cTypePk != 5) && (mob.templateId != 166 || getMyChar().cTypePk != 5) && (mob.templateId != 200 || getMyChar().cTypePk != 4) && (mob.templateId != 199 || getMyChar().cTypePk != 5) && (mob.templateId != 198 || getMyChar().cTypePk != 6) && (mob.templateId != 202 || mob.status != 8 || mob.isPaint()) && mob.status != 1 && mob.status != 0 && value1 <= mob.x && mob.x <= value2 && value3 <= mob.y && mob.y <= value4) {
                        this.focus.addElement(mob);
                        if (this.mobFocus != null && mob.equals(this.mobFocus)) {
                            value = this.focus.size();
                        }
                    }
                }
                for (int index6 = 0; index6 < GameScr.vNpc.size(); index6++) {
                    Npc npc;
                    if ((npc = (Npc) GameScr.vNpc.elementAt(index6)).statusMe != 15 && value1 <= npc.cx && npc.cx <= value2 && value3 <= npc.cy && npc.cy <= value4) {
                        this.focus.addElement(npc);
                        if (this.npcFocus != null && npc.equals(this.npcFocus)) {
                            value = this.focus.size();
                        }
                    }
                }
                for (int index7 = 0; index7 < GameScr.vCharInMap.size(); index7++) {
                    Char character8;
                    if (!(character8 = (Char) GameScr.vCharInMap.elementAt(index7)).isNhanban && character8.statusMe != 15 && !character8.isInvisible && value1 <= character8.cx && character8.cx <= value2 && value3 <= character8.cy && character8.cy <= value4) {
                        this.focus.addElement(character8);
                        if (this.charFocus != null && character8.equals(this.charFocus)) {
                            value = this.focus.size();
                        }
                    }
                }
                if (this.focus.size() > 0) {
                    if (value >= this.focus.size()) {
                        value = 0;
                    }
                    if (this.focus.elementAt(value) instanceof Mob) {
                        this.mobFocus = (Mob) this.focus.elementAt(value);
                        this.deFocusNPC();
                        this.charFocus = null;
                        this.itemFocus = null;
                        isManualFocus = true;
                        return;
                    }
                    if (this.focus.elementAt(value) instanceof Npc) {
                        this.mobFocus = null;
                        this.deFocusNPC();
                        this.npcFocus = (Npc) this.focus.elementAt(value);
                        this.charFocus = null;
                        this.itemFocus = null;
                        isManualFocus = true;
                        return;
                    }
                    if (this.focus.elementAt(value) instanceof Char) {
                        this.mobFocus = null;
                        this.deFocusNPC();
                        this.charFocus = (Char) this.focus.elementAt(value);
                        this.itemFocus = null;
                        isManualFocus = true;
                        return;
                    }
                    if (this.focus.elementAt(value) instanceof ItemMap) {
                        this.mobFocus = null;
                        this.deFocusNPC();
                        this.charFocus = null;
                        this.itemFocus = (ItemMap) this.focus.elementAt(value);
                        isManualFocus = true;
                        return;
                    }
                } else {
                    this.mobFocus = null;
                    this.deFocusNPC();
                    this.charFocus = null;
                    this.itemFocus = null;
                    isManualFocus = false;
                }
            } else {
                if (TileMap.mapID != 98 && TileMap.mapID != 104) {
                    for (int index9 = 0; index9 < GameScr.vCharInMap.size(); index9++) {
                        Char character10;
                        if (!(character10 = (Char) GameScr.vCharInMap.elementAt(index9)).isNhanban && character10.statusMe != 15 && !character10.isInvisible && value1 <= character10.cx && character10.cx <= value2 && value3 <= character10.cy && character10.cy <= value4) {
                            if (TileMap.mapID != 111) {
                                if (character10.cTypePk != getMyChar().cTypePk && character10.statusMe != 14 && character10.statusMe != 5) {
                                    this.focus.addElement(character10);
                                    if (this.charFocus != null && character10.equals(this.charFocus)) {
                                        value = this.focus.size();
                                    }
                                }
                            } else if (myChar.cTypePk == 0) {
                                this.focus.addElement(character10);
                                if (this.charFocus != null && character10.equals(this.charFocus)) {
                                    value = this.focus.size();
                                }
                            } else if (myChar.nClass.classId == 6) {
                                if (myChar.cTypePk == character10.cTypePk) {
                                    if (character10.statusMe == 14 || character10.statusMe == 5) {
                                        this.focus.addElement(character10);
                                        if (this.charFocus != null && character10.equals(this.charFocus)) {
                                            value = this.focus.size();
                                        }
                                    }
                                } else if ((myChar.cTypePk != 4 || character10.cTypePk == 5 || character10.cTypePk == 6 || character10.cTypePk == 7) && (myChar.cTypePk != 5 || character10.cTypePk == 4 || character10.cTypePk == 6 || character10.cTypePk == 7) && (myChar.cTypePk != 6 || character10.cTypePk == 4 || character10.cTypePk == 5 || character10.cTypePk == 7) && (myChar.cTypePk != 7 || character10.cTypePk == 4 || character10.cTypePk == 5 || character10.cTypePk == 6) && character10.statusMe != 14 && character10.statusMe != 5) {
                                    this.focus.addElement(character10);
                                    if (this.charFocus != null && character10.equals(this.charFocus)) {
                                        value = this.focus.size();
                                    }
                                }
                            } else if ((myChar.cTypePk != 4 || character10.cTypePk == 5 || character10.cTypePk == 6 || character10.cTypePk == 7) && (myChar.cTypePk != 5 || character10.cTypePk == 4 || character10.cTypePk == 6 || character10.cTypePk == 7) && (myChar.cTypePk != 6 || character10.cTypePk == 4 || character10.cTypePk == 5 || character10.cTypePk == 7) && (myChar.cTypePk != 7 || character10.cTypePk == 4 || character10.cTypePk == 5 || character10.cTypePk == 6) && character10.statusMe != 14 && character10.statusMe != 5) {
                                this.focus.addElement(character10);
                                if (this.charFocus != null && character10.equals(this.charFocus)) {
                                    value = this.focus.size();
                                }
                            }
                        }
                    }
                } else {
                    for (int index11 = 0; index11 < GameScr.vCharInMap.size(); index11++) {
                        Char character12;
                        if (!(character12 = (Char) GameScr.vCharInMap.elementAt(index11)).isNhanban && character12.statusMe != 15 && !character12.isInvisible && value1 <= character12.cx && character12.cx <= value2 && value3 <= character12.cy && character12.cy <= value4) {
                            this.focus.addElement(character12);
                            if (this.charFocus != null && character12.equals(this.charFocus)) {
                                value = this.focus.size();
                            }
                        }
                    }
                }
                for (int index13 = 0; index13 < GameScr.vItemMap.size(); index13++) {
                    ItemMap itemMap14 = (ItemMap) GameScr.vItemMap.elementAt(index13);
                    if (value1 <= itemMap14.x && itemMap14.x <= value2 && value3 <= itemMap14.y && itemMap14.y <= value4) {
                        this.focus.addElement(itemMap14);
                        if (this.itemFocus != null && itemMap14.equals(this.itemFocus)) {
                            value = this.focus.size();
                        }
                    }
                }
                for (int index15 = 0; index15 < GameScr.vMob.size(); index15++) {
                    Mob mob16;
                    if (((mob16 = (Mob) GameScr.vMob.elementAt(index15)).templateId != 97 || getMyChar().cTypePk != 4) && (mob16.templateId != 98 || getMyChar().cTypePk != 4) && (mob16.templateId != 167 || getMyChar().cTypePk != 4) && (mob16.templateId != 96 || getMyChar().cTypePk != 5) && (mob16.templateId != 99 || getMyChar().cTypePk != 5) && (mob16.templateId != 166 || getMyChar().cTypePk != 5) && (mob16.templateId != 200 || getMyChar().cTypePk != 4) && (mob16.templateId != 199 || getMyChar().cTypePk != 5) && (mob16.templateId != 198 || getMyChar().cTypePk != 6) && (mob16.templateId != 202 || mob16.status != 8 || mob16.isPaint()) && mob16.status != 1 && mob16.status != 0 && value1 <= mob16.x && mob16.x <= value2 && value3 <= mob16.y && mob16.y <= value4) {
                        this.focus.addElement(mob16);
                        if (this.mobFocus != null && mob16.equals(this.mobFocus)) {
                            value = this.focus.size();
                        }
                    }
                }
                for (int index17 = 0; index17 < GameScr.vNpc.size(); index17++) {
                    Npc npc18;
                    if ((npc18 = (Npc) GameScr.vNpc.elementAt(index17)).statusMe != 15 && value1 <= npc18.cx && npc18.cx <= value2 && value3 <= npc18.cy && npc18.cy <= value4) {
                        this.focus.addElement(npc18);
                        if (this.npcFocus != null && npc18.equals(this.npcFocus)) {
                            value = this.focus.size();
                        }
                    }
                }
                if (this.focus.size() <= 0) {
                    this.mobFocus = null;
                    this.deFocusNPC();
                    this.charFocus = null;
                    this.itemFocus = null;
                    isManualFocus = false;
                    return;
                }
                if (value >= this.focus.size()) {
                    value = 0;
                }
                if (this.focus.elementAt(value) instanceof Char) {
                    this.mobFocus = null;
                    this.deFocusNPC();
                    this.charFocus = (Char) this.focus.elementAt(value);
                    this.itemFocus = null;
                    isManualFocus = true;
                    return;
                }
                if (this.focus.elementAt(value) instanceof Npc) {
                    this.mobFocus = null;
                    this.deFocusNPC();
                    this.npcFocus = (Npc) this.focus.elementAt(value);
                    this.charFocus = null;
                    this.itemFocus = null;
                    isManualFocus = true;
                    return;
                }
                if (this.focus.elementAt(value) instanceof Mob) {
                    this.mobFocus = (Mob) this.focus.elementAt(value);
                    this.deFocusNPC();
                    this.charFocus = null;
                    this.itemFocus = null;
                    isManualFocus = true;
                    return;
                }
                if (this.focus.elementAt(value) instanceof ItemMap) {
                    this.mobFocus = null;
                    this.deFocusNPC();
                    this.charFocus = null;
                    this.itemFocus = (ItemMap) this.focus.elementAt(value);
                    isManualFocus = true;
                    return;
                }
            }
        }
    }

    public final void deFocusNPC() {
        if (this.me && this.npcFocus != null) {
            this.npcFocus.chatPopup = null;
            this.npcFocus = null;
        }
    }

    private void updateCharInBridge() {
        if (!GameCanvas.lowGraphic) {
            if (TileMap.tileTypeAt(this.cx, this.cy + 1, 1024)) {
                TileMap.setTileTypeAtPixel(this.cx, this.cy + 1, 512);
                TileMap.setTileTypeAtPixel(this.cx, this.cy - 2, 512);
            }
            if (TileMap.tileTypeAt(this.cx - TileMap.size, this.cy + 1, 512)) {
                TileMap.killTileTypeAt(this.cx - TileMap.size, this.cy + 1, 512);
                TileMap.killTileTypeAt(this.cx - TileMap.size, this.cy - 2, 512);
            }
            if (TileMap.tileTypeAt(this.cx + TileMap.size, this.cy + 1, 512)) {
                TileMap.killTileTypeAt(this.cx + TileMap.size, this.cy + 1, 512);
                TileMap.killTileTypeAt(this.cx + TileMap.size, this.cy - 2, 512);
            }
        }
    }

    public final void itemMonToBag(Message msg) {
        try {
            this.readParam(msg);
            getMyChar().eff5BuffHp = msg.reader().readShort();
            getMyChar().eff5BuffMp = msg.reader().readShort();
            int unsignedByte = msg.reader().readUnsignedByte();
            Item item;
            (item = this.arrItemMounts[unsignedByte]).typeUI = 3;
            this.arrItemMounts[unsignedByte] = null;
            item.indexUI = msg.reader().readUnsignedByte();
            this.arrItemBag[item.indexUI] = item;
            if (unsignedByte == 4) {
                this.isNewMount = this.isWolf = this.isMoto = this.isMotoBehind = false;
            }
            GameScr.isPaintItemInfo = false;
            GameScr.gI().setLCR();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public final void itemBodyToBag(Message msg) {
        try {
            this.readParam(msg);
            getMyChar().eff5BuffHp = msg.reader().readShort();
            getMyChar().eff5BuffMp = msg.reader().readShort();
            Item item;
            (item = this.arrItemBody[msg.reader().readUnsignedByte()]).typeUI = 3;
            if (item.indexUI == 1) {
                this.wp = 15;
            } else if (item.indexUI == 2) {
                this.setDefaultBody();
            } else if (item.indexUI == 6) {
                this.setDefaultLeg();
            }
            this.arrItemBody[item.indexUI] = null;
            item.indexUI = msg.reader().readUnsignedByte();
            getMyChar().head = msg.reader().readShort();
            this.arrItemBag[item.indexUI] = item;
            GameScr.gI().left = GameScr.gI().center = null;
            GameScr.gI().setLCR();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Char.itemBodyToBag()");
        }
    }

    public final void itemBagToBox(Message msg) {
        try {
            int unsignedByte = msg.reader().readUnsignedByte();
            int unsignedByte1 = msg.reader().readUnsignedByte();
            Item item;
            if ((item = this.arrItemBag[unsignedByte]) != null) {
                if (item.template.type == 16) {
                    GameScr.hpPotion = GameScr.hpPotion - item.quantity;
                }
                if (item.template.type == 17) {
                    GameScr.mpPotion = GameScr.mpPotion - item.quantity;
                }
                this.arrItemBag[unsignedByte] = null;
                if (this.arrItemBox[unsignedByte1] == null) {
                    item.indexUI = unsignedByte1;
                    item.typeUI = 4;
                    this.arrItemBox[unsignedByte1] = item;
                } else {
                    this.arrItemBox[unsignedByte1].quantity = this.arrItemBox[unsignedByte1].quantity + item.quantity;
                }
            }
            GameScr.gI().left = GameScr.gI().center = null;
            GameScr.gI().updateKeyBuyItemUI();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Char.itemBagToBox()");
        }
    }

    public final void itemBoxToBag(Message msg) {
        try {
            int unsignedByte = msg.reader().readUnsignedByte();
            int unsignedByte1 = msg.reader().readUnsignedByte();
            Item item;
            if ((item = this.arrItemBox[unsignedByte]) != null) {
                if (item.template.type == 16) {
                    GameScr.hpPotion = GameScr.hpPotion + item.quantity;
                }
                if (item.template.type == 17) {
                    GameScr.mpPotion = GameScr.mpPotion + item.quantity;
                }
                this.arrItemBox[unsignedByte] = null;
                if (this.arrItemBag[unsignedByte1] == null) {
                    item.indexUI = unsignedByte1;
                    item.typeUI = 3;
                    this.arrItemBag[unsignedByte1] = item;
                } else {
                    this.arrItemBag[unsignedByte1].quantity = this.arrItemBag[unsignedByte1].quantity + item.quantity;
                }
            }
            GameScr.gI().left = GameScr.gI().center = null;
            GameScr.gI().updateKeyBuyItemUI();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("Char.itemBoxToBag()");
        }
    }

    public static void crystalCollect(Message msg, boolean isCoin) {
        try {
            for (int index = 0; index < GameScr.arrItemUpPeal.length; index++) {
                GameScr.arrItemUpPeal[index] = null;
            }
            byte byteValue = msg.reader().readByte();
            Item item;
            (item = new Item()).typeUI = 3;
            item.indexUI = msg.reader().readByte();
            item.template = ItemTemplates.get(msg.reader().readShort());
            item.isLock = msg.reader().readBoolean();
            item.isExpires = msg.reader().readBoolean();
            item.quantity = 1;
            if (isCoin) {
                getMyChar().xu = msg.reader().readInt();
            } else {
                getMyChar().yen = msg.reader().readInt();
                try {
                    getMyChar().xu = msg.reader().readInt();
                } catch (Exception exception) {
                }
            }
            GameScr.arrItemUpPeal[0] = item;
            GameScr.effUpok = GameScr.efs[53];
            GameScr.indexEff = 0;
            GameScr.gI().left = GameScr.gI().center = null;
            GameScr.gI().updateCommandForUI();
            GameCanvas.endDlg();
            if (byteValue == 1) {
                InfoMe.addInfo(mResources.UPGRADE_SUCCESS + " " + item.template.name);
            } else {
                InfoMe.addInfo(mResources.UPGRADE + " " + ItemTemplates.get((short) (item.template.id + 1)).name + " " + mResources.UPGRADE_FAIL + " " + item.template.name, 25, mFont.tahoma_7_red);
            }
        } catch (Exception exception1) {
            exception1.printStackTrace();
            System.out.println("Char.itemBagToBox()");
        }
    }

    private static void kickOption(Item item, int maxKick) {
        int value = 0;
        if (item != null && item.options != null) {
            for (int index = 0; index < item.options.size(); index++) {
                ItemOption itemOption;
                (itemOption = (ItemOption) item.options.elementAt(index)).active = 0;
                if (itemOption.optionTemplate.type == 2) {
                    if (value < maxKick) {
                        itemOption.active = 1;
                        value++;
                    }
                } else if (itemOption.optionTemplate.type == 3 && item.upgrade >= 4) {
                    itemOption.active = 1;
                } else if (itemOption.optionTemplate.type == 4 && item.upgrade >= 8) {
                    itemOption.active = 1;
                } else if (itemOption.optionTemplate.type == 5 && item.upgrade >= 12) {
                    itemOption.active = 1;
                } else if (itemOption.optionTemplate.type == 6 && item.upgrade >= 14) {
                    itemOption.active = 1;
                } else if (itemOption.optionTemplate.type == 7 && item.upgrade >= 16) {
                    itemOption.active = 1;
                }
            }
        }
    }

    public final void updateKickOption() {
        int value = 2;
        int value1 = 2;
        int value2 = 2;
        if (this.arrItemBody[0] == null) {
            value--;
        }
        if (this.arrItemBody[6] == null) {
            value--;
        }
        if (this.arrItemBody[5] == null) {
            value--;
        }
        kickOption(this.arrItemBody[0], value);
        kickOption(this.arrItemBody[6], value);
        kickOption(this.arrItemBody[5], value);
        if (this.arrItemBody[2] == null) {
            value1--;
        }
        if (this.arrItemBody[8] == null) {
            value1--;
        }
        if (this.arrItemBody[7] == null) {
            value1--;
        }
        kickOption(this.arrItemBody[2], value1);
        kickOption(this.arrItemBody[8], value1);
        kickOption(this.arrItemBody[7], value1);
        if (this.arrItemBody[4] == null) {
            value2--;
        }
        if (this.arrItemBody[3] == null) {
            value2--;
        }
        if (this.arrItemBody[9] == null) {
            value2--;
        }
        if (this.arrItemBody[1] != null) {
            if (this.arrItemBody[1].sys == this.getSys()) {
                if (this.arrItemBody[1].options != null) {
                    for (int index = 0; index < this.arrItemBody[1].options.size(); index++) {
                        ItemOption itemOption;
                        if ((itemOption = (ItemOption) this.arrItemBody[1].options.elementAt(index)).optionTemplate.type == 2) {
                            itemOption.active = 1;
                        }
                    }
                }
            } else if (this.arrItemBody[1].options != null) {
                for (int index3 = 0; index3 < this.arrItemBody[1].options.size(); index3++) {
                    ItemOption itemOption4;
                    if ((itemOption4 = (ItemOption) this.arrItemBody[1].options.elementAt(index3)).optionTemplate.type == 2) {
                        itemOption4.active = 0;
                    }
                }
            }
        }
        kickOption(this.arrItemBody[4], value2);
        kickOption(this.arrItemBody[3], value2);
        kickOption(this.arrItemBody[9], value2);
    }

    public final void doInjure(int HPShow, int MPShow, boolean isBoss, int idBoss) {
        this.cHP -= HPShow;
        this.cMP -= MPShow;
        if (!this.me) {
            this.cHP = this.cHpNew;
        }
        if (this.cHP < 0) {
            this.cHP = 0;
        }
        if (this.cMP < 0) {
            this.cMP = 0;
        }
        if (this.cHP < 1 && this.statusMe != 14 && this.statusMe != 5) {
            this.cHP = 1;
        }
        if (HPShow <= 0) {
            if (this.me) {
                GameScr.startFlyText("", this.cx, this.cy - this.ch, 0, -2, 7);
            } else {
                GameScr.startFlyText("", this.cx, this.cy - this.ch, 0, -2, 4);
            }
        } else {
            GameScr.startFlyText("-" + HPShow, this.cx, this.cy - this.ch, 0, -2, 0);
        }
        if (HPShow > 0) {
            this.isInjure = 4;
        }
        if (isBoss) {
            if (idBoss == 114) {
                ServerEffect.addServerEffect(32, this.cx, this.cy - this.chh, 1);
                return;
            }
            if (idBoss == 115) {
                ServerEffect.addServerEffect(85, this.cx, this.cy, 1);
                return;
            }
            if (idBoss == 139) {
                GameScr.shaking = 1;
                GameScr.count = 0;
                ServerEffect.addServerEffect(91, this, 2);
                return;
            }
            if (idBoss == 144) {
                ServerEffect.addServerEffect(91, this, 1);
                return;
            }
        } else {
            this.callEff(49);
        }
    }

    private void startDie(short toX, short toY) {
        if (this.me) {
            isLockKey = true;
            for (int index = 0; index < GameScr.vCharInMap.size(); index++) {
                ((Char) GameScr.vCharInMap.elementAt(index)).killCharId = -9999;
            }
        }
        this.statusMe = 5;
        this.cp2 = toX;
        this.cp3 = toY;
        this.cp1 = 0;
        this.cHP = 0;
        this.testCharId = -9999;
        this.killCharId = -9999;
    }

    public final void waitToDie(short shortValue, short shortValue1) {
        this.wdx = shortValue;
        this.wdy = shortValue1;
    }

    private void changeStatusStand() {
        this.timeBocdau = 0;
        this.statusMe = 1;
        this.timeSummon = System.currentTimeMillis();
    }

    public final void liveFromDead() {
        this.cHP = this.cMaxHP;
        this.cMP = this.cMaxMP;
        this.changeStatusStand();
        this.cp1 = this.cp2 = this.cp3 = 0;
        ServerEffect.addServerEffect(20, this, 2);
        GameScr.gI().center = null;
    }

    public final boolean doUsePotion(int type) {
        if (this.arrItemBag == null) {
            return false;
        }
        for (int index = 0; index < this.arrItemBag.length; index++) {
            if (this.arrItemBag[index] != null && this.arrItemBag[index].template.type == type && this.arrItemBag[index].template.level <= myChar.clevel) {
                Service.gI().useItem(index);
                return true;
            }
        }
        return false;
    }

    private static boolean isLang() {
        return TileMap.mapID == 1 || TileMap.mapID == 27 || TileMap.mapID == 72 || TileMap.mapID == 10 || TileMap.mapID == 17 || TileMap.mapID == 22 || TileMap.mapID == 32 || TileMap.mapID == 38 || TileMap.mapID == 43 || TileMap.mapID == 48;
    }

    public final boolean isMeCanAttackOtherPlayer(Char cAtt) {
        if (cAtt != null && cAtt.isNhanban) {
            return false;
        }
        if (cAtt != null && getMyChar().myskill != null && getMyChar().myskill.template.type != 2 && getMyChar().myskill.template.type != 3 && (getMyChar().myskill.template.type != 4 || cAtt.statusMe == 14 || cAtt.statusMe == 5)) {
            if (getMyChar().cTypePk == 7 && (cAtt.cTypePk == 6 || cAtt.cTypePk == 4 || cAtt.cTypePk == 5) || getMyChar().cTypePk == 6 && (cAtt.cTypePk == 7 || cAtt.cTypePk == 4 || cAtt.cTypePk == 5) || getMyChar().cTypePk == 4 && (cAtt.cTypePk == 7 || cAtt.cTypePk == 5 || cAtt.cTypePk == 6) || getMyChar().cTypePk == 5 && (cAtt.cTypePk == 7 || cAtt.cTypePk == 4 || cAtt.cTypePk == 6)) {
                getMyChar();
                if (!isTeam(cAtt) && !isLang()) {
                    return cAtt.statusMe != 14 && cAtt.statusMe != 5;
                }
            }
            if (cAtt.cTypePk == 3) {
                getMyChar();
                if (!isTeam(cAtt) && !isLang()) {
                    return cAtt.statusMe != 14 && cAtt.statusMe != 5;
                }
            }
            if (getMyChar().cTypePk == 3) {
                getMyChar();
                if (!isTeam(cAtt) && !isLang()) {
                    return cAtt.statusMe != 14 && cAtt.statusMe != 5;
                }
            }
            if (getMyChar().cTypePk == 1 && cAtt.cTypePk == 1) {
                getMyChar();
                if (!isTeam(cAtt) && !isLang()) {
                    return cAtt.statusMe != 14 && cAtt.statusMe != 5;
                }
            }
            return (getMyChar().testCharId < 0 || getMyChar().testCharId != cAtt.charID) && (getMyChar().killCharId < 0 || getMyChar().killCharId != cAtt.charID || isLang()) && (cAtt.killCharId < 0 || cAtt.killCharId != getMyChar().charID || isLang()) ? false : cAtt.statusMe != 14 && cAtt.statusMe != 5;
        } else {
            return false;
        }
    }

    private static boolean isTeam(Char c) {
        for (int index = 0; index < GameScr.vParty.size(); index++) {
            Party party = (Party) GameScr.vParty.elementAt(index);
            if (c.charID == party.charId) {
                return true;
            }
        }
        return false;
    }

    public static void clearTask() {
        getMyChar().callEffTask(21);
        getMyChar().taskMaint = null;
        for (int index = 0; index < getMyChar().arrItemBag.length; index++) {
            if (getMyChar().arrItemBag[index] != null && (getMyChar().arrItemBag[index].template.type == 25 || getMyChar().arrItemBag[index].template.type == 23 || getMyChar().arrItemBag[index].template.type == 24)) {
                getMyChar().arrItemBag[index] = null;
            }
        }
        Npc.clearEffTask();
    }

    public static int getCT() {
        if (pointChienTruong >= 4000) {
            return 4;
        } else if (pointChienTruong >= 1500) {
            return 3;
        } else if (pointChienTruong >= 600) {
            return 2;
        } else {
            return pointChienTruong >= 200 ? 1 : 0;
        }
    }

    public final boolean isHumanz() {
        return this.isHuman;
    }

    public final boolean isNhanbanz() {
        return this.isNhanban;
    }

    public final void GetNewMount() {
        this.frameMount = (int[][]) CharPartInfo.newMount.get(String.valueOf(this.arrItemMounts[4].template.id));
    }

    public final boolean isHaveNewMount() {
        return this.ID_HORSE > -1 ? false : this.arrItemMounts != null && this.arrItemMounts[4] != null && this.arrItemMounts[4].template != null && this.arrItemMounts[4].template.id != 443 && this.arrItemMounts[4].template.id != 523 && this.arrItemMounts[4].template.id != 485 && this.arrItemMounts[4].template.id != 524;
    }

    private void updNewMount() {
        if (this.ID_HORSE <= -1 && this.isNewMount && this.frameMount != null) {
            this.tickNewMount++;
            if (this.isMotoBehind) {
                this.fNewMount = 5;
            } else if (this.statusMe == 1 || this.statusMe == 6) {
                this.fNewMount = 0;
                this.tickNewMount = GameCanvas.gameTick % 20 > 12 ? 1 : 0;
                if (this.ID_PP > -1) {
                    this.tickNewMount = this.cf;
                }
                this.dyMount = this.tickNewMount;
            } else if (this.statusMe == 2 || this.statusMe == 10) {
                this.fNewMount = 1;
                int value = this.frameMount[this.fNewMount].length / 3;
                if (this.tickNewMount < value) {
                    this.dyMount = 0;
                } else if (this.tickNewMount < value << 1) {
                    this.dyMount = 1;
                } else {
                    this.dyMount = 2;
                }
            } else if (this.statusMe == 3) {
                this.fNewMount = 2;
            } else if (this.statusMe == 4) {
                this.fNewMount = 3;
            } else if (this.statusMe == 14) {
                this.fNewMount = 4;
            }
            if (this.tickNewMount > this.frameMount[this.fNewMount].length - 1) {
                this.tickNewMount = 0;
            }
        }
    }

    private void paintBehindNewMount(mGraphics g) {
        byte byteValue = 2;
        if (this.cdir == 1) {
            byteValue = 0;
        }
        SmallImage.drawSmallImage(g, this.frameMount[this.fNewMount][this.tickNewMount], this.cx, this.cy, byteValue, 33);
    }

    private void paintNewMount(mGraphics graphics, Part part, Part part1, int[] values) {
        byte byteValue = 2;
        byte byteValue2 = 24;
        if (this.cdir == 1) {
            byteValue = 0;
            byteValue2 = 0;
        }
        if (part != null) {
            SmallImage.drawSmallImage(graphics, part.pi[CharInfo[this.cf][3][0]].id, this.cx + (CharInfo[this.cf][3][1] + part.pi[CharInfo[this.cf][3][0]].dx) * this.cdir, this.cy - CharInfo[this.cf][3][2] + part.pi[CharInfo[this.cf][3][0]].dy - 10 + this.dyMount, byteValue, byteValue2);
        }
        if (values != null && this.ID_PP == -1) {
            SmallImage.drawSmallImage(graphics, values[this.tickCoat], this.cx + this.hdx + (this.dxBody + -7) * this.cdir, this.cy - SmallImage.getHeight(this.getLegId()) - 19 + this.dyBody + this.dyMount, byteValue, 17);
        }
        byte byteValue3 = -4;
        if (this.cdir == 1) {
            byteValue3 = 4;
        }
        SmallImage.drawSmallImage(graphics, this.frameMount[this.fNewMount][this.tickNewMount], this.cx, this.cy, byteValue, 33);
        if (this.ID_Body > -1) {
            this.paintBody(graphics, this.cx + byteValue3 + this.getxs(), this.cy - 18 + this.dyMount - this.getys(), 1);
        } else {
            SmallImage.drawSmallImage(graphics, this.getBodyPaintId(), this.cx + this.hdx + this.dxBody * this.cdir, this.cy - SmallImage.getHeight(this.getLegId()) - 9 + this.dyBody + this.dyMount, byteValue, 33);
        }
        if (this.ID_HAIR > -1) {
            this.paintHair(graphics, this.cx + byteValue3 + this.getxs(), this.cy - 18 + this.dyMount - this.getys(), 1);
        } else {
            SmallImage.drawSmallImage(graphics, this.getHeadId(), this.cx + this.hdx + this.dxHead * this.cdir, this.cy - CharInfo[0][0][2] + part1.pi[CharInfo[0][0][0]].dy - 12 + this.dyHead + this.dyMount, byteValue, 17);
        }
        if (this.ID_MAT_NA > -1) {
            this.paintMatna(graphics, this.cx + byteValue3 + this.getxs(), this.cy - 18 + this.dyMount - this.getys(), 1);
        }
    }

    public final void setThoiTrang(short[] arr1) {
        this.ID_HAIR = arr1[0];
        this.ID_Body = arr1[1];
        this.ID_LEG = arr1[2];
        this.ID_WEA_PONE = arr1[3];
        this.ID_PP = arr1[4];
        this.ID_NAME = arr1[5];
        this.ID_HORSE = arr1[6];
        this.ID_RANK = arr1[7];
        this.ID_MAT_NA = arr1[8];
        this.ID_Bien_Hinh = arr1[9];
        this.ColorName = 0;
        if (this.ID_NAME > 3000) {
            this.ColorName = (byte) (this.ID_NAME - 3000);
            this.ID_NAME = -1;
        }
    }
}
