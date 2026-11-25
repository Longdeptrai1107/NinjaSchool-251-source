package nso;

import main.GameCanvas;

public final class SplashScr extends mScreen {

    public static int splashScrStat;

    public SplashScr() {
    }

    public final void update() {
        if (nso.SplashScr.splashScrStat > 5) {
            if (LanguageScr.loadLanguageID() >= 0) {
                GameCanvas.initGameCanvas();
                GameCanvas.selectsvScr.switchToMe();
            } else {
                GameCanvas.initGameCanvas();
                GameCanvas.languageScr.switchToMe();
            }
        }
        nso.SplashScr.splashScrStat++;
    }
}
