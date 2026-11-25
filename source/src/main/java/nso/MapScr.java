package nso;

import javax.microedition.lcdui.Image;
import main.GameCanvas;

public final class MapScr extends mScreen implements IActionListener {

    private static MapScr instance;

    private boolean modeCurrentMap;

    private static Image imgMap = null;

    private static Image imgX;

    private static Image imgPointer;

    private static int mapW;

    private static int mapH;

    private static int mfx;

    private static int mfy;

    private static int mpoint;

    private static int tick3;

    private static int mcmtoX;

    private static int mcmtoY;

    private static int mcmvx;

    private static int mcmvy;

    private static int mcmdx;

    private static int mcmdy;

    private static int mcmx;

    private static int mcmy;

    private static int mcmxLim;

    private static int mcmyLim;

    private static int taskmapId;

    private static int dx = 0;

    private static int dy = 0;

    private static int[] x = new int[] { 1, 156, 140, 174, 196, 195, 125, 148, 156, 173, 199, 203, 222, 264, 283, 277, 298, 307, 311, 315, 116, 90, 59, 31, 252, 55, 81, 111, 148, 187, 219, 253, 278, 304, 311, 310, 284, 309, 294, 62, 92, 117, 99, 134, 154, 175, 34, 52, 40, 78, 59, 82, 114, 179, 158, 142, 1, 215, 291, 242, 147, 301, 71, 23, 116, 126, 305, 286, 264, 20, 46, 70, 78, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

    private static int[] y = new int[] { 1, 68, 75, 88, 80, 107, 87, 114, 136, 160, 168, 196, 216, 219, 248, 265, 276, 260, 232, 204, 111, 82, 79, 59, 168, 33, 28, 34, 45, 20, 54, 44, 19, 40, 60, 100, 175, 165, 134, 181, 199, 208, 221, 220, 219, 221, 195, 217, 246, 244, 250, 263, 262, 241, 252, 244, 2, 240, 197, 139, 16, 18, 208, 223, 239, 186, 120, 119, 135, 107, 125, 126, 148, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

    private int maxPX;

    private int maxPY;

    private int xM;

    private int yM;

    private boolean trans = false;

    private int lastX;

    private int lastY;

    private static int lastpoint;

    public MapScr() {
        super.right = new Command(mResources.CLOSE, this, 1000, null);
        super.center = new Command(mResources.CHANGE, this, 1001, null);
        super.left = new Command("", this, 14004, null);
        lastpoint = -1;
    }

    private void resetCMLim() {
        int value = mGraphics.getImageWidth(TileMap.imgMiniMap);
        this.xM = (GameCanvas.w - value) / 2;
        this.yM = (GameCanvas.h - 20 - mGraphics.getImageHeight(TileMap.imgMiniMap)) / 2;
        if (this.xM < 0) {
            this.xM = 0;
        }
        if (this.yM < 0) {
            this.yM = 0;
        }
        if (this.modeCurrentMap) {
            mcmxLim = value + 20 - GameCanvas.w;
            mcmyLim = mGraphics.getImageHeight(TileMap.imgMiniMap) + 40 - GameCanvas.h;
            this.maxPX = value + 20;
            this.maxPY = value + 40;
            if (this.maxPY < GameCanvas.h - 26) {
                this.maxPY = GameCanvas.h - 26;
            }
            if (this.maxPX < GameCanvas.w) {
                this.maxPX = GameCanvas.w;
            }
            mfx = this.xM + Char.getMyChar().cx / 12;
            mfy = this.yM + Char.getMyChar().cy / 12;
        } else {
            mcmxLim = 340 - GameCanvas.w;
            mcmyLim = 340 - GameCanvas.h;
            mfx = x[TileMap.mapID] + dx;
            mfy = y[TileMap.mapID] + dy;
            this.maxPX = 330 + dx;
            this.maxPY = 310 + dy;
        }
        this.maxPX -= 10;
        this.maxPY -= 10;
        if (mcmxLim < 0) {
            mcmxLim = 0;
        }
        if (mcmyLim < 0) {
            mcmyLim = 0;
        }
        mcmy = 0;
        mcmx = 0;
        mcmtoY = 0;
        mcmtoX = 0;
        mcmtoX = mfx - GameCanvas.hw;
        mcmtoY = mfy - GameCanvas.hh;
    }

    public static MapScr gI() {
        if (instance == null) {
            instance = new MapScr();
        }
        return instance;
    }

    public final void switchToMe() {
        super.switchToMe();
        SmallImage.freeBig();
        TileMap.freeTileImage();
        super.right = new Command(mResources.CLOSE, this, 1000, null);
        super.center = new Command(mResources.CHANGE, this, 1001, null);
        super.left = new Command("", this, 14004, null);
        if (imgMap == null) {
            imgMap = GameCanvas.loadImage("/wm.png");
            imgX = GameCanvas.loadImage("/u/x.png");
            imgPointer = GameCanvas.loadImage("/u/wpt1.png");
            mapW = mGraphics.getImageHeight(imgMap);
            mapH = mGraphics.getImageHeight(imgMap);
        }
        if (GameCanvas.w > mapW) {
            dx = GameCanvas.hw - mapW / 2 - 12;
        }
        if (GameCanvas.h > mapH) {
            dy = GameCanvas.hh - mapH / 2;
        }
        this.resetCMLim();
        findMapNearestPoint();
        mFont.number_green.freeImage();
        mFont.number_orange.freeImage();
        mFont.number_red.freeImage();
        mFont.number_white.freeImage();
        mFont.number_white.freeImage();
        mFont.number_yellow.freeImage();
        mFont.tahoma_7.freeImage();
        mFont.tahoma_7_blue.freeImage();
        mFont.tahoma_7_blue1.freeImage();
        mFont.tahoma_7_green.freeImage();
        mFont.tahoma_7_red.freeImage();
        mFont.tahoma_7b_blue.freeImage();
        mFont.tahoma_7b_purple.freeImage();
        mFont.tahoma_7b_red.freeImage();
        mFont.tahoma_7b_white.freeImage();
        System.gc();
        lastpoint = -1;
    }

    public final void unLoad() {
        super.unLoad();
        imgMap = null;
        imgX = null;
        System.gc();
        TileMap.reloadTileSheets();
        SmallImage.loadBigImage();
        mFont.number_green.reloadImage();
        mFont.number_orange.reloadImage();
        mFont.number_red.reloadImage();
        mFont.number_white.reloadImage();
        mFont.number_white.reloadImage();
        mFont.number_yellow.reloadImage();
        mFont.tahoma_7.reloadImage();
        mFont.tahoma_7_blue.reloadImage();
        mFont.tahoma_7_blue1.reloadImage();
        mFont.tahoma_7_green.reloadImage();
        mFont.tahoma_7_red.reloadImage();
        mFont.tahoma_7b_blue.reloadImage();
        mFont.tahoma_7b_purple.reloadImage();
        mFont.tahoma_7b_red.reloadImage();
        mFont.tahoma_7b_white.reloadImage();
    }

    public final void paint(mGraphics g) {
        boolean flag = false;
        g.setColor(0);
        g.fillRect(0, 0, GameCanvas.w, GameCanvas.h);
        g.translate(10, 10);
        g.translate(-mcmx, -mcmy);
        if (this.modeCurrentMap) {
            g.drawImage(TileMap.imgMiniMap, this.xM, this.yM, 0);
            for (int index = 0; index < GameScr.vMob.size(); index++) {
                Mob mob;
                int value = (mob = (Mob) GameScr.vMob.elementAt(index)).x / 12;
                int value1 = mob.y / 12;
                if (mob.level < Char.getMyChar().clevel - 2) {
                    g.setColor(11184810);
                } else if (mob.level > Char.getMyChar().clevel + 2) {
                    g.setColor(16711680);
                } else {
                    g.setColor(16776960);
                }
                g.fillRect(this.xM + value - 1, this.yM + value1 - 1, 3, 3);
            }
            for (int index2 = 0; index2 < GameScr.vParty.size(); index2++) {
                Party party;
                if ((party = (Party) GameScr.vParty.elementAt(index2)).c != null && party.c != Char.getMyChar()) {
                    int value3 = party.c.cx / 12;
                    int value4 = party.c.cy / 12;
                    if (GameCanvas.gameTick % 10 < 8) {
                        g.setColor(16777215);
                        g.fillRect(this.xM + value3 - 2, this.yM + value4 - 2, 5, 5);
                        g.setColor(65280);
                        g.fillRect(this.xM + value3 - 1, this.yM + value4 - 1, 3, 3);
                    }
                }
            }
            GameScr.gI();
            GameScr.getTaskNpcId();
            for (int index5 = 0; index5 < GameScr.vNpc.size(); index5++) {
                Npc npc;
                int value6 = (npc = (Npc) GameScr.vNpc.elementAt(index5)).cx / 12;
                int value7 = npc.cy / 12;
                g.setColor(16777215);
                g.fillRect(this.xM + value6 - 2, this.yM + value7 - 2, 5, 5);
                g.setColor(65280);
                g.fillRect(this.xM + value6 - 1, this.yM + value7 - 1, 3, 3);
                g.drawImage(imgX, this.xM + value6, this.yM + value7, 3);
                flag = true;
            }
            for (byte index8 = 0; index8 < TileMap.vGo.size(); index8++) {
                Waypoint waypoint;
                int value9 = ((waypoint = (Waypoint) TileMap.vGo.elementAt(index8)).minX + waypoint.maxX) / 2 / 12;
                int value10 = (waypoint.minY + waypoint.maxY) / 2 / 12;
                if (GameCanvas.gameTick % 10 < 8) {
                    g.setColor(0);
                    g.fillRect(this.xM + value9 - 2, this.yM + value10 - 2, 5, 5);
                    g.setColor(16777215);
                    g.fillRect(this.xM + value9 - 1, this.yM + value10 - 1, 3, 3);
                }
            }
            int value11 = Char.getMyChar().cx / 12;
            int value12 = Char.getMyChar().cy / 12;
            g.setColor(16777215);
            g.fillRect(this.xM + value11 - 2, this.yM + value12 - 2, 5, 5);
            if (GameCanvas.gameTick % 10 > 5) {
                g.setColor(255);
                g.fillRect(this.xM + value11 - 1, this.yM + value12 - 1, 3, 3);
            }
            g.drawImage(imgPointer, mfx - 2, mfy, 0);
            super.paint(g);
            if (!flag) {
                mFont.tahoma_7_white.drawString(g, TileMap.mapName, 10, GameCanvas.h - 17, 0);
            }
        } else {
            if (GameCanvas.w > mapW && GameCanvas.h > mapH) {
                g.drawImage(imgMap, GameCanvas.hw, GameCanvas.hh, StaticObj.VCENTER_HCENTER);
            } else if (GameCanvas.w > mapW) {
                g.drawImage(imgMap, GameCanvas.hw, 0, StaticObj.TOP_CENTER);
            } else if (GameCanvas.h > mapH) {
                g.drawImage(imgMap, 0, GameCanvas.hh, StaticObj.VCENTER_LEFT);
            } else {
                g.drawImage(imgMap, 0, 0, 0);
            }
            if (TileMap.mapID < TileMap.mapNames.length && TileMap.mapID >= 0) {
                int value13 = 0;
                if (x[TileMap.mapID] != 1 || y[TileMap.mapID] != 1) {
                    value13 = x[TileMap.mapID] < 100 ? 0 : (x[TileMap.mapID] > 200 ? 1 : 2);
                    GameCanvas.paintShukiren(x[TileMap.mapID] + dx, y[TileMap.mapID] + dy, g, false);
                }
                int value14 = 0;
                if (taskmapId >= 0) {
                    value13 = x[taskmapId] < 100 ? 0 : (x[taskmapId] > 200 ? 1 : 2);
                    mFont.tahoma_7_white.drawString(g, TileMap.mapNames[taskmapId], x[taskmapId] + dx, y[taskmapId] + dy - 20, value13, mFont.tahoma_7_grey);
                    g.drawImage(imgX, x[taskmapId] + dx, y[taskmapId] + dy, 3);
                    flag = true;
                    value14 = y[taskmapId] - 20;
                } else if (x[TileMap.mapID] != 1 || y[TileMap.mapID] != 1) {
                    value14 = y[TileMap.mapID] - 20;
                    mFont.tahoma_7_yellow.drawString(g, TileMap.mapNames[TileMap.mapID], x[TileMap.mapID] + dx, y[TileMap.mapID] + dy - 20, value13, mFont.tahoma_7_grey);
                }
                for (int index15 = 0; index15 < Char.getMyChar().taskOrders.size(); index15++) {
                    TaskOrder taskOrder;
                    if ((taskOrder = (TaskOrder) Char.getMyChar().taskOrders.elementAt(index15)).mapId >= 0 && taskOrder.mapId < x.length) {
                        g.drawImage(imgX, x[taskOrder.mapId] + dx, y[taskOrder.mapId] + dy, 3);
                    }
                }
                if (mpoint >= 0 && (taskmapId < 0 && TileMap.mapID != mpoint || taskmapId >= 0 && mpoint != taskmapId)) {
                    value13 = x[mpoint] < 100 ? 0 : (x[mpoint] > 200 ? 1 : 2);
                    int value16 = x[mpoint];
                    int value17;
                    if ((value17 = y[mpoint] - 20) > value14 && value17 - value14 < 30) {
                        value17 += 40;
                    }
                    if (value17 < value14 && value14 - value17 < 20) {
                        value17 -= 5;
                    }
                    mFont.tahoma_7_yellow.drawString(g, TileMap.mapNames[mpoint], value16 + dx, value17 + dy, value13, mFont.tahoma_7_grey);
                }
            }
            g.drawImage(imgPointer, mfx - 2, mfy, 0);
            g.translate(-g.getTranslateX(), -g.getTranslateY());
            super.paint(g);
        }
        if (flag) {
            g.drawImage(imgX, 10, GameCanvas.h - 12, 3);
            mFont.tahoma_7_white.drawString(g, mResources.ME_TASK, 20, GameCanvas.h - 17, 0);
        }
    }

    public final void updateKey() {
        super.updateKey();
        if (++tick3 > 10000) {
            tick3 = 0;
        }
        if (mcmx != mcmtoX || mcmy != mcmtoY) {
            mcmvx = mcmtoX - mcmx << 1;
            mcmvy = mcmtoY - mcmy << 1;
            mcmdx = mcmdx + mcmvx;
            mcmx = mcmx + (mcmdx >> 4);
            mcmdx &= 15;
            mcmdy = mcmdy + mcmvy;
            mcmy = mcmy + (mcmdy >> 4);
            mcmdy &= 15;
            if (mcmx < 0) {
                mcmx = 0;
            }
            if (mcmx > mcmxLim) {
                mcmx = mcmxLim;
            }
            if (mcmy < 0) {
                mcmy = 0;
            }
            if (mcmy > mcmyLim) {
                mcmy = mcmyLim;
            }
        }
        int value = 0;
        if (GameCanvas.keyHold[2]) {
            if ((mfy -= 4) < dy - 10) {
                mfy = dy - 10;
            }
            value = 1;
        }
        if (GameCanvas.keyHold[8]) {
            if ((mfy += 4) > this.maxPY) {
                mfy = this.maxPY;
            }
            value = 1;
        }
        if (GameCanvas.keyHold[4]) {
            if ((mfx -= 4) < dx - 10) {
                mfx = dx - 10;
            }
            value = 1;
        }
        if (GameCanvas.keyHold[6]) {
            if ((mfx += 4) > this.maxPX) {
                mfx = this.maxPX;
            }
            value = 1;
        }
        if ((value != 0)) {
            mcmtoX = mfx - GameCanvas.hw;
            mcmtoY = mfy - GameCanvas.hh;
            findMapNearestPoint();
        }
        GameScr.gI();
        taskmapId = GameScr.getTaskMapId();
        if (GameCanvas.isPointerClick && GameCanvas.py < GameCanvas.h - mScreen.cmdH) {
            GameCanvas.isPointerClick = false;
            this.trans = true;
            this.lastX = GameCanvas.px;
            this.lastY = GameCanvas.py;
        } else if (GameCanvas.isPointerDown && this.trans) {
            mcmtoX = mcmtoX - (GameCanvas.px - this.lastX);
            mcmtoY = mcmtoY - (GameCanvas.py - this.lastY);
            if (mcmtoX < 0) {
                mcmtoX = 0;
            }
            if (mcmtoY < 0) {
                mcmtoY = 0;
            }
            if (mcmtoX > mcmxLim) {
                mcmtoX = mcmxLim;
            }
            if (mcmtoY > mcmyLim) {
                mcmtoY = mcmyLim;
            }
            mcmx = mcmtoX;
            mcmy = mcmtoY;
            this.lastX = GameCanvas.px;
            this.lastY = GameCanvas.py;
        }
        if (GameCanvas.isPointerJustRelease) {
            value = GameCanvas.pxLast - GameCanvas.px;
            int value1 = GameCanvas.pyLast - GameCanvas.py;
            if (value < 10 && value1 < 10) {
                mfx = mcmx + GameCanvas.pxLast - 8;
                mfy = mcmy + GameCanvas.pyLast - 8;
                findMapNearestPoint();
            }
            this.trans = false;
            GameCanvas.isPointerJustRelease = false;
        }
        if (GameCanvas.isTouch && GameCanvas.w >= 320) {
            super.left.x = GameCanvas.w / 2 - 160;
            super.center.x = GameCanvas.w / 2 - 35;
            super.right.x = GameCanvas.w / 2 + 88;
            super.left.y = super.center.y = super.right.y = GameCanvas.h - 26;
        }
    }

    private static void findMapNearestPoint() {
        lastpoint = mpoint;
        mpoint = -1;
        for (int index = 0; index < x.length; index++) {
            if (Res.abs(mfx - (x[index] + dx)) < 10 && Res.abs(mfy - (y[index] + dy)) < 10) {
                mpoint = index;
                if (lastpoint != -1 && lastpoint == mpoint) {
                    Service.gI().adminMove(mpoint);
                    lastpoint = -1;
                    mpoint = -1;
                    return;
                }
                break;
            }
        }
    }

    public final void perform(int idAction, Object p) {
        switch(idAction) {
            case 1000:
                if (Char.getMyChar().cHP <= 0 || Char.getMyChar().statusMe == 14) {
                    super.center = GameScr.gI().cmdDead;
                    Char.getMyChar().cHP = 0;
                }
                GameScr.gI().switchToMe();
                return;
            case 1001:
                this.modeCurrentMap = !this.modeCurrentMap;
                this.resetCMLim();
                return;
            case 14004:
                Service.gI().adminMove(mpoint);
        }
    }
}
