package Domain;

import Technical.DBFacade;
import Technical.MessageDialog;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

/**
 * Created by Jacob on 24-04-2017.
 */
public class Reservation {
    private MessageDialog messageDialog;
    private DBFacade db;
    private int customerID;
    private int roomID;
    private Date dateFrom;
    private Date dateTo;

    public Reservation() {
        messageDialog = new MessageDialog();
        db = new DBFacade();
    }

    public void insertReservation(int customerID, int roomID, Date dateFrom, Date dateTo) {
        this.customerID = customerID;
        this.roomID = roomID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;

        try {
            CallableStatement cl = db.callableStatement("{(call insertReservation (?, ?, ?, ?)}");

            cl.setInt(1, this.customerID);
            cl.setInt(2, this.roomID);
            cl.setDate(3, dateFrom);
            cl.setDate(4, this.dateTo);

            cl.executeUpdate();

            Customer customer = new Customer();
            customer.getCustomer(this.customerID);

            String customerName = customer.getFirstname() + " " + customer.getLastname();

            messageDialog.infoMessage("Room: " + this.roomID + " have been booked for " + customerName + " from: " + dateFrom + " to: " + dateTo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkAvalibility(int roomID, Date dateFrom, Date dateTo) {

        return true;
    }

    public void getReservation(int bookingID) {

    }
}
