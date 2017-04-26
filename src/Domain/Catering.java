package Domain;

import Technical.DBFacade;
import Technical.MessageDialog;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 * Created by Bruger on 26-04-2017.
 */
public class Catering {
    private DBFacade db;
    private MessageDialog messageDialog;
    private String basketName;
    private String description;
    private BigDecimal price;

    public Catering(){
        db = new DBFacade();
        messageDialog = new MessageDialog();
    }
    public void saveInVariables(String basketName, String description, BigDecimal price) {
        this.basketName = basketName;
        this.description = description;
        this.price = price;
    }

    public void addBasket(String basketName, String description, BigDecimal price) {
        saveInVariables(basketName, description, price);

        try {
            CallableStatement cl = db.callableStatement("{call insertCatering(?, ?, ?)}");

            cl.setString(1, this.basketName);
            cl.setString(2, this.description);
            cl.setBigDecimal(3, this.price);

            int rows = cl.executeUpdate();
            if (rows > 0) {

                messageDialog.infoMessage(this.basketName + " have been created!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
