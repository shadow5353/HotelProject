package Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Jacob on 18-04-2017.
 */
public class DB {
    private String userName = "sa";
    private String password = "987654321";
    private String port = "1433";
    private String databaseName = "db_Hotel";
    private Connection con;
    private PreparedStatement ps;

    public DB() {

        openConnection();
    }

    private void openConnection()  {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:"+port+";databaseName="+databaseName,userName,password);
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement preparedStatement(String sql) throws SQLException {
        ps = con.prepareStatement(sql);

        return ps;
    }

}
