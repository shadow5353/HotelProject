package Domain;

import Technical.DBFacade;
import Technical.MessageDialog;

import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 * Created by Bruger on 27-04-2017.
 */
public class CateringOrder {
    private DBFacade db;
    private MessageDialog messageDialog;

    public CateringOrder() {
        db = new DBFacade();
        messageDialog = new MessageDialog();
    }

    public void insertCateringOrder(int cateringID, int customerID) {
        try {
            CallableStatement cl = db.callableStatement("{call insertCateringOrder (?, ?)}");

            cl.setInt(1, customerID);
            cl.setInt(2, cateringID);

            cl.executeUpdate();

            messageDialog.infoMessage("Customer " + customerID + " have ordered " + cateringID + " successfully!");
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
