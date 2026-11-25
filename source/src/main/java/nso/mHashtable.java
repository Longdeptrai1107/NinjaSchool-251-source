package nso;

import java.util.Hashtable;

public final class mHashtable {

    public Hashtable h = new Hashtable();

    public mHashtable() {
    }

    public final Object get(Object k) {
        return this.h.get(k);
    }

    public final boolean equals(Object argument) {
        return this.h.equals(argument);
    }

    public final void put(Object k, Object v) {
        this.h.put(k, v);
    }
}
