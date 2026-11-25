package nso;

import main.GameCanvas;

public final class Skill {

    public SkillTemplate template;

    public short skillId;

    public int point;

    public int level;

    public int coolDown;

    public long lastTimeUseThisSkill;

    public int dx;

    public int dy;

    public int maxFight;

    public int manaUse;

    public SkillOption[] options;

    public boolean paintCanNotUseSkill = false;

    public Skill() {
    }

    public final void paint(int x, int y, mGraphics g) {
        SmallImage.drawSmallImage(g, this.template.iconId, x, y, 0, StaticObj.VCENTER_HCENTER);
        long longValue;
        if ((longValue = System.currentTimeMillis() - this.lastTimeUseThisSkill) < this.coolDown) {
            g.setColor(3355443);
            if (this.paintCanNotUseSkill && GameCanvas.gameTick % 6 > 2) {
                g.setColor(4473924);
            }
            int value = (int) (longValue * 18L / this.coolDown);
            g.fillRect(x - 9, y - 9 + value, 18, 18 - value);
        } else {
            this.paintCanNotUseSkill = false;
        }
    }

    public final boolean isCooldown() {
        return System.currentTimeMillis() - this.lastTimeUseThisSkill < this.coolDown;
    }
}
