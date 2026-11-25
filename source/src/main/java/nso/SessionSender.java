package nso;

import java.io.IOException;

final class SessionSender implements Runnable {

    final Session_ME session;

    public SessionSender(Session_ME sessionME) {
        this.session = sessionME;
        Session_ME.setSendQueue(sessionME, new MyVector());
    }

    public final void run() {
        while (this.session.connected) {
            try {
                if (this.session.getKeyComplete) {
                    while (Session_ME.getSendQueue(this.session).size() > 0) {
                        GameScr.gI();
                        Message message = (Message) Session_ME.getSendQueue(this.session).elementAt(0);
                        Session_ME.getSendQueue(this.session).removeElementAt(0);
                        Session_ME.sendMessageNow(this.session, message);
                    }
                }
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException interruptedException) {
                }
            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }
}
