package nso;

import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;

final class SessionConnector implements Runnable {

    private final String connectionUrl;

    private Session_ME session;

    SessionConnector(Session_ME sessionME, String text) {
        this.session = sessionME;
        this.connectionUrl = text;
    }

    public final void run() {
        Session_ME.isCancel = false;
        new Thread(new ConnectionTimeout()).start();
        this.session.connecting = true;
        Thread.currentThread().setPriority(1);
        this.session.connected = true;
        try {
            String text = this.connectionUrl;
            SessionConnector sessionConnector = this;
            this.session.sc = (SocketConnection) Connector.open(text);
            Session_ME.setOutputStream(sessionConnector.session, sessionConnector.session.sc.openDataOutputStream());
            sessionConnector.session.dis = sessionConnector.session.sc.openDataInputStream();
            new Thread(Session_ME.getSender(sessionConnector.session)).start();
            sessionConnector.session.collectorThread = new Thread(new SessionReceiver(sessionConnector.session));
            sessionConnector.session.collectorThread.start();
            sessionConnector.session.timeConnected = System.currentTimeMillis();
            Session_ME.sendMessageNow(sessionConnector.session, new Message((byte) -27));
            sessionConnector.session.connecting = false;
            Controller controller = this.session.messageHandler;
            System.out.println("Connect ok");
        } catch (Exception exception) {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException interruptedException) {
            }
            if (!Session_ME.isCancel) {
                if (this.session.messageHandler != null) {
                    this.session.close();
                    this.session.messageHandler.onConnectionError();
                }
            }
        }
    }
}
