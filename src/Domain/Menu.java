package Domain;

import Technical.DBFacade;
import Technical.MessageDialog;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 * Created by Bruger on 25-04-2017.
 */
public class Menu {
    private DBFacade db;
    private MessageDialog messageDialog;
    private String dishName;
    private String description;
    private BigDecimal price;

    public Menu() {
        db = new DBFacade();
        messageDialog = new MessageDialog();
    }

    public void saveInVariables(String dishName, String description, BigDecimal price) {
        this.dishName = dishName;
        this.description = description;
        this.price = price;
    }

    public void addDish(String dishName, String description, BigDecimal price) {
        saveInVariables(dishName, description, price);

        try {
            CallableStatement cl = db.callableStatement("{call insertMenu(?, ?, ?)}");

            cl.setString(1, this.dishName);
            cl.setString(2, this.description);
            cl.setBigDecimal(3, this.price);

            int rows = cl.executeUpdate();
            if (rows > 0) {

                messageDialog.infoMessage(this.dishName + " have been created!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateMenu(int menuID, String dishName, String description, BigDecimal price)
    {
        try {
            CallableStatement cl = db.callableStatement("{call updateMenu (?, ?, ?, ?)}");

            cl.setInt(1, menuID);
            cl.setString(2, dishName);
            cl.setString(3, description);
            cl.setBigDecimal(4, price);
            System.out.println(dishName);

            cl.executeUpdate();

            messageDialog.infoMessage("Service: " + dishName + " have been updated!");
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public void deleteMenu(int ID){
        try {
            CallableStatement cl = db.callableStatement("{call deleteMenu (?)}");

            cl.setInt(1, ID);

            cl.executeUpdate();

            messageDialog.infoMessage("Dish Number: " + ID + " have been removed!");
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
