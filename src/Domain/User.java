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
    private String name;
    private String email;
    private String password;
    private boolean isAdmin;

    public User() {
        db = new DBFacade();
        messageDialog = new MessageDialog();
    }

    public void deleteUser(int userID) throws SQLException {
        CallableStatement cl = db.callableStatement("{call deleteUser(?)}");
        cl.setInt(1, userID);
        int rows = cl.executeUpdate();
        if (rows > 0) {
            messageDialog.deleteMessage("You successfully deleted user with ID =  " + userID);
        } else {
            messageDialog.errorMessage("No such ID found");
        }
    }

    public void insertUser(String name, String email, String password, boolean isAdmin) {
        this.name = name;
        this.email = email;
        this.password = Encrypt.password(password);
        this.isAdmin = isAdmin;

        try {
            CallableStatement cl = db.callableStatement("{call selectUser(?)}");

            cl.setString(1, email);

            ResultSet rs = cl.executeQuery();

            if(rs.next()) {
                messageDialog.errorMessage("User already exists with this email: " + this.email);
            } else {
                CallableStatement clInsert = db.callableStatement("{call insertUser(?, ?, ?, ?)}");

                clInsert.setString(1, this.name);
                clInsert.setString(2, this.email);
                clInsert.setString(3, this.password);
                clInsert.setBoolean(4, this.isAdmin);

                clInsert.executeUpdate();

                messageDialog.infoMessage(name + " have been created!");
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
