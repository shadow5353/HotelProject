package Domain;

import Technical.DBFacade;
import Technical.MessageDialog;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Jacob on 20-04-2017.
 */
public class Service {
    private DBFacade db;
    private MessageDialog messageDialog;
    private String name;
    private String description;
    private BigDecimal price;

    public Service() {
        db = new DBFacade();
        messageDialog = new MessageDialog();
    }

    private void saveInVariables(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // get Service Info
    public void getServiceInfo(int serviceID) {
        try {
            CallableStatement cl = db.callableStatement("{call selectService(?)}");

            cl.setInt(1, serviceID);

            cl.executeUpdate();

            String name = cl.getString("fldServiceName");
            String description = cl.getString("fldDescription");
            BigDecimal price = cl.getBigDecimal("fldPrice");

            saveInVariables(name, description, price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertService(String name, String description, BigDecimal price) {
        saveInVariables(name, description, price);

        try {
            CallableStatement cl = db.callableStatement("{call insertService(?, ?, ?)}");

            cl.setString(1, name);
            cl.setString(2, description);
            cl.setBigDecimal(3, price);

            cl.executeUpdate();

            messageDialog.infoMessage("Service: " + name + " have been created!");
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void updateService(int serviceID, String serviceName, String description, BigDecimal price) {
        try {
            CallableStatement cl = db.callableStatement("{call updateService (?, ?, ?, ?)}");

            cl.setInt(1, serviceID);
            cl.setString(2, serviceName);
            cl.setString(3, description);
            cl.setBigDecimal(4, price);

            cl.executeUpdate();

            messageDialog.infoMessage("Service: " + serviceName + " have been updated!");
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public ArrayList<Integer> serviceIDs() {
        ArrayList<Integer> ids = new ArrayList<>();

        try {
            PreparedStatement ps = db.preparedStatement("SELECT fldServiceID FROM tblService");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ids.add(rs.getInt(1));
            }
        } catch (SQLException e) {

        }

        return ids;
    }

    public void deleteService(int id) {
        try {
            CallableStatement cl = db.callableStatement("{call deleteService (?)");

            cl.setInt(1, id);

            cl.executeUpdate();

            messageDialog.infoMessage("Service Number: " + id + " have been removed!");
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
