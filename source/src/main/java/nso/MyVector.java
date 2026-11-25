package nso;

import java.util.Vector;

public final class MyVector extends Vector {

    public MyVector() {
    }

    public final synchronized void addElement(Object o) {
        super.addElement(o);
    }

    public final synchronized Object elementAt(int index) {
        return super.elementAt(index);
    }

    public final synchronized void removeAllElements() {
        super.removeAllElements();
    }

    public final synchronized boolean removeElement(Object o) {
        return super.removeElement(o);
    }

    public final synchronized void insertElementAt(Object o, int i) {
        super.insertElementAt(o, i);
    }

    public final synchronized void removeElementAt(int index) {
        super.removeElementAt(index);
    }
}
