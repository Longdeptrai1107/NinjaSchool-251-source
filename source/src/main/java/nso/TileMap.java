package nso;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Vector;
import javax.microedition.lcdui.Image;
import main.GameCanvas;
import main.GameMidlet;
import java.io.IOException;

public final class TileMap {

    public static int tmw;

    public static int tmh;

    public static int pxw;

    public static int pxh;

    public static int tileID;

    public static char[] maps;

    public static int[] types;

    private static Image imgTile;

    private static Image imgTileSmall;

    public static Image imgMiniMap;

    private static Image imgWaterfall;

    private static Image imgTopWaterfall;

    private static Image imgWaterflow;

    private static Image imgLeaf;

    private static Image imgflowRiver;

    public static byte size = 24;

    private static int bx;

    private static int dbx;

    private static int fx;

    private static int dfx;

    public static String mapName1 = null;

    public static String mapName = "";

    public static byte zoneID;

    public static byte bgID;

    public static byte typeMap;

    public static short mapID;

    private static int cmtoYmini;

    private static int cmyMini;

    private static int cmdyMini;

    private static int cmvyMini;

    private static int cmtoXMini;

    private static int cmxMini;

    private static int cmdxMini;

    private static int cmvxMini;

    public static int wMiniMap;

    public static int hMiniMap;

    public static int posMiniMapX;

    public static int posMiniMapY;

    public static Vector vGo = new Vector();

    public static String[] mapNames;

    public static StringHashtable locationStand = new StringHashtable();

    public static StringHashtable itemMap = new StringHashtable();

    private static int defaultSolidTile;

    public static int sizeMiniMap = 2;

    public static int gssx;

    public static int gssxe;

    public static int gssy;

    public static int gssye;

    public static int countx;

    public static int county;

    private static int[] colorMini = new int[] { 5257738, 8807192 };

    public TileMap() {
    }

    public static void setPosMiniMap(int x, int y, int w, int h) {
        nso.TileMap.wMiniMap = w;
        nso.TileMap.hMiniMap = h;
        nso.TileMap.posMiniMapX = x;
        nso.TileMap.posMiniMapY = y;
    }

    public static void updateMiniMap() {
        nso.TileMap.cmtoXMini = Char.getMyChar().cx / 12;
        nso.TileMap.cmtoYmini = Char.getMyChar().cy / 12;
        if (nso.TileMap.cmtoXMini > tmw * nso.TileMap.sizeMiniMap - nso.TileMap.wMiniMap / 2) {
            nso.TileMap.cmtoXMini = tmw * nso.TileMap.sizeMiniMap - nso.TileMap.wMiniMap;
        } else if (nso.TileMap.cmtoXMini < nso.TileMap.wMiniMap / 2) {
            nso.TileMap.cmtoXMini = 0;
        } else {
            nso.TileMap.cmtoXMini = nso.TileMap.cmtoXMini - nso.TileMap.wMiniMap / 2;
        }
        if (nso.TileMap.cmtoYmini < nso.TileMap.hMiniMap / 2) {
            nso.TileMap.cmtoYmini = 0;
        } else {
            nso.TileMap.cmtoYmini = nso.TileMap.cmtoYmini - nso.TileMap.hMiniMap / 2;
        }
        if (nso.TileMap.cmtoYmini > nso.TileMap.tmh * nso.TileMap.sizeMiniMap - nso.TileMap.hMiniMap) {
            nso.TileMap.cmtoYmini = nso.TileMap.tmh * nso.TileMap.sizeMiniMap - nso.TileMap.hMiniMap;
        }
    }

    public static void updateCmMiniMap() {
        if (tmw * nso.TileMap.sizeMiniMap >= nso.TileMap.wMiniMap || nso.TileMap.tmh * nso.TileMap.sizeMiniMap >= nso.TileMap.hMiniMap) {
            if (nso.TileMap.cmyMini != nso.TileMap.cmtoYmini) {
                nso.TileMap.cmvyMini = nso.TileMap.cmtoYmini - nso.TileMap.cmyMini << 2;
                nso.TileMap.cmdyMini = nso.TileMap.cmdyMini + nso.TileMap.cmvyMini;
                nso.TileMap.cmyMini = nso.TileMap.cmyMini + (nso.TileMap.cmdyMini >> 4);
                nso.TileMap.cmdyMini &= 15;
            }
            if (nso.TileMap.cmxMini != nso.TileMap.cmtoXMini) {
                nso.TileMap.cmvxMini = nso.TileMap.cmtoXMini - nso.TileMap.cmxMini << 2;
                nso.TileMap.cmdxMini = nso.TileMap.cmdxMini + nso.TileMap.cmvxMini;
                nso.TileMap.cmxMini = nso.TileMap.cmxMini + (nso.TileMap.cmdxMini >> 4);
                nso.TileMap.cmdxMini &= 15;
            }
        }
    }

    public static void freeTileImage() {
        nso.TileMap.imgTile = null;
        System.gc();
    }

    static final void loadTileImage() {
        if (nso.TileMap.imgLeaf == null) {
            nso.TileMap.imgLeaf = GameCanvas.loadImage("/t/uwt.png");
        }
        if (imgWaterfall == null) {
            imgWaterfall = GameCanvas.loadImage("/t/wtf.png");
        }
        if (imgTopWaterfall == null) {
            imgTopWaterfall = GameCanvas.loadImage("/t/twtf.png");
        }
        if (nso.TileMap.imgWaterflow == null) {
            nso.TileMap.imgWaterflow = GameCanvas.loadImage("/t/wts.png");
        }
        if (nso.TileMap.imgflowRiver == null) {
            nso.TileMap.imgflowRiver = GameCanvas.loadImage("/t/wts1.png");
        }
        System.gc();
    }

    public static void loadMap(int tileId) {
        nso.TileMap.pxh = nso.TileMap.tmh * size;
        nso.TileMap.pxw = tmw * size;
        try {
            for (int index = 0; index < tmw * nso.TileMap.tmh; index++) {
                int value = index;
                if (nso.TileMap.locationStand != null ? nso.TileMap.locationStand.get(String.valueOf(value)) != null : false) {
                    types[index] = types[index] | 2;
                }
                if (tileId == 4) {
                    if (maps[index] == 1 || maps[index] == 2 || maps[index] == 3 || maps[index] == 4 || maps[index] == 5 || maps[index] == 6 || maps[index] == '\t' || maps[index] == '\n' || maps[index] == 'O' || maps[index] == 'P' || maps[index] == '\r' || maps[index] == 14 || maps[index] == '+' || maps[index] == ',' || maps[index] == '-' || maps[index] == '2') {
                        types[index] = types[index] | 2;
                    }
                    if (maps[index] == '\t' || maps[index] == 11) {
                        types[index] = types[index] | 4;
                    }
                    if (maps[index] == '\n' || maps[index] == '\f') {
                        types[index] = types[index] | 8;
                    }
                    if (maps[index] == '\r' || maps[index] == 14) {
                        types[index] = types[index] | 1024;
                    }
                    if (maps[index] == 'L' || maps[index] == 'M') {
                        types[index] = types[index] | 64;
                        if (maps[index] == 'N') {
                            types[index] = types[index] | 4096;
                        }
                    }
                }
                if (tileId == 1) {
                    if (maps[index] == 22) {
                        defaultSolidTile = maps[index] - 1;
                    }
                    if (maps[index] == 1 || maps[index] == 2 || maps[index] == 3 || maps[index] == 4 || maps[index] == 5 || maps[index] == 6 || maps[index] == 7 || maps[index] == '$' || maps[index] == '%' || maps[index] == '6' || maps[index] == '[' || maps[index] == '\\' || maps[index] == ']' || maps[index] == '^' || maps[index] == 'I' || maps[index] == 'J' || maps[index] == 'a' || maps[index] == 'b' || maps[index] == 't' || maps[index] == 'u' || maps[index] == 'v' || maps[index] == 'x' || maps[index] == '=') {
                        types[index] = types[index] | 2;
                    }
                    if (maps[index] == 2 || maps[index] == 3 || maps[index] == 4 || maps[index] == 5 || maps[index] == 6 || maps[index] == 20 || maps[index] == 21 || maps[index] == 22 || maps[index] == 23 || maps[index] == '$' || maps[index] == '%' || maps[index] == '&' || maps[index] == '\'' || maps[index] == '=') {
                        types[index] = types[index] | 4096;
                    }
                    if (maps[index] == '\b' || maps[index] == '\t' || maps[index] == '\n' || maps[index] == '\f' || maps[index] == '\r' || maps[index] == 14 || maps[index] == 30) {
                        types[index] = types[index] | 16;
                    }
                    if (maps[index] == 17) {
                        types[index] = types[index] | 32;
                    }
                    if (maps[index] == 18) {
                        types[index] = types[index] | 128;
                    }
                    if (maps[index] == '%' || maps[index] == '&' || maps[index] == '=') {
                        types[index] = types[index] | 4;
                    }
                    if (maps[index] == '$' || maps[index] == '\'' || maps[index] == '=') {
                        types[index] = types[index] | 8;
                    }
                    if (maps[index] == 19) {
                        types[index] = types[index] | 64;
                        if ((types[index - tmw] & 4096) == 4096) {
                            types[index] = types[index] | 4096;
                        }
                    }
                    if (maps[index] == '#') {
                        types[index] = types[index] | 2048;
                    }
                    if (maps[index] == 7) {
                        types[index] = types[index] | 1024;
                    }
                    if (maps[index] == ' ' || maps[index] == '!' || maps[index] == '"') {
                        types[index] = types[index] | 256;
                    }
                }
                if (tileId == 2) {
                    if (maps[index] == 22 || maps[index] == 'g' || maps[index] == 'o') {
                        defaultSolidTile = maps[index] - 1;
                    }
                    if (maps[index] == 1 || maps[index] == 2 || maps[index] == 3 || maps[index] == 4 || maps[index] == 5 || maps[index] == 6 || maps[index] == 7 || maps[index] == '$' || maps[index] == '%' || maps[index] == '6' || maps[index] == '=' || maps[index] == 'I' || maps[index] == 'L' || maps[index] == 'M' || maps[index] == 'N' || maps[index] == 'O' || maps[index] == 'R' || maps[index] == 'S' || maps[index] == 'b' || maps[index] == 'c' || maps[index] == 'd' || maps[index] == 'f' || maps[index] == 'g' || maps[index] == 'l' || maps[index] == 'm' || maps[index] == 'n' || maps[index] == 'p' || maps[index] == 'q' || maps[index] == 't' || maps[index] == 'u' || maps[index] == '}' || maps[index] == '~' || maps[index] == 127 || maps[index] == 129 || maps[index] == 130) {
                        types[index] = types[index] | 2;
                    }
                    if (maps[index] == 1 || maps[index] == 3 || maps[index] == 4 || maps[index] == 5 || maps[index] == 6 || maps[index] == 20 || maps[index] == 21 || maps[index] == 22 || maps[index] == 23 || maps[index] == '$' || maps[index] == '%' || maps[index] == '&' || maps[index] == '\'' || maps[index] == '7' || maps[index] == 'm' || maps[index] == 'o' || maps[index] == 'p' || maps[index] == 'q' || maps[index] == 'r' || maps[index] == 's' || maps[index] == 't' || maps[index] == 127 || maps[index] == 129 || maps[index] == 130) {
                        types[index] = types[index] | 4096;
                    }
                    if (maps[index] == '\b' || maps[index] == '\t' || maps[index] == '\n' || maps[index] == '\f' || maps[index] == '\r' || maps[index] == 14 || maps[index] == 30 || maps[index] == 135) {
                        types[index] = types[index] | 16;
                    }
                    if (maps[index] == 17) {
                        types[index] = types[index] | 32;
                    }
                    if (maps[index] == 18) {
                        types[index] = types[index] | 128;
                    }
                    if (maps[index] == '=' || maps[index] == '%' || maps[index] == '&' || maps[index] == 127 || maps[index] == 130 || maps[index] == 131) {
                        types[index] = types[index] | 4;
                    }
                    if (maps[index] == '=' || maps[index] == '$' || maps[index] == '\'' || maps[index] == 127 || maps[index] == 129 || maps[index] == 132) {
                        types[index] = types[index] | 8;
                    }
                    if (maps[index] == 19) {
                        types[index] = types[index] | 64;
                        if ((types[index - tmw] & 4096) == 4096) {
                            types[index] = types[index] | 4096;
                        }
                    }
                    if (maps[index] == 134) {
                        types[index] = types[index] | 64;
                        if ((types[index - tmw] & 4096) == 4096) {
                            types[index] = types[index] | 4096;
                        }
                    }
                    if (maps[index] == '#') {
                        types[index] = types[index] | 2048;
                    }
                    if (maps[index] == 7) {
                        types[index] = types[index] | 1024;
                    }
                    if (maps[index] == ' ' || maps[index] == '!' || maps[index] == '"') {
                        types[index] = types[index] | 256;
                    }
                    if (maps[index] == '=' || maps[index] == 127) {
                        types[index] = types[index] | 8192;
                    }
                }
                if (tileId == 3) {
                    if (maps[index] == '\f' || maps[index] == '3' || maps[index] == 'X' || maps[index] == 't' || maps[index] == 128) {
                        defaultSolidTile = maps[index] - 1;
                    }
                    if (maps[index] == 'm' || maps[index] == 'n') {
                        defaultSolidTile = maps[index];
                    }
                    if (maps[index] == 1 || maps[index] == 2 || maps[index] == 3 || maps[index] == 4 || maps[index] == 5 || maps[index] == 6 || maps[index] == 7 || maps[index] == 11 || maps[index] == 14 || maps[index] == 17 || maps[index] == '+' || maps[index] == '3' || maps[index] == '?' || maps[index] == 'A' || maps[index] == 'C' || maps[index] == 'D' || maps[index] == 'G' || maps[index] == 'H' || maps[index] == 'S' || maps[index] == 'T' || maps[index] == 'U' || maps[index] == 'W' || maps[index] == '[' || maps[index] == '^' || maps[index] == 'a' || maps[index] == 'b' || maps[index] == 'j' || maps[index] == 'k' || maps[index] == 'o' || maps[index] == 'q' || maps[index] == 'u' || maps[index] == 'v' || maps[index] == 'w' || maps[index] == '}' || maps[index] == '~' || maps[index] == 129 || maps[index] == 130 || maps[index] == 131 || maps[index] == 133 || maps[index] == 136 || maps[index] == 138 || maps[index] == 139 || maps[index] == 142) {
                        types[index] = types[index] | 2;
                    }
                    if (maps[index] == '|' || maps[index] == 't' || maps[index] == '{' || maps[index] == ',' || maps[index] == '\f' || maps[index] == 15 || maps[index] == 16 || maps[index] == '-' || maps[index] == '\n' || maps[index] == '\t') {
                        types[index] = types[index] | 4096;
                    }
                    if (maps[index] == 23) {
                        types[index] = types[index] | 32;
                    }
                    if (maps[index] == 24) {
                        types[index] = types[index] | 128;
                    }
                    if (maps[index] == 6 || maps[index] == 15 || maps[index] == '3' || maps[index] == '_' || maps[index] == 'a' || maps[index] == 'j' || maps[index] == 'o' || maps[index] == '{' || maps[index] == '}' || maps[index] == 138 || maps[index] == 140) {
                        types[index] = types[index] | 4;
                    }
                    if (maps[index] == 7 || maps[index] == 16 || maps[index] == '3' || maps[index] == '`' || maps[index] == 'b' || maps[index] == 'k' || maps[index] == 'o' || maps[index] == '|' || maps[index] == '~' || maps[index] == 139 || maps[index] == 141) {
                        types[index] = types[index] | 8;
                    }
                    if (maps[index] == 25) {
                        types[index] = types[index] | 64;
                        if ((types[index - tmw] & 4096) == 4096) {
                            types[index] = types[index] | 4096;
                        }
                    }
                    if (maps[index] == '"') {
                        types[index] = types[index] | 2048;
                    }
                    if (maps[index] == 17) {
                        types[index] = types[index] | 1024;
                    }
                    if (maps[index] == '!' || maps[index] == 'g' || maps[index] == 'h' || maps[index] == 'i' || maps[index] == 26 || maps[index] == '!') {
                        types[index] = types[index] | 256;
                    }
                    if (maps[index] == '3' || maps[index] == 'o' || maps[index] == 'D') {
                        types[index] = types[index] | 8192;
                    }
                    if (maps[index] == 'R' || maps[index] == 'n' || maps[index] == 143) {
                        types[index] = types[index] | 16384;
                    }
                    if (maps[index] == 'q') {
                        types[index] = types[index] | 65536;
                    }
                    if (maps[index] == 142) {
                        types[index] = types[index] | 32768;
                    }
                    if (maps[index] == '(' || maps[index] == ')') {
                        types[index] = types[index] | 131072;
                    }
                    if (maps[index] == 'n') {
                        types[index] = types[index] | 262144;
                    }
                    if (maps[index] == 143) {
                        types[index] = types[index] | 524288;
                    }
                }
                if (tileId == 5) {
                    if (maps[index] == 6 || maps[index] == 7 || maps[index] == '\b' || maps[index] == '$' || maps[index] == '2' || maps[index] == '3' || maps[index] == '7' || maps[index] == '8' || maps[index] == '9' || maps[index] == ':' || maps[index] == ';' || maps[index] == 'D' || maps[index] == 'F' || maps[index] == 'M' || maps[index] == 'I' || maps[index] == 'J' || maps[index] == 'K' || maps[index] == 'N' || maps[index] == 'u' || maps[index] == 'v' || maps[index] == 130) {
                        types[index] = types[index] | 2;
                    }
                    if (maps[index] == 6 || maps[index] == 'u') {
                        types[index] = types[index] | 4;
                    }
                    if (maps[index] == 11 || maps[index] == '\n') {
                        types[index] = types[index] | 32;
                    }
                    if (maps[index] == '\f' || maps[index] == '\r') {
                        types[index] = types[index] | 64;
                    }
                    if (maps[index] == 7 || maps[index] == 'u') {
                        types[index] = types[index] | 8;
                    }
                }
            }
            nso.TileMap.imgMiniMap = Image.createImage(tmw * nso.TileMap.sizeMiniMap * mGraphics.zoomLevel, nso.TileMap.tmh * nso.TileMap.sizeMiniMap * mGraphics.zoomLevel);
            mGraphics graphics;
            (graphics = new mGraphics(nso.TileMap.imgMiniMap.getGraphics())).setColor(0);
            graphics.fillRect(0, 0, tmw * nso.TileMap.sizeMiniMap, nso.TileMap.tmh * nso.TileMap.sizeMiniMap);
            for (int index1 = 0; index1 < tmw; index1++) {
                for (int index2 = 0; index2 < nso.TileMap.tmh; index2++) {
                    int value3;
                    if ((value3 = maps[index2 * tmw + index1] - 1) != -1) {
                        graphics.drawRegion(nso.TileMap.imgTileSmall, 0, value3 * nso.TileMap.sizeMiniMap, nso.TileMap.sizeMiniMap, nso.TileMap.sizeMiniMap, 0, index1 * nso.TileMap.sizeMiniMap, index2 * nso.TileMap.sizeMiniMap, 0);
                    }
                }
            }
            if (!GameCanvas.lowGraphic) {
                if (mapID == 0 || mapID <= 4 || mapID >= 16 && mapID <= 18 || mapID >= 24 && mapID <= 27 || mapID == 22 || mapID == 33 || mapID == 34 || mapID == 38 || mapID == 57 || mapID == 58 || mapID == 60 || mapID == 68 || mapID >= 70 && mapID <= 75 || mapID == 81) {
                    Effect2.vAnimateEffect.addElement(new AnimateEffect((byte) 1, true, 10));
                }
                if (mapID >= 39 && mapID <= 44 || mapID >= 46 && mapID <= 48 || mapID == 56 || mapID >= 62 && mapID <= 65) {
                    Effect2.vAnimateEffect.addElement(new AnimateEffect((byte) 3, true, Res.random(150, 200)));
                    return;
                }
            }
        } catch (Exception exception) {
            System.out.println("Error Load Map");
            exception.printStackTrace();
            GameMidlet.instance.exit();
        }
    }

    public static final void paintTilemap(mGraphics g) {
        for (int index = GameScr.gssx; index < GameScr.gssxe; index++) {
            for (int index1 = GameScr.gssy; index1 < GameScr.gssye; index1++) {
                int value = maps[index1 * tmw + index] - 1;
                if ((tileTypeAt(index, index1) & 256) != 256) {
                    if (tileID == 4 && (tileTypeAt(index, index1) & 64) == 64) {
                        value = index1 - 1;
                        if ((value = maps[value * tmw + index] - 1) == 15) {
                            g.drawRegion(nso.TileMap.imgTile, 0, 17 * size, 24, 24, 0, index * size, index1 * size, 0);
                            continue;
                        }
                        if (value == 5) {
                            g.drawRegion(nso.TileMap.imgTile, 0, 7 * size, 24, 24, 0, index * size, index1 * size, 0);
                            continue;
                        }
                        if (value == 18 || value == 22 || value == 15) {
                            g.drawRegion(nso.TileMap.imgTile, 0, 17 * size, 24, 24, 0, index * size, index1 * size, 0);
                            continue;
                        }
                        if (value == 44 || value == 52 || value == 51) {
                            g.drawRegion(nso.TileMap.imgTile, 0, 56 * size, 24, 24, 0, index * size, index1 * size, 0);
                            continue;
                        }
                        if (value == 24 || value == 23 || value == 20 || value == 21 || value == 19 || value == 12 || value == 13) {
                            continue;
                        }
                        if (value != -1) {
                            g.drawRegion(nso.TileMap.imgTile, 0, value * size, 24, 24, 0, index * size, index1 * size, 0);
                        } else if (value == -1) {
                            continue;
                        }
                    }
                    if (tileID == 1) {
                        if ((tileTypeAt(index, index1) & 32) == 32) {
                            g.drawRegion(imgWaterfall, 0, 24 * (GameCanvas.gameTick % 4), 24, 24, 0, index * size, index1 * size, 0);
                            continue;
                        }
                        if ((tileTypeAt(index, index1) & 64) == 64 || (tileTypeAt(index, index1) & 2048) == 2048) {
                            if ((tileTypeAt(index, index1 - 1) & 32) == 32) {
                                g.drawRegion(imgWaterfall, 0, 24 * (GameCanvas.gameTick % 4), 24, 24, 0, index * size, index1 * size, 0);
                                continue;
                            }
                            if ((tileTypeAt(index, index1 - 1) & 4096) == 4096) {
                                g.drawRegion(nso.TileMap.imgTile, 0, 504, 24, 24, 0, index * size, index1 * size, 0);
                                continue;
                            }
                        }
                    }
                    if (tileID == 2) {
                        if ((tileTypeAt(index, index1) & 32) == 32) {
                            g.drawRegion(imgWaterfall, 0, 24 * (GameCanvas.gameTick % 8 >> 1), 24, 24, 0, index * size, index1 * size, 0);
                            continue;
                        }
                        if (value == 17) {
                            g.drawRegion(imgTopWaterfall, 0, 24 * (GameCanvas.gameTick % 8 >> 1), 24, 24, 0, index * size, index1 * size, 0);
                            continue;
                        }
                        if (value == 133) {
                            g.drawRegion(nso.TileMap.imgTile, 0, 132 * size, 24, 24, 0, index * size, index1 * size, 0);
                            continue;
                        }
                        if ((tileTypeAt(index, index1) & 64) == 64 || (tileTypeAt(index, index1) & 2048) == 2048) {
                            if ((tileTypeAt(index, index1 - 1) & 32) == 32) {
                                g.drawRegion(imgWaterfall, 0, 24 * (GameCanvas.gameTick % 4), 24, 24, 0, index * size, index1 * size, 0);
                                continue;
                            }
                            if ((tileTypeAt(index, index1 - 1) & 4096) == 4096) {
                                if ((value = tileAt(index, index1 - 1)) == 55) {
                                    value = 54;
                                } else if (value == 19 || value == 35) {
                                    if ((value = tileAt(index, index1 - 2)) == 55) {
                                        value = 54;
                                    } else if (value < 40) {
                                        value = 21;
                                    }
                                } else if (value < 40) {
                                    value = 21;
                                } else {
                                    value = 110;
                                }
                                g.drawRegion(nso.TileMap.imgTile, 0, value * 24, 24, 24, 0, index * size, index1 * size, 0);
                                continue;
                            }
                        }
                    }
                    if (tileID == 3) {
                        if ((tileTypeAt(index, index1) & 32) == 32) {
                            g.drawRegion(imgWaterfall, 0, 24 * (GameCanvas.gameTick % 8 >> 1), 24, 24, 0, index * size, index1 * size, 0);
                            continue;
                        }
                        if (value == 23) {
                            g.drawRegion(imgTopWaterfall, 0, 24 * (GameCanvas.gameTick % 8 >> 1), 24, 24, 0, index * size, index1 * size, 0);
                            continue;
                        }
                        if ((tileTypeAt(index, index1) & 64) == 64 || (tileTypeAt(index, index1) & 2048) == 2048) {
                            if ((tileTypeAt(index, index1 - 1) & 32) == 32) {
                                g.drawRegion(imgWaterfall, 0, 24 * (GameCanvas.gameTick % 4), 24, 24, 0, index * size, index1 * size, 0);
                                continue;
                            }
                            if ((tileTypeAt(index, index1 - 1) & 4096) == 4096) {
                                if ((value = tileAt(index, index1 - 1)) == 25) {
                                    value = tileAt(index, index1 - 2);
                                }
                                if (value == 45) {
                                    value = 44;
                                }
                                g.drawRegion(nso.TileMap.imgTile, 0, --value * 24, 24, 24, 0, index * size, index1 * size, 0);
                                continue;
                            }
                        }
                    }
                    if ((tileTypeAt(index, index1) & 16) == 16) {
                        nso.TileMap.dbx = (nso.TileMap.bx = index * size - GameScr.cmx) - GameScr.gW2;
                        nso.TileMap.fx = (nso.TileMap.dfx = (size - 2) * nso.TileMap.dbx / size) + GameScr.gW2;
                        g.drawRegion(nso.TileMap.imgTile, 0, value * size, 24, 24, 0, nso.TileMap.fx + GameScr.cmx, index1 * size, 0);
                    } else if ((tileTypeAt(index, index1) & 512) == 512) {
                        if (value != -1) {
                            g.drawRegion(nso.TileMap.imgTile, 0, value * size, 24, 1, 0, index * size, index1 * size, 0);
                            g.drawRegion(nso.TileMap.imgTile, 0, value * size, 24, 24, 0, index * size, index1 * size + 1, 0);
                        }
                    } else if (value != -1) {
                        g.drawRegion(nso.TileMap.imgTile, 0, value * size, 24, 24, 0, index * size, index1 * size, 0);
                    }
                }
            }
        }
    }

    public static final void paintMiniMap(mGraphics g) {
        if (GameCanvas.w > 176) {
            Res.resetTrans(g);
            g.translate(nso.TileMap.posMiniMapX + 1, nso.TileMap.posMiniMapY + 2);
            int value = Char.getMyChar().cx / 12;
            int value1 = Char.getMyChar().cy / 12;
            g.setColor(0);
            g.fillRect(-2, -2, nso.TileMap.wMiniMap + 2, nso.TileMap.hMiniMap);
            g.setClip(-2, -2, nso.TileMap.wMiniMap + 4, nso.TileMap.hMiniMap + 4);
            for (int index = 0; index < 2; index++) {
                g.setColor(colorMini[index]);
                g.drawRect(index - 2, index - 2, nso.TileMap.wMiniMap + 2 - (index << 1), nso.TileMap.hMiniMap - (index << 1));
            }
            g.setClip(0, 0, nso.TileMap.wMiniMap - 2, nso.TileMap.hMiniMap - 3);
            if (mGraphics.getImageWidth(nso.TileMap.imgMiniMap) > nso.TileMap.wMiniMap || mGraphics.getImageHeight(nso.TileMap.imgMiniMap) > nso.TileMap.hMiniMap) {
                g.translate(-nso.TileMap.cmxMini, -nso.TileMap.cmyMini);
            }
            g.drawImage(nso.TileMap.imgMiniMap, 0, 0, 0);
            g.setColor(16777215);
            g.fillRect(value - 2, value1 - 2, 5, 5);
            g.setColor(16711680);
            g.fillRect(value - 1, value1 - 1, 3, 3);
            for (int index2 = 0; index2 < GameScr.vParty.size(); index2++) {
                Party party;
                if ((party = (Party) GameScr.vParty.elementAt(index2)).c != null && party.c != Char.getMyChar()) {
                    value1 = party.c.cx / 12;
                    value = party.c.cy / 12;
                    if (value1 < nso.TileMap.cmxMini) {
                        value1 = nso.TileMap.cmxMini;
                    }
                    if (value < nso.TileMap.cmyMini) {
                        value = nso.TileMap.cmyMini;
                    }
                    if (value1 > nso.TileMap.cmxMini + nso.TileMap.wMiniMap) {
                        value1 = nso.TileMap.cmxMini + nso.TileMap.wMiniMap;
                    }
                    if (value > nso.TileMap.cmyMini + nso.TileMap.hMiniMap) {
                        value = nso.TileMap.cmyMini + nso.TileMap.hMiniMap;
                    }
                    if (GameCanvas.gameTick % 10 < 8) {
                        g.setColor(16777215);
                        g.fillRect(value1 - 2, value - 2, 5, 5);
                        g.setColor(65280);
                        g.fillRect(value1 - 1, value - 1, 3, 3);
                    }
                }
            }
            Res.resetTrans(g);
            if (GameCanvas.isTouch) {
                g.drawImage(GameScr.imgMapBorder, nso.TileMap.posMiniMapX - 1, nso.TileMap.posMiniMapY, 0);
            }
        }
    }

    public static final void paintOutTilemap(mGraphics g) {
        if (!GameCanvas.lowGraphic) {
            for (int index = GameScr.gssx; index < GameScr.gssxe; index++) {
                for (int index1 = GameScr.gssy; index1 < GameScr.gssye; index1++) {
                    Image image = null;
                    if (tileID == 4) {
                        image = nso.TileMap.imgflowRiver;
                    } else {
                        image = nso.TileMap.imgWaterflow;
                    }
                    if ((tileTypeAt(index, index1) & 2048) == 2048) {
                        g.drawImage(nso.TileMap.imgLeaf, index, index1, 0);
                    }
                    if ((tileTypeAt(index, index1) & 64) == 64) {
                        g.drawRegion(image, 0, (GameCanvas.gameTick % 8 >> 2) * 24, 24, 24, 0, index * size, index1 * size, 0);
                    }
                    if ((tileTypeAt(index, index1) & 256) == 256) {
                        g.drawRegion(nso.TileMap.imgTile, 0, (maps[index1 * tmw + index] - 1) * size, 24, 24, 0, index * size, index1 * size, 0);
                    }
                }
            }
            if (tileID != 4 && GameCanvas.isTouch && GameCanvas.isTouchControl && GameScr.gssye >= nso.TileMap.tmh - 2) {
                for (int index2 = GameScr.gssx; index2 < GameScr.gssxe; index2++) {
                    int value = nso.TileMap.tmh - 2;
                    int value3 = maps[value * tmw + index2] - 1;
                    if ((tileTypeAt(index2, value) & 32) == 32) {
                        for (int index4 = 1; index4 <= 4; index4++) {
                            g.drawRegion(imgWaterfall, 0, 24 * (GameCanvas.gameTick % 4), 24, 24, 0, index2 * size, (value + index4) * size, 0);
                        }
                    } else {
                        if (mapID == 64) {
                            defaultSolidTile = 115;
                        }
                        if ((tileTypeAt(index2, value) & 2) == 2 || (tileTypeAt(index2, value) & 64) == 64) {
                            value3 = defaultSolidTile;
                        }
                        if (value3 >= 0) {
                            for (int index5 = 1; index5 <= 4; index5++) {
                                g.drawRegion(nso.TileMap.imgTile, 0, value3 * size, 24, 24, 0, index2 * size, (value + index5) * size, 0);
                            }
                        }
                    }
                }
            }
        }
    }

    private static int tileAt(int x, int y) {
        try {
            return maps[y * tmw + x];
        } catch (Exception exception) {
            return 1000;
        }
    }

    private static int tileTypeAt(int x, int y) {
        try {
            return types[y * tmw + x];
        } catch (Exception exception) {
            return 1000;
        }
    }

    public static final int tileTypeAtPixel(int px, int py) {
        try {
            return types[py / size * tmw + px / size];
        } catch (Exception exception) {
            return 1000;
        }
    }

    public static final boolean tileTypeAt(int px, int py, int t) {
        try {
            return (types[py / size * tmw + px / size] & t) == t;
        } catch (Exception exception) {
            return false;
        }
    }

    public static final void setTileTypeAtPixel(int value, int value1, int value2) {
        types[value1 / size * tmw + value / size] = types[value1 / size * tmw + value / size] | 512;
    }

    public static final void killTileTypeAt(int value, int value1, int value2) {
        types[value1 / size * tmw + value / size] = types[value1 / size * tmw + value / size] & -513;
    }

    public static final int tileYofPixel(int value) {
        return value / size * size;
    }

    public static final int tileXofPixel(int value) {
        return value / size * size;
    }

    public static void loadMapFromResource() throws IOException {
        InputStream inputStream = null;
        inputStream = null;
        inputStream = "".getClass().getResourceAsStream("/map/" + mapID);
        DataInputStream dataInputStream;
        tmw = (char) (dataInputStream = new DataInputStream(inputStream)).read();
        nso.TileMap.tmh = (char) dataInputStream.read();
        maps = new char[dataInputStream.available()];
        for (int index = 0; index < tmw * nso.TileMap.tmh; index++) {
            maps[index] = (char) dataInputStream.read();
        }
        types = new int[maps.length];
    }

    public static void reloadTileSheets() {
        nso.TileMap.imgTile = null;
        System.gc();
        nso.TileMap.imgTile = GameCanvas.loadImage("/t/" + tileID + ".png");
        nso.TileMap.imgTileSmall = GameCanvas.loadImage("/t/mini_" + tileID + ".png");
    }
}
