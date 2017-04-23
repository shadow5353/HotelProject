package Domain;

import technical.DBFacade;
import technical.MessageDialog;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.SQLException;

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
}
