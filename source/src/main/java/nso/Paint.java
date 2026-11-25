package nso;

import javax.microedition.lcdui.Image;
import main.GameCanvas;

public final class Paint {

    public static int COLORBACKGROUND = 6562304;

    public static int COLORLIGHT = 9581056;

    public static int COLORDARK = 3937280;

    public static int COLORBORDER = 15224576;

    public static int COLORFOCUS = 16777215;

    public static int hTab = 24;

    private static int lenCaption = 0;

    public Paint() {
        int[] values = new int[] { 15970400, -844109861, 2250052, 16374659, 15906669, 12931125, 3108954 };
    }

    public static void paintCmdBar(mGraphics graphics, Command command, Command command1, Command command2) {
        mFont font = GameCanvas.isTouch ? mFont.tahoma_7b_yellow : mFont.tahoma_8b;
        int value = GameCanvas.isTouch ? 3 : 1;
        if (!GameCanvas.isTouch) {
            if (command != null) {
                font.drawString(graphics, command.caption, 5, GameCanvas.h - mScreen.cmdH + 4 + value, 0);
            }
            if (command1 != null) {
                font.drawString(graphics, command1.caption, GameCanvas.hw, GameCanvas.h - mScreen.cmdH + 4 + value, 2);
            }
            if (command2 != null) {
                if (command2.img != null) {
                    graphics.drawImage(command2.img, GameCanvas.w - 5, GameCanvas.h - 11, 10);
                    return;
                }
                font.drawString(graphics, command2.caption, GameCanvas.w - 5, GameCanvas.h - mScreen.cmdH + 4 + value, 1);
                return;
            }
        } else {
            if (command != null && (lenCaption = font.getWidth(command.caption)) > 0) {
                if (command.x > 0 && command.y > 0) {
                    command.paint(graphics);
                } else {
                    if (mScreen.keyTouch == 0) {
                        graphics.drawImage(GameScr.imgLbtnFocus, 1, GameCanvas.h - mScreen.cmdH + 1, 0);
                    } else {
                        graphics.drawImage(GameScr.imgLbtn, 1, GameCanvas.h - mScreen.cmdH + 1, 0);
                    }
                    font.drawString(graphics, command.caption, 35, GameCanvas.h - mScreen.cmdH + 4 + value, 2);
                }
            }
            if (command1 != null && (lenCaption = font.getWidth(command1.caption)) > 0) {
                if (command1.x > 0 && command1.y > 0) {
                    command1.paint(graphics);
                } else {
                    if (mScreen.keyTouch == 1) {
                        graphics.drawImage(GameScr.imgLbtnFocus, GameCanvas.hw - 35, GameCanvas.h - mScreen.cmdH + 1, 0);
                    } else {
                        graphics.drawImage(GameScr.imgLbtn, GameCanvas.hw - 35, GameCanvas.h - mScreen.cmdH + 1, 0);
                    }
                    font.drawString(graphics, command1.caption, GameCanvas.hw, GameCanvas.h - mScreen.cmdH + 4 + value, 2);
                }
            }
            if (command2 != null && (lenCaption = font.getWidth(command2.caption)) > 0) {
                if (command2.x > 0 && command2.y > 0) {
                    command2.paint(graphics);
                    return;
                }
                if (mScreen.keyTouch == 2) {
                    graphics.drawImage(GameScr.imgLbtnFocus, GameCanvas.w - 71, GameCanvas.h - mScreen.cmdH + 1, 0);
                } else {
                    graphics.drawImage(GameScr.imgLbtn, GameCanvas.w - 71, GameCanvas.h - mScreen.cmdH + 1, 0);
                }
                font.drawString(graphics, command2.caption, GameCanvas.w - 35, GameCanvas.h - mScreen.cmdH + 4 + value, 2);
            }
        }
    }

    public static void paintCommandBarBackground(mGraphics graphics) {
        if (!GameCanvas.isTouch) {
            graphics.setColor(0);
            graphics.fillRect(0, GameCanvas.h - hTab, GameCanvas.w, hTab + 1);
            graphics.setColor(8947848);
            graphics.fillRect(0, GameCanvas.h - (hTab - 1), GameCanvas.w, 1);
        }
    }

    public static void paintInputTf(mGraphics graphics, boolean flag, int value, int value1, int value2, int value3, int value4, int value5, String text) {
        graphics.setColor(0);
        if (flag) {
            graphics.drawRegion(GameScr.imgTf, 0, 81, 29, 27, 0, value, value1, 0);
            graphics.drawRegion(GameScr.imgTf, 0, 135, 29, 27, 0, value + value2 - 29, value1, 0);
            graphics.drawRegion(GameScr.imgTf, 0, 108, 29, 27, 0, value + value2 - 58, value1, 0);
            for (int index = 0; index < (value2 - 58) / 29; index++) {
                graphics.drawRegion(GameScr.imgTf, 0, 108, 29, 27, 0, value + 29 + index * 29, value1, 0);
            }
        } else {
            graphics.drawRegion(GameScr.imgTf, 0, 0, 29, 27, 0, value, value1, 0);
            graphics.drawRegion(GameScr.imgTf, 0, 54, 29, 27, 0, value + value2 - 29, value1, 0);
            graphics.drawRegion(GameScr.imgTf, 0, 27, 29, 27, 0, value + value2 - 58, value1, 0);
            for (int index6 = 0; index6 < (value2 - 58) / 29; index6++) {
                graphics.drawRegion(GameScr.imgTf, 0, 27, 29, 27, 0, value + 29 + index6 * 29, value1, 0);
            }
        }
        graphics.setClip(value + 3, value1 + 1, value2 - 4, value3 - 4);
        mFont.tahoma_8b.drawString(graphics, text, value4, value5, 0);
    }

    public static void paintInputTf_new(mGraphics graphics, boolean flag, int value, int value1, int value2, int value3, int value4, String text) {
        graphics.setColor(0);
        if (flag) {
            graphics.drawRegion(GameScr.imgTf, 0, 81, 29, 27, 0, value, value1, 0);
            graphics.drawRegion(GameScr.imgTf, 0, 135, 29, 27, 0, value + value2 - 29, value1, 0);
            graphics.drawRegion(GameScr.imgTf, 0, 108, 29, 27, 0, value + value2 - 58, value1, 0);
            for (int index = 0; index < (value2 - 58) / 29; index++) {
                graphics.drawRegion(GameScr.imgTf, 0, 108, 29, 27, 0, value + 29 + index * 29, value1, 0);
            }
        } else {
            graphics.drawRegion(GameScr.imgTf, 0, 0, 29, 27, 0, value, value1, 0);
            graphics.drawRegion(GameScr.imgTf, 0, 54, 29, 27, 0, value + value2 - 29, value1, 0);
            graphics.drawRegion(GameScr.imgTf, 0, 27, 29, 27, 0, value + value2 - 58, value1, 0);
            for (int index5 = 0; index5 < (value2 - 58) / 29; index5++) {
                graphics.drawRegion(GameScr.imgTf, 0, 27, 29, 27, 0, value + 29 + index5 * 29, value1, 0);
            }
        }
        mFont.tahoma_8b.drawString(graphics, text, value3, value4, 0);
    }

    public final void paintInputDlg(mGraphics g, int x, int y, int w, int h, String[] str, Image imgCapcha) {
        if (imgCapcha == null) {
            paintFrame(x, y, w, h, g);
            int value = y + 20 - mFont.tahoma_8b.getHeight();
            y = 0;
            for (int index = value; y < str.length; index += mFont.tahoma_8b.getHeight()) {
                mFont.tahoma_8b.drawString(g, str[y], x + w / 2, index, 2);
                y++;
            }
        } else {
            paintFrame(x, y - imgCapcha.getHeight(), w, h + imgCapcha.getHeight(), g);
            g.drawImage(imgCapcha, x + w / 2, y + h / 2 - 4, 33);
            int value1 = y + 20 - mFont.tahoma_8b.getHeight();
            y = 0;
            for (int index2 = value1; y < str.length; index2 += mFont.tahoma_8b.getHeight()) {
                mFont.tahoma_8b.drawString(g, str[y], x + w / 2, index2 - imgCapcha.getHeight(), 2);
                y++;
            }
        }
    }

    public static void paintFrame(int value, int value1, int value2, int value3, mGraphics graphics) {
        graphics.setColor(COLORBACKGROUND);
        graphics.fillRect(value, value1, value2, value3);
        graphics.setColor(0);
        graphics.drawRect(value - 2, value1 - 2, value2 + 3, value3 + 3);
        graphics.setColor(13948116);
        graphics.drawRect(value - 1, value1 - 1, value2 + 1, value3 + 1);
        graphics.setColor(5720393);
        graphics.drawRect(value, value1, value2 - 1, value3 - 1);
        if (GameCanvas.isTouch) {
            graphics.drawImage(GameCanvas.imgBorder[0], value - 4, value1 - 3, 20);
            graphics.drawRegion(GameCanvas.imgBorder[0], 0, 0, GameCanvas.borderCornerWidth, GameCanvas.borderCornerHeight, 2, value + value2 + 4, value1 - 3, StaticObj.TOP_RIGHT);
            graphics.drawRegion(GameCanvas.imgBorder[0], 0, 0, GameCanvas.borderCornerWidth, GameCanvas.borderCornerHeight, 1, value - 4, value1 + value3 + 3, StaticObj.BOTTOM_LEFT);
            graphics.drawRegion(GameCanvas.imgBorder[0], 0, 0, GameCanvas.borderCornerWidth, GameCanvas.borderCornerHeight, 3, value + value2 + 4, value1 + value3 + 3, StaticObj.BOTTOM_RIGHT);
            graphics.drawImage(GameCanvas.imgBorder[1], value + value2 / 2, value1 - 4, StaticObj.TOP_CENTER);
        }
    }

    public static void paintFrameBorder(int value, int value1, int value2, int value3, mGraphics graphics) {
        graphics.setColor(0);
        graphics.drawRect(value - 2, value1 - 2, value2 + 3, value3 + 3);
        graphics.setColor(13948116);
        graphics.drawRect(value - 1, value1 - 1, value2 + 1, value3 + 1);
        graphics.setColor(5720393);
        graphics.drawRect(value, value1, value2 - 1, value3 - 1);
        if (GameCanvas.isTouch) {
            graphics.drawImage(GameCanvas.imgBorder[0], value - 4, value1 - 3, 20);
            graphics.drawRegion(GameCanvas.imgBorder[0], 0, 0, GameCanvas.borderCornerWidth, GameCanvas.borderCornerHeight, 2, value + value2 + 4, value1 - 3, StaticObj.TOP_RIGHT);
            graphics.drawRegion(GameCanvas.imgBorder[0], 0, 0, GameCanvas.borderCornerWidth, GameCanvas.borderCornerHeight, 1, value - 4, value1 + value3 + 3, StaticObj.BOTTOM_LEFT);
            graphics.drawRegion(GameCanvas.imgBorder[0], 0, 0, GameCanvas.borderCornerWidth, GameCanvas.borderCornerHeight, 3, value + value2 + 4, value1 + value3 + 3, StaticObj.BOTTOM_RIGHT);
            graphics.drawImage(GameCanvas.imgBorder[1], value + value2 / 2, value1 - 4, StaticObj.TOP_CENTER);
        }
    }

    public static void paintFrameInside(int value, int value1, int value2, int value3, mGraphics graphics) {
        graphics.setColor(COLORBACKGROUND);
        graphics.fillRect(value, value1, value2, value3);
    }

    public static void paintFrameInsideSelected(int value, int value1, int value2, int value3, mGraphics graphics) {
        graphics.setColor(COLORLIGHT);
        graphics.fillRect(value, value1, value2, value3);
    }
}
