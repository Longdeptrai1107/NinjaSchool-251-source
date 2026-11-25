package nso;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class Message {

    public byte command;

    private ByteArrayOutputStream outputBuffer = null;

    private DataOutputStream dos = null;

    private ByteArrayInputStream inputBuffer = null;

    private DataInputStream dis = null;

    public Message() {
    }

    public Message(byte command1) {
        this.command = command1;
        this.outputBuffer = new ByteArrayOutputStream();
        this.dos = new DataOutputStream(this.outputBuffer);
    }

    public Message(byte command1, byte[] data) {
        this.command = command1;
        this.inputBuffer = new ByteArrayInputStream(data);
        this.dis = new DataInputStream(this.inputBuffer);
    }

    public final byte[] getData() {
        return this.outputBuffer.toByteArray();
    }

    public final DataInputStream reader() {
        return this.dis;
    }

    public final DataOutputStream writer() {
        return this.dos;
    }

    public final void cleanup() {
        try {
            if (this.dis != null) {
                this.dis.close();
            }
            if (this.dos != null) {
                this.dos.close();
                return;
            }
        } catch (IOException iOException) {
        }
    }
}
