package Domain;

import Technical.DBFacade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jacob on 18-04-2017.
 */
public class UserInfo {
    private DBFacade dbFacade = new DBFacade();
    private int userID;

    public UserInfo(int userID) {
        this.userID = userID;
    }

    /**
     * Get the name of the user
     * @return the users name
     */
    public String getName() {
        try {
            String name;

            PreparedStatement ps = dbFacade.preparedStatement("SELECT fldName FROM tblUsers WHERE fldUserID = ?");

            ps.setInt(1, this.userID);

            ResultSet rs = ps.executeQuery();

            rs.next();
            name = rs.getString(1);

            return name;
        } catch (SQLException e) {
            e.getStackTrace();
        }

        return null;
    }

    /**
     * Get admin status on the user
     * @return true or false if the user is admin
     */
    public boolean getIsAdmin() {
        boolean isAdmin = false;
        try {
            PreparedStatement ps = dbFacade.preparedStatement("SELECT fldAdmin FROM tblUsers WHERE fldUserID = ?");

            ps.setInt(1, this.userID);

            ResultSet rs = ps.executeQuery();

            rs.next();

            if (rs.getBoolean(1)) {
                isAdmin = true;
            } else {
                isAdmin = false;
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }

        return isAdmin;
    }
}
