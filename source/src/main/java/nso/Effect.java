package nso;

public final class Effect {

    public static EffectTemplate[] effTemplates;

    public int timeStart;

    public int timeLenght;

    public short param;

    public EffectTemplate template;

    public Effect(byte templateId, int timeStart1, int timeLenght2, short param3) {
        this.template = effTemplates[templateId];
        this.timeStart = timeStart1;
        this.timeLenght = timeLenght2 / 1000;
        this.param = param3;
    }
}
