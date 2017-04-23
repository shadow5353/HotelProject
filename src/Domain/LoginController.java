package Domain;

import technical.DBFacade;
import technical.Encrypt;

import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jacob on 18-04-2017.
 */
public class LoginController {
    private DBFacade dbFacade = new DBFacade();
    private int userID;

    public LoginController() {}

    /**
     * Check if the user exist in the database
     * @param email the username of the user
     * @param password the password of the user
     * @return true or false if the user exist
     */
    public boolean login(String email, String password) {
        try {

            password = Encrypt.password(password);

            CallableStatement cl = dbFacade.callableStatement("{call loginUser(?, ?)}");

            cl.setString(1, email);
            cl.setString(2, password);

            ResultSet rs = cl.executeQuery();

            if(rs.next()) {
                this.userID = rs.getInt("fldUserID");
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Get the userID
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }
}
