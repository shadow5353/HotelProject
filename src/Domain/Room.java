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

    // get room info
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
        try {
            CallableStatement cl = db.callableStatement("{call updateRoom (?, ?, ?, ?)}");

            cl.setInt(1, roomID);
            cl.setString(2, roomSize);
            cl.setString(3, description);
            cl.setBigDecimal(4, price);

            cl.executeUpdate();

            messageDialog.infoMessage("Room Number: " + roomID + " have been updated");

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public void deleteRoom(int roomID) {
        try {
            CallableStatement cl = db.callableStatement("{call deleteRoom (?)}");

            cl.setInt(1, roomID);

            cl.executeUpdate();

            messageDialog.infoMessage("Room Number: " + roomID + " have been removed");
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public ArrayList<Integer> getRoomID() throws SQLException {
        ArrayList<Integer> id = new ArrayList<>();
        ResultSet rs = db.resultSet("SELECT fldRoomID from tblRoom");
        while (rs.next()) {
            id.add(rs.getInt(1));
        }


        return id;
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
