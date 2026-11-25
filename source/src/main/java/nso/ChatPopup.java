package nso;

import main.GameCanvas;

public final class ChatPopup extends Effect2 implements IActionListener {

    private int sayWidth = 100;

    private int delay;

    private int sayRun;

    private String[] says;

    private int cx;

    private int cy;

    private int ch;

    private Char c;

    private boolean outSide = false;

    private int currentLine;

    private String[] lines;

    public Command cmdNextLine;

    public static ChatPopup currentMultilineChatPopup;

    public ChatPopup() {
    }

    public static void addChatPopupMultiLine(String chat, int howLong, Char c1) {
        String[] textLines;
        if ((textLines = Res.split(chat, "\n", 0)).length == 1) {
            addChatPopup(textLines[0], 1000, c1);
        } else {
            (currentMultilineChatPopup = addChatPopup(textLines[0], 1000, c1)).currentLine = 0;
            currentMultilineChatPopup.lines = textLines;
            currentMultilineChatPopup.cmdNextLine = new Command(mResources.NEXT, currentMultilineChatPopup, 8000, null);
        }
    }

    public static ChatPopup addChatPopup(String chat, int howLong, Char c1) {
        ChatPopup chatPopup = new ChatPopup();
        if (chat.length() < 10) {
            chatPopup.sayWidth = 64;
        }
        if (GameCanvas.w == 128) {
            chatPopup.sayWidth = 128;
        }
        chatPopup.says = mFont.tahoma_7_red.splitFontArray(chat, chatPopup.sayWidth - 10);
        chatPopup.delay = howLong;
        chatPopup.c = c1;
        chatPopup.cx = c1.cx;
        chatPopup.cy = c1.cy;
        c1.chatPopup = chatPopup;
        chatPopup.sayRun = 7;
        Effect2.vEffect2.addElement(chatPopup);
        return chatPopup;
    }

    public final void update() {
        if (this.c != null) {
            this.cx = this.c.cx;
            this.cy = this.c.cy;
            this.ch = this.c.ch + 10;
        }
        if (this.delay > 0) {
            this.delay--;
        }
        if (this.sayRun > 1) {
            this.sayRun--;
        }
        if (this.c != null && this.c.chatPopup != null && this.c.chatPopup != this || this.c != null && this.c.chatPopup == null || this.delay == 0) {
            Effect2.vEffect2Outside.removeElement(this);
            Effect2.vEffect2.removeElement(this);
        }
    }

    public final void paint(mGraphics g) {
        int value = this.cx;
        int value1 = this.cy;
        g.setColor(16777215);
        g.fillRoundRect(value - this.sayWidth / 2 - 1, value1 - this.ch - 15 + this.sayRun - this.says.length * 12 - 10, this.sayWidth + 2, (this.says.length + 1) * 12 + 1, 12, 12);
        g.setColor(0);
        g.drawRoundRect(value - this.sayWidth / 2 - 1, value1 - this.ch - 15 + this.sayRun - this.says.length * 12 - 10, this.sayWidth + 1, (this.says.length + 1) * 12, 12, 12);
        SmallImage.drawSmallImage(g, 941, value - 3, value1 - this.ch - 15 + this.sayRun + 2, 0, 17);
        for (int index = 0; index < this.says.length; index++) {
            mFont.tahoma_7.drawString(g, this.says[index], value, value1 - this.ch - 15 + this.sayRun + index * 12 - this.says.length * 12 - 4, 2);
        }
    }

    public final void perform(int idAction, Object p) {
        if (idAction == 8000) {
            int value = currentMultilineChatPopup.currentLine;
            if (++value >= currentMultilineChatPopup.lines.length) {
                currentMultilineChatPopup.c.chatPopup = null;
                currentMultilineChatPopup = null;
                return;
            }
            ChatPopup chatPopup;
            (chatPopup = addChatPopup(currentMultilineChatPopup.lines[value], currentMultilineChatPopup.delay, currentMultilineChatPopup.c)).currentLine = value;
            chatPopup.lines = currentMultilineChatPopup.lines;
            chatPopup.cmdNextLine = currentMultilineChatPopup.cmdNextLine;
            currentMultilineChatPopup = chatPopup;
        }
    }
}
