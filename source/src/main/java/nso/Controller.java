package nso;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import javax.microedition.lcdui.Image;
import main.GameCanvas;
import main.GameMidlet;
import java.io.IOException;

public final class Controller {

    private static Controller me;

    private Message messWait;

    public Controller() {
    }

    public static Controller gI() {
        if (me == null) {
            me = new Controller();
        }
        return me;
    }

    public final void onConnectionError() {
        GameCanvas.startOK(mResources.SERVER_MAINTENANCE, 8884, null);
    }

    private static void requestItemPlayer(Message msg) {
        try {
            int unsignedByte = msg.reader().readUnsignedByte();
            Item item;
            (item = GameScr.currentCharViewInfo.arrItemBody[unsignedByte]).expires = msg.reader().readLong();
            item.saleCoinLock = msg.reader().readInt();
            item.sys = msg.reader().readByte();
            item.options = new MyVector();
            try {
                while (true) {
                    item.options.addElement(new ItemOption(msg.reader().readUnsignedByte(), msg.reader().readInt()));
                }
            } catch (Exception exception) {
            }
        } catch (Exception exception1) {
            exception1.printStackTrace();
        }
    }

    private static void viewItemAuction(Message msg) {
        try {
            Item item = null;
            int value = msg.reader().readInt();
            for (int index = 0; index < GameScr.arrItemStands.length; index++) {
                if (GameScr.arrItemStands[index].item.itemId == value) {
                    item = GameScr.arrItemStands[index].item;
                    break;
                }
            }
            item.typeUI = 37;
            item.expires = -1L;
            item.saleCoinLock = msg.reader().readInt();
            if (item.isTypeBody() || item.isTypeNgocKham()) {
                item.options = new MyVector();
                try {
                    item.upgrade = msg.reader().readByte();
                    item.sys = msg.reader().readByte();
                    while (true) {
                        item.options.addElement(new ItemOption(msg.reader().readUnsignedByte(), msg.reader().readInt()));
                    }
                } catch (Exception exception) {
                    return;
                }
            }
        } catch (Exception exception1) {
            exception1.printStackTrace();
        }
    }

    public final void onMessage(Message msg) {
        short shortValue;
        short shortValue1;
        try {
            try {
                switch(msg.command) {
                    case -30:
                        this.messageSubCommand(msg);
                        return;
                    case -29:
                        messageNotLogin(msg);
                        return;
                    case -28:
                        this.messageNotMap(msg);
                        break;
                    case -27:
                    case -17:
                    case -9:
                    case 12:
                    case 24:
                    case 28:
                    case 29:
                    case 32:
                    case 35:
                    case 41:
                    case 44:
                    case 56:
                    case 73:
                    case 74:
                    case 80:
                    case 81:
                    case 105:
                    case 110:
                    case 111:
                    case 113:
                    case 115:
                    case 120:
                    default:
                        return;
                    case -26:
                        GameCanvas.startOKDlg(msg.reader().readUTF());
                        return;
                    case -25:
                        String text;
                        Info.addInfo(text = msg.reader().readUTF(), 150, mFont.tahoma_7b_yellow);
                        ChatManager.gI().addChat(mResources.GLOBALCHAT[0], mResources.SERVER_ALERT, text);
                        return;
                    case -24:
                        InfoMe.addInfo(msg.reader().readUTF(), 50, mFont.tahoma_7_yellow);
                        return;
                    case -23:
                        int value = msg.reader().readInt();
                        String text2 = msg.reader().readUTF();
                        Char character;
                        if (Char.getMyChar().charID == value) {
                            character = Char.getMyChar();
                        } else {
                            character = GameScr.findCharInMap(value);
                        }
                        if (character != null) {
                            ChatPopup.addChatPopup(text2, 100, character);
                            ChatManager.gI().addChat(mResources.PUBLICCHAT[0], character.cName, text2);
                            return;
                        }
                        return;
                    case -22:
                        String text3 = msg.reader().readUTF();
                        String text4 = msg.reader().readUTF();
                        ChatManager.gI().addChat(text3, text3, text4);
                        if ((!GameScr.isPaintMessage || !ChatManager.gI().getCurrentChatTab().ownerName.equals(text3)) && !ChatManager.blockPrivateChat) {
                            ChatManager.gI().addWaitList(text3);
                        }
                        return;
                    case -21:
                        String text5 = msg.reader().readUTF();
                        String text6 = msg.reader().readUTF();
                        ChatManager.gI().addChat(mResources.GLOBALCHAT[0], text5, text6);
                        if (!ChatManager.blockGlobalChat) {
                            Info.addInfo(text5 + ": " + text6, 80, mFont.tahoma_7b_yellow);
                        }
                        return;
                    case -20:
                        String text7 = msg.reader().readUTF();
                        String text8 = msg.reader().readUTF();
                        ChatManager.gI().addChat(mResources.PARTYCHAT[0], text7, text8);
                        if (!GameScr.isPaintMessage || ChatManager.gI().getCurrentChatTab().type != 1) {
                            ChatManager.gI();
                            ChatManager.isMessagePt = true;
                        }
                        return;
                    case -19:
                        String text9 = msg.reader().readUTF();
                        String text10 = msg.reader().readUTF();
                        ChatManager.gI().addChat(mResources.CLANCHAT[0], text9, text10);
                        if (!GameScr.isPaintMessage || ChatManager.gI().getCurrentChatTab().type != 4) {
                            ChatManager.isMessageClan = true;
                        }
                        return;
                    case -18:
                        GameCanvas.isLoading = true;
                        GameScr.resetAllvector();
                        TileMap.vGo.removeAllElements();
                        System.gc();
                        TileMap.mapID = (short) msg.reader().readUnsignedByte();
                        TileMap.tileID = msg.reader().readByte();
                        TileMap.bgID = msg.reader().readByte();
                        TileMap.typeMap = msg.reader().readByte();
                        TileMap.mapName = msg.reader().readUTF();
                        TileMap.zoneID = msg.reader().readByte();
                        TileMap.reloadTileSheets();
                        try {
                            TileMap.loadMapFromResource();
                        } catch (Exception exception) {
                            Service.gI().requestMaptemplate(TileMap.mapID);
                            this.messWait = msg;
                            return;
                        }
                        this.loadInfoMap(msg);
                        if (Char.getMyChar().mobMe != null) {
                            Char.getMyChar().mobMe.x = Char.getMyChar().cx;
                            Char.getMyChar().mobMe.y = Char.getMyChar().cy - 40;
                        }
                        return;
                    case -16:
                        Char.isLockKey = true;
                        Char.ischangingMap = true;
                        Mob.vEggMonter.removeAllElements();
                        GameScr.gI().timeStartMap = 0;
                        GameScr.gI().timeLengthMap = 0;
                        Char.getMyChar().mobFocus = null;
                        Char.getMyChar().npcFocus = null;
                        Char.getMyChar().charFocus = null;
                        Char.getMyChar().itemFocus = null;
                        Char.getMyChar().focus.removeAllElements();
                        Char.getMyChar().testCharId = -9999;
                        Char.getMyChar().killCharId = -9999;
                        GameScr.resetAllvector();
                        GameCanvas.freeBackgroundImages();
                        if (GameScr.vParty.size() <= 1) {
                            GameScr.vParty.removeAllElements();
                        }
                        GameScr.gI().resetButton();
                        GameScr.gI().center = null;
                        return;
                    case -15:
                        short shortValue11 = msg.reader().readShort();
                        for (int index = 0; index < GameScr.vItemMap.size(); index++) {
                            if (((ItemMap) GameScr.vItemMap.elementAt(index)).itemMapID == shortValue11) {
                                GameScr.vItemMap.removeElementAt(index);
                                return;
                            }
                        }
                        return;
                    case -14:
                        Char.getMyChar().itemFocus = null;
                        short shortValue12 = msg.reader().readShort();
                        for (int index13 = 0; index13 < GameScr.vItemMap.size(); index13++) {
                            ItemMap itemMap;
                            if ((itemMap = (ItemMap) GameScr.vItemMap.elementAt(index13)).itemMapID == shortValue12) {
                                itemMap.setPoint(Char.getMyChar().cx, Char.getMyChar().cy - 10);
                                if (itemMap.template.type == 19) {
                                    int unsignedShort = msg.reader().readUnsignedShort();
                                    Char.getMyChar().yen += unsignedShort;
                                    if (itemMap.template.id != 238) {
                                        InfoMe.addInfo(mResources.RECEIVE + " " + unsignedShort + " " + mResources.YEN);
                                        return;
                                    }
                                } else if (itemMap.template.type == 25 && itemMap.template.id != 238) {
                                    InfoMe.addInfo(mResources.RECEIVE + " " + itemMap.template.name, 15, mFont.tahoma_7_yellow);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    case -13:
                        short shortValue14 = msg.reader().readShort();
                        for (int index15 = 0; index15 < GameScr.vItemMap.size(); index15++) {
                            ItemMap itemMap16;
                            if ((itemMap16 = (ItemMap) GameScr.vItemMap.elementAt(index15)).itemMapID == shortValue14) {
                                Char character17;
                                if ((character17 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                                    itemMap16.setPoint(character17.cx, character17.cy - 10);
                                    if (itemMap16.x < character17.cx) {
                                        character17.cdir = -1;
                                    } else if (itemMap16.x > character17.cx) {
                                        character17.cdir = 1;
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    case -12:
                        byte byteValue = msg.reader().readByte();
                        GameScr.vItemMap.addElement(new ItemMap(msg.reader().readShort(), Char.getMyChar().arrItemBag[byteValue].template.id, Char.getMyChar().cx, Char.getMyChar().cy, msg.reader().readShort(), msg.reader().readShort()));
                        Char.getMyChar().arrItemBag[byteValue] = null;
                        return;
                    case -11:
                        Char.getMyChar().cPk = msg.reader().readByte();
                        Char.getMyChar().waitToDie(msg.reader().readShort(), msg.reader().readShort());
                        try {
                            Char.getMyChar().cEXP = msg.reader().readLong();
                            GameScr.setLevel_Exp(Char.getMyChar().cEXP, true);
                        } catch (Exception exception292) {
                        }
                        Char.getMyChar().countKill = 0;
                        return;
                    case -10:
                        if (Char.getMyChar().wdx != 0 || Char.getMyChar().wdy != 0) {
                            Char.getMyChar().cx = Char.getMyChar().wdx;
                            Char.getMyChar().cy = Char.getMyChar().wdy;
                            Char.getMyChar().wdx = Char.getMyChar().wdy = 0;
                        }
                        Char.getMyChar().liveFromDead();
                        Char.isLockKey = false;
                        return;
                    case -8:
                        int value18 = msg.reader().readInt();
                        Char.getMyChar().yen += value18;
                        GameScr.gI().yenTemp = value18;
                        GameScr.startFlyText(value18 > 0 ? "+" + value18 : "" + value18, Char.getMyChar().cx, Char.getMyChar().cy - Char.getMyChar().ch - 10, 0, -2, 1);
                        return;
                    case -7:
                        int value19 = msg.reader().readInt();
                        Char.getMyChar().xu += value19;
                        Char.getMyChar().yen -= value19;
                        GameScr.startFlyText("+" + value19, Char.getMyChar().cx, Char.getMyChar().cy - Char.getMyChar().ch - 10, 0, -2, 1);
                        return;
                    case -6:
                        Char character20;
                        if ((character20 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            GameScr.vItemMap.addElement(new ItemMap(msg.reader().readShort(), msg.reader().readShort(), character20.cx, character20.cy, msg.reader().readShort(), msg.reader().readShort()));
                            return;
                        }
                        return;
                    case -5:
                        try {
                            Mob mob;
                            (mob = Mob.get_Mob(msg.reader().readUnsignedByte())).sys = msg.reader().readByte();
                            mob.levelBoss = msg.reader().readByte();
                            mob.x = mob.xFirst;
                            mob.y = mob.yFirst;
                            mob.status = 5;
                            mob.injureThenDie = false;
                            mob.hp = msg.reader().readInt();
                            mob.maxHp = mob.hp;
                            if (mob.getTemplate().mobTemplateId == 202) {
                                ServerEffect.addServerEffect(148, mob.x, mob.y, 0);
                            } else {
                                ServerEffect.addServerEffect(60, mob.x, mob.y, 1);
                            }
                            return;
                        } catch (Exception exception293) {
                            exception293.printStackTrace();
                            return;
                        }
                    case -4:
                        Mob mob21 = null;
                        try {
                            mob21 = Mob.get_Mob(msg.reader().readUnsignedByte());
                        } catch (Exception exception294) {
                        }
                        if (mob21 != null && mob21.status != 0 && mob21.status != 0) {
                            mob21.startDie();
                            try {
                                int value22;
                                if ((value22 = msg.reader().readInt()) < 0) {
                                    value22 = Res.abs(value22) + 32767;
                                }
                                if (msg.reader().readBoolean()) {
                                    GameScr.startFlyText("-" + value22, mob21.x, mob21.y - mob21.h, 0, -2, 3);
                                } else {
                                    GameScr.startFlyText("-" + value22, mob21.x, mob21.y - mob21.h, 0, -2, 5);
                                }
                                ItemMap itemMap23 = new ItemMap(msg.reader().readShort(), msg.reader().readShort(), mob21.x, mob21.y, msg.reader().readShort(), msg.reader().readShort());
                                GameScr.vItemMap.addElement(itemMap23);
                                if (Res.abs(itemMap23.y - Char.getMyChar().cy) < 24 && Res.abs(itemMap23.x - Char.getMyChar().cx) < 24) {
                                    Char.getMyChar().charFocus = null;
                                    return;
                                }
                            } catch (Exception exception295) {
                            }
                            return;
                        }
                        return;
                    case -3:
                        Mob mob24 = null;
                        try {
                            mob24 = Mob.get_Mob(msg.reader().readUnsignedByte());
                        } catch (Exception exception296) {
                        }
                        if (mob24 != null) {
                            int value25 = msg.reader().readInt();
                            int value26;
                            try {
                                value26 = msg.reader().readInt();
                            } catch (Exception exception297) {
                                value26 = 0;
                            }
                            if (mob24.isBusyAttackSomeOne) {
                                Char.getMyChar().doInjure(value25, value26, false, -1);
                                mob24.attackOtherInRange();
                            } else {
                                mob24.dame = value25;
                                mob24.dameMp = value26;
                                mob24.setAttack(Char.getMyChar());
                            }
                            short shortValue27 = msg.reader().readShort();
                            byte byteValue28 = msg.reader().readByte();
                            byte byteValue29 = msg.reader().readByte();
                            mob24.setTypeAtk(shortValue27, byteValue28, byteValue29);
                        }
                        return;
                    case -2:
                        Mob mob30 = null;
                        try {
                            mob30 = Mob.get_Mob(msg.reader().readUnsignedByte());
                        } catch (Exception exception298) {
                        }
                        if (mob30 == null) {
                            return;
                        }
                        Char character31;
                        if ((character31 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            int value32 = msg.reader().readInt();
                            mob30.dame = character31.cHP - value32;
                            character31.cHpNew = value32;
                            try {
                                character31.cMP = msg.reader().readInt();
                            } catch (Exception exception299) {
                            }
                            if (mob30.isBusyAttackSomeOne) {
                                character31.doInjure(mob30.dame, 0, false, -1);
                                mob30.attackOtherInRange();
                            } else {
                                mob30.setAttack(character31);
                            }
                            short shortValue33 = msg.reader().readShort();
                            byte byteValue34 = msg.reader().readByte();
                            byte byteValue35 = msg.reader().readByte();
                            mob30.setTypeAtk(shortValue33, byteValue34, byteValue35);
                            return;
                        }
                        return;
                    case -1:
                        Mob mob36 = null;
                        try {
                            mob36 = Mob.get_Mob(msg.reader().readUnsignedByte());
                        } catch (Exception exception300) {
                        }
                        if (mob36 != null) {
                            mob36.hp = msg.reader().readInt();
                            int value37;
                            if ((value37 = msg.reader().readInt()) < 0) {
                                value37 = Res.abs(value37) + 32767;
                            }
                            boolean flag = msg.reader().readBoolean();
                            try {
                                mob36.levelBoss = msg.reader().readByte();
                                mob36.maxHp = msg.reader().readInt();
                            } catch (Exception exception301) {
                            }
                            if (flag) {
                                GameScr.startFlyText("-" + value37, mob36.x, mob36.y - mob36.h, 0, -2, 3);
                            } else {
                                GameScr.startFlyText("-" + value37, mob36.x, mob36.y - mob36.h, 0, -2, 5);
                            }
                            return;
                        }
                        return;
                    case 0:
                        Char character38;
                        if ((character38 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            character38.cPk = msg.reader().readByte();
                            if (character38.charID == Char.aCID) {
                                Char.isAFocusDie = true;
                            }
                            character38.waitToDie(msg.reader().readShort(), msg.reader().readShort());
                            if (Char.getMyChar().charFocus == character38) {
                                Char.getMyChar().charFocus = null;
                            }
                            return;
                        }
                        return;
                    case 1:
                        int value39 = msg.reader().readInt();
                        for (int index40 = 0; index40 < GameScr.vCharInMap.size(); index40++) {
                            Char character41 = null;
                            try {
                                character41 = (Char) GameScr.vCharInMap.elementAt(index40);
                            } catch (Exception exception302) {
                            }
                            if (character41 == null) {
                                return;
                            }
                            if (character41.charID == value39) {
                                character41.cxMoveLast = msg.reader().readShort();
                                character41.cyMoveLast = msg.reader().readShort();
                                character41.moveTo(character41.cxMoveLast, character41.cyMoveLast);
                                character41.lastUpdateTime = System.currentTimeMillis();
                                return;
                            }
                        }
                        return;
                    case 2:
                        int value42 = msg.reader().readInt();
                        for (int index43 = 0; index43 < GameScr.vCharInMap.size(); index43++) {
                            Char character44;
                            if ((character44 = (Char) GameScr.vCharInMap.elementAt(index43)) != null && character44.charID == value42) {
                                if (!character44.isInvisible && character44.isHuman && !character44.isNhanban) {
                                    ServerEffect.addServerEffect(60, character44.cx, character44.cy, 1);
                                } else if (!character44.isInvisible && character44.isNhanbanz() && !character44.isHuman) {
                                    ServerEffect.addServerEffect(141, character44.cx, character44.cy, 0);
                                }
                                GameScr.vCharInMap.removeElementAt(index43);
                                Party.clear(value42);
                                return;
                            }
                        }
                        return;
                    case 3:
                        Char character45;
                        (character45 = new Char()).charID = msg.reader().readInt();
                        if (readCharInfo(character45, msg)) {
                            GameScr.vCharInMap.addElement(character45);
                        }
                        return;
                    case 4:
                        Char character46;
                        if ((character46 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            if ((TileMap.tileTypeAtPixel(character46.cx, character46.cy) & 2) == 2) {
                                character46.setSkillPaint(GameScr.sks[msg.reader().readByte()], 0);
                            } else {
                                character46.setSkillPaint(GameScr.sks[msg.reader().readByte()], 1);
                            }
                            if (character46.isWolf) {
                                character46.isWolf = false;
                                character46.timeSummon = System.currentTimeMillis();
                                ServerEffect.addServerEffect(60, character46, 1);
                            }
                            if (character46.isMoto) {
                                character46.isMoto = false;
                                character46.isMotoBehind = true;
                            }
                            byte byteValue47 = msg.reader().readByte();
                            character46.attMobs = new Mob[byteValue47];
                            for (int index48 = 0; index48 < character46.attMobs.length; index48++) {
                                Mob mob49 = Mob.get_Mob(msg.reader().readUnsignedByte());
                                character46.attMobs[index48] = mob49;
                                if (index48 == 0) {
                                    if (character46.cx <= mob49.x) {
                                        character46.cdir = 1;
                                    } else {
                                        character46.cdir = -1;
                                    }
                                }
                            }
                            character46.mobFocus = character46.attMobs[0];
                            Char[] values = new Char[10];
                            int value50 = 0;
                            try {
                                for (value50 = 0; value50 < values.length; value50++) {
                                    int value51;
                                    Char character52;
                                    if ((value51 = msg.reader().readInt()) == Char.getMyChar().charID) {
                                        character52 = Char.getMyChar();
                                    } else {
                                        character52 = GameScr.findCharInMap(value51);
                                    }
                                    values[value50] = character52;
                                    if (value50 == 0) {
                                        if (character46.cx <= character52.cx) {
                                            character46.cdir = 1;
                                        } else {
                                            character46.cdir = -1;
                                        }
                                    }
                                }
                            } catch (Exception exception303) {
                            }
                            if (value50 > 0) {
                                character46.attChars = new Char[value50];
                                for (int index53 = 0; index53 < character46.attChars.length; index53++) {
                                    character46.attChars[index53] = values[index53];
                                }
                                character46.charFocus = character46.attChars[0];
                            }
                            return;
                        }
                        return;
                    case 5:
                        long longValue = msg.reader().readLong();
                        Char.getMyChar().cExpDown = 0L;
                        Char.getMyChar().cEXP += longValue;
                        int value54 = Char.getMyChar().clevel;
                        GameScr.setLevel_Exp(Char.getMyChar().cEXP, true);
                        if (value54 != Char.getMyChar().clevel) {
                            ServerEffect.addServerEffect(58, Char.getMyChar(), 1);
                        }
                        GameScr.startFlyText("+" + longValue, Char.getMyChar().cx, Char.getMyChar().cy - Char.getMyChar().ch, 0, -2, 2);
                        if (longValue >= 1000000L) {
                            InfoMe.addInfo(mResources.RECEIVE + " " + longValue + " " + mResources.EXP, 20, mFont.tahoma_7_yellow);
                        }
                        return;
                    case 6:
                        ItemMap itemMap55 = new ItemMap(msg.reader().readShort(), msg.reader().readShort(), msg.reader().readShort(), msg.reader().readShort());
                        byte[] data;
                        if ((data = NinjaUtil.readByteArray_Int(msg)) != null && data.length > 0) {
                            itemMap55.imgCaptcha = new MyImage();
                            itemMap55.imgCaptcha.img = createImage(data);
                        }
                        GameScr.vItemMap.addElement(itemMap55);
                        return;
                    case 7:
                        Char.getMyChar().arrItemBag[msg.reader().readByte()].quantity = msg.reader().readShort();
                        return;
                    case 8:
                        byte byteValue56 = msg.reader().readByte();
                        Char.getMyChar().arrItemBag[byteValue56] = new Item();
                        Char.getMyChar().arrItemBag[byteValue56].typeUI = 3;
                        Char.getMyChar().arrItemBag[byteValue56].indexUI = byteValue56;
                        Char.getMyChar().arrItemBag[byteValue56].template = ItemTemplates.get(msg.reader().readShort());
                        Char.getMyChar().arrItemBag[byteValue56].isLock = msg.reader().readBoolean();
                        if (Char.getMyChar().arrItemBag[byteValue56].isTypeBody() || Char.getMyChar().arrItemBag[byteValue56].isTypeNgocKham()) {
                            Char.getMyChar().arrItemBag[byteValue56].upgrade = msg.reader().readByte();
                        }
                        Char.getMyChar().arrItemBag[byteValue56].isExpires = msg.reader().readBoolean();
                        try {
                            Char.getMyChar().arrItemBag[byteValue56].quantity = msg.reader().readUnsignedShort();
                        } catch (Exception exception304) {
                            Char.getMyChar().arrItemBag[byteValue56].quantity = 1;
                        }
                        if (Char.getMyChar().arrItemBag[byteValue56].template.type == 16) {
                            GameScr.hpPotion = GameScr.hpPotion + Char.getMyChar().arrItemBag[byteValue56].quantity;
                        }
                        if (Char.getMyChar().arrItemBag[byteValue56].template.type == 17) {
                            GameScr.mpPotion = GameScr.mpPotion + Char.getMyChar().arrItemBag[byteValue56].quantity;
                        }
                        if (Char.getMyChar().arrItemBag[byteValue56].template.id == 340) {
                            GameScr gameScr = GameScr.gI();
                            gameScr.numSprinLeft = gameScr.numSprinLeft + Char.getMyChar().arrItemBag[byteValue56].quantity;
                        }
                        if (GameScr.isPaintTrade) {
                            if (GameScr.gI().tradeItemName.equals("")) {
                                GameScr gameScr57 = GameScr.gI();
                                gameScr57.tradeItemName = gameScr57.tradeItemName + Char.getMyChar().arrItemBag[byteValue56].template.name;
                            } else {
                                GameScr gameScr58 = GameScr.gI();
                                gameScr58.tradeItemName = gameScr58.tradeItemName + ", " + Char.getMyChar().arrItemBag[byteValue56].template.name;
                            }
                            return;
                        } else {
                            if (Char.getMyChar().arrItemBag[byteValue56].template.type != 20) {
                                InfoMe.addInfo(mResources.RECEIVE + " " + Char.getMyChar().arrItemBag[byteValue56].template.name);
                                return;
                            }
                            return;
                        }
                    case 9:
                        Item item = Char.getMyChar().arrItemBag[msg.reader().readUnsignedByte()];
                        boolean flag59 = false;
                        try {
                            shortValue1 = msg.reader().readShort();
                        } catch (Exception exception305) {
                            shortValue1 = 1;
                        }
                        item.quantity += shortValue1;
                        if (item.template.type == 16) {
                            GameScr.hpPotion += shortValue1;
                        }
                        if (item.template.type == 17) {
                            GameScr.mpPotion += shortValue1;
                        }
                        if (item.template.id == 340) {
                            GameScr.gI().numSprinLeft += shortValue1;
                        }
                        GameCanvas.endDlg();
                        if (GameScr.isPaintTrade) {
                            if (GameScr.gI().tradeItemName.equals("")) {
                                GameScr gameScr60 = GameScr.gI();
                                gameScr60.tradeItemName = gameScr60.tradeItemName + item.template.name;
                            } else {
                                GameScr gameScr61 = GameScr.gI();
                                gameScr61.tradeItemName = gameScr61.tradeItemName + ", " + item.template.name;
                            }
                            return;
                        } else {
                            if (item.template.type != 20) {
                                InfoMe.addInfo(mResources.RECEIVE + " " + item.template.name);
                                return;
                            }
                            return;
                        }
                    case 10:
                        byte byteValue62 = msg.reader().readByte();
                        if (Char.getMyChar().arrItemBag[byteValue62].template.type == 16) {
                            GameScr.hpPotion = GameScr.hpPotion - Char.getMyChar().arrItemBag[byteValue62].quantity;
                        }
                        if (Char.getMyChar().arrItemBag[byteValue62].template.type == 17) {
                            GameScr.mpPotion = GameScr.mpPotion - Char.getMyChar().arrItemBag[byteValue62].quantity;
                        }
                        Char.getMyChar().arrItemBag[byteValue62] = null;
                        GameScr.gI();
                        if (GameScr.isPaintUI()) {
                            GameScr.gI().left = GameScr.gI().center = null;
                        } else {
                            GameScr.gI().resetButton();
                        }
                        return;
                    case 11:
                        byte byteValue63 = msg.reader().readByte();
                        if (Char.getMyChar().arrItemBag[byteValue63].template.type == 24) {
                            InfoDlg.hide();
                        }
                        Char.getMyChar().useItem(byteValue63);
                        Char.getMyChar().readParam(msg);
                        Char.getMyChar().eff5BuffHp = msg.reader().readShort();
                        Char.getMyChar().eff5BuffMp = msg.reader().readShort();
                        GameScr.gI().setLCR();
                        return;
                    case 13:
                        Char.getMyChar().xu = msg.reader().readInt();
                        Char.getMyChar().yen = msg.reader().readInt();
                        Char.getMyChar().luong = msg.reader().readInt();
                        GameCanvas.endDlg();
                        return;
                    case 14:
                        Item item64 = Char.getMyChar().arrItemBag[msg.reader().readByte()];
                        Char.getMyChar().yen = msg.reader().readInt();
                        boolean flag65 = false;
                        try {
                            shortValue = msg.reader().readShort();
                        } catch (Exception exception306) {
                            shortValue = 1;
                        }
                        item64.quantity -= shortValue;
                        if (item64.template.type == 16) {
                            GameScr.hpPotion -= shortValue;
                        }
                        if (item64.template.type == 17) {
                            GameScr.mpPotion -= shortValue;
                        }
                        if (item64.quantity <= 0) {
                            Char.getMyChar().arrItemBag[item64.indexUI] = null;
                        }
                        GameScr.gI().left = GameScr.gI().center = null;
                        GameScr.gI().updateCommandForUI();
                        GameCanvas.endDlg();
                        return;
                    case 15:
                        Char.getMyChar().itemBodyToBag(msg);
                        return;
                    case 16:
                        Char.getMyChar().itemBoxToBag(msg);
                        return;
                    case 17:
                        Char.getMyChar().itemBagToBox(msg);
                        return;
                    case 18:
                        byte byteValue66 = msg.reader().readByte();
                        short shortValue67 = 1;
                        try {
                            shortValue67 = msg.reader().readShort();
                        } catch (Exception exception307) {
                        }
                        if (Char.getMyChar().arrItemBag[byteValue66].template.type == 24) {
                            InfoDlg.hide();
                        }
                        if (Char.getMyChar().arrItemBag[byteValue66].template.type == 16) {
                            GameScr.hpPotion--;
                        }
                        if (Char.getMyChar().arrItemBag[byteValue66].template.type == 17) {
                            GameScr.mpPotion--;
                        }
                        if (Char.getMyChar().arrItemBag[byteValue66].quantity > shortValue67) {
                            Char.getMyChar().arrItemBag[byteValue66].quantity -= shortValue67;
                        } else {
                            Char.getMyChar().arrItemBag[byteValue66] = null;
                        }
                        if (GameScr.isPaintInfoMe) {
                            GameScr.gI().setLCR();
                        }
                        return;
                    case 19:
                        Char.getMyChar();
                        Char.crystalCollect(msg, true);
                        return;
                    case 20:
                        Char.getMyChar();
                        Char.crystalCollect(msg, false);
                        return;
                    case 21:
                        byte byteValue68 = msg.reader().readByte();
                        Char.getMyChar().luong = msg.reader().readInt();
                        Char.getMyChar().xu = msg.reader().readInt();
                        Char.getMyChar().yen = msg.reader().readInt();
                        if (GameScr.itemUpGrade != null) {
                            GameScr.itemUpGrade.upgrade = msg.reader().readByte();
                            GameScr.itemUpGrade.isLock = true;
                            GameScr.itemUpGrade.clearExpire();
                            if (byteValue68 == 1) {
                                GameScr.effUpok = GameScr.efs[53];
                                GameScr.indexEff = 0;
                            }
                        }
                        if (GameScr.arrItemUpGrade != null) {
                            for (int index69 = 0; index69 < GameScr.arrItemUpGrade.length; index69++) {
                                GameScr.arrItemUpGrade[index69] = null;
                            }
                        }
                        if (byteValue68 == 5 || byteValue68 == 6) {
                            if (GameScr.itemSplit != null) {
                                GameScr.itemSplit = null;
                            }
                            if (GameScr.arrItemSplit != null) {
                                for (int index70 = 0; index70 < GameScr.arrItemSplit.length; index70++) {
                                    GameScr.arrItemSplit[index70] = null;
                                }
                            }
                        }
                        GameScr.gI().left = GameScr.gI().center = null;
                        GameScr.gI().updateKeyBuyItemUI();
                        GameCanvas.endDlg();
                        if (byteValue68 == 5) {
                            InfoMe.addInfo(mResources.TYPEKHAMNGOC[0] + GameScr.itemUpGrade.upgrade, 20, mFont.tahoma_7_white);
                            return;
                        } else if (byteValue68 == 6) {
                            InfoMe.addInfo(mResources.TYPEKHAMNGOC[1] + GameScr.itemUpGrade.upgrade, 20, mFont.tahoma_7_red);
                            return;
                        } else {
                            if (byteValue68 == 1) {
                                InfoMe.addInfo(mResources.TYPEUPGRADE[0] + GameScr.itemUpGrade.upgrade, 20, mFont.tahoma_7_white);
                            } else {
                                InfoMe.addInfo(mResources.TYPEUPGRADE[1] + GameScr.itemUpGrade.upgrade, 20, mFont.tahoma_7_red);
                            }
                            return;
                        }
                    case 22:
                        byte byteValue71 = msg.reader().readByte();
                        String text72 = mResources.SPLIT_ITEM_NAME;
                        for (int index73 = 0; index73 < GameScr.arrItemSplit.length; index73++) {
                            GameScr.arrItemSplit[index73] = null;
                        }
                        for (int index74 = 0; index74 < byteValue71; index74++) {
                            Item item75;
                            (item75 = new Item()).typeUI = 3;
                            item75.indexUI = msg.reader().readByte();
                            item75.template = ItemTemplates.get(msg.reader().readShort());
                            item75.expires = -1L;
                            item75.quantity = 1;
                            item75.isLock = GameScr.itemSplit.isLock;
                            Char.getMyChar().arrItemBag[item75.indexUI] = item75;
                            text72 = text72 + item75.template.name;
                            if (index74 < byteValue71 - 1) {
                                text72 = text72 + ", ";
                            }
                        }
                        GameScr.itemSplit.upgrade = 0;
                        GameScr.itemSplit.clearExpire();
                        GameScr.gI().left = GameScr.gI().center = null;
                        GameScr.gI().updateCommandForUI();
                        GameCanvas.endDlg();
                        InfoMe.addInfo(text72);
                        GameScr.effUpok = GameScr.efs[66];
                        GameScr.indexEff = 0;
                        return;
                    case 23:
                        String text76 = msg.reader().readUTF();
                        GameCanvas.startYesNoDlg(text76 + " " + mResources.PLEASE_PARTY, 8889, text76, 8882, null);
                        return;
                    case 25:
                        byte byteValue77 = msg.reader().readByte();
                        for (int index78 = 0; index78 < byteValue77; index78++) {
                            int value79 = msg.reader().readInt();
                            short shortValue80 = msg.reader().readShort();
                            short shortValue81 = msg.reader().readShort();
                            int value82 = msg.reader().readInt();
                            Char character83;
                            if ((character83 = GameScr.findCharInMap(value79)) != null) {
                                character83.cx = shortValue80;
                                character83.cy = shortValue81;
                                character83.cHP = value82;
                                character83.lastUpdateTime = System.currentTimeMillis();
                            }
                        }
                        return;
                    case 26:
                        Char.getMyChar().countKill = msg.reader().readUnsignedShort();
                        Char.getMyChar().countKillMax = msg.reader().readUnsignedShort();
                        return;
                    case 27:
                        Mob mob84 = Mob.get_Mob(msg.reader().readUnsignedByte());
                        int value85;
                        Char character86;
                        if ((value85 = msg.reader().readInt()) == Char.getMyChar().charID) {
                            character86 = Char.getMyChar();
                        } else {
                            character86 = GameScr.findCharInMap(value85);
                        }
                        character86.moveFast = new short[3];
                        character86.moveFast[0] = 0;
                        character86.moveFast[1] = (short) mob84.x;
                        character86.moveFast[2] = (short) mob84.y;
                        character86.isBlinking = false;
                        return;
                    case 30:
                        byte byteValue87 = msg.reader().readByte();
                        try {
                            GameScr.svTitle = msg.reader().readUTF();
                            GameScr.svAction = msg.reader().readUTF();
                        } catch (Exception exception308) {
                        }
                        GameScr.gI().doOpenUI(byteValue87);
                        return;
                    case 31:
                        Char.getMyChar().xuInBox = msg.reader().readInt();
                        Char.getMyChar().arrItemBox = new Item[msg.reader().readUnsignedByte()];
                        for (int index88 = 0; index88 < Char.getMyChar().arrItemBox.length; index88++) {
                            short shortValue89;
                            if ((shortValue89 = msg.reader().readShort()) != -1) {
                                Char.getMyChar().arrItemBox[index88] = new Item();
                                Char.getMyChar().arrItemBox[index88].typeUI = 4;
                                Char.getMyChar().arrItemBox[index88].indexUI = index88;
                                Char.getMyChar().arrItemBox[index88].template = ItemTemplates.get(shortValue89);
                                Char.getMyChar().arrItemBox[index88].isLock = msg.reader().readBoolean();
                                if (Char.getMyChar().arrItemBox[index88].isTypeBody() || Char.getMyChar().arrItemBox[index88].isTypeNgocKham()) {
                                    Char.getMyChar().arrItemBox[index88].upgrade = msg.reader().readByte();
                                }
                                Char.getMyChar().arrItemBox[index88].isExpires = msg.reader().readBoolean();
                                Char.getMyChar().arrItemBox[index88].quantity = msg.reader().readShort();
                            }
                        }
                        return;
                    case 33:
                        byte byteValue90;
                        if ((byteValue90 = msg.reader().readByte()) == 14) {
                            GameScr.arrItemStore = new Item[msg.reader().readByte()];
                            for (int index91 = 0; index91 < GameScr.arrItemStore.length; index91++) {
                                GameScr.arrItemStore[index91] = new Item();
                                GameScr.arrItemStore[index91].typeUI = 14;
                                GameScr.arrItemStore[index91].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemStore[index91].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else if (byteValue90 == 15) {
                            GameScr.arrItemBook = new Item[msg.reader().readByte()];
                            for (int index92 = 0; index92 < GameScr.arrItemBook.length; index92++) {
                                GameScr.arrItemBook[index92] = new Item();
                                GameScr.arrItemBook[index92].typeUI = 15;
                                GameScr.arrItemBook[index92].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemBook[index92].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else if (byteValue90 == 32) {
                            GameScr.arrItemFashion = new Item[msg.reader().readByte()];
                            for (int index93 = 0; index93 < GameScr.arrItemFashion.length; index93++) {
                                GameScr.arrItemFashion[index93] = new Item();
                                GameScr.arrItemFashion[index93].typeUI = 32;
                                GameScr.arrItemFashion[index93].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemFashion[index93].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else if (byteValue90 == 34) {
                            GameScr.arrItemClanShop = new Item[msg.reader().readByte()];
                            for (int index94 = 0; index94 < GameScr.arrItemClanShop.length; index94++) {
                                GameScr.arrItemClanShop[index94] = new Item();
                                GameScr.arrItemClanShop[index94].typeUI = 34;
                                GameScr.arrItemClanShop[index94].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemClanShop[index94].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else if (byteValue90 == 35) {
                            GameScr.arrItemElites = new Item[msg.reader().readByte()];
                            for (int index95 = 0; index95 < GameScr.arrItemElites.length; index95++) {
                                GameScr.arrItemElites[index95] = new Item();
                                GameScr.arrItemElites[index95].typeUI = 35;
                                GameScr.arrItemElites[index95].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemElites[index95].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else if (byteValue90 == 20) {
                            GameScr.arrItemNonNam = new Item[msg.reader().readByte()];
                            for (int index96 = 0; index96 < GameScr.arrItemNonNam.length; index96++) {
                                GameScr.arrItemNonNam[index96] = new Item();
                                GameScr.arrItemNonNam[index96].typeUI = byteValue90;
                                GameScr.arrItemNonNam[index96].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemNonNam[index96].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else if (byteValue90 == 21) {
                            GameScr.arrItemNonNu = new Item[msg.reader().readByte()];
                            for (int index97 = 0; index97 < GameScr.arrItemNonNu.length; index97++) {
                                GameScr.arrItemNonNu[index97] = new Item();
                                GameScr.arrItemNonNu[index97].typeUI = byteValue90;
                                GameScr.arrItemNonNu[index97].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemNonNu[index97].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else if (byteValue90 == 22) {
                            GameScr.arrItemAoNam = new Item[msg.reader().readByte()];
                            for (int index98 = 0; index98 < GameScr.arrItemAoNam.length; index98++) {
                                GameScr.arrItemAoNam[index98] = new Item();
                                GameScr.arrItemAoNam[index98].typeUI = byteValue90;
                                GameScr.arrItemAoNam[index98].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemAoNam[index98].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else if (byteValue90 == 23) {
                            GameScr.arrItemAoNu = new Item[msg.reader().readByte()];
                            for (int index99 = 0; index99 < GameScr.arrItemAoNu.length; index99++) {
                                GameScr.arrItemAoNu[index99] = new Item();
                                GameScr.arrItemAoNu[index99].typeUI = byteValue90;
                                GameScr.arrItemAoNu[index99].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemAoNu[index99].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else if (byteValue90 == 24) {
                            GameScr.arrItemGangTayNam = new Item[msg.reader().readByte()];
                            for (int index100 = 0; index100 < GameScr.arrItemGangTayNam.length; index100++) {
                                GameScr.arrItemGangTayNam[index100] = new Item();
                                GameScr.arrItemGangTayNam[index100].typeUI = byteValue90;
                                GameScr.arrItemGangTayNam[index100].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemGangTayNam[index100].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else if (byteValue90 == 25) {
                            GameScr.arrItemGangTayNu = new Item[msg.reader().readByte()];
                            for (int index101 = 0; index101 < GameScr.arrItemGangTayNu.length; index101++) {
                                GameScr.arrItemGangTayNu[index101] = new Item();
                                GameScr.arrItemGangTayNu[index101].typeUI = byteValue90;
                                GameScr.arrItemGangTayNu[index101].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemGangTayNu[index101].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else if (byteValue90 == 26) {
                            GameScr.arrItemQuanNam = new Item[msg.reader().readByte()];
                            for (int index102 = 0; index102 < GameScr.arrItemQuanNam.length; index102++) {
                                GameScr.arrItemQuanNam[index102] = new Item();
                                GameScr.arrItemQuanNam[index102].typeUI = byteValue90;
                                GameScr.arrItemQuanNam[index102].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemQuanNam[index102].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else if (byteValue90 == 27) {
                            GameScr.arrItemQuanNu = new Item[msg.reader().readByte()];
                            for (int index103 = 0; index103 < GameScr.arrItemQuanNu.length; index103++) {
                                GameScr.arrItemQuanNu[index103] = new Item();
                                GameScr.arrItemQuanNu[index103].typeUI = byteValue90;
                                GameScr.arrItemQuanNu[index103].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemQuanNu[index103].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else if (byteValue90 == 28) {
                            GameScr.arrItemGiayNam = new Item[msg.reader().readByte()];
                            for (int index104 = 0; index104 < GameScr.arrItemGiayNam.length; index104++) {
                                GameScr.arrItemGiayNam[index104] = new Item();
                                GameScr.arrItemGiayNam[index104].typeUI = byteValue90;
                                GameScr.arrItemGiayNam[index104].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemGiayNam[index104].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else if (byteValue90 == 29) {
                            GameScr.arrItemGiayNu = new Item[msg.reader().readByte()];
                            for (int index105 = 0; index105 < GameScr.arrItemGiayNu.length; index105++) {
                                GameScr.arrItemGiayNu[index105] = new Item();
                                GameScr.arrItemGiayNu[index105].typeUI = byteValue90;
                                GameScr.arrItemGiayNu[index105].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemGiayNu[index105].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else if (byteValue90 == 16) {
                            GameScr.arrItemLien = new Item[msg.reader().readByte()];
                            for (int index106 = 0; index106 < GameScr.arrItemLien.length; index106++) {
                                GameScr.arrItemLien[index106] = new Item();
                                GameScr.arrItemLien[index106].typeUI = byteValue90;
                                GameScr.arrItemLien[index106].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemLien[index106].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else if (byteValue90 == 17) {
                            GameScr.arrItemNhan = new Item[msg.reader().readByte()];
                            for (int index107 = 0; index107 < GameScr.arrItemNhan.length; index107++) {
                                GameScr.arrItemNhan[index107] = new Item();
                                GameScr.arrItemNhan[index107].typeUI = byteValue90;
                                GameScr.arrItemNhan[index107].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemNhan[index107].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else if (byteValue90 == 18) {
                            GameScr.arrItemNgocBoi = new Item[msg.reader().readByte()];
                            for (int index108 = 0; index108 < GameScr.arrItemNgocBoi.length; index108++) {
                                GameScr.arrItemNgocBoi[index108] = new Item();
                                GameScr.arrItemNgocBoi[index108].typeUI = byteValue90;
                                GameScr.arrItemNgocBoi[index108].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemNgocBoi[index108].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else if (byteValue90 == 19) {
                            GameScr.arrItemPhu = new Item[msg.reader().readByte()];
                            for (int index109 = 0; index109 < GameScr.arrItemPhu.length; index109++) {
                                GameScr.arrItemPhu[index109] = new Item();
                                GameScr.arrItemPhu[index109].typeUI = byteValue90;
                                GameScr.arrItemPhu[index109].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemPhu[index109].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else if (byteValue90 == 2) {
                            GameScr.arrItemWeapon = new Item[msg.reader().readByte()];
                            for (int index110 = 0; index110 < GameScr.arrItemWeapon.length; index110++) {
                                GameScr.arrItemWeapon[index110] = new Item();
                                GameScr.arrItemWeapon[index110].typeUI = byteValue90;
                                GameScr.arrItemWeapon[index110].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemWeapon[index110].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else if (byteValue90 == 6) {
                            GameScr.arrItemStack = new Item[msg.reader().readByte()];
                            for (int index111 = 0; index111 < GameScr.arrItemStack.length; index111++) {
                                GameScr.arrItemStack[index111] = new Item();
                                GameScr.arrItemStack[index111].typeUI = byteValue90;
                                GameScr.arrItemStack[index111].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemStack[index111].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else if (byteValue90 == 7) {
                            GameScr.arrItemStackLock = new Item[msg.reader().readByte()];
                            for (int index112 = 0; index112 < GameScr.arrItemStackLock.length; index112++) {
                                GameScr.arrItemStackLock[index112] = new Item();
                                GameScr.arrItemStackLock[index112].typeUI = byteValue90;
                                GameScr.arrItemStackLock[index112].isLock = true;
                                GameScr.arrItemStackLock[index112].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemStackLock[index112].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else if (byteValue90 == 8) {
                            GameScr.arrItemGrocery = new Item[msg.reader().readByte()];
                            for (int index113 = 0; index113 < GameScr.arrItemGrocery.length; index113++) {
                                GameScr.arrItemGrocery[index113] = new Item();
                                GameScr.arrItemGrocery[index113].typeUI = byteValue90;
                                GameScr.arrItemGrocery[index113].indexUI = msg.reader().readUnsignedByte();
                                GameScr.arrItemGrocery[index113].template = ItemTemplates.get(msg.reader().readShort());
                            }
                            return;
                        } else {
                            if (byteValue90 == 9) {
                                GameScr.arrItemGroceryLock = new Item[msg.reader().readByte()];
                                for (int index114 = 0; index114 < GameScr.arrItemGroceryLock.length; index114++) {
                                    GameScr.arrItemGroceryLock[index114] = new Item();
                                    GameScr.arrItemGroceryLock[index114].typeUI = byteValue90;
                                    GameScr.arrItemGroceryLock[index114].isLock = true;
                                    GameScr.arrItemGroceryLock[index114].indexUI = msg.reader().readUnsignedByte();
                                    GameScr.arrItemGroceryLock[index114].template = ItemTemplates.get(msg.reader().readShort());
                                }
                            }
                            return;
                        }
                    case 34:
                        MyVector entries = new MyVector();
                        String text115;
                        if (!(text115 = msg.reader().readUTF()).equals("")) {
                            GameScr.gI().showAlert(null, text115, true);
                        }
                        byte byteValue116 = msg.reader().readByte();
                        for (int index117 = 0; index117 < byteValue116; index117++) {
                            String text118 = msg.reader().readUTF();
                            Short boxedShort = new Short(msg.reader().readShort());
                            entries.addElement(new Command(text118, GameCanvas.instance, 88819, boxedShort));
                        }
                        GameCanvas.menu.startAt(entries);
                        return;
                    case 36:
                        GameScr.gI().openUIZone(msg);
                        return;
                    case 37:
                        GameScr.gI().tradeName = msg.reader().readUTF();
                        GameScr.gI().openUITrade();
                        return;
                    case 38:
                        short shortValue119 = msg.reader().readShort();
                        for (int index120 = 0; index120 < GameScr.vNpc.size(); index120++) {
                            Npc npc;
                            if ((npc = (Npc) GameScr.vNpc.elementAt(index120)).template.npcTemplateId == shortValue119 && npc.equals(Char.getMyChar().npcFocus)) {
                                ChatPopup.addChatPopupMultiLine(msg.reader().readUTF(), 1000, npc);
                                return;
                            }
                        }
                        return;
                    case 39:
                        short shortValue121 = msg.reader().readShort();
                        for (int index122 = 0; index122 < GameScr.vNpc.size(); index122++) {
                            Npc npc123;
                            if ((npc123 = (Npc) GameScr.vNpc.elementAt(index122)).template.npcTemplateId == shortValue121 && npc123.equals(Char.getMyChar().npcFocus)) {
                                ChatPopup.addChatPopup(msg.reader().readUTF(), 1000, npc123);
                                String[] textLines = new String[msg.reader().readByte()];
                                for (int index124 = 0; index124 < textLines.length; index124++) {
                                    textLines[index124] = msg.reader().readUTF();
                                }
                                GameScr.gI();
                                GameScr.createMenu(textLines, npc123);
                                return;
                            }
                        }
                        return;
                    case 40:
                        InfoDlg.hide();
                        GameCanvas.clearKeyHold();
                        GameCanvas.clearKeyPressed();
                        MyVector entries125 = new MyVector();
                        try {
                            while (true) {
                                entries125.addElement(new Command(msg.reader().readUTF(), GameCanvas.instance, 88822, null));
                            }
                        } catch (Exception exception309) {
                            if (Char.getMyChar().npcFocus != null) {
                                for (int index126 = 0; index126 < Char.getMyChar().npcFocus.template.menu.length; index126++) {
                                    String[] textLines127 = Char.getMyChar().npcFocus.template.menu[index126];
                                    entries125.addElement(new Command(textLines127[0], GameCanvas.instance, 88820, textLines127));
                                }
                                GameCanvas.menu.startAt(entries125);
                                GameCanvas.menu.showbyServer = true;
                                return;
                            }
                            return;
                        }
                    case 42:
                        requestItemInfo(msg);
                        return;
                    case 43:
                        Char character128;
                        Integer boxedValue;
                        if ((character128 = GameScr.findCharInMap((boxedValue = new Integer(msg.reader().readInt())).intValue())) != null) {
                            GameCanvas.startYesNoDlg(character128.cName + " " + mResources.INVITETRADE, 88810, boxedValue, 88811, null);
                        }
                        return;
                    case 45:
                        GameScr.gI().typeTradeOrder = 1;
                        GameScr.gI().coinTradeOrder = msg.reader().readInt();
                        GameScr.arrItemTradeOrder = new Item[12];
                        byte byteValue129 = msg.reader().readByte();
                        for (int index130 = 0; index130 < byteValue129; index130++) {
                            GameScr.arrItemTradeOrder[index130] = new Item();
                            GameScr.arrItemTradeOrder[index130].typeUI = 3;
                            GameScr.arrItemTradeOrder[index130].indexUI = index130;
                            GameScr.arrItemTradeOrder[index130].template = ItemTemplates.get(msg.reader().readShort());
                            GameScr.arrItemTradeOrder[index130].isLock = false;
                            if (GameScr.arrItemTradeOrder[index130].isTypeBody() || GameScr.arrItemTradeOrder[index130].isTypeNgocKham()) {
                                GameScr.arrItemTradeOrder[index130].upgrade = msg.reader().readByte();
                            }
                            GameScr.arrItemTradeOrder[index130].isExpires = msg.reader().readBoolean();
                            GameScr.arrItemTradeOrder[index130].quantity = msg.reader().readShort();
                        }
                        if (GameScr.gI().typeTrade == 1 && GameScr.gI().typeTradeOrder == 1) {
                            GameScr.gI().timeTrade = (int) (System.currentTimeMillis() / 1000L + 5L);
                        }
                        return;
                    case 46:
                        GameScr.gI().typeTradeOrder = 2;
                        if (GameScr.gI().typeTrade >= 2 && GameScr.gI().typeTradeOrder >= 2) {
                            InfoDlg.showWait();
                        }
                        return;
                    case 47:
                        GameCanvas.taskTick = 150;
                        short shortValue131 = msg.reader().readShort();
                        byte byteValue132 = msg.reader().readByte();
                        String text133 = msg.reader().readUTF();
                        String text134 = msg.reader().readUTF();
                        String[] textLines135;
                        short[] values136 = new short[(textLines135 = new String[msg.reader().readByte()]).length];
                        short shortValue137 = -1;
                        for (int index138 = 0; index138 < textLines135.length; index138++) {
                            String text139 = msg.reader().readUTF();
                            values136[index138] = -1;
                            if (!text139.equals("")) {
                                textLines135[index138] = text139;
                            }
                        }
                        try {
                            shortValue137 = msg.reader().readShort();
                            for (int index140 = 0; index140 < textLines135.length; index140++) {
                                values136[index140] = msg.reader().readShort();
                            }
                        } catch (Exception exception310) {
                        }
                        Char.getMyChar().taskMaint = new Task(shortValue131, byteValue132, text133, text134, textLines135, values136, shortValue137);
                        Char.getMyChar().callEffTask(21);
                        if (Char.getMyChar().npcFocus != null) {
                            Npc.clearEffTask();
                        }
                        return;
                    case 48:
                        if (Char.getMyChar().taskMaint != null) {
                            GameCanvas.taskTick = 100;
                            Char.getMyChar().taskMaint.index++;
                            Char.getMyChar().taskMaint.count = 0;
                            if (Char.getMyChar().npcFocus != null && Char.getMyChar().npcFocus.chatPopup != null && Char.getMyChar().taskMaint.index >= 2) {
                                Char.getMyChar().npcFocus.chatPopup = null;
                            }
                            if (Char.getMyChar().taskMaint.index >= Char.getMyChar().taskMaint.subNames.length - 1) {
                                Char.getMyChar().callEffTask(61);
                            } else {
                                Char.getMyChar().callEffTask(21);
                            }
                            Npc.clearEffTask();
                        }
                        return;
                    case 49:
                        Char.getMyChar().ctaskId++;
                        Char.getMyChar();
                        Char.clearTask();
                        return;
                    case 50:
                        GameCanvas.taskTick = 50;
                        Char.getMyChar().taskMaint.count = msg.reader().readShort();
                        if (Char.getMyChar().npcFocus != null) {
                            Npc.clearEffTask();
                        }
                        return;
                    case 51:
                        Mob mob141 = null;
                        try {
                            mob141 = Mob.get_Mob(msg.reader().readUnsignedByte());
                        } catch (Exception exception311) {
                        }
                        if (mob141 != null) {
                            mob141.hp = msg.reader().readInt();
                            GameScr.startFlyText("", mob141.x, mob141.y - mob141.h, 0, -2, 4);
                        }
                        return;
                    case 52:
                        Char.ischangingMap = false;
                        Char.isLockKey = false;
                        Char.getMyChar().cx = msg.reader().readShort();
                        Char.getMyChar().cy = msg.reader().readShort();
                        Char.getMyChar().cxSend = Char.getMyChar().cx;
                        Char.getMyChar().cySend = Char.getMyChar().cy;
                        return;
                    case 53:
                        GameScr.gI().resetButton();
                        String text142;
                        if (!(text142 = msg.reader().readUTF()).equals("typemoi")) {
                            String text143 = msg.reader().readUTF();
                            GameScr.gI().showAlert(text142, text143, false);
                        } else {
                            String text144 = msg.reader().readUTF();
                            short shortValue145 = msg.reader().readShort();
                            String text146 = msg.reader().readUTF();
                            short shortValue147 = msg.reader().readShort();
                            String text148 = msg.reader().readUTF();
                            short shortValue149 = msg.reader().readShort();
                            String text150 = msg.reader().readUTF();
                            byte byteValue151 = msg.reader().readByte();
                            String text152 = msg.reader().readUTF();
                            GameScr.gI().showLucky_Draw(text144, shortValue145, text146, shortValue147, text148, shortValue149, text150, text152, byteValue151);
                        }
                        return;
                    case 54:
                        GameCanvas.gI().openWeb(msg.reader().readUTF(), msg.reader().readUTF(), msg.reader().readUTF(), msg.reader().readUTF());
                        return;
                    case 55:
                        GameCanvas.gI().sendSms(msg.reader().readUTF(), msg.reader().readUTF(), msg.reader().readShort(), msg.reader().readUTF(), msg.reader().readUTF());
                        return;
                    case 57:
                        GameCanvas.endDlg();
                        GameScr.gI().resetButton();
                        return;
                    case 58:
                        GameScr.arrItemTradeMe = null;
                        GameScr.arrItemTradeOrder = null;
                        if (GameScr.gI().coinTradeOrder > 0) {
                            GameScr gameScr153 = GameScr.gI();
                            gameScr153.tradeItemName = gameScr153.tradeItemName + ", " + GameScr.gI().coinTradeOrder + " " + mResources.XU;
                            GameScr.startFlyText("+" + GameScr.gI().coinTradeOrder, Char.getMyChar().cx, Char.getMyChar().cy - Char.getMyChar().ch - 10, 0, -2, 6);
                        }
                        GameScr.gI().coinTrade = GameScr.gI().coinTradeOrder = 0;
                        GameScr.gI().resetButton();
                        Char.getMyChar().xu = msg.reader().readInt();
                        InfoDlg.hide();
                        if (!GameScr.gI().tradeItemName.equals("")) {
                            InfoMe.addInfo(mResources.RECEIVE + " " + GameScr.gI().tradeItemName);
                        }
                        return;
                    case 59:
                        String text154 = msg.reader().readUTF();
                        Friend friend = new Friend(text154, (byte) 4);
                        GameScr.vFriendWait.addElement(friend);
                        InfoMe.addInfo(text154 + " " + mResources.FRIEND_ADDED, 20, mFont.tahoma_7_white);
                        if (GameScr.isPaintFriend) {
                            boolean flag155 = false;
                            for (int index156 = 0; index156 < GameScr.vFriend.size(); index156++) {
                                if (((Friend) GameScr.vFriend.elementAt(index156)).friendName.equals(text154)) {
                                    flag155 = true;
                                    break;
                                }
                            }
                            if (!flag155) {
                                GameScr.vFriend.addElement(friend);
                                GameScr.gI();
                                GameScr.sortList(0);
                                GameScr.indexRow = 0;
                                GameScr.scrMain.clear();
                                return;
                            }
                        }
                        return;
                    case 60:
                        Char character157;
                        if ((character157 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            Mob.interestChar = character157;
                        }
                        if (character157 != null) {
                            if ((TileMap.tileTypeAtPixel(character157.cx, character157.cy) & 2) == 2) {
                                character157.setSkillPaint(GameScr.sks[msg.reader().readByte()], 0);
                            } else {
                                character157.setSkillPaint(GameScr.sks[msg.reader().readByte()], 1);
                            }
                            if (character157.isWolf && character157.vitaWolf >= 500) {
                                character157.isWolf = false;
                                character157.timeSummon = System.currentTimeMillis();
                                ServerEffect.addServerEffect(60, character157, 1);
                            }
                            if (character157.isMoto) {
                                character157.isMoto = false;
                                character157.isMotoBehind = true;
                                if (character157.vitaWolf > 500) {
                                    ServerEffect.addServerEffect(60, character157, 1);
                                }
                            }
                            Mob[] values158 = new Mob[10];
                            int value159 = 0;
                            try {
                                for (value159 = 0; value159 < values158.length; value159++) {
                                    Mob mob160 = Mob.get_Mob(msg.reader().readUnsignedByte());
                                    values158[value159] = mob160;
                                    if (value159 == 0) {
                                        if (character157.cx <= mob160.x) {
                                            character157.cdir = 1;
                                        } else {
                                            character157.cdir = -1;
                                        }
                                    }
                                }
                            } catch (Exception exception312) {
                            }
                            if (value159 > 0) {
                                character157.attMobs = new Mob[value159];
                                for (int index161 = 0; index161 < character157.attMobs.length; index161++) {
                                    character157.attMobs[index161] = values158[index161];
                                }
                                character157.mobFocus = character157.attMobs[0];
                            }
                            return;
                        }
                        return;
                    case 61:
                        Char character162;
                        if ((character162 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            if ((TileMap.tileTypeAtPixel(character162.cx, character162.cy) & 2) == 2) {
                                character162.setSkillPaint(GameScr.sks[msg.reader().readByte()], 0);
                            } else {
                                character162.setSkillPaint(GameScr.sks[msg.reader().readByte()], 1);
                            }
                            if (character162.isWolf) {
                                character162.isWolf = false;
                                character162.timeSummon = System.currentTimeMillis();
                                if (character162.vitaWolf >= 500) {
                                    ServerEffect.addServerEffect(60, character162, 1);
                                }
                            }
                            if (character162.isMoto) {
                                character162.isMoto = false;
                                character162.isMotoBehind = true;
                                ServerEffect.addServerEffect(60, character162, 1);
                            }
                            Char[] values163 = new Char[10];
                            int value164 = 0;
                            try {
                                for (value164 = 0; value164 < values163.length; value164++) {
                                    Char character165;
                                    int value166;
                                    if ((value166 = msg.reader().readInt()) == Char.getMyChar().charID) {
                                        character165 = Char.getMyChar();
                                    } else {
                                        character165 = GameScr.findCharInMap(value166);
                                    }
                                    values163[value164] = character165;
                                    if (value164 == 0) {
                                        if (character162.cx <= character165.cx) {
                                            character162.cdir = 1;
                                        } else {
                                            character162.cdir = -1;
                                        }
                                    }
                                }
                            } catch (Exception exception313) {
                            }
                            if (value164 > 0) {
                                character162.attChars = new Char[value164];
                                for (int index167 = 0; index167 < character162.attChars.length; index167++) {
                                    character162.attChars[index167] = values163[index167];
                                }
                                character162.charFocus = character162.attChars[0];
                            }
                            return;
                        }
                        return;
                    case 62:
                        int value168;
                        if ((value168 = msg.reader().readInt()) == Char.getMyChar().charID) {
                            Char character169;
                            (character169 = Char.getMyChar()).cHP = msg.reader().readInt();
                            int value170 = msg.reader().readInt();
                            int value171 = 0;
                            try {
                                character169.cMP = msg.reader().readInt();
                                value171 = msg.reader().readInt();
                            } catch (Exception exception314) {
                            }
                            int value172;
                            if ((value172 = value170 + value171) == 0) {
                                GameScr.startFlyText("", character169.cx, character169.cy - character169.ch, 0, -2, 7);
                                return;
                            } else {
                                if (value172 < 0) {
                                    int value173 = -value172;
                                    GameScr.startFlyText("-" + value173, character169.cx, character169.cy - character169.ch, 0, -2, 8);
                                } else {
                                    GameScr.startFlyText("-" + value172, character169.cx, character169.cy - character169.ch, 0, -2, 0);
                                }
                                return;
                            }
                        }
                        Char character174;
                        if ((character174 = GameScr.findCharInMap(value168)) != null) {
                            character174.cHP = msg.reader().readInt();
                            int value175 = msg.reader().readInt();
                            int value176 = 0;
                            try {
                                character174.cMP = msg.reader().readInt();
                                value176 = msg.reader().readInt();
                            } catch (Exception exception315) {
                            }
                            int value177;
                            if ((value177 = value175 + value176) == 0) {
                                GameScr.startFlyText("", character174.cx, character174.cy - character174.ch, 0, -2, 4);
                                return;
                            } else {
                                if (value177 < 0) {
                                    int value178 = -value177;
                                    GameScr.startFlyText("-" + value178, character174.cx, character174.cy - character174.ch, 0, -2, 3);
                                } else {
                                    GameScr.startFlyText("-" + value177, character174.cx, character174.cy - character174.ch, 0, -2, 5);
                                }
                                return;
                            }
                        }
                        return;
                    case 63:
                        MyVector entries179 = new MyVector();
                        while (true) {
                            try {
                                entries179.addElement(new Command(msg.reader().readUTF(), GameCanvas.instance, 88817, null));
                            } catch (Exception exception316) {
                                GameCanvas.menu.startAt(entries179);
                                return;
                            }
                        }
                    case 64:
                        int value180;
                        Char character181;
                        if ((value180 = msg.reader().readInt()) == Char.getMyChar().charID) {
                            character181 = Char.getMyChar();
                        } else {
                            character181 = GameScr.findCharInMap(value180);
                        }
                        character181.moveFast = new short[3];
                        character181.moveFast[0] = 0;
                        short shortValue182 = msg.reader().readShort();
                        short shortValue183 = msg.reader().readShort();
                        character181.moveFast[1] = shortValue182;
                        character181.moveFast[2] = shortValue183;
                        character181.isBlinking = false;
                        try {
                            int value184;
                            Char character185;
                            if ((value184 = msg.reader().readInt()) == Char.getMyChar().charID) {
                                character185 = Char.getMyChar();
                            } else {
                                character185 = GameScr.findCharInMap(value184);
                            }
                            character185.cx = shortValue182;
                            character185.cy = shortValue183;
                        } catch (Exception exception317) {
                            exception317.printStackTrace();
                        }
                        return;
                    case 65:
                        Char character186;
                        if ((character186 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            GameCanvas.startYesNoDlg(character186.cName + " " + mResources.INVITETEST, 88812, character186, 8882, null);
                        }
                        return;
                    case 66:
                        int value187 = msg.reader().readInt();
                        int value188 = msg.reader().readInt();
                        if (value187 != Char.getMyChar().charID && value188 != Char.getMyChar().charID) {
                            GameScr.findCharInMap(value187).testCharId = value188;
                            GameScr.findCharInMap(value188).testCharId = value187;
                            return;
                        } else {
                            if (value187 == Char.getMyChar().charID) {
                                Char.getMyChar().testCharId = value188;
                                Char.getMyChar().npcFocus = null;
                                Char.getMyChar().mobFocus = null;
                                Char.getMyChar().itemFocus = null;
                                Char.getMyChar().charFocus = GameScr.findCharInMap(Char.getMyChar().testCharId);
                                Char.getMyChar().charFocus.testCharId = Char.getMyChar().charID;
                                GameScr.gI().cPreFocusID = GameScr.gI().cLastFocusID;
                                GameScr.gI().cLastFocusID = value188;
                                Char.isManualFocus = true;
                            } else if (value188 == Char.getMyChar().charID) {
                                Char.getMyChar().testCharId = value187;
                                Char.getMyChar().npcFocus = null;
                                Char.getMyChar().mobFocus = null;
                                Char.getMyChar().itemFocus = null;
                                Char.getMyChar().charFocus = GameScr.findCharInMap(Char.getMyChar().testCharId);
                                Char.getMyChar().charFocus.testCharId = Char.getMyChar().charID;
                                GameScr.gI().cPreFocusID = GameScr.gI().cLastFocusID;
                                GameScr.gI().cLastFocusID = value187;
                                Char.isManualFocus = true;
                                return;
                            }
                            return;
                        }
                    case 67:
                        int value189 = msg.reader().readInt();
                        int value190 = msg.reader().readInt();
                        int value191 = 0;
                        try {
                            value191 = msg.reader().readInt();
                        } catch (Exception exception318) {
                        }
                        if (value189 == Char.getMyChar().charID) {
                            Char character192 = GameScr.findCharInMap(value190);
                            if (value191 > 0) {
                                InfoMe.addInfo(mResources.replace(mResources.YOU_LOST, character192.cName));
                                Char.getMyChar().cHP = value191;
                                Char.getMyChar().resultTest = 29;
                                if (character192 != null) {
                                    character192.resultTest = 89;
                                }
                            } else {
                                if (character192 != null) {
                                    character192.resultTest = 59;
                                }
                                Char.getMyChar().resultTest = 59;
                                InfoMe.addInfo(mResources.replace(mResources.TEST_END, character192.cName));
                            }
                            Char.getMyChar().testCharId = -9999;
                            Char.getMyChar().charFocus = null;
                            if (GameScr.gI().cPreFocusID >= 0) {
                                GameScr.gI().cLastFocusID = GameScr.gI().cPreFocusID;
                                GameScr.gI().cPreFocusID = -1;
                            } else {
                                GameScr.gI().cLastFocusID = -1;
                            }
                            if (character192 != null) {
                                character192.testCharId = -9999;
                                return;
                            }
                            return;
                        } else if (value190 == Char.getMyChar().charID) {
                            Char character193 = GameScr.findCharInMap(value189);
                            if (value191 > 0) {
                                if (character193 != null) {
                                    character193.cHP = value191;
                                }
                                if (character193 != null) {
                                    character193.resultTest = 29;
                                }
                                Char.getMyChar().resultTest = 89;
                                InfoMe.addInfo(mResources.replace(mResources.YOU_WIN, character193.cName));
                            } else {
                                if (character193 != null) {
                                    character193.resultTest = 59;
                                }
                                Char.getMyChar().resultTest = 59;
                                InfoMe.addInfo(mResources.replace(mResources.TEST_END, character193.cName));
                            }
                            if (character193 != null) {
                                character193.testCharId = -9999;
                            }
                            Char.getMyChar().testCharId = -9999;
                            Char.getMyChar().charFocus = null;
                            if (GameScr.gI().cPreFocusID >= 0) {
                                GameScr.gI().cLastFocusID = GameScr.gI().cPreFocusID;
                                GameScr.gI().cPreFocusID = -1;
                            } else {
                                GameScr.gI().cLastFocusID = -1;
                            }
                            return;
                        } else {
                            Char character194 = GameScr.findCharInMap(value189);
                            Char character195 = GameScr.findCharInMap(value190);
                            if (value191 > 0) {
                                if (character194 != null) {
                                    character194.cHP = value191;
                                }
                                if (character194 != null) {
                                    character194.resultTest = 29;
                                }
                                if (character195 != null) {
                                    character195.resultTest = 89;
                                }
                            } else {
                                if (character194 != null) {
                                    character194.resultTest = 59;
                                }
                                if (character195 != null) {
                                    character195.resultTest = 59;
                                }
                            }
                            if (character194 != null) {
                                character194.testCharId = -9999;
                            }
                            if (character195 != null) {
                                character195.testCharId = -9999;
                                return;
                            }
                            return;
                        }
                    case 68:
                        Char character196;
                        if ((character196 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            character196.killCharId = Char.getMyChar().charID;
                            Char.getMyChar().npcFocus = null;
                            Char.getMyChar().mobFocus = null;
                            Char.getMyChar().itemFocus = null;
                            Char.getMyChar().charFocus = character196;
                            Char.isManualFocus = true;
                            InfoMe.addInfo(character196.cName + mResources.CUU_SAT, 20, mFont.tahoma_7_red);
                        }
                        return;
                    case 69:
                        Char.getMyChar().killCharId = msg.reader().readInt();
                        Char.getMyChar().npcFocus = null;
                        Char.getMyChar().mobFocus = null;
                        Char.getMyChar().itemFocus = null;
                        Char.getMyChar().charFocus = GameScr.findCharInMap(Char.getMyChar().killCharId);
                        Char.isManualFocus = true;
                        return;
                    case 70:
                        Char player = Char.getMyChar();
                        try {
                            player = GameScr.findCharInMap(msg.reader().readInt());
                        } catch (Exception exception319) {
                        }
                        player.killCharId = -9999;
                        return;
                    case 71:
                        long longValue197 = msg.reader().readLong();
                        Char.getMyChar().cExpDown -= longValue197;
                        GameScr.startFlyText("+" + longValue197, Char.getMyChar().cx, Char.getMyChar().cy - Char.getMyChar().ch, 0, -2, 2);
                        return;
                    case 72:
                        Char.getMyChar().cPk = msg.reader().readByte();
                        Char.getMyChar().waitToDie(msg.reader().readShort(), msg.reader().readShort());
                        Char.getMyChar().cEXP = GameScr.getMaxExp(Char.getMyChar().clevel - 1);
                        Char.getMyChar().cExpDown = msg.reader().readLong();
                        GameScr.setLevel_Exp(Char.getMyChar().cEXP, true);
                        return;
                    case 75:
                        BuNhin buNhin = new BuNhin(msg.reader().readUTF(), msg.reader().readShort(), msg.reader().readShort());
                        GameScr.vBuNhin.addElement(buNhin);
                        ServerEffect.addServerEffect(60, buNhin.x, buNhin.y, 1);
                        return;
                    case 76:
                        Mob mob198;
                        if ((mob198 = Mob.get_Mob(msg.reader().readUnsignedByte())) == null) {
                            return;
                        }
                        BuNhin buNhin199;
                        if ((buNhin199 = GameScr.findBuNhinInMap(msg.reader().readShort())) != null) {
                            short shortValue200 = msg.reader().readShort();
                            byte byteValue201 = msg.reader().readByte();
                            byte byteValue202 = msg.reader().readByte();
                            mob198.setAttack(buNhin199);
                            mob198.setTypeAtk(shortValue200, byteValue201, byteValue202);
                            return;
                        }
                        return;
                    case 77:
                        BuNhin buNhin203 = (BuNhin) GameScr.vBuNhin.elementAt(msg.reader().readShort());
                        GameScr.vBuNhin.removeElement(buNhin203);
                        ServerEffect.addServerEffect(60, buNhin203.x, buNhin203.y, 1);
                        return;
                    case 78:
                        Mob mob204 = null;
                        try {
                            mob204 = Mob.get_Mob(msg.reader().readUnsignedByte());
                        } catch (Exception exception320) {
                        }
                        if (mob204 != null && mob204.status != 0 && mob204.status != 0) {
                            mob204.status = 0;
                            ServerEffect.addServerEffect(60, mob204.x, mob204.y, 1);
                            ItemMap itemMap205 = new ItemMap(msg.reader().readShort(), msg.reader().readShort(), mob204.x, mob204.y, msg.reader().readShort(), msg.reader().readShort());
                            GameScr.vItemMap.addElement(itemMap205);
                            if (Res.abs(itemMap205.y - Char.getMyChar().cy) < 24 && Res.abs(itemMap205.x - Char.getMyChar().cx) < 24) {
                                Char.getMyChar().charFocus = null;
                                return;
                            }
                        }
                        return;
                    case 79:
                        int value206 = msg.reader().readInt();
                        String text207 = msg.reader().readUTF();
                        GameCanvas.startYesNoDlg(text207 + " " + mResources.INVITEPARTY, 8887, new Integer(value206), 8888, new Integer(value206));
                        return;
                    case 82:
                        GameScr.vParty.removeAllElements();
                        boolean flag208 = msg.reader().readBoolean();
                        try {
                            for (int index209 = 0; index209 < 6; index209++) {
                                GameScr.vParty.addElement(new Party(msg.reader().readInt(), msg.reader().readByte(), msg.reader().readUTF(), flag208));
                            }
                        } catch (Exception exception321) {
                        }
                        GameScr.gI().refreshTeam();
                        return;
                    case 83:
                        GameScr.vParty.removeAllElements();
                        GameScr.gI().refreshTeam();
                        return;
                    case 84:
                        Friend friend210 = new Friend(msg.reader().readUTF(), msg.reader().readByte());
                        GameScr.gI();
                        GameScr.actRemoveWaitAcceptFriend(friend210.friendName);
                        if (friend210.type == 0) {
                            InfoMe.addInfo(mResources.YOU_ADD + " " + friend210.friendName + " " + mResources.TO_LIST);
                            GameScr.vFriend.addElement(friend210);
                        } else if (friend210.type == 1) {
                            for (int index211 = 0; index211 < GameScr.vFriend.size(); index211++) {
                                if (((Friend) GameScr.vFriend.elementAt(index211)).friendName.equals(friend210.friendName)) {
                                    GameScr.vFriend.removeElementAt(index211);
                                    break;
                                }
                            }
                            InfoMe.addInfo(mResources.YOU_AND + " " + friend210.friendName + " " + mResources.BE_FRIEND);
                            friend210.type = 3;
                            GameScr.vFriend.insertElementAt(friend210, 0);
                        }
                        if (GameScr.isPaintFriend) {
                            GameScr.gI();
                            GameScr.sortList(0);
                            GameScr.indexRow = 0;
                            GameScr.scrMain.clear();
                        }
                        return;
                    case 85:
                        Mob mob212;
                        if ((mob212 = Mob.get_Mob(msg.reader().readUnsignedByte())) != null) {
                            mob212.isDisable = msg.reader().readBoolean();
                        }
                        return;
                    case 86:
                        Mob mob213;
                        if ((mob213 = Mob.get_Mob(msg.reader().readUnsignedByte())) != null) {
                            mob213.isDontMove = msg.reader().readBoolean();
                        }
                        return;
                    case 87:
                        int value214;
                        Char character215;
                        if ((value214 = msg.reader().readInt()) == Char.getMyChar().charID) {
                            character215 = Char.getMyChar();
                        } else {
                            character215 = GameScr.findCharInMap(value214);
                        }
                        if (character215 != null) {
                            int unsignedByte = msg.reader().readUnsignedByte();
                            short shortValue216 = msg.reader().readShort();
                            byte byteValue217 = msg.reader().readByte();
                            byte byteValue218 = msg.reader().readByte();
                            byte byteValue219 = 0;
                            int value220 = -1;
                            try {
                                if ((byteValue219 = msg.reader().readByte()) == 1) {
                                    value220 = msg.reader().readInt();
                                }
                            } catch (Exception exception322) {
                                exception322.printStackTrace();
                            }
                            if (character215.mobMe != null) {
                                if (byteValue219 == 0) {
                                    Mob mob221 = Mob.get_Mob(unsignedByte);
                                    character215.mobMe.attackOtherMob(mob221);
                                } else {
                                    Char character222 = GameScr.findCharInMap(value220);
                                    character215.mobMe.attackOtherChar(character222);
                                }
                            }
                            character215.mobMe.setTypeAtk(shortValue216, byteValue217, byteValue218);
                            return;
                        }
                        return;
                    case 88:
                        int value223;
                        Char character224;
                        if ((value223 = msg.reader().readInt()) == Char.getMyChar().charID) {
                            character224 = Char.getMyChar();
                        } else if ((character224 = GameScr.findCharInMap(value223)) == null) {
                            return;
                        }
                        character224.cHP = character224.cMaxHP;
                        character224.cMP = character224.cMaxMP;
                        character224.cx = msg.reader().readShort();
                        character224.cy = msg.reader().readShort();
                        character224.liveFromDead();
                        return;
                    case 89:
                        Mob mob225;
                        if ((mob225 = Mob.get_Mob(msg.reader().readUnsignedByte())) != null) {
                            mob225.isFire = msg.reader().readBoolean();
                        }
                        return;
                    case 90:
                        Mob mob226;
                        if ((mob226 = Mob.get_Mob(msg.reader().readUnsignedByte())) != null) {
                            mob226.isIce = msg.reader().readBoolean();
                            if (!mob226.isIce) {
                                ServerEffect.addServerEffect(77, mob226.x, mob226.y - 9, 1);
                                return;
                            }
                        }
                        return;
                    case 91:
                        Mob mob227;
                        if ((mob227 = Mob.get_Mob(msg.reader().readUnsignedByte())) != null) {
                            mob227.isWind = msg.reader().readBoolean();
                        }
                        return;
                    case 92:
                        String text228 = msg.reader().readUTF();
                        Short boxedShort229 = new Short(msg.reader().readShort());
                        GameCanvas.inputDlg.show(text228, new Command(mResources.ACCEPT, GameCanvas.instance, 88818, boxedShort229), 0);
                        return;
                    case 93:
                        int value230 = msg.reader().readInt();
                        GameScr.currentCharViewInfo = new Char();
                        if (Char.getMyChar().charID == value230) {
                            GameScr.currentCharViewInfo = Char.getMyChar();
                        } else {
                            Char character231;
                            if ((character231 = GameScr.findCharInMap(value230)) == null) {
                                GameScr.currentCharViewInfo = new Char();
                            } else {
                                GameScr.currentCharViewInfo = character231;
                            }
                            GameScr.currentCharViewInfo.charID = value230;
                            GameScr.currentCharViewInfo.statusMe = 1;
                            GameScr.gI().showViewInfo();
                        }
                        GameScr.currentCharViewInfo.cName = msg.reader().readUTF();
                        GameScr.currentCharViewInfo.head = msg.reader().readShort();
                        GameScr.currentCharViewInfo.cgender = msg.reader().readByte();
                        byte byteValue232 = msg.reader().readByte();
                        GameScr.currentCharViewInfo.nClass = GameScr.nClasss[byteValue232];
                        GameScr.currentCharViewInfo.cPk = msg.reader().readByte();
                        GameScr.currentCharViewInfo.cHP = msg.reader().readInt();
                        GameScr.currentCharViewInfo.cMaxHP = msg.reader().readInt();
                        GameScr.currentCharViewInfo.cMP = msg.reader().readInt();
                        GameScr.currentCharViewInfo.cMaxMP = msg.reader().readInt();
                        GameScr.currentCharViewInfo.cspeed = msg.reader().readByte();
                        GameScr.currentCharViewInfo.cResFire = msg.reader().readShort();
                        GameScr.currentCharViewInfo.cResIce = msg.reader().readShort();
                        GameScr.currentCharViewInfo.cResWind = msg.reader().readShort();
                        GameScr.currentCharViewInfo.cdame = msg.reader().readInt();
                        GameScr.currentCharViewInfo.cdameDown = msg.reader().readInt();
                        GameScr.currentCharViewInfo.cExactly = msg.reader().readShort();
                        GameScr.currentCharViewInfo.cMiss = msg.reader().readShort();
                        GameScr.currentCharViewInfo.cFatal = msg.reader().readShort();
                        GameScr.currentCharViewInfo.cReactDame = msg.reader().readShort();
                        GameScr.currentCharViewInfo.sysUp = msg.reader().readShort();
                        GameScr.currentCharViewInfo.sysDown = msg.reader().readShort();
                        GameScr.currentCharViewInfo.clevel = msg.reader().readUnsignedByte();
                        GameScr.currentCharViewInfo.pointUydanh = msg.reader().readShort();
                        GameScr.currentCharViewInfo.cClanName = msg.reader().readUTF();
                        if (!GameScr.currentCharViewInfo.cClanName.equals("")) {
                            GameScr.currentCharViewInfo.ctypeClan = msg.reader().readByte();
                        }
                        GameScr.currentCharViewInfo.pointUydanh = msg.reader().readShort();
                        GameScr.currentCharViewInfo.pointNon = msg.reader().readShort();
                        GameScr.currentCharViewInfo.pointAo = msg.reader().readShort();
                        GameScr.currentCharViewInfo.pointGangtay = msg.reader().readShort();
                        GameScr.currentCharViewInfo.pointQuan = msg.reader().readShort();
                        GameScr.currentCharViewInfo.pointGiay = msg.reader().readShort();
                        GameScr.currentCharViewInfo.pointVukhi = msg.reader().readShort();
                        GameScr.currentCharViewInfo.pointLien = msg.reader().readShort();
                        GameScr.currentCharViewInfo.pointNhan = msg.reader().readShort();
                        GameScr.currentCharViewInfo.pointNgocboi = msg.reader().readShort();
                        GameScr.currentCharViewInfo.pointPhu = msg.reader().readShort();
                        GameScr.currentCharViewInfo.countFinishDay = msg.reader().readByte();
                        GameScr.currentCharViewInfo.countLoopBoos = msg.reader().readByte();
                        GameScr.currentCharViewInfo.countPB = msg.reader().readByte();
                        GameScr.currentCharViewInfo.limitTiemnangso = msg.reader().readByte();
                        GameScr.currentCharViewInfo.limitKynangso = msg.reader().readByte();
                        GameScr.currentCharViewInfo.arrItemBody = new Item[32];
                        try {
                            GameScr.currentCharViewInfo.setDefaultPart();
                            for (int index233 = 0; index233 < 16; index233++) {
                                short shortValue234;
                                if ((shortValue234 = msg.reader().readShort()) > -1) {
                                    ItemTemplate itemTemplate;
                                    byte byteValue235 = (itemTemplate = ItemTemplates.get(shortValue234)).type;
                                    GameScr.currentCharViewInfo.arrItemBody[byteValue235] = new Item();
                                    GameScr.currentCharViewInfo.arrItemBody[byteValue235].indexUI = byteValue235;
                                    GameScr.currentCharViewInfo.arrItemBody[byteValue235].typeUI = 5;
                                    GameScr.currentCharViewInfo.arrItemBody[byteValue235].template = itemTemplate;
                                    GameScr.currentCharViewInfo.arrItemBody[byteValue235].isLock = true;
                                    GameScr.currentCharViewInfo.arrItemBody[byteValue235].upgrade = msg.reader().readByte();
                                    GameScr.currentCharViewInfo.arrItemBody[byteValue235].sys = msg.reader().readByte();
                                    if (byteValue235 == 1) {
                                        GameScr.currentCharViewInfo.wp = GameScr.currentCharViewInfo.arrItemBody[byteValue235].template.part;
                                    } else if (byteValue235 == 2) {
                                        GameScr.currentCharViewInfo.body = GameScr.currentCharViewInfo.arrItemBody[byteValue235].template.part;
                                    } else if (byteValue235 == 6) {
                                        GameScr.currentCharViewInfo.leg = GameScr.currentCharViewInfo.arrItemBody[byteValue235].template.part;
                                    }
                                }
                            }
                        } catch (Exception exception323) {
                        }
                        try {
                            for (int index236 = 0; index236 < 16; index236++) {
                                short shortValue237;
                                if ((shortValue237 = msg.reader().readShort()) > -1) {
                                    ItemTemplate itemTemplate238;
                                    int value239 = (itemTemplate238 = ItemTemplates.get(shortValue237)).type + 16;
                                    GameScr.currentCharViewInfo.arrItemBody[value239] = new Item();
                                    GameScr.currentCharViewInfo.arrItemBody[value239].indexUI = value239;
                                    GameScr.currentCharViewInfo.arrItemBody[value239].typeUI = 5;
                                    GameScr.currentCharViewInfo.arrItemBody[value239].template = itemTemplate238;
                                    GameScr.currentCharViewInfo.arrItemBody[value239].isLock = true;
                                    GameScr.currentCharViewInfo.arrItemBody[value239].upgrade = msg.reader().readByte();
                                    GameScr.currentCharViewInfo.arrItemBody[value239].sys = msg.reader().readByte();
                                    if (value239 == 1) {
                                        GameScr.currentCharViewInfo.wp = GameScr.currentCharViewInfo.arrItemBody[value239].template.part;
                                    } else if (value239 == 2) {
                                        GameScr.currentCharViewInfo.body = GameScr.currentCharViewInfo.arrItemBody[value239].template.part;
                                    } else if (value239 == 6) {
                                        GameScr.currentCharViewInfo.leg = GameScr.currentCharViewInfo.arrItemBody[value239].template.part;
                                    }
                                }
                            }
                            return;
                        } catch (Exception exception324) {
                            return;
                        }
                    case 94:
                        requestItemPlayer(msg);
                        return;
                    case 95:
                        int value240 = msg.reader().readInt();
                        Char.getMyChar().xu += value240;
                        GameScr.startFlyText(value240 > 0 ? "+" + value240 : "" + value240, Char.getMyChar().cx, Char.getMyChar().cy - Char.getMyChar().ch - 10, 0, -2, 1);
                        return;
                    case 96:
                        Char.getMyChar().taskOrders.addElement(new TaskOrder(msg.reader().readByte(), msg.reader().readInt(), msg.reader().readInt(), msg.reader().readUTF(), msg.reader().readUTF(), msg.reader().readUnsignedByte(), msg.reader().readUnsignedByte()));
                        Char.getMyChar().callEffTask(21);
                        return;
                    case 97:
                        byte byteValue241 = msg.reader().readByte();
                        for (int index242 = 0; index242 < Char.getMyChar().taskOrders.size(); index242++) {
                            TaskOrder taskOrder;
                            if ((taskOrder = (TaskOrder) Char.getMyChar().taskOrders.elementAt(index242)).taskId == byteValue241) {
                                taskOrder.count = msg.reader().readInt();
                                if (taskOrder.count == taskOrder.maxCount) {
                                    Char.getMyChar().callEffTask(61);
                                }
                                return;
                            }
                        }
                        return;
                    case 98:
                        byte byteValue243 = msg.reader().readByte();
                        for (int index244 = 0; index244 < Char.getMyChar().taskOrders.size(); index244++) {
                            if (((TaskOrder) Char.getMyChar().taskOrders.elementAt(index244)).taskId == byteValue243) {
                                Char.getMyChar().taskOrders.removeElementAt(index244);
                                break;
                            }
                        }
                        Char.getMyChar().callEffTask(21);
                        return;
                    case 99:
                        Char character245;
                        if ((character245 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            GameCanvas.startYesNoDlg(character245.cName + " " + mResources.INVITETESTDUN, 88840, character245, 8882, null);
                        }
                        return;
                    case 100:
                        GameScr.vList.removeAllElements();
                        byte byteValue246 = msg.reader().readByte();
                        DunItem dunItem = null;
                        for (int index247 = 0; index247 < byteValue246; index247++) {
                            try {
                                (dunItem = new DunItem()).id = msg.reader().readByte();
                                dunItem.name1 = msg.reader().readUTF();
                                dunItem.name2 = msg.reader().readUTF();
                                GameScr.vList.addElement(dunItem);
                            } catch (Exception exception325) {
                            }
                        }
                        GameScr.gI().doShowListUI();
                        return;
                    case 101:
                        try {
                            GameScr.currentCharViewInfo.pointTinhTu = msg.reader().readInt();
                            GameScr.currentCharViewInfo.limitPhongLoi = msg.reader().readByte();
                            GameScr.currentCharViewInfo.limitBangHoa = msg.reader().readByte();
                        } catch (Exception exception326) {
                            exception326.printStackTrace();
                        }
                        return;
                    case 102:
                        Item item248;
                        if ((item248 = Char.getMyChar().arrItemBag[msg.reader().readByte()]) != null) {
                            GameScr.itemSell = item248;
                        }
                        Char.getMyChar().xu = msg.reader().readInt();
                        if (GameScr.itemSell != null) {
                            if (GameScr.itemSell.template.type == 16) {
                                GameScr.hpPotion = GameScr.hpPotion - GameScr.itemSell.quantity;
                            }
                            if (GameScr.itemSell.template.type == 17) {
                                GameScr.mpPotion = GameScr.mpPotion - GameScr.itemSell.quantity;
                            }
                            Char.getMyChar().arrItemBag[GameScr.itemSell.indexUI] = null;
                            GameScr.itemSell = null;
                            GameScr.gI().resetButton();
                            InfoMe.addInfo(mResources.SALE_INFO);
                        }
                        GameCanvas.endDlg();
                        return;
                    case 103:
                        GameScr.indexMenu = msg.reader().readByte();
                        GameScr.arrItemStands = new ItemStands[msg.reader().readInt()];
                        for (int index249 = 0; index249 < GameScr.arrItemStands.length; index249++) {
                            GameScr.arrItemStands[index249] = new ItemStands();
                            GameScr.arrItemStands[index249].item = new Item();
                            GameScr.arrItemStands[index249].item.itemId = msg.reader().readInt();
                            GameScr.arrItemStands[index249].timeStart = (int) (System.currentTimeMillis() / 1000L);
                            GameScr.arrItemStands[index249].timeEnd = msg.reader().readInt();
                            GameScr.arrItemStands[index249].item.quantity = msg.reader().readUnsignedShort();
                            GameScr.arrItemStands[index249].seller = msg.reader().readUTF();
                            GameScr.arrItemStands[index249].price = msg.reader().readInt();
                            GameScr.arrItemStands[index249].item.template = ItemTemplates.get(msg.reader().readShort());
                        }
                        GameScr.gI().doOpenUI(37);
                        return;
                    case 104:
                        viewItemAuction(msg);
                        return;
                    case 106:
                        Char character250;
                        if ((character250 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            GameCanvas.startYesNoDlg(character250.cName + " " + mResources.INVITETESTGT, 88841, character250, 8882, null);
                        }
                        return;
                    case 107:
                        byte byteValue251 = msg.reader().readByte();
                        GameCanvas.startYesNoDlg(msg.reader().readUTF(), 8890, new Integer(byteValue251), 8891, null);
                        return;
                    case 108:
                        Char.getMyChar().itemMonToBag(msg);
                        return;
                    case 109:
                        InfoDlg.hide();
                        GameCanvas.clearKeyHold();
                        GameCanvas.clearKeyPressed();
                        MyVector entries252 = new MyVector();
                        try {
                            byte byteValue253 = msg.reader().readByte();
                            for (int index254 = 0; index254 < byteValue253; index254++) {
                                String[] textLines255 = new String[msg.reader().readByte()];
                                for (int index256 = 0; index256 < textLines255.length; index256++) {
                                    textLines255[index256] = msg.reader().readUTF();
                                }
                                entries252.addElement(new Command(textLines255[0], GameCanvas.instance, 88820, textLines255));
                            }
                        } catch (Exception exception327) {
                        }
                        if (Char.getMyChar().npcFocus != null) {
                            GameCanvas.menu.startAt(entries252);
                            return;
                        }
                        return;
                    case 112:
                        Item item257;
                        (item257 = Char.getMyChar().arrItemBag[msg.reader().readByte()]).upgrade = msg.reader().readByte();
                        item257.expires = 0L;
                        return;
                    case 114:
                        GameScr.gI().typeba = msg.reader().readByte();
                        return;
                    case 116:
                        Char character258;
                        if ((character258 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            readCharInfo(character258, msg);
                        }
                        return;
                    case 117:
                        byte byteValue259;
                        if ((byteValue259 = msg.reader().readByte()) == -1) {
                            GameCanvas.readMessenge.onVithuInfo(msg);
                        } else if (!GameCanvas.lowGraphic) {
                            try {
                                Mob.vEggMonter.removeAllElements();
                                TileMap.itemMap.clear();
                                GameScr.vItemTreeBehind.removeAllElements();
                                GameScr.vItemTreeBetwen.removeAllElements();
                                GameScr.vItemTreeFront.removeAllElements();
                                for (int index260 = 0; index260 < byteValue259; index260++) {
                                    short shortValue261 = msg.reader().readShort();
                                    String text262 = String.valueOf(shortValue261);
                                    byte[] data263 = new byte[msg.reader().readInt()];
                                    msg.reader().read(data263);
                                    Image image = createImage(data263);
                                    TileMap.itemMap.put(text262, image);
                                }
                                int unsignedByte264 = msg.reader().readUnsignedByte();
                                for (int index265 = 0; index265 < unsignedByte264; index265++) {
                                    int unsignedByte266 = msg.reader().readUnsignedByte();
                                    int unsignedByte267 = msg.reader().readUnsignedByte();
                                    int unsignedByte268 = msg.reader().readUnsignedByte();
                                    ItemTree itemTree;
                                    (itemTree = new ItemTree(unsignedByte267, unsignedByte268)).idTree = unsignedByte266;
                                    GameScr.vItemTreeBehind.addElement(itemTree);
                                }
                                int unsignedByte269 = msg.reader().readUnsignedByte();
                                for (int index270 = 0; index270 < unsignedByte269; index270++) {
                                    int unsignedByte271 = msg.reader().readUnsignedByte();
                                    int unsignedByte272 = msg.reader().readUnsignedByte();
                                    int unsignedByte273 = msg.reader().readUnsignedByte();
                                    ItemTree itemTree274;
                                    (itemTree274 = new ItemTree(unsignedByte272, unsignedByte273)).idTree = unsignedByte271;
                                    GameScr.vItemTreeBetwen.addElement(itemTree274);
                                }
                                int unsignedByte275 = msg.reader().readUnsignedByte();
                                for (int index276 = 0; index276 < unsignedByte275; index276++) {
                                    int unsignedByte277 = msg.reader().readUnsignedByte();
                                    int unsignedByte278 = msg.reader().readUnsignedByte();
                                    int unsignedByte279 = msg.reader().readUnsignedByte();
                                    ItemTree itemTree280;
                                    (itemTree280 = new ItemTree(unsignedByte278, unsignedByte279)).idTree = unsignedByte277;
                                    GameScr.vItemTreeFront.addElement(itemTree280);
                                }
                                return;
                            } catch (Exception exception328) {
                                exception328.printStackTrace();
                                return;
                            }
                        }
                        return;
                    case 118:
                        String text281 = msg.reader().readUTF();
                        RMS.saveRMSString("acc", text281);
                        String text282 = msg.reader().readUTF();
                        RMS.saveRMSString("pass", text282);
                        SelectServerScr.uname = text281;
                        SelectServerScr.pass = text282;
                        SelectServerScr.unameChange = "";
                        SelectServerScr.passChange = "";
                        if (!text281.startsWith("tmpusr")) {
                            GameScr.gI().switchToMe();
                        }
                        return;
                    case 119:
                        short shortValue283;
                        if ((shortValue283 = msg.reader().readByte()) == -1) {
                            GameScr.isUseitemAuto = true;
                            GameScr.loadCamera(true);
                            if ((GameScr.rangeSearch = msg.reader().readInt()) > 360) {
                                GameScr.isAllmap = true;
                            } else {
                                GameScr.isAllmap = false;
                                GameScr.pointCenterX = Char.getMyChar().cx;
                                GameScr.pointCenterY = Char.getMyChar().cy;
                            }
                            return;
                        } else {
                            if (shortValue283 == 0) {
                                Char character284;
                                if ((character284 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                                    ServerEffect.addServerEffect(141, character284.cx, character284.cy, 2);
                                    short shortValue285 = msg.reader().readShort();
                                    character284.cxMoveLast = shortValue285;
                                    shortValue283 = msg.reader().readShort();
                                    character284.cyMoveLast = shortValue283;
                                    ServerEffect.addServerEffect(141, character284.cx, character284.cy, 2);
                                    return;
                                }
                            } else {
                                GameScr.isUseitemAuto = false;
                                GameScr.auto = 0;
                            }
                            return;
                        }
                    case 121:
                        GameScr.vList.removeAllElements();
                        int unsignedByte286 = msg.reader().readUnsignedByte();
                        Ranked ranked = null;
                        for (int index287 = 0; index287 < unsignedByte286; index287++) {
                            try {
                                (ranked = new Ranked()).name = msg.reader().readUTF();
                                ranked.ranked = msg.reader().readInt();
                                ranked.stt = msg.reader().readUTF();
                                GameScr.vList.addElement(ranked);
                            } catch (Exception exception329) {
                            }
                        }
                        GameScr.gI().doShowRankedListUI();
                        return;
                    case 122:
                        byte byteValue288;
                        if ((byteValue288 = msg.reader().readByte()) == 0) {
                            addMob(msg);
                            return;
                        } else if (byteValue288 == 1) {
                            addEffAuto(msg);
                            return;
                        } else {
                            if (byteValue288 == 2) {
                                getImgEffAuto(msg);
                            } else if (byteValue288 == 3) {
                                getDataEffAuto(msg);
                                return;
                            }
                            return;
                        }
                    case 123:
                        byte byteValue289;
                        if ((byteValue289 = msg.reader().readByte()) == 0) {
                            GameCanvas.isKiemduyet_info = true;
                            return;
                        } else if (byteValue289 == 1) {
                            GameCanvas.isKiemduyet_info = false;
                            return;
                        } else {
                            if (byteValue289 == 2) {
                                GameCanvas.isKiemduyet = true;
                                RMS.saveRMSInt("isKiemduyet", 0);
                            } else {
                                GameCanvas.isKiemduyet = false;
                                RMS.saveRMSInt("isKiemduyet", 1);
                            }
                            return;
                        }
                    case 124:
                        khamngoc(msg);
                        return;
                    case 125:
                        byte byteValue290;
                        if ((byteValue290 = msg.reader().readByte()) == 0) {
                            addEffect(msg);
                            return;
                        } else {
                            if (byteValue290 == 1) {
                                getImgEffect(msg);
                            } else if (byteValue290 == 2) {
                                getDataEffect(msg);
                                return;
                            }
                            return;
                        }
                    case 126:
                        byte byteValue291 = msg.reader().readByte();
                        GameCanvas.endDlg();
                        if (byteValue291 == 0) {
                            GameScr.instance.resetButton();
                            return;
                        }
                }
            } catch (Exception exception330) {
                System.out.println("ERROR COMAND: " + msg.command);
                exception330.printStackTrace();
            }
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    private static void createItem(DataInputStream d) throws IOException {
        GameScr.vcItem = d.readByte();
        GameScr.iOptionTemplates = new ItemOptionTemplate[d.readUnsignedByte()];
        for (int index = 0; index < GameScr.iOptionTemplates.length; index++) {
            GameScr.iOptionTemplates[index] = new ItemOptionTemplate();
            GameScr.iOptionTemplates[index].id = index;
            GameScr.iOptionTemplates[index].name = d.readUTF();
            GameScr.iOptionTemplates[index].type = d.readByte();
        }
        short shortValue = d.readShort();
        for (int index1 = 0; index1 < shortValue; index1++) {
            ItemTemplates.add(new ItemTemplate((short) index1, d.readByte(), d.readByte(), d.readUTF(), d.readUTF(), d.readByte(), d.readShort(), d.readShort(), d.readBoolean()));
        }
    }

    private static void createSkill(DataInputStream d) throws IOException {
        GameScr.vcSkill = d.readByte();
        GameScr.sOptionTemplates = new SkillOptionTemplate[d.readByte()];
        for (int index = 0; index < GameScr.sOptionTemplates.length; index++) {
            GameScr.sOptionTemplates[index] = new SkillOptionTemplate();
            GameScr.sOptionTemplates[index].id = index;
            GameScr.sOptionTemplates[index].name = d.readUTF();
        }
        GameScr.nClasss = new NClass[d.readUnsignedByte()];
        for (int index1 = 0; index1 < GameScr.nClasss.length; index1++) {
            GameScr.nClasss[index1] = new NClass();
            GameScr.nClasss[index1].classId = index1;
            GameScr.nClasss[index1].name = d.readUTF();
            GameScr.nClasss[index1].skillTemplates = new SkillTemplate[d.readByte()];
            for (int index2 = 0; index2 < GameScr.nClasss[index1].skillTemplates.length; index2++) {
                GameScr.nClasss[index1].skillTemplates[index2] = new SkillTemplate();
                GameScr.nClasss[index1].skillTemplates[index2].id = d.readByte();
                GameScr.nClasss[index1].skillTemplates[index2].name = d.readUTF();
                GameScr.nClasss[index1].skillTemplates[index2].maxPoint = d.readByte();
                GameScr.nClasss[index1].skillTemplates[index2].type = d.readByte();
                GameScr.nClasss[index1].skillTemplates[index2].iconId = d.readShort();
                short shortValue = 150;
                if (GameCanvas.w == 128 || GameCanvas.h <= 208) {
                    shortValue = 100;
                }
                GameScr.nClasss[index1].skillTemplates[index2].description = mFont.tahoma_7_white.splitFontArray(d.readUTF(), shortValue);
                GameScr.nClasss[index1].skillTemplates[index2].skills = new Skill[d.readByte()];
                for (int index3 = 0; index3 < GameScr.nClasss[index1].skillTemplates[index2].skills.length; index3++) {
                    GameScr.nClasss[index1].skillTemplates[index2].skills[index3] = new Skill();
                    GameScr.nClasss[index1].skillTemplates[index2].skills[index3].skillId = d.readShort();
                    GameScr.nClasss[index1].skillTemplates[index2].skills[index3].template = GameScr.nClasss[index1].skillTemplates[index2];
                    GameScr.nClasss[index1].skillTemplates[index2].skills[index3].point = d.readByte();
                    GameScr.nClasss[index1].skillTemplates[index2].skills[index3].level = d.readByte();
                    GameScr.nClasss[index1].skillTemplates[index2].skills[index3].manaUse = d.readShort();
                    GameScr.nClasss[index1].skillTemplates[index2].skills[index3].coolDown = d.readInt();
                    GameScr.nClasss[index1].skillTemplates[index2].skills[index3].dx = d.readShort();
                    GameScr.nClasss[index1].skillTemplates[index2].skills[index3].dy = d.readShort();
                    GameScr.nClasss[index1].skillTemplates[index2].skills[index3].maxFight = d.readByte();
                    GameScr.nClasss[index1].skillTemplates[index2].skills[index3].options = new SkillOption[d.readByte()];
                    for (int index4 = 0; index4 < GameScr.nClasss[index1].skillTemplates[index2].skills[index3].options.length; index4++) {
                        GameScr.nClasss[index1].skillTemplates[index2].skills[index3].options[index4] = new SkillOption();
                        GameScr.nClasss[index1].skillTemplates[index2].skills[index3].options[index4].param = d.readShort();
                        GameScr.nClasss[index1].skillTemplates[index2].skills[index3].options[index4].optionTemplate = GameScr.sOptionTemplates[d.readByte()];
                    }
                    Skills.add(GameScr.nClasss[index1].skillTemplates[index2].skills[index3]);
                }
            }
        }
    }

    private static void createMap(DataInputStream d) throws IOException {
        GameScr.vcMap = d.readByte();
        TileMap.mapNames = new String[d.readUnsignedByte()];
        for (int index = 0; index < TileMap.mapNames.length; index++) {
            TileMap.mapNames[index] = d.readUTF();
        }
        Npc.arrNpcTemplate = new NpcTemplate[d.readByte()];
        for (byte index1 = 0; index1 < Npc.arrNpcTemplate.length; index1++) {
            Npc.arrNpcTemplate[index1] = new NpcTemplate();
            Npc.arrNpcTemplate[index1].npcTemplateId = index1;
            Npc.arrNpcTemplate[index1].name = d.readUTF();
            Npc.arrNpcTemplate[index1].headId = d.readShort();
            Npc.arrNpcTemplate[index1].bodyId = d.readShort();
            Npc.arrNpcTemplate[index1].legId = d.readShort();
            Npc.arrNpcTemplate[index1].menu = new String[d.readByte()][];
            for (int index2 = 0; index2 < Npc.arrNpcTemplate[index1].menu.length; index2++) {
                Npc.arrNpcTemplate[index1].menu[index2] = new String[d.readByte()];
                for (int index3 = 0; index3 < Npc.arrNpcTemplate[index1].menu[index2].length; index3++) {
                    Npc.arrNpcTemplate[index1].menu[index2][index3] = d.readUTF();
                }
            }
        }
        short shortValue;
        Mob.arrMobTemplate = new MobTemplate[shortValue = d.readShort()];
        for (int index4 = 0; index4 < shortValue; index4++) {
            Mob.arrMobTemplate[index4] = new MobTemplate();
            Mob.arrMobTemplate[index4].mobTemplateId = (short) index4;
            Mob.arrMobTemplate[index4].type = d.readByte();
            Mob.arrMobTemplate[index4].name = d.readUTF();
            Mob.arrMobTemplate[index4].hp = d.readInt();
            Mob.arrMobTemplate[index4].rangeMove = d.readByte();
            Mob.arrMobTemplate[index4].speed = d.readByte();
        }
    }

    private static void createData(DataInputStream d) throws IOException {
        GameScr.vcData = d.readByte();
        RMS.saveRMS("nj_arrow", NinjaUtil.readByteArray(d));
        RMS.saveRMS("nj_effect", NinjaUtil.readByteArray(d));
        RMS.saveRMS("nj_image", NinjaUtil.readByteArray(d));
        RMS.saveRMS("nj_part", NinjaUtil.readByteArray(d));
        RMS.saveRMS("nj_skill", NinjaUtil.readByteArray(d));
        GameScr.mapTasks = new byte[(GameScr.tasks = new byte[d.readByte()][]).length][];
        for (int index = 0; index < GameScr.tasks.length; index++) {
            GameScr.tasks[index] = new byte[d.readByte()];
            GameScr.mapTasks[index] = new byte[GameScr.tasks[index].length];
            for (int index1 = 0; index1 < GameScr.tasks[index].length; index1++) {
                GameScr.tasks[index][index1] = d.readByte();
                GameScr.mapTasks[index][index1] = d.readByte();
            }
        }
        GameScr.exps = new long[d.readUnsignedByte()];
        for (int index2 = 0; index2 < GameScr.exps.length; index2++) {
            GameScr.exps[index2] = d.readLong();
        }
        GameScr.crystals = new int[d.readByte()];
        for (int index3 = 0; index3 < GameScr.crystals.length; index3++) {
            GameScr.crystals[index3] = d.readInt();
        }
        GameScr.upClothe = new int[d.readByte()];
        for (int index4 = 0; index4 < GameScr.upClothe.length; index4++) {
            GameScr.upClothe[index4] = d.readInt();
        }
        GameScr.upAdorn = new int[d.readByte()];
        for (int index5 = 0; index5 < GameScr.upAdorn.length; index5++) {
            GameScr.upAdorn[index5] = d.readInt();
        }
        GameScr.upWeapon = new int[d.readByte()];
        for (int index6 = 0; index6 < GameScr.upWeapon.length; index6++) {
            GameScr.upWeapon[index6] = d.readInt();
        }
        GameScr.coinUpCrystals = new int[d.readByte()];
        for (int index7 = 0; index7 < GameScr.coinUpCrystals.length; index7++) {
            GameScr.coinUpCrystals[index7] = d.readInt();
        }
        GameScr.coinUpClothes = new int[d.readByte()];
        for (int index8 = 0; index8 < GameScr.coinUpClothes.length; index8++) {
            GameScr.coinUpClothes[index8] = d.readInt();
        }
        GameScr.coinUpAdorns = new int[d.readByte()];
        for (int index9 = 0; index9 < GameScr.coinUpAdorns.length; index9++) {
            GameScr.coinUpAdorns[index9] = d.readInt();
        }
        GameScr.coinUpWeapons = new int[d.readByte()];
        for (int index10 = 0; index10 < GameScr.coinUpWeapons.length; index10++) {
            GameScr.coinUpWeapons[index10] = d.readInt();
        }
        GameScr.goldUps = new int[d.readByte()];
        for (int index11 = 0; index11 < GameScr.goldUps.length; index11++) {
            GameScr.goldUps[index11] = d.readInt();
        }
        GameScr.maxPercents = new int[d.readByte()];
        for (int index12 = 0; index12 < GameScr.maxPercents.length; index12++) {
            GameScr.maxPercents[index12] = d.readInt();
        }
        Effect.effTemplates = new EffectTemplate[d.readByte()];
        for (int index13 = 0; index13 < Effect.effTemplates.length; index13++) {
            Effect.effTemplates[index13] = new EffectTemplate();
            Effect.effTemplates[index13].id = d.readByte();
            Effect.effTemplates[index13].type = d.readByte();
            d.readUTF();
            Effect.effTemplates[index13].iconId = d.readShort();
        }
    }

    public static Image createImage(byte[] arr) {
        try {
            return Image.createImage(arr, 0, arr.length);
        } catch (Exception exception) {
            return null;
        }
    }

    private void loadInfoMap(Message msg) {
        try {
            Char player = Char.getMyChar();
            Char player1 = Char.getMyChar();
            Char.getMyChar();
            player.cx = player1.cxSend = msg.reader().readShort();
            player = Char.getMyChar();
            player1 = Char.getMyChar();
            Char.getMyChar();
            player.cy = player1.cySend = msg.reader().readShort();
            byte byteValue = msg.reader().readByte();
            for (int index = 0; index < byteValue; index++) {
                TileMap.vGo.addElement(new Waypoint(msg.reader().readShort(), msg.reader().readShort(), msg.reader().readShort(), msg.reader().readShort()));
            }
            byte byteValue2 = msg.reader().readByte();
            for (byte index3 = 0; index3 < byteValue2; index3++) {
                Mob mob = new Mob(index3, msg.reader().readBoolean(), msg.reader().readBoolean(), msg.reader().readBoolean(), msg.reader().readBoolean(), msg.reader().readBoolean(), msg.reader().readShort(), msg.reader().readByte(), msg.reader().readInt(), msg.reader().readUnsignedByte(), msg.reader().readInt(), msg.reader().readShort(), msg.reader().readShort(), msg.reader().readByte(), msg.reader().readByte(), msg.reader().readBoolean(), false);
                if (Mob.arrMobTemplate[mob.templateId].type != 0) {
                    if (index3 % 3 == 0) {
                        mob.dir = -1;
                    } else {
                        mob.dir = 1;
                    }
                    mob.x += 10 - index3 % 20;
                }
                GameScr.vMob.addElement(mob);
            }
            byte byteValue4 = msg.reader().readByte();
            for (byte index5 = 0; index5 < byteValue4; index5++) {
                GameScr.vBuNhin.addElement(new BuNhin(msg.reader().readUTF(), msg.reader().readShort(), msg.reader().readShort()));
            }
            byte byteValue6 = msg.reader().readByte();
            for (int index7 = 0; index7 < byteValue6; index7++) {
                GameScr.vNpc.addElement(new Npc(index7, msg.reader().readByte(), msg.reader().readShort(), msg.reader().readShort(), msg.reader().readByte()));
            }
            byte byteValue8 = msg.reader().readByte();
            for (int index9 = 0; index9 < byteValue8; index9++) {
                ItemMap itemMap = new ItemMap(msg.reader().readShort(), msg.reader().readShort(), msg.reader().readShort(), msg.reader().readShort());
                boolean flag = false;
                for (int index10 = 0; index10 < GameScr.vItemMap.size(); index10++) {
                    if (((ItemMap) GameScr.vItemMap.elementAt(index10)).itemMapID == itemMap.itemMapID) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    GameScr.vItemMap.addElement(itemMap);
                }
            }
            GameScr.loadCamera(false);
            try {
                TileMap.mapName1 = null;
                TileMap.mapName = TileMap.mapName1 = msg.reader().readUTF();
            } catch (Exception exception) {
            }
            try {
                TileMap.locationStand.clear();
                int unsignedByte = msg.reader().readUnsignedByte();
                for (int index11 = 0; index11 < unsignedByte; index11++) {
                    int unsignedByte12 = msg.reader().readUnsignedByte();
                    int unsignedByte13 = msg.reader().readUnsignedByte();
                    String text = String.valueOf((short) (unsignedByte13 * TileMap.tmw + unsignedByte12));
                    TileMap.locationStand.put(text, "location");
                }
            } catch (Exception exception14) {
                exception14.printStackTrace();
            }
            TileMap.loadMap(TileMap.tileID);
            Char.getMyChar().cvx = 0;
            Char.getMyChar().statusMe = 4;
            GameScr.gI().loadSplash();
            GameCanvas.loadBG(TileMap.bgID);
            Char.isLockKey = false;
            Char.ischangingMap = false;
            GameCanvas.clearKeyHold();
            GameCanvas.clearKeyPressed();
            GameScr.gI().switchToMe();
            InfoDlg.hide();
            InfoDlg.show(TileMap.mapName, mResources.ZONE + " " + TileMap.zoneID, 30);
            Party.refreshAll();
            GameCanvas.endDlg();
            GameCanvas.isLoading = false;
        } catch (Exception exception15) {
        }
    }

    private void messageNotMap(Message msg) {
        try {
            try {
                switch(msg.reader().readByte()) {
                    case -127:
                    case -125:
                    case -124:
                    case -118:
                    case -110:
                    case -107:
                    case -105:
                    case -104:
                    case -103:
                    case -102:
                    case -101:
                    case -100:
                    case -94:
                    case -92:
                    case -91:
                    case -89:
                    case -87:
                    case -85:
                    case -82:
                    case -79:
                    case -78:
                    case -76:
                    case -75:
                    case -74:
                    case -73:
                    case -71:
                    case -69:
                    case -68:
                    case -65:
                    case -64:
                    case -63:
                    case -61:
                    case -60:
                    default:
                        return;
                    case -126:
                        byte byteValue = msg.reader().readByte();
                        LoginScr.isLoggingIn = false;
                        SelectCharScr selectCharScr;
                        (selectCharScr = SelectCharScr.gI()).name = new String[3];
                        selectCharScr.parthead = new int[3];
                        selectCharScr.partleg = new int[3];
                        selectCharScr.partbody = new int[3];
                        selectCharScr.partWp = new int[3];
                        selectCharScr.level = new int[3];
                        selectCharScr.phai = new String[3];
                        selectCharScr.gender = new byte[3];
                        if (GameCanvas.isTouch) {
                            selectCharScr.indexSelect = -1;
                        } else {
                            selectCharScr.indexSelect = 0;
                        }
                        GameScr.gI();
                        GameScr.readPart();
                        SmallImage.init();
                        for (byte index = 0; index < byteValue; index++) {
                            SelectCharScr.gI().gender[index] = msg.reader().readByte();
                            SelectCharScr.gI().name[index] = msg.reader().readUTF();
                            SelectCharScr.gI().phai[index] = msg.reader().readUTF();
                            SelectCharScr.gI().level[index] = msg.reader().readUnsignedByte();
                            SelectCharScr.gI().parthead[index] = msg.reader().readShort();
                            SelectCharScr.gI().partWp[index] = msg.reader().readShort();
                            SelectCharScr.gI().partbody[index] = msg.reader().readShort();
                            SelectCharScr.gI().partleg[index] = msg.reader().readShort();
                            if (SelectCharScr.gI().partWp[index] == -1) {
                                SelectCharScr.gI().partWp[index] = 15;
                            }
                            if (SelectCharScr.gI().partbody[index] == -1) {
                                if (SelectCharScr.gI().gender[index] == 0) {
                                    SelectCharScr.gI().partbody[index] = 10;
                                } else {
                                    SelectCharScr.gI().partbody[index] = 1;
                                }
                            }
                            if (SelectCharScr.gI().partleg[index] == -1) {
                                if (SelectCharScr.gI().gender[index] == 0) {
                                    SelectCharScr.gI().partleg[index] = 9;
                                } else {
                                    SelectCharScr.gI().partleg[index] = 0;
                                }
                            }
                        }
                        SelectCharScr.gI().switchToMe();
                        GameCanvas.endDlg();
                        return;
                    case -123:
                        GameScr.vsData = msg.reader().readByte();
                        GameScr.vsMap = msg.reader().readByte();
                        GameScr.vsSkill = msg.reader().readByte();
                        GameScr.vsItem = msg.reader().readByte();
                        System.out.println("****** DATA VERSION: Server " + GameScr.vsData + " Client " + GameScr.vcData);
                        System.out.println("****** MAP VERSION: Server " + GameScr.vsMap + " Client " + GameScr.vcMap);
                        System.out.println("****** SKILL VERSION: Server " + GameScr.vsSkill + " Client " + GameScr.vcSkill);
                        System.out.println("****** ITEM VERSION: Server " + GameScr.vsItem + " Client " + GameScr.vcItem);
                        if (GameScr.vsData != GameScr.vcData) {
                            Service.gI().updateData();
                        } else {
                            try {
                                createData(new DataInputStream(new ByteArrayInputStream(RMS.loadRMS("data"))));
                            } catch (Exception exception) {
                                GameScr.vcData = -1;
                                Service.gI().updateData();
                            }
                        }
                        if (GameScr.vsMap != GameScr.vcMap) {
                            Service.gI().updateMap();
                        } else {
                            try {
                                createMap(new DataInputStream(new ByteArrayInputStream(RMS.loadRMS("map"))));
                            } catch (Exception exception49) {
                                GameScr.vcMap = -1;
                                Service.gI().updateMap();
                            }
                        }
                        if (GameScr.vsSkill != GameScr.vcSkill) {
                            Service.gI().updateSkill();
                        } else {
                            try {
                                createSkill(new DataInputStream(new ByteArrayInputStream(RMS.loadRMS("skill"))));
                            } catch (Exception exception50) {
                                GameScr.vcSkill = -1;
                                Service.gI().updateSkill();
                            }
                        }
                        if (GameScr.vsItem != GameScr.vcItem) {
                            Service.gI().updateItem();
                        } else {
                            try {
                                createItem(new DataInputStream(new ByteArrayInputStream(RMS.loadRMS("item"))));
                            } catch (Exception exception51) {
                                GameScr.vcItem = -1;
                                Service.gI().updateItem();
                            }
                        }
                        if (GameScr.vsData == GameScr.vcData && GameScr.vsMap == GameScr.vcMap && GameScr.vsSkill == GameScr.vcSkill && GameScr.vsItem == GameScr.vcItem) {
                            GameScr.gI();
                            GameScr.readEfect();
                            GameScr.gI();
                            GameScr.readArrow();
                            GameScr.gI();
                            GameScr.readSkill();
                            Service.gI().clientOk();
                        }
                        CharPartInfo.doSetInfo(msg);
                        return;
                    case -122:
                        System.out.println("GET UPDATE_DATA " + msg.reader().available() + " bytes");
                        msg.reader().mark(100000);
                        createData(msg.reader());
                        msg.reader().reset();
                        byte[] data = new byte[msg.reader().available()];
                        msg.reader().readFully(data);
                        RMS.saveRMS("data", data);
                        byte[] data1 = new byte[] { GameScr.vcData };
                        RMS.saveRMS("dataVersion", data1);
                        if (GameScr.vsData != GameScr.vcData || GameScr.vsMap != GameScr.vcMap || GameScr.vsSkill != GameScr.vcSkill || GameScr.vsItem != GameScr.vcItem) {
                            return;
                        }
                        GameScr.gI();
                        GameScr.readEfect();
                        GameScr.gI();
                        GameScr.readArrow();
                        GameScr.gI();
                        GameScr.readSkill();
                        Service.gI().clientOk();
                        return;
                    case -121:
                        System.out.println("GET UPDATE_MAP " + msg.reader().available() + " bytes");
                        msg.reader().mark(100000);
                        createMap(msg.reader());
                        msg.reader().reset();
                        byte[] data2 = new byte[msg.reader().available()];
                        msg.reader().readFully(data2);
                        RMS.saveRMS("map", data2);
                        byte[] data3 = new byte[] { GameScr.vcMap };
                        RMS.saveRMS("mapVersion", data3);
                        if (GameScr.vsData != GameScr.vcData || GameScr.vsMap != GameScr.vcMap || GameScr.vsSkill != GameScr.vcSkill || GameScr.vsItem != GameScr.vcItem) {
                            return;
                        }
                        GameScr.gI();
                        GameScr.readEfect();
                        GameScr.gI();
                        GameScr.readArrow();
                        GameScr.gI();
                        GameScr.readSkill();
                        Service.gI().clientOk();
                        return;
                    case -120:
                        System.out.println("GET UPDATE_SKILL " + msg.reader().available() + " bytes");
                        msg.reader().mark(100000);
                        createSkill(msg.reader());
                        msg.reader().reset();
                        byte[] data4 = new byte[msg.reader().available()];
                        msg.reader().readFully(data4);
                        if (Char.getMyChar().isHumanz()) {
                            RMS.saveRMS("skill", data4);
                        } else {
                            RMS.saveRMS("skillnhanban", data4);
                        }
                        byte[] data5 = new byte[] { GameScr.vcSkill };
                        RMS.saveRMS("skillVersion", data5);
                        if (GameScr.vsData != GameScr.vcData || GameScr.vsMap != GameScr.vcMap || GameScr.vsSkill != GameScr.vcSkill || GameScr.vsItem != GameScr.vcItem) {
                            return;
                        }
                        GameScr.gI();
                        GameScr.readEfect();
                        GameScr.gI();
                        GameScr.readArrow();
                        GameScr.gI();
                        GameScr.readSkill();
                        Service.gI().clientOk();
                        return;
                    case -119:
                        System.out.println("GET UPDATE_ITEM " + msg.reader().available() + " bytes");
                        msg.reader().mark(100000);
                        createItem(msg.reader());
                        msg.reader().reset();
                        byte[] data6 = new byte[msg.reader().available()];
                        msg.reader().readFully(data6);
                        RMS.saveRMS("item", data6);
                        byte[] data7 = new byte[] { GameScr.vcItem };
                        RMS.saveRMS("itemVersion", data7);
                        if (GameScr.vsData != GameScr.vcData || GameScr.vsMap != GameScr.vcMap || GameScr.vsSkill != GameScr.vcSkill || GameScr.vsItem != GameScr.vcItem) {
                            return;
                        }
                        GameScr.gI();
                        GameScr.readEfect();
                        GameScr.gI();
                        GameScr.readArrow();
                        GameScr.gI();
                        GameScr.readSkill();
                        Service.gI().clientOk();
                        return;
                    case -117:
                        Char.getMyChar().cPk = msg.reader().readByte();
                        Info.addInfo(mResources.PK_NOW + " " + Char.getMyChar().cPk, 15, mFont.tahoma_7_yellow);
                        Char.getMyChar().callEffTask(21);
                        return;
                    case -116:
                        Char.getMyChar().xu = msg.reader().readInt();
                        Char.clan.coin = msg.reader().readInt();
                        return;
                    case -115:
                        int value = msg.reader().readInt();
                        byte[] data8 = NinjaUtil.readByteArray(msg);
                        SmallImage.reciveImage(value, data8);
                        return;
                    case -114:
                        if (Char.clan == null) {
                            Char.clan = new Clan();
                        }
                        Char.clan.writeLog(msg.reader().readUTF());
                        return;
                    case -113:
                        if (Char.clan == null) {
                            Char.clan = new Clan();
                        }
                        Char.clan.name = msg.reader().readUTF();
                        Char.clan.main_name = msg.reader().readUTF();
                        msg.reader().readUTF();
                        Char.clan.total = msg.reader().readShort();
                        Char.clan.openDun = msg.reader().readByte();
                        Char.clan.level = msg.reader().readByte();
                        Char.clan.exp = msg.reader().readInt();
                        Char.clan.expNext = msg.reader().readInt();
                        Char.clan.coin = msg.reader().readInt();
                        Char.clan.freeCoin = msg.reader().readInt();
                        Char.clan.coinUp = msg.reader().readInt();
                        Char.clan.reg_date = msg.reader().readUTF();
                        Char.clan.alert = msg.reader().readUTF();
                        Char.clan.use_card = msg.reader().readInt();
                        Char.clan.itemLevel = msg.reader().readByte();
                        return;
                    case -112:
                        GameScr.vClan.removeAllElements();
                        short shortValue = msg.reader().readShort();
                        for (int index9 = 0; index9 < shortValue; index9++) {
                            GameScr.vClan.addElement(new Member(msg.reader().readByte(), msg.reader().readByte(), msg.reader().readByte(), msg.reader().readUTF(), msg.reader().readInt(), msg.reader().readBoolean()));
                        }
                        try {
                            for (int index10 = 0; index10 < shortValue; index10++) {
                                ((Member) GameScr.vClan.elementAt(index10)).pointClanWeek = msg.reader().readInt();
                            }
                        } catch (Exception exception52) {
                        }
                        GameScr.gI();
                        GameScr.sortClan();
                        return;
                    case -111:
                        Char.clan.items = new Item[30];
                        byte byteValue11 = msg.reader().readByte();
                        for (int index12 = 0; index12 < byteValue11; index12++) {
                            Char.clan.items[index12] = new Item();
                            Char.clan.items[index12].typeUI = 39;
                            Char.clan.items[index12].indexUI = index12;
                            Char.clan.items[index12].quantity = msg.reader().readShort();
                            Char.clan.items[index12].template = ItemTemplates.get(msg.reader().readShort());
                        }
                        GameScr.gI().clearVecThanThu();
                        byte byteValue13 = msg.reader().readByte();
                        for (int index14 = 0; index14 < byteValue13; index14++) {
                            String text = msg.reader().readUTF();
                            short shortValue15 = msg.reader().readShort();
                            short shortValue16 = msg.reader().readShort();
                            int value17 = msg.reader().readInt();
                            String text18 = "";
                            MyVector entries = new MyVector();
                            int value19 = -1;
                            int value20 = -1;
                            byte byteValue21 = msg.reader().readByte();
                            if (value17 >= 0) {
                                text18 = msg.reader().readUTF();
                            } else {
                                for (int index22 = 0; index22 < byteValue21; index22++) {
                                    String text23 = msg.reader().readUTF();
                                    entries.addElement(text23);
                                }
                                value19 = msg.reader().readInt();
                                value20 = msg.reader().readInt();
                            }
                            byte byteValue24 = msg.reader().readByte();
                            GameScr.gI().addInfo_ThanThu(new Clan_ThanThu(text, byteValue24, shortValue15, shortValue16, value17, text18, entries, value19, value20));
                        }
                        return;
                    case -109:
                        try {
                            boolean flag = false;
                            GameCanvas.isLoading = true;
                            TileMap.maps = null;
                            TileMap.types = null;
                            System.gc();
                            TileMap.tmw = msg.reader().readByte();
                            TileMap.tmh = msg.reader().readByte();
                            TileMap.maps = new char[TileMap.tmw * TileMap.tmh];
                            for (int index25 = 0; index25 < TileMap.maps.length; index25++) {
                                short shortValue26;
                                if ((shortValue26 = msg.reader().readByte()) < 0) {
                                    shortValue26 += 256;
                                }
                                TileMap.maps[index25] = (char) shortValue26;
                            }
                            TileMap.types = new int[TileMap.maps.length];
                            msg = this.messWait;
                            this.loadInfoMap(msg);
                        } catch (Exception exception53) {
                            exception53.printStackTrace();
                        }
                        msg.cleanup();
                        this.messWait.cleanup();
                        msg = this.messWait = null;
                        return;
                    case -108:
                        short shortValue27 = msg.reader().readShort();
                        try {
                            byte byteValue28 = msg.reader().readByte();
                            Mob.arrMobTemplate[shortValue27].typeFly = byteValue28;
                        } catch (Exception exception54) {
                        }
                        byte byteValue29 = msg.reader().readByte();
                        Mob.arrMobTemplate[shortValue27].imgs = new Image[byteValue29];
                        if (shortValue27 != 98 && shortValue27 != 99) {
                            for (int index30 = 0; index30 < Mob.arrMobTemplate[shortValue27].imgs.length; index30++) {
                                Mob.arrMobTemplate[shortValue27].imgs[index30] = createImage(NinjaUtil.readByteArray(msg));
                            }
                        } else {
                            Mob.arrMobTemplate[shortValue27].imgs = new Image[3];
                            Image image = createImage(NinjaUtil.readByteArray(msg));
                            for (int index31 = 0; index31 < Mob.arrMobTemplate[shortValue27].imgs.length; index31++) {
                                Mob.arrMobTemplate[shortValue27].imgs[index31] = image;
                            }
                        }
                        if (msg.reader().readBoolean()) {
                            byteValue29 = msg.reader().readByte();
                            Mob.arrMobTemplate[shortValue27].frameBossMove = new byte[byteValue29];
                            for (int index32 = 0; index32 < byteValue29; index32++) {
                                Mob.arrMobTemplate[shortValue27].frameBossMove[index32] = msg.reader().readByte();
                            }
                            byteValue29 = msg.reader().readByte();
                            Mob.arrMobTemplate[shortValue27].frameBossAttack = new byte[byteValue29][];
                            for (int index33 = 0; index33 < byteValue29; index33++) {
                                Mob.arrMobTemplate[shortValue27].frameBossAttack[index33] = new byte[msg.reader().readByte()];
                                for (int index34 = 0; index34 < Mob.arrMobTemplate[shortValue27].frameBossAttack[index33].length; index34++) {
                                    Mob.arrMobTemplate[shortValue27].frameBossAttack[index33][index34] = msg.reader().readByte();
                                }
                            }
                        }
                        if (msg.reader().readInt() > 0) {
                            if (shortValue27 < 236) {
                                readDataMobOld(msg, shortValue27);
                            } else {
                                readDataMobNew(msg, shortValue27);
                            }
                            return;
                        }
                        return;
                    case -106:
                        GameScr.typeActive = msg.reader().readByte();
                        return;
                    case -99:
                        GameCanvas.input2Dlg.setTitle(mResources.SERI_NUM, mResources.CARD_CODE);
                        String text35 = msg.reader().readUTF();
                        GameCanvas.input2Dlg.show(text35, new Command(mResources.CLOSE, GameCanvas.instance, 8882, null), new Command(mResources.CHARGE, GameCanvas.instance, 88816, null), 0, 1);
                        return;
                    case -98:
                        Char.getMyChar();
                        Char.clearTask();
                        return;
                    case -97:
                        GameCanvas.isLoading = false;
                        GameCanvas.endDlg();
                        Integer boxedValue = new Integer(msg.reader().readInt());
                        GameCanvas.inputDlg.show(mResources.NAME_CHANGE, new Command(mResources.OK, GameCanvas.instance, 88829, boxedValue), 0);
                        return;
                    case -96:
                        Char.getMyChar().cClanName = msg.reader().readUTF();
                        Char.getMyChar().ctypeClan = 4;
                        Char.getMyChar().luong = msg.reader().readInt();
                        Char.getMyChar().callEffTask(21);
                        return;
                    case -95:
                        if (Char.clan != null) {
                            Char.clan.alert = msg.reader().readUTF();
                        }
                        return;
                    case -93:
                        int value36;
                        if ((value36 = msg.reader().readInt()) == Char.getMyChar().charID) {
                            GameScr.vClan.removeAllElements();
                            Char.getMyChar().cClanName = "";
                            Char.getMyChar().ctypeClan = -1;
                            Char.clan = null;
                        } else {
                            GameScr.vClan.removeAllElements();
                            Char character;
                            (character = GameScr.findCharInMap(value36)).cClanName = "";
                            character.ctypeClan = -1;
                        }
                        return;
                    case -90:
                        Char.getMyChar().xu = msg.reader().readInt();
                        GameScr.gI().resetButton();
                        return;
                    case -88:
                        GameScr.gI().resetButton();
                        Item item;
                        (item = Char.getMyChar().arrItemBag[msg.reader().readByte()]).clearExpire();
                        item.isLock = true;
                        item.upgrade = msg.reader().readByte();
                        Item item37;
                        (item37 = Char.getMyChar().arrItemBag[msg.reader().readByte()]).clearExpire();
                        item37.isLock = true;
                        item37.upgrade = msg.reader().readByte();
                        Info.addInfo(mResources.CONVERT_OK, 20, mFont.tahoma_7b_yellow);
                        return;
                    case -86:
                        GameCanvas.endDlg();
                        GameScr.gI().resetButton();
                        InfoMe.addInfo(msg.reader().readUTF(), 20, mFont.tahoma_7_yellow);
                        return;
                    case -84:
                        Char.pointPB = msg.reader().readShort();
                        return;
                    case -83:
                        short shortValue38 = msg.reader().readShort();
                        short shortValue39 = msg.reader().readShort();
                        byte byteValue40 = msg.reader().readByte();
                        short shortValue41 = msg.reader().readShort();
                        if (shortValue38 == 0) {
                            GameScr.gI().showAlert(mResources.REVIEW, "          " + mResources.EMPTY_INFO, false);
                        } else {
                            String text42 = mResources.PROPERTY + ": " + shortValue38 + "\n\n";
                            if (shortValue39 == 0) {
                                text42 = text42 + mResources.NOT_FINISH + "\n\n";
                            } else {
                                text42 = text42 + mResources.TIME_FINISH + ": " + NinjaUtil.getTime(shortValue39) + "\n\n";
                            }
                            text42 = text42 + mResources.TEAMWORK + ": " + byteValue40 + "\n\n";
                            text42 = text42 + mResources.REWARD + ": " + shortValue41 + " " + mResources.LUCKY_GIFT + "\n\n";
                            GameScr.gI().showAlert(mResources.REVIEW, text42, false);
                            if (shortValue41 > 0) {
                                GameScr.gI().left = new Command(mResources.REWARD, 1000);
                                return;
                            }
                        }
                        return;
                    case -81:
                        Char.pointChienTruong = msg.reader().readShort();
                        return;
                    case -80:
                        GameScr.gI().showAlert(mResources.RESULT, msg.reader().readUTF(), false);
                        if (msg.reader().readBoolean()) {
                            GameScr.gI().left = new Command(mResources.REWARD, 2000);
                        }
                        return;
                    case -77:
                        GameCanvas.loadBG(TileMap.bgID = msg.reader().readByte());
                        return;
                    case -72:
                        GameScr.gI().yenValue = new String[9];
                        GameScr.arrItemSprin = new short[9];
                        if (GameScr.indexSelect < 0 || GameScr.indexSelect > 8) {
                            GameScr.indexCard = 0;
                            GameScr.indexSelect = 0;
                        }
                        for (int index43 = 0; index43 < 9; index43++) {
                            GameScr.arrItemSprin[index43] = msg.reader().readShort();
                            GameScr.gI().yenValue[index43] = GameScr.gI().YenCards[NinjaUtil.randomNumber(9)];
                        }
                        GameScr.gI().left = new Command(mResources.CONTINUE, null, 1506, null);
                        GameScr.gI().timePoint = System.currentTimeMillis();
                        GameScr.gI().numSprinLeft--;
                        GameCanvas.endDlg();
                        return;
                    case -70:
                        String text44 = msg.reader().readUTF();
                        GameCanvas.startYesNoDlg(NinjaUtil.replace(mResources.INVITE_TO_CBT, "#", text44), new Command(mResources.YES, GameCanvas.instance, 88842, null), new Command(mResources.NO, GameCanvas.instance, 8882, null));
                        return;
                    case -67:
                        Mob mob = null;
                        try {
                            mob = Mob.get_Mob(msg.reader().readUnsignedByte());
                        } catch (Exception exception55) {
                        }
                        if (mob != null) {
                            int value45;
                            if ((value45 = msg.reader().readInt()) == Char.getMyChar().charID) {
                                GameScr.vMobSoul.addElement(new MobSoul(mob.x, mob.y, Char.getMyChar()));
                            } else {
                                Char character46;
                                if ((character46 = GameScr.findCharInMap(value45)) != null) {
                                    GameScr.vMobSoul.addElement(new MobSoul(mob.x, mob.y, character46));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    case -66:
                        int value47 = msg.reader().readInt();
                        if (Char.getMyChar().charID == value47) {
                            GameScr.vMobSoul.addElement(new MobSoul(Char.getMyChar().cx, Char.getMyChar().cy));
                        } else {
                            Char character48;
                            if ((character48 = GameScr.findCharInMap(value47)) != null) {
                                GameScr.vMobSoul.addElement(new MobSoul(character48.cx, character48.cy));
                                return;
                            }
                        }
                        return;
                    case -62:
                        Char.clan.itemLevel = msg.reader().readByte();
                        return;
                    case -59:
                        GameMidlet.instance.sendGPS();
                }
            } catch (Exception exception56) {
            }
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    private static void messageNotLogin(Message msg) {
        try {
            switch(msg.reader().readByte()) {
                case -124:
                    System.out.println("SEND SMS");
                    String text = msg.reader().readUTF();
                    SMS.sendSMS(msg.reader().readUTF(), "sms://" + text, new Command("", GameCanvas.gI(), 88825, null), new Command("", GameCanvas.gI(), 88826, null));
                    break;
                case 2:
                    RMS.clearRMS();
            }
        } catch (Exception exception) {
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    private void messageSubCommand(Message msg) {
        try {
            try {
                byte byteValue = msg.reader().readByte();
                int value = 0;
                switch(byteValue) {
                    case -128:
                        Char character;
                        if ((character = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            character.cHP = msg.reader().readInt();
                            character.cMaxHP = msg.reader().readInt();
                            character.clevel = msg.reader().readUnsignedByte();
                            return;
                        }
                        return;
                    case -127:
                        GameScr.vCharInMap.removeAllElements();
                        GameScr.vItemMap.removeAllElements();
                        GameScr.loadImg();
                        GameScr.currentCharViewInfo = Char.getMyChar();
                        Char.getMyChar().charID = msg.reader().readInt();
                        Char.getMyChar().cClanName = msg.reader().readUTF();
                        if (!Char.getMyChar().cClanName.equals("")) {
                            Char.getMyChar().ctypeClan = msg.reader().readByte();
                        }
                        Char.getMyChar().ctaskId = msg.reader().readByte();
                        Char.getMyChar().cgender = msg.reader().readByte();
                        Char.getMyChar().head = msg.reader().readShort();
                        Char.getMyChar().cspeed = msg.reader().readByte();
                        Char.getMyChar().cName = msg.reader().readUTF();
                        Char.getMyChar().cPk = msg.reader().readByte();
                        Char.getMyChar().cTypePk = msg.reader().readByte();
                        Char.getMyChar().cMaxHP = msg.reader().readInt();
                        Char.getMyChar().cHP = msg.reader().readInt();
                        Char.getMyChar().cMaxMP = msg.reader().readInt();
                        Char.getMyChar().cMP = msg.reader().readInt();
                        Char.getMyChar().cEXP = msg.reader().readLong();
                        Char.getMyChar().cExpDown = msg.reader().readLong();
                        GameScr.setLevel_Exp(Char.getMyChar().cEXP, true);
                        Char.getMyChar().eff5BuffHp = msg.reader().readShort();
                        Char.getMyChar().eff5BuffMp = msg.reader().readShort();
                        Char.getMyChar().nClass = GameScr.nClasss[msg.reader().readByte()];
                        Char.getMyChar().pPoint = msg.reader().readShort();
                        Char.getMyChar().potential[0] = msg.reader().readShort();
                        Char.getMyChar().potential[1] = msg.reader().readShort();
                        Char.getMyChar().potential[2] = msg.reader().readInt();
                        Char.getMyChar().potential[3] = msg.reader().readInt();
                        Char.getMyChar().sPoint = msg.reader().readShort();
                        Char.getMyChar().vSkill.removeAllElements();
                        Char.getMyChar().vSkillFight.removeAllElements();
                        value = msg.reader().readByte();
                        for (byte index = 0; index < value; index++) {
                            Skill skill = Skills.get(msg.reader().readShort());
                            if (Char.getMyChar().myskill == null) {
                                Char.getMyChar().myskill = skill;
                            }
                            Char.getMyChar().vSkill.addElement(skill);
                            if ((skill.template.type == 1 || skill.template.type == 4 || skill.template.type == 2 || skill.template.type == 3) && (skill.template.maxPoint == 0 || skill.template.maxPoint > 0 && skill.point > 0)) {
                                byte byteValue1 = skill.template.id;
                                Char.getMyChar();
                                if (byteValue1 == 0) {
                                    Service service = Service.gI();
                                    Char.getMyChar();
                                    service.selectSkill(0);
                                }
                                Char.getMyChar().vSkillFight.addElement(skill);
                            }
                        }
                        GameScr.gI();
                        GameScr.sortSkill();
                        Char.getMyChar().xu = msg.reader().readInt();
                        Char.getMyChar().yen = msg.reader().readInt();
                        Char.getMyChar().luong = msg.reader().readInt();
                        Char.getMyChar().arrItemBag = new Item[msg.reader().readUnsignedByte()];
                        GameScr.mpPotion = 0;
                        GameScr.hpPotion = 0;
                        for (int index2 = 0; index2 < Char.getMyChar().arrItemBag.length; index2++) {
                            short shortValue;
                            if ((shortValue = msg.reader().readShort()) != -1) {
                                Char.getMyChar().arrItemBag[index2] = new Item();
                                Char.getMyChar().arrItemBag[index2].typeUI = 3;
                                Char.getMyChar().arrItemBag[index2].indexUI = index2;
                                Char.getMyChar().arrItemBag[index2].template = ItemTemplates.get(shortValue);
                                Char.getMyChar().arrItemBag[index2].isLock = msg.reader().readBoolean();
                                if (Char.getMyChar().arrItemBag[index2].isTypeBody() || Char.getMyChar().arrItemBag[index2].isTypeMounts() || Char.getMyChar().arrItemBag[index2].isTypeNgocKham()) {
                                    Char.getMyChar().arrItemBag[index2].upgrade = msg.reader().readByte();
                                }
                                Char.getMyChar().arrItemBag[index2].isExpires = msg.reader().readBoolean();
                                Char.getMyChar().arrItemBag[index2].quantity = msg.reader().readUnsignedShort();
                                if (Char.getMyChar().arrItemBag[index2].template.type == 16) {
                                    GameScr.hpPotion = GameScr.hpPotion + Char.getMyChar().arrItemBag[index2].quantity;
                                }
                                if (Char.getMyChar().arrItemBag[index2].template.type == 17) {
                                    GameScr.mpPotion = GameScr.mpPotion + Char.getMyChar().arrItemBag[index2].quantity;
                                }
                                if (Char.getMyChar().arrItemBag[index2].template.id == 340) {
                                    GameScr gameScr = GameScr.gI();
                                    gameScr.numSprinLeft = gameScr.numSprinLeft + Char.getMyChar().arrItemBag[index2].quantity;
                                }
                            }
                        }
                        Char.getMyChar().arrItemBody = new Item[32];
                        try {
                            Char.getMyChar().setDefaultPart();
                            for (int index3 = 0; index3 < 16; index3++) {
                                short shortValue4;
                                if ((shortValue4 = msg.reader().readShort()) != -1) {
                                    ItemTemplate itemTemplate;
                                    byte byteValue5 = (itemTemplate = ItemTemplates.get(shortValue4)).type;
                                    Char.getMyChar().arrItemBody[byteValue5] = new Item();
                                    Char.getMyChar().arrItemBody[byteValue5].indexUI = byteValue5;
                                    Char.getMyChar().arrItemBody[byteValue5].typeUI = 5;
                                    Char.getMyChar().arrItemBody[byteValue5].template = itemTemplate;
                                    Char.getMyChar().arrItemBody[byteValue5].isLock = true;
                                    Char.getMyChar().arrItemBody[byteValue5].upgrade = msg.reader().readByte();
                                    Char.getMyChar().arrItemBody[byteValue5].sys = msg.reader().readByte();
                                    if (byteValue5 == 1) {
                                        Char.getMyChar().wp = Char.getMyChar().arrItemBody[byteValue5].template.part;
                                    } else if (byteValue5 == 2) {
                                        Char.getMyChar().body = Char.getMyChar().arrItemBody[byteValue5].template.part;
                                    } else if (byteValue5 == 6) {
                                        Char.getMyChar().leg = Char.getMyChar().arrItemBody[byteValue5].template.part;
                                    }
                                }
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                        Char.getMyChar().isHuman = msg.reader().readBoolean();
                        Char.getMyChar().isNhanban = msg.reader().readBoolean();
                        short[] values;
                        if ((values = new short[] { msg.reader().readShort(), msg.reader().readShort(), msg.reader().readShort(), msg.reader().readShort() })[0] > -1) {
                            Char.getMyChar().head = values[0];
                        }
                        if (values[1] > -1) {
                            Char.getMyChar().wp = values[1];
                        }
                        if (values[2] > -1) {
                            Char.getMyChar().body = values[2];
                        }
                        if (values[3] > -1) {
                            Char.getMyChar().leg = values[3];
                        }
                        short[] values6 = new short[10];
                        try {
                            for (int index7 = 0; index7 < 10; index7++) {
                                values6[index7] = msg.reader().readShort();
                            }
                        } catch (Exception exception103) {
                            values6 = null;
                        }
                        if (values6 != null) {
                            Char.getMyChar().setThoiTrang(values6);
                        }
                        try {
                            for (int index8 = 0; index8 < 16; index8++) {
                                short shortValue9;
                                if ((shortValue9 = msg.reader().readShort()) != -1) {
                                    ItemTemplate itemTemplate10;
                                    int value11 = (itemTemplate10 = ItemTemplates.get(shortValue9)).type + 16;
                                    Char.getMyChar().arrItemBody[value11] = new Item();
                                    Char.getMyChar().arrItemBody[value11].indexUI = value11;
                                    Char.getMyChar().arrItemBody[value11].typeUI = 5;
                                    Char.getMyChar().arrItemBody[value11].template = itemTemplate10;
                                    Char.getMyChar().arrItemBody[value11].isLock = true;
                                    Char.getMyChar().arrItemBody[value11].upgrade = msg.reader().readByte();
                                    Char.getMyChar().arrItemBody[value11].sys = msg.reader().readByte();
                                    if (value11 == 1) {
                                        Char.getMyChar().wp = Char.getMyChar().arrItemBody[value11].template.part;
                                    } else if (value11 == 2) {
                                        Char.getMyChar().body = Char.getMyChar().arrItemBody[value11].template.part;
                                    } else if (value11 == 6) {
                                        Char.getMyChar().leg = Char.getMyChar().arrItemBody[value11].template.part;
                                    }
                                }
                            }
                        } catch (Exception exception104) {
                            exception104.printStackTrace();
                        }
                        short shortValue12 = 0;
                        try {
                            shortValue12 = msg.reader().readShort();
                        } catch (Exception exception105) {
                            shortValue12 = -1;
                        }
                        Char.getMyChar().ID_SUSANO = shortValue12;
                        if (Char.getMyChar().isHuman) {
                            GameScr.gI();
                            GameScr.loadSkillShortcut();
                        } else if (Char.getMyChar().isNhanban) {
                            GameScr.gI();
                            GameScr.loadSkillShortcutNhanban();
                        }
                        Char.getMyChar().statusMe = 4;
                        GameScr.isViewClanInvite = RMS.loadRMSInt(Char.getMyChar().cName + "vci") >= 1;
                        if (Char.getMyChar().isHumanz()) {
                            createSkill(new DataInputStream(new ByteArrayInputStream(RMS.loadRMS("skill"))));
                        } else {
                            createSkill(new DataInputStream(new ByteArrayInputStream(RMS.loadRMS("skillnhanban"))));
                        }
                        Service.gI().loadRMS("KSkill");
                        Service.gI().loadRMS("OSkill");
                        Service.gI().loadRMS("CSkill");
                        return;
                    case -126:
                        Char.getMyChar().readParam(msg);
                        Char.getMyChar().potential[0] = msg.reader().readShort();
                        Char.getMyChar().potential[1] = msg.reader().readShort();
                        Char.getMyChar().potential[2] = msg.reader().readInt();
                        Char.getMyChar().potential[3] = msg.reader().readInt();
                        Char.getMyChar().callEffTask(61);
                        Char.getMyChar().nClass = GameScr.nClasss[msg.reader().readByte()];
                        Char.getMyChar().sPoint = msg.reader().readShort();
                        Char.getMyChar().pPoint = msg.reader().readShort();
                        Char.getMyChar().vSkill.removeAllElements();
                        Char.getMyChar().vSkillFight.removeAllElements();
                        Char.getMyChar().myskill = null;
                        return;
                    case -125:
                        Char.getMyChar().readParam(msg);
                        if (Char.getMyChar().statusMe != 14 && Char.getMyChar().statusMe != 5) {
                            Char.getMyChar().cHP = Char.getMyChar().cMaxHP;
                            Char.getMyChar().cMP = Char.getMyChar().cMaxMP;
                        }
                        try {
                            Char.getMyChar().sPoint = msg.reader().readShort();
                            Char.getMyChar().vSkill.removeAllElements();
                            Char.getMyChar().vSkillFight.removeAllElements();
                            byte byteValue13 = msg.reader().readByte();
                            for (byte index14 = 0; index14 < byteValue13; index14++) {
                                Skill skill15 = Skills.get(msg.reader().readShort());
                                if (Char.getMyChar().myskill == null) {
                                    Char.getMyChar().myskill = skill15;
                                } else if (skill15.template.equals(Char.getMyChar().myskill.template)) {
                                    Char.getMyChar().myskill = skill15;
                                }
                                Char.getMyChar().vSkill.addElement(skill15);
                                if ((skill15.template.type == 1 || skill15.template.type == 4 || skill15.template.type == 2 || skill15.template.type == 3) && (skill15.template.maxPoint == 0 || skill15.template.maxPoint > 0 && skill15.point > 0)) {
                                    byte byteValue16 = skill15.template.id;
                                    Char.getMyChar();
                                    if (byteValue16 == 0) {
                                        Service service17 = Service.gI();
                                        Char.getMyChar();
                                        service17.selectSkill(0);
                                    }
                                    Char.getMyChar().vSkillFight.addElement(skill15);
                                }
                            }
                            GameScr.gI();
                            GameScr.sortSkill();
                            if (GameScr.isPaintInfoMe) {
                                GameScr.indexRow = -1;
                                GameScr.gI().setLCR();
                                return;
                            }
                        } catch (Exception exception106) {
                            exception106.printStackTrace();
                        }
                        return;
                    case -124:
                        Char.getMyChar().readParam(msg);
                        Char.getMyChar().cEXP = msg.reader().readLong();
                        GameScr.setLevel_Exp(Char.getMyChar().cEXP, true);
                        Char.getMyChar().sPoint = msg.reader().readShort();
                        Char.getMyChar().pPoint = msg.reader().readShort();
                        Char.getMyChar().potential[0] = msg.reader().readShort();
                        Char.getMyChar().potential[1] = msg.reader().readShort();
                        Char.getMyChar().potential[2] = msg.reader().readInt();
                        Char.getMyChar().potential[3] = msg.reader().readInt();
                        return;
                    case -123:
                        Char.getMyChar().xu = msg.reader().readInt();
                        Char.getMyChar().yen = msg.reader().readInt();
                        Char.getMyChar().luong = msg.reader().readInt();
                        Char.getMyChar().cHP = msg.reader().readInt();
                        Char.getMyChar().cMP = msg.reader().readInt();
                        if (msg.reader().readByte() == 1) {
                            GameScr.gI().resetCaptcha();
                            Char.getMyChar().isCaptcha = true;
                        } else {
                            Char.getMyChar().isCaptcha = false;
                        }
                        return;
                    case -122:
                        Char.getMyChar().cHP = msg.reader().readInt();
                        return;
                    case -121:
                        Char.getMyChar().cMP = msg.reader().readInt();
                        return;
                    case -120:
                        Char character18;
                        if ((character18 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            readCharInfo(character18, msg);
                        }
                        return;
                    case -119:
                        Char character19;
                        if ((character19 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            character19.cHP = msg.reader().readInt();
                            character19.cMaxHP = msg.reader().readInt();
                            return;
                        }
                        return;
                    case -117:
                        Char character20;
                        if ((character20 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            character20.cHP = msg.reader().readInt();
                            character20.cMaxHP = msg.reader().readInt();
                            character20.eff5BuffHp = msg.reader().readShort();
                            character20.eff5BuffMp = msg.reader().readShort();
                            character20.wp = msg.reader().readShort();
                            if (character20.wp == -1) {
                                character20.setDefaultWeapon();
                            }
                            return;
                        }
                        return;
                    case -116:
                        Char character21;
                        if ((character21 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            character21.cHP = msg.reader().readInt();
                            character21.cMaxHP = msg.reader().readInt();
                            character21.eff5BuffHp = msg.reader().readShort();
                            character21.eff5BuffMp = msg.reader().readShort();
                            character21.body = msg.reader().readShort();
                            if (character21.body == -1) {
                                character21.setDefaultBody();
                            }
                            return;
                        }
                        return;
                    case -113:
                        Char character22;
                        if ((character22 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            character22.cHP = msg.reader().readInt();
                            character22.cMaxHP = msg.reader().readInt();
                            character22.eff5BuffHp = msg.reader().readShort();
                            character22.eff5BuffMp = msg.reader().readShort();
                            character22.leg = msg.reader().readShort();
                            if (character22.leg == -1) {
                                character22.setDefaultLeg();
                            }
                            return;
                        }
                        return;
                    case -112:
                        Char character23;
                        if ((character23 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            character23.cHP = msg.reader().readInt();
                            character23.cMaxHP = msg.reader().readInt();
                            character23.eff5BuffHp = msg.reader().readShort();
                            character23.eff5BuffMp = msg.reader().readShort();
                            return;
                        }
                        return;
                    case -111:
                        Char character24;
                        if ((character24 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            character24.cHP = msg.reader().readInt();
                            return;
                        }
                        return;
                    case -110:
                        Char character25;
                        if ((character25 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            character25.cHP = msg.reader().readInt();
                            character25.cMaxHP = msg.reader().readInt();
                            character25.cx = character25.cxMoveLast = msg.reader().readShort();
                            character25.cy = character25.cyMoveLast = msg.reader().readShort();
                            character25.statusMe = 1;
                            ServerEffect.addServerEffect(20, character25, 2);
                            return;
                        }
                        return;
                    case -109:
                        Char.getMyChar().readParam(msg);
                        if (Char.getMyChar().statusMe != 14 && Char.getMyChar().statusMe != 5) {
                            Char.getMyChar().cHP = Char.getMyChar().cMaxHP;
                            Char.getMyChar().cMP = Char.getMyChar().cMaxMP;
                        }
                        Char.getMyChar().pPoint = msg.reader().readShort();
                        Char.getMyChar().potential[0] = msg.reader().readShort();
                        Char.getMyChar().potential[1] = msg.reader().readShort();
                        Char.getMyChar().potential[2] = msg.reader().readInt();
                        Char.getMyChar().potential[3] = msg.reader().readInt();
                        return;
                    case -107:
                        Char.getMyChar().bagSort();
                        return;
                    case -106:
                        Char.getMyChar().boxSort();
                        return;
                    case -105:
                        int value26 = msg.reader().readInt();
                        Char.getMyChar().xu -= value26;
                        Char.getMyChar().xuInBox += value26;
                        return;
                    case -104:
                        int value27 = msg.reader().readInt();
                        Char.getMyChar().xuInBox -= value27;
                        Char.getMyChar().xu += value27;
                        return;
                    case -102:
                        Char.getMyChar().arrItemBag[msg.reader().readByte()] = null;
                        Skill skill28 = Skills.get(msg.reader().readShort());
                        Char.getMyChar().vSkill.addElement(skill28);
                        if ((skill28.template.type == 1 || skill28.template.type == 4 || skill28.template.type == 2 || skill28.template.type == 3) && (skill28.template.maxPoint == 0 || skill28.template.maxPoint > 0 && skill28.point > 0)) {
                            byte byteValue29 = skill28.template.id;
                            Char.getMyChar();
                            if (byteValue29 == 0) {
                                Service service30 = Service.gI();
                                Char.getMyChar();
                                service30.selectSkill(0);
                            }
                            Char.getMyChar().vSkillFight.addElement(skill28);
                        }
                        GameScr.gI();
                        GameScr.sortSkill();
                        GameScr.gI().addSkillShortcut(skill28);
                        GameScr.gI().setLCR();
                        InfoMe.addInfo(mResources.LEARN_SKILL + " " + skill28.template.name);
                        return;
                    case -101:
                        Effect effect = new Effect(msg.reader().readByte(), (int) (System.currentTimeMillis() / 1000L) - msg.reader().readInt(), msg.reader().readInt(), msg.reader().readShort());
                        Char.getMyChar().vEff.addElement(effect);
                        if (effect.template.type == 7) {
                            Char player = Char.getMyChar();
                            player.cMiss = (short) (player.cMiss + effect.param);
                            return;
                        } else if (effect.template.type == 12 || effect.template.type == 11) {
                            Char.getMyChar().isInvisible = true;
                            ServerEffect.addServerEffect(60, Char.getMyChar().cx, Char.getMyChar().cy, 1);
                            return;
                        } else if (effect.template.type == 14) {
                            GameCanvas.clearKeyPressed();
                            GameCanvas.clearKeyHold();
                            Char.getMyChar().cx = msg.reader().readShort();
                            Char.getMyChar().cy = msg.reader().readShort();
                            Char.getMyChar().statusMe = 1;
                            Char.getMyChar().isLockMove = true;
                            ServerEffect.addServerEffectWithTime(76, Char.getMyChar(), effect.timeLenght);
                            return;
                        } else if (effect.template.type == 1) {
                            ServerEffect.addServerEffectWithTime(48, Char.getMyChar(), effect.timeLenght);
                            return;
                        } else {
                            if (effect.template.type == 2) {
                                GameCanvas.clearKeyPressed();
                                GameCanvas.clearKeyHold();
                                Char.getMyChar().cx = msg.reader().readShort();
                                Char.getMyChar().cy = msg.reader().readShort();
                                Char.getMyChar().statusMe = 1;
                                Char.getMyChar().isLockMove = true;
                                Char.getMyChar().isLockAttack = true;
                            } else if (effect.template.type == 3) {
                                GameCanvas.clearKeyPressed();
                                GameCanvas.clearKeyHold();
                                Char.getMyChar().cx = msg.reader().readShort();
                                Char.getMyChar().cy = msg.reader().readShort();
                                Char.getMyChar().statusMe = 1;
                                Char.isLockKey = true;
                                ServerEffect.addServerEffectWithTime(43, Char.getMyChar(), effect.timeLenght);
                                return;
                            }
                            return;
                        }
                    case -100:
                        EffectTemplate effectTemplate = Effect.effTemplates[msg.reader().readByte()];
                        for (int index31 = 0; index31 < Char.getMyChar().vEff.size(); index31++) {
                            Effect effect32;
                            if ((effect32 = (Effect) Char.getMyChar().vEff.elementAt(index31)).template.type == effectTemplate.type) {
                                if (effect32.template.type == 7) {
                                    Char player33 = Char.getMyChar();
                                    player33.cMiss = (short) (player33.cMiss - effect32.param);
                                }
                                effect32.template = effectTemplate;
                                effect32.timeStart = (int) (System.currentTimeMillis() / 1000L) - msg.reader().readInt();
                                effect32.timeLenght = msg.reader().readInt() / 1000;
                                effect32.param = msg.reader().readShort();
                                if (effect32.template.type == 7) {
                                    Char player34 = Char.getMyChar();
                                    player34.cMiss = (short) (player34.cMiss + effect32.param);
                                }
                                break;
                            }
                        }
                        if (!GameScr.isPaintInfoMe) {
                            GameScr.gI().resetButton();
                        }
                        return;
                    case -99:
                        byte byteValue35 = msg.reader().readByte();
                        Effect effect36 = null;
                        for (int index37 = 0; index37 < Char.getMyChar().vEff.size(); index37++) {
                            if ((effect36 = (Effect) Char.getMyChar().vEff.elementAt(index37)).template.id == byteValue35) {
                                if (effect36.template.type == 7) {
                                    Char player38 = Char.getMyChar();
                                    player38.cMiss = (short) (player38.cMiss - effect36.param);
                                }
                                Char.getMyChar().vEff.removeElementAt(index37);
                                break;
                            }
                        }
                        if (effect36.template.type == 0 || effect36.template.type == 12) {
                            Char.getMyChar().cHP = msg.reader().readInt();
                            Char.getMyChar().cMP = msg.reader().readInt();
                            if (effect36.template.type == 0) {
                                InfoMe.addInfo(mResources.EFF_REMOVE);
                            } else if (effect36.template.type == 12) {
                                Char.getMyChar().isInvisible = false;
                                ServerEffect.addServerEffect(60, Char.getMyChar().cx, Char.getMyChar().cy, 1);
                                return;
                            }
                            return;
                        } else if (effect36.template.type == 4 || effect36.template.type == 13 || effect36.template.type == 17) {
                            Char.getMyChar().cHP = msg.reader().readInt();
                            return;
                        } else if (effect36.template.type == 23) {
                            Char.getMyChar().cHP = msg.reader().readInt();
                            Char.getMyChar().cMaxHP = msg.reader().readInt();
                            return;
                        } else if (effect36.template.type == 11) {
                            Char.getMyChar().isInvisible = false;
                            ServerEffect.addServerEffect(60, Char.getMyChar().cx, Char.getMyChar().cy, 1);
                            return;
                        } else if (effect36.template.type == 14) {
                            Char.getMyChar().isLockMove = false;
                            return;
                        } else {
                            if (effect36.template.type == 2) {
                                Char.getMyChar().isLockMove = false;
                                Char.getMyChar().isLockAttack = false;
                                ServerEffect.addServerEffect(77, Char.getMyChar().cx, Char.getMyChar().cy - 9, 1);
                            } else if (effect36.template.type == 3) {
                                Char.isLockKey = false;
                                return;
                            }
                            return;
                        }
                    case -98:
                        try {
                            Char character39;
                            if ((character39 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                                Effect effect40 = new Effect(msg.reader().readByte(), (int) (System.currentTimeMillis() / 1000L) - msg.reader().readInt(), msg.reader().readInt(), msg.reader().readShort());
                                character39.vEff.addElement(effect40);
                                if (effect40.template.type == 12 || effect40.template.type == 11) {
                                    character39.isInvisible = true;
                                    ServerEffect.addServerEffect(60, character39.cx, character39.cy, 1);
                                    return;
                                } else if (effect40.template.type == 14) {
                                    character39.cx = character39.cxMoveLast = msg.reader().readShort();
                                    character39.cy = character39.cyMoveLast = msg.reader().readShort();
                                    character39.statusMe = 1;
                                    ServerEffect.addServerEffectWithTime(76, character39, effect40.timeLenght);
                                    return;
                                } else if (effect40.template.type == 1) {
                                    ServerEffect.addServerEffectWithTime(48, character39, effect40.timeLenght);
                                    return;
                                } else {
                                    if (effect40.template.type == 2) {
                                        character39.cx = character39.cxMoveLast = msg.reader().readShort();
                                        character39.cy = character39.cyMoveLast = msg.reader().readShort();
                                        character39.statusMe = 1;
                                        character39.isLockAttack = true;
                                    } else if (effect40.template.type == 3) {
                                        character39.cx = character39.cxMoveLast = msg.reader().readShort();
                                        character39.cy = character39.cyMoveLast = msg.reader().readShort();
                                        character39.statusMe = 1;
                                        ServerEffect.addServerEffectWithTime(43, character39, effect40.timeLenght);
                                        return;
                                    }
                                    return;
                                }
                            }
                            return;
                        } catch (Exception exception107) {
                            return;
                        }
                    case -97:
                        try {
                            Char character41;
                            if ((character41 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                                EffectTemplate effectTemplate42 = Effect.effTemplates[msg.reader().readByte()];
                                for (int index43 = 0; index43 < character41.vEff.size(); index43++) {
                                    Effect effect44 = (Effect) character41.vEff.elementAt(index43);
                                    if (effectTemplate42.type == effectTemplate42.type) {
                                        effect44.template = effectTemplate42;
                                        effect44.timeStart = (int) (System.currentTimeMillis() / 1000L) - msg.reader().readInt();
                                        effect44.timeLenght = msg.reader().readInt() / 1000;
                                        effect44.param = msg.reader().readShort();
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        } catch (Exception exception108) {
                            return;
                        }
                    case -96:
                        Char character45;
                        if ((character45 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            byte byteValue46 = msg.reader().readByte();
                            Effect effect47 = null;
                            for (int index48 = 0; index48 < character45.vEff.size(); index48++) {
                                if ((effect47 = (Effect) character45.vEff.elementAt(index48)).template.id == byteValue46) {
                                    character45.vEff.removeElementAt(index48);
                                    break;
                                }
                            }
                            if (effect47 != null) {
                                if (effect47.template.type == 0) {
                                    character45.cHP = msg.reader().readInt();
                                    character45.cMP = msg.reader().readInt();
                                    return;
                                } else if (effect47.template.type == 11) {
                                    character45.cx = character45.cxMoveLast = msg.reader().readUnsignedShort();
                                    character45.cy = character45.cyMoveLast = msg.reader().readUnsignedShort();
                                    character45.isInvisible = false;
                                    ServerEffect.addServerEffect(60, character45.cx, character45.cy, 1);
                                    return;
                                } else if (effect47.template.type == 12) {
                                    character45.cHP = msg.reader().readInt();
                                    character45.cMP = msg.reader().readInt();
                                    character45.isInvisible = false;
                                    ServerEffect.addServerEffect(60, character45.cx, character45.cy, 1);
                                    return;
                                } else if (effect47.template.type == 4 || effect47.template.type == 13 || effect47.template.type == 17) {
                                    character45.cHP = msg.reader().readInt();
                                    return;
                                } else {
                                    if (effect47.template.type == 23) {
                                        Char.getMyChar().cHP = msg.reader().readInt();
                                        Char.getMyChar().cMaxHP = msg.reader().readInt();
                                    } else if (effect47.template.type == 2) {
                                        character45.isLockAttack = false;
                                        ServerEffect.addServerEffect(77, character45.cx, character45.cy - 9, 1);
                                        return;
                                    }
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    case -95:
                        GameScr.gI().timeLengthMap = msg.reader().readInt();
                        GameScr.gI().timeStartMap = (int) (System.currentTimeMillis() / 1000L);
                        return;
                    case -94:
                        byte byteValue49 = msg.reader().readByte();
                        Npc npc;
                        (npc = (Npc) GameScr.vNpc.elementAt(byteValue49)).statusMe = msg.reader().readByte();
                        if (npc.template.npcTemplateId == 31 && npc.statusMe == 15) {
                            GameScr.startLanterns(npc.cx, npc.cy);
                        }
                        return;
                    case -92:
                        int value50;
                        Char character51;
                        if ((value50 = msg.reader().readInt()) == Char.getMyChar().charID) {
                            character51 = Char.getMyChar();
                        } else {
                            character51 = GameScr.findCharInMap(value50);
                        }
                        if (character51 != null) {
                            character51.cTypePk = msg.reader().readByte();
                        }
                        return;
                    case -91:
                        Item[] values52 = new Item[msg.reader().readUnsignedByte()];
                        for (int index53 = 0; index53 < Char.getMyChar().arrItemBag.length; index53++) {
                            values52[index53] = Char.getMyChar().arrItemBag[index53];
                        }
                        Char.getMyChar().arrItemBag = values52;
                        Char.getMyChar().arrItemBag[msg.reader().readUnsignedByte()] = null;
                        InfoMe.addInfo(mResources.BAG_EXPANDED + " " + Char.getMyChar().arrItemBag.length + " " + mResources.CELL);
                        return;
                    case -90:
                        for (int index54 = 0; index54 < GameScr.vNpc.size(); index54++) {
                            Npc npc55;
                            if ((npc55 = (Npc) GameScr.vNpc.elementAt(index54)).statusMe == 15) {
                                npc55.statusMe = 1;
                                break;
                            }
                        }
                        byte byteValue56;
                        if ((byteValue56 = msg.reader().readByte()) == 1) {
                            InfoMe.addInfo(mResources.PROTECT_FAR, 20, mFont.tahoma_7_yellow);
                        } else if (byteValue56 == 2) {
                            InfoMe.addInfo(mResources.PROTECT_INJURE, 20, mFont.tahoma_7_yellow);
                            return;
                        }
                        return;
                    case -89:
                        GameCanvas.isLoading = false;
                        try {
                            InfoMe.addInfo(msg.reader().readUTF(), 20, mFont.tahoma_7_yellow);
                        } catch (Exception exception109) {
                        }
                        InfoDlg.hide();
                        GameCanvas.endDlg();
                        return;
                    case -87:
                        value = msg.reader().readByte();
                        Party party = (Party) GameScr.vParty.elementAt(value);
                        GameScr.vParty.setElementAt(GameScr.vParty.elementAt(0), value);
                        GameScr.vParty.setElementAt(party, 0);
                        GameScr.gI().refreshTeam();
                        InfoMe.addInfo(party.name + mResources.TEAMLEADER_CHANGE, 20, mFont.tahoma_7_yellow);
                        return;
                    case -86:
                        GameScr.vParty.removeAllElements();
                        GameScr.gI().refreshTeam();
                        InfoMe.addInfo(mResources.MOVEOUT_ME, 20, mFont.tahoma_7_yellow);
                        return;
                    case -85:
                        GameScr.vFriend.removeAllElements();
                        try {
                            while (true) {
                                GameScr.vFriend.addElement(new Friend(msg.reader().readUTF(), msg.reader().readByte()));
                            }
                        } catch (Exception exception110) {
                            for (int index57 = 0; index57 < GameScr.vFriendWait.size(); index57++) {
                                GameScr.vFriend.addElement(GameScr.vFriendWait.elementAt(index57));
                            }
                            GameScr.gI();
                            GameScr.sortList(0);
                            return;
                        }
                    case -84:
                        GameScr.vEnemies.removeAllElements();
                        try {
                            while (true) {
                                GameScr.vEnemies.addElement(new Friend(msg.reader().readUTF(), msg.reader().readByte()));
                            }
                        } catch (Exception exception111) {
                            GameScr.gI();
                            GameScr.sortList(1);
                            return;
                        }
                    case -83:
                        String text = msg.reader().readUTF();
                        for (int index58 = 0; index58 < GameScr.vFriend.size(); index58++) {
                            if (((Friend) GameScr.vFriend.elementAt(index58)).friendName.equals(text)) {
                                GameScr.indexRow = 0;
                                GameScr.vFriend.removeElementAt(index58);
                                GameScr.gI();
                                GameScr.actRemoveWaitAcceptFriend(text);
                                break;
                            }
                        }
                        if (GameScr.isPaintFriend) {
                            GameScr.gI();
                            GameScr.sortList(0);
                            GameScr.indexRow = 0;
                            GameScr.scrMain.clear();
                        }
                        return;
                    case -82:
                        String text59 = msg.reader().readUTF();
                        for (int index60 = 0; index60 < GameScr.vEnemies.size(); index60++) {
                            if (((Friend) GameScr.vEnemies.elementAt(index60)).friendName.equals(text59)) {
                                GameScr.indexRow = 0;
                                GameScr.vEnemies.removeElementAt(index60);
                                break;
                            }
                        }
                        GameScr.gI();
                        GameScr.sortList(1);
                        return;
                    case -81:
                        Char.getMyChar().cPk = msg.reader().readByte();
                        Char.getMyChar().charFocus = null;
                        return;
                    case -80:
                        Char.getMyChar().arrItemBody[msg.reader().readByte()] = null;
                        return;
                    case -78:
                        ServerEffect.addServerEffect(msg.reader().readShort(), Char.getMyChar().cx, Char.getMyChar().cy, 1);
                        return;
                    case -77:
                        try {
                            GameScr.vPtMap.removeAllElements();
                            while (true) {
                                GameScr.vPtMap.addElement(new Party(msg.reader().readByte(), msg.reader().readUnsignedByte(), msg.reader().readUTF(), msg.reader().readByte()));
                            }
                        } catch (Exception exception112) {
                            GameScr.gI().refreshFindTeam();
                            return;
                        }
                    case -76:
                        ((Party) GameScr.vParty.firstElement()).isLock = msg.reader().readBoolean();
                        return;
                    case -75:
                        Char.getMyChar().arrItemBox[msg.reader().readByte()] = null;
                        return;
                    case -74:
                        InfoDlg.showWait(msg.reader().readUTF());
                        return;
                    case -73:
                        Mob mob = Mob.get_Mob(msg.reader().readUnsignedByte());
                        ServerEffect.addServerEffect(67, mob.x, mob.y, 1);
                        return;
                    case -72:
                        Char.getMyChar().luong = msg.reader().readInt();
                        return;
                    case -71:
                        int value61 = msg.reader().readInt();
                        Char.getMyChar().luong += value61;
                        GameScr.startFlyText("+" + value61, Char.getMyChar().cx, Char.getMyChar().cy - Char.getMyChar().ch - 10, 0, -2, 6);
                        InfoMe.addInfo(mResources.RECEIVE + " " + value61 + " " + mResources.GOLD, 20, mFont.tahoma_7_yellow);
                        return;
                    case -69:
                        short shortValue62 = msg.reader().readShort();
                        value = msg.reader().readByte();
                        if (shortValue62 > 0) {
                            short shortValue63 = (short) Char.getMyChar().cx;
                            short shortValue64 = (short) (Char.getMyChar().cy - 40);
                            Char.getMyChar().mobMe = new Mob((short) -1, false, false, false, false, false, shortValue62, 1, 0, 0, 0, shortValue63, shortValue64, (byte) 4, (byte) 0, value != 0, false);
                            Char.getMyChar().mobMe.status = 5;
                        } else {
                            Char.getMyChar().mobMe = null;
                        }
                        return;
                    case -68:
                        Char character65;
                        if ((character65 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            short shortValue66 = msg.reader().readShort();
                            byte byteValue67 = msg.reader().readByte();
                            if (shortValue66 > 0) {
                                short shortValue68 = (short) character65.cx;
                                short shortValue69 = (short) (character65.cy - 40);
                                character65.mobMe = new Mob((short) -1, false, false, false, false, false, shortValue66, 1, 0, 0, 0, shortValue68, shortValue69, (byte) 4, (byte) 0, byteValue67 != 0, false);
                                character65.mobMe.status = 5;
                            } else {
                                character65.mobMe = null;
                            }
                            return;
                        }
                        return;
                    case -65:
                        String text70 = msg.reader().readUTF();
                        byte[] data = new byte[msg.reader().readInt()];
                        msg.reader().read(data);
                        if (data.length == 0) {
                            data = null;
                        }
                        try {
                            msg.reader().readByte();
                        } catch (Exception exception113) {
                            exception113.printStackTrace();
                        }
                        if (text70.equals("KSkill")) {
                            GameScr.gI().onKSkill(data);
                            return;
                        } else {
                            if (text70.equals("OSkill")) {
                                GameScr.gI().onOSkill(data);
                            } else if (text70.equals("CSkill")) {
                                GameScr.gI().onCSkill(data);
                                return;
                            }
                            return;
                        }
                    case -64:
                        Char character71;
                        if ((character71 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            character71.cHP = msg.reader().readInt();
                            character71.cMaxHP = msg.reader().readInt();
                            character71.eff5BuffHp = msg.reader().readShort();
                            character71.eff5BuffMp = msg.reader().readShort();
                            character71.head = msg.reader().readShort();
                            return;
                        }
                        return;
                    case -63:
                        Char character72;
                        Integer boxedValue;
                        if ((character72 = GameScr.findCharInMap((boxedValue = new Integer(msg.reader().readInt())).intValue())) != null) {
                            GameCanvas.startYesNoDlg(character72.cName + " " + mResources.replace(mResources.INVITECLAN, msg.reader().readUTF()), 88830, boxedValue, 88811, null);
                        }
                        return;
                    case -62:
                        int value73 = msg.reader().readInt();
                        if (Char.getMyChar().charID == value73) {
                            Char.getMyChar().cClanName = msg.reader().readUTF();
                            Char.getMyChar().ctypeClan = msg.reader().readByte();
                            Char.getMyChar().callEffTask(21);
                        } else {
                            Char character74;
                            (character74 = GameScr.findCharInMap(value73)).cClanName = msg.reader().readUTF();
                            character74.ctypeClan = msg.reader().readByte();
                        }
                        return;
                    case -61:
                        Char character75;
                        Integer boxedValue76;
                        if (GameScr.isViewClanInvite && (character75 = GameScr.findCharInMap((boxedValue76 = new Integer(msg.reader().readInt())).intValue())) != null) {
                            GameCanvas.startYesNoDlg(character75.cName + " " + mResources.PLEASECLAN, 88831, boxedValue76, 88811, null);
                        }
                        return;
                    case -59:
                        int value77;
                        Char character78;
                        if ((value77 = msg.reader().readInt()) == Char.getMyChar().charID) {
                            character78 = Char.getMyChar();
                        } else {
                            character78 = GameScr.findCharInMap(value77);
                        }
                        character78.cHP = msg.reader().readInt();
                        character78.cMaxHP = msg.reader().readInt();
                        return;
                    case -58:
                        GameScr.gI().resetButton();
                        GameCanvas.timeBallEffect = 70;
                        GameCanvas.isBallEffect = true;
                        ServerEffect.addServerEffect(119, GameScr.gW2 + GameScr.cmx, GameScr.gH2 + GameScr.cmy, 1);
                        return;
                    case -57:
                        GameCanvas.timeBallEffect = 40;
                        GameCanvas.isBallEffect = true;
                        return;
                    case -56:
                        Char character79;
                        if ((character79 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            character79.cHP = msg.reader().readInt();
                            character79.cMaxHP = msg.reader().readInt();
                            character79.coat = (short) msg.reader().readUnsignedShort();
                        }
                        return;
                    case -55:
                        Char character80;
                        if ((character80 = GameScr.findCharInMap(msg.reader().readInt())) != null) {
                            character80.cHP = msg.reader().readInt();
                            character80.cMaxHP = msg.reader().readInt();
                            character80.glove = (short) msg.reader().readUnsignedShort();
                        }
                        return;
                    case -54:
                        int value81 = msg.reader().readInt();
                        Char character82;
                        if (Char.getMyChar().charID == value81) {
                            character82 = Char.getMyChar();
                        } else {
                            character82 = GameScr.findCharInMap(value81);
                        }
                        if (character82 != null) {
                            character82.arrItemMounts = new Item[5];
                            character82.isNewMount = character82.isWolf = character82.isMoto = character82.isMotoBehind = false;
                            for (int index83 = 0; index83 < character82.arrItemMounts.length; index83++) {
                                short shortValue84;
                                if ((shortValue84 = msg.reader().readShort()) != -1) {
                                    character82.arrItemMounts[index83] = new Item();
                                    character82.arrItemMounts[index83].typeUI = 41;
                                    character82.arrItemMounts[index83].indexUI = index83;
                                    character82.arrItemMounts[index83].template = ItemTemplates.get(shortValue84);
                                    character82.arrItemMounts[index83].upgrade = msg.reader().readByte();
                                    character82.arrItemMounts[index83].expires = msg.reader().readLong();
                                    character82.arrItemMounts[index83].sys = msg.reader().readByte();
                                    character82.arrItemMounts[index83].isLock = true;
                                    if (index83 == 4) {
                                        if (character82.arrItemMounts[index83].template.id == 485 || character82.arrItemMounts[index83].template.id == 524) {
                                            character82.isMoto = true;
                                        } else if (character82.arrItemMounts[index83].template.id != 443 && character82.arrItemMounts[index83].template.id != 523) {
                                            character82.isNewMount = true;
                                            character82.GetNewMount();
                                        } else {
                                            character82.isWolf = true;
                                        }
                                    }
                                    byte byteValue85 = msg.reader().readByte();
                                    character82.arrItemMounts[index83].options = new MyVector();
                                    for (int index86 = 0; index86 < byteValue85; index86++) {
                                        character82.arrItemMounts[index83].options.addElement(new ItemOption(msg.reader().readUnsignedByte(), msg.reader().readInt()));
                                    }
                                }
                            }
                        }
                        return;
                    case 115:
                        GameScr.currentCharViewInfo = Char.getMyChar();
                        Char.getMyChar().lastNormalSkill = null;
                        Char.getMyChar().charID = msg.reader().readInt();
                        Char.getMyChar().cClanName = msg.reader().readUTF();
                        if (!Char.getMyChar().cClanName.equals("")) {
                            Char.getMyChar().ctypeClan = msg.reader().readByte();
                        }
                        Char.getMyChar().ctaskId = msg.reader().readByte();
                        Char.getMyChar().cgender = msg.reader().readByte();
                        Char.getMyChar().head = msg.reader().readShort();
                        Char.getMyChar().cspeed = msg.reader().readByte();
                        Char.getMyChar().cName = msg.reader().readUTF();
                        Char.getMyChar().cPk = msg.reader().readByte();
                        Char.getMyChar().cTypePk = msg.reader().readByte();
                        Char.getMyChar().cMaxHP = msg.reader().readInt();
                        Char.getMyChar().cHP = msg.reader().readInt();
                        Char.getMyChar().cMaxMP = msg.reader().readInt();
                        Char.getMyChar().cMP = msg.reader().readInt();
                        Char.getMyChar().cEXP = msg.reader().readLong();
                        Char.getMyChar().cExpDown = msg.reader().readLong();
                        GameScr.setLevel_Exp(Char.getMyChar().cEXP, true);
                        Char.getMyChar().eff5BuffHp = msg.reader().readShort();
                        Char.getMyChar().eff5BuffMp = msg.reader().readShort();
                        Char.getMyChar().nClass = GameScr.nClasss[msg.reader().readByte()];
                        Char.getMyChar().pPoint = msg.reader().readShort();
                        Char.getMyChar().potential[0] = msg.reader().readShort();
                        Char.getMyChar().potential[1] = msg.reader().readShort();
                        Char.getMyChar().potential[2] = msg.reader().readInt();
                        Char.getMyChar().potential[3] = msg.reader().readInt();
                        Char.getMyChar().sPoint = msg.reader().readShort();
                        Char.getMyChar().vSkill.removeAllElements();
                        Char.getMyChar().vSkillFight.removeAllElements();
                        value = msg.reader().readByte();
                        for (byte index87 = 0; index87 < value; index87++) {
                            Skill skill88 = Skills.get(msg.reader().readShort());
                            if (Char.getMyChar().myskill == null) {
                                Char.getMyChar().myskill = skill88;
                            }
                            Char.getMyChar().vSkill.addElement(skill88);
                            if ((skill88.template.type == 1 || skill88.template.type == 4 || skill88.template.type == 2 || skill88.template.type == 3) && (skill88.template.maxPoint == 0 || skill88.template.maxPoint > 0 && skill88.point > 0)) {
                                byte byteValue89 = skill88.template.id;
                                Char.getMyChar();
                                if (byteValue89 == 0) {
                                    Service service90 = Service.gI();
                                    Char.getMyChar();
                                    service90.selectSkill(0);
                                }
                                Char.getMyChar().vSkillFight.addElement(skill88);
                            }
                        }
                        GameScr.gI();
                        GameScr.sortSkill();
                        Char.getMyChar().xu = msg.reader().readInt();
                        Char.getMyChar().yen = msg.reader().readInt();
                        Char.getMyChar().luong = msg.reader().readInt();
                        Char.getMyChar().arrItemBag = new Item[msg.reader().readUnsignedByte()];
                        GameScr.mpPotion = 0;
                        GameScr.hpPotion = 0;
                        for (int index91 = 0; index91 < Char.getMyChar().arrItemBag.length; index91++) {
                            if ((value = msg.reader().readShort()) != -1) {
                                Char.getMyChar().arrItemBag[index91] = new Item();
                                Char.getMyChar().arrItemBag[index91].typeUI = 3;
                                Char.getMyChar().arrItemBag[index91].indexUI = index91;
                                Char.getMyChar().arrItemBag[index91].template = ItemTemplates.get((short) value);
                                Char.getMyChar().arrItemBag[index91].isLock = msg.reader().readBoolean();
                                if (Char.getMyChar().arrItemBag[index91].isTypeBody() || Char.getMyChar().arrItemBag[index91].isTypeMounts() || Char.getMyChar().arrItemBag[index91].isTypeNgocKham()) {
                                    Char.getMyChar().arrItemBag[index91].upgrade = msg.reader().readByte();
                                }
                                Char.getMyChar().arrItemBag[index91].isExpires = msg.reader().readBoolean();
                                Char.getMyChar().arrItemBag[index91].quantity = msg.reader().readUnsignedShort();
                                if (Char.getMyChar().arrItemBag[index91].template.type == 16) {
                                    GameScr.hpPotion = GameScr.hpPotion + Char.getMyChar().arrItemBag[index91].quantity;
                                }
                                if (Char.getMyChar().arrItemBag[index91].template.type == 17) {
                                    GameScr.mpPotion = GameScr.mpPotion + Char.getMyChar().arrItemBag[index91].quantity;
                                }
                                if (Char.getMyChar().arrItemBag[index91].template.id == 340) {
                                    GameScr gameScr92 = GameScr.gI();
                                    gameScr92.numSprinLeft = gameScr92.numSprinLeft + Char.getMyChar().arrItemBag[index91].quantity;
                                }
                            }
                        }
                        Char.getMyChar().arrItemBody = new Item[32];
                        try {
                            Char.getMyChar().setDefaultPart();
                            for (int index93 = 0; index93 < 16; index93++) {
                                if ((value = msg.reader().readShort()) != -1) {
                                    ItemTemplate itemTemplate94;
                                    byte byteValue95 = (itemTemplate94 = ItemTemplates.get((short) value)).type;
                                    Char.getMyChar().arrItemBody[byteValue95] = new Item();
                                    Char.getMyChar().arrItemBody[byteValue95].indexUI = byteValue95;
                                    Char.getMyChar().arrItemBody[byteValue95].typeUI = 5;
                                    Char.getMyChar().arrItemBody[byteValue95].template = itemTemplate94;
                                    Char.getMyChar().arrItemBody[byteValue95].isLock = true;
                                    Char.getMyChar().arrItemBody[byteValue95].upgrade = msg.reader().readByte();
                                    Char.getMyChar().arrItemBody[byteValue95].sys = msg.reader().readByte();
                                    if (byteValue95 == 1) {
                                        Char.getMyChar().wp = Char.getMyChar().arrItemBody[byteValue95].template.part;
                                    } else if (byteValue95 == 2) {
                                        Char.getMyChar().body = Char.getMyChar().arrItemBody[byteValue95].template.part;
                                    } else if (byteValue95 == 6) {
                                        Char.getMyChar().leg = Char.getMyChar().arrItemBody[byteValue95].template.part;
                                    }
                                }
                            }
                        } catch (Exception exception114) {
                            exception114.printStackTrace();
                        }
                        Char.getMyChar().isHuman = msg.reader().readBoolean();
                        Char.getMyChar().isNhanban = msg.reader().readBoolean();
                        short[] values96;
                        if ((values96 = new short[] { msg.reader().readShort(), msg.reader().readShort(), msg.reader().readShort(), msg.reader().readShort() })[0] > -1) {
                            Char.getMyChar().head = values96[0];
                        }
                        if (values96[1] > -1) {
                            Char.getMyChar().wp = values96[1];
                        }
                        if (values96[2] > -1) {
                            Char.getMyChar().body = values96[2];
                        }
                        if (values96[3] > -1) {
                            Char.getMyChar().leg = values96[3];
                        }
                        short[] values97 = new short[10];
                        try {
                            for (int index98 = 0; index98 < 10; index98++) {
                                values97[index98] = msg.reader().readShort();
                            }
                        } catch (Exception exception115) {
                            values97 = null;
                        }
                        if (values97 != null) {
                            Char.getMyChar().setThoiTrang(values97);
                        }
                        GameScr.gI();
                        GameScr.sortSkill();
                        if (Char.getMyChar().isHuman) {
                            GameScr.gI();
                            GameScr.loadSkillShortcut();
                        } else if (Char.getMyChar().isNhanban) {
                            GameScr.gI();
                            GameScr.loadSkillShortcutNhanban();
                        }
                        Char.getMyChar().statusMe = 4;
                        GameScr.isViewClanInvite = RMS.loadRMSInt(Char.getMyChar().cName + "vci") >= 1;
                        Service.gI().loadRMS("KSkill");
                        Service.gI().loadRMS("OSkill");
                        Service.gI().loadRMS("CSkill");
                        try {
                            for (int index99 = 0; index99 < 16; index99++) {
                                short shortValue100;
                                if ((shortValue100 = msg.reader().readShort()) != -1) {
                                    ItemTemplate itemTemplate101;
                                    value = (itemTemplate101 = ItemTemplates.get(shortValue100)).type + 16;
                                    Char.getMyChar().arrItemBody[value] = new Item();
                                    Char.getMyChar().arrItemBody[value].indexUI = value;
                                    Char.getMyChar().arrItemBody[value].typeUI = 5;
                                    Char.getMyChar().arrItemBody[value].template = itemTemplate101;
                                    Char.getMyChar().arrItemBody[value].isLock = true;
                                    Char.getMyChar().arrItemBody[value].upgrade = msg.reader().readByte();
                                    Char.getMyChar().arrItemBody[value].sys = msg.reader().readByte();
                                    if (value == 1) {
                                        Char.getMyChar().wp = Char.getMyChar().arrItemBody[value].template.part;
                                    } else if (value == 2) {
                                        Char.getMyChar().body = Char.getMyChar().arrItemBody[value].template.part;
                                    } else if (value == 6) {
                                        Char.getMyChar().leg = Char.getMyChar().arrItemBody[value].template.part;
                                    }
                                }
                            }
                        } catch (Exception exception116) {
                            exception116.printStackTrace();
                        }
                        short shortValue102 = 0;
                        try {
                            shortValue102 = msg.reader().readShort();
                        } catch (Exception exception117) {
                            shortValue102 = -1;
                        }
                        Char.getMyChar().ID_SUSANO = shortValue102;
                        return;
                }
            } catch (Exception exception118) {
            }
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    private static boolean readCharInfo(Char c, Message msg) {
        try {
            c.cClanName = msg.reader().readUTF();
            if (!c.cClanName.equals("")) {
                c.ctypeClan = msg.reader().readByte();
            }
            c.isInvisible = msg.reader().readBoolean();
            c.cTypePk = msg.reader().readByte();
            c.nClass = GameScr.nClasss[msg.reader().readByte()];
            c.cgender = msg.reader().readByte();
            c.head = msg.reader().readShort();
            c.cName = msg.reader().readUTF();
            c.cHP = msg.reader().readInt();
            c.cMaxHP = msg.reader().readInt();
            c.clevel = msg.reader().readUnsignedByte();
            c.wp = msg.reader().readShort();
            c.body = msg.reader().readShort();
            c.leg = msg.reader().readShort();
            byte byteValue = msg.reader().readByte();
            if (c.wp == -1) {
                c.setDefaultWeapon();
            }
            if (c.body == -1) {
                c.setDefaultBody();
            }
            if (c.leg == -1) {
                c.setDefaultLeg();
            }
            if (byteValue == -1) {
                c.mobMe = null;
            } else {
                short shortValue = (short) c.cx;
                short shortValue1 = (short) (c.cy - 40);
                c.mobMe = new Mob((short) -1, false, false, false, false, false, byteValue, 1, 0, 0, 0, shortValue, shortValue1, (byte) 4, (byte) 0, false, false);
                c.mobMe.status = 5;
            }
            c.cx = c.cxMoveLast = msg.reader().readShort();
            c.cy = c.cyMoveLast = msg.reader().readShort();
            c.eff5BuffHp = msg.reader().readShort();
            c.eff5BuffMp = msg.reader().readShort();
            byte byteValue2 = msg.reader().readByte();
            for (int index = 0; index < byteValue2; index++) {
                Effect effect = new Effect(msg.reader().readByte(), msg.reader().readInt(), msg.reader().readInt(), msg.reader().readShort());
                c.vEff.addElement(effect);
                if (effect.template.type == 12 || effect.template.type == 11) {
                    c.isInvisible = true;
                }
            }
            if (!c.isInvisible) {
                ServerEffect.addServerEffect(60, c, 1);
            }
            if (c.cHP == 0) {
                c.statusMe = 14;
                if (Char.getMyChar().charID == c.charID) {
                    GameScr.gI().resetButton();
                }
            }
            if (c.charID == -Char.getMyChar().charID) {
                for (int index3 = 0; index3 < GameScr.vNpc.size(); index3++) {
                    Npc npc;
                    if ((npc = (Npc) GameScr.vNpc.elementAt(index3)).template.name.equals(c.cName)) {
                        Npc npc4;
                        (npc4 = npc).statusMe = 15;
                        npc4.chatPopup = null;
                        break;
                    }
                }
            }
            c.isHuman = msg.reader().readBoolean();
            c.isNhanban = msg.reader().readBoolean();
            if (c.isNhanbanz()) {
                ServerEffect.addServerEffect(141, c.cx, c.cy, 0);
            }
            short[] values;
            if ((values = new short[] { msg.reader().readShort(), msg.reader().readShort(), msg.reader().readShort(), msg.reader().readShort() })[0] > -1) {
                c.head = values[0];
            }
            if (values[1] > -1) {
                c.wp = values[1];
            }
            if (values[2] > -1) {
                c.body = values[2];
            }
            if (values[3] > -1) {
                c.leg = values[3];
            }
            short[] values5 = new short[10];
            try {
                for (int index6 = 0; index6 < 10; index6++) {
                    values5[index6] = msg.reader().readShort();
                }
            } catch (Exception exception) {
            }
            c.setThoiTrang(values5);
            short shortValue7 = 0;
            try {
                shortValue7 = msg.reader().readShort();
            } catch (Exception exception9) {
                shortValue7 = -1;
            }
            c.ID_SUSANO = shortValue7;
            Char character = c;
            for (int index8 = 0; index8 < GameScr.vParty.size(); index8++) {
                Party party;
                if ((party = (Party) GameScr.vParty.elementAt(index8)).charId == character.charID) {
                    party.c = character;
                    break;
                }
            }
            return true;
        } catch (Exception exception10) {
            return false;
        }
    }

    private static void requestItemInfo(Message msg) {
        try {
            byte byteValue;
            Item item;
            byteValue = msg.reader().readByte();
            int unsignedByte = msg.reader().readUnsignedByte();
            item = null;
            label186: switch(byteValue) {
                case 2:
                    item = GameScr.arrItemWeapon[unsignedByte];
                    break;
                case 3:
                    if ((item = Char.getMyChar().arrItemBag[unsignedByte]) != null) {
                        break;
                    }
                    if (GameScr.itemSplit != null && GameScr.itemSplit.indexUI == unsignedByte) {
                        item = GameScr.itemSplit;
                    }
                    if (GameScr.itemUpGrade != null && GameScr.itemUpGrade.indexUI == unsignedByte) {
                        item = GameScr.itemUpGrade;
                    }
                    if (GameScr.itemSell != null && GameScr.itemSell.indexUI == unsignedByte) {
                        item = GameScr.itemSell;
                    }
                    if (item == null && GameScr.arrItemUpGrade != null) {
                        for (int index = 0; index < GameScr.arrItemUpGrade.length; index++) {
                            if (GameScr.arrItemUpGrade[index] != null && GameScr.arrItemUpGrade[index].indexUI == unsignedByte) {
                                item = GameScr.arrItemUpGrade[index];
                                break;
                            }
                        }
                    }
                    if (item == null && GameScr.arrItemConvert != null) {
                        for (int index1 = 0; index1 < GameScr.arrItemConvert.length; index1++) {
                            if (GameScr.arrItemConvert[index1] != null && GameScr.arrItemConvert[index1].indexUI == unsignedByte) {
                                item = GameScr.arrItemConvert[index1];
                                break;
                            }
                        }
                    }
                    if (item == null && GameScr.arrItemUpPeal != null) {
                        for (int index2 = 0; index2 < GameScr.arrItemUpPeal.length; index2++) {
                            if (GameScr.arrItemUpPeal[index2] != null && GameScr.arrItemUpPeal[index2].indexUI == unsignedByte) {
                                item = GameScr.arrItemUpPeal[index2];
                                break;
                            }
                        }
                    }
                    if (item == null && GameScr.arrItemTradeMe != null) {
                        for (int index3 = 0; index3 < GameScr.arrItemTradeMe.length; index3++) {
                            if (GameScr.arrItemTradeMe[index3] != null && GameScr.arrItemTradeMe[index3].indexUI == unsignedByte) {
                                item = GameScr.arrItemTradeMe[index3];
                                break;
                            }
                        }
                    }
                    if (item == null && GameScr.arrItemSplit != null) {
                        for (int index4 = 0; index4 < GameScr.arrItemSplit.length; index4++) {
                            if (GameScr.arrItemSplit[index4] != null && GameScr.arrItemSplit[index4].indexUI == unsignedByte) {
                                item = GameScr.arrItemSplit[index4];
                                break label186;
                            }
                        }
                    }
                    break;
                case 4:
                    item = Char.getMyChar().arrItemBox[unsignedByte];
                    break;
                case 5:
                    item = Char.getMyChar().arrItemBody[unsignedByte];
                    break;
                case 6:
                    item = GameScr.arrItemStack[unsignedByte];
                    break;
                case 7:
                    item = GameScr.arrItemStackLock[unsignedByte];
                    break;
                case 8:
                    item = GameScr.arrItemGrocery[unsignedByte];
                    break;
                case 9:
                    item = GameScr.arrItemGroceryLock[unsignedByte];
                case 10:
                case 11:
                case 12:
                case 13:
                case 31:
                case 33:
                case 36:
                case 37:
                case 38:
                default:
                    break;
                case 14:
                    item = GameScr.arrItemStore[unsignedByte];
                    break;
                case 15:
                    item = GameScr.arrItemBook[unsignedByte];
                    break;
                case 16:
                    item = GameScr.arrItemLien[unsignedByte];
                    break;
                case 17:
                    item = GameScr.arrItemNhan[unsignedByte];
                    break;
                case 18:
                    item = GameScr.arrItemNgocBoi[unsignedByte];
                    break;
                case 19:
                    item = GameScr.arrItemPhu[unsignedByte];
                    break;
                case 20:
                    item = GameScr.arrItemNonNam[unsignedByte];
                    break;
                case 21:
                    item = GameScr.arrItemNonNu[unsignedByte];
                    break;
                case 22:
                    item = GameScr.arrItemAoNam[unsignedByte];
                    break;
                case 23:
                    item = GameScr.arrItemAoNu[unsignedByte];
                    break;
                case 24:
                    item = GameScr.arrItemGangTayNam[unsignedByte];
                    break;
                case 25:
                    item = GameScr.arrItemGangTayNu[unsignedByte];
                    break;
                case 26:
                    item = GameScr.arrItemQuanNam[unsignedByte];
                    break;
                case 27:
                    item = GameScr.arrItemQuanNu[unsignedByte];
                    break;
                case 28:
                    item = GameScr.arrItemGiayNam[unsignedByte];
                    break;
                case 29:
                    item = GameScr.arrItemGiayNu[unsignedByte];
                    break;
                case 30:
                    item = GameScr.arrItemTradeOrder[unsignedByte];
                    break;
                case 32:
                    item = GameScr.arrItemFashion[unsignedByte];
                    break;
                case 34:
                    item = GameScr.arrItemClanShop[unsignedByte];
                    break;
                case 35:
                    item = GameScr.arrItemElites[unsignedByte];
                    break;
                case 39:
                    item = Char.clan.items[GameScr.indexSelect];
            }
            item.expires = msg.reader().readLong();
            if (item.isTypeUIMe()) {
                item.saleCoinLock = msg.reader().readInt();
            } else if (item.isTypeUIShop() || item.isTypeUIShopLock() || item.isTypeUIStore() || item.isTypeUIBook() || item.isTypeUIFashion() || item.isTypeUIClanShop()) {
                item.buyCoin = msg.reader().readInt();
                item.buyCoinLock = msg.reader().readInt();
                item.buyGold = msg.reader().readInt();
            }
            if (item.isTypeBody() || item.isTypeMounts() || item.isTypeNgocKham()) {
                item.sys = msg.reader().readByte();
                item.options = new MyVector();
                try {
                    while (true) {
                        item.options.addElement(new ItemOption(msg.reader().readUnsignedByte(), msg.reader().readInt()));
                    }
                } catch (Exception exception) {
                }
            } else if (item.template.id == 233) {
                item.img = createImage(NinjaUtil.readByteArray(msg));
            } else if (item.template.id == 234) {
                item.img = createImage(NinjaUtil.readByteArray(msg));
            } else if (item.template.id == 235) {
                item.img = createImage(NinjaUtil.readByteArray(msg));
            }
            if (byteValue == 5) {
                Char.getMyChar().updateKickOption();
                return;
            }
        } catch (Exception exception5) {
            exception5.printStackTrace();
            System.out.println("Controller.requestItemInfo()");
        }
    }

    private static void addMob(Message msg) {
        try {
            byte byteValue = msg.reader().readByte();
            for (byte index = 0; index < byteValue; index++) {
                short shortValue = (short) msg.reader().readUnsignedByte();
                boolean flag = msg.reader().readBoolean();
                boolean flag1 = msg.reader().readBoolean();
                boolean flag2 = msg.reader().readBoolean();
                boolean flag3 = msg.reader().readBoolean();
                boolean flag4 = msg.reader().readBoolean();
                short shortValue5 = msg.reader().readShort();
                byte byteValue6 = msg.reader().readByte();
                int value = msg.reader().readInt();
                int unsignedByte = msg.reader().readUnsignedByte();
                int value7 = msg.reader().readInt();
                short shortValue8 = msg.reader().readShort();
                short shortValue9 = msg.reader().readShort();
                byte byteValue10 = msg.reader().readByte();
                byte byteValue11 = msg.reader().readByte();
                boolean flag12 = msg.reader().readBoolean();
                Mob mob = new Mob(shortValue, flag, flag1, flag2, flag3, flag4, shortValue5, byteValue6, value, unsignedByte, value7, shortValue8, shortValue9, byteValue10, byteValue11, flag12, true);
                if (Mob.arrMobTemplate[mob.templateId].type != 0) {
                    if (index % 3 == 0) {
                        mob.dir = -1;
                    } else {
                        mob.dir = 1;
                    }
                    mob.x += 10 - index % 20;
                }
                GameScr.vMob.addElement(mob);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("err addMob");
        }
    }

    private static void addEffAuto(Message message) {
        try {
            short shortValue = (short) message.reader().readUnsignedByte();
            short shortValue1 = message.reader().readShort();
            short shortValue2 = message.reader().readShort();
            byte byteValue = message.reader().readByte();
            short shortValue3 = message.reader().readShort();
            EffectAuto.addEffectAuto(shortValue, shortValue1, shortValue2, byteValue, shortValue3, 1);
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("err add effAuto");
        }
    }

    private static void getDataEffAuto(Message message) {
        try {
            short shortValue = (short) message.reader().readUnsignedByte();
            short shortValue1 = message.reader().readShort();
            byte[] data = null;
            if (shortValue1 > 0) {
                data = new byte[shortValue1];
                message.reader().read(data);
            }
            EffectAuto.reciveData(shortValue, data);
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("err add effAuto");
        }
    }

    private static void getImgEffAuto(Message message) {
        try {
            short shortValue = (short) message.reader().readUnsignedByte();
            byte[] data = NinjaUtil.readByteArray_Int(message);
            EffectAuto.reciveImage(shortValue, data);
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("err getImgEffAuto");
        }
    }

    private static void khamngoc(Message msg) {
        try {
            byte byteValue = msg.reader().readByte();
            Char.getMyChar().luong = msg.reader().readInt();
            Char.getMyChar().xu = msg.reader().readInt();
            Char.getMyChar().yen = msg.reader().readInt();
            if (byteValue == 0) {
                if (GameScr.itemSplit != null) {
                    GameScr.itemSplit = null;
                }
                if (GameScr.arrItemSplit != null) {
                    for (int index = 0; index < GameScr.arrItemSplit.length; index++) {
                        GameScr.arrItemSplit[index] = null;
                    }
                }
            } else if (byteValue == 1) {
                if (GameScr.itemSplit != null) {
                    GameScr.itemSplit.isLock = true;
                    GameScr.itemSplit.upgrade = msg.reader().readByte();
                    GameScr.effUpok = GameScr.efs[53];
                    GameScr.indexEff = 0;
                }
                if (GameScr.arrItemSplit != null) {
                    for (int index1 = 0; index1 < GameScr.arrItemSplit.length; index1++) {
                        GameScr.arrItemSplit[index1] = null;
                    }
                }
            } else if ((byteValue == 2 || byteValue == 3) && GameScr.arrItemSplit != null) {
                for (int index2 = 0; index2 < GameScr.arrItemSplit.length; index2++) {
                    GameScr.arrItemSplit[index2] = null;
                }
            }
            GameScr.gI().left = GameScr.gI().center = null;
            GameScr.gI().updateKeyBuyItemUI();
            GameCanvas.endDlg();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("err getImgEffAuto");
        }
    }

    private static void addEffect(Message message) {
        try {
            MainObject mainObject;
            if (message.reader().readByte() == 1) {
                mainObject = Mob.get_Mob(message.reader().readUnsignedByte());
            } else {
                int value;
                if ((value = message.reader().readInt()) == Char.getMyChar().charID) {
                    mainObject = Char.getMyChar();
                } else {
                    mainObject = GameScr.findCharInMap(value);
                }
            }
            if (mainObject == null) {
                return;
            }
            short shortValue = message.reader().readShort();
            int value1 = message.reader().readInt();
            int value2 = message.reader().readByte();
            boolean flag = message.reader().readByte() != 0;
            long longValue = value1;
            int value3 = value2 * 1000;
            boolean flag4 = flag;
            int value5 = value3;
            long longValue6 = longValue;
            short shortValue7 = shortValue;
            MainObject mainObject8 = mainObject;
            value2 = 0;
            while (true) {
                if (value2 >= mainObject8.vecEFfect.size()) {
                    DataSkillEff dataSkillEff = new DataSkillEff(shortValue7, longValue6, value5, flag4);
                    mainObject8.vecEFfect.addElement(dataSkillEff);
                    return;
                }
                DataSkillEff dataSkillEff9;
                if ((dataSkillEff9 = (DataSkillEff) mainObject8.vecEFfect.elementAt(value2)) != null && dataSkillEff9.idEff == shortValue7) {
                    dataSkillEff9.timelive = longValue6 + System.currentTimeMillis();
                    dataSkillEff9.miliSecondWait = value5;
                    dataSkillEff9.setTypeEff(longValue6);
                    break;
                }
                value2++;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void getImgEffect(Message msg) {
        try {
            short shortValue = msg.reader().readShort();
            byte[] data = NinjaUtil.readByteArray_Int(msg);
            GameData.setImgIcon(shortValue, data);
            ImageIcon imageIcon;
            if ((imageIcon = (ImageIcon) GameData.listImgIcon.get("" + shortValue)) == null) {
                imageIcon = new ImageIcon();
                GameData.listImgIcon.put(String.valueOf(shortValue), imageIcon);
            }
            imageIcon.img = createImage(data);
            if (GameMidlet.CLIENT_TYPE != 1) {
                RMS.saveRMSImage("ImgEffect " + shortValue, data);
                return;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("err getImgEffect");
        }
    }

    private static void getDataEffect(Message msg) {
        try {
            short shortValue = msg.reader().readShort();
            short shortValue1 = msg.reader().readShort();
            byte[] data = null;
            if (shortValue1 > 0) {
                data = new byte[shortValue1];
                msg.reader().read(data);
            }
            PacketBuffer packetBuffer;
            if ((packetBuffer = (PacketBuffer) GameData.listbyteData.get("" + shortValue)) != null) {
                byte[] data2 = data;
                PacketBuffer packetBuffer3 = packetBuffer;
                if (data2 != null) {
                    packetBuffer3.data = data2;
                }
                return;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("err getDataEffect ");
        }
    }

    private static void readDataMobOld(Message msg, int mobTemplateId) {
        try {
            Mob.arrMobTemplate[mobTemplateId].imginfo = new ImageInfo[msg.reader().readByte()];
            for (int index = 0; index < Mob.arrMobTemplate[mobTemplateId].imginfo.length; index++) {
                Mob.arrMobTemplate[mobTemplateId].imginfo[index] = new ImageInfo();
                msg.reader().readByte();
                Mob.arrMobTemplate[mobTemplateId].imginfo[index].x0 = msg.reader().readUnsignedByte();
                Mob.arrMobTemplate[mobTemplateId].imginfo[index].y0 = msg.reader().readUnsignedByte();
                Mob.arrMobTemplate[mobTemplateId].imginfo[index].w = msg.reader().readUnsignedByte();
                Mob.arrMobTemplate[mobTemplateId].imginfo[index].h = msg.reader().readUnsignedByte();
            }
            Mob.arrMobTemplate[mobTemplateId].frameBoss = new Frame[msg.reader().readShort()];
            for (int index1 = 0; index1 < Mob.arrMobTemplate[mobTemplateId].frameBoss.length; index1++) {
                Mob.arrMobTemplate[mobTemplateId].frameBoss[index1] = new Frame();
                byte byteValue = msg.reader().readByte();
                Mob.arrMobTemplate[mobTemplateId].frameBoss[index1].dx = new short[byteValue];
                Mob.arrMobTemplate[mobTemplateId].frameBoss[index1].dy = new short[byteValue];
                Mob.arrMobTemplate[mobTemplateId].frameBoss[index1].idImg = new byte[byteValue];
                for (int index2 = 0; index2 < byteValue; index2++) {
                    Mob.arrMobTemplate[mobTemplateId].frameBoss[index1].dx[index2] = msg.reader().readShort();
                    Mob.arrMobTemplate[mobTemplateId].frameBoss[index1].dy[index2] = msg.reader().readShort();
                    Mob.arrMobTemplate[mobTemplateId].frameBoss[index1].idImg[index2] = msg.reader().readByte();
                }
            }
            short shortValue = msg.reader().readShort();
            for (int index3 = 0; index3 < shortValue; index3++) {
                msg.reader().readShort();
            }
        } catch (Exception exception) {
        }
    }

    private static void readDataMobNew(Message msg, int mobTemplateId) {
        try {
            short shortValue = 0;
            Mob.arrMobTemplate[mobTemplateId].imginfo = new ImageInfo[msg.reader().readByte()];
            for (int index = 0; index < Mob.arrMobTemplate[mobTemplateId].imginfo.length; index++) {
                Mob.arrMobTemplate[mobTemplateId].imginfo[index] = new ImageInfo();
                msg.reader().readByte();
                Mob.arrMobTemplate[mobTemplateId].imginfo[index].x0 = msg.reader().readUnsignedByte();
                Mob.arrMobTemplate[mobTemplateId].imginfo[index].y0 = msg.reader().readUnsignedByte();
                Mob.arrMobTemplate[mobTemplateId].imginfo[index].w = msg.reader().readUnsignedByte();
                Mob.arrMobTemplate[mobTemplateId].imginfo[index].h = msg.reader().readUnsignedByte();
            }
            Mob.arrMobTemplate[mobTemplateId].frameBoss = new Frame[msg.reader().readShort()];
            for (int index1 = 0; index1 < Mob.arrMobTemplate[mobTemplateId].frameBoss.length; index1++) {
                Mob.arrMobTemplate[mobTemplateId].frameBoss[index1] = new Frame();
                byte byteValue = msg.reader().readByte();
                Mob.arrMobTemplate[mobTemplateId].frameBoss[index1].dx = new short[byteValue];
                Mob.arrMobTemplate[mobTemplateId].frameBoss[index1].dy = new short[byteValue];
                Mob.arrMobTemplate[mobTemplateId].frameBoss[index1].idImg = new byte[byteValue];
                Mob.arrMobTemplate[mobTemplateId].frameBoss[index1].flip = new byte[byteValue];
                Mob.arrMobTemplate[mobTemplateId].frameBoss[index1].onTop = new byte[byteValue];
                for (int index2 = 0; index2 < byteValue; index2++) {
                    Mob.arrMobTemplate[mobTemplateId].frameBoss[index1].dx[index2] = msg.reader().readShort();
                    Mob.arrMobTemplate[mobTemplateId].frameBoss[index1].dy[index2] = msg.reader().readShort();
                    Mob.arrMobTemplate[mobTemplateId].frameBoss[index1].idImg[index2] = msg.reader().readByte();
                    Mob.arrMobTemplate[mobTemplateId].frameBoss[index1].flip[index2] = msg.reader().readByte();
                    Mob.arrMobTemplate[mobTemplateId].frameBoss[index1].onTop[index2] = msg.reader().readByte();
                }
            }
            shortValue = (short) msg.reader().readUnsignedByte();
            Mob.arrMobTemplate[mobTemplateId].sequence = new byte[shortValue];
            for (int index3 = 0; index3 < shortValue; index3++) {
                Mob.arrMobTemplate[mobTemplateId].sequence[index3] = (byte) msg.reader().readShort();
            }
            msg.reader().readByte();
            for (int index4 = 0; index4 < 4; index4++) {
                if (index4 != 2) {
                    byte byteValue5 = msg.reader().readByte();
                    Mob.arrMobTemplate[mobTemplateId].frameChar[index4] = new byte[byteValue5];
                    for (int index6 = 0; index6 < byteValue5; index6++) {
                        Mob.arrMobTemplate[mobTemplateId].frameChar[index4][index6] = msg.reader().readByte();
                    }
                }
            }
            try {
                Mob.arrMobTemplate[mobTemplateId].indexSplash[0] = (byte) (Mob.arrMobTemplate[mobTemplateId].frameChar[0].length - 7);
                Mob.arrMobTemplate[mobTemplateId].indexSplash[1] = (byte) (Mob.arrMobTemplate[mobTemplateId].frameChar[1].length - 7);
                Mob.arrMobTemplate[mobTemplateId].indexSplash[2] = (byte) (Mob.arrMobTemplate[mobTemplateId].frameChar[3].length - 7);
                Mob.arrMobTemplate[mobTemplateId].indexSplash[3] = (byte) (Mob.arrMobTemplate[mobTemplateId].frameChar[3].length - 7);
            } catch (Exception exception) {
                new StringBuffer("loi read data mod ").append(exception.toString()).toString();
            }
            for (int index7 = 0; index7 < 3; index7++) {
                Mob.arrMobTemplate[mobTemplateId].indexSplash[index7] = msg.reader().readByte();
            }
            Mob.arrMobTemplate[mobTemplateId].indexSplash[3] = Mob.arrMobTemplate[mobTemplateId].indexSplash[2];
        } catch (Exception exception8) {
            new StringBuffer("loi ham read data new mob ").append(mobTemplateId).append(" ").append(exception8.toString()).toString();
        }
    }
}
