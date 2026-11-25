package nso;

import main.GameCanvas;

public final class Info {

    private static MyVector infoWaitToShow = new MyVector();

    private static InfoItem info;

    private static int p1 = 5;

    private static int p2;

    private static int x;

    private static int strWidth;

    private static int limLeft = 2;

    public static int hI = 15;

    public Info() {
    }

    public static void paint(mGraphics g) {
        int value = GameCanvas.isKiemduyet ? 16 : 0;
        int value1 = GameCanvas.w;
        if (info != null) {
            g.setClip(0, 0, GameCanvas.w, GameCanvas.h);
            if (!GameCanvas.isTouch) {
                Paint.paintFrame(-6, value - 4, value1 + 10, hI + 8, g);
            } else {
                g.setColor(0);
                g.fillRect(0, value, value1, hI);
            }
            g.setClip(0, value, value1, hI + 5);
            info.f.drawString(g, info.s, nso.Info.x, value + 5, 0);
        }
    }

    public static void update() {
        if (GameCanvas.isTouch) {
            hI = 20;
        }
        if (p1 == 0) {
            if ((nso.Info.x = nso.Info.x + (limLeft - nso.Info.x) / 3) - limLeft < 3) {
                nso.Info.x = limLeft + 2;
                p1 = 2;
                nso.Info.p2 = 0;
                return;
            }
        } else if (p1 == 2) {
            if (++nso.Info.p2 > info.speed) {
                p1 = 3;
                nso.Info.p2 = 0;
                return;
            }
        } else if (p1 == 3) {
            if (nso.Info.x + strWidth < limLeft + GameCanvas.w - 160) {
                nso.Info.x -= 6;
            } else {
                nso.Info.x -= 2;
            }
            if (nso.Info.x + strWidth < limLeft) {
                p1 = 4;
                nso.Info.p2 = 0;
                return;
            }
        } else if (p1 == 4) {
            if (++nso.Info.p2 > 10) {
                p1 = 5;
                nso.Info.p2 = 0;
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
                nso.Info.p2 = 0;
                p1 = 0;
                nso.Info.x = GameCanvas.w;
                return;
            }
            info = null;
            if (GameCanvas.isTouch) {
                hI = 0;
            }
        }
    }

    public static void addInfo(String s, int speed, mFont f) {
        String text = s;
        boolean flag;
        if (info != null && info.s != null && text.equals(info.s)) {
            flag = true;
        } else if (infoWaitToShow.size() > 0 && text.equals(((InfoItem) infoWaitToShow.lastElement()).s)) {
            flag = true;
        } else {
            label96: {
                if (text.length() >= 8) {
                    if (info != null && info.s != null && p1 < 3 && info.s.length() >= 8) {
                        String text1 = text.substring(0, 8);
                        String text2 = info.s.substring(0, 8);
                        if (text1.equals(text2)) {
                            int value = 7;
                            while (value < text.length() && value < info.s.length() && text.charAt(value) == info.s.charAt(value)) {
                                value++;
                            }
                            text2 = text.substring(value, text.length());
                            info.s = info.s + ", " + text2;
                            p1 = 2;
                            nso.Info.p2 = 0;
                            flag = true;
                            break label96;
                        }
                    }
                    String text3;
                    if (infoWaitToShow.size() > 0 && (text3 = ((InfoItem) infoWaitToShow.lastElement()).s).length() >= 8) {
                        String text4 = text.substring(0, 8);
                        String text5 = text3.substring(0, 8);
                        if (text4.equals(text5)) {
                            int value6 = 7;
                            while (value6 < text.length() && value6 < text3.length() && text.charAt(value6) == text3.charAt(value6)) {
                                value6++;
                            }
                            text = text.substring(value6, text.length());
                            new StringBuffer(String.valueOf(text3)).append(", ").append(text).toString();
                            flag = true;
                            break label96;
                        }
                    }
                }
                flag = false;
            }
        }
        if (!flag) {
            if (GameCanvas.w == 128) {
                limLeft = 1;
            }
            if (infoWaitToShow.size() > 10) {
                infoWaitToShow.removeElementAt(0);
            }
            infoWaitToShow.addElement(new InfoItem(s, f, speed));
        }
    }
}
