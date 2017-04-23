package technical;

import java.sql.*;

/**
 * Created by Jacob on 18-04-2017.
 */
public class DBFacade {
    private String userName = "sa";
    private String password = "987654321";
    private String port = "1433";
    private String databaseName = "db_Hotel";
    private Connection con;
    private PreparedStatement ps;
    private CallableStatement cl;

    public DBFacade() {

        openConnection();
    }

    /**
     * Open connection to the database
     */
    private void openConnection()  {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:"+port+";databaseName="+databaseName,userName,password);
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Makes prepared Statement
     * @param sql the SQL code for the prepared statement
     * @return the prepared statement
     * @throws SQLException
     */
    public PreparedStatement preparedStatement(String sql) throws SQLException {
        ps = con.prepareStatement(sql);

        return ps;
    }

    public CallableStatement callableStatement(String sql) throws SQLException {
        cl = con.prepareCall(sql);

        return cl;
    }

}
