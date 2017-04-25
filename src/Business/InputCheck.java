package Business;

import Technical.MessageDialog;

import javax.swing.*;
import java.math.BigDecimal;

/**
 * Created by Jacob on 25-04-2017.
 */
public class InputCheck {
    private static MessageDialog messageDialog = new MessageDialog();

    public static int checkForInt(JTextField textField) {
        try {
            int number = Integer.parseInt(textField.getText());

            return number;
        } catch (NumberFormatException e) {
            messageDialog.errorMessage("Please insert a number!");
        }

        return 0;
    }

    public static BigDecimal checkForBigDecimal(JTextField textField) {
        BigDecimal bigDecimal = new BigDecimal(textField.getText());

        return bigDecimal;
    }
}
