package nso;

public final class Skills {

    private static mHashtable skills = new mHashtable();

    public Skills() {
    }

    public static void add(Skill skill) {
        skills.put(new Short(skill.skillId), skill);
    }

    public static Skill get(short skillId) {
        return (Skill) skills.get(new Short(skillId));
    }
}
