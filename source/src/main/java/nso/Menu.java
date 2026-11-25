package nso;

import javax.microedition.lcdui.Image;
import main.GameCanvas;

public final class Menu implements IActionListener {

    public boolean showMenu;

    private MyVector menuItems;

    public int menuSelectedItem;

    private int menuX;

    private int menuY;

    private int menuW;

    private int menuH;

    private int renderY;

    private static int cmtoX;

    private static int cmx;

    private static int cmxLim;

    private static int xc;

    private Command left = new Command(mResources.SELECT, 0);

    private Command right = GameCanvas.isTouch ? null : new Command(mResources.CLOSE, 0, GameCanvas.w - 71, GameCanvas.h - mScreen.cmdH + 1);

    private Command center = null;

    private static Image imgButton = GameCanvas.loadImage("/hd/btnlBig0.png");

    private static Image imgButtonFocus = GameCanvas.loadImage("/hd/btnlBig1.png");

    boolean disableClose;

    public boolean showbyServer;

    private int w;

    private int pointerDownTime;

    private int pointerDownFirstX;

    private int[] pointerDownLastX = new int[3];

    private boolean pointerIsDowning;

    private boolean isDownWhenRunning;

    private int waitToPerform;

    private int cmRun;

    public byte wait;

    private int cmvx;

    private int cmdx;

    public Menu() {
    }

    public final void startAt(MyVector entries) {
        this.disableClose = false;
        this.showbyServer = false;
        ChatPopup.currentMultilineChatPopup = null;
        InfoDlg.hide();
        if (entries.size() != 0) {
            this.menuItems = entries;
            this.menuW = 60;
            this.menuH = 60;
            for (int index = 0; index < entries.size(); index++) {
                Command command = (Command) entries.elementAt(index);
                if (mFont.tahoma_7_yellow.getWidth(command.caption) > this.menuW - 8) {
                    command.subCaption = mFont.tahoma_7_yellow.splitFontArray(command.caption, this.menuW - 8);
                }
            }
            this.menuX = (GameCanvas.w - entries.size() * this.menuW) / 2;
            if (this.menuX < 1) {
                this.menuX = 1;
            }
            this.menuY = GameCanvas.h - this.menuH - (Paint.hTab + 1);
            if (GameCanvas.isTouch) {
                this.menuY -= 3;
            }
            this.renderY = this.menuY;
            this.showMenu = true;
            this.menuSelectedItem = 0;
            if ((cmxLim = this.menuItems.size() * this.menuW - GameCanvas.w) < 0) {
                cmxLim = 0;
            }
            cmtoX = 0;
            cmx = 0;
            xc = 50;
            this.w = entries.size() * this.menuW - 1;
            if (this.w > GameCanvas.w - 2) {
                this.w = GameCanvas.w - 2;
            }
            if (GameCanvas.isTouch) {
                this.menuSelectedItem = -1;
            }
        }
    }

    public final void updateMenuKey() {
        if (this.showMenu) {
            if (this.wait > 0) {
                this.wait--;
            }
            boolean flag = false;
            if (GameCanvas.keyPressedz[2] || GameCanvas.keyPressedz[4]) {
                flag = true;
                this.menuSelectedItem--;
                if (this.menuSelectedItem < 0) {
                    this.menuSelectedItem = this.menuItems.size() - 1;
                }
            } else if (GameCanvas.keyPressedz[8] || GameCanvas.keyPressedz[6]) {
                flag = true;
                this.menuSelectedItem++;
                if (this.menuSelectedItem > this.menuItems.size() - 1) {
                    this.menuSelectedItem = 0;
                }
            } else if (GameCanvas.keyPressedz[5]) {
                if (this.center != null) {
                    if (this.center.idAction > 0) {
                        if (this.center.actionListener == GameScr.gI()) {
                            GameScr.gI().actionPerform(this.center.idAction, this.center.p);
                        } else {
                            this.perform(this.center.idAction, this.center.p);
                        }
                    }
                } else {
                    this.waitToPerform = 2;
                }
            } else if (GameCanvas.keyPressedz[12]) {
                if (this.left.idAction > 0) {
                    this.perform(this.left.idAction, this.left.p);
                } else {
                    this.waitToPerform = 2;
                }
            } else if (!this.disableClose && (GameCanvas.keyPressedz[13] || mScreen.getCmdPointerLast(this.right))) {
                Menu menu = this;
                this.showMenu = false;
                InfoDlg.hide();
                if (menu.showbyServer) {
                    Service.gI().menu((byte) 1, Char.getMyChar().npcFocus.template.npcTemplateId, GameCanvas.menu.menuSelectedItem, 0);
                    menu.showbyServer = false;
                }
            }
            this.center = null;
            if (GameScr.isMessageMenu && !GameCanvas.isTouch) {
                Object argument = null;
                Object argument1 = null;
                if (this.menuSelectedItem != -1) {
                    argument1 = (Command) this.menuItems.elementAt(this.menuSelectedItem);
                    if ((argument = ChatManager.gI().findTab(((Command) argument1).caption)) != null && ((ChatTab) argument).type == 2) {
                        this.center = new Command(mResources.HIDE_TAB, this, 1000, argument);
                    }
                }
            }
            if (flag) {
                if ((cmtoX = this.menuSelectedItem * this.menuW + this.menuW - GameCanvas.w / 2) > cmxLim) {
                    cmtoX = cmxLim;
                }
                if (cmtoX < 0) {
                    cmtoX = 0;
                }
                if (this.menuSelectedItem == this.menuItems.size() - 1 || this.menuSelectedItem == 0) {
                    cmx = cmtoX;
                }
            }
            if (this.wait <= 0 && !this.disableClose && GameCanvas.isPointerJustRelease && !GameCanvas.isPointer(this.menuX, this.menuY, this.w, this.menuH) && !this.pointerIsDowning) {
                this.pointerDownTime = this.pointerDownFirstX = 0;
                this.pointerIsDowning = false;
                this.showMenu = false;
                GameCanvas.isPointerJustRelease = false;
                if (this.showbyServer) {
                    Service.gI().menu((byte) 1, Char.getMyChar().npcFocus.template.npcTemplateId, GameCanvas.menu.menuSelectedItem, 0);
                    this.showbyServer = false;
                }
            } else {
                if (GameCanvas.isPointerDown) {
                    if (!this.pointerIsDowning && GameCanvas.isPointer(this.menuX, this.menuY, this.w, this.menuH)) {
                        for (int index = 0; index < this.pointerDownLastX.length; index++) {
                            this.pointerDownLastX[0] = GameCanvas.px;
                        }
                        this.pointerDownFirstX = GameCanvas.px;
                        this.pointerIsDowning = true;
                        this.isDownWhenRunning = this.cmRun != 0;
                        this.cmRun = 0;
                    } else if (this.pointerIsDowning) {
                        this.pointerDownTime++;
                        if (this.pointerDownTime > 5 && this.pointerDownFirstX == GameCanvas.px && !this.isDownWhenRunning) {
                            this.pointerDownFirstX = -1000;
                            this.menuSelectedItem = (cmtoX + GameCanvas.px - this.menuX) / this.menuW;
                        }
                        int value;
                        if ((value = GameCanvas.px - this.pointerDownLastX[0]) != 0 && this.menuSelectedItem != -1) {
                            this.menuSelectedItem = -1;
                        }
                        for (int index2 = this.pointerDownLastX.length - 1; index2 > 0; index2--) {
                            this.pointerDownLastX[index2] = this.pointerDownLastX[index2 - 1];
                        }
                        this.pointerDownLastX[0] = GameCanvas.px;
                        if ((cmtoX -= value) < 0) {
                            cmtoX = 0;
                        }
                        if (cmtoX > cmxLim) {
                            cmtoX = cmxLim;
                        }
                        if (cmx < 0 || cmx > cmxLim) {
                            value /= 2;
                        }
                        cmx -= value;
                    }
                }
                if (GameCanvas.isPointerJustRelease && this.pointerIsDowning) {
                    int value3 = GameCanvas.px - this.pointerDownLastX[0];
                    GameCanvas.isPointerJustRelease = false;
                    if (Res.abs(value3) < 20 && Res.abs(GameCanvas.px - this.pointerDownFirstX) < 20 && !this.isDownWhenRunning) {
                        this.cmRun = 0;
                        cmtoX = cmx;
                        this.pointerDownFirstX = -1000;
                        this.menuSelectedItem = (cmtoX + GameCanvas.px - this.menuX) / this.menuW;
                        this.pointerDownTime = 0;
                        this.waitToPerform = 10;
                    } else if (this.menuSelectedItem != -1 && this.pointerDownTime > 5) {
                        this.pointerDownTime = 0;
                        this.waitToPerform = 1;
                    } else if (this.menuSelectedItem == -1 && !this.isDownWhenRunning) {
                        if (cmx < 0) {
                            cmtoX = 0;
                        } else if (cmx > cmxLim) {
                            cmtoX = cmxLim;
                        } else {
                            int value4;
                            byte byteValue;
                            if ((value4 = GameCanvas.px - this.pointerDownLastX[0] + (this.pointerDownLastX[0] - this.pointerDownLastX[1]) + (this.pointerDownLastX[1] - this.pointerDownLastX[2])) > 10) {
                                byteValue = 10;
                            } else if (value4 < -10) {
                                byteValue = -10;
                            } else {
                                byteValue = 0;
                            }
                            this.cmRun = -byteValue * 100;
                        }
                    }
                    this.pointerIsDowning = false;
                    this.pointerDownTime = 0;
                    GameCanvas.isPointerJustRelease = false;
                }
                GameCanvas.clearKeyPressed();
                GameCanvas.clearKeyHold();
            }
        }
    }

    public final void paintMenu(mGraphics g) {
        try {
            g.translate(-g.getTranslateX(), -g.getTranslateY());
            g.translate(-cmx, 0);
            if (GameCanvas.isTouch) {
                for (int index = 0; index < this.menuItems.size(); index++) {
                    if (index == this.menuSelectedItem) {
                        g.drawImage(nso.Menu.imgButtonFocus, this.menuX + index * this.menuW + 1, this.renderY + 1, 0);
                    } else {
                        g.drawImage(nso.Menu.imgButton, this.menuX + index * this.menuW + 1, this.renderY + 1, 0);
                    }
                    String[] textLines;
                    if ((textLines = ((Command) this.menuItems.elementAt(index)).subCaption) == null) {
                        textLines = new String[] { ((Command) this.menuItems.elementAt(index)).caption };
                    }
                    int value = this.renderY + (this.menuH - textLines.length * 14) / 2 + 1;
                    for (int index1 = 0; index1 < textLines.length; index1++) {
                        if (GameScr.isMessageMenu) {
                            if (ChatManager.gI().findWaitPerson(textLines[index1])) {
                                if (GameCanvas.gameTick % 10 > 5) {
                                    mFont.tahoma_7_red.drawString(g, textLines[index1], this.menuX + index * this.menuW + this.menuW / 2 - 2, value + index1 * 14, 2);
                                } else {
                                    mFont.tahoma_7_yellow.drawString(g, textLines[index1], this.menuX + index * this.menuW + this.menuW / 2 - 2, value + index1 * 14, 2);
                                }
                            } else {
                                mFont.tahoma_7_yellow.drawString(g, textLines[index1], this.menuX + index * this.menuW + this.menuW / 2 - 2, value + index1 * 14, 2);
                            }
                        } else {
                            mFont.tahoma_7_yellow.drawString(g, textLines[index1], this.menuX + index * this.menuW + this.menuW / 2 - 2, value + index1 * 14, 2);
                        }
                    }
                }
            } else {
                for (int index2 = 0; index2 < this.menuItems.size(); index2++) {
                    if (index2 == this.menuSelectedItem) {
                        g.drawImage(nso.Menu.imgButtonFocus, this.menuX + index2 * this.menuW + 1, this.renderY + 1 - 23, 0);
                    } else {
                        g.drawImage(nso.Menu.imgButton, this.menuX + index2 * this.menuW + 1, this.renderY + 1 - 23, 0);
                    }
                    String[] textLines3;
                    if ((textLines3 = ((Command) this.menuItems.elementAt(index2)).subCaption) == null) {
                        textLines3 = new String[] { ((Command) this.menuItems.elementAt(index2)).caption };
                    }
                    int value4 = this.renderY + (this.menuH - textLines3.length * 14) / 2 + 1 - 23;
                    for (int index5 = 0; index5 < textLines3.length; index5++) {
                        if (GameScr.isMessageMenu) {
                            if (ChatManager.gI().findWaitPerson(textLines3[index5])) {
                                if (GameCanvas.gameTick % 10 > 5) {
                                    mFont.tahoma_7_red.drawString(g, textLines3[index5], this.menuX + index2 * this.menuW + this.menuW / 2 - 2, value4 + index5 * 14, 2);
                                } else {
                                    mFont.tahoma_7_yellow.drawString(g, textLines3[index5], this.menuX + index2 * this.menuW + this.menuW / 2 - 2, value4 + index5 * 14, 2);
                                }
                            } else {
                                mFont.tahoma_7_yellow.drawString(g, textLines3[index5], this.menuX + index2 * this.menuW + this.menuW / 2 - 2, value4 + index5 * 14, 2);
                            }
                        } else {
                            mFont.tahoma_7_yellow.drawString(g, textLines3[index5], this.menuX + index2 * this.menuW + this.menuW / 2 - 2, value4 + index5 * 14, 2);
                        }
                    }
                }
            }
            g.translate(-g.getTranslateX(), -g.getTranslateY());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public final void moveCamera() {
        Menu menu = this;
        if (this.cmRun != 0 && !menu.pointerIsDowning) {
            if ((cmtoX = cmtoX + menu.cmRun / 100) < 0) {
                cmtoX = 0;
            } else if (cmtoX > cmxLim) {
                cmtoX = cmxLim;
            } else {
                cmx = cmtoX;
            }
            menu.cmRun = menu.cmRun * 9 / 10;
            if (menu.cmRun < 100 && menu.cmRun > -100) {
                menu.cmRun = 0;
            }
        }
        if (cmx != cmtoX && !menu.pointerIsDowning) {
            menu.cmvx = cmtoX - cmx << 2;
            menu.cmdx = menu.cmdx + menu.cmvx;
            cmx = cmx + (menu.cmdx >> 4);
            menu.cmdx &= 15;
        }
        if (this.renderY > this.menuY) {
            int value;
            if ((value = this.renderY - this.menuY >> 1) < 1) {
                value = 1;
            }
            this.renderY -= value;
        }
        if (xc != 0 && (xc >>= 1) < 0) {
            xc = 0;
        }
        if (this.waitToPerform > 0) {
            this.waitToPerform--;
            GameScr.isMessageMenu = false;
            if (this.waitToPerform == 0) {
                this.showMenu = false;
                Command command;
                if (this.menuSelectedItem >= 0 && (command = (Command) this.menuItems.elementAt(this.menuSelectedItem)) != null) {
                    command.performAction();
                }
            }
        }
    }

    public final void perform(int idAction, Object p) {
        if (idAction == 1000) {
            ChatTab chatTab = (ChatTab) p;
            this.menuItems.removeAllElements();
            ChatManager.gI().removeFromWaitList(chatTab.ownerName);
            ChatManager.gI().chatTabs.removeElement(chatTab);
            for (int index = 0; index < ChatManager.gI().chatTabs.size(); index++) {
                p = (ChatTab) ChatManager.gI().chatTabs.elementAt(index);
                this.menuItems.addElement(new Command(((ChatTab) p).ownerName, null, 12001, new Integer(index)));
            }
            this.menuItems.addElement(new Command(mResources.BLOCK_MESSAGE, null, 12006, null));
            this.menuItems.addElement(new Command(mResources.CHAT_ADMIN, null, 12008, null));
            for (int index1 = 0; index1 < this.menuItems.size(); index1++) {
                Command command = (Command) this.menuItems.elementAt(index1);
                if (mFont.tahoma_7_yellow.getWidth(command.caption) > this.menuW - 8) {
                    command.subCaption = mFont.tahoma_7_yellow.splitFontArray(command.caption, this.menuW - 8);
                }
            }
            cmxLim = this.menuItems.size() * this.menuW - GameCanvas.w;
            if ((cmtoX = this.menuSelectedItem * this.menuW + this.menuW - GameCanvas.w / 2) > cmxLim) {
                cmtoX = cmxLim;
            }
            if (cmtoX < 0) {
                cmtoX = 0;
            }
            if (this.menuSelectedItem == this.menuItems.size() - 1 || this.menuSelectedItem == 0) {
                cmx = cmtoX;
            }
        }
    }
}
