package nso;

public final class SMS {

    public SMS() {
    }

    public static void sendSMS(String text, String text1, Command command, Command command2) {
        String text3 = text1;
        new Thread(new SmsSender(text3, text, text1, command, command2)).start();
    }

    public static void startConnectionThread() {
        Session_ME.instance.initThread.start();
    }
}
