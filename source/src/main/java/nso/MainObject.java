package nso;

public class MainObject {

    public MyVector vecEFfect = new MyVector();

    public MainObject() {
    }

    public final void paintTopDataEff(mGraphics graphics, int value, int value1, int value2) {
        for (int index = 0; index < this.vecEFfect.size(); index++) {
            DataSkillEff dataSkillEff;
            if ((dataSkillEff = (DataSkillEff) this.vecEFfect.elementAt(index)) != null) {
                int value3 = value1;
                if (dataSkillEff.isHead) {
                    value3 = value1 + value2 + 4;
                }
                dataSkillEff.paintTopEff(graphics, value, value3);
            }
        }
    }

    public final void paintBottomDataEff(mGraphics graphics, int value, int value1, int value2) {
        for (int index = 0; index < this.vecEFfect.size(); index++) {
            DataSkillEff dataSkillEff;
            if ((dataSkillEff = (DataSkillEff) this.vecEFfect.elementAt(index)) != null) {
                int value3 = value1;
                if (dataSkillEff.isHead) {
                    value3 = value1 + value2 + 4;
                }
                dataSkillEff.paintBottomEff(graphics, value, value3);
            }
        }
    }

    public final void updateDataEff(byte type, int statusMe) {
        for (int index = 0; index < this.vecEFfect.size(); index++) {
            DataSkillEff dataSkillEff;
            if ((dataSkillEff = (DataSkillEff) this.vecEFfect.elementAt(index)) != null) {
                dataSkillEff.update();
                if (dataSkillEff.wantDetroy) {
                    this.vecEFfect.removeElement(dataSkillEff);
                }
            }
        }
        if (type == 0 && statusMe == 14) {
            this.vecEFfect.removeAllElements();
        }
        if (type == 1 && statusMe == 0) {
            this.vecEFfect.removeAllElements();
        }
    }
}
