package nso;

import main.GameCanvas;

public final class InfoMe {

    private static MyVector infoWaitToShow = new MyVector();

    private static InfoItem info;

    private static int p1 = 5;

    private static int p2;

    private static int x;

    private static int strWidth;

    private static int limLeft = 2;

    private static int hI = 20;

    public InfoMe() {
    }

    public static void paint(mGraphics g) {
        int value = limLeft;
        int value1 = GameCanvas.h - 23;
        int value2 = GameCanvas.w;
        if (GameCanvas.isTouch) {
            if (GameCanvas.w >= 450) {
                value = 130;
                value2 = GameCanvas.w - 260;
            } else {
                value = 80;
                value2 = GameCanvas.w - 160 - 10;
            }
            value1 = GameCanvas.h - 60;
            limLeft = value + 2;
        }
        if (info != null) {
            if (GameCanvas.currentDialog == null || GameCanvas.currentDialog.center == null) {
                g.setClip(0, 0, GameCanvas.w, GameCanvas.h);
                if (GameCanvas.isTouch) {
                    Paint.paintFrame(value, value1 - 4, value2 + 10, hI + 8, g);
                } else {
                    g.setColor(0);
                    g.fillRect(value - 2, value1, value2 + 2, hI);
                }
                g.setClip(value, value1, value2, hI);
                info.f.drawString(g, info.s, x, value1 + 3, 0);
            }
        }
    }

    public static void update() {
        if (p1 == 0) {
            if ((x = x + (limLeft - x) / 3) - limLeft < 3) {
                x = limLeft + 2;
                p1 = 2;
                nso.InfoMe.p2 = 0;
                return;
            }
        } else if (p1 == 2) {
            if (++nso.InfoMe.p2 > info.speed) {
                p1 = 3;
                nso.InfoMe.p2 = 0;
                return;
            }
        } else if (p1 == 3) {
            if (x + strWidth < limLeft + GameCanvas.w - 20) {
                x -= 6;
            } else {
                x -= 2;
            }
            if (x + strWidth < limLeft) {
                p1 = 4;
                nso.InfoMe.p2 = 0;
                return;
            }
        } else if (p1 == 4) {
            if (++nso.InfoMe.p2 > 10) {
                p1 = 5;
                nso.InfoMe.p2 = 0;
                return;
            }
        } else if (p1 == 5) {
            if (infoWaitToShow.size() > 0) {
                InfoItem infoItem = (InfoItem) infoWaitToShow.firstElement();
                infoWaitToShow.removeElementAt(0);
                if (info != null && infoItem.s.equals(info.s)) {
                    return;
                }
                info = infoItem;
                strWidth = infoItem.f.getWidth(info.s);
                nso.InfoMe.p2 = 0;
                p1 = 0;
                x = GameCanvas.w;
                return;
            }
            info = null;
        }
    }

    public static void addInfo(String s) {
        if (!canMergeString(s)) {
            if (GameCanvas.w == 128) {
                limLeft = 1;
            }
            if (infoWaitToShow.size() > 10) {
                infoWaitToShow.removeElementAt(0);
            }
            infoWaitToShow.addElement(new InfoItem(s));
        }
    }

    private static boolean canMergeString(String s) {
        if (info != null && info.s != null && s.equals(info.s)) {
            return true;
        }
        if (infoWaitToShow.size() > 0 && s.equals(((InfoItem) infoWaitToShow.lastElement()).s)) {
            return true;
        }
        if (s.length() < 8) {
            return false;
        }
        if (info != null && info.s != null && p1 < 3 && info.s.length() >= 8) {
            String text = s.substring(0, 8);
            String text1 = info.s.substring(0, 8);
            if (text.equals(text1)) {
                int value = 7;
                while (value < s.length() && value < info.s.length() && (s.charAt(value) < '0' || s.charAt(value) > '9') && s.charAt(value) == info.s.charAt(value)) {
                    value++;
                }
                text1 = s.substring(value, s.length());
                info.s = info.s + ", " + text1;
                p1 = 2;
                nso.InfoMe.p2 = 0;
                return true;
            }
        }
        String text2;
        if (infoWaitToShow.size() > 0 && (text2 = ((InfoItem) infoWaitToShow.lastElement()).s).length() >= 8) {
            String text3 = s.substring(0, 8);
            String text4 = text2.substring(0, 8);
            if (text3.equals(text4)) {
                int value5 = 7;
                while (value5 < s.length() && value5 < text2.length() && (s.charAt(value5) < '0' || s.charAt(value5) > '9') && s.charAt(value5) == text2.charAt(value5)) {
                    value5++;
                }
                s = s.substring(value5, s.length());
                new StringBuffer(String.valueOf(text2)).append(", ").append(s).toString();
                return true;
            }
        }
        return false;
    }

    public static void addInfo(String s, int speed, mFont f) {
        if (!canMergeString(s)) {
            if (GameCanvas.w == 128) {
                limLeft = 1;
            }
            if (infoWaitToShow.size() > 10) {
                infoWaitToShow.removeElementAt(0);
            }
            infoWaitToShow.addElement(new InfoItem(s, f, speed));
        }
    }

    public static boolean isEmpty() {
        return p1 == 5 && infoWaitToShow.size() == 0;
    }
}
