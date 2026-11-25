package nso;

public final class Part {

    public PartImage[] pi;

    public Part(int type) {
        if (type == 0) {
            this.pi = new PartImage[8];
        }
        if (type == 1) {
            this.pi = new PartImage[18];
        }
        if (type == 2) {
            this.pi = new PartImage[10];
        }
        if (type == 3) {
            this.pi = new PartImage[2];
        }
    }
}
