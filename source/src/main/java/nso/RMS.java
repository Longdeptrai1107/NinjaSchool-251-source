package nso;

import javax.microedition.rms.RecordStore;

public final class RMS {

    public RMS() {
    }

    public static void saveRMS(String text, byte[] data) {
        try {
            RecordStore recordStore;
            if ((recordStore = RecordStore.openRecordStore("vj" + text, true)).getNumRecords() > 0) {
                recordStore.setRecord(1, data, 0, data.length);
            } else {
                recordStore.addRecord(data, 0, data.length);
            }
            recordStore.closeRecordStore();
        } catch (Exception exception) {
        }
    }

    public static byte[] loadRMS(String text) {
        try {
            RecordStore recordStore;
            byte[] data = (recordStore = RecordStore.openRecordStore("vj" + text, false)).getRecord(1);
            recordStore.closeRecordStore();
            return data;
        } catch (Exception exception) {
            return null;
        }
    }

    public static void saveRMSInt(String file, int x) {
        try {
            saveRMS(file, new byte[] { (byte) x });
        } catch (Exception exception) {
        }
    }

    public static void saveRMSString(String filename, String data) {
        try {
            saveRMS(filename, data.getBytes("UTF-8"));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static String loadRMSString(String fileName) {
        byte[] data;
        if ((data = loadRMS(fileName)) == null) {
            return null;
        }
        try {
            return new String(data, "UTF-8");
        } catch (Exception exception) {
            return new String(data);
        }
    }

    public static int loadRMSInt(String file) {
        byte[] data;
        return (data = loadRMS(file)) == null ? -1 : data[0];
    }

    private static void deleteRecord(String name) {
        try {
            RecordStore.deleteRecordStore("vj" + name);
        } catch (Exception exception) {
        }
    }

    public static void saveRMSImage(String text, byte[] data) {
        try {
            RecordStore recordStore;
            if ((recordStore = RecordStore.openRecordStore("vj" + text, true)).getNumRecords() > 0) {
                recordStore.setRecord(1, data, 0, data.length);
            } else {
                recordStore.addRecord(data, 0, data.length);
            }
            recordStore.closeRecordStore();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void clearRMS() {
        deleteRecord("nj_arrow");
        deleteRecord("nj_effect");
        deleteRecord("nj_image");
        deleteRecord("nj_part");
        deleteRecord("nj_skill");
        deleteRecord("data");
        deleteRecord("dataVersion");
        deleteRecord("map");
        deleteRecord("mapVersion");
        deleteRecord("skill");
        deleteRecord("killVersion");
        deleteRecord("item");
        deleteRecord("itemVersion");
    }
}
