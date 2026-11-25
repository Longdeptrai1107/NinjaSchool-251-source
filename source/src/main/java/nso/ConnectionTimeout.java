package nso;

final class ConnectionTimeout implements Runnable {

    ConnectionTimeout() {
    }

    public final void run() {
        try {
            Thread.sleep(20000L);
        } catch (InterruptedException interruptedException) {
        }
        if (Session_ME.instance.connecting) {
            try {
                Session_ME.instance.sc.close();
            } catch (Exception exception) {
            }
            Session_ME.isCancel = true;
            Session_ME.instance.connecting = false;
            Session_ME.instance.connected = false;
            Session_ME.instance.messageHandler.onConnectionError();
        }
    }
}
