package nso;

import main.GameCanvas;

public final class RegisterScr extends mScreen implements IActionListener {

    public static RegisterScr instance;

    private int xPanel;

    private int yPanel;

    private int wPanel;

    private int hPanel;

    private int wC;

    private int xT;

    private int focus;

    private TField[] tf = new TField[7];

    private String[] menuName = new String[] { "Họ và tên", "Ngày-tháng-năm sinh", "Địa chỉ thường trú", "CMND", "Ngày cấp(dd-mm-yyyy)", "Nơi cấp", "Số điện thoại, địa chỉ thư điện tử (nếu có).", "* Dưới 18 tuổi chỉ có thể chơi 180p 1 ngày" };

    private String[] menuInfo = new String[] { "", "", "", "", "", "", "", "" };

    public Scroll scroll = new Scroll();

    public RegisterScr() {
        instance = this;
        this.xPanel = GameCanvas.hw - 100;
        this.yPanel = 10;
        this.wPanel = 200;
        this.hPanel = GameCanvas.h - 40;
        this.wC = this.wPanel - 40;
        this.xT = GameCanvas.hw - this.wC / 2;
        for (int index = 0; index < this.tf.length; index++) {
            this.tf[index] = new TField();
            this.tf[index].name = this.menuName[index];
            this.tf[index].x = this.xT;
            this.tf[index].y = (index + 1) * 50;
            this.tf[index].width = this.wC;
            this.tf[index].height = mScreen.ITEM_HEIGHT + 2;
            this.tf[index].isFocus = false;
            this.tf[index].setIputType(3);
            this.tf[index].setText(this.menuInfo[index]);
            if (index == 0) {
                this.tf[index].isFocus = true;
            }
        }
        super.left = new Command(mResources.REGISTER, this, 1, null);
    }

    public final void update() {
        super.update();
        if (++GameScr.cmx > GameCanvas.w * 3 + 100) {
            GameScr.cmx = 100;
        }
        for (int index = 0; index < this.tf.length; index++) {
            this.tf[index].update();
        }
        new ScrollResult();
        ScrollResult scrollResult = null;
        if ((scrollResult = this.scroll.updateKey()).isDowning || scrollResult.isFinish) {
            this.focus = (byte) scrollResult.selected;
        }
        this.scroll.updatecm();
        scrollResult.getClass();
        if (this.focus == -1) {
            for (int index1 = 0; index1 < this.tf.length; index1++) {
                this.tf[index1].isFocus = false;
            }
        }
    }

    public final void keyPress(int keyCode) {
        super.keyPress(keyCode);
        for (int index = 0; index < this.tf.length; index++) {
            if (this.tf[index].isFocus) {
                this.tf[index].keyPressed(keyCode);
            }
        }
    }

    public final void updateKey() {
        if (GameCanvas.keyPressedz[2]) {
            this.focus--;
            if (this.focus < 0) {
                this.focus = this.menuName.length;
            }
            this.scroll.moveTo(this.focus * this.scroll.ITEM_SIZE);
        } else if (GameCanvas.keyPressedz[8]) {
            this.focus++;
            if (this.focus > this.menuName.length) {
                this.focus = 0;
            }
            this.scroll.moveTo(this.focus * this.scroll.ITEM_SIZE);
        }
        if (GameCanvas.keyPressedz[2] || GameCanvas.keyPressedz[8]) {
            GameCanvas.clearKeyPressed();
            for (int index = 0; index < this.tf.length; index++) {
                this.tf[index].isFocus = false;
            }
            if (this.focus < this.tf.length) {
                this.tf[this.focus].isFocus = true;
            }
            this.scroll.moveTo(this.focus * this.scroll.ITEM_SIZE);
        }
        if (GameCanvas.isPointerHoldIn(this.xPanel, this.yPanel, this.wPanel, this.hPanel) && GameCanvas.isPointerJustRelease) {
            for (int index1 = 0; index1 < this.tf.length; index1++) {
                if (GameCanvas.isPointerHoldIn(this.tf[index1].x, this.tf[index1].y, this.tf[index1].width, this.tf[index1].height)) {
                    this.focus = index1;
                }
            }
        }
        super.updateKey();
        GameCanvas.clearKeyPressed();
    }

    public final void paint(mGraphics g) {
        g.setColor(0);
        g.fillRect(0, 0, GameCanvas.w, GameCanvas.h);
        GameCanvas.paintBGGameScr(g);
        Paint.paintFrame(this.xPanel, this.yPanel, this.wPanel, this.hPanel, g);
        mFont.tahoma_7b_white.drawString(g, mResources.REGISTER, GameCanvas.hw, this.yPanel + 10, 2);
        this.scroll.setStyle(this.menuName.length, 50, this.xPanel, this.yPanel + 25, this.wPanel, this.hPanel - 25, true, 0);
        this.scroll.setClip(g, this.xPanel, this.yPanel + 25, this.wPanel, this.hPanel - 25);
        for (int index = 0; index < this.menuName.length; index++) {
            if (index != this.menuName.length - 1) {
                mFont.tahoma_7_yellow.drawString(g, this.menuName[index], GameCanvas.hw, (index + 1) * 50 - 13, 2);
            } else {
                mFont.tahoma_7_red.drawString(g, this.menuName[index], GameCanvas.hw, (index + 1) * 50 - 13, 2);
            }
        }
        for (int index1 = 0; index1 < this.tf.length; index1++) {
            this.tf[index1].paint_NonSetClip(g);
        }
        super.paint(g);
    }

    public final void switchToMe() {
        super.switchToMe();
        this.scroll.clear();
    }

    public final void perform(int idAction, Object p) {
        switch(idAction) {
            case 1:
                Service.gI().info_Kiemduyet(this.tf[0].getText(), this.tf[1].getText(), this.tf[2].getText(), this.tf[3].getText(), this.tf[4].getText(), this.tf[5].getText(), this.tf[6].getText());
                GameCanvas.isKiemduyet_info = false;
                GameScr.gI().switchToMe();
        }
    }
}
