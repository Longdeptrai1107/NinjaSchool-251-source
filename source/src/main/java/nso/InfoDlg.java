package nso;

import main.GameCanvas;

public final class InfoDlg {

    static boolean isShow;

    private static String title;

    private static String subtitke;

    public static int delay;

    public static boolean isLock;

    public InfoDlg() {
    }

    public static void show(String title1, String subtitle, int delay2) {
        if (title1 != null) {
            isShow = true;
            title = title1;
            subtitke = subtitle;
            delay = delay2;
        }
    }

    public static void showWait() {
        show(mResources.PLEASEWAIT, null, 5000);
        isLock = true;
    }

    public static void showWait(String str) {
        show(str, null, 5000);
        isLock = true;
    }

    public static void paint(mGraphics g) {
        String text = title;
        if (TileMap.mapName1 != null) {
            text = TileMap.mapName1;
        }
        if (isShow) {
            if (!isLock || delay <= 4990) {
                if (!GameScr.isPaintAlert) {
                    Paint.paintFrame(GameCanvas.hw - 64, 10, 128, 40, g);
                    if (isLock) {
                        GameCanvas.paintShukiren(GameCanvas.hw - mFont.tahoma_8b.getWidth(text) / 2 - 10, 30, g, false);
                        mFont.tahoma_8b.drawString(g, text, GameCanvas.hw + 5, 23, 2);
                    } else if (subtitke != null) {
                        mFont.tahoma_8b.drawString(g, text, GameCanvas.hw, 18, 2);
                        mFont.tahoma_7_white.drawString(g, subtitke, GameCanvas.hw, 32, 2);
                    } else {
                        mFont.tahoma_8b.drawString(g, text, GameCanvas.hw, 23, 2);
                    }
                }
            }
        }
    }

    public static void hide() {
        title = "";
        subtitke = null;
        isLock = false;
        delay = 0;
        isShow = false;
    }
}
