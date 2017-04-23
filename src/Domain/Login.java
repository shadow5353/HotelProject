package Domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jacob on 18-04-2017.
 */
public class Login {
    private DB db = new DB();
    private int userID;

    public Login() {

    }

    public boolean login(String username, String password) {
        try {
            PreparedStatement ps = db.preparedStatement("SELECT * FROM tblUsers WHERE fldEmail = ? AND fldPassword = ?");

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                this.userID = rs.getInt("fldID");
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public int getUserID() {
        return userID;
    }
}
