package nso;

import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;

final class NativeTextBoxListener implements CommandListener {

    private TField textField;

    private final TextBox textBox;

    NativeTextBoxListener(TField textField, TextBox textBox) {
        this.textField = textField;
        this.textBox = textBox;
    }

    public final void commandAction(javax.microedition.lcdui.Command javaxmicroeditionlcduiCommand, Displayable displayable) {
        if (javaxmicroeditionlcduiCommand.getLabel().equals(mResources.OK)) {
            this.textField.setText(this.textBox.getString());
        }
        Display.getDisplay(TField.midlet).setCurrent(TField.returnCanvas);
        TField.returnCanvas.setFullScreenMode(true);
    }
}
