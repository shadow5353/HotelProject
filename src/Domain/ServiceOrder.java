package Domain;

import Technical.DBFacade;
import Technical.MessageDialog;

import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 * Created by Jacob on 26-04-2017.
 */
public class ServiceOrder {
    private DBFacade db;
    private MessageDialog messageDialog;

    public ServiceOrder() {
        db = new DBFacade();
        messageDialog = new MessageDialog();
    }

    public void insertServiceOrder(int serviceID, int customerID) {
        try {
            CallableStatement cl = db.callableStatement("{call insertServiceOrder (?, ?)}");

            cl.setInt(1, serviceID);
            cl.setInt(2, customerID);

            cl.executeUpdate();

            messageDialog.infoMessage("Customer " + customerID + " have ordered " + serviceID + " successfully!");
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
