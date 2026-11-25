package nso;

import java.io.IOException;
import main.GameCanvas;
import main.GameMidlet;

public final class Service {

    private Session_ME session = Session_ME.gI();

    private static Service instance;

    private int xx;

    private int yy;

    public Service() {
    }

    public static Service gI() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    private static Message messageNotLogin(byte command) throws IOException {
        Message message = new Message((byte) -29);
        new StringBuffer("CMD NOT_LOGIN ----> ").append(command).toString();
        message.writer().writeByte(command);
        return message;
    }

    private static Message messageNotMap(byte command) throws IOException {
        Message message = new Message((byte) -28);
        new StringBuffer("CMD NOT MAP ----> ").append(command).toString();
        message.writer().writeByte(command);
        return message;
    }

    private static Message messageSubCommand(byte command) throws IOException {
        Message message = new Message((byte) -30);
        new StringBuffer("CMD SUB_COMMAND ----> ").append(command).toString();
        message.writer().writeByte(command);
        return message;
    }

    public final void setClientType() {
        try {
            Message message;
            (message = messageNotLogin((byte) -125)).writer().writeByte(GameMidlet.CLIENT_TYPE);
            message.writer().writeByte(mGraphics.zoomLevel);
            message.writer().writeBoolean(GameCanvas.isGPRS);
            message.writer().writeInt(GameCanvas.w);
            message.writer().writeInt(GameCanvas.h);
            message.writer().writeBoolean(TField.isQwerty);
            message.writer().writeBoolean(GameCanvas.isTouch);
            message.writer().writeUTF(System.getProperty("microedition.platform"));
            message.writer().writeByte(0);
            message.writer().writeInt(0);
            message.writer().writeByte(mResources.languageID);
            message.writer().writeInt(GameMidlet.userProvider);
            message.writer().writeUTF(GameMidlet.clientAgent);
            this.session.sendMessage(message);
            message.cleanup();
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public final void login(String username, String pass, String version) {
        gI().setClientType();
        try {
            Message message;
            (message = messageNotLogin((byte) -127)).writer().writeUTF(username);
            message.writer().writeUTF(pass);
            message.writer().writeUTF(version);
            message.writer().writeUTF("");
            message.writer().writeUTF("");
            message.writer().writeUTF(RMS.loadRMSString("random"));
            message.writer().writeByte(GameMidlet.serverLogin);
            this.session.sendMessage(message);
            message.cleanup();
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public final void requestRegisterNew(String username, String pass, String email) {
        try {
            Message message;
            (message = new Message((byte) 118)).writer().writeUTF(username);
            message.writer().writeUTF(pass);
            message.writer().writeUTF(email);
            this.session.sendMessage(message);
            message.cleanup();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public final void requestForgetPass(String username) {
        try {
            Message message;
            (message = messageNotLogin((byte) -122)).writer().writeUTF(username);
            this.session.sendMessage(message);
            message.cleanup();
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public final void requestChangeMap() {
        Message message = new Message((byte) -17);
        this.session.sendMessage(message);
        message.cleanup();
    }

    public final void requestChangeZone(int zoneId, int indexUI) {
        Message message = new Message((byte) 28);
        try {
            message.writer().writeByte(zoneId);
            message.writer().writeByte(indexUI);
            this.session.sendMessage(message);
            message.cleanup();
        } catch (Exception exception) {
        }
    }

    public final void charMove(int value, int value1) {
        try {
            if (value - this.xx != 0 || value1 - this.yy != 0) {
                Message message;
                (message = new Message((byte) 1)).writer().writeShort(value);
                message.writer().writeShort(value1);
                this.xx = value;
                this.yy = value1;
                this.session.sendMessage(message);
                message.cleanup();
                return;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public final void selectCharToPlay(String charname) {
        Message message = new Message((byte) -28);
        try {
            message.writer().writeByte(-126);
            message.writer().writeUTF(charname);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        this.session.sendMessage(message);
    }

    public final void createChar(String name, int gender, int hair) {
        Message message = new Message((byte) -28);
        try {
            message.writer().writeByte(-125);
            message.writer().writeUTF(name);
            message.writer().writeByte(gender);
            message.writer().writeByte(hair);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        this.session.sendMessage(message);
    }

    public final void requestModTemplate(int modTemplateId) {
        Message message = null;
        try {
            (message = messageNotMap((byte) -108)).writer().writeShort(modTemplateId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void requestItemInfo(int typeUI, int indexUI) {
        Message message = null;
        try {
            (message = new Message((byte) 42)).writer().writeByte(typeUI);
            message.writer().writeByte(indexUI);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void requestItemPlayer(int charId, int indexUI) {
        Message message = null;
        try {
            (message = new Message((byte) 94)).writer().writeInt(charId);
            message.writer().writeByte(indexUI);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void upPotential(int index, int point) {
        Message message = null;
        try {
            (message = messageSubCommand((byte) -109)).writer().writeByte(index);
            message.writer().writeShort(point);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void upSkill(int skillTemplateId, int point) {
        Message message = null;
        try {
            (message = messageSubCommand((byte) -108)).writer().writeShort(skillTemplateId);
            message.writer().writeByte(point);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void itemBodyToBag(int indexUI) {
        Message message = null;
        try {
            (message = new Message((byte) 15)).writer().writeByte(indexUI);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void itemMonToBag(int indexUI) {
        Message message = null;
        try {
            (message = new Message((byte) 108)).writer().writeByte(indexUI);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void itemBoxToBag(int indexUI) {
        Message message = null;
        try {
            (message = new Message((byte) 16)).writer().writeByte(indexUI);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void itemBagToBox(int indexUI) {
        Message message = null;
        try {
            (message = new Message((byte) 17)).writer().writeByte(indexUI);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void useItem(int indexUI) {
        Message message = null;
        try {
            (message = new Message((byte) 11)).writer().writeByte(indexUI);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
        if (Char.getMyChar().arrItemBag[indexUI] != null && Char.getMyChar().arrItemBag[indexUI].template.type == 24) {
            GameScr.gI().resetButton();
            InfoDlg.showWait("");
        }
    }

    public final void saleItem(int indexUI, int quantity) {
        GameCanvas.msgdlg.pleasewait();
        Message message = null;
        try {
            (message = new Message((byte) 14)).writer().writeByte(indexUI);
            if (quantity > 1) {
                message.writer().writeInt(quantity);
            }
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void buyItem(int typeUI, int indexUI, int quantity) {
        GameCanvas.msgdlg.pleasewait();
        Message message = null;
        try {
            (message = new Message((byte) 13)).writer().writeByte(typeUI);
            message.writer().writeByte(indexUI);
            if (quantity > 1) {
                message.writer().writeShort(quantity);
            }
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void selectSkill(int skillTemplateId) {
        Message message = null;
        try {
            (message = new Message((byte) 41)).writer().writeShort(skillTemplateId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void openFindParty() {
        Message message = null;
        try {
            message = messageSubCommand((byte) -77);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void openUIZone() {
        Message message = null;
        try {
            message = new Message((byte) 36);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void useItemChangeMap(int indexUI, int indexMenu) {
        Message message = null;
        try {
            (message = new Message((byte) 12)).writer().writeByte(indexUI);
            message.writer().writeByte(indexMenu);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void openMenu(int npcId) {
        Message message = null;
        try {
            (message = new Message((byte) 40)).writer().writeShort(npcId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void menu(byte typeclose, int npcId, int menuId, int optionId) {
        Message message = null;
        try {
            (message = new Message((byte) 29)).writer().writeByte(typeclose);
            message.writer().writeByte(npcId);
            message.writer().writeByte(menuId);
            message.writer().writeByte(optionId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void menuId(short menuId) {
        Message message = null;
        try {
            (message = new Message((byte) 34)).writer().writeShort(menuId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void textBoxId(short menuId, String str) {
        Message message = null;
        try {
            (message = new Message((byte) 92)).writer().writeShort(menuId);
            message.writer().writeUTF(str);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void requestItem(int typeUI) {
        Message message = null;
        try {
            (message = messageSubCommand((byte) -103)).writer().writeByte(typeUI);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void bagSort() {
        Message message = null;
        try {
            message = messageSubCommand((byte) -107);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void boxSort() {
        Message message = null;
        try {
            message = messageSubCommand((byte) -106);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void boxCoinIn(int coinIn) {
        Message message = null;
        try {
            (message = messageSubCommand((byte) -105)).writer().writeInt(coinIn);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void boxCoinOut(int coinOut) {
        Message message = null;
        try {
            (message = messageSubCommand((byte) -104)).writer().writeInt(coinOut);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void crystalCollect(Item[] items) {
        GameCanvas.msgdlg.pleasewait();
        Message message = null;
        try {
            message = new Message((byte) 19);
            for (int index = 0; index < items.length; index++) {
                if (items[index] != null) {
                    message.writer().writeByte(items[index].indexUI);
                }
            }
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void upgradeItem(Item item, Item[] items, boolean isGold) {
        GameCanvas.msgdlg.pleasewait();
        Message message = null;
        try {
            (message = new Message((byte) 21)).writer().writeBoolean(isGold);
            message.writer().writeByte(item.indexUI);
            for (int index = 0; index < items.length; index++) {
                if (items[index] != null) {
                    message.writer().writeByte(items[index].indexUI);
                }
            }
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void crystalCollectLock(Item[] items) {
        GameCanvas.msgdlg.pleasewait();
        Message message = null;
        try {
            message = new Message((byte) 20);
            for (int index = 0; index < items.length; index++) {
                if (items[index] != null) {
                    message.writer().writeByte(items[index].indexUI);
                }
            }
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void splitItem(Item item) {
        GameCanvas.msgdlg.pleasewait();
        Message message = null;
        try {
            (message = new Message((byte) 22)).writer().writeByte(item.indexUI);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void acceptInviteTrade(int playerMapId) {
        Message message = null;
        try {
            (message = new Message((byte) 44)).writer().writeInt(playerMapId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void acceptInviteTestDun(int playerMapId) {
        Message message = null;
        try {
            (message = new Message((byte) 99)).writer().writeInt(playerMapId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void acceptInviteTestGT(int playerMapId) {
        Message message = null;
        try {
            (message = new Message((byte) 106)).writer().writeInt(playerMapId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void sendUIConfirmID(int Id) {
        Message message = null;
        try {
            (message = new Message((byte) 107)).writer().writeByte(Id);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void acceptInviteTest(int playerMapId) {
        Message message = null;
        try {
            (message = new Message((byte) 66)).writer().writeInt(playerMapId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void cancelInviteTrade() {
        Message message = null;
        try {
            message = new Message((byte) 56);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void cancelTrade() {
        Message message = null;
        try {
            message = new Message((byte) 57);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void tradeAccept() {
        Message message = null;
        try {
            message = new Message((byte) 46);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void tradeItemLock(int coin, Item[] items) {
        Message message = null;
        try {
            (message = new Message((byte) 45)).writer().writeInt(coin);
            coin = 0;
            for (int index = 0; index < items.length; index++) {
                if (items[index] != null) {
                    coin++;
                }
            }
            message.writer().writeByte(coin);
            for (int index1 = 0; index1 < items.length; index1++) {
                if (items[index1] != null) {
                    message.writer().writeByte(items[index1].indexUI);
                }
            }
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void sendPlayerAttack(MyVector vMob, MyVector vChar, int type) {
        Message message = null;
        if (type != 0) {
            try {
                if (vMob.size() > 0 && vChar.size() > 0) {
                    if (type == 1) {
                        message = new Message((byte) 4);
                    } else if (type == 2) {
                        message = new Message((byte) 73);
                    }
                    message.writer().writeByte(vMob.size());
                    for (int index = 0; index < vMob.size(); index++) {
                        Mob mob = (Mob) vMob.elementAt(index);
                        message.writer().writeByte(mob.mobId);
                    }
                    for (int index1 = 0; index1 < vChar.size(); index1++) {
                        Char character;
                        if ((character = (Char) vChar.elementAt(index1)) != null) {
                            message.writer().writeInt(character.charID);
                        } else {
                            message.writer().writeInt(-1);
                        }
                    }
                } else if (vMob.size() > 0) {
                    message = new Message((byte) 60);
                    for (int index2 = 0; index2 < vMob.size(); index2++) {
                        Mob mob3 = (Mob) vMob.elementAt(index2);
                        message.writer().writeByte(mob3.mobId);
                    }
                } else if (vChar.size() > 0) {
                    message = new Message((byte) 61);
                    for (int index4 = 0; index4 < vChar.size(); index4++) {
                        Char character5 = (Char) vChar.elementAt(index4);
                        message.writer().writeInt(character5.charID);
                    }
                }
                if (message != null) {
                    this.session.sendMessage(message);
                }
            } catch (Exception exception) {
            }
        }
    }

    public final void pickItem(int itemMapId) {
        Message message = null;
        for (int index = 0; index < GameScr.vItemMap.size(); index++) {
            GameScr.vItemMap.elementAt(index);
        }
        try {
            (message = new Message((byte) -14)).writer().writeShort(itemMapId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void throwItem(int index) {
        Message message = null;
        try {
            (message = new Message((byte) -12)).writer().writeByte(index);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void returnTownFromDead() {
        Message message = null;
        try {
            message = new Message((byte) -9);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void wakeUpFromDead() {
        Message message = null;
        try {
            message = new Message((byte) -10);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void getTask(int npcTemplateId, int menuId, int optionId) {
        Message message = null;
        try {
            (message = new Message((byte) 47)).writer().writeByte(npcTemplateId);
            message.writer().writeByte(menuId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void chat(String text) {
        Message message = null;
        try {
            (message = new Message((byte) -23)).writer().writeUTF(text);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void adminChat(String text) {
        Message message = null;
        try {
            (message = messageNotMap((byte) -78)).writer().writeUTF(text);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void updateData() {
        Message message = null;
        try {
            message = messageNotMap((byte) -122);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void updateMap() {
        Message message = null;
        try {
            message = messageNotMap((byte) -121);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void updateSkill() {
        Message message = null;
        try {
            message = messageNotMap((byte) -120);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void updateItem() {
        Message message = null;
        try {
            message = messageNotMap((byte) -119);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void clientOk() {
        Message message = null;
        try {
            message = messageNotMap((byte) -101);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void tradeInvite(int charId) {
        Message message = null;
        try {
            (message = new Message((byte) 43)).writer().writeInt(charId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void addFriend(String name) {
        Message message = null;
        try {
            (message = new Message((byte) 59)).writer().writeUTF(name);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void addPartyAccept(int charId) {
        Message message = null;
        try {
            (message = new Message((byte) 80)).writer().writeInt(charId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void addPartyCancel(int charId) {
        Message message = null;
        try {
            (message = new Message((byte) 81)).writer().writeInt(charId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void testInvite(int charId) {
        Message message = null;
        try {
            (message = new Message((byte) 65)).writer().writeInt(charId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void addCuuSat(int charId) {
        Message message = null;
        try {
            (message = new Message((byte) 68)).writer().writeInt(charId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void buffLive(int charId) {
        Message message = null;
        try {
            (message = messageSubCommand((byte) -79)).writer().writeInt(charId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void addParty(String name) {
        Message message = null;
        try {
            (message = new Message((byte) 79)).writer().writeUTF(name);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void requestMaptemplate(int maptemplateId) {
        Message message = null;
        try {
            (message = messageNotMap((byte) -109)).writer().writeByte(maptemplateId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void changePk(int typePk) {
        Message message = null;
        try {
            (message = messageSubCommand((byte) -93)).writer().writeByte(typePk);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void changeTeamLeader(int index) {
        Message message = null;
        try {
            (message = messageSubCommand((byte) -87)).writer().writeByte(index);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void moveMember(int index) {
        Message message = null;
        try {
            (message = messageSubCommand((byte) -86)).writer().writeByte(index);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void sendUseSkillMyBuff() {
        Message message = null;
        try {
            (message = new Message((byte) 74)).writer().writeByte(Char.getMyChar().cdir);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void createParty() {
        Message message = null;
        try {
            message = messageSubCommand((byte) -88);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void lockParty(boolean isLock) {
        Message message = null;
        try {
            (message = messageSubCommand((byte) -76)).writer().writeBoolean(isLock);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void outParty() {
        Message message = null;
        try {
            message = new Message((byte) 83);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void requestFriend() {
        Message message = null;
        try {
            message = messageSubCommand((byte) -85);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void requestMatchInfo(int zoneid) {
        Message message = null;
        try {
            (message = new Message((byte) 100)).writer().writeByte(zoneid);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void requestPlayerInfo(MyVector chars) {
        Message message = null;
        try {
            (message = new Message((byte) 25)).writer().writeByte(chars.size());
            for (int index = 0; index < chars.size(); index++) {
                Char character = (Char) chars.elementAt(index);
                message.writer().writeInt(character.charID);
            }
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void requestEnemies() {
        Message message = null;
        try {
            message = messageSubCommand((byte) -84);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void removeFriend(String name) {
        Message message = null;
        try {
            (message = messageSubCommand((byte) -83)).writer().writeUTF(name);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void pleaseInputParty(String str) {
        Message message = null;
        try {
            (message = new Message((byte) 23)).writer().writeUTF(str);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void acceptPleaseParty(String str) {
        Message message = null;
        try {
            (message = new Message((byte) 24)).writer().writeUTF(str);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void viewInfo(String text, int value) {
        Message message = null;
        try {
            (message = new Message((byte) 93)).writer().writeUTF(text);
            message.writer().writeByte(0);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void chatParty(String text) {
        Message message = null;
        try {
            (message = new Message((byte) -20)).writer().writeUTF(text);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void chatGlobal(String text) {
        Message message = null;
        try {
            (message = new Message((byte) -21)).writer().writeUTF(text);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void chatPrivate(String to, String text) {
        Message message = null;
        try {
            (message = new Message((byte) -22)).writer().writeUTF(to);
            message.writer().writeUTF(text);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void chatClan(String text) {
        Message message = null;
        try {
            (message = new Message((byte) -19)).writer().writeUTF(text);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void sendCardInfo(String NAP, String PIN) {
        Message message = null;
        try {
            (message = messageNotMap((byte) -99)).writer().writeUTF(NAP);
            message.writer().writeUTF(PIN);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void saveRms(String key, byte[] data, byte type) {
        Message message = null;
        try {
            (message = messageSubCommand((byte) -67)).writer().writeUTF(key);
            message.writer().writeInt(data.length);
            message.writer().write(data);
            message.writer().write(type);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void loadRMS(String key) {
        Message message = null;
        try {
            (message = messageSubCommand((byte) -65)).writer().writeUTF(key);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void adminMove(int mapId) {
        Message message = null;
        try {
            (message = messageSubCommand((byte) -70)).writer().writeByte(mapId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void changeName(String name, int id) {
        Message message = null;
        try {
            (message = messageNotMap((byte) -97)).writer().writeInt(id);
            message.writer().writeUTF(name);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void requestIcon(int id) {
        Message message = null;
        try {
            (message = messageNotMap((byte) -115)).writer().writeInt(id);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void requestClanInfo() {
        Message message = null;
        try {
            message = messageNotMap((byte) -113);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void requestClanMember() {
        Message message = null;
        try {
            message = messageNotMap((byte) -112);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void requestClanItem() {
        Message message = null;
        try {
            message = messageNotMap((byte) -111);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void requestClanLog() {
        Message message = null;
        try {
            message = messageNotMap((byte) -114);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void clanInvite(int charId) {
        Message message = null;
        try {
            (message = messageSubCommand((byte) -63)).writer().writeInt(charId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void clanPlease(int charId) {
        Message message = null;
        try {
            (message = messageSubCommand((byte) -61)).writer().writeInt(charId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void acceptInviteClan(int playerMapId) {
        Message message = null;
        try {
            (message = messageSubCommand((byte) -62)).writer().writeInt(playerMapId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void acceptPleaseClan(int playerMapId) {
        Message message = null;
        try {
            (message = messageSubCommand((byte) -60)).writer().writeInt(playerMapId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void changeClanAlert(String str) {
        Message message = null;
        try {
            (message = messageNotMap((byte) -95)).writer().writeUTF(str);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void changeClanType(String name, int type) {
        Message message = null;
        try {
            (message = messageNotMap((byte) -94)).writer().writeUTF(name);
            message.writer().writeByte(type);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void moveOutClan(String name) {
        Message message = null;
        try {
            (message = messageNotMap((byte) -93)).writer().writeUTF(name);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void outClan() {
        Message message = null;
        try {
            message = messageNotMap((byte) -92);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void inputCoinClan(int coin) {
        Message message = null;
        try {
            (message = messageNotMap((byte) -90)).writer().writeInt(coin);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void outputCoinClan(int coin) {
        Message message = null;
        try {
            (message = messageNotMap((byte) -89)).writer().writeInt(coin);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void clanUpLevel() {
        Message message = null;
        try {
            message = messageNotMap((byte) -91);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void doConvertUpgrade(int index1, int index2, int index3) {
        Message message = null;
        try {
            (message = messageNotMap((byte) -88)).writer().writeByte(index1);
            message.writer().writeByte(index2);
            message.writer().writeByte(index3);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void inviteClanDun(String name) {
        Message message = null;
        try {
            (message = messageNotMap((byte) -87)).writer().writeUTF(name);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void inviteClanBattlefield(String name) {
        Message message = null;
        try {
            (message = messageNotMap((byte) -70)).writer().writeUTF(name);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void acceptClanBattlefield() {
        Message message = null;
        try {
            message = messageNotMap((byte) -68);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void inviteClanBattlefieldAll() {
        Message message = null;
        try {
            message = messageNotMap((byte) -69);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void unlockClanItem() {
        Message message = null;
        try {
            message = messageNotMap((byte) -62);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void inputNumSplit(int indexItem, int numSplit) {
        Message message = null;
        try {
            (message = messageNotMap((byte) -85)).writer().writeByte(indexItem);
            message.writer().writeInt(numSplit);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void activeAccProtect(int pass) {
        Message message = null;
        try {
            (message = messageNotMap((byte) -105)).writer().writeInt(pass);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void clearAccProtect(int pass) {
        Message message = null;
        try {
            (message = messageNotMap((byte) -102)).writer().writeInt(pass);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void updateActive(int passOld, int passNew) {
        Message message = null;
        try {
            (message = messageNotMap((byte) -104)).writer().writeInt(passOld);
            message.writer().writeInt(passNew);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void openLockAccProtect(int pass2) {
        Message message = null;
        try {
            (message = messageNotMap((byte) -103)).writer().writeInt(pass2);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void rewardPB() {
        Message message = null;
        try {
            message = messageNotMap((byte) -82);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void rewardCT() {
        Message message = null;
        try {
            message = messageNotMap((byte) -79);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void sendToSaleItem(Item item, int value) {
        Message message = null;
        try {
            (message = new Message((byte) 102)).writer().writeByte(item.indexUI);
            message.writer().writeInt(value);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void requestItemAuction(int itemId) {
        Message message = null;
        try {
            (message = new Message((byte) 104)).writer().writeInt(itemId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void buyItemAuction(int itemId) {
        Message message = null;
        try {
            (message = new Message((byte) 105)).writer().writeInt(itemId);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void selectCard() {
        Message message = null;
        try {
            (message = messageNotMap((byte) -72)).writer().writeByte(GameScr.indexSelect);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void sendClanItem(String name) {
        Message message = null;
        try {
            (message = messageNotMap((byte) -61)).writer().writeByte(GameScr.indexSelect);
            message.writer().writeUTF(name);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void useClanItem() {
        Message message = null;
        try {
            (message = messageNotMap((byte) -60)).writer().writeByte(GameScr.indexSelect);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void luyenthach(Item[] items) {
        GameCanvas.msgdlg.pleasewait();
        Message message = null;
        try {
            message = new Message((byte) 110);
            for (int index = 0; index < items.length; index++) {
                if (items[index] != null && (items[index].template.id == 10 || items[index].template.id == 11)) {
                    message.writer().writeByte(items[index].indexUI);
                    break;
                }
            }
            for (int index1 = 0; index1 < items.length; index1++) {
                if (items[index1] != null && (items[index1].template.id == 455 || items[index1].template.id == 456)) {
                    message.writer().writeByte(items[index1].indexUI);
                }
            }
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void tinhluyen(Item it, Item[] items) {
        GameCanvas.msgdlg.pleasewait();
        Message message = null;
        try {
            (message = new Message((byte) 111)).writer().writeByte(it.indexUI);
            for (int index = 0; index < items.length; index++) {
                if (items[index] != null && (items[index].template.id == 455 || items[index].template.id == 456 || items[index].template.id == 457)) {
                    message.writer().writeByte(items[index].indexUI);
                }
            }
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void dichchuyen(Item it, Item[] items) {
        GameCanvas.msgdlg.pleasewait();
        Message message = null;
        try {
            (message = new Message((byte) 112)).writer().writeByte(it.indexUI);
            int value = 0;
            for (int index = 0; index < items.length; index++) {
                if (items[index] != null && items[index].template.id == 454) {
                    message.writer().writeByte(items[index].indexUI);
                    value++;
                }
            }
            if (value >= 20) {
                this.session.sendMessage(message);
                return;
            }
            GameCanvas.startOKDlg(mResources.NOT_ENOUGH_DICHCHUYEN);
        } catch (Exception exception) {
            exception.printStackTrace();
            return;
        } finally {
            message.cleanup();
        }
    }

    public final void sendCatkeo(int id) {
        Message message = null;
        try {
            (message = new Message((byte) 113)).writer().writeShort(id);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void ChucTet(String to, String loichuc, byte type) {
        Message message = null;
        to = to + " " + loichuc;
        try {
            (message = new Message((byte) -21)).writer().writeUTF(to);
            message.writer().writeByte(type);
            this.session.sendMessage(message);
        } catch (Exception exception) {
        } finally {
            message.cleanup();
        }
    }

    public final void SendCapcha(short idRe, String capcha) {
        Message message = null;
        try {
            (message = new Message((byte) 118)).writer().writeUTF(capcha);
            message.writer().writeShort(idRe);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void sendAttackMobFast(short idMonter) {
        Message message = null;
        try {
            (message = new Message((byte) 119)).writer().writeByte(idMonter);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void requestRanked(byte index, String name) {
        Message message = null;
        try {
            (message = new Message((byte) 121)).writer().writeByte(index);
            message.writer().writeUTF(name);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void request_imgEffAuto(byte type, short id) {
        Message message = null;
        try {
            (message = messageNotMap((byte) 122)).writer().writeByte(type);
            message.writer().writeByte(id);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void luckyDraw(short type, String money, byte typeLucky) {
        Message message = null;
        try {
            (message = new Message((byte) 92)).writer().writeShort(type);
            message.writer().writeUTF(money);
            message.writer().writeByte(typeLucky);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void info_Kiemduyet(String name, String ngaysinh, String diachi, String cmnd, String ngaycap, String noicap, String email) {
        try {
            Message message;
            (message = new Message((byte) 123)).writer().writeUTF(name);
            message.writer().writeUTF(ngaysinh);
            message.writer().writeUTF(diachi);
            message.writer().writeUTF(cmnd);
            message.writer().writeUTF(ngaycap);
            message.writer().writeUTF(noicap);
            message.writer().writeUTF(email);
            this.session.sendMessage(message);
            message.cleanup();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public final void send_Captcha(byte type) {
        Message message = null;
        try {
            (message = messageNotMap((byte) 122)).writer().writeByte(4);
            message.writer().writeByte(type);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void ngockham(byte type, Item item, Item ngoc, Item[] items) {
        GameCanvas.msgdlg.pleasewait();
        Message message = null;
        try {
            (message = new Message((byte) 124)).writer().writeByte(type);
            if (type == 0) {
                message.writer().writeByte(item.indexUI);
                message.writer().writeByte(ngoc.indexUI);
                for (int index = 0; index < items.length; index++) {
                    if (items[index] != null) {
                        message.writer().writeByte(items[index].indexUI);
                    }
                }
            } else if (type == 1) {
                message.writer().writeByte(ngoc.indexUI);
                for (int index1 = 0; index1 < items.length; index1++) {
                    if (items[index1] != null) {
                        message.writer().writeByte(items[index1].indexUI);
                    }
                }
            } else if (type == 2 || type == 3) {
                message.writer().writeByte(ngoc.indexUI);
            }
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void giaodo(Item[] items) {
        GameCanvas.msgdlg.pleasewait();
        Message message = null;
        try {
            message = new Message((byte) 126);
            for (int index = 0; index < items.length; index++) {
                if (items[index] != null) {
                    message.writer().writeByte(items[index].indexUI);
                }
            }
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void doGetImgIcon(short id) {
        Message message = null;
        try {
            (message = new Message((byte) 125)).writer().writeByte(1);
            message.writer().writeShort(id);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void doGetByteData(int id) {
        Message message = null;
        try {
            (message = new Message((byte) 125)).writer().writeByte(2);
            message.writer().writeShort(id);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            message.cleanup();
        }
    }

    public final void sendGPS() {
        Message message = null;
        try {
            (message = messageNotMap((byte) -59)).writer().writeUTF(GameMidlet.longitude);
            message.writer().writeUTF(GameMidlet.latitude);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public final void doRemoveVithu(int id) {
        Message message = null;
        try {
            (message = new Message((byte) 117)).writer().writeByte(0);
            message.writer().writeByte(id);
            this.session.sendMessage(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
