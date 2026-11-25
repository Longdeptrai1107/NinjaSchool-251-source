package nso;

import javax.microedition.lcdui.Image;
import main.GameCanvas;

public final class GameData {

    public static int ID_START_SKILL = 0;

    public static mHashtable listImgIcon = new mHashtable();

    public static mHashtable listbyteData = new mHashtable();

    public GameData() {
    }

    public static ImageIcon getImgIcon(short id) {
        try {
            ImageIcon imageIcon;
            if ((imageIcon = (ImageIcon) listImgIcon.get(String.valueOf(id))) == null || imageIcon != null && imageIcon.img == null) {
                if (imageIcon == null) {
                    imageIcon = new ImageIcon();
                    listImgIcon.put(String.valueOf(id), imageIcon);
                }
                imageIcon.img = Controller.createImage(RMS.loadRMS("effect " + id));
                if (imageIcon.img == null && System.currentTimeMillis() / 1000L - imageIcon.timeGetBack > 10L) {
                    imageIcon.timeGetBack = (int) (System.currentTimeMillis() / 1000L);
                    if (id >= 0) {
                        imageIcon.img = GameCanvas.loadImage("/eff_auto/" + id + ".png");
                    }
                    if (imageIcon.img == null && Session_ME.gI().isConnected()) {
                        Service.gI().doGetImgIcon(id);
                        imageIcon.timeGetBack = (int) (System.currentTimeMillis() / 1000L);
                    }
                    System.currentTimeMillis();
                }
            } else {
                System.currentTimeMillis();
            }
            return imageIcon;
        } catch (Exception exception) {
            return null;
        }
    }

    public static void setImgIcon(short id, byte[] data) {
        try {
            ImageIcon imageIcon;
            if ((imageIcon = (ImageIcon) listImgIcon.get(String.valueOf(id))) == null) {
                imageIcon = new ImageIcon();
            }
            listImgIcon.put(String.valueOf(id), imageIcon);
            if (data.length > 0) {
                imageIcon.img = Image.createImage(data, 0, data.length);
            } else {
                imageIcon.timeGetBack = (int) (System.currentTimeMillis() / 1000L);
            }
            System.currentTimeMillis();
        } catch (Exception exception) {
        }
    }
}
