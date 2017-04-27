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
    public void updateCatering(int cateringID, String dishName, String description, BigDecimal price)
    {
        try {
            CallableStatement cl = db.callableStatement("{call updateCatering (?, ?, ?, ?)}");

            cl.setInt(1, cateringID);
            cl.setString(2, dishName);
            cl.setString(3, description);
            cl.setBigDecimal(4, price);
            System.out.println(dishName);

            cl.executeUpdate();

            messageDialog.infoMessage("Catering: " + dishName + " has been updated!");
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
    public ArrayList<Integer> cateringIDs() {
        ArrayList<Integer> ids = new ArrayList<>();

        try {
            PreparedStatement ps = db.preparedStatement("SELECT fldCateringID FROM tblCatering");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ids.add(rs.getInt(1));
            }
        } catch (SQLException e) {

        }

        return ids;
    }


    public void deleteMenu(int cateringID){
        try {
            CallableStatement cl = db.callableStatement("{call deleteCatering (?)}");

            cl.setInt(1, cateringID);
            System.out.println(cateringID);

            int rows = cl.executeUpdate();
            System.out.println("rows: " +  rows);

            messageDialog.infoMessage("Basket Number: " + cateringID + " has been removed!");
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
