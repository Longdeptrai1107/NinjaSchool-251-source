package nso;

public final class ChatTab {

    public int type;

    public String ownerName;

    public MyVector contents = new MyVector();

    public ChatTab(String ownerName1, int type2) {
        this.ownerName = ownerName1;
        this.type = type2;
    }

    public ChatTab() {
    }

    public final void addChat(String whoChat, String text) {
        boolean flag = false;
        if (GameScr.isPaintMessage && ChatManager.gI().getCurrentChatTab() == this && GameScr.indexRow == this.contents.size() - 1) {
            flag = true;
        }
        this.contents.addElement("c3@" + whoChat);
        MyVector entries = mFont.tahoma_7_white.splitFontVector(text, 160);
        for (int index = 0; index < entries.size(); index++) {
            this.contents.addElement("c0" + entries.elementAt(index));
        }
        if (flag) {
            GameScr.gI().scrollDownAlert();
        }
        this.clear();
    }

    private void clear() {
        while (this.contents.size() > 50) {
            this.contents.removeElementAt(1);
        }
    }

    public final void addInfo(String text) {
        boolean flag = false;
        if (GameScr.isPaintMessage && ChatManager.gI().getCurrentChatTab() == this && GameScr.indexRow == this.contents.size() - 1) {
            flag = true;
        }
        MyVector entries = mFont.tahoma_7_white.splitFontVector(text, 160);
        for (int index = 0; index < entries.size(); index++) {
            this.contents.addElement(entries.elementAt(index));
        }
        if (flag) {
            GameScr.gI().scrollDownAlert();
        }
        this.clear();
    }
}
