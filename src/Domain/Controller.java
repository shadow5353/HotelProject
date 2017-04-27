package Domain;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Kasper on 25-04-2017.
 */
public class Controller {
    Room room;
    Reservation reservation;
    Customer customer;
    private Object userID;

    public Controller() {
        room = new Room();
        reservation = new Reservation();
        customer = new Customer();
    }

    public boolean checkAvailbility(int roomID, Date dateFrom, Date dateTo) {
        return reservation.checkAvalibility(roomID, dateFrom, dateTo);
    }

    public ArrayList<Integer> getRoomID() throws SQLException {
        return room.getRoomID();
    }

    public ArrayList<String> checkIfCustomerExists(String customerMail) throws SQLException {
        return customer.checkIfCustomerExist(customerMail);
    }

    public void makeReservation(int phoneNo, int roomID, int userID, java.sql.Date dateFrom, java.sql.Date dateTo) throws SQLException {
        int customerID = getCustomerID(phoneNo);
        reservation.insertReservation(customerID, roomID, 1, dateFrom, dateTo);
    }

    private int getCustomerID(int phoneNO) throws SQLException {
        return customer.getCustomerID(phoneNO);
    }

    public void insertCustomer(String firstname, String lastname, String email, int phone, String address, String city, int postalcode) {
        customer.insertCustomer(firstname, lastname, email, phone, address, city, postalcode);
    }

    public Object getUserID() {
        return userID;
    }
}
