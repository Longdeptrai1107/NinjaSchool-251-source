package nso;

import main.GameCanvas;
import main.MotherCanvas;

public final class ChatTextField implements IActionListener {

    private static ChatTextField instance;

    public TField tfChat;

    public boolean isShow = false;

    GameScr parentScreen;

    private long lastChatTime = 0L;

    public Command left = new Command(mResources.CHAT, this, 8000, null, 1, GameCanvas.h - mScreen.cmdH + 1);

    public Command right = new Command(mResources.DELETE, this, 8001, null, GameCanvas.w - 53, GameCanvas.h - mScreen.cmdH + 1);

    public Command center = null;

    private String to;

    public static ChatTextField gI() {
        return instance == null ? (instance = new ChatTextField()) : instance;
    }

    protected ChatTextField() {
        this.tfChat = new TField();
        this.tfChat.name = "chat";
        this.tfChat.x = 16;
        this.tfChat.width = MotherCanvas.instance.getWidth_new() - 32;
        this.tfChat.height = mScreen.ITEM_HEIGHT + 2;
        this.tfChat.isFocus = true;
        this.tfChat.setMaxTextLenght(40);
    }

    public final void startChat(int value, GameScr gameScr, String text) {
        this.right.caption = mResources.CLOSE;
        this.to = text;
        this.tfChat.keyPressed(value);
        if (!this.tfChat.getText().equals("") && GameCanvas.currentDialog == null) {
            this.parentScreen = gameScr;
            this.isShow = true;
        }
        this.tfChat.title_Null = text;
    }

    public final void showChat(String str) {
        this.right.caption = mResources.CLOSE;
        this.to = str;
        if (GameCanvas.currentDialog == null) {
            this.isShow = true;
            if (GameCanvas.isTouch) {
                this.tfChat.showNativeTextBox();
            }
        }
        this.tfChat.title_Null = str;
    }

    public final void paint(mGraphics g) {
        if (this.isShow) {
            this.tfChat.paint(g);
        }
    }

    public final void perform(int idAction, Object p) {
        switch(idAction) {
            case 8000:
                if (this.parentScreen != null) {
                    long longValue;
                    if ((longValue = System.currentTimeMillis()) - this.lastChatTime < 1000L) {
                        return;
                    }
                    this.lastChatTime = longValue;
                    this.parentScreen.onChatFromMe(this.tfChat.getText(), this.to);
                    this.tfChat.setText("");
                    this.right.caption = mResources.CLOSE;
                    return;
                }
                break;
            case 8001:
                this.tfChat.clear();
                if (this.tfChat.getText().equals("")) {
                    this.isShow = false;
                    this.parentScreen.onCancelChat();
                }
        }
    }
}
