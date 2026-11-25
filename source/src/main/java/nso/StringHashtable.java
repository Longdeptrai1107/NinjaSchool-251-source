package nso;

import java.util.Hashtable;

public final class StringHashtable extends Hashtable {

    public StringHashtable() {
    }

    public final synchronized Object put(String text, Object argument) {
        return super.put(text, argument);
    }

    public final synchronized void clear() {
        super.clear();
    }

    public final synchronized Object remove(Object argument) {
        return super.remove(argument);
    }

    public final synchronized Object get(String text) {
        return super.get(text);
    }
}
