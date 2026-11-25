package nso;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Image;
import main.GameCanvas;
import main.GameMidlet;

public final class GameScr extends mScreen implements IActionListener {

    public static GameScr instance;

    public static int gW;

    public static int gH;

    public static int gW2;

    private static int gssw;

    private static int gssh;

    public static int gH23;

    public static int gH2;

    private static int csPadMaxH;

    public static int cmdBarH;

    public static int gW6;

    public static int cmx;

    public static int cmy;

    private static int cmdx;

    private static int cmdy;

    private static int cmvx;

    private static int cmvy;

    public static int cmtoX;

    public static int cmtoY;

    private static int cmxLim;

    private static int cmyLim;

    public static int gssx;

    public static int gssy;

    public static int gssxe;

    public static int gssye;

    public static MyVector VecTime = new MyVector();

    private Command cmdBag;

    private Command cmdSkill;

    private Command cmdTiemnang;

    private Command cmdtrangbi;

    private Command cmdInfo;

    private Command cmdFocus;

    private Command cmdBijuu;

    private Command cmdTrangbi2;

    public static int mpPotion;

    public static int hpPotion;

    public static SkillPaint[] sks;

    public static Arrowpaint[] arrs;

    public static Part[] parts;

    public static EffectCharPaint[] efs;

    private int idTypeTask = 0;

    private boolean isShortcut = false;

    public static MyVector vMobSoul = new MyVector();

    public static MyVector vClan = new MyVector();

    public static MyVector vParty = new MyVector();

    public static MyVector vPtMap = new MyVector();

    public static MyVector vFriend = new MyVector();

    public static MyVector vList = new MyVector();

    public static MyVector vFriendWait = new MyVector();

    public static MyVector vEnemies = new MyVector();

    public static MyVector vCharInMap = new MyVector();

    public static MyVector vItemMap = new MyVector();

    public static MyVector vMobAttack = new MyVector();

    public static MyVector vSet = new MyVector();

    public static MyVector vMob = new MyVector();

    public static MyVector vNpc = new MyVector();

    public static MyVector vBuNhin = new MyVector();

    private static MyVector vLanterns = new MyVector();

    public static NClass[] nClasss;

    private static int indexSize = 28;

    private static int indexTitle = 0;

    public static int indexSelect = 0;

    public static int indexRow = -1;

    private static int indexRowMax;

    public static int indexMenu = 0;

    public static int indexCard = -1;

    private Item itemFocus;

    public static ItemOptionTemplate[] iOptionTemplates;

    public static SkillOptionTemplate[] sOptionTemplates;

    private static Scroll scrInfo = new Scroll();

    public static Scroll scrMain = new Scroll();

    public static Item[] arrItemNonNam;

    public static Item[] arrItemNonNu;

    public static Item[] arrItemAoNam;

    public static Item[] arrItemAoNu;

    public static Item[] arrItemGangTayNam;

    public static Item[] arrItemGangTayNu;

    public static Item[] arrItemQuanNam;

    public static Item[] arrItemQuanNu;

    public static Item[] arrItemGiayNam;

    public static Item[] arrItemGiayNu;

    public static Item[] arrItemLien;

    public static Item[] arrItemNhan;

    public static Item[] arrItemNgocBoi;

    public static Item[] arrItemPhu;

    public static Item[] arrItemWeapon;

    public static Item[] arrItemStack;

    public static Item[] arrItemStackLock;

    public static Item[] arrItemGrocery;

    public static Item[] arrItemGroceryLock;

    public static Item[] arrItemStore;

    public static Item[] arrItemElites;

    public static Item[] arrItemClanShop;

    public static Item[] arrItemBook;

    public static Item[] arrItemFashion;

    public static Item[] arrItemUpPeal;

    public static Item[] arrItemUpGrade;

    public static Item[] arrItemSplit;

    public static Item[] arrItemTradeMe;

    public static Item[] arrItemTradeOrder;

    public static Item[] arrItemConvert;

    public static ItemStands[] arrItemStands;

    public static short[] arrItemSprin;

    public int numSprinLeft;

    public static Item itemUpGrade;

    public static Item itemSplit;

    public static Item itemSell;

    private static boolean isTypeXu;

    private static boolean isViewNext;

    private static boolean isViewClanMemOnline = false;

    private static boolean isSortClanByPointWeek = false;

    public static boolean isViewClanInvite = true;

    private static boolean isChop;

    public static boolean isMessageMenu = false;

    private static boolean isPaintRankedList = false;

    public static boolean isPaintAuctionSale = false;

    public static boolean isPaintAlert = false;

    private static boolean isPaintTask = false;

    private static boolean isPaintTeam = false;

    private static boolean isPaintFindTeam = false;

    public static boolean isPaintFriend = false;

    private static boolean isPaintList = false;

    private static boolean isPaintEnemies = false;

    public static boolean isPaintItemInfo = false;

    private static boolean isPaintSelectSkill = false;

    public static boolean isPaintInfoMe = false;

    private static boolean isPaintStore = false;

    private static boolean isPaintEliteShop = false;

    private static boolean isPaintNonNam = false;

    private static boolean isPaintNonNu = false;

    private static boolean isPaintAoNam = false;

    private static boolean isPaintAoNu = false;

    private static boolean isPaintGangTayNam = false;

    private static boolean isPaintGangTayNu = false;

    private static boolean isPaintQuanNam = false;

    private static boolean isPaintQuanNu = false;

    private static boolean isPaintGiayNam = false;

    private static boolean isPaintGiayNu = false;

    private static boolean isPaintLien = false;

    private static boolean isPaintNhan = false;

    private static boolean isPaintNgocBoi = false;

    private static boolean isPaintPhu = false;

    private static boolean isPaintWeapon = false;

    private static boolean isPaintStack = false;

    private static boolean isPaintStackLock = false;

    private static boolean isPaintGrocery = false;

    private static boolean isPaintGroceryLock = false;

    private static boolean isPaintUpGrade = false;

    private static boolean isPaintConvert = false;

    private static boolean isPaintUpGradeGold = false;

    private static boolean isPaintUpPearl = false;

    private static boolean isPaintBox = false;

    private static boolean isPaintSplit = false;

    private static boolean isPaintCharInMap = false;

    public static boolean isPaintTrade = false;

    private static boolean isPaintZone = false;

    public static boolean isPaintAuto = false;

    public static boolean isPaintMessage = false;

    private static boolean isPaintClan = false;

    private static boolean isRequestMember = false;

    private static boolean isPaintLuckySpin = false;

    private static boolean isPaintAuctionBuy = false;

    private static boolean isPaintLuyenThach;

    private static boolean isPaintTinhluyen;

    private static boolean isPaintDichChuyen;

    private static boolean isPaintLuyenNgoc;

    private static boolean isPaintKhamNgoc;

    private static boolean isPaintGotNgoc;

    private static boolean isPaintThaoNgoc;

    private static boolean isPaintLucky_Draw = false;

    private static boolean isPaintGiaoDo = false;

    private static boolean isPaintCheDo = false;

    public static Char currentCharViewInfo;

    public static long[] exps;

    public static int[] crystals;

    public static int[] upClothe;

    public static int[] upAdorn;

    public static int[] upWeapon;

    public static int[] coinUpCrystals;

    public static int[] coinUpClothes;

    public static int[] coinUpAdorns;

    public static int[] coinUpWeapons;

    public static int[] maxPercents;

    public static int[] goldUps;

    private static int[] coinGotngoc = new int[] { 0, 5000, 40000, 135000, 320000, 625000, 1080000, 1715000, 2560000, 3645000, 5000000 };

    private int zoneCol = 6;

    private int[] zones;

    private int[] pts;

    public int typeTrade = 0;

    public int typeTradeOrder = 0;

    public int coinTrade = 0;

    public int coinTradeOrder = 0;

    public int timeTrade = 0;

    private int typeSortPrice = 0;

    private int typeSortLevel = 0;

    private int typeSortName = 0;

    private int indexItemUse = -1;

    public int cLastFocusID = -1;

    public int cPreFocusID = -1;

    private boolean isLockKey;

    public static byte[][] tasks;

    public static byte[][] mapTasks;

    private MyVector texts;

    private String textsTitle;

    private TField tfText = null;

    public static byte vcData;

    public static byte vcMap;

    public static byte vcSkill;

    public static byte vcItem;

    public static byte vsData;

    public static byte vsMap;

    public static byte vsSkill;

    public static byte vsItem;

    private static Image imgTopBar;

    private static Image imgTransparent;

    private static Image imgArrow;

    private static Image imgArrow2;

    private static Image imgChat;

    private static Image imgMenu;

    private static Image imgFocus;

    private static Image imgButton;

    private static Image imgButton2;

    private static Image imgHpp;

    private static Image imgMpp;

    private static Image imgRight;

    private static Image imgRight2;

    private static Image imgSkill;

    public static Image imgTf = GameCanvas.loadImage("/hd/tf.png");

    public static Image imgMapBorder;

    public static Image imgLbtn;

    public static Image imgLbtnFocus;

    private static Image imgSelect = GameCanvas.loadImage("/u/select.png");

    public static Image imgMatcho;

    public static Image imgFiremoto;

    public String tradeName = "";

    public String tradeItemName = "";

    public int timeLengthMap;

    public int timeStartMap;

    private static byte typeViewInfo = 0;

    public static byte typeActive = 0;

    private int[] xM = new int[2];

    private int[] yM = new int[2];

    private int[] xMounts;

    private int[] yMounts;

    public long timePoint;

    public String[] YenCards = new String[] { "10000", "20000", "30000", "50000", "100000", "200000", "500000", "1000000", "5000000" };

    public int yenTemp;

    public int typeba;

    public String[] yenValue;

    public static MyVector vItemTreeFront = new MyVector();

    public static MyVector vItemTreeBehind = new MyVector();

    public static MyVector vItemTreeBetwen = new MyVector();

    public static Image imgEggMonters = GameCanvas.loadImage("/trung1.png");

    public static Image imgEffMob = GameCanvas.loadImage("/eff/g132.png");

    public static Image imgEffMob1 = GameCanvas.loadImage("/eff/g10.png");

    public static Image imgEffMob2 = GameCanvas.loadImage("/eff/g6.png");

    public static Image imgEffMob3 = GameCanvas.loadImage("/eff/g99.png");

    public static Image imgsmokeFollow = GameCanvas.loadImage("/eff/g9.png");

    public static boolean isUseitemAuto = false;

    public static boolean isAllmap = false;

    private static Skill[] keySkill;

    private static Skill[] onScreenSkill;

    private Command menu;

    private Command cmdPotentialAdd;

    private Command cmdSkillUp;

    private Command cmdAddFriend;

    private Command cmdBijuuAddPoint;

    private Command cmdBijuuSkillUp;

    private static byte menuCooldown;

    static int shaking;

    static int count;

    private long lastFire;

    public static int auto;

    public boolean lockAutoMove = false;

    private int nSkill = 0;

    private int selectedIndexSkill = -1;

    private long lastSendUpdatePostion;

    private int runArrow = 0;

    private static int hMiniMap;

    private static int yTouchBar;

    private static int xL;

    private static int yL;

    private static int xC;

    private static int yC;

    private static int xR;

    private static int yR;

    private static int xF;

    private static int yF;

    private static int xU;

    private static int yU;

    private static int xHP;

    private static int yHP;

    private static int xMP;

    private static int yMP;

    private static int xTG;

    private static int yTG;

    private static int[] xS;

    private static int[] yS;

    private static int xSkill;

    private static int ySkill;

    private static int padSkill;

    private static String[] flyTextString;

    private static int[] flyTextX;

    private static int[] flyTextY;

    private static int[] flyTextDx;

    private static int[] flyTextDy;

    private static int[] flyTextState;

    private static int[] flyTextColor;

    private static int[] splashX;

    private static int[] splashY;

    private static int[] splashState;

    private static int[] splashF;

    private static int[] splashDir;

    private static Image[] imgSplash;

    private static int cmdBarX;

    private static int cmdBarY;

    private static int cmdBarW;

    private static int cmdBarLeftWidth;

    private static int cmdBarRightWidth;

    private static int cmdBarFillWidth;

    private static int hpBarX;

    private static int hpBarY;

    private static int hpBarW;

    private static int mpBarW;

    private static int expBarW;

    private static int mpBarHeight;

    private static Image[] imgCmdBar;

    public static int popupY;

    public static int popupX;

    private static int indextabTrangbi;

    private static boolean unusedInterfaceFlag;

    private int indexMember;

    private String[] arrClanInfo;

    private String[] arrClanDongGop;

    private int indexTiemNang;

    private Command cmdGiaoDoMoveOut;

    private Command cmdTradeLock;

    private Command cmdTradeAccept;

    private Command cmdKhamNgocMoveOut_Ngoc;

    private Command cmdKhamNgocMoveOut_Item;

    private Command cmdKhamNgocMoveOut_Stone;

    private Command cmdUpgradeMoveOut;

    private Command cmdConvertMoveOut;

    private Command cmdSplitMoveOut;

    private Command cmdTradeSendMoney;

    private Command cmdTradeMoveOut;

    private Command cmdTradeViewItemInfo;

    private Command cmdTradeSelectItem;

    private Command cmdTradeSelectInBag;

    private Command cmdTradeSelectInList;

    private Command cmdCloseAll;

    private Command cmdEliteShopBuy;

    private Command cmdEliteShopView;

    private Command cmdStoreBuy;

    private Command cmdStoreView;

    private Command cmdClanStoreBuy;

    private Command cmdClanStoreView;

    private Command cmdStoreLockBuy;

    private Command cmdStoreLockView;

    private Command cmdStoreFashionBuy;

    private Command cmdStoreFashionView;

    private Command cmdNonNamBuy;

    private Command cmdNonNamView;

    private Command cmdNonNuBuy;

    private Command cmdNonNuView;

    private Command cmdAoNamBuy;

    private Command cmdAoNamView;

    private Command cmdAoNuBuy;

    private Command cmdAoNuView;

    private Command cmdGangTayNamBuy;

    private Command cmdGangTayNamView;

    private Command cmdGangTayNuBuy;

    private Command cmdGangTayNuView;

    private String alertURL;

    private String fnick;

    private static int xstart;

    private static int ystart;

    public static int popupW;

    public static int popupH;

    private static int scrollOffset;

    private static int scrollTarget;

    private static int scrollRemainder;

    private static int scrollVelocity;

    private static int columns;

    private static int rows;

    private int yPaint;

    private int[] color;

    private int[][] colorBorder;

    private int[] size;

    private static String Name_store;

    public static int indexEff;

    public static EffectCharPaint effUpok;

    private static int inforX;

    private static int inforY;

    private static int inforW;

    private static int inforH;

    public Command cmdDead;

    private Command cmdBagUseItem;

    private Command cmdBagSortItem;

    private Command cmdItemInfoClose;

    private Command cmdBagThrowItem;

    private Command cmdBagSplitItem;

    private Command cmdBagViewItemInfo;

    private Command cmdBagSelectItem;

    public static String svTitle;

    public static String svAction;

    private int Hitem;

    private int cardReportStep;

    private String strErrCard;

    private long timeLastBuff;

    private static long lastAutoMove;

    private static int index;

    private static int[] fardistandsX;

    private static int[] fardistandsY;

    private static boolean isItemNearMe;

    public static int pointCenterX;

    public static int pointCenterY;

    public static int rangeSearch;

    private short timeLucky_Draw;

    private short percentWin1Lucky_Draw;

    private short numPlayerLucky_Draw;

    private String timeC;

    private String totalMoneyLucky_Draw;

    private String percentWin2Lucky_Draw;

    private String winnerInfoLucky_Draw;

    private String myMoneyLucky_Draw;

    private long timeStart;

    private boolean isRefresh;

    public static byte typeLucky_Draw;

    private mFont fnt;

    private byte[] arrowCaptcha;

    private byte indexThanThu;

    private MyVector clan_thanthu;

    private int xThanThu;

    private int yThanThu;

    private int wThanThu;

    private int hThanThu;

    private int xExpThanThu;

    private int yExpThanThu;

    private int wExpThanThu;

    private int hExpThanThu;

    private int xSelectThanThu;

    private int ySelectThanThu;

    private int wSelectThanThu;

    private int xRecThanThu;

    private int yRecThanThu;

    private int wRecThanThu;

    private int hRecThanThu;

    private int countSendRequests;

    private String strTime;

    private int[] craftSlotX;

    private int[] craftSlotY;

    private int selectedCraftSlot;

    private int[][] arrNgocKhamEXP;

    private static int indexBijuuMenu;

    static {
        new MyVector();
        (GameCanvas.imghealth = new Image[2])[0] = GameCanvas.loadImage("/m1.png");
        GameCanvas.imghealth[1] = GameCanvas.loadImage("/m2.png");
        GameCanvas.imgPlus12 = GameCanvas.loadImage("/plus12.png");
        GameCanvas.backitem = GameCanvas.loadImage("/Big4.png");
        if (GameCanvas.isTouch) {
            nso.GameScr.imgButton = GameCanvas.loadImage("/hd/button.png");
            nso.GameScr.imgButton2 = GameCanvas.loadImage("/hd/button2.png");
            nso.GameScr.imgHpp = GameCanvas.loadImage("/hd/hpp.png");
            nso.GameScr.imgMpp = GameCanvas.loadImage("/hd/mpp.png");
            nso.GameScr.imgRight = GameCanvas.loadImage("/hd/right.png");
            nso.GameScr.imgRight2 = GameCanvas.loadImage("/hd/right2.png");
            nso.GameScr.imgSkill = GameCanvas.loadImage("/hd/skill.png");
            nso.GameScr.imgLbtnFocus = GameCanvas.loadImage("/hd/btnlf.png");
            imgArrow = GameCanvas.loadImage("/hd/arrow.png");
            nso.GameScr.imgArrow2 = GameCanvas.loadImage("/hd/arrow2.png");
            nso.GameScr.imgChat = GameCanvas.loadImage("/hd/chat.png");
            nso.GameScr.imgFocus = GameCanvas.loadImage("/hd/focus.png");
            nso.GameScr.imgMenu = GameCanvas.loadImage("/hd/menu.png");
            nso.GameScr.imgTopBar = GameCanvas.loadImage("/hd/topbar.png");
            nso.GameScr.imgTransparent = GameCanvas.loadImage("/hd/transparent.png");
            nso.GameScr.imgMapBorder = GameCanvas.loadImage("/hd/mapborder.png");
            nso.GameScr.imgLbtn = GameCanvas.loadImage("/hd/btnl.png");
        }
        nso.GameScr.imgMatcho = GameCanvas.loadImage("/hd/mat.png");
        nso.GameScr.imgFiremoto = GameCanvas.loadImage("/hd/lua.png");
        byte[] var0 = RMS.loadRMS("dataVersion");
        byte[] var1 = RMS.loadRMS("mapVersion");
        byte[] var2 = RMS.loadRMS("skillVersion");
        byte[] var3 = RMS.loadRMS("itemVersion");
        if (var0 != null) {
            nso.GameScr.vcData = var0[0];
        }
        if (var1 != null) {
            nso.GameScr.vcMap = var1[0];
        }
        if (var2 != null) {
            nso.GameScr.vcSkill = var2[0];
        }
        if (var3 != null) {
            nso.GameScr.vcItem = var3[0];
        }
        keySkill = new Skill[3];
        onScreenSkill = new Skill[5];
        count = 0;
        nso.GameScr.flyTextX = new int[5];
        nso.GameScr.flyTextY = new int[5];
        nso.GameScr.flyTextDx = new int[5];
        nso.GameScr.flyTextDy = new int[5];
        flyTextState = new int[5];
        flyTextString = new String[5];
        nso.GameScr.flyTextColor = new int[8];
        for (int var4 = 0; var4 < 5; var4++) {
            flyTextState[var4] = -1;
        }
        nso.GameScr.unusedInterfaceFlag = false;
        popupW = 140;
        popupH = 160;
        columns = 6;
        Name_store = "Shop Online";
        new MyVector();
        indexEff = 0;
        nso.GameScr.svTitle = "";
        nso.GameScr.svAction = "";
        nso.GameScr.isItemNearMe = false;
        typeLucky_Draw = 0;
        indexBijuuMenu = 0;
    }

    public static long getMaxExp(int level) {
        long longValue = 0L;
        for (int index = 0; index <= level; index++) {
            longValue += exps[index];
        }
        return longValue;
    }

    public static void resetAllvector() {
        vCharInMap.removeAllElements();
        vItemMap.removeAllElements();
        vMobSoul.removeAllElements();
        Effect2.vEffect2.removeAllElements();
        Effect2.vAnimateEffect.removeAllElements();
        Effect2.vEffect2Outside.removeAllElements();
        nso.GameScr.vMobAttack.removeAllElements();
        nso.GameScr.vSet.removeAllElements();
        vMob.removeAllElements();
        vNpc.removeAllElements();
        vBuNhin.removeAllElements();
        Char.getMyChar().vMovePoints.removeAllElements();
    }

    public static void loadSkillShortcut() {
        Service.gI().loadRMS("KSkill");
        Service.gI().loadRMS("OSkill");
        Service.gI().loadRMS("CSkill");
    }

    public static void loadSkillShortcutNhanban() {
        Service.gI().loadRMS("KSkill");
        Service.gI().loadRMS("OSkill");
        Service.gI().loadRMS("CSkill");
    }

    public final void onOSkill(byte[] oSkillID) {
        onScreenSkill = new Skill[5];
        if (oSkillID == null) {
            for (int index = 0; index < onScreenSkill.length && index < Char.getMyChar().vSkillFight.size(); index++) {
                Skill skill = (Skill) Char.getMyChar().vSkillFight.elementAt(index);
                onScreenSkill[index] = skill;
            }
            saveOnScreenSkillToRMS();
        } else {
            for (int index1 = 0; index1 < oSkillID.length; index1++) {
                for (int index2 = 0; index2 < Char.getMyChar().vSkillFight.size(); index2++) {
                    Skill skill3;
                    if ((skill3 = (Skill) Char.getMyChar().vSkillFight.elementAt(index2)).template.id == oSkillID[index1]) {
                        onScreenSkill[index1] = skill3;
                        break;
                    }
                }
            }
        }
    }

    public final void onKSkill(byte[] kSkillID) {
        keySkill = new Skill[3];
        if (kSkillID == null) {
            for (int index = 0; index < keySkill.length && index < Char.getMyChar().vSkillFight.size(); index++) {
                Skill skill = (Skill) Char.getMyChar().vSkillFight.elementAt(index);
                keySkill[index] = skill;
            }
            saveKeySkillToRMS();
        } else {
            for (int index1 = 0; index1 < kSkillID.length; index1++) {
                for (int index2 = 0; index2 < Char.getMyChar().vSkillFight.size(); index2++) {
                    Skill skill3;
                    if ((skill3 = (Skill) Char.getMyChar().vSkillFight.elementAt(index2)).template.id == kSkillID[index1]) {
                        keySkill[index1] = skill3;
                        break;
                    }
                }
            }
        }
    }

    public final void onCSkill(byte[] cSkillID) {
        if (cSkillID != null && cSkillID.length != 0) {
            for (int index = 0; index < Char.getMyChar().vSkillFight.size(); index++) {
                Skill skill;
                if ((skill = (Skill) Char.getMyChar().vSkillFight.elementAt(index)).template.id == cSkillID[0]) {
                    Char.getMyChar().myskill = skill;
                    Char.getMyChar().lastNormalSkill = skill;
                    break;
                }
            }
        } else if (Char.getMyChar().vSkillFight.size() > 0) {
            Char.getMyChar().myskill = (Skill) Char.getMyChar().vSkillFight.elementAt(0);
        }
        if (Char.getMyChar().myskill != null) {
            Service.gI().selectSkill(Char.getMyChar().myskill.template.id);
            Char.getMyChar();
        }
    }

    private static void doSetOnScreenSkill(SkillTemplate skillTemplate) {
        Skill skill = Char.getMyChar().getSkill(skillTemplate);
        MyVector entries = new MyVector();
        for (int index = 0; index < 5; index++) {
            boolean flag = false;
            if (onScreenSkill[index] == null) {
                flag = true;
            }
            Object[] values;
            (values = new Object[2])[0] = skill;
            values[1] = String.valueOf(index);
            entries.addElement(new Command(mResources.CELLS + " " + (index + 1), 11120, values));
            if (flag) {
                break;
            }
        }
        GameCanvas.menu.startAt(entries);
    }

    private static void doSetKeySkill(SkillTemplate skillTemplate) {
        Skill skill = Char.getMyChar().getSkill(skillTemplate);
        String[] textLines = TField.isQwerty ? mResources.KEY_QWERTY : mResources.KEY_T9;
        MyVector entries = new MyVector();
        for (int index = 0; index < 3; index++) {
            Object[] values;
            (values = new Object[2])[0] = skill;
            values[1] = String.valueOf(index);
            entries.addElement(new Command(textLines[index], 11121, values));
        }
        GameCanvas.menu.startAt(entries);
    }

    private static void saveOnScreenSkillToRMS() {
        byte[] data = new byte[onScreenSkill.length];
        for (int index = 0; index < onScreenSkill.length; index++) {
            if (onScreenSkill[index] == null) {
                data[index] = -1;
            } else {
                data[index] = onScreenSkill[index].template.id;
            }
        }
        if (Char.getMyChar().isHumanz()) {
            Service.gI().saveRms("OSkill", data, (byte) 0);
        } else {
            Service.gI().saveRms("OSkill", data, (byte) 1);
        }
    }

    private static void saveKeySkillToRMS() {
        byte[] data = new byte[keySkill.length];
        for (int index = 0; index < keySkill.length; index++) {
            if (keySkill[index] == null) {
                data[index] = -1;
            } else {
                data[index] = keySkill[index].template.id;
            }
        }
        if (Char.getMyChar().isHumanz()) {
            Service.gI().saveRms("KSkill", data, (byte) 0);
        } else {
            Service.gI().saveRms("KSkill", data, (byte) 1);
        }
    }

    public final void addSkillShortcut(Skill skill) {
        if (skill.template.type != 0) {
            for (int index = 0; index < onScreenSkill.length; index++) {
                if (onScreenSkill[index] == null) {
                    onScreenSkill[index] = skill;
                    break;
                }
            }
            for (int index1 = 0; index1 < keySkill.length; index1++) {
                if (keySkill[index1] == null) {
                    keySkill[index1] = skill;
                    break;
                }
            }
            if (Char.getMyChar().myskill == null) {
                Char.getMyChar().myskill = skill;
            }
            saveKeySkillToRMS();
            saveOnScreenSkillToRMS();
        }
    }

    public static boolean isBagFull() {
        for (int index = Char.getMyChar().arrItemBag.length - 1; index >= 0; index--) {
            if (Char.getMyChar().arrItemBag[index] == null) {
                return false;
            }
        }
        return true;
    }

    public static void createMenu(String[] menu1, Npc npc) {
        MyVector entries = new MyVector();
        for (int index = 0; index < menu1.length; index++) {
            entries.addElement(new Command(menu1[index], 11057, npc));
        }
        GameCanvas.menu.startAt(entries);
    }

    private void doBag() {
        currentCharViewInfo = Char.getMyChar();
        indexMenu = 0;
        this.doMiniMenuInforMe();
    }

    private void doskill() {
        currentCharViewInfo = Char.getMyChar();
        indexMenu = 1;
        this.doMiniMenuInforMe();
    }

    private void doTiemnangMe() {
        currentCharViewInfo = Char.getMyChar();
        indexMenu = 2;
        this.doMiniMenuInforMe();
    }

    private void doInfo() {
        currentCharViewInfo = Char.getMyChar();
        indexMenu = 3;
        this.doMiniMenuInforMe();
    }

    private void doTrangbi() {
        currentCharViewInfo = Char.getMyChar();
        indexMenu = 4;
        this.doMiniMenuInforMe();
    }

    private void doThucuoi() {
        currentCharViewInfo = Char.getMyChar();
        indexMenu = 5;
        this.doMiniMenuInforMe();
    }

    private void doBiJuu() {
        currentCharViewInfo = Char.getMyChar();
        indexMenu = 6;
        indexBijuuMenu = 0;
        this.doMiniMenuInforMe();
    }

    private void doBiJuu_Point() {
        currentCharViewInfo = Char.getMyChar();
        indexMenu = 6;
        indexBijuuMenu = 1;
        this.doMiniMenuInforMe();
    }

    private void doBiJuu_Skill() {
        currentCharViewInfo = Char.getMyChar();
        indexMenu = 6;
        indexBijuuMenu = 2;
        this.doMiniMenuInforMe();
    }

    public static void readPart() {
        DataInputStream dataInputStream = null;
        try {
            short shortValue;
            parts = new Part[shortValue = (dataInputStream = new DataInputStream(new ByteArrayInputStream(RMS.loadRMS("nj_part")))).readShort()];
            for (int index = 0; index < shortValue; index++) {
                byte byteValue = dataInputStream.readByte();
                parts[index] = new Part(byteValue);
                for (int index1 = 0; index1 < parts[index].pi.length; index1++) {
                    parts[index].pi[index1] = new PartImage();
                    parts[index].pi[index1].id = dataInputStream.readShort();
                    parts[index].pi[index1].dx = dataInputStream.readByte();
                    parts[index].pi[index1].dy = dataInputStream.readByte();
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                dataInputStream.close();
            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public static void readEfect() {
        DataInputStream dataInputStream = null;
        try {
            short shortValue;
            efs = new EffectCharPaint[shortValue = (dataInputStream = new DataInputStream(new ByteArrayInputStream(RMS.loadRMS("nj_effect")))).readShort()];
            for (int index = 0; index < shortValue; index++) {
                efs[index] = new EffectCharPaint();
                efs[index].idEf = dataInputStream.readShort();
                efs[index].arrEfInfo = new EffectInfoPaint[dataInputStream.readByte()];
                for (int index1 = 0; index1 < efs[index].arrEfInfo.length; index1++) {
                    efs[index].arrEfInfo[index1] = new EffectInfoPaint();
                    efs[index].arrEfInfo[index1].idImg = dataInputStream.readShort();
                    efs[index].arrEfInfo[index1].dx = dataInputStream.readByte();
                    efs[index].arrEfInfo[index1].dy = dataInputStream.readByte();
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                dataInputStream.close();
            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public static void readArrow() {
        DataInputStream dataInputStream = null;
        try {
            short shortValue;
            arrs = new Arrowpaint[shortValue = (dataInputStream = new DataInputStream(new ByteArrayInputStream(RMS.loadRMS("nj_arrow")))).readShort()];
            for (int index = 0; index < shortValue; index++) {
                arrs[index] = new Arrowpaint();
                dataInputStream.readShort();
                arrs[index].imgId[0] = dataInputStream.readShort();
                arrs[index].imgId[1] = dataInputStream.readShort();
                arrs[index].imgId[2] = dataInputStream.readShort();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                dataInputStream.close();
            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public static void readSkill() {
        DataInputStream dataInputStream = null;
        try {
            short shortValue = (dataInputStream = new DataInputStream(new ByteArrayInputStream(RMS.loadRMS("nj_skill")))).readShort();
            int value = 0;
            for (int index = 0; index < nClasss.length; index++) {
                value += nClasss[index].skillTemplates.length;
            }
            sks = new SkillPaint[value];
            for (int index1 = 0; index1 < shortValue; index1++) {
                short shortValue2 = dataInputStream.readShort();
                sks[shortValue2] = new SkillPaint();
                sks[shortValue2].effId = dataInputStream.readShort();
                dataInputStream.readByte();
                sks[shortValue2].skillStand = new SkillInfoPaint[dataInputStream.readByte()];
                for (int index3 = 0; index3 < sks[shortValue2].skillStand.length; index3++) {
                    sks[shortValue2].skillStand[index3] = new SkillInfoPaint();
                    sks[shortValue2].skillStand[index3].status = dataInputStream.readByte();
                    sks[shortValue2].skillStand[index3].effS0Id = dataInputStream.readShort();
                    sks[shortValue2].skillStand[index3].e0dx = dataInputStream.readShort();
                    sks[shortValue2].skillStand[index3].e0dy = dataInputStream.readShort();
                    sks[shortValue2].skillStand[index3].effS1Id = dataInputStream.readShort();
                    sks[shortValue2].skillStand[index3].e1dx = dataInputStream.readShort();
                    sks[shortValue2].skillStand[index3].e1dy = dataInputStream.readShort();
                    sks[shortValue2].skillStand[index3].effS2Id = dataInputStream.readShort();
                    sks[shortValue2].skillStand[index3].e2dx = dataInputStream.readShort();
                    sks[shortValue2].skillStand[index3].e2dy = dataInputStream.readShort();
                    sks[shortValue2].skillStand[index3].arrowId = dataInputStream.readShort();
                    sks[shortValue2].skillStand[index3].adx = dataInputStream.readShort();
                    sks[shortValue2].skillStand[index3].ady = dataInputStream.readShort();
                }
                sks[shortValue2].skillfly = new SkillInfoPaint[dataInputStream.readByte()];
                for (int index4 = 0; index4 < sks[shortValue2].skillfly.length; index4++) {
                    sks[shortValue2].skillfly[index4] = new SkillInfoPaint();
                    sks[shortValue2].skillfly[index4].status = dataInputStream.readByte();
                    sks[shortValue2].skillfly[index4].effS0Id = dataInputStream.readShort();
                    sks[shortValue2].skillfly[index4].e0dx = dataInputStream.readShort();
                    sks[shortValue2].skillfly[index4].e0dy = dataInputStream.readShort();
                    sks[shortValue2].skillfly[index4].effS1Id = dataInputStream.readShort();
                    sks[shortValue2].skillfly[index4].e1dx = dataInputStream.readShort();
                    sks[shortValue2].skillfly[index4].e1dy = dataInputStream.readShort();
                    sks[shortValue2].skillfly[index4].effS2Id = dataInputStream.readShort();
                    sks[shortValue2].skillfly[index4].e2dx = dataInputStream.readShort();
                    sks[shortValue2].skillfly[index4].e2dy = dataInputStream.readShort();
                    sks[shortValue2].skillfly[index4].arrowId = dataInputStream.readShort();
                    sks[shortValue2].skillfly[index4].adx = dataInputStream.readShort();
                    sks[shortValue2].skillfly[index4].ady = dataInputStream.readShort();
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                dataInputStream.close();
            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public static void setLevel_Exp(long exp, boolean value) {
        int value1;
        long longValue = exp;
        boolean flag = false;
        for (value1 = 0; value1 < exps.length && longValue >= exps[value1]; value1++) {
            longValue -= exps[value1];
        }
        long[] values = new long[] { value1, longValue };
        Char.getMyChar().clevel = (int) values[0];
        Char.getMyChar().cExpR = values[1];
    }

    public static GameScr gI() {
        if (instance == null) {
            instance = new GameScr();
        }
        return instance;
    }

    public static void clearGameScr() {
        instance = null;
        arrItemTradeOrder = null;
        arrItemTradeMe = null;
        arrItemSplit = null;
        arrItemUpGrade = null;
        arrItemUpPeal = null;
        itemSplit = null;
        itemUpGrade = null;
    }

    public final void loadSplash() {
        if (nso.GameScr.imgSplash == null) {
            nso.GameScr.imgSplash = new Image[3];
            for (int index = 0; index < 3; index++) {
                nso.GameScr.imgSplash[index] = GameCanvas.loadImage("/e/sp" + index + ".png");
            }
        }
        nso.GameScr.splashX = new int[2];
        nso.GameScr.splashY = new int[2];
        splashState = new int[2];
        nso.GameScr.splashF = new int[2];
        nso.GameScr.splashDir = new int[2];
        splashState[0] = splashState[1] = -1;
        this.loadCmdBar();
        Res.init();
    }

    public GameScr() {
        int[] values = new int[] { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 };
        this.indexMember = 0;
        this.arrClanInfo = null;
        this.arrClanDongGop = null;
        this.indexTiemNang = 0;
        this.yPaint = 0;
        this.color = new int[] { 0, 0, 0, 0, 600841, 600841, 667658, 667658, 3346944, 3346688, 4199680, 5052928, 3276851, 3932211, 4587571, 5046280, 6684682, 3359744 };
        this.colorBorder = new int[][] { { 18687, 16869, 15052, 13235, 11161, 9344 }, { 45824, 39168, 32768, 26112, 19712, 13056 }, { 16744192, 15037184, 13395456, 11753728, 10046464, 8404992 }, { 13500671, 12058853, 10682572, 9371827, 7995545, 6684800 }, { 16711705, 15007767, 13369364, 11730962, 10027023, 8388621 } };
        this.size = new int[] { 2, 1, 1, 1, 1, 1 };
        this.cmdDead = new Command(mResources.DIES[0], 11038);
        this.Hitem = 30;
        this.cardReportStep = 0;
        this.strErrCard = "";
        this.fnt = mFont.tahoma_7b_yellow;
        this.arrowCaptcha = new byte[] { -1, -1, -1, -1, -1, -1 };
        this.indexThanThu = 0;
        this.clan_thanthu = new MyVector();
        this.strTime = "";
        this.arrNgocKhamEXP = new int[][] { new int[2], { 200, 10 }, { 500, 20 }, { 1000, 50 }, { 2000, 100 }, { 5000, 200 }, { 10000, 500 }, { 20000, 1000 }, { 50000, 2000 }, { 100000, 5000 }, { 100000, 10000 } };
        if (GameCanvas.w == 128 || GameCanvas.h <= 208) {
            indexSize = 20;
        }
        GameScr gameScr = this;
        this.cmdBijuuAddPoint = new Command(mResources.ADD, 5043);
        gameScr.cmdBijuuSkillUp = new Command(mResources.ADD, 5053);
        gameScr.cmdAddFriend = new Command(mResources.ACCEPT, 11002);
        gameScr.cmdSkillUp = new Command(mResources.ADD, 11003);
        gameScr.cmdGangTayNuView = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11004);
        gameScr.cmdGangTayNuBuy = new Command(mResources.BUY, 11005);
        gameScr.cmdPotentialAdd = new Command(mResources.ADD, 11006);
        gameScr.cmdGangTayNamView = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11007);
        gameScr.cmdGangTayNamBuy = new Command(mResources.BUY, 11008);
        gameScr.cmdAoNuView = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11009);
        gameScr.cmdAoNuBuy = new Command(mResources.BUY, 11010);
        gameScr.cmdAoNamView = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11011);
        gameScr.cmdAoNamBuy = new Command(mResources.BUY, 11012);
        gameScr.cmdNonNuView = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11013);
        gameScr.cmdNonNuBuy = new Command(mResources.BUY, 11014);
        gameScr.cmdNonNamView = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11015);
        gameScr.cmdNonNamBuy = new Command(mResources.BUY, 11016);
        gameScr.cmdStoreLockView = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11017);
        gameScr.cmdStoreFashionView = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 13001);
        gameScr.cmdStoreLockBuy = new Command(mResources.BUY, 11018);
        gameScr.cmdStoreFashionBuy = new Command(mResources.BUY, 13002);
        gameScr.cmdStoreView = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11019);
        gameScr.cmdStoreBuy = new Command(mResources.BUY, 11020);
        gameScr.cmdEliteShopBuy = new Command(mResources.BUY, 14022);
        gameScr.cmdEliteShopView = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 14023);
        gameScr.cmdClanStoreView = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 14018);
        gameScr.cmdClanStoreBuy = new Command(mResources.BUY, 14019);
        gameScr.cmdCloseAll = new Command(mResources.CLOSE, 11021);
        gameScr.cmdBagSelectItem = new Command(mResources.SELECT, 11022);
        gameScr.cmdBagViewItemInfo = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11023);
        gameScr.cmdBagThrowItem = new Command(mResources.THROW, 11024);
        gameScr.cmdBagSplitItem = new Command(mResources.SPLIT, 110244);
        gameScr.cmdItemInfoClose = new Command(mResources.CLOSE, 11025);
        gameScr.cmdBagUseItem = new Command(mResources.USE, 11026);
        gameScr.cmdBagSortItem = new Command(mResources.SORT, 110221);
        gameScr.cmdTradeSelectInList = new Command(mResources.SELECT, 11027);
        gameScr.cmdTradeSelectInBag = new Command(mResources.SELECT, 11028);
        gameScr.cmdTradeSelectItem = new Command(mResources.SELECT, 11029);
        gameScr.cmdTradeViewItemInfo = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11030);
        new Command(mResources.BACK, 11021);
        gameScr.menu = new Command(mResources.MENU, 11000);
        gameScr.cmdFocus = new Command("Focus", 11001);
        gameScr.cmdTradeLock = new Command(mResources.LOCK1, 11032);
        gameScr.cmdTradeAccept = new Command(mResources.ACCEPT, 11033);
        gameScr.cmdUpgradeMoveOut = new Command(mResources.MOVEOUT, 11034);
        gameScr.cmdConvertMoveOut = new Command(mResources.MOVEOUT, 14014);
        gameScr.cmdSplitMoveOut = new Command(mResources.MOVEOUT, 11035);
        gameScr.cmdTradeSendMoney = new Command(mResources.SENDMONEY, 11036);
        gameScr.cmdTradeMoveOut = new Command(mResources.MOVEOUT, 11037);
        gameScr.cmdKhamNgocMoveOut_Ngoc = new Command(mResources.MOVEOUT, 339);
        gameScr.cmdKhamNgocMoveOut_Item = new Command(mResources.MOVEOUT, 340);
        gameScr.cmdKhamNgocMoveOut_Stone = new Command(mResources.MOVEOUT, 343);
        gameScr.cmdGiaoDoMoveOut = new Command(mResources.MOVEOUT, 402);
        new Command("240", 110381);
        new Command("360", 1103911);
        new Command("Toàn Map", 110401);
        gameScr.cmdTrangbi2 = new Command(mResources.tbi2, 2003);
        int value = GameCanvas.w / 2 - mScreen.cmdW / 2;
        int value1 = GameCanvas.h - 26;
        int value2 = value;
        Command command = gameScr.cmdTrangbi2;
        gameScr.cmdTrangbi2.x = value2;
        command.y = value1;
        if (GameCanvas.isTouch && GameCanvas.isTouchControl) {
            gameScr.menu.x = nso.GameScr.gW - 135;
            gameScr.menu.y = 6;
            gameScr.menu.img = nso.GameScr.imgMenu;
            gameScr.cmdFocus.x = nso.GameScr.gW;
            gameScr.cmdFocus.y = gH;
            if (GameCanvas.isTouchControlSmallScreen) {
                gameScr.menu.x = nso.GameScr.gW / 2 - 38;
                gameScr.menu.y = gH - 34;
            }
        }
        this.cmdFocus.img = GameCanvas.loadImage("/u/fc.png");
        super.left = this.menu;
        super.right = this.cmdFocus;
        if ((nso.GameScr.hMiniMap = GameCanvas.h / 5) > 100) {
            nso.GameScr.hMiniMap = 100;
        }
    }

    private void doCloseItemInfo() {
        if (!GameCanvas.isTouch || GameCanvas.isTouch && GameCanvas.w < 320 || isPaintInfoMe && indexMenu > 0 || isPaintClan && indexMenu == 0) {
            nso.GameScr.isPaintItemInfo = false;
        }
        nso.GameScr.isViewNext = false;
        if (isPaintUI()) {
            this.updateCommandForUI();
            super.right = this.cmdCloseAll;
        } else {
            this.setLCR();
        }
    }

    private void doUpPotential() {
        if (indexTitle > 0 && indexTitle <= 4 || GameCanvas.isTouch) {
            GameCanvas.inputDlg.show(mResources.INPUT_POINT, this.cmdPotentialAdd, 1);
        }
    }

    private void doUpSkill() {
        if (indexTitle > 0 && indexTitle <= 4) {
            GameCanvas.inputDlg.show(mResources.INPUT_POINT, this.cmdSkillUp, 1);
        }
    }

    private void doAddFriend() {
        if (isPaintFriend) {
            GameCanvas.inputDlg.show(mResources.BE_FRIEND_WITH, this.cmdAddFriend, 0);
        }
    }

    private void doMiniMenuInforMe() {
        isPaintInfoMe = true;
        setPopupSize(175, 200);
        this.setLCR();
        if (indexMenu == 3 && currentCharViewInfo.charID == Char.getMyChar().charID) {
            Service.gI().viewInfo(currentCharViewInfo.cName, 0);
        }
        if (indexMenu == 5) {
            this.xMounts = new int[5];
            this.yMounts = new int[5];
            nso.GameScr.xstart = popupX + 5;
            nso.GameScr.ystart = popupY + 35;
            this.xMounts[0] = nso.GameScr.xstart + 5;
            this.yMounts[0] = nso.GameScr.ystart + 35;
            this.xMounts[1] = nso.GameScr.xstart + 5;
            this.yMounts[1] = nso.GameScr.ystart + 70;
            this.xMounts[2] = nso.GameScr.xstart + 131;
            this.yMounts[2] = nso.GameScr.ystart + 35;
            this.xMounts[3] = nso.GameScr.xstart + 131;
            this.yMounts[3] = nso.GameScr.ystart + 70;
            this.xMounts[4] = this.xMounts[0] + indexSize + 7;
            this.yMounts[4] = this.yMounts[0] - 5;
        }
        if (indexMenu == 6) {
            this.xMounts = new int[5];
            this.yMounts = new int[5];
            nso.GameScr.xstart = popupX + 5;
            nso.GameScr.ystart = popupY + 35;
            this.xMounts[0] = nso.GameScr.xstart + 5;
            this.yMounts[0] = nso.GameScr.ystart + 35;
            this.xMounts[1] = nso.GameScr.xstart + 5;
            this.yMounts[1] = nso.GameScr.ystart + 70;
            this.xMounts[2] = nso.GameScr.xstart + 131;
            this.yMounts[2] = nso.GameScr.ystart + 35;
            this.xMounts[3] = nso.GameScr.xstart + 131;
            this.yMounts[3] = nso.GameScr.ystart + 70;
            this.xMounts[4] = this.xMounts[0] + indexSize + 7;
            this.yMounts[4] = this.yMounts[0] - 5;
        }
        super.right = new Command(mResources.BACK, 11060);
    }

    private void doMenuInforMe() {
        scrMain.clear();
        scrInfo.clear();
        nso.GameScr.isViewNext = false;
        this.cmdBag = new Command(mResources.MENUME[0], 1100011);
        this.cmdSkill = new Command(mResources.MENUME[1], 1100012);
        this.cmdTiemnang = new Command(mResources.MENUME[2], 1100013);
        this.cmdInfo = new Command(mResources.MENUME[3], 1100014);
        this.cmdtrangbi = new Command(mResources.MENUME[4], 1100015);
        this.cmdBijuu = new Command(mResources.MENUME[6], 1100017);
        MyVector entries;
        (entries = new MyVector()).addElement(this.cmdBag);
        entries.addElement(this.cmdSkill);
        entries.addElement(this.cmdTiemnang);
        entries.addElement(this.cmdInfo);
        entries.addElement(this.cmdtrangbi);
        entries.addElement(new Command(mResources.MENUME[5], 1100016));
        entries.addElement(this.cmdBijuu);
        GameCanvas.menu.startAt(entries);
    }

    private static void doMenusynthesis() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.SYNTHESIS[0], 110002));
        entries.addElement(new Command(mResources.SYNTHESIS[1], 1100032));
        entries.addElement(new Command(mResources.SYNTHESIS[2], 1100033));
        entries.addElement(new Command(mResources.Lucky_draw, 1100034));
        entries.addElement(new Command(mResources.CONFIG, LoginScr.mgI(), 1004, null));
        GameCanvas.menu.startAt(entries);
    }

    private static void actMenu() {
        if (nso.GameScr.menuCooldown <= 0) {
            Command command = new Command(mResources.MENUGAMESCR[1], 110001);
            Command command1 = new Command(mResources.MENUGAMESCR[3], 110003);
            Command command2 = new Command(mResources.MENUGAMESCR[4], 110004);
            new Command(mResources.MENUGAMESCR[0], 110005);
            Command command3 = new Command(mResources.MENUGAMESCR[6], 110006);
            new Command(mResources.MENUGAMESCR[7], 110007);
            new Command(mResources.MENUGAMESCR[8], 110008);
            new Command(mResources.MENUGAMESCR[9], 110009);
            new Command(mResources.MENUGAMESCR[10], 110010);
            new Command(mResources.MENUGAMESCR[11], 110011);
            new Command(mResources.MENUGAMESCR[12], 110012);
            new Command(mResources.MENUGAMESCR[13], 110013);
            new Command(mResources.MENUGAMESCR[14], 110014);
            new Command(mResources.MENUGAMESCR[15], 110015);
            new Command(mResources.MENUGAMESCR[16], 110016);
            new Command(mResources.MENUGAMESCR[17], 110017);
            Command command4 = new Command(mResources.MENUGAMESCR[18], 110018);
            Command command5 = new Command("Xác thực tài khoản", 1100181);
            Command command6 = new Command(mResources.xoataikhoan, 2025);
            MyVector entries = new MyVector();
            if (Char.getMyChar().clevel >= 3 && SelectServerScr.isVirtualAcc()) {
                entries.addElement(command5);
            }
            entries.addElement(command);
            entries.addElement(command1);
            entries.addElement(command3);
            entries.addElement(command4);
            entries.addElement(command6);
            entries.addElement(command2);
            GameCanvas.menu.startAt(entries);
        }
    }

    private void doShowTaskUI() {
        this.resetButton();
        isPaintTask = true;
        indexMenu = this.idTypeTask;
        this.isLockKey = true;
        setPopupSize(175, 200);
        super.right = this.cmdCloseAll;
        super.left = new Command(mResources.MENUGAMESCR[2], 110002);
        super.center = new Command(mResources.CHANGE, 110019);
    }

    private void doShowFindTeamUI() {
        this.resetButton();
        isPaintFindTeam = true;
        this.isLockKey = true;
        setPopupSize(175, 200);
        super.right = this.cmdCloseAll;
        Service.gI().openFindParty();
        this.refreshFindTeam();
    }

    private void doShowCharInMap() {
        this.resetButton();
        if (this.cLastFocusID > 0) {
            indexRow = Char.getIndexChar(this.cLastFocusID);
        } else {
            indexRow = 0;
            this.cLastFocusID = -1;
        }
        isPaintCharInMap = true;
        this.isLockKey = true;
        setPopupSize(175, 200);
        super.right = this.cmdCloseAll;
    }

    private void doShowTeamUI() {
        this.resetButton();
        isPaintTeam = true;
        this.isLockKey = true;
        setPopupSize(175, 200);
        super.right = this.cmdCloseAll;
        this.refreshTeam();
    }

    public final void doShowRankedListUI() {
        this.resetButton();
        isPaintRankedList = true;
        this.isLockKey = true;
        setPopupSize(175, 200);
        super.right = this.cmdCloseAll;
        super.left = super.center = null;
        indexRow = 0;
    }

    public final void doShowListUI() {
        this.resetButton();
        isPaintList = true;
        this.isLockKey = true;
        setPopupSize(175, 200);
        super.right = this.cmdCloseAll;
        super.left = super.center = null;
        indexRow = 0;
    }

    private void doShowFriendUI() {
        this.resetButton();
        isPaintFriend = true;
        this.isLockKey = true;
        setPopupSize(175, 200);
        super.right = this.cmdCloseAll;
        super.left = new Command(mResources.LIST, 11044);
        super.center = null;
        indexRow = 0;
        Service.gI().requestFriend();
    }

    private void doShowEnemiesUI() {
        this.resetButton();
        isPaintEnemies = true;
        this.isLockKey = true;
        setPopupSize(175, 200);
        super.right = this.cmdCloseAll;
        super.left = new Command(mResources.LIST, 14017);
        super.center = null;
        indexRow = 0;
        Service.gI().requestEnemies();
    }

    public final void refreshFindTeam() {
        if (isPaintFindTeam) {
            super.left = super.center = null;
            super.left = new Command(mResources.MENU, 11045);
            Party party;
            if (vPtMap.size() > 0 && indexRow >= 0 && indexRow < vPtMap.size() && (party = (Party) vPtMap.elementAt(indexRow)) != null && !Char.getMyChar().cName.equals(party.name)) {
                super.center = new Command(mResources.SELECT, 11046);
            }
        }
    }

    public final void refreshTeam() {
        if (isPaintTeam) {
            super.left = super.center = null;
            indexRow = 0;
            if (vParty.size() == 0) {
                super.center = null;
                super.left = new Command(mResources.MENU, 11047);
                return;
            }
            Party party;
            if ((party = (Party) vParty.firstElement()).charId == Char.getMyChar().charID) {
                super.left = new Command(mResources.TEAMLEADER, 11070, party);
                return;
            }
            super.left = new Command(mResources.OUT_TEAM, 11071);
        }
    }

    private static void doShowMap() {
        if (TileMap.typeMap != 1) {
            MapScr.gI().switchToMe();
        }
    }

    public final void openUIZone(Message message) {
        InfoDlg.hide();
        try {
            byte byteValue;
            if ((byteValue = message.reader().readByte()) > 0) {
                this.zones = new int[byteValue];
                this.pts = new int[this.zones.length];
                for (int index = 0; index < this.zones.length; index++) {
                    this.zones[index] = message.reader().readByte();
                    this.pts[index] = message.reader().readByte();
                }
                isPaintZone = true;
                indexSelect = TileMap.zoneID;
                setPopupSize(175, 200);
                super.left = new Command(mResources.SELECT, 11067);
                super.center = new Command("", 11067);
                super.right = this.cmdCloseAll;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public final void openUITrade() {
        try {
            this.resetButton();
            this.tradeItemName = "";
            this.typeTrade = 0;
            this.typeTrade = this.typeTradeOrder = this.coinTrade = this.coinTradeOrder = 0;
            isPaintTrade = true;
            arrItemTradeMe = new Item[12];
            arrItemTradeOrder = new Item[12];
            indexMenu = 0;
            setPopupSize(175, 200);
            super.right = this.cmdCloseAll;
        } catch (Exception exception) {
        }
    }

    public static final void loadCamera(boolean fullScreen) {
        nso.GameScr.gW = GameCanvas.w;
        if (!GameCanvas.isTouch || GameCanvas.isTouch && !GameCanvas.isTouchControl) {
            cmdBarH = 36;
            if (GameCanvas.isTouch) {
                cmdBarH += 3;
            }
        } else {
            cmdBarH = 8;
        }
        gH = GameCanvas.h - cmdBarH - 20;
        if (fullScreen) {
            gH = GameCanvas.h;
        }
        if (GameCanvas.isTouch && GameCanvas.isTouchControl) {
            gH = GameCanvas.h;
        }
        if (GameCanvas.h == 160) {
            gH = 150;
        }
        nso.GameScr.cmdBarW = nso.GameScr.gW;
        if (GameCanvas.w > 176) {
            nso.GameScr.cmdBarW -= 50;
        }
        nso.GameScr.cmdBarX = 0;
        nso.GameScr.cmdBarY = GameCanvas.h - Paint.hTab - cmdBarH;
        if ((csPadMaxH = GameCanvas.h / 6) < 48) {
            csPadMaxH = 48;
        }
        nso.GameScr.gW2 = nso.GameScr.gW >> 1;
        nso.GameScr.gH2 = gH >> 1;
        nso.GameScr.gH23 = 2 * gH / 3;
        nso.GameScr.gW6 = nso.GameScr.gW / 6;
        nso.GameScr.gssw = nso.GameScr.gW / TileMap.size + 2;
        nso.GameScr.gssh = gH / TileMap.size + 2;
        if (nso.GameScr.gW % 24 != 0) {
            nso.GameScr.gssw++;
        }
        nso.GameScr.cmxLim = (TileMap.tmw - 1) * TileMap.size - nso.GameScr.gW;
        nso.GameScr.cmyLim = (TileMap.tmh - 1) * TileMap.size - gH;
        if (GameCanvas.isTouch && GameCanvas.isTouchControl) {
            nso.GameScr.cmyLim += 60;
        }
        cmx = nso.GameScr.cmtoX = Char.getMyChar().cx - nso.GameScr.gW2 + nso.GameScr.gW6 * Char.getMyChar().cdir;
        cmy = nso.GameScr.cmtoY = Char.getMyChar().cy - nso.GameScr.gH23;
        if (cmx < 24) {
            cmx = 24;
        }
        if (cmx > nso.GameScr.cmxLim) {
            cmx = nso.GameScr.cmxLim;
        }
        if (cmy < 0) {
            cmy = 0;
        }
        if (cmy > nso.GameScr.cmyLim) {
            cmy = nso.GameScr.cmyLim;
        }
        if ((nso.GameScr.gssx = cmx / TileMap.size - 1) < 0) {
            nso.GameScr.gssx = 0;
        }
        nso.GameScr.gssy = cmy / TileMap.size;
        nso.GameScr.gssxe = nso.GameScr.gssx + nso.GameScr.gssw;
        nso.GameScr.gssye = nso.GameScr.gssy + nso.GameScr.gssh;
        if (nso.GameScr.gssy < 0) {
            nso.GameScr.gssy = 0;
        }
        if (nso.GameScr.gssye > TileMap.tmh - 1) {
            nso.GameScr.gssye = TileMap.tmh - 1;
        }
        if ((TileMap.countx = nso.GameScr.gssxe - nso.GameScr.gssx << 2) > TileMap.tmw) {
            TileMap.countx = TileMap.tmw;
        }
        if ((TileMap.county = nso.GameScr.gssye - nso.GameScr.gssy << 2) > TileMap.tmh) {
            TileMap.county = TileMap.tmh;
        }
        if ((TileMap.gssx = (Char.getMyChar().cx - 2 * nso.GameScr.gW) / TileMap.size) < 0) {
            TileMap.gssx = 0;
        }
        if ((TileMap.gssxe = TileMap.gssx + TileMap.countx) > TileMap.tmw) {
            TileMap.gssxe = TileMap.tmw;
        }
        if ((TileMap.gssy = (Char.getMyChar().cy - 2 * gH) / TileMap.size) < 0) {
            TileMap.gssy = 0;
        }
        if ((TileMap.gssye = TileMap.gssy + TileMap.county) > TileMap.tmh) {
            TileMap.gssye = TileMap.tmh;
        }
        ChatTextField.gI().parentScreen = instance;
        ChatTextField.gI().tfChat.y = GameCanvas.h - 35 - ChatTextField.gI().tfChat.height;
        if (GameCanvas.isTouch && (!GameCanvas.isTouch || GameCanvas.isTouchControl)) {
            TileMap.setPosMiniMap(GameCanvas.w - 60, 0, 60, 42);
        } else {
            TileMap.setPosMiniMap(GameCanvas.w - 51, nso.GameScr.cmdBarY - 4, 50, 40);
        }
        if (GameCanvas.isTouch) {
            nso.GameScr.yTouchBar = gH - 88;
            nso.GameScr.xC = nso.GameScr.gW - 100;
            nso.GameScr.yC = 2;
            if (GameCanvas.isTouchControlSmallScreen) {
                nso.GameScr.xC = nso.GameScr.gW / 2 - 2;
                nso.GameScr.yC = nso.GameScr.yTouchBar + 50;
            }
            nso.GameScr.xL = 1;
            nso.GameScr.yL = nso.GameScr.yTouchBar + 50;
            xR = 42;
            nso.GameScr.yR = nso.GameScr.yTouchBar + 50;
            nso.GameScr.xF = nso.GameScr.gW - 50;
            yF = nso.GameScr.yTouchBar + 35;
            xU = 22;
            nso.GameScr.yU = nso.GameScr.yTouchBar + 19;
            nso.GameScr.xHP = nso.GameScr.gW - 74;
            nso.GameScr.yHP = nso.GameScr.yTouchBar + 13;
            nso.GameScr.xMP = nso.GameScr.gW - 85;
            nso.GameScr.yMP = nso.GameScr.yTouchBar + 50;
            nso.GameScr.xTG = nso.GameScr.gW - 37;
            nso.GameScr.yTG = nso.GameScr.yTouchBar - 1;
            if (GameCanvas.w >= 450) {
                nso.GameScr.yU -= 15;
                xU += 28;
                xR += 45;
                nso.GameScr.xL += 10;
                nso.GameScr.yTG -= 12;
                nso.GameScr.yHP -= 7;
                nso.GameScr.xF -= 18;
                nso.GameScr.xTG -= 10;
                nso.GameScr.xHP -= 17;
                nso.GameScr.xMP -= 24;
            } else if (GameCanvas.w >= 360) {
                nso.GameScr.yU -= 5;
                xU += 6;
                xR += 12;
                nso.GameScr.yTG -= 2;
                nso.GameScr.yHP -= 2;
                nso.GameScr.xHP -= 2;
                nso.GameScr.xMP -= 2;
            }
        }
        nso.GameScr.xS = new int[onScreenSkill.length];
        nso.GameScr.yS = new int[onScreenSkill.length];
        if (GameCanvas.isTouch) {
            if (GameCanvas.isTouchControlSmallScreen) {
                xSkill = 2;
                ySkill = 55;
                nso.GameScr.padSkill = 5;
                for (int index = 0; index < nso.GameScr.xS.length; index++) {
                    nso.GameScr.xS[index] = index * (25 + nso.GameScr.padSkill);
                    nso.GameScr.yS[index] = ySkill;
                }
            } else {
                if (GameCanvas.w <= 320) {
                    xSkill = nso.GameScr.gW2 - onScreenSkill.length * 25 / 2 - 15;
                } else {
                    xSkill = nso.GameScr.gW2 - onScreenSkill.length * 25 / 2;
                }
                ySkill = nso.GameScr.yTouchBar + 58;
                nso.GameScr.padSkill = 5;
                for (int index1 = 0; index1 < nso.GameScr.xS.length; index1++) {
                    nso.GameScr.xS[index1] = index1 * (25 + nso.GameScr.padSkill);
                    nso.GameScr.yS[index1] = ySkill;
                }
            }
        } else {
            xSkill = 0;
            for (int index2 = 0; index2 < nso.GameScr.yS.length; index2++) {
                nso.GameScr.xS[index2] = 2;
                nso.GameScr.yS[index2] = 2 + index2 * 25;
            }
        }
    }

    private static boolean checkSkillValid() {
        if (Char.getMyChar().myskill != null && Char.getMyChar().cMP < Char.getMyChar().myskill.manaUse) {
            InfoMe.addInfo(mResources.NOT_ENOUGH_MP);
            return false;
        }
        if (Char.getMyChar().myskill != null && (Char.getMyChar().myskill.template.maxPoint <= 0 || Char.getMyChar().myskill.point != 0)) {
            if (Char.getMyChar().arrItemBody[1] == null) {
                GameCanvas.startOKDlg(mResources.WEAPON_EMPTY);
                return false;
            } else {
                return true;
            }
        } else {
            GameCanvas.startOKDlg(mResources.SKILL_FAIL);
            return false;
        }
    }

    public final void resetButton() {
        if (Char.getMyChar().arrItemBag != null) {
            if ((nso.GameScr.isPaintUpPearl || nso.GameScr.isPaintLuyenThach) && arrItemUpPeal != null) {
                for (int index = 0; index < arrItemUpPeal.length; index++) {
                    if (arrItemUpPeal[index] != null) {
                        Char.getMyChar().arrItemBag[arrItemUpPeal[index].indexUI] = arrItemUpPeal[index];
                        arrItemUpPeal[index] = null;
                    }
                }
            }
            if (nso.GameScr.isPaintUpGrade) {
                if (itemUpGrade != null) {
                    Char.getMyChar().arrItemBag[itemUpGrade.indexUI] = itemUpGrade;
                    itemUpGrade = null;
                }
                if (arrItemUpGrade != null) {
                    for (int index1 = 0; index1 < arrItemUpGrade.length; index1++) {
                        if (arrItemUpGrade[index1] != null) {
                            Char.getMyChar().arrItemBag[arrItemUpGrade[index1].indexUI] = arrItemUpGrade[index1];
                            arrItemUpGrade[index1] = null;
                        }
                    }
                }
            }
            if (nso.GameScr.isPaintKhamNgoc) {
                if (itemUpGrade != null) {
                    Char.getMyChar().arrItemBag[itemUpGrade.indexUI] = itemUpGrade;
                    itemUpGrade = null;
                }
                if (itemSplit != null) {
                    Char.getMyChar().arrItemBag[itemSplit.indexUI] = itemSplit;
                    itemSplit = null;
                }
                if (arrItemUpGrade != null) {
                    for (int index2 = 0; index2 < arrItemUpGrade.length; index2++) {
                        if (arrItemUpGrade[index2] != null) {
                            Char.getMyChar().arrItemBag[arrItemUpGrade[index2].indexUI] = arrItemUpGrade[index2];
                            arrItemUpGrade[index2] = null;
                        }
                    }
                }
            }
            if (nso.GameScr.isPaintGiaoDo && arrItemUpGrade != null) {
                for (int index3 = 0; index3 < arrItemUpGrade.length; index3++) {
                    if (arrItemUpGrade[index3] != null) {
                        Char.getMyChar().arrItemBag[arrItemUpGrade[index3].indexUI] = arrItemUpGrade[index3];
                        arrItemUpGrade[index3] = null;
                    }
                }
            }
            if (nso.GameScr.isPaintAuctionSale && itemSell != null) {
                Char.getMyChar().arrItemBag[itemSell.indexUI] = itemSell;
                itemSell = null;
            }
            if (nso.GameScr.isPaintConvert && arrItemConvert != null) {
                for (int index4 = 0; index4 < arrItemConvert.length; index4++) {
                    if (arrItemConvert[index4] != null) {
                        Char.getMyChar().arrItemBag[arrItemConvert[index4].indexUI] = arrItemConvert[index4];
                        arrItemConvert[index4] = null;
                    }
                }
            }
            if (nso.GameScr.isPaintSplit || nso.GameScr.isPaintDichChuyen || nso.GameScr.isPaintTinhluyen || nso.GameScr.isPaintLuyenNgoc || nso.GameScr.isPaintCheDo) {
                if (itemSplit != null) {
                    Char.getMyChar().arrItemBag[itemSplit.indexUI] = itemSplit;
                    itemSplit = null;
                }
                if (arrItemSplit != null) {
                    for (int index5 = 0; index5 < arrItemSplit.length; index5++) {
                        if (arrItemSplit[index5] != null) {
                            if (nso.GameScr.isPaintTinhluyen || nso.GameScr.isPaintDichChuyen || nso.GameScr.isPaintLuyenNgoc || nso.GameScr.isPaintCheDo) {
                                Char.getMyChar().arrItemBag[arrItemSplit[index5].indexUI] = arrItemSplit[index5];
                            }
                            arrItemSplit[index5] = null;
                        }
                    }
                }
            }
            if (nso.GameScr.isPaintGiaoDo && arrItemSplit != null) {
                for (int index6 = 0; index6 < arrItemSplit.length; index6++) {
                    if (arrItemSplit[index6] != null) {
                        Char.getMyChar().arrItemBag[arrItemSplit[index6].indexUI] = arrItemSplit[index6];
                        arrItemSplit[index6] = null;
                    }
                }
            }
            if (isPaintTrade) {
                InfoDlg.hide();
                if (this.coinTrade > 0) {
                    Char player = Char.getMyChar();
                    player.xu = player.xu + this.coinTrade;
                }
                if (arrItemTradeMe != null) {
                    for (int index7 = 0; index7 < arrItemTradeMe.length; index7++) {
                        if (arrItemTradeMe[index7] != null) {
                            Char.getMyChar().arrItemBag[arrItemTradeMe[index7].indexUI] = arrItemTradeMe[index7];
                            arrItemTradeMe[index7] = null;
                        }
                    }
                }
                if (arrItemTradeOrder != null) {
                    for (int index8 = 0; index8 < arrItemTradeOrder.length; index8++) {
                        arrItemTradeOrder[index8] = null;
                    }
                }
            }
            if ((nso.GameScr.isPaintGotNgoc || nso.GameScr.isPaintThaoNgoc) && itemSplit != null) {
                Char.getMyChar().arrItemBag[itemSplit.indexUI] = itemSplit;
                itemSplit = null;
            }
        }
        if (isPaintTrade) {
            Service.gI().cancelTrade();
        }
        GameCanvas.menu.showMenu = false;
        ChatTextField chatTextField;
        (chatTextField = ChatTextField.gI()).tfChat.setText("");
        chatTextField.isShow = false;
        ChatTextField.gI().center = null;
        if (!GameCanvas.isTouch) {
            isPaintSelectSkill = false;
        }
        nso.GameScr.isMessageMenu = false;
        isPaintUpGradeGold = false;
        this.isLockKey = false;
        isPaintZone = false;
        isPaintAuto = false;
        isPaintInfoMe = false;
        nso.GameScr.isPaintItemInfo = false;
        isPaintTask = false;
        isPaintTeam = false;
        isPaintMessage = false;
        isPaintClan = false;
        isPaintLuckySpin = false;
        isRequestMember = false;
        isPaintCharInMap = false;
        isPaintFindTeam = false;
        isPaintFriend = false;
        isPaintAuctionBuy = false;
        isPaintList = false;
        isPaintRankedList = false;
        isPaintEnemies = false;
        isPaintAlert = false;
        isPaintLucky_Draw = false;
        this.typeTrade = 0;
        isPaintStore = false;
        nso.GameScr.isPaintEliteShop = false;
        nso.GameScr.isPaintNonNam = false;
        nso.GameScr.isPaintNonNu = false;
        nso.GameScr.isPaintAoNam = false;
        nso.GameScr.isPaintAoNu = false;
        nso.GameScr.isPaintGangTayNam = false;
        nso.GameScr.isPaintGangTayNu = false;
        nso.GameScr.isPaintQuanNam = false;
        nso.GameScr.isPaintQuanNu = false;
        nso.GameScr.isPaintGiayNam = false;
        nso.GameScr.isPaintGiayNu = false;
        nso.GameScr.isPaintLien = false;
        nso.GameScr.isPaintNhan = false;
        nso.GameScr.isPaintNgocBoi = false;
        nso.GameScr.isPaintPhu = false;
        nso.GameScr.isPaintWeapon = false;
        nso.GameScr.isPaintStack = false;
        nso.GameScr.isPaintStackLock = false;
        nso.GameScr.isPaintGrocery = false;
        nso.GameScr.isPaintGroceryLock = false;
        nso.GameScr.isPaintUpGrade = false;
        nso.GameScr.isPaintAuctionSale = false;
        nso.GameScr.isPaintConvert = false;
        nso.GameScr.isPaintDichChuyen = false;
        nso.GameScr.isPaintTinhluyen = false;
        nso.GameScr.isPaintSplit = false;
        isPaintTrade = false;
        nso.GameScr.isPaintLuyenThach = false;
        nso.GameScr.isPaintUpPearl = false;
        nso.GameScr.isPaintBox = false;
        nso.GameScr.isPaintKhamNgoc = false;
        nso.GameScr.isPaintLuyenNgoc = false;
        nso.GameScr.isPaintCheDo = false;
        nso.GameScr.isPaintGiaoDo = false;
        nso.GameScr.isPaintGotNgoc = false;
        nso.GameScr.isPaintThaoNgoc = false;
        indexMenu = 0;
        indexSelect = 0;
        this.indexItemUse = -1;
        indexRow = -1;
        indexRowMax = 0;
        indexTitle = 0;
        this.typeTrade = this.typeTradeOrder = 0;
        super.left = this.menu;
        super.right = this.cmdFocus;
        this.xMounts = this.yMounts = null;
        super.center = null;
        if (Char.getMyChar().cHP <= 0 || Char.getMyChar().statusMe == 14 || Char.getMyChar().statusMe == 5) {
            if (GameCanvas.isTouchControlSmallScreen) {
                this.cmdDead.caption = "";
            }
            super.center = this.cmdDead;
        }
        scrMain.clear();
    }

    public final void keyPress(int keyCode) {
        if (this.tfText != null && this.tfText.isFocus) {
            this.tfText.keyPressed(keyCode);
        }
        super.keyPress(keyCode);
    }

    public final void updateKey() {
        if (!GameCanvas.menu.showMenu) {
            if (!InfoDlg.isLock) {
                if (GameCanvas.isTouch && !ChatTextField.gI().isShow && !GameCanvas.menu.showMenu) {
                    GameScr gameScr = this;
                    GameScr gameScr1 = this;
                    int value = -1;
                    if (GameCanvas.isPointerClick) {
                        for (int index = 0; index < gameScr1.xM.length; index++) {
                            if (GameCanvas.isPointerHoldIn(gameScr1.xM[index], gameScr1.yM[index], 100, 12) && GameCanvas.isPointerJustRelease) {
                                value = index;
                                break;
                            }
                        }
                    }
                    int value2 = value;
                    if (value != -1 && !isPaintPopup() && !isPaintUI() && !isOpenUI()) {
                        if (value2 != 0) {
                            if (ChatManager.isMessagePt) {
                                ChatManager.gI().switchToTab(1);
                            } else if (ChatManager.isMessageClan) {
                                ChatManager.gI().switchToTab(3);
                            }
                            gameScr.openUIChatTab();
                            gameScr.xM[1] = gameScr.yM[1] = -1;
                        } else if (ChatManager.gI().waitList.size() > 0) {
                            ChatManager chatManager = ChatManager.gI();
                            int value3 = 3;
                            int value4;
                            label1532: while (true) {
                                if (value3 >= chatManager.chatTabs.size()) {
                                    value4 = -1;
                                    break;
                                }
                                ChatTab chatTab = (ChatTab) chatManager.chatTabs.elementAt(value3);
                                for (int index5 = 0; index5 < chatManager.waitList.size(); index5++) {
                                    if (chatTab.ownerName.equals(chatManager.waitList.elementAt(index5).toString())) {
                                        value4 = value3;
                                        break label1532;
                                    }
                                }
                                value3++;
                            }
                            value = value4;
                            ChatManager.gI().switchToTab(value);
                            gameScr.openUIChatTab();
                            gameScr.xM[0] = gameScr.yM[0] = -1;
                        }
                    }
                    gameScr = this;
                    boolean flag = false;
                    mScreen.keyTouch = -1;
                    if (GameCanvas.isPointerHoldIn(TileMap.posMiniMapX, TileMap.posMiniMapY, TileMap.wMiniMap, TileMap.hMiniMap) && GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                        doShowMap();
                        flag = true;
                    }
                    if (GameCanvas.isTouch && (!GameCanvas.menu.showMenu || !GameCanvas.isTouchControlSmallScreen) && GameCanvas.currentDialog == null && ChatPopup.currentMultilineChatPopup == null && !GameCanvas.menu.showMenu && !isPaintPopup()) {
                        if (GameCanvas.isPointerHoldIn(nso.GameScr.xC, nso.GameScr.yC, 34, 34)) {
                            mScreen.keyTouch = 15;
                            if (GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                                ChatTextField.gI().showChat(mResources.PUBLICCHAT[0]);
                                flag = true;
                                GameCanvas.isPointerJustRelease = false;
                                GameCanvas.isPointerClick = false;
                            }
                        }
                        if (!gameScr.isNotPaintTouchControl()) {
                            if (!Char.getMyChar().isCaptcha) {
                                if (GameCanvas.isPointerHoldIn(xU, nso.GameScr.yU, 34, 34)) {
                                    mScreen.keyTouch = 3;
                                    GameCanvas.keyHold[2] = true;
                                    gameScr.resetAuto();
                                    flag = true;
                                } else if (GameCanvas.isPointerDown) {
                                    GameCanvas.keyHold[2] = false;
                                }
                                if (GameCanvas.isPointerHoldIn(xU - 30, nso.GameScr.yU, 30, 34)) {
                                    GameCanvas.keyHold[1] = true;
                                    gameScr.resetAuto();
                                    flag = true;
                                } else if (GameCanvas.isPointerDown) {
                                    GameCanvas.keyHold[1] = false;
                                }
                                if (GameCanvas.isPointerHoldIn(xU + 34, nso.GameScr.yU, 30, 34)) {
                                    GameCanvas.keyHold[3] = true;
                                    gameScr.resetAuto();
                                    flag = true;
                                } else if (GameCanvas.isPointerDown) {
                                    GameCanvas.keyHold[3] = false;
                                }
                                if (GameCanvas.isPointerHoldIn(nso.GameScr.xL, nso.GameScr.yL, 34, 34)) {
                                    mScreen.keyTouch = 4;
                                    GameCanvas.keyHold[4] = true;
                                    gameScr.resetAuto();
                                    flag = true;
                                } else if (GameCanvas.isPointerDown) {
                                    GameCanvas.keyHold[4] = false;
                                }
                                if (GameCanvas.isPointerHoldIn(xR - 5, nso.GameScr.yR, 40, 34)) {
                                    mScreen.keyTouch = 6;
                                    GameCanvas.keyHold[6] = true;
                                    gameScr.resetAuto();
                                    flag = true;
                                } else if (GameCanvas.isPointerDown) {
                                    GameCanvas.keyHold[6] = false;
                                }
                                if (GameCanvas.isPointerHoldIn(nso.GameScr.xF, yF, 54, 54)) {
                                    GameCanvas.keyHold[5] = true;
                                    mScreen.keyTouch = 5;
                                    if (GameCanvas.isPointerJustRelease) {
                                        GameCanvas.keyPressedz[5] = true;
                                        flag = true;
                                    }
                                }
                            } else {
                                GameScr gameScr6 = gameScr;
                                if (GameCanvas.isPointer(nso.GameScr.xL, nso.GameScr.yL, 34, 34) && GameCanvas.isPointerJustRelease) {
                                    gameScr6.doClickCaptcha((byte) 0);
                                    GameCanvas.clearKeyHold();
                                }
                                if (GameCanvas.isPointer(xU, nso.GameScr.yU, 34, 34) && GameCanvas.isPointerJustRelease) {
                                    gameScr6.doClickCaptcha((byte) 1);
                                    GameCanvas.clearKeyHold();
                                }
                                if (GameCanvas.isPointer(xR - 5, nso.GameScr.yR, 40, 34) && GameCanvas.isPointerJustRelease) {
                                    gameScr6.doClickCaptcha((byte) 2);
                                    GameCanvas.clearKeyHold();
                                }
                            }
                            if (Char.getMyChar().ctaskId > 1) {
                                if (GameCanvas.isPointerHoldIn(nso.GameScr.xMP, nso.GameScr.yMP, 34, 34)) {
                                    mScreen.keyTouch = 11;
                                    if (GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                                        GameCanvas.keyPressedz[11] = true;
                                        flag = true;
                                    }
                                }
                                if (GameCanvas.isPointerHoldIn(nso.GameScr.xHP, nso.GameScr.yHP, 34, 34)) {
                                    mScreen.keyTouch = 10;
                                    if (GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                                        GameCanvas.keyPressedz[10] = true;
                                        flag = true;
                                    }
                                }
                                if (GameCanvas.isPointerHoldIn(nso.GameScr.xTG, nso.GameScr.yTG, 34, 34)) {
                                    mScreen.keyTouch = 13;
                                    if (GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                                        GameCanvas.isPointerJustRelease = false;
                                        GameCanvas.isPointerClick = false;
                                        Char.getMyChar().findNextFocusByKey();
                                        flag = true;
                                    }
                                }
                            }
                            if (Char.getMyChar().vSkill.size() >= 2 && (GameCanvas.isPointerHoldIn(xSkill + nso.GameScr.xS[0], nso.GameScr.yS[0], onScreenSkill.length * 30, 30) || !GameCanvas.isTouchControl && GameCanvas.isPointerHoldIn(xSkill + nso.GameScr.xS[0], nso.GameScr.yS[0], 30, onScreenSkill.length * 25)) && GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                                int value7 = 0;
                                if (!GameCanvas.isTouchControl) {
                                    value7 = (GameCanvas.pyLast - (ySkill + nso.GameScr.yS[0])) / 25;
                                } else {
                                    value7 = (GameCanvas.pxLast - (xSkill + nso.GameScr.xS[0])) / 30;
                                }
                                gameScr.selectedIndexSkill = value7;
                                if (indexSelect < 0) {
                                    indexSelect = 0;
                                }
                                if (gameScr.selectedIndexSkill > onScreenSkill.length - 1) {
                                    gameScr.selectedIndexSkill = onScreenSkill.length - 1;
                                }
                                flag = true;
                                Skill skill = onScreenSkill[gameScr.selectedIndexSkill];
                                gameScr.doUseSkill(skill, false, true);
                                gameScr.isShortcut = true;
                            }
                            if (GameCanvas.isPointerJustRelease) {
                                GameCanvas.keyHold[1] = false;
                                GameCanvas.keyHold[2] = false;
                                GameCanvas.keyHold[3] = false;
                                GameCanvas.keyHold[4] = false;
                                GameCanvas.keyHold[6] = false;
                            }
                            if (!flag && !isPaintPopup() && !isPaintUI() && !isOpenUI() && GameCanvas.isPointerClick) {
                                value = 0;
                                label1479: while (true) {
                                    if (value >= vMob.size()) {
                                        for (int index8 = 0; index8 < vNpc.size(); index8++) {
                                            Npc npc;
                                            if ((npc = (Npc) vNpc.elementAt(index8)).isPaint() && GameCanvas.isPointerInGame(npc.cx - npc.cw / 2, npc.cy - npc.ch, npc.cw, npc.ch) && GameCanvas.isPointerJustRelease) {
                                                Char.getMyChar().mobFocus = null;
                                                Char.getMyChar().deFocusNPC();
                                                Char.getMyChar().npcFocus = npc;
                                                Char.getMyChar().charFocus = null;
                                                Char.getMyChar().itemFocus = null;
                                                Char.isManualFocus = true;
                                                break label1479;
                                            }
                                        }
                                        for (int index9 = 0; index9 < vCharInMap.size(); index9++) {
                                            Char character;
                                            if ((character = (Char) vCharInMap.elementAt(index9)).isPaint() && !character.isNhanbanz() && GameCanvas.isPointerInGame(character.cx - character.cw / 2, character.cy - character.ch, character.cw, character.ch) && GameCanvas.isPointerJustRelease) {
                                                Char.getMyChar().mobFocus = null;
                                                Char.getMyChar().deFocusNPC();
                                                Char.getMyChar().charFocus = character;
                                                Char.getMyChar().itemFocus = null;
                                                Char.isManualFocus = true;
                                                break label1479;
                                            }
                                        }
                                        value = 0;
                                        while (true) {
                                            if (value >= vItemMap.size()) {
                                                break label1479;
                                            }
                                            ItemMap itemMap;
                                            if (GameCanvas.isPointerInGame((itemMap = (ItemMap) vItemMap.elementAt(value)).x - 12, itemMap.y - 24, 24, 24) && GameCanvas.isPointerJustRelease) {
                                                Char.getMyChar().mobFocus = null;
                                                Char.getMyChar().deFocusNPC();
                                                Char.getMyChar().charFocus = null;
                                                Char.getMyChar().itemFocus = itemMap;
                                                Char.isManualFocus = true;
                                                break label1479;
                                            }
                                            value++;
                                        }
                                    }
                                    Mob mob;
                                    if ((mob = (Mob) vMob.elementAt(value)).isPaint() && GameCanvas.isPointerInGame(mob.x - mob.w / 2, mob.y - mob.h, mob.w, mob.h) && GameCanvas.isPointerJustRelease) {
                                        Char.getMyChar().mobFocus = mob;
                                        Char.getMyChar().deFocusNPC();
                                        Char.getMyChar().charFocus = null;
                                        Char.getMyChar().itemFocus = null;
                                        Char.isManualFocus = true;
                                        break;
                                    }
                                    value++;
                                }
                            }
                        }
                    }
                }
                GameScr gameScr10 = this;
                label1443: if (TileMap.mapID != 130 && !isMobSameParty()) {
                    long longValue = System.currentTimeMillis();
                    if (GameCanvas.keyPressedz[2] || GameCanvas.keyPressedz[4] || GameCanvas.keyPressedz[6] || GameCanvas.keyPressedz[1] || GameCanvas.keyPressedz[3]) {
                        nso.GameScr.auto = 0;
                        if (gameScr10.lockAutoMove) {
                            Char.getMyChar().isLockMove = false;
                            gameScr10.lockAutoMove = false;
                        }
                    }
                    if (GameCanvas.keyPressedz[5] && !isPaintPopup()) {
                        if (nso.GameScr.auto == 0) {
                            if (longValue - gameScr10.lastFire < 800L && (Char.getMyChar().myskill != null && Char.getMyChar().cMP < Char.getMyChar().myskill.manaUse ? false : (Char.getMyChar().myskill != null && (Char.getMyChar().myskill.template.maxPoint <= 0 || Char.getMyChar().myskill.point != 0) ? Char.getMyChar().arrItemBody[1] != null : false)) && Char.getMyChar().mobFocus != null) {
                                nso.GameScr.auto = 10;
                                GameCanvas.keyPressedz[5] = false;
                            }
                        } else {
                            if (!gameScr10.lockAutoMove && Char.getMyChar().statusMe != 14) {
                                gameScr10.lockAutoMove = !gameScr10.lockAutoMove;
                                Char.getMyChar().isLockMove = !Char.getMyChar().isLockMove;
                                gameScr10.lastFire = longValue;
                                break label1443;
                            }
                            nso.GameScr.auto = 0;
                            if (gameScr10.lockAutoMove) {
                                Char.getMyChar().isLockMove = false;
                                gameScr10.lockAutoMove = false;
                            }
                            GameCanvas.keyPressedz[4] = GameCanvas.keyPressedz[6] = false;
                        }
                        gameScr10.lastFire = longValue;
                    }
                    if (GameCanvas.gameTick % 10 == 0 && nso.GameScr.auto > 0 && (Char.getMyChar().mobFocus != null || Char.getMyChar().itemFocus != null)) {
                        gameScr10.doFire(true);
                    }
                    if (nso.GameScr.auto > 1) {
                        nso.GameScr.auto--;
                    }
                }
                gameScr10 = this;
                if (GameCanvas.isTouch) {
                    if (GameCanvas.isPointerDown && !GameCanvas.isPointerJustRelease && GameCanvas.isPointerHoldIn(nso.GameScr.xTG, nso.GameScr.yTG, 34, 34) && !isPaintCharInMap && GameCanvas.isPointerClick && GameCanvas.isHoldPress()) {
                        gameScr10.doShowCharInMap();
                    }
                } else if (GameCanvas.keyHold[13] && !isPaintCharInMap && GameCanvas.isHoldPress()) {
                    gameScr10.doShowCharInMap();
                }
                if (ChatPopup.currentMultilineChatPopup != null) {
                    Command command = ChatPopup.currentMultilineChatPopup.cmdNextLine;
                    if ((GameCanvas.keyPressedz[5] || mScreen.getCmdPointerLast(command)) && command != null) {
                        GameCanvas.isPointerJustRelease = false;
                        GameCanvas.keyPressedz[5] = false;
                        mScreen.keyTouch = -1;
                        if (command != null) {
                            command.performAction();
                        }
                    }
                } else if (!ChatTextField.gI().isShow) {
                    if (mScreen.keyTouch != -1 && GameCanvas.isPointerHoldIn(nso.GameScr.xL, nso.GameScr.yL, 34, 34)) {
                        GameCanvas.isPointerJustRelease = false;
                    }
                    if (mScreen.keyTouch != -1 && GameCanvas.isPointerHoldIn(xR, nso.GameScr.yR, 34, 34)) {
                        GameCanvas.isPointerJustRelease = false;
                    }
                    if (mScreen.keyTouch != -1 && GameCanvas.isPointerHoldIn(xU, nso.GameScr.yU, 34, 34)) {
                        GameCanvas.isPointerJustRelease = false;
                    }
                    if ((GameCanvas.keyPressedz[12] || mScreen.getCmdPointerLast(GameCanvas.currentScreen.left)) && super.left != null) {
                        GameCanvas.isPointerJustRelease = false;
                        GameCanvas.isPointerClick = false;
                        GameCanvas.keyPressedz[12] = false;
                        mScreen.keyTouch = -1;
                        if (super.left != null) {
                            super.left.performAction();
                        }
                    }
                    if ((GameCanvas.keyPressedz[13] || mScreen.getCmdPointerLast(GameCanvas.currentScreen.right)) && super.right != null) {
                        GameCanvas.isPointerJustRelease = false;
                        GameCanvas.isPointerClick = false;
                        GameCanvas.keyPressedz[13] = false;
                        mScreen.keyTouch = -1;
                        if (super.right != null) {
                            super.right.performAction();
                        }
                    }
                    if ((GameCanvas.keyPressedz[5] || mScreen.getCmdPointerLast(GameCanvas.currentScreen.center)) && super.center != null) {
                        GameCanvas.isPointerJustRelease = false;
                        GameCanvas.keyPressedz[5] = false;
                        mScreen.keyTouch = -1;
                        if (super.center != null) {
                            super.center.performAction();
                        }
                    }
                } else {
                    if (ChatTextField.gI().left != null && (GameCanvas.keyPressedz[12] || mScreen.getCmdPointerLast(ChatTextField.gI().left)) && ChatTextField.gI().left != null) {
                        ChatTextField.gI().left.performAction();
                    }
                    if (ChatTextField.gI().right != null && (GameCanvas.keyPressedz[13] || mScreen.getCmdPointerLast(ChatTextField.gI().right)) && ChatTextField.gI().right != null) {
                        ChatTextField.gI().right.performAction();
                    }
                    if (ChatTextField.gI().center != null && (GameCanvas.keyPressedz[5] || mScreen.getCmdPointerLast(ChatTextField.gI().center)) && ChatTextField.gI().center != null) {
                        ChatTextField.gI().center.performAction();
                    }
                }
                gameScr10 = this;
                if (isPaintZone && GameCanvas.currentDialog == null) {
                    boolean flag11 = false;
                    if (GameCanvas.keyPressedz[4]) {
                        if (--indexSelect < 0) {
                            indexSelect = gameScr10.zones.length - 1;
                        }
                        flag11 = true;
                    } else if (GameCanvas.keyPressedz[6]) {
                        if (++indexSelect >= gameScr10.zones.length) {
                            indexSelect = 0;
                        }
                        flag11 = true;
                    } else if (GameCanvas.keyPressedz[8]) {
                        if (indexSelect + gameScr10.zoneCol <= gameScr10.zones.length - 1) {
                            indexSelect = indexSelect + gameScr10.zoneCol;
                        }
                        flag11 = true;
                    } else if (GameCanvas.keyPressedz[2]) {
                        if (indexSelect - gameScr10.zoneCol >= 0) {
                            indexSelect = indexSelect - gameScr10.zoneCol;
                        }
                        flag11 = true;
                    }
                    if (flag11) {
                        scrMain.moveTo(indexSelect / columns * scrMain.ITEM_SIZE);
                        GameCanvas.clearKeyHold();
                        GameCanvas.clearKeyPressed();
                    }
                    ScrollResult scrollResult;
                    if (GameCanvas.isTouch && ((scrollResult = scrMain.updateKey()).isDowning || scrollResult.isFinish)) {
                        indexSelect = scrollResult.selected;
                    }
                }
                gameScr10 = this;
                if (isPaintRankedList || isPaintTeam || isPaintFindTeam || isPaintFriend || isPaintEnemies || isPaintCharInMap || isPaintList || isPaintAuctionBuy) {
                    if (isPaintAuctionBuy) {
                        ScrollResult scrollResult12;
                        if (isPaintAuctionBuy && ((scrollResult12 = scrMain.updateKey()).isDowning || scrollResult12.isFinish)) {
                            if ((indexSelect = scrollResult12.selected) >= arrItemStands.length) {
                                indexSelect = -1;
                            }
                            if (indexSelect >= 0) {
                                indexTitle = 1;
                            }
                            gameScr10.updateCommandForUI();
                        }
                    } else {
                        label1653: {
                            if (isPaintTeam) {
                                if (vParty.size() == 0) {
                                    break label1653;
                                }
                                if (GameCanvas.keyPressedz[8]) {
                                    if (++indexRow >= vParty.size()) {
                                        indexRow = vParty.size() - 1;
                                    }
                                    scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                                } else if (GameCanvas.keyPressedz[2]) {
                                    if (--indexRow < 0) {
                                        indexRow = 0;
                                    }
                                    scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                                }
                                gameScr10.setPartyCommand();
                            } else if (isPaintFindTeam) {
                                if (GameCanvas.keyPressedz[8]) {
                                    if (++indexRow >= vPtMap.size()) {
                                        indexRow = vPtMap.size() - 1;
                                    }
                                    scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                                } else if (GameCanvas.keyPressedz[2]) {
                                    if (--indexRow < 0) {
                                        indexRow = 0;
                                    }
                                    scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                                }
                                gameScr10.refreshFindTeam();
                            } else if (isPaintFriend) {
                                if (GameCanvas.keyPressedz[8]) {
                                    if (++indexRow >= indexRowMax) {
                                        indexRow = 0;
                                    }
                                    scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                                } else if (GameCanvas.keyPressedz[2]) {
                                    if (--indexRow < 0) {
                                        indexRow = indexRowMax - 1;
                                    }
                                    scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                                }
                                gameScr10.setFriendCommand();
                            } else if (isPaintEnemies) {
                                if (GameCanvas.keyPressedz[8]) {
                                    if (++indexRow >= indexRowMax) {
                                        indexRow = 0;
                                    }
                                    scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                                } else if (GameCanvas.keyPressedz[2]) {
                                    if (--indexRow < 0) {
                                        indexRow = indexRowMax - 1;
                                    }
                                    scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                                }
                                gameScr10.setEnemiesCommand();
                            } else if (isPaintCharInMap) {
                                if (GameCanvas.keyPressedz[8]) {
                                    if (++indexRow >= vCharInMap.size()) {
                                        indexRow = vCharInMap.size() - 1;
                                    }
                                    scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                                } else if (GameCanvas.keyPressedz[2]) {
                                    if (--indexRow < 0) {
                                        indexRow = 0;
                                    }
                                    scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                                }
                                if (gameScr10.cLastFocusID > 0 && !GameCanvas.isTouch) {
                                    scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                                }
                                gameScr10.setCharFocusCommand();
                            } else if (isPaintList) {
                                if (GameCanvas.keyPressedz[8]) {
                                    if (++indexRow >= vList.size()) {
                                        indexRow = vList.size() - 1;
                                    }
                                    scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                                } else if (GameCanvas.keyPressedz[2]) {
                                    if (--indexRow < 0) {
                                        indexRow = 0;
                                    }
                                    scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                                }
                                gameScr10.setDunListCommand();
                            } else if (isPaintRankedList) {
                                if (GameCanvas.keyPressedz[8]) {
                                    if (++indexRow >= vList.size()) {
                                        indexRow = vList.size() - 1;
                                    }
                                    scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                                } else if (GameCanvas.keyPressedz[2]) {
                                    if (--indexRow < 0) {
                                        indexRow = 0;
                                    }
                                    scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                                }
                                gameScr10.setRankedListCommand();
                            }
                            if (GameCanvas.isTouch && GameCanvas.currentDialog == null && !GameCanvas.menu.showMenu) {
                                MyVector entries = null;
                                if (isPaintTeam) {
                                    entries = vParty;
                                } else if (isPaintFriend) {
                                    entries = vFriend;
                                } else if (isPaintEnemies) {
                                    entries = vEnemies;
                                } else if (isPaintFindTeam) {
                                    entries = vPtMap;
                                } else if (isPaintCharInMap) {
                                    entries = vCharInMap;
                                } else if (isPaintList) {
                                    entries = vList;
                                } else if (isPaintRankedList) {
                                    entries = vList;
                                }
                                ScrollResult scrollResult13;
                                if ((scrollResult13 = scrMain.updateKey()).isDowning || scrollResult13.isFinish) {
                                    if ((indexRow = scrollResult13.selected) >= entries.size()) {
                                        indexRow = -1;
                                    }
                                    if (isPaintTeam) {
                                        gameScr10.setPartyCommand();
                                    } else if (isPaintFriend) {
                                        gameScr10.setFriendCommand();
                                    } else if (isPaintEnemies) {
                                        gameScr10.setEnemiesCommand();
                                    } else if (isPaintCharInMap) {
                                        gameScr10.setCharFocusCommand();
                                    } else if (isPaintList) {
                                        gameScr10.setDunListCommand();
                                    } else if (isPaintRankedList) {
                                        gameScr10.setRankedListCommand();
                                    }
                                }
                            }
                            GameCanvas.clearKeyHold();
                            GameCanvas.clearKeyPressed();
                        }
                    }
                }
                this.updateKeyBuyItemUI();
                this.updateKeyUIInforMe();
                gameScr10 = this;
                if (isPaintClan) {
                    if (indexTitle == 0) {
                        if (GameCanvas.keyPressedz[8]) {
                            if (Char.clan == null) {
                                indexTitle = 0;
                            } else {
                                indexTitle = 1;
                            }
                            indexSelect = 0;
                            indexRow = -1;
                            if (indexMenu == 0) {
                                indexSelect = Char.clan.itemLevel;
                            }
                            scrMain.clear();
                            scrInfo.clear();
                        }
                        if (GameCanvas.keyPressedz[4]) {
                            indexSelect = 0;
                            indexRow = -1;
                            indexMenu--;
                            scrMain.clear();
                            scrInfo.clear();
                            if (indexMenu < 0) {
                                indexMenu = mResources.CLAN.length - 1;
                            }
                            if (indexMenu >= mResources.CLAN.length) {
                                indexMenu = 0;
                            }
                            if (indexMenu == 1 && isRequestMember) {
                                Service.gI().requestClanMember();
                                isRequestMember = false;
                            } else if (indexMenu == 2) {
                                Service.gI().requestClanItem();
                            } else if (indexMenu == 3) {
                                Service.gI().requestClanLog();
                            } else if (indexMenu == 4) {
                                Service.gI().requestClanItem();
                            }
                            setPopupSize(175, 200);
                        }
                        if (GameCanvas.keyPressedz[6]) {
                            indexSelect = 0;
                            indexRow = -1;
                            indexMenu++;
                            scrMain.clear();
                            scrInfo.clear();
                            if (indexMenu < 0) {
                                indexMenu = mResources.CLAN.length - 1;
                            }
                            if (indexMenu >= mResources.CLAN.length) {
                                indexMenu = 0;
                            }
                            if (indexMenu == 1 && isRequestMember) {
                                Service.gI().requestClanMember();
                                isRequestMember = false;
                            } else if (indexMenu == 2) {
                                Service.gI().requestClanItem();
                            } else if (indexMenu == 3) {
                                Service.gI().requestClanLog();
                            } else if (indexMenu == 4) {
                                Service.gI().requestClanItem();
                            }
                            setPopupSize(175, 200);
                        }
                        gameScr10.setClanComand();
                    } else if (nso.GameScr.isPaintItemInfo) {
                        if (GameCanvas.keyPressedz[2]) {
                            if (--indexRow < 0) {
                                indexRow = indexRowMax - 1;
                            }
                            scrInfo.moveTo(indexRow * scrInfo.ITEM_SIZE);
                        } else if (GameCanvas.keyPressedz[8]) {
                            if (++indexRow >= indexRowMax) {
                                indexRow = 0;
                            }
                            scrInfo.moveTo(indexRow * scrInfo.ITEM_SIZE);
                        }
                    } else {
                        if (indexRow < 0) {
                            indexRow = 0;
                        }
                        if (indexMenu == 2) {
                            if (Char.clan != null && Char.clan.items != null) {
                                if (GameCanvas.keyPressedz[4]) {
                                    if (--indexSelect < 0) {
                                        indexSelect = Char.clan.items.length - 1;
                                    }
                                } else if (GameCanvas.keyPressedz[6]) {
                                    if (++indexSelect >= Char.clan.items.length) {
                                        indexSelect = 0;
                                    }
                                } else if (GameCanvas.keyPressedz[8]) {
                                    if (indexSelect + columns <= Char.clan.items.length - 1) {
                                        indexSelect = indexSelect + columns;
                                    }
                                } else if (GameCanvas.keyPressedz[2]) {
                                    if (indexSelect >= 0 && indexSelect < columns) {
                                        indexTitle = 0;
                                        indexSelect = 0;
                                    } else if (indexSelect - columns >= 0) {
                                        indexSelect = indexSelect - columns;
                                    }
                                }
                                scrMain.moveTo(indexSelect / columns * scrMain.ITEM_SIZE);
                            }
                        } else if (indexMenu == 0 && indexTitle == 1) {
                            if (GameCanvas.keyPressedz[8]) {
                                indexTitle++;
                            } else if (GameCanvas.keyPressedz[2]) {
                                indexTitle--;
                            }
                        } else if (indexMenu == 4) {
                            GameScr gameScr14 = gameScr10;
                            if (GameCanvas.keyPressedz[2]) {
                                if (indexRow == 0) {
                                    indexTitle--;
                                    indexRow = -1;
                                } else {
                                    indexRow--;
                                }
                                scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                            } else if (GameCanvas.keyPressedz[8]) {
                                if (++indexRow >= indexRowMax) {
                                    indexRow = 0;
                                }
                                scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                            } else if (GameCanvas.keyPressedz[4]) {
                                gameScr14.indexThanThu--;
                                if (gameScr14.indexThanThu < 0) {
                                    gameScr14.indexThanThu = 0;
                                }
                            } else if (GameCanvas.keyPressedz[6]) {
                                gameScr14.indexThanThu++;
                                if (gameScr14.indexThanThu > gameScr14.clan_thanthu.size() - 1) {
                                    gameScr14.indexThanThu = (byte) (gameScr14.clan_thanthu.size() - 1);
                                }
                            }
                        } else if (GameCanvas.keyPressedz[2]) {
                            if (indexRow == 0) {
                                indexTitle--;
                                indexRow = -1;
                            } else {
                                indexRow--;
                            }
                            scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                            if (indexMenu == 1 && isRequestMember) {
                                Service.gI().requestClanMember();
                                isRequestMember = false;
                            }
                        } else if (GameCanvas.keyPressedz[8]) {
                            if (++indexRow >= indexRowMax) {
                                indexRow = 0;
                            }
                            scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                        }
                        gameScr10.setClanComand();
                    }
                    if (GameCanvas.isTouch) {
                        GameScr gameScr15 = gameScr10;
                        label1225: if (GameCanvas.currentDialog == null && !GameCanvas.menu.showMenu) {
                            if (GameCanvas.isPointerJustRelease) {
                                if (GameCanvas.isPointerHoldIn(popupX, popupY, popupW, gameScr15.Hitem) && (!nso.GameScr.isPaintItemInfo || GameCanvas.w >= 320) && GameCanvas.isPointerClick) {
                                    if (GameCanvas.isPointerHoldIn(nso.GameScr.gW2 - 90, popupY + 5, 60, 40)) {
                                        indexSelect = 0;
                                        indexMenu--;
                                        indexRow = 0;
                                    }
                                    if (GameCanvas.isPointerHoldIn(nso.GameScr.gW2 + 20, popupY + 5, 60, 40)) {
                                        indexSelect = 0;
                                        indexMenu++;
                                        indexRow = 0;
                                    }
                                    nso.GameScr.isPaintItemInfo = false;
                                    scrMain.clear();
                                    scrInfo.clear();
                                    if (indexMenu < 0) {
                                        indexMenu = mResources.CLAN.length - 1;
                                    }
                                    if (indexMenu > mResources.CLAN.length - 1) {
                                        indexMenu = 0;
                                    }
                                    indexTitle = 1;
                                    if (indexMenu == 1 && isRequestMember) {
                                        Service.gI().requestClanMember();
                                        isRequestMember = false;
                                    } else if (indexMenu == 2 && Char.clan != null && Char.clan.items == null) {
                                        Service.gI().requestClanItem();
                                    }
                                    if (indexMenu == 3) {
                                        Service.gI().requestClanLog();
                                    }
                                    if (indexMenu == 4) {
                                        Service.gI().requestClanItem();
                                    }
                                    setPopupSize(175, 200);
                                    gameScr15.setClanComand();
                                }
                                if (indexMenu == 4) {
                                    GameScr gameScr16 = gameScr15;
                                    int value17 = gameScr15.xSelectThanThu - gameScr16.wSelectThanThu / 2;
                                    int value18 = gameScr16.ySelectThanThu - gameScr16.wSelectThanThu / 2;
                                    int value19 = (gameScr16.wSelectThanThu + 5) * gameScr16.clan_thanthu.size();
                                    int value20 = gameScr16.wSelectThanThu;
                                    int value21;
                                    if (GameCanvas.isPointerHoldIn(value17, value18, value19, value20) && (value21 = (GameCanvas.px - value17) / (gameScr16.wSelectThanThu + 5)) >= 0 && value21 < gameScr16.clan_thanthu.size()) {
                                        gameScr16.indexThanThu = (byte) value21;
                                    }
                                }
                            }
                            if (nso.GameScr.isPaintItemInfo) {
                                ScrollResult scrollResult22;
                                if ((scrollResult22 = scrInfo.updateKey()).isDowning || scrollResult22.isFinish) {
                                    indexRow = scrollResult22.selected;
                                    indexTitle = 1;
                                }
                                if (GameCanvas.isTouchControlSmallScreen) {
                                    break label1225;
                                }
                            }
                            if (indexMenu == 2) {
                                ScrollResult scrollResult23;
                                if ((scrollResult23 = scrMain.updateKey()).isDowning || scrollResult23.isFinish) {
                                    indexSelect = scrollResult23.selected;
                                    indexTitle = 1;
                                    gameScr15.actionPerform(1509, null);
                                }
                            } else if (indexMenu == 0 && GameCanvas.isPointerHoldIn(popupX + 18, popupY + 32, 5 * indexSize, indexSize) && GameCanvas.isPointerJustRelease && GameCanvas.isPointerClick) {
                                if (Char.clan != null) {
                                    indexSelect = Char.clan.itemLevel;
                                    indexTitle = 1;
                                }
                            } else if (indexMenu != 0 && indexMenu != 3) {
                                ScrollResult scrollResult24;
                                if (indexMenu == 1 && vClan.size() != 0 && ((scrollResult24 = scrMain.updateKey()).isDowning || scrollResult24.isFinish)) {
                                    indexRow = scrollResult24.selected;
                                    gameScr15.updateCommandForUI();
                                }
                            } else {
                                ScrollResult scrollResult25;
                                if (!nso.GameScr.isPaintItemInfo && ((scrollResult25 = scrMain.updateKey()).isDowning || scrollResult25.isFinish)) {
                                    indexRow = scrollResult25.selected;
                                    indexTitle = indexMenu == 0 ? 2 : 1;
                                    if (scrollResult25.isFinish) {
                                        scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                                    }
                                }
                            }
                        }
                    }
                    GameCanvas.clearKeyHold();
                    GameCanvas.clearKeyPressed();
                }
                if (isPaintTask) {
                    if (indexTitle == 0) {
                        if (indexTitle == 0 && GameCanvas.keyPressedz[8]) {
                            indexTitle = 1;
                            indexRow = -1;
                            scrMain.clear();
                            scrInfo.clear();
                        }
                    } else {
                        if (indexRow < 0) {
                            indexRow = 0;
                        }
                        if (GameCanvas.keyPressedz[2]) {
                            if (indexRow == 0) {
                                indexTitle--;
                                indexRow = -1;
                            } else {
                                indexRow--;
                            }
                            scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                        } else if (GameCanvas.keyPressedz[8]) {
                            if (++indexRow >= indexRowMax) {
                                indexRow = 0;
                            }
                            scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                        }
                    }
                    ScrollResult scrollResult26;
                    if (GameCanvas.isTouch && ((scrollResult26 = scrMain.updateKey()).isDowning || scrollResult26.isFinish)) {
                        indexRow = scrollResult26.selected;
                        indexTitle = 1;
                    }
                }
                this.updateKeyAlert();
                this.updateKeyMessage();
                if (Char.getMyChar().currentMovePoint != null) {
                    for (int index27 = 0; index27 < GameCanvas.keyPressedz.length; index27++) {
                        if (GameCanvas.keyPressedz[index27]) {
                            Char.getMyChar().currentMovePoint = null;
                            break;
                        }
                    }
                }
                if (ChatTextField.gI().isShow && GameCanvas.keyAsciiPress != 0) {
                    ChatTextField chatTextField = ChatTextField.gI();
                    int value28 = GameCanvas.keyAsciiPress;
                    ChatTextField chatTextField29 = chatTextField;
                    if (chatTextField.isShow) {
                        chatTextField29.tfChat.keyPressed(value28);
                    }
                    if (chatTextField29.tfChat.getText().equals("")) {
                        chatTextField29.right.caption = mResources.CLOSE;
                    } else {
                        chatTextField29.right.caption = mResources.DELETE;
                    }
                    GameCanvas.keyAsciiPress = 0;
                }
                if (this.isLockKey) {
                    GameCanvas.clearKeyHold();
                    GameCanvas.clearKeyPressed();
                } else if (!GameCanvas.menu.showMenu && !isOpenUI() && !Char.isLockKey) {
                    if (GameCanvas.keyPressedz[10]) {
                        GameCanvas.keyPressedz[10] = false;
                        doUseHP();
                        GameCanvas.clearKeyPressed();
                    }
                    if (GameCanvas.keyPressedz[11]) {
                        GameCanvas.keyPressedz[11] = false;
                        doUseMP();
                        GameCanvas.clearKeyPressed();
                    }
                    if (GameCanvas.keyAsciiPress != 0 && TField.isQwerty) {
                        if (GameCanvas.keyAsciiPress == 32) {
                            doUseHP();
                            GameCanvas.keyAsciiPress = 0;
                            GameCanvas.clearKeyPressed();
                        } else if (GameCanvas.keyAsciiPress == 64) {
                            doUseMP();
                            GameCanvas.keyAsciiPress = 0;
                            GameCanvas.clearKeyPressed();
                        } else if (GameCanvas.keyAsciiPress == 48) {
                            doUseMP();
                            GameCanvas.keyAsciiPress = 0;
                            GameCanvas.clearKeyPressed();
                        } else if (GameCanvas.keyAsciiPress == 63) {
                            doUseMP();
                            GameCanvas.keyAsciiPress = 0;
                            GameCanvas.clearKeyPressed();
                        }
                    }
                    if (Char.getMyChar().skillPaint == null) {
                        if (!Char.getMyChar().isCaptcha) {
                            if (Char.getMyChar().statusMe == 1) {
                                if (GameCanvas.keyPressedz[5]) {
                                    GameCanvas.keyPressedz[5] = false;
                                    this.doFire(false);
                                } else if (GameCanvas.keyHold[2]) {
                                    if (!Char.getMyChar().isLockMove && !Char.getMyChar().isBlinking) {
                                        setCharJump(0);
                                    }
                                } else if (GameCanvas.keyHold[1]) {
                                    Char.getMyChar().cdir = -1;
                                    if (!Char.getMyChar().isLockMove && !Char.getMyChar().isBlinking) {
                                        setCharJump(-4);
                                    }
                                } else if (GameCanvas.keyHold[3]) {
                                    Char.getMyChar().cdir = 1;
                                    if (!Char.getMyChar().isLockMove && !Char.getMyChar().isBlinking) {
                                        setCharJump(4);
                                    }
                                } else if (GameCanvas.keyHold[4]) {
                                    Char.getMyChar().isAttack = false;
                                    if (Char.getMyChar().cdir == 1) {
                                        Char.getMyChar().cdir = -1;
                                    } else if (!Char.getMyChar().isLockMove && !Char.getMyChar().isBlinking) {
                                        Char.getMyChar().statusMe = 2;
                                        Char.getMyChar().cvx = -Char.getMyChar().getSpeed();
                                    }
                                } else if (GameCanvas.keyHold[6]) {
                                    Char.getMyChar().isAttack = false;
                                    if (Char.getMyChar().cdir == -1) {
                                        Char.getMyChar().cdir = 1;
                                    } else if (!Char.getMyChar().isLockMove && !Char.getMyChar().isBlinking) {
                                        Char.getMyChar().statusMe = 2;
                                        Char.getMyChar().cvx = Char.getMyChar().getSpeed();
                                    }
                                }
                            } else if (Char.getMyChar().statusMe == 2) {
                                if (GameCanvas.keyPressedz[5]) {
                                    GameCanvas.keyPressedz[5] = false;
                                    this.doFire(false);
                                } else if (GameCanvas.keyHold[2]) {
                                    Char.getMyChar().cvy = Char.getMyChar().canJumpHigh ? -10 : -8;
                                    Char.getMyChar().statusMe = 3;
                                    Char.getMyChar().cp1 = 0;
                                } else if (GameCanvas.keyHold[1]) {
                                    Char.getMyChar().cdir = -1;
                                    Char.getMyChar().cvy = Char.getMyChar().canJumpHigh ? -10 : -8;
                                    Char.getMyChar().cvx = -4;
                                    Char.getMyChar().statusMe = 3;
                                    Char.getMyChar().cp1 = 0;
                                } else if (GameCanvas.keyHold[3]) {
                                    Char.getMyChar().cdir = 1;
                                    Char.getMyChar().cvy = Char.getMyChar().canJumpHigh ? -10 : -8;
                                    Char.getMyChar().cvx = 4;
                                    Char.getMyChar().statusMe = 3;
                                    Char.getMyChar().cp1 = 0;
                                } else if (GameCanvas.keyHold[4]) {
                                    if (Char.getMyChar().cdir == 1) {
                                        Char.getMyChar().cdir = -1;
                                    } else {
                                        Char player = Char.getMyChar();
                                        int value30 = -Char.getMyChar().getSpeed();
                                        Char.getMyChar();
                                        player.cvx = value30;
                                    }
                                } else if (GameCanvas.keyHold[6]) {
                                    if (Char.getMyChar().cdir == -1) {
                                        Char.getMyChar().cdir = 1;
                                    } else {
                                        Char player31 = Char.getMyChar();
                                        int value32 = Char.getMyChar().getSpeed();
                                        Char.getMyChar();
                                        player31.cvx = value32;
                                    }
                                }
                            } else if (Char.getMyChar().statusMe == 3) {
                                if (GameCanvas.keyPressedz[5]) {
                                    GameCanvas.keyPressedz[5] = false;
                                    this.doFire(false);
                                }
                                if (!GameCanvas.keyHold[4] && !GameCanvas.keyHold[1]) {
                                    if (GameCanvas.keyHold[6] || GameCanvas.keyHold[3]) {
                                        if (Char.getMyChar().cdir == -1) {
                                            Char.getMyChar().cdir = 1;
                                        } else {
                                            Char.getMyChar().cvx = Char.getMyChar().getSpeed();
                                        }
                                    }
                                } else if (Char.getMyChar().cdir == 1) {
                                    Char.getMyChar().cdir = -1;
                                } else {
                                    Char.getMyChar().cvx = -Char.getMyChar().getSpeed();
                                }
                                if ((GameCanvas.keyHold[2] || GameCanvas.keyHold[1] || GameCanvas.keyHold[3]) && Char.getMyChar().canJumpHigh && Char.getMyChar().cp1 == 0 && Char.getMyChar().cvy > -4) {
                                    Char.getMyChar().cp1++;
                                    Char.getMyChar().cvy = -7;
                                }
                            } else if (Char.getMyChar().statusMe == 4) {
                                if (GameCanvas.keyPressedz[5]) {
                                    GameCanvas.keyPressedz[5] = false;
                                    this.doFire(false);
                                }
                                if (GameCanvas.keyPressedz[2]) {
                                    GameCanvas.clearKeyPressed();
                                }
                                if (GameCanvas.keyHold[4]) {
                                    if (Char.getMyChar().cdir == 1) {
                                        Char.getMyChar().cdir = -1;
                                    } else {
                                        Char.getMyChar().cvx = -Char.getMyChar().getSpeed();
                                    }
                                } else if (GameCanvas.keyHold[6]) {
                                    if (Char.getMyChar().cdir == -1) {
                                        Char.getMyChar().cdir = 1;
                                    } else {
                                        Char.getMyChar().cvx = Char.getMyChar().getSpeed();
                                    }
                                }
                            } else if (Char.getMyChar().statusMe == 10) {
                                if (GameCanvas.keyPressedz[5]) {
                                    GameCanvas.keyPressedz[5] = false;
                                    this.doFire(false);
                                }
                                if (GameCanvas.keyHold[2]) {
                                    Char.getMyChar().cvy = -10;
                                    Char.getMyChar().statusMe = 3;
                                    Char.getMyChar().cp1 = 0;
                                } else if (GameCanvas.keyHold[4]) {
                                    if (Char.getMyChar().cdir == 1) {
                                        Char.getMyChar().cdir = -1;
                                    } else {
                                        Char.getMyChar().cvx = -5;
                                    }
                                } else if (GameCanvas.keyHold[6]) {
                                    if (Char.getMyChar().cdir == -1) {
                                        Char.getMyChar().cdir = 1;
                                    } else {
                                        Char.getMyChar().cvx = 5;
                                    }
                                }
                            } else if (Char.getMyChar().statusMe == 7) {
                                if (GameCanvas.keyPressedz[5]) {
                                    GameCanvas.keyPressedz[5] = false;
                                }
                                if (GameCanvas.keyHold[4]) {
                                    if (Char.getMyChar().cdir == 1) {
                                        Char.getMyChar().cdir = -1;
                                    } else {
                                        Char.getMyChar().cvx = -Char.getMyChar().getSpeed() + 2;
                                    }
                                } else if (GameCanvas.keyHold[6]) {
                                    if (Char.getMyChar().cdir == -1) {
                                        Char.getMyChar().cdir = 1;
                                    } else {
                                        Char.getMyChar().cvx = Char.getMyChar().getSpeed() - 2;
                                    }
                                }
                            } else if (Char.getMyChar().statusMe == 11) {
                                if (GameCanvas.keyPressedz[5]) {
                                    GameCanvas.keyPressedz[5] = false;
                                    this.doFire(false);
                                }
                                if (GameCanvas.keyHold[2]) {
                                    Char.getMyChar().cvy = -10;
                                    Char.getMyChar().statusMe = 3;
                                    Char.getMyChar().cp1 = 0;
                                }
                            }
                            if (GameCanvas.keyPressedz[8] && GameCanvas.keyAsciiPress != 56) {
                                GameCanvas.keyPressedz[8] = false;
                                this.doChangeSkill();
                            }
                        } else {
                            this.updateKeyCaptcha();
                        }
                        if (GameCanvas.keyAsciiPress != 0) {
                            if (TField.isQwerty) {
                                if (GameCanvas.keyAsciiPress == 113) {
                                    this.isShortcut = true;
                                    if (keySkill[0] != null) {
                                        this.doUseSkill(keySkill[0], true, true);
                                    }
                                } else if (GameCanvas.keyAsciiPress == 119) {
                                    this.isShortcut = true;
                                    if (keySkill[1] != null) {
                                        this.doUseSkill(keySkill[1], true, true);
                                    }
                                } else if (GameCanvas.keyAsciiPress == 101) {
                                    this.isShortcut = true;
                                    if (keySkill[2] != null) {
                                        this.doUseSkill(keySkill[2], true, true);
                                    }
                                } else {
                                    ChatTextField.gI().startChat(GameCanvas.keyAsciiPress, this, mResources.PUBLICCHAT[0]);
                                }
                            } else if (!GameCanvas.isMoveNumberPad) {
                                ChatTextField.gI().startChat(GameCanvas.keyAsciiPress, this, mResources.PUBLICCHAT[0]);
                            } else if (GameCanvas.keyAsciiPress == 55) {
                                this.isShortcut = true;
                                if (keySkill[0] != null) {
                                    this.doUseSkill(keySkill[0], true, true);
                                }
                            } else if (GameCanvas.keyAsciiPress == 56) {
                                this.isShortcut = true;
                                if (keySkill[1] != null) {
                                    this.doUseSkill(keySkill[1], true, true);
                                }
                            } else if (GameCanvas.keyAsciiPress == 57) {
                                this.isShortcut = true;
                                if (keySkill[2] != null) {
                                    this.doUseSkill(keySkill[2], true, true);
                                }
                            } else if (GameCanvas.keyAsciiPress == 48) {
                                ChatTextField.gI().showChat(mResources.PUBLICCHAT[0]);
                            }
                            GameCanvas.keyAsciiPress = 0;
                        }
                    }
                }
            }
        }
    }

    private void resetAuto() {
        nso.GameScr.auto = 0;
        this.lockAutoMove = Char.getMyChar().isLockMove = false;
    }

    public static void doUseMP() {
        if (!Char.getMyChar().doUsePotion(17)) {
            for (int index = 0; index < Char.getMyChar().arrItemBag.length; index++) {
                if (Char.getMyChar().arrItemBag[index] != null && Char.getMyChar().arrItemBag[index].template.type == 17) {
                    InfoMe.addInfo(mResources.NOT_ENOUGH_LEVEL);
                    return;
                }
            }
            if (nso.GameScr.auto != 1) {
                InfoMe.addInfo(mResources.MP_EMPTY);
            }
        }
    }

    public static void doUseHP() {
        int value = (int) (System.currentTimeMillis() / 1000L);
        for (int index = 0; index < Char.getMyChar().vEff.size(); index++) {
            Effect effect;
            if ((effect = (Effect) Char.getMyChar().vEff.elementAt(index)).template.id == 21 && effect.timeLenght - (value - effect.timeStart) >= 2) {
                return;
            }
        }
        if (!Char.getMyChar().doUsePotion(16)) {
            for (int index1 = 0; index1 < Char.getMyChar().arrItemBag.length; index1++) {
                if (Char.getMyChar().arrItemBag[index1] != null && Char.getMyChar().arrItemBag[index1].template.type == 16) {
                    InfoMe.addInfo(mResources.NOT_ENOUGH_LEVEL);
                    return;
                }
            }
            if (nso.GameScr.auto != 1) {
                InfoMe.addInfo(mResources.HP_EMPTY);
            }
        }
    }

    private static boolean isMobSameParty() {
        return Char.getMyChar().mobFocus == null ? false : Char.getMyChar().mobFocus.getTemplate().mobTemplateId == 142 && Char.getMyChar().cTypePk == 4 || Char.getMyChar().mobFocus.getTemplate().mobTemplateId == 143 && Char.getMyChar().cTypePk == 5 || Char.getMyChar().mobFocus.getTemplate().mobTemplateId == 143 && Char.getMyChar().cTypePk == 6;
    }

    private void doFire(boolean isFireByShortCut) {
        if (Char.getMyChar().statusMe != 14) {
            boolean flag;
            if (!InfoDlg.isLock && !Char.getMyChar().isLockAttack && !Char.isLockKey && !Char.getMyChar().isBlinking) {
                if (Char.getMyChar().mobFocus == null || (Char.getMyChar().mobFocus.templateId != 97 || Char.getMyChar().cTypePk != 4) && (Char.getMyChar().mobFocus.templateId != 98 || Char.getMyChar().cTypePk != 4) && (Char.getMyChar().mobFocus.templateId != 96 || Char.getMyChar().cTypePk != 5) && (Char.getMyChar().mobFocus.templateId != 99 || Char.getMyChar().cTypePk != 5) && (Char.getMyChar().mobFocus.templateId != 200 || Char.getMyChar().cTypePk != 4) && (Char.getMyChar().mobFocus.templateId != 199 || Char.getMyChar().cTypePk != 5) && (Char.getMyChar().mobFocus.templateId != 198 || Char.getMyChar().cTypePk != 6)) {
                    if (Char.getMyChar().myskill != null && Char.getMyChar().myskill.template.type == 2 && Char.getMyChar().npcFocus == null) {
                        flag = checkSkillValid();
                    } else {
                        label370: if (Char.getMyChar().skillPaint == null && (Char.getMyChar().charFocus == null || !Char.getMyChar().charFocus.isNhanbanz()) && (Char.getMyChar().mobFocus != null || Char.getMyChar().npcFocus != null || Char.getMyChar().charFocus != null || Char.getMyChar().itemFocus != null)) {
                            if (Char.getMyChar().mobFocus != null) {
                                if (Char.getMyChar().myskill == null) {
                                    flag = false;
                                    break label370;
                                }
                                if (Char.getMyChar().arrItemBody[1] == null) {
                                    InfoMe.addInfo(mResources.WEAPON_FAIL);
                                    flag = false;
                                    break label370;
                                }
                                if (Char.getMyChar().mobFocus.status == 1 || Char.getMyChar().mobFocus.status == 0 || Char.getMyChar().myskill.template.type == 4) {
                                    flag = false;
                                    break label370;
                                }
                                if (!checkSkillValid()) {
                                    flag = false;
                                    break label370;
                                }
                                if (Char.getMyChar().cx < Char.getMyChar().mobFocus.x) {
                                    Char.getMyChar().cdir = 1;
                                } else {
                                    Char.getMyChar().cdir = -1;
                                }
                                int value = Math.abs(Char.getMyChar().cx - Char.getMyChar().mobFocus.x);
                                int value1 = Math.abs(Char.getMyChar().cy - Char.getMyChar().mobFocus.y);
                                Char.getMyChar().cvx = 0;
                                if (Char.getMyChar().isUseLongRangeWeapon()) {
                                    if (value > Char.getMyChar().myskill.dx || value1 > Char.getMyChar().myskill.dy) {
                                        Char.getMyChar().currentMovePoint = new MovePoint(Char.getMyChar().mobFocus.x, Char.getMyChar().cy);
                                        GameCanvas.clearKeyHold();
                                        GameCanvas.clearKeyPressed();
                                        flag = false;
                                        break label370;
                                    }
                                    GameCanvas.clearKeyHold();
                                    GameCanvas.clearKeyPressed();
                                } else if ((Char.getMyChar().myskill.template.id == 24 || Char.getMyChar().myskill.template.id == 40 || Char.getMyChar().myskill.template.id == 42) && value <= Char.getMyChar().myskill.dx && value1 <= Char.getMyChar().myskill.dy) {
                                    GameCanvas.clearKeyHold();
                                    GameCanvas.clearKeyPressed();
                                    Char.getMyChar().cvx = 0;
                                } else {
                                    if (value > Char.getMyChar().myskill.dx || value1 > Char.getMyChar().myskill.dy || Char.getMyChar().cy < Char.getMyChar().mobFocus.y - 10) {
                                        Char.getMyChar().currentMovePoint = new MovePoint(Char.getMyChar().mobFocus.x + Char.getMyChar().mobFocus.dir * 12, Char.getMyChar().cy);
                                        GameCanvas.clearKeyHold();
                                        GameCanvas.clearKeyPressed();
                                        flag = false;
                                        break label370;
                                    }
                                    GameCanvas.clearKeyHold();
                                    GameCanvas.clearKeyPressed();
                                    Char.getMyChar().cvx = 0;
                                }
                            } else {
                                if (Char.getMyChar().npcFocus != null) {
                                    if (Char.getMyChar().cx < Char.getMyChar().npcFocus.cx) {
                                        Char.getMyChar().cdir = 1;
                                    } else {
                                        Char.getMyChar().cdir = -1;
                                    }
                                    if (Char.getMyChar().cx < Char.getMyChar().npcFocus.cx) {
                                        Char.getMyChar().npcFocus.cdir = -1;
                                    } else {
                                        Char.getMyChar().npcFocus.cdir = 1;
                                    }
                                    int value2 = Math.abs(Char.getMyChar().cx - Char.getMyChar().npcFocus.cx);
                                    int value3 = Math.abs(Char.getMyChar().cy - Char.getMyChar().npcFocus.cy);
                                    if (value2 < 60 && value3 < 40) {
                                        GameCanvas.clearKeyHold();
                                        GameCanvas.clearKeyPressed();
                                        if (Char.getMyChar().npcFocus.template.npcTemplateId == 13) {
                                            InfoDlg.showWait();
                                            Service.gI().openUIZone();
                                        } else {
                                            Service.gI().openMenu(Char.getMyChar().npcFocus.template.npcTemplateId);
                                            InfoDlg.showWait();
                                        }
                                    } else {
                                        Char.getMyChar().currentMovePoint = new MovePoint(Char.getMyChar().npcFocus.cx, Char.getMyChar().cy);
                                        GameCanvas.clearKeyHold();
                                        GameCanvas.clearKeyPressed();
                                    }
                                    flag = false;
                                    break label370;
                                }
                                if (Char.getMyChar().charFocus != null) {
                                    if (Char.getMyChar().cx < Char.getMyChar().charFocus.cx) {
                                        Char.getMyChar().cdir = 1;
                                    } else {
                                        Char.getMyChar().cdir = -1;
                                    }
                                    int value4 = Math.abs(Char.getMyChar().cx - Char.getMyChar().charFocus.cx);
                                    int value5 = Math.abs(Char.getMyChar().cy - Char.getMyChar().charFocus.cy);
                                    if (!Char.getMyChar().isMeCanAttackOtherPlayer(Char.getMyChar().charFocus)) {
                                        if (value4 < 60 && value5 < 40 && Char.getMyChar().charFocus.charID >= 0) {
                                            GameCanvas.clearKeyHold();
                                            if (Char.getMyChar().charFocus.statusMe != 14 && Char.getMyChar().charFocus.statusMe != 5 && TileMap.typeMap == 1) {
                                                flag = false;
                                                break label370;
                                            }
                                            if (!this.isShortcut) {
                                                MyVector entries;
                                                (entries = new MyVector()).addElement(new Command(mResources.CHAR_ORDER[6], 110397));
                                                entries.addElement(new Command(mResources.CHAR_ORDER[4], 110391));
                                                if ((Char.getMyChar().ctypeClan == 4 || Char.getMyChar().ctypeClan == 3 || Char.getMyChar().ctypeClan == 2) && Char.getMyChar().charFocus.cClanName.equals("")) {
                                                    entries.addElement(new Command(mResources.CHAR_ORDER[8], 110398));
                                                }
                                                if ((Char.getMyChar().charFocus.ctypeClan == 4 || Char.getMyChar().charFocus.ctypeClan == 3 || Char.getMyChar().charFocus.ctypeClan == 2) && Char.getMyChar().cClanName.equals("")) {
                                                    entries.addElement(new Command(mResources.CHAR_ORDER[9], 110399));
                                                }
                                                entries.addElement(new Command(mResources.CHAR_ORDER[7], 12004, Char.getMyChar().charFocus.cName));
                                                if (Char.getMyChar().nClass.classId == 6) {
                                                    entries.addElement(new Command(mResources.CHAR_ORDER[11] + ": " + (!Char.isAResuscitate ? mResources.ON : mResources.OFF), 1103991));
                                                }
                                                if (Char.getMyChar().charFocus.statusMe != 14 && Char.getMyChar().charFocus.statusMe != 5) {
                                                    entries.addElement(new Command(mResources.CHAR_ORDER[0], 110392));
                                                    entries.addElement(new Command(mResources.CHAR_ORDER[1], 110393));
                                                    entries.addElement(new Command(mResources.CHAR_ORDER[2], 110394));
                                                } else if (Char.getMyChar().myskill.template.type == 4) {
                                                    entries.addElement(new Command(mResources.CHAR_ORDER[5], 110395));
                                                }
                                                entries.addElement(new Command(mResources.CHAR_ORDER[3], 110396));
                                                GameCanvas.menu.startAt(entries);
                                                GameCanvas.menu.wait = 5;
                                            }
                                            this.isShortcut = false;
                                        } else {
                                            Char.getMyChar().currentMovePoint = new MovePoint(Char.getMyChar().charFocus.cx, Char.getMyChar().cy);
                                            GameCanvas.clearKeyHold();
                                            GameCanvas.clearKeyPressed();
                                        }
                                        flag = false;
                                        break label370;
                                    }
                                    if (Char.getMyChar().myskill == null) {
                                        flag = false;
                                        break label370;
                                    }
                                    if (Char.getMyChar().arrItemBody[1] == null) {
                                        InfoMe.addInfo(mResources.WEAPON_FAIL);
                                        flag = false;
                                        break label370;
                                    }
                                    if (!checkSkillValid()) {
                                        flag = false;
                                        break label370;
                                    }
                                    if (Char.getMyChar().cx < Char.getMyChar().charFocus.cx) {
                                        Char.getMyChar().cdir = 1;
                                    } else {
                                        Char.getMyChar().cdir = -1;
                                    }
                                    Char.getMyChar().cvx = 0;
                                    if (Char.getMyChar().isUseLongRangeWeapon()) {
                                        if (value4 > Char.getMyChar().myskill.dx || value5 > Char.getMyChar().myskill.dy) {
                                            Char.getMyChar().currentMovePoint = new MovePoint(Char.getMyChar().charFocus.cx, Char.getMyChar().cy);
                                            GameCanvas.clearKeyHold();
                                            GameCanvas.clearKeyPressed();
                                            flag = false;
                                            break label370;
                                        }
                                        GameCanvas.clearKeyHold();
                                        GameCanvas.clearKeyPressed();
                                    } else if ((Char.getMyChar().myskill.template.id == 24 || Char.getMyChar().myskill.template.id == 40 || Char.getMyChar().myskill.template.id == 42) && value4 <= Char.getMyChar().myskill.dx && value5 <= Char.getMyChar().myskill.dy) {
                                        GameCanvas.clearKeyHold();
                                        GameCanvas.clearKeyPressed();
                                        Char.getMyChar().cvx = 0;
                                    } else {
                                        if (value4 > Char.getMyChar().myskill.dx || value5 > Char.getMyChar().myskill.dy || Char.getMyChar().cy < Char.getMyChar().charFocus.cy) {
                                            Char.getMyChar().currentMovePoint = new MovePoint(Char.getMyChar().charFocus.cx + Char.getMyChar().charFocus.cdir * 12, Char.getMyChar().cy);
                                            GameCanvas.clearKeyHold();
                                            GameCanvas.clearKeyPressed();
                                            flag = false;
                                            break label370;
                                        }
                                        GameCanvas.clearKeyHold();
                                        GameCanvas.clearKeyPressed();
                                        Char.getMyChar().cvx = 0;
                                    }
                                } else if (Char.getMyChar().itemFocus != null) {
                                    if (Char.getMyChar().statusMe != 1) {
                                        flag = false;
                                        break label370;
                                    }
                                    if (Char.getMyChar().cx < Char.getMyChar().itemFocus.x) {
                                        Char.getMyChar().cdir = 1;
                                    } else {
                                        Char.getMyChar().cdir = -1;
                                    }
                                    int value6 = Math.abs(Char.getMyChar().cx - Char.getMyChar().itemFocus.x);
                                    int value7 = Math.abs(Char.getMyChar().cy - Char.getMyChar().itemFocus.y);
                                    if ((value6 > 35 || value7 >= 35) && (nso.GameScr.auto == 0 || value6 > 48 || value7 > 48)) {
                                        Char.getMyChar().currentMovePoint = new MovePoint(Char.getMyChar().itemFocus.x, Char.getMyChar().cy);
                                        GameCanvas.clearKeyHold();
                                        GameCanvas.clearKeyPressed();
                                    } else {
                                        GameCanvas.clearKeyHold();
                                        GameCanvas.clearKeyPressed();
                                        Service.gI().pickItem(Char.getMyChar().itemFocus.itemMapID);
                                    }
                                    flag = false;
                                    break label370;
                                }
                            }
                            flag = true;
                        } else {
                            flag = false;
                        }
                    }
                } else {
                    flag = false;
                }
            } else {
                flag = false;
            }
            if (flag) {
                if (isMobSameParty()) {
                    MyVector entries8;
                    (entries8 = new MyVector()).addElement(new Command(mResources.CAT_KEO, 151301));
                    GameCanvas.menu.startAt(entries8);
                    return;
                }
                if (Char.getMyChar().mobFocus != null && Char.getMyChar().mobFocus.getTemplate().mobTemplateId == 144 && TileMap.mapID == 130) {
                    MyVector entries9;
                    (entries9 = new MyVector()).addElement(new Command(mResources.CHO_KEO, 151301));
                    GameCanvas.menu.startAt(entries9);
                    return;
                }
                Char.getMyChar().setSkillPaint(sks[Char.getMyChar().myskill.template.id], 0);
                Char.getMyChar().currentFireByShortcut = isFireByShortCut;
                if (Char.getMyChar().isWolf) {
                    Char.getMyChar().isWolf = false;
                    Char.getMyChar().timeSummon = System.currentTimeMillis();
                    if (Char.getMyChar().vitaWolf >= 500) {
                        ServerEffect.addServerEffect(60, Char.getMyChar(), 1);
                    }
                }
                if (Char.getMyChar().isHaveMoto() && !Char.getMyChar().isMotoBehind) {
                    Char.getMyChar().isMoto = false;
                    Char.getMyChar().isMotoBehind = true;
                    ServerEffect.addServerEffect(60, Char.getMyChar(), 1);
                }
                if (Char.getMyChar().isHaveNewMount() && !Char.getMyChar().isMotoBehind) {
                    Char.getMyChar().isNewMount = false;
                    Char.getMyChar().isMotoBehind = true;
                    ServerEffect.addServerEffect(60, Char.getMyChar(), 1);
                }
            }
        }
        if (!isFireByShortCut) {
            Char.getMyChar().lastNormalSkill = Char.getMyChar().myskill;
        }
    }

    private void doChangeSkill() {
        this.nSkill = 0;
        for (int index = 0; index < onScreenSkill.length; index++) {
            if (onScreenSkill[index] != null) {
                this.nSkill++;
            }
        }
        if (this.nSkill <= 1) {
            InfoMe.isEmpty();
        } else {
            if (!isPaintSelectSkill || this.selectedIndexSkill == -1) {
                isPaintSelectSkill = true;
                for (int index1 = 0; index1 < onScreenSkill.length; index1++) {
                    if (onScreenSkill[index1] == Char.getMyChar().myskill) {
                        this.selectedIndexSkill = index1;
                        break;
                    }
                }
            }
            this.selectedIndexSkill++;
            if (this.selectedIndexSkill >= onScreenSkill.length) {
                this.selectedIndexSkill = 0;
            }
            if (onScreenSkill[this.selectedIndexSkill] == null) {
                this.selectedIndexSkill = 0;
            }
            super.center = new Command("", 11059);
        }
    }

    public final void doUseSkill(Skill skill, boolean isShortcut, boolean isSelectSkill) {
        this.selectedIndexSkill = -1;
        if (skill != null) {
            if (skill.template.type == 4 && Char.getMyChar().charFocus != null) {
                if (Char.getMyChar().charFocus.isNhanbanz()) {
                    return;
                }
                if (Char.getMyChar().charFocus.statusMe == 14 || Char.getMyChar().charFocus.statusMe == 5) {
                    Service.gI().buffLive(Char.getMyChar().charFocus.charID);
                    if ((TileMap.tileTypeAtPixel(Char.getMyChar().cx, Char.getMyChar().cy) & 2) == 2) {
                        Char.getMyChar().setSkillPaint(sks[49], 0);
                    } else {
                        Char.getMyChar().setSkillPaint(sks[49], 1);
                    }
                }
            }
            if (isSelectSkill) {
                Service.gI().selectSkill(skill.template.id);
            }
        }
        if (skill.template.type != 2) {
            this.resetButton();
        }
        if (skill != null) {
            Char.getMyChar().myskill = skill;
            if (Char.getMyChar().npcFocus == null && skill.template.type != 4) {
                this.doFire(isShortcut);
            }
        }
    }

    public static void sortList(int type) {
        MyVector entries = type == 0 ? vFriend : vEnemies;
        for (int index = 0; index < entries.size() - 1; index++) {
            Friend friend = (Friend) entries.elementAt(index);
            for (int index1 = index + 1; index1 < entries.size(); index1++) {
                Friend friend2;
                if ((friend2 = (Friend) entries.elementAt(index1)).type > friend.type) {
                    Friend friend3 = friend2;
                    friend2 = friend;
                    friend = friend3;
                    entries.setElementAt(friend, index);
                    entries.setElementAt(friend2, index1);
                } else if (friend2.type == friend.type && friend.friendName.compareTo(friend2.friendName) > 0) {
                    Friend friend4 = friend2;
                    friend2 = friend;
                    friend = friend4;
                    entries.setElementAt(friend, index);
                    entries.setElementAt(friend2, index1);
                }
            }
        }
    }

    public static void sortClan() {
        for (int index = 0; index < vClan.size() - 1; index++) {
            Member member = (Member) vClan.elementAt(index);
            for (int index1 = index + 1; index1 < vClan.size(); index1++) {
                Member member2 = (Member) vClan.elementAt(index1);
                if (isViewClanMemOnline && !isSortClanByPointWeek) {
                    if (member2.isOnline && !member.isOnline) {
                        Member member3 = member2;
                        member2 = member;
                        member = member3;
                        vClan.setElementAt(member, index);
                        vClan.setElementAt(member2, index1);
                    } else if (member2.isOnline && member.isOnline) {
                        if (member2.type > member.type) {
                            Member member4 = member2;
                            member2 = member;
                            member = member4;
                            vClan.setElementAt(member, index);
                            vClan.setElementAt(member2, index1);
                        } else if (member2.type == member.type) {
                            if (member2.pointClan > member.pointClan) {
                                Member member5 = member2;
                                member2 = member;
                                member = member5;
                                vClan.setElementAt(member, index);
                                vClan.setElementAt(member2, index1);
                            } else if (member.pointClan == member2.pointClan) {
                                if (member2.pointClanWeek > member.pointClanWeek) {
                                    Member member6 = member2;
                                    member2 = member;
                                    member = member6;
                                    vClan.setElementAt(member, index);
                                    vClan.setElementAt(member2, index1);
                                } else if (member.pointClanWeek == member2.pointClanWeek) {
                                    if (member2.level > member.level) {
                                        Member member7 = member2;
                                        member2 = member;
                                        member = member7;
                                        vClan.setElementAt(member, index);
                                        vClan.setElementAt(member2, index1);
                                    } else if (member.level == member2.level && member.name.compareTo(member2.name) > 0) {
                                        Member member8 = member2;
                                        member2 = member;
                                        member = member8;
                                        vClan.setElementAt(member, index);
                                        vClan.setElementAt(member2, index1);
                                    }
                                }
                            }
                        }
                    }
                } else if (isSortClanByPointWeek) {
                    if (isViewClanMemOnline) {
                        if (member2.isOnline && !member.isOnline) {
                            Member member9 = member2;
                            member2 = member;
                            member = member9;
                            vClan.setElementAt(member, index);
                            vClan.setElementAt(member2, index1);
                        } else if (member2.isOnline && member.isOnline) {
                            if (member2.pointClanWeek > member.pointClanWeek) {
                                Member member10 = member2;
                                member2 = member;
                                member = member10;
                                vClan.setElementAt(member, index);
                                vClan.setElementAt(member2, index1);
                            } else if (member.pointClanWeek == member2.pointClanWeek) {
                                if (member2.pointClan > member.pointClan) {
                                    Member member11 = member2;
                                    member2 = member;
                                    member = member11;
                                    vClan.setElementAt(member, index);
                                    vClan.setElementAt(member2, index1);
                                } else if (member.pointClan == member2.pointClan) {
                                    if (member2.type > member.type) {
                                        Member member12 = member2;
                                        member2 = member;
                                        member = member12;
                                        vClan.setElementAt(member, index);
                                        vClan.setElementAt(member2, index1);
                                    } else if (member2.type == member.type && member.level == member2.level && member.name.compareTo(member2.name) > 0) {
                                        Member member13 = member2;
                                        member2 = member;
                                        member = member13;
                                        vClan.setElementAt(member, index);
                                        vClan.setElementAt(member2, index1);
                                    }
                                }
                            }
                        }
                    } else if (member2.pointClanWeek > member.pointClanWeek) {
                        Member member14 = member2;
                        member2 = member;
                        member = member14;
                        vClan.setElementAt(member, index);
                        vClan.setElementAt(member2, index1);
                    } else if (member.pointClanWeek == member2.pointClanWeek) {
                        if (member2.pointClan > member.pointClan) {
                            Member member15 = member2;
                            member2 = member;
                            member = member15;
                            vClan.setElementAt(member, index);
                            vClan.setElementAt(member2, index1);
                        } else if (member.pointClan == member2.pointClan) {
                            if (member2.type > member.type) {
                                Member member16 = member2;
                                member2 = member;
                                member = member16;
                                vClan.setElementAt(member, index);
                                vClan.setElementAt(member2, index1);
                            } else if (member2.type == member.type && member.level == member2.level && member.name.compareTo(member2.name) > 0) {
                                Member member17 = member2;
                                member2 = member;
                                member = member17;
                                vClan.setElementAt(member, index);
                                vClan.setElementAt(member2, index1);
                            }
                        }
                    }
                } else if (member2.type > member.type) {
                    Member member18 = member2;
                    member2 = member;
                    member = member18;
                    vClan.setElementAt(member, index);
                    vClan.setElementAt(member2, index1);
                } else if (member2.type == member.type) {
                    if (member2.pointClan > member.pointClan) {
                        Member member19 = member2;
                        member2 = member;
                        member = member19;
                        vClan.setElementAt(member, index);
                        vClan.setElementAt(member2, index1);
                    } else if (member.pointClan == member2.pointClan) {
                        if (member2.pointClanWeek > member.pointClanWeek) {
                            Member member20 = member2;
                            member2 = member;
                            member = member20;
                            vClan.setElementAt(member, index);
                            vClan.setElementAt(member2, index1);
                        } else if (member.pointClanWeek == member2.pointClanWeek) {
                            if (member2.level > member.level) {
                                Member member21 = member2;
                                member2 = member;
                                member = member21;
                                vClan.setElementAt(member, index);
                                vClan.setElementAt(member2, index1);
                            } else if (member.level == member2.level && member.name.compareTo(member2.name) > 0) {
                                Member member22 = member2;
                                member2 = member;
                                member = member22;
                                vClan.setElementAt(member, index);
                                vClan.setElementAt(member2, index1);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void sortSkill() {
        for (int index = 0; index < Char.getMyChar().vSkillFight.size() - 1; index++) {
            Skill skill = (Skill) Char.getMyChar().vSkillFight.elementAt(index);
            for (int index1 = index + 1; index1 < Char.getMyChar().vSkillFight.size(); index1++) {
                Skill skill2;
                if ((skill2 = (Skill) Char.getMyChar().vSkillFight.elementAt(index1)).template.id < skill.template.id) {
                    Skill skill3 = skill2;
                    skill2 = skill;
                    skill = skill3;
                    Char.getMyChar().vSkillFight.setElementAt(skill, index);
                    Char.getMyChar().vSkillFight.setElementAt(skill2, index1);
                }
            }
        }
    }

    private static void setCharJump(int cvx) {
        Char.getMyChar().cvy = Char.getMyChar().canJumpHigh ? -10 : -8;
        Char.getMyChar().cvx = cvx;
        Char.getMyChar().statusMe = 3;
        Char.getMyChar().cp1 = 0;
    }

    public final void update() {
        for (int index = 0; index < VecTime.size(); index++) {
            TimecountDown timecountDown;
            if ((timecountDown = (TimecountDown) VecTime.elementAt(index)) != null) {
                timecountDown.update();
                if (timecountDown.wantdestroy) {
                    VecTime.removeElement(timecountDown);
                }
            }
        }
        if (indexMenu == 4 && GameCanvas.isTouch && mScreen.getCmdPointerLast(this.cmdTrangbi2) && this.cmdTrangbi2 != null) {
            GameCanvas.isPointerJustRelease = false;
            GameCanvas.keyPressedz[5] = false;
            mScreen.keyTouch = -1;
            this.cmdTrangbi2.performAction();
        }
        if (GameCanvas.gameTick % 200 == 0) {
            Char.SetRemove();
        }
        if (nso.GameScr.shaking != 0 && !GameCanvas.lowGraphic) {
            cmx = cmx + NinjaUtil.random(-7, 7);
            if (++count > 20) {
                nso.GameScr.shaking = 0;
                count = 0;
            }
        } else if (cmx != nso.GameScr.cmtoX || cmy != nso.GameScr.cmtoY) {
            if (!isUseitemAuto) {
                nso.GameScr.cmvx = nso.GameScr.cmtoX - cmx << 2;
                nso.GameScr.cmvy = nso.GameScr.cmtoY - cmy << 2;
            } else {
                nso.GameScr.cmvx = nso.GameScr.cmtoX - cmx << 1;
                nso.GameScr.cmvy = nso.GameScr.cmtoY - cmy << 2;
            }
            nso.GameScr.cmdx = nso.GameScr.cmdx + nso.GameScr.cmvx;
            cmx = cmx + (nso.GameScr.cmdx >> 4);
            nso.GameScr.cmdx &= 15;
            nso.GameScr.cmdy = nso.GameScr.cmdy + nso.GameScr.cmvy;
            cmy = cmy + (nso.GameScr.cmdy >> 4);
            nso.GameScr.cmdy &= 15;
            if (cmx < 24) {
                cmx = 24;
            }
            if (cmx > nso.GameScr.cmxLim) {
                cmx = nso.GameScr.cmxLim;
            }
            if (cmy < 0) {
                cmy = 0;
            }
            if (cmy > nso.GameScr.cmyLim) {
                cmy = nso.GameScr.cmyLim;
            }
        }
        if ((nso.GameScr.gssx = cmx / TileMap.size - 1) < 0) {
            nso.GameScr.gssx = 0;
        }
        nso.GameScr.gssy = cmy / TileMap.size;
        nso.GameScr.gssxe = nso.GameScr.gssx + nso.GameScr.gssw;
        nso.GameScr.gssye = nso.GameScr.gssy + nso.GameScr.gssh;
        if (nso.GameScr.gssy < 0) {
            nso.GameScr.gssy = 0;
        }
        if (nso.GameScr.gssye > TileMap.tmh - 1) {
            nso.GameScr.gssye = TileMap.tmh - 1;
        }
        if ((TileMap.gssx = (Char.getMyChar().cx - 2 * nso.GameScr.gW) / TileMap.size) < 0) {
            TileMap.gssx = 0;
        }
        if ((TileMap.gssxe = TileMap.gssx + TileMap.countx) > TileMap.tmw) {
            TileMap.gssx = (TileMap.gssxe = TileMap.tmw) - TileMap.countx;
        }
        if ((TileMap.gssy = (Char.getMyChar().cy - 2 * gH) / TileMap.size) < 0) {
            TileMap.gssy = 0;
        }
        if ((TileMap.gssye = TileMap.gssy + TileMap.county) > TileMap.tmh) {
            TileMap.gssy = (TileMap.gssye = TileMap.tmh) - TileMap.county;
        }
        scrMain.updatecm();
        scrInfo.updatecm();
        ChatTextField chatTextField;
        if ((chatTextField = ChatTextField.gI()).isShow) {
            chatTextField.tfChat.update();
            chatTextField.tfChat.getClass();
        }
        if (nso.GameScr.menuCooldown >= 0) {
            nso.GameScr.menuCooldown--;
        }
        TileMap.updateCmMiniMap();
        GameCanvas.gI();
        GameCanvas.updateBallEffect();
        if (GameCanvas.isGPRS) {
            MyVector entries = new MyVector();
            long longValue = System.currentTimeMillis();
            for (int index1 = 0; index1 < vCharInMap.size(); index1++) {
                Char character;
                (character = (Char) vCharInMap.elementAt(index1)).update();
                if (character.isPaint()) {
                    if (character.isDirtyPostion && longValue - character.lastUpdateTime > 10000L && longValue - this.lastSendUpdatePostion > 10000L) {
                        character.isDirtyPostion = false;
                        character.lastUpdateTime = longValue;
                        entries.addElement(character);
                    }
                } else {
                    character.lastUpdateTime = longValue;
                    character.isDirtyPostion = true;
                }
            }
            if (entries.size() > 0) {
                Service.gI().requestPlayerInfo(entries);
                this.lastSendUpdatePostion = longValue;
            }
        } else {
            for (int index2 = 0; index2 < vCharInMap.size(); index2++) {
                ((Char) vCharInMap.elementAt(index2)).update();
            }
        }
        Char.getMyChar().update();
        if (Char.getMyChar().statusMe == 1 && GameCanvas.gameTick % 100 == 0) {
            System.gc();
        }
        for (int index3 = 0; index3 < vMob.size(); index3++) {
            ((Mob) vMob.elementAt(index3)).updateMobAttack();
        }
        for (int index4 = 0; index4 < vNpc.size(); index4++) {
            ((Npc) vNpc.elementAt(index4)).update();
        }
        GameCanvas.gI().updateDust();
        for (int index5 = 0; index5 < 5; index5++) {
            if (flyTextState[index5] != -1) {
                flyTextState[index5] = flyTextState[index5] + Res.abs(nso.GameScr.flyTextDy[index5]);
                if (flyTextState[index5] > 30) {
                    flyTextState[index5] = -1;
                }
                nso.GameScr.flyTextX[index5] = nso.GameScr.flyTextX[index5] + nso.GameScr.flyTextDx[index5];
                nso.GameScr.flyTextY[index5] = nso.GameScr.flyTextY[index5] + nso.GameScr.flyTextDy[index5];
            }
        }
        for (int index6 = 0; index6 < nso.GameScr.vLanterns.size(); index6++) {
            Lanterns lanterns;
            Lanterns lanterns7 = lanterns = (Lanterns) nso.GameScr.vLanterns.elementAt(index6);
            lanterns7.y = lanterns7.y - lanterns.dy;
            if (lanterns.yStart - lanterns.y > 150) {
                lanterns.isEnd = true;
            }
            if (((Lanterns) nso.GameScr.vLanterns.elementAt(index6)).isEnd) {
                nso.GameScr.vLanterns.removeElementAt(index6);
            }
        }
        for (int index8 = 0; index8 < 2; index8++) {
            if (splashState[index8] != -1) {
                splashState[index8]++;
                nso.GameScr.splashX[index8] = nso.GameScr.splashX[index8] + (nso.GameScr.splashDir[index8] << 2);
                nso.GameScr.splashY[index8]--;
                if (splashState[index8] >= 6) {
                    splashState[index8] = -1;
                } else {
                    nso.GameScr.splashF[index8] = (splashState[index8] >> 1) % 3;
                }
            }
        }
        if (indexMenu != -1) {
            if (nso.GameScr.scrollOffset != nso.GameScr.scrollTarget) {
                nso.GameScr.scrollVelocity = nso.GameScr.scrollTarget - nso.GameScr.scrollOffset << 2;
                nso.GameScr.scrollRemainder = nso.GameScr.scrollRemainder + nso.GameScr.scrollVelocity;
                nso.GameScr.scrollOffset = nso.GameScr.scrollOffset + (nso.GameScr.scrollRemainder >> 4);
                nso.GameScr.scrollRemainder &= 15;
            }
            if (Math.abs(nso.GameScr.scrollTarget - nso.GameScr.scrollOffset) < 15 && nso.GameScr.scrollOffset < 0) {
                nso.GameScr.scrollTarget = 0;
            }
            if (Math.abs(nso.GameScr.scrollTarget - nso.GameScr.scrollOffset) < 15 && nso.GameScr.scrollOffset > 0) {
                nso.GameScr.scrollTarget = 0;
            }
        }
        GameCanvas.updateBG();
        for (int index9 = 0; index9 < nso.GameScr.vMobAttack.size(); index9++) {
            ((MobAttack) nso.GameScr.vMobAttack.elementAt(index9)).update();
        }
        for (int index10 = 0; index10 < vItemMap.size(); index10++) {
            ItemMap itemMap;
            if ((itemMap = (ItemMap) vItemMap.elementAt(index10)).status == 2 && itemMap.x == itemMap.xEnd && itemMap.y == itemMap.yEnd) {
                vItemMap.removeElement(itemMap);
                if (Char.getMyChar().itemFocus != null && Char.getMyChar().itemFocus.equals(itemMap)) {
                    Char.getMyChar().itemFocus = null;
                }
            } else if (itemMap.status > 0) {
                if (itemMap.vx == 0) {
                    itemMap.x = itemMap.xEnd;
                }
                if (itemMap.vy == 0) {
                    itemMap.y = itemMap.yEnd;
                }
                if (itemMap.x != itemMap.xEnd) {
                    itemMap.x = itemMap.x + itemMap.vx;
                    if (itemMap.vx > 0 && itemMap.x > itemMap.xEnd || itemMap.vx < 0 && itemMap.x < itemMap.xEnd) {
                        itemMap.x = itemMap.xEnd;
                    }
                }
                if (itemMap.y != itemMap.yEnd) {
                    itemMap.y = itemMap.y + itemMap.vy;
                    if (itemMap.vy > 0 && itemMap.y > itemMap.yEnd || itemMap.vy < 0 && itemMap.y < itemMap.yEnd) {
                        itemMap.y = itemMap.yEnd;
                    }
                }
            } else {
                itemMap.status = (byte) (itemMap.status - 4);
                if (itemMap.status < -12) {
                    itemMap.y -= 12;
                    itemMap.status = 1;
                }
            }
        }
        for (int index11 = 0; index11 < vMobSoul.size(); index11++) {
            ((MobSoul) vMobSoul.elementAt(index11)).update();
        }
        for (int index12 = 0; index12 < nso.GameScr.vSet.size(); index12++) {
            Set set;
            (set = (Set) nso.GameScr.vSet.elementAt(index12)).time++;
            if (set.time == 5) {
                set.time = 0;
                nso.GameScr.vSet.removeElement(set);
            }
            Mob mob = Mob.get_Mob(0);
            set.xMob = mob.x;
            set.yMob = mob.y - mob.h / 2;
            set.xChar = ((Char) vCharInMap.elementAt(0)).cx;
            set.yChar = ((Char) vCharInMap.elementAt(0)).cy - Char.getMyChar().chh;
            if (Res.abs(((int[]) null)[0] - set.xMob) > 5 || Res.abs(((int[]) null)[0] - set.yMob) > 5) {
                ((int[]) null)[0] = set.xMob;
                ((int[]) null)[0] = set.yMob;
            }
            if (Res.abs(((int[]) null)[0] - set.xChar) > 5 || Res.abs(((int[]) null)[0] - set.yChar) > 5) {
                ((int[]) null)[0] = set.xChar;
                ((int[]) null)[0] = set.yChar;
            }
        }
        if ((TileMap.tmw * TileMap.sizeMiniMap >= TileMap.wMiniMap || TileMap.tmh * TileMap.sizeMiniMap >= TileMap.hMiniMap) && System.currentTimeMillis() / 100L > 20L) {
            TileMap.updateMiniMap();
        }
        for (int index13 = Effect2.vRemoveEffect2.size() - 1; index13 >= 0; index13--) {
            Effect2.vEffect2.removeElement(Effect2.vRemoveEffect2.elementAt(index13));
            Effect2.vRemoveEffect2.removeElementAt(index13);
        }
        for (int index14 = 0; index14 < Effect2.vEffect2.size(); index14++) {
            ((Effect2) Effect2.vEffect2.elementAt(index14)).update();
        }
        for (int index15 = 0; index15 < Effect2.vEffect2Outside.size(); index15++) {
            ((Effect2) Effect2.vEffect2Outside.elementAt(index15)).update();
        }
        for (int index16 = 0; index16 < Effect2.vAnimateEffect.size(); index16++) {
            ((Effect2) Effect2.vAnimateEffect.elementAt(index16)).update();
        }
        for (int index17 = 0; index17 < Mob.vEggMonter.size(); index17++) {
            EggMonters eggMonters;
            if ((eggMonters = (EggMonters) Mob.vEggMonter.elementAt(index17)) != null) {
                EggMonters eggMonters18 = eggMonters;
                if (eggMonters.isPaint()) {
                    if (eggMonters18.status == 0) {
                        eggMonters18.vy++;
                        eggMonters18.y = eggMonters18.y + eggMonters18.vy;
                        eggMonters18.frame++;
                        if (eggMonters18.frame > 3) {
                            eggMonters18.frame = 0;
                        }
                        if ((TileMap.tileTypeAtPixel(eggMonters18.x, eggMonters18.y) & 2) == 2) {
                            eggMonters18.status = 1;
                            eggMonters18.vy = 0;
                        }
                    } else if (eggMonters18.status == 1) {
                        eggMonters18.frame++;
                        if (eggMonters18.frame > 6) {
                            eggMonters18.frame = 6;
                            EggMonters.ownerEgg.status = 5;
                        }
                    }
                }
                if (eggMonters.frame == 6) {
                    if (EggMonters.ownerEgg != null) {
                        EggMonters.ownerEgg.status = 5;
                    }
                    Mob.vEggMonter.removeElementAt(index17);
                }
            }
        }
        SmallImage.checkTimeUseImg();
        GameScr gameScr = this;
        if (this.cLastFocusID >= 0 && vCharInMap.size() > 0) {
            int value;
            if ((value = Char.getIndexChar(gameScr.cLastFocusID)) >= 0 && value < vCharInMap.size()) {
                Char character19;
                if ((character19 = (Char) vCharInMap.elementAt(value)) != null && Char.isCharInScreen(character19) && !character19.isNhanbanz()) {
                    Char.getMyChar().mobFocus = null;
                    Char.getMyChar().deFocusNPC();
                    Char.getMyChar().itemFocus = null;
                    Char.getMyChar();
                    Char.isManualFocus = true;
                    Char.getMyChar().charFocus = character19;
                }
            } else {
                gameScr.cLastFocusID = -1;
                Char.getMyChar().charFocus = null;
            }
        } else {
            gameScr.cLastFocusID = -1;
        }
        Info.update();
        InfoMe.update();
        if (currentCharViewInfo != null && currentCharViewInfo.charID != Char.getMyChar().charID) {
            currentCharViewInfo.update();
        }
        this.runArrow++;
        if (this.runArrow > 3) {
            this.runArrow = 0;
        }
        if (isPaintRankedList) {
            indexSize = 40;
        } else {
            indexSize = 28;
        }
        EffectAuto.checkTimeUseImg();
        EffectAuto.checkTimeUseData();
        if (GameCanvas.isKiemduyet_info) {
            GameCanvas.regScr.switchToMe();
        }
    }

    private static void paintTime(mGraphics g) {
        for (int index = 0; index < VecTime.size(); index++) {
            TimecountDown timecountDown;
            if ((timecountDown = (TimecountDown) VecTime.elementAt(index)) != null) {
                timecountDown.paint(g, GameCanvas.w, nso.GameScr.hMiniMap + index * 18 + 15);
            }
        }
    }

    public final void paint(mGraphics graphics) {
        if (Char.ischangingMap) {
            graphics.setColor(0);
            graphics.fillRect(0, 0, GameCanvas.w, GameCanvas.h);
            mFont.tahoma_7b_yellow.drawString(graphics, mResources.LOADING, GameCanvas.hw, GameCanvas.hh + 20, 2);
            GameCanvas.paintShukiren(GameCanvas.hw, GameCanvas.hh, graphics, false);
        } else {
            GameCanvas.paintBGGameScr(graphics);
            graphics.translate(-cmx, -cmy);
            for (int index = 0; index < nso.GameScr.vItemTreeBehind.size(); index++) {
                ((ItemTree) nso.GameScr.vItemTreeBehind.elementAt(index)).paint(graphics);
            }
            TileMap.paintTilemap(graphics);
            for (int index1 = 0; index1 < nso.GameScr.vItemTreeBetwen.size(); index1++) {
                ((ItemTree) nso.GameScr.vItemTreeBetwen.elementAt(index1)).paint(graphics);
            }
            for (int index2 = 0; index2 < vMob.size(); index2++) {
                ((Mob) vMob.elementAt(index2)).paint(graphics);
            }
            for (int index3 = 0; index3 < Mob.vEggMonter.size(); index3++) {
                EggMonters eggMonters = (EggMonters) Mob.vEggMonter.elementAt(index3);
                mGraphics graphics4 = graphics;
                EggMonters eggMonters5 = eggMonters;
                if (eggMonters.isPaint()) {
                    graphics4.drawRegion(nso.GameScr.imgEggMonters, 0, eggMonters5.frame << 5, 32, 32, 0, eggMonters5.x, eggMonters5.y, 33);
                }
            }
            for (int index6 = 0; index6 < vBuNhin.size(); index6++) {
                BuNhin buNhin = (BuNhin) vBuNhin.elementAt(index6);
                mGraphics graphics7 = graphics;
                BuNhin buNhin8 = buNhin;
                BuNhin buNhin9 = buNhin;
                if (buNhin.x < cmx ? false : (buNhin9.x > cmx + nso.GameScr.gW ? false : (buNhin9.y < cmy ? false : buNhin9.y <= cmy + gH + 30))) {
                    mFont.tahoma_7_yellow.drawString(graphics7, buNhin8.name, buNhin8.x, buNhin8.y - 32, 2, mFont.tahoma_7_grey);
                    SmallImage.drawSmallImage(graphics7, 1180, buNhin8.x, buNhin8.y, 0, 33);
                    if (buNhin8.isInjure) {
                        SmallImage.drawSmallImage(graphics7, 288, buNhin8.x, buNhin8.y, 0, 33);
                        buNhin8.isInjure = false;
                    }
                }
            }
            for (int index10 = 0; index10 < vNpc.size(); index10++) {
                ((Npc) vNpc.elementAt(index10)).paint(graphics);
            }
            mGraphics graphics11 = graphics;
            GameScr gameScr = this;
            for (int index12 = 0; index12 < TileMap.vGo.size(); index12++) {
                Waypoint waypoint;
                if ((waypoint = (Waypoint) TileMap.vGo.elementAt(index12)).minY != 0 && waypoint.maxY < TileMap.pxh - 24) {
                    if (waypoint.maxX <= TileMap.pxw / 2) {
                        if (!GameCanvas.isTouch) {
                            SmallImage.drawSmallImage(graphics11, 1213, waypoint.maxX + 12 + gameScr.runArrow, waypoint.maxY - 12, 2, StaticObj.VCENTER_HCENTER);
                        } else {
                            SmallImage.drawSmallImage(graphics11, 1213, waypoint.maxX + 12 + gameScr.runArrow, waypoint.maxY - 32, 2, StaticObj.VCENTER_HCENTER);
                        }
                    } else if (waypoint.minX >= TileMap.pxw / 2) {
                        if (!GameCanvas.isTouch) {
                            SmallImage.drawSmallImage(graphics11, 1213, waypoint.minX - 12 - gameScr.runArrow, waypoint.maxY - 12, 0, StaticObj.VCENTER_HCENTER);
                        } else {
                            SmallImage.drawSmallImage(graphics11, 1213, waypoint.minX - 12 - gameScr.runArrow, waypoint.maxY - 32, 0, StaticObj.VCENTER_HCENTER);
                        }
                    }
                } else if (waypoint.maxY <= TileMap.pxh / 2) {
                    int value = waypoint.minX + (waypoint.maxX - waypoint.minX) / 2;
                    int value13 = waypoint.minY + (waypoint.maxY - waypoint.minY) / 2 + gameScr.runArrow;
                    if (GameCanvas.isTouch) {
                        value13 = waypoint.maxY + (waypoint.maxY - waypoint.minY) + gameScr.runArrow + 10;
                    }
                    SmallImage.drawSmallImage(graphics11, 1213, value, value13, 6, StaticObj.VCENTER_HCENTER);
                } else if (waypoint.minY >= TileMap.pxh / 2) {
                    SmallImage.drawSmallImage(graphics11, 1213, waypoint.minX + (waypoint.maxX - waypoint.minX) / 2, waypoint.minY - 12 - gameScr.runArrow, 4, StaticObj.VCENTER_HCENTER);
                }
            }
            graphics.setClip(0, -200, GameCanvas.w - graphics.getTranslateX(), 200 + GameCanvas.h - graphics.getTranslateY());
            GameCanvas.gI().paintDust(graphics);
            for (int index14 = 0; index14 < vCharInMap.size(); index14++) {
                Char character = null;
                try {
                    character = (Char) vCharInMap.elementAt(index14);
                } catch (Exception exception) {
                }
                if (character != null) {
                    if (TileMap.mapID == 111 && index14 > 19) {
                        character.paintCharName_HP_MP_Overhead(graphics);
                    } else {
                        character.paint(graphics);
                    }
                }
            }
            for (int index15 = 0; index15 < vParty.size(); index15++) {
                Party party;
                if ((party = (Party) vParty.elementAt(index15)).c != null && party.c != Char.getMyChar()) {
                    party.c.paintNameInSameParty(graphics);
                }
            }
            mGraphics graphics16 = graphics;
            for (int index17 = 0; index17 < 5; index17++) {
                if (flyTextState[index17] != -1 && GameCanvas.isPaint(nso.GameScr.flyTextX[index17], nso.GameScr.flyTextY[index17])) {
                    if (nso.GameScr.flyTextColor[index17] == 0) {
                        mFont.number_red.drawString(graphics16, flyTextString[index17], nso.GameScr.flyTextX[index17], nso.GameScr.flyTextY[index17], 2);
                    } else if (nso.GameScr.flyTextColor[index17] == 1) {
                        mFont.number_yellow.drawString(graphics16, flyTextString[index17], nso.GameScr.flyTextX[index17], nso.GameScr.flyTextY[index17], 2);
                    } else if (nso.GameScr.flyTextColor[index17] == 2) {
                        mFont.number_green.drawString(graphics16, flyTextString[index17], nso.GameScr.flyTextX[index17], nso.GameScr.flyTextY[index17], 2);
                    } else if (nso.GameScr.flyTextColor[index17] == 3) {
                        mFont.tahoma_7b_yellow.drawString(graphics16, flyTextString[index17], nso.GameScr.flyTextX[index17], nso.GameScr.flyTextY[index17], 2, mFont.tahoma_7b_blue);
                    } else if (nso.GameScr.flyTextColor[index17] == 8) {
                        mFont.tahoma_7b_white.drawString(graphics16, flyTextString[index17], nso.GameScr.flyTextX[index17], nso.GameScr.flyTextY[index17], 2, mFont.tahoma_7b_blue);
                    } else if (nso.GameScr.flyTextColor[index17] == 4) {
                        SmallImage.drawSmallImage(graphics16, 1062, nso.GameScr.flyTextX[index17], nso.GameScr.flyTextY[index17], 0, 3);
                    } else if (nso.GameScr.flyTextColor[index17] == 5) {
                        mFont.number_orange.drawString(graphics16, flyTextString[index17], nso.GameScr.flyTextX[index17], nso.GameScr.flyTextY[index17], 2);
                    } else if (nso.GameScr.flyTextColor[index17] == 6) {
                        mFont.tahoma_7_yellow.drawString(graphics16, flyTextString[index17], nso.GameScr.flyTextX[index17], nso.GameScr.flyTextY[index17], 2, mFont.tahoma_7_red);
                    } else if (nso.GameScr.flyTextColor[index17] == 7) {
                        SmallImage.drawSmallImage(graphics16, 655, nso.GameScr.flyTextX[index17], nso.GameScr.flyTextY[index17], 0, 3);
                    }
                }
            }
            mGraphics graphics18 = graphics;
            for (int index19 = 0; index19 < nso.GameScr.vLanterns.size(); index19++) {
                Lanterns lanterns = (Lanterns) nso.GameScr.vLanterns.elementAt(index19);
                mGraphics graphics20 = graphics18;
                Lanterns lanterns21 = lanterns;
                if (GameCanvas.gameTick % 10 < 8) {
                    SmallImage.drawSmallImage(graphics20, 1292, lanterns21.x, lanterns21.y, 0, 3);
                } else {
                    SmallImage.drawSmallImage(graphics20, 1291, lanterns21.x, lanterns21.y, 0, 3);
                }
            }
            mGraphics graphics22 = graphics;
            for (int index23 = 0; index23 < 2; index23++) {
                if (splashState[index23] != -1) {
                    if (nso.GameScr.splashDir[index23] == 1) {
                        graphics22.drawImage(nso.GameScr.imgSplash[nso.GameScr.splashF[index23]], nso.GameScr.splashX[index23], nso.GameScr.splashY[index23], 3);
                    } else {
                        graphics22.drawRegion(nso.GameScr.imgSplash[nso.GameScr.splashF[index23]], 0, 0, mGraphics.getImageWidth(nso.GameScr.imgSplash[nso.GameScr.splashF[index23]]), mGraphics.getImageHeight(nso.GameScr.imgSplash[nso.GameScr.splashF[index23]]), 2, nso.GameScr.splashX[index23], nso.GameScr.splashY[index23], 3);
                    }
                }
            }
            Char.getMyChar().paint(graphics);
            graphics11 = graphics;
            gameScr = this;
            if (Char.getMyChar().isCaptcha) {
                for (int index24 = 0; index24 < gameScr.arrowCaptcha.length; index24++) {
                    if (gameScr.arrowCaptcha[index24] != -1) {
                        byte byteValue = 0;
                        if (gameScr.arrowCaptcha[index24] == 0) {
                            byteValue = 2;
                        } else if (gameScr.arrowCaptcha[index24] == 1) {
                            byteValue = 6;
                        } else if (gameScr.arrowCaptcha[index24] == 2) {
                            byteValue = 0;
                        }
                        SmallImage.drawSmallImage(graphics11, 989, Char.getMyChar().cx + index24 * 10 - (gameScr.arrowCaptcha.length - 1) * 10 / 2, Char.getMyChar().cy - 40, byteValue, 3);
                    }
                }
            }
            for (int index25 = 0; index25 < nso.GameScr.vSet.size(); index25++) {
                Set set = (Set) nso.GameScr.vSet.elementAt(index25);
            }
            for (int index26 = 0; index26 < vItemMap.size(); index26++) {
                ItemMap itemMap = (ItemMap) vItemMap.elementAt(index26);
                graphics11 = graphics;
                ItemMap itemMap27 = itemMap;
                if (itemMap.imgCaptcha != null && itemMap27.imgCaptcha.img != null) {
                    byte byteValue28 = 0;
                    if (itemMap27.status <= 0) {
                        byteValue28 = itemMap27.status;
                    }
                    graphics11.drawImage(itemMap27.imgCaptcha.img, itemMap27.x, itemMap27.y + byteValue28, 33);
                } else {
                    byte byteValue29 = 0;
                    if (itemMap27.status <= 0) {
                        byteValue29 = itemMap27.status;
                    }
                    SmallImage.drawSmallImage(graphics11, itemMap27.template.iconID, itemMap27.x, itemMap27.y + byteValue29, 0, 33);
                    if (Char.getMyChar().itemFocus != null && Char.getMyChar().itemFocus.equals(itemMap27) && itemMap27.status != 2) {
                        SmallImage.drawSmallImage(graphics11, 988, itemMap27.x, itemMap27.y - 20, 0, 3);
                    }
                }
            }
            for (int index30 = 0; index30 < vMobSoul.size(); index30++) {
                ((MobSoul) vMobSoul.elementAt(index30)).paint(graphics);
            }
            TileMap.paintOutTilemap(graphics);
            for (int index31 = 0; index31 < Effect2.vEffect2.size(); index31++) {
                ((Effect2) Effect2.vEffect2.elementAt(index31)).paint(graphics);
            }
            for (int index32 = 0; index32 < nso.GameScr.vItemTreeFront.size(); index32++) {
                ((ItemTree) nso.GameScr.vItemTreeFront.elementAt(index32)).paint(graphics);
            }
            if (!GameCanvas.lowGraphic) {
                for (int index33 = 0; index33 < Effect2.vAnimateEffect.size(); index33++) {
                    ((Effect2) Effect2.vAnimateEffect.elementAt(index33)).paint(graphics);
                }
            }
            for (int index34 = 0; index34 < nso.GameScr.vMobAttack.size(); index34++) {
                nso.GameScr.vMobAttack.elementAt(index34);
            }
            graphics11 = graphics;
            try {
                byte byteValue35;
                if ((byteValue35 = getTaskNpcId()) != -1) {
                    Npc npc = null;
                    for (int index36 = 0; index36 < vNpc.size(); index36++) {
                        Npc npc37;
                        if ((npc37 = (Npc) vNpc.elementAt(index36)).template.npcTemplateId == byteValue35) {
                            if (npc == null) {
                                npc = npc37;
                            } else if (Res.abs(npc37.cx - Char.getMyChar().cx) < Res.abs(npc.cx - Char.getMyChar().cx)) {
                                npc = npc37;
                            }
                        }
                    }
                    if (npc != null && npc.statusMe != 15 && (npc.cx <= cmx || npc.cx >= cmx + nso.GameScr.gW || npc.cy <= cmy || npc.cy >= cmy + gH) && GameCanvas.gameTick % 10 >= 5) {
                        int value38 = npc.cx - Char.getMyChar().cx;
                        int value39 = npc.cy - Char.getMyChar().cy;
                        int value40 = 0;
                        int value41 = 0;
                        byte byteValue42 = 0;
                        if (value38 > 0 && value39 >= 0) {
                            if (Res.abs(value38) >= Res.abs(value39)) {
                                value40 = nso.GameScr.gW - 10;
                                value41 = gH / 2 + 30;
                                if (GameCanvas.isTouch) {
                                    value41 = gH / 2 + 10;
                                }
                                byteValue42 = 0;
                            } else {
                                value40 = nso.GameScr.gW / 2;
                                value41 = gH - 10;
                                byteValue42 = 5;
                            }
                        } else if (value38 >= 0 && value39 < 0) {
                            if (Res.abs(value38) >= Res.abs(value39)) {
                                value40 = nso.GameScr.gW - 10;
                                value41 = gH / 2 + 30;
                                if (GameCanvas.isTouch) {
                                    value41 = gH / 2 + 10;
                                }
                                byteValue42 = 0;
                            } else {
                                value40 = nso.GameScr.gW / 2;
                                value41 = 10;
                                byteValue42 = 6;
                            }
                        }
                        if (value38 < 0 && value39 >= 0) {
                            if (Res.abs(value38) >= Res.abs(value39)) {
                                value40 = 10;
                                value41 = gH / 2 + 30;
                                if (GameCanvas.isTouch) {
                                    value41 = gH / 2 + 10;
                                }
                                byteValue42 = 3;
                            } else {
                                value40 = nso.GameScr.gW / 2;
                                value41 = gH - 10;
                                byteValue42 = 5;
                            }
                        } else if (value38 <= 0 && value39 < 0) {
                            if (Res.abs(value38) >= Res.abs(value39)) {
                                value40 = 10;
                                value41 = gH / 2 + 30;
                                if (GameCanvas.isTouch) {
                                    value41 = gH / 2 + 10;
                                }
                                byteValue42 = 3;
                            } else {
                                value40 = nso.GameScr.gW / 2;
                                value41 = 10;
                                byteValue42 = 6;
                            }
                        }
                        resetTranslate(graphics11);
                        SmallImage.drawSmallImage(graphics11, 992, value40, value41, byteValue42, StaticObj.VCENTER_HCENTER);
                    }
                }
            } catch (Exception exception60) {
            }
            graphics11 = graphics;
            gameScr = this;
            if (GameCanvas.isTouch) {
                resetTranslate(graphics11);
                gameScr.loadInforBar();
                int value43 = Char.getMyChar().cHP * hpBarW / Char.getMyChar().cMaxHP;
                int value44 = Char.getMyChar().cMP * mpBarW / Char.getMyChar().cMaxMP;
                int value45 = (int) (Char.getMyChar().cExpR * expBarW / exps[Char.getMyChar().clevel]);
                if (value43 > hpBarW) {
                    value43 = 0;
                }
                graphics11.setColor(-10585344);
                graphics11.fillRect(0, hpBarY - 10, expBarW, 3);
                graphics11.setColor(-10427136);
                graphics11.fillRect(0, hpBarY - 10, value45, 3);
                graphics11.setColor(-9756672);
                graphics11.fillRect(0, hpBarY - 10, expBarW, 1);
                graphics11.fillRect(0, hpBarY - 7, expBarW, 1);
                for (int index46 = 0; index46 < 10; index46++) {
                    graphics11.fillRect(index46 * expBarW / 10 - 1, hpBarY - 10, 1, 3);
                }
                graphics11.setColor(-1769452);
                graphics11.drawImage(nso.GameScr.imgTransparent, hpBarX - 1, hpBarY, 0);
                graphics11.fillRect(hpBarX, hpBarY, value43, 9);
                graphics11.setColor(-16755227);
                graphics11.drawImage(nso.GameScr.imgTransparent, hpBarX - 28, hpBarY + 13, 0);
                graphics11.fillRect(hpBarX, hpBarY + 16, value44, 7);
                graphics11.drawImage(nso.GameScr.imgTopBar, 0, hpBarY - 7, 0);
                mFont.number_white.drawString(graphics11, "" + Char.getMyChar().cHP, hpBarX + hpBarW / 2 - 30, hpBarY + 1, 0);
                mFont.number_white.drawString(graphics11, "" + Char.getMyChar().cMP, hpBarX + hpBarW / 2 - 30, hpBarY + 15, 0);
                mFont.tahoma_8b.drawString(graphics11, "" + Char.getMyChar().clevel, hpBarX - 27, hpBarY + 1, 2);
                long longValue = 0L;
                if (Char.getMyChar().cExpDown > 0L) {
                    longValue = Char.getMyChar().cExpDown * 10000L / exps[Char.getMyChar().clevel];
                } else {
                    longValue = Char.getMyChar().cExpR * 10000L / exps[Char.getMyChar().clevel];
                }
                int value47 = (int) (longValue % 100L);
                mFont.tahoma_7_white.drawString(graphics11, (Char.getMyChar().cExpDown > 0L ? "-" + longValue / 100L : "" + longValue / 100L) + "." + (value47 < 10 ? "0" + value47 : "" + value47) + "%", hpBarX - 27, hpBarY + 13, 2);
            }
            if (!Char.getMyChar().isCaptcha) {
                this.paintDebugInfo(graphics);
                resetTranslate(graphics);
                this.paintFoodEffect(graphics);
                resetTranslate(graphics);
                TileMap.paintMiniMap(graphics);
                graphics.translate(-graphics.getTranslateX(), -graphics.getTranslateY());
                if (!GameCanvas.isTouch || GameCanvas.isTouch && !GameCanvas.isTouchControl) {
                    mGraphics graphics48 = graphics;
                    graphics.setClip(0, nso.GameScr.cmdBarY - 4, GameCanvas.w, 100);
                    graphics48.setColor(3612190);
                    graphics48.fillRect(hpBarX - 44, hpBarY, 19, 19);
                    graphics48.setColor(265220);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 35, nso.GameScr.cmdBarFillWidth, 1);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 33, nso.GameScr.cmdBarFillWidth, 1);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 30, nso.GameScr.cmdBarFillWidth, 1);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 28, nso.GameScr.cmdBarFillWidth, 1);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 26, nso.GameScr.cmdBarFillWidth, 1);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 12, nso.GameScr.cmdBarFillWidth, 1);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 24, nso.GameScr.cmdBarFillWidth, 1);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 18, nso.GameScr.cmdBarFillWidth, 1);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 16, nso.GameScr.cmdBarFillWidth, 1);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 2, nso.GameScr.cmdBarFillWidth, 1);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 4, nso.GameScr.cmdBarFillWidth, 1);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 6, nso.GameScr.cmdBarFillWidth, 1);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 14, nso.GameScr.cmdBarFillWidth, 1);
                    graphics48.setColor(12562018);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 5, nso.GameScr.cmdBarFillWidth, 1);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 17, nso.GameScr.cmdBarFillWidth, 1);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 34, nso.GameScr.cmdBarFillWidth, 1);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 29, nso.GameScr.cmdBarFillWidth, 1);
                    graphics48.setColor(14667167);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 3, nso.GameScr.cmdBarFillWidth, 1);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 15, nso.GameScr.cmdBarFillWidth, 1);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 27, nso.GameScr.cmdBarFillWidth, 1);
                    graphics48.setColor(3355443);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 7, nso.GameScr.cmdBarFillWidth, 5);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 19, nso.GameScr.cmdBarFillWidth, 5);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 31, nso.GameScr.cmdBarFillWidth, 2);
                    graphics48.setColor(12281361);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 25, nso.GameScr.cmdBarFillWidth, 1);
                    graphics48.fillRect(nso.GameScr.cmdBarLeftWidth, nso.GameScr.cmdBarY + 13, nso.GameScr.cmdBarFillWidth, 1);
                    graphics48.drawImage(nso.GameScr.imgCmdBar[0], 0, nso.GameScr.cmdBarY + 2, 0);
                    graphics48.drawImage(nso.GameScr.imgCmdBar[1], 0 + nso.GameScr.cmdBarW, nso.GameScr.cmdBarY - 4, 24);
                    int value49;
                    if ((value49 = Char.getMyChar().cHP * hpBarW / Char.getMyChar().cMaxHP) > hpBarW) {
                        value49 = 0;
                    }
                    graphics48.setColor(7798784);
                    graphics48.fillRect(hpBarX, hpBarY, value49, 2);
                    graphics48.setColor(13369344);
                    graphics48.fillRect(hpBarX, hpBarY + 1, value49, 4);
                    int value50;
                    if ((value50 = Char.getMyChar().cMP * hpBarW / Char.getMyChar().cMaxMP) > hpBarW) {
                        value50 = 0;
                    }
                    graphics48.setColor(4488);
                    graphics48.fillRect(hpBarX, hpBarY + 12, value50, 2);
                    graphics48.setColor(4573);
                    graphics48.fillRect(hpBarX, hpBarY + 14, value50, nso.GameScr.mpBarHeight - 2);
                    int value51 = (int) (Char.getMyChar().cExpR * expBarW / exps[Char.getMyChar().clevel]);
                    graphics48.setColor(94373);
                    graphics48.fillRect(46, nso.GameScr.cmdBarY + 31, value51, 1);
                    graphics48.setColor(65535);
                    graphics48.fillRect(46, nso.GameScr.cmdBarY + 32, value51, 1);
                    mFont.number_yellow.drawString(graphics48, "" + Char.getMyChar().clevel, 28, nso.GameScr.cmdBarY + 9, 2);
                    long longValue52 = 0L;
                    if (Char.getMyChar().cExpDown > 0L) {
                        longValue52 = Char.getMyChar().cExpDown * 10000L / exps[Char.getMyChar().clevel];
                    } else {
                        longValue52 = Char.getMyChar().cExpR * 10000L / exps[Char.getMyChar().clevel];
                    }
                    int value53 = (int) (longValue52 % 100L);
                    mFont.tahoma_7_white.drawString(graphics48, (Char.getMyChar().cExpDown > 0L ? "-" + longValue52 / 100L : "" + longValue52 / 100L) + "." + (value53 < 10 ? "0" + value53 : "" + value53) + "%", 24, nso.GameScr.cmdBarY + 23, 2);
                    mFont.number_green.drawString(graphics48, "" + nso.GameScr.hpPotion, nso.GameScr.cmdBarW - 11, nso.GameScr.cmdBarY + 6, 2);
                    mFont.number_green.drawString(graphics48, "" + nso.GameScr.mpPotion, nso.GameScr.cmdBarW - 11, nso.GameScr.cmdBarY + 18, 2);
                    mFont.number_white.drawString(graphics48, "" + Char.getMyChar().cHP, hpBarX + hpBarW / 2, nso.GameScr.cmdBarY + 6, 2);
                    mFont.number_white.drawString(graphics48, "" + Char.getMyChar().cMP, hpBarX + hpBarW / 2, nso.GameScr.cmdBarY + 18, 2);
                    if (Char.getMyChar().vSkillFight.size() > 0 && Char.getMyChar().myskill != null) {
                        int value54 = nso.GameScr.cmdBarLeftWidth - 28;
                        int value55 = hpBarY + 7;
                        Char.getMyChar().myskill.paint(value54, value55, graphics48);
                    }
                    graphics48.setColor(9463099);
                    graphics48.fillRect(0, nso.GameScr.cmdBarY + 35, GameCanvas.w, 1);
                } else {
                    Paint.paintCommandBarBackground(graphics);
                }
                if (GameCanvas.isTouch) {
                    isPaintSelectSkill = true;
                }
                resetTranslate(graphics);
                this.paintSelectedSkill(graphics);
                resetTranslate(graphics);
                graphics.setClip(0, 0, GameCanvas.w, GameCanvas.h);
                for (int index56 = 0; index56 < Effect2.vEffect2Outside.size(); index56++) {
                    ((Effect2) Effect2.vEffect2Outside.elementAt(index56)).paint(graphics);
                }
                resetTranslate(graphics);
                if (isPaintInfoMe) {
                    graphics11 = graphics;
                    gameScr = this;
                    if (indexMenu == 0) {
                        gameScr.paintBag(graphics11, mResources.MENUME);
                    }
                    this.paintKyNang(graphics);
                    this.paintTiemNang(graphics);
                    graphics11 = graphics;
                    label581: if (indexMenu == 3) {
                        resetTranslate(graphics11);
                        Paint.paintFrame(popupX, popupY, popupW, popupH, graphics11);
                        if (indexTitle == 1) {
                            graphics11.setColor(Paint.COLORDARK);
                            graphics11.fillRect(popupX + 7, popupY + 32, popupW - 14, popupH - 40);
                            graphics11.setColor(16777215);
                        } else {
                            graphics11.setColor(10249521);
                        }
                        graphics11.drawRect(popupX + 7, popupY + 32, popupW - 14, popupH - 40);
                        paintTitle(graphics11, mResources.MENUME[indexMenu], true);
                        nso.GameScr.xstart = popupX + 17;
                        nso.GameScr.ystart = popupY + 34;
                        scrMain.setStyle(indexRowMax, 12, popupX, popupY + 35, popupW, popupH - 44, true, 1);
                        scrMain.setClip(graphics11);
                        if (nso.GameScr.typeViewInfo == 0) {
                            indexRowMax = 19;
                            int value57 = nso.GameScr.ystart;
                            if (currentCharViewInfo == null) {
                                break label581;
                            }
                            mFont.tahoma_7b_white.drawString(graphics11, mResources.inforMe[0] + currentCharViewInfo.cName, nso.GameScr.xstart, value57, 0);
                            String text = mResources.inforMe[1] + currentCharViewInfo.cPk;
                            value57 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text, nso.GameScr.xstart, value57, 0);
                            text = mResources.inforMe[2] + currentCharViewInfo.clevel;
                            value57 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text, nso.GameScr.xstart, value57, 0);
                            text = mResources.inforMe[3] + currentCharViewInfo.nClass.name;
                            value57 += 12;
                            mFont.tahoma_7_blue1.drawString(graphics11, text, nso.GameScr.xstart, value57, 0);
                            mFont font = mFont.tahoma_7_blue1;
                            text = mResources.inforMe[4] + mResources.SYS[currentCharViewInfo.getSys()];
                            value57 += 12;
                            font.drawString(graphics11, text, nso.GameScr.xstart, value57, 0);
                            text = mResources.inforMe[5] + currentCharViewInfo.cHP + "/" + currentCharViewInfo.cMaxHP;
                            value57 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text, nso.GameScr.xstart, value57, 0);
                            text = mResources.inforMe[6] + currentCharViewInfo.cMP + "/" + currentCharViewInfo.cMaxMP;
                            value57 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text, nso.GameScr.xstart, value57, 0);
                            font = mFont.tahoma_7_white;
                            text = mResources.inforMe[7] + currentCharViewInfo.getSpeed();
                            value57 += 12;
                            font.drawString(graphics11, text, nso.GameScr.xstart, value57, 0);
                            text = mResources.inforMe[8] + (currentCharViewInfo.cdame - currentCharViewInfo.cdame / 10) + "-" + currentCharViewInfo.cdame;
                            value57 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text, nso.GameScr.xstart, value57, 0);
                            text = mResources.inforMe[9] + currentCharViewInfo.cResFire;
                            value57 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text, nso.GameScr.xstart, value57, 0);
                            text = mResources.inforMe[10] + currentCharViewInfo.cResIce;
                            value57 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text, nso.GameScr.xstart, value57, 0);
                            text = mResources.inforMe[11] + currentCharViewInfo.cResWind;
                            value57 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text, nso.GameScr.xstart, value57, 0);
                            text = mResources.inforMe[12] + currentCharViewInfo.cdameDown;
                            value57 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text, nso.GameScr.xstart, value57, 0);
                            text = mResources.inforMe[13] + currentCharViewInfo.cExactly;
                            value57 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text, nso.GameScr.xstart, value57, 0);
                            text = mResources.inforMe[14] + currentCharViewInfo.cMiss;
                            value57 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text, nso.GameScr.xstart, value57, 0);
                            text = mResources.inforMe[15] + currentCharViewInfo.cFatal;
                            value57 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text, nso.GameScr.xstart, value57, 0);
                            text = mResources.inforMe[16] + currentCharViewInfo.cReactDame;
                            value57 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text, nso.GameScr.xstart, value57, 0);
                            text = mResources.inforMe[17] + currentCharViewInfo.sysUp;
                            value57 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text, nso.GameScr.xstart, value57, 0);
                            text = mResources.inforMe[18] + currentCharViewInfo.sysDown;
                            value57 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text, nso.GameScr.xstart, value57, 0);
                        } else if (nso.GameScr.typeViewInfo == 1) {
                            indexRowMax = 20;
                            int value58 = nso.GameScr.ystart;
                            if (currentCharViewInfo == null) {
                                break label581;
                            }
                            mFont.tahoma_7b_white.drawString(graphics11, mResources.inforMePoint[15] + (currentCharViewInfo.cClanName.equals("") ? mResources.NO_CLAN : currentCharViewInfo.cClanName), nso.GameScr.xstart, value58, 0);
                            String text59 = mResources.inforMePoint[0] + currentCharViewInfo.pointUydanh;
                            value58 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text59, nso.GameScr.xstart, value58, 0);
                            text59 = mResources.inforMePoint[11] + currentCharViewInfo.countFinishDay + "/20";
                            value58 += 12;
                            mFont.tahoma_7_blue1.drawString(graphics11, text59, nso.GameScr.xstart, value58, 0);
                            text59 = mResources.inforMePoint[12] + currentCharViewInfo.countLoopBoos + mResources.NUMBER;
                            value58 += 12;
                            mFont.tahoma_7_blue1.drawString(graphics11, text59, nso.GameScr.xstart, value58, 0);
                            text59 = mResources.inforMePoint[16] + currentCharViewInfo.countPB + mResources.NUMBER;
                            value58 += 12;
                            mFont.tahoma_7_blue1.drawString(graphics11, text59, nso.GameScr.xstart, value58, 0);
                            text59 = mResources.inforMePoint[13] + currentCharViewInfo.limitTiemnangso;
                            value58 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text59, nso.GameScr.xstart, value58, 0);
                            text59 = mResources.inforMePoint[14] + currentCharViewInfo.limitKynangso;
                            value58 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text59, nso.GameScr.xstart, value58, 0);
                            text59 = mResources.inforMePoint[18] + currentCharViewInfo.limitPhongLoi + mResources.NUMBER;
                            value58 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text59, nso.GameScr.xstart, value58, 0);
                            text59 = mResources.inforMePoint[19] + currentCharViewInfo.limitBangHoa + mResources.NUMBER;
                            value58 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text59, nso.GameScr.xstart, value58, 0);
                            text59 = mResources.inforMePoint[17] + currentCharViewInfo.pointTinhTu;
                            value58 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text59, nso.GameScr.xstart, value58, 0);
                            text59 = mResources.inforMePoint[1] + currentCharViewInfo.pointVukhi;
                            value58 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text59, nso.GameScr.xstart, value58, 0);
                            text59 = mResources.inforMePoint[2] + currentCharViewInfo.pointLien;
                            value58 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text59, nso.GameScr.xstart, value58, 0);
                            text59 = mResources.inforMePoint[3] + currentCharViewInfo.pointNhan;
                            value58 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text59, nso.GameScr.xstart, value58, 0);
                            text59 = mResources.inforMePoint[4] + currentCharViewInfo.pointNgocboi;
                            value58 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text59, nso.GameScr.xstart, value58, 0);
                            text59 = mResources.inforMePoint[5] + currentCharViewInfo.pointPhu;
                            value58 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text59, nso.GameScr.xstart, value58, 0);
                            text59 = mResources.inforMePoint[6] + currentCharViewInfo.pointNon;
                            value58 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text59, nso.GameScr.xstart, value58, 0);
                            text59 = mResources.inforMePoint[7] + currentCharViewInfo.pointAo;
                            value58 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text59, nso.GameScr.xstart, value58, 0);
                            text59 = mResources.inforMePoint[8] + currentCharViewInfo.pointGangtay;
                            value58 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text59, nso.GameScr.xstart, value58, 0);
                            text59 = mResources.inforMePoint[9] + currentCharViewInfo.pointQuan;
                            value58 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text59, nso.GameScr.xstart, value58, 0);
                            text59 = mResources.inforMePoint[10] + currentCharViewInfo.pointGiay;
                            value58 += 12;
                            mFont.tahoma_7_white.drawString(graphics11, text59, nso.GameScr.xstart, value58, 0);
                        }
                        if (indexTitle == 1 && indexRow >= 0) {
                            SmallImage.drawSmallImage(graphics11, 942, nso.GameScr.xstart - 8, nso.GameScr.ystart + 2 + indexRow * 12, 0, StaticObj.TOP_LEFT);
                        }
                    }
                    this.paintTrangbi(graphics);
                    this.paintThuCuoi(graphics);
                    this.paintBijuu(graphics);
                } else if (isPaintUI()) {
                    graphics11 = graphics;
                    gameScr = this;
                    if (isPaintStore) {
                        if (indexMenu == 0) {
                            gameScr.paintItemList(graphics11, mResources.TITLESTORE, nso.GameScr.arrItemStore);
                        } else if (indexMenu == 1) {
                            gameScr.paintItemList(graphics11, mResources.TITLESTORE, nso.GameScr.arrItemBook);
                        } else if (indexMenu == 2) {
                            gameScr.paintItemList(graphics11, mResources.TITLESTORE, nso.GameScr.arrItemFashion);
                        } else if (indexMenu == 3) {
                            gameScr.paintItemList(graphics11, mResources.TITLESTORE, nso.GameScr.arrItemClanShop);
                        } else if (indexMenu == 52) {
                            gameScr.paintShopOnline(graphics11, nso.GameScr.arrItemFashion);
                        }
                    }
                    graphics11 = graphics;
                    gameScr = this;
                    if (nso.GameScr.isPaintNonNam) {
                        if (indexMenu == 0) {
                            gameScr.paintItemList(graphics11, mResources.TITLECLOTHE, nso.GameScr.arrItemNonNam);
                        } else if (indexMenu == 1) {
                            gameScr.paintBag(graphics11, mResources.TITLENON);
                        }
                    }
                    graphics11 = graphics;
                    gameScr = this;
                    if (nso.GameScr.isPaintNonNu) {
                        if (indexMenu == 0) {
                            gameScr.paintItemList(graphics11, mResources.TITLECLOTHE, nso.GameScr.arrItemNonNu);
                        } else if (indexMenu == 1) {
                            gameScr.paintBag(graphics11, mResources.TITLENON);
                        }
                    }
                    graphics11 = graphics;
                    gameScr = this;
                    if (nso.GameScr.isPaintAoNam) {
                        if (indexMenu == 0) {
                            gameScr.paintItemList(graphics11, mResources.TITLECLOTHE, nso.GameScr.arrItemAoNam);
                        } else if (indexMenu == 1) {
                            gameScr.paintBag(graphics11, mResources.TITLEAO);
                        }
                    }
                    graphics11 = graphics;
                    gameScr = this;
                    if (nso.GameScr.isPaintAoNu) {
                        if (indexMenu == 0) {
                            gameScr.paintItemList(graphics11, mResources.TITLECLOTHE, nso.GameScr.arrItemAoNu);
                        } else if (indexMenu == 1) {
                            gameScr.paintBag(graphics11, mResources.TITLEAO);
                        }
                    }
                    graphics11 = graphics;
                    gameScr = this;
                    if (nso.GameScr.isPaintGangTayNam) {
                        if (indexMenu == 0) {
                            gameScr.paintItemList(graphics11, mResources.TITLECLOTHE, nso.GameScr.arrItemGangTayNam);
                        } else if (indexMenu == 1) {
                            gameScr.paintBag(graphics11, mResources.TITLEGANGTAY);
                        }
                    }
                    graphics11 = graphics;
                    gameScr = this;
                    if (nso.GameScr.isPaintGangTayNu) {
                        if (indexMenu == 0) {
                            gameScr.paintItemList(graphics11, mResources.TITLECLOTHE, nso.GameScr.arrItemGangTayNu);
                        } else if (indexMenu == 1) {
                            gameScr.paintBag(graphics11, mResources.TITLEGANGTAY);
                        }
                    }
                    graphics11 = graphics;
                    gameScr = this;
                    if (nso.GameScr.isPaintQuanNam) {
                        if (indexMenu == 0) {
                            gameScr.paintItemList(graphics11, mResources.TITLECLOTHE, nso.GameScr.arrItemQuanNam);
                        } else if (indexMenu == 1) {
                            gameScr.paintBag(graphics11, mResources.TITLEQUAN);
                        }
                    }
                    graphics11 = graphics;
                    gameScr = this;
                    if (nso.GameScr.isPaintQuanNu) {
                        if (indexMenu == 0) {
                            gameScr.paintItemList(graphics11, mResources.TITLEQUAN, nso.GameScr.arrItemQuanNu);
                        } else if (indexMenu == 1) {
                            gameScr.paintBag(graphics11, mResources.TITLEQUAN);
                        }
                    }
                    graphics11 = graphics;
                    gameScr = this;
                    if (nso.GameScr.isPaintGiayNam) {
                        if (indexMenu == 0) {
                            gameScr.paintItemList(graphics11, mResources.TITLECLOTHE, nso.GameScr.arrItemGiayNam);
                        } else if (indexMenu == 1) {
                            gameScr.paintBag(graphics11, mResources.TITLEGIAY);
                        }
                    }
                    graphics11 = graphics;
                    gameScr = this;
                    if (nso.GameScr.isPaintGiayNu) {
                        if (indexMenu == 0) {
                            gameScr.paintItemList(graphics11, mResources.TITLECLOTHE, nso.GameScr.arrItemGiayNu);
                        } else if (indexMenu == 1) {
                            gameScr.paintBag(graphics11, mResources.TITLEGIAY);
                        }
                    }
                    graphics11 = graphics;
                    gameScr = this;
                    if (nso.GameScr.isPaintLien) {
                        if (indexMenu == 0) {
                            gameScr.paintItemList(graphics11, mResources.TITLEDAYCHUYEN, nso.GameScr.arrItemLien);
                        } else if (indexMenu == 1) {
                            gameScr.paintBag(graphics11, mResources.TITLEDAYCHUYEN);
                        }
                    }
                    graphics11 = graphics;
                    gameScr = this;
                    if (nso.GameScr.isPaintNhan) {
                        if (indexMenu == 0) {
                            gameScr.paintItemList(graphics11, mResources.TITLENHAN, nso.GameScr.arrItemNhan);
                        } else if (indexMenu == 1) {
                            gameScr.paintBag(graphics11, mResources.TITLENHAN);
                        }
                    }
                    graphics11 = graphics;
                    gameScr = this;
                    if (nso.GameScr.isPaintNgocBoi) {
                        if (indexMenu == 0) {
                            gameScr.paintItemList(graphics11, mResources.TITLENGOCBOI, nso.GameScr.arrItemNgocBoi);
                        } else if (indexMenu == 1) {
                            gameScr.paintBag(graphics11, mResources.TITLENGOCBOI);
                        }
                    }
                    graphics11 = graphics;
                    gameScr = this;
                    if (nso.GameScr.isPaintPhu) {
                        if (indexMenu == 0) {
                            gameScr.paintItemList(graphics11, mResources.TITLEPHU, nso.GameScr.arrItemPhu);
                        } else if (indexMenu == 1) {
                            gameScr.paintBag(graphics11, mResources.TITLEPHU);
                        }
                    }
                    graphics11 = graphics;
                    gameScr = this;
                    if (nso.GameScr.isPaintWeapon) {
                        if (indexMenu == 0) {
                            gameScr.paintItemList(graphics11, mResources.TITLEWEAPON, nso.GameScr.arrItemWeapon);
                        } else if (indexMenu == 1) {
                            gameScr.paintBag(graphics11, mResources.TITLEWEAPON);
                        }
                    }
                    graphics11 = graphics;
                    gameScr = this;
                    if (nso.GameScr.isPaintEliteShop) {
                        gameScr.paintItemList(graphics11, mResources.TITLEELITESHOP, nso.GameScr.arrItemElites);
                    }
                    this.paintUILuckySprin(graphics);
                    this.paintThuoc(graphics);
                    this.paintThuocKhoa(graphics);
                    this.paintTaphoa(graphics);
                    this.paintTaphoakhoa(graphics);
                    this.paintCuonghoa(graphics);
                    this.paintGianHang(graphics);
                    this.PaintAuctionBuy(graphics);
                    this.paintChuyenHoa(graphics);
                    this.paintTachHT(graphics);
                    this.paintLuyenThu(graphics);
                    this.paintLuyenAo(graphics);
                    this.paintGhepngoc(graphics);
                    this.paintLuyenThach(graphics);
                    this.paintRuong(graphics);
                    this.paintItemTrade(graphics);
                    this.paintLuyenNgoc(graphics);
                    this.paintCheDo(graphics);
                    this.paintKhamNgoc(graphics);
                    this.paintGiaoDo(graphics);
                    this.paintGotNgoc(graphics);
                    this.paintThaoNgoc(graphics);
                } else if (isPaintZone) {
                    this.paintZone(graphics);
                }
                this.paintUIAuto(graphics);
                this.paintTask(graphics);
                this.paintCharInMap(graphics);
                this.paintTeam(graphics);
                this.paintFindTeam(graphics);
                this.paintFriend(graphics);
                this.paintList(graphics);
                this.paintClanInfo(graphics);
                this.paintItemInfo(graphics);
                this.paintListRanked(graphics);
                resetTranslate(graphics);
                if (GameCanvas.isTouch && GameCanvas.w >= 320) {
                    if (super.left != null && super.left != this.menu) {
                        super.left.x = GameCanvas.w / 2 - 160;
                        super.left.y = GameCanvas.h - 26;
                    }
                    if (super.center != null) {
                        super.center.x = GameCanvas.w / 2 - 35;
                        super.center.y = GameCanvas.h - 26;
                    }
                    if (super.right != null && super.right != this.cmdFocus) {
                        super.right.x = GameCanvas.w / 2 + 88;
                        super.right.y = GameCanvas.h - 26;
                    }
                }
            }
            super.paint(graphics);
            if (GameCanvas.isTouch && GameCanvas.isTouchControl) {
                this.paintTouchControl(graphics);
                isPaintSelectSkill = true;
            }
            paintTime(graphics);
            resetTranslate(graphics);
            this.paintAlert(graphics);
            resetTranslate(graphics);
            this.paintLucky_Draw(graphics);
            resetTranslate(graphics);
            Info.paint(graphics);
            resetTranslate(graphics);
            ChatTextField.gI().paint(graphics);
            resetTranslate(graphics);
            InfoMe.paint(graphics);
        }
    }

    private void paintUIAuto(mGraphics g) {
        if (isPaintAuto) {
            resetTranslate(g);
            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
            if (indexTitle == 1) {
                g.setColor(Paint.COLORDARK);
                g.fillRect(popupX + 7, popupY + 32, popupW - 14, popupH - 55);
                g.setColor(16777215);
            } else {
                g.setColor(10249521);
            }
            g.drawRect(popupX + 7, popupY + 32, popupW - 14, popupH - 55);
            paintTitle(g, mResources.ACTIONS[7], false);
            nso.GameScr.xstart = popupX + 17;
            nso.GameScr.ystart = popupY + 45;
            indexRowMax = 7;
            scrMain.setStyle(indexRowMax, 35, popupX, popupY + 39, popupW, popupH - 63, true, 1);
            scrMain.setClip(g);
            int value = nso.GameScr.ystart;
            paintCheckBox(g, mResources.AUTO_TEXT[0], Char.isAHP, Char.aHpValue + "%", nso.GameScr.xstart, value);
            String text = mResources.AUTO_TEXT[1];
            String text1 = Char.aMpValue + "%";
            int value2 = value + 30;
            paintCheckBox(g, text, Char.isAMP, text1, nso.GameScr.xstart, value2);
            text = mResources.AUTO_TEXT[2];
            boolean flag = Char.isAFood;
            text1 = String.valueOf(Char.aFoodValue);
            int value3 = value2 + 30;
            paintCheckBox(g, text, flag, text1, nso.GameScr.xstart, value3);
            text = mResources.AUTO_TEXT[3];
            int value4 = value3 + 30;
            paintCheckBox(g, text, Char.isABuff, "", nso.GameScr.xstart, value4);
            text = mResources.AUTO_TEXT[4];
            int value5 = value4 + 30;
            paintCheckBox(g, text, Char.isAPickYen, "", nso.GameScr.xstart, value5);
            text = mResources.AUTO_TEXT[5];
            int value6 = value5 + 30;
            paintCheckBox(g, text, Char.isAPickYHM, "", nso.GameScr.xstart, value6);
            text = mResources.AUTO_TEXT[6];
            int value7 = value6 + 30;
            paintCheckBox(g, text, Char.isAPickYHMS, "", nso.GameScr.xstart, value7);
            text = mResources.AUTO_TEXT[7];
            int value8 = value7 + 30;
            paintCheckBox(g, text, Char.isANoPick, "", nso.GameScr.xstart, value8);
            if (indexTitle == 1 && indexRow >= 0 && !GameCanvas.isTouch) {
                SmallImage.drawSmallImage(g, 942, nso.GameScr.xstart - 8, nso.GameScr.ystart + 2 + indexRow * 30, 0, StaticObj.TOP_LEFT);
            }
            resetTranslate(g);
            mFont.tahoma_7_green.drawString(g, GameCanvas.isTouch ? mResources.AUTO_TIP2 : mResources.AUTO_TIP1, popupX + popupW / 2, popupY + popupH - 17, 2);
        }
    }

    private static void paintCheckBox(mGraphics graphics, String text, boolean flag, String text1, int value, int value2) {
        graphics.setColor(16777215);
        graphics.fillRect(value, value2, 12, 12);
        if (flag) {
            graphics.setColor(9650442);
            graphics.drawLine(value + 2, value2 + 2, value + 2 + 7, value2 + 2 + 7);
            graphics.drawLine(value + 2, value2 + 2 + 7, value + 2 + 7, value2 + 2);
        }
        mFont font;
        (font = flag ? mFont.tahoma_7_white : mFont.tahoma_7_grey).drawString(graphics, text, value + 18, value2, 0);
        if (!text1.equals("")) {
            graphics.setColor(Paint.COLORLIGHT);
            graphics.fillRect(value + 115, value2 - 3, 30, 20);
            graphics.setColor(flag ? 16777215 : 0);
            graphics.drawRect(value + 115, value2 - 3, 30, 20);
            font.drawString(graphics, text1, value + 133, value2 + 2, 2);
        }
    }

    private void paintList(mGraphics g) {
        if (isPaintList) {
            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
            paintTitle(g, mResources.LIST, false);
            nso.GameScr.xstart = popupX + 5;
            nso.GameScr.ystart = popupY + 40;
            if (vList.size() == 0) {
                mFont.tahoma_7_white.drawString(g, mResources.EMPTY_INFO, popupX + popupW / 2, popupY + 40, 2);
                return;
            }
            g.setColor(-16770791);
            g.fillRect(nso.GameScr.xstart - 2, nso.GameScr.ystart - 2, popupW - 6, indexSize * 5 + 8);
            resetTranslate(g);
            scrMain.setStyle(vList.size(), indexSize, nso.GameScr.xstart, nso.GameScr.ystart, popupW - 3, indexSize * 5 + 4, true, 1);
            scrMain.setClip(g, nso.GameScr.xstart, nso.GameScr.ystart, popupW - 3, indexSize * 5 + 6);
            indexRowMax = vList.size();
            for (int index = 0; index < vList.size(); index++) {
                DunItem dunItem = null;
                try {
                    dunItem = (DunItem) vList.elementAt(index);
                } catch (Exception exception) {
                }
                if (dunItem != null) {
                    if (indexRow == index) {
                        g.setColor(Paint.COLORLIGHT);
                        g.fillRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + indexRow * indexSize + 2, popupW - 15, indexSize - 4);
                        g.setColor(16777215);
                        g.drawRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + indexRow * indexSize + 2, popupW - 15, indexSize - 4);
                    } else {
                        g.setColor(Paint.COLORBACKGROUND);
                        g.fillRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + index * indexSize + 2, popupW - 15, indexSize - 4);
                        g.setColor(13932896);
                        g.drawRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + index * indexSize + 2, popupW - 15, indexSize - 4);
                    }
                    mFont.tahoma_7_yellow.drawString(g, dunItem.name1, nso.GameScr.xstart + (popupW - 10) / 2 - popupW / 4, nso.GameScr.ystart + index * indexSize + indexSize / 2 - 6, 2);
                    mFont.tahoma_7b_red.drawString(g, " vs ", nso.GameScr.xstart + (popupW - 10) / 2, nso.GameScr.ystart + index * indexSize + indexSize / 2 - 6, 2);
                    mFont.tahoma_7_yellow.drawString(g, dunItem.name2, nso.GameScr.xstart + (popupW - 10) / 2 + popupW / 4, nso.GameScr.ystart + index * indexSize + indexSize / 2 - 6, 2);
                }
            }
            paintNumCount(g);
        }
    }

    private void paintCharInMap(mGraphics g) {
        if (isPaintCharInMap) {
            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
            paintTitle(g, mResources.LIST, false);
            nso.GameScr.xstart = popupX + 5;
            nso.GameScr.ystart = popupY + 40;
            if (vCharInMap.size() == 0) {
                mFont.tahoma_7_white.drawString(g, mResources.NO_ONE, popupX + popupW / 2, popupY + 40, 2);
                return;
            }
            g.setColor(-16770791);
            g.fillRect(nso.GameScr.xstart - 2, nso.GameScr.ystart - 2, popupW - 6, indexSize * 5 + 8);
            resetTranslate(g);
            scrMain.setStyle(vCharInMap.size(), indexSize, nso.GameScr.xstart, nso.GameScr.ystart, popupW - 3, indexSize * 5 + 4, true, 1);
            scrMain.setClip(g, nso.GameScr.xstart, nso.GameScr.ystart, popupW - 3, indexSize * 5 + 6);
            indexRowMax = vCharInMap.size();
            for (int index = 0; index < vCharInMap.size(); index++) {
                Char character = null;
                try {
                    if ((character = (Char) vCharInMap.elementAt(index)).isNhanbanz()) {
                        continue;
                    }
                } catch (Exception exception) {
                }
                if (character != null) {
                    if (indexRow == index) {
                        g.setColor(Paint.COLORLIGHT);
                        g.fillRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + indexRow * indexSize + 2, popupW - 15, indexSize - 4);
                        g.setColor(16777215);
                        g.drawRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + indexRow * indexSize + 2, popupW - 15, indexSize - 4);
                    } else {
                        g.setColor(Paint.COLORBACKGROUND);
                        g.fillRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + index * indexSize + 2, popupW - 15, indexSize - 4);
                        g.setColor(13932896);
                        g.drawRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + index * indexSize + 2, popupW - 15, indexSize - 4);
                    }
                    SmallImage.drawSmallImage(g, 647, nso.GameScr.xstart + 12, nso.GameScr.ystart + index * indexSize + indexSize / 2, 0, 3);
                    if (this.cLastFocusID > 0 && this.cLastFocusID == character.charID) {
                        mFont.tahoma_7_yellow.drawString(g, character.cName + " - " + mResources.level + ": " + character.clevel, nso.GameScr.xstart + 22, nso.GameScr.ystart + index * indexSize + indexSize / 2 - 6, 0);
                    } else if (character.statusMe == 14) {
                        mFont.tahoma_7_grey.drawString(g, character.cName + " - " + mResources.level + ": " + character.clevel, nso.GameScr.xstart + 22, nso.GameScr.ystart + index * indexSize + indexSize / 2 - 6, 0);
                    } else {
                        mFont.tahoma_7_green.drawString(g, character.cName + " - " + mResources.level + ": " + character.clevel, nso.GameScr.xstart + 22, nso.GameScr.ystart + index * indexSize + indexSize / 2 - 6, 0);
                    }
                }
            }
            paintNumCount(g);
        }
    }

    private void paintFoodEffect(mGraphics graphics) {
        try {
            int value = (int) (System.currentTimeMillis() / 1000L);
            int value1 = 5;
            if (GameCanvas.isTouch && GameCanvas.isTouchControl) {
                value1 = 45 + Info.hI;
            }
            if (GameCanvas.isTouchControlSmallScreen && Char.getMyChar().vSkillFight.size() > 4) {
                value1 += 25;
            }
            resetTranslate(graphics);
            if (!GameCanvas.isTouchControlLargeScreen) {
                int value2 = 0;
                for (int index = 0; index < Char.getMyChar().vEff.size(); index++) {
                    Effect effect = (Effect) Char.getMyChar().vEff.elementAt(index);
                    SmallImage.drawSmallImage(graphics, effect.template.iconId, GameCanvas.w - 13 - (index * 13 << 1), value1 + 14, 0, 33);
                    if ((value2 = effect.timeLenght - (value - effect.timeStart)) >= 0) {
                        mFont.tahoma_7_white.drawString(graphics, NinjaUtil.getTime(value2), GameCanvas.w - 13 - (index * 13 << 1), value1 + 15, 2, mFont.tahoma_7_grey);
                    }
                }
                value2 = this.timeLengthMap - (value - this.timeStartMap);
                if (Char.getMyChar().vEff.size() > 0) {
                    value1 += 27;
                }
                if (value2 > 0) {
                    mFont.tahoma_7_white.drawString(graphics, mResources.TIME + ": " + NinjaUtil.getTime(value2), GameCanvas.w - 2, value1, 1, mFont.tahoma_7_grey);
                    value1 += 12;
                }
                if (TileMap.typeMap == 1) {
                    mFont.tahoma_7_white.drawString(graphics, mResources.ACHIEVEMENT + ": " + Char.getMyChar().countKill, GameCanvas.w - 2, value1, 1, mFont.tahoma_7_grey);
                    value1 += 12;
                    mFont.tahoma_7_white.drawString(graphics, mResources.MAX + ": " + Char.getMyChar().countKillMax, GameCanvas.w - 2, value1, 1, mFont.tahoma_7_grey);
                    value1 += 12;
                } else if (TileMap.typeMap == 2 || TileMap.mapID == 114 || TileMap.mapID == 115 || TileMap.mapID == 116) {
                    mFont.tahoma_7_white.drawString(graphics, mResources.PROPERTY + ": " + Char.pointPB, GameCanvas.w - 2, value1, 1, mFont.tahoma_7_grey);
                    value1 += 12;
                } else if (TileMap.typeMap == 3) {
                    mFont.tahoma_7_white.drawString(graphics, mResources.PROPERTY + ": " + Char.pointChienTruong, GameCanvas.w - 2, value1, 1, mFont.tahoma_7_grey);
                    value1 += 12;
                    mFont.tahoma_7_white.drawString(graphics, mResources.TITLE_CT[Char.getCT()], GameCanvas.w - 2, value1, 1, mFont.tahoma_7_grey);
                    value1 += 12;
                }
            }
            if (vParty.size() > 0 && GameCanvas.w > 128 && !isPaintUI()) {
                value1 -= 18;
                for (int index3 = 0; index3 < vParty.size(); index3++) {
                    Party party;
                    if ((party = (Party) vParty.elementAt(index3)).c != null) {
                        String text = party.name + "(" + party.c.clevel + ")";
                        int value4 = GameCanvas.w - 14;
                        value1 += 18;
                        mFont.tahoma_7_white.drawString(graphics, text, value4, value1, 1, mFont.tahoma_7_grey);
                        party.c.paintHp(graphics, GameCanvas.w - 41, value1 + 12);
                        SmallImage.drawSmallImage(graphics, party.iconId, GameCanvas.w - 7, value1 + 9, 0, 3);
                    } else {
                        value1 += 16;
                        mFont.tahoma_7_green.drawString(graphics, party.name, GameCanvas.w - 14, value1 + 5, 1, mFont.tahoma_7_grey);
                        SmallImage.drawSmallImage(graphics, party.iconId, GameCanvas.w - 7, value1 + 11, 0, 3);
                    }
                }
                return;
            }
        } catch (Exception exception) {
        }
    }

    public static void resetTranslate(mGraphics g) {
        g.translate(-g.getTranslateX(), -g.getTranslateY());
        g.setClip(0, -200, GameCanvas.w, 200 + GameCanvas.h);
    }

    private void paintDebugInfo(mGraphics g) {
        try {
            if (!GameCanvas.menu.showMenu) {
                if (!InfoDlg.isShow) {
                    if (!isPaintPopup()) {
                        int value = -7;
                        byte byteValue = 3;
                        if ((!GameCanvas.isTouch || GameCanvas.isTouch && !GameCanvas.isTouchControl) && isPaintSelectSkill) {
                            byteValue += 30;
                        }
                        if (GameCanvas.isTouch) {
                            value = -7 + 45 + Info.hI;
                            if (GameCanvas.isTouchControlSmallScreen) {
                                value += 35;
                            }
                        }
                        g.translate(-g.getTranslateX(), -g.getTranslateY());
                        if (GameCanvas.isTouchControlLargeScreen) {
                            int value1 = (int) (System.currentTimeMillis() / 1000L);
                            for (int index = 0; index < Char.getMyChar().vEff.size(); index++) {
                                Effect effect = (Effect) Char.getMyChar().vEff.elementAt(index);
                                SmallImage.drawSmallImage(g, effect.template.iconId, byteValue + 13 + (index * 13 << 1), value + 27, 0, 33);
                                int value2;
                                if ((value2 = effect.timeLenght - (value1 - effect.timeStart)) >= 0) {
                                    mFont.tahoma_7_white.drawString(g, NinjaUtil.getTime(value2), byteValue + 13 + (index * 13 << 1), value + 28, 2, mFont.tahoma_7_grey);
                                }
                            }
                            int value3 = this.timeLengthMap - (value1 - this.timeStartMap);
                            if (Char.getMyChar().vEff.size() > 0) {
                                value += 27;
                            }
                            if (value3 > 0) {
                                mFont font = mFont.tahoma_7_white;
                                String text = mResources.TIME + ": " + NinjaUtil.getTime(value3);
                                value += 12;
                                font.drawString(g, text, byteValue, value, 0, mFont.tahoma_7_grey);
                            }
                        }
                        if (Char.getMyChar().clevel <= 20) {
                            if (Char.getMyChar().pPoint > 0) {
                                String text4 = "+" + Char.getMyChar().pPoint + " " + mResources.POTENIAL;
                                value += 12;
                                mFont.tahoma_7_yellow.drawString(g, text4, byteValue, value, 0, mFont.tahoma_7_grey);
                            }
                            if (Char.getMyChar().sPoint > 0) {
                                String text5 = "+" + Char.getMyChar().sPoint + " " + mResources.SKILL_PT;
                                value += 12;
                                mFont.tahoma_7_yellow.drawString(g, text5, byteValue, value, 0, mFont.tahoma_7_grey);
                            }
                        }
                        if (ChatManager.gI().waitList.size() > 0) {
                            this.xM[0] = byteValue;
                            this.yM[0] = value + 12;
                            String text6 = "+" + ChatManager.gI().waitList.size() + " " + mResources.private_message;
                            if (GameCanvas.gameTick % 10 > 4) {
                                value += 12;
                                mFont.tahoma_7_red.drawString(g, text6, byteValue, value, 0, mFont.tahoma_7_grey);
                            } else {
                                value += 12;
                                mFont.tahoma_7_yellow.drawString(g, text6, byteValue, value, 0, mFont.tahoma_7_grey);
                            }
                        }
                        if (ChatManager.isMessageClan || ChatManager.isMessagePt) {
                            String text7 = "";
                            this.xM[1] = byteValue;
                            this.yM[1] = value + 12;
                            if (ChatManager.isMessageClan && ChatManager.isMessagePt) {
                                text7 = mResources.CLANPT_MESSAGE[0];
                            } else if (ChatManager.isMessageClan) {
                                text7 = mResources.CLANPT_MESSAGE[1];
                            } else if (ChatManager.isMessagePt) {
                                text7 = mResources.CLANPT_MESSAGE[2];
                            }
                            if (GameCanvas.gameTick % 10 > 7) {
                                value += 12;
                                mFont.tahoma_7_red.drawString(g, text7, byteValue, value, 0, mFont.tahoma_7_grey);
                            } else {
                                value += 12;
                                mFont.tahoma_7_yellow.drawString(g, text7, byteValue, value, 0, mFont.tahoma_7_grey);
                            }
                        }
                        if (TileMap.typeMap != 3) {
                            if (Char.getMyChar().isHumanz()) {
                                if (Char.getMyChar().taskMaint != null) {
                                    String text8 = Char.getMyChar().taskMaint.subNames[Char.getMyChar().taskMaint.index];
                                    for (int index9 = 0; text8 == null; text8 = Char.getMyChar().taskMaint.subNames[Char.getMyChar().taskMaint.index - index9]) {
                                        index9++;
                                    }
                                    if (Char.getMyChar().taskMaint.counts[Char.getMyChar().taskMaint.index] != -1) {
                                        text8 = text8 + " " + Char.getMyChar().taskMaint.count + "/" + Char.getMyChar().taskMaint.counts[Char.getMyChar().taskMaint.index];
                                    }
                                    if (GameCanvas.taskTick > 0 && GameCanvas.gameTick % 10 > 4) {
                                        value += 12;
                                        mFont.tahoma_7_yellow.drawString(g, text8, byteValue, value, 0, mFont.tahoma_7_grey);
                                    } else {
                                        value += 12;
                                        mFont.tahoma_7_white.drawString(g, text8, byteValue, value, 0, mFont.tahoma_7_grey);
                                    }
                                } else {
                                    byte byteValue10;
                                    if ((byteValue10 = getTaskMapId()) >= 0) {
                                        String text11 = mResources.TASK_RECEIVE + " " + TileMap.mapNames[byteValue10];
                                        value += 12;
                                        mFont.tahoma_7_white.drawString(g, text11, byteValue, value, 0, mFont.tahoma_7_grey);
                                    }
                                }
                            }
                        } else if (Char.getMyChar().charFocus != null) {
                            if (Char.getMyChar().charFocus.cTypePk == 4) {
                                value += 12;
                                mFont.tahoma_7_white.drawString(g, mResources.WHITE_PARTY, byteValue, value, 0, mFont.tahoma_7_grey);
                            } else if (Char.getMyChar().charFocus.cTypePk == 5) {
                                value += 12;
                                mFont.tahoma_7_white.drawString(g, mResources.BLACK_PARTY, byteValue, value, 0, mFont.tahoma_7_grey);
                            } else if (Char.getMyChar().charFocus.cTypePk == 6) {
                                value += 12;
                                mFont.tahoma_7_white.drawString(g, mResources.PHE3_PARTY, byteValue, value, 0, mFont.tahoma_7_grey);
                            }
                        } else if (Char.getMyChar().mobFocus != null) {
                            if (Char.getMyChar().mobFocus.templateId == 96) {
                                value += 12;
                                mFont.tahoma_7_white.drawString(g, mResources.BLACK_PARTY, byteValue, value, 0, mFont.tahoma_7_grey);
                            } else if (Char.getMyChar().mobFocus.templateId == 97) {
                                value += 12;
                                mFont.tahoma_7_white.drawString(g, mResources.WHITE_PARTY, byteValue, value, 0, mFont.tahoma_7_grey);
                            } else if (Char.getMyChar().mobFocus.templateId == 93) {
                                value += 12;
                                mFont.tahoma_7_white.drawString(g, mResources.PHE3_PARTY, byteValue, value, 0, mFont.tahoma_7_grey);
                            } else {
                                value += 12;
                                mFont.tahoma_7_white.drawString(g, mResources.NEUTRAL, byteValue, value, 0, mFont.tahoma_7_grey);
                            }
                        }
                        if (Char.getMyChar().mobFocus != null) {
                            MobTemplate mobTemplate = Char.getMyChar().mobFocus.getTemplate();
                            String text12 = mobTemplate.name + " lv" + Char.getMyChar().mobFocus.level;
                            if (Char.getMyChar().mobFocus.templateId != 0 && Char.getMyChar().mobFocus.templateId != 142 && Char.getMyChar().mobFocus.templateId != 143) {
                                text12 = text12 + ": " + Char.getMyChar().mobFocus.hp + "/" + Char.getMyChar().mobFocus.maxHp;
                            }
                            g.setColor(Char.getMyChar().mobFocus.getHPColor());
                            value += 12;
                            g.fillRect(byteValue, value + 3, 5, 5);
                            g.setColor(0);
                            g.drawRect(byteValue, value + 3, 5, 5);
                            mFont.tahoma_7_white.drawString(g, text12, byteValue + 12, value, 0, mFont.tahoma_7_grey);
                        } else if (Char.getMyChar().npcFocus != null) {
                            value += 12;
                            mFont.tahoma_7_yellow.drawString(g, Char.getMyChar().npcFocus.template.name, byteValue, value, 0, mFont.tahoma_7_grey);
                        } else if (Char.getMyChar().charFocus != null) {
                            g.setColor(Char.getMyChar().charFocus.getClassColor());
                            value += 12;
                            g.fillRect(byteValue, value + 3, 5, 5);
                            g.setColor(0);
                            g.drawRect(byteValue, value + 3, 5, 5);
                            mFont.tahoma_7_white.drawString(g, Char.getMyChar().charFocus.cName + " lv" + Char.getMyChar().charFocus.clevel + ": " + Char.getMyChar().charFocus.cHP + "/" + Char.getMyChar().charFocus.cMaxHP, byteValue + 12, value, 0, mFont.tahoma_7_grey);
                        }
                        if (GameCanvas.isTouchControlLargeScreen) {
                            if (TileMap.typeMap == 1) {
                                mFont font13 = mFont.tahoma_7_white;
                                String text14 = mResources.ACHIEVEMENT + ": " + Char.getMyChar().countKill;
                                value += 12;
                                font13.drawString(g, text14, byteValue, value, 0, mFont.tahoma_7_grey);
                                font13 = mFont.tahoma_7_white;
                                text14 = mResources.MAX + ": " + Char.getMyChar().countKillMax;
                                value += 12;
                                font13.drawString(g, text14, byteValue, value, 0, mFont.tahoma_7_grey);
                            } else if (TileMap.typeMap == 2 || TileMap.mapID == 114 || TileMap.mapID == 115 || TileMap.mapID == 116) {
                                String text15 = mResources.PROPERTY + ": " + Char.pointPB;
                                value += 12;
                                mFont.tahoma_7_white.drawString(g, text15, byteValue, value, 0, mFont.tahoma_7_grey);
                            } else if (TileMap.typeMap == 3) {
                                String text16 = mResources.PROPERTY + ": " + Char.pointChienTruong;
                                value += 12;
                                mFont.tahoma_7_white.drawString(g, text16, byteValue, value, 0, mFont.tahoma_7_grey);
                                mFont font17 = mFont.tahoma_7_white;
                                text16 = mResources.TITLE_CT[Char.getCT()];
                                value += 12;
                                font17.drawString(g, text16, byteValue, value, 0, mFont.tahoma_7_grey);
                            }
                        }
                        g.translate(-g.getTranslateX(), -g.getTranslateY());
                    }
                }
            }
        } catch (Exception exception) {
        }
    }

    private void paintTouchControl(mGraphics g) {
        if (GameCanvas.isTouch && (!GameCanvas.menu.showMenu || !GameCanvas.isTouchControlSmallScreen)) {
            if (GameCanvas.currentDialog == null && ChatPopup.currentMultilineChatPopup == null && !GameCanvas.menu.showMenu && !isPaintPopup()) {
                resetTranslate(g);
                if (!ChatTextField.gI().isShow) {
                    g.drawImage(nso.GameScr.imgChat, nso.GameScr.xC + 17, nso.GameScr.yC + 17, 3);
                }
                if (!this.isNotPaintTouchControl()) {
                    g.drawImage(nso.GameScr.imgButton, nso.GameScr.xL, nso.GameScr.yL, 0);
                    g.drawRegion(imgArrow, 0, 0, mGraphics.getImageWidth(imgArrow), mGraphics.getImageHeight(imgArrow), 3, nso.GameScr.xL + 15, nso.GameScr.yL + 16, 3);
                    if (mScreen.keyTouch == 4) {
                        g.drawImage(nso.GameScr.imgButton2, nso.GameScr.xL, nso.GameScr.yL, 0);
                        g.drawRegion(nso.GameScr.imgArrow2, 0, 0, mGraphics.getImageWidth(imgArrow), mGraphics.getImageHeight(imgArrow), 3, nso.GameScr.xL + 15, nso.GameScr.yL + 16, 3);
                    }
                    g.drawImage(nso.GameScr.imgButton, xR, nso.GameScr.yR, 0);
                    g.drawRegion(imgArrow, 0, 0, mGraphics.getImageWidth(imgArrow), mGraphics.getImageHeight(imgArrow), 0, xR + 17, nso.GameScr.yR + 16, 3);
                    if (mScreen.keyTouch == 6) {
                        g.drawImage(nso.GameScr.imgButton2, xR, nso.GameScr.yR, 0);
                        g.drawRegion(nso.GameScr.imgArrow2, 0, 0, mGraphics.getImageWidth(imgArrow), mGraphics.getImageHeight(imgArrow), 0, xR + 17, nso.GameScr.yR + 16, 3);
                    }
                    g.drawImage(nso.GameScr.imgButton, xU, nso.GameScr.yU, 0);
                    g.drawRegion(imgArrow, 0, 0, mGraphics.getImageWidth(imgArrow), mGraphics.getImageHeight(imgArrow), 7, xU + 17, nso.GameScr.yU + 14, 3);
                    if (mScreen.keyTouch == 3) {
                        g.drawImage(nso.GameScr.imgButton2, xU, nso.GameScr.yU, 0);
                        g.drawRegion(nso.GameScr.imgArrow2, 0, 0, mGraphics.getImageWidth(imgArrow), mGraphics.getImageHeight(imgArrow), 7, xU + 17, nso.GameScr.yU + 14, 3);
                    }
                    if (Char.getMyChar().ctaskId > 1) {
                        g.drawImage(nso.GameScr.imgButton, nso.GameScr.xHP, nso.GameScr.yHP, 0);
                        if (mScreen.keyTouch == 10) {
                            g.drawImage(nso.GameScr.imgButton2, nso.GameScr.xHP, nso.GameScr.yHP, 0);
                        }
                        g.drawImage(nso.GameScr.imgHpp, nso.GameScr.xHP + 16, nso.GameScr.yHP + 15, 3);
                        mFont.number_white.drawString(g, "" + nso.GameScr.hpPotion, nso.GameScr.xHP + 22, nso.GameScr.yHP + 20, 1);
                        g.drawImage(nso.GameScr.imgButton, nso.GameScr.xMP, nso.GameScr.yMP, 0);
                        if (mScreen.keyTouch == 11) {
                            g.drawImage(nso.GameScr.imgButton2, nso.GameScr.xMP, nso.GameScr.yMP, 0);
                        }
                        g.drawImage(nso.GameScr.imgMpp, nso.GameScr.xMP + 16, nso.GameScr.yMP + 15, 3);
                        mFont.number_white.drawString(g, "" + nso.GameScr.mpPotion, nso.GameScr.xMP + 22, nso.GameScr.yMP + 20, 1);
                        g.drawImage(nso.GameScr.imgButton, nso.GameScr.xTG, nso.GameScr.yTG, 0);
                        if (mScreen.keyTouch == 13) {
                            g.drawImage(nso.GameScr.imgButton2, nso.GameScr.xTG, nso.GameScr.yTG, 0);
                        }
                        g.drawImage(nso.GameScr.imgFocus, nso.GameScr.xTG + 16, nso.GameScr.yTG + 16, 3);
                    }
                    g.drawImage(nso.GameScr.imgRight, nso.GameScr.xF, yF, 0);
                    if (mScreen.keyTouch == 5) {
                        g.drawImage(nso.GameScr.imgRight2, nso.GameScr.xF, yF, 0);
                    }
                }
            }
        }
    }

    private void paintSelectedSkill(mGraphics g) {
        if (GameCanvas.currentDialog == null && ChatPopup.currentMultilineChatPopup == null && !GameCanvas.menu.showMenu && !isPaintPopup() && super.center != this.cmdDead) {
            if (!GameCanvas.isTouch || Char.getMyChar().vSkill.size() >= 2) {
                if (isPaintSelectSkill) {
                    for (int index = 0; index < onScreenSkill.length; index++) {
                        if (GameCanvas.isTouchControlSmallScreen) {
                            if (Info.hI > 0) {
                                nso.GameScr.yS[index] = 55 + Info.hI;
                            } else {
                                nso.GameScr.yS[index] = 55;
                            }
                        }
                        if (GameCanvas.isTouch && GameCanvas.isTouchControl) {
                            g.drawImage(nso.GameScr.imgSkill, xSkill + nso.GameScr.xS[index] - 1, nso.GameScr.yS[index] - 1, 0);
                        } else {
                            g.setColor(16764040);
                            g.drawRect(xSkill + nso.GameScr.xS[index] - 1, nso.GameScr.yS[index] - 1, 25, 25);
                        }
                        Skill skill = onScreenSkill[index];
                        if (index == this.selectedIndexSkill && !isPaintUI() && GameCanvas.gameTick % 10 > 5) {
                            g.setColor(16777215);
                            g.fillRect(xSkill + nso.GameScr.xS[index] + 1, nso.GameScr.yS[index] + 1, 22, 22);
                        } else if (!GameCanvas.isTouch) {
                            g.setColor(0);
                            g.fillRect(xSkill + nso.GameScr.xS[index], nso.GameScr.yS[index], 24, 24);
                        }
                        if (skill != null) {
                            if (skill == Char.getMyChar().myskill) {
                                g.setColor(16711680);
                                g.drawRect(xSkill + nso.GameScr.xS[index] - 1, nso.GameScr.yS[index] - 1, 25, 25);
                            }
                            skill.paint(xSkill + nso.GameScr.xS[index] + 12, nso.GameScr.yS[index] + 12, g);
                        }
                    }
                }
            }
        }
    }

    public static final void startFlyText(String flyString, int x, int y, int dx, int dy, int color1) {
        dx = -1;
        for (int index = 0; index < 5; index++) {
            if (flyTextState[index] == -1) {
                dx = index;
                break;
            }
        }
        if (dx != -1) {
            nso.GameScr.flyTextColor[dx] = color1;
            flyTextString[dx] = flyString;
            nso.GameScr.flyTextX[dx] = x;
            nso.GameScr.flyTextY[dx] = y;
            nso.GameScr.flyTextDx[dx] = 0;
            nso.GameScr.flyTextDy[dx] = -2;
            flyTextState[dx] = 0;
        }
    }

    public static final void startLanterns(int value, int value1) {
        nso.GameScr.vLanterns.addElement(new Lanterns(value, value1));
    }

    public static final boolean startSplash(int x, int y, int dir) {
        int value = splashState[0] == -1 ? 0 : 1;
        if (splashState[value] != -1) {
            return false;
        }
        splashState[value] = 0;
        nso.GameScr.splashDir[value] = dir;
        nso.GameScr.splashX[value] = x;
        nso.GameScr.splashY[value] = y;
        return true;
    }

    private void loadCmdBar() {
        if (nso.GameScr.imgCmdBar == null) {
            nso.GameScr.imgCmdBar = new Image[2];
            for (int index = 0; index < 2; index++) {
                nso.GameScr.imgCmdBar[index] = GameCanvas.loadImage("/u/c" + index + ".png");
            }
        }
        nso.GameScr.cmdBarLeftWidth = mGraphics.getImageWidth(nso.GameScr.imgCmdBar[0]);
        nso.GameScr.cmdBarRightWidth = mGraphics.getImageWidth(nso.GameScr.imgCmdBar[1]);
        nso.GameScr.cmdBarFillWidth = nso.GameScr.gW - nso.GameScr.cmdBarLeftWidth - nso.GameScr.cmdBarRightWidth + 1;
        hpBarX = 63;
        hpBarY = nso.GameScr.cmdBarY + 7;
        hpBarW = nso.GameScr.gW - 84 - 30 + 15;
        expBarW = nso.GameScr.gW - 44 - 4;
        nso.GameScr.mpBarHeight = 5;
        if (GameCanvas.w > 176) {
            nso.GameScr.cmdBarFillWidth -= 50;
            hpBarW -= 50;
            expBarW -= 50;
            hpBarX += 15;
            hpBarW -= 15;
        }
        this.loadInforBar();
    }

    private void loadInforBar() {
        if (GameCanvas.isTouch) {
            hpBarW = 82;
            mpBarW = 57;
            hpBarX = 52;
            hpBarY = GameCanvas.isKiemduyet ? 25 : 10 + Info.hI;
            expBarW = nso.GameScr.gW - 61;
            if (GameCanvas.isTouchControlSmallScreen) {
                nso.GameScr.xC = nso.GameScr.gW / 2 - 2;
                nso.GameScr.yC = nso.GameScr.yTouchBar + 50;
            } else {
                this.menu.y = 6 + Info.hI;
                nso.GameScr.xC = nso.GameScr.gW - 100;
                nso.GameScr.yC = 2 + Info.hI;
            }
            TileMap.setPosMiniMap(GameCanvas.w - 60, GameCanvas.isKiemduyet ? 16 : Info.hI, 60, 42);
        }
    }

    private void paintTrangbi(mGraphics g) {
        if (indexMenu == 4) {
            g.translate(-g.getTranslateX(), -g.getTranslateY());
            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
            g.setColor(Paint.COLORBACKGROUND);
            paintTitle(g, mResources.MENUME[indexMenu], true);
            if (currentCharViewInfo.arrItemBody == null) {
                GameCanvas.paintShukiren(popupX + 90, popupY + 75, g, false);
                mFont.tahoma_7b_white.drawString(g, mResources.PLEASEWAIT, popupX + popupW / 2, popupY + 90, 2);
            } else {
                g.setColor(13606712);
                g.drawRect(popupX + 33, popupY + (GameCanvas.isTouchControlLargeScreen ? 87 : 34), popupW - 67, GameCanvas.isTouchControlLargeScreen ? 76 : 128);
                int value = indexSize - 2;
                int value1 = 0;
                for (int index = 0; index < 16; index++) {
                    if (index == 0 || index == 2 || index == 4 || index == 6 || index == 8) {
                        g.setColor(0);
                        g.fillRect(popupX + 4 + 1, popupY + 35 + index / 2 * value + 1, value - 1, value - 1);
                        if (indextabTrangbi == 0) {
                            if (mResources.ITEMNAME[index].length > 1) {
                                mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[index][0], popupX + 7 + 11, popupY + 36 + index / 2 * value + 2, 2);
                                mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[index][1], popupX + 7 + 11, popupY + 36 + index / 2 * value + 2 + 9, 2);
                            } else {
                                mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[index][0], popupX + 7 + 11, popupY + 36 + index / 2 * value + 2 + 5, 2);
                            }
                        }
                    } else if (index == 1 || index == 3 || index == 5 || index == 7 || index == 9) {
                        g.setColor(0);
                        g.fillRect(popupX + popupW - value - 4, popupY + 35 + index / 2 * value + 1, value - 1, value - 1);
                        if (indextabTrangbi == 0) {
                            if (mResources.ITEMNAME[index].length > 1) {
                                mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[index][0], popupX + popupW - value / 2 - 4, popupY + 36 + index / 2 * value + 2, 2);
                                mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[index][1], popupX + popupW - value / 2 - 4, popupY + 36 + index / 2 * value + 2 + 9, 2);
                            } else {
                                mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[index][0], popupX + popupW - value / 2 - 4, popupY + 36 + index / 2 * value + 2 + 5, 2);
                            }
                        }
                    } else if (index == 9 || index == 10 || index == 11 || index == 12 || index == 13 || index == 14 || index == 15) {
                        int value2 = popupX + 4 + 1 + value1 * (value + 2);
                        int value3 = popupY + 35 + value * 5 + 1;
                        g.setColor(0);
                        g.fillRect(value2, popupY + 35 + value * 5 + 1, value - 1, value - 1);
                        if (indextabTrangbi == 0) {
                            if (mResources.ITEMNAME[index].length > 1) {
                                mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[index][0], value2 + value / 2, value3 + 2, 2);
                                mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[index][1], value2 + value / 2, value3 + 2 + 9, 2);
                            } else {
                                mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[index][0], value2 + value / 2, value3 + 2 + 5, 2);
                            }
                        }
                        value1++;
                    }
                }
                if (indextabTrangbi == 0) {
                    for (int index4 = 0; index4 < 16; index4++) {
                        Item item;
                        if ((item = currentCharViewInfo.arrItemBody[index4]) != null) {
                            if (item.eff == null) {
                                item.eff = efs[56];
                            }
                            if (item.indexUI == 0 || item.indexUI == 2 || item.indexUI == 4 || item.indexUI == 6 || item.indexUI == 8 || item.indexUI == 10) {
                                int value5 = popupX + 4;
                                int value6 = popupY + 34 + item.indexUI / 2 * value;
                                this.paintItem(g, item, value5 - 1, value6, 0, 1);
                            } else if (item.indexUI != 1 && item.indexUI != 3 && item.indexUI != 5 && item.indexUI != 7 && item.indexUI != 9) {
                                if (item.indexUI == 11 || item.indexUI == 12 || item.indexUI == 13 || item.indexUI == 14 || item.indexUI == 15) {
                                    if (item.indexUI == 10) {
                                        value1 = 1;
                                    } else if (item.indexUI == 11) {
                                        value1 = 2;
                                    } else if (item.indexUI == 12) {
                                        value1 = 3;
                                    } else if (item.indexUI == 13) {
                                        value1 = 4;
                                    } else if (item.indexUI == 14) {
                                        value1 = 5;
                                    } else if (item.indexUI == 15) {
                                        value1 = 6;
                                    }
                                    int value7 = popupX + 2 + 1 + value1 * (value + 2) - value;
                                    int value8 = popupY + 35 + value * 5;
                                    this.paintItem(g, item, value7 - 2, value8 - 1, 0, 1);
                                }
                            } else {
                                int value9 = popupX + popupW - value - 5;
                                int value10 = popupY + 35 + item.indexUI / 2 * value;
                                this.paintItem(g, item, value9 - 1, value10 - 1, 0, 1);
                            }
                            if (GameCanvas.gameTick % 4 == 0) {
                                item.indexEff++;
                                if (item.indexEff >= item.eff.arrEfInfo.length) {
                                    item.indexEff = 0;
                                }
                            }
                        }
                    }
                }
                if (indextabTrangbi > 0) {
                    for (int index11 = 0; index11 < 16; index11++) {
                        Item item12;
                        if ((item12 = currentCharViewInfo.arrItemBody[index11 + indextabTrangbi]) != null) {
                            int value13 = item12.indexUI - 16;
                            if (item12.eff == null) {
                                item12.eff = efs[56];
                            }
                            if (value13 == 0 || value13 == 2 || value13 == 4 || value13 == 6 || value13 == 8 || value13 == 10) {
                                int value14 = popupX + 4;
                                int value15 = popupY + 34 + value13 / 2 * value;
                                this.paintItem(g, item12, value14 - 1, value15, 0, 1);
                            } else if (value13 != 1 && value13 != 3 && value13 != 5 && value13 != 7 && value13 != 9) {
                                if (value13 == 11 || value13 == 12 || value13 == 13 || value13 == 14 || value13 == 15) {
                                    if (value13 == 10) {
                                        value1 = 1;
                                    } else if (value13 == 11) {
                                        value1 = 2;
                                    } else if (value13 == 12) {
                                        value1 = 3;
                                    } else if (value13 == 13) {
                                        value1 = 4;
                                    } else if (value13 == 14) {
                                        value1 = 5;
                                    } else if (value13 == 15) {
                                        value1 = 6;
                                    }
                                    int value16 = popupX + 2 + 1 + value1 * (value + 2) - value;
                                    int value17 = popupY + 35 + value * 5;
                                    this.paintItem(g, item12, value16 - 2, value17 - 1, 0, 1);
                                }
                            } else {
                                int value18 = popupX + popupW - value - 5;
                                int value19 = popupY + 35 + value13 / 2 * value;
                                this.paintItem(g, item12, value18 - 1, value19 - 1, 0, 1);
                            }
                            if (GameCanvas.gameTick % 4 == 0) {
                                item12.indexEff++;
                                if (item12.indexEff >= item12.eff.arrEfInfo.length) {
                                    item12.indexEff = 0;
                                }
                            }
                        }
                    }
                }
                for (int index20 = 0; index20 < 16; index20++) {
                    if (indexTitle == 1 && index20 == indexSelect) {
                        if (index20 == 0 || index20 == 2 || index20 == 4 || index20 == 6 || index20 == 8) {
                            g.setColor(16777215);
                            g.drawRect(popupX + 4, popupY + 35 + index20 / 2 * value, value, value);
                            paintSelectHighlight(popupX + 5 - 2, popupY + 35 + index20 / 2 * value - 1, g);
                        } else if (index20 == 1 || index20 == 3 || index20 == 5 || index20 == 7 || index20 == 9) {
                            g.setColor(16777215);
                            g.drawRect(popupX + popupW - value - 4 - 1, popupY + 35 + index20 / 2 * value, value, value);
                            paintSelectHighlight(popupX + popupW - value - 4 - 2, popupY + 35 + index20 / 2 * value - 1, g);
                        } else if (index20 == 9 || index20 == 10 || index20 == 11 || index20 == 12 || index20 == 13 || index20 == 14 || index20 == 15) {
                            if (index20 == 9) {
                                value1 = 0;
                            } else if (index20 == 10) {
                                value1 = 1;
                            } else if (index20 == 11) {
                                value1 = 2;
                            } else if (index20 == 12) {
                                value1 = 3;
                            } else if (index20 == 13) {
                                value1 = 4;
                            } else if (index20 == 14) {
                                value1 = 5;
                            } else if (index20 == 15) {
                                value1 = 6;
                            }
                            int value21 = popupX + 2 + 1 + value1 * (value + 2) - value;
                            int value22 = popupY + 35 + value * 5;
                            g.setColor(16777215);
                            g.drawRect(value21 - 1, value22, value, value);
                            paintSelectHighlight(value21 - 2, value22 - 1, g);
                        }
                    }
                }
                int value23 = GameCanvas.isTouchControlLargeScreen ? -25 : 16;
                Part part = parts[currentCharViewInfo.head];
                Part part24 = parts[currentCharViewInfo.leg];
                Part part25 = parts[currentCharViewInfo.body];
                Part part26 = parts[currentCharViewInfo.wp];
                if (currentCharViewInfo.arrItemBody != null && currentCharViewInfo.arrItemBody[11] != null) {
                    part = parts[currentCharViewInfo.arrItemBody[11].template.part];
                }
                if (part.pi != null && part.pi.length >= 8) {
                    for (int index27 = 0; index27 < part.pi.length; index27++) {
                        if (part.pi[index27] == null || !SmallImage.isExitsImage(part.pi[index27].id)) {
                            Char.getMyChar();
                            part = Char.getDefaultHead(Char.getMyChar().cgender);
                            break;
                        }
                    }
                } else {
                    Char.getMyChar();
                    part = Char.getDefaultHead(Char.getMyChar().cgender);
                }
                value = currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1;
                int[] values = currentCharViewInfo.getClassCoat();
                if (currentCharViewInfo.ID_WEA_PONE > -1) {
                    currentCharViewInfo.paintWeaponUIBot(g, nso.GameScr.gW2, nso.GameScr.gH2 - 24, value);
                }
                if (currentCharViewInfo.ID_PP > -1) {
                    currentCharViewInfo.paintPPUIBot(g, nso.GameScr.gW2, nso.GameScr.gH2 - 24, value);
                }
                if (values != null && currentCharViewInfo.ID_PP == -1) {
                    if (Char.getMyChar().tickCoat == 0) {
                        SmallImage.drawSmallImage(g, values[Char.getMyChar().tickCoat], nso.GameScr.gW2 + Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][1] + part.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][0]].dx - 2, nso.GameScr.gH2 + value23 - Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][2] + part.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][0]].dy + 16, 0, 0);
                    } else if (Char.getMyChar().tickCoat == 1) {
                        SmallImage.drawSmallImage(g, values[Char.getMyChar().tickCoat], nso.GameScr.gW2 + Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][1] + part.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][0]].dx - 9, nso.GameScr.gH2 + value23 - Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][2] + part.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][0]].dy + 16, 0, 0);
                    } else if (Char.getMyChar().tickCoat == 2) {
                        SmallImage.drawSmallImage(g, values[Char.getMyChar().tickCoat], nso.GameScr.gW2 + Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][1] + part.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][0]].dx - 12, nso.GameScr.gH2 + value23 - Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][2] + part.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][0]].dy + 16, 0, 0);
                    } else {
                        SmallImage.drawSmallImage(g, values[Char.getMyChar().tickCoat], nso.GameScr.gW2 + Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][1] + part.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][0]].dx - 9, nso.GameScr.gH2 + value23 - Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][2] + part.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][0]].dy + 16, 0, 0);
                    }
                }
                currentCharViewInfo.paintClanEffect(g, nso.GameScr.gW2 + Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][2][1] + part25.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][2][0]].dx + 18, nso.GameScr.gH2 + value23 - Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][1][2] + part24.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][1][0]].dy + 5);
                if (currentCharViewInfo.ID_WEA_PONE == -1) {
                    SmallImage.drawSmallImage(g, part26.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][3][0]].id, nso.GameScr.gW2 + Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][3][1] + part26.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][3][0]].dx, nso.GameScr.gH2 + value23 - Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][3][2] + part26.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][3][0]].dy, 0, 0);
                }
                if (currentCharViewInfo.ID_LEG > -1) {
                    currentCharViewInfo.paintLegUI(g, nso.GameScr.gW2, nso.GameScr.gH2 - 24, value);
                } else {
                    SmallImage.drawSmallImage(g, part24.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][1][0]].id, nso.GameScr.gW2 + Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][1][1] + part24.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][1][0]].dx, nso.GameScr.gH2 + value23 - Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][1][2] + part24.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][1][0]].dy, 0, 0);
                }
                if (currentCharViewInfo.ID_Body > -1) {
                    currentCharViewInfo.paintBodyUI(g, nso.GameScr.gW2, nso.GameScr.gH2 - 24, value);
                } else {
                    SmallImage.drawSmallImage(g, part25.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][2][0]].id, nso.GameScr.gW2 + Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][2][1] + part25.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][2][0]].dx, nso.GameScr.gH2 + value23 - Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][2][2] + part25.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][2][0]].dy, 0, 0);
                }
                if (currentCharViewInfo.ID_HAIR > -1) {
                    currentCharViewInfo.paintHeadUI(g, nso.GameScr.gW2, nso.GameScr.gH2 - 24, value);
                } else {
                    SmallImage.drawSmallImage(g, part.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][0]].id, nso.GameScr.gW2 + Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][1] + part.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][0]].dx, nso.GameScr.gH2 + value23 - Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][2] + part.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][0][0]].dy, 0, 0);
                }
                if (currentCharViewInfo.ID_MAT_NA > -1) {
                    currentCharViewInfo.paintMatNaUI(g, nso.GameScr.gW2, nso.GameScr.gH2 - 24, value);
                }
                currentCharViewInfo.paintClanEffect(g, nso.GameScr.gW2 + Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][2][1] + part25.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][2][0]].dx + 5, nso.GameScr.gH2 + value23 - Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][1][2] + part24.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][1][0]].dy + 5);
                currentCharViewInfo.paintClanEffect2(g, nso.GameScr.gW2 + Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][2][1] + part25.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][2][0]].dx + 22, nso.GameScr.gH2 + value23 - Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][1][2] + part24.pi[Char.CharInfo[currentCharViewInfo.cp1 % 15 < 5 ? 0 : 1][1][0]].dy + 5);
                if (currentCharViewInfo.ID_PP > -1) {
                    currentCharViewInfo.paintPPUITop(g, nso.GameScr.gW2, nso.GameScr.gH2 - 24, value);
                }
                if (currentCharViewInfo.ID_WEA_PONE > -1) {
                    currentCharViewInfo.paintWeaponUITop(g, nso.GameScr.gW2, nso.GameScr.gH2 - 24, value);
                }
                if (this.cmdTrangbi2 != null && GameCanvas.isTouch) {
                    g = g;
                    Command command = this.cmdTrangbi2;
                    if (!this.cmdTrangbi2.isFocus) {
                        g.drawImage(nso.GameScr.imgLbtn, command.x, command.y, 0);
                    } else {
                        g.drawImage(nso.GameScr.imgLbtnFocus, command.x, command.y, 0);
                    }
                    mFont.tahoma_7b_yellow.drawString(g, command.caption, command.x + 36, command.y + 6, 2);
                }
            }
        }
    }

    private void paintThuCuoi(mGraphics g) {
        if (indexMenu == 5) {
            g.translate(-g.getTranslateX(), -g.getTranslateY());
            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
            g.setColor(Paint.COLORBACKGROUND);
            paintTitle(g, mResources.MENUME[indexMenu], true);
            resetTranslate(g);
            g.setColor(0);
            g.fillRect(popupX + 2, popupY + 31, 171, popupH - 34);
            g.setColor(13606712);
            g.drawRect(popupX + 3, popupY + 32, 168, popupH - 37);
            g.setColor(Paint.COLORBACKGROUND);
            g.fillRect(popupX + 4, popupY + 34, 166, popupH - 39);
            if (currentCharViewInfo.arrItemMounts[4] != null) {
                mFont.tahoma_7b_white.drawString(g, currentCharViewInfo.arrItemMounts[4].template.name, popupX + 90, nso.GameScr.ystart + 2, 2);
                int value = currentCharViewInfo.arrItemMounts[4].sys + 1;
                for (int index = 0; index < value; index++) {
                    SmallImage.drawSmallImage(g, 628, popupX + 90 + index * 12 - value * 6, nso.GameScr.ystart + 20, 0, 3);
                }
            } else {
                mFont.tahoma_7b_white.drawString(g, mResources.MON_NAME, popupX + 90, nso.GameScr.ystart + 2, 2);
            }
            for (int index1 = 0; index1 < currentCharViewInfo.arrItemMounts.length - 1; index1++) {
                if (currentCharViewInfo.arrItemMounts[index1] != null) {
                    this.paintItem(g, currentCharViewInfo.arrItemMounts[index1], this.xMounts[index1], this.yMounts[index1]);
                } else {
                    g.setColor(6425);
                    g.fillRect(this.xMounts[index1] - 1, this.yMounts[index1] - 1, indexSize + 3, indexSize + 3);
                    if (index1 == 0) {
                        if (currentCharViewInfo.isHaveMoto()) {
                            mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[22][0], this.xMounts[index1] + indexSize / 2, this.yMounts[index1] + indexSize / 2 - 10, 2);
                            mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[22][1], this.xMounts[index1] + indexSize / 2, this.yMounts[index1] + indexSize / 2 + 2, 2);
                        } else {
                            mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[19][0], this.xMounts[index1] + indexSize / 2, this.yMounts[index1] + indexSize / 2 - 10, 2);
                            mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[19][1], this.xMounts[index1] + indexSize / 2, this.yMounts[index1] + indexSize / 2 + 2, 2);
                        }
                    } else if (index1 == 1) {
                        if (currentCharViewInfo.isHaveMoto()) {
                            mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[20][0], this.xMounts[index1] + indexSize / 2, this.yMounts[index1] + indexSize / 2 - 10, 2);
                            mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[20][1], this.xMounts[index1] + indexSize / 2, this.yMounts[index1] + indexSize / 2 + 2, 2);
                        } else {
                            mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[16][0], this.xMounts[index1] + indexSize / 2, this.yMounts[index1] + indexSize / 2 - 10, 2);
                            mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[16][1], this.xMounts[index1] + indexSize / 2, this.yMounts[index1] + indexSize / 2 + 2, 2);
                        }
                    } else if (index1 == 2) {
                        if (currentCharViewInfo.isHaveMoto()) {
                            mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[21][0], this.xMounts[index1] + indexSize / 2, this.yMounts[index1] + indexSize / 2 - 10, 2);
                            mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[21][1], this.xMounts[index1] + indexSize / 2, this.yMounts[index1] + indexSize / 2 + 2, 2);
                        } else {
                            mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[17][0], this.xMounts[index1] + indexSize / 2, this.yMounts[index1] + indexSize / 2 - 10, 2);
                            mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[17][1], this.xMounts[index1] + indexSize / 2, this.yMounts[index1] + indexSize / 2 + 2, 2);
                        }
                    } else if (index1 == 3) {
                        if (currentCharViewInfo.isHaveMoto()) {
                            mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[23][0], this.xMounts[index1] + indexSize / 2, this.yMounts[index1] + indexSize / 2 - 10, 2);
                            mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[23][1], this.xMounts[index1] + indexSize / 2, this.yMounts[index1] + indexSize / 2 + 2, 2);
                        } else {
                            mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[18][0], this.xMounts[index1] + indexSize / 2, this.yMounts[index1] + indexSize / 2 - 10, 2);
                            mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[18][1], this.xMounts[index1] + indexSize / 2, this.yMounts[index1] + indexSize / 2 + 2, 2);
                        }
                    }
                }
                if (indexSelect == index1 && indexTitle == 1 && indexSelect < 4) {
                    g.setColor(16777215);
                } else {
                    g.setColor(12281361);
                }
                g.drawRect(this.xMounts[index1], this.yMounts[index1], indexSize, indexSize);
            }
            int value2 = this.xMounts[0] + indexSize + 7;
            int value3 = this.yMounts[0] - 5;
            g.setColor(6425);
            g.fillRect(value2, value3, 84, 75);
            if (indexSelect == 4) {
                g.setColor(16777215);
            } else {
                g.setColor(12281361);
            }
            g.drawRect(value2, value3, 84, 75);
            int value4 = 0;
            int value5 = 0;
            int value6 = 0;
            int value7 = 0;
            int value8 = 0;
            if (currentCharViewInfo.ID_HORSE > -1) {
                currentCharViewInfo.paintHorseUI(g, value2 + 35, value3 + 55);
            }
            if (currentCharViewInfo.arrItemMounts[4] != null) {
                if (currentCharViewInfo.isHaveNewMount()) {
                    int[][] values = (int[][]) CharPartInfo.newMount.get(String.valueOf(currentCharViewInfo.arrItemMounts[4].template.id));
                    if (GameCanvas.gameTick % 20 > 15) {
                        SmallImage.drawSmallImage(g, values[0][0], value2 + 45 - 10, value3 + 35, 0, 3);
                    } else {
                        SmallImage.drawSmallImage(g, values[0][1], value2 + 45 - 10, value3 + 35, 0, 3);
                    }
                } else if (currentCharViewInfo.isHaveMoto()) {
                    if (currentCharViewInfo.arrItemMounts[4].template.id == 485) {
                        if (currentCharViewInfo.arrItemMounts[4].sys < 2) {
                            SmallImage.drawSmallImage(g, 1800, value2 + 45, value3 + 35, 0, 3);
                        } else {
                            SmallImage.drawSmallImage(g, 2063, value2 + 45, value3 + 35, 0, 3);
                        }
                    } else if (currentCharViewInfo.arrItemMounts[4].template.id == 524) {
                        if (currentCharViewInfo.arrItemMounts[4].sys < 2) {
                            SmallImage.drawSmallImage(g, 2067, value2 + 45, value3 + 35, 0, 3);
                        } else {
                            SmallImage.drawSmallImage(g, 2071, value2 + 45, value3 + 35, 0, 3);
                        }
                    }
                } else if (currentCharViewInfo.isHaveWolf()) {
                    if (currentCharViewInfo.arrItemMounts[4].template.id == 443) {
                        if (currentCharViewInfo.arrItemMounts[4].sys < 2) {
                            if (GameCanvas.gameTick % 20 > 15) {
                                SmallImage.drawSmallImage(g, 1801, value2 + 45, value3 + 35, 0, 3);
                            } else {
                                SmallImage.drawSmallImage(g, 1802, value2 + 45, value3 + 35, 0, 3);
                            }
                        } else if (GameCanvas.gameTick % 20 > 15) {
                            SmallImage.drawSmallImage(g, 2080, value2 + 45, value3 + 35, 0, 3);
                        } else {
                            SmallImage.drawSmallImage(g, 2081, value2 + 45, value3 + 35, 0, 3);
                        }
                    } else if (currentCharViewInfo.arrItemMounts[4].template.id == 523) {
                        if (GameCanvas.gameTick % 20 > 15) {
                            SmallImage.drawSmallImage(g, 2062, value2 + 45, value3 + 35, 0, 3);
                        } else {
                            SmallImage.drawSmallImage(g, 2061, value2 + 45, value3 + 35, 0, 3);
                        }
                    }
                }
                if (currentCharViewInfo.arrItemMounts[4].options != null) {
                    for (int index9 = 0; index9 < currentCharViewInfo.arrItemMounts[4].options.size(); index9++) {
                        ItemOption itemOption;
                        if ((itemOption = (ItemOption) currentCharViewInfo.arrItemMounts[4].options.elementAt(index9)).optionTemplate.id == 65) {
                            value4 = itemOption.param;
                        } else if (itemOption.optionTemplate.id == 66) {
                            value5 = itemOption.param;
                        }
                    }
                }
                value6 = value4 * 85 / 1000;
                value7 = value5 * 85 / 1000;
                value8 = currentCharViewInfo.arrItemMounts[4].upgrade + 1;
            }
            int value10 = nso.GameScr.xstart + 5;
            value2 = nso.GameScr.ystart + 112;
            mFont.tahoma_7b_white.drawString(g, mResources.Level + ": ", value10, value2, 0);
            mFont.tahoma_7b_white.drawString(g, String.valueOf(value8), value10 + 70, value2, 0);
            if (currentCharViewInfo.isHaveMoto()) {
                String text = mResources.MACHINE + ": ";
                value2 += 15;
                mFont.tahoma_7b_white.drawString(g, text, value10, value2, 0);
            } else {
                String text11 = mResources.EXP + ": ";
                value2 += 15;
                mFont.tahoma_7b_white.drawString(g, text11, value10, value2, 0);
            }
            g.setColor(6425);
            g.fillRect(value10 + 70, value2, 85, 14);
            g.setColor(371981);
            g.fillRect(value10 + 70, value2, value6, 14);
            g.setColor(5131338);
            g.drawRect(value10 + 70, value2, 85, 14);
            mFont.tahoma_7_white.drawString(g, value4 + "/" + 1000, value10 + 113, value2 + 2, 2);
            if (currentCharViewInfo.isHaveMoto()) {
                String text12 = mResources.POWER + ": ";
                value2 += 17;
                mFont.tahoma_7b_white.drawString(g, text12, value10, value2, 0);
            } else {
                String text13 = mResources.VITALITY + ": ";
                value2 += 17;
                mFont.tahoma_7b_white.drawString(g, text13, value10, value2, 0);
            }
            g.setColor(6425);
            g.fillRect(value10 + 70, value2, 85, 14);
            g.setColor(16711680);
            g.fillRect(value10 + 70, value2, value7, 14);
            g.setColor(5131338);
            g.drawRect(value10 + 70, value2, 85, 14);
            mFont.tahoma_7_white.drawString(g, value5 + "/" + 1000, value10 + 113, value2 + 2, 2);
        }
    }

    private void paintClanInfo(mGraphics g) {
        if (isPaintClan) {
            resetTranslate(g);
            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
            paintTitle(g, mResources.CLAN[indexMenu], true);
            if (indexMenu == 0) {
                if (Char.clan != null && Char.clan.name != null && !Char.clan.name.equals("")) {
                    int[] values = new int[] { 1692, 1693, 1694, 1695, 1696 };
                    for (int index = 0; index < values.length; index++) {
                        g.setColor(6425);
                        g.fillRect(popupX + index * indexSize + 18, popupY + 32, indexSize - 2, indexSize - 2);
                        if (indexTitle == 1 && index == indexSelect) {
                            g.setColor(16777215);
                        } else {
                            g.setColor(12281361);
                        }
                        g.drawRect(popupX + index * indexSize + 18, popupY + 32, indexSize - 2, indexSize - 2);
                        if (index > Char.clan.itemLevel - 1) {
                            SmallImage.drawSmallImage(g, 1697, popupX + index * indexSize + 18 + indexSize / 2, popupY + 32 + indexSize / 2, 0, 3);
                        } else {
                            SmallImage.drawSmallImage(g, values[index], popupX + index * indexSize + 18 + indexSize / 2, popupY + 32 + indexSize / 2, 0, 3);
                        }
                    }
                    if (indexTitle == 2) {
                        g.setColor(Paint.COLORDARK);
                        g.fillRect(popupX + 7, popupY + 60, popupW - 14, popupH - 68);
                        g.setColor(16777215);
                    } else {
                        g.setColor(10249521);
                    }
                    g.drawRect(popupX + 7, popupY + 60, popupW - 14, popupH - 68);
                    nso.GameScr.xstart = popupX + 17;
                    nso.GameScr.ystart = popupY + 62;
                    indexRowMax = 12;
                    scrMain.setStyle(indexRowMax, 12, popupX, popupY + 62, popupW, popupH - 72, true, 1);
                    scrMain.setClip(g);
                    mFont.tahoma_7b_yellow.drawString(g, mResources.CLANINFO[0] + Char.clan.name, nso.GameScr.xstart, nso.GameScr.ystart, 0);
                    mFont.tahoma_7_blue1.drawString(g, mResources.CLANINFO[1] + Char.clan.main_name, nso.GameScr.xstart, nso.GameScr.ystart += 12, 0);
                    mFont.tahoma_7_white.drawString(g, mResources.CLANINFO[2] + Char.clan.total + "/" + (Char.clan.level * 5 + 45), nso.GameScr.xstart, nso.GameScr.ystart += 12, 0);
                    mFont.tahoma_7_white.drawString(g, mResources.CLANINFO[3] + Char.clan.level, nso.GameScr.xstart, nso.GameScr.ystart += 12, 0);
                    mFont.tahoma_7_white.drawString(g, mResources.CLANINFO[4] + Char.clan.exp + "/" + Char.clan.expNext, nso.GameScr.xstart, nso.GameScr.ystart += 12, 0);
                    mFont.tahoma_7_white.drawString(g, mResources.CLANINFO[5] + NinjaUtil.numberToString(String.valueOf(Char.clan.coin)) + " " + mResources.XU, nso.GameScr.xstart, nso.GameScr.ystart += 12, 0);
                    mFont.tahoma_7_white.drawString(g, mResources.CLANINFO[8] + NinjaUtil.numberToString(String.valueOf(Char.clan.freeCoin)) + " " + mResources.XU, nso.GameScr.xstart, nso.GameScr.ystart += 12, 0);
                    mFont.tahoma_7_white.drawString(g, mResources.CLANINFO[9] + NinjaUtil.numberToString(String.valueOf(Char.clan.coinUp)) + " " + mResources.XU, nso.GameScr.xstart, nso.GameScr.ystart += 12, 0);
                    if (mFont.tahoma_7_white.getWidth(mResources.CLANINFO[10] + Char.clan.openDun + " " + mResources.COUNT) > inforW - 10) {
                        this.paintMultiLine(g, mFont.tahoma_7_white, mResources.CLANINFO[10] + Char.clan.openDun + " " + mResources.COUNT, nso.GameScr.xstart, nso.GameScr.ystart += 12, 0, popupW - 20);
                    } else {
                        mFont.tahoma_7_white.drawString(g, mResources.CLANINFO[10] + Char.clan.openDun + " " + mResources.COUNT, nso.GameScr.xstart, nso.GameScr.ystart += 12, 0);
                    }
                    if (mFont.tahoma_7_white.getWidth(mResources.CLANINFO[12] + Char.clan.use_card + " " + mResources.COUNT) > inforW - 10) {
                        this.paintMultiLine(g, mFont.tahoma_7_white, mResources.CLANINFO[12] + Char.clan.use_card + " " + mResources.COUNT, nso.GameScr.xstart, nso.GameScr.ystart += 12, 0, popupW - 20);
                    } else {
                        mFont.tahoma_7_white.drawString(g, mResources.CLANINFO[12] + Char.clan.use_card + " " + mResources.COUNT, nso.GameScr.xstart, nso.GameScr.ystart += 12, 0);
                    }
                    mFont.tahoma_7_white.drawString(g, mResources.CLANINFO[6] + Char.clan.reg_date, nso.GameScr.xstart, nso.GameScr.ystart += 12, 0);
                    if (this.arrClanInfo == null) {
                        this.arrClanInfo = splitMultiLine(mFont.tahoma_7_yellow, Char.clan.alert);
                    }
                    this.paintMultiLine(g, mFont.tahoma_7_yellow, this.arrClanInfo, nso.GameScr.xstart, nso.GameScr.ystart += 12, 0);
                    if (indexTitle == 2 && indexRow >= 0) {
                        SmallImage.drawSmallImage(g, 942, nso.GameScr.xstart - 8, popupY + 62 + 2 + indexRow * 12, 0, StaticObj.TOP_LEFT);
                    }
                    scrMain.setStyle(indexRowMax, 12, popupX, popupY + 62, popupW, popupH - 72, true, 1);
                } else {
                    indexRowMax = 1;
                    mFont.tahoma_7_white.drawString(g, mResources.EMPTY_INFO, popupX + popupW / 2, popupY + 40, 2);
                }
            } else if (indexMenu == 1) {
                nso.GameScr.xstart = popupX + 5;
                nso.GameScr.ystart = popupY + 32;
                if (vClan.size() == 0) {
                    mFont.tahoma_7_white.drawString(g, mResources.EMPTY_INFO, popupX + popupW / 2, popupY + 40, 2);
                } else {
                    g.setColor(6425);
                    g.fillRect(nso.GameScr.xstart - 2, nso.GameScr.ystart - 2, popupW - 6, indexSize * 5 + 8);
                    resetTranslate(g);
                    scrMain.setClip(g, nso.GameScr.xstart, nso.GameScr.ystart, popupW - 3, indexSize * 5 + 6);
                    this.indexMember = 0;
                    for (int index1 = 0; index1 < vClan.size(); index1++) {
                        Member member = (Member) vClan.elementAt(index1);
                        if (!isViewClanMemOnline || member.isOnline) {
                            if (index1 * (indexSize + indexSize / 2) >= scrMain.cmy - (indexSize + indexSize / 2) && index1 * (indexSize + indexSize / 2) < scrMain.cmy + indexSize * 5 + 8) {
                                if (indexRow == this.indexMember) {
                                    g.setColor(Paint.COLORLIGHT);
                                    g.fillRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + indexRow * (indexSize + indexSize / 2) + 2, popupW - 15, indexSize + indexSize / 2 - 4);
                                    g.setColor(16777215);
                                    g.drawRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + indexRow * (indexSize + indexSize / 2) + 2, popupW - 15, indexSize + indexSize / 2 - 4);
                                } else {
                                    g.setColor(Paint.COLORBACKGROUND);
                                    g.fillRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 2, popupW - 15, indexSize + indexSize / 2 - 4);
                                    g.setColor(13932896);
                                    g.drawRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 2, popupW - 15, indexSize + indexSize / 2 - 4);
                                }
                                SmallImage.drawSmallImage(g, member.iconId, nso.GameScr.xstart + 12, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 13, 0, 3);
                                if (member.type == 4) {
                                    SmallImage.drawSmallImage(g, 1216, nso.GameScr.xstart + 12, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 30, 0, 3);
                                    if (member.isOnline) {
                                        mFont.tahoma_7_yellow.drawString(g, mResources.CLANS_STANDFOR[0] + " ", nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 5, 0, mFont.tahoma_7_grey);
                                        mFont.tahoma_7_white.drawString(g, member.name + " - " + mResources.level + ": " + member.level, nso.GameScr.xstart + 45, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 5, 0);
                                        mFont.tahoma_7_green.drawString(g, mResources.CLANINFO[7] + member.pointClan, nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 16, 0);
                                        mFont.tahoma_7_blue1.drawString(g, mResources.CLANINFO[11] + member.pointClanWeek, nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 26, 0);
                                    } else {
                                        mFont.tahoma_7_grey.drawString(g, mResources.CLANS_STANDFOR[0] + " ", nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 5, 0);
                                        mFont.tahoma_7_grey.drawString(g, member.name + " - " + mResources.level + ": " + member.level, nso.GameScr.xstart + 45, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 5, 0);
                                        mFont.tahoma_7_grey.drawString(g, mResources.CLANINFO[7] + member.pointClan, nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 16, 0);
                                        mFont.tahoma_7_grey.drawString(g, mResources.CLANINFO[11] + member.pointClanWeek, nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 26, 0);
                                    }
                                } else if (member.type == 3) {
                                    SmallImage.drawSmallImage(g, 1215, nso.GameScr.xstart + 12, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 30, 0, 3);
                                    if (member.isOnline) {
                                        mFont.tahoma_7_yellow.drawString(g, mResources.CLANS_STANDFOR[1] + " ", nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 5, 0, mFont.tahoma_7_grey);
                                        mFont.tahoma_7_white.drawString(g, member.name + " - " + mResources.level + ": " + member.level, nso.GameScr.xstart + 45, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 5, 0);
                                        mFont.tahoma_7_green.drawString(g, mResources.CLANINFO[7] + member.pointClan, nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 16, 0);
                                        mFont.tahoma_7_blue1.drawString(g, mResources.CLANINFO[11] + member.pointClanWeek, nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 26, 0);
                                    } else {
                                        mFont.tahoma_7_grey.drawString(g, mResources.CLANS_STANDFOR[1] + " ", nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 5, 0);
                                        mFont.tahoma_7_grey.drawString(g, member.name + " - " + mResources.level + ": " + member.level, nso.GameScr.xstart + 45, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 5, 0);
                                        mFont.tahoma_7_grey.drawString(g, mResources.CLANINFO[7] + member.pointClan, nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 16, 0);
                                        mFont.tahoma_7_grey.drawString(g, mResources.CLANINFO[11] + member.pointClanWeek, nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 26, 0);
                                    }
                                } else if (member.type == 2) {
                                    SmallImage.drawSmallImage(g, 1217, nso.GameScr.xstart + 12, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 30, 0, 3);
                                    if (member.isOnline) {
                                        mFont.tahoma_7_yellow.drawString(g, mResources.CLANS_STANDFOR[2] + " ", nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 5, 0, mFont.tahoma_7_grey);
                                        mFont.tahoma_7_white.drawString(g, member.name + " - " + mResources.level + ": " + member.level, nso.GameScr.xstart + 45, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 5, 0);
                                        mFont.tahoma_7_green.drawString(g, mResources.CLANINFO[7] + member.pointClan, nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 16, 0);
                                        mFont.tahoma_7_blue1.drawString(g, mResources.CLANINFO[11] + member.pointClanWeek, nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 26, 0);
                                    } else {
                                        mFont.tahoma_7_grey.drawString(g, mResources.CLANS_STANDFOR[2] + " ", nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 5, 0);
                                        mFont.tahoma_7_grey.drawString(g, member.name + " - " + mResources.level + ": " + member.level, nso.GameScr.xstart + 45, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 5, 0);
                                        mFont.tahoma_7_grey.drawString(g, mResources.CLANINFO[7] + member.pointClan, nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 16, 0);
                                        mFont.tahoma_7_grey.drawString(g, mResources.CLANINFO[11] + member.pointClanWeek, nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 26, 0);
                                    }
                                } else if (member.type == 1) {
                                    SmallImage.drawSmallImage(g, 1214, nso.GameScr.xstart + 12, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 30, 0, 3);
                                    if (member.isOnline) {
                                        mFont.tahoma_7_yellow.drawString(g, mResources.CLANS_STANDFOR[3] + " ", nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 5, 0, mFont.tahoma_7_grey);
                                        mFont.tahoma_7_white.drawString(g, member.name + " - " + mResources.level + ": " + member.level, nso.GameScr.xstart + 45, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 5, 0);
                                        mFont.tahoma_7_green.drawString(g, mResources.CLANINFO[7] + member.pointClan, nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 16, 0);
                                        mFont.tahoma_7_blue1.drawString(g, mResources.CLANINFO[11] + member.pointClanWeek, nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 26, 0);
                                    } else {
                                        mFont.tahoma_7_grey.drawString(g, mResources.CLANS_STANDFOR[3] + " ", nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 5, 0);
                                        mFont.tahoma_7_grey.drawString(g, member.name + " - " + mResources.level + ": " + member.level, nso.GameScr.xstart + 45, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 5, 0);
                                        mFont.tahoma_7_grey.drawString(g, mResources.CLANINFO[7] + member.pointClan, nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 16, 0);
                                        mFont.tahoma_7_grey.drawString(g, mResources.CLANINFO[11] + member.pointClanWeek, nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 26, 0);
                                    }
                                } else if (member.isOnline) {
                                    mFont.tahoma_7_white.drawString(g, member.name + " - " + mResources.level + ": " + member.level, nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 5, 0);
                                    mFont.tahoma_7_green.drawString(g, mResources.CLANINFO[7] + member.pointClan, nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 16, 0);
                                    mFont.tahoma_7_blue1.drawString(g, mResources.CLANINFO[11] + member.pointClanWeek, nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 26, 0);
                                } else {
                                    mFont.tahoma_7_grey.drawString(g, member.name + " - " + mResources.level + ": " + member.level, nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 5, 0);
                                    mFont.tahoma_7_grey.drawString(g, mResources.CLANINFO[7] + member.pointClan, nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 16, 0);
                                    mFont.tahoma_7_grey.drawString(g, mResources.CLANINFO[11] + member.pointClanWeek, nso.GameScr.xstart + 22, nso.GameScr.ystart + this.indexMember * (indexSize + indexSize / 2) + 26, 0);
                                }
                            }
                            this.indexMember++;
                        }
                    }
                    scrMain.setStyle(this.indexMember, indexSize + indexSize / 2, nso.GameScr.xstart, nso.GameScr.ystart, popupW - 3, indexSize * 5 + 4, true, 1);
                    indexRowMax = this.indexMember;
                    paintNumCount(g);
                }
            } else if (indexMenu != 2) {
                if (indexMenu == 3) {
                    if (Char.clan != null && Char.clan.name != null && !Char.clan.name.equals("") && !Char.clan.log.equals("")) {
                        indexRowMax = 1;
                        nso.GameScr.xstart = popupX + 17;
                        nso.GameScr.ystart = popupY + 34;
                        inforW = popupW - 30;
                        scrMain.setClip(g);
                        if (this.arrClanDongGop == null) {
                            this.arrClanDongGop = splitMultiLine(mFont.tahoma_7_white, Char.clan.log);
                        }
                        this.paintMultiLine(g, mFont.tahoma_7_white, this.arrClanDongGop, nso.GameScr.xstart, nso.GameScr.ystart, 0);
                        if (indexTitle == 1 && indexRow >= 0) {
                            SmallImage.drawSmallImage(g, 942, nso.GameScr.xstart - 8, popupY + 34 + 2 + indexRow * 12, 0, StaticObj.TOP_LEFT);
                        }
                        scrMain.setStyle(indexRowMax, 12, popupX, popupY + 35, popupW, popupH - 44, true, 1);
                    } else {
                        indexRowMax = 1;
                        mFont.tahoma_7_white.drawString(g, mResources.EMPTY_INFO, popupX + popupW / 2, popupY + 40, 2);
                    }
                } else {
                    if (indexMenu == 4) {
                        this.paintThanThu_Clan(g);
                    }
                }
            } else {
                nso.GameScr.xstart = popupX + 3;
                nso.GameScr.ystart = popupY + 32;
                g.setColor(6425);
                g.fillRect(nso.GameScr.xstart - 1, nso.GameScr.ystart - 1, columns * indexSize + 3, 5 * indexSize + 3);
                Item[] values2 = null;
                if (Char.clan != null && Char.clan.items != null) {
                    values2 = Char.clan.items;
                } else {
                    values2 = new Item[30];
                }
                this.paintBagItem(g, values2);
            }
        }
    }

    private static void paintNumCount(mGraphics g) {
        resetTranslate(g);
        int value = indexRow;
        if (isPaintAuctionBuy) {
            value = indexSelect;
        }
        if (value >= 0 && indexRowMax > 0) {
            value = value + 1 < indexRowMax ? value + 1 : indexRowMax;
            mFont.tahoma_7_yellow.drawString(g, value + "/" + indexRowMax, popupX + popupW / 2, popupY + popupH - 12, 2, mFont.tahoma_7_grey);
        }
    }

    private void updateKeyUIInforMe() {
        if (isPaintInfoMe && indexMenu != -1 && GameCanvas.currentDialog == null) {
            if (indexTitle == 0) {
                super.left = super.center = null;
                if (indexMenu == 0) {
                    super.left = new Command(mResources.SORT, 110221);
                }
                if (GameCanvas.keyPressedz[8]) {
                    indexTitle = 1;
                    indexSelect = 0;
                    indexRow = 0;
                    scrMain.clear();
                    scrInfo.clear();
                }
                if (GameCanvas.keyPressedz[4]) {
                    indexSelect = 0;
                    indexRow = -1;
                    indexMenu--;
                    scrMain.clear();
                    scrInfo.clear();
                    if (currentCharViewInfo.charID != Char.getMyChar().charID) {
                        if (indexMenu < 3) {
                            indexMenu = 5;
                        }
                    } else if (indexMenu < 0) {
                        indexMenu = mResources.MENUME.length - 1;
                    }
                    this.doMiniMenuInforMe();
                }
                if (GameCanvas.keyPressedz[6]) {
                    indexSelect = 0;
                    indexRow = -1;
                    indexMenu++;
                    scrMain.clear();
                    scrInfo.clear();
                    if (currentCharViewInfo.charID != Char.getMyChar().charID) {
                        if (indexMenu > 5) {
                            indexMenu = 3;
                        }
                    } else if (indexMenu > mResources.MENUME.length - 1) {
                        indexMenu = 0;
                    }
                    this.doMiniMenuInforMe();
                }
                this.setLCR();
            } else if (nso.GameScr.isPaintItemInfo) {
                if (GameCanvas.keyPressedz[2]) {
                    if (--indexRow < 0) {
                        indexRow = indexRowMax - 1;
                    }
                    scrInfo.moveTo(indexRow * scrInfo.ITEM_SIZE);
                } else if (GameCanvas.keyPressedz[8]) {
                    if (++indexRow >= indexRowMax) {
                        indexRow = 0;
                    }
                    scrInfo.moveTo(indexRow * scrInfo.ITEM_SIZE);
                }
            } else if (indexMenu == 0) {
                if (GameCanvas.keyPressedz[4]) {
                    if (--indexSelect < 0) {
                        indexSelect = Char.getMyChar().arrItemBag.length - 1;
                    }
                    super.left = super.center = null;
                    this.setLCR();
                    scrMain.moveTo(indexSelect / columns * scrMain.ITEM_SIZE);
                } else if (GameCanvas.keyPressedz[6]) {
                    if (++indexSelect >= Char.getMyChar().arrItemBag.length) {
                        indexSelect = 0;
                    }
                    super.left = super.center = null;
                    this.setLCR();
                    scrMain.moveTo(indexSelect / columns * scrMain.ITEM_SIZE);
                } else if (GameCanvas.keyPressedz[8]) {
                    if (indexSelect + columns <= Char.getMyChar().arrItemBag.length - 1) {
                        indexSelect = indexSelect + columns;
                    }
                    super.left = super.center = null;
                    this.setLCR();
                    scrMain.moveTo(indexSelect / columns * scrMain.ITEM_SIZE);
                } else if (GameCanvas.keyPressedz[2]) {
                    if (indexSelect >= 0 && indexSelect < columns) {
                        indexTitle = 0;
                        indexSelect = 0;
                    } else if (indexSelect - columns >= 0) {
                        indexSelect = indexSelect - columns;
                    }
                    super.left = super.center = null;
                    this.setLCR();
                    scrMain.moveTo(indexSelect / columns * scrMain.ITEM_SIZE);
                }
            } else if (indexMenu == 1) {
                if (GameCanvas.keyPressedz[2]) {
                    if (indexTitle == 1 && indexRow == -1) {
                        indexTitle--;
                    } else if (indexTitle == 1 && indexRow >= 0) {
                        indexRow--;
                    }
                    scrInfo.moveTo(indexRow * scrInfo.ITEM_SIZE);
                } else if (GameCanvas.keyPressedz[8]) {
                    if (indexTitle == 0) {
                        indexTitle++;
                    } else if (indexTitle == 1) {
                        if (++indexRow >= indexRowMax) {
                            indexRow = 0;
                        }
                        scrInfo.moveTo(indexRow * scrInfo.ITEM_SIZE);
                    }
                    super.left = super.center = null;
                    this.setLCR();
                } else if (GameCanvas.keyPressedz[4]) {
                    indexRow = -1;
                    if (indexTitle == 1 && --indexSelect < 0) {
                        indexSelect = Char.getMyChar().nClass.skillTemplates.length - 1;
                    }
                    super.left = super.center = null;
                    this.setLCR();
                    scrMain.moveTo(indexSelect * scrMain.ITEM_SIZE);
                    scrInfo.clear();
                    indexRow = 0;
                } else if (GameCanvas.keyPressedz[6]) {
                    indexRow = -1;
                    if (indexTitle == 1 && ++indexSelect >= Char.getMyChar().nClass.skillTemplates.length) {
                        indexSelect = 0;
                    }
                    super.left = super.center = null;
                    this.setLCR();
                    scrMain.moveTo(indexSelect * scrMain.ITEM_SIZE);
                    scrInfo.clear();
                    indexRow = 0;
                }
            } else if (indexMenu == 2) {
                if (GameCanvas.keyPressedz[2]) {
                    indexTitle--;
                } else if (GameCanvas.keyPressedz[8]) {
                    if (++indexTitle >= 5) {
                        indexTitle = 1;
                    }
                    super.left = super.center = null;
                    this.setLCR();
                }
            } else if (indexMenu == 3) {
                if (indexRow < 0) {
                    indexRow = 0;
                }
                if (GameCanvas.keyPressedz[2]) {
                    if (indexRow == 0) {
                        indexTitle--;
                        indexRow = -1;
                    } else {
                        indexRow--;
                    }
                    scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                } else if (GameCanvas.keyPressedz[8]) {
                    if (++indexRow >= indexRowMax) {
                        indexRow = 0;
                    }
                    scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                }
            } else if (indexMenu == 4) {
                int value = indexSelect;
                if (indexSelect != 11 && indexSelect != 12 && indexSelect != 13 && indexSelect != 14) {
                    if (indexSelect == 9) {
                        if (GameCanvas.keyPressedz[2]) {
                            indexSelect -= 2;
                        } else if (GameCanvas.keyPressedz[8]) {
                            indexSelect = 15;
                        } else if (GameCanvas.keyPressedz[4]) {
                            indexSelect--;
                        } else if (GameCanvas.keyPressedz[6]) {
                            indexSelect++;
                        }
                    } else if (indexSelect == 10) {
                        if (GameCanvas.keyPressedz[2]) {
                            indexSelect -= 2;
                        } else if (GameCanvas.keyPressedz[4]) {
                            indexSelect--;
                        } else if (GameCanvas.keyPressedz[6] || GameCanvas.keyPressedz[8]) {
                            indexSelect++;
                        }
                    } else if (indexSelect == 15) {
                        if (GameCanvas.keyPressedz[2]) {
                            indexSelect = 9;
                        } else if (GameCanvas.keyPressedz[4]) {
                            indexSelect--;
                        } else if (GameCanvas.keyPressedz[8] || GameCanvas.keyPressedz[6]) {
                            indexSelect = 0;
                        }
                    } else if (GameCanvas.keyPressedz[2]) {
                        if (indexSelect <= 1) {
                            indexSelect = 0;
                            indexTitle = 0;
                        } else {
                            indexSelect -= 2;
                        }
                    } else if (GameCanvas.keyPressedz[8]) {
                        if ((indexSelect += 2) > 15) {
                            indexSelect = 0;
                        }
                    } else if (GameCanvas.keyPressedz[4]) {
                        if (--indexSelect < 0) {
                            indexSelect = 15;
                        }
                    } else if (GameCanvas.keyPressedz[6] && ++indexSelect > 11) {
                        indexSelect = 0;
                    }
                } else if (GameCanvas.keyPressedz[2] || GameCanvas.keyPressedz[4]) {
                    indexSelect--;
                } else if (GameCanvas.keyPressedz[6] || GameCanvas.keyPressedz[8]) {
                    indexSelect++;
                }
                if (value != indexSelect) {
                    super.left = super.center = null;
                    this.setLCR();
                }
            } else if (indexMenu == 5) {
                if (GameCanvas.keyPressedz[2]) {
                    if (indexSelect == 4) {
                        indexSelect = 0;
                        indexTitle--;
                    } else if (--indexSelect < 0) {
                        indexSelect = 0;
                        indexTitle--;
                    }
                    this.setLCR();
                } else if (GameCanvas.keyPressedz[4]) {
                    if (indexSelect >= 2 && indexSelect != 4) {
                        indexSelect = 4;
                    } else {
                        indexSelect = 0;
                    }
                    this.setLCR();
                } else if (GameCanvas.keyPressedz[6]) {
                    if (indexSelect < 2) {
                        indexSelect = 4;
                    } else {
                        indexSelect = 2;
                    }
                    this.setLCR();
                } else if (GameCanvas.keyPressedz[8]) {
                    if (++indexSelect >= 4) {
                        indexSelect = 0;
                    }
                    this.setLCR();
                }
            } else if (indexMenu == 6) {
                if (indexBijuuMenu == 0) {
                    if (GameCanvas.keyPressedz[2]) {
                        if (indexSelect == 4) {
                            indexSelect = 0;
                            indexTitle--;
                        } else if (--indexSelect < 0) {
                            indexSelect = 0;
                            indexTitle--;
                        }
                        this.setLCR();
                    } else if (GameCanvas.keyPressedz[4]) {
                        if (indexSelect >= 2 && indexSelect != 4) {
                            indexSelect = 4;
                        } else {
                            indexSelect = 0;
                        }
                        this.setLCR();
                    } else if (GameCanvas.keyPressedz[6]) {
                        if (indexSelect < 2) {
                            indexSelect = 4;
                        } else {
                            indexSelect = 2;
                        }
                        this.setLCR();
                    } else if (GameCanvas.keyPressedz[8]) {
                        if (++indexSelect >= 4) {
                            indexSelect = 0;
                        }
                        this.setLCR();
                    }
                } else if (indexBijuuMenu == 1) {
                    if (GameCanvas.keyPressedz[2]) {
                        indexTitle--;
                    } else if (GameCanvas.keyPressedz[8]) {
                        if (++indexTitle >= 5) {
                            indexTitle = 1;
                        }
                        super.left = super.center = null;
                        this.setLCR();
                    }
                } else if (GameCanvas.keyPressedz[2]) {
                    if (indexTitle == 1 && indexRow == -1) {
                        indexTitle--;
                    } else if (indexTitle == 1 && indexRow >= 0) {
                        indexRow--;
                    }
                    scrInfo.moveTo(indexRow * scrInfo.ITEM_SIZE);
                } else if (GameCanvas.keyPressedz[8]) {
                    if (indexTitle == 0) {
                        indexTitle++;
                    } else if (indexTitle == 1) {
                        if (++indexRow >= indexRowMax) {
                            indexRow = 0;
                        }
                        scrInfo.moveTo(indexRow * scrInfo.ITEM_SIZE);
                    }
                    super.left = super.center = null;
                    this.setLCR();
                } else if (GameCanvas.keyPressedz[4]) {
                    indexRow = -1;
                    if (indexTitle == 1 && --indexSelect < 0) {
                        indexSelect = Char.getMyChar().nClass.skillTemplates.length - 1;
                    }
                    super.left = super.center = null;
                    this.setLCR();
                    scrMain.moveTo(indexSelect * scrMain.ITEM_SIZE);
                    scrInfo.clear();
                    indexRow = 0;
                } else if (GameCanvas.keyPressedz[6]) {
                    indexRow = -1;
                    if (indexTitle == 1 && ++indexSelect >= Char.getMyChar().nClass.skillTemplates.length) {
                        indexSelect = 0;
                    }
                    super.left = super.center = null;
                    this.setLCR();
                    scrMain.moveTo(indexSelect * scrMain.ITEM_SIZE);
                    scrInfo.clear();
                    indexRow = 0;
                }
            }
            if (GameCanvas.isTouch) {
                label592: if (!GameCanvas.menu.showMenu && GameCanvas.currentDialog == null) {
                    if (GameCanvas.isPointerJustRelease && GameCanvas.isPointerHoldIn(popupX, popupY, popupW, this.Hitem) && (!nso.GameScr.isPaintItemInfo || GameCanvas.w >= 320) && GameCanvas.isPointerClick) {
                        if (GameCanvas.isPointerHoldIn(nso.GameScr.gW2 - 90, popupY + 5, 60, 40)) {
                            indexSelect = 0;
                            indexMenu--;
                        }
                        if (GameCanvas.isPointerHoldIn(nso.GameScr.gW2 + 20, popupY + 5, 60, 40)) {
                            indexSelect = 0;
                            indexMenu++;
                        }
                        nso.GameScr.isPaintItemInfo = false;
                        scrMain.clear();
                        scrInfo.clear();
                        if (currentCharViewInfo.charID != Char.getMyChar().charID) {
                            if (indexMenu < 3) {
                                indexMenu = mResources.MENUME.length - 1;
                            }
                            if (indexMenu > mResources.MENUME.length - 1) {
                                indexMenu = 3;
                            }
                        } else {
                            if (indexMenu < 0) {
                                indexMenu = mResources.MENUME.length - 1;
                            }
                            if (indexMenu > mResources.MENUME.length - 1) {
                                indexMenu = 0;
                            }
                        }
                        indexTitle = 1;
                        indexSelect = -1;
                        this.doMiniMenuInforMe();
                    }
                    if (nso.GameScr.isPaintItemInfo) {
                        ScrollResult scrollResult;
                        if ((scrollResult = scrInfo.updateKey()).isDowning || scrollResult.isFinish) {
                            indexRow = scrollResult.selected;
                            indexTitle = 1;
                        }
                        if (GameCanvas.isTouchControlSmallScreen) {
                            break label592;
                        }
                    }
                    if (indexMenu == 0) {
                        ScrollResult scrollResult1;
                        if ((scrollResult1 = scrMain.updateKey()).isDowning || scrollResult1.isFinish) {
                            if (indexSelect != scrollResult1.selected) {
                                indexSelect = scrollResult1.selected;
                                super.left = super.center = null;
                                if (GameCanvas.isTouchControlSmallScreen) {
                                    this.setLCR();
                                } else if (getItemFocus(3) != null) {
                                    this.actBagViewItemInfo();
                                } else {
                                    nso.GameScr.isPaintItemInfo = false;
                                    super.left = this.cmdBagSortItem;
                                }
                            }
                            indexTitle = 1;
                        }
                    } else if (indexMenu == 1) {
                        ScrollResult scrollResult2;
                        if (!(scrollResult2 = scrMain.updateKey()).isDowning && !scrollResult2.isFinish) {
                            if (((scrollResult2 = scrInfo.updateKey()).isDowning || scrollResult2.isFinish) && indexRow != scrollResult2.selected) {
                                indexRow = scrollResult2.selected;
                            }
                        } else {
                            if (indexSelect != scrollResult2.selected) {
                                if ((indexSelect = scrollResult2.selected) >= Char.getMyChar().nClass.skillTemplates.length) {
                                    indexSelect = -1;
                                }
                                super.left = super.center = null;
                                this.setLCR();
                                scrInfo.clear();
                                indexRow = 0;
                            }
                            indexTitle = 1;
                        }
                    } else if (indexMenu == 2) {
                        if (GameCanvas.isPointerJustRelease && GameCanvas.isPointerHoldIn(popupX + 5, popupY + 52, popupW - 10, 130) && GameCanvas.isPointerClick) {
                            int value3 = (GameCanvas.py - (popupY + 52)) / 32;
                            if (++value3 == this.indexTiemNang) {
                                MyVector entries;
                                (entries = new MyVector()).addElement(new Command(mResources.UPPOINT, 11064));
                                entries.addElement(new Command(mResources.UPPOINTS, 11065));
                                GameCanvas.menu.startAt(entries);
                            }
                            indexTitle = value3;
                            this.indexTiemNang = value3;
                            this.setLCR();
                        }
                    } else if (indexMenu == 3) {
                        ScrollResult scrollResult4;
                        if ((scrollResult4 = scrMain.updateKey()).isDowning || scrollResult4.isFinish) {
                            indexRow = scrollResult4.selected;
                            indexTitle = 1;
                        }
                    } else if (indexMenu == 4) {
                        if (GameCanvas.isPointerJustRelease) {
                            indexTitle = 1;
                            if (GameCanvas.isPointerHoldIn(popupX + 4, popupY + 35, indexSize, 130)) {
                                indexSelect = (GameCanvas.py - (popupY + 35)) / indexSize << 1;
                                super.left = super.center = null;
                                this.setLCR();
                            }
                            if (GameCanvas.isPointerHoldIn(popupX + popupW - 30, popupY + 35, indexSize, 130)) {
                                indexSelect = ((GameCanvas.pyLast - (popupY + 35)) / indexSize << 1) + 1;
                                super.left = super.center = null;
                                this.setLCR();
                            }
                            if (GameCanvas.isPointerHoldIn(popupX + 4, popupY + 165, popupW - 8, indexSize)) {
                                int value5 = (GameCanvas.pxLast - (popupX + 4)) / indexSize;
                                value5 += 10;
                                indexSelect = value5;
                                super.left = super.center = null;
                                this.setLCR();
                            }
                        }
                    } else if (indexMenu == 5) {
                        if (GameCanvas.isPointerJustRelease) {
                            for (int index = 0; index < this.xMounts.length; index++) {
                                if (index == 4) {
                                    if (GameCanvas.isPointerHoldIn(this.xMounts[index], this.yMounts[index], 84, 75) && GameCanvas.isPointerClick) {
                                        indexTitle = 1;
                                        indexSelect = 4;
                                        this.setLCR();
                                        if (!GameCanvas.isTouchControlSmallScreen && super.center != null) {
                                            this.actionPerform(super.center.idAction, super.center.p);
                                        }
                                    }
                                } else if (GameCanvas.isPointerHoldIn(this.xMounts[index], this.yMounts[index], indexSize, indexSize) && GameCanvas.isPointerClick) {
                                    indexTitle = 1;
                                    indexSelect = index;
                                    this.setLCR();
                                    if (!GameCanvas.isTouchControlSmallScreen) {
                                        if (currentCharViewInfo.arrItemMounts[indexSelect] != null) {
                                            this.actionPerform(super.center.idAction, super.center.p);
                                        } else {
                                            nso.GameScr.isPaintItemInfo = false;
                                        }
                                    }
                                }
                            }
                        }
                    } else if (indexMenu == 6) {
                        if (indexBijuuMenu == 0) {
                            if (GameCanvas.isPointerJustRelease) {
                                for (int index6 = 0; index6 < this.xMounts.length; index6++) {
                                    if (index6 == 4) {
                                        if (GameCanvas.isPointerHoldIn(this.xMounts[index6], this.yMounts[index6], 84, 75) && GameCanvas.isPointerClick) {
                                            indexTitle = 1;
                                            indexSelect = 4;
                                            this.setLCR();
                                            if (!GameCanvas.isTouchControlSmallScreen && super.center != null) {
                                                this.actionPerform(super.center.idAction, super.center.p);
                                            }
                                        }
                                    } else if (GameCanvas.isPointerHoldIn(this.xMounts[index6], this.yMounts[index6], indexSize, indexSize) && GameCanvas.isPointerClick) {
                                        indexTitle = 1;
                                        indexSelect = index6;
                                        this.setLCR();
                                        if (!GameCanvas.isTouchControlSmallScreen) {
                                            if (currentCharViewInfo.arrItemViThu[indexSelect] != null) {
                                                this.actionPerform(super.center.idAction, super.center.p);
                                            } else {
                                                nso.GameScr.isPaintItemInfo = false;
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (indexBijuuMenu == 1) {
                            if (GameCanvas.isPointerJustRelease && GameCanvas.isPointerHoldIn(popupX + 5, popupY + 52, popupW - 10, 130) && GameCanvas.isPointerClick) {
                                int value7 = (GameCanvas.py - (popupY + 52)) / 32;
                                if (++value7 == this.indexTiemNang) {
                                    actBijuuMenuPoint();
                                }
                                indexTitle = value7;
                                this.indexTiemNang = value7;
                                this.setLCR();
                            }
                        } else {
                            ScrollResult scrollResult8;
                            if (!(scrollResult8 = scrMain.updateKey()).isDowning && !scrollResult8.isFinish) {
                                if (((scrollResult8 = scrInfo.updateKey()).isDowning || scrollResult8.isFinish) && indexRow != scrollResult8.selected) {
                                    indexRow = scrollResult8.selected;
                                }
                            } else {
                                if (indexSelect != scrollResult8.selected) {
                                    if ((indexSelect = scrollResult8.selected) >= Char.getMyChar().nClass.skillTemplates.length) {
                                        indexSelect = -1;
                                    }
                                    super.left = super.center = null;
                                    this.setLCR();
                                    scrInfo.clear();
                                    indexRow = 0;
                                }
                                indexTitle = 1;
                            }
                        }
                    }
                }
            }
            GameCanvas.clearKeyHold();
            GameCanvas.clearKeyPressed();
        }
    }

    private static Member curMemberSelected() {
        return (Member) vClan.elementAt(indexRow);
    }

    private void setClanComand() {
        if (!nso.GameScr.isPaintItemInfo) {
            super.left = super.center = null;
            if (indexMenu == 0) {
                if (Char.getMyChar().ctypeClan == 4) {
                    super.left = new Command(mResources.CLANS[0], 14004);
                }
                if (Char.getMyChar().ctypeClan == 3) {
                    super.left = new Command(mResources.CLANS[1], 14004);
                }
                if (Char.getMyChar().ctypeClan == 2) {
                    super.left = new Command(mResources.CLANS[2], 14004);
                }
                if (!Char.getMyChar().cClanName.equals("")) {
                    if (indexTitle == 1) {
                        super.center = new Command(mResources.VIEW, 140101);
                        return;
                    }
                    super.center = new Command(mResources.CLAN_MENU[3], 14010);
                    return;
                }
            } else if (indexMenu == 1) {
                Member member;
                if (vClan.size() > 0 && indexRow >= 0 && indexRow < vClan.size() && (member = curMemberSelected()) != null) {
                    if (Char.getMyChar().ctypeClan == 4) {
                        super.left = new Command(mResources.CLANS[0], 14005);
                    }
                    if (Char.getMyChar().ctypeClan == 3) {
                        super.left = new Command(mResources.CLANS[1], 14005);
                    }
                    if (Char.getMyChar().ctypeClan != 4 && Char.getMyChar().ctypeClan != 3) {
                        super.left = new Command(mResources.CLANS[4], 14005);
                    }
                    if (!member.name.equals(Char.getMyChar().cName) && (!isViewClanMemOnline || this.indexMember != 0)) {
                        super.center = new Command(mResources.SELECT, 14006, member.name);
                        return;
                    }
                }
            } else if (indexMenu == 2 && indexTitle == 1) {
                if (Char.clan == null || Char.clan.items == null) {
                    return;
                }
                super.left = new Command(mResources.SELECT, 1508);
                if (!GameCanvas.isTouchControlLargeScreen) {
                    super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 1509);
                }
            }
        }
    }

    private void updateKeyAlert() {
        if (isPaintAlert && GameCanvas.currentDialog == null) {
            int value = 0;
            if (GameCanvas.keyPressedz[8]) {
                if (++indexRow >= this.texts.size()) {
                    indexRow = 0;
                }
                value = 1;
            } else if (GameCanvas.keyPressedz[2]) {
                if (--indexRow < 0) {
                    indexRow = this.texts.size() - 1;
                }
                value = 1;
            }
            if ((value != 0)) {
                scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                GameCanvas.clearKeyHold();
                GameCanvas.clearKeyPressed();
            }
            ScrollResult scrollResult;
            if (GameCanvas.isTouch && ((scrollResult = scrMain.updateKey()).isDowning || scrollResult.isFinish)) {
                indexRow = scrollResult.selected;
                value = 1;
            }
            ChatTab chatTab;
            if (isPaintMessage && !GameCanvas.isTouch && (chatTab = ChatManager.gI().getCurrentChatTab()).type == 2 && indexRow == 0) {
                ChatTextField.gI().center = new Command(mResources.HIDE_TAB, 120051, chatTab);
            }
            if ((value != 0) && indexRow >= 0 && indexRow < this.texts.size()) {
                String text = (String) this.texts.elementAt(indexRow);
                value = 0;
                this.fnick = null;
                this.alertURL = null;
                super.center = null;
                ChatTextField.gI().center = null;
                if ((value = text.indexOf("http://")) >= 0) {
                    this.alertURL = text.substring(value);
                    super.center = new Command(mResources.OPEN_LINK, 12000);
                    if (!GameCanvas.isTouch) {
                        ChatTextField.gI().center = new Command(mResources.OPEN_LINK, null, 12000, null);
                        return;
                    }
                } else if (text.indexOf("@") >= 0) {
                    String text1;
                    value = (text1 = text.substring(2).trim()).indexOf("@");
                    String text2 = text1.substring(value);
                    int value3 = 0;
                    if ((value3 = text2.indexOf(" ")) <= 0) {
                        value3 = value + text2.length();
                    } else {
                        value3 += value;
                    }
                    this.fnick = text1.substring(value + 1, value3);
                    if (!this.fnick.equals("") && !this.fnick.equals(Char.getMyChar().cName) && !this.fnick.equals(mResources.SERVER_ALERT.substring(0, 5)) && !this.fnick.equals(mResources.SERVER_ALERT)) {
                        super.center = new Command(mResources.SELECT, 12009, this.fnick);
                        if (!GameCanvas.isTouch) {
                            ChatTextField.gI().center = new Command(mResources.SELECT, null, 12009, this.fnick);
                            return;
                        }
                    } else {
                        this.fnick = null;
                        super.center = null;
                    }
                }
            }
        }
    }

    private void updateKeyMessage() {
        if (isPaintMessage) {
            boolean flag = false;
            if (GameCanvas.keyPressedz[4]) {
                flag = true;
                ChatManager.gI().switchToPreviousTab();
            } else if (GameCanvas.keyPressedz[6]) {
                flag = true;
                ChatManager.gI().switchToNextTab();
            }
            if (flag) {
                this.openUIChatTab();
            }
            if (GameCanvas.isTouch && GameCanvas.isTouch && GameCanvas.isPointerHoldIn(popupX, popupY, popupW, this.Hitem) && (!nso.GameScr.isPaintItemInfo || GameCanvas.w >= 320) && GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                if (GameCanvas.isPointerHoldIn(nso.GameScr.gW2 - 90, popupY + 5, 60, 40)) {
                    ChatManager.gI().switchToPreviousTab();
                    this.openUIChatTab();
                }
                if (GameCanvas.isPointerHoldIn(nso.GameScr.gW2 + 20, popupY + 5, 60, 40)) {
                    ChatManager.gI().switchToNextTab();
                    this.openUIChatTab();
                }
            }
        }
    }

    private void setCharFocusCommand() {
        if (indexRow >= 0 && vCharInMap.size() > 0) {
            if (Char.getIndexChar(this.cLastFocusID) == indexRow) {
                super.left = new Command(mResources.UNSELECT, 14002);
            } else {
                super.left = new Command(mResources.SELECT, 14003);
                super.center = new Command("", 14003);
            }
        } else {
            super.left = super.center = null;
        }
    }

    private void setRankedListCommand() {
        if (vList.size() > 0 && indexRow >= 0 && indexRowMax > 0) {
            super.center = new Command(mResources.RANKED_MATCH, 14024);
            super.left = new Command(mResources.PLAYER_INFO, 14025);
        } else {
            super.center = null;
            super.left = null;
        }
    }

    private void setDunListCommand() {
        if (vList.size() > 0 && indexRow >= 0 && indexRowMax > 0) {
            super.center = new Command(mResources.SELECT, 14021);
        } else {
            super.center = null;
        }
    }

    private void setEnemiesCommand() {
        if (vEnemies.size() > 0 && indexRow >= 0 && indexRowMax > 0) {
            super.center = new Command(mResources.SELECT, 11078);
        } else {
            super.center = null;
        }
    }

    private void setFriendCommand() {
        if (vFriend.size() > 0 && indexRow >= 0 && indexRowMax > 0 && indexRow < vFriend.size()) {
            vFriend.elementAt(indexRow);
            super.center = new Command(mResources.SELECT, 11079);
        } else {
            super.center = null;
        }
    }

    private void setPartyCommand() {
        super.center = null;
        if (indexRow != -1) {
            if (((Party) vParty.elementAt(0)).charId == Char.getMyChar().charID) {
                Party party;
                if ((party = (Party) vParty.elementAt(indexRow)).charId != Char.getMyChar().charID) {
                    super.center = new Command(mResources.SELECT, 11080, party.name);
                    return;
                }
            } else {
                Party party1;
                if ((party1 = (Party) vParty.elementAt(indexRow)).charId != Char.getMyChar().charID) {
                    super.center = new Command(mResources.SELECT, 12009, party1.name);
                }
            }
        }
    }

    private static boolean isPaintPopup() {
        return isPaintRankedList || isPaintLuckySpin || nso.GameScr.isPaintItemInfo || isPaintInfoMe || isPaintStore || nso.GameScr.isPaintEliteShop || isPaintAuctionBuy || nso.GameScr.isPaintWeapon || nso.GameScr.isPaintNonNam || nso.GameScr.isPaintNonNu || nso.GameScr.isPaintAoNam || nso.GameScr.isPaintAoNu || nso.GameScr.isPaintGangTayNam || nso.GameScr.isPaintGangTayNu || nso.GameScr.isPaintQuanNam || nso.GameScr.isPaintQuanNu || nso.GameScr.isPaintGiayNam || nso.GameScr.isPaintGiayNu || nso.GameScr.isPaintLien || nso.GameScr.isPaintNhan || nso.GameScr.isPaintNgocBoi || nso.GameScr.isPaintPhu || nso.GameScr.isPaintStack || nso.GameScr.isPaintStackLock || nso.GameScr.isPaintGrocery || nso.GameScr.isPaintGroceryLock || nso.GameScr.isPaintUpGrade || nso.GameScr.isPaintAuctionSale || nso.GameScr.isPaintConvert || nso.GameScr.isPaintSplit || nso.GameScr.isPaintTinhluyen || nso.GameScr.isPaintDichChuyen || nso.GameScr.isPaintUpPearl || nso.GameScr.isPaintLuyenThach || nso.GameScr.isPaintBox || isPaintTrade || isPaintAlert || isPaintZone || isPaintAuto || isPaintTeam || isPaintClan || isPaintFindTeam || isPaintTask || isPaintFriend || isPaintList || isPaintEnemies || isPaintCharInMap || isPaintMessage || isPaintLucky_Draw || nso.GameScr.isPaintLuyenNgoc || nso.GameScr.isPaintCheDo || nso.GameScr.isPaintKhamNgoc || nso.GameScr.isPaintGiaoDo || nso.GameScr.isPaintGotNgoc || nso.GameScr.isPaintThaoNgoc;
    }

    private boolean isNotPaintTouchControl() {
        if (!GameCanvas.isTouch || Char.ischangingMap || isPaintZone || isPaintAuto) {
            return true;
        } else if (ChatTextField.gI().isShow) {
            return true;
        } else {
            return super.center == this.cmdDead && GameCanvas.isTouchControlLargeScreen ? true : GameCanvas.currentDialog != null || ChatPopup.currentMultilineChatPopup != null || GameCanvas.menu.showMenu || isPaintPopup();
        }
    }

    public static boolean isPaintUI() {
        return isPaintAuto || isPaintStore || isPaintLuckySpin || nso.GameScr.isPaintEliteShop || nso.GameScr.isPaintWeapon || nso.GameScr.isPaintNonNam || nso.GameScr.isPaintNonNu || nso.GameScr.isPaintAoNam || nso.GameScr.isPaintAoNu || nso.GameScr.isPaintGangTayNam || nso.GameScr.isPaintGangTayNu || nso.GameScr.isPaintQuanNam || nso.GameScr.isPaintQuanNu || nso.GameScr.isPaintGiayNam || nso.GameScr.isPaintGiayNu || nso.GameScr.isPaintLien || nso.GameScr.isPaintNhan || nso.GameScr.isPaintNgocBoi || nso.GameScr.isPaintPhu || nso.GameScr.isPaintStack || nso.GameScr.isPaintStackLock || nso.GameScr.isPaintGrocery || nso.GameScr.isPaintGroceryLock || nso.GameScr.isPaintUpGrade || isPaintAuctionBuy || nso.GameScr.isPaintAuctionSale || nso.GameScr.isPaintConvert || nso.GameScr.isPaintSplit || nso.GameScr.isPaintTinhluyen || nso.GameScr.isPaintDichChuyen || nso.GameScr.isPaintUpPearl || nso.GameScr.isPaintLuyenThach || nso.GameScr.isPaintBox || isPaintTrade || nso.GameScr.isPaintLuyenNgoc || nso.GameScr.isPaintCheDo || nso.GameScr.isPaintKhamNgoc || nso.GameScr.isPaintGiaoDo || nso.GameScr.isPaintGotNgoc || nso.GameScr.isPaintThaoNgoc;
    }

    private static boolean isOpenUI() {
        return isPaintAuto || nso.GameScr.isPaintItemInfo || isPaintLuckySpin || isPaintInfoMe || isPaintStore || nso.GameScr.isPaintEliteShop || nso.GameScr.isPaintWeapon || nso.GameScr.isPaintNonNam || nso.GameScr.isPaintNonNu || nso.GameScr.isPaintAoNam || nso.GameScr.isPaintAoNu || nso.GameScr.isPaintGangTayNam || nso.GameScr.isPaintGangTayNu || nso.GameScr.isPaintQuanNam || nso.GameScr.isPaintQuanNu || nso.GameScr.isPaintGiayNam || nso.GameScr.isPaintGiayNu || nso.GameScr.isPaintLien || nso.GameScr.isPaintNhan || nso.GameScr.isPaintNgocBoi || nso.GameScr.isPaintPhu || nso.GameScr.isPaintStack || nso.GameScr.isPaintStackLock || nso.GameScr.isPaintGrocery || nso.GameScr.isPaintGroceryLock || nso.GameScr.isPaintUpGrade || isPaintAuctionBuy || nso.GameScr.isPaintAuctionSale || nso.GameScr.isPaintConvert || nso.GameScr.isPaintSplit || nso.GameScr.isPaintTinhluyen || nso.GameScr.isPaintDichChuyen || nso.GameScr.isPaintUpPearl || nso.GameScr.isPaintLuyenThach || nso.GameScr.isPaintBox || isPaintTrade || nso.GameScr.isPaintLuyenNgoc || nso.GameScr.isPaintCheDo || nso.GameScr.isPaintKhamNgoc || nso.GameScr.isPaintGiaoDo || nso.GameScr.isPaintGotNgoc || nso.GameScr.isPaintThaoNgoc;
    }

    private static boolean isSmallUI() {
        return isPaintRankedList || isPaintInfoMe && indexMenu == 6 && indexBijuuMenu != 0 || isPaintInfoMe && indexMenu > 0 && indexMenu < 5 || isPaintAuto || isPaintZone || isPaintClan && (indexMenu == 0 || indexMenu == 1 || indexMenu == 3 || indexMenu == 4) || isPaintCharInMap || isPaintTeam || isPaintFindTeam || isPaintFriend || isPaintList || isPaintEnemies || isPaintTask || isPaintMessage || isPaintAlert || isPaintLucky_Draw;
    }

    private static void actionBuy(Item item) {
        Command command = new Command(mResources.ACCEPT, 11055, item);
        GameCanvas.inputDlg.show(mResources.INPUT_QUANTITY, command, 1);
    }

    private static void actionSale(Item item) {
        if (item.quantity > 1) {
            Command command = new Command(mResources.ACCEPT, 110562, item);
            GameCanvas.inputDlg.show(mResources.INPUT_QUANTITY, command, 1);
        } else {
            GameCanvas.startYesNoDlg(mResources.CONFIRMSALEITEM, new Command(mResources.YES, 11061, item), new Command(mResources.NO, 1));
        }
    }

    private static void actionCoinOut() {
        Command command = new Command(mResources.ACCEPT, 11042);
        GameCanvas.inputDlg.show(mResources.INPUT_COIN, command, 1);
    }

    private static void actionCoinTrade() {
        Command command = new Command(mResources.ACCEPT, 110361);
        GameCanvas.inputDlg.show(mResources.INPUT_COIN, command, 1);
    }

    private static void actionCoinIn() {
        Command command = new Command(mResources.ACCEPT, 11043);
        GameCanvas.inputDlg.show(mResources.INPUT_COIN, command, 1);
    }

    public final void updateKeyBuyItemUI() {
        if (GameCanvas.currentDialog == null && isPaintUI()) {
            if (indexTitle == 0) {
                GameScr gameScr = this;
                super.left = gameScr.center = null;
                if (!isPaintLuckySpin) {
                    if (nso.GameScr.isPaintBox) {
                        if (nso.GameScr.svTitle.equals("")) {
                            if (indexMenu == 0) {
                                gameScr.left = new Command(mResources.MENU, 11115);
                            } else if (indexMenu == 1) {
                                gameScr.left = new Command(mResources.MENU, 11116);
                            }
                        } else {
                            gameScr.left = null;
                        }
                    } else if (indexMenu == 1 && isPaintTrade && gameScr.typeTrade == 0) {
                        gameScr.left = gameScr.cmdTradeSendMoney;
                    } else if (indexMenu == 1 && !isPaintStore && !nso.GameScr.isPaintEliteShop && !nso.GameScr.isPaintUpPearl && !nso.GameScr.isPaintLuyenThach && !nso.GameScr.isPaintUpGrade && !nso.GameScr.isPaintConvert && !nso.GameScr.isPaintSplit && !nso.GameScr.isPaintTinhluyen && !nso.GameScr.isPaintDichChuyen && !isPaintTrade && !isPaintAuctionBuy && !nso.GameScr.isPaintAuctionSale && !nso.GameScr.isPaintLuyenNgoc && !nso.GameScr.isPaintCheDo && !nso.GameScr.isPaintKhamNgoc && !nso.GameScr.isPaintGiaoDo && !nso.GameScr.isPaintGotNgoc && !nso.GameScr.isPaintThaoNgoc) {
                        gameScr.left = new Command(mResources.SORT, 110221);
                    }
                    if (nso.GameScr.isPaintLuyenThach && indexMenu == 0) {
                        int value = 0;
                        int value1 = 0;
                        int value2 = 0;
                        short shortValue = 0;
                        for (int index = 0; index < arrItemUpPeal.length; index++) {
                            Item item;
                            if ((item = arrItemUpPeal[index]) != null) {
                                if (item.template.id == 455) {
                                    value++;
                                } else if (item.template.id == 456) {
                                    value1++;
                                } else if (item.template.type == 26) {
                                    value2++;
                                    shortValue = item.template.id;
                                }
                            }
                        }
                        if (value >= 9 || value1 >= 9 || shortValue >= 10 && value >= 3 && value2 == 1 || shortValue >= 11 && value1 >= 3 && value2 == 1) {
                            gameScr.left = new Command(mResources.BEGIN, 1600);
                        }
                    } else if (nso.GameScr.isPaintTinhluyen) {
                        try {
                            if (indexMenu == 0) {
                                if (indexTitle == 1) {
                                    if (itemSplit != null) {
                                        gameScr.left = new Command(mResources.SELECT, 11103);
                                    } else {
                                        nso.GameScr.isPaintItemInfo = false;
                                    }
                                    if (GameCanvas.isTouchControlLargeScreen) {
                                        gameScr.updateItemInfo(3, itemSplit);
                                    } else {
                                        gameScr.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11104, itemSplit);
                                    }
                                } else if (indexTitle == 2) {
                                    Item item3;
                                    if ((item3 = arrItemSplit[indexSelect]) != null) {
                                        if (GameCanvas.isTouchControlLargeScreen) {
                                            gameScr.updateItemInfo(3, item3);
                                        } else {
                                            gameScr.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11104, item3);
                                        }
                                        gameScr.left = new Command(mResources.MOVEOUT, 1605);
                                    } else {
                                        nso.GameScr.isPaintItemInfo = false;
                                    }
                                    if (itemSplit != null) {
                                        gameScr.left = new Command(mResources.SELECT, 1604);
                                    }
                                }
                            } else if (indexMenu == 1) {
                                if (Char.getMyChar().arrItemBag[indexSelect] == null) {
                                    gameScr.left = null;
                                    nso.GameScr.isPaintItemInfo = false;
                                } else {
                                    gameScr.left = new Command(mResources.SELECT, 11106);
                                }
                            }
                        } catch (Exception exception) {
                        }
                    } else if (nso.GameScr.isPaintDichChuyen) {
                        if (indexMenu == 0) {
                            if (indexTitle != 1) {
                                if (indexTitle == 2) {
                                    Item item4;
                                    if ((item4 = arrItemSplit[indexSelect]) != null) {
                                        if (GameCanvas.isTouchControlLargeScreen) {
                                            gameScr.updateItemInfo(3, item4);
                                        } else {
                                            gameScr.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11104, item4);
                                        }
                                    } else {
                                        nso.GameScr.isPaintItemInfo = false;
                                    }
                                    if (itemSplit != null && itemSplit.upgrade > 13) {
                                        gameScr.left = new Command(mResources.SELECT, 1604);
                                    }
                                }
                            } else {
                                if (itemSplit != null && itemSplit.upgrade > 13) {
                                    gameScr.left = new Command(mResources.SELECT, 11103);
                                } else if (itemSplit != null) {
                                    gameScr.left = gameScr.cmdSplitMoveOut;
                                } else {
                                    nso.GameScr.isPaintItemInfo = false;
                                }
                                if (GameCanvas.isTouchControlLargeScreen) {
                                    gameScr.updateItemInfo(3, itemSplit);
                                } else {
                                    gameScr.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11104, itemSplit);
                                }
                            }
                        } else if (indexMenu == 1) {
                            if (Char.getMyChar().arrItemBag[indexSelect] == null) {
                                gameScr.left = null;
                                nso.GameScr.isPaintItemInfo = false;
                            } else {
                                gameScr.left = new Command(mResources.SELECT, 1606);
                            }
                        }
                    }
                    if (nso.GameScr.isPaintUpPearl && indexMenu == 0) {
                        int value5 = 0;
                        for (int index6 = 0; index6 < arrItemUpPeal.length; index6++) {
                            if (arrItemUpPeal[index6] != null) {
                                if (++value5 >= 2) {
                                    gameScr.left = new Command(mResources.BEGIN, 11062);
                                    break;
                                }
                            }
                        }
                    }
                    if (nso.GameScr.isPaintUpGrade && indexMenu == 0 && itemUpGrade != null) {
                        for (int index7 = 0; index7 < arrItemUpGrade.length; index7++) {
                            if (arrItemUpGrade[index7] != null) {
                                gameScr.center = new Command("", 110981);
                                gameScr.left = new Command(mResources.BEGIN, 110981);
                                break;
                            }
                        }
                    }
                    if (nso.GameScr.isPaintKhamNgoc && indexMenu == 0 && itemUpGrade != null && itemSplit != null) {
                        for (int index8 = 0; index8 < arrItemUpGrade.length; index8++) {
                            if (arrItemUpGrade[index8] != null) {
                                gameScr.center = new Command("", 341);
                                gameScr.left = new Command(mResources.BEGIN, 341);
                                break;
                            }
                        }
                    }
                    if (nso.GameScr.isPaintAuctionSale && indexMenu == 0 && itemSell != null && gameScr.tfText != null && !gameScr.tfText.getText().equals("") && Char.getMyChar().xu >= 5000) {
                        gameScr.left = new Command(mResources.SALE, 15002);
                    }
                    if (nso.GameScr.isPaintConvert && indexMenu == 0 && indexTitle == 0) {
                        for (int index9 = 0; index9 < arrItemConvert.length; index9++) {
                            if (arrItemConvert[index9] == null) {
                                gameScr.left = null;
                                break;
                            }
                            if (index9 == arrItemConvert.length - 1) {
                                gameScr.left = new Command(mResources.BEGIN, 140131);
                            }
                        }
                    }
                    if (nso.GameScr.isPaintSplit && indexMenu == 0 && itemSplit != null && itemSplit.upgrade > 0) {
                        gameScr.left = new Command(mResources.BEGIN, 11105);
                    }
                    if (isPaintTrade && indexMenu == 0) {
                        if (gameScr.typeTrade == 0) {
                            gameScr.left = gameScr.cmdTradeLock;
                        } else if (gameScr.typeTrade == 1 && gameScr.typeTradeOrder >= 1 && gameScr.timeTrade - System.currentTimeMillis() / 1000L <= 0L) {
                            gameScr.left = gameScr.cmdTradeAccept;
                        }
                    }
                    if (GameCanvas.keyPressedz[8]) {
                        indexTitle = 1;
                        indexSelect = 0;
                        indexRow = -1;
                        scrMain.clear();
                        scrInfo.clear();
                        gameScr.updateCommandForUI();
                    }
                    if (GameCanvas.keyPressedz[4]) {
                        indexSelect = 0;
                        indexRow = -1;
                        indexMenu--;
                        scrMain.clear();
                        scrInfo.clear();
                        if (isPaintAuctionBuy) {
                            if (indexMenu < 0) {
                                indexMenu = mResources.MENUSTANDS.length - 1;
                            }
                            Service.gI().menu((byte) 0, 28, 0, indexMenu);
                            arrItemStands = null;
                            indexSelect = -1;
                        } else if (nso.GameScr.isPaintEliteShop || isPaintAuto) {
                            indexMenu = 0;
                        } else if (indexMenu < 0) {
                            if (isPaintStore) {
                                indexMenu = mResources.TITLESTORE.length - 1;
                            } else {
                                indexMenu = 1;
                            }
                        }
                        gameScr.left = gameScr.center = null;
                        if (isPaintStore) {
                            getCurrentStoreData();
                        }
                        if (nso.GameScr.isPaintEliteShop && nso.GameScr.arrItemElites == null && indexMenu == 0) {
                            Service.gI().requestItem(35);
                        }
                    }
                    if (GameCanvas.keyPressedz[6]) {
                        indexSelect = 0;
                        indexRow = -1;
                        indexMenu++;
                        scrMain.clear();
                        scrInfo.clear();
                        if (isPaintAuctionBuy) {
                            if (indexMenu > mResources.MENUSTANDS.length - 1) {
                                indexMenu = 0;
                            }
                            Service.gI().menu((byte) 0, 28, 0, indexMenu);
                            arrItemStands = null;
                            indexSelect = -1;
                        } else if (nso.GameScr.isPaintEliteShop || isPaintAuto) {
                            indexMenu = 0;
                        } else if (isPaintStore) {
                            if (indexMenu > mResources.TITLESTORE.length - 1) {
                                indexMenu = 0;
                            }
                        } else if (indexMenu > 1) {
                            indexMenu = 0;
                        }
                        gameScr.left = gameScr.center = null;
                        if (isPaintStore) {
                            getCurrentStoreData();
                        }
                        if (nso.GameScr.isPaintEliteShop && nso.GameScr.arrItemElites == null && indexMenu == 0) {
                            Service.gI().requestItem(35);
                        }
                    }
                }
            } else if (indexTitle >= 1) {
                if (nso.GameScr.isPaintItemInfo) {
                    if (GameCanvas.keyPressedz[2]) {
                        if (--indexRow < 0) {
                            indexRow = indexRowMax - 1;
                        }
                        scrInfo.moveTo(indexRow * scrInfo.ITEM_SIZE);
                    } else if (GameCanvas.keyPressedz[8]) {
                        if (++indexRow >= indexRowMax) {
                            indexRow = 0;
                        }
                        scrInfo.moveTo(indexRow * scrInfo.ITEM_SIZE);
                    }
                } else {
                    if (isPaintAuto) {
                        if (GameCanvas.keyPressedz[2]) {
                            if (--indexRow < 0) {
                                indexRow = indexRowMax;
                            }
                            scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                        } else if (GameCanvas.keyPressedz[4]) {
                            if (indexRow == 0) {
                                if ((Char.aHpValue -= 10) < 10) {
                                    Char.aHpValue = 10;
                                }
                            } else if (indexRow == 1) {
                                if ((Char.aMpValue -= 10) < 10) {
                                    Char.aMpValue = 10;
                                }
                            } else if (indexRow == 2 && (Char.aFoodValue -= 10) <= 0) {
                                Char.aFoodValue = 1;
                            }
                        } else if (GameCanvas.keyPressedz[6]) {
                            if (indexRow == 0) {
                                if ((Char.aHpValue += 10) > 90) {
                                    Char.aHpValue = 90;
                                }
                            } else if (indexRow == 1) {
                                if ((Char.aMpValue += 10) > 90) {
                                    Char.aMpValue = 90;
                                }
                            } else if (indexRow == 2) {
                                if (Char.aFoodValue == 1) {
                                    Char.aFoodValue = 10;
                                } else if ((Char.aFoodValue += 10) > 70) {
                                    Char.aFoodValue = 70;
                                }
                            }
                        } else if (GameCanvas.keyPressedz[8]) {
                            if (++indexRow > indexRowMax) {
                                indexRow = 0;
                            }
                            scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
                        }
                        if (!GameCanvas.isTouch) {
                            GameCanvas.clearKeyHold();
                            GameCanvas.clearKeyPressed();
                        }
                    } else if (isPaintTrade && indexMenu == 0) {
                        boolean flag = false;
                        if (indexTitle == 1) {
                            if (GameCanvas.keyPressedz[4]) {
                                if (--indexSelect < 0) {
                                    indexSelect = 11;
                                }
                                super.left = super.center = null;
                                this.updateCommandForUI();
                            } else if (GameCanvas.keyPressedz[6]) {
                                if (indexSelect == 2) {
                                    indexTitle = 2;
                                    indexSelect = 0;
                                } else if (indexSelect == 5) {
                                    indexTitle = 2;
                                    indexSelect = 3;
                                } else if (indexSelect == 8) {
                                    indexTitle = 2;
                                    indexSelect = 6;
                                } else if (indexSelect == 11) {
                                    indexTitle = 2;
                                    indexSelect = 9;
                                } else if (indexSelect == 14) {
                                    indexTitle = 2;
                                    indexSelect = 12;
                                } else if (++indexSelect >= 12) {
                                    indexSelect = 0;
                                }
                                super.left = super.center = null;
                                this.updateCommandForUI();
                            } else if (GameCanvas.keyPressedz[8]) {
                                if (indexSelect + 3 <= 11) {
                                    indexSelect += 3;
                                }
                                super.left = super.center = null;
                                this.updateCommandForUI();
                            } else if (GameCanvas.keyPressedz[2]) {
                                if (indexSelect >= 0 && indexSelect < 3) {
                                    indexTitle = 0;
                                    indexSelect = 0;
                                } else if (indexSelect - 3 >= 0) {
                                    indexSelect -= 3;
                                }
                                super.left = super.center = null;
                                this.updateCommandForUI();
                            }
                        } else if (indexTitle == 2) {
                            if (GameCanvas.keyPressedz[4]) {
                                if (indexSelect == 0) {
                                    indexTitle = 1;
                                    indexSelect = 2;
                                } else if (indexSelect == 3) {
                                    indexTitle = 1;
                                    indexSelect = 5;
                                } else if (indexSelect == 6) {
                                    indexTitle = 1;
                                    indexSelect = 8;
                                } else if (indexSelect == 9) {
                                    indexTitle = 1;
                                    indexSelect = 11;
                                } else if (indexSelect == 12) {
                                    indexTitle = 1;
                                    indexSelect = 14;
                                } else if (--indexSelect < 0) {
                                    indexSelect = 11;
                                }
                                super.left = super.center = null;
                                this.updateCommandForUI();
                            } else if (GameCanvas.keyPressedz[6]) {
                                if (++indexSelect >= 12) {
                                    indexSelect = 0;
                                }
                                super.left = super.center = null;
                                this.updateCommandForUI();
                            } else if (GameCanvas.keyPressedz[8]) {
                                if (indexSelect + 3 <= 11) {
                                    indexSelect += 3;
                                }
                                super.left = super.center = null;
                                this.updateCommandForUI();
                            } else if (GameCanvas.keyPressedz[2]) {
                                if (indexSelect >= 0 && indexSelect < 3) {
                                    indexTitle = 0;
                                    indexSelect = 0;
                                } else if (indexSelect - 3 >= 0) {
                                    indexSelect -= 3;
                                }
                                super.left = super.center = null;
                                this.updateCommandForUI();
                            }
                        }
                        if (!GameCanvas.isTouch) {
                            GameCanvas.clearKeyHold();
                            GameCanvas.clearKeyPressed();
                        }
                    } else if (isPaintLuckySpin) {
                        if (GameCanvas.keyPressedz[4]) {
                            if (--indexSelect < 0) {
                                indexSelect = 8;
                            }
                        } else if (GameCanvas.keyPressedz[6]) {
                            if (++indexSelect > 8) {
                                indexSelect = 0;
                            }
                        } else if (GameCanvas.keyPressedz[8]) {
                            if (indexSelect + 3 < 9) {
                                indexSelect += 3;
                            }
                        } else if (GameCanvas.keyPressedz[2] && indexSelect - 3 >= 0) {
                            indexSelect -= 3;
                        }
                        if (!GameCanvas.isTouch) {
                            GameCanvas.clearKeyHold();
                            GameCanvas.clearKeyPressed();
                        }
                    } else if (nso.GameScr.isPaintAuctionSale && indexMenu == 0) {
                        if (GameCanvas.keyPressedz[2]) {
                            if (--indexTitle < 0) {
                                indexTitle = 0;
                            }
                        } else if (GameCanvas.keyPressedz[8] && ++indexTitle > 2) {
                            indexTitle = 2;
                        }
                        this.updateCommandForUI();
                    } else if (isPaintAuctionBuy) {
                        if (GameCanvas.keyPressedz[4]) {
                            if (arrItemStands != null) {
                                if ((indexSelect -= 5) < 0) {
                                    indexSelect = arrItemStands.length - 1;
                                }
                                scrMain.moveTo(indexSelect * scrMain.ITEM_SIZE);
                                this.updateCommandForUI();
                            }
                        } else if (GameCanvas.keyPressedz[6]) {
                            if (arrItemStands != null) {
                                if ((indexSelect += 5) >= arrItemStands.length) {
                                    indexSelect = 0;
                                }
                                scrMain.moveTo(indexSelect * scrMain.ITEM_SIZE);
                                this.updateCommandForUI();
                            }
                        } else if (GameCanvas.keyPressedz[8]) {
                            if (arrItemStands != null) {
                                if (++indexSelect >= arrItemStands.length) {
                                    indexSelect = 0;
                                }
                                scrMain.moveTo(indexSelect * scrMain.ITEM_SIZE);
                                this.updateCommandForUI();
                            }
                        } else if (GameCanvas.keyPressedz[2] && arrItemStands != null) {
                            if (--indexSelect < 0) {
                                indexTitle = 0;
                            }
                            scrMain.moveTo(indexSelect * scrMain.ITEM_SIZE);
                            this.updateCommandForUI();
                        }
                        GameCanvas.clearKeyHold();
                        GameCanvas.clearKeyPressed();
                    } else if ((nso.GameScr.isPaintGiaoDo || nso.GameScr.isPaintKhamNgoc || nso.GameScr.isPaintUpGrade || nso.GameScr.isPaintConvert) && indexTitle == 1 && indexMenu == 0) {
                        if (GameCanvas.keyPressedz[4]) {
                            if (--indexSelect < 0) {
                                indexSelect = 1;
                            }
                            super.left = super.center = null;
                            this.updateCommandForUI();
                        } else if (GameCanvas.keyPressedz[6]) {
                            if (++indexSelect > 1) {
                                indexSelect = 0;
                            }
                            super.left = super.center = null;
                            this.updateCommandForUI();
                        } else if (GameCanvas.keyPressedz[8]) {
                            indexTitle = 2;
                            indexSelect = 0;
                            super.left = super.center = null;
                            this.updateCommandForUI();
                        } else if (GameCanvas.keyPressedz[2]) {
                            indexTitle = 0;
                            indexSelect = 0;
                            super.left = super.center = null;
                            this.updateCommandForUI();
                        }
                        if (!GameCanvas.isTouch) {
                            GameCanvas.clearKeyHold();
                            GameCanvas.clearKeyPressed();
                        }
                    } else if ((nso.GameScr.isPaintSplit || nso.GameScr.isPaintTinhluyen || nso.GameScr.isPaintDichChuyen || nso.GameScr.isPaintLuyenNgoc || nso.GameScr.isPaintCheDo) && indexTitle == 1 && indexMenu == 0) {
                        if (GameCanvas.keyPressedz[8]) {
                            indexTitle = 2;
                            indexSelect = 0;
                            super.left = super.center = null;
                            this.updateCommandForUI();
                        } else if (GameCanvas.keyPressedz[2]) {
                            indexTitle = 0;
                            indexSelect = 0;
                            super.left = super.center = null;
                            this.updateCommandForUI();
                        }
                        GameCanvas.clearKeyHold();
                        GameCanvas.clearKeyPressed();
                    } else if ((nso.GameScr.isPaintGotNgoc || nso.GameScr.isPaintThaoNgoc) && indexMenu == 0) {
                        if (GameCanvas.keyPressedz[2]) {
                            if (--indexTitle < 0) {
                                indexTitle = 0;
                            }
                        } else if (GameCanvas.keyPressedz[8] && ++indexTitle > 1) {
                            indexTitle = 1;
                        }
                        this.updateCommandForUI();
                    }
                    int value10 = getMaxIndexForCurrentStore();
                    if (GameCanvas.keyPressedz[4]) {
                        if (--indexSelect < 0) {
                            indexSelect = value10 - 1;
                        }
                        super.left = super.center = null;
                        this.updateCommandForUI();
                        scrMain.moveTo(indexSelect / columns * scrMain.ITEM_SIZE);
                    } else if (GameCanvas.keyPressedz[6]) {
                        if (++indexSelect >= value10) {
                            indexSelect = 0;
                        }
                        super.left = super.center = null;
                        this.updateCommandForUI();
                        scrMain.moveTo(indexSelect / columns * scrMain.ITEM_SIZE);
                    } else if (GameCanvas.keyPressedz[8]) {
                        if (indexSelect + columns <= value10 - 1) {
                            indexSelect = indexSelect + columns;
                        }
                        super.left = super.center = null;
                        this.updateCommandForUI();
                        scrMain.moveTo(indexSelect / columns * scrMain.ITEM_SIZE);
                    } else if (GameCanvas.keyPressedz[2]) {
                        if (indexSelect >= 0 && indexSelect < columns) {
                            indexTitle = 0;
                            indexSelect = 0;
                            if ((nso.GameScr.isPaintKhamNgoc || nso.GameScr.isPaintUpGrade || nso.GameScr.isPaintSplit || nso.GameScr.isPaintTinhluyen || nso.GameScr.isPaintDichChuyen || nso.GameScr.isPaintConvert || nso.GameScr.isPaintLuyenNgoc || nso.GameScr.isPaintCheDo) && indexMenu == 0) {
                                indexTitle = 1;
                            }
                        } else if (indexSelect - columns >= 0) {
                            indexSelect = indexSelect - columns;
                        }
                        super.left = super.center = null;
                        this.updateCommandForUI();
                        scrMain.moveTo(indexSelect / columns * scrMain.ITEM_SIZE);
                    }
                }
            }
            if (GameCanvas.isTouch) {
                GameScr gameScr11 = this;
                label1185: if (!GameCanvas.menu.showMenu && GameCanvas.currentDialog == null) {
                    if (GameCanvas.isPointerJustRelease && GameCanvas.isPointerHoldIn(popupX, popupY, popupW, gameScr11.Hitem) && (!nso.GameScr.isPaintItemInfo || GameCanvas.w >= 320) && GameCanvas.isPointerClick) {
                        if (GameCanvas.isPointerHoldIn(nso.GameScr.gW2 - 80, popupY + 5, 60, 40)) {
                            indexSelect = 0;
                            indexMenu--;
                            gameScr11.updateCommandForUI();
                        }
                        if (GameCanvas.isPointerHoldIn(nso.GameScr.gW2 + 10, popupY + 5, 60, 40)) {
                            indexSelect = 0;
                            indexMenu++;
                            gameScr11.updateCommandForUI();
                        }
                        indexTitle = 0;
                        if (!isPaintUI()) {
                            if (indexMenu < 0) {
                                indexMenu = mResources.MENUME.length - 1;
                            }
                            if (indexMenu > mResources.MENUME.length - 1) {
                                indexMenu = 0;
                            }
                        } else {
                            if (isPaintStore) {
                                if (indexMenu < 0) {
                                    indexMenu = mResources.TITLESTORE.length - 1;
                                } else if (indexMenu > mResources.TITLESTORE.length - 1) {
                                    indexMenu = 0;
                                }
                                getCurrentStoreData();
                            } else if (isPaintAuctionBuy) {
                                if (indexMenu < 0) {
                                    indexMenu = mResources.MENUSTANDS.length - 1;
                                } else if (indexMenu > mResources.MENUSTANDS.length - 1) {
                                    indexMenu = 0;
                                }
                                Service.gI().menu((byte) 0, 28, 0, indexMenu);
                                indexSelect = -1;
                            } else if (nso.GameScr.isPaintEliteShop || isPaintAuto) {
                                indexMenu = 0;
                            } else if (indexMenu < 0) {
                                indexMenu = 1;
                            } else if (indexMenu > 1) {
                                indexMenu = 0;
                            }
                            if (nso.GameScr.isPaintEliteShop) {
                                indexMenu = 0;
                            }
                        }
                        nso.GameScr.isPaintItemInfo = false;
                        scrMain.clear();
                    }
                    if (nso.GameScr.isPaintItemInfo) {
                        ScrollResult scrollResult;
                        if ((scrollResult = scrInfo.updateKey()).isDowning || scrollResult.isFinish) {
                            indexRow = scrollResult.selected;
                            indexTitle = 1;
                        }
                        if (!GameCanvas.isTouchControlLargeScreen) {
                            break label1185;
                        }
                    }
                    if (isPaintAuto) {
                        ScrollResult scrollResult12;
                        if (((scrollResult12 = scrMain.updateKey()).isFinish || scrollResult12.isDowning) && indexSelect != scrollResult12.selected) {
                            indexTitle = 1;
                            indexRow = scrollResult12.selected;
                            gameScr11.updateCommandForUI();
                        }
                        if (GameCanvas.isPointerInRoll(scrMain.xPos + 16, scrMain.yPos + 5, 16, 16, scrMain) && GameCanvas.isPointerClick) {
                            Char.isAHP = !Char.isAHP;
                            if (nso.GameScr.typeActive == 1) {
                                Char.isAHP = false;
                                InfoMe.addInfo(mResources.AOPENACC, 20, mFont.tahoma_7_yellow);
                            }
                            GameCanvas.isPointerDown = false;
                        }
                        if (GameCanvas.isPointerInRoll(scrMain.xPos + 16, scrMain.yPos + 35, 16, 16, scrMain) && GameCanvas.isPointerClick) {
                            Char.isAMP = !Char.isAMP;
                            if (nso.GameScr.typeActive == 1) {
                                Char.isAMP = false;
                                InfoMe.addInfo(mResources.AOPENACC, 20, mFont.tahoma_7_yellow);
                            }
                            GameCanvas.isPointerDown = false;
                        }
                        if (GameCanvas.isPointerInRoll(scrMain.xPos + 16, scrMain.yPos + 65, 16, 16, scrMain) && GameCanvas.isPointerClick) {
                            Char.isAFood = !Char.isAFood;
                            if (nso.GameScr.typeActive == 1) {
                                Char.isAFood = false;
                                InfoMe.addInfo(mResources.AOPENACC, 20, mFont.tahoma_7_yellow);
                            }
                            GameCanvas.isPointerDown = false;
                        }
                        if (GameCanvas.isPointerInRoll(scrMain.xPos + 16, scrMain.yPos + 95, 16, 16, scrMain) && GameCanvas.isPointerClick) {
                            Char.isABuff = !Char.isABuff;
                            GameCanvas.isPointerDown = false;
                        }
                        if (GameCanvas.isPointerInRoll(scrMain.xPos + 16, scrMain.yPos + 125, 16, 16, scrMain) && GameCanvas.isPointerClick) {
                            Char.isAPickYen = !Char.isAPickYen;
                            GameCanvas.isPointerDown = false;
                            if (Char.isAPickYen) {
                                Char.isANoPick = false;
                                Char.isAPickYHMS = false;
                                Char.isAPickYHM = false;
                            }
                        }
                        if (GameCanvas.isPointerInRoll(scrMain.xPos + 16, scrMain.yPos + 155, 16, 16, scrMain) && GameCanvas.isPointerClick) {
                            Char.isAPickYHM = !Char.isAPickYHM;
                            GameCanvas.isPointerDown = false;
                            if (Char.isAPickYHM) {
                                Char.isANoPick = false;
                                Char.isAPickYHMS = false;
                                Char.isAPickYen = false;
                            }
                        }
                        if (GameCanvas.isPointerInRoll(scrMain.xPos + 16, scrMain.yPos + 185, 16, 16, scrMain) && GameCanvas.isPointerClick) {
                            Char.isAPickYHMS = !Char.isAPickYHMS;
                            GameCanvas.isPointerDown = false;
                            if (Char.isAPickYHMS) {
                                Char.isANoPick = false;
                                Char.isAPickYHM = false;
                                Char.isAPickYen = false;
                            }
                        }
                        if (GameCanvas.isPointerInRoll(scrMain.xPos + 16, scrMain.yPos + 215, 16, 16, scrMain) && GameCanvas.isPointerClick) {
                            Char.isANoPick = !Char.isANoPick;
                            GameCanvas.isPointerDown = false;
                            if (Char.isANoPick) {
                                Char.isAPickYHMS = false;
                                Char.isAPickYHM = false;
                                Char.isAPickYen = false;
                            }
                        }
                        if (GameCanvas.isPointerInRoll(scrMain.xPos + 131, scrMain.yPos + 2, 30, 20, scrMain) && GameCanvas.isPointerClick && Char.isAHP) {
                            GameCanvas.inputDlg.show(mResources.AHP_TEXT, new Command(mResources.OK, 1511), 1);
                            GameCanvas.isPointerDown = false;
                        }
                        if (GameCanvas.isPointerInRoll(scrMain.xPos + 131, scrMain.yPos + 32, 30, 20, scrMain) && GameCanvas.isPointerClick && Char.isAMP) {
                            GameCanvas.inputDlg.show(mResources.AHP_TEXT, new Command(mResources.OK, 1512), 1);
                            GameCanvas.isPointerDown = false;
                        }
                        if (GameCanvas.isPointerInRoll(scrMain.xPos + 131, scrMain.yPos + 62, 30, 20, scrMain) && GameCanvas.isPointerClick && Char.isAFood) {
                            MyVector entries;
                            (entries = new MyVector()).addElement(new Command(mResources.ALEVEL[0], 15130));
                            entries.addElement(new Command(mResources.ALEVEL[1], 15131));
                            entries.addElement(new Command(mResources.ALEVEL[2], 15132));
                            entries.addElement(new Command(mResources.ALEVEL[3], 15133));
                            entries.addElement(new Command(mResources.ALEVEL[4], 15134));
                            entries.addElement(new Command(mResources.ALEVEL[5], 15135));
                            entries.addElement(new Command(mResources.ALEVEL[6], 15136));
                            entries.addElement(new Command(mResources.ALEVEL[7], 15137));
                            GameCanvas.menu.startAt(entries);
                            GameCanvas.menu.disableClose = true;
                        }
                    } else if (nso.GameScr.isPaintEliteShop || isPaintStore || nso.GameScr.isPaintBox || nso.GameScr.isPaintGrocery || nso.GameScr.isPaintGroceryLock || nso.GameScr.isPaintStack || nso.GameScr.isPaintStackLock || nso.GameScr.isPaintNonNam || nso.GameScr.isPaintNonNu || nso.GameScr.isPaintAoNam || nso.GameScr.isPaintAoNu || nso.GameScr.isPaintGangTayNam || nso.GameScr.isPaintGangTayNu || nso.GameScr.isPaintQuanNam || nso.GameScr.isPaintQuanNu || nso.GameScr.isPaintGiayNam || nso.GameScr.isPaintGiayNu || nso.GameScr.isPaintWeapon || nso.GameScr.isPaintLien || nso.GameScr.isPaintNhan || nso.GameScr.isPaintNgocBoi || nso.GameScr.isPaintPhu) {
                        ScrollResult scrollResult13;
                        if (((scrollResult13 = scrMain.updateKey()).isFinish || scrollResult13.isDowning) && indexSelect != scrollResult13.selected) {
                            indexTitle = 1;
                            indexSelect = scrollResult13.selected;
                            gameScr11.left = gameScr11.center = null;
                            nso.GameScr.isPaintItemInfo = false;
                            gameScr11.updateCommandForUI();
                        }
                    } else if (isPaintTrade) {
                        if (indexMenu == 0) {
                            gameScr11.indexPointer(popupX + 4, popupY + gameScr11.Hitem + 15, 3, 4, 1);
                            gameScr11.indexPointer(popupX + popupW - 3 - 3 * indexSize, popupY + gameScr11.Hitem + 15, 3, 4, 2);
                        } else {
                            ScrollResult scrollResult14;
                            if (indexMenu == 1 && ((scrollResult14 = scrMain.updateKey()).isFinish || scrollResult14.isDowning) && indexSelect != scrollResult14.selected) {
                                indexTitle = 1;
                                indexSelect = scrollResult14.selected;
                                gameScr11.updateCommandForUI();
                            }
                        }
                    } else if (!nso.GameScr.isPaintUpPearl && !nso.GameScr.isPaintLuyenThach) {
                        if (!nso.GameScr.isPaintSplit && !nso.GameScr.isPaintTinhluyen && !nso.GameScr.isPaintDichChuyen && !nso.GameScr.isPaintLuyenNgoc) {
                            if (!nso.GameScr.isPaintUpGrade && !nso.GameScr.isPaintConvert && !nso.GameScr.isPaintKhamNgoc) {
                                if (nso.GameScr.isPaintGiaoDo) {
                                    if (indexMenu == 0) {
                                        ScrollResult scrollResult15;
                                        if (((scrollResult15 = scrMain.updateKey()).isFinish || scrollResult15.isDowning) && indexSelect != scrollResult15.selected) {
                                            indexTitle = 1;
                                            indexSelect = scrollResult15.selected;
                                            gameScr11.left = gameScr11.center = null;
                                            nso.GameScr.isPaintItemInfo = false;
                                            gameScr11.updateCommandForUI();
                                        }
                                    } else {
                                        ScrollResult scrollResult16;
                                        if (indexMenu == 1 && ((scrollResult16 = scrMain.updateKey()).isFinish || scrollResult16.isDowning) && indexSelect != scrollResult16.selected) {
                                            indexTitle = 1;
                                            indexSelect = scrollResult16.selected;
                                            gameScr11.updateCommandForUI();
                                        }
                                    }
                                } else if (nso.GameScr.isPaintAuctionSale) {
                                    if (indexMenu == 0) {
                                        if (GameCanvas.isPointerHoldIn(popupX + 75, popupY + 69, indexSize, indexSize)) {
                                            if (GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                                                indexTitle = 1;
                                                gameScr11.updateCommandForUI();
                                            }
                                        } else if (GameCanvas.isPointerHoldIn(gameScr11.tfText.x, gameScr11.tfText.y, gameScr11.tfText.width, gameScr11.tfText.height) && GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                                            indexTitle = 2;
                                            gameScr11.tfText.showNativeTextBox();
                                            gameScr11.updateCommandForUI();
                                        }
                                    } else {
                                        ScrollResult scrollResult17;
                                        if (indexMenu == 1 && ((scrollResult17 = scrMain.updateKey()).isFinish || scrollResult17.isDowning) && indexSelect != scrollResult17.selected) {
                                            indexTitle = 1;
                                            indexSelect = scrollResult17.selected;
                                            gameScr11.updateCommandForUI();
                                        }
                                    }
                                } else if (isPaintLuckySpin) {
                                    if (GameCanvas.isPointerHoldIn(nso.GameScr.xstart, nso.GameScr.ystart, 120, 120) && GameCanvas.isPointerJustRelease && GameCanvas.isPointerClick) {
                                        indexSelect = (GameCanvas.pxLast - nso.GameScr.xstart) / 40 + (GameCanvas.pyLast - nso.GameScr.ystart) / 40 * 3;
                                        indexTitle = 1;
                                        gameScr11.updateCommandForUI();
                                        gameScr11.doviewCardsInfo();
                                    }
                                } else if (!nso.GameScr.isPaintGotNgoc && !nso.GameScr.isPaintThaoNgoc) {
                                    if (nso.GameScr.isPaintCheDo) {
                                        ScrollResult scrollResult18;
                                        if (indexMenu == 1 && ((scrollResult18 = scrMain.updateKey()).isFinish || scrollResult18.isDowning) && indexSelect != scrollResult18.selected) {
                                            indexTitle = 1;
                                            indexSelect = scrollResult18.selected;
                                            gameScr11.updateCommandForUI();
                                        }
                                        if (indexMenu == 0) {
                                            for (int index19 = 0; index19 < gameScr11.craftSlotX.length; index19++) {
                                                if (GameCanvas.isPointerHoldIn(gameScr11.craftSlotX[index19], gameScr11.craftSlotY[index19], indexSize, indexSize) && GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                                                    gameScr11.selectedCraftSlot = index19;
                                                }
                                            }
                                        }
                                    }
                                } else if (indexMenu == 0) {
                                    if (GameCanvas.isPointerHoldIn(popupX + 75, popupY + 69, indexSize, indexSize) && GameCanvas.isPointerClick && GameCanvas.isPointerJustRelease) {
                                        indexTitle = 1;
                                        gameScr11.updateCommandForUI();
                                    }
                                } else {
                                    ScrollResult scrollResult20;
                                    if (indexMenu == 1 && ((scrollResult20 = scrMain.updateKey()).isFinish || scrollResult20.isDowning) && indexSelect != scrollResult20.selected) {
                                        indexTitle = 1;
                                        indexSelect = scrollResult20.selected;
                                        gameScr11.updateCommandForUI();
                                    }
                                }
                            } else if (indexMenu == 0) {
                                GameScr gameScr21 = gameScr11;
                                int value22 = popupX + 45;
                                int value23 = popupY + 32;
                                int value24 = popupX + 100;
                                if (GameCanvas.isPointerJustRelease) {
                                    if (GameCanvas.isPointerHoldIn(value22, value23, 29, 29)) {
                                        indexTitle = 1;
                                        indexSelect = 0;
                                        gameScr21.updateCommandForUI();
                                    }
                                    if (GameCanvas.isPointerHoldIn(value24, value23, 29, 29)) {
                                        indexTitle = 1;
                                        indexSelect = 1;
                                        gameScr21.updateCommandForUI();
                                        if (nso.GameScr.isPaintUpPearl && indexMenu == 0) {
                                            for (int index25 = 0; index25 < arrItemUpPeal.length; index25++) {
                                                if (arrItemUpPeal[index25] != null) {
                                                    gameScr21.center = new Command(mResources.ACCEPT, 11062);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    if (GameCanvas.isPointerHoldIn(popupX, popupY + 2 * gameScr21.Hitem + 5, popupW, popupH - gameScr21.Hitem * 3)) {
                                        gameScr21.indexPointer(popupX, popupY + 2 * gameScr21.Hitem + 5, 6, 3, 2);
                                    }
                                }
                            } else {
                                ScrollResult scrollResult26;
                                if (indexMenu == 1 && ((scrollResult26 = scrMain.updateKey()).isFinish || scrollResult26.isDowning) && indexSelect != scrollResult26.selected) {
                                    indexTitle = 1;
                                    indexSelect = scrollResult26.selected;
                                    gameScr11.updateCommandForUI();
                                }
                            }
                        } else if (indexMenu == 0) {
                            if (GameCanvas.isPointerHoldIn(popupX + 74, nso.GameScr.ystart - indexSize - 3, indexSize, indexSize)) {
                                indexTitle = 1;
                                indexSelect = 0;
                                gameScr11.updateCommandForUI();
                            }
                            gameScr11.indexPointer(popupX + 4, popupY + 2 * gameScr11.Hitem + 5, 6, 4, 2);
                        } else {
                            ScrollResult scrollResult27;
                            if (indexMenu == 1 && ((scrollResult27 = scrMain.updateKey()).isFinish || scrollResult27.isDowning) && indexSelect != scrollResult27.selected) {
                                indexTitle = 1;
                                indexSelect = scrollResult27.selected;
                                gameScr11.updateCommandForUI();
                            }
                        }
                    } else if (indexMenu == 0) {
                        gameScr11.indexPointer(popupX + 4, popupY + gameScr11.Hitem + 3, 6, 4, 1);
                    } else {
                        ScrollResult scrollResult28;
                        if (indexMenu == 1 && ((scrollResult28 = scrMain.updateKey()).isFinish || scrollResult28.isDowning) && indexSelect != scrollResult28.selected) {
                            indexTitle = 1;
                            indexSelect = scrollResult28.selected;
                            gameScr11.updateCommandForUI();
                        }
                    }
                }
            }
            GameCanvas.clearKeyHold();
            GameCanvas.clearKeyPressed();
        }
    }

    private static int getMaxIndexForCurrentStore() {
        int value = 0;
        try {
            if (nso.GameScr.isPaintEliteShop) {
                if (nso.GameScr.arrItemElites.length % columns == 0) {
                    value = nso.GameScr.arrItemElites.length;
                } else {
                    value = (nso.GameScr.arrItemElites.length / columns + 1) * columns;
                }
            } else if (isPaintStore) {
                if (indexMenu == 0) {
                    if (nso.GameScr.arrItemStore.length % columns == 0) {
                        value = nso.GameScr.arrItemStore.length;
                    } else {
                        value = (nso.GameScr.arrItemStore.length / columns + 1) * columns;
                    }
                } else if (indexMenu == 1) {
                    if (nso.GameScr.arrItemBook.length % columns == 0) {
                        value = nso.GameScr.arrItemBook.length;
                    } else {
                        value = (nso.GameScr.arrItemBook.length / columns + 1) * columns;
                    }
                } else if (indexMenu == 2) {
                    if (nso.GameScr.arrItemFashion.length % columns == 0) {
                        value = nso.GameScr.arrItemFashion.length;
                    } else {
                        value = (nso.GameScr.arrItemFashion.length / columns + 1) * columns;
                    }
                } else if (indexMenu == 52) {
                    if (nso.GameScr.arrItemFashion.length % columns == 0) {
                        value = nso.GameScr.arrItemFashion.length;
                    } else {
                        value = (nso.GameScr.arrItemFashion.length / columns + 1) * columns;
                    }
                }
            } else if (nso.GameScr.isPaintNonNam) {
                if (nso.GameScr.arrItemNonNam.length % columns == 0) {
                    value = nso.GameScr.arrItemNonNam.length;
                } else {
                    value = (nso.GameScr.arrItemNonNam.length / columns + 1) * columns;
                }
            } else if (nso.GameScr.isPaintNonNu) {
                if (nso.GameScr.arrItemNonNu.length % columns == 0) {
                    value = nso.GameScr.arrItemNonNu.length;
                } else {
                    value = (nso.GameScr.arrItemNonNu.length / columns + 1) * columns;
                }
            } else if (nso.GameScr.isPaintAoNam) {
                if (nso.GameScr.arrItemAoNam.length % columns == 0) {
                    value = nso.GameScr.arrItemAoNam.length;
                } else {
                    value = (nso.GameScr.arrItemAoNam.length / columns + 1) * columns;
                }
            } else if (nso.GameScr.isPaintAoNu) {
                if (nso.GameScr.arrItemAoNu.length % columns == 0) {
                    value = nso.GameScr.arrItemAoNu.length;
                } else {
                    value = (nso.GameScr.arrItemAoNu.length / columns + 1) * columns;
                }
            } else if (nso.GameScr.isPaintGangTayNam) {
                if (nso.GameScr.arrItemGangTayNam.length % columns == 0) {
                    value = nso.GameScr.arrItemGangTayNam.length;
                } else {
                    value = (nso.GameScr.arrItemGangTayNam.length / columns + 1) * columns;
                }
            } else if (nso.GameScr.isPaintGangTayNu) {
                if (nso.GameScr.arrItemGangTayNu.length % columns == 0) {
                    value = nso.GameScr.arrItemGangTayNu.length;
                } else {
                    value = (nso.GameScr.arrItemGangTayNu.length / columns + 1) * columns;
                }
            } else if (nso.GameScr.isPaintQuanNam) {
                if (nso.GameScr.arrItemQuanNam.length % columns == 0) {
                    value = nso.GameScr.arrItemQuanNam.length;
                } else {
                    value = (nso.GameScr.arrItemQuanNam.length / columns + 1) * columns;
                }
            } else if (nso.GameScr.isPaintQuanNu) {
                if (nso.GameScr.arrItemQuanNu.length % columns == 0) {
                    value = nso.GameScr.arrItemQuanNu.length;
                } else {
                    value = (nso.GameScr.arrItemQuanNu.length / columns + 1) * columns;
                }
            } else if (nso.GameScr.isPaintGiayNam) {
                if (nso.GameScr.arrItemGiayNam.length % columns == 0) {
                    value = nso.GameScr.arrItemGiayNam.length;
                } else {
                    value = (nso.GameScr.arrItemGiayNam.length / columns + 1) * columns;
                }
            } else if (nso.GameScr.isPaintGiayNu) {
                if (nso.GameScr.arrItemGiayNu.length % columns == 0) {
                    value = nso.GameScr.arrItemGiayNu.length;
                } else {
                    value = (nso.GameScr.arrItemGiayNu.length / columns + 1) * columns;
                }
            } else if (nso.GameScr.isPaintLien) {
                if (nso.GameScr.arrItemLien.length % columns == 0) {
                    value = nso.GameScr.arrItemLien.length;
                } else {
                    value = (nso.GameScr.arrItemLien.length / columns + 1) * columns;
                }
            } else if (nso.GameScr.isPaintNhan) {
                if (nso.GameScr.arrItemNhan.length % columns == 0) {
                    value = nso.GameScr.arrItemNhan.length;
                } else {
                    value = (nso.GameScr.arrItemNhan.length / columns + 1) * columns;
                }
            } else if (nso.GameScr.isPaintNgocBoi) {
                if (nso.GameScr.arrItemNgocBoi.length % columns == 0) {
                    value = nso.GameScr.arrItemNgocBoi.length;
                } else {
                    value = (nso.GameScr.arrItemNgocBoi.length / columns + 1) * columns;
                }
            } else if (nso.GameScr.isPaintPhu) {
                if (nso.GameScr.arrItemPhu.length % columns == 0) {
                    value = nso.GameScr.arrItemPhu.length;
                } else {
                    value = (nso.GameScr.arrItemPhu.length / columns + 1) * columns;
                }
            } else if (nso.GameScr.isPaintWeapon) {
                if (nso.GameScr.arrItemWeapon.length % columns == 0) {
                    value = nso.GameScr.arrItemWeapon.length;
                } else {
                    value = (nso.GameScr.arrItemWeapon.length / columns + 1) * columns;
                }
            } else if (nso.GameScr.isPaintStack) {
                if (nso.GameScr.arrItemStack.length % columns == 0) {
                    value = nso.GameScr.arrItemStack.length;
                } else {
                    value = (nso.GameScr.arrItemStack.length / columns + 1) * columns;
                }
            } else if (nso.GameScr.isPaintStackLock) {
                if (nso.GameScr.arrItemStackLock.length % columns == 0) {
                    value = nso.GameScr.arrItemStackLock.length;
                } else {
                    value = (nso.GameScr.arrItemStackLock.length / columns + 1) * columns;
                }
            } else if (nso.GameScr.isPaintGrocery) {
                if (nso.GameScr.arrItemGrocery.length % columns == 0) {
                    value = nso.GameScr.arrItemGrocery.length;
                } else {
                    value = (nso.GameScr.arrItemGrocery.length / columns + 1) * columns;
                }
            } else if (nso.GameScr.isPaintGroceryLock) {
                if (nso.GameScr.arrItemGroceryLock.length % columns == 0) {
                    value = nso.GameScr.arrItemGroceryLock.length;
                } else {
                    value = (nso.GameScr.arrItemGroceryLock.length / columns + 1) * columns;
                }
            }
            if (nso.GameScr.isPaintBox) {
                value = Char.getMyChar().arrItemBox.length;
            }
            if (indexMenu == 1 && !isPaintStore) {
                value = Char.getMyChar().arrItemBag.length;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        if ((nso.GameScr.isPaintUpPearl || nso.GameScr.isPaintLuyenThach || nso.GameScr.isPaintSplit || nso.GameScr.isPaintTinhluyen || nso.GameScr.isPaintDichChuyen || nso.GameScr.isPaintLuyenNgoc || nso.GameScr.isPaintCheDo) && indexMenu == 0) {
            value = 24;
        } else if ((nso.GameScr.isPaintKhamNgoc || nso.GameScr.isPaintUpGrade || nso.GameScr.isPaintConvert) && indexMenu == 0) {
            value = 18;
        } else if (value < 30) {
            value = 30;
        }
        return value;
    }

    private static void getCurrentStoreData() {
        if (indexMenu == 0) {
            Service.gI().requestItem(14);
        } else if (indexMenu == 1) {
            Service.gI().requestItem(15);
        } else if (indexMenu == 2) {
            Service.gI().requestItem(32);
        } else if (indexMenu == 3) {
            Service.gI().requestItem(34);
        } else {
            if (indexMenu == 52) {
                Service.gI().requestItem(32);
            }
        }
    }

    private void saleItem() {
        if (Char.getMyChar().arrItemBag[indexSelect].quantity > 1) {
            super.left = new Command(mResources.SALE, 11072);
        } else {
            super.left = new Command(mResources.SALE, 11073);
        }
    }

    public final void updateCommandForUI() {
        super.left = super.center = null;
        if (indexSelect >= 0) {
            if (isPaintAuto) {
                if (indexTitle == 1 && !GameCanvas.isTouch) {
                    super.left = new Command(mResources.SELECT, 1510);
                }
            } else if (isPaintLuckySpin) {
                if (indexTitle == 1) {
                    super.left = new Command(mResources.SELECT, 1506);
                    super.center = new Command("", 1507);
                }
            } else if (nso.GameScr.isPaintEliteShop) {
                if (indexMenu == 0 && getItemFocus(35) != null) {
                    super.left = this.cmdEliteShopBuy;
                    if (!GameCanvas.isTouchControlLargeScreen) {
                        super.center = this.cmdEliteShopView;
                        return;
                    }
                    this.actView((byte) 35);
                }
            } else if (isPaintStore) {
                if (indexMenu == 52) {
                    if (getItemFocus(32) != null) {
                        super.left = this.cmdStoreFashionBuy;
                        if (!GameCanvas.isTouchControlLargeScreen) {
                            super.center = this.cmdStoreFashionView;
                            return;
                        }
                        this.actView((byte) 32);
                        return;
                    }
                } else if (indexMenu == 0) {
                    if (getItemFocus(14) != null) {
                        super.left = this.cmdStoreBuy;
                        if (!GameCanvas.isTouchControlLargeScreen) {
                            super.center = this.cmdStoreView;
                            return;
                        }
                        this.actView((byte) 14);
                        return;
                    }
                } else if (indexMenu == 1) {
                    if (getItemFocus(15) != null) {
                        super.left = this.cmdStoreLockBuy;
                        if (!GameCanvas.isTouchControlLargeScreen) {
                            super.center = this.cmdStoreLockView;
                            return;
                        }
                        this.actView((byte) 15);
                        return;
                    }
                } else if (indexMenu == 2) {
                    if (getItemFocus(32) != null) {
                        super.left = this.cmdStoreFashionBuy;
                        if (!GameCanvas.isTouchControlLargeScreen) {
                            super.center = this.cmdStoreFashionView;
                            return;
                        }
                        this.actView((byte) 32);
                        return;
                    }
                } else if (indexMenu == 3 && getItemFocus(34) != null) {
                    super.left = this.cmdClanStoreBuy;
                    if (!GameCanvas.isTouchControlLargeScreen) {
                        super.center = this.cmdClanStoreView;
                        return;
                    }
                    this.actView((byte) 34);
                }
            } else {
                if (nso.GameScr.isPaintNonNam) {
                    if (indexMenu == 0) {
                        if (getItemFocus(20) != null) {
                            super.left = this.cmdNonNamBuy;
                            if (!GameCanvas.isTouchControlLargeScreen) {
                                super.center = this.cmdNonNamView;
                            } else {
                                this.actView((byte) 20);
                            }
                        }
                    } else if (indexMenu == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                        this.saleItem();
                    }
                } else if (nso.GameScr.isPaintNonNu) {
                    if (indexMenu == 0) {
                        if (getItemFocus(21) != null) {
                            super.left = this.cmdNonNuBuy;
                            if (!GameCanvas.isTouchControlLargeScreen) {
                                super.center = this.cmdNonNuView;
                            } else {
                                this.actView((byte) 21);
                            }
                        }
                    } else if (indexMenu == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                        this.saleItem();
                    }
                } else if (nso.GameScr.isPaintAoNam) {
                    if (indexMenu == 0) {
                        if (getItemFocus(22) != null) {
                            super.left = this.cmdAoNamBuy;
                            if (!GameCanvas.isTouchControlLargeScreen) {
                                super.center = this.cmdAoNamView;
                            } else {
                                this.actView((byte) 22);
                            }
                        }
                    } else if (indexMenu == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                        this.saleItem();
                    }
                } else if (nso.GameScr.isPaintAoNu) {
                    if (indexMenu == 0) {
                        if (getItemFocus(23) != null) {
                            super.left = this.cmdAoNuBuy;
                            if (!GameCanvas.isTouchControlLargeScreen) {
                                super.center = this.cmdAoNuView;
                            } else {
                                this.actView((byte) 23);
                            }
                        }
                    } else if (indexMenu == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                        this.saleItem();
                    }
                } else if (nso.GameScr.isPaintGangTayNam) {
                    if (indexMenu == 0) {
                        if (getItemFocus(24) != null) {
                            super.left = this.cmdGangTayNamBuy;
                            if (!GameCanvas.isTouchControlLargeScreen) {
                                super.center = this.cmdGangTayNamView;
                            } else {
                                this.actView((byte) 24);
                            }
                        }
                    } else if (indexMenu == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                        this.saleItem();
                    }
                } else if (nso.GameScr.isPaintGangTayNu) {
                    if (indexMenu == 0) {
                        if (getItemFocus(25) != null) {
                            super.left = this.cmdGangTayNuBuy;
                            if (!GameCanvas.isTouchControlLargeScreen) {
                                super.center = this.cmdGangTayNuView;
                            } else {
                                this.actView((byte) 25);
                            }
                        }
                    } else if (indexMenu == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                        this.saleItem();
                    }
                } else if (nso.GameScr.isPaintQuanNam) {
                    if (indexMenu == 0) {
                        Item item;
                        if ((item = getItemFocus(26)) != null) {
                            super.left = new Command(mResources.BUY, 11092, item);
                            if (!GameCanvas.isTouchControlLargeScreen) {
                                super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11088, item);
                            } else {
                                this.updateItemInfo(26, item);
                            }
                        }
                    } else if (indexMenu == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                        this.saleItem();
                    }
                } else if (nso.GameScr.isPaintQuanNu) {
                    if (indexMenu == 0) {
                        Item item1;
                        if ((item1 = getItemFocus(27)) != null) {
                            super.left = new Command(mResources.BUY, 11092, item1);
                            if (!GameCanvas.isTouchControlLargeScreen) {
                                super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11089);
                            } else {
                                this.updateItemInfo(27, item1);
                            }
                        }
                    } else if (indexMenu == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                        this.saleItem();
                    }
                } else if (nso.GameScr.isPaintGiayNam) {
                    if (indexMenu == 0) {
                        Item item2;
                        if ((item2 = getItemFocus(28)) != null) {
                            super.left = new Command(mResources.BUY, 11092, item2);
                            if (!GameCanvas.isTouchControlLargeScreen) {
                                super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11090);
                            } else {
                                this.updateItemInfo(28, item2);
                            }
                        }
                    } else if (indexMenu == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                        this.saleItem();
                    }
                } else if (nso.GameScr.isPaintGiayNu) {
                    if (indexMenu == 0) {
                        Item item3;
                        if ((item3 = getItemFocus(29)) != null) {
                            super.left = new Command(mResources.BUY, 11092, item3);
                            if (!GameCanvas.isTouchControlLargeScreen) {
                                super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11091);
                            } else {
                                this.updateItemInfo(29, item3);
                            }
                        }
                    } else if (indexMenu == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                        this.saleItem();
                    }
                } else if (nso.GameScr.isPaintLien) {
                    if (indexMenu == 0) {
                        Item item4;
                        if ((item4 = getItemFocus(16)) != null) {
                            super.left = new Command(mResources.BUY, 11092, item4);
                            if (GameCanvas.isTouchControlLargeScreen) {
                                this.updateItemInfo(16, item4);
                            } else {
                                super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 110923);
                            }
                        } else {
                            nso.GameScr.isPaintItemInfo = false;
                        }
                    } else if (indexMenu == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                        this.saleItem();
                    }
                } else if (nso.GameScr.isPaintNhan) {
                    if (indexMenu == 0) {
                        Item item5;
                        if ((item5 = getItemFocus(17)) != null) {
                            super.left = new Command(mResources.BUY, 11092, item5);
                            if (GameCanvas.isTouchControlLargeScreen) {
                                this.updateItemInfo(17, item5);
                            } else {
                                super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 110924);
                            }
                        } else {
                            nso.GameScr.isPaintItemInfo = false;
                        }
                    } else if (indexMenu == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                        this.saleItem();
                    }
                } else if (nso.GameScr.isPaintNgocBoi) {
                    if (indexMenu == 0) {
                        Item item6;
                        if ((item6 = getItemFocus(18)) != null) {
                            super.left = new Command(mResources.BUY, 11092, item6);
                            if (GameCanvas.isTouchControlLargeScreen) {
                                this.updateItemInfo(18, item6);
                            } else {
                                super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 110925);
                            }
                        } else {
                            nso.GameScr.isPaintItemInfo = false;
                        }
                    } else if (indexMenu == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                        this.saleItem();
                    }
                } else if (nso.GameScr.isPaintPhu) {
                    if (indexMenu == 0) {
                        Item item7;
                        if ((item7 = getItemFocus(19)) != null) {
                            super.left = new Command(mResources.BUY, 11092, item7);
                            if (GameCanvas.isTouchControlLargeScreen) {
                                this.updateItemInfo(19, item7);
                            } else {
                                super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 110926);
                            }
                        } else {
                            nso.GameScr.isPaintItemInfo = false;
                        }
                    } else if (indexMenu == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                        this.saleItem();
                    }
                } else if (nso.GameScr.isPaintWeapon) {
                    if (indexMenu == 0) {
                        Item item8;
                        if ((item8 = getItemFocus(2)) != null) {
                            super.left = new Command(mResources.BUY, 11092, item8);
                            if (GameCanvas.isTouchControlLargeScreen) {
                                this.updateItemInfo(2, item8);
                            } else {
                                super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11093);
                            }
                        } else {
                            nso.GameScr.isPaintItemInfo = false;
                        }
                    } else if (indexMenu == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                        this.saleItem();
                    }
                } else if (nso.GameScr.isPaintStack) {
                    if (indexMenu == 0) {
                        Item item9;
                        if ((item9 = getItemFocus(6)) != null) {
                            super.left = new Command(mResources.BUY, 11092, item9);
                            if (GameCanvas.isTouchControlLargeScreen) {
                                this.updateItemInfo(6, item9);
                            } else {
                                super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11094);
                            }
                        }
                    } else if (indexMenu == 1) {
                        if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                            this.saleItem();
                        } else {
                            super.left = this.cmdBagSortItem;
                        }
                    }
                } else if (nso.GameScr.isPaintStackLock) {
                    if (indexMenu == 0) {
                        Item item10;
                        if ((item10 = getItemFocus(7)) != null) {
                            super.left = new Command(mResources.BUY, 11092, item10);
                            if (GameCanvas.isTouchControlLargeScreen) {
                                this.updateItemInfo(7, item10);
                            } else {
                                super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11095);
                            }
                        }
                    } else if (indexMenu == 1) {
                        if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                            this.saleItem();
                        } else {
                            super.left = this.cmdBagSortItem;
                        }
                    }
                } else if (nso.GameScr.isPaintGrocery) {
                    if (indexMenu == 0) {
                        Item item11;
                        if ((item11 = getItemFocus(8)) != null) {
                            super.left = new Command(mResources.BUY, 11092, item11);
                            if (GameCanvas.isTouchControlLargeScreen) {
                                this.updateItemInfo(8, item11);
                            } else {
                                super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11096);
                            }
                        }
                    } else if (indexMenu == 1) {
                        if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                            this.saleItem();
                        } else {
                            super.left = this.cmdBagSortItem;
                        }
                    }
                } else if (nso.GameScr.isPaintGroceryLock) {
                    if (indexMenu == 0) {
                        Item item12;
                        if ((item12 = getItemFocus(9)) != null) {
                            super.left = new Command(mResources.BUY, 11092, item12);
                            if (GameCanvas.isTouchControlLargeScreen) {
                                this.updateItemInfo(9, item12);
                            } else {
                                super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11097);
                            }
                        }
                    } else if (indexMenu == 1) {
                        if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                            this.saleItem();
                        } else {
                            super.left = this.cmdBagSortItem;
                        }
                    }
                } else if (nso.GameScr.isPaintUpGrade) {
                    if (indexMenu == 0) {
                        if (indexTitle == 1) {
                            if (itemUpGrade != null) {
                                if (indexSelect == 0) {
                                    super.left = new Command(mResources.SELECT, 11098);
                                    if (GameCanvas.isTouchControlLargeScreen) {
                                        nso.GameScr.isViewNext = false;
                                        this.updateItemInfo(3, itemUpGrade);
                                    } else {
                                        super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11099);
                                    }
                                } else if (indexSelect == 1 && !itemUpGrade.isUpMax()) {
                                    if (GameCanvas.isTouchControlLargeScreen) {
                                        nso.GameScr.isViewNext = true;
                                        this.updateItemInfo(3, itemUpGrade);
                                    } else {
                                        super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 110991);
                                    }
                                }
                            } else {
                                nso.GameScr.isPaintItemInfo = false;
                            }
                        } else if (indexTitle == 2) {
                            Item item13 = getItemFocus(10);
                            nso.GameScr.isViewNext = false;
                            if (item13 != null) {
                                super.left = new Command(mResources.SELECT, 11100);
                                if (GameCanvas.isTouchControlLargeScreen) {
                                    this.updateItemInfo(3, item13);
                                } else {
                                    super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11101);
                                }
                            } else {
                                super.left = null;
                                nso.GameScr.isPaintItemInfo = false;
                                if (itemUpGrade != null) {
                                    for (int index = 0; index < arrItemUpGrade.length; index++) {
                                        if (arrItemUpGrade[index] != null) {
                                            super.left = new Command(mResources.BEGIN, 110981);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    } else if (indexMenu == 1) {
                        if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                            super.left = new Command(mResources.SELECT, 11102);
                        } else {
                            super.left = null;
                        }
                    }
                } else if (nso.GameScr.isPaintConvert) {
                    if (indexMenu == 0) {
                        if (indexTitle == 1) {
                            if (indexSelect == 0) {
                                if (arrItemConvert[0] != null) {
                                    super.left = new Command(mResources.SELECT, 14013);
                                    if (GameCanvas.isTouchControlLargeScreen) {
                                        this.updateItemInfo(3, arrItemConvert[indexSelect]);
                                    } else {
                                        super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 14016);
                                    }
                                }
                            } else if (indexSelect == 1) {
                                if (arrItemConvert[1] != null) {
                                    super.left = new Command(mResources.SELECT, 14013);
                                    if (GameCanvas.isTouchControlLargeScreen) {
                                        this.updateItemInfo(3, arrItemConvert[indexSelect]);
                                    } else {
                                        super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 14016);
                                    }
                                }
                            } else {
                                nso.GameScr.isPaintItemInfo = false;
                            }
                        } else if (indexTitle == 2) {
                            Item item14 = null;
                            int value;
                            if ((value = indexSelect + 2) <= arrItemConvert.length - 1) {
                                item14 = arrItemConvert[value];
                            }
                            if (item14 != null) {
                                super.left = new Command(mResources.MOVEOUT, 140151);
                                if (GameCanvas.isTouchControlLargeScreen) {
                                    this.updateItemInfo(3, item14);
                                } else {
                                    super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 140161);
                                }
                            } else {
                                super.left = new Command(mResources.BEGIN, 140131);
                                for (int index15 = 0; index15 < arrItemConvert.length; index15++) {
                                    if (arrItemConvert[index15] == null) {
                                        super.left = null;
                                        break;
                                    }
                                }
                                nso.GameScr.isPaintItemInfo = false;
                            }
                        }
                    } else if (indexMenu == 1) {
                        if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                            super.left = new Command(mResources.SELECT, 14012);
                        } else {
                            super.left = null;
                        }
                    }
                } else if (nso.GameScr.isPaintAuctionSale) {
                    if (indexMenu == 0) {
                        if (indexTitle == 2) {
                            this.tfText.isFocus = true;
                            super.right = this.tfText.cmdClear;
                        } else {
                            this.tfText.isFocus = false;
                            super.right = this.cmdCloseAll;
                        }
                        int value16 = 0;
                        try {
                            value16 = Integer.parseInt(this.tfText.getText());
                        } catch (Exception exception) {
                        }
                        if (itemSell != null && value16 > 0 && Char.getMyChar().xu >= 5000) {
                            super.left = new Command(mResources.SALE, 15002);
                        }
                        if (indexTitle == 1 && itemSell != null) {
                            super.left = new Command(mResources.SELECT, 1500);
                            if (GameCanvas.isTouchControlLargeScreen) {
                                this.updateItemInfo(3, itemSell);
                            } else {
                                super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 1501);
                            }
                        }
                    } else if (indexMenu == 1) {
                        super.right = this.cmdCloseAll;
                        if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                            super.left = new Command(mResources.SELECT, 1503);
                        } else {
                            super.left = null;
                            nso.GameScr.isPaintItemInfo = false;
                        }
                    }
                } else {
                    if (isPaintAuctionBuy) {
                        ItemStands itemStands;
                        if (indexTitle == 1 && arrItemStands != null && indexSelect >= 0 && indexSelect < arrItemStands.length && (itemStands = arrItemStands[indexSelect]) != null) {
                            super.left = new Command(mResources.SELECT, 1504);
                            if (GameCanvas.isTouchControlLargeScreen) {
                                this.actionPerform(1505, null);
                                return;
                            }
                            super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 1505);
                        }
                        return;
                    }
                    if (nso.GameScr.isPaintSplit) {
                        if (indexMenu == 0) {
                            if (indexTitle == 1) {
                                if (itemSplit != null && itemSplit.upgrade > 0) {
                                    super.left = new Command(mResources.SELECT, 11103);
                                } else if (itemSplit != null) {
                                    super.left = this.cmdSplitMoveOut;
                                } else {
                                    nso.GameScr.isPaintItemInfo = false;
                                }
                                if (GameCanvas.isTouchControlLargeScreen) {
                                    this.updateItemInfo(3, itemSplit);
                                } else {
                                    super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11104, itemSplit);
                                }
                            } else if (indexTitle == 2) {
                                Item item17;
                                if ((item17 = arrItemSplit[indexSelect]) != null) {
                                    if (GameCanvas.isTouchControlLargeScreen) {
                                        this.updateItemInfo(3, item17);
                                    } else {
                                        super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11104, item17);
                                    }
                                } else {
                                    nso.GameScr.isPaintItemInfo = false;
                                }
                                if (itemSplit != null && itemSplit.upgrade > 0) {
                                    super.left = new Command(mResources.BEGIN, 11105);
                                }
                            }
                        } else if (indexMenu == 1) {
                            if (Char.getMyChar().arrItemBag[indexSelect] == null) {
                                super.left = null;
                                nso.GameScr.isPaintItemInfo = false;
                            } else {
                                super.left = new Command(mResources.SELECT, 11106);
                            }
                        }
                    } else if (nso.GameScr.isPaintTinhluyen) {
                        try {
                            if (indexMenu == 0) {
                                if (indexTitle == 1) {
                                    if (itemSplit != null) {
                                        super.left = new Command(mResources.SELECT, 11103);
                                    } else {
                                        nso.GameScr.isPaintItemInfo = false;
                                    }
                                    if (GameCanvas.isTouchControlLargeScreen) {
                                        this.updateItemInfo(3, itemSplit);
                                    } else {
                                        super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11104, itemSplit);
                                    }
                                } else if (indexTitle == 2) {
                                    Item item18;
                                    if ((item18 = arrItemSplit[indexSelect]) != null) {
                                        if (GameCanvas.isTouchControlLargeScreen) {
                                            this.updateItemInfo(3, item18);
                                        } else {
                                            super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11104, item18);
                                        }
                                        super.left = new Command(mResources.MOVEOUT, 1605);
                                    } else {
                                        nso.GameScr.isPaintItemInfo = false;
                                    }
                                    if (itemSplit != null) {
                                        super.left = new Command(mResources.SELECT, 1604);
                                    }
                                }
                            } else if (indexMenu == 1) {
                                if (Char.getMyChar().arrItemBag[indexSelect] == null) {
                                    super.left = null;
                                    nso.GameScr.isPaintItemInfo = false;
                                } else {
                                    super.left = new Command(mResources.SELECT, 11106);
                                }
                            }
                        } catch (Exception exception42) {
                        }
                    } else if (nso.GameScr.isPaintDichChuyen) {
                        if (indexMenu == 0) {
                            if (indexTitle == 1) {
                                if (itemSplit != null && itemSplit.upgrade > 11) {
                                    super.left = new Command(mResources.SELECT, 11103);
                                } else if (itemSplit != null) {
                                    super.left = this.cmdSplitMoveOut;
                                } else {
                                    nso.GameScr.isPaintItemInfo = false;
                                }
                                if (GameCanvas.isTouchControlLargeScreen) {
                                    this.updateItemInfo(3, itemSplit);
                                } else {
                                    super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11104, itemSplit);
                                }
                            } else if (indexTitle == 2) {
                                Item item19;
                                if ((item19 = arrItemSplit[indexSelect]) != null) {
                                    if (GameCanvas.isTouchControlLargeScreen) {
                                        this.updateItemInfo(3, item19);
                                    } else {
                                        super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11104, item19);
                                    }
                                } else {
                                    nso.GameScr.isPaintItemInfo = false;
                                }
                                if (itemSplit != null && itemSplit.upgrade > 11) {
                                    super.left = new Command(mResources.SELECT, 1604);
                                }
                            }
                        } else if (indexMenu == 1) {
                            if (Char.getMyChar().arrItemBag[indexSelect] == null) {
                                super.left = null;
                                nso.GameScr.isPaintItemInfo = false;
                            } else {
                                super.left = new Command(mResources.SELECT, 1606);
                            }
                        }
                    } else if (nso.GameScr.isPaintUpPearl) {
                        if (indexMenu == 0) {
                            int value20 = 0;
                            for (int index21 = 0; index21 < arrItemUpPeal.length; index21++) {
                                if (arrItemUpPeal[index21] != null) {
                                    if (++value20 >= 2) {
                                        break;
                                    }
                                }
                            }
                            Item item22;
                            if ((item22 = getItemFocus(11)) != null) {
                                if (value20 >= 2) {
                                    super.left = new Command(mResources.SELECT, 11107);
                                } else {
                                    super.left = new Command(mResources.MOVEOUT, 111071);
                                }
                                if (GameCanvas.isTouchControlLargeScreen) {
                                    this.updateItemInfo(3, item22);
                                } else {
                                    super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11108);
                                }
                            } else {
                                nso.GameScr.isPaintItemInfo = false;
                                if (value20 >= 2) {
                                    super.left = new Command(mResources.BEGIN, 11062);
                                }
                            }
                        } else if (indexMenu == 1) {
                            if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                                super.left = new Command(mResources.SELECT, 11109);
                            } else {
                                nso.GameScr.isPaintItemInfo = false;
                                super.left = null;
                            }
                        }
                    } else if (nso.GameScr.isPaintLuyenThach) {
                        if (indexMenu == 0) {
                            int value23 = 0;
                            int value24 = 0;
                            int value25 = 0;
                            short shortValue = 0;
                            for (int index26 = 0; index26 < arrItemUpPeal.length; index26++) {
                                Item item27;
                                if ((item27 = arrItemUpPeal[index26]) != null) {
                                    if (item27.template.id == 455) {
                                        value23++;
                                    } else if (item27.template.id == 456) {
                                        value24++;
                                    } else if (item27.template.type == 26) {
                                        shortValue = item27.template.id;
                                        value25++;
                                    }
                                }
                                if (value23 >= 9 || value24 >= 9 || shortValue == 10 && value23 >= 3 || shortValue == 11 && value24 >= 3) {
                                    break;
                                }
                            }
                            Item item28;
                            if ((item28 = getItemFocus(43)) != null) {
                                if (value23 != 9 && value24 != 9 && (shortValue != 10 || value23 != 3 || value25 != 1) && (shortValue != 11 || value24 != 3 || value25 != 1)) {
                                    super.left = new Command(mResources.MOVEOUT, 111071);
                                } else {
                                    super.left = new Command(mResources.SELECT, 1601);
                                }
                                if (GameCanvas.isTouchControlLargeScreen) {
                                    this.updateItemInfo(43, item28);
                                } else {
                                    super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 1602);
                                }
                            } else {
                                nso.GameScr.isPaintItemInfo = false;
                                if (value23 >= 9 || value24 >= 9 || shortValue >= 10 && (value23 >= 3 || value24 >= 3)) {
                                    super.left = new Command(mResources.BEGIN, 1600);
                                }
                            }
                        } else if (indexMenu == 1) {
                            if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                                super.left = new Command(mResources.SELECT, 1603);
                            } else {
                                nso.GameScr.isPaintItemInfo = false;
                                super.left = null;
                            }
                        }
                    } else if (isPaintTrade) {
                        if (indexMenu == 0) {
                            if (indexTitle == 1) {
                                Item item29;
                                if ((item29 = arrItemTradeMe[indexSelect]) != null) {
                                    if (this.typeTrade == 0) {
                                        super.left = this.cmdTradeSelectInList;
                                    } else if (this.typeTrade == 1 && this.typeTradeOrder >= 1 && this.timeTrade - System.currentTimeMillis() / 1000L <= 0L) {
                                        super.left = this.cmdTradeAccept;
                                    }
                                    if (GameCanvas.isTouchControlLargeScreen) {
                                        Item item30 = arrItemTradeMe[indexSelect];
                                        this.updateItemInfo(3, item30);
                                    } else {
                                        super.center = this.cmdTradeViewItemInfo;
                                    }
                                } else {
                                    nso.GameScr.isPaintItemInfo = false;
                                    if (this.typeTrade == 0) {
                                        super.left = this.cmdTradeLock;
                                    } else if (this.typeTrade == 1 && this.typeTradeOrder >= 1 && this.timeTrade - System.currentTimeMillis() / 1000L <= 0L) {
                                        super.left = this.cmdTradeAccept;
                                    }
                                }
                            }
                            if (indexTitle == 2) {
                                Item item31;
                                if ((item31 = arrItemTradeOrder[indexSelect]) != null) {
                                    if (GameCanvas.isTouchControlLargeScreen) {
                                        Item item32 = arrItemTradeOrder[indexSelect];
                                        this.updateItemInfo(30, item32);
                                    } else {
                                        super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11110);
                                    }
                                } else {
                                    nso.GameScr.isPaintItemInfo = false;
                                }
                            }
                        } else if (indexMenu == 1 && this.typeTrade == 0) {
                            if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                                super.left = this.cmdTradeSelectInBag;
                            } else {
                                super.left = this.cmdTradeSendMoney;
                            }
                        }
                    } else if (nso.GameScr.isPaintBox) {
                        if (indexMenu == 0) {
                            Item item33;
                            if ((item33 = getItemFocus(4)) != null) {
                                String text = mResources.GETOUT;
                                if (!nso.GameScr.svTitle.equals("")) {
                                    text = nso.GameScr.svAction;
                                }
                                super.left = new Command(text, 111101);
                                if (GameCanvas.isTouchControlLargeScreen) {
                                    this.updateItemInfo(4, item33);
                                } else {
                                    super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11111);
                                }
                            } else if (nso.GameScr.svTitle.equals("")) {
                                super.left = new Command(mResources.SORT, 11112);
                            }
                        } else if (indexMenu == 1) {
                            if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                                super.left = new Command(mResources.GETIN, 11113);
                            } else {
                                super.left = this.cmdBagSortItem;
                            }
                        }
                    } else if (!nso.GameScr.isPaintCheDo) {
                        if (nso.GameScr.isPaintLuyenNgoc) {
                            GameScr gameScr = this;
                            try {
                                if (indexMenu == 0) {
                                    if (indexTitle == 1) {
                                        if (itemSplit != null) {
                                            gameScr.left = new Command(mResources.SELECT, 11103);
                                        } else {
                                            nso.GameScr.isPaintItemInfo = false;
                                        }
                                        if (GameCanvas.isTouchControlLargeScreen) {
                                            gameScr.updateItemInfo(3, itemSplit);
                                        } else {
                                            gameScr.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11104, itemSplit);
                                        }
                                    } else if (indexTitle == 2) {
                                        Item item34;
                                        if ((item34 = arrItemSplit[indexSelect]) != null) {
                                            if (GameCanvas.isTouchControlLargeScreen) {
                                                gameScr.updateItemInfo(3, item34);
                                            } else {
                                                gameScr.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11104, item34);
                                            }
                                            gameScr.left = new Command(mResources.MOVEOUT, 1605);
                                        } else {
                                            nso.GameScr.isPaintItemInfo = false;
                                        }
                                        if (itemSplit != null) {
                                            gameScr.left = new Command(mResources.SELECT, 1604);
                                        }
                                    }
                                } else if (indexMenu == 1) {
                                    if (Char.getMyChar().arrItemBag[indexSelect] == null) {
                                        gameScr.left = null;
                                        nso.GameScr.isPaintItemInfo = false;
                                    } else {
                                        gameScr.left = new Command(mResources.SELECT, 222);
                                    }
                                }
                            } catch (Exception exception43) {
                            }
                        } else if (nso.GameScr.isPaintKhamNgoc) {
                            GameScr gameScr35 = this;
                            if (indexMenu == 0) {
                                if (indexTitle == 1) {
                                    if (itemSplit != null && indexSelect == 0) {
                                        gameScr35.left = new Command(mResources.SELECT, 338);
                                        if (GameCanvas.isTouchControlLargeScreen) {
                                            nso.GameScr.isViewNext = false;
                                            gameScr35.updateItemInfo(3, itemSplit);
                                        } else {
                                            gameScr35.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 335);
                                        }
                                    }
                                    if (itemUpGrade != null && indexSelect == 1) {
                                        gameScr35.left = new Command(mResources.SELECT, 344);
                                        if (GameCanvas.isTouchControlLargeScreen) {
                                            nso.GameScr.isViewNext = false;
                                            gameScr35.updateItemInfo(3, itemUpGrade);
                                        } else {
                                            gameScr35.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 336);
                                        }
                                    }
                                    if (itemSplit == null && itemUpGrade == null) {
                                        nso.GameScr.isPaintItemInfo = false;
                                    }
                                } else if (indexTitle == 2) {
                                    Item item36 = getItemFocus(47);
                                    nso.GameScr.isViewNext = false;
                                    if (item36 != null) {
                                        gameScr35.left = new Command(mResources.SELECT, 345);
                                        if (GameCanvas.isTouchControlLargeScreen) {
                                            gameScr35.updateItemInfo(3, item36);
                                        } else {
                                            gameScr35.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11101);
                                        }
                                    } else {
                                        gameScr35.left = null;
                                        nso.GameScr.isPaintItemInfo = false;
                                        if (itemUpGrade != null && itemSplit != null) {
                                            for (int index37 = 0; index37 < arrItemUpGrade.length; index37++) {
                                                if (arrItemUpGrade[index37] != null) {
                                                    gameScr35.left = new Command(mResources.BEGIN, 341);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            } else if (indexMenu == 1) {
                                if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                                    gameScr35.left = new Command(mResources.SELECT, 337);
                                } else {
                                    gameScr35.left = null;
                                }
                            }
                        } else if (nso.GameScr.isPaintGiaoDo) {
                            GameScr gameScr38 = this;
                            if (indexMenu == 0) {
                                Item item39 = getItemFocus(48);
                                nso.GameScr.isViewNext = false;
                                if (item39 != null) {
                                    gameScr38.left = new Command(mResources.SELECT, 401);
                                    if (GameCanvas.isTouchControlLargeScreen) {
                                        gameScr38.updateItemInfo(3, item39);
                                    } else {
                                        gameScr38.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11101);
                                    }
                                } else {
                                    for (int index40 = 0; index40 < arrItemSplit.length; index40++) {
                                        if (arrItemSplit[index40] != null) {
                                            gameScr38.left = new Command(mResources.TITLEGIAODO[0], 403);
                                            break;
                                        }
                                    }
                                }
                            } else if (indexMenu == 1) {
                                if (Char.getMyChar().arrItemBag[indexSelect] != null) {
                                    gameScr38.left = new Command(mResources.SELECT, 400);
                                } else {
                                    gameScr38.left = null;
                                }
                            }
                        } else if (nso.GameScr.isPaintGotNgoc || nso.GameScr.isPaintThaoNgoc) {
                            GameScr gameScr41 = this;
                            if (indexMenu == 0) {
                                if (itemSplit != null) {
                                    gameScr41.left = new Command(mResources.SELECT, 11103);
                                } else {
                                    nso.GameScr.isPaintItemInfo = false;
                                }
                                if (GameCanvas.isTouchControlLargeScreen) {
                                    gameScr41.updateItemInfo(3, itemSplit);
                                } else {
                                    gameScr41.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11104, itemSplit);
                                }
                            } else if (indexMenu == 1) {
                                if (Char.getMyChar().arrItemBag[indexSelect] == null) {
                                    gameScr41.left = null;
                                    nso.GameScr.isPaintItemInfo = false;
                                } else {
                                    gameScr41.left = new Command(mResources.SELECT, 405);
                                }
                            }
                        }
                    }
                }
                if (isPaintUI() && indexMenu == 1 && Char.getMyChar().arrItemBag[indexSelect] != null) {
                    if (GameCanvas.isTouchControlLargeScreen) {
                        this.updateItemInfo(3, Char.getMyChar().arrItemBag[indexSelect]);
                        return;
                    }
                    super.center = new Command(GameCanvas.isTouch ? mResources.VIEW : "", 11114);
                }
            }
        }
    }

    public static void setPopupSize(int w, int h) {
        if (GameCanvas.w == 128 || GameCanvas.h <= 208) {
            w = 126;
            h = 160;
        }
        popupW = w;
        popupH = h;
        popupX = nso.GameScr.gW2 - w / 2;
        popupY = nso.GameScr.gH2 - h / 2;
        if (GameCanvas.h <= 250) {
            popupY -= 10;
        }
        if (GameCanvas.isTouchControlLargeScreen && !isSmallUI() && GameCanvas.currentScreen instanceof GameScr) {
            popupW = 310;
            popupX = nso.GameScr.gW / 2 - popupW / 2;
        }
        if (popupY < -10) {
            popupY = -10;
        }
        if (GameCanvas.h > 208 && popupY < 0) {
            popupY = 0;
        }
        if (GameCanvas.h == 208 && popupY < 10) {
            popupY = 10;
        }
    }

    private void paintSkillInfo(mGraphics g, Skill skill) {
        if (Char.getMyChar().clevel >= skill.level) {
            mFont.tahoma_7_white.drawString(g, mResources.LEVELNEED + " " + skill.level, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
        } else {
            mFont.tahoma_7_red.drawString(g, mResources.LEVELNEED + " " + skill.level, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
        }
        if (skill.template.type != 0) {
            indexRowMax += 4;
            mFont.tahoma_7_white.drawString(g, mResources.MAX_FIGHT + ": " + skill.maxFight, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
            mFont.tahoma_7_white.drawString(g, mResources.MANA_USE + ": " + skill.manaUse, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
            mFont.tahoma_7_white.drawString(g, mResources.RANGE_ATTACK + ": " + skill.dx, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
            mFont font = mFont.tahoma_7_white;
            StringBuffer stringBuffer = new StringBuffer(String.valueOf(mResources.TIME_LOOP)).append(": ");
            Skill skill1 = skill;
            String text;
            if (skill.coolDown % 1000 == 0) {
                text = String.valueOf(skill1.coolDown / 1000);
            } else {
                int value = skill1.coolDown % 1000;
                text = skill1.coolDown / 1000 + "." + (value % 100 == 0 ? value / 100 : value / 10);
            }
            font.drawString(g, stringBuffer.append(text).append(" ").append(mResources.SECOND).toString(), nso.GameScr.xstart + 5, this.yPaint += 12, 0);
        }
        indexRowMax++;
    }

    private void paintSkillOption(mGraphics g, Skill skill) {
        SkillOption[] values = skill.options;
        for (int index = 0; index < values.length; index++) {
            SkillOption skillOption = values[index];
            if (mFont.tahoma_7_white.getWidth(skillOption.getOptionString()) > 145) {
                MyVector entries = mFont.tahoma_7_white.splitFontVector(skillOption.getOptionString(), 145);
                for (int index1 = 0; index1 < entries.size(); index1++) {
                    mFont.tahoma_7_white.drawString(g, entries.elementAt(index1).toString(), nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                    indexRowMax++;
                }
            } else {
                mFont.tahoma_7_white.drawString(g, skillOption.getOptionString(), nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                indexRowMax++;
            }
        }
    }

    private void paintKyNang(mGraphics g) {
        if (indexMenu == 1) {
            resetTranslate(g);
            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
            paintTitle(g, mResources.MENUME[indexMenu], true);
            mFont.tahoma_7b_white.drawString(g, mResources.SKILL_POINT, popupX + 10, popupY + 32, 0);
            mFont.tahoma_7b_white.drawString(g, "" + Char.getMyChar().sPoint, popupX + popupW - 10, popupY + 32, 1);
            g.setColor(0);
            g.fillRect(popupX + 4, popupY + 44, popupW - 7, indexSize + 3);
            g.setColor(12281361);
            g.drawRect(popupX + 5, popupY + 45, popupW - 10, indexSize);
            if (indexTitle >= 1) {
                g.setColor(Paint.COLORBORDER);
                g.drawRect(popupX + 5, popupY + 48 + indexSize, popupW - 10, popupH - 64 - indexSize);
            }
            int value = Char.getMyChar().nClass.skillTemplates.length;
            nso.GameScr.xstart = popupX + 5;
            nso.GameScr.ystart = popupY + 45;
            scrMain.setStyle(value, indexSize + 2, nso.GameScr.xstart + 1, nso.GameScr.ystart, popupW - 12, indexSize + 2, false, 1);
            scrMain.setClip(g);
            for (int index = 0; index < value; index++) {
                int value1 = nso.GameScr.xstart + index * (indexSize + 2) + indexSize / 2;
                int value2 = nso.GameScr.ystart + indexSize / 2;
                SmallImage.drawSmallImage(g, Char.getMyChar().nClass.skillTemplates[index].iconId, value1, value2, 0, 3);
                if (indexTitle == 1 && index == indexSelect) {
                    g.setColor(16777215);
                    g.drawRect(nso.GameScr.xstart + index * (indexSize + 2) + 2, nso.GameScr.ystart + 2, indexSize - 4, indexSize - 4);
                    paintSelectHighlight(nso.GameScr.xstart + index * (indexSize + 2), nso.GameScr.ystart, g);
                }
            }
            nso.GameScr.xstart += 8;
            nso.GameScr.ystart += 6;
            if (indexTitle == 1 && indexSelect >= 0) {
                resetTranslate(g);
                SkillTemplate skillTemplate = Char.getMyChar().nClass.skillTemplates[indexSelect];
                indexRowMax = 4 + skillTemplate.description.length;
                Skill skill = Char.getMyChar().getSkill(skillTemplate);
                int value3 = popupX;
                int value4 = nso.GameScr.ystart + indexSize + 2;
                int value5 = popupW - 6;
                int value6 = popupH - 70 - indexSize;
                scrInfo.setClip(g, value3, value4, value5, value6);
                this.yPaint = nso.GameScr.ystart + 18;
                if (skill == null) {
                    Skill skill7 = skillTemplate.skills.length > 1 ? skillTemplate.skills[1] : skillTemplate.skills[0];
                    mFont.tahoma_7b_red.drawString(g, skillTemplate.name, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                    for (int index8 = 0; index8 < skillTemplate.description.length; index8++) {
                        mFont.tahoma_7_white.drawString(g, skillTemplate.description[index8], nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                    }
                    mFont.tahoma_7_white.drawString(g, mResources.SKILLTYPE[skillTemplate.type], nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                    mFont.tahoma_7_white.drawString(g, mResources.LEVELMAX + ": " + skillTemplate.maxPoint, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                    mFont.tahoma_7_red.drawString(g, mResources.replace(mResources.LEVELNEXT, String.valueOf(skill7.point)), nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                    this.paintSkillInfo(g, skill7);
                    this.paintSkillOption(g, skill7);
                } else {
                    mFont.tahoma_7b_white.drawString(g, skillTemplate.name, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                    for (int index9 = 0; index9 < skillTemplate.description.length; index9++) {
                        mFont.tahoma_7_white.drawString(g, skillTemplate.description[index9], nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                    }
                    mFont.tahoma_7_white.drawString(g, mResources.SKILLTYPE[skillTemplate.type], nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                    mFont.tahoma_7_white.drawString(g, mResources.LEVELMAX + ": " + skillTemplate.maxPoint, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                    if (skill.point == skillTemplate.maxPoint) {
                        mFont.tahoma_7_blue.drawString(g, mResources.LEVELEDMAX, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                        this.paintSkillInfo(g, skill);
                        this.paintSkillOption(g, skill);
                    } else {
                        mFont.tahoma_7_blue.drawString(g, mResources.replace(mResources.LEVELNOW, String.valueOf(skill.point)), nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                        this.paintSkillInfo(g, skill);
                        this.paintSkillOption(g, skill);
                        int value10;
                        for (value10 = 0; value10 < skillTemplate.skills.length; value10++) {
                            if (skillTemplate.skills[value10].equals(skill)) {
                                value10++;
                                break;
                            }
                        }
                        mFont.tahoma_7_red.drawString(g, mResources.replace(mResources.LEVELNEXT, String.valueOf(skillTemplate.skills[value10].point)), nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                        this.paintSkillInfo(g, skillTemplate.skills[value10]);
                        indexRowMax++;
                        this.paintSkillOption(g, skillTemplate.skills[value10]);
                    }
                }
                scrInfo.setStyle(indexRowMax, 12, value3, value4, value5, value6, true, 1);
                if (indexRow >= 0) {
                    SmallImage.drawSmallImage(g, 942, nso.GameScr.xstart + 2, nso.GameScr.ystart + 32 + indexRow * 12, 0, StaticObj.TOP_RIGHT);
                }
            }
        }
    }

    private void paintBag(mGraphics g, String[] titles) {
        try {
            resetTranslate(g);
            this.paintItemFrame(g, titles, true);
            this.paintBagItem(g, Char.getMyChar().arrItemBag);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void paintBagItem(mGraphics g, Item[] items) {
        rows = items.length / columns;
        scrMain.setStyle(rows, indexSize, nso.GameScr.xstart, nso.GameScr.ystart, columns * indexSize, 5 * indexSize, true, 6);
        scrMain.setClip(g, nso.GameScr.xstart, nso.GameScr.ystart, scrMain.width + 2, scrMain.height + 2);
        for (int index = 0; index < rows; index++) {
            for (int index1 = 0; index1 < columns; index1++) {
                SmallImage.drawSmallImage(g, 154, nso.GameScr.xstart + index1 * indexSize + indexSize / 2, nso.GameScr.ystart + index * indexSize + indexSize / 2, 0, 3);
                g.setColor(12281361);
                g.drawRect(nso.GameScr.xstart + index1 * indexSize, nso.GameScr.ystart + index * indexSize, indexSize, indexSize);
            }
        }
        for (int index2 = 0; index2 < items.length; index2++) {
            Item item;
            if ((item = items[index2]) != null) {
                int value = item.indexUI / columns;
                int value3 = item.indexUI - value * columns;
                this.paintItem(g, item, nso.GameScr.xstart + value3 * indexSize, nso.GameScr.ystart + value * indexSize);
                if (item.quantity > 1) {
                    mFont.number_yellow.drawString(g, "" + item.quantity, nso.GameScr.xstart + value3 * indexSize + indexSize, nso.GameScr.ystart + value * indexSize + indexSize - mFont.number_yellow.getHeight(), 1);
                }
            }
        }
        if (indexTitle > 0 && indexSelect >= 0) {
            int value4 = indexSelect / columns;
            int value5 = indexSelect - value4 * columns;
            g.setColor(16777215);
            g.drawRect(nso.GameScr.xstart + value5 * indexSize, nso.GameScr.ystart + value4 * indexSize, indexSize, indexSize);
            paintSelectHighlight(nso.GameScr.xstart + value5 * indexSize, nso.GameScr.ystart + value4 * indexSize, g);
        }
    }

    private static void paintSelectHighlight(int value, int value1, mGraphics graphics) {
        graphics.drawImage(nso.GameScr.imgSelect, value - 5, value1 - 5, 0);
    }

    private static int upgradeEffectY(int value) {
        int value1 = indexSize - 2;
        if ((value = value % (value1 * 4)) >= 0 && value < value1) {
            return 0;
        } else if (value1 <= value && value < value1 << 1) {
            return value % value1;
        } else {
            return value1 << 1 <= value && value < value1 * 3 ? value1 : value1 - value % value1;
        }
    }

    private static int upgradeEffectX(int value) {
        int value1 = indexSize - 2;
        if ((value = value % (value1 * 4)) >= 0 && value < value1) {
            return value % value1;
        } else if (value1 <= value && value < value1 << 1) {
            return value1;
        } else {
            return value1 << 1 <= value && value < value1 * 3 ? value1 - value % value1 : 0;
        }
    }

    private void paintShopOnline(mGraphics g, Item[] items) {
        try {
            resetTranslate(g);
            boolean flag = true;
            String text = Name_store;
            mGraphics graphics = g;
            Paint.paintFrame(popupX, popupY, popupW, popupH, graphics);
            mFont.tahoma_7_white.drawString(graphics, mResources.XU + ": " + NinjaUtil.numberToString(String.valueOf(Char.getMyChar().xu)), popupX + 6, popupY + popupH - 26, 0);
            mFont.tahoma_7_white.drawString(graphics, mResources.YEN + ": " + NinjaUtil.numberToString(String.valueOf(Char.getMyChar().yen)), popupX + popupW - 6, popupY + popupH - 26, 1);
            if (isPaintTrade) {
                if (GameCanvas.gameTick % 10 > 4) {
                    mFont.tahoma_7_yellow.drawString(graphics, mResources.SELECTTRADE, popupX + popupW / 2, popupY + popupH - 14, 2);
                }
            } else if (nso.GameScr.isPaintUpPearl) {
                if (GameCanvas.gameTick % 10 > 4) {
                    mFont.tahoma_7_yellow.drawString(graphics, mResources.SELECTPEARL, popupX + popupW / 2, popupY + popupH - 14, 2);
                }
            } else if (nso.GameScr.isPaintSplit) {
                if (GameCanvas.gameTick % 10 > 4) {
                    mFont.tahoma_7_yellow.drawString(graphics, mResources.SELECT_ITEM, popupX + popupW / 2, popupY + popupH - 14, 2);
                }
            } else {
                mFont.tahoma_7_yellow.drawString(graphics, mResources.LUONG + ": " + NinjaUtil.numberToString(String.valueOf(Char.getMyChar().luong)), popupX + popupW / 2, popupY + popupH - 14, 2);
            }
            paintTitle(graphics, text, false);
            nso.GameScr.xstart = popupX + 3;
            nso.GameScr.ystart = popupY + 32;
            graphics.setColor(6425);
            graphics.fillRect(nso.GameScr.xstart - 1, nso.GameScr.ystart - 1, columns * indexSize + 3, 5 * indexSize + 3);
            if (items == null) {
                GameCanvas.paintShukiren(popupX + 90, popupY + 75, g, false);
                mFont.tahoma_7b_white.drawString(g, mResources.PLEASEWAIT, popupX + 90, popupY + 90, 2);
                return;
            }
            if (items.length <= 30) {
                rows = 5;
            } else if (items.length % columns == 0) {
                rows = items.length / columns;
            } else {
                rows = items.length / columns + 1;
            }
            scrMain.setStyle(rows, indexSize, nso.GameScr.xstart, nso.GameScr.ystart, columns * indexSize, 5 * indexSize, true, 6);
            scrMain.setClip(g, nso.GameScr.xstart, nso.GameScr.ystart, scrMain.width + 2, scrMain.height + 2);
            for (int index = 0; index < rows; index++) {
                for (int index1 = 0; index1 < columns; index1++) {
                    SmallImage.drawSmallImage(g, 154, nso.GameScr.xstart + index1 * indexSize + indexSize / 2, nso.GameScr.ystart + index * indexSize + indexSize / 2, 0, 3);
                    g.setColor(12281361);
                    g.drawRect(nso.GameScr.xstart + index1 * indexSize, nso.GameScr.ystart + index * indexSize, indexSize, indexSize);
                }
            }
            for (int index2 = 0; index2 < items.length; index2++) {
                Item item;
                if ((item = items[index2]) != null) {
                    int value = item.indexUI / columns;
                    int value3 = item.indexUI - value * columns;
                    if (!item.isLock) {
                        g.setColor(12083);
                        g.fillRect(nso.GameScr.xstart + value3 * indexSize + 1, nso.GameScr.ystart + value * indexSize + 1, indexSize - 1, indexSize - 1);
                        SmallImage.drawSmallImage(g, 154, nso.GameScr.xstart + value3 * indexSize + indexSize / 2, nso.GameScr.ystart + value * indexSize + indexSize / 2, 0, 3);
                    }
                    SmallImage.drawSmallImage(g, item.template.iconID, nso.GameScr.xstart + value3 * indexSize + indexSize / 2, nso.GameScr.ystart + value * indexSize + indexSize / 2, 0, 3);
                }
            }
            if (indexTitle > 0 && indexSelect >= 0) {
                int value4 = indexSelect / columns;
                int value5 = indexSelect - value4 * columns;
                g.setColor(16777215);
                g.drawRect(nso.GameScr.xstart + value5 * indexSize, nso.GameScr.ystart + value4 * indexSize, indexSize, indexSize);
                paintSelectHighlight(nso.GameScr.xstart + value5 * indexSize, nso.GameScr.ystart + value4 * indexSize, g);
                return;
            }
        } catch (Exception exception) {
        }
    }

    private void paintItemList(mGraphics g, String[] titles, Item[] items) {
        try {
            resetTranslate(g);
            this.paintItemFrame(g, titles, true);
            if (items == null) {
                GameCanvas.paintShukiren(popupX + 90, popupY + 75, g, false);
                mFont.tahoma_7b_white.drawString(g, mResources.PLEASEWAIT, popupX + 90, popupY + 90, 2);
                return;
            }
            if (items.length <= 30) {
                rows = 5;
            } else if (items.length % columns == 0) {
                rows = items.length / columns;
            } else {
                rows = items.length / columns + 1;
            }
            scrMain.setStyle(rows, indexSize, nso.GameScr.xstart, nso.GameScr.ystart, columns * indexSize, 5 * indexSize, true, 6);
            scrMain.setClip(g, nso.GameScr.xstart, nso.GameScr.ystart, scrMain.width + 2, scrMain.height + 2);
            for (int index = 0; index < rows; index++) {
                for (int index1 = 0; index1 < columns; index1++) {
                    SmallImage.drawSmallImage(g, 154, nso.GameScr.xstart + index1 * indexSize + indexSize / 2, nso.GameScr.ystart + index * indexSize + indexSize / 2, 0, 3);
                    g.setColor(12281361);
                    g.drawRect(nso.GameScr.xstart + index1 * indexSize, nso.GameScr.ystart + index * indexSize, indexSize, indexSize);
                }
            }
            for (int index2 = 0; index2 < items.length; index2++) {
                Item item;
                if ((item = items[index2]) != null) {
                    int value = item.indexUI / columns;
                    int value3 = item.indexUI - value * columns;
                    if (!item.isLock) {
                        g.setColor(12083);
                        g.fillRect(nso.GameScr.xstart + value3 * indexSize + 1, nso.GameScr.ystart + value * indexSize + 1, indexSize - 1, indexSize - 1);
                        SmallImage.drawSmallImage(g, 154, nso.GameScr.xstart + value3 * indexSize + indexSize / 2, nso.GameScr.ystart + value * indexSize + indexSize / 2, 0, 3);
                    }
                    if (GameCanvas.gameTick % 6 == 0) {
                        item.indexFrame = (item.indexFrame + 1) % 3;
                    }
                    if (item.isNewitem()) {
                        g.drawImage(GameCanvas.backitem, nso.GameScr.xstart + value3 * indexSize + indexSize / 2, nso.GameScr.ystart + value * indexSize + indexSize / 2, 3);
                    }
                    SmallImage.drawSmallImageNew(g, item.template.iconID, nso.GameScr.xstart + value3 * indexSize + indexSize / 2, nso.GameScr.ystart + value * indexSize + indexSize / 2, 0, 3, item.indexFrame);
                }
            }
            if (indexTitle > 0 && indexSelect >= 0) {
                int value4 = indexSelect / columns;
                int value5 = indexSelect - value4 * columns;
                g.setColor(16777215);
                g.drawRect(nso.GameScr.xstart + value5 * indexSize, nso.GameScr.ystart + value4 * indexSize, indexSize, indexSize);
                paintSelectHighlight(nso.GameScr.xstart + value5 * indexSize, nso.GameScr.ystart + value4 * indexSize, g);
                return;
            }
        } catch (Exception exception) {
        }
    }

    private void paintItemFrame(mGraphics g, String[] titles, boolean paintMoney) {
        Paint.paintFrame(popupX, popupY, popupW, popupH, g);
        if (paintMoney) {
            mFont.tahoma_7_white.drawString(g, mResources.XU + ": " + NinjaUtil.numberToString(String.valueOf(Char.getMyChar().xu)), popupX + 6, popupY + popupH - 26, 0);
            mFont.tahoma_7_white.drawString(g, mResources.YEN + ": " + NinjaUtil.numberToString(String.valueOf(Char.getMyChar().yen)), popupX + popupW - 6, popupY + popupH - 26, 1);
            if (isPaintTrade) {
                if (GameCanvas.gameTick % 10 > 4) {
                    mFont.tahoma_7_yellow.drawString(g, mResources.SELECTTRADE, popupX + popupW / 2, popupY + popupH - 14, 2);
                }
            } else if (nso.GameScr.isPaintUpPearl) {
                if (GameCanvas.gameTick % 10 > 4) {
                    mFont.tahoma_7_yellow.drawString(g, mResources.SELECTPEARL, popupX + popupW / 2, popupY + popupH - 14, 2);
                }
            } else if (nso.GameScr.isPaintSplit) {
                if (GameCanvas.gameTick % 10 > 4) {
                    mFont.tahoma_7_yellow.drawString(g, mResources.SELECT_ITEM, popupX + popupW / 2, popupY + popupH - 14, 2);
                }
            } else {
                mFont.tahoma_7_yellow.drawString(g, mResources.LUONG + ": " + NinjaUtil.numberToString(String.valueOf(Char.getMyChar().luong)), popupX + popupW / 2, popupY + popupH - 14, 2);
            }
        }
        paintTitle(g, titles[indexMenu], titles.length > 1);
        nso.GameScr.xstart = popupX + 3;
        nso.GameScr.ystart = popupY + 32;
        g.setColor(6425);
        g.fillRect(nso.GameScr.xstart - 1, nso.GameScr.ystart - 1, columns * indexSize + 3, 5 * indexSize + 3);
    }

    private void paintItem(mGraphics g, Item item, int x, int y) {
        this.paintItem(g, item, x, y, 0, 0);
    }

    private void paintItem(mGraphics g, Item item, int x, int y, int dUpgrade, int dR) {
        if (!item.isTypeMounts()) {
            if ((dUpgrade = item.upgrade + dUpgrade) > 0) {
                if (dUpgrade >= 4) {
                    g.setColor(this.color[dUpgrade > 16 ? 16 : dUpgrade]);
                    g.fillRect(x + 1 + dR, y + 1 + dR, indexSize - 1 - dR * 2, indexSize - 1 - dR * 2);
                    SmallImage.drawSmallImage(g, 154, x + indexSize / 2, y + indexSize / 2, 0, 3);
                } else {
                    paintItemBackground(g, item, x, y, dR);
                }
                if (dUpgrade >= 1) {
                    int value = x + indexSize / 2;
                    int value1 = y + indexSize / 2;
                    mGraphics graphics = g;
                    int value2 = dUpgrade;
                    dR = value1;
                    dUpgrade = value;
                    int value3 = indexSize - 2;
                    int value4 = value2 < 4 ? 0 : (value2 < 8 ? 1 : (value2 < 12 ? 2 : (value2 <= 14 ? 3 : 4)));
                    for (int index = 0; index < this.size.length; index++) {
                        int value5 = dUpgrade - value3 / 2 + upgradeEffectX(GameCanvas.gameTick - (index << 2));
                        int value6 = dR - value3 / 2 + upgradeEffectY(GameCanvas.gameTick - (index << 2));
                        graphics.setColor(this.colorBorder[value4][index]);
                        graphics.fillRect(value5 - this.size[index] / 2, value6 - this.size[index] / 2, this.size[index], this.size[index]);
                    }
                    if (value2 == 4 || value2 == 8) {
                        for (int index7 = 0; index7 < this.size.length; index7++) {
                            int value8 = dUpgrade - value3 / 2 + upgradeEffectX(GameCanvas.gameTick - (value3 << 1) - (index7 << 2));
                            int value9 = dR - value3 / 2 + upgradeEffectY(GameCanvas.gameTick - (value3 << 1) - (index7 << 2));
                            graphics.setColor(this.colorBorder[value4 - 1][index7]);
                            graphics.fillRect(value8 - this.size[index7] / 2, value9 - this.size[index7] / 2, this.size[index7], this.size[index7]);
                        }
                    }
                    if (value2 != 1 && value2 != 4 && value2 != 8) {
                        for (int index10 = 0; index10 < this.size.length; index10++) {
                            int value11 = dUpgrade - value3 / 2 + upgradeEffectX(GameCanvas.gameTick - (value3 << 1) - (index10 << 2));
                            int value12 = dR - value3 / 2 + upgradeEffectY(GameCanvas.gameTick - (value3 << 1) - (index10 << 2));
                            graphics.setColor(this.colorBorder[value4][index10]);
                            graphics.fillRect(value11 - this.size[index10] / 2, value12 - this.size[index10] / 2, this.size[index10], this.size[index10]);
                        }
                    }
                    if (value2 != 1 && value2 != 4 && value2 != 8 && value2 != 12 && value2 != 2 && value2 != 5 && value2 != 9) {
                        for (int index13 = 0; index13 < this.size.length; index13++) {
                            int value14 = dUpgrade - value3 / 2 + upgradeEffectX(GameCanvas.gameTick - value3 - (index13 << 2));
                            int value15 = dR - value3 / 2 + upgradeEffectY(GameCanvas.gameTick - value3 - (index13 << 2));
                            graphics.setColor(this.colorBorder[value4][index13]);
                            graphics.fillRect(value14 - this.size[index13] / 2, value15 - this.size[index13] / 2, this.size[index13], this.size[index13]);
                        }
                    }
                    if (value2 != 1 && value2 != 4 && value2 != 8 && value2 != 12 && value2 != 2 && value2 != 5 && value2 != 9 && value2 != 13 && value2 != 3 && value2 != 6 && value2 != 10 && value2 != 15) {
                        for (int index16 = 0; index16 < this.size.length; index16++) {
                            int value17 = dUpgrade - value3 / 2 + upgradeEffectX(GameCanvas.gameTick - value3 * 3 - (index16 << 2));
                            int value18 = dR - value3 / 2 + upgradeEffectY(GameCanvas.gameTick - value3 * 3 - (index16 << 2));
                            graphics.setColor(this.colorBorder[value4][index16]);
                            graphics.fillRect(value17 - this.size[index16] / 2, value18 - this.size[index16] / 2, this.size[index16], this.size[index16]);
                        }
                    }
                }
            } else {
                paintItemBackground(g, item, x, y, dR);
            }
        }
        if (GameCanvas.gameTick % 6 == 0) {
            item.indexFrame = (item.indexFrame + 1) % 3;
        }
        if (item.isNewitem()) {
            g.drawImage(GameCanvas.backitem, x + indexSize / 2, y + indexSize / 2, 3);
        }
        SmallImage.drawSmallImageNew(g, item.template.iconID, x + indexSize / 2, y + indexSize / 2, 0, 3, item.indexFrame);
    }

    private static void paintItemBackground(mGraphics g, Item item, int x, int y, int dR) {
        if (!item.isLock) {
            g.setColor(12083);
        } else {
            g.setColor(6425);
        }
        g.fillRect(x + 1 + dR, y + 1 + dR, indexSize - 2 - dR * 2, indexSize - 2 - dR * 2);
        SmallImage.drawSmallImage(g, 154, x + indexSize / 2, y + indexSize / 2, 0, 3);
    }

    private void paintSplit(mGraphics g, String[] titles) {
        try {
            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
            paintTitle(g, titles[indexMenu], titles.length > 1);
            nso.GameScr.xstart = popupX + 3;
            nso.GameScr.ystart = popupY + 34 + indexSize;
            int value = popupX + 74;
            int value1 = nso.GameScr.ystart - indexSize - 3;
            rows = 4;
            if (itemSplit != null) {
                this.paintItem(g, itemSplit, value, value1);
            } else {
                g.setColor(6425);
                g.fillRect(value - 1, value1 - 1, indexSize + 3, indexSize + 3);
                SmallImage.drawSmallImage(g, 154, value + indexSize / 2, value1 + indexSize / 2, 0, 3);
            }
            g.setColor(12281361);
            g.drawRect(value, value1, indexSize, indexSize);
            g.setColor(6425);
            g.fillRect(nso.GameScr.xstart - 1, nso.GameScr.ystart - 1, indexSize * columns + 3, indexSize * rows + 3);
            for (int index = 0; index < rows; index++) {
                for (int index2 = 0; index2 < columns; index2++) {
                    SmallImage.drawSmallImage(g, 154, nso.GameScr.xstart + index2 * indexSize + indexSize / 2, nso.GameScr.ystart + index * indexSize + indexSize / 2, 0, 3);
                    g.setColor(12281361);
                    g.drawRect(nso.GameScr.xstart + index2 * indexSize, nso.GameScr.ystart + index * indexSize, indexSize, indexSize);
                }
            }
            for (int index3 = 0; index3 < arrItemSplit.length; index3++) {
                Item item;
                if ((item = arrItemSplit[index3]) != null) {
                    int value4 = index3 / columns;
                    int value5 = index3 - value4 * columns;
                    if (!item.isLock) {
                        g.setColor(12083);
                        g.fillRect(nso.GameScr.xstart + value5 * indexSize + 1, nso.GameScr.ystart + value4 * indexSize + 1, indexSize - 1, indexSize - 1);
                    }
                    SmallImage.drawSmallImage(g, item.template.iconID, nso.GameScr.xstart + value5 * indexSize + indexSize / 2, nso.GameScr.ystart + value4 * indexSize + indexSize / 2, 0, 3);
                }
            }
            if (indexTitle == 1) {
                g.setColor(16777215);
                g.drawRect(value, value1, indexSize, indexSize);
            } else if (indexTitle == 2) {
                int value6 = indexSelect / columns;
                int value7 = indexSelect - value6 * columns;
                g.setColor(16777215);
                g.drawRect(nso.GameScr.xstart + value7 * indexSize, nso.GameScr.ystart + value6 * indexSize, indexSize, indexSize);
            }
            if (effUpok != null) {
                SmallImage.drawSmallImage(g, effUpok.arrEfInfo[indexEff].idImg, value + indexSize / 2 + effUpok.arrEfInfo[indexEff].dx, value1 + indexSize / 2 + effUpok.arrEfInfo[indexEff].dy, 0, 3);
                if (GameCanvas.gameTick % 2 == 0 && ++indexEff >= effUpok.arrEfInfo.length) {
                    indexEff = 0;
                    effUpok = null;
                }
            }
            if (nso.GameScr.isPaintTinhluyen && itemSplit != null) {
                Object argument = null;
                for (int index8 = 0; index8 < itemSplit.options.size() && ((ItemOption) (argument = (ItemOption) itemSplit.options.elementAt(index8))).optionTemplate.id != 85; index8++) {
                    argument = null;
                }
                if (argument != null) {
                    int[] values = new int[] { 60, 45, 34, 26, 20, 15, 11, 8, 6 };
                    int[] values9 = new int[] { 150000, 247500, 408375, 673819, 1111801, 2056832, 4010822, 7420021, 12243035 };
                    byte[] data = new byte[] { 3, 5, 9, 4, 7, 10, 5, 7, 9 };
                    mFont.tahoma_7_yellow.drawString(g, mResources.LEVEL_TINHLUYEN + ": " + NinjaUtil.numberToString(String.valueOf(((ItemOption) argument).param + 1)), nso.GameScr.xstart + 1, nso.GameScr.ystart + 114, 0);
                    mFont.tahoma_7_yellow.drawString(g, mResources.PERCENT1 + values[((ItemOption) argument).param] + "%)", nso.GameScr.xstart + 70, nso.GameScr.ystart + 114, 0);
                    mFont.tahoma_7_yellow.drawString(g, mResources.NEED + ": " + NinjaUtil.numberToString(String.valueOf(values9[((ItemOption) argument).param])) + " " + mResources.YEN + ", " + data[((ItemOption) argument).param] + " " + (((ItemOption) argument).param < 3 ? mResources.TUTINH[1] : (((ItemOption) argument).param < 6 ? mResources.TUTINH[2] : mResources.TUTINH[3])), nso.GameScr.xstart + 1, nso.GameScr.ystart + 126, 0);
                    return;
                }
                mFont.tahoma_7_red.drawString(g, mResources.CAN_NOT_TINHLUYEN, nso.GameScr.xstart + 1, nso.GameScr.ystart + 120, 0);
                return;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void paintUpPearl(mGraphics g, String[] titles) {
        try {
            resetTranslate(g);
            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
            paintTitle(g, titles[indexMenu], titles.length > 1);
            nso.GameScr.xstart = popupX + 3;
            nso.GameScr.ystart = popupY + 32;
            g.setColor(6425);
            rows = 4;
            if (!nso.GameScr.isPaintUpPearl) {
                mFont.tahoma_7_white.drawString(g, mResources.LUYEN_THACH[0], nso.GameScr.xstart + 3, nso.GameScr.ystart + rows * indexSize + 9, 0);
                mFont.tahoma_7_white.drawString(g, mResources.LUYEN_THACH[1], nso.GameScr.xstart + 3, nso.GameScr.ystart + rows * indexSize + 21, 0);
                mFont.tahoma_7_white.drawString(g, mResources.LUYEN_THACH[2], nso.GameScr.xstart + 3, nso.GameScr.ystart + rows * indexSize + 33, 0);
            } else {
                int value = 0;
                int value1 = 0;
                int value2 = 0;
                boolean flag = false;
                for (int index = 0; index < arrItemUpPeal.length; index++) {
                    if (arrItemUpPeal[index] != null) {
                        if (arrItemUpPeal[index].isLock) {
                            flag = true;
                        }
                        value += crystals[arrItemUpPeal[index].template.id];
                        value1++;
                    }
                }
                if (value > 0) {
                    value2 = crystals.length - 1;
                    while (value2 >= 0 && value <= crystals[value2]) {
                        value2--;
                    }
                }
                if (value2 >= crystals.length - 1) {
                    value2 = crystals.length - 2;
                }
                if (isTypeXu) {
                    if (value1 > 1) {
                        mFont.tahoma_7_yellow.drawString(g, mResources.CRYSTALOUT + " " + (value2 + 2) + " " + (flag ? mResources.LOCK : ""), nso.GameScr.xstart + 3, nso.GameScr.ystart + rows * indexSize + 9, 0);
                        if (nso.GameScr.coinUpCrystals[value2 + 1] > Char.getMyChar().xu) {
                            mFont.tahoma_7_red.drawString(g, mResources.replace(mResources.COINNEED, NinjaUtil.numberToString(String.valueOf(nso.GameScr.coinUpCrystals[value2 + 1]))), nso.GameScr.xstart + 3, nso.GameScr.ystart + rows * indexSize + 21, 0);
                        } else {
                            mFont.tahoma_7_yellow.drawString(g, mResources.replace(mResources.COINNEED, NinjaUtil.numberToString(String.valueOf(nso.GameScr.coinUpCrystals[value2 + 1]))), nso.GameScr.xstart + 3, nso.GameScr.ystart + rows * indexSize + 21, 0);
                        }
                        mFont.tahoma_7_yellow.drawString(g, mResources.PERCENT + ": " + value * 100 / crystals[value2 + 1] + "%", nso.GameScr.xstart + 3, nso.GameScr.ystart + rows * indexSize + 33, 0);
                    } else {
                        for (int index3 = 1; index3 <= 2; index3++) {
                            mFont.tahoma_7_white.drawString(g, mResources.HELPCRYSTAL[index3], nso.GameScr.xstart + 3, nso.GameScr.ystart + rows * indexSize + 5 + (index3 - 1) * 12, 0);
                        }
                    }
                } else if (value1 > 1) {
                    mFont.tahoma_7_yellow.drawString(g, mResources.CRYSTALOUT + " " + (value2 + 2) + " " + mResources.LOCK, nso.GameScr.xstart + 3, nso.GameScr.ystart + rows * indexSize + 9, 0);
                    if (nso.GameScr.coinUpCrystals[value2 + 1] > Char.getMyChar().xu + Char.getMyChar().yen) {
                        mFont.tahoma_7_red.drawString(g, mResources.replace(mResources.COINLOCKNEED, NinjaUtil.numberToString(String.valueOf(nso.GameScr.coinUpCrystals[value2 + 1]))), nso.GameScr.xstart + 3, nso.GameScr.ystart + rows * indexSize + 21, 0);
                    } else {
                        mFont.tahoma_7_yellow.drawString(g, mResources.replace(mResources.COINLOCKNEED, NinjaUtil.numberToString(String.valueOf(nso.GameScr.coinUpCrystals[value2 + 1]))), nso.GameScr.xstart + 3, nso.GameScr.ystart + rows * indexSize + 21, 0);
                    }
                    mFont.tahoma_7_yellow.drawString(g, mResources.PERCENT + ": " + value * 100 / crystals[value2 + 1] + "%", nso.GameScr.xstart + 3, nso.GameScr.ystart + rows * indexSize + 33, 0);
                } else {
                    for (int index4 = 0; index4 < 3; index4++) {
                        mFont.tahoma_7_white.drawString(g, mResources.HELPCRYSTAL[index4], nso.GameScr.xstart + 3, nso.GameScr.ystart + rows * indexSize + 5 + index4 * 12, 0);
                    }
                }
            }
            g.setColor(0);
            g.fillRect(nso.GameScr.xstart, nso.GameScr.ystart, columns * indexSize + 1, rows * indexSize + 1);
            for (int index5 = 0; index5 < rows; index5++) {
                for (int index6 = 0; index6 < columns; index6++) {
                    SmallImage.drawSmallImage(g, 154, nso.GameScr.xstart + index6 * indexSize + indexSize / 2, nso.GameScr.ystart + index5 * indexSize + indexSize / 2, 0, 3);
                    g.setColor(12281361);
                    g.drawRect(nso.GameScr.xstart + index6 * indexSize, nso.GameScr.ystart + index5 * indexSize, indexSize, indexSize);
                }
            }
            for (int index7 = 0; index7 < arrItemUpPeal.length; index7++) {
                Item item;
                if ((item = arrItemUpPeal[index7]) != null) {
                    int value8 = index7 / columns;
                    int value9 = index7 - value8 * columns;
                    if (!item.isLock) {
                        g.setColor(4543829);
                        g.fillRect(nso.GameScr.xstart + value9 * indexSize + 1, nso.GameScr.ystart + value8 * indexSize + 1, indexSize - 1, indexSize - 1);
                    }
                    SmallImage.drawSmallImage(g, item.template.iconID, nso.GameScr.xstart + value9 * indexSize + indexSize / 2, nso.GameScr.ystart + value8 * indexSize + indexSize / 2, 0, 3);
                }
            }
            if (indexTitle > 0) {
                int value10 = indexSelect / columns;
                int value11 = indexSelect - value10 * columns;
                g.setColor(16777215);
                g.drawRect(nso.GameScr.xstart + value11 * indexSize, nso.GameScr.ystart + value10 * indexSize, indexSize, indexSize);
            }
            if (effUpok != null) {
                SmallImage.drawSmallImage(g, effUpok.arrEfInfo[indexEff].idImg, nso.GameScr.xstart + indexSize / 2 + effUpok.arrEfInfo[indexEff].dx + 1, nso.GameScr.ystart + indexSize / 2 + 9 + effUpok.arrEfInfo[indexEff].dy, 0, 3);
                if (GameCanvas.gameTick % 2 == 0 && ++indexEff >= effUpok.arrEfInfo.length) {
                    indexEff = 0;
                    effUpok = null;
                    return;
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void paintUILuckySprin(mGraphics g) {
        if (isPaintLuckySpin) {
            resetTranslate(g);
            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
            int value = popupW;
            if (GameCanvas.isTouchControlLargeScreen) {
                value = popupW / 2 + 20;
            }
            g.setColor(0);
            g.fillRect(popupX + 7, popupY + 31, value - 14, popupH - 58);
            g.setColor(-3170504);
            g.drawRect(popupX + 8, popupY + 32, value - 16, popupH - 60);
            g.setColor(Paint.COLORBACKGROUND);
            g.fillRect(popupX + 9, popupY + 33, value - 18, popupH - 62);
            paintTitle(g, mResources.LATQUA, false);
            nso.GameScr.xstart = popupX + 33;
            nso.GameScr.ystart = popupY + 40;
            for (int index = 0; index < 3; index++) {
                for (int index1 = 0; index1 < 3; index1++) {
                    g.setColor(Paint.COLORDARK);
                    g.fillRect(nso.GameScr.xstart + index1 * 40, nso.GameScr.ystart + 10 + index * 40, 29, 29);
                    g.setColor(-6527695);
                    g.drawRect(nso.GameScr.xstart + index1 * 40, nso.GameScr.ystart + 10 + index * 40, 29, 29);
                    g.setColor(-6737152);
                    g.fillRect(nso.GameScr.xstart + index1 * 40 + 2, nso.GameScr.ystart + 12 + index * 40, 26, 26);
                    g.setColor(Paint.COLORDARK);
                    g.fillRect(nso.GameScr.xstart + index1 * 40 + 4, nso.GameScr.ystart + 14 + index * 40, 22, 22);
                    SmallImage.drawSmallImage(g, 1414, nso.GameScr.xstart + index1 * 40 + 20 - 5, nso.GameScr.ystart + index * 40 + 20 + 4, 0, StaticObj.VCENTER_HCENTER);
                }
            }
            for (int index2 = 0; index2 < 9; index2++) {
                int value3;
                int value4;
                mGraphics graphics;
                int value5;
                label73: {
                    value4 = index2 / 3;
                    value3 = index2 - value4 * 3;
                    if (arrItemSprin != null) {
                        g.setColor(-16770791);
                        g.fillRect(nso.GameScr.xstart + value3 * 40 + 4, nso.GameScr.ystart + 14 + value4 * 40, 22, 22);
                        g.setColor(index2 == indexSelect ? -1 : -6527695);
                        g.drawRect(nso.GameScr.xstart + value3 * 40 + 4, nso.GameScr.ystart + 14 + value4 * 40, 21, 21);
                        SmallImage.drawSmallImage(g, 154, nso.GameScr.xstart + value3 * 40 + 17 - 3, nso.GameScr.ystart + 7 + value4 * 40 + 17, 0, 3);
                        if (System.currentTimeMillis() - this.timePoint < 1000L) {
                            if (index2 == indexCard) {
                                SmallImage.drawSmallImage(g, ItemTemplates.getIcon(arrItemSprin[indexCard]), nso.GameScr.xstart + value3 * 40 + 17 - 3, nso.GameScr.ystart + 7 + value4 * 40 + 17, 0, 3);
                            } else {
                                SmallImage.drawSmallImage(g, 1414, nso.GameScr.xstart + value3 * 40 + 17 - 2, nso.GameScr.ystart + 7 + value4 * 40 + 17, 0, StaticObj.VCENTER_HCENTER);
                            }
                        } else {
                            label59: {
                                if (arrItemSprin[index2] >= 0) {
                                    short shortValue = arrItemSprin[index2];
                                    mHashtable mHashtable6 = ItemTemplates.itemTemplates;
                                    if (shortValue < ItemTemplates.itemTemplates.h.size()) {
                                        SmallImage.drawSmallImage(g, ItemTemplates.getIcon(arrItemSprin[index2]), nso.GameScr.xstart + value3 * 40 + 17 - 3, nso.GameScr.ystart + 7 + value4 * 40 + 17, 0, 3);
                                        break label59;
                                    }
                                }
                                SmallImage.drawSmallImage(g, ItemTemplates.getIcon((short) 242), nso.GameScr.xstart + value3 * 40 + 17 - 3, nso.GameScr.ystart + 7 + value4 * 40 + 17, 0, 3);
                            }
                        }
                        if (indexCard == index2 && this.yenTemp > 0) {
                            this.yenValue[index2] = String.valueOf(this.yenTemp);
                        }
                        if (indexTitle != 1) {
                            continue;
                        }
                        if (indexCard == index2 && GameCanvas.gameTick % 10 > 4) {
                            graphics = g;
                            value5 = -3368653;
                            break label73;
                        }
                        if (index2 == indexSelect) {
                            graphics = g;
                            value5 = -1;
                            break label73;
                        }
                        graphics = g;
                    } else {
                        if (indexTitle != 1) {
                            continue;
                        }
                        graphics = g;
                        if (index2 == indexSelect) {
                            value5 = -1;
                            break label73;
                        }
                    }
                    value5 = Paint.COLORLIGHT;
                }
                graphics.setColor(value5);
                g.drawRect(nso.GameScr.xstart + value3 * 40, nso.GameScr.ystart + 10 + value4 * 40, 29, 29);
            }
            mFont.tahoma_7_yellow.drawString(g, mResources.LUOTLATQUA + this.numSprinLeft, popupX + popupW / 2, popupY + popupH - 20, 2);
        }
    }

    private void paintThuoc(mGraphics g) {
        if (nso.GameScr.isPaintStack) {
            if (indexMenu == 0) {
                this.paintItemList(g, mResources.TITLESTACK, nso.GameScr.arrItemStack);
                return;
            }
            if (indexMenu == 1) {
                this.paintBag(g, mResources.TITLESTACK);
            }
        }
    }

    private void paintThuocKhoa(mGraphics g) {
        if (nso.GameScr.isPaintStackLock) {
            if (indexMenu == 0) {
                this.paintItemList(g, mResources.TITLESTACKLOCK, nso.GameScr.arrItemStackLock);
                return;
            }
            if (indexMenu == 1) {
                this.paintBag(g, mResources.TITLESTACKLOCK);
            }
        }
    }

    private void paintTaphoa(mGraphics g) {
        if (nso.GameScr.isPaintGrocery) {
            if (indexMenu == 0) {
                this.paintItemList(g, mResources.TITLEGROCERY, nso.GameScr.arrItemGrocery);
                return;
            }
            if (indexMenu == 1) {
                this.paintBag(g, mResources.TITLEGROCERY);
            }
        }
    }

    private void paintTaphoakhoa(mGraphics g) {
        if (nso.GameScr.isPaintGroceryLock) {
            if (indexMenu == 0) {
                this.paintItemList(g, mResources.TITLEGROCERYLOCK, nso.GameScr.arrItemGroceryLock);
                return;
            }
            if (indexMenu == 1) {
                this.paintBag(g, mResources.TITLEGROCERYLOCK);
            }
        }
    }

    private void paintCuonghoa(mGraphics g) {
        block40: {
            block41: {
                block39: {
                    if (!nso.GameScr.isPaintUpGrade)
                        break block40;
                    if (indexMenu != 0)
                        break block41;
                    Object argument = mResources.TITLEUPGRADE;
                    try {
                        int value;
                        int value1;
                        int value2;
                        int value3;
                        block44: {
                            block42: {
                                int value4;
                                block46: {
                                    block45: {
                                        block43: {
                                            rows = 3;
                                            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
                                            GameScr.paintTitle(g, ((String[]) argument)[indexMenu], ((String[]) argument).length > 1);
                                            nso.GameScr.xstart = popupX + 3;
                                            nso.GameScr.ystart = popupY + 34 + indexSize;
                                            value3 = popupX + 45;
                                            value2 = popupX + 100;
                                            value1 = nso.GameScr.ystart - indexSize - 3;
                                            if (itemUpGrade != null) {
                                                this.paintItem(g, itemUpGrade, value3, value1);
                                                g.setColor(0xBB6611);
                                                g.drawRect(value3, value1, indexSize, indexSize);
                                                mFont.tahoma_7_yellow.drawString(g, "(+" + GameScr.itemUpGrade.upgrade + ")", value3 - 5, value1 + indexSize / 2 - 5, 1);
                                            } else {
                                                g.setColor(6425);
                                                g.fillRect(value3 - 1, value1 - 1, indexSize + 3, indexSize + 3);
                                                SmallImage.drawSmallImage(g, 154, value3 + indexSize / 2, value1 + indexSize / 2, 0, 3);
                                                g.setColor(0xBB6611);
                                                g.drawRect(value3, value1, indexSize, indexSize);
                                            }
                                            SmallImage.drawSmallImage(g, 942, value3 + 43, nso.GameScr.ystart - 15, 0, StaticObj.VCENTER_HCENTER);
                                            if (itemUpGrade != null && !itemUpGrade.isUpMax()) {
                                                this.paintItem(g, itemUpGrade, value2, value1, 1, 0);
                                                g.setColor(0xBB6611);
                                                g.drawRect(value2, value1, indexSize, indexSize);
                                                mFont.tahoma_7_yellow.drawString(g, "(+" + (GameScr.itemUpGrade.upgrade + 1) + ")", value2 + indexSize + 10, value1 + indexSize / 2 - 5, 0);
                                            } else {
                                                g.setColor(6425);
                                                g.fillRect(value2 - 1, value1 - 1, indexSize + 3, indexSize + 3);
                                                SmallImage.drawSmallImage(g, 154, value2 + indexSize / 2, value1 + indexSize / 2, 0, 3);
                                                g.setColor(0xBB6611);
                                                g.drawRect(value2, value1, indexSize, indexSize);
                                            }
                                            if (indexTitle == 1) {
                                                if (indexSelect == 0) {
                                                    g.setColor(0xFFFFFF);
                                                    g.drawRect(value3, value1, indexSize, indexSize);
                                                }
                                                if (indexSelect == 1) {
                                                    g.setColor(0xFFFFFF);
                                                    g.drawRect(value2, value1, indexSize, indexSize);
                                                }
                                            }
                                            if (itemUpGrade == null)
                                                break block42;
                                            if (!itemUpGrade.isUpMax())
                                                break block43;
                                            if (!GameCanvas.isTouchControlLargeScreen) {
                                                mFont.tahoma_7_yellow.drawString(g, mResources.HELPUPGRADE[3], popupX + popupW / 2, nso.GameScr.ystart + rows * indexSize + 5, 2);
                                            } else {
                                                mFont.tahoma_7_yellow.drawString(g, mResources.HELPUPGRADE[3], popupX + 7, nso.GameScr.ystart + rows * indexSize + 5, 0);
                                            }
                                            break block44;
                                        }
                                        value4 = 0;
                                        value2 = 0;
                                        while (value2 < arrItemUpGrade.length) {
                                            if (arrItemUpGrade[value2] != null && GameScr.arrItemUpGrade[value2].template.type == 26) {
                                                value4 += crystals[GameScr.arrItemUpGrade[value2].template.id];
                                            }
                                            ++value2;
                                        }
                                        value = 0;
                                        if (!itemUpGrade.isTypeClothe())
                                            break block45;
                                        value2 = value4 * 100 / nso.GameScr.upClothe[GameScr.itemUpGrade.upgrade];
                                        if (value2 > nso.GameScr.maxPercents[GameScr.itemUpGrade.upgrade]) {
                                            value2 = nso.GameScr.maxPercents[GameScr.itemUpGrade.upgrade];
                                        }
                                        if (isPaintUpGradeGold) {
                                            value2 = (int) ((double) value2 * 1.5);
                                            value = nso.GameScr.goldUps[GameScr.itemUpGrade.upgrade];
                                        }
                                        if (nso.GameScr.coinUpClothes[GameScr.itemUpGrade.upgrade] > Char.getMyChar().xu + Char.getMyChar().yen) {
                                            mFont.tahoma_7_red.drawString(g, mResources.replace(mResources.COINLOCKNEED, NinjaUtil.numberToString(String.valueOf(nso.GameScr.coinUpClothes[GameScr.itemUpGrade.upgrade]))), nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 5, 0);
                                        } else {
                                            mFont.tahoma_7_yellow.drawString(g, mResources.replace(mResources.COINLOCKNEED, NinjaUtil.numberToString(String.valueOf(nso.GameScr.coinUpClothes[GameScr.itemUpGrade.upgrade]))), nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 5, 0);
                                        }
                                        if (value > Char.getMyChar().luong) {
                                            mFont.tahoma_7_red.drawString(g, mResources.replace(mResources.GOLDNEED, String.valueOf(value)), nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 17, 0);
                                        } else {
                                            mFont.tahoma_7_yellow.drawString(g, mResources.replace(mResources.GOLDNEED, String.valueOf(value)), nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 17, 0);
                                        }
                                        mFont.tahoma_7_yellow.drawString(g, String.valueOf(mResources.PERCENT) + ": " + value2 + "%", nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 29, 0);
                                        break block44;
                                    }
                                    if (!itemUpGrade.isTypeAdorn())
                                        break block46;
                                    value2 = value4 * 100 / nso.GameScr.upAdorn[GameScr.itemUpGrade.upgrade];
                                    if (value2 > nso.GameScr.maxPercents[GameScr.itemUpGrade.upgrade]) {
                                        value2 = nso.GameScr.maxPercents[GameScr.itemUpGrade.upgrade];
                                    }
                                    if (isPaintUpGradeGold) {
                                        value2 = (int) ((double) value2 * 1.5);
                                        value = nso.GameScr.goldUps[GameScr.itemUpGrade.upgrade];
                                    }
                                    if (nso.GameScr.coinUpAdorns[GameScr.itemUpGrade.upgrade] > Char.getMyChar().xu + Char.getMyChar().yen) {
                                        mFont.tahoma_7_red.drawString(g, mResources.replace(mResources.COINLOCKNEED, NinjaUtil.numberToString(String.valueOf(nso.GameScr.coinUpAdorns[GameScr.itemUpGrade.upgrade]))), nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 5, 0);
                                    } else {
                                        mFont.tahoma_7_yellow.drawString(g, mResources.replace(mResources.COINLOCKNEED, NinjaUtil.numberToString(String.valueOf(nso.GameScr.coinUpAdorns[GameScr.itemUpGrade.upgrade]))), nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 5, 0);
                                    }
                                    if (value > Char.getMyChar().luong) {
                                        mFont.tahoma_7_red.drawString(g, mResources.replace(mResources.GOLDNEED, String.valueOf(value)), nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 17, 0);
                                    } else {
                                        mFont.tahoma_7_yellow.drawString(g, mResources.replace(mResources.GOLDNEED, String.valueOf(value)), nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 17, 0);
                                    }
                                    mFont.tahoma_7_yellow.drawString(g, String.valueOf(mResources.PERCENT) + ": " + value2 + "%", nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 29, 0);
                                    break block44;
                                }
                                if (!itemUpGrade.isTypeWeapon())
                                    break block44;
                                value2 = value4 * 100 / nso.GameScr.upWeapon[GameScr.itemUpGrade.upgrade];
                                if (value2 > nso.GameScr.maxPercents[GameScr.itemUpGrade.upgrade]) {
                                    value2 = nso.GameScr.maxPercents[GameScr.itemUpGrade.upgrade];
                                }
                                if (isPaintUpGradeGold) {
                                    value2 = (int) ((double) value2 * 1.5);
                                    value = nso.GameScr.goldUps[GameScr.itemUpGrade.upgrade];
                                }
                                if (nso.GameScr.coinUpWeapons[GameScr.itemUpGrade.upgrade] > Char.getMyChar().xu + Char.getMyChar().yen) {
                                    mFont.tahoma_7_red.drawString(g, mResources.replace(mResources.COINLOCKNEED, NinjaUtil.numberToString(String.valueOf(nso.GameScr.coinUpWeapons[GameScr.itemUpGrade.upgrade]))), nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 5, 0);
                                } else {
                                    mFont.tahoma_7_yellow.drawString(g, mResources.replace(mResources.COINLOCKNEED, NinjaUtil.numberToString(String.valueOf(nso.GameScr.coinUpWeapons[GameScr.itemUpGrade.upgrade]))), nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 5, 0);
                                }
                                if (value > Char.getMyChar().luong) {
                                    mFont.tahoma_7_red.drawString(g, mResources.replace(mResources.GOLDNEED, String.valueOf(value)), nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 17, 0);
                                } else {
                                    mFont.tahoma_7_yellow.drawString(g, mResources.replace(mResources.GOLDNEED, String.valueOf(value)), nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 17, 0);
                                }
                                mFont.tahoma_7_yellow.drawString(g, String.valueOf(mResources.PERCENT) + ": " + value2 + "%", nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 29, 0);
                                break block44;
                            }
                            int value5 = 0;
                            while (value5 < 3) {
                                mFont.tahoma_7_white.drawString(g, mResources.HELPUPGRADE[value5], nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 5 + value5 * 12, 0);
                                ++value5;
                            }
                        }
                        g.setColor(0);
                        g.fillRect(nso.GameScr.xstart - 1, nso.GameScr.ystart - 1, columns * indexSize + 3, rows * indexSize + 3);
                        int value6 = 0;
                        while (value6 < rows) {
                            value2 = 0;
                            while (value2 < columns) {
                                SmallImage.drawSmallImage(g, 154, nso.GameScr.xstart + value2 * indexSize + indexSize / 2, nso.GameScr.ystart + value6 * indexSize + indexSize / 2, 0, 3);
                                g.setColor(0xBB6611);
                                g.drawRect(nso.GameScr.xstart + value2 * indexSize, nso.GameScr.ystart + value6 * indexSize, indexSize, indexSize);
                                ++value2;
                            }
                            ++value6;
                        }
                        if (indexTitle == 2) {
                            value6 = indexSelect / columns;
                            value2 = indexSelect - value6 * columns;
                            g.setColor(0xFFFFFF);
                            g.drawRect(nso.GameScr.xstart + value2 * indexSize, nso.GameScr.ystart + value6 * indexSize, indexSize, indexSize);
                        }
                        value6 = 0;
                        while (value6 < arrItemUpGrade.length) {
                            Item item = arrItemUpGrade[value6];
                            if (item != null) {
                                value = value6 / columns;
                                int value7 = value6 - value * columns;
                                if (!item.isLock) {
                                    g.setColor(12083);
                                    g.fillRect(nso.GameScr.xstart + value7 * indexSize + 1, nso.GameScr.ystart + value * indexSize + 1, indexSize - 1, indexSize - 1);
                                }
                                SmallImage.drawSmallImage(g, item.template.iconID, nso.GameScr.xstart + value7 * indexSize + indexSize / 2, nso.GameScr.ystart + value * indexSize + indexSize / 2, 0, 3);
                            }
                            ++value6;
                        }
                        if (effUpok == null)
                            break block39;
                        SmallImage.drawSmallImage(g, GameScr.effUpok.arrEfInfo[GameScr.indexEff].idImg, value3 + indexSize / 2 + GameScr.effUpok.arrEfInfo[GameScr.indexEff].dx + 1, value1 + indexSize / 2 + 9 + GameScr.effUpok.arrEfInfo[GameScr.indexEff].dy, 0, 3);
                        if (GameCanvas.gameTick % 2 != 0 || ++indexEff < GameScr.effUpok.arrEfInfo.length)
                            break block39;
                        indexEff = 0;
                        effUpok = null;
                        break block40;
                    } catch (Exception exception) {
                        argument = exception;
                        exception.printStackTrace();
                    }
                }
                return;
            }
            if (indexMenu == 1) {
                this.paintBag(g, mResources.TITLEUPGRADE);
            }
        }
    }

    private void paintGianHang(mGraphics g) {
        if (nso.GameScr.isPaintAuctionSale) {
            if (indexMenu == 0) {
                String[] textLines = mResources.TITLESTAND;
                g = g;
                try {
                    rows = 5;
                    Paint.paintFrame(popupX, popupY, popupW, popupH, g);
                    this.paintItemFrame(g, textLines, false);
                    g.setColor(6693376);
                    g.fillRect(popupX + 3, popupY + 32, 168, 140);
                    g.setColor(13408563);
                    g.drawRect(popupX + 3, popupY + 32, 168, 140);
                    int value = popupX + 74;
                    int value1 = popupY + 40 + indexSize;
                    mFont.tahoma_7_white.drawString(g, mResources.ITEM_SELL, value + indexSize / 2, value1 - indexSize / 2 - 4, 2);
                    if (itemSell != null) {
                        g.setColor(6425);
                        g.fillRect(value - 1, value1 - 1, indexSize + 3, indexSize + 3);
                        SmallImage.drawSmallImage(g, 154, value + indexSize / 2, value1 + indexSize / 2, 0, 3);
                        this.paintItem(g, itemSell, value, value1);
                        if (itemSell.quantity > 1) {
                            mFont.number_yellow.drawString(g, String.valueOf(itemSell.quantity), value + indexSize, value1 + indexSize / 2 + 6, 1);
                        }
                        g.setColor(indexTitle == 1 ? 16777215 : 12281361);
                        g.drawRect(value, value1, indexSize, indexSize);
                    } else {
                        g.setColor(6425);
                        g.fillRect(value - 1, value1 - 1, indexSize + 3, indexSize + 3);
                        SmallImage.drawSmallImage(g, 154, value + indexSize / 2, value1 + indexSize / 2, 0, 3);
                        g.setColor(12281361);
                        g.drawRect(value, value1, indexSize, indexSize);
                    }
                    mFont.tahoma_7_white.drawString(g, mResources.MONEY_SELL, value + indexSize / 2, value1 + 3 * indexSize / 2 + 2, 2);
                    if (Char.getMyChar().xu < 5000) {
                        mFont.tahoma_7_red.drawString(g, mResources.SALENEED, value + indexSize / 2, popupY + popupH - 25, 2);
                        mFont.tahoma_7_red.drawString(g, mResources.SALETAX, value + indexSize / 2, popupY + popupH - 13, 2);
                    } else {
                        mFont.tahoma_7_white.drawString(g, mResources.SALENEED, value + indexSize / 2, popupY + popupH - 25, 2);
                        mFont.tahoma_7_white.drawString(g, mResources.SALETAX, value + indexSize / 2, popupY + popupH - 13, 2);
                    }
                    this.tfText.x = popupX + 40;
                    this.tfText.y = popupY + 130;
                    this.tfText.paint(g);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else {
                if (indexMenu == 1) {
                    this.paintBag(g, mResources.TITLESTAND);
                }
            }
        }
    }

    private void paintChuyenHoa(mGraphics g) {
        block18: {
            if (nso.GameScr.isPaintConvert) {
                if (indexMenu == 0) {
                    block17: {
                        Object argument = mResources.TITLECONVERT;
                        try {
                            rows = 3;
                            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
                            GameScr.paintTitle(g, ((String[]) argument)[indexMenu], ((String[]) argument).length > 1);
                            nso.GameScr.xstart = popupX + 3;
                            nso.GameScr.ystart = popupY + 34 + indexSize;
                            int value = popupX + 45;
                            int value1 = popupX + 100;
                            int value2 = nso.GameScr.ystart - indexSize - 3;
                            if (arrItemConvert[0] != null) {
                                this.paintItem(g, arrItemConvert[0], value, value2);
                                g.setColor(0xBB6611);
                                g.drawRect(value, value2, indexSize, indexSize);
                                mFont.tahoma_7_yellow.drawString(g, "(+" + GameScr.arrItemConvert[0].upgrade + ")", value - 5, value2 + indexSize / 2 - 5, 1);
                            } else {
                                g.setColor(6425);
                                g.fillRect(value - 1, value2 - 1, indexSize + 3, indexSize + 3);
                                SmallImage.drawSmallImage(g, 154, value + indexSize / 2, value2 + indexSize / 2, 0, 3);
                                g.setColor(0xBB6611);
                                g.drawRect(value, value2, indexSize, indexSize);
                            }
                            SmallImage.drawSmallImage(g, 942, value + 43, nso.GameScr.ystart - 15, 0, StaticObj.VCENTER_HCENTER);
                            if (arrItemConvert[1] != null) {
                                Item item = arrItemConvert[1].clone();
                                if (arrItemConvert[0] != null && GameScr.arrItemConvert[0].template.type == item.template.type && GameScr.arrItemConvert[1].template.level >= GameScr.arrItemConvert[0].template.level) {
                                    item.upgrade = GameScr.arrItemConvert[0].upgrade;
                                }
                                this.paintItem(g, item, value1, value2);
                                g.setColor(0xBB6611);
                                g.drawRect(value1, value2, indexSize, indexSize);
                                mFont.tahoma_7_yellow.drawString(g, "(+" + item.upgrade + ")", value1 + indexSize + 10, value2 + indexSize / 2 - 5, 0);
                            } else {
                                g.setColor(6425);
                                g.fillRect(value1 - 1, value2 - 1, indexSize + 3, indexSize + 3);
                                SmallImage.drawSmallImage(g, 154, value1 + indexSize / 2, value2 + indexSize / 2, 0, 3);
                                g.setColor(0xBB6611);
                                g.drawRect(value1, value2, indexSize, indexSize);
                            }
                            if (indexTitle == 1) {
                                if (indexSelect == 0) {
                                    g.setColor(0xFFFFFF);
                                    g.drawRect(value, value2, indexSize, indexSize);
                                }
                                if (indexSelect == 1) {
                                    g.setColor(0xFFFFFF);
                                    g.drawRect(value1, value2, indexSize, indexSize);
                                }
                            }
                            g.setColor(0);
                            g.fillRect(nso.GameScr.xstart - 1, nso.GameScr.ystart - 1, columns * indexSize + 3, rows * indexSize + 3);
                            int value3 = 0;
                            while (value3 < rows) {
                                int value4 = 0;
                                while (value4 < columns) {
                                    SmallImage.drawSmallImage(g, 154, nso.GameScr.xstart + value4 * indexSize + indexSize / 2, nso.GameScr.ystart + value3 * indexSize + indexSize / 2, 0, 3);
                                    g.setColor(0xBB6611);
                                    g.drawRect(nso.GameScr.xstart + value4 * indexSize, nso.GameScr.ystart + value3 * indexSize, indexSize, indexSize);
                                    ++value4;
                                }
                                ++value3;
                            }
                            Item item5 = arrItemConvert[2];
                            if (item5 != null) {
                                int value6 = 0 / columns;
                                value = 0 - value6 * columns;
                                if (!item5.isLock) {
                                    g.setColor(12083);
                                    g.fillRect(nso.GameScr.xstart + value * indexSize + 1, nso.GameScr.ystart + value6 * indexSize + 1, indexSize - 1, indexSize - 1);
                                }
                                SmallImage.drawSmallImage(g, item5.template.iconID, nso.GameScr.xstart + value * indexSize + indexSize / 2, nso.GameScr.ystart + value6 * indexSize + indexSize / 2, 0, 3);
                            }
                            mFont.tahoma_7_white.drawString(g, "- " + mResources.UPGRADE_CONDITION[0], nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 10, 0);
                            mFont.tahoma_7_white.drawString(g, "  " + mResources.UPGRADE_CONDITION[1], nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 22, 0);
                            mFont.tahoma_7_white.drawString(g, "- " + mResources.UPGRADE_CONDITION[2], nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 34, 0);
                            if (indexTitle != 2)
                                break block17;
                            int value7 = indexSelect / columns;
                            value = indexSelect - value7 * columns;
                            g.setColor(0xFFFFFF);
                            g.drawRect(nso.GameScr.xstart + value * indexSize, nso.GameScr.ystart + value7 * indexSize, indexSize, indexSize);
                            break block18;
                        } catch (Exception exception) {
                            argument = exception;
                            exception.printStackTrace();
                        }
                    }
                    return;
                }
                if (indexMenu == 1) {
                    this.paintBag(g, mResources.TITLEUPGRADE);
                }
            }
        }
    }

    private void paintTachHT(mGraphics g) {
        if (nso.GameScr.isPaintSplit) {
            if (indexMenu == 0) {
                this.paintSplit(g, mResources.TITLESPLIT);
                return;
            }
            if (indexMenu == 1) {
                this.paintBag(g, mResources.TITLESPLIT);
            }
        }
    }

    private void paintLuyenThu(mGraphics g) {
        if (nso.GameScr.isPaintDichChuyen) {
            if (indexMenu == 0) {
                this.paintSplit(g, mResources.TITLELUYENTHU);
                return;
            }
            if (indexMenu == 1) {
                this.paintBag(g, mResources.TITLELUYENTHU);
            }
        }
    }

    private void paintLuyenAo(mGraphics g) {
        if (nso.GameScr.isPaintTinhluyen) {
            if (indexMenu == 0) {
                this.paintSplit(g, mResources.TITLELUYENAO);
                return;
            }
            if (indexMenu == 1) {
                this.paintBag(g, mResources.TITLELUYENAO);
            }
        }
    }

    private void paintItemTrade(mGraphics g) {
        block42: {
            if (isPaintTrade) {
                if (indexMenu == 0) {
                    block43: {
                        Object argument = mResources.TITLETRADE;
                        try {
                            int value;
                            int value1;
                            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
                            GameScr.paintTitle(g, ((String[]) argument)[indexMenu], ((String[]) argument).length > 1);
                            nso.GameScr.xstart = popupX + 3;
                            nso.GameScr.ystart = popupY + 45;
                            rows = 4;
                            mFont.tahoma_7_yellow.drawString(g, Char.getMyChar().cName, nso.GameScr.xstart + 1, nso.GameScr.ystart - 12, 0);
                            int value2 = nso.GameScr.xstart;
                            int value3 = 0;
                            while (value3 < 3) {
                                if (value3 == this.typeTrade) {
                                    mFont.tahoma_7_blue1.drawString(g, String.valueOf(value3 + 1), value2 + 2 + value3 * 20, nso.GameScr.ystart + rows * (indexSize + 3) + 8, 0);
                                } else {
                                    mFont.tahoma_7_grey.drawString(g, String.valueOf(value3 + 1), value2 + 2 + value3 * 20, nso.GameScr.ystart + rows * (indexSize + 3) + 8, 0);
                                }
                                if (value3 < 2) {
                                    SmallImage.drawSmallImage(g, 942, value2 + 14 + value3 * 20, nso.GameScr.ystart + rows * (indexSize + 3) + 13, 0, StaticObj.VCENTER_HCENTER);
                                }
                                ++value3;
                            }
                            mFont.tahoma_7_white.drawString(g, String.valueOf(NinjaUtil.numberToString(String.valueOf(this.coinTrade))) + " " + mResources.XU, nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 4, 0);
                            if (this.typeTrade == 0) {
                                g.setColor(0);
                            }
                            if (this.typeTrade == 1) {
                                g.setColor(210986);
                            }
                            if (this.typeTrade == 2) {
                                g.setColor(805690);
                            }
                            g.fillRect(nso.GameScr.xstart - 1, nso.GameScr.ystart - 1, indexSize * 3 + 3, (indexSize << 2) + 3);
                            value3 = 0;
                            while (value3 < rows) {
                                value2 = 0;
                                while (value2 < 3) {
                                    SmallImage.drawSmallImage(g, 154, nso.GameScr.xstart + value2 * indexSize + indexSize / 2, nso.GameScr.ystart + value3 * indexSize + indexSize / 2, 0, 3);
                                    g.setColor(0xBB6611);
                                    g.drawRect(nso.GameScr.xstart + value2 * indexSize, nso.GameScr.ystart + value3 * indexSize, indexSize, indexSize);
                                    ++value2;
                                }
                                ++value3;
                            }
                            if (indexTitle == 1) {
                                value3 = indexSelect / 3;
                                value2 = indexSelect - value3 * 3;
                                g.setColor(0xFFFFFF);
                                g.drawRect(nso.GameScr.xstart + value2 * indexSize, nso.GameScr.ystart + value3 * indexSize, indexSize, indexSize);
                            }
                            if (arrItemTradeMe != null) {
                                value3 = 0;
                                while (value3 < arrItemTradeMe.length) {
                                    Item item = arrItemTradeMe[value3];
                                    if (item != null) {
                                        value1 = value3 / 3;
                                        value = value3 - value1 * 3;
                                        if (!item.isLock) {
                                            g.setColor(12083);
                                            g.fillRect(nso.GameScr.xstart + value * indexSize + 1, nso.GameScr.ystart + value1 * indexSize + 1, indexSize - 1, indexSize - 1);
                                        }
                                        if (GameCanvas.gameTick % 6 == 0) {
                                            item.indexFrame = (item.indexFrame + 1) % 3;
                                        }
                                        if (item.isNewitem()) {
                                            g.drawImage(GameCanvas.backitem, nso.GameScr.xstart + value * indexSize + indexSize / 2, nso.GameScr.ystart + value1 * indexSize + indexSize / 2, 3);
                                        }
                                        SmallImage.drawSmallImageNew(g, item.template.iconID, nso.GameScr.xstart + value * indexSize + indexSize / 2, nso.GameScr.ystart + value1 * indexSize + indexSize / 2, 0, 3, item.indexFrame);
                                        if (item.quantity > 1) {
                                            mFont.number_yellow.drawString(g, String.valueOf(item.quantity), nso.GameScr.xstart + value * indexSize + indexSize, nso.GameScr.ystart + value1 * indexSize + indexSize - mFont.number_yellow.getHeight(), 1);
                                        }
                                        if (item.quantity > 1) {
                                            mFont.number_yellow.drawString(g, String.valueOf(item.quantity), nso.GameScr.xstart + value * indexSize + indexSize, nso.GameScr.ystart + value1 * indexSize + indexSize - mFont.number_yellow.getHeight(), 1);
                                        }
                                    }
                                    ++value3;
                                }
                            }
                            nso.GameScr.xstart = popupX + popupW - 2 - indexSize * 3;
                            rows = 4;
                            mFont.tahoma_7_yellow.drawString(g, this.tradeName, popupX + popupW - 2, nso.GameScr.ystart - 12, 1);
                            int value4 = popupX + popupW - 3 - 60;
                            value3 = 0;
                            while (value3 < 3) {
                                if (value3 == this.typeTradeOrder) {
                                    mFont.tahoma_7_blue1.drawString(g, String.valueOf(value3 + 1), value4 + 2 + value3 * 20, nso.GameScr.ystart + rows * (indexSize + 3) + 8, 0);
                                } else {
                                    mFont.tahoma_7_grey.drawString(g, String.valueOf(value3 + 1), value4 + 2 + value3 * 20, nso.GameScr.ystart + rows * (indexSize + 3) + 8, 0);
                                }
                                if (value3 < 2) {
                                    SmallImage.drawSmallImage(g, 942, value4 + 14 + value3 * 20, nso.GameScr.ystart + rows * (indexSize + 3) + 13, 0, StaticObj.VCENTER_HCENTER);
                                }
                                ++value3;
                            }
                            mFont.tahoma_7_white.drawString(g, String.valueOf(NinjaUtil.numberToString(String.valueOf(this.coinTradeOrder))) + " " + mResources.XU, popupX + popupW - 2, nso.GameScr.ystart + rows * indexSize + 4, 1);
                            if (this.typeTradeOrder == 0) {
                                g.setColor(0);
                            }
                            if (this.typeTradeOrder == 1) {
                                g.setColor(210986);
                            }
                            if (this.typeTradeOrder == 2) {
                                g.setColor(805690);
                            }
                            g.fillRect(nso.GameScr.xstart - 1, nso.GameScr.ystart - 1, indexSize * 3 + 3, (indexSize << 2) + 3);
                            value3 = 0;
                            while (value3 < rows) {
                                value4 = 0;
                                while (value4 < 3) {
                                    SmallImage.drawSmallImage(g, 154, nso.GameScr.xstart + value4 * indexSize + indexSize / 2, nso.GameScr.ystart + value3 * indexSize + indexSize / 2, 0, 3);
                                    g.setColor(0xBB6611);
                                    g.drawRect(nso.GameScr.xstart + value4 * indexSize, nso.GameScr.ystart + value3 * indexSize, indexSize, indexSize);
                                    ++value4;
                                }
                                ++value3;
                            }
                            if (indexTitle == 2) {
                                value3 = indexSelect / 3;
                                value4 = indexSelect - value3 * 3;
                                g.setColor(0xFFFFFF);
                                g.drawRect(nso.GameScr.xstart + value4 * indexSize, nso.GameScr.ystart + value3 * indexSize, indexSize, indexSize);
                            }
                            if (arrItemTradeOrder != null) {
                                value3 = 0;
                                while (value3 < arrItemTradeOrder.length) {
                                    Item item5 = arrItemTradeOrder[value3];
                                    if (item5 != null) {
                                        value1 = value3 / 3;
                                        value = value3 - value1 * 3;
                                        if (!item5.isLock) {
                                            g.setColor(12083);
                                            g.fillRect(nso.GameScr.xstart + value * indexSize + 1, nso.GameScr.ystart + value1 * indexSize + 1, indexSize - 1, indexSize - 1);
                                        }
                                        if (GameCanvas.gameTick % 6 == 0) {
                                            item5.indexFrame = (item5.indexFrame + 1) % 3;
                                        }
                                        if (item5.isNewitem()) {
                                            g.drawImage(GameCanvas.backitem, nso.GameScr.xstart + value * indexSize + indexSize / 2, nso.GameScr.ystart + value1 * indexSize + indexSize / 2, 3);
                                        }
                                        SmallImage.drawSmallImageNew(g, item5.template.iconID, nso.GameScr.xstart + value * indexSize + indexSize / 2, nso.GameScr.ystart + value1 * indexSize + indexSize / 2, 0, 3, item5.indexFrame);
                                        if (item5.quantity > 1) {
                                            mFont.number_yellow.drawString(g, String.valueOf(item5.quantity), nso.GameScr.xstart + value * indexSize + indexSize, nso.GameScr.ystart + value1 * indexSize + indexSize - mFont.number_yellow.getHeight(), 1);
                                        }
                                        if (item5.quantity > 1) {
                                            mFont.number_yellow.drawString(g, String.valueOf(item5.quantity), nso.GameScr.xstart + value * indexSize + indexSize, nso.GameScr.ystart + value1 * indexSize + indexSize - mFont.number_yellow.getHeight(), 1);
                                        }
                                    }
                                    ++value3;
                                }
                            }
                            if (this.timeTrade - (value3 = (int) (System.currentTimeMillis() / 1000L)) > 0 && this.typeTrade == 1 && this.typeTradeOrder == 1) {
                                mFont.tahoma_7_white.drawString(g, String.valueOf(mResources.WAIT) + " " + (this.timeTrade - value3) + " " + mResources.SECOND, popupX + popupW / 2, popupY + popupH - 13, 2);
                                break block42;
                            }
                            if (this.typeTrade != 0)
                                break block43;
                            mFont.tahoma_7_white.drawString(g, mResources.TRADEHELP, popupX + popupW / 2, popupY + popupH - 13, 2);
                            break block42;
                        } catch (Exception exception) {
                            argument = exception;
                            exception.printStackTrace();
                        }
                    }
                    return;
                }
                if (indexMenu == 1) {
                    this.paintBag(g, mResources.TITLETRADE);
                }
            }
        }
    }

    private void paintGhepngoc(mGraphics g) {
        if (nso.GameScr.isPaintUpPearl) {
            if (indexMenu == 0) {
                this.paintUpPearl(g, mResources.TITLEUPPEARL);
                return;
            }
            if (indexMenu == 1) {
                this.paintBag(g, mResources.TITLEUPPEARL);
            }
        }
    }

    private void paintLuyenThach(mGraphics g) {
        if (nso.GameScr.isPaintLuyenThach) {
            if (indexMenu == 0) {
                this.paintUpPearl(g, mResources.TITLELUYENTHACH);
                return;
            }
            if (indexMenu == 1) {
                this.paintBag(g, mResources.TITLELUYENTHACH);
            }
        }
    }

    private void paintRuong(mGraphics g) {
        if (nso.GameScr.isPaintBox) {
            if (indexMenu == 0) {
                String[] textLines = mResources.TITLEBOX;
                g = g;
                try {
                    resetTranslate(g);
                    this.paintItemFrame(g, textLines, false);
                    if (Char.getMyChar().arrItemBox == null) {
                        GameCanvas.paintShukiren(popupX + 90, popupY + 75, g, false);
                        mFont.tahoma_7b_white.drawString(g, mResources.PLEASEWAIT, popupX + 90, popupY + 90, 2);
                    } else {
                        mFont.tahoma_7_white.drawString(g, mResources.XUINBAG + ": " + NinjaUtil.numberToString(String.valueOf(Char.getMyChar().xuInBox)), popupX + popupW / 2, popupY + popupH - 18, 2);
                        this.paintBagItem(g, Char.getMyChar().arrItemBox);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else {
                if (indexMenu == 1) {
                    this.paintBag(g, mResources.TITLEBOX);
                }
            }
        }
    }

    private void paintTiemNang(mGraphics g) {
        if (indexMenu == 2) {
            g.translate(-g.getTranslateX(), -g.getTranslateY());
            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
            paintTitle(g, mResources.MENUME[indexMenu], true);
            mFont.tahoma_8b.drawString(g, mResources.POTENTIAL_POINT, popupX + 10, popupY + 33, 0);
            mFont.tahoma_8b.drawString(g, "" + Char.getMyChar().pPoint, popupX + popupW - 10, popupY + 33, 1);
            int value = (popupH - 80) / 5;
            for (int index = 0; index < Char.getMyChar().potential.length; index++) {
                g.setColor(Paint.COLORBORDER);
                if (indexTitle > 0 && indexTitle - 1 == index) {
                    g.setColor(Paint.COLORDARK);
                    g.fillRect(popupX + 5, popupY + 52 + index * (value + 4), popupW - 10, value);
                    g.setColor(Paint.COLORFOCUS);
                }
                g.drawRect(popupX + 5, popupY + 52 + index * (value + 4), popupW - 10, value);
                mFont.tahoma_7b_white.drawString(g, "" + Char.getMyChar().potential[index], popupX + popupW - 10, popupY + 52 + (value - 10) / 2 + index * (value + 4), 1);
                mFont.tahoma_7b_white.drawString(g, mResources.NAMEPOTENTIAL[index], popupX + 10, popupY + 52 + (value - 10) / 2 + index * (value + 4), 0);
            }
            if (indexTitle > 0) {
                switch(Char.getMyChar().nClass.classId) {
                    case 0:
                        mFont.tahoma_7_green.drawString(g, mResources.HELPPOTENTIAL1[0], popupX + 10, popupY + 52 + (value - 10) / 2 + 4 * (value + 4), 0);
                        return;
                    case 1:
                    case 3:
                    case 5:
                        mFont.tahoma_7_green.drawString(g, mResources.HELPPOTENTIAL2[indexTitle - 1], popupX + 10, popupY + 52 + (value - 10) / 2 + 4 * (value + 4), 0);
                        return;
                    case 2:
                    case 4:
                    case 6:
                        mFont.tahoma_7_green.drawString(g, mResources.HELPPOTENTIAL3[indexTitle - 1], popupX + 10, popupY + 52 + (value - 10) / 2 + 4 * (value + 4), 0);
                }
            }
        }
    }

    private static Item getItemFocus(int typeUI) {
        try {
            if (indexSelect < 0) {
                return null;
            }
            switch(typeUI) {
                case 2:
                    if (nso.GameScr.arrItemWeapon.length > indexSelect) {
                        return nso.GameScr.arrItemWeapon[indexSelect];
                    }
                    return null;
                case 3:
                    return Char.getMyChar().arrItemBag[indexSelect];
                case 4:
                    return Char.getMyChar().arrItemBox[indexSelect];
                case 5:
                    return currentCharViewInfo.arrItemBody[indexSelect + indextabTrangbi];
                case 6:
                    if (nso.GameScr.arrItemStack.length > indexSelect) {
                        return nso.GameScr.arrItemStack[indexSelect];
                    }
                    return null;
                case 7:
                    if (nso.GameScr.arrItemStackLock.length > indexSelect) {
                        return nso.GameScr.arrItemStackLock[indexSelect];
                    }
                    return null;
                case 8:
                    if (nso.GameScr.arrItemGrocery.length > indexSelect) {
                        return nso.GameScr.arrItemGrocery[indexSelect];
                    }
                    return null;
                case 9:
                    if (nso.GameScr.arrItemGroceryLock.length > indexSelect) {
                        return nso.GameScr.arrItemGroceryLock[indexSelect];
                    }
                    return null;
                case 10:
                    return arrItemUpGrade[indexSelect];
                case 11:
                    return arrItemUpPeal[indexSelect];
                case 12:
                case 13:
                case 30:
                case 31:
                case 33:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 49:
                case 50:
                case 51:
                default:
                    break;
                case 14:
                    if (nso.GameScr.arrItemStore.length > indexSelect) {
                        return nso.GameScr.arrItemStore[indexSelect];
                    }
                    return null;
                case 15:
                    if (nso.GameScr.arrItemBook.length > indexSelect) {
                        return nso.GameScr.arrItemBook[indexSelect];
                    }
                    return null;
                case 16:
                    if (nso.GameScr.arrItemLien.length > indexSelect) {
                        return nso.GameScr.arrItemLien[indexSelect];
                    }
                    return null;
                case 17:
                    if (nso.GameScr.arrItemNhan.length > indexSelect) {
                        return nso.GameScr.arrItemNhan[indexSelect];
                    }
                    return null;
                case 18:
                    if (nso.GameScr.arrItemNgocBoi.length > indexSelect) {
                        return nso.GameScr.arrItemNgocBoi[indexSelect];
                    }
                    return null;
                case 19:
                    if (nso.GameScr.arrItemPhu.length > indexSelect) {
                        return nso.GameScr.arrItemPhu[indexSelect];
                    }
                    return null;
                case 20:
                    if (nso.GameScr.arrItemNonNam.length > indexSelect) {
                        return nso.GameScr.arrItemNonNam[indexSelect];
                    }
                    return null;
                case 21:
                    if (nso.GameScr.arrItemNonNu.length > indexSelect) {
                        return nso.GameScr.arrItemNonNu[indexSelect];
                    }
                    return null;
                case 22:
                    if (nso.GameScr.arrItemAoNam.length > indexSelect) {
                        return nso.GameScr.arrItemAoNam[indexSelect];
                    }
                    return null;
                case 23:
                    if (nso.GameScr.arrItemAoNu.length > indexSelect) {
                        return nso.GameScr.arrItemAoNu[indexSelect];
                    }
                    return null;
                case 24:
                    if (nso.GameScr.arrItemGangTayNam.length > indexSelect) {
                        return nso.GameScr.arrItemGangTayNam[indexSelect];
                    }
                    return null;
                case 25:
                    if (nso.GameScr.arrItemGangTayNu.length > indexSelect) {
                        return nso.GameScr.arrItemGangTayNu[indexSelect];
                    }
                    return null;
                case 26:
                    if (nso.GameScr.arrItemQuanNam.length > indexSelect) {
                        return nso.GameScr.arrItemQuanNam[indexSelect];
                    }
                    return null;
                case 27:
                    if (nso.GameScr.arrItemQuanNu.length > indexSelect) {
                        return nso.GameScr.arrItemQuanNu[indexSelect];
                    }
                    return null;
                case 28:
                    if (nso.GameScr.arrItemGiayNam.length > indexSelect) {
                        return nso.GameScr.arrItemGiayNam[indexSelect];
                    }
                    return null;
                case 29:
                    if (nso.GameScr.arrItemGiayNu.length > indexSelect) {
                        return nso.GameScr.arrItemGiayNu[indexSelect];
                    }
                    return null;
                case 32:
                    if (nso.GameScr.arrItemFashion.length > indexSelect) {
                        return nso.GameScr.arrItemFashion[indexSelect];
                    }
                    return null;
                case 34:
                    if (nso.GameScr.arrItemClanShop.length > indexSelect) {
                        return nso.GameScr.arrItemClanShop[indexSelect];
                    }
                    return null;
                case 35:
                    if (nso.GameScr.arrItemElites.length > indexSelect) {
                        return nso.GameScr.arrItemElites[indexSelect];
                    }
                    return null;
                case 43:
                    return arrItemUpPeal[indexSelect];
                case 44:
                    return arrItemSplit[indexSelect];
                case 45:
                    return arrItemSplit[indexSelect];
                case 46:
                    return arrItemSplit[indexSelect];
                case 47:
                    return arrItemUpGrade[indexSelect];
                case 48:
                    return arrItemSplit[indexSelect];
                case 52:
                    if (nso.GameScr.arrItemFashion.length > indexSelect) {
                        return nso.GameScr.arrItemFashion[indexSelect];
                    }
                    return null;
            }
        } catch (Exception exception) {
        }
        return null;
    }

    public static void loadImg() {
        TileMap.loadTileImage();
    }

    private static void paintTitle(mGraphics g, String title, boolean arrow) {
        int value = 0;
        if (!nso.GameScr.svTitle.equals("")) {
            title = nso.GameScr.svTitle;
        }
        value = nso.GameScr.gW / 2;
        g.setColor(Paint.COLORDARK);
        g.fillRoundRect(value - mFont.tahoma_8b.getWidth(title) / 2 - 12, popupY + 4, mFont.tahoma_8b.getWidth(title) + 22, 24, 6, 6);
        if ((indexTitle == 0 || GameCanvas.isTouch) && arrow) {
            SmallImage.drawSmallImage(g, 989, value - mFont.tahoma_8b.getWidth(title) / 2 - 15 - 7 - (GameCanvas.gameTick % 8 <= 3 ? 2 : 0), popupY + 16, 2, StaticObj.VCENTER_HCENTER);
            SmallImage.drawSmallImage(g, 989, value + mFont.tahoma_8b.getWidth(title) / 2 + 15 + 5 + (GameCanvas.gameTick % 8 <= 3 ? 2 : 0), popupY + 16, 0, StaticObj.VCENTER_HCENTER);
        }
        if (indexTitle == 0) {
            g.setColor(Paint.COLORFOCUS);
        } else {
            g.setColor(Paint.COLORBORDER);
        }
        g.drawRoundRect(value - mFont.tahoma_8b.getWidth(title) / 2 - 12, popupY + 4, mFont.tahoma_8b.getWidth(title) + 22, 24, 6, 6);
        mFont.tahoma_8b.drawString(g, title, value, popupY + 9, 2);
    }

    private void paintZone(mGraphics g) {
        if (isPaintZone) {
            resetTranslate(g);
            this.paintItemFrame(g, new String[] { mResources.ZONE }, false);
            mFont.tahoma_7_yellow.drawString(g, TileMap.mapName, popupX + popupW / 2, popupY + popupH - 25, 2);
            if (indexSelect >= 0 && indexSelect < this.zones.length) {
                mFont.tahoma_7_white.drawString(g, mResources.POPULATION + ": " + this.zones[indexSelect] + ", " + mResources.PARTY + ": " + this.pts[indexSelect], popupX + popupW / 2, popupY + popupH - 13, 2);
            }
            int value = indexSelect / this.zoneCol;
            int value1 = indexSelect % this.zoneCol;
            rows = this.zones.length / this.zoneCol;
            if (this.zones.length % this.zoneCol > 0) {
                rows++;
            }
            if (rows < 5) {
                rows = 5;
            }
            scrMain.setStyle(rows, indexSize, nso.GameScr.xstart, nso.GameScr.ystart, columns * indexSize + 2, 5 * indexSize + 2, true, 6);
            scrMain.setClip(g);
            int value2 = 0;
            for (int index = 0; index < rows; index++) {
                for (int index3 = 0; index3 < this.zoneCol; index3++) {
                    g.setColor(12281361);
                    g.drawRect(nso.GameScr.xstart + index3 * indexSize, nso.GameScr.ystart + index * indexSize, indexSize, indexSize);
                    if (value2 < this.zones.length) {
                        SmallImage.drawSmallImage(g, 154, nso.GameScr.xstart + index3 * indexSize + indexSize / 2, nso.GameScr.ystart + index * indexSize + indexSize / 2, 0, 3);
                        if (this.zones[value2] >= 20) {
                            mFont.tahoma_7b_red.drawString(g, "" + value2, nso.GameScr.xstart + index3 * indexSize + indexSize / 2, nso.GameScr.ystart + index * indexSize + indexSize / 2 - 4, 2);
                        } else if (this.zones[value2] >= 15) {
                            mFont.tahoma_7b_yellow.drawString(g, "" + value2, nso.GameScr.xstart + index3 * indexSize + indexSize / 2, nso.GameScr.ystart + index * indexSize + indexSize / 2 - 4, 2);
                        } else {
                            mFont.tahoma_7b_white.drawString(g, "" + value2, nso.GameScr.xstart + index3 * indexSize + indexSize / 2, nso.GameScr.ystart + index * indexSize + indexSize / 2 - 4, 2);
                        }
                        value2++;
                    }
                }
            }
            if (indexSelect >= 0) {
                g.setColor(16777215);
                g.drawRect(nso.GameScr.xstart + value1 * indexSize, nso.GameScr.ystart + value * indexSize, indexSize, indexSize);
            }
        }
    }

    private static void upPearl() {
        int value = 0;
        int value1 = 0;
        boolean flag = false;
        boolean flag2 = false;
        for (int index = 0; index < arrItemUpPeal.length; index++) {
            if (arrItemUpPeal[index] != null) {
                value++;
                value1 += crystals[arrItemUpPeal[index].template.id];
                if (arrItemUpPeal[index].template.id == 11) {
                    GameCanvas.msgdlg.setInfo(mResources.UP_MAX, null, new Command(mResources.CLOSE, 1), null);
                    MsgDlg msgDlg = GameCanvas.msgdlg;
                    GameCanvas.currentDialog = GameCanvas.msgdlg;
                    return;
                }
            }
            if (arrItemUpPeal[index] != null && arrItemUpPeal[index].isLock) {
                flag = true;
            }
            if (arrItemUpPeal[index] != null && !arrItemUpPeal[index].isLock) {
                flag2 = true;
            }
        }
        if (value <= 1) {
            GameCanvas.msgdlg.setInfo(mResources.NOT_ENOUGH_UPPEARL, null, new Command(mResources.CLOSE, 1), null);
            MsgDlg msgDlg3 = GameCanvas.msgdlg;
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        } else {
            int value4 = crystals.length - 1;
            while (value4 >= 0 && value1 <= crystals[value4]) {
                value4--;
            }
            if (value4 >= crystals.length - 1) {
                value4 = crystals.length - 2;
            }
            if (isTypeXu) {
                if (nso.GameScr.coinUpCrystals[value4 + 1] > Char.getMyChar().xu) {
                    GameCanvas.msgdlg.setInfo(mResources.NOT_ENOUGH_COIN_UPPEARL, null, new Command(mResources.CLOSE, 1), null);
                    MsgDlg msgDlg5 = GameCanvas.msgdlg;
                    GameCanvas.currentDialog = GameCanvas.msgdlg;
                } else if (flag) {
                    GameCanvas.startYesNoDlg(mResources.CONFIRMUPPEARL, 88813, arrItemUpPeal, 8882, null);
                } else {
                    Service.gI().crystalCollect(arrItemUpPeal);
                }
            } else if (nso.GameScr.coinUpCrystals[value4 + 1] > Char.getMyChar().xu + Char.getMyChar().yen) {
                GameCanvas.msgdlg.setInfo(mResources.NOT_ENOUGH_COIN_UPPEARL, null, new Command(mResources.CLOSE, 1), null);
                MsgDlg msgDlg6 = GameCanvas.msgdlg;
                GameCanvas.currentDialog = GameCanvas.msgdlg;
            } else if (flag2) {
                GameCanvas.startYesNoDlg(mResources.CONFIRMUPPEARL, 88814, arrItemUpPeal, 8882, null);
            } else {
                Service.gI().crystalCollectLock(arrItemUpPeal);
            }
        }
    }

    private static void doLuyenThach() {
        int value = 0;
        int value1 = 0;
        int value2 = 0;
        short shortValue = 0;
        for (int index = 0; index < arrItemUpPeal.length; index++) {
            Item item;
            if ((item = arrItemUpPeal[index]) != null) {
                if (item.template.id == 455) {
                    value++;
                } else if (item.template.id == 456) {
                    value1++;
                } else if (item.template.type == 26) {
                    value2++;
                    shortValue = item.template.id;
                }
            }
        }
        if (value2 > 1) {
            GameCanvas.startOKDlg(mResources.ONLY_LUYENTHACH3);
        } else if (value <= 9 && value1 <= 9 && (shortValue < 10 || value <= 3 && value1 <= 3)) {
            if (value + value1 < 3) {
                GameCanvas.startOKDlg(mResources.NOT_ENOUGH_LUYENTHACH1);
            } else if ((shortValue != 10 || value1 != 3) && (shortValue != 11 || value != 3)) {
                Service.gI().luyenthach(arrItemUpPeal);
            } else {
                GameCanvas.startOKDlg(mResources.ONLY_LUYENTHACH4);
            }
        } else {
            GameCanvas.startOKDlg(mResources.MAX_LUYENTHACH1);
        }
    }

    public static byte getTaskMapId() {
        if (Char.getMyChar().ctaskId >= nso.GameScr.tasks.length) {
            return -3;
        }
        byte byteValue = 0;
        if (Char.getMyChar().taskMaint == null) {
            byteValue = nso.GameScr.mapTasks[Char.getMyChar().ctaskId][0];
        } else {
            byteValue = nso.GameScr.mapTasks[Char.getMyChar().ctaskId][Char.getMyChar().taskMaint.index + 1];
        }
        if (byteValue == -1) {
            if (Char.getMyChar().nClass.classId == 0 && Char.getMyChar().ctaskId == 9) {
                byteValue = -2;
            } else if (Char.getMyChar().nClass.classId == 0 || Char.getMyChar().nClass.classId == 1 || Char.getMyChar().nClass.classId == 2) {
                byteValue = 1;
            } else if (Char.getMyChar().nClass.classId == 3 || Char.getMyChar().nClass.classId == 4) {
                byteValue = 72;
            } else if (Char.getMyChar().nClass.classId == 5 || Char.getMyChar().nClass.classId == 6) {
                byteValue = 27;
            }
        }
        return byteValue;
    }

    public static byte getTaskNpcId() {
        try {
            if (Char.getMyChar().ctaskId >= nso.GameScr.tasks.length) {
                return -3;
            }
            byte byteValue = 0;
            if (Char.getMyChar().taskMaint == null) {
                byteValue = nso.GameScr.tasks[Char.getMyChar().ctaskId][0];
            } else {
                byteValue = nso.GameScr.tasks[Char.getMyChar().ctaskId][Char.getMyChar().taskMaint.index + 1];
            }
            if (byteValue == -1) {
                if (Char.getMyChar().nClass.classId == 0 && Char.getMyChar().ctaskId == 9) {
                    byteValue = -2;
                } else if (Char.getMyChar().nClass.classId == 0 || Char.getMyChar().nClass.classId == 1 || Char.getMyChar().nClass.classId == 2) {
                    byteValue = 9;
                } else if (Char.getMyChar().nClass.classId == 3 || Char.getMyChar().nClass.classId == 4) {
                    byteValue = 10;
                } else if (Char.getMyChar().nClass.classId == 5 || Char.getMyChar().nClass.classId == 6) {
                    byteValue = 11;
                }
            }
            return byteValue;
        } catch (Exception exception) {
            return -1;
        }
    }

    private void upGrade() {
        int value = 0;
        for (int index = 0; index < arrItemUpGrade.length; index++) {
            if (arrItemUpGrade[index] != null && arrItemUpGrade[index].template.type == 26) {
                value += crystals[arrItemUpGrade[index].template.id];
            }
        }
        boolean flag = false;
        boolean flag1 = false;
        int value2 = 0;
        if (itemUpGrade.isTypeClothe()) {
            if (nso.GameScr.coinUpClothes[itemUpGrade.upgrade] > Char.getMyChar().xu + Char.getMyChar().yen) {
                flag = true;
            }
            value2 = value * 100 / nso.GameScr.upClothe[itemUpGrade.upgrade];
        } else if (itemUpGrade.isTypeAdorn()) {
            if (nso.GameScr.coinUpAdorns[itemUpGrade.upgrade] > Char.getMyChar().xu + Char.getMyChar().yen) {
                flag = true;
            }
            value2 = value * 100 / nso.GameScr.upAdorn[itemUpGrade.upgrade];
        } else if (itemUpGrade.isTypeWeapon()) {
            if (nso.GameScr.coinUpWeapons[itemUpGrade.upgrade] > Char.getMyChar().xu + Char.getMyChar().yen) {
                flag = true;
            }
            value2 = value * 100 / nso.GameScr.upWeapon[itemUpGrade.upgrade];
        }
        if (isPaintUpGradeGold && nso.GameScr.goldUps[itemUpGrade.upgrade] > Char.getMyChar().luong) {
            flag1 = true;
        }
        if (flag) {
            InfoMe.addInfo(mResources.NOT_ENOUGH_COIN_UPGRADE, 15, mFont.tahoma_7_red);
        } else if (flag1) {
            InfoMe.addInfo(mResources.NOT_ENOUGH_GOLD_UPGRADE, 15, mFont.tahoma_7_red);
        } else if (value2 > 250) {
            GameCanvas.startYesNoDlg(mResources.PERCENT_BIG, 88815, null, 8882, null);
        } else {
            doUpgrade();
        }
    }

    public static void doUpgrade() {
        if (!itemUpGrade.isLock) {
            GameCanvas.startYesNoDlg(mResources.CONFIRMUPGRADE, new Command(mResources.YES, 11063), new Command(mResources.NO, 1));
        } else {
            Service.gI().upgradeItem(itemUpGrade, arrItemUpGrade, isPaintUpGradeGold);
        }
    }

    private static void split() {
        if (!nso.GameScr.isPaintCheDo) {
            if (nso.GameScr.isPaintLuyenNgoc) {
                Service.gI().ngockham((byte) 1, null, itemSplit, arrItemSplit);
                return;
            }
            if (nso.GameScr.isPaintTinhluyen) {
                Service.gI().tinhluyen(itemSplit, arrItemSplit);
                return;
            }
            if (nso.GameScr.isPaintDichChuyen) {
                Service.gI().dichchuyen(itemSplit, arrItemSplit);
                return;
            }
            if (itemSplit.upgrade == 0) {
                GameCanvas.msgdlg.setInfo(mResources.NOT_UPGRADE, null, new Command(mResources.CLOSE, 1), null);
                MsgDlg msgDlg = GameCanvas.msgdlg;
                GameCanvas.currentDialog = GameCanvas.msgdlg;
                return;
            }
            int value = -1;
            int value1 = 0;
            for (int index = 0; index < Char.getMyChar().arrItemBag.length; index++) {
                if (Char.getMyChar().arrItemBag[index] == null) {
                    value++;
                }
            }
            for (int index2 = 0; index2 < arrItemSplit.length; index2++) {
                if (arrItemSplit[index2] != null) {
                    value1++;
                }
            }
            if (value1 > value) {
                GameCanvas.msgdlg.setInfo(mResources.BAG_FULL, null, new Command(mResources.CLOSE, 1), null);
                MsgDlg msgDlg3 = GameCanvas.msgdlg;
                GameCanvas.currentDialog = GameCanvas.msgdlg;
                return;
            }
            GameCanvas.startYesNoDlg(mResources.CONFIRMSPLIT, new Command(mResources.YES, 11087, itemSplit), new Command(mResources.NO, 1));
        }
    }

    private void updateItemInfo(int typeUI, Item item, Command left, Command right) {
        this.updateItemInfo(3, item);
        if (left != null) {
            super.left = new Command(left.caption, 11040);
        }
    }

    private void updateItemInfo(int typeUI, Item item) {
        if (item != null) {
            this.itemFocus = item;
            inforW = 120;
            inforH = 120;
            if (GameCanvas.isTouch && !GameCanvas.isTouchControlSmallScreen) {
                inforH += 18;
            }
            nso.GameScr.isPaintItemInfo = true;
            scrInfo.clear();
            indexRow = 0;
            if (item.expires == 0L) {
                if (nso.GameScr.isPaintTinhluyen || nso.GameScr.isPaintDichChuyen || nso.GameScr.isPaintLuyenNgoc || nso.GameScr.isPaintCheDo || nso.GameScr.isPaintKhamNgoc || nso.GameScr.isPaintThaoNgoc || nso.GameScr.isPaintGotNgoc) {
                    Service.gI().requestItemInfo(item.typeUI, item.indexUI);
                }
                if (isPaintAuctionBuy) {
                    Service.gI().requestItemAuction(item.itemId);
                } else if (currentCharViewInfo.charID == Char.getMyChar().charID) {
                    Service.gI().requestItemInfo(typeUI, item.indexUI);
                } else {
                    Service.gI().requestItemPlayer(currentCharViewInfo.charID, item.indexUI);
                }
            }
            if (typeUI == 5) {
                Char.getMyChar().updateKickOption();
            }
            if (!GameCanvas.isTouch || GameCanvas.isTouch && GameCanvas.isTouchControlSmallScreen || isPaintInfoMe && indexMenu > 0 && indexMenu < 4 || isPaintClan && indexMenu == 0) {
                super.center = this.cmdItemInfoClose;
                super.right = null;
                super.left = null;
            }
            GameCanvas.clearKeyHold();
            GameCanvas.clearKeyPressed();
        }
    }

    public final void showAlert(String title, String str, boolean withMenuShow) {
        InfoDlg.hide();
        isPaintAlert = true;
        this.isLockKey = true;
        indexRow = 0;
        setPopupSize(175, 200);
        if (withMenuShow) {
            popupH -= 60;
        }
        super.right = new Command(mResources.CLOSE, 3);
        super.left = super.center = null;
        this.textsTitle = title;
        this.texts = mFont.tahoma_7.splitFontVector(str, popupW - 30);
    }

    public final void doCloseAlert() {
        isPaintAlert = false;
        this.textsTitle = null;
        this.texts = null;
        super.center = null;
        this.resetButton();
    }

    public final void scrollDownAlert() {
        indexRowMax = this.texts.size();
        scrMain.setStyle(indexRowMax, 12, popupX, nso.GameScr.ystart + 12, popupW, popupH - 42 - (this.textsTitle != null ? 10 : 0), true, 1);
        indexRow = this.texts.size() - 1;
        scrMain.moveTo(indexRow * scrMain.ITEM_SIZE);
    }

    private void paintAlert(mGraphics g) {
        if (this.texts != null && isPaintAlert) {
            resetTranslate(g);
            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
            if (this.textsTitle != null) {
                paintTitle(g, this.textsTitle, isPaintMessage);
            }
            nso.GameScr.xstart = popupX + 15;
            nso.GameScr.ystart = popupY + 15;
            if (this.textsTitle != null) {
                nso.GameScr.ystart += 10;
            }
            indexRowMax = this.texts.size();
            scrMain.setStyle(indexRowMax, 12, popupX, nso.GameScr.ystart + 12, popupW, popupH - 42 - (this.textsTitle != null ? 10 : 0), true, 1);
            scrMain.setClip(g);
            this.yPaint = nso.GameScr.ystart;
            mFont font = mFont.tahoma_7_white;
            String text;
            for (int index = 0; index < this.texts.size() && (text = (String) this.texts.elementAt(index)) != null && this.texts != null && font != null; index++) {
                if (text.startsWith("c")) {
                    if (text.startsWith("c0")) {
                        text = text.substring(2);
                        font = mFont.tahoma_7_white;
                    } else if (text.startsWith("c1")) {
                        text = text.substring(2);
                        font = mFont.tahoma_7b_yellow;
                    } else if (text.startsWith("c2")) {
                        text = text.substring(2);
                        font = mFont.tahoma_7b_white;
                    } else if (text.startsWith("c3")) {
                        text = text.substring(2);
                        font = mFont.tahoma_7_yellow;
                    } else if (text.startsWith("c4")) {
                        text = text.substring(2);
                        font = mFont.tahoma_7b_red;
                    } else if (text.startsWith("c5")) {
                        text = text.substring(2);
                        font = mFont.tahoma_7_red;
                    } else if (text.startsWith("c6")) {
                        text = text.substring(2);
                        font = mFont.tahoma_7_grey;
                    } else if (text.startsWith("c7")) {
                        text = text.substring(2);
                        font = mFont.tahoma_7b_blue;
                    } else if (text.startsWith("c8")) {
                        text = text.substring(2);
                        font = mFont.tahoma_7_blue;
                    } else if (text.startsWith("c9")) {
                        text = text.substring(2);
                        font = mFont.tahoma_7_green;
                    }
                }
                font.drawString(g, text, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
            }
            if (indexRow >= 0) {
                SmallImage.drawSmallImage(g, 942, nso.GameScr.xstart - 5, nso.GameScr.ystart + 12 + 1 + indexRow * 12, 0, StaticObj.TOP_LEFT);
            }
        }
    }

    private void paintFindTeam(mGraphics g) {
        if (isPaintFindTeam) {
            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
            paintTitle(g, mResources.FINDTEAM, false);
            nso.GameScr.xstart = popupX + 5;
            nso.GameScr.ystart = popupY + 40;
            if (vPtMap.size() == 0) {
                mFont.tahoma_7_white.drawString(g, mResources.NOT_TEAM_MAP, popupX + popupW / 2, popupY + 40, 2);
            } else {
                g.setColor(6425);
                g.fillRect(nso.GameScr.xstart - 2, nso.GameScr.ystart - 2, popupW - 6, indexSize * 5 + 8);
                resetTranslate(g);
                scrMain.setStyle(vPtMap.size(), indexSize, nso.GameScr.xstart, nso.GameScr.ystart, popupW - 3, indexSize * 5 + 4, true, 1);
                scrMain.setClip(g, nso.GameScr.xstart, nso.GameScr.ystart, popupW - 3, indexSize * 5 + 6);
                indexRowMax = vPtMap.size();
                for (int index = 0; index < vPtMap.size(); index++) {
                    Party party = (Party) vPtMap.elementAt(index);
                    if (indexRow == index) {
                        g.setColor(Paint.COLORLIGHT);
                        g.fillRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + indexRow * indexSize + 2, popupW - 15, indexSize - 4);
                        g.setColor(16777215);
                        g.drawRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + indexRow * indexSize + 2, popupW - 15, indexSize - 4);
                    } else {
                        g.setColor(Paint.COLORBACKGROUND);
                        g.fillRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + index * indexSize + 2, popupW - 15, indexSize - 4);
                        g.setColor(13932896);
                        g.drawRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + index * indexSize + 2, popupW - 15, indexSize - 4);
                    }
                    SmallImage.drawSmallImage(g, 647, nso.GameScr.xstart + 12, nso.GameScr.ystart + index * indexSize + indexSize / 2, 0, 3);
                    mFont.tahoma_7_white.drawString(g, party.name + " - " + mResources.level + ": " + party.level + " (" + party.size + ")", nso.GameScr.xstart + 22, nso.GameScr.ystart + index * indexSize + indexSize / 2 - 6, 0);
                }
            }
            paintNumCount(g);
        }
    }

    private void paintTeam(mGraphics g) {
        if (isPaintTeam) {
            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
            paintTitle(g, mResources.TEAM, false);
            nso.GameScr.xstart = popupX + 5;
            nso.GameScr.ystart = popupY + 40;
            if (vParty.size() == 0) {
                mFont.tahoma_7_white.drawString(g, mResources.NOT_TEAM, popupX + popupW / 2, popupY + 40, 2);
            } else {
                g.setColor(6425);
                g.fillRect(nso.GameScr.xstart - 2, nso.GameScr.ystart - 2, popupW - 6, indexSize * 5 + 8);
                resetTranslate(g);
                scrMain.setStyle(vParty.size(), indexSize, nso.GameScr.xstart, nso.GameScr.ystart, popupW - 3, indexSize * 5 + 4, true, 1);
                scrMain.setClip(g, nso.GameScr.xstart, nso.GameScr.ystart, popupW - 3, indexSize * 5 + 6);
                indexRowMax = vParty.size();
                for (int index = 0; index < vParty.size(); index++) {
                    Party party = (Party) vParty.elementAt(index);
                    if (indexRow == index) {
                        g.setColor(Paint.COLORLIGHT);
                        g.fillRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + indexRow * indexSize + 2, popupW - 15, indexSize - 4);
                        g.setColor(16777215);
                        g.drawRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + indexRow * indexSize + 2, popupW - 15, indexSize - 4);
                    } else {
                        g.setColor(Paint.COLORBACKGROUND);
                        g.fillRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + index * indexSize + 2, popupW - 15, indexSize - 4);
                        g.setColor(13932896);
                        g.drawRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + index * indexSize + 2, popupW - 15, indexSize - 4);
                    }
                    SmallImage.drawSmallImage(g, party.iconId, nso.GameScr.xstart + 12, nso.GameScr.ystart + index * indexSize + indexSize / 2, 0, 3);
                    if (party.c == null) {
                        mFont.tahoma_7_green.drawString(g, party.name, nso.GameScr.xstart + 22, nso.GameScr.ystart + index * indexSize + indexSize / 2 - 6, 0);
                    } else if (index == 0) {
                        mFont.tahoma_7_yellow.drawString(g, party.name + " - " + mResources.level + ": " + party.c.clevel, nso.GameScr.xstart + 22, nso.GameScr.ystart + index * indexSize + indexSize / 2 - 6, 0);
                    } else {
                        mFont.tahoma_7_white.drawString(g, party.name + " - " + mResources.level + ": " + party.c.clevel, nso.GameScr.xstart + 22, nso.GameScr.ystart + index * indexSize + indexSize / 2 - 6, 0);
                    }
                }
            }
            paintNumCount(g);
        }
    }

    private void PaintAuctionBuy(mGraphics g) {
        if (isPaintAuctionBuy) {
            int value = popupW;
            if (GameCanvas.isTouchControlLargeScreen) {
                value = popupW / 2 + 20;
            }
            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
            paintTitle(g, mResources.MENUSTANDS[indexMenu], GameCanvas.isTouch ? true : indexTitle == 0);
            g.setColor(6425);
            g.fillRect(nso.GameScr.xstart - 2, nso.GameScr.ystart - 2, value - 6, indexSize * 5 + 4);
            if (arrItemStands == null) {
                GameCanvas.paintShukiren(popupX + 90, popupY + 75, g, false);
                mFont.tahoma_7b_white.drawString(g, mResources.PLEASEWAIT, popupX + 90, popupY + 90, 2);
                return;
            }
            ItemStands[] values = arrItemStands;
            nso.GameScr.xstart = popupX + 5;
            nso.GameScr.ystart = popupY + 33;
            if (values.length > 0) {
                indexRowMax = values.length;
                resetTranslate(g);
                scrMain.setStyle(indexRowMax, indexSize, nso.GameScr.xstart, nso.GameScr.ystart, value - 3, indexSize * 5, true, 1);
                scrMain.setClip(g, nso.GameScr.xstart, nso.GameScr.ystart, value - 3, indexSize * 5 + 2);
                for (int index = 0; index < values.length; index++) {
                    ItemStands itemStands;
                    if ((itemStands = values[index]) != null && itemStands.item != null && itemStands.item.template != null) {
                        int value1 = (int) (System.currentTimeMillis() / 1000L);
                        if (index * indexSize >= scrMain.cmy - indexSize && index * indexSize < scrMain.cmy + indexSize * 5 + 4) {
                            if (indexSelect == index) {
                                g.setColor(Paint.COLORLIGHT);
                                g.fillRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + indexSelect * indexSize + 2, value - 15, indexSize - 4);
                                g.setColor(16777215);
                                g.drawRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + indexSelect * indexSize + 2, value - 15, indexSize - 4);
                            } else {
                                g.setColor(Paint.COLORBACKGROUND);
                                g.fillRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + index * indexSize + 2, value - 15, indexSize - 4);
                                g.setColor(13932896);
                                g.drawRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + index * indexSize + 2, value - 15, indexSize - 4);
                            }
                            g.setColor(0);
                            g.fillRect(nso.GameScr.xstart + 4, nso.GameScr.ystart + index * indexSize + 4, indexSize - 1, indexSize - 8);
                            g.setColor(indexSelect == index ? 16777215 : 12281361);
                            g.drawRect(nso.GameScr.xstart + 4, nso.GameScr.ystart + index * indexSize + 4, indexSize - 1, indexSize - 8);
                            if (GameCanvas.gameTick % 6 == 0) {
                                itemStands.item.indexFrame = (itemStands.item.indexFrame + 1) % 3;
                            }
                            g.setColor(11403519);
                            if (itemStands.item.isNewitem()) {
                                g.drawRect(nso.GameScr.xstart + 5, nso.GameScr.ystart + index * indexSize + 5, indexSize - 3, indexSize - 10);
                            }
                            SmallImage.drawSmallImageNew(g, itemStands.item.template.iconID, nso.GameScr.xstart + indexSize / 2, nso.GameScr.ystart + index * indexSize + indexSize / 2, 0, 3, itemStands.item.indexFrame);
                            if (itemStands.item.quantity > 1) {
                                mFont.number_yellow.drawString(g, String.valueOf(itemStands.item.quantity), nso.GameScr.xstart + indexSize, nso.GameScr.ystart + index * indexSize + indexSize / 2 + 2, 1);
                            }
                            value1 = itemStands.timeEnd - (value1 - itemStands.timeStart);
                            mFont.tahoma_7_white.drawString(g, mResources.SELLER + ": " + itemStands.seller, nso.GameScr.xstart + indexSize + 7, nso.GameScr.ystart + index * indexSize + indexSize / 2 - mFont.number_yellow.getHeight() - 2, 0);
                            mFont.tahoma_7_white.drawString(g, mResources.PRICE + ": " + NinjaUtil.numberToString(String.valueOf(itemStands.price)) + " " + mResources.XU, nso.GameScr.xstart + indexSize + 7, nso.GameScr.ystart + index * indexSize + indexSize / 2 - mFont.number_yellow.getHeight() + 9, 0);
                            if (value1 < 60) {
                                mFont.tahoma_7_blue.drawString(g, mResources.NEAR, nso.GameScr.xstart + value - 30, nso.GameScr.ystart + index * indexSize + indexSize / 2 - mFont.number_yellow.getHeight() - 2, 2);
                                mFont.tahoma_7_blue.drawString(g, mResources.DEADLINE, nso.GameScr.xstart + value - 30, nso.GameScr.ystart + index * indexSize + indexSize / 2 - mFont.number_yellow.getHeight() + 9, 2);
                            } else {
                                mFont.tahoma_7_green.drawString(g, mResources.REMAIN, nso.GameScr.xstart + value - 30, nso.GameScr.ystart + index * indexSize + indexSize / 2 - mFont.number_yellow.getHeight() - 2, 2);
                                mFont.tahoma_7_green.drawString(g, NinjaUtil.getTime(value1), nso.GameScr.xstart + value - 30, nso.GameScr.ystart + index * indexSize + indexSize / 2 - mFont.number_yellow.getHeight() + 9, 2);
                            }
                        }
                    }
                }
            } else {
                indexRowMax = values.length;
                mFont.tahoma_7_white.drawString(g, mResources.EMPTY_INFO, popupX + value / 2, popupY + 40, 2);
            }
            paintNumCount(g);
        }
    }

    private void paintFriend(mGraphics g) {
        if (isPaintFriend || isPaintEnemies) {
            String text = isPaintFriend ? mResources.FRIENDS[0] : mResources.FRIENDS[1];
            MyVector entries = isPaintFriend ? vFriend : vEnemies;
            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
            paintTitle(g, text, false);
            if (entries.size() <= 0) {
                mFont.tahoma_7_white.drawString(g, isPaintFriend ? mResources.NO_FRIEND : mResources.YOU_KILLED, popupX + popupW / 2, popupY + 40, 2);
            } else {
                nso.GameScr.xstart = popupX + 5;
                nso.GameScr.ystart = popupY + 40;
                g.setColor(6425);
                g.fillRect(nso.GameScr.xstart - 2, nso.GameScr.ystart - 2, popupW - 6, indexSize * 5 + 8);
                resetTranslate(g);
                scrMain.setStyle(entries.size(), indexSize, nso.GameScr.xstart, nso.GameScr.ystart, popupW - 3, indexSize * 5 + 4, true, 1);
                scrMain.setClip(g, nso.GameScr.xstart, nso.GameScr.ystart, popupW - 3, indexSize * 5 + 6);
                indexRowMax = entries.size();
                int value = 0;
                for (int index = 0; index < entries.size(); index++) {
                    Friend friend = (Friend) entries.elementAt(index);
                    if (!isViewClanMemOnline || friend.type == 3) {
                        mFont font = mFont.tahoma_7_grey;
                        if (friend.type == 1 || friend.type == 2) {
                            font = mFont.tahoma_7_green;
                        } else if (friend.type == 3) {
                            font = mFont.tahoma_7_white;
                        } else if (friend.type == 4) {
                            font = mFont.tahoma_7_red;
                        }
                        if (index * indexSize >= scrMain.cmy - indexSize && index * indexSize < scrMain.cmy + indexSize * 5 + 8) {
                            if (indexRow == index) {
                                g.setColor(Paint.COLORLIGHT);
                                g.fillRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + indexRow * indexSize + 2, popupW - 15, indexSize - 4);
                                g.setColor(16777215);
                                g.drawRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + indexRow * indexSize + 2, popupW - 15, indexSize - 4);
                            } else {
                                g.setColor(Paint.COLORBACKGROUND);
                                g.fillRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + index * indexSize + 2, popupW - 15, indexSize - 4);
                                g.setColor(13932896);
                                g.drawRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + index * indexSize + 2, popupW - 15, indexSize - 4);
                            }
                            if (friend.type == 4) {
                                if (GameCanvas.gameTick % 10 > 7) {
                                    font.drawString(g, friend.friendName, nso.GameScr.xstart + 8, nso.GameScr.ystart + index * indexSize + indexSize / 2 - 6, 0);
                                } else {
                                    mFont.tahoma_7_yellow.drawString(g, friend.friendName, nso.GameScr.xstart + 8, nso.GameScr.ystart + index * indexSize + indexSize / 2 - 6, 0);
                                }
                                mFont.tahoma_7_blue.drawString(g, mResources.CONFIRM_FRIEND, nso.GameScr.xstart + popupW - 15, nso.GameScr.ystart + index * indexSize + indexSize / 2 - 6, 1);
                            } else {
                                font.drawString(g, friend.friendName, nso.GameScr.xstart + 8, nso.GameScr.ystart + index * indexSize + indexSize / 2 - 6, 0);
                            }
                        }
                        value++;
                    }
                }
                indexRowMax = value;
                scrMain.setStyle(value, indexSize, nso.GameScr.xstart, nso.GameScr.ystart, popupW - 3, indexSize * 5 + 4, true, 1);
            }
            paintNumCount(g);
        }
    }

    private void paintTask(mGraphics g) {
        if (isPaintTask) {
            indexRowMax = 0;
            resetTranslate(g);
            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
            paintTitle(g, mResources.TASK[indexMenu], false);
            nso.GameScr.xstart = popupX + 10;
            nso.GameScr.ystart = popupY + 32;
            if (indexMenu == 0) {
                boolean flag = false;
                scrMain.setStyle(indexRowMax, 12, popupX, popupY + 32, popupW, popupH - 40, true, 1);
                scrMain.setClip(g);
                if (Char.getMyChar().taskMaint != null) {
                    for (int index = 0; index < Char.getMyChar().taskMaint.names.length; index++) {
                        mFont.tahoma_7b_white.drawString(g, Char.getMyChar().taskMaint.names[index], nso.GameScr.xstart, this.yPaint = nso.GameScr.ystart, 0);
                        indexRowMax++;
                    }
                    int value = 0;
                    String text = null;
                    for (int index1 = 0; index1 < Char.getMyChar().taskMaint.subNames.length; index1++) {
                        if (Char.getMyChar().taskMaint.subNames[index1] != null) {
                            value = index1;
                            text = "- " + Char.getMyChar().taskMaint.subNames[index1];
                            if (Char.getMyChar().taskMaint.counts[index1] != -1) {
                                if (Char.getMyChar().taskMaint.index == index1) {
                                    text = text + " " + Char.getMyChar().taskMaint.count + "/" + Char.getMyChar().taskMaint.counts[index1];
                                    if (Char.getMyChar().taskMaint.count == Char.getMyChar().taskMaint.counts[index1]) {
                                        mFont.tahoma_7_white.drawString(g, text, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                                    } else {
                                        mFont font = mFont.tahoma_7_grey;
                                        if (!flag) {
                                            flag = true;
                                            font = mFont.tahoma_7_yellow;
                                        }
                                        font.drawString(g, text, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                                    }
                                } else if (Char.getMyChar().taskMaint.index > index1) {
                                    text = text + " " + Char.getMyChar().taskMaint.counts[index1] + "/" + Char.getMyChar().taskMaint.counts[index1];
                                    mFont.tahoma_7_white.drawString(g, text, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                                } else {
                                    text = text + " 0/" + Char.getMyChar().taskMaint.counts[index1];
                                    mFont font2 = mFont.tahoma_7_grey;
                                    if (!flag) {
                                        flag = true;
                                        font2 = mFont.tahoma_7_yellow;
                                    }
                                    font2.drawString(g, text, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                                }
                            } else if (Char.getMyChar().taskMaint.index > index1) {
                                mFont.tahoma_7_white.drawString(g, text, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                            } else {
                                mFont font3 = mFont.tahoma_7_grey;
                                if (!flag) {
                                    flag = true;
                                    font3 = mFont.tahoma_7_yellow;
                                }
                                font3.drawString(g, text, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                            }
                            indexRowMax++;
                        } else if (Char.getMyChar().taskMaint.index <= index1) {
                            text = "- " + Char.getMyChar().taskMaint.subNames[value];
                            mFont font4 = mFont.tahoma_7_grey;
                            if (!flag) {
                                flag = true;
                                font4 = mFont.tahoma_7_yellow;
                            }
                            font4.drawString(g, text, nso.GameScr.xstart + 5, this.yPaint, 0);
                        }
                    }
                    this.yPaint += 5;
                    for (int index5 = 0; index5 < Char.getMyChar().taskMaint.details.length; index5++) {
                        mFont.tahoma_7_white.drawString(g, Char.getMyChar().taskMaint.details[index5], nso.GameScr.xstart, this.yPaint += 12, 0);
                        indexRowMax++;
                    }
                } else {
                    byte byteValue = getTaskMapId();
                    byte byteValue6 = getTaskNpcId();
                    String text7 = null;
                    if (byteValue == -3 || byteValue6 == -3) {
                        text7 = mResources.DES_TASK[3];
                    } else if (Char.getMyChar().taskMaint == null && Char.getMyChar().ctaskId == 9 && Char.getMyChar().nClass.classId == 0) {
                        text7 = mResources.TASK_INPUT_CLASS;
                    } else {
                        if (byteValue6 < 0 || byteValue < 0) {
                            return;
                        }
                        text7 = mResources.DES_TASK[0] + Npc.arrNpcTemplate[byteValue6].name + mResources.DES_TASK[1] + TileMap.mapNames[byteValue] + mResources.DES_TASK[2];
                    }
                    String[] textLines = mFont.tahoma_7_white.splitFontArray(text7, 150);
                    for (int index8 = 0; index8 < textLines.length; index8++) {
                        if (index8 == 0) {
                            mFont.tahoma_7_white.drawString(g, textLines[index8], nso.GameScr.xstart + 5, this.yPaint = nso.GameScr.ystart, 0);
                        } else {
                            mFont.tahoma_7_white.drawString(g, textLines[index8], nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                        }
                        indexRowMax++;
                    }
                }
                if (indexTitle == 1 && indexRow >= 0 && indexRowMax > 0) {
                    SmallImage.drawSmallImage(g, 942, nso.GameScr.xstart - 8, nso.GameScr.ystart + 2 + indexRow * 12, 0, StaticObj.TOP_LEFT);
                }
                scrMain.setStyle(indexRowMax, 12, popupX, popupY + 32, popupW, popupH - 44, true, 1);
                return;
            }
            if (indexMenu == 1) {
                this.yPaint = nso.GameScr.ystart - 12;
                scrMain.setStyle(Char.getMyChar().taskOrders.size(), 12, popupX, popupY + 32, popupW, popupH - 44, true, 1);
                scrMain.setClip(g);
                indexRowMax = 0;
                for (int index9 = 0; index9 < Char.getMyChar().taskOrders.size(); index9++) {
                    TaskOrder taskOrder = (TaskOrder) Char.getMyChar().taskOrders.elementAt(index9);
                    mFont.tahoma_7b_white.drawString(g, taskOrder.name, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                    String text10 = "";
                    if (taskOrder.taskId == 0 || taskOrder.taskId == 3) {
                        text10 = mResources.KILL + " " + Mob.arrMobTemplate[taskOrder.killId].name;
                    } else if (taskOrder.taskId == 1) {
                        text10 = mResources.KILLBOSS + " " + Mob.arrMobTemplate[taskOrder.killId].name;
                    } else if (taskOrder.taskId == 2) {
                        text10 = mResources.GIOITHIEU;
                    } else if (taskOrder.taskId == 4) {
                        text10 = mResources.KILLBOSS1 + " " + Mob.arrMobTemplate[taskOrder.killId].name;
                    } else if (taskOrder.taskId == 5) {
                        text10 = mResources.KILLBOSS2 + " " + Mob.arrMobTemplate[taskOrder.killId].name;
                    } else if (taskOrder.taskId == 6) {
                        text10 = mResources.KILLBOSS3;
                    }
                    if (taskOrder.taskId == 6) {
                        if (taskOrder.count == taskOrder.maxCount) {
                            mFont.tahoma_7_white.drawString(g, text10, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                        } else {
                            mFont.tahoma_7_yellow.drawString(g, text10, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                        }
                    } else if (taskOrder.count == taskOrder.maxCount) {
                        mFont.tahoma_7_white.drawString(g, text10 + " " + taskOrder.count + "/" + taskOrder.maxCount, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                    } else {
                        mFont.tahoma_7_yellow.drawString(g, text10 + " " + taskOrder.count + "/" + taskOrder.maxCount, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                    }
                    indexRowMax += 3;
                    inforW = popupW - 25;
                    this.paintMultiLine(g, mFont.tahoma_7_white, taskOrder.description, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                    this.yPaint += 12;
                }
                if (this.typeba > 0) {
                    mFont.tahoma_7_white.drawString(g, mResources.noti_hiddenquest, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                    switch(this.typeba) {
                        case 1:
                            mFont.tahoma_7_white.drawString(g, mResources.noti_aggressivepoint, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                            break;
                        case 2:
                            mFont.tahoma_7_white.drawString(g, mResources.noti_cave, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                            break;
                        case 3:
                            mFont.tahoma_7_white.drawString(g, mResources.noti_huntingwildbeast, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                            break;
                        case 4:
                            mFont.tahoma_7_white.drawString(g, mResources.noti_upgrade, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                            break;
                        case 5:
                            mFont.tahoma_7_white.drawString(g, mResources.noti_dailyquest, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                            break;
                        case 6:
                            mFont.tahoma_7_white.drawString(g, mResources.noti_battlefield, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                            break;
                        case 7:
                            mFont.tahoma_7_white.drawString(g, mResources.noti_sevenbeasts, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                            break;
                        case 8:
                            mFont.tahoma_7_white.drawString(g, mResources.noti_luckycard, nso.GameScr.xstart + 5, this.yPaint += 12, 0);
                    }
                }
                if (indexTitle == 1 && indexRow >= 0 && indexRowMax > 0) {
                    SmallImage.drawSmallImage(g, 942, nso.GameScr.xstart - 8, nso.GameScr.ystart + 2 + indexRow * 12, 0, StaticObj.TOP_LEFT);
                }
                indexRowMax++;
                scrMain.setStyle(indexRowMax, 12, popupX, popupY + 32, popupW, popupH - 44, true, 1);
            }
        }
    }

    private static String[] splitMultiLine(mFont font, String text) {
        return font.splitFontArray(text, popupW - 20);
    }

    private void paintMultiLine(mGraphics g, mFont f, String[] arr, int x, int y, int align) {
        align = y;
        for (int index = 0; index < arr.length; index++) {
            String text;
            if ((text = arr[index]).startsWith("c")) {
                if (text.startsWith("c0")) {
                    text = text.substring(2);
                    f = mFont.tahoma_7_white;
                } else if (text.startsWith("c1")) {
                    text = text.substring(2);
                    f = mFont.tahoma_7_yellow;
                } else if (text.startsWith("c2")) {
                    text = text.substring(2);
                    f = mFont.tahoma_7_green;
                }
            }
            if (index == 0) {
                f.drawString(g, text, x, y, 0);
            } else {
                if (index * scrMain.ITEM_SIZE + align >= scrMain.cmy - 12 && index * scrMain.ITEM_SIZE < scrMain.cmy + popupH - 44) {
                    y += 12;
                    f.drawString(g, text, x, y, 0);
                } else {
                    y += 12;
                }
                this.yPaint += 12;
                indexRowMax++;
            }
        }
    }

    private void paintMultiLine(mGraphics g, mFont f, String str, int x, int y, int align) {
        try {
            int value = GameCanvas.isTouch && GameCanvas.w >= 320 ? 20 : 10;
            int value1 = y;
            String[] textLines = f.splitFontArray(str, inforW - value);
            for (int index = 0; index < textLines.length; index++) {
                if (index == 0) {
                    f.drawString(g, textLines[index], x, y, align);
                } else {
                    if (index * scrMain.ITEM_SIZE + value1 >= scrMain.cmy - 12 && index * scrMain.ITEM_SIZE < scrMain.cmy + popupH + 44) {
                        String text = textLines[index];
                        y += 12;
                        f.drawString(g, text, x, y, align);
                        this.yPaint += 12;
                    } else {
                        y += 12;
                    }
                    indexRowMax++;
                }
            }
        } catch (Exception exception) {
            System.out.println("loi  " + exception.toString());
        }
    }

    private void paintMultiLine(mGraphics g, mFont f, String str, int x, int y, int align, int width) {
        align = y;
        String[] textLines = f.splitFontArray(str, width);
        for (int index = 0; index < textLines.length; index++) {
            if (index == 0) {
                f.drawString(g, textLines[index], x, y, 0);
            } else {
                if (index * scrMain.ITEM_SIZE + align >= scrMain.cmy - 12 && index * scrMain.ITEM_SIZE < scrMain.cmy + popupH - 44) {
                    String text = textLines[index];
                    y += 12;
                    f.drawString(g, text, x, y, 0);
                    this.yPaint += 12;
                } else {
                    y += 12;
                }
                indexRowMax++;
            }
        }
    }

    private void paintItemInfo(mGraphics g) {
        if (GameCanvas.isTouchControlLargeScreen && !isSmallUI() && (isOpenUI() || isPaintPopup() || isPaintUI())) {
            setInfoFrameForLargeScreen();
            paintInforFrame(g);
            resetTranslate(g);
            this.paintMultiLine(g, mFont.tahoma_7_white, mResources.CHOOSE_ITEM, inforX + inforW / 2, inforY + inforH / 2 - 20, 2);
        }
        if (nso.GameScr.isPaintItemInfo && this.itemFocus != null && this.itemFocus.template != null) {
            Item item = this.itemFocus;
            if (nso.GameScr.isViewNext && !this.itemFocus.isUpMax() && indexMenu == 0) {
                item = this.itemFocus.viewNext(this.itemFocus.upgrade + 1);
            }
            if (nso.GameScr.isPaintConvert && indexMenu == 0 && indexTitle == 1 && item.isTypeBody() && item.upgrade == 0 && arrItemConvert[0] != null && arrItemConvert[0].template.type == arrItemConvert[1].template.type && arrItemConvert[1].template.level >= arrItemConvert[0].template.level) {
                item = this.itemFocus.viewNext(arrItemConvert[0].upgrade);
            }
            resetTranslate(g);
            if (item.expires != 0L && item.options != null && item.options.size() > 0) {
                for (int index = 0; index < item.options.size(); index++) {
                    int value;
                    if ((value = ((ItemOption) item.options.elementAt(index)).getOptionString().length() * 5) > inforW && !GameCanvas.isTouchControlLargeScreen) {
                        inforW = value;
                    }
                }
            }
            int value1;
            if ((value1 = mFont.tahoma_7b_white.getWidth(item.template.name) + 10) > inforW && !GameCanvas.isTouchControlLargeScreen) {
                inforW = value1;
            }
            if (inforW > GameCanvas.w - 4) {
                inforW = GameCanvas.w - 4;
            }
            if (inforH > GameCanvas.h - 4) {
                inforW = GameCanvas.h - 4;
            }
            inforX = nso.GameScr.gW / 2 - inforW / 2;
            inforY = gH / 2 - inforH / 2;
            setInfoFrameForLargeScreen();
            if (inforX < 2) {
                inforX = 2;
            }
            if (inforY < 2) {
                inforY = 2;
            }
            paintInforFrame(g);
            if (!isPaintClan || indexMenu != 0) {
                scrInfo.setClip(g, inforX, inforY + 2, inforW, inforH - 2);
                indexRowMax = 3;
                this.yPaint = inforY + 3;
                mFont font = mFont.tahoma_7b_white;
                if (item.isTypeMounts()) {
                    if (item.sys >= 1 && item.sys < 4) {
                        font = mFont.tahoma_7b_blue;
                    } else if (item.sys >= 4 && item.sys < 8) {
                        font = mFont.tahoma_7b_green;
                    } else if (item.sys >= 8 && item.sys < 12) {
                        font = mFont.tahoma_7b_yellow;
                    } else if (item.sys >= 12 && item.sys < 15) {
                        font = mFont.tahoma_7b_purple;
                    } else if (item.sys >= 15) {
                        font = mFont.tahoma_7b_red;
                    }
                } else if (item.upgrade >= 1 && item.upgrade < 4) {
                    font = mFont.tahoma_7b_blue;
                } else if (item.upgrade >= 4 && item.upgrade < 8) {
                    font = mFont.tahoma_7b_green;
                } else if (item.upgrade >= 8 && item.upgrade < 12) {
                    font = mFont.tahoma_7b_yellow;
                } else if (item.upgrade >= 12 && item.upgrade < 15) {
                    font = mFont.tahoma_7b_purple;
                } else if (item.upgrade >= 15) {
                    font = mFont.tahoma_7b_red;
                }
                if (item.img != null) {
                    g.drawRegion(item.img, 0, 0, mGraphics.getImageWidth(item.img), mGraphics.getImageHeight(item.img), 0, inforX + inforW / 2, this.yPaint + inforH - 10, 33);
                }
                if (item.isTypeMounts()) {
                    this.paintMultiLine(g, font, item.template.name + " + " + (item.sys + 1), inforX + 8, this.yPaint, 0);
                } else {
                    this.paintMultiLine(g, font, item.template.name + (item.upgrade > 0 ? " +" + item.upgrade : ""), inforX + 8, this.yPaint, 0);
                }
                if (item.upgrade >= 15 && !isChop && !item.isTypeMounts()) {
                    if (font.splitFontArray(item.template.name + (item.upgrade > 0 ? " +" + item.upgrade : ""), inforW - (GameCanvas.isTouch && GameCanvas.w >= 320 ? 20 : 10)).length > 1) {
                        this.yPaint -= 12;
                    }
                    if (item.isTypeMounts()) {
                        this.paintMultiLine(g, mFont.tahoma_7b_white, item.template.name, inforX + 8, this.yPaint, 0);
                    } else {
                        this.paintMultiLine(g, mFont.tahoma_7b_white, item.template.name + (item.upgrade > 0 ? " +" + item.upgrade : ""), inforX + 8, this.yPaint, 0);
                    }
                }
                if (item.isTypeBody()) {
                    this.yPaint += 12;
                    indexRowMax++;
                    if (isChop && GameCanvas.gameTick % 5 == 0) {
                        isChop = !isChop;
                    } else if (!isChop && GameCanvas.gameTick % 5 == 0) {
                        isChop = !isChop;
                    }
                    int value2 = item.upgrade / 2 + 1;
                    if (item.upgrade == 0) {
                        for (int index3 = 0; index3 < value2; index3++) {
                            SmallImage.drawSmallImage(g, 633, inforX + 12 + index3 * 10, this.yPaint + 5, 0, StaticObj.VCENTER_HCENTER);
                        }
                    } else if (item.upgrade >= 1 && item.upgrade < 4) {
                        for (int index4 = 0; index4 < value2; index4++) {
                            SmallImage.drawSmallImage(g, 625, inforX + 12 + index4 * 10, this.yPaint + 5, 0, StaticObj.VCENTER_HCENTER);
                        }
                        if (item.upgrade == 3) {
                            SmallImage.drawSmallImage(g, 635, inforX + 12 + value2 * 10, this.yPaint + 5, 0, StaticObj.VCENTER_HCENTER);
                        }
                    } else if (item.upgrade >= 4 && item.upgrade < 8) {
                        for (int index5 = 0; index5 < value2; index5++) {
                            SmallImage.drawSmallImage(g, 626, inforX + 12 + index5 * 10, this.yPaint + 5, 0, StaticObj.VCENTER_HCENTER);
                        }
                        if (item.upgrade % 2 != 0) {
                            SmallImage.drawSmallImage(g, 636, inforX + 12 + value2 * 10, this.yPaint + 5, 0, StaticObj.VCENTER_HCENTER);
                        }
                    } else if (item.upgrade >= 8 && item.upgrade < 12) {
                        for (int index6 = 0; index6 < value2; index6++) {
                            if (isChop) {
                                SmallImage.drawSmallImage(g, 627, inforX + 12 + index6 * 10, this.yPaint + 5, 0, StaticObj.VCENTER_HCENTER);
                            } else {
                                SmallImage.drawSmallImage(g, 628, inforX + 12 + index6 * 10, this.yPaint + 5, 0, StaticObj.VCENTER_HCENTER);
                            }
                        }
                        if (item.upgrade % 2 != 0) {
                            if (isChop) {
                                SmallImage.drawSmallImage(g, 637, inforX + 12 + value2 * 10, this.yPaint + 5, 0, StaticObj.VCENTER_HCENTER);
                            } else {
                                SmallImage.drawSmallImage(g, 638, inforX + 12 + value2 * 10, this.yPaint + 5, 0, StaticObj.VCENTER_HCENTER);
                            }
                        }
                    } else if (item.upgrade >= 12 && item.upgrade < 15) {
                        for (int index7 = 0; index7 < value2; index7++) {
                            if (isChop) {
                                SmallImage.drawSmallImage(g, 629, inforX + 12 + index7 * 10, this.yPaint + 5, 0, StaticObj.VCENTER_HCENTER);
                            } else {
                                SmallImage.drawSmallImage(g, 630, inforX + 12 + index7 * 10, this.yPaint + 5, 0, StaticObj.VCENTER_HCENTER);
                            }
                        }
                        if (item.upgrade % 2 != 0) {
                            if (isChop) {
                                SmallImage.drawSmallImage(g, 639, inforX + 12 + value2 * 10, this.yPaint + 5, 0, StaticObj.VCENTER_HCENTER);
                            } else {
                                SmallImage.drawSmallImage(g, 640, inforX + 12 + value2 * 10, this.yPaint + 5, 0, StaticObj.VCENTER_HCENTER);
                            }
                        }
                    } else {
                        for (int index8 = 0; index8 < value2; index8++) {
                            if (isChop) {
                                SmallImage.drawSmallImage(g, 631, inforX + 12 + index8 * 10, this.yPaint + 5, 0, StaticObj.VCENTER_HCENTER);
                            } else {
                                SmallImage.drawSmallImage(g, 632, inforX + 12 + index8 * 10, this.yPaint + 5, 0, StaticObj.VCENTER_HCENTER);
                            }
                        }
                        if (item.upgrade % 2 != 0) {
                            if (isChop) {
                                SmallImage.drawSmallImage(g, 641, inforX + 12 + value2 * 10, this.yPaint + 5, 0, StaticObj.VCENTER_HCENTER);
                            } else {
                                SmallImage.drawSmallImage(g, 642, inforX + 12 + value2 * 10, this.yPaint + 5, 0, StaticObj.VCENTER_HCENTER);
                            }
                        }
                    }
                } else if (item.isTypeMounts()) {
                    this.yPaint += 12;
                    int value9 = item.sys + 1;
                    for (int index10 = 0; index10 < value9; index10++) {
                        SmallImage.drawSmallImage(g, 633, inforX + 12 + index10 * 10, this.yPaint + 5, 0, StaticObj.VCENTER_HCENTER);
                    }
                }
                mFont.tahoma_7_white.drawString(g, item.isLock ? mResources.LOCKED : mResources.NOLOCK, inforX + 8, this.yPaint += 12, 0);
                if (item.isTypeBody() || item.isTypeMounts()) {
                    Item item11 = item;
                    String text;
                    if ((text = item.template.type == 12 ? mResources.SPECUPGRADE : (item11.template.level >= 10 && item11.template.type < 10 ? (item11.upgrade == 0 ? mResources.NOUPGRADE : null) : mResources.NOTUPGRADE)) != null) {
                        this.paintMultiLine(g, mFont.tahoma_7_white, text, inforX + 8, this.yPaint += 12, 0);
                        indexRowMax++;
                    }
                }
                if (item.template.gender == 0 || item.template.gender == 1) {
                    if (item.template.gender == Char.getMyChar().cgender) {
                        mFont.tahoma_7_white.drawString(g, mResources.GENDER[item.template.gender], inforX + 8, this.yPaint += 12, 0);
                        indexRowMax++;
                    } else {
                        mFont.tahoma_7_red.drawString(g, mResources.GENDER[item.template.gender], inforX + 8, this.yPaint += 12, 0);
                        indexRowMax++;
                    }
                }
                if (Char.getMyChar().clevel != -1) {
                    if (Char.getMyChar().clevel >= item.template.level) {
                        this.paintMultiLine(g, mFont.tahoma_7_white, mResources.LEVELNEED + " " + item.template.level, inforX + 8, this.yPaint += 12, 0);
                    } else {
                        this.paintMultiLine(g, mFont.tahoma_7_red, mResources.LEVELNEED + " " + item.template.level, inforX + 8, this.yPaint += 12, 0);
                    }
                }
                if ((item.template.id < 40 || item.template.id > 48) && item.template.id != 311 && item.template.id != 375 && item.template.id != 397 && item.template.id != 552 && item.template.id != 558) {
                    if ((item.template.id < 49 || item.template.id > 57) && item.template.id != 312 && item.template.id != 376 && item.template.id != 398 && item.template.id != 553 && item.template.id != 559) {
                        if ((item.template.id < 58 || item.template.id > 66) && item.template.id != 313 && item.template.id != 377 && item.template.id != 399 && item.template.id != 554 && item.template.id != 560) {
                            if ((item.template.id < 67 || item.template.id > 75) && item.template.id != 314 && item.template.id != 378 && item.template.id != 400 && item.template.id != 555 && item.template.id != 561) {
                                if ((item.template.id < 76 || item.template.id > 84) && item.template.id != 315 && item.template.id != 379 && item.template.id != 401 && item.template.id != 556 && item.template.id != 562) {
                                    if (item.template.id >= 85 && item.template.id <= 93 || item.template.id == 316 || item.template.id == 380 || item.template.id == 402 || item.template.id == 557 || item.template.id == 563) {
                                        boolean flag = false;
                                        if (Char.getMyChar().nClass.classId == 6) {
                                            mFont.tahoma_7_white.drawString(g, mResources.CLASSNEED + " " + nClasss[6].name, inforX + 8, this.yPaint += 12, 0);
                                        } else {
                                            mFont.tahoma_7_red.drawString(g, mResources.CLASSNEED + " " + nClasss[6].name, inforX + 8, this.yPaint += 12, 0);
                                        }
                                        indexRowMax++;
                                    }
                                } else {
                                    boolean flag12 = false;
                                    if (Char.getMyChar().nClass.classId == 5) {
                                        mFont.tahoma_7_white.drawString(g, mResources.CLASSNEED + " " + nClasss[5].name, inforX + 8, this.yPaint += 12, 0);
                                    } else {
                                        mFont.tahoma_7_red.drawString(g, mResources.CLASSNEED + " " + nClasss[5].name, inforX + 8, this.yPaint += 12, 0);
                                    }
                                    indexRowMax++;
                                }
                            } else {
                                boolean flag13 = false;
                                if (Char.getMyChar().nClass.classId == 4) {
                                    mFont.tahoma_7_white.drawString(g, mResources.CLASSNEED + " " + nClasss[4].name, inforX + 8, this.yPaint += 12, 0);
                                } else {
                                    mFont.tahoma_7_red.drawString(g, mResources.CLASSNEED + " " + nClasss[4].name, inforX + 8, this.yPaint += 12, 0);
                                }
                                indexRowMax++;
                            }
                        } else {
                            boolean flag14 = false;
                            if (Char.getMyChar().nClass.classId == 3) {
                                mFont.tahoma_7_white.drawString(g, mResources.CLASSNEED + " " + nClasss[3].name, inforX + 8, this.yPaint += 12, 0);
                            } else {
                                mFont.tahoma_7_red.drawString(g, mResources.CLASSNEED + " " + nClasss[3].name, inforX + 8, this.yPaint += 12, 0);
                            }
                            indexRowMax++;
                        }
                    } else {
                        boolean flag15 = false;
                        if (Char.getMyChar().nClass.classId == 2) {
                            mFont.tahoma_7_white.drawString(g, mResources.CLASSNEED + " " + nClasss[2].name, inforX + 8, this.yPaint += 12, 0);
                        } else {
                            mFont.tahoma_7_red.drawString(g, mResources.CLASSNEED + " " + nClasss[2].name, inforX + 8, this.yPaint += 12, 0);
                        }
                        indexRowMax++;
                    }
                } else {
                    boolean flag16 = false;
                    if (Char.getMyChar().nClass.classId == 1) {
                        mFont.tahoma_7_white.drawString(g, mResources.CLASSNEED + " " + nClasss[1].name, inforX + 8, this.yPaint += 12, 0);
                    } else {
                        mFont.tahoma_7_red.drawString(g, mResources.CLASSNEED + " " + nClasss[1].name, inforX + 8, this.yPaint += 12, 0);
                    }
                    indexRowMax++;
                }
                if (!item.isTypeMounts()) {
                    if (item.template.id == 420) {
                        if (Char.getMyChar().nClass.classId != 1 && Char.getMyChar().nClass.classId != 2) {
                            mFont.tahoma_7_red.drawString(g, mResources.SYSITEM[1], inforX + 8, this.yPaint += 12, 0);
                        } else {
                            mFont.tahoma_7_white.drawString(g, mResources.SYSITEM[1], inforX + 8, this.yPaint += 12, 0);
                        }
                        indexRowMax++;
                    } else if (item.template.id == 421) {
                        if (Char.getMyChar().nClass.classId != 3 && Char.getMyChar().nClass.classId != 4) {
                            mFont.tahoma_7_red.drawString(g, mResources.SYSITEM[2], inforX + 8, this.yPaint += 12, 0);
                        } else {
                            mFont.tahoma_7_white.drawString(g, mResources.SYSITEM[2], inforX + 8, this.yPaint += 12, 0);
                        }
                        indexRowMax++;
                    } else if (item.template.id == 422) {
                        if (Char.getMyChar().nClass.classId != 5 && Char.getMyChar().nClass.classId != 6) {
                            mFont.tahoma_7_red.drawString(g, mResources.SYSITEM[3], inforX + 8, this.yPaint += 12, 0);
                        } else {
                            mFont.tahoma_7_white.drawString(g, mResources.SYSITEM[3], inforX + 8, this.yPaint += 12, 0);
                        }
                        indexRowMax++;
                    }
                }
                if (item.expires > 0L) {
                    if (!item.isTypeUIShop() && !item.isTypeUIShopLock() && !item.isTypeUIStore() && !item.isTypeUIBook() && !item.isTypeUIFashion() && !item.isTypeUIClanShop() && item.typeUI != 39) {
                        if ((value1 = mFont.tahoma_7.getWidth(mResources.EXPIRES + ": " + item.getExpiresString()) + 10) > inforW && !GameCanvas.isTouchControlLargeScreen) {
                            inforW = value1;
                        }
                        this.paintMultiLine(g, mFont.tahoma_7_yellow, mResources.EXPIRES + ": " + item.getExpiresString(), inforX + 8, this.yPaint += 12, 0);
                    } else {
                        if ((value1 = mFont.tahoma_7.getWidth(mResources.EXPIRES + ": " + item.getExpiresShopString()) + 10) > inforW && !GameCanvas.isTouchControlLargeScreen) {
                            inforW = value1;
                        }
                        this.paintMultiLine(g, mFont.tahoma_7_yellow, mResources.EXPIRES + ": " + item.getExpiresShopString(), inforX + 8, this.yPaint += 12, 0);
                    }
                    indexRowMax++;
                }
                if (!item.template.description.equals("")) {
                    this.paintMultiLine(g, mFont.tahoma_7_white, item.template.description, inforX + 8, this.yPaint += 12, 0);
                    indexRowMax++;
                }
                if (item.isTypeUIMe() || item.typeUI == 37) {
                    mFont.tahoma_7_yellow.drawString(g, mResources.replace(mResources.COIN_LOCK_SALE, NinjaUtil.numberToString(String.valueOf(item.saleCoinLock))), inforX + 8, this.yPaint += 12, 0);
                    indexRowMax++;
                } else if (item.isTypeUIShop() || item.isTypeUIShopLock() || item.isTypeUIStore() || item.isTypeUIBook() || item.isTypeUIFashion() || item.isTypeUIClanShop()) {
                    if (item.buyCoin > 0) {
                        if (item.isTypeUIClanShop()) {
                            if ((value1 = mFont.tahoma_7.getWidth(mResources.replace(mResources.COIN_BUY_CLAN, NinjaUtil.numberToString(String.valueOf(item.buyCoin)))) + 10) > inforW && !GameCanvas.isTouchControlLargeScreen) {
                                inforW = value1;
                            }
                            mFont.tahoma_7_yellow.drawString(g, mResources.replace(mResources.COIN_BUY_CLAN, NinjaUtil.numberToString(String.valueOf(item.buyCoin))), inforX + 8, this.yPaint += 12, 0);
                        } else {
                            mFont.tahoma_7_yellow.drawString(g, mResources.replace(mResources.COIN_BUY, NinjaUtil.numberToString(String.valueOf(item.buyCoin))), inforX + 8, this.yPaint += 12, 0);
                        }
                        indexRowMax++;
                    } else if (item.buyCoinLock > 0) {
                        mFont.tahoma_7_yellow.drawString(g, mResources.replace(mResources.COIN_LOCK_BUY, NinjaUtil.numberToString(String.valueOf(item.buyCoinLock))), inforX + 8, this.yPaint += 12, 0);
                        indexRowMax++;
                    } else if (item.buyGold > 0) {
                        mFont.tahoma_7_yellow.drawString(g, mResources.replace(mResources.GOLD_BUY, NinjaUtil.numberToString(String.valueOf(item.buyGold))), inforX + 8, this.yPaint += 12, 0);
                        indexRowMax++;
                    }
                }
                if (item.template.type == 33) {
                    mFont.tahoma_7_yellow.drawString(g, mResources.Level + ": " + (item.upgrade + 1), inforX + 8, this.yPaint += 12, 0);
                    indexRowMax++;
                }
                if (item.isTypeBody() && item.sys != 0) {
                    mFont.tahoma_7_blue1.drawString(g, mResources.SYSITEM[item.sys], inforX + 8, this.yPaint += 12, 0);
                    indexRowMax++;
                }
                if (item.expires != 0L && item.options != null && item.options.size() > 0) {
                    boolean flag17 = false;
                    boolean flag18 = false;
                    for (int index19 = 0; index19 < item.options.size(); index19++) {
                        ItemOption itemOption = (ItemOption) item.options.elementAt(index19);
                        if (!flag17 && itemOption.optionTemplate.type == 2) {
                            flag17 = true;
                            String text20 = mResources.LINE[0] + ": ";
                            if (item.template.type == 1) {
                                text20 = text20 + mResources.BODY[item.template.type] + "(" + mResources.KICKSYS[this.itemFocus.sys] + ")";
                            } else if (item.template.type == 0) {
                                text20 = text20 + mResources.BODY[6] + "(" + mResources.KICKSYS[this.itemFocus.sys] + "), " + mResources.BODY[5] + "(" + mResources.KICKSYS[this.itemFocus.sys] + ")";
                            } else if (item.template.type == 6) {
                                text20 = text20 + mResources.BODY[0] + "(" + mResources.KICKSYS[this.itemFocus.sys] + "), " + mResources.BODY[5] + "(" + mResources.KICKSYS[this.itemFocus.sys] + ")";
                            } else if (item.template.type == 5) {
                                text20 = text20 + mResources.BODY[0] + "(" + mResources.KICKSYS[this.itemFocus.sys] + "), " + mResources.BODY[6] + "(" + mResources.KICKSYS[this.itemFocus.sys] + ")";
                            } else if (item.template.type == 2) {
                                text20 = text20 + mResources.BODY[8] + "(" + mResources.KICKSYS[this.itemFocus.sys] + "), " + mResources.BODY[7] + "(" + mResources.KICKSYS[this.itemFocus.sys] + ")";
                            } else if (item.template.type == 8) {
                                text20 = text20 + mResources.BODY[2] + "(" + mResources.KICKSYS[this.itemFocus.sys] + "), " + mResources.BODY[7] + "(" + mResources.KICKSYS[this.itemFocus.sys] + ")";
                            } else if (item.template.type == 7) {
                                text20 = text20 + mResources.BODY[2] + "(" + mResources.KICKSYS[this.itemFocus.sys] + "), " + mResources.BODY[8] + "(" + mResources.KICKSYS[this.itemFocus.sys] + ")";
                            } else if (item.template.type == 4) {
                                text20 = text20 + mResources.BODY[3] + "(" + mResources.KICKSYS[this.itemFocus.sys] + "), " + mResources.BODY[9] + "(" + mResources.KICKSYS[this.itemFocus.sys] + ")";
                            } else if (item.template.type == 3) {
                                text20 = text20 + mResources.BODY[4] + "(" + mResources.KICKSYS[this.itemFocus.sys] + "), " + mResources.BODY[9] + "(" + mResources.KICKSYS[this.itemFocus.sys] + ")";
                            } else if (item.template.type == 9) {
                                text20 = text20 + mResources.BODY[4] + "(" + mResources.KICKSYS[this.itemFocus.sys] + "), " + mResources.BODY[3] + "(" + mResources.KICKSYS[this.itemFocus.sys] + ")";
                            }
                            if ((value1 = mFont.tahoma_7_white.getWidth(text20) + 15) > inforW && !GameCanvas.isTouchControlLargeScreen) {
                                inforW = value1;
                            }
                            this.paintMultiLine(g, mFont.tahoma_7_white, text20, inforX + 8, this.yPaint += 12, 0);
                            indexRowMax++;
                        }
                        if (!flag18 && itemOption.optionTemplate.type > 2 && itemOption.optionTemplate.type < 8) {
                            flag18 = true;
                            mFont.tahoma_7_white.drawString(g, mResources.LINE[1], inforX + 8, this.yPaint += 12, 0);
                            indexRowMax++;
                        }
                        if (itemOption.optionTemplate.id == 65) {
                            this.paintMultiLine(g, mFont.tahoma_7_blue, item.template.id == 485 ? NinjaUtil.replace(itemOption.getOptionString(), mResources.EXP, mResources.MACHINE) : itemOption.getOptionString(), inforX + 8, this.yPaint += 12, 0);
                        } else if (itemOption.optionTemplate.id == 66) {
                            this.paintMultiLine(g, mFont.tahoma_7_blue1, item.template.id == 485 ? NinjaUtil.replace(itemOption.getOptionString(), mResources.VITALITY, mResources.POWER) : itemOption.getOptionString(), inforX + 8, this.yPaint += 12, 0);
                        } else if (itemOption.optionTemplate.type == 0) {
                            this.paintMultiLine(g, mFont.tahoma_7_blue1, item.isTypeUIShopView() ? itemOption.getOptionShopString() : itemOption.getOptionString(), inforX + 8, this.yPaint += 12, 0);
                        } else if (itemOption.optionTemplate.type == 1) {
                            this.paintMultiLine(g, mFont.tahoma_7_green, item.isTypeUIShopView() ? itemOption.getOptionShopString() : itemOption.getOptionString(), inforX + 8, this.yPaint += 12, 0);
                        } else if (itemOption.optionTemplate.type == 8) {
                            if (itemOption.optionTemplate.id == 85) {
                                mFont font21 = mFont.tahoma_7_yellow;
                                String text22;
                                if (item.isTypeUIShopView()) {
                                    text22 = itemOption.getOptionShopString();
                                } else {
                                    ItemOption itemOption23 = itemOption;
                                    text22 = NinjaUtil.replace(itemOption.optionTemplate.name, "#", String.valueOf(itemOption23.param));
                                }
                                this.paintMultiLine(g, font21, text22, inforX + 8, this.yPaint += 12, 0);
                            } else {
                                mFont font24 = mFont.tahoma_7b_blue;
                                item.isTypeUIShopView();
                                this.paintMultiLine(g, font24, itemOption.getOptionShopString(), inforX + 8, this.yPaint += 12, 0);
                            }
                        } else if (itemOption.optionTemplate.type == 2 && item.typeUI == 5 && itemOption.active == 1 || itemOption.optionTemplate.type == 3 && item.upgrade >= 4 || itemOption.optionTemplate.type == 4 && item.upgrade >= 8 || itemOption.optionTemplate.type == 5 && item.upgrade >= 12 || itemOption.optionTemplate.type == 6 && item.upgrade >= 14 || itemOption.optionTemplate.type == 7 && item.upgrade >= 16) {
                            this.paintMultiLine(g, mFont.tahoma_7_green, item.isTypeUIShopView() ? itemOption.getOptionShopString() : itemOption.getOptionString(), inforX + 8, this.yPaint += 12, 0);
                        } else {
                            this.paintMultiLine(g, mFont.tahoma_7_grey, item.isTypeUIShopView() ? itemOption.getOptionShopString() : itemOption.getOptionString(), inforX + 8, this.yPaint += 12, 0);
                        }
                        indexRowMax++;
                    }
                }
                if (isPaintLuckySpin) {
                    if (item.template.id == 12) {
                        mFont.tahoma_7_red.drawString(g, NinjaUtil.numberToString(this.yenValue[indexSelect]) + " " + mResources.YEN, inforX + 8, this.yPaint += 12, 0);
                    }
                    if (item.template.type >= 0 && item.template.type <= 9) {
                        mFont.tahoma_7_yellow.drawString(g, mResources.MAX_OPTIONS, inforX + 8, this.yPaint += 12, 0);
                    }
                    indexRowMax++;
                }
                if (indexRow >= 0 && (!GameCanvas.isTouch || GameCanvas.isTouch && GameCanvas.w < 320)) {
                    SmallImage.drawSmallImage(g, 942, inforX + 1, inforY + 5 + indexRow * 12, 0, StaticObj.TOP_LEFT);
                }
                scrInfo.setStyle(indexRowMax, 12, inforX, inforY + 2, inforW, inforH - 4, true, 1);
            } else if (Char.clan != null) {
                this.yPaint = inforY - 9;
                indexRowMax = 2;
                scrInfo.setClip(g, inforX, inforY + 2, inforW, inforH - 2);
                inforW = mFont.tahoma_7_white.getWidth(mResources.CLAN_ITEM[Char.clan.itemLevel][1]) + 10;
                for (int index25 = 0; index25 < 2; index25++) {
                    mFont.tahoma_7_white.drawString(g, mResources.CLAN_ITEM[Char.clan.itemLevel][index25], inforX + 8, this.yPaint += 12, 0);
                }
                if (indexRow >= 0 && (!GameCanvas.isTouch || GameCanvas.isTouch && GameCanvas.w < 320)) {
                    SmallImage.drawSmallImage(g, 942, inforX + 1, inforY + 5 + indexRow * 12, 0, StaticObj.TOP_LEFT);
                }
                scrInfo.setStyle(indexRowMax, 12, inforX, inforY + 2, inforW, inforH - 4, true, 1);
            }
        }
    }

    private static void paintInforFrame(mGraphics g) {
        resetTranslate(g);
        g.setColor(0);
        g.fillRect(inforX - 2, inforY - 2, inforW + 5, inforH + 5);
        g.setColor(13606712);
        g.drawRect(inforX - 1, inforY - 1, inforW + 2, inforH + 2);
        g.setColor(Paint.COLORBACKGROUND);
        g.fillRect(inforX, inforY, inforW, inforH);
    }

    private static void setInfoFrameForLargeScreen() {
        if (GameCanvas.isTouchControlLargeScreen && (!isPaintClan || indexMenu != 0)) {
            inforX = popupX + 175;
            inforW = popupW - 179;
            inforY = popupY + 33;
            inforH = 138;
            if (isPaintTrade && indexMenu == 0) {
                inforX = popupX + 6 + 3 * indexSize;
                inforW = popupW - (11 + 6 * indexSize);
            }
            if (isPaintInfoMe) {
                if (indexMenu == 4) {
                    inforX = popupX + 33;
                    inforY = popupY + 87;
                    inforW = popupW - 67;
                    inforH = 75;
                    return;
                }
                if (indexMenu == 5) {
                    inforH = 161;
                }
            }
        }
    }

    public final void setLCR() {
        super.center = null;
        if (indexTitle != 0 || indexMenu != 1 && indexMenu != 3 && indexMenu != 4) {
            switch(indexMenu) {
                case 0:
                    if (indexTitle == 1) {
                        if (getItemFocus(3) != null) {
                            super.left = this.cmdBagSelectItem;
                            if (GameCanvas.isTouch && GameCanvas.w < 320 || !GameCanvas.isTouch) {
                                super.center = this.cmdBagViewItemInfo;
                            }
                        } else {
                            nso.GameScr.isPaintItemInfo = false;
                            super.left = this.cmdBagSortItem;
                        }
                    }
                    break;
                case 1:
                    if (indexTitle == 1) {
                        super.left = null;
                        if (indexSelect >= 0) {
                            SkillTemplate skillTemplate = Char.getMyChar().nClass.skillTemplates[indexSelect];
                            Skill skill;
                            if ((skill = Char.getMyChar().getSkill(skillTemplate)) != null) {
                                if (skill.point < skillTemplate.maxPoint) {
                                    super.left = new Command(mResources.UPPOINT, 14001);
                                }
                                if (skill.template.type != 1 && skill.template.type != 4 && skill.template.type != 2 && skill.template.type != 3) {
                                    super.center = null;
                                } else {
                                    super.center = new Command(mResources.SHORCUT, 11081);
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    if (indexTitle >= 1) {
                        super.left = new Command(mResources.UPPOINT, 11084);
                        super.center = new Command("", 11084);
                    }
                    break;
                case 3:
                    super.left = null;
                    super.center = new Command(mResources.CHANGE, 110854);
                    break;
                case 4:
                    if (indexTitle == 1) {
                        super.left = null;
                        Item item;
                        if ((item = getItemFocus(5)) != null) {
                            if (currentCharViewInfo.charID == Char.getMyChar().charID) {
                                super.left = new Command(mResources.SELECT, 11082);
                                if (GameCanvas.isTouchControlLargeScreen) {
                                    this.updateItemInfo(5, item);
                                } else {
                                    super.center = new Command(mResources.VIEW, 11083);
                                }
                            } else if (GameCanvas.isTouchControlLargeScreen) {
                                this.updateItemInfo(5, item);
                            } else {
                                super.center = new Command(mResources.VIEW, 11083);
                            }
                        } else {
                            nso.GameScr.isPaintItemInfo = false;
                            if (!GameCanvas.isTouch && indextabTrangbi > 0) {
                                super.left = new Command(mResources.tbi1, 2003);
                            }
                        }
                    }
                    break;
                case 5:
                    super.left = null;
                    if (indexTitle == 1 && indexSelect >= 0 && currentCharViewInfo.arrItemMounts[indexSelect] != null) {
                        if (Char.getMyChar().charID == currentCharViewInfo.charID) {
                            super.left = new Command(mResources.MOVEOUT, 1516);
                        }
                        super.center = new Command(GameCanvas.isTouchControlLargeScreen ? "" : mResources.VIEW, 1515);
                    }
                    break;
                case 6:
                    if (indexBijuuMenu == 0) {
                        super.left = null;
                        if (indexTitle == 1 && indexSelect >= 0 && currentCharViewInfo.arrItemViThu[indexSelect] != null) {
                            if (Char.getMyChar().charID == currentCharViewInfo.charID) {
                                super.left = new Command(mResources.MOVEOUT, 508);
                            }
                            super.center = new Command(GameCanvas.isTouchControlLargeScreen ? "" : mResources.VIEW, 503);
                        }
                    } else if (indexBijuuMenu == 1) {
                        if (indexTitle >= 1) {
                            super.left = new Command(mResources.UPPOINT, 504);
                        }
                    } else {
                        if (indexTitle == 1) {
                            super.left = null;
                            if (indexSelect >= 0) {
                                SkillTemplate skillTemplate1 = Char.getMyChar().nClass.skillTemplates[indexSelect];
                                Skill skill2;
                                if ((skill2 = Char.getMyChar().getSkill(skillTemplate1)) != null) {
                                    if (skill2.point < skillTemplate1.maxPoint) {
                                        super.left = new Command(mResources.UPPOINT, 14001);
                                    }
                                    if (skill2.template.type != 1 && skill2.template.type != 4 && skill2.template.type != 2 && skill2.template.type != 3) {
                                        super.center = null;
                                    } else {
                                        super.center = new Command(mResources.SHORCUT, 11081);
                                    }
                                }
                            }
                        }
                        if (indexTitle == 1) {
                            super.left = null;
                            if (indexSelect >= 0) {
                                SkillTemplate skillTemplate3 = Char.getMyChar().nClass.skillTemplates[indexSelect];
                                Skill skill4;
                                if ((skill4 = Char.getMyChar().getSkill(skillTemplate3)) != null) {
                                    if (skill4.point < skillTemplate3.maxPoint) {
                                        super.left = new Command(mResources.UPPOINT, 505);
                                    }
                                    super.center = null;
                                }
                            }
                        }
                    }
            }
            if (indexMenu != 6 && currentCharViewInfo.charID == Char.getMyChar().charID) {
                super.right = new Command(mResources.BACK, 11086);
            } else {
                super.right = this.cmdCloseAll;
            }
        } else {
            super.left = null;
        }
    }

    public final void doOpenUI(int typeUI) {
        indexTitle = 0;
        super.right = this.cmdCloseAll;
        switch(typeUI) {
            case 2:
                indexMenu = 0;
                nso.GameScr.isPaintWeapon = true;
                if (nso.GameScr.arrItemWeapon == null) {
                    Service.gI().requestItem(2);
                }
            case 3:
            case 5:
            case 30:
            case 39:
            case 41:
            case 42:
            case 51:
            default:
                break;
            case 4:
                indexMenu = 0;
                nso.GameScr.isPaintBox = true;
                if (Char.getMyChar().arrItemBox == null) {
                    Service.gI().requestItem(4);
                }
                break;
            case 6:
                indexMenu = 0;
                nso.GameScr.isPaintStack = true;
                if (nso.GameScr.arrItemStack == null) {
                    Service.gI().requestItem(6);
                }
                break;
            case 7:
                indexMenu = 0;
                nso.GameScr.isPaintStackLock = true;
                if (nso.GameScr.arrItemStackLock == null) {
                    Service.gI().requestItem(7);
                }
                break;
            case 8:
                indexMenu = 0;
                nso.GameScr.isPaintGrocery = true;
                if (nso.GameScr.arrItemGrocery == null) {
                    Service.gI().requestItem(8);
                }
                break;
            case 9:
                indexMenu = 0;
                nso.GameScr.isPaintGroceryLock = true;
                if (nso.GameScr.arrItemGroceryLock == null) {
                    Service.gI().requestItem(9);
                }
                break;
            case 10:
                indexMenu = 0;
                nso.GameScr.isPaintUpGrade = true;
                arrItemUpGrade = new Item[18];
                break;
            case 11:
                indexMenu = 0;
                nso.GameScr.isPaintUpPearl = true;
                isTypeXu = true;
                arrItemUpPeal = new Item[24];
                break;
            case 12:
                indexMenu = 0;
                nso.GameScr.isPaintUpPearl = true;
                isTypeXu = false;
                arrItemUpPeal = new Item[24];
                break;
            case 13:
                indexMenu = 0;
                nso.GameScr.isPaintSplit = true;
                arrItemSplit = new Item[24];
                break;
            case 14:
                isPaintStore = true;
                indexMenu = 0;
                if (nso.GameScr.arrItemStore == null) {
                    Service.gI().requestItem(14);
                }
                break;
            case 15:
                isPaintStore = true;
                indexMenu = 1;
                if (nso.GameScr.arrItemBook == null) {
                    Service.gI().requestItem(15);
                }
                break;
            case 16:
                indexMenu = 0;
                nso.GameScr.isPaintLien = true;
                if (nso.GameScr.arrItemLien == null) {
                    Service.gI().requestItem(16);
                }
                break;
            case 17:
                indexMenu = 0;
                nso.GameScr.isPaintNhan = true;
                if (nso.GameScr.arrItemNhan == null) {
                    Service.gI().requestItem(17);
                }
                break;
            case 18:
                indexMenu = 0;
                nso.GameScr.isPaintNgocBoi = true;
                if (nso.GameScr.arrItemNgocBoi == null) {
                    Service.gI().requestItem(18);
                }
                break;
            case 19:
                indexMenu = 0;
                nso.GameScr.isPaintPhu = true;
                if (nso.GameScr.arrItemPhu == null) {
                    Service.gI().requestItem(19);
                }
                break;
            case 20:
                indexMenu = 0;
                nso.GameScr.isPaintNonNam = true;
                if (nso.GameScr.arrItemNonNam == null) {
                    Service.gI().requestItem(20);
                }
                break;
            case 21:
                indexMenu = 0;
                nso.GameScr.isPaintNonNu = true;
                if (nso.GameScr.arrItemNonNu == null) {
                    Service.gI().requestItem(21);
                }
                break;
            case 22:
                indexMenu = 0;
                nso.GameScr.isPaintAoNam = true;
                if (nso.GameScr.arrItemAoNam == null) {
                    Service.gI().requestItem(22);
                }
                break;
            case 23:
                indexMenu = 0;
                nso.GameScr.isPaintAoNu = true;
                if (nso.GameScr.arrItemAoNu == null) {
                    Service.gI().requestItem(23);
                }
                break;
            case 24:
                indexMenu = 0;
                nso.GameScr.isPaintGangTayNam = true;
                if (nso.GameScr.arrItemGangTayNam == null) {
                    Service.gI().requestItem(24);
                }
                break;
            case 25:
                indexMenu = 0;
                nso.GameScr.isPaintGangTayNu = true;
                if (nso.GameScr.arrItemGangTayNu == null) {
                    Service.gI().requestItem(25);
                }
                break;
            case 26:
                indexMenu = 0;
                nso.GameScr.isPaintQuanNam = true;
                if (nso.GameScr.arrItemQuanNam == null) {
                    Service.gI().requestItem(26);
                }
                break;
            case 27:
                indexMenu = 0;
                nso.GameScr.isPaintQuanNu = true;
                if (nso.GameScr.arrItemQuanNu == null) {
                    Service.gI().requestItem(27);
                }
                break;
            case 28:
                indexMenu = 0;
                nso.GameScr.isPaintGiayNam = true;
                if (nso.GameScr.arrItemGiayNam == null) {
                    Service.gI().requestItem(28);
                }
                break;
            case 29:
                indexMenu = 0;
                nso.GameScr.isPaintGiayNu = true;
                if (nso.GameScr.arrItemGiayNu == null) {
                    Service.gI().requestItem(29);
                }
                break;
            case 31:
                indexMenu = 0;
                nso.GameScr.isPaintUpGrade = true;
                isPaintUpGradeGold = true;
                arrItemUpGrade = new Item[18];
                break;
            case 32:
                isPaintStore = true;
                indexMenu = 2;
                if (nso.GameScr.arrItemFashion == null) {
                    Service.gI().requestItem(32);
                }
                break;
            case 33:
                indexMenu = 0;
                nso.GameScr.isPaintConvert = true;
                arrItemConvert = new Item[3];
                break;
            case 34:
                isPaintStore = true;
                indexMenu = 3;
                if (nso.GameScr.arrItemClanShop == null) {
                    Service.gI().requestItem(34);
                }
                break;
            case 35:
                nso.GameScr.isPaintEliteShop = true;
                indexMenu = 0;
                if (nso.GameScr.arrItemElites == null) {
                    Service.gI().requestItem(35);
                }
                break;
            case 36:
                indexMenu = 0;
                GameScr gameScr = this;
                nso.GameScr.isPaintAuctionSale = true;
                itemSell = null;
                gameScr.tfText = new TField();
                gameScr.tfText.setMaxTextLenght(9);
                gameScr.tfText.setIputType(1);
                gameScr.tfText.width = 100;
                gameScr.tfText.height = mScreen.ITEM_HEIGHT + 2;
                break;
            case 37:
                isPaintAuctionBuy = true;
                this.updateCommandForUI();
                break;
            case 38:
                arrItemSprin = null;
                isPaintLuckySpin = true;
                indexTitle = 1;
                this.updateCommandForUI();
                break;
            case 40:
                isPaintAuto = true;
                indexTitle = 1;
                indexRow = 0;
                this.updateCommandForUI();
                break;
            case 43:
                indexMenu = 0;
                nso.GameScr.isPaintLuyenThach = true;
                arrItemUpPeal = new Item[24];
                break;
            case 44:
                indexMenu = 0;
                nso.GameScr.isPaintTinhluyen = true;
                arrItemSplit = new Item[24];
                break;
            case 45:
                indexMenu = 0;
                nso.GameScr.isPaintDichChuyen = true;
                arrItemSplit = new Item[24];
                break;
            case 46:
                indexMenu = 0;
                nso.GameScr.isPaintLuyenNgoc = true;
                arrItemSplit = new Item[24];
                break;
            case 47:
                indexMenu = 0;
                nso.GameScr.isPaintKhamNgoc = true;
                arrItemUpGrade = new Item[18];
                break;
            case 48:
                indexMenu = 0;
                nso.GameScr.isPaintGiaoDo = true;
                arrItemSplit = new Item[18];
                break;
            case 49:
                indexMenu = 0;
                nso.GameScr.isPaintGotNgoc = true;
                itemSplit = null;
                break;
            case 50:
                indexMenu = 0;
                nso.GameScr.isPaintThaoNgoc = true;
                itemSplit = null;
                break;
            case 52:
                isPaintStore = true;
                indexMenu = 52;
                Service.gI().requestItem(52);
                break;
            case 53:
                indexMenu = 0;
                nso.GameScr.isPaintCheDo = true;
                arrItemSplit = new Item[24];
        }
        setPopupSize(175, 200);
        GameScr gameScr1 = this;
        this.craftSlotX = new int[9];
        gameScr1.craftSlotY = new int[9];
        int value = popupX + 3;
        int value2 = popupY + 34 + indexSize;
        gameScr1.craftSlotX[0] = popupX + 74;
        gameScr1.craftSlotY[0] = value2 + 4;
        gameScr1.craftSlotX[1] = value + 1;
        gameScr1.craftSlotY[1] = value2 - indexSize;
        gameScr1.craftSlotX[2] = value + popupW / 2 - indexSize / 2 - 2;
        gameScr1.craftSlotY[2] = value2 - indexSize;
        gameScr1.craftSlotX[3] = gameScr1.craftSlotX[1];
        gameScr1.craftSlotX[4] = gameScr1.craftSlotX[0];
        gameScr1.craftSlotX[5] = gameScr1.craftSlotX[2];
        gameScr1.craftSlotY[3] = gameScr1.craftSlotY[1] + indexSize * 3 - 2;
        gameScr1.craftSlotY[4] = gameScr1.craftSlotY[1] + indexSize * 3 - 2;
        gameScr1.craftSlotY[5] = gameScr1.craftSlotY[1] + indexSize * 3 - 2;
        gameScr1.craftSlotX[6] = gameScr1.craftSlotX[1];
        gameScr1.craftSlotX[7] = gameScr1.craftSlotX[0];
        gameScr1.craftSlotX[8] = gameScr1.craftSlotX[2];
        gameScr1.craftSlotY[6] = gameScr1.craftSlotY[1] + (indexSize << 2) + 10;
        gameScr1.craftSlotY[7] = gameScr1.craftSlotY[1] + (indexSize << 2) + 10;
        gameScr1.craftSlotY[8] = gameScr1.craftSlotY[1] + (indexSize << 2) + 10;
    }

    public static Char findCharInMap(int charId) {
        for (int index = 0; index < vCharInMap.size(); index++) {
            Char character;
            if ((character = (Char) vCharInMap.elementAt(index)).charID == charId) {
                return character;
            }
        }
        return null;
    }

    public static BuNhin findBuNhinInMap(int index) {
        return vBuNhin.size() > 0 ? (BuNhin) vBuNhin.elementAt(index) : null;
    }

    public final void onChatFromMe(String text, String to) {
        if (!isPaintMessage || GameCanvas.isTouch) {
            ChatTextField.gI().isShow = false;
        }
        nso.GameScr.menuCooldown = 5;
        if (!text.equals("")) {
            if (to.equals(mResources.PUBLICCHAT[0])) {
                Service.gI().chat(text);
            } else if (to.equals(mResources.PARTYCHAT[0])) {
                if (vParty.size() == 0) {
                    ChatManager.gI().getCurrentChatTab().addInfo(mResources.NOT_IN_PARTY);
                } else {
                    Service.gI().chatParty(text);
                }
            } else if (to.equals(mResources.GLOBALCHAT[0])) {
                Service.gI().chatGlobal(text);
            } else if (to.equals(mResources.CLANCHAT[0])) {
                if (Char.getMyChar().cClanName.equals("")) {
                    ChatManager.gI().getCurrentChatTab().addInfo(mResources.NOT_IN_CLAN);
                } else {
                    Service.gI().chatClan(text);
                }
            } else {
                ChatManager.gI().addChat(to, Char.getMyChar().cName, text);
                Service.gI().chatPrivate(to, text);
            }
        }
    }

    public final void onCancelChat() {
        if (isPaintMessage) {
            this.doCloseAlert();
            isPaintMessage = false;
            ChatTextField.gI().center = null;
        }
    }

    private void indexPointer(int x, int y, int numCols, int numRows, int title) {
        if (nso.GameScr.isPaintUpPearl || nso.GameScr.isPaintLuyenThach || nso.GameScr.isPaintTinhluyen || nso.GameScr.isPaintDichChuyen || nso.GameScr.isPaintSplit || isPaintTrade || nso.GameScr.isPaintUpGrade || nso.GameScr.isPaintConvert || nso.GameScr.isPaintAuctionSale || nso.GameScr.isPaintLuyenNgoc || nso.GameScr.isPaintCheDo || nso.GameScr.isPaintKhamNgoc || nso.GameScr.isPaintGotNgoc || nso.GameScr.isPaintThaoNgoc) {
            int value = numCols * indexSize;
            numRows *= indexSize;
            scrMain.clear();
            if (GameCanvas.isPointerHoldIn(x, y, value, numRows)) {
                indexTitle = title;
                if (GameCanvas.isPointerClick) {
                    if ((x = (GameCanvas.pxLast - x) / indexSize + (GameCanvas.pyLast - y) / indexSize * numCols) / columns < rows) {
                        indexSelect = x;
                    }
                    super.left = super.center = null;
                    if (isPaintTrade) {
                        if (indexSelect < 0) {
                            indexSelect = 11;
                        }
                        if (indexSelect > 11) {
                            indexSelect = 11;
                        }
                    }
                    this.updateCommandForUI();
                }
            }
        }
    }

    public final void actionPerform(int idAction, Object p) {
        String text = null;
        System.out.println("cho nay ne " + idAction);
        text = null;
        MyVector entries = null;
        switch(idAction) {
            case 1:
                GameCanvas.endDlg();
                return;
            case 2:
                GameCanvas.endDlg();
                super.left = super.center = null;
                this.updateCommandForUI();
                return;
            case 3:
                this.doCloseAlert();
                return;
            case 222:
                this.actSplitItemBag_luyenngoc();
                return;
            case 333:
                this.doOpenUI(47);
                return;
            case 334:
                this.actUpgrade_HanhTrang();
                return;
            case 335:
                nso.GameScr.isViewNext = false;
                this.updateItemInfo(3, itemSplit);
                return;
            case 336:
                nso.GameScr.isViewNext = false;
                this.updateItemInfo(3, itemUpGrade);
                return;
            case 337:
                this.act_update_khamngoc();
                return;
            case 338:
                this.setCMD_act_KhamNgoc(0);
                return;
            case 339:
                this.actKhamNgocMoveOut(0);
                return;
            case 340:
                this.actKhamNgocMoveOut(1);
                return;
            case 341:
                this.khamngoc();
                return;
            case 342:
                actConfirmKhamNgoc();
                return;
            case 343:
                this.actKhamNgocMoveOut(2);
                return;
            case 344:
                this.setCMD_act_KhamNgoc(1);
                return;
            case 345:
                this.setCMD_act_KhamNgoc(2);
                return;
            case 400:
                this.act_update_giaodo();
                return;
            case 401:
                this.setCMD_act_GiaoDo();
                return;
            case 402:
                this.actGiaoDoMoveOut();
                return;
            case 403:
                sendGiaoDo();
                return;
            case 405:
                actSplitItemBag_gotngoc();
                return;
            case 500:
                this.actBijuuSelect();
                return;
            case 501:
                Service.gI().itemMonToBag(indexSelect);
                return;
            case 502:
                this.doBiJuu();
                return;
            case 503:
                this.updateItemInfo(51, currentCharViewInfo.arrItemViThu[indexSelect]);
                return;
            case 504:
                actBijuuMenuPoint();
                return;
            case 505:
                actBijuuKyNang();
                return;
            case 508:
                Service.gI().doRemoveVithu(indexSelect);
                return;
            case 999:
                this.doOpenUI(35);
                return;
            case 1000:
                Service.gI().rewardPB();
                this.resetButton();
                return;
            case 1500:
                (entries = new MyVector()).addElement(new Command(mResources.MOVEOUT, 15001));
                if (Char.getMyChar().xu >= 5000) {
                    entries.addElement(new Command(mResources.SALE, 15002));
                }
                GameCanvas.menu.startAt(entries);
                return;
            case 1501:
                this.updateItemInfo(3, itemSell);
                return;
            case 1502:
                this.tfText.showNativeTextBox();
                return;
            case 1503:
                doBagToStand();
                return;
            case 1504:
                domenuItemStand();
                return;
            case 1505:
                this.updateItemInfo(3, arrItemStands[indexSelect].item);
                return;
            case 1506:
                if (arrItemSprin != null) {
                    this.yenTemp = 0;
                    nso.GameScr.isPaintItemInfo = false;
                    indexCard = -1;
                    arrItemSprin = null;
                    gI().left = new Command(mResources.SELECT, 1506);
                    return;
                }
                indexCard = indexSelect;
                Service.gI().selectCard();
                GameCanvas.startWaitDlgWithoutCancel();
                return;
            case 1507:
                this.doviewCardsInfo();
                return;
            case 1508:
                entries = new MyVector();
                Item item;
                if ((item = Char.clan.items[indexSelect]) != null) {
                    if (item.template.id == 281) {
                        entries.addElement(new Command(mResources.USE, 15081));
                    } else {
                        entries.addElement(new Command(mResources.CLAN_BOX, 15082));
                    }
                    GameCanvas.menu.startAt(entries);
                    return;
                }
                break;
            case 1509:
                if (indexSelect >= 0 && Char.clan != null) {
                    this.updateItemInfo(39, Char.clan.items[indexSelect]);
                    return;
                }
                nso.GameScr.isPaintItemInfo = false;
                return;
            case 1510:
                doAutoSelect();
                return;
            case 1511:
                text = GameCanvas.inputDlg.tfInput.getText();
                GameCanvas.endDlg();
                try {
                    if (text.equals("")) {
                        GameCanvas.startOKDlg(mResources.INVALID_NUM);
                        return;
                    }
                    int value;
                    if ((value = (Integer.valueOf(text)).intValue()) >= 10 && value <= 90) {
                        Char.aHpValue = value;
                        return;
                    }
                    GameCanvas.startOKDlg(mResources.INVALID_NUM);
                    return;
                } catch (Exception exception) {
                    GameCanvas.startOKDlg(mResources.INVALID_NUM);
                    return;
                }
            case 1512:
                text = GameCanvas.inputDlg.tfInput.getText();
                GameCanvas.endDlg();
                try {
                    if (text.equals("")) {
                        GameCanvas.startOKDlg(mResources.INVALID_NUM);
                        return;
                    }
                    int value1;
                    if ((value1 = (Integer.valueOf(text)).intValue()) >= 10 && value1 <= 90) {
                        Char.aMpValue = value1;
                        return;
                    }
                    GameCanvas.startOKDlg(mResources.INVALID_NUM);
                    return;
                } catch (Exception exception32) {
                    GameCanvas.startOKDlg(mResources.INVALID_NUM);
                    return;
                }
            case 1515:
                this.updateItemInfo(41, currentCharViewInfo.arrItemMounts[indexSelect]);
                return;
            case 1516:
                Service.gI().itemMonToBag(indexSelect);
                return;
            case 1600:
                doLuyenThach();
                return;
            case 1601:
                actLuyenThachSelect();
                return;
            case 1602:
                Item item2 = getItemFocus(43);
                this.updateItemInfo(3, item2);
                return;
            case 1603:
                this.actgetLuyenThachItems();
                return;
            case 1604:
                entries = new MyVector();
                if (arrItemSplit[indexSelect] != null) {
                    entries.addElement(new Command(mResources.MOVEOUT, 1605));
                }
                entries.addElement(new Command(mResources.BEGIN, 11105));
                GameCanvas.menu.startAt(entries);
                return;
            case 1605:
                this.actTinhLuyenMoveOut();
                return;
            case 1606:
                this.actDichChuyenTrangBiLeft();
                return;
            case 1700:
                this.luckyDraw_refresh();
                return;
            case 1701:
                luckyDraw_Tf();
                return;
            case 1702:
                this.doCloseLucky_Draw();
                return;
            case 2000:
                Service.gI().rewardCT();
                this.resetButton();
                return;
            case 2001:
                Service.gI().throwItem(indexSelect);
                return;
            case 2002:
                GameCanvas.endDlg();
                return;
            case 2003:
                if (indextabTrangbi == 0) {
                    indextabTrangbi = 16;
                    this.cmdTrangbi2.caption = mResources.tbi1;
                    return;
                }
                indextabTrangbi = 0;
                this.cmdTrangbi2.caption = mResources.tbi2;
                if (!GameCanvas.isTouch) {
                    super.left = new Command(mResources.SELECT, 11082);
                    return;
                }
                break;
            case 2004:
                return;
            case 2025:
                GameCanvas.startYesNoDlg(mResources.hoixoa, new Command("yes", 20251), new Command("no", 20252));
                return;
            case 5021:
                this.doBiJuu_Point();
                return;
            case 5022:
                this.doBiJuu_Skill();
                return;
            case 5041:
                Service.gI().upPotential(indexTitle - 1, 1);
                this.setLCR();
                return;
            case 5042:
                this.doBijuuUpPoint();
                return;
            case 5043:
                actBijuuUpPoint();
                return;
            case 5051:
                Service.gI().upSkill(Char.getMyChar().nClass.skillTemplates[indexSelect].id, 1);
                this.setLCR();
                return;
            case 5052:
                this.doBijuuUpSkill();
                return;
            case 5053:
                actBijSkillUpPoint();
                break;
            case 9999:
                this.doOpenUI(37);
                return;
            case 11000:
                actMenu();
                return;
            case 11001:
                Char.getMyChar().findNextFocusByKey();
                return;
            case 11002:
                actAddFriendAccept();
                return;
            case 11003:
                actSkillUpPoint();
                return;
            case 11004:
                this.actView((byte) 25);
                return;
            case 11005:
                actGangTayNuBuy();
                return;
            case 11006:
                actAddPotential();
                return;
            case 11007:
                this.actView((byte) 24);
                return;
            case 11008:
                actGangTayNamBuy();
                return;
            case 11009:
                this.actView((byte) 23);
                return;
            case 11010:
                actAoNuBuy();
                return;
            case 11011:
                this.actView((byte) 22);
                return;
            case 11012:
                actAoNamBuy();
                return;
            case 11013:
                this.actView((byte) 21);
                return;
            case 11014:
                actNonNuBuy();
                return;
            case 11015:
                this.actView((byte) 20);
                return;
            case 11016:
                actNonNamBuy();
                return;
            case 11017:
                this.actView((byte) 15);
                return;
            case 11018:
                actStoreLockBuy();
                return;
            case 11019:
                this.actView((byte) 14);
                return;
            case 11020:
                actStoreBuy();
                return;
            case 11021:
                nso.GameScr.svTitle = "";
                nso.GameScr.svAction = "";
                this.resetButton();
                return;
            case 11022:
                this.actBagSelectItem();
                return;
            case 11023:
                this.actBagViewItemInfo();
                return;
            case 11024:
                actBagThrowItem();
                return;
            case 11025:
                this.doCloseItemInfo();
                return;
            case 11026:
                actBagUseItem();
                return;
            case 11027:
                this.actTradeSelectInList();
                return;
            case 11028:
                this.actTradeSelectInBag();
                return;
            case 11029:
                this.actTradeSelectItem();
                return;
            case 11030:
                this.actTradeViewItemInfo();
                return;
            case 11032:
                this.actTradeLock();
                return;
            case 11033:
                this.actTradeAccept();
                return;
            case 11034:
                this.actUpgradeMoveOut();
                return;
            case 11035:
                this.actSplitMoveOut();
                return;
            case 11036:
                actionCoinTrade();
                return;
            case 11037:
                this.actTradeMoveOut();
                return;
            case 11038:
                actDead();
                return;
            case 11040:
                this.actleftItemInfo();
                return;
            case 11041:
                this.actrightItemInfo();
                return;
            case 11042:
                actCoinOut();
                return;
            case 11043:
                actCoinIn();
                return;
            case 11044:
                domenuFriendLeft();
                return;
            case 11045:
                domenuFindTeam();
                return;
            case 11046:
                domenuFindTeamCenter();
                return;
            case 11047:
                domenuTeamLeft();
                return;
            case 11048:
                actBoxSort();
                return;
            case 11049:
                actionCoinOut();
                return;
            case 11050:
                actionCoinIn();
                return;
            case 11051:
                actUseItem();
                return;
            case 11052:
                Item item3 = (Item) p;
                Service.gI().useItemChangeMap(item3.indexUI, GameCanvas.menu.menuSelectedItem);
                return;
            case 11053:
                Item item4;
                doItemChangeMap(item4 = (Item) p);
                return;
            case 11054:
                this.doOpenUIZone();
                return;
            case 11055:
                Item item5;
                doActionBuy(item5 = (Item) p);
                return;
            case 11057:
                Npc npc = (Npc) p;
                Service.gI().getTask(npc.template.npcTemplateId, GameCanvas.menu.menuSelectedItem, -1);
                return;
            case 11058:
                Item item6 = (Item) p;
                GameCanvas.endDlg();
                Service.gI().saleItem(item6.indexUI, Integer.parseInt(GameCanvas.inputDlg.tfInput.getText()));
                return;
            case 11059:
                this.actdoChooseSkill();
                return;
            case 11060:
                this.actdoMiniInfo();
                return;
            case 11061:
                Item item7;
                actSaleConfirm(item7 = (Item) p);
                return;
            case 11062:
                upPearl();
                return;
            case 11063:
                actConfirmUpgrade();
                return;
            case 11064:
                Service.gI().upPotential(indexTitle - 1, 1);
                this.setLCR();
                return;
            case 11065:
                this.doUpPotential();
                return;
            case 11066:
                this.doCloseAlert();
                isPaintMessage = false;
                nso.GameScr.isMessageMenu = false;
                ChatTextField.gI().center = null;
                return;
            case 11067:
                if (TileMap.zoneID != indexSelect) {
                    Service.gI().requestChangeZone(indexSelect, this.indexItemUse);
                    return;
                }
                InfoMe.addInfo(mResources.ZONE_HERE);
                return;
            case 11068:
                text = (String) p;
                this.actOpenWeb(text);
                return;
            case 11069:
                this.actOpenWebCancel();
                return;
            case 11070:
                Party party;
                actRefresh_TeamLeader(party = (Party) p);
                return;
            case 11071:
                Service.gI().outParty();
                return;
            case 11072:
                actSaleItem();
                return;
            case 11073:
                actionSale(Char.getMyChar().arrItemBag[indexSelect]);
                return;
            case 11074:
                MyVector entries8;
                short shortValue = Short.parseShort(String.valueOf((entries8 = (MyVector) p).elementAt(0)));
                String text9 = String.valueOf(entries8.elementAt(1));
                this.actSendSMSLeft(shortValue, text9);
                return;
            case 11075:
                this.actSendSMSRight();
                return;
            case 11076:
                text = (String) p;
                Service.gI().addParty(text);
                return;
            case 11077:
                actConfirmRemoveFriend(text = (String) p);
                return;
            case 11078:
                actSetEnemiesCommand();
                return;
            case 11079:
                actSetFriendCommand();
                return;
            case 11080:
                actSetPartyCommand(text = (String) p);
                return;
            case 11081:
                actdoGan();
                return;
            case 11082:
                actTrangBiSelect();
                return;
            case 11083:
                this.actView((byte) 5);
                return;
            case 11084:
                actdoUpPoint();
                return;
            case 11085:
                actBuyQuanNam();
                return;
            case 11086:
                this.actTrangBiRight();
                return;
            case 11087:
                Item item10 = (Item) p;
                GameCanvas.endDlg();
                Service.gI().splitItem(item10);
                return;
            case 11088:
                this.actView((byte) 26);
                return;
            case 11089:
                this.actView((byte) 27);
                return;
            case 11090:
                this.actView((byte) 28);
                return;
            case 11091:
                this.actView((byte) 29);
                return;
            case 11092:
                Item item11;
                actBuyLeft(item11 = (Item) p);
                return;
            case 11093:
                this.actView((byte) 2);
                return;
            case 11094:
                this.actView((byte) 6);
                return;
            case 11095:
                this.actView((byte) 7);
                return;
            case 11096:
                this.actView((byte) 8);
                return;
            case 11097:
                this.actView((byte) 9);
                return;
            case 11098:
                this.actUpgradeLeft();
                return;
            case 11099:
                nso.GameScr.isViewNext = false;
                this.updateItemInfo(3, itemUpGrade);
                return;
            case 11100:
                actUpgradeBag();
                return;
            case 11101:
                Item item12 = getItemFocus(10);
                this.updateItemInfo(3, item12);
                return;
            case 11102:
                this.actUpgrade_HanhTrang();
                return;
            case 11103:
                this.actSplitItem();
                return;
            case 11104:
                this.updateItemInfo(3, (Item) p);
                return;
            case 11105:
                split();
                return;
            case 11106:
                this.actSplitItemBag();
                return;
            case 11107:
                actUpPearlSelect();
                return;
            case 11108:
                this.actView((byte) 3);
                return;
            case 11109:
                this.actUpPearlItems();
                return;
            case 11110:
                Item item13 = arrItemTradeOrder[indexSelect];
                this.updateItemInfo(30, item13);
                return;
            case 11111:
                Item item14 = getItemFocus(4);
                this.updateItemInfo(4, item14);
                return;
            case 11112:
                Service.gI().boxSort();
                return;
            case 11113:
                Service.gI().itemBagToBox(Char.getMyChar().arrItemBag[indexSelect].indexUI);
                return;
            case 11114:
                this.updateItemInfo(3, Char.getMyChar().arrItemBag[indexSelect]);
                return;
            case 11115:
                actBuyItemUILeft();
                return;
            case 11116:
                actBuyItemLeft2();
                return;
            case 11120:
                Object[] values;
                Skill skill = (Skill) (values = (Object[]) p)[0];
                int value15 = Integer.parseInt((String) values[1]);
                onScreenSkill[value15] = skill;
                saveOnScreenSkillToRMS();
                return;
            case 11121:
                Object[] values16;
                Skill skill17 = (Skill) (values16 = (Object[]) p)[0];
                int value18 = Integer.parseInt((String) values16[1]);
                keySkill[value18] = skill17;
                saveKeySkillToRMS();
                return;
            case 12000:
                this.actOpenAlertURL();
                return;
            case 12001:
                ChatManager.gI().switchToTab(((Integer) p).intValue());
                this.openUIChatTab();
                return;
            case 12002:
            case 12004:
                text = (String) p;
                ChatTab chatTab;
                if ((chatTab = ChatManager.gI().findTab(text)) == null) {
                    ChatManager.gI().addNewTab(text);
                    ChatManager.gI().switchToLastTab();
                } else {
                    ChatManager.gI().switchToTab(chatTab);
                }
                this.openUIChatTab();
                isPaintFindTeam = false;
                isPaintClan = false;
                isPaintEnemies = false;
                isPaintFriend = false;
                isPaintTeam = false;
                ChatTextField.gI().center = null;
                return;
            case 12003:
                this.doShowFriendUI();
                return;
            case 12005:
                this.doShowChatTextFieldInMessage();
                return;
            case 12006:
                doShowBlockMessageMenu();
                return;
            case 12007:
                this.cardReportStep = 1;
                this.strErrCard = "";
                this.doShowErrorInput();
                return;
            case 12008:
                domenuErrorAdim();
                return;
            case 12009:
                text = (String) p;
                MyVector entries19;
                (entries19 = new MyVector()).addElement(new Command(mResources.CHAR_ORDER[7], 12002, text));
                entries19.addElement(new Command(mResources.TEAMLEADER_SELECT[2], 110803, text));
                if (isPaintTeam) {
                    entries19.addElement(new Command(mResources.CHAR_ORDER[6], 110804));
                }
                if (isPaintMessage) {
                    entries19.addElement(new Command(mResources.MOVETO, 14020, text));
                    entries19.addElement(new Command(mResources.CHAR_ORDER[6], 1108041, text));
                }
                GameCanvas.menu.startAt(entries19);
                return;
            case 13001:
                this.actView((byte) 32);
                return;
            case 13002:
                actStoreFashionBuy();
                return;
            case 14001:
                actdoKyNang();
                return;
            case 14002:
                this.doUnfocusChar();
                return;
            case 14003:
                this.doCharFocusList();
                return;
            case 14004:
                domenuClanNotice();
                return;
            case 14005:
                this.domenuClanLeader();
                return;
            case 14006:
                actSetClanCommand(text = (String) p);
                return;
            case 14007:
                domenuClanConfig();
                return;
            case 14008:
                GameCanvas.startYesNoDlg(mResources.MOVE_OUT_CLAN1, new Command(mResources.YES, 140081), new Command(mResources.NO, 1));
                return;
            case 14009:
                domenuClanPermission();
                return;
            case 14010:
                GameCanvas.inputDlg.show(mResources.INPUT_CLAN_CONTRIBUTE, new Command(mResources.ACCEPT, GameCanvas.instance, 88833, null), 1);
                return;
            case 14011:
                nso.GameScr.isMessageMenu = false;
                return;
            case 14012:
                this.actConvert_HanhTrang();
                return;
            case 14013:
                this.actConvertLeft();
                return;
            case 14014:
                this.actConvertMoveOut();
                return;
            case 14015:
                this.actItemConvertMoveOut();
                return;
            case 14016:
                this.updateItemInfo(3, arrItemConvert[indexSelect]);
                return;
            case 14017:
                domenuEnemieLeft();
                return;
            case 14018:
                this.actView((byte) 34);
                return;
            case 14019:
                actClanStoreBuy();
                return;
            case 14020:
                if (isHaveVanBienLenh()) {
                    text = (String) p;
                    Service.gI().textBoxId((short) 1, text);
                    return;
                }
                GameCanvas.startOKDlg(mResources.ALERT_MOVETO);
                return;
            case 14021:
                actSetDunListCommand();
                return;
            case 14022:
                actEliteShopBuy();
                return;
            case 14023:
                this.actView((byte) 35);
                return;
            case 14024:
                this.actSetRankedListCommand((byte) 1);
                return;
            case 14025:
                this.actSetRankedListCommand((byte) 0);
                return;
            case 15001:
                this.doStandToBag();
                return;
            case 15002:
                try {
                    if ((idAction = Integer.parseInt(this.tfText.getText())) <= 0) {
                        GameCanvas.startOKDlg(mResources.INVALID_NUM);
                    }
                    GameCanvas.startYesNoDlg(mResources.replace(mResources.SALE_ASK, NinjaUtil.numberToString(String.valueOf(idAction))), new Command(mResources.YES, 150021), new Command(mResources.NO, 1));
                    return;
                } catch (Exception exception33) {
                    GameCanvas.startOKDlg(mResources.INVALID_NUM);
                    return;
                }
            case 15041:
                domenuSortItemStand();
                return;
            case 15042:
                GameCanvas.startYesNoDlg(mResources.replace(mResources.BUY_ASK, NinjaUtil.numberToString(String.valueOf(arrItemStands[indexSelect].price))), new Command(mResources.YES, 150421), new Command(mResources.NO, 1));
                return;
            case 15081:
                Service.gI().useClanItem();
                return;
            case 15082:
                GameCanvas.inputDlg.show(mResources.INPUT_MEM_NAME, new Command(mResources.OK, GameCanvas.instance, 88843, new Integer(indexSelect)), 0);
                return;
            case 15130:
                Char.aFoodValue = 1;
                return;
            case 15131:
                Char.aFoodValue = 10;
                return;
            case 15132:
                Char.aFoodValue = 20;
                return;
            case 15133:
                Char.aFoodValue = 30;
                return;
            case 15134:
                Char.aFoodValue = 40;
                return;
            case 15135:
                Char.aFoodValue = 50;
                return;
            case 15136:
                Char.aFoodValue = 60;
                return;
            case 15137:
                Char.aFoodValue = 70;
                return;
            case 20251:
                GameCanvas.startOKDlg(mResources.textxoa);
                return;
            case 20252:
                GameCanvas.endDlg();
                return;
            case 110001:
                this.doMenuInforMe();
                return;
            case 110002:
                doShowMap();
                return;
            case 110003:
                doMenusynthesis();
                return;
            case 110004:
                actMenu4();
                return;
            case 110005:
                this.doOpenUI(14);
                return;
            case 110006:
                actOrder();
                return;
            case 110007:
                this.doOpenUI(7);
                return;
            case 110008:
                this.doOpenUI(6);
                return;
            case 110009:
                this.doOpenUI(9);
                return;
            case 110010:
                this.doOpenUI(8);
                return;
            case 110011:
                this.doOpenUI(10);
                return;
            case 110012:
                this.doOpenUI(11);
                return;
            case 110013:
                this.doOpenUI(12);
                return;
            case 110014:
                this.doOpenUI(4);
                return;
            case 110015:
                this.doOpenUI(13);
                return;
            case 110016:
                Service.gI().openUIZone();
                return;
            case 110017:
                this.openUITrade();
                return;
            case 110018:
                doShowListChatTab();
                return;
            case 110019:
                this.changeTaskInfo();
                return;
            case 110051:
                actBuy((byte) 25);
                return;
            case 110052:
                this.actBuys((byte) 25);
                return;
            case 110081:
                actBuy((byte) 24);
                return;
            case 110082:
                this.actBuys((byte) 24);
                return;
            case 110101:
                actBuy((byte) 23);
                return;
            case 110102:
                this.actBuys((byte) 23);
                return;
            case 110121:
                actBuy((byte) 22);
                return;
            case 110122:
                this.actBuys((byte) 22);
                return;
            case 110141:
                actBuy((byte) 21);
                return;
            case 110142:
                this.actBuys((byte) 21);
                return;
            case 110161:
                actBuy((byte) 20);
                return;
            case 110162:
                this.actBuys((byte) 20);
                return;
            case 110181:
                actBuy((byte) 15);
                return;
            case 110182:
                this.actBuys((byte) 15);
                return;
            case 110201:
                actBuy((byte) 14);
                return;
            case 110202:
                this.actBuys((byte) 14);
                return;
            case 110221:
                actBagSortItem();
                return;
            case 110244:
                actBagSplitItem();
                return;
            case 110361:
                this.actionCoinTradeAccept();
                return;
            case 110382:
                Service.gI().returnTownFromDead();
                return;
            case 110383:
                Service.gI().wakeUpFromDead();
                return;
            case 110391:
                this.actmenuAttack(1);
                return;
            case 110392:
                this.actmenuAttack(2);
                return;
            case 110393:
                this.actmenuAttack(3);
                return;
            case 110394:
                this.actmenuAttack(4);
                return;
            case 110395:
                this.actmenuAttack(5);
                return;
            case 110396:
                this.actmenuAttack(6);
                return;
            case 110397:
                this.actmenuAttack(7);
                return;
            case 110398:
                this.actmenuAttack(8);
                return;
            case 110399:
                this.actmenuAttack(9);
                return;
            case 110441:
                this.doAddFriend();
                return;
            case 110451:
                actInputTeam();
                return;
            case 110452:
                actRefreshFindTeam();
                return;
            case 110471:
                actCreateTeam();
                return;
            case 110531:
                Item item20 = (Item) p;
                Service.gI().useItemChangeMap(item20.indexUI, GameCanvas.menu.menuSelectedItem + 3);
                return;
            case 110561:
                GameCanvas.endDlg();
                this.updateCommandForUI();
                return;
            case 110562:
                Item item21;
                doActionSaleOk(item21 = (Item) p);
                return;
            case 110701:
                Service.gI().outParty();
                return;
            case 110702:
                Service.gI().lockParty(true);
                return;
            case 110703:
                Service.gI().lockParty(false);
                return;
            case 110721:
                Service.gI().saleItem(indexSelect, 1);
                return;
            case 110722:
                actionSale(Char.getMyChar().arrItemBag[indexSelect]);
                return;
            case 110723:
                Service.gI().saleItem(indexSelect, Char.getMyChar().arrItemBag[indexSelect].quantity);
                return;
            case 110771:
                text = (String) p;
                GameCanvas.endDlg();
                Service.gI().removeFriend(text);
                return;
            case 110791:
                text = (String) p;
                Service.gI().addParty(text);
                return;
            case 110792:
                actSetDeleteFriend(text = (String) p);
                return;
            case 110801:
                Service.gI().moveMember(indexRow);
                return;
            case 110802:
                Service.gI().changeTeamLeader(indexRow);
                return;
            case 110803:
                text = (String) p;
                Service.gI().addFriend(text);
                return;
            case 110804:
                viewMemberInfo();
                return;
            case 110805:
                this.viewMemberClanInfo();
                return;
            case 110811:
                doSetKeySkill(Char.getMyChar().nClass.skillTemplates[indexSelect]);
                return;
            case 110812:
                doSetOnScreenSkill(Char.getMyChar().nClass.skillTemplates[indexSelect]);
                return;
            case 110821:
                Service.gI().itemBodyToBag(indexSelect + indextabTrangbi);
                return;
            case 110841:
                Service.gI().upPotential(indexTitle - 1, 1);
                this.setLCR();
                return;
            case 110842:
                this.doUpPotential();
                return;
            case 110851:
                Item item22 = (Item) p;
                Service.gI().buyItem(item22.typeUI, item22.indexUI, 1);
                return;
            case 110852:
                Item item23;
                actionBuy(item23 = (Item) p);
                return;
            case 110854:
                actTrangBiCenter();
                return;
            case 110921:
                Item item24 = (Item) p;
                Service.gI().buyItem(item24.typeUI, item24.indexUI, 1);
                return;
            case 110922:
                Item item25;
                actionBuy(item25 = (Item) p);
                return;
            case 110923:
                this.actView((byte) 16);
                return;
            case 110924:
                this.actView((byte) 17);
                return;
            case 110925:
                this.actView((byte) 18);
                return;
            case 110926:
                this.actView((byte) 19);
                return;
            case 110981:
                this.upGrade();
                return;
            case 110991:
                nso.GameScr.isViewNext = true;
                this.updateItemInfo(3, itemUpGrade);
                return;
            case 111001:
                this.actItemUpgradeMoveOut();
                return;
            case 111031:
                if (nso.GameScr.isPaintTinhluyen) {
                    Service.gI().tinhluyen(itemSplit, arrItemSplit);
                    return;
                }
                if (nso.GameScr.isPaintDichChuyen) {
                    Service.gI().dichchuyen(itemSplit, arrItemSplit);
                    return;
                }
                if (nso.GameScr.isPaintLuyenNgoc) {
                    Service.gI().ngockham((byte) 1, null, itemSplit, arrItemSplit);
                    return;
                }
                if (nso.GameScr.isPaintGotNgoc) {
                    Service.gI().ngockham((byte) 2, null, itemSplit, null);
                    return;
                }
                if (nso.GameScr.isPaintThaoNgoc) {
                    Service.gI().ngockham((byte) 3, null, itemSplit, null);
                    return;
                }
                break;
            case 111071:
                this.actUpPearlMoveOut();
                return;
            case 111101:
                Item item26 = getItemFocus(4);
                Service.gI().itemBoxToBag(item26.indexUI);
                return;
            case 120051:
                ChatTab chatTab27 = (ChatTab) p;
                ChatManager.gI().chatTabs.removeElement(chatTab27);
                if (ChatManager.gI().currentTabIndex > ChatManager.gI().chatTabs.size() - 1) {
                    ChatManager.gI().switchToPreviousTab();
                }
                if (ChatManager.gI().getCurrentChatTab() != null) {
                    this.openUIChatTab();
                    return;
                }
                ChatTextField.gI().isShow = false;
                this.resetButton();
                return;
            case 120061:
                ChatManager.blockGlobalChat = !ChatManager.blockGlobalChat;
                GameCanvas.startOKDlg(mResources.BLOCK_GLOBAL_CHAT + (ChatManager.blockGlobalChat ? mResources.ON : mResources.OFF));
                return;
            case 120062:
                ChatManager.blockPrivateChat = !ChatManager.blockPrivateChat;
                GameCanvas.startOKDlg(mResources.BLOCK_PRIVATE_CHAT + (ChatManager.blockPrivateChat ? mResources.ON : mResources.OFF));
                return;
            case 120071:
                this.cardReportStep = 2;
                if (GameCanvas.input2Dlg.tfInput.getText().equals("")) {
                    GameCanvas.startOKDlg(mResources.NOT_INPUT_CARDINFO);
                    return;
                }
                if (GameCanvas.input2Dlg.tfInput2.getText().equals("")) {
                    GameCanvas.startOKDlg(mResources.NOT_INPUT_CARDMONEY);
                    return;
                }
                this.strErrCard = "Loại thẻ: " + GameCanvas.input2Dlg.tfInput.getText();
                this.strErrCard = this.strErrCard + ", Mệnh giá: " + GameCanvas.input2Dlg.tfInput2.getText();
                GameCanvas.endDlg();
                this.doShowErrorInput();
                return;
            case 120072:
                if (GameCanvas.input2Dlg.tfInput.getText().equals("")) {
                    GameCanvas.startOKDlg(mResources.NOT_INPUT_CARDSERI);
                    return;
                }
                if (GameCanvas.input2Dlg.tfInput2.getText().equals("")) {
                    GameCanvas.startOKDlg(mResources.NOT_INPUT_CARDTIME);
                    return;
                }
                this.strErrCard = this.strErrCard + ", Số seri: " + GameCanvas.input2Dlg.tfInput.getText();
                this.strErrCard = this.strErrCard + ", Khoảng thời gian nạp: " + GameCanvas.input2Dlg.tfInput2.getText();
                Service.gI().adminChat(this.strErrCard);
                GameCanvas.endDlg();
                return;
            case 120081:
                GameCanvas.inputDlg.tfInput.setMaxTextLenght(11);
                GameCanvas.inputDlg.show(mResources.INPUT_REG_NUMPHONE, new Command("OK", null, 120082, null), 1);
                return;
            case 120082:
                if ((text = GameCanvas.inputDlg.tfInput.getText()).equals("")) {
                    GameCanvas.startOKDlg(mResources.NOT_INPUT_NUMPHONE);
                    return;
                }
                Service.gI().adminChat("Số điện thoại đăng ký: " + text);
                GameCanvas.endDlg();
                return;
            case 130011:
                Npc npc28 = (Npc) p;
                Service.gI().getTask(npc28.template.npcTemplateId, 0, -1);
                npc28.chatPopup = null;
                this.resetButton();
                return;
            case 130012:
                Npc npc29;
                (npc29 = (Npc) p).chatPopup = null;
                this.resetButton();
                return;
            case 130021:
                actBuy((byte) 32);
                return;
            case 130022:
                this.actBuys((byte) 32);
                return;
            case 140011:
                Service.gI().upSkill(Char.getMyChar().nClass.skillTemplates[indexSelect].id, 1);
                this.setLCR();
                return;
            case 140012:
                this.doUpSkill();
                return;
            case 140041:
                GameCanvas.inputDlg.tfInput.setMaxTextLenght(180);
                GameCanvas.inputDlg.show(mResources.INPUT_CLAN_TEXT, new Command(mResources.ACCEPT, GameCanvas.instance, 88832, null), 0);
                return;
            case 140042:
                Service.gI().clanUpLevel();
                return;
            case 140043:
                GameCanvas.inputDlg.show(mResources.INPUT_CLAN_MONEY, new Command(mResources.ACCEPT, GameCanvas.instance, 88834, null), 0);
                return;
            case 140044:
                Service.gI().unlockClanItem();
                return;
            case 140071:
                indexRow = 0;
                indexSelect = 0;
                scrMain.clear();
                isViewClanMemOnline = !isViewClanMemOnline;
                sortClan();
                return;
            case 140072:
                indexRow = 0;
                indexSelect = 0;
                scrMain.clear();
                isSortClanByPointWeek = !isSortClanByPointWeek;
                sortClan();
                return;
            case 140081:
                Service.gI().outClan();
                GameCanvas.endDlg();
                return;
            case 140091:
                Service.gI().changeClanType(((Member) vClan.elementAt(indexRow)).name, 3);
                return;
            case 140092:
                Service.gI().changeClanType(((Member) vClan.elementAt(indexRow)).name, 2);
                return;
            case 140093:
                GameCanvas.startYesNoDlg(mResources.CLEAR_CLAN_TYPE, new Command(mResources.YES, 1400931), new Command(mResources.NO, 1));
                return;
            case 140094:
                GameCanvas.startYesNoDlg(mResources.MOVE_OUT_CLAN, new Command(mResources.YES, 1400941), new Command(mResources.NO, 1));
                return;
            case 140095:
                Member member = (Member) vClan.elementAt(indexRow);
                Service.gI().inviteClanDun(member.name);
                return;
            case 140096:
                (entries = new MyVector()).addElement(new Command(mResources.INVITE_THIS_PERSON, 1400961));
                entries.addElement(new Command(mResources.INVITE_ALL, 1400962));
                GameCanvas.menu.startAt(entries);
                return;
            case 140101:
                Item item30;
                (item30 = new Item()).template = ItemTemplates.get((short) 0);
                item30.expires = -1L;
                this.updateItemInfo(39, item30);
                return;
            case 140131:
                GameCanvas.startYesNoDlg(mResources.CONFIRMCONVERT, new Command(mResources.YES, 140132), new Command(mResources.NO, 1));
                return;
            case 140132:
                Convert();
                return;
            case 140151:
                this.actItemConvertMoveOut2();
                return;
            case 140161:
                this.updateItemInfo(3, arrItemConvert[2]);
                return;
            case 140191:
                actBuy((byte) 34);
                return;
            case 140192:
                this.actBuys((byte) 34);
                return;
            case 140221:
                actBuy((byte) 35);
                return;
            case 140222:
                this.actBuys((byte) 35);
                return;
            case 150021:
                GameCanvas.startWaitDlg();
                idAction = 0;
                try {
                    idAction = Integer.parseInt(this.tfText.getText());
                } catch (Exception exception34) {
                }
                Service.gI().sendToSaleItem(itemSell, idAction);
                return;
            case 150411:
                this.typeSortLevel = 0;
                this.typeSortName = 0;
                if (this.typeSortPrice == 0) {
                    this.typeSortPrice = 1;
                } else if (this.typeSortPrice == 1) {
                    this.typeSortPrice = 2;
                } else if (this.typeSortPrice == 2) {
                    this.typeSortPrice = 1;
                }
                this.sortItemStand();
                return;
            case 150412:
                this.typeSortLevel = 0;
                this.typeSortPrice = 0;
                if (this.typeSortName == 0) {
                    this.typeSortName = 1;
                } else if (this.typeSortName == 1) {
                    this.typeSortName = 2;
                } else if (this.typeSortName == 2) {
                    this.typeSortName = 1;
                }
                this.sortItemStand();
                return;
            case 150413:
                this.typeSortPrice = 0;
                this.typeSortName = 0;
                if (this.typeSortLevel == 0) {
                    this.typeSortLevel = 1;
                } else if (this.typeSortLevel == 1) {
                    this.typeSortLevel = 2;
                } else if (this.typeSortLevel == 2) {
                    this.typeSortLevel = 1;
                }
                this.sortItemStand();
                return;
            case 150421:
                GameCanvas.endDlg();
                Service.gI().buyItemAuction(arrItemStands[indexSelect].item.itemId);
                return;
            case 151301:
                Service.gI().sendCatkeo(Char.getMyChar().mobFocus.getTemplate().mobTemplateId);
                return;
            case 909090:
                this.doOpenUI(38);
                return;
            case 1100011:
                this.doBag();
                return;
            case 1100012:
                this.doskill();
                return;
            case 1100013:
                this.doTiemnangMe();
                return;
            case 1100014:
                this.doInfo();
                return;
            case 1100015:
                this.doTrangbi();
                return;
            case 1100016:
                this.doThucuoi();
                return;
            case 1100017:
                this.doBiJuu();
                return;
            case 1100032:
                this.doShowTaskUI();
                return;
            case 1100033:
                domenuClan();
                return;
            case 1100034:
                domenuLucky_Draw();
                return;
            case 1100041:
                actMenu41();
                return;
            case 1100061:
                this.doShowFindTeamUI();
                return;
            case 1100062:
                this.doShowTeamUI();
                return;
            case 1100063:
                this.doShowFriendUI();
                return;
            case 1100064:
                this.doShowEnemiesUI();
                return;
            case 1100065:
                actsubMenuOrder();
                return;
            case 1100067:
                domenuPrivateLock();
                return;
            case 1100068:
                this.doOpenUI(40);
                return;
            case 1100181:
                GameCanvas.startYesNoDlg(mResources.noti_reg, new Command(mResources.COUNTINUE, 1100182), new Command(mResources.NO, GameCanvas.instance, 8882, null));
                return;
            case 1100182:
                GameCanvas.currentDialog = null;
                GameCanvas.loginScr.switchToMe(true);
                return;
            case 1103991:
                this.actmenuAttack(10);
                return;
            case 1107921:
                text = (String) p;
                GameCanvas.endDlg();
                Service.gI().removeFriend(text);
                actRemoveWaitAcceptFriend(text);
                return;
            case 1107931:
                text = (String) p;
                Service.gI().addFriend(text);
                return;
            case 1107932:
                actRemoveWaitAcceptFriend(text = (String) p);
                return;
            case 1108041:
                text = (String) p;
                Service.gI().viewInfo(text, 0);
                gI().resetButton();
                return;
            case 1400931:
                Service.gI().changeClanType(((Member) vClan.elementAt(indexRow)).name, 0);
                GameCanvas.endDlg();
                return;
            case 1400941:
                Service.gI().moveOutClan(((Member) vClan.elementAt(indexRow)).name);
                GameCanvas.endDlg();
                return;
            case 1400961:
                Member member31 = (Member) vClan.elementAt(indexRow);
                Service.gI().inviteClanBattlefield(member31.name);
                return;
            case 1400962:
                Service.gI().inviteClanBattlefieldAll();
                return;
            case 11000651:
                actsubMenuOrder_PK(1);
                return;
            case 11000652:
                actsubMenuOrder_PK(2);
                return;
            case 11000653:
                actsubMenuOrder_PK(3);
                return;
            case 11000661:
                indexMenu = 0;
                this.doShowClan();
                return;
            case 11000662:
                indexMenu = 1;
                this.doShowClan();
                Service.gI().requestClanMember();
                return;
            case 11000663:
                indexMenu = 2;
                this.doShowClan();
                Service.gI().requestClanItem();
                return;
            case 11000664:
                indexMenu = 3;
                this.doShowClan();
                Service.gI().requestClanLog();
                return;
            case 11000665:
                if (isViewClanInvite = !isViewClanInvite) {
                    RMS.saveRMSInt(Char.getMyChar().cName + "vci", 1);
                    return;
                }
                RMS.saveRMSInt(Char.getMyChar().cName + "vci", 0);
                return;
            case 11000666:
                indexMenu = 4;
                this.doShowClan();
                Service.gI().requestClanItem();
                return;
            case 11000671:
                GameCanvas.startYesNoDlg(mResources.ACTIVE_PROTECT_ACC, 88836, null, 8882, null);
                return;
            case 11000672:
                GameCanvas.inputDlg.tfInput.setMaxTextLenght(6);
                GameCanvas.inputDlg.show(mResources.INPUT_PRIVATE_PASS, new Command(mResources.ACCEPT, GameCanvas.instance, 88837, null), 1);
                return;
            case 11000673:
                GameCanvas.input2Dlg.setTitle(mResources.OLD_PASS, mResources.NEW_PASS);
                GameCanvas.input2Dlg.tfInput.setMaxTextLenght(6);
                GameCanvas.input2Dlg.tfInput2.setMaxTextLenght(6);
                GameCanvas.input2Dlg.show(mResources.INPUT_PRIVATE_PASS, new Command(mResources.CLOSE, GameCanvas.instance, 8882, null), new Command(mResources.ACCEPT, GameCanvas.instance, 88838, null), 1, 1);
                return;
            case 11000674:
                GameCanvas.inputDlg.tfInput.setMaxTextLenght(6);
                GameCanvas.inputDlg.show(mResources.INPUT_PRIVATE_PASS, new Command(mResources.ACCEPT, GameCanvas.instance, 88839, null), 1);
                return;
        }
    }

    private void actDichChuyenTrangBiLeft() {
        try {
            if (Char.getMyChar().arrItemBag[indexSelect].template.id == 454) {
                if (arrItemSplit == null) {
                    arrItemSplit = new Item[24];
                }
                for (int index = 0; index < arrItemSplit.length; index++) {
                    if (index == 20) {
                        GameCanvas.startOKDlg(mResources.CRYSTAL_FULL);
                        return;
                    }
                    if (arrItemSplit[index] == null) {
                        arrItemSplit[index] = Char.getMyChar().arrItemBag[indexSelect];
                        Char.getMyChar().arrItemBag[indexSelect] = null;
                        super.left = super.center = null;
                        this.updateCommandForUI();
                        return;
                    }
                }
            } else if (Char.getMyChar().arrItemBag[indexSelect].upgrade > 11) {
                if (itemSplit == null) {
                    itemSplit = Char.getMyChar().arrItemBag[indexSelect];
                    Char.getMyChar().arrItemBag[indexSelect] = null;
                } else {
                    Item item = Char.getMyChar().arrItemBag[indexSelect];
                    Char.getMyChar().arrItemBag[indexSelect] = null;
                    Char.getMyChar().arrItemBag[itemSplit.indexUI] = itemSplit;
                    itemSplit = item;
                }
                Service.gI().requestItemInfo(itemSplit.typeUI, itemSplit.indexUI);
            } else {
                GameCanvas.startOKDlg(mResources.CAN_NOT_DICHCHUYEN);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void actTinhLuyenMoveOut() {
        Item item = getItemFocus(44);
        arrItemSplit[indexSelect] = null;
        Char.getMyChar().arrItemBag[item.indexUI] = item;
        super.left = super.center = null;
        this.updateCommandForUI();
    }

    private static void doAutoSelect() {
        if (indexRow == 0) {
            Char.isAHP = !Char.isAHP;
            if (nso.GameScr.typeActive == 1) {
                Char.isAHP = false;
                InfoMe.addInfo(mResources.AOPENACC, 20, mFont.tahoma_7_yellow);
                return;
            }
        } else if (indexRow == 1) {
            Char.isAMP = !Char.isAMP;
            if (nso.GameScr.typeActive == 1) {
                Char.isAMP = false;
                InfoMe.addInfo(mResources.AOPENACC, 20, mFont.tahoma_7_yellow);
                return;
            }
        } else if (indexRow == 2) {
            Char.isAFood = !Char.isAFood;
            if (nso.GameScr.typeActive == 1) {
                Char.isAFood = false;
                InfoMe.addInfo(mResources.AOPENACC, 20, mFont.tahoma_7_yellow);
                return;
            }
        } else {
            if (indexRow == 3) {
                Char.isABuff = !Char.isABuff;
                return;
            }
            if (indexRow == 4) {
                if (Char.isAPickYen = !Char.isAPickYen) {
                    Char.isANoPick = false;
                    Char.isAPickYHMS = false;
                    Char.isAPickYHM = false;
                    return;
                }
            } else if (indexRow == 5) {
                if (Char.isAPickYHM = !Char.isAPickYHM) {
                    Char.isANoPick = false;
                    Char.isAPickYHMS = false;
                    Char.isAPickYen = false;
                    return;
                }
            } else if (indexRow == 6) {
                if (Char.isAPickYHMS = !Char.isAPickYHMS) {
                    Char.isANoPick = false;
                    Char.isAPickYHM = false;
                    Char.isAPickYen = false;
                    return;
                }
            } else if (indexRow == 7 && (Char.isANoPick = !Char.isANoPick)) {
                Char.isAPickYHMS = false;
                Char.isAPickYHM = false;
                Char.isAPickYen = false;
            }
        }
    }

    private void doviewCardsInfo() {
        if (arrItemSprin != null) {
            Item item;
            (item = new Item()).template = ItemTemplates.get(arrItemSprin[indexSelect]);
            this.updateItemInfo(38, item);
        }
    }

    private void sortItemStand() {
        if (this.typeSortLevel != 0 || this.typeSortPrice != 0 || this.typeSortName != 0) {
            for (int index = 0; index < arrItemStands.length - 1; index++) {
                for (int index1 = index + 1; index1 < arrItemStands.length; index1++) {
                    if (this.typeSortPrice == 1) {
                        if (arrItemStands[index].price < arrItemStands[index1].price) {
                            ItemStands itemStands = arrItemStands[index];
                            arrItemStands[index] = arrItemStands[index1];
                            arrItemStands[index1] = itemStands;
                        }
                    } else if (this.typeSortPrice == 2 && arrItemStands[index].price > arrItemStands[index1].price) {
                        ItemStands itemStands2 = arrItemStands[index];
                        arrItemStands[index] = arrItemStands[index1];
                        arrItemStands[index1] = itemStands2;
                    }
                    if (this.typeSortName == 1) {
                        if (!arrItemStands[index].item.template.name.equals(arrItemStands[index1].item.template.name) && arrItemStands[index].item.template.name.compareTo(arrItemStands[index1].item.template.name) > 0) {
                            ItemStands itemStands3 = arrItemStands[index];
                            arrItemStands[index] = arrItemStands[index1];
                            arrItemStands[index1] = itemStands3;
                        }
                    } else if (this.typeSortName == 2 && !arrItemStands[index].item.template.name.equals(arrItemStands[index1].item.template.name) && arrItemStands[index].item.template.name.compareTo(arrItemStands[index1].item.template.name) < 0) {
                        ItemStands itemStands4 = arrItemStands[index];
                        arrItemStands[index] = arrItemStands[index1];
                        arrItemStands[index1] = itemStands4;
                    }
                    if (this.typeSortLevel == 1) {
                        if (arrItemStands[index].item.template.level < arrItemStands[index1].item.template.level) {
                            ItemStands itemStands5 = arrItemStands[index];
                            arrItemStands[index] = arrItemStands[index1];
                            arrItemStands[index1] = itemStands5;
                        }
                    } else if (this.typeSortLevel == 2 && arrItemStands[index].item.template.level > arrItemStands[index1].item.template.level) {
                        ItemStands itemStands6 = arrItemStands[index];
                        arrItemStands[index] = arrItemStands[index1];
                        arrItemStands[index1] = itemStands6;
                    }
                }
            }
        }
    }

    private static void domenuSortItemStand() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.SORT_BY_PRICE, 150411));
        entries.addElement(new Command(mResources.SORT_BY_NAME, 150412));
        entries.addElement(new Command(mResources.SORT_BY_LEVEL, 150413));
        GameCanvas.menu.startAt(entries);
    }

    private static void domenuItemStand() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.SORT, 15041));
        entries.addElement(new Command(mResources.BUY, 15042));
        GameCanvas.menu.startAt(entries);
    }

    private void doStandToBag() {
        Char.getMyChar().arrItemBag[itemSell.indexUI] = itemSell;
        itemSell = null;
        super.left = super.center = null;
    }

    private static void doBagToStand() {
        Item item;
        if ((item = Char.getMyChar().arrItemBag[indexSelect]) != null) {
            if (item.isLock || item.isExpires) {
                GameCanvas.startOKDlg(mResources.ONLY_NO_EXPIRE);
            } else if (itemSell == null) {
                itemSell = Char.getMyChar().arrItemBag[indexSelect];
                Char.getMyChar().arrItemBag[indexSelect] = null;
            } else {
                item = Char.getMyChar().arrItemBag[indexSelect];
                Char.getMyChar().arrItemBag[indexSelect] = null;
                Char.getMyChar().arrItemBag[itemSell.indexUI] = itemSell;
                itemSell = item;
            }
        }
    }

    private static void actClanStoreBuy() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.BUY, 140191));
        entries.addElement(new Command(mResources.BUYS, 140192));
        GameCanvas.menu.startAt(entries);
    }

    private static void domenuErrorAdim() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.BAG_CODE, null, 120081, null));
        entries.addElement(new Command(mResources.CARD, null, 12007, null));
        GameCanvas.menu.startAt(entries);
    }

    private void doShowErrorInput() {
        if (this.cardReportStep == 1) {
            GameCanvas.input2Dlg.setTitle(mResources.CARD_TYPE, mResources.CARD_MONEY);
            GameCanvas.input2Dlg.show(mResources.INPUT_CARDTYPE_MONEY, new Command(mResources.CLOSE, GameCanvas.gI(), 8882, null), new Command(mResources.NEXT, null, 120071, null), 0, 0);
        } else {
            GameCanvas.input2Dlg.setTitle(mResources.CARD_SERI, mResources.CARD_TIME);
            GameCanvas.input2Dlg.show(mResources.INPUT_CARDSERI_TIME, new Command(mResources.CLOSE, GameCanvas.gI(), 8882, null), new Command(mResources.OK, null, 120072, null), 0, 0);
        }
    }

    public static void actRemoveWaitAcceptFriend(String strFWname) {
        for (int index = 0; index < vFriend.size(); index++) {
            Friend friend;
            if ((friend = (Friend) vFriend.elementAt(index)).friendName.equals(strFWname) && friend.type == 4) {
                vFriend.removeElementAt(index);
                break;
            }
        }
        for (int index1 = 0; index1 < vFriendWait.size(); index1++) {
            if (((Friend) vFriendWait.elementAt(index1)).friendName.equals(strFWname)) {
                vFriendWait.removeElementAt(index1);
                return;
            }
        }
    }

    private static void domenuClanConfig() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.CLAN_MENU[0] + ": " + (isViewClanMemOnline ? mResources.OFF : mResources.ON), 140071));
        entries.addElement(new Command(mResources.CLAN_SORTTYPE, 140072));
        GameCanvas.menu.startAt(entries);
    }

    private static void domenuEnemieLeft() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.CLAN_MENU[0] + ": " + (isViewClanMemOnline ? mResources.OFF : mResources.ON), 140071));
        GameCanvas.menu.startAt(entries);
    }

    private static void domenuFriendLeft() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.ADDNEW, 110441));
        entries.addElement(new Command(mResources.CLAN_MENU[0] + ": " + (isViewClanMemOnline ? mResources.OFF : mResources.ON), 140071));
        GameCanvas.menu.startAt(entries);
    }

    private static void domenuPrivateLock() {
        MyVector entries = new MyVector();
        if (nso.GameScr.typeActive == 0) {
            entries.addElement(new Command(mResources.ENABLE, 11000671));
        } else if (nso.GameScr.typeActive == 1) {
            entries.addElement(new Command(mResources.UNLOCK, 11000672));
        }
        if (nso.GameScr.typeActive == 1 || nso.GameScr.typeActive == 2) {
            entries.addElement(new Command(mResources.CANCEL_PRIVATE_PROTECT, 11000674));
            entries.addElement(new Command(mResources.CHANGE_PRIVATE_PASS, 11000673));
        }
        GameCanvas.menu.startAt(entries);
    }

    private static void domenuTeamLeft() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.CREATE_TEAM, 110471));
        entries.addElement(new Command(mResources.ACTIONS[4], 1100061));
        GameCanvas.menu.startAt(entries);
    }

    private static void Convert() {
        GameCanvas.endDlg();
        Service.gI().doConvertUpgrade(arrItemConvert[0].indexUI, arrItemConvert[1].indexUI, arrItemConvert[2].indexUI);
    }

    private static void domenuClanNotice() {
        MyVector entries = new MyVector();
        if (Char.getMyChar().ctypeClan == 3 || Char.getMyChar().ctypeClan == 4) {
            if (indexTitle == 1) {
                entries.addElement(new Command(mResources.CLAN_MENU[8], 140044));
            }
            entries.addElement(new Command(mResources.CLAN_MENU[2], 140041));
            entries.addElement(new Command(mResources.CLAN_MENU[5], 140042));
            if (Char.getMyChar().ctypeClan == 4) {
                entries.addElement(new Command(mResources.CLAN_MENU[4], 140043));
            }
            entries.addElement(new Command(mResources.CHAR_ORDER[10] + ": " + (isViewClanInvite ? mResources.OFF : mResources.ON), 11000665));
        }
        GameCanvas.menu.startAt(entries);
    }

    private static void domenuFindTeamCenter() {
        Party party;
        if ((party = (Party) vPtMap.elementAt(indexRow)) != null && !Char.getMyChar().cName.equals(party.name)) {
            MyVector entries;
            (entries = new MyVector()).addElement(new Command(mResources.CHAR_ORDER[6], 1108041, party.name));
            entries.addElement(new Command(mResources.CHAT, 12002, party.name));
            entries.addElement(new Command(mResources.TEAMLEADER_SELECT[2], 110803, party.name));
            GameCanvas.menu.startAt(entries);
        }
    }

    private static void domenuFindTeam() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.REFRESH, 110452));
        if (vPtMap.size() > 0) {
            entries.addElement(new Command(mResources.INPUT_TEAM, 110451));
        }
        GameCanvas.menu.startAt(entries);
    }

    private static void domenuClanPermission() {
        Member member = (Member) vClan.elementAt(indexRow);
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.CLANS[1], 140091, member.name));
        entries.addElement(new Command(mResources.CLANS[2], 140092, member.name));
        GameCanvas.menu.startAt(entries);
    }

    private void viewMemberClanInfo() {
        Member member;
        if (indexRow >= 0 && indexRow < vClan.size() && (member = curMemberSelected()) != null && !member.name.equals("")) {
            Service.gI().viewInfo(member.name, 0);
            isPaintClan = false;
            gI().resetButton();
        }
    }

    private void domenuClanLeader() {
        Member member = curMemberSelected();
        MyVector entries = new MyVector();
        if (Char.getMyChar().ctypeClan == 4) {
            if (member.type != 4) {
                if (member.type != 3 && member.type != 2) {
                    entries.addElement(new Command(mResources.SET_TYPE_CLAN, 14009, member.name));
                } else {
                    entries.addElement(new Command(mResources.CLEAR_TYPE_CLAN, 140093, member.name));
                }
                if (TileMap.mapID != 98 && TileMap.mapID != 104) {
                    entries.addElement(new Command(mResources.CLAN_MENU[6], 140095, member.name));
                } else {
                    entries.addElement(new Command(mResources.CLAN_MENU[7], 140096, member.name));
                }
                entries.addElement(new Command(mResources.FIRED_CLAN, 140094, member.name));
            }
            entries.addElement(new Command(mResources.CONFIG, 14007));
        } else if (Char.getMyChar().ctypeClan == 3) {
            if (member.type != 4 && !member.name.equals(Char.getMyChar().cName)) {
                entries.addElement(new Command(mResources.FIRED_CLAN, 140094, member.name));
                if (TileMap.mapID != 98 && TileMap.mapID != 104) {
                    entries.addElement(new Command(mResources.CLAN_MENU[6], 140095, member.name));
                } else {
                    entries.addElement(new Command(mResources.CLAN_MENU[7], 140096, member.name));
                }
            }
            entries.addElement(new Command(mResources.CONFIG, 14007));
            entries.addElement(new Command(mResources.CLAN_MENU[1], 14008, member.name));
        } else {
            entries.addElement(new Command(mResources.CONFIG, 14007));
            entries.addElement(new Command(mResources.CLAN_MENU[1], 14008, member.name));
        }
        GameCanvas.menu.startAt(entries);
    }

    private static boolean isHaveVanBienLenh() {
        for (int index = 0; index < Char.getMyChar().arrItemBag.length; index++) {
            Item item;
            if ((item = Char.getMyChar().arrItemBag[index]) != null && item.template.id == 279 && item.template.level <= Char.getMyChar().clevel) {
                return true;
            }
        }
        return false;
    }

    private static void actSetClanCommand(String mName) {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.CHAR_ORDER[6], 110805));
        entries.addElement(new Command(mResources.CHAT, 12002, mName));
        entries.addElement(new Command(mResources.PT, 110791, mName));
        entries.addElement(new Command(mResources.MOVETO, 14020, mName));
        entries.addElement(new Command(mResources.TEAMLEADER_SELECT[2], 110803, mName));
        GameCanvas.menu.startAt(entries);
    }

    private void doShowClan() {
        isPaintClan = true;
        isRequestMember = true;
        isSortClanByPointWeek = false;
        this.arrClanInfo = this.arrClanDongGop = null;
        setPopupSize(175, 200);
        this.updateCommandForUI();
        super.right = this.cmdCloseAll;
        Service.gI().requestClanInfo();
    }

    private static void domenuClan() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.CLAN[0], 11000661));
        entries.addElement(new Command(mResources.CLAN[1], 11000662));
        entries.addElement(new Command(mResources.CLAN[2], 11000663));
        entries.addElement(new Command(mResources.CLAN[3], 11000664));
        entries.addElement(new Command(mResources.CLAN[4], 11000666));
        GameCanvas.menu.startAt(entries);
    }

    private void doUnfocusChar() {
        Char.getMyChar().charFocus = null;
        Char.isManualFocus = false;
        this.cLastFocusID = -1;
        isPaintCharInMap = false;
        this.resetButton();
    }

    private void doCharFocusList() {
        Char character;
        if (!(character = (Char) vCharInMap.elementAt(indexRow)).isNhanbanz()) {
            this.cLastFocusID = character.charID;
            Char.getMyChar().mobFocus = null;
            Char.getMyChar().deFocusNPC();
            Char.getMyChar().itemFocus = null;
            Char.getMyChar();
            Char.isManualFocus = true;
            isPaintCharInMap = false;
            Char.getMyChar().charFocus = character;
        }
        this.resetButton();
    }

    private void changeTaskInfo() {
        if (indexMenu == 0) {
            indexMenu = 1;
        } else {
            indexMenu = 0;
        }
        indexRow = 0;
        this.idTypeTask = indexMenu;
    }

    private static void viewMemberInfo() {
        Party party;
        if ((party = (Party) vParty.elementAt(indexRow)).c != null && party.c != Char.getMyChar()) {
            Service.gI().viewInfo(party.c.cName, 0);
            isPaintTeam = false;
            gI().resetButton();
        }
    }

    private static void actBuyItemLeft2() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.SORT, 110221));
        entries.addElement(new Command(mResources.GETINMONEY, 11050));
        GameCanvas.menu.startAt(entries);
    }

    private static void actBuyItemUILeft() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.SORT, 11048));
        entries.addElement(new Command(mResources.GETOUTMONEY, 11049));
        GameCanvas.menu.startAt(entries);
    }

    private void actgetLuyenThachItems() {
        if (Char.getMyChar().arrItemBag[indexSelect].template.type != 26 && Char.getMyChar().arrItemBag[indexSelect].template.id != 455 && Char.getMyChar().arrItemBag[indexSelect].template.id != 456) {
            if (Char.getMyChar().arrItemBag[indexSelect].template.id == 457) {
                GameCanvas.msgdlg.setInfo(mResources.ONLY_LUYENTHACH1, null, new Command(mResources.CLOSE, 2), null);
            } else {
                GameCanvas.msgdlg.setInfo(mResources.ONLY_LUYENTHACH2, null, new Command(mResources.CLOSE, 2), null);
            }
        } else {
            if (Char.getMyChar().arrItemBag[indexSelect].template.type == 26 && Char.getMyChar().arrItemBag[indexSelect].template.id < 10) {
                GameCanvas.startOKDlg(mResources.ONLY_LUYENTHACH5);
                return;
            }
            short shortValue = 0;
            int value = 0;
            boolean flag = arrItemUpPeal[12] != null;
            for (int index = 0; index < arrItemUpPeal.length; index++) {
                if (arrItemUpPeal[index] != null && arrItemUpPeal[index].template.type != 26) {
                    shortValue = arrItemUpPeal[index].template.id;
                    value++;
                }
            }
            for (int index1 = 0; index1 < arrItemUpPeal.length; index1++) {
                if (arrItemUpPeal[index1] == null) {
                    if (Char.getMyChar().arrItemBag[indexSelect].template.type == 26) {
                        if (arrItemUpPeal[12] == null) {
                            arrItemUpPeal[12] = Char.getMyChar().arrItemBag[indexSelect];
                            Char.getMyChar().arrItemBag[indexSelect] = null;
                        } else {
                            Item item = Char.getMyChar().arrItemBag[indexSelect];
                            Char.getMyChar().arrItemBag[indexSelect] = null;
                            Char.getMyChar().arrItemBag[arrItemUpPeal[12].indexUI] = arrItemUpPeal[12];
                            arrItemUpPeal[12] = item;
                        }
                    } else if (shortValue > 0 && Char.getMyChar().arrItemBag[indexSelect].template.id != shortValue) {
                        GameCanvas.startOKDlg(mResources.ONLY_LUYENTHACH6);
                    } else if ((!flag || value < 3) && value < 9) {
                        arrItemUpPeal[index1] = Char.getMyChar().arrItemBag[indexSelect];
                        Char.getMyChar().arrItemBag[indexSelect] = null;
                    } else {
                        GameCanvas.startOKDlg(mResources.MAX_LUYENTHACH1);
                    }
                    super.left = super.center = null;
                    this.updateCommandForUI();
                    return;
                }
            }
            GameCanvas.msgdlg.setInfo(mResources.CRYSTAL_FULL, null, new Command(mResources.CLOSE, 2), null);
        }
        MsgDlg msgDlg = GameCanvas.msgdlg;
        GameCanvas.currentDialog = GameCanvas.msgdlg;
    }

    private void actUpPearlItems() {
        if (Char.getMyChar().arrItemBag[indexSelect].template.type != 26) {
            GameCanvas.msgdlg.setInfo(mResources.ONLY_CRYSTAL, null, new Command(mResources.CLOSE, 2), null);
            MsgDlg msgDlg = GameCanvas.msgdlg;
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        } else {
            for (int index = 0; index < arrItemUpPeal.length; index++) {
                if (arrItemUpPeal[index] == null) {
                    arrItemUpPeal[index] = Char.getMyChar().arrItemBag[indexSelect];
                    Char.getMyChar().arrItemBag[indexSelect] = null;
                    super.left = super.center = null;
                    this.updateCommandForUI();
                    return;
                }
            }
            GameCanvas.msgdlg.setInfo(mResources.CRYSTAL_FULL, null, new Command(mResources.CLOSE, 2), null);
            MsgDlg msgDlg1 = GameCanvas.msgdlg;
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        }
    }

    private void actUpPearlMoveOut() {
        Item item = getItemFocus(11);
        arrItemUpPeal[indexSelect] = null;
        Char.getMyChar().arrItemBag[item.indexUI] = item;
        super.left = super.center = null;
        this.updateCommandForUI();
    }

    private static void actLuyenThachSelect() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.MOVEOUT, 111071));
        for (int index = 0; index < arrItemUpPeal.length; index++) {
            if (arrItemUpPeal[index] != null) {
                entries.addElement(new Command(mResources.BEGIN, 1600));
                break;
            }
        }
        GameCanvas.menu.startAt(entries);
    }

    private static void actUpPearlSelect() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.MOVEOUT, 111071));
        for (int index = 0; index < arrItemUpPeal.length; index++) {
            if (arrItemUpPeal[index] != null) {
                entries.addElement(new Command(mResources.BEGIN, 11062));
                break;
            }
        }
        GameCanvas.menu.startAt(entries);
    }

    private void actSplitItemBag() {
        try {
            if (nso.GameScr.isPaintTinhluyen) {
                if (!Char.getMyChar().arrItemBag[indexSelect].isTypeBody() && !Char.getMyChar().arrItemBag[indexSelect].isTypeMounts() && Char.getMyChar().arrItemBag[indexSelect].template.id != 455 && Char.getMyChar().arrItemBag[indexSelect].template.id != 456 && Char.getMyChar().arrItemBag[indexSelect].template.id != 457) {
                    GameCanvas.msgdlg.setInfo(mResources.CAN_NOT_TINHLUYEN, null, new Command(mResources.CLOSE, 2), null);
                    MsgDlg msgDlg = GameCanvas.msgdlg;
                    GameCanvas.currentDialog = GameCanvas.msgdlg;
                } else if (Char.getMyChar().arrItemBag[indexSelect].template.id != 455 && Char.getMyChar().arrItemBag[indexSelect].template.id != 456 && Char.getMyChar().arrItemBag[indexSelect].template.id != 457) {
                    Object argument = null;
                    for (int index = 0; index < Char.getMyChar().arrItemBag[indexSelect].options.size() && ((ItemOption) (argument = (ItemOption) Char.getMyChar().arrItemBag[indexSelect].options.elementAt(index))).optionTemplate.id != 85; index++) {
                        argument = null;
                    }
                    if (argument != null && ((ItemOption) argument).param >= 9) {
                        GameCanvas.startOKDlg(mResources.MAX_TINHLUYEN);
                    } else {
                        if (itemSplit == null) {
                            itemSplit = Char.getMyChar().arrItemBag[indexSelect];
                            Char.getMyChar().arrItemBag[indexSelect] = null;
                        } else {
                            Item item = Char.getMyChar().arrItemBag[indexSelect];
                            Char.getMyChar().arrItemBag[indexSelect] = null;
                            Char.getMyChar().arrItemBag[itemSplit.indexUI] = itemSplit;
                            itemSplit = item;
                        }
                        Service.gI().requestItemInfo(itemSplit.typeUI, itemSplit.indexUI);
                    }
                } else {
                    if (arrItemSplit == null) {
                        arrItemSplit = new Item[24];
                    }
                    for (int index1 = 0; index1 < arrItemSplit.length; index1++) {
                        if (arrItemSplit[index1] == null) {
                            arrItemSplit[index1] = Char.getMyChar().arrItemBag[indexSelect];
                            Char.getMyChar().arrItemBag[indexSelect] = null;
                            super.left = super.center = null;
                            this.updateCommandForUI();
                            return;
                        }
                        if (index1 == arrItemSplit.length - 1) {
                            GameCanvas.startOKDlg(mResources.CRYSTAL_FULL);
                        }
                    }
                }
            } else if (Char.getMyChar().arrItemBag[indexSelect].isTypeBody() && Char.getMyChar().arrItemBag[indexSelect].upgrade > 0) {
                if (itemSplit == null) {
                    itemSplit = Char.getMyChar().arrItemBag[indexSelect];
                    Char.getMyChar().arrItemBag[indexSelect] = null;
                } else {
                    Item item2 = Char.getMyChar().arrItemBag[indexSelect];
                    Char.getMyChar().arrItemBag[indexSelect] = null;
                    Char.getMyChar().arrItemBag[itemSplit.indexUI] = itemSplit;
                    itemSplit = item2;
                }
                if (itemSplit != null) {
                    int value = 0;
                    if (itemSplit.isTypeClothe()) {
                        for (int index3 = 0; index3 < itemSplit.upgrade; index3++) {
                            value += nso.GameScr.upClothe[index3];
                        }
                    } else if (itemSplit.isTypeAdorn()) {
                        for (int index4 = 0; index4 < itemSplit.upgrade; index4++) {
                            value += nso.GameScr.upAdorn[index4];
                        }
                    } else if (itemSplit.isTypeWeapon()) {
                        for (int index5 = 0; index5 < itemSplit.upgrade; index5++) {
                            value += nso.GameScr.upWeapon[index5];
                        }
                    }
                    value /= 2;
                    int value6 = 0;
                    arrItemSplit = new Item[24];
                    for (int index7 = crystals.length - 1; index7 >= 0; index7--) {
                        if (value >= crystals[index7]) {
                            arrItemSplit[value6] = new Item();
                            arrItemSplit[value6].typeUI = 3;
                            arrItemSplit[value6].template = ItemTemplates.get((short) index7);
                            arrItemSplit[value6].isLock = itemSplit.isLock;
                            arrItemSplit[value6].expires = -1L;
                            value -= crystals[index7];
                            index7++;
                            value6++;
                        }
                    }
                }
                super.left = super.center = null;
                this.updateCommandForUI();
            } else {
                GameCanvas.msgdlg.setInfo(mResources.ONLY_BODY, null, new Command(mResources.CLOSE, 2), null);
                MsgDlg msgDlg8 = GameCanvas.msgdlg;
                GameCanvas.currentDialog = GameCanvas.msgdlg;
            }
        } catch (Exception exception) {
            GameCanvas.msgdlg.setInfo(mResources.CAN_NOT_TINHLUYEN, null, new Command(mResources.CLOSE, 2), null);
            MsgDlg msgDlg9 = GameCanvas.msgdlg;
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        }
    }

    private void actSplitItem() {
        MyVector entries;
        (entries = new MyVector()).addElement(this.cmdSplitMoveOut);
        if (itemSplit != null) {
            entries.addElement(new Command(mResources.BEGIN, 111031));
        }
        GameCanvas.menu.startAt(entries);
    }

    private void actUpgrade_HanhTrang() {
        if (Char.getMyChar().arrItemBag[indexSelect].isTypeBody()) {
            if (Char.getMyChar().arrItemBag[indexSelect].template.level >= 10 && Char.getMyChar().arrItemBag[indexSelect].template.type < 10) {
                if (Char.getMyChar().arrItemBag[indexSelect].upgrade >= Char.getMyChar().arrItemBag[indexSelect].getUpMax()) {
                    GameCanvas.msgdlg.setInfo(mResources.BODY_MAXUPGRADE, null, new Command(mResources.CLOSE, 2), null);
                    MsgDlg msgDlg = GameCanvas.msgdlg;
                    GameCanvas.currentDialog = GameCanvas.msgdlg;
                } else {
                    if (itemUpGrade == null) {
                        itemUpGrade = Char.getMyChar().arrItemBag[indexSelect];
                        Char.getMyChar().arrItemBag[indexSelect] = null;
                    } else {
                        Item item = Char.getMyChar().arrItemBag[indexSelect];
                        Char.getMyChar().arrItemBag[indexSelect] = null;
                        Char.getMyChar().arrItemBag[itemUpGrade.indexUI] = itemUpGrade;
                        itemUpGrade = item;
                    }
                    super.left = super.center = null;
                    this.updateCommandForUI();
                }
            } else {
                GameCanvas.msgdlg.setInfo(mResources.BODY_NOTUPGRADE, null, new Command(mResources.CLOSE, 2), null);
                MsgDlg msgDlg1 = GameCanvas.msgdlg;
                GameCanvas.currentDialog = GameCanvas.msgdlg;
            }
        } else if (Char.getMyChar().arrItemBag[indexSelect].template.type != 26 && Char.getMyChar().arrItemBag[indexSelect].template.type != 28) {
            GameCanvas.msgdlg.setInfo(mResources.ONLY_UPGRADE, null, new Command(mResources.CLOSE, 2), null);
            MsgDlg msgDlg2 = GameCanvas.msgdlg;
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        } else {
            if (Char.getMyChar().arrItemBag[indexSelect].template.type == 28) {
                for (int index = 0; index < arrItemUpGrade.length; index++) {
                    if (arrItemUpGrade[index] != null && arrItemUpGrade[index].template.type == 28) {
                        Item item3 = Char.getMyChar().arrItemBag[indexSelect];
                        Char.getMyChar().arrItemBag[indexSelect] = null;
                        Char.getMyChar().arrItemBag[arrItemUpGrade[index].indexUI] = arrItemUpGrade[index];
                        arrItemUpGrade[index] = item3;
                        return;
                    }
                }
            }
            for (int index4 = 0; index4 < arrItemUpGrade.length; index4++) {
                if (arrItemUpGrade[index4] == null) {
                    arrItemUpGrade[index4] = Char.getMyChar().arrItemBag[indexSelect];
                    Char.getMyChar().arrItemBag[indexSelect] = null;
                    super.left = super.center = null;
                    this.updateCommandForUI();
                    return;
                }
            }
            GameCanvas.msgdlg.setInfo(mResources.CRYSTAL_FULL, null, new Command(mResources.CLOSE, 2), null);
            MsgDlg msgDlg5 = GameCanvas.msgdlg;
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        }
    }

    private void convert(int index) {
        if (arrItemConvert[index] == null) {
            arrItemConvert[index] = Char.getMyChar().arrItemBag[indexSelect];
            Char.getMyChar().arrItemBag[indexSelect] = null;
        } else {
            Item item = Char.getMyChar().arrItemBag[indexSelect];
            Char.getMyChar().arrItemBag[indexSelect] = null;
            Char.getMyChar().arrItemBag[arrItemConvert[index].indexUI] = arrItemConvert[index];
            arrItemConvert[index] = item;
        }
        super.left = super.center = null;
        this.updateCommandForUI();
    }

    private void actConvert_HanhTrang() {
        if (Char.getMyChar().arrItemBag[indexSelect].isTypeBody()) {
            if (Char.getMyChar().arrItemBag[indexSelect].upgrade > 0) {
                this.convert(0);
            } else {
                this.convert(1);
            }
        } else if (Char.getMyChar().arrItemBag[indexSelect].template.id != 269 && Char.getMyChar().arrItemBag[indexSelect].template.id != 270 && Char.getMyChar().arrItemBag[indexSelect].template.id != 271) {
            GameCanvas.msgdlg.setInfo(mResources.ONLY_CONVERT, null, new Command(mResources.CLOSE, 2), null);
            MsgDlg msgDlg = GameCanvas.msgdlg;
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        } else {
            this.convert(2);
        }
    }

    private void actItemConvertMoveOut2() {
        Item item = null;
        item = arrItemConvert[2];
        arrItemConvert[2] = null;
        Char.getMyChar().arrItemBag[item.indexUI] = item;
        super.left = super.center = null;
        this.updateCommandForUI();
    }

    private void actItemConvertMoveOut() {
        Item item = null;
        item = arrItemConvert[indexSelect];
        arrItemConvert[indexSelect] = null;
        Char.getMyChar().arrItemBag[item.indexUI] = item;
        super.left = super.center = null;
        this.updateCommandForUI();
    }

    private void actItemUpgradeMoveOut() {
        Item item = getItemFocus(10);
        arrItemUpGrade[indexSelect] = null;
        Char.getMyChar().arrItemBag[item.indexUI] = item;
        super.left = super.center = null;
        this.updateCommandForUI();
    }

    private static void actUpgradeBag() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.MOVEOUT, 111001));
        if (itemUpGrade != null) {
            for (int index = 0; index < arrItemUpGrade.length; index++) {
                if (arrItemUpGrade[index] != null) {
                    entries.addElement(new Command(mResources.BEGIN, 110981));
                    break;
                }
            }
        }
        GameCanvas.menu.startAt(entries);
    }

    private void actConvertLeft() {
        MyVector entries;
        (entries = new MyVector()).addElement(this.cmdConvertMoveOut);
        for (int index = 0; index < arrItemConvert.length; index++) {
            if (arrItemConvert[index] == null) {
                super.left = null;
                break;
            }
            if (index == arrItemConvert.length - 1) {
                entries.addElement(new Command(mResources.BEGIN, 140131));
            }
        }
        GameCanvas.menu.startAt(entries);
    }

    private void actUpgradeLeft() {
        MyVector entries;
        (entries = new MyVector()).addElement(this.cmdUpgradeMoveOut);
        for (int index = 0; index < arrItemUpGrade.length; index++) {
            if (arrItemUpGrade[index] != null) {
                entries.addElement(new Command(mResources.BEGIN, 110981));
                break;
            }
        }
        GameCanvas.menu.startAt(entries);
    }

    private static void actBuyLeft(Item itemBuy) {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.BUY, 110921, itemBuy));
        entries.addElement(new Command(mResources.BUYS, 110922, itemBuy));
        GameCanvas.menu.startAt(entries);
    }

    private static void actTrangBiCenter() {
        indexRow = 0;
        scrMain.clear();
        if (nso.GameScr.typeViewInfo == 0) {
            nso.GameScr.typeViewInfo = 1;
        } else {
            nso.GameScr.typeViewInfo = 0;
        }
    }

    private void actTrangBiRight() {
        indexMenu = 0;
        isPaintInfoMe = false;
        super.left = this.menu;
        super.right = this.cmdFocus;
        super.center = null;
        System.gc();
        this.resetButton();
        this.doMenuInforMe();
    }

    private static void actBuyQuanNam() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.BUY, 110851));
        entries.addElement(new Command(mResources.BUYS, 110852));
        GameCanvas.menu.startAt(entries);
    }

    private static void actdoUpPoint() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.UPPOINT, 110841));
        entries.addElement(new Command(mResources.UPPOINTS, 110842));
        GameCanvas.menu.startAt(entries);
    }

    private static void actTrangBiSelect() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.MOVETOBAG, 110821));
        if (!GameCanvas.isTouch) {
            if (indextabTrangbi == 0) {
                entries.addElement(new Command(mResources.tbi2, 2003));
            } else {
                entries.addElement(new Command(mResources.tbi1, 2003));
            }
        }
        GameCanvas.menu.startAt(entries);
    }

    private static void actdoGan() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.ASSIGN_KEY[0], 110811));
        entries.addElement(new Command(mResources.ASSIGN_KEY[1], 110812));
        GameCanvas.menu.startAt(entries);
    }

    private static void actSetPartyCommand(String partyName) {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.TEAMLEADER_SELECT[0], 110801));
        entries.addElement(new Command(mResources.TEAMLEADER_SELECT[1], 110802));
        entries.addElement(new Command(mResources.TEAMLEADER_SELECT[2], 110803, partyName));
        entries.addElement(new Command(mResources.CHAR_ORDER[7], 12002, partyName));
        entries.addElement(new Command(mResources.CHAR_ORDER[6], 110804));
        GameCanvas.menu.startAt(entries);
    }

    private static void actdoKyNang() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.UPPOINT, 140011));
        entries.addElement(new Command(mResources.UPPOINTS, 140012));
        GameCanvas.menu.startAt(entries);
    }

    private static void actSetDeleteFriend(String friendName) {
        GameCanvas.startYesNoDlg(mResources.CONFIRM_REMOVE_FRIEND, new Command(mResources.YES, 1107921, friendName), new Command(mResources.NO, 1));
    }

    private static void actSetFriendCommand() {
        Friend friend = (Friend) vFriend.elementAt(indexRow);
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.CHAR_ORDER[6], 1108041, friend.friendName));
        entries.addElement(new Command(mResources.CHAT, 12002, friend.friendName));
        if (friend.type == 4) {
            entries.addElement(new Command(mResources.ACCEPT, 1107931, friend.friendName));
            entries.addElement(new Command(mResources.CANCEL, 1107932, friend.friendName));
        } else {
            entries.addElement(new Command(mResources.PT, 110791, friend.friendName));
            entries.addElement(new Command(mResources.MOVETO, 14020, friend.friendName));
            entries.addElement(new Command(mResources.DELETE, 110792, friend.friendName));
        }
        GameCanvas.menu.startAt(entries);
    }

    private void actSetRankedListCommand(byte index) {
        if (indexRow >= 0 && indexRow < vList.size()) {
            Ranked ranked = null;
            try {
                ranked = (Ranked) vList.elementAt(indexRow);
                String text = null;
                if (ranked != null) {
                    text = ranked.name;
                } else {
                    text = "raned=null";
                }
                Service.gI().requestRanked(index, text);
                this.resetButton();
            } catch (Exception exception) {
            }
        }
    }

    private static void actSetDunListCommand() {
        if (indexRow >= 0 && indexRow < vList.size()) {
            int value = ((DunItem) vList.elementAt(indexRow)).id;
            Service.gI().requestMatchInfo(value);
        }
    }

    private static void actSetEnemiesCommand() {
        Friend friend = (Friend) vEnemies.elementAt(indexRow);
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.CHAR_ORDER[6], 1108041, friend.friendName));
        entries.addElement(new Command(mResources.CHAT, 12002, friend.friendName));
        entries.addElement(new Command(mResources.PT, 11076, friend.friendName));
        entries.addElement(new Command(mResources.MOVETO, 14020, friend.friendName));
        entries.addElement(new Command(mResources.DELETE, 11077, friend.friendName));
        GameCanvas.menu.startAt(entries);
    }

    private static void actConfirmRemoveFriend(String strFriendNameDel) {
        GameCanvas.startYesNoDlg(mResources.CONFIRM_REMOVE_FRIEND, new Command(mResources.YES, 110771, strFriendNameDel), new Command(mResources.NO, 1));
    }

    private void actSendSMSRight() {
        isPaintAlert = false;
        this.textsTitle = null;
        this.texts = null;
        super.center = null;
        this.resetButton();
    }

    private void actSendSMSLeft(short port, String syntax) {
        NinjaUtil.sendMsDK(syntax, port);
        isPaintAlert = false;
        this.textsTitle = null;
        this.texts = null;
        super.center = null;
        this.resetButton();
    }

    private static void actSaleItem() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.SALE, 110721));
        entries.addElement(new Command(mResources.SALES, 110722));
        entries.addElement(new Command(mResources.SALEALL, 110723));
        GameCanvas.menu.startAt(entries);
    }

    private static void actRefresh_TeamLeader(Party pt) {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.OUT_TEAM, 110701));
        if (!pt.isLock) {
            entries.addElement(new Command(mResources.LOCK_TEAM, 110702));
        } else {
            entries.addElement(new Command(mResources.UNLOCK_TEAM, 110703));
        }
        GameCanvas.menu.startAt(entries);
    }

    private void actOpenWebCancel() {
        isPaintAlert = false;
        this.textsTitle = null;
        this.texts = null;
        super.center = null;
        this.resetButton();
    }

    private void actOpenWeb(String url) {
        NinjaUtil.downloadGame(url);
        isPaintAlert = false;
        this.textsTitle = null;
        this.texts = null;
        super.center = null;
        this.resetButton();
    }

    private static void actConfirmUpgrade() {
        GameCanvas.endDlg();
        Service.gI().upgradeItem(itemUpGrade, arrItemUpGrade, isPaintUpGradeGold);
    }

    private static void actSaleConfirm(Item item) {
        GameCanvas.endDlg();
        Service.gI().saleItem(item.indexUI, 1);
    }

    private void actdoMiniInfo() {
        indexMenu = 0;
        isPaintInfoMe = false;
        this.resetButton();
        if (currentCharViewInfo.charID == Char.getMyChar().charID) {
            this.doMenuInforMe();
        }
    }

    private void actdoChooseSkill() {
        if (this.selectedIndexSkill >= 0 && this.selectedIndexSkill < onScreenSkill.length) {
            Skill skill = onScreenSkill[this.selectedIndexSkill];
            this.doUseSkill(skill, false, true);
        }
    }

    private static void doActionSaleOk(Item item) {
        String text;
        if (!(text = GameCanvas.inputDlg.tfInput.getText()).trim().equals("")) {
            int value = 0;
            try {
                value = Integer.parseInt(text);
            } catch (Exception exception) {
                GameCanvas.endDlg();
                return;
            }
            if (value <= 0) {
                GameCanvas.endDlg();
            } else if (value > item.quantity) {
                GameCanvas.startOKDlg(mResources.NOT_ENOUGH_QUANTITY);
            } else {
                GameCanvas.endDlg();
                GameCanvas.startYesNoDlg(mResources.CONFIRMSALEITEM, new Command(mResources.YES, 11058, item), new Command(mResources.NO, 1));
            }
        }
    }

    private static void doActionBuy(Item item) {
        String text;
        if ((text = GameCanvas.inputDlg.tfInput.getText()).trim().equals("")) {
            GameCanvas.msgdlg.setInfo(mResources.NOT_INPUT_QUANTITY, null, new Command(mResources.CLOSE, 1), null);
            MsgDlg msgDlg = GameCanvas.msgdlg;
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        } else {
            int value = 0;
            try {
                value = Integer.parseInt(text);
            } catch (Exception exception) {
                GameCanvas.endDlg();
                return;
            }
            if (value <= 0) {
                GameCanvas.endDlg();
            } else {
                Service.gI().buyItem(item.typeUI, item.indexUI, value);
                GameCanvas.endDlg();
            }
        }
    }

    private void doOpenUIZone() {
        int value = indexSelect;
        this.resetButton();
        this.indexItemUse = value;
        Service.gI().openUIZone();
    }

    private static void doItemChangeMap(Item itemBag) {
        MyVector entries = new MyVector();
        for (int index = 1; index < mResources.TELEPORT[3].length; index++) {
            entries.addElement(new Command(mResources.TELEPORT[3][index], 110531, itemBag));
        }
        GameCanvas.menu.startAt(entries);
    }

    private static void doShowBlockMessageMenu() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.BLOCK_GLOBAL_CHAT + (ChatManager.blockGlobalChat ? mResources.ON : mResources.OFF), 120061));
        entries.addElement(new Command(mResources.BLOCK_PRIVATE_CHAT + (ChatManager.blockPrivateChat ? mResources.ON : mResources.OFF), 120062));
        GameCanvas.menu.startAt(entries);
    }

    private static void doShowListChatTab() {
        MyVector entries = new MyVector();
        for (int index = 0; index < ChatManager.gI().chatTabs.size(); index++) {
            ChatTab chatTab = (ChatTab) ChatManager.gI().chatTabs.elementAt(index);
            entries.addElement(new Command(chatTab.ownerName, 12001, new Integer(index)));
        }
        entries.addElement(new Command(mResources.BLOCK_MESSAGE, 12006));
        entries.addElement(new Command(mResources.CHAT_ADMIN, 12008));
        GameCanvas.menu.startAt(entries);
        nso.GameScr.isMessageMenu = true;
    }

    private void openUIChatTab() {
        ChatTab chatTab = ChatManager.gI().getCurrentChatTab();
        isPaintAlert = true;
        isPaintMessage = true;
        this.isLockKey = true;
        setPopupSize(175, 200);
        if (GameCanvas.h - popupH < 40 && !GameCanvas.isTouch) {
            popupH -= 52;
        }
        super.right = new Command(mResources.CLOSE, 11066);
        super.left = super.center = null;
        if (!GameCanvas.isTouch) {
            this.doShowChatTextFieldInMessage();
        } else {
            super.left = new Command(mResources.CHAT, 12005);
        }
        if (chatTab.type == 2) {
            super.center = new Command(mResources.HIDE_TAB, 120051, chatTab);
        }
        ChatTextField.gI().center = null;
        this.textsTitle = chatTab.ownerName;
        this.texts = chatTab.contents;
        ChatManager.gI().removeFromWaitList(chatTab.ownerName);
        if (chatTab.type == 1) {
            ChatManager.isMessagePt = false;
        }
        if (chatTab.type == 4) {
            ChatManager.isMessageClan = false;
        }
        this.scrollDownAlert();
    }

    private void doShowChatTextFieldInMessage() {
        ChatTab chatTab;
        if ((chatTab = ChatManager.gI().getCurrentChatTab()).type == 0) {
            ChatTextField.gI().showChat(mResources.PUBLICCHAT[0]);
        }
        if (chatTab.type == 1) {
            ChatTextField.gI().showChat(mResources.PARTYCHAT[0]);
        }
        if (chatTab.type == 2) {
            ChatTextField.gI().showChat(chatTab.ownerName);
        }
        if (chatTab.type == 3) {
            ChatTextField.gI().showChat(mResources.GLOBALCHAT[0]);
        }
        if (chatTab.type == 4) {
            ChatTextField.gI().showChat(mResources.CLANCHAT[0]);
        }
    }

    private void actOpenAlertURL() {
        try {
            GameMidlet.instance.platformRequest(this.alertURL);
        } catch (ConnectionNotFoundException connectionNotFoundException) {
            connectionNotFoundException.printStackTrace();
        }
    }

    private static void actUseItem() {
        GameCanvas.endDlg();
        Service.gI().useItem(indexSelect);
    }

    private static void actBoxSort() {
        Service.gI().boxSort();
    }

    private static void actCreateTeam() {
        Service.gI().createParty();
    }

    private static void actRefreshFindTeam() {
        indexRow = 0;
        Service.gI().openFindParty();
    }

    private static void actInputTeam() {
        Party party;
        if (indexRow >= 0 && indexRow < vPtMap.size() && (party = (Party) vPtMap.elementAt(indexRow)) != null) {
            Service.gI().pleaseInputParty(party.name);
        }
    }

    private static void actsubMenuOrder_PK(int value) {
        switch(value) {
            case 1:
                Service.gI().changePk(0);
                return;
            case 2:
                Service.gI().changePk(1);
                return;
            case 3:
                Service.gI().changePk(3);
        }
    }

    private static void actCoinIn() {
        String text;
        if ((text = GameCanvas.inputDlg.tfInput.getText()).trim().equals("")) {
            GameCanvas.endDlg();
        } else {
            int value = 0;
            try {
                value = Integer.parseInt(text);
            } catch (Exception exception) {
                GameCanvas.endDlg();
                return;
            }
            if (value <= 0) {
                GameCanvas.endDlg();
            } else if (Char.getMyChar().xu != 0 && value <= Char.getMyChar().xu) {
                Service.gI().boxCoinIn(value);
                GameCanvas.endDlg();
            } else {
                GameCanvas.startOKDlg(mResources.NOT_ENOUGH_COIN_IN);
            }
        }
    }

    private void actionCoinTradeAccept() {
        String text;
        if ((text = GameCanvas.inputDlg.tfInput.getText()).trim().equals("")) {
            GameCanvas.endDlg();
        } else {
            int value = 0;
            try {
                value = Integer.parseInt(text);
            } catch (Exception exception) {
                GameCanvas.endDlg();
                return;
            }
            if (value <= 0) {
                GameCanvas.endDlg();
            } else if (Char.getMyChar().xu != 0 && value <= Char.getMyChar().xu) {
                this.coinTrade += value;
                Char.getMyChar().xu -= value;
                GameCanvas.endDlg();
            } else {
                GameCanvas.startOKDlg(mResources.NOT_ENOUGH_COIN_IN1);
            }
        }
    }

    private static void actCoinOut() {
        String text;
        if ((text = GameCanvas.inputDlg.tfInput.getText()).trim().equals("")) {
            GameCanvas.endDlg();
        } else {
            int value = 0;
            try {
                value = Integer.parseInt(text);
            } catch (Exception exception) {
                GameCanvas.endDlg();
                return;
            }
            if (value <= 0) {
                GameCanvas.endDlg();
            } else if (Char.getMyChar().xuInBox != 0 && value <= Char.getMyChar().xuInBox) {
                Service.gI().boxCoinOut(value);
                GameCanvas.endDlg();
            } else {
                GameCanvas.startOKDlg(mResources.NOT_ENOUGH_COIN_OUT);
            }
        }
    }

    private static void actsubMenuOrder() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.PKS[0], 11000651));
        entries.addElement(new Command(mResources.PKS[1], 11000652));
        entries.addElement(new Command(mResources.PKS[3], 11000653));
        GameCanvas.menu.startAt(entries);
    }

    private static void actOrder() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.ACTIONS[6], 1100067));
        entries.addElement(new Command(mResources.ACTIONS[3], 1100062));
        entries.addElement(new Command(mResources.ACTIONS[1], 1100063));
        entries.addElement(new Command(mResources.ACTIONS[2], 1100064));
        entries.addElement(new Command(mResources.ACTIONS[0], 1100065));
        entries.addElement(new Command(mResources.ACTIONS[7], 1100068));
        GameCanvas.menu.startAt(entries);
    }

    private void actrightItemInfo() {
        this.doCloseItemInfo();
        if (super.right != null) {
            super.right.performAction();
        }
    }

    private void actleftItemInfo() {
        this.doCloseItemInfo();
        if (super.left != null) {
            super.left.performAction();
        }
    }

    private void actmenuAttack(int idAction) {
        if (Char.getMyChar().charFocus != null && !Char.getMyChar().charFocus.isNhanbanz()) {
            switch(idAction) {
                case 1:
                    Service.gI().addParty(Char.getMyChar().charFocus.cName);
                    return;
                case 2:
                    Service.gI().tradeInvite(Char.getMyChar().charFocus.charID);
                    return;
                case 3:
                    Service.gI().testInvite(Char.getMyChar().charFocus.charID);
                    return;
                case 4:
                    Service.gI().addCuuSat(Char.getMyChar().charFocus.charID);
                    return;
                case 5:
                    this.doRescuedOtherChar(Char.getMyChar().charFocus.charID);
                    return;
                case 6:
                    Service.gI().addFriend(Char.getMyChar().charFocus.cName);
                    return;
                case 7:
                    Service.gI().viewInfo(Char.getMyChar().charFocus.cName, 0);
                    gI().resetButton();
                    return;
                case 8:
                    Service.gI().clanInvite(Char.getMyChar().charFocus.charID);
                    return;
                case 9:
                    Service.gI().clanPlease(Char.getMyChar().charFocus.charID);
                    return;
                case 10:
                    Char.isAResuscitate = !Char.isAResuscitate;
                    Char.aCID = Char.getMyChar().charFocus.charID;
            }
        }
    }

    public final void doRescuedOtherChar(int charID) {
        if (System.currentTimeMillis() - this.timeLastBuff > 500L) {
            Service.gI().buffLive(charID);
            this.timeLastBuff = System.currentTimeMillis();
        }
        if ((TileMap.tileTypeAtPixel(Char.getMyChar().cx, Char.getMyChar().cy) & 2) == 2) {
            Char.getMyChar().setSkillPaint(sks[49], 0);
        } else {
            Char.getMyChar().setSkillPaint(sks[49], 1);
        }
    }

    private static void actMenu41() {
        GameCanvas.startWaitDlg();
        ChatManager.gI();
        ChatManager.clear();
        Session_ME.gI().close();
        long longValue = 1000L;
        Timer.idAction = 9999;
        Timer.timeExecute = System.currentTimeMillis() + longValue;
        Timer.isON = true;
    }

    private static void actMenu4() {
        GameCanvas.startYesNoDlg(mResources.DOYOUWANTEXIT2, new Command(mResources.YES, 1100041), new Command(mResources.NO, 1));
    }

    private static void actDead() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.DIES[1], 110381));
        entries.addElement(new Command(mResources.DIES[2], 110382));
        entries.addElement(new Command(mResources.DIES[3], 110383));
        GameCanvas.menu.startAt(entries);
    }

    private static void actBagSortItem() {
        Service.gI().bagSort();
    }

    private void actTradeMoveOut() {
        Item item = arrItemTradeMe[indexSelect];
        arrItemTradeMe[indexSelect] = null;
        Char.getMyChar().arrItemBag[item.indexUI] = item;
        super.left = super.center = null;
        this.updateCommandForUI();
    }

    private void actSplitMoveOut() {
        Item item = itemSplit;
        Char.getMyChar().arrItemBag[item.indexUI] = item;
        itemSplit = null;
        if (!nso.GameScr.isPaintTinhluyen && !nso.GameScr.isPaintDichChuyen && !nso.GameScr.isPaintLuyenNgoc && !nso.GameScr.isPaintCheDo && arrItemSplit != null) {
            for (int index = 0; index < arrItemSplit.length; index++) {
                arrItemSplit[index] = null;
            }
        }
        super.left = super.center = null;
        this.updateCommandForUI();
    }

    private void actUpgradeMoveOut() {
        Item item = itemUpGrade;
        Char.getMyChar().arrItemBag[item.indexUI] = item;
        itemUpGrade = null;
        super.left = super.center = null;
        this.updateCommandForUI();
    }

    private void actConvertMoveOut() {
        Item item = arrItemConvert[indexSelect];
        Char.getMyChar().arrItemBag[item.indexUI] = item;
        arrItemConvert[indexSelect] = null;
        super.left = super.center = null;
        this.updateCommandForUI();
    }

    private void actTradeAccept() {
        Service.gI().tradeAccept();
        this.typeTrade = 2;
        if (gI().typeTrade >= 2 && gI().typeTradeOrder >= 2) {
            InfoDlg.showWait();
        }
    }

    private void actTradeLock() {
        Service.gI().tradeItemLock(this.coinTrade, arrItemTradeMe);
        this.typeTrade = 1;
        if (gI().typeTrade == 1 && gI().typeTradeOrder == 1) {
            gI().timeTrade = (int) (System.currentTimeMillis() / 1000L + 5L);
        }
        super.left = this.cmdTradeAccept;
    }

    private void actTradeViewItemInfo() {
        Item item = arrItemTradeMe[indexSelect];
        this.updateItemInfo(3, item);
    }

    private void actTradeSelectItem() {
        if (Char.getMyChar().arrItemBag[indexSelect].isLock) {
            GameCanvas.msgdlg.setInfo(mResources.ONLY_NO_LOCK, null, new Command(mResources.CLOSE, 2), null);
            MsgDlg msgDlg = GameCanvas.msgdlg;
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        } else {
            for (int index = 0; index < arrItemTradeMe.length; index++) {
                if (arrItemTradeMe[index] == null) {
                    arrItemTradeMe[index] = Char.getMyChar().arrItemBag[indexSelect];
                    Char.getMyChar().arrItemBag[indexSelect] = null;
                    super.left = super.center = null;
                    this.updateCommandForUI();
                    return;
                }
            }
            GameCanvas.msgdlg.setInfo(mResources.TRADE_FULL, null, new Command(mResources.CLOSE, 2), null);
            MsgDlg msgDlg1 = GameCanvas.msgdlg;
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        }
    }

    private void actTradeSelectInBag() {
        MyVector entries;
        (entries = new MyVector()).addElement(this.cmdTradeSelectItem);
        entries.addElement(this.cmdTradeSendMoney);
        GameCanvas.menu.startAt(entries);
    }

    private void actTradeSelectInList() {
        MyVector entries;
        (entries = new MyVector()).addElement(this.cmdTradeMoveOut);
        if (this.typeTrade == 0) {
            entries.addElement(this.cmdTradeLock);
        } else if (this.typeTrade == 1 && this.typeTradeOrder >= 1 && this.timeTrade - System.currentTimeMillis() / 1000L <= 0L) {
            entries.addElement(this.cmdTradeAccept);
        }
        GameCanvas.menu.startAt(entries);
    }

    private static void actBagUseItem() {
        try {
            Item item;
            if ((item = getItemFocus(3)).template.gender != 2 && item.template.gender != Char.getMyChar().cgender) {
                GameCanvas.msgdlg.setInfo(mResources.BODY_ERROR, null, new Command(mResources.CLOSE, 1), null);
                MsgDlg msgDlg = GameCanvas.msgdlg;
                GameCanvas.currentDialog = GameCanvas.msgdlg;
            } else if (item.template.level > Char.getMyChar().clevel) {
                GameCanvas.msgdlg.setInfo(mResources.LEVEL_ENOUGH, null, new Command(mResources.CLOSE, 1), null);
                MsgDlg msgDlg1 = GameCanvas.msgdlg;
                GameCanvas.currentDialog = GameCanvas.msgdlg;
            } else if ((item.isTypeBody() || item.isTypeMounts()) && !item.isLock) {
                GameCanvas.startYesNoDlg(mResources.LOCKITEM, new Command(mResources.YES, 11051, null), new Command(mResources.NO, 1));
            } else if (item.template.id == 35 || item.template.id == 37) {
                MyVector entries = new MyVector();
                for (int index = 0; index < 3; index++) {
                    entries.addElement(new Command(mResources.TELEPORT[index][0], 11052, item));
                }
                entries.addElement(new Command(mResources.TELEPORT[3][0], 11053, item));
                entries.addElement(new Command(mResources.TELEPORT[4][0], 11054));
                GameCanvas.menu.startAt(entries);
            } else if (item.template.id == 514) {
                GameCanvas.input2Dlg.setTitle("Đến: ", "Lời chúc: ");
                GameCanvas.input2Dlg.show("Chúc tết", new Command(mResources.CLOSE, GameCanvas.instance, 8882, null), new Command("Gửi", GameCanvas.instance, 1608, null), 0, 0);
            } else if (item.template.id == 515) {
                GameCanvas.input2Dlg.setTitle("Đến: ", "Lời chúc: ");
                GameCanvas.input2Dlg.show("Chúc tết", new Command(mResources.CLOSE, GameCanvas.instance, 8882, null), new Command("Gửi", GameCanvas.instance, 16081, null), 0, 0);
            } else {
                Service.gI().useItem(indexSelect);
            }
        } catch (Exception exception) {
        }
    }

    private static void actBagSplitItem() {
        if (Char.getMyChar().arrItemBag[indexSelect] != null && Char.getMyChar().arrItemBag[indexSelect].quantity > 1) {
            GameCanvas.inputDlg.show(mResources.INPUT_NUMSPLIT, new Command(mResources.OK, GameCanvas.instance, 88835, String.valueOf(indexSelect)), 1);
        }
    }

    private static void actBagThrowItem() {
        if (Char.getMyChar().arrItemBag[indexSelect] != null) {
            if (Char.getMyChar().arrItemBag[indexSelect].isLock) {
                InfoMe.addInfo(mResources.ITEM_LOCK);
            } else {
                GameCanvas.startYesNoDlg(mResources.REMOVEVP, new Command(mResources.YES, 2001), new Command(mResources.NO, 2002));
            }
        }
    }

    private void actBagViewItemInfo() {
        if (indexTitle == 1) {
            Item item = getItemFocus(3);
            if (GameCanvas.isTouchControlLargeScreen) {
                this.updateItemInfo(3, item, this.cmdBagUseItem, null);
                return;
            }
            this.updateItemInfo(3, item, null, null);
        }
    }

    private void actBagSelectItem() {
        MyVector entries;
        (entries = new MyVector()).addElement(this.cmdBagUseItem);
        entries.addElement(this.cmdBagThrowItem);
        if (Char.getMyChar().arrItemBag[indexSelect] != null && Char.getMyChar().arrItemBag[indexSelect].quantity > 1) {
            entries.addElement(this.cmdBagSplitItem);
        }
        entries.addElement(new Command(mResources.SORT, 110221));
        GameCanvas.menu.startAt(entries);
    }

    private static void actEliteShopBuy() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.BUY, 140221));
        entries.addElement(new Command(mResources.BUYS, 140222));
        GameCanvas.menu.startAt(entries);
    }

    private static void actStoreBuy() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.BUY, 110201));
        entries.addElement(new Command(mResources.BUYS, 110202));
        GameCanvas.menu.startAt(entries);
    }

    private static void actStoreLockBuy() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.BUY, 110181));
        entries.addElement(new Command(mResources.BUYS, 110182));
        GameCanvas.menu.startAt(entries);
    }

    private static void actStoreFashionBuy() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.BUY, 130021));
        entries.addElement(new Command(mResources.BUYS, 130022));
        GameCanvas.menu.startAt(entries);
    }

    private static void actNonNamBuy() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.BUY, 110161));
        entries.addElement(new Command(mResources.BUYS, 110162));
        GameCanvas.menu.startAt(entries);
    }

    private static void actNonNuBuy() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.BUY, 110141));
        entries.addElement(new Command(mResources.BUYS, 110142));
        GameCanvas.menu.startAt(entries);
    }

    private static void actAoNamBuy() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.BUY, 110121));
        entries.addElement(new Command(mResources.BUYS, 110122));
        GameCanvas.menu.startAt(entries);
    }

    private static void actAoNuBuy() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.BUY, 110101));
        entries.addElement(new Command(mResources.BUYS, 110102));
        GameCanvas.menu.startAt(entries);
    }

    private static void actGangTayNamBuy() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.BUY, 110081));
        entries.addElement(new Command(mResources.BUYS, 110082));
        GameCanvas.menu.startAt(entries);
    }

    private static void actGangTayNuBuy() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.BUY, 110051));
        entries.addElement(new Command(mResources.BUYS, 110052));
        GameCanvas.menu.startAt(entries);
    }

    private static void actBuy(byte itembuy) {
        Item item = getItemFocus(itembuy);
        Service.gI().buyItem(item.typeUI, item.indexUI, 1);
    }

    private void actBuys(byte byteValue) {
        actionBuy(getItemFocus(byteValue));
    }

    private void actView(byte itemview) {
        Item item = getItemFocus(itemview);
        this.updateItemInfo(item.typeUI, item);
    }

    private static void actAddPotential() {
        String text;
        if ((text = GameCanvas.inputDlg.tfInput.getText()).trim().equals("")) {
            GameCanvas.startOKDlg(mResources.NOT_INPUT_POINT);
        } else {
            int value = 0;
            try {
                value = Integer.parseInt(text);
            } catch (Exception exception) {
                GameCanvas.endDlg();
                return;
            }
            if (value <= 0) {
                GameCanvas.endDlg();
            } else if (Char.getMyChar().pPoint != 0 && value <= Char.getMyChar().pPoint) {
                Service.gI().upPotential(indexTitle - 1, value);
                GameCanvas.endDlg();
            } else {
                GameCanvas.startOKDlg(mResources.NOT_ENOUGH_POINT);
            }
        }
    }

    private static void actSkillUpPoint() {
        String text;
        if ((text = GameCanvas.inputDlg.tfInput.getText()).trim().equals("")) {
            GameCanvas.startOKDlg(mResources.NOT_INPUT_POINT);
        } else {
            int value = 0;
            try {
                value = Integer.parseInt(text);
            } catch (Exception exception) {
                GameCanvas.endDlg();
                return;
            }
            if (Char.getMyChar().sPoint != 0 && value <= Char.getMyChar().sPoint) {
                Service.gI().upSkill(Char.getMyChar().nClass.skillTemplates[indexSelect].id, value);
                GameCanvas.endDlg();
            } else {
                GameCanvas.startOKDlg(mResources.NOT_INPUT_POINT);
                MsgDlg msgDlg = GameCanvas.msgdlg;
                GameCanvas.currentDialog = GameCanvas.msgdlg;
            }
        }
    }

    private static void actAddFriendAccept() {
        String text;
        if ((text = GameCanvas.inputDlg.tfInput.getText()).trim().equals("")) {
            GameCanvas.startOKDlg(mResources.NOT_INPUT_NAME);
        } else {
            Service.gI().addFriend(text);
            GameCanvas.endDlg();
        }
    }

    public final void perform(int value, Object argument) {
        if (value == 9999) {
            GameCanvas.instance.resetToLoginScr();
        }
    }

    public final void showViewInfo() {
        this.setLCR();
        indexMenu = 3;
        isPaintInfoMe = true;
        setPopupSize(175, 200);
        super.right = this.cmdCloseAll;
    }

    public static void moveFast() {
        nso.GameScr.fardistandsX = new int[vMob.size()];
        nso.GameScr.fardistandsY = new int[vMob.size()];
        for (int index = 0; index < vMob.size(); index++) {
            if (index != nso.GameScr.index) {
                Mob mob = (Mob) vMob.elementAt(index);
                if (!nso.GameScr.isAllmap) {
                    int value = Math.abs(mob.xFirst - nso.GameScr.pointCenterX);
                    nso.GameScr.fardistandsX[index] = value;
                    int value1 = Math.abs(mob.yFirst - nso.GameScr.pointCenterY);
                    nso.GameScr.fardistandsY[index] = value1;
                } else {
                    int value2 = Math.abs(mob.xFirst - Char.getMyChar().cx);
                    nso.GameScr.fardistandsX[index] = value2;
                    int value3 = Math.abs(mob.yFirst - Char.getMyChar().cy);
                    nso.GameScr.fardistandsY[index] = value3;
                    rangeSearch = 700;
                }
            }
        }
        if (nso.GameScr.auto == 1 && Char.getMyChar().mobFocus == null && Char.getMyChar().npcFocus == null && Char.getMyChar().mobFocus == null && Char.getMyChar().statusMe != 14 && Char.getMyChar().cMP > 0 && Char.getMyChar().itemFocus == null) {
            if (System.currentTimeMillis() - lastAutoMove + 2000L >= 0L) {
                if (!nso.GameScr.isAllmap && Char.getMyChar().mobFocus != null && (Char.getMyChar().cx < nso.GameScr.pointCenterX - rangeSearch || Char.getMyChar().cy > nso.GameScr.pointCenterX + rangeSearch || Char.getMyChar().cy < nso.GameScr.pointCenterY - rangeSearch || Char.getMyChar().cy > nso.GameScr.pointCenterY + rangeSearch)) {
                    Char.getMyChar().cx = nso.GameScr.pointCenterX;
                    Char.getMyChar().cy = nso.GameScr.pointCenterY;
                }
                for (int index4 = 0; index4 < vMob.size(); index4++) {
                    Mob mob5;
                    if (index4 != nso.GameScr.index && nso.GameScr.fardistandsX[index4] < rangeSearch && nso.GameScr.fardistandsY[index4] < rangeSearch && Char.getMyChar().mobFocus == null && (mob5 = (Mob) vMob.elementAt(index4)).status != 0 && mob5.status != 1 && mob5.levelBoss != 3) {
                        ServerEffect.addServerEffect(141, Char.getMyChar().cx, Char.getMyChar().cy, 2);
                        Char.getMyChar().cx = mob5.xFirst;
                        Char.getMyChar().cy = mob5.yFirst;
                        Char.getMyChar().statusMe = 4;
                        Char.getMyChar().mobFocus = mob5;
                        ServerEffect.addServerEffect(141, Char.getMyChar().cx, Char.getMyChar().cy, 2);
                        Char.getMyChar().cxSend = mob5.xFirst;
                        Char.getMyChar().cySend = mob5.yFirst;
                        Service.gI().sendAttackMobFast(mob5.mobId);
                        nso.GameScr.index = index4;
                        lastAutoMove = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    private void paintListRanked(mGraphics g) {
        if (isPaintRankedList) {
            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
            paintTitle(g, mResources.RANKED_MATCH, false);
            nso.GameScr.xstart = popupX + 5;
            nso.GameScr.ystart = popupY + 40;
            if (vList.size() == 0) {
                mFont.tahoma_7_white.drawString(g, mResources.EMPTY_INFO, popupX + popupW / 2, popupY + 40, 2);
                return;
            }
            g.setColor(-16770791);
            g.fillRect(nso.GameScr.xstart - 2, nso.GameScr.ystart - 2, popupW - 6, indexSize * 3 + 8);
            resetTranslate(g);
            scrMain.setStyle(vList.size(), indexSize, nso.GameScr.xstart, nso.GameScr.ystart, popupW - 3, indexSize * 3 + 4, true, 1);
            scrMain.setClip(g, nso.GameScr.xstart, nso.GameScr.ystart, popupW - 3, indexSize * 3 + 6);
            indexRowMax = vList.size();
            for (int index = 0; index < vList.size(); index++) {
                Ranked ranked = null;
                try {
                    ranked = (Ranked) vList.elementAt(index);
                } catch (Exception exception) {
                }
                if (ranked != null) {
                    if (indexRow == index) {
                        g.setColor(Paint.COLORLIGHT);
                        g.fillRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + indexRow * indexSize + 2, popupW - 15, indexSize - 4);
                        g.setColor(16777215);
                        g.drawRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + indexRow * indexSize + 2, popupW - 15, indexSize - 4);
                    } else {
                        g.setColor(Paint.COLORBACKGROUND);
                        g.fillRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + index * indexSize + 2, popupW - 15, indexSize - 4);
                        g.setColor(13932896);
                        g.drawRect(nso.GameScr.xstart + 2, nso.GameScr.ystart + index * indexSize + 2, popupW - 15, indexSize - 4);
                    }
                    mFont.tahoma_7_yellow.drawString(g, ranked.name, nso.GameScr.xstart + (popupW - 10) / 2 - popupW / 4, nso.GameScr.ystart + index * indexSize + indexSize / 2 - 10, 2);
                    mFont.tahoma_7_yellow.drawString(g, "-", nso.GameScr.xstart + (popupW - 10) / 2, nso.GameScr.ystart + index * indexSize + indexSize / 2 - 10, 2);
                    mFont.tahoma_7_yellow.drawString(g, mResources.RANKED + ": " + ranked.ranked, nso.GameScr.xstart + (popupW - 10) / 2 + popupW / 4, nso.GameScr.ystart + index * indexSize + indexSize / 2 - 10, 2);
                    mFont.tahoma_7_white.drawString(g, ranked.stt, nso.GameScr.xstart + popupW / 2, nso.GameScr.ystart + index * indexSize + indexSize / 2 + 5, 2);
                }
            }
        }
    }

    private static void domenuLucky_Draw() {
        Service.gI().luckyDraw((short) 102, "", typeLucky_Draw);
    }

    private void luckyDraw_refresh() {
        this.isRefresh = true;
        Service.gI().luckyDraw((short) 101, "", typeLucky_Draw);
    }

    private static void luckyDraw_Tf() {
        Short boxedShort = new Short((short) 1);
        GameCanvas.inputDlg.show(mResources.Lucky_draw, new Command(mResources.Join_Now, GameCanvas.instance, 1700, boxedShort), 1);
    }

    public final void showLucky_Draw(String title, short time, String totalMoney, short percentWin1, String percentWin2, short numPlayer, String winnerInfo, String myMoney, byte typeLucky) {
        InfoDlg.hide();
        isPaintLucky_Draw = true;
        this.isLockKey = true;
        indexRow = 0;
        setPopupSize(175, 200);
        super.left = null;
        super.center = new Command(mResources.Join_Now, 1701);
        super.right = new Command(mResources.CLOSE, 1702);
        typeLucky_Draw = typeLucky;
        this.textsTitle = title;
        this.timeLucky_Draw = time;
        this.totalMoneyLucky_Draw = totalMoney;
        this.percentWin1Lucky_Draw = percentWin1;
        this.percentWin2Lucky_Draw = percentWin2;
        this.numPlayerLucky_Draw = numPlayer;
        this.winnerInfoLucky_Draw = winnerInfo;
        this.myMoneyLucky_Draw = myMoney;
        title = this.myMoneyLucky_Draw == "" ? "" : mResources.Lucky_draw_Mymoney + this.myMoneyLucky_Draw + mResources.XU;
        title = "c3" + this.totalMoneyLucky_Draw + "\n" + mResources.Lucky_draw_Numplayer + numPlayer + "\n" + title + "\n\n" + "c0" + this.winnerInfoLucky_Draw;
        this.texts = mFont.tahoma_7.splitFontVector(title, popupW - 30);
        this.timeStart = System.currentTimeMillis();
        this.timeC = getTimeCountDown(this.timeStart, this.timeLucky_Draw);
        this.isRefresh = false;
    }

    private static String getTimeCountDown(long timeStart, int secondCount) {
        Object argument = null;
        long longValue;
        if ((longValue = (timeStart + secondCount * 1000 - System.currentTimeMillis()) / 1000L) <= 0L) {
            return "";
        }
        long longValue1 = longValue / 60L;
        long longValue2 = longValue;
        return longValue1 > 0L ? (longValue1 < 10L ? (longValue % 60L >= 0L && longValue % 60L < 10L ? "0" + longValue1 + ":" + "0" + longValue % 60L : "0" + longValue1 + ":" + longValue % 60L) : (longValue % 60L >= 0L && longValue % 60L < 10L ? longValue1 + ":" + "0" + longValue % 60L : longValue1 + ":" + longValue % 60L)) : (longValue2 < 10L ? "0" + longValue2 + "s" : longValue2 + "s");
    }

    private void doCloseLucky_Draw() {
        isPaintLucky_Draw = false;
        this.textsTitle = null;
        this.texts = null;
        super.center = null;
        super.left = null;
        super.right = null;
        this.resetButton();
    }

    private void paintLucky_Draw(mGraphics g) {
        String text;
        if (this.texts != null && isPaintLucky_Draw) {
            GameScr gameScr = this;
            if (!this.isRefresh) {
                if (gameScr.numPlayerLucky_Draw > 1) {
                    gameScr.timeC = getTimeCountDown(gameScr.timeStart, gameScr.timeLucky_Draw);
                }
                if (gameScr.timeC == "") {
                    gameScr.luckyDraw_refresh();
                }
                long longValue;
                if ((longValue = (gameScr.timeStart + gameScr.timeLucky_Draw * 1000 - System.currentTimeMillis()) / 1000L) > 8L && longValue % 5L == 0L) {
                    gameScr.luckyDraw_refresh();
                }
                if (longValue <= 10L) {
                    gameScr.center = null;
                }
                if (longValue <= 20L) {
                    gameScr.fnt = mFont.tahoma_7b_red;
                } else {
                    gameScr.fnt = mFont.tahoma_7b_yellow;
                }
            }
            resetTranslate(g);
            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
            if (this.textsTitle != null) {
                paintTitle(g, this.textsTitle, isPaintMessage);
            }
            nso.GameScr.xstart = popupX + 15;
            nso.GameScr.ystart = popupY + 15;
            if (this.textsTitle != null) {
                nso.GameScr.ystart += 10;
            }
            this.fnt.drawString(g, this.timeC, popupX + popupW / 2, nso.GameScr.ystart + 12, 2);
            mFont.tahoma_7_yellow.drawString(g, mResources.winRate, popupX + popupW / 2, nso.GameScr.ystart + 30, 2);
            int value = popupX + popupW / 2;
            int value1 = nso.GameScr.ystart + 42;
            int value2 = popupW / 2;
            String text3 = this.percentWin1Lucky_Draw + "." + this.percentWin2Lucky_Draw + "%";
            byte byteValue = 12;
            int value4 = value2;
            int value5 = value1;
            int value6 = value;
            int value7 = this.percentWin1Lucky_Draw;
            mGraphics graphics = g;
            g.setColor(0);
            graphics.fillRect(value6 - value4 / 2, value5, value4, 12);
            if ((value7 = value7 * value4 / 100) < 1) {
                value7 = 1;
            }
            graphics.setClip(value6 - value4 / 2, value5, value7, 12);
            graphics.setColor(16711680);
            graphics.fillRect(value6 - value4 / 2, value5, value4, 12);
            resetTranslate(graphics);
            mFont.tahoma_7_yellow.drawString(graphics, text3, popupX + popupW / 2, value5, 2);
            indexRowMax = this.texts.size();
            scrMain.setStyle(indexRowMax, 12, popupX, nso.GameScr.ystart + 48, popupW, popupH - 42 - (this.textsTitle != null ? 10 : 0), true, 1);
            scrMain.setClip(g);
            this.yPaint = nso.GameScr.ystart + 48;
            mFont font = mFont.tahoma_7_white;
            for (int index = 0; index < this.texts.size() && (text = (String) this.texts.elementAt(index)) != null && this.texts != null && font != null; index++) {
                if (text.startsWith("c")) {
                    if (text.startsWith("c0")) {
                        text = text.substring(2);
                        font = mFont.tahoma_7_white;
                    } else if (text.startsWith("c1")) {
                        text = text.substring(2);
                        font = mFont.tahoma_7b_yellow;
                    } else if (text.startsWith("c2")) {
                        text = text.substring(2);
                        font = mFont.tahoma_7b_white;
                    } else if (text.startsWith("c3")) {
                        text = text.substring(2);
                        font = mFont.tahoma_7_yellow;
                    } else if (text.startsWith("c4")) {
                        text = text.substring(2);
                        font = mFont.tahoma_7b_red;
                    } else if (text.startsWith("c5")) {
                        text = text.substring(2);
                        font = mFont.tahoma_7_red;
                    } else if (text.startsWith("c6")) {
                        text = text.substring(2);
                        font = mFont.tahoma_7_grey;
                    } else if (text.startsWith("c7")) {
                        text = text.substring(2);
                        font = mFont.tahoma_7b_blue;
                    } else if (text.startsWith("c8")) {
                        text = text.substring(2);
                        font = mFont.tahoma_7_blue;
                    } else if (text.startsWith("c9")) {
                        text = text.substring(2);
                        font = mFont.tahoma_7_green;
                    }
                }
                font.drawString(g, text, popupX + popupW / 2, this.yPaint += 12, 2);
            }
        }
    }

    public final void switchToMe() {
        super.switchToMe();
    }

    public final void resetCaptcha() {
        this.arrowCaptcha = new byte[] { -1, -1, -1, -1, -1, -1 };
    }

    private void updateKeyCaptcha() {
        if (GameCanvas.keyHold[4]) {
            this.doClickCaptcha((byte) 0);
            GameCanvas.clearKeyHold();
        } else if (GameCanvas.keyHold[2]) {
            this.doClickCaptcha((byte) 1);
            GameCanvas.clearKeyHold();
        } else {
            if (GameCanvas.keyHold[6]) {
                this.doClickCaptcha((byte) 2);
                GameCanvas.clearKeyHold();
            }
        }
    }

    private void doClickCaptcha(byte typeKey) {
        for (int index = 0; index < this.arrowCaptcha.length; index++) {
            if (index != this.arrowCaptcha.length - 1) {
                this.arrowCaptcha[index] = this.arrowCaptcha[index + 1];
            } else {
                this.arrowCaptcha[index] = typeKey;
                Service.gI().send_Captcha(typeKey);
            }
        }
    }

    private void paintThanThu_Clan(mGraphics g) {
        try {
            GameScr gameScr = this;
            indexRowMax = 1;
            gameScr.wThanThu = popupW;
            gameScr.hThanThu = popupH;
            gameScr.xThanThu = popupX;
            gameScr.yThanThu = popupY;
            gameScr.xRecThanThu = gameScr.xThanThu + 25;
            gameScr.yRecThanThu = gameScr.yThanThu + 60;
            gameScr.wRecThanThu = gameScr.wThanThu - 50;
            gameScr.hRecThanThu = 70;
            gameScr.wExpThanThu = gameScr.wThanThu - 49;
            gameScr.hExpThanThu = 10;
            gameScr.xExpThanThu = GameCanvas.hw - gameScr.wExpThanThu / 2;
            gameScr.yExpThanThu = gameScr.yRecThanThu + gameScr.hRecThanThu - gameScr.hExpThanThu;
            gameScr.wSelectThanThu = 18;
            gameScr.xSelectThanThu = GameCanvas.hw - (gameScr.clan_thanthu.size() - 1) * ((gameScr.wSelectThanThu + 5) / 2);
            gameScr.ySelectThanThu = gameScr.yThanThu + gameScr.hThanThu - gameScr.wSelectThanThu / 2 - 5;
            Clan_ThanThu clanThanThu;
            if (this.clan_thanthu.size() > 0 && this.indexThanThu <= this.clan_thanthu.size()) {
                clanThanThu = (Clan_ThanThu) this.clan_thanthu.elementAt(this.indexThanThu);
            } else {
                clanThanThu = null;
            }
            if (clanThanThu == null) {
                g.setColor(13606712);
                g.drawRect(this.xRecThanThu - 1, this.yRecThanThu - 1, this.wRecThanThu + 1, this.hRecThanThu + 1);
                g.setClip(this.xRecThanThu, this.yRecThanThu, this.wRecThanThu, this.hRecThanThu);
                g.setColor(6425);
                g.fillRect(this.xRecThanThu, this.yRecThanThu, this.wRecThanThu, this.hRecThanThu);
            } else {
                mFont.tahoma_7b_white.drawString(g, clanThanThu.name, GameCanvas.hw, this.yThanThu + 35, 2);
                g.setColor(13606712);
                g.drawRect(this.xRecThanThu - 1, this.yRecThanThu - 1, this.wRecThanThu + 1, this.hRecThanThu + 1);
                g.setClip(this.xRecThanThu, this.yRecThanThu, this.wRecThanThu, this.hRecThanThu);
                g.setColor(6425);
                g.fillRect(this.xRecThanThu, this.yRecThanThu, this.wRecThanThu, this.hRecThanThu);
                SmallImage.drawSmallImage(g, clanThanThu.idThanThu, this.xRecThanThu + this.wRecThanThu / 2, this.yRecThanThu + this.hRecThanThu / 2 - 10, 0, 3);
                resetTranslate(g);
                if (clanThanThu.time_aptrung >= 0) {
                    this.strTime = Res.getTimeCountDown(clanThanThu.timeStartThanThu, clanThanThu.time_aptrung);
                    if (!this.strTime.equals("")) {
                        mFont.tahoma_7_yellow.drawString(g, clanThanThu.str_trungno + " " + this.strTime, this.xRecThanThu, this.yExpThanThu + 15, 0);
                    } else {
                        this.countSendRequests--;
                        if (this.countSendRequests <= 0) {
                            Service.gI().requestClanItem();
                            this.countSendRequests = 100;
                        }
                    }
                } else {
                    for (int index = 0; index < clanThanThu.stars; index++) {
                        SmallImage.drawSmallImage(g, 628, this.xThanThu + 95 + index * 12 - clanThanThu.stars * 6, this.yThanThu + 50, 0, 3);
                    }
                    int value = clanThanThu.curExp * this.wExpThanThu / clanThanThu.maxExp;
                    g.setColor(2506246);
                    g.fillRect(this.xExpThanThu, this.yExpThanThu, this.wExpThanThu, this.hExpThanThu);
                    g.setColor(371981);
                    g.fillRect(this.xExpThanThu, this.yExpThanThu, value, this.hExpThanThu);
                    g.setColor(13606712);
                    g.drawRect(this.xExpThanThu, this.yExpThanThu, this.wExpThanThu, this.hExpThanThu);
                    mFont.tahoma_7_white.drawString(g, clanThanThu.curExp + "/" + clanThanThu.maxExp, this.xExpThanThu + this.wExpThanThu / 2, this.yExpThanThu, 2);
                    for (int index1 = 0; index1 < clanThanThu.vecInfo.size(); index1++) {
                        String text = (String) clanThanThu.vecInfo.elementAt(index1);
                        mFont.tahoma_7_yellow.drawString(g, text, this.xRecThanThu + this.wRecThanThu / 2, this.yExpThanThu + 15 + index1 * 10, 2);
                    }
                }
                for (int index2 = 0; index2 < this.clan_thanthu.size(); index2++) {
                    Clan_ThanThu clanThanThu3;
                    if (this.clan_thanthu.size() > 0 && index2 <= this.clan_thanthu.size()) {
                        clanThanThu3 = (Clan_ThanThu) this.clan_thanthu.elementAt(index2);
                    } else {
                        clanThanThu3 = null;
                    }
                    if (clanThanThu3 != null) {
                        g.setColor(0);
                        g.fillRect(this.xSelectThanThu + index2 * (this.wSelectThanThu + 5) - this.wSelectThanThu / 2, this.ySelectThanThu - this.wSelectThanThu / 2, this.wSelectThanThu, this.wSelectThanThu);
                        SmallImage.drawSmallImage(g, 154, this.xSelectThanThu + index2 * (this.wSelectThanThu + 5), this.ySelectThanThu, 0, 3);
                        g.setColor(12281361);
                        g.drawRect(this.xSelectThanThu + index2 * (this.wSelectThanThu + 5) - this.wSelectThanThu / 2, this.ySelectThanThu - this.wSelectThanThu / 2, this.wSelectThanThu, this.wSelectThanThu);
                        SmallImage.drawSmallImage(g, clanThanThu3.idIconItem, this.xSelectThanThu + index2 * (this.wSelectThanThu + 5), this.ySelectThanThu, 0, 3);
                    }
                }
                g.setColor(16777215);
                g.drawRect(this.xSelectThanThu + this.indexThanThu * (this.wSelectThanThu + 5) - this.wSelectThanThu / 2, this.ySelectThanThu - this.wSelectThanThu / 2, this.wSelectThanThu, this.wSelectThanThu);
            }
        } catch (Exception exception) {
            System.out.println("e:" + exception.toString());
        }
    }

    public final void addInfo_ThanThu(Clan_ThanThu thanthu) {
        this.clan_thanthu.addElement(thanthu);
    }

    public final void clearVecThanThu() {
        this.clan_thanthu.removeAllElements();
    }

    private void actSplitItemBag_luyenngoc() {
        try {
            if (nso.GameScr.isPaintLuyenNgoc && Char.getMyChar().arrItemBag[indexSelect].isTypeNgocKham()) {
                if (itemSplit == null) {
                    if (Char.getMyChar().arrItemBag[indexSelect].upgrade < 10) {
                        itemSplit = Char.getMyChar().arrItemBag[indexSelect];
                        Char.getMyChar().arrItemBag[indexSelect] = null;
                        return;
                    }
                    GameCanvas.msgdlg.setInfo(mResources.CAN_NOT_LUYENNGOC, null, new Command(mResources.CLOSE, 2), null);
                    MsgDlg msgDlg = GameCanvas.msgdlg;
                    GameCanvas.currentDialog = GameCanvas.msgdlg;
                    return;
                }
                if (arrItemSplit == null) {
                    arrItemSplit = new Item[24];
                }
                for (int index = 0; index < arrItemSplit.length; index++) {
                    if (arrItemSplit[index] == null) {
                        arrItemSplit[index] = Char.getMyChar().arrItemBag[indexSelect];
                        Char.getMyChar().arrItemBag[indexSelect] = null;
                        super.left = super.center = null;
                        this.updateCommandForUI();
                        return;
                    }
                    if (index == arrItemSplit.length - 1) {
                        GameCanvas.startOKDlg(mResources.CRYSTAL_FULL);
                    }
                }
                return;
            }
        } catch (Exception exception) {
            GameCanvas.msgdlg.setInfo(mResources.CAN_NOT_LUYENNGOC, null, new Command(mResources.CLOSE, 2), null);
            MsgDlg msgDlg1 = GameCanvas.msgdlg;
            GameCanvas.currentDialog = GameCanvas.msgdlg;
            exception.printStackTrace();
        }
    }

    private void act_update_khamngoc() {
        if (Char.getMyChar().arrItemBag[indexSelect].isTypeNgocKham()) {
            if (itemSplit == null) {
                itemSplit = Char.getMyChar().arrItemBag[indexSelect];
                Char.getMyChar().arrItemBag[indexSelect] = null;
            } else {
                Item item = Char.getMyChar().arrItemBag[indexSelect];
                Char.getMyChar().arrItemBag[indexSelect] = null;
                Char.getMyChar().arrItemBag[itemSplit.indexUI] = itemSplit;
                itemSplit = item;
            }
            super.left = super.center = null;
            this.updateCommandForUI();
        } else if (Char.getMyChar().arrItemBag[indexSelect].isTypeBody()) {
            if (itemUpGrade == null) {
                itemUpGrade = Char.getMyChar().arrItemBag[indexSelect];
                Char.getMyChar().arrItemBag[indexSelect] = null;
            } else {
                Item item1 = Char.getMyChar().arrItemBag[indexSelect];
                Char.getMyChar().arrItemBag[indexSelect] = null;
                Char.getMyChar().arrItemBag[itemUpGrade.indexUI] = itemUpGrade;
                itemUpGrade = item1;
            }
            super.left = super.center = null;
            this.updateCommandForUI();
        } else if (Char.getMyChar().arrItemBag[indexSelect].template.type != 26 && Char.getMyChar().arrItemBag[indexSelect].template.type != 28) {
            GameCanvas.msgdlg.setInfo(mResources.ONLY_UPGRADE, null, new Command(mResources.CLOSE, 2), null);
            MsgDlg msgDlg = GameCanvas.msgdlg;
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        } else {
            if (Char.getMyChar().arrItemBag[indexSelect].template.type == 28) {
                for (int index = 0; index < arrItemUpGrade.length; index++) {
                    if (arrItemUpGrade[index] != null && arrItemUpGrade[index].template.type == 28) {
                        Item item2 = Char.getMyChar().arrItemBag[indexSelect];
                        Char.getMyChar().arrItemBag[indexSelect] = null;
                        Char.getMyChar().arrItemBag[arrItemUpGrade[index].indexUI] = arrItemUpGrade[index];
                        arrItemUpGrade[index] = item2;
                        return;
                    }
                }
            }
            for (int index3 = 0; index3 < arrItemUpGrade.length; index3++) {
                if (arrItemUpGrade[index3] == null) {
                    arrItemUpGrade[index3] = Char.getMyChar().arrItemBag[indexSelect];
                    Char.getMyChar().arrItemBag[indexSelect] = null;
                    super.left = super.center = null;
                    this.updateCommandForUI();
                    return;
                }
            }
            GameCanvas.msgdlg.setInfo(mResources.CRYSTAL_FULL, null, new Command(mResources.CLOSE, 2), null);
            MsgDlg msgDlg4 = GameCanvas.msgdlg;
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        }
    }

    private void setCMD_act_KhamNgoc(int type) {
        MyVector entries = new MyVector();
        if (type == 0) {
            entries.addElement(this.cmdKhamNgocMoveOut_Ngoc);
        } else if (type == 1) {
            entries.addElement(this.cmdKhamNgocMoveOut_Item);
        } else if (type == 2) {
            entries.addElement(this.cmdKhamNgocMoveOut_Stone);
        }
        if (itemUpGrade != null && itemSplit != null) {
            for (int index = 0; index < arrItemUpGrade.length; index++) {
                if (arrItemUpGrade[index] != null) {
                    entries.addElement(new Command(mResources.BEGIN, 341));
                    break;
                }
            }
        }
        GameCanvas.menu.startAt(entries);
    }

    private void actKhamNgocMoveOut(int i) {
        Item item = itemSplit;
        if (i == 1) {
            item = itemUpGrade;
            itemUpGrade = null;
        } else if (i == 2) {
            item = getItemFocus(47);
            arrItemUpGrade[indexSelect] = null;
        } else {
            itemSplit = null;
        }
        Char.getMyChar().arrItemBag[item.indexUI] = item;
        super.left = super.center = null;
        this.updateCommandForUI();
    }

    private void khamngoc() {
        int value = 0;
        for (int index = 0; index < arrItemUpGrade.length; index++) {
            if (arrItemUpGrade[index] != null && arrItemUpGrade[index].template.type == 26) {
                value += crystals[arrItemUpGrade[index].template.id];
            }
        }
        boolean flag = false;
        int value1 = 0;
        if (itemSplit != null) {
            if (nso.GameScr.coinUpWeapons[itemSplit.upgrade] > Char.getMyChar().xu + Char.getMyChar().yen) {
                flag = true;
            }
            value1 = value * 100 / nso.GameScr.upWeapon[itemSplit.upgrade];
        }
        if (flag) {
            InfoMe.addInfo(mResources.NOT_ENOUGH_COIN_UPGRADE, 15, mFont.tahoma_7_red);
        } else if (value1 > 250) {
            GameCanvas.startYesNoDlg(mResources.PERCENT_BIG, new Command(mResources.YES, 342), new Command(mResources.NO, 1));
        } else {
            if (itemSplit != null && itemUpGrade != null && arrItemUpGrade.length > 0) {
                if (!itemUpGrade.isLock) {
                    GameCanvas.startYesNoDlg(mResources.CONFIRMUPGRADE, new Command(mResources.YES, 342), new Command(mResources.NO, 1));
                    return;
                }
                Service.gI().ngockham((byte) 0, itemUpGrade, itemSplit, arrItemUpGrade);
            }
        }
    }

    private static void actConfirmKhamNgoc() {
        GameCanvas.endDlg();
        if (itemSplit != null && itemUpGrade != null && arrItemUpGrade.length > 0) {
            Service.gI().ngockham((byte) 0, itemUpGrade, itemSplit, arrItemUpGrade);
        }
    }

    private void paintLuyenNgoc(mGraphics g) {
        block23: {
            if (nso.GameScr.isPaintLuyenNgoc) {
                if (indexMenu == 0) {
                    block24: {
                        Object argument = mResources.TITLELUYENNGOC;
                        try {
                            Object argument1;
                            int value;
                            int value2;
                            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
                            GameScr.paintTitle(g, ((String[]) argument)[indexMenu], ((String[]) argument).length > 1);
                            nso.GameScr.xstart = popupX + 3;
                            nso.GameScr.ystart = popupY + 34 + indexSize;
                            int value3 = popupX + 74;
                            int value4 = nso.GameScr.ystart - indexSize - 3;
                            rows = 4;
                            if (itemSplit != null) {
                                int value5;
                                this.paintItem(g, itemSplit, value3, value4);
                                value2 = value4 + 25;
                                value = value3 + 35;
                                argument1 = g;
                                GameScr gameScr = this;
                                int value6 = gameScr.arrNgocKhamEXP[GameScr.itemSplit.upgrade][0];
                                int value7 = 0;
                                ItemOption itemOption = null;
                                if (GameScr.itemSplit.options != null) {
                                    value5 = 0;
                                    while (value5 < GameScr.itemSplit.options.size()) {
                                        itemOption = (ItemOption) GameScr.itemSplit.options.elementAt(value5);
                                        if (itemOption.optionTemplate.id == 104) {
                                            value7 = itemOption.param;
                                        }
                                        ++value5;
                                    }
                                }
                                value5 = 0;
                                int value8 = 0;
                                while (value8 < arrItemSplit.length) {
                                    Item item = arrItemSplit[value8];
                                    if (item != null) {
                                        value5 += gameScr.arrNgocKhamEXP[item.upgrade][1];
                                    }
                                    ++value8;
                                }
                                int value9 = 0;
                                ((mGraphics) argument1).setColor(0);
                                ((mGraphics) argument1).fillRect(value, value2 - 5, 60, 5);
                                value8 = value7 * 60 / value6;
                                if (value8 <= 0) {
                                    value8 = 0;
                                } else if (value8 > 60) {
                                    value8 = 60;
                                }
                                ((mGraphics) argument1).setColor(-16711936);
                                ((mGraphics) argument1).fillRect(value, value2 - 5, value8, 5);
                                value9 = value5 * 60 / value6;
                                if (value9 >= 60 - value8) {
                                    value9 = 60 - value8;
                                }
                                ((mGraphics) argument1).setColor(-16346586);
                                ((mGraphics) argument1).fillRect(value + value8, value2 - 5, value9, 5);
                                mFont.tahoma_7_yellow.drawString((mGraphics) argument1, String.valueOf(value5 + value7) + "/" + value6, value + 30, value2 - 5 - 15, 2);
                            } else {
                                g.setColor(6425);
                                g.fillRect(value3 - 1, value4 - 1, indexSize + 3, indexSize + 3);
                                SmallImage.drawSmallImage(g, 154, value3 + indexSize / 2, value4 + indexSize / 2, 0, 3);
                            }
                            g.setColor(0xBB6611);
                            g.drawRect(value3, value4, indexSize, indexSize);
                            g.setColor(6425);
                            g.fillRect(nso.GameScr.xstart - 1, nso.GameScr.ystart - 1, indexSize * columns + 3, indexSize * rows + 3);
                            int value10 = 0;
                            while (value10 < rows) {
                                int value11 = 0;
                                while (value11 < columns) {
                                    SmallImage.drawSmallImage(g, 154, nso.GameScr.xstart + value11 * indexSize + indexSize / 2, nso.GameScr.ystart + value10 * indexSize + indexSize / 2, 0, 3);
                                    g.setColor(0xBB6611);
                                    g.drawRect(nso.GameScr.xstart + value11 * indexSize, nso.GameScr.ystart + value10 * indexSize, indexSize, indexSize);
                                    ++value11;
                                }
                                ++value10;
                            }
                            value10 = 0;
                            while (value10 < arrItemSplit.length) {
                                argument1 = arrItemSplit[value10];
                                if (argument1 != null) {
                                    value = value10 / columns;
                                    value2 = value10 - value * columns;
                                    if (!((Item) argument1).isLock) {
                                        g.setColor(12083);
                                        g.fillRect(nso.GameScr.xstart + value2 * indexSize + 1, nso.GameScr.ystart + value * indexSize + 1, indexSize - 1, indexSize - 1);
                                    }
                                    this.paintItem(g, (Item) argument1, nso.GameScr.xstart + value2 * indexSize, nso.GameScr.ystart + value * indexSize);
                                    if (((Item) argument1).quantity > 1) {
                                        mFont.number_yellow.drawString(g, String.valueOf(((Item) argument1).quantity), nso.GameScr.xstart + value2 * indexSize + indexSize, nso.GameScr.ystart + value * indexSize + indexSize - mFont.number_yellow.getHeight(), 1);
                                    }
                                }
                                ++value10;
                            }
                            if (indexTitle == 1) {
                                g.setColor(0xFFFFFF);
                                g.drawRect(value3, value4, indexSize, indexSize);
                                break block23;
                            }
                            if (indexTitle != 2)
                                break block24;
                            value10 = indexSelect / columns;
                            int value12 = indexSelect - value10 * columns;
                            g.setColor(0xFFFFFF);
                            g.drawRect(nso.GameScr.xstart + value12 * indexSize, nso.GameScr.ystart + value10 * indexSize, indexSize, indexSize);
                            break block23;
                        } catch (Exception exception) {
                            argument = exception;
                            exception.printStackTrace();
                        }
                    }
                    return;
                }
                if (indexMenu == 1) {
                    this.paintBag(g, mResources.TITLELUYENNGOC);
                }
            }
        }
    }

    private void paintCheDo(mGraphics graphics) {
        block12: {
            if (nso.GameScr.isPaintCheDo) {
                if (indexMenu == 0) {
                    block11: {
                        Object argument = mResources.TITLECHEDO;
                        try {
                            Paint.paintFrame(popupX, popupY, popupW, popupH, graphics);
                            GameScr.paintTitle(graphics, ((String[]) argument)[indexMenu], ((String[]) argument).length > 1);
                            nso.GameScr.xstart = popupX + 3;
                            nso.GameScr.ystart = popupY + 34 + indexSize;
                            int value = popupX + 74;
                            int value1 = nso.GameScr.ystart - indexSize - 3;
                            rows = 4;
                            int value2 = 0;
                            while (value2 < this.craftSlotX.length) {
                                graphics.setColor(6425);
                                graphics.fillRect(this.craftSlotX[value2] - 1, this.craftSlotY[value2] - 1, indexSize + 3, indexSize + 3);
                                graphics.setColor(0xBB6611);
                                graphics.drawRect(this.craftSlotX[value2], this.craftSlotY[value2], indexSize, indexSize);
                                SmallImage.drawSmallImage(graphics, 154, this.craftSlotX[value2] + indexSize / 2, this.craftSlotY[value2] + indexSize / 2, 0, 3);
                                ++value2;
                            }
                            value2 = 0;
                            while (value2 < arrItemSplit.length) {
                                Item item = arrItemSplit[value2];
                                if (item != null) {
                                    int value3 = value2 / columns;
                                    int value4 = value2 - value3 * columns;
                                    if (!item.isLock) {
                                        graphics.setColor(12083);
                                        graphics.fillRect(nso.GameScr.xstart + value4 * indexSize + 1, nso.GameScr.ystart + value3 * indexSize + 1, indexSize - 1, indexSize - 1);
                                    }
                                    this.paintItem(graphics, item, nso.GameScr.xstart + value4 * indexSize, nso.GameScr.ystart + value3 * indexSize);
                                    if (item.quantity > 1) {
                                        mFont.number_yellow.drawString(graphics, String.valueOf(item.quantity), nso.GameScr.xstart + value4 * indexSize + indexSize, nso.GameScr.ystart + value3 * indexSize + indexSize - mFont.number_yellow.getHeight(), 1);
                                    }
                                }
                                ++value2;
                            }
                            if (indexMenu == 0 && this.selectedCraftSlot >= 0) {
                                graphics.setColor(0xFFFFFF);
                                graphics.drawRect(this.craftSlotX[this.selectedCraftSlot], this.craftSlotY[this.selectedCraftSlot], indexSize, indexSize);
                            }
                            if (indexTitle != 1)
                                break block11;
                            graphics.setColor(0xFFFFFF);
                            graphics.drawRect(value, value1, indexSize, indexSize);
                            break block12;
                        } catch (Exception exception) {
                            argument = exception;
                            exception.printStackTrace();
                        }
                    }
                    return;
                }
                if (indexMenu == 1) {
                    this.paintBag(graphics, mResources.TITLECHEDO);
                }
            }
        }
    }

    private void paintKhamNgoc(mGraphics g) {
        block31: {
            if (nso.GameScr.isPaintKhamNgoc) {
                if (indexMenu == 0) {
                    block30: {
                        Object argument = mResources.TITLEKHAMNGOC;
                        try {
                            int value;
                            rows = 3;
                            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
                            GameScr.paintTitle(g, ((String[]) argument)[indexMenu], ((String[]) argument).length > 1);
                            nso.GameScr.xstart = popupX + 3;
                            nso.GameScr.ystart = popupY + 34 + indexSize;
                            int value1 = popupX + 45;
                            int value2 = popupX + 100;
                            int value3 = nso.GameScr.ystart - indexSize - 3;
                            if (itemSplit != null) {
                                this.paintItem(g, itemSplit, value1, value3);
                            } else {
                                g.setColor(6425);
                                g.fillRect(value1 - 1, value3 - 1, indexSize + 3, indexSize + 3);
                                SmallImage.drawSmallImage(g, 154, value1 + indexSize / 2, value3 + indexSize / 2, 0, 3);
                            }
                            g.setColor(0xBB6611);
                            g.drawRect(value1, value3, indexSize, indexSize);
                            if (itemUpGrade != null) {
                                this.paintItem(g, itemUpGrade, value2, value3);
                            } else {
                                g.setColor(6425);
                                g.fillRect(value2 - 1, value3 - 1, indexSize + 3, indexSize + 3);
                                SmallImage.drawSmallImage(g, 154, value2 + indexSize / 2, value3 + indexSize / 2, 0, 3);
                            }
                            g.setColor(0xBB6611);
                            g.drawRect(value1, value3, indexSize, indexSize);
                            g.drawRect(value2, value3, indexSize, indexSize);
                            mFont.tahoma_7b_yellow.drawString(g, "+", value1 + indexSize + 15, value3 + indexSize / 2 - 5, 2);
                            if (indexTitle == 1) {
                                if (indexSelect == 0) {
                                    g.setColor(0xFFFFFF);
                                    g.drawRect(value1, value3, indexSize, indexSize);
                                }
                                if (indexSelect == 1) {
                                    g.setColor(0xFFFFFF);
                                    g.drawRect(value2, value3, indexSize, indexSize);
                                }
                            }
                            int value4 = 0;
                            while (value4 < rows) {
                                value1 = 0;
                                while (value1 < columns) {
                                    g.setColor(6425);
                                    g.fillRect(nso.GameScr.xstart + value1 * indexSize, nso.GameScr.ystart + value4 * indexSize, indexSize + 3, indexSize + 3);
                                    SmallImage.drawSmallImage(g, 154, nso.GameScr.xstart + value1 * indexSize + indexSize / 2, nso.GameScr.ystart + value4 * indexSize + indexSize / 2, 0, 3);
                                    g.setColor(0xBB6611);
                                    g.drawRect(nso.GameScr.xstart + value1 * indexSize, nso.GameScr.ystart + value4 * indexSize, indexSize, indexSize);
                                    ++value1;
                                }
                                ++value4;
                            }
                            if (indexTitle == 2) {
                                value4 = indexSelect / columns;
                                value1 = indexSelect - value4 * columns;
                                g.setColor(0xFFFFFF);
                                g.drawRect(nso.GameScr.xstart + value1 * indexSize, nso.GameScr.ystart + value4 * indexSize, indexSize, indexSize);
                            }
                            value4 = 0;
                            while (value4 < arrItemUpGrade.length) {
                                Item item = arrItemUpGrade[value4];
                                if (item != null) {
                                    int value5 = value4 / columns;
                                    value = value4 - value5 * columns;
                                    if (!item.isLock) {
                                        g.setColor(12083);
                                        g.fillRect(nso.GameScr.xstart + value * indexSize + 1, nso.GameScr.ystart + value5 * indexSize + 1, indexSize - 1, indexSize - 1);
                                    }
                                    SmallImage.drawSmallImage(g, item.template.iconID, nso.GameScr.xstart + value * indexSize + indexSize / 2, nso.GameScr.ystart + value5 * indexSize + indexSize / 2, 0, 3);
                                }
                                ++value4;
                            }
                            if (itemUpGrade != null && itemSplit != null) {
                                value4 = 0;
                                int value6 = 0;
                                while (value6 < arrItemUpGrade.length) {
                                    if (arrItemUpGrade[value6] != null && GameScr.arrItemUpGrade[value6].template.type == 26) {
                                        value4 += crystals[GameScr.arrItemUpGrade[value6].template.id];
                                    }
                                    ++value6;
                                }
                                value6 = value4 * 100 / nso.GameScr.upWeapon[GameScr.itemSplit.upgrade];
                                if (value6 > nso.GameScr.maxPercents[GameScr.itemSplit.upgrade]) {
                                    value6 = nso.GameScr.maxPercents[GameScr.itemSplit.upgrade];
                                }
                                if (isPaintUpGradeGold) {
                                    value6 = (int) ((double) value6 * 1.5);
                                }
                                mFont font = mFont.tahoma_7_yellow;
                                value = 0;
                                ItemOption itemOption = null;
                                if (GameScr.itemSplit.options != null) {
                                    int value7 = 0;
                                    while (value7 < GameScr.itemSplit.options.size()) {
                                        itemOption = (ItemOption) GameScr.itemSplit.options.elementAt(value7);
                                        if (itemOption.optionTemplate.id == 123) {
                                            value = itemOption.param;
                                        }
                                        ++value7;
                                    }
                                } else {
                                    Service.gI().requestItemInfo(GameScr.itemSplit.typeUI, GameScr.itemSplit.indexUI);
                                }
                                if (value > Char.getMyChar().xu + Char.getMyChar().yen) {
                                    font = mFont.tahoma_7_red;
                                }
                                font.drawString(g, mResources.replace(mResources.COINLOCKNEED, NinjaUtil.numberToString(String.valueOf(value))), nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 5, 0);
                                mFont.tahoma_7_yellow.drawString(g, String.valueOf(mResources.PERCENT) + ": " + value6 + "%", nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 17, 0);
                            } else {
                                value4 = 0;
                                while (value4 < mResources.HELPKHAMNGOC.length) {
                                    mFont.tahoma_7_white.drawString(g, mResources.HELPKHAMNGOC[value4], nso.GameScr.xstart, nso.GameScr.ystart + rows * indexSize + 5 + value4 * 12, 0);
                                    ++value4;
                                }
                            }
                            if (effUpok == null)
                                break block30;
                            SmallImage.drawSmallImage(g, GameScr.effUpok.arrEfInfo[GameScr.indexEff].idImg, value2 + indexSize / 2 + GameScr.effUpok.arrEfInfo[GameScr.indexEff].dx + 1, value3 + indexSize / 2 + 9 + GameScr.effUpok.arrEfInfo[GameScr.indexEff].dy, 0, 3);
                            if (GameCanvas.gameTick % 2 != 0 || ++indexEff < GameScr.effUpok.arrEfInfo.length)
                                break block30;
                            indexEff = 0;
                            effUpok = null;
                            break block31;
                        } catch (Exception exception) {
                            argument = exception;
                            exception.printStackTrace();
                        }
                    }
                    return;
                }
                if (indexMenu == 1) {
                    this.paintBag(g, mResources.TITLEKHAMNGOC);
                }
            }
        }
    }

    private void paintGotNgoc(mGraphics g) {
        if (nso.GameScr.isPaintGotNgoc) {
            if (indexMenu == 0) {
                this.paintGotNgoc(g, mResources.TITLEGOTNGOC, (byte) 0);
                return;
            }
            if (indexMenu == 1) {
                this.paintBag(g, mResources.TITLEGOTNGOC);
            }
        }
    }

    private void paintThaoNgoc(mGraphics g) {
        if (nso.GameScr.isPaintThaoNgoc) {
            if (indexMenu == 0) {
                this.paintGotNgoc(g, mResources.TITLETHAONGOC, (byte) 1);
                return;
            }
            if (indexMenu == 1) {
                this.paintBag(g, mResources.TITLETHAONGOC);
            }
        }
    }

    private void paintGotNgoc(mGraphics g, String[] titles, byte typemoney) {
        try {
            rows = 5;
            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
            this.paintItemFrame(g, titles, false);
            g.setColor(6693376);
            g.fillRect(popupX + 3, popupY + 32, 168, 140);
            g.setColor(13408563);
            g.drawRect(popupX + 3, popupY + 32, 168, 140);
            int value = popupX + 74;
            int value1 = popupY + 40 + indexSize;
            if (itemSplit != null) {
                g.setColor(6425);
                g.fillRect(value - 1, value1 - 1, indexSize + 3, indexSize + 3);
                SmallImage.drawSmallImage(g, 154, value + indexSize / 2, value1 + indexSize / 2, 0, 3);
                this.paintItem(g, itemSplit, value, value1);
                if (itemSplit.quantity > 1) {
                    mFont.number_yellow.drawString(g, "" + itemSplit.quantity, value + indexSize, value1 + indexSize / 2 + 6, 1);
                }
                g.setColor(indexTitle == 1 ? 16777215 : 12281361);
                g.drawRect(value, value1, indexSize, indexSize);
            } else {
                g.setColor(6425);
                g.fillRect(value - 1, value1 - 1, indexSize + 3, indexSize + 3);
                SmallImage.drawSmallImage(g, 154, value + indexSize / 2, value1 + indexSize / 2, 0, 3);
                g.setColor(12281361);
                g.drawRect(value, value1, indexSize, indexSize);
            }
            if (itemSplit != null) {
                int value2 = 0;
                ItemOption itemOption = null;
                if (itemSplit.options != null) {
                    for (int index = 0; index < itemSplit.options.size(); index++) {
                        if ((itemOption = (ItemOption) itemSplit.options.elementAt(index)).optionTemplate.id == 122) {
                            value2 = itemOption.param;
                        }
                    }
                } else {
                    Service.gI().requestItemInfo(itemSplit.typeUI, itemSplit.indexUI);
                }
                String text = mResources.MONEY_SELL2;
                String text3 = value2 + mResources.YEN;
                String text4 = mResources.HELP_THAONGOC;
                if (typemoney == 0) {
                    text = mResources.MONEY_SELL;
                    text3 = coinGotngoc[itemSplit.upgrade] + mResources.XU;
                    text4 = mResources.HELP_GOTNGOC;
                }
                mFont.tahoma_7_white.drawString(g, text, value + indexSize / 2, value1 + 3 * indexSize / 2 + 2, 2);
                mFont.tahoma_7_yellow.drawString(g, text3, value + indexSize / 2, value1 + 3 * indexSize / 2 + 14, 2);
                String[] textLines = mFont.tahoma_7_white.splitFontArray(text4, 130);
                for (int index5 = 0; index5 < textLines.length; index5++) {
                    mFont.tahoma_7_white.drawString(g, textLines[index5], value + indexSize / 2, popupY + popupH - 25 + index5 * 12 - 2, 2);
                }
                return;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void actSplitItemBag_gotngoc() {
        try {
            if (nso.GameScr.isPaintGotNgoc) {
                if (Char.getMyChar().arrItemBag[indexSelect].isTypeNgocKham()) {
                    itemSplit = Char.getMyChar().arrItemBag[indexSelect];
                    Char.getMyChar().arrItemBag[indexSelect] = null;
                    return;
                }
            } else if (nso.GameScr.isPaintThaoNgoc && Char.getMyChar().arrItemBag[indexSelect].isTypeBody()) {
                itemSplit = Char.getMyChar().arrItemBag[indexSelect];
                Char.getMyChar().arrItemBag[indexSelect] = null;
                return;
            }
        } catch (Exception exception) {
            GameCanvas.msgdlg.setInfo(mResources.CAN_NOT_GOTNGOC, null, new Command(mResources.CLOSE, 2), null);
            MsgDlg msgDlg = GameCanvas.msgdlg;
            GameCanvas.currentDialog = GameCanvas.msgdlg;
        }
    }

    private void paintGiaoDo(mGraphics g) {
        block11: {
            if (nso.GameScr.isPaintGiaoDo) {
                if (indexMenu == 0) {
                    block12: {
                        Item[] values = arrItemSplit;
                        String[] textLines = mResources.TITLEGIAODO;
                        try {
                            GameScr.resetTranslate(g);
                            this.paintItemFrame(g, textLines, true);
                            if (values == null) {
                                GameCanvas.paintShukiren(popupX + 90, popupY + 75, g, false);
                                mFont.tahoma_7b_white.drawString(g, mResources.PLEASEWAIT, popupX + 90, popupY + 90, 2);
                                break block11;
                            }
                            rows = values.length <= 30 ? 5 : (values.length % columns == 0 ? values.length / columns : values.length / columns + 1);
                            scrMain.setStyle(rows, indexSize, nso.GameScr.xstart, nso.GameScr.ystart, columns * indexSize, 5 * indexSize, true, 6);
                            scrMain.setClip(g, nso.GameScr.xstart, nso.GameScr.ystart, GameScr.scrMain.width + 2, GameScr.scrMain.height + 2);
                            int value = 0;
                            while (value < rows) {
                                int value1 = 0;
                                while (value1 < columns) {
                                    SmallImage.drawSmallImage(g, 154, nso.GameScr.xstart + value1 * indexSize + indexSize / 2, nso.GameScr.ystart + value * indexSize + indexSize / 2, 0, 3);
                                    g.setColor(0xBB6611);
                                    g.drawRect(nso.GameScr.xstart + value1 * indexSize, nso.GameScr.ystart + value * indexSize, indexSize, indexSize);
                                    ++value1;
                                }
                                ++value;
                            }
                            value = 0;
                            while (value < values.length) {
                                Item item = values[value];
                                if (item != null) {
                                    int value2 = value / columns;
                                    int value3 = value - value2 * columns;
                                    if (!item.isLock) {
                                        g.setColor(12083);
                                        g.fillRect(nso.GameScr.xstart + value3 * indexSize + 1, nso.GameScr.ystart + value2 * indexSize + 1, indexSize - 1, indexSize - 1);
                                        SmallImage.drawSmallImage(g, 154, nso.GameScr.xstart + value3 * indexSize + indexSize / 2, nso.GameScr.ystart + value2 * indexSize + indexSize / 2, 0, 3);
                                    }
                                    SmallImage.drawSmallImage(g, item.template.iconID, nso.GameScr.xstart + value3 * indexSize + indexSize / 2, nso.GameScr.ystart + value2 * indexSize + indexSize / 2, 0, 3);
                                }
                                ++value;
                            }
                            if (indexTitle <= 0 || indexSelect < 0)
                                break block12;
                            value = indexSelect / columns;
                            int value4 = indexSelect - value * columns;
                            g.setColor(0xFFFFFF);
                            g.drawRect(nso.GameScr.xstart + value4 * indexSize, nso.GameScr.ystart + value * indexSize, indexSize, indexSize);
                            GameScr.paintSelectHighlight(nso.GameScr.xstart + value4 * indexSize, nso.GameScr.ystart + value * indexSize, g);
                            break block11;
                        } catch (Exception exception) {
                        }
                    }
                    return;
                }
                if (indexMenu == 1) {
                    this.paintBag(g, mResources.TITLEGIAODO);
                }
            }
        }
    }

    private void act_update_giaodo() {
        for (int index = 0; index < arrItemSplit.length; index++) {
            if (arrItemSplit[index] == null) {
                arrItemSplit[index] = Char.getMyChar().arrItemBag[indexSelect];
                Char.getMyChar().arrItemBag[indexSelect] = null;
                super.left = super.center = null;
                this.updateCommandForUI();
                return;
            }
        }
    }

    private void setCMD_act_GiaoDo() {
        MyVector entries = new MyVector();
        for (int index = 0; index < arrItemSplit.length; index++) {
            if (arrItemSplit[index] != null) {
                entries.addElement(this.cmdGiaoDoMoveOut);
                break;
            }
        }
        if (arrItemSplit.length > 0) {
            entries.addElement(new Command(mResources.TITLEGIAODO[0], 403));
        }
        GameCanvas.menu.startAt(entries);
    }

    private void actGiaoDoMoveOut() {
        Item item = getItemFocus(48);
        arrItemSplit[indexSelect] = null;
        Char.getMyChar().arrItemBag[item.indexUI] = item;
        super.left = super.center = null;
        this.updateCommandForUI();
    }

    private static void sendGiaoDo() {
        Service.gI().giaodo(arrItemSplit);
    }

    private void paintBijuu(mGraphics g) {
        if (indexMenu == 6) {
            g.translate(-g.getTranslateX(), -g.getTranslateY());
            Paint.paintFrame(popupX, popupY, popupW, popupH, g);
            g.setColor(Paint.COLORBACKGROUND);
            paintTitle(g, mResources.MENUME[indexMenu], true);
            resetTranslate(g);
            g.setColor(0);
            g.fillRect(popupX + 2, popupY + 31, 171, popupH - 34);
            g.setColor(13606712);
            g.drawRect(popupX + 3, popupY + 32, 168, popupH - 37);
            g.setColor(Paint.COLORBACKGROUND);
            g.fillRect(popupX + 4, popupY + 34, 166, popupH - 39);
            if (currentCharViewInfo.arrItemViThu[4] != null) {
                mFont.tahoma_7b_white.drawString(g, currentCharViewInfo.arrItemViThu[4].template.name, popupX + 90, nso.GameScr.ystart + 2, 2);
                int value = currentCharViewInfo.arrItemViThu[4].sys + 1;
                for (int index = 0; index < value; index++) {
                    SmallImage.drawSmallImage(g, 628, popupX + 90 + index * 12 - value * 6, nso.GameScr.ystart + 20, 0, 3);
                }
            }
            for (int index1 = 0; index1 < currentCharViewInfo.arrItemViThu.length - 1; index1++) {
                if (currentCharViewInfo.arrItemViThu[index1] != null) {
                    this.paintItem(g, currentCharViewInfo.arrItemViThu[index1], this.xMounts[index1], this.yMounts[index1]);
                } else {
                    g.setColor(6425);
                    g.fillRect(this.xMounts[index1] - 1, this.yMounts[index1] - 1, indexSize + 3, indexSize + 3);
                    mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[index1 + 24][0], this.xMounts[index1] + indexSize / 2, this.yMounts[index1] + indexSize / 2 - 10, 2);
                    mFont.tahoma_7_grey.drawString(g, mResources.ITEMNAME[index1 + 24][1], this.xMounts[index1] + indexSize / 2, this.yMounts[index1] + indexSize / 2 + 2, 2);
                }
                if (indexSelect == index1 && indexTitle == 1 && indexSelect < 4) {
                    g.setColor(16777215);
                } else {
                    g.setColor(12281361);
                }
                g.drawRect(this.xMounts[index1], this.yMounts[index1], indexSize, indexSize);
            }
            int value2 = this.xMounts[0] + indexSize + 7;
            int value3 = this.yMounts[0] - 5;
            g.setColor(6425);
            g.fillRect(value2, value3, 84, 75);
            if (indexSelect == 4) {
                g.setColor(16777215);
            } else {
                g.setColor(12281361);
            }
            g.drawRect(value2, value3, 84, 75);
            if (currentCharViewInfo.mobVithu != null) {
                currentCharViewInfo.mobVithu.paintTopMobNew(g, value2 + 35, value3 + 55);
                currentCharViewInfo.mobVithu.paintBoTomMobNew(g, value2 + 35, value3 + 55);
            }
            int value4 = 0;
            value2 = 0;
            value3 = 0;
            if (currentCharViewInfo.arrItemViThu[4] != null) {
                if (currentCharViewInfo.arrItemViThu[4].options != null) {
                    for (int index5 = 0; index5 < currentCharViewInfo.arrItemViThu[4].options.size(); index5++) {
                        ItemOption itemOption;
                        if ((itemOption = (ItemOption) currentCharViewInfo.arrItemViThu[4].options.elementAt(index5)).optionTemplate.id == 151) {
                            value4 = itemOption.param;
                        } else if (itemOption.optionTemplate.id == 150) {
                            value2 = itemOption.param;
                        }
                    }
                }
                value3 = currentCharViewInfo.arrItemViThu[4].upgrade;
            }
            int value6 = nso.GameScr.xstart + 5;
            int value7 = nso.GameScr.ystart + 112;
            mFont.tahoma_7b_white.drawString(g, mResources.Level + ": ", value6, value7, 0);
            mFont.tahoma_7b_white.drawString(g, String.valueOf(value3), value6 + 70, value7, 0);
            String text = mResources.NAMEPOTENTIAL[2] + ": ";
            value7 += 15;
            mFont.tahoma_7b_white.drawString(g, text, value6, value7, 0);
            mFont.tahoma_7b_white.drawString(g, String.valueOf(value2), value6 + 70, value7, 0);
            text = mResources.EXP + ": ";
            value7 += 17;
            mFont.tahoma_7b_white.drawString(g, text, value6, value7, 0);
            mFont.tahoma_7b_white.drawString(g, String.valueOf(value4), value6 + 70, value7, 0);
        }
    }

    private void actBijuuSelect() {
        MyVector entries = new MyVector();
        if (indexBijuuMenu == 0) {
            entries.addElement(new Command(mResources.POTENTIAL_POINT, 5021));
            entries.addElement(new Command(mResources.MENUME[1], 5022));
            entries.addElement(this.cmdCloseAll);
        } else if (indexBijuuMenu == 1) {
            entries.addElement(new Command(mResources.MENUME[indexMenu], 502));
            entries.addElement(new Command(mResources.MENUME[1], 5022));
            entries.addElement(this.cmdCloseAll);
        } else if (indexBijuuMenu == 2) {
            entries.addElement(new Command(mResources.MENUME[indexMenu], 502));
            entries.addElement(new Command(mResources.POTENTIAL_POINT, 5021));
            entries.addElement(this.cmdCloseAll);
        }
        GameCanvas.menu.startAt(entries);
    }

    private static void actBijuuMenuPoint() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.UPPOINT, 5041));
        entries.addElement(new Command(mResources.UPPOINTS, 5042));
        GameCanvas.menu.startAt(entries);
    }

    private void doBijuuUpPoint() {
        if (indexTitle > 0 && indexTitle <= 4 || GameCanvas.isTouch) {
            GameCanvas.inputDlg.show(mResources.INPUT_POINT, this.cmdBijuuAddPoint, 1);
        }
    }

    private static void actBijuuUpPoint() {
        String text;
        if ((text = GameCanvas.inputDlg.tfInput.getText()).trim().equals("")) {
            GameCanvas.startOKDlg(mResources.NOT_INPUT_POINT);
        } else {
            int value = 0;
            try {
                value = Integer.parseInt(text);
            } catch (Exception exception) {
                GameCanvas.endDlg();
                return;
            }
            if (value <= 0) {
                GameCanvas.endDlg();
            } else if (Char.getMyChar().pPoint != 0 && value <= Char.getMyChar().pPoint) {
                Service.gI().upPotential(indexTitle - 1, value);
                GameCanvas.endDlg();
            } else {
                GameCanvas.startOKDlg(mResources.NOT_ENOUGH_POINT);
            }
        }
    }

    private static void actBijuuKyNang() {
        MyVector entries;
        (entries = new MyVector()).addElement(new Command(mResources.UPPOINT, 5051));
        entries.addElement(new Command(mResources.UPPOINTS, 5052));
        GameCanvas.menu.startAt(entries);
    }

    private void doBijuuUpSkill() {
        if (indexTitle > 0 && indexTitle <= 4) {
            GameCanvas.inputDlg.show(mResources.INPUT_POINT, this.cmdBijuuSkillUp, 1);
        }
    }

    private static void actBijSkillUpPoint() {
        String text;
        if ((text = GameCanvas.inputDlg.tfInput.getText()).trim().equals("")) {
            GameCanvas.startOKDlg(mResources.NOT_INPUT_POINT);
        } else {
            int value = 0;
            try {
                value = Integer.parseInt(text);
            } catch (Exception exception) {
                GameCanvas.endDlg();
                return;
            }
            if (Char.getMyChar().sPoint != 0 && value <= Char.getMyChar().sPoint) {
                Service.gI().upSkill(Char.getMyChar().nClass.skillTemplates[indexSelect].id, value);
                GameCanvas.endDlg();
            } else {
                GameCanvas.startOKDlg(mResources.NOT_INPUT_POINT);
                MsgDlg msgDlg = GameCanvas.msgdlg;
                GameCanvas.currentDialog = GameCanvas.msgdlg;
            }
        }
    }
}
