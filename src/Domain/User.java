package Domain;

import Technical.DBFacade;
import Technical.Encrypt;
import Technical.MessageDialog;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jacob on 20-04-2017.
 */
public class User {
    private DBFacade db;
    private MessageDialog messageDialog;

    public User() {
        db = new DBFacade();
        messageDialog = new MessageDialog();
    }

    public void deleteUser(int userID) {
        try {
            CallableStatement cl = db.callableStatement("{call deleteService(?)}");
            cl.setInt(1, userID);
            int rows = cl.executeUpdate();
            if (rows > 0) {
                messageDialog.deleteMessage("You successfully deleted user with ID = " + userID);
            } else {
                messageDialog.errorMessage("No such ID found");
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public void updateUser(int userID, String name, String email, boolean isAdmin) {
        try {
            CallableStatement cl = db.callableStatement("{call updateService (?, ?, ?, ?)}");

            cl.setInt(1, userID);
            cl.setString(2, name);
            cl.setString(3, email);
            cl.setBoolean(4, isAdmin);

            cl.executeUpdate();

            messageDialog.infoMessage(name + " have been updated!");
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public void insertUser(String name, String email, String password, boolean isAdmin) {

        try {
            CallableStatement cl = db.callableStatement("{call selectUser(?)}");

            cl.setString(1, email);

            ResultSet rs = cl.executeQuery();

            if (rs.next()) {
                messageDialog.errorMessage("User already exists with this email: " + email);
            } else {
                CallableStatement clInsert = db.callableStatement("{call insertUser(?, ?, ?, ?)}");

                password = Encrypt.password(password);

                clInsert.setString(1, name);
                clInsert.setString(2, email);
                clInsert.setString(3, password);
                clInsert.setBoolean(4, isAdmin);

                clInsert.executeUpdate();

                messageDialog.infoMessage(name + " have been created!");
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
