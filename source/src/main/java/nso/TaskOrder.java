package nso;

public final class TaskOrder {

    public int taskId;

    public int count;

    public int maxCount;

    public String name;

    public String description;

    public int killId;

    public int mapId;

    public TaskOrder(byte taskId1, int count2, int maxCount3, String name4, String description5, int killId6, int mapId7) {
        this.count = count2;
        this.maxCount = maxCount3;
        this.taskId = taskId1;
        this.name = name4;
        this.description = description5;
        this.killId = killId6;
        this.mapId = mapId7;
    }
}
