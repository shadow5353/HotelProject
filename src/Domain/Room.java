package Domain;

import technical.DBFacade;
import technical.MessageDialog;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 * Created by Jacob on 20-04-2017.
 */
public class Room {
    private DBFacade db;
    private MessageDialog messageDialog;
    private String roomSize;
    private String description;
    private BigDecimal price;

    public Room() {
        db = new DBFacade();
        messageDialog = new MessageDialog();
    }

    private void saveInVariables(String roomSize, String description, BigDecimal price) {
        this.roomSize = roomSize;
        this.description = description;
        this.price = price;
    }

    // TODO get room info
    public void getRoomInfo(int roomID) {

    }

    public void insertRoom(String roomSize, String description, BigDecimal price) {
        saveInVariables(roomSize, description, price);

        try {
            CallableStatement cl = db.callableStatement("{call insertRoom(?, ?, ?)}");

            cl.setString(1, this.roomSize);
            cl.setString(2, this.description);
            cl.setBigDecimal(3, this.price);

            cl.executeUpdate();

            messageDialog.infoMessage(this.roomSize + " have been created!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
