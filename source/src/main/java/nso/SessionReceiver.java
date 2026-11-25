package nso;

import main.GameCanvas;
import java.io.IOException;

final class SessionReceiver implements Runnable {

    private Session_ME session;

    SessionReceiver(Session_ME sessionME) {
        this.session = sessionME;
    }

    public final void run() {
        try {
            while (this.session.isConnected()) {
                SessionReceiver sessionReceiver = this;
                byte byteValue = this.session.dis.readByte();
                if (sessionReceiver.session.getKeyComplete) {
                    byteValue = Session_ME.readKey(sessionReceiver.session, byteValue);
                }
                int value;
                if (byteValue == -32) {
                    byteValue = sessionReceiver.session.dis.readByte();
                    if (sessionReceiver.session.getKeyComplete) {
                        byteValue = Session_ME.readKey(sessionReceiver.session, byteValue);
                    }
                    byte byteValue1 = Session_ME.readKey(sessionReceiver.session, sessionReceiver.session.dis.readByte());
                    byte byteValue2 = Session_ME.readKey(sessionReceiver.session, sessionReceiver.session.dis.readByte());
                    byte byteValue3 = Session_ME.readKey(sessionReceiver.session, sessionReceiver.session.dis.readByte());
                    byte byteValue4 = Session_ME.readKey(sessionReceiver.session, sessionReceiver.session.dis.readByte());
                    value = (byteValue1 & 255) << 24 | (byteValue2 & 255) << 16 | (byteValue3 & 255) << 8 | byteValue4 & 255;
                } else if (sessionReceiver.session.getKeyComplete) {
                    byte byteValue5 = sessionReceiver.session.dis.readByte();
                    byte byteValue6 = sessionReceiver.session.dis.readByte();
                    value = (Session_ME.readKey(sessionReceiver.session, byteValue5) & 255) << 8 | Session_ME.readKey(sessionReceiver.session, byteValue6) & 255;
                } else {
                    value = sessionReceiver.session.dis.readUnsignedShort();
                }
                byte[] data = new byte[value];
                int value7 = 0;
                int value8 = 0;
                while (value7 != -1 && value8 < value) {
                    if ((value7 = sessionReceiver.session.dis.read(data, value8, value - value8)) > 0) {
                        value8 += value7;
                        sessionReceiver.session.recvByteCount += value8 + 5;
                        int value9 = Session_ME.gI().recvByteCount + Session_ME.gI().sendByteCount;
                        sessionReceiver.session.host = value9 / 1024 + "." + value9 % 1024 / 102 + "Kb";
                    }
                }
                if (sessionReceiver.session.getKeyComplete) {
                    for (int index = 0; index < data.length; index++) {
                        data[index] = Session_ME.readKey(sessionReceiver.session, data[index]);
                    }
                }
                Message message = new Message(byteValue, data);
                try {
                    if (message.command == -27) {
                        this.getKey(message);
                    } else {
                        this.session.messageHandler.onMessage(message);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        } catch (Exception exception10) {
        }
        if (this.session.connected) {
            if (this.session.messageHandler != null) {
                if (System.currentTimeMillis() - this.session.timeConnected > 500L) {
                    Controller controller = this.session.messageHandler;
                    GameCanvas.instance.resetToLoginScr();
                } else {
                    this.session.messageHandler.onConnectionError();
                }
            }
            if (this.session.sc != null) {
                Session_ME.cleanNetwork(this.session);
            }
        }
    }

    private void getKey(Message message) throws IOException {
        byte byteValue = message.reader().readByte();
        this.session.key = new byte[byteValue];
        for (int index = 0; index < byteValue; index++) {
            this.session.key[index] = message.reader().readByte();
        }
        for (int index1 = 0; index1 < this.session.key.length - 1; index1++) {
            this.session.key[index1 + 1] = (byte) (this.session.key[index1 + 1] ^ this.session.key[index1]);
        }
        this.session.getKeyComplete = true;
    }
}
