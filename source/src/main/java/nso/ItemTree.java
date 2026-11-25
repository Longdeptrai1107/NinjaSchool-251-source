package nso;

import javax.microedition.lcdui.Image;
import main.GameCanvas;

public final class ItemTree {

    public int idTree;

    private int xTree;

    private int yTree;

    public ItemTree(int x, int y) {
        this.xTree = x * 24 + 12;
        this.yTree = y * 24 + 24 + 3;
    }

    private Object getImageFromHash() {
        Object argument;
        return (argument = TileMap.itemMap.get(String.valueOf(this.idTree))) != null ? argument : null;
    }

    public final void paint(mGraphics g) {
        if (!GameCanvas.lowGraphic) {
            if (this.getImageFromHash() != null) {
                g.drawImage((Image) this.getImageFromHash(), this.xTree, this.yTree, 33);
            }
        }
    }
}
