package GUI; /**
 * Created by Kasper on 26-04-2017.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Domain.Controller;
import Domain.LoginController;
import Technical.MessageDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Kasper
 */
class ReservationGUI extends JPanel {
    MessageDialog messageDialog = new MessageDialog();
    Controller controller;
    LoginController loginController = LoginController.getInstance();
    private JTextField addressField;
    private JLabel addressLabel;
    private JButton checkAvailabilityButton;
    private JButton checkIfExistingButton;
    private JLabel checkIfExistingLabel;
    private JLabel checkInLabel;
    private JLabel checkOutLabel;
    private JTextField cityField;
    private JLabel cityLabel;
    private JPanel creatingCustomerPanel;
    private JTextField emailField;
    private JLabel emailLabel;
    private JLabel headlineLabel;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private JTextField lastNameField;
    private JLabel lastNameLabel;
    private JButton makeReservationButton;
    private JTextField nameField;
    private JLabel nameLabel;
    private JTextField phoneNumberField;
    private JLabel phoneNumberLabel;
    private JLabel pictureLabel;
    private JLabel roomIdLabel;
    private JTextField zipField;
    private JLabel zipLabel;

    /**
     * Creates new form ReservationGUI
     */
    public ReservationGUI(Controller controller) {
        this.controller = controller;
        initComponents();
        checkAvailabilityButtonActionPerformed();
        checkIfExistingButtonActionPerformed();
        makeReservationButtonActionPerformed();

    }

    private void initComponents() {

        headlineLabel = new JLabel();
        checkAvailabilityButton = new JButton();
        roomIdLabel = new JLabel();
        checkOutLabel = new JLabel();
        checkInLabel = new JLabel();
        pictureLabel = new JLabel();
        jComboBox1 = new JComboBox<>();
        creatingCustomerPanel = new JPanel();
        checkIfExistingLabel = new JLabel();
        checkIfExistingButton = new JButton();
        emailLabel = new JLabel();
        jLabel1 = new JLabel();
        addressLabel = new JLabel();
        cityLabel = new JLabel();
        zipLabel = new JLabel();
        nameField = new JTextField();
        lastNameField = new JTextField();
        phoneNumberField = new JTextField();
        emailField = new JTextField();
        nameLabel = new JLabel();
        addressField = new JTextField();
        lastNameLabel = new JLabel();
        cityField = new JTextField();
        phoneNumberLabel = new JLabel();
        zipField = new JTextField();
        makeReservationButton = new JButton();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();

        headlineLabel.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        headlineLabel.setText("Reservation");
        headlineLabel.setToolTipText("");

        checkAvailabilityButton.setText("Check availability");

        roomIdLabel.setText("Room");

        checkOutLabel.setText("Check out");

        checkInLabel.setText("Check in");

        pictureLabel.setIcon(new ImageIcon("src/Resources/pic.png")); // NOI18N

        try {
            for (int i = 0; i < controller.getRoomID().size(); i++) {
                jComboBox1.addItem(String.valueOf(controller.getRoomID().get(i)));
            }
        } catch (SQLException e) {

        }

        GroupLayout creatingCustomerPanelLayout = new GroupLayout(creatingCustomerPanel);
        creatingCustomerPanel.setLayout(creatingCustomerPanelLayout);
        creatingCustomerPanelLayout.setHorizontalGroup(
                creatingCustomerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 1074, Short.MAX_VALUE)
        );
        creatingCustomerPanelLayout.setVerticalGroup(
                creatingCustomerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        checkIfExistingLabel.setText("Check if customer exists:");

        checkIfExistingButton.setText("Check");

        emailLabel.setText("Email: ");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("Create customer");

        addressLabel.setText("Address: ");

        cityLabel.setText("City: ");

        zipLabel.setText("Zip: ");

        nameLabel.setText("Name: ");

        lastNameLabel.setText("Last name: ");

        phoneNumberLabel.setText("Phone number: ");

        makeReservationButton.setText("Make reservation");

        // Setting fields and buttons to NOT-ENABLED

        addressField.setEnabled(false);
        cityField.setEnabled(false);
        zipField.setEnabled(false);
        nameField.setEnabled(false);
        lastNameField.setEnabled(false);
        phoneNumberField.setEnabled(false);
        makeReservationButton.setEnabled(false);
        emailField.setEnabled(false);
        checkIfExistingButton.setEnabled(false);
        makeReservationButton.setEnabled(false);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(headlineLabel, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(24, 24, 24)
                                                                                .addComponent(roomIdLabel)))
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(52, 52, 52)
                                                                                .addComponent(checkInLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(102, 102, 102)
                                                                                .addComponent(checkOutLabel))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(30, 30, 30)
                                                                                .addComponent(jXDatePicker1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(45, 45, 45)
                                                                                .addComponent(jXDatePicker2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(checkAvailabilityButton)))))
                                                .addGap(60, 60, 60)
                                                .addComponent(pictureLabel)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(nameLabel)
                                                                                        .addComponent(lastNameLabel))
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(phoneNumberLabel)
                                                                                        .addComponent(emailLabel)
                                                                                        .addComponent(addressLabel)
                                                                                        .addComponent(cityLabel)
                                                                                        .addComponent(zipLabel))
                                                                                .addGap(18, 192, Short.MAX_VALUE)
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(cityField, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(phoneNumberField, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(addressField, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(zipField, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))))
                                                                .addGap(48, 48, 48)
                                                                .addComponent(makeReservationButton)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 535, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel1)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(checkIfExistingLabel, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(checkIfExistingButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addComponent(creatingCustomerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(353, Short.MAX_VALUE))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[]{addressField, cityField, emailField, lastNameField, nameField, phoneNumberField, zipField});

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(headlineLabel)
                                                .addGap(11, 11, 11)
                                                .addComponent(creatingCustomerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(101, 101, 101)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(checkInLabel)
                                                                        .addComponent(checkOutLabel)
                                                                        .addComponent(roomIdLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                                                        .addComponent(jXDatePicker2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jXDatePicker1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(checkAvailabilityButton)
                                                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(54, 54, 54)
                                                                .addComponent(pictureLabel)))
                                                .addGap(61, 61, 61)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(checkIfExistingLabel)
                                                        .addComponent(checkIfExistingButton))
                                                .addGap(32, 32, 32)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(nameLabel)
                                                        .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lastNameLabel)
                                                        .addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(phoneNumberLabel)
                                                        .addComponent(phoneNumberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(emailLabel)
                                                        .addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(addressLabel)
                                                        .addComponent(addressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(cityLabel)
                                                        .addComponent(cityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(zipLabel)
                                                        .addComponent(zipField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(makeReservationButton))
                                                .addGap(51, 51, 51)))
                                .addContainerGap())
        );

        layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[]{checkIfExistingButton, checkIfExistingLabel});

        layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[]{jXDatePicker1, jXDatePicker2});

    }

    private void checkAvailabilityButtonActionPerformed() {
        checkAvailabilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jXDatePicker1.getDate() == null || jXDatePicker2.getDate() == null) {
                    messageDialog.infoMessage("You have to choose check in and check out");
                } else {
                    java.util.Date arrival = jXDatePicker1.getDate();
                    java.sql.Date arrivalSQL = new java.sql.Date(arrival.getTime());
                    java.util.Date departure = jXDatePicker2.getDate();
                    java.sql.Date departureSQL = new java.sql.Date(departure.getTime());
                    if (controller.checkAvailbility(Integer.parseInt(String.valueOf(jComboBox1.getSelectedItem())), arrivalSQL, departureSQL)) {
                        messageDialog.infoMessage("Available");
                        addressField.setEnabled(true);
                        cityField.setEnabled(true);
                        zipField.setEnabled(true);
                        nameField.setEnabled(true);
                        lastNameField.setEnabled(true);
                        phoneNumberField.setEnabled(true);
                        emailField.setEnabled(true);
                        checkIfExistingButton.setEnabled(true);
                    } else {
                        messageDialog.infoMessage("Not available");
                    }
                }
            }
        });
    }

    private void makeReservationButtonActionPerformed() {
        makeReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (makeReservationButton.getText().equals("Make reservation")) {
                        int phoneNumber = Integer.parseInt(phoneNumberField.getText());
                        int roomID = Integer.parseInt(String.valueOf(jComboBox1.getSelectedItem()));
                        int userID = loginController.getUserID();
                        java.sql.Date dateFrom = new java.sql.Date(jXDatePicker1.getDate().getTime());
                        java.sql.Date dateTo = new java.sql.Date(jXDatePicker2.getDate().getTime());

                        controller.makeReservation(phoneNumber, roomID, userID, dateFrom, dateTo);

                    } else {
                        // Readability
                        String firstname = nameField.getText();
                        String lastname = lastNameField.getText();
                        String email = emailField.getText();
                        int phone = Integer.parseInt(phoneNumberField.getText());
                        String address = addressField.getText();
                        String city = cityField.getText();
                        int postalCode = Integer.parseInt(zipField.getText());
                        int phoneNumber = Integer.parseInt(phoneNumberField.getText());
                        int roomID = Integer.parseInt(String.valueOf(jComboBox1.getSelectedItem()));
                        int userID = loginController.getUserID();
                        java.sql.Date dateFrom = new java.sql.Date(jXDatePicker1.getDate().getTime());
                        java.sql.Date dateTo = new java.sql.Date(jXDatePicker2.getDate().getTime());

                        // Making new customer
                        controller.insertCustomer(firstname, lastname, email, phone, address, city, postalCode);
                        // Creating the reservation for the new customer
                        controller.makeReservation(phoneNumber, roomID, userID, dateFrom, dateTo);

                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void checkIfExistingButtonActionPerformed() {
        checkIfExistingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstname = nameField.getText();
                String lastname = lastNameField.getText();
                String email = emailField.getText();
                String phone = phoneNumberField.getText();
                String address = addressField.getText();
                String city = cityField.getText();
                String postalCode = zipField.getText();
                try {
                    if (firstname.isEmpty() && lastname.isEmpty() && email.isEmpty() && phone.isEmpty() && address.isEmpty() && city.isEmpty() && postalCode.isEmpty()) {
                        messageDialog.errorMessage("You have to insert an email");
                        return;
                    }
                    if (controller.checkIfCustomerExists(emailField.getText()).size() == 0) {
                        messageDialog.errorMessage("User does not exist");
                        makeReservationButton.setText("Create customer and reservation");
                    } else {
                        messageDialog.infoMessage("Customer found");
                        ArrayList<String> informationAboutCustomer = controller.checkIfCustomerExists(emailField.getText());
                        nameField.setText(informationAboutCustomer.get(1));
                        lastNameField.setText(informationAboutCustomer.get(2));
                        phoneNumberField.setText(informationAboutCustomer.get(4));
                        emailField.setText(informationAboutCustomer.get(3));
                        addressField.setText(informationAboutCustomer.get(5));
                        cityField.setText(informationAboutCustomer.get(6));
                        zipField.setText(informationAboutCustomer.get(7));
                    }

                    makeReservationButton.setEnabled(true);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
