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
    public void updateService(String dishName, String description, BigDecimal price)
    {

    }
}
