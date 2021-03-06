package Domain;

/**
 * Created by Kasper on 25-04-2017.
 */

import Technical.DBFacade;
import Technical.MessageDialog;

import java.sql.*;

/**
 * Created by Jacob on 24-04-2017.
 */
public class Reservation {
    private MessageDialog messageDialog;
    private DBFacade db;
    private int customerID;
    private int roomID;
    private int userID;
    private Date dateFrom;
    private Date dateTo;

    public Reservation() {
        messageDialog = new MessageDialog();
        db = new DBFacade();
    }

    public void insertReservation(int customerID, int roomID, int userID, Date dateFrom, Date dateTo) {
        this.customerID = customerID;
        this.roomID = roomID;
        this.userID = userID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;

        try {
            CallableStatement cl = db.callableStatement("{call insertReservation (?, ?, ?, ?, ?)}");

            cl.setInt(1, this.customerID);
            cl.setInt(2, this.roomID);
            cl.setInt(3, this.userID);
            cl.setDate(4, this.dateFrom);
            cl.setDate(5, this.dateTo);

            cl.executeUpdate();

            messageDialog.infoMessage("Room: " + this.roomID + " have been booked for " + customerID + " from: " + dateFrom + " to: " + dateTo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkAvalibility(int roomID, Date dateFrom, Date dateTo) {
        try {
            CallableStatement cl = db.callableStatement("{call checkAvalibility (?, ?, ?)}");

            cl.setInt(1, roomID);
            cl.setDate(2, dateFrom);
            cl.setDate(3, dateTo);

            ResultSet rs = cl.executeQuery();

            if (rs.next()) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    public void getReservation(int bookingID) {
        try {
            CallableStatement cl = db.callableStatement("{(call selectReservation (?))}");

            cl.setInt(1, bookingID);

            cl.executeQuery();

            this.customerID = cl.getInt("fldCustomerID");
            this.roomID = cl.getInt("fldRoomID");
            this.userID = cl.getInt("fldUserID");
            this.dateFrom = cl.getDate("fldDateFrom");
            this.dateTo = cl.getDate("fldDateTo");

        } catch (SQLException e) {
        }
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getRoomID() {
        return roomID;
    }

    public int getUserID() {
        return userID;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void deleteReservation(int bookingID) throws SQLException {
        PreparedStatement ps = db.preparedStatement("DELETE FROM tblReservation WHERE fldBookingID = ?");
        ps.setInt(1, bookingID);

        ps.executeUpdate();
    }

    public ResultSet getData() throws SQLException {
        PreparedStatement ps = db.preparedStatement("SELECT * FROM tblReservation");
        ResultSet rs = ps.executeQuery();

        return rs;
    }
}
