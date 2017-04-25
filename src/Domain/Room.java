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
        try {
            CallableStatement cl = db.callableStatement("{(call selectRoom (?))}");

            cl.setInt(1, roomID);

            cl.executeUpdate();

            this.roomSize = cl.getString("fldRoomsize");
            this.description = cl.getString("fldDescription");
            this.price = cl.getBigDecimal("fldPrice");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRoom(int roomID, String roomSize, String description, BigDecimal price) {

    }

    public ArrayList<Integer> getIDs() {
        ArrayList<Integer> ids = new ArrayList<>();

        try {
            PreparedStatement ps = db.preparedStatement("SELECT fldRoomID FROM tblRoom");

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                ids.add(rs.getInt(1));
            }

            return ids;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
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

    public String getRoomSize() {
        return roomSize;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
