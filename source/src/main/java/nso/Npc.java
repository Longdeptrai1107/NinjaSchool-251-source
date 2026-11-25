package nso;

import main.GameCanvas;

public final class Npc extends Char {

    public NpcTemplate template;

    public static NpcTemplate[] arrNpcTemplate;

    public Npc(int npcId, int status, int cx, int cy, int templateId) {
        super.cx = cx;
        super.cy = cy;
        super.statusMe = status;
        this.template = arrNpcTemplate[templateId];
    }

    public static void clearEffTask() {
        for (int index = 0; index < GameScr.vNpc.size(); index++) {
            Npc npc;
            (npc = (Npc) GameScr.vNpc.elementAt(index)).effTask = null;
            npc.indexEffTask = -1;
        }
    }

    public final void update() {
        label46: if (super.effTask == null) {
            label51: {
                byte[] data = new byte[] { -1, 9, 9, 10, 10, 11, 11 };
                if (Char.getMyChar().ctaskId >= 9 && Char.getMyChar().ctaskId <= 10 && Char.getMyChar().nClass.classId > 0 && data[Char.getMyChar().nClass.classId] == this.template.npcTemplateId) {
                    if (Char.getMyChar().taskMaint != null) {
                        if (Char.getMyChar().taskMaint == null || Char.getMyChar().taskMaint.index + 1 != Char.getMyChar().taskMaint.subNames.length) {
                            break label46;
                        }
                        super.effTask = GameScr.efs[62];
                        break label51;
                    }
                } else {
                    GameScr.gI();
                    byte byteValue = GameScr.getTaskNpcId();
                    if (Char.getMyChar().taskMaint != null || byteValue != this.template.npcTemplateId) {
                        if (Char.getMyChar().taskMaint == null || byteValue != this.template.npcTemplateId) {
                            break label46;
                        }
                        if (Char.getMyChar().taskMaint.index + 1 == Char.getMyChar().taskMaint.subNames.length) {
                            super.effTask = GameScr.efs[62];
                            break label51;
                        }
                    }
                }
                super.effTask = GameScr.efs[57];
            }
            super.indexEffTask = 0;
        }
        super.update();
    }

    public final void paint(mGraphics g) {
        if (this.isPaint()) {
            if (super.statusMe != 15) {
                if (super.cTypePk != 0) {
                    super.paint(g);
                } else if (this.template != null) {
                    if (this.template.npcTemplateId == 13) {
                        if (Char.getMyChar().npcFocus != null && Char.getMyChar().npcFocus.equals(this)) {
                            SmallImage.drawSmallImage(g, 988, super.cx, super.cy - super.ch - 1, 0, 33);
                        }
                        SmallImage.drawSmallImage(g, 1060, super.cx, super.cy, 0, 33);
                        mFont.tahoma_7_white.drawString(g, String.valueOf(TileMap.zoneID), super.cx, super.cy - 10 - 2 - mFont.tahoma_7.getHeight(), 2);
                    } else if (this.template.npcTemplateId == 31) {
                        if (Char.getMyChar().npcFocus != null && Char.getMyChar().npcFocus.equals(this)) {
                            SmallImage.drawSmallImage(g, 988, super.cx, super.cy - super.ch - 1, 0, 33);
                        }
                        SmallImage.drawSmallImage(g, 1291, super.cx, super.cy, 0, 33);
                    } else if (this.template.npcTemplateId == 27) {
                        if (Char.getMyChar().npcFocus != null && Char.getMyChar().npcFocus.equals(this)) {
                            SmallImage.drawSmallImage(g, 988, super.cx, super.cy - super.ch - 1, 0, 33);
                        }
                        SmallImage.drawSmallImage(g, 1224, super.cx, super.cy, 0, 33);
                    } else {
                        Part part = GameScr.parts[this.template.headId];
                        Part part1 = GameScr.parts[this.template.legId];
                        Part part2 = GameScr.parts[this.template.bodyId];
                        if (super.cdir == 1) {
                            SmallImage.drawSmallImage(g, part.pi[Char.CharInfo[super.cf][0][0]].id, super.cx + Char.CharInfo[super.cf][0][1] + part.pi[Char.CharInfo[super.cf][0][0]].dx, super.cy - Char.CharInfo[super.cf][0][2] + part.pi[Char.CharInfo[super.cf][0][0]].dy, 0, 0);
                            SmallImage.drawSmallImage(g, part1.pi[Char.CharInfo[super.cf][1][0]].id, super.cx + Char.CharInfo[super.cf][1][1] + part1.pi[Char.CharInfo[super.cf][1][0]].dx, super.cy - Char.CharInfo[super.cf][1][2] + part1.pi[Char.CharInfo[super.cf][1][0]].dy, 0, 0);
                            SmallImage.drawSmallImage(g, part2.pi[Char.CharInfo[super.cf][2][0]].id, super.cx + Char.CharInfo[super.cf][2][1] + part2.pi[Char.CharInfo[super.cf][2][0]].dx, super.cy - Char.CharInfo[super.cf][2][2] + part2.pi[Char.CharInfo[super.cf][2][0]].dy, 0, 0);
                        } else {
                            SmallImage.drawSmallImage(g, part.pi[Char.CharInfo[super.cf][0][0]].id, super.cx - Char.CharInfo[super.cf][0][1] - part.pi[Char.CharInfo[super.cf][0][0]].dx, super.cy - Char.CharInfo[super.cf][0][2] + part.pi[Char.CharInfo[super.cf][0][0]].dy, 2, 24);
                            SmallImage.drawSmallImage(g, part1.pi[Char.CharInfo[super.cf][1][0]].id, super.cx - Char.CharInfo[super.cf][1][1] - part1.pi[Char.CharInfo[super.cf][1][0]].dx, super.cy - Char.CharInfo[super.cf][1][2] + part1.pi[Char.CharInfo[super.cf][1][0]].dy, 2, 24);
                            SmallImage.drawSmallImage(g, part2.pi[Char.CharInfo[super.cf][2][0]].id, super.cx - Char.CharInfo[super.cf][2][1] - part2.pi[Char.CharInfo[super.cf][2][0]].dx, super.cy - Char.CharInfo[super.cf][2][2] + part2.pi[Char.CharInfo[super.cf][2][0]].dy, 2, 24);
                        }
                        if (super.indexEffTask >= 0 && super.effTask != null && super.cTypePk == 0) {
                            SmallImage.drawSmallImage(g, super.effTask.arrEfInfo[super.indexEffTask].idImg, super.cx + super.effTask.arrEfInfo[super.indexEffTask].dx, super.cy + super.effTask.arrEfInfo[super.indexEffTask].dy, 0, 3);
                            if (GameCanvas.gameTick % 2 == 0) {
                                super.indexEffTask++;
                                if (super.indexEffTask >= super.effTask.arrEfInfo.length) {
                                    super.indexEffTask = 0;
                                }
                            }
                        }
                        if (Char.getMyChar().npcFocus != null && Char.getMyChar().npcFocus.equals(this)) {
                            mFont.tahoma_7_yellow.drawString(g, this.template.name, super.cx, super.cy - super.ch - mFont.tahoma_7.getHeight() - 7, 2, mFont.tahoma_7_grey);
                            SmallImage.drawSmallImage(g, 988, super.cx, super.cy - super.ch - 2, 0, 33);
                        } else {
                            mFont.tahoma_7_yellow.drawString(g, this.template.name, super.cx, super.cy - super.ch - 3 - mFont.tahoma_7.getHeight(), 2, mFont.tahoma_7_grey);
                        }
                    }
                }
            }
        }
    }
}
