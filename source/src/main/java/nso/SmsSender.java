package nso;

import javax.microedition.io.Connector;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

final class SmsSender implements Runnable {

    private final String smsUrl;

    private final String messageText;

    private final String recipient;

    private final Command onSuccess;

    private final Command onFailure;

    SmsSender(String text, String text1, String text2, Command command, Command command3) {
        this.smsUrl = text;
        this.messageText = text1;
        this.recipient = text2;
        this.onSuccess = command;
        this.onFailure = command3;
    }

    public final void run() {
        try {
            MessageConnection messageConnection = null;
            TextMessage textMessage;
            (textMessage = (TextMessage) (messageConnection = (MessageConnection) Connector.open(this.smsUrl)).newMessage("text")).setAddress(this.smsUrl);
            textMessage.setPayloadText(this.messageText);
            messageConnection.send(textMessage);
            System.out.println("SMS data: " + this.messageText + ", to: " + this.recipient);
            this.onSuccess.performAction();
        } catch (Exception exception) {
            this.onFailure.performAction();
        }
    }
}
