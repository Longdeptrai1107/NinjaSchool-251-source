package nso;

import java.util.Random;
import main.GameCanvas;

public final class Res {

    private static short[] SIN = new short[] { 0, 18, 36, 54, 71, 89, 107, 125, 143, 160, 178, 195, 213, 230, 248, 265, 282, 299, 316, 333, 350, 367, 384, 400, 416, 433, 449, 465, 481, 496, 512, 527, 543, 558, 573, 587, 602, 616, 630, 644, 658, 672, 685, 698, 711, 724, 737, 749, 761, 773, 784, 796, 807, 818, 828, 839, 849, 859, 868, 878, 887, 896, 904, 912, 920, 928, 935, 943, 949, 956, 962, 968, 974, 979, 984, 989, 994, 998, 1002, 1005, 1008, 1011, 1014, 1016, 1018, 1020, 1022, 1023, 1023, 1024, 1024 };

    private static short[] COS;

    private static int[] TAN;

    private static Random r = new Random();

    public Res() {
    }

    public static void init() {
        COS = new short[91];
        TAN = new int[91];
        for (int index = 0; index <= 90; index++) {
            COS[index] = SIN[90 - index];
            if (COS[index] == 0) {
                TAN[index] = Integer.MAX_VALUE;
            } else {
                TAN[index] = (SIN[index] << 10) / COS[index];
            }
        }
    }

    public static final int sin(int a) {
        if ((a = fixangle(a)) >= 0 && a < 90) {
            return SIN[a];
        } else if (a >= 90 && a < 180) {
            return SIN[180 - a];
        } else {
            return a >= 180 && a < 270 ? -SIN[a - 180] : -SIN[360 - a];
        }
    }

    public static final int cos(int a) {
        if ((a = fixangle(a)) >= 0 && a < 90) {
            return COS[a];
        } else if (a >= 90 && a < 180) {
            return -COS[180 - a];
        } else {
            return a >= 180 && a < 270 ? -COS[a - 180] : COS[360 - a];
        }
    }

    public static final int angle(int value, int value1) {
        int value2;
        if (value != 0) {
            int value3 = Math.abs((value1 << 10) / value);
            label44: {
                for (int index = 0; index <= 90; index++) {
                    if (TAN[index] >= value3) {
                        value2 = index;
                        break label44;
                    }
                }
                value2 = 0;
            }
            value3 = value2;
            if (value1 >= 0 && value < 0) {
                value3 = 180 - value3;
            }
            if (value1 < 0 && value < 0) {
                value3 += 180;
            }
            if (value1 >= 0 || value < 0) {
                return value3;
            }
            value2 = 360 - value3;
        } else {
            value2 = value1 > 0 ? 90 : 270;
        }
        return value2;
    }

    public static final int fixangle(int value) {
        if (value >= 360) {
            value -= 360;
        }
        if (value < 0) {
            value += 360;
        }
        return value;
    }

    public static int xetVX(int value, int value1) {
        return cos(fixangle(value)) * value1 >> 10;
    }

    public static int xetVY(int value, int value1) {
        return sin(fixangle(value)) * value1 >> 10;
    }

    public static int random(int value, int value1) {
        return value + r.nextInt(value1 - value);
    }

    public static int distance(int x1, int y1, int x2, int y2) {
        if ((x1 = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) <= 0) {
            return 0;
        }
        y1 = (x1 + 1) / 2;
        do {
            x2 = y1;
            y1 = y1 / 2 + x1 / (y1 * 2);
        } while (Math.abs(x2 - y1) > 1);
        return y1;
    }

    public static int rnd(int value) {
        return r.nextInt(value);
    }

    public static int abs(int value) {
        return value > 0 ? value : -value;
    }

    public static void resetTrans(mGraphics g) {
        g.translate(-g.getTranslateX(), -g.getTranslateY());
        g.setClip(0, 0, GameCanvas.w, GameCanvas.h);
    }

    public static String[] split(String original, String separator, int count) {
        int value;
        String[] textLines;
        if ((value = original.indexOf(separator)) >= 0) {
            textLines = split(original.substring(value + separator.length()), separator, count + 1);
        } else {
            textLines = new String[count + 1];
            value = original.length();
        }
        textLines[count] = original.substring(0, value);
        return textLines;
    }

    public static String getTimeCountDown(long timeStart, int milisecondCount) {
        String text = "";
        long longValue;
        if ((longValue = (timeStart + milisecondCount - System.currentTimeMillis()) / 1000L) <= 0L) {
            return "";
        }
        long longValue1 = 0L;
        long longValue2 = 0L;
        long longValue3 = longValue / 60L;
        long longValue4 = longValue;
        if (longValue >= 86400L) {
            longValue1 = longValue / 86400L;
            longValue2 = longValue % 86400L / 3600L;
        } else if (longValue >= 3600L) {
            longValue2 = longValue / 3600L;
            longValue3 = longValue % 3600L / 60L;
        } else if (longValue >= 60L) {
            longValue3 = longValue / 60L;
            longValue4 = longValue % 60L;
        } else {
            longValue4 = longValue;
        }
        String text5;
        if (longValue1 > 0L) {
            if (longValue1 >= 10L) {
                text5 = longValue2 < 1L ? longValue1 + "d" : (longValue2 < 10L ? longValue1 + "d" + "0" + longValue2 + "h" : longValue1 + "d" + longValue2 + "h");
            } else {
                if (longValue1 >= 10L) {
                    return text;
                }
                text5 = longValue2 < 1L ? longValue1 + "d" : (longValue2 < 10L ? longValue1 + "d" + "0" + longValue2 + "h" : longValue1 + "d" + longValue2 + "h");
            }
        } else if (longValue2 > 0L) {
            if (longValue2 >= 10L) {
                text5 = longValue3 < 1L ? longValue2 + "h" : (longValue3 < 10L ? longValue2 + "h" + "0" + longValue3 + "m" : longValue2 + "h" + longValue3 + "m");
            } else {
                if (longValue2 >= 10L) {
                    return text;
                }
                text5 = longValue3 < 1L ? longValue2 + "h" : (longValue3 < 10L ? longValue2 + "h" + "0" + longValue3 + "m" : longValue2 + "h" + longValue3 + "m");
            }
        } else if (longValue3 > 0L) {
            if (longValue3 >= 10L) {
                if (longValue4 >= 10L) {
                    text5 = longValue3 + "m" + longValue4 + "s";
                } else {
                    if (longValue4 >= 10L) {
                        return text;
                    }
                    text5 = longValue3 + "m" + "0" + longValue4 + "s";
                }
            } else {
                if (longValue3 >= 10L) {
                    return text;
                }
                if (longValue4 >= 10L) {
                    text5 = longValue3 + "m" + longValue4 + "s";
                } else {
                    if (longValue4 >= 10L) {
                        return text;
                    }
                    text5 = longValue3 + "m" + "0" + longValue4 + "s";
                }
            }
        } else {
            text5 = longValue4 < 10L ? "0" + longValue4 + "s" : longValue4 + "s";
        }
        return text5;
    }
}
