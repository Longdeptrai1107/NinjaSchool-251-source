package nso;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.TextBox;
import javax.microedition.midlet.MIDlet;
import main.GameCanvas;

public final class TField implements IActionListener {

    public int x;

    public int y;

    public int width;

    public int height;

    public boolean isFocus;

    private boolean unusedInputFlag = false;

    private static int typeXpeed = 2;

    private static final int[] MAX_TIME_TO_CONFIRM_KEY = new int[] { 18, 14, 11, 9, 6, 4, 2 };

    private static int CARET_HEIGHT = 0;

    private static String[] print = new String[] { " 0", ".,@?!_1\"/$-():*+<=>;%&~#%^&*{}[];'/1", "abc2áàảãạâấầẩẫậăắằẳẵặ2", "def3đéèẻẽẹêếềểễệ3", "ghi4íìỉĩị4", "jkl5", "mno6óòỏõọôốồổỗộơớờởỡợ6", "pqrs7", "tuv8úùủũụưứừửữự8", "wxyz9ýỳỷỹỵ9", "*", "#" };

    private static String[] printA = new String[] { "0", "1", "abc2", "def3", "ghi4", "jkl5", "mno6", "pqrs7", "tuv8", "wxyz9", "0", "0" };

    public String title = "";

    public String title_Null = "";

    private String text = "";

    private String passwordText = "";

    private String paintedText = "";

    private int caretPos = 0;

    private int counter = 0;

    private int maxTextLenght = 500;

    private int offsetX = 0;

    private int lastKey = -1984;

    private int keyInActiveState = 0;

    private int indexOfActiveChar = 0;

    private int showCaretCounter = 10;

    private int inputType = 0;

    public static boolean isQwerty;

    private static int unusedTypingModeAreaWidth;

    private int mode = 0;

    private static int changeModeKey = 11;

    public static Canvas returnCanvas;

    public static MIDlet midlet;

    public String name = "";

    public Command cmdClear;

    static {
        String[] var10000 = new String[] { "abc", "Abc", "ABC", "123" };
        int[][] var0 = new int[][] { { 32, 48 }, { 49, 69 }, { 50, 84 }, { 51, 85 }, { 52, 68 }, { 53, 71 }, { 54, 74 }, { 55, 67 }, { 56, 66 }, { 57, 77 }, { 42, 128 }, { 35, 137 }, { 33, 113 }, { 63, 97 }, { 64, 121, 122 }, { 46, 111 }, { 44, 108 } };
    }

    public final void showNativeTextBox() {
        TextBox textBox;
        (textBox = new TextBox(this.name, "", this.maxTextLenght, 0)).addCommand(new javax.microedition.lcdui.Command(mResources.OK, 4, 0));
        textBox.addCommand(new javax.microedition.lcdui.Command("Cancel", 3, 0));
        textBox.setCommandListener(new NativeTextBoxListener(this, textBox));
        try {
            if (this.inputType == 2) {
                textBox.setConstraints(65536);
            } else if (this.inputType == 1) {
                textBox.setConstraints(2);
            } else {
                textBox.setConstraints(0);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        textBox.setString(this.text);
        textBox.setMaxSize(this.maxTextLenght);
        Display.getDisplay(nso.TField.midlet).setCurrent(textBox);
    }

    public static boolean setNormal(char ch) {
        return ch >= '0' && ch <= '9' || ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z';
    }

    public TField() {
        this.text = "";
        nso.TField.CARET_HEIGHT = mFont.tahoma_8b.getHeight() + 1;
        this.cmdClear = new Command(mResources.DELETE, this, 1000, null);
        nso.TField.unusedTypingModeAreaWidth = 0;
        if (RMS.loadRMSInt("qwerty") == 1) {
            isQwerty = true;
        }
    }

    public final void clear() {
        if (this.caretPos > 0 && this.text.length() > 0) {
            this.text = this.text.substring(0, this.caretPos - 1) + this.text.substring(this.caretPos, this.text.length());
            this.caretPos--;
            this.setOffset();
            this.setPasswordTest();
        }
    }

    private void setOffset() {
        if (this.inputType == 2) {
            this.paintedText = this.passwordText;
        } else {
            this.paintedText = this.text;
        }
        if (this.offsetX < 0 && mFont.tahoma_8b.getWidth(this.paintedText) + this.offsetX < this.width - 4 - 13) {
            this.offsetX = this.width - 10 - mFont.tahoma_8b.getWidth(this.paintedText);
        }
        if (this.offsetX + mFont.tahoma_8b.getWidth(this.paintedText.substring(0, this.caretPos)) <= 0) {
            this.offsetX = -mFont.tahoma_8b.getWidth(this.paintedText.substring(0, this.caretPos));
            this.offsetX += 40;
        } else if (this.offsetX + mFont.tahoma_8b.getWidth(this.paintedText.substring(0, this.caretPos)) >= this.width - 12) {
            this.offsetX = this.width - 10 - mFont.tahoma_8b.getWidth(this.paintedText.substring(0, this.caretPos)) - 8;
        }
        if (this.offsetX > 0) {
            this.offsetX = 0;
        }
    }

    private void keyPressedAscii(int keyCode) {
        if (this.inputType != 2 && this.inputType != 3 || keyCode >= 48 && keyCode <= 57 || keyCode >= 65 && keyCode <= 90 || keyCode >= 97 && keyCode <= 122) {
            if (this.text.length() < this.maxTextLenght) {
                String text1 = this.text.substring(0, this.caretPos) + (char) keyCode;
                if (this.caretPos < this.text.length()) {
                    text1 = text1 + this.text.substring(this.caretPos, this.text.length());
                }
                this.text = text1;
                this.caretPos++;
                this.setPasswordTest();
                this.setOffset();
            }
        }
    }

    public final boolean keyPressed(int keyCode) {
        if (keyCode != 8 && keyCode != -8 && keyCode != 204) {
            if (keyCode >= 65 && keyCode <= 122 && !isQwerty) {
                isQwerty = true;
                nso.TField.unusedTypingModeAreaWidth = 0;
                RMS.saveRMSInt("qwerty", 1);
            }
            if (isQwerty) {
                if (keyCode == 45) {
                    if (keyCode == this.lastKey && this.keyInActiveState < MAX_TIME_TO_CONFIRM_KEY[nso.TField.typeXpeed]) {
                        this.text = this.text.substring(0, this.caretPos - 1) + '_';
                        this.paintedText = this.text;
                        this.setPasswordTest();
                        this.setOffset();
                        this.lastKey = -1984;
                        return false;
                    }
                    this.lastKey = 45;
                }
                if (keyCode >= 32) {
                    this.keyPressedAscii(keyCode);
                    return false;
                }
            }
            if (keyCode == changeModeKey) {
                this.mode++;
                if (this.mode > 3) {
                    this.mode = 0;
                }
                this.keyInActiveState = 1;
                this.lastKey = keyCode;
                return false;
            } else {
                if (keyCode == 42) {
                    keyCode = 58;
                }
                if (keyCode == 35) {
                    keyCode = 59;
                }
                if (keyCode < 48 || keyCode > 59) {
                    this.indexOfActiveChar = 0;
                    this.lastKey = -1984;
                    if (keyCode == 14) {
                        if (this.caretPos > 0) {
                            this.caretPos--;
                            this.setOffset();
                            this.showCaretCounter = 10;
                            return false;
                        }
                    } else if (keyCode == 15) {
                        if (this.caretPos < this.text.length()) {
                            this.caretPos++;
                            this.setOffset();
                            this.showCaretCounter = 10;
                            return false;
                        }
                    } else {
                        if (keyCode == 19) {
                            this.clear();
                            return false;
                        }
                        this.lastKey = keyCode;
                    }
                } else if (this.inputType == 0 || this.inputType == 2 || this.inputType == 3) {
                    keyCode = keyCode;
                    String[] textLines;
                    if (this.inputType != 2 && this.inputType != 3) {
                        textLines = nso.TField.print;
                    } else {
                        textLines = nso.TField.printA;
                    }
                    if (keyCode == this.lastKey) {
                        this.indexOfActiveChar = (this.indexOfActiveChar + 1) % textLines[keyCode - 48].length();
                        char characterCode = textLines[keyCode - 48].charAt(this.indexOfActiveChar);
                        if (this.mode == 0) {
                            characterCode = Character.toLowerCase(characterCode);
                        } else if (this.mode == 1) {
                            characterCode = Character.toUpperCase(characterCode);
                        } else if (this.mode == 2) {
                            characterCode = Character.toUpperCase(characterCode);
                        } else {
                            characterCode = textLines[keyCode - 48].charAt(textLines[keyCode - 48].length() - 1);
                        }
                        String text1 = this.text.substring(0, this.caretPos - 1) + characterCode;
                        if (this.caretPos < this.text.length()) {
                            text1 = text1 + this.text.substring(this.caretPos, this.text.length());
                        }
                        this.text = text1;
                        this.keyInActiveState = MAX_TIME_TO_CONFIRM_KEY[nso.TField.typeXpeed];
                        this.setPasswordTest();
                    } else if (this.text.length() < this.maxTextLenght) {
                        if (this.mode == 1 && this.lastKey != -1984) {
                            this.mode = 0;
                        }
                        this.indexOfActiveChar = 0;
                        char characterCode2 = textLines[keyCode - 48].charAt(this.indexOfActiveChar);
                        if (this.mode == 0) {
                            characterCode2 = Character.toLowerCase(characterCode2);
                        } else if (this.mode == 1) {
                            characterCode2 = Character.toUpperCase(characterCode2);
                        } else if (this.mode == 2) {
                            characterCode2 = Character.toUpperCase(characterCode2);
                        } else {
                            characterCode2 = textLines[keyCode - 48].charAt(textLines[keyCode - 48].length() - 1);
                        }
                        String text3 = this.text.substring(0, this.caretPos) + characterCode2;
                        if (this.caretPos < this.text.length()) {
                            text3 = text3 + this.text.substring(this.caretPos, this.text.length());
                        }
                        this.text = text3;
                        this.keyInActiveState = MAX_TIME_TO_CONFIRM_KEY[nso.TField.typeXpeed];
                        this.caretPos++;
                        this.setPasswordTest();
                        this.setOffset();
                    }
                    this.lastKey = keyCode;
                } else if (this.inputType == 1) {
                    this.keyPressedAscii(keyCode);
                    this.keyInActiveState = 1;
                }
                return true;
            }
        } else {
            this.clear();
            return true;
        }
    }

    public final void paint(mGraphics graphics) {
        graphics.setClip(0, 0, GameCanvas.w, GameCanvas.h);
        boolean flag = this.isFocus;
        if (this.inputType == 2) {
            this.paintedText = this.passwordText;
        } else {
            this.paintedText = this.text;
        }
        if (this.paintedText.equals("")) {
            this.paintedText = this.title_Null;
        }
        Paint.paintInputTf(graphics, flag, this.x, this.y, this.width, this.height, 4 + this.offsetX + this.x, this.y + (this.height - mFont.tahoma_8b.getHeight()) / 2, this.paintedText);
        graphics.setClip(this.x + 3, this.y + 1, this.width - 4, this.height - 4);
        graphics.setColor(0);
        if (this.isFocus && this.keyInActiveState == 0 && (this.showCaretCounter > 0 || this.counter / 5 % 2 == 0)) {
            graphics.setColor(11184810);
            graphics.fillRect(5 + this.offsetX + this.x + mFont.tahoma_8b.getWidth(this.paintedText.substring(0, this.caretPos)) - 1, this.y + (this.height - nso.TField.CARET_HEIGHT) / 2 + 1, 1, nso.TField.CARET_HEIGHT);
        }
    }

    public final void paint_NonSetClip(mGraphics graphics) {
        boolean flag = this.isFocus;
        if (this.inputType == 2) {
            this.paintedText = this.passwordText;
        } else {
            this.paintedText = this.text;
        }
        if (this.paintedText.equals("")) {
            this.paintedText = this.title_Null;
        }
        Paint.paintInputTf_new(graphics, flag, this.x, this.y, this.width, 4 + this.offsetX + this.x, this.y + (this.height - mFont.tahoma_8b.getHeight()) / 2, this.paintedText);
        graphics.setColor(0);
        if (this.isFocus && this.keyInActiveState == 0 && (this.showCaretCounter > 0 || this.counter / 5 % 2 == 0)) {
            graphics.setColor(11184810);
            graphics.fillRect(5 + this.offsetX + this.x + mFont.tahoma_8b.getWidth(this.paintedText.substring(0, this.caretPos)) - 1, this.y + (this.height - nso.TField.CARET_HEIGHT) / 2 + 1, 1, nso.TField.CARET_HEIGHT);
        }
    }

    private void setPasswordTest() {
        if (this.inputType == 2) {
            this.passwordText = "";
            for (int index = 0; index < this.text.length(); index++) {
                this.passwordText = this.passwordText + "*";
            }
            if (this.keyInActiveState > 0 && this.caretPos > 0) {
                this.passwordText = this.passwordText.substring(0, this.caretPos - 1) + this.text.charAt(this.caretPos - 1) + this.passwordText.substring(this.caretPos, this.passwordText.length());
            }
        }
    }

    public final void update() {
        this.counter++;
        if (this.keyInActiveState > 0) {
            this.keyInActiveState--;
            if (this.keyInActiveState == 0) {
                this.indexOfActiveChar = 0;
                if (this.mode == 1 && this.lastKey != changeModeKey) {
                    this.mode = 0;
                }
                this.lastKey = -1984;
                this.setPasswordTest();
            }
        }
        if (this.showCaretCounter > 0) {
            this.showCaretCounter--;
        }
        if (GameCanvas.isPointerJustRelease) {
            if (GameCanvas.currentScreen == RegisterScr.instance) {
                if (RegisterScr.instance == null) {
                    RegisterScr.instance = new RegisterScr();
                }
                int value = RegisterScr.instance.scroll.cmy;
                if (!GameCanvas.isPointerHoldIn(this.x, this.y - value, this.width, this.height)) {
                    this.isFocus = false;
                    return;
                }
                this.showNativeTextBox();
            } else {
                if (GameCanvas.isPointerHoldIn(this.x, this.y, this.width, this.height)) {
                    this.showNativeTextBox();
                    return;
                }
                this.isFocus = false;
            }
        }
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String text1) {
        if (text1 != null) {
            this.lastKey = -1984;
            this.keyInActiveState = 0;
            this.indexOfActiveChar = 0;
            this.text = text1;
            this.paintedText = text1;
            this.setPasswordTest();
            this.caretPos = text1.length();
            this.setOffset();
        }
    }

    public final void setMaxTextLenght(int value) {
        this.maxTextLenght = value;
    }

    public final void setIputType(int value) {
        this.inputType = value;
    }

    public final void perform(int idAction, Object p) {
        switch(idAction) {
            case 1000:
                this.clear();
        }
    }
}
