package nso;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.microedition.io.SocketConnection;
import main.GameMidlet;

public final class Session_ME {

    protected static Session_ME instance = new Session_ME();

    public boolean unusedSessionFlag = false;

    private DataOutputStream dos;

    public DataInputStream dis;

    public Controller messageHandler;

    public SocketConnection sc;

    public boolean connected;

    public boolean connecting;

    private final SessionSender sender = new SessionSender(this);

    public Thread initThread;

    public Thread collectorThread;

    public int sendByteCount;

    public int recvByteCount;

    boolean getKeyComplete;

    public byte[] key = null;

    private byte curR;

    private byte curW;

    long timeConnected;

    public String host = "";

    public static boolean isCancel;

    private MyVector sendQueue;

    public Session_ME() {
    }

    public static Session_ME gI() {
        return instance;
    }

    public final boolean isConnected() {
        return this.connected;
    }

    public final void setHandler(Controller controller) {
        this.messageHandler = controller;
    }

    public final void connect(String text) {
        System.out.println("connect to " + text + ":" + GameMidlet.serverLogin);
        if (!this.connected && !this.connecting) {
            this.getKeyComplete = false;
            this.sc = null;
            this.initThread = new Thread(new SessionConnector(this, text));
            SMS.startConnectionThread();
        }
    }

    public final void sendMessage(Message message) {
        message = message;
        SessionSender sessionSender = this.sender;
        this.sender.session.sendQueue.addElement(message);
    }

    private synchronized void doSendMessage(Message m) {
        byte[] data = m.getData();
        try {
            if (this.getKeyComplete) {
                byte byteValue = this.writeKey(m.command);
                this.dos.writeByte(byteValue);
            } else {
                this.dos.writeByte(m.command);
            }
            new StringBuffer("cmd send ---> ").append(m.command).toString();
            if (data != null) {
                int value = data.length;
                if (m.command != -31 && this.getKeyComplete) {
                    byte byteValue1 = this.writeKey((byte) (value >> 8));
                    this.dos.writeByte(byteValue1);
                    byte byteValue2 = this.writeKey((byte) value);
                    this.dos.writeByte(byteValue2);
                } else {
                    this.dos.writeShort(value);
                }
                if (this.getKeyComplete) {
                    for (int index = 0; index < data.length; index++) {
                        data[index] = this.writeKey(data[index]);
                    }
                }
                this.dos.write(data);
                this.sendByteCount += 5 + data.length;
            } else {
                this.dos.writeShort(0);
                this.sendByteCount += 5;
            }
            this.dos.flush();
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private byte writeKey(byte byteValue) {
        byteValue = (byte) (this.key[this.curW++] & 0xFF ^ byteValue & 0xFF);
        if (this.curW >= this.key.length) {
            this.curW = (byte) (this.curW % this.key.length);
        }
        return byteValue;
    }

    public final void close() {
        this.cleanNetwork();
    }

    private void cleanNetwork() {
        this.key = null;
        this.curR = 0;
        this.curW = 0;
        try {
            this.connected = false;
            this.connecting = false;
            if (this.sc != null) {
                this.sc.close();
                this.sc = null;
            }
            if (this.dos != null) {
                this.dos.close();
                this.dos = null;
            }
            if (this.dis != null) {
                this.dis.close();
                this.dis = null;
            }
            this.collectorThread = null;
            System.gc();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    static void setOutputStream(Session_ME sessionME, DataOutputStream dataOutputStream) {
        sessionME.dos = dataOutputStream;
    }

    static SessionSender getSender(Session_ME sessionME) {
        return sessionME.sender;
    }

    static void sendMessageNow(Session_ME sessionME, Message message) throws IOException {
        sessionME.doSendMessage(message);
    }

    static void setSendQueue(Session_ME sessionME, MyVector entries) {
        sessionME.sendQueue = entries;
    }

    static MyVector getSendQueue(Session_ME sessionME) {
        return sessionME.sendQueue;
    }

    static void cleanNetwork(Session_ME sessionME) {
        sessionME.cleanNetwork();
    }

    static byte readKey(Session_ME sessionME, byte byteValue) {
        byteValue = byteValue;
        Session_ME sessionME1 = sessionME;
        byteValue = (byte) (sessionME.key[sessionME1.curR++] & 0xFF ^ byteValue & 0xFF);
        if (sessionME1.curR >= sessionME1.key.length) {
            sessionME1.curR = (byte) (sessionME1.curR % sessionME1.key.length);
        }
        return byteValue;
    }
}
