package Domain;

import Technical.DBFacade;
import Technical.MessageDialog;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

/**
 * Created by Jacob on 27-04-2017.
 */
public class Arrangement {
    private DBFacade db;
    private MessageDialog messageDialog;

    public Arrangement() {
        db = new DBFacade();
        messageDialog = new MessageDialog();
    }

    public void createArrangement(int customerID, String arrangementName, String description, int numberOfGuests, BigDecimal price, Date dateFrom, Date dateTo, boolean confirm) {
        try {
            CallableStatement cl = db.callableStatement("{call insertArrangement (?, ?, ?, ?, ?, ?, ?, ?)}");

            cl.setInt(1, customerID);
            cl.setString(2, arrangementName);
            cl.setString(3, description);
            cl.setInt(4, numberOfGuests);
            cl.setBigDecimal(5, price);
            cl.setDate(6, dateFrom);
            cl.setDate(7, dateTo);
            cl.setBoolean(8, confirm);

            cl.executeUpdate();

            messageDialog.infoMessage(arrangementName + " have been created!");

        } catch (SQLException e) {

        }
    }

    public void deleteRoom(int arrangementID) {
        try {
            CallableStatement cl = db.callableStatement("{call deleteArrangement (?)}");

            cl.setInt(1, arrangementID);

            cl.executeUpdate();

            messageDialog.infoMessage("Arrangement: " + arrangementID + " have been deleted!");
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
