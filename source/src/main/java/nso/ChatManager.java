package nso;

import main.GameCanvas;

public final class ChatManager {

    public MyVector chatTabs;

    private static ChatManager instance;

    public int currentTabIndex = 0;

    public static boolean blockGlobalChat;

    public static boolean blockPrivateChat;

    public static boolean isMessageClan;

    public static boolean isMessagePt;

    public MyVector waitList = new MyVector();

    public final void switchToNextTab() {
        this.currentTabIndex++;
        if (this.currentTabIndex > this.chatTabs.size() - 1) {
            this.currentTabIndex = 0;
        }
    }

    public final void switchToPreviousTab() {
        this.currentTabIndex--;
        if (this.currentTabIndex < 0) {
            this.currentTabIndex = this.chatTabs.size() - 1;
        }
    }

    public final void switchToTab(int index) {
        this.currentTabIndex = index;
    }

    public final void switchToTab(ChatTab t) {
        this.currentTabIndex = this.chatTabs.indexOf(t);
    }

    public final void switchToLastTab() {
        this.currentTabIndex = this.chatTabs.size() - 1;
    }

    public static ChatManager gI() {
        return instance == null ? (instance = new ChatManager()) : instance;
    }

    public ChatManager() {
        this.chatTabs = new MyVector();
        this.chatTabs.addElement(new ChatTab(mResources.PUBLICCHAT[0], 0));
        this.chatTabs.addElement(new ChatTab(mResources.PARTYCHAT[0], 1));
        this.chatTabs.addElement(new ChatTab(mResources.GLOBALCHAT[0], 3));
        this.chatTabs.addElement(new ChatTab(mResources.CLANCHAT[0], 4));
        ChatTab chatTab;
        (chatTab = this.findTab(mResources.GLOBALCHAT[0])).addInfo("c8" + mResources.GLOBALCHAT[1]);
        chatTab.addInfo("c8" + mResources.GLOBALCHAT[2]);
        chatTab.addInfo("c8" + mResources.GLOBALCHAT[3]);
        this.findTab(mResources.PARTYCHAT[0]).addInfo("c8" + mResources.PARTYCHAT[1]);
        this.findTab(mResources.CLANCHAT[0]).addInfo("c8" + mResources.CLANCHAT[1]);
        this.findTab(mResources.PUBLICCHAT[0]).addInfo("c8" + mResources.PUBLICCHAT[1]);
    }

    public final ChatTab findTab(String ownerName) {
        for (int index = 0; index < this.chatTabs.size(); index++) {
            ChatTab chatTab;
            if ((chatTab = (ChatTab) this.chatTabs.elementAt(index)).ownerName.equals(ownerName)) {
                return chatTab;
            }
        }
        return null;
    }

    public final void addChat(String ownerName, String whoChat, String text) {
        ChatTab chatTab;
        if ((chatTab = this.findTab(ownerName)) == null) {
            chatTab = this.addNewTab(ownerName);
        }
        chatTab.addChat(whoChat, text);
    }

    public final ChatTab getCurrentChatTab() {
        return (ChatTab) this.chatTabs.elementAt(this.currentTabIndex);
    }

    public final ChatTab addNewTab(String friendName) {
        ChatTab chatTab = new ChatTab(friendName, 2);
        if (!GameCanvas.isTouch) {
            chatTab.addInfo("c2" + mResources.CLOSE_CURTAB);
        }
        this.chatTabs.addElement(chatTab);
        return chatTab;
    }

    public final void addWaitList(String nick) {
        for (int index = 0; index < this.waitList.size(); index++) {
            if (((String) this.waitList.elementAt(index)).equals(nick)) {
                return;
            }
        }
        this.waitList.addElement(nick);
    }

    public final boolean findWaitPerson(String nick) {
        for (int index = 0; index < this.waitList.size(); index++) {
            if (((String) this.waitList.elementAt(index)).equals(nick)) {
                return true;
            }
        }
        return false;
    }

    public final void removeFromWaitList(String nick) {
        for (int index = 0; index < this.waitList.size(); index++) {
            if (((String) this.waitList.elementAt(index)).equals(nick)) {
                this.waitList.removeElementAt(index);
                return;
            }
        }
    }

    public static void clear() {
        instance = null;
    }
}
