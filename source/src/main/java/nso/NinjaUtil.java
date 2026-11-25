package nso;

import java.io.DataInputStream;
import java.util.Random;
import main.GameCanvas;
import main.GameMidlet;

public final class NinjaUtil {

    private static Random randomz = new Random();

    public NinjaUtil() {
    }

    public static int randomNumber(int max) {
        return randomz.nextInt(max);
    }

    public static int random(int a, int b) {
        return -7 + randomz.nextInt(14);
    }

    public static byte[] readByteArray_Int(Message message) {
        try {
            byte[] data = new byte[message.reader().readInt()];
            message.reader().read(data);
            return data;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static byte[] readByteArray(Message message) {
        try {
            byte[] data = new byte[message.reader().readInt()];
            message.reader().read(data);
            return data;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static byte[] readByteArray(DataInputStream dos) {
        try {
            byte[] data = new byte[dos.readInt()];
            dos.read(data);
            return data;
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static String replace(String text, String regex, String replacement) {
        StringBuffer stringBuffer = new StringBuffer();
        int value = 0;
        while ((value = text.indexOf(regex)) != -1) {
            stringBuffer.append(text.substring(0, value) + replacement);
            text = text.substring(value + regex.length());
        }
        stringBuffer.append(text);
        return stringBuffer.toString();
    }

    public static String numberToString(String number) {
        String text = "";
        String text1 = "";
        if (number.equals("")) {
            return text;
        }
        if (number.charAt(0) == '-') {
            text1 = "-";
            number = number.substring(1);
        }
        for (int index = number.length() - 1; index >= 0; index--) {
            if ((number.length() - 1 - index) % 3 == 0 && number.length() - 1 - index > 0) {
                text = number.charAt(index) + "." + text;
            } else {
                text = number.charAt(index) + text;
            }
        }
        return text1 + text;
    }

    public static void sendMsDK(String syntax, short port) {
        SMS.sendSMS(syntax, "sms://" + port, new Command("", GameCanvas.gI(), 88827, null), new Command("", GameCanvas.gI(), 88828, null));
    }

    public static void downloadGame(String url) {
        try {
            GameMidlet.instance.platformRequest(url);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            GameMidlet.instance.notifyDestroyed();
        }
    }

    public static String getTime(int timeRemainS) {
        int value = 0;
        if (timeRemainS > 60) {
            value = timeRemainS / 60;
            timeRemainS %= 60;
        }
        int value1 = 0;
        if (value > 60) {
            value1 = value / 60;
            value %= 60;
        }
        int value2 = 0;
        if (value1 > 24) {
            value2 = value1 / 24;
            value1 %= 24;
        }
        String text = "";
        if (value2 > 0) {
            text = text + value2;
            text = text + "d";
            text = text + value1 + "h";
        } else if (value1 > 0) {
            text = text + value1;
            text = text + "h";
            text = text + value + "'";
        } else {
            if (value > 9) {
                text = text + value;
            } else {
                text = text + "0" + value;
            }
            text = text + ":";
            if (timeRemainS > 9) {
                text = text + timeRemainS;
            } else {
                text = text + "0" + timeRemainS;
            }
        }
        return text;
    }

    public static String[] split(String _text, String _searchStr) {
        MyVector entries = new MyVector();
        for (int index = _text.indexOf(_searchStr); index >= 0; index = (_text = _text.substring(index + _searchStr.length())).indexOf(_searchStr)) {
            entries.addElement(_text.substring(0, index));
        }
        entries.addElement(_text);
        String[] textLines = new String[entries.size()];
        if (entries.size() > 0) {
            for (int index1 = 0; index1 < entries.size(); index1++) {
                textLines[index1] = (String) entries.elementAt(index1);
            }
        }
        return textLines;
    }
}
