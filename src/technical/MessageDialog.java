package technical;

import javax.swing.*;

/**
 * Created by Jacob on 20-04-2017.
 */
public class MessageDialog {

    public MessageDialog() {}

    public void errorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void infoMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Hotel System", JOptionPane.INFORMATION_MESSAGE);
    }
}
