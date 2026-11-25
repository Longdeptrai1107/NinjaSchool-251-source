package nso;

import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.lcdui.Image;
import main.GameCanvas;

public final class mFont {

    private int space;

    private int height;

    private Image imgFont;

    private String strFont;

    private int[][] fImages;

    private static String FONT_CHARACTERS = " 0123456789+-*='_?.,<>/[]{}!@#$%^&*():aáàảãạâấầẩẫậăắằẳẵặbcdđeéèẻẽẹêếềểễệfghiíìỉĩịjklmnoóòỏõọôốồổỗộơớờởỡợpqrstuúùủũụưứừửữựvxyýỳỷỹỵzwAÁÀẢÃẠĂẰẮẲẴẶÂẤẦẨẪẬBCDĐEÉÈẺẼẸÊẾỀỂỄỆFGHIÍÌỈĨỊJKLMNOÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢPQRSTUÚÙỦŨỤƯỨỪỬỮỰVXYÝỲỶỸỴZW";

    public static mFont tahoma_7b_red = new mFont(nso.mFont.FONT_CHARACTERS, "/font/tahoma_7b_red.png", "/font/tahoma_7b", 0, (byte) 0);

    public static mFont tahoma_7b_blue = new mFont(nso.mFont.FONT_CHARACTERS, "/font/tahoma_7b_blue.png", "/font/tahoma_7b", 0, (byte) 0);

    public static mFont tahoma_7b_purple = new mFont(nso.mFont.FONT_CHARACTERS, "/font/tahoma_7b_purple.png", "/font/tahoma_7b", 0, (byte) 0);

    public static mFont tahoma_7b_yellow = new mFont(nso.mFont.FONT_CHARACTERS, "/font/tahoma_7b_yellow.png", "/font/tahoma_7b", 0, (byte) 0);

    public static mFont tahoma_7b_white = new mFont(nso.mFont.FONT_CHARACTERS, "/font/tahoma_7b_white.png", "/font/tahoma_7b", 0, (byte) 0);

    public static mFont tahoma_7b_green = new mFont(nso.mFont.FONT_CHARACTERS, "/font/tahoma_7b_green.png", "/font/tahoma_7b", 0, (byte) 0);

    public static mFont tahoma_7 = new mFont(nso.mFont.FONT_CHARACTERS, "/font/tahoma_7.png", "/font/tahoma_7", 0, (byte) 0);

    public static mFont tahoma_7_blue1 = new mFont(nso.mFont.FONT_CHARACTERS, "/font/tahoma_7_blue1.png", "/font/tahoma_7", 0, (byte) 0);

    public static mFont tahoma_7_white = new mFont(nso.mFont.FONT_CHARACTERS, "/font/tahoma_7_white.png", "/font/tahoma_7", 0, (byte) 0);

    public static mFont tahoma_7_yellow = new mFont(nso.mFont.FONT_CHARACTERS, "/font/tahoma_7_yellow.png", "/font/tahoma_7", 0, (byte) 0);

    public static mFont tahoma_7_grey = new mFont(nso.mFont.FONT_CHARACTERS, "/font/tahoma_7_grey.png", "/font/tahoma_7", 0, (byte) 0);

    public static mFont tahoma_7_red = new mFont(nso.mFont.FONT_CHARACTERS, "/font/tahoma_7_red.png", "/font/tahoma_7", 0, (byte) 0);

    public static mFont tahoma_7_blue = new mFont(nso.mFont.FONT_CHARACTERS, "/font/tahoma_7_blue.png", "/font/tahoma_7", 0, (byte) 0);

    public static mFont tahoma_7_green = new mFont(nso.mFont.FONT_CHARACTERS, "/font/tahoma_7_green.png", "/font/tahoma_7", 0, (byte) 0);

    public static mFont tahoma_8b = new mFont(nso.mFont.FONT_CHARACTERS, "/font/tahoma_8b.png", "/font/tahoma_8b", -1, (byte) 0);

    public static mFont number_yellow = new mFont(" 0123456789+-", "/font/number_yellow.png", "/font/number", 0, (byte) 0);

    public static mFont number_red = new mFont(" 0123456789+-", "/font/number_red.png", "/font/number", 0, (byte) 0);

    public static mFont number_green = new mFont(" 0123456789+-", "/font/number_green.png", "/font/number", 0, (byte) 0);

    public static mFont number_white = new mFont(" 0123456789+-", "/font/number_white.png", "/font/number", 0, (byte) 0);

    public static mFont number_orange = new mFont(" 0123456789+-", "/font/number_orange.png", "/font/number", 0, (byte) 0);

    private String fontImagePath;

    private mFont(String text, String text1, String text2, int value, byte byteValue) {
        try {
            this.strFont = text;
            this.space = value;
            this.fontImagePath = text1;
            DataInputStream dataInputStream = null;
            this.reloadImage();
            try {
                dataInputStream = new DataInputStream(this.getClass().getResourceAsStream(text2));
                this.fImages = new int[dataInputStream.readShort()][];
                for (int index = 0; index < this.fImages.length; index++) {
                    this.fImages[index] = new int[4];
                    this.fImages[index][0] = dataInputStream.readShort();
                    this.fImages[index][1] = dataInputStream.readShort();
                    this.fImages[index][2] = dataInputStream.readShort();
                    this.fImages[index][3] = dataInputStream.readShort();
                    int value3 = this.fImages[index][3];
                    this.height = value3;
                }
            } catch (Exception exception) {
                try {
                    dataInputStream.close();
                } catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
        } catch (Exception exception4) {
            exception4.printStackTrace();
        }
    }

    public final void reloadImage() {
        this.imgFont = GameCanvas.loadImage(this.fontImagePath);
    }

    public final void freeImage() {
        this.imgFont = null;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth(String text) {
        int value = 0;
        for (int index = 0; index < text.length(); index++) {
            int value1;
            if ((value1 = this.strFont.indexOf(text.charAt(index))) == -1) {
                value1 = 0;
            }
            value += this.fImages[value1][2] + this.space;
        }
        return value;
    }

    public final void drawString(mGraphics graphics, String text, int value, int value1, int value2) {
        int count = text.length();
        if (value2 == 0) {
            value2 = value;
        } else if (value2 == 1) {
            value2 = value - this.getWidth(text);
        } else {
            value2 = value - (this.getWidth(text) >> 1);
        }
        for (int index = 0; index < count; index++) {
            if ((value = this.strFont.indexOf(text.charAt(index))) == -1) {
                value = 0;
            }
            if (value > -1) {
                graphics.drawRegion(this.imgFont, this.fImages[value][0], this.fImages[value][1], this.fImages[value][2], this.fImages[value][3], 0, value2, value1, 20);
            }
            value2 += this.fImages[value][2] + this.space;
        }
    }

    public final void drawString(mGraphics g, String st, int x, int y, int align, mFont font) {
        int count = st.length();
        if (align == 0) {
            align = x;
        } else if (align == 1) {
            align = x - this.getWidth(st);
        } else {
            align = x - (this.getWidth(st) >> 1);
        }
        for (int index = 0; index < count; index++) {
            if ((x = this.strFont.indexOf(st.charAt(index))) == -1) {
                x = 0;
            }
            if (x > -1) {
                g.drawRegion(font.imgFont, this.fImages[x][0], this.fImages[x][1], this.fImages[x][2], this.fImages[x][3], 0, align + 1, y, 20);
                g.drawRegion(font.imgFont, this.fImages[x][0], this.fImages[x][1], this.fImages[x][2], this.fImages[x][3], 0, align, y + 1, 20);
                g.drawRegion(this.imgFont, this.fImages[x][0], this.fImages[x][1], this.fImages[x][2], this.fImages[x][3], 0, align, y, 20);
            }
            align += this.fImages[x][2] + this.space;
        }
    }

    public final MyVector splitFontVector(String src, int lineWidth) {
        MyVector entries = new MyVector();
        String text = "";
        for (int index = 0; index < src.length(); index++) {
            if (src.charAt(index) == '\n') {
                entries.addElement(text);
                text = "";
            } else {
                text = text + src.charAt(index);
                if (this.getWidth(text) > lineWidth) {
                    int value = 0;
                    value = text.length() - 1;
                    while (value >= 0 && text.charAt(value) != ' ') {
                        value--;
                    }
                    if (value < 0) {
                        value = text.length() - 1;
                    }
                    entries.addElement(text.substring(0, value));
                    index = index - (text.length() - value) + 1;
                    text = "";
                }
                if (index == src.length() - 1 && !text.trim().equals("")) {
                    entries.addElement(text);
                }
            }
        }
        return entries;
    }

    public final String[] splitFontArray(String text, int value) {
        MyVector entries;
        String[] textLines = new String[(entries = this.splitFontVector(text, value)).size()];
        for (int index = 0; index < entries.size(); index++) {
            textLines[index] = entries.elementAt(index).toString();
        }
        return textLines;
    }
}
