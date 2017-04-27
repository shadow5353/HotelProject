package Domain;

import Technical.DBFacade;
import Technical.MessageDialog;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Jacob on 20-04-2017.
 */
public class Customer {
    private DBFacade db;
    private MessageDialog messageDialog;
    private String firstname;
    private String lastname;
    private String email;
    private int phone;
    private String address;
    private String city;
    private int postalcode;

    public Customer() {
        db = new DBFacade();
        messageDialog = new MessageDialog();
    }

    // get Customer info
    public void getCustomer(int customerID) {
        try {
            CallableStatement cl = db.callableStatement("{call selectCustomer(?)}");

            cl.setInt(1, customerID);

            cl.executeUpdate();

            this.firstname = cl.getString("fldFirstname");
            this.lastname = cl.getString("fldLastname");
            this.email = cl.getString("fldEmail");
            this.phone = cl.getInt("fldPhoneno");
            this.address = cl.getString("fldAddress");
            this.city = cl.getString("fldCity");
            this.postalcode = cl.getInt("fldPostalCode");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getCustomerIDs() {
        ArrayList<Integer> customerIDs = new ArrayList<>();

        try {
            PreparedStatement ps = db.preparedStatement("SELECT fldCustomerID");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                customerIDs.add(rs.getInt(1));
            }

        } catch (SQLException e) {

        }

        return customerIDs;
    }

    public int getCustomerID(int phoneNo) throws SQLException {
        PreparedStatement ps = db.preparedStatement("SELECT fldCustomerID FROM tblCustomer WHERE fldPhoneno = ?");
        ps.setInt(1, phoneNo);
        ResultSet resultSet = ps.executeQuery();
        if(resultSet.next()){
            return resultSet.getInt(1);
        }
        return 0;


    }

    public ArrayList<String> checkIfCustomerExist(String customerMail) throws SQLException {
        ArrayList<String> informationAboutCustomer = new ArrayList<>();
        PreparedStatement ps = db.preparedStatement("SELECT * FROM tblCustomer WHERE fldEmail = ?");
        ps.setString(1, customerMail);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            informationAboutCustomer.add(String.valueOf(resultSet.getInt(1)));
            informationAboutCustomer.add(resultSet.getString(2));
            informationAboutCustomer.add(resultSet.getString(3));
            informationAboutCustomer.add(resultSet.getString(4));
            informationAboutCustomer.add(String.valueOf(resultSet.getInt(5)));
            informationAboutCustomer.add(resultSet.getString(6));
            informationAboutCustomer.add(resultSet.getString(7));
            informationAboutCustomer.add(String.valueOf(resultSet.getInt(8)));
        } else {
            return informationAboutCustomer;
        }

        return informationAboutCustomer;

    }

    public void insertCustomer(String firstname, String lastname, String email, int phone, String address, String city, int postalcode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.postalcode = postalcode;

        try {
            PreparedStatement ps = db.preparedStatement("SELECT * FROM tblCustomer WHERE fldEmail = ?");

            ps.setString(1, this.email);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                messageDialog.errorMessage("Customer already exists!");
            } else {

                CallableStatement cl = db.callableStatement("{call insertCustomer(?, ?, ?, ?, ?, ?, ?)}");

                cl.setString(1, this.firstname);
                cl.setString(2, this.lastname);
                cl.setString(3, this.email);
                cl.setInt(4, this.phone);
                cl.setString(5, this.address);
                cl.setString(6, this.city);
                cl.setInt(7, this.postalcode);

                cl.executeUpdate();

                messageDialog.infoMessage(this.firstname + " " + this.lastname  + " have been created!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public int getPostalcode() {
        return postalcode;
    }
}
