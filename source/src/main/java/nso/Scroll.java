package nso;

import main.GameCanvas;

public final class Scroll {

    private int cmtoX;

    private int cmtoY;

    public int cmx;

    public int cmy;

    private int cmvx;

    private int cmvy;

    private int cmdx;

    private int cmdy;

    public int xPos;

    public int yPos;

    public int width;

    public int height;

    private int cmxLim;

    private int cmyLim;

    public static Scroll me;

    private int pointerDownTime;

    private int pointerDownFirstX;

    private int[] pointerDownLastX = new int[3];

    private boolean pointerIsDowning;

    private boolean isDownWhenRunning;

    private int cmRun;

    private int selectedItem;

    public int ITEM_SIZE;

    private int ITEM_PER_LINE;

    private boolean styleUPDOWN = true;

    public Scroll() {
    }

    public final void clear() {
        this.cmtoX = 0;
        this.cmtoY = 0;
        this.cmx = 0;
        this.cmy = 0;
        this.cmvx = 0;
        this.cmvy = 0;
        this.cmdx = 0;
        this.cmdy = 0;
        this.cmxLim = 0;
        this.cmyLim = 0;
        this.width = 0;
        this.height = 0;
    }

    public final void setClip(mGraphics g, int x, int y, int w, int h) {
        g.setClip(x, y, w, h - 1);
        g.translate(-g.getTranslateX(), -g.getTranslateY());
        g.translate(-this.cmx, -this.cmy);
    }

    public final void setClip(mGraphics g) {
        g.setClip(this.xPos, this.yPos, this.width, this.height - 1);
        g.translate(-g.getTranslateX(), -g.getTranslateY());
        g.translate(-this.cmx, -this.cmy);
    }

    public final ScrollResult updateKey() {
        if (this.styleUPDOWN) {
            Scroll scroll;
            int value = (scroll = this).xPos;
            int value1 = scroll.yPos;
            int value2 = scroll.width;
            int value3 = scroll.height;
            if (GameCanvas.isPointerDown) {
                if (!scroll.pointerIsDowning && GameCanvas.isPointer(value, value1, value2, value3)) {
                    for (int index = 0; index < scroll.pointerDownLastX.length; index++) {
                        scroll.pointerDownLastX[0] = GameCanvas.py;
                    }
                    scroll.pointerDownFirstX = GameCanvas.py;
                    scroll.pointerIsDowning = true;
                    scroll.selectedItem = -1;
                    scroll.isDownWhenRunning = scroll.cmRun != 0;
                    scroll.cmRun = 0;
                } else if (scroll.pointerIsDowning) {
                    scroll.pointerDownTime++;
                    if (scroll.pointerDownTime > 5 && scroll.pointerDownFirstX == GameCanvas.py && !scroll.isDownWhenRunning) {
                        scroll.pointerDownFirstX = -1000;
                        if (scroll.ITEM_PER_LINE > 1) {
                            value2 = (scroll.cmtoY + GameCanvas.py - value1) / scroll.ITEM_SIZE;
                            value3 = (scroll.cmtoX + GameCanvas.px - value) / scroll.ITEM_SIZE;
                            scroll.selectedItem = value2 * scroll.ITEM_PER_LINE + value3;
                        } else {
                            scroll.selectedItem = (scroll.cmtoY + GameCanvas.py - value1) / scroll.ITEM_SIZE;
                        }
                    }
                    if ((value2 = GameCanvas.py - scroll.pointerDownLastX[0]) != 0 && scroll.selectedItem != -1) {
                        scroll.selectedItem = -1;
                    }
                    for (int index4 = scroll.pointerDownLastX.length - 1; index4 > 0; index4--) {
                        scroll.pointerDownLastX[index4] = scroll.pointerDownLastX[index4 - 1];
                    }
                    scroll.pointerDownLastX[0] = GameCanvas.py;
                    scroll.cmtoY -= value2;
                    if (scroll.cmtoY < 0) {
                        scroll.cmtoY = 0;
                    }
                    if (scroll.cmtoY > scroll.cmyLim) {
                        scroll.cmtoY = scroll.cmyLim;
                    }
                    if (scroll.cmy < 0 || scroll.cmy > scroll.cmyLim) {
                        value2 /= 2;
                    }
                    scroll.cmy -= value2;
                }
            }
            boolean flag = false;
            if (GameCanvas.isPointerJustRelease && scroll.pointerIsDowning) {
                value3 = GameCanvas.py - scroll.pointerDownLastX[0];
                GameCanvas.isPointerJustRelease = false;
                if (Res.abs(value3) < 20 && Res.abs(GameCanvas.py - scroll.pointerDownFirstX) < 20 && !scroll.isDownWhenRunning) {
                    scroll.cmRun = 0;
                    scroll.cmtoY = scroll.cmy;
                    scroll.pointerDownFirstX = -1000;
                    if (scroll.ITEM_PER_LINE > 1) {
                        value1 = (scroll.cmtoY + GameCanvas.py - value1) / scroll.ITEM_SIZE;
                        value = (scroll.cmtoX + GameCanvas.px - value) / scroll.ITEM_SIZE;
                        scroll.selectedItem = value1 * scroll.ITEM_PER_LINE + value;
                    } else {
                        scroll.selectedItem = (scroll.cmtoY + GameCanvas.py - value1) / scroll.ITEM_SIZE;
                    }
                    scroll.pointerDownTime = 0;
                    flag = true;
                } else if (scroll.selectedItem != -1 && scroll.pointerDownTime > 5) {
                    scroll.pointerDownTime = 0;
                    flag = true;
                } else if (scroll.selectedItem == -1 && !scroll.isDownWhenRunning) {
                    if (scroll.cmy < 0) {
                        scroll.cmtoY = 0;
                    } else if (scroll.cmy > scroll.cmyLim) {
                        scroll.cmtoY = scroll.cmyLim;
                    } else {
                        byte byteValue;
                        if ((value1 = GameCanvas.py - scroll.pointerDownLastX[0] + (scroll.pointerDownLastX[0] - scroll.pointerDownLastX[1]) + (scroll.pointerDownLastX[1] - scroll.pointerDownLastX[2])) > 10) {
                            byteValue = 10;
                        } else if (value1 < -10) {
                            byteValue = -10;
                        } else {
                            byteValue = 0;
                        }
                        scroll.cmRun = -byteValue * 100;
                    }
                }
                scroll.pointerIsDowning = false;
                scroll.pointerDownTime = 0;
                GameCanvas.isPointerJustRelease = false;
            }
            ScrollResult scrollResult;
            (scrollResult = new ScrollResult()).selected = scroll.selectedItem;
            scrollResult.isFinish = flag;
            scrollResult.isDowning = scroll.pointerIsDowning;
            return scrollResult;
        } else {
            Scroll scroll5;
            int value6 = (scroll5 = this).xPos;
            int value7 = scroll5.yPos;
            int value8 = scroll5.width;
            int value9 = scroll5.height;
            if (GameCanvas.isPointerDown) {
                if (!scroll5.pointerIsDowning && GameCanvas.isPointer(value6, value7, value8, value9)) {
                    for (int index10 = 0; index10 < scroll5.pointerDownLastX.length; index10++) {
                        scroll5.pointerDownLastX[0] = GameCanvas.px;
                    }
                    scroll5.pointerDownFirstX = GameCanvas.px;
                    scroll5.pointerIsDowning = true;
                    scroll5.selectedItem = -1;
                    scroll5.isDownWhenRunning = scroll5.cmRun != 0;
                    scroll5.cmRun = 0;
                } else if (scroll5.pointerIsDowning) {
                    scroll5.pointerDownTime++;
                    if (scroll5.pointerDownTime > 5 && scroll5.pointerDownFirstX == GameCanvas.px && !scroll5.isDownWhenRunning) {
                        scroll5.pointerDownFirstX = -1000;
                        scroll5.selectedItem = (scroll5.cmtoX + GameCanvas.px - value6) / scroll5.ITEM_SIZE;
                    }
                    if ((value8 = GameCanvas.px - scroll5.pointerDownLastX[0]) != 0 && scroll5.selectedItem != -1) {
                        scroll5.selectedItem = -1;
                    }
                    for (int index11 = scroll5.pointerDownLastX.length - 1; index11 > 0; index11--) {
                        scroll5.pointerDownLastX[index11] = scroll5.pointerDownLastX[index11 - 1];
                    }
                    scroll5.pointerDownLastX[0] = GameCanvas.px;
                    scroll5.cmtoX -= value8;
                    if (scroll5.cmtoX < 0) {
                        scroll5.cmtoX = 0;
                    }
                    if (scroll5.cmtoX > scroll5.cmxLim) {
                        scroll5.cmtoX = scroll5.cmxLim;
                    }
                    if (scroll5.cmx < 0 || scroll5.cmx > scroll5.cmxLim) {
                        value8 /= 2;
                    }
                    scroll5.cmx -= value8;
                }
            }
            boolean flag12 = false;
            if (GameCanvas.isPointerJustRelease && scroll5.pointerIsDowning) {
                value9 = GameCanvas.px - scroll5.pointerDownLastX[0];
                GameCanvas.isPointerJustRelease = false;
                if (Res.abs(value9) < 20 && Res.abs(GameCanvas.px - scroll5.pointerDownFirstX) < 20 && !scroll5.isDownWhenRunning) {
                    scroll5.cmRun = 0;
                    scroll5.cmtoX = scroll5.cmx;
                    scroll5.pointerDownFirstX = -1000;
                    scroll5.selectedItem = (scroll5.cmtoX + GameCanvas.px - value6) / scroll5.ITEM_SIZE;
                    scroll5.pointerDownTime = 0;
                    flag12 = true;
                } else if (scroll5.selectedItem != -1 && scroll5.pointerDownTime > 5) {
                    scroll5.pointerDownTime = 0;
                    flag12 = true;
                } else if (scroll5.selectedItem == -1 && !scroll5.isDownWhenRunning) {
                    if (scroll5.cmx < 0) {
                        scroll5.cmtoX = 0;
                    } else if (scroll5.cmx > scroll5.cmxLim) {
                        scroll5.cmtoX = scroll5.cmxLim;
                    } else {
                        byte byteValue13;
                        if ((value7 = GameCanvas.px - scroll5.pointerDownLastX[0] + (scroll5.pointerDownLastX[0] - scroll5.pointerDownLastX[1]) + (scroll5.pointerDownLastX[1] - scroll5.pointerDownLastX[2])) > 10) {
                            byteValue13 = 10;
                        } else if (value7 < -10) {
                            byteValue13 = -10;
                        } else {
                            byteValue13 = 0;
                        }
                        scroll5.cmRun = -byteValue13 * 100;
                    }
                }
                scroll5.pointerIsDowning = false;
                scroll5.pointerDownTime = 0;
                GameCanvas.isPointerJustRelease = false;
            }
            ScrollResult scrollResult14;
            (scrollResult14 = new ScrollResult()).selected = scroll5.selectedItem;
            scrollResult14.isFinish = flag12;
            scrollResult14.isDowning = scroll5.pointerIsDowning;
            return scrollResult14;
        }
    }

    public final void updatecm() {
        if (this.cmRun != 0 && !this.pointerIsDowning) {
            if (this.styleUPDOWN) {
                this.cmtoY = this.cmtoY + this.cmRun / 100;
                if (this.cmtoY < 0) {
                    this.cmtoY = 0;
                } else if (this.cmtoY > this.cmyLim) {
                    this.cmtoY = this.cmyLim;
                } else {
                    this.cmy = this.cmtoY;
                }
            } else {
                this.cmtoX = this.cmtoX + this.cmRun / 100;
                if (this.cmtoX < 0) {
                    this.cmtoX = 0;
                } else if (this.cmtoX > this.cmxLim) {
                    this.cmtoX = this.cmxLim;
                } else {
                    this.cmx = this.cmtoX;
                }
            }
            this.cmRun = this.cmRun * 9 / 10;
            if (this.cmRun < 100 && this.cmRun > -100) {
                this.cmRun = 0;
            }
        }
        if (this.cmx != this.cmtoX && !this.pointerIsDowning) {
            this.cmvx = this.cmtoX - this.cmx << 2;
            this.cmdx = this.cmdx + this.cmvx;
            this.cmx = this.cmx + (this.cmdx >> 4);
            this.cmdx &= 15;
        }
        if (this.cmy != this.cmtoY && !this.pointerIsDowning) {
            this.cmvy = this.cmtoY - this.cmy << 2;
            this.cmdy = this.cmdy + this.cmvy;
            this.cmy = this.cmy + (this.cmdy >> 4);
            this.cmdy &= 15;
        }
    }

    public final void setStyle(int nItem, int ITEM_SIZE1, int xPos, int yPos, int width2, int height3, boolean styleUPDOWN4, int ITEM_PER_LINE) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.ITEM_SIZE = ITEM_SIZE1;
        this.width = width2;
        this.height = height3;
        this.styleUPDOWN = styleUPDOWN4;
        this.ITEM_PER_LINE = ITEM_PER_LINE;
        if (styleUPDOWN4) {
            this.cmyLim = nItem * ITEM_SIZE1 - height3;
        } else {
            this.cmxLim = nItem * ITEM_SIZE1 - width2;
        }
        if (this.cmyLim < 0) {
            this.cmyLim = 0;
        }
        if (this.cmxLim < 0) {
            this.cmxLim = 0;
        }
    }

    public final void moveTo(int to) {
        if (this.styleUPDOWN) {
            to -= (this.height - this.ITEM_SIZE) / 2;
            this.cmtoY = to;
            if (this.cmtoY < 0) {
                this.cmtoY = 0;
            }
            if (this.cmtoY > this.cmyLim) {
                this.cmtoY = this.cmyLim;
                return;
            }
        } else {
            to -= (this.width - this.ITEM_SIZE) / 2;
            this.cmtoX = to;
            if (this.cmtoX < 0) {
                this.cmtoX = 0;
            }
            if (this.cmtoX > this.cmxLim) {
                this.cmtoX = this.cmxLim;
            }
        }
    }
}
