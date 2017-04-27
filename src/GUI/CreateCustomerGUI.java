package GUI;

import Domain.Controller;
import Technical.MessageDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Kasper on 21-04-2017.
 */
public class CreateCustomerGUI extends JPanel {
    private JLabel createUserLabel, checkIfExistingLabel, nameLabel, lastNameLabel, addressLabel, cityLabel, phoneLabel, zipLabel, emailLabel;
    private JTextField nameField, lastNameField, addressField, cityField, phoneField, zipField, emailField;
    private JButton checkIfExisting, createCustomerButton;
    private Dimension sizeOfField = new Dimension(200, 30);
    private Dimension sizeOfLabel = new Dimension(150, 18);
    MessageDialog messageDialog = new MessageDialog();
    Controller controller;

    public CreateCustomerGUI(Controller controller) {
        this.controller = controller;
        GridBagConstraints c = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        headline(c);
        checkIfExisting(c);
        name(c);
        lastName(c);
        phoneNo(c);
        email(c);
        address(c);
        city(c);
        zip(c);
        c.gridx = 2;
        c.gridy = 10;
        c.insets = new Insets(10, 0, 0, 0);
        this.add(buttons(), c);
        createCustomerButtonActionPerformed();
        checkIfExistingButtonActionPerformed();
    }

    private JPanel buttons() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        createCustomerButton = new JButton("Create customer");
        c.gridx = 2;
        c.anchor = GridBagConstraints.LINE_END;
        panel.add(createCustomerButton, c);
        createCustomerButton.setEnabled(false);

        return panel;
    }

    private void zip(GridBagConstraints c) {
        zipLabel = new JLabel("Zip: ", SwingConstants.RIGHT);
        zipLabel.setPreferredSize(sizeOfLabel);
        c.gridx = 1;
        c.gridy = 9;
        this.add(zipLabel, c);
        zipField = new JTextField();
        zipField.setPreferredSize(sizeOfField);
        c.gridx = 2;
        c.gridy = 9;
        this.add(zipField, c);
    }

    private void city(GridBagConstraints c) {
        cityLabel = new JLabel("City: ", SwingConstants.RIGHT);
        cityLabel.setPreferredSize(sizeOfLabel);
        c.gridx = 1;
        c.gridy = 8;
        this.add(cityLabel, c);
        cityField = new JTextField();
        cityField.setPreferredSize(sizeOfField);
        c.gridx = 2;
        c.gridy = 8;
        this.add(cityField, c);
    }

    private void address(GridBagConstraints c) {
        addressLabel = new JLabel("Address: ", SwingConstants.RIGHT);
        addressLabel.setPreferredSize(sizeOfLabel);
        c.gridx = 1;
        c.gridy = 7;
        this.add(addressLabel, c);
        addressField = new JTextField();
        addressField.setPreferredSize(sizeOfField);
        c.gridx = 2;
        c.gridy = 7;
        this.add(addressField, c);
    }

    private void email(GridBagConstraints c) {
        emailLabel = new JLabel("Email: ", SwingConstants.RIGHT);
        emailLabel.setPreferredSize(sizeOfLabel);
        c.gridx = 1;
        c.gridy = 6;
        this.add(emailLabel, c);
        emailField = new JTextField();
        emailField.setPreferredSize(sizeOfField);
        c.gridx = 2;
        c.gridy = 6;
        this.add(emailField, c);
    }

    private void phoneNo(GridBagConstraints c) {
        phoneLabel = new JLabel("Phone number: ", SwingConstants.RIGHT);
        phoneLabel.setPreferredSize(sizeOfLabel);
        c.gridx = 1;
        c.gridy = 5;
        this.add(phoneLabel, c);
        phoneField = new JTextField();
        phoneField.setPreferredSize(sizeOfField);
        c.gridx = 2;
        c.gridy = 5;
        this.add(phoneField, c);
    }

    private void lastName(GridBagConstraints c) {
        lastNameLabel = new JLabel("Last name: ", SwingConstants.RIGHT);
        lastNameLabel.setPreferredSize(sizeOfLabel);
        c.gridx = 1;
        c.gridy = 4;
        this.add(lastNameLabel, c);
        lastNameField = new JTextField();
        lastNameField.setPreferredSize(sizeOfField);
        c.gridx = 2;
        c.gridy = 4;
        this.add(lastNameField, c);
    }

    private void name(GridBagConstraints c) {
        nameLabel = new JLabel("Name: ", SwingConstants.RIGHT);
        nameLabel.setPreferredSize(sizeOfLabel);
        c.gridy = 3;
        c.gridx = 1;
        c.insets = new Insets(0, 8, 5, 0);
        this.add(nameLabel, c);
        c.gridx = 2;
        c.gridy = 3;
        nameField = new JTextField();
        nameField.setPreferredSize(sizeOfField);
        this.add(nameField, c);
    }

    private void checkIfExisting(GridBagConstraints c) {
        checkIfExistingLabel = new JLabel("Check if customer already exists: ");
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        this.add(checkIfExistingLabel, c);
        checkIfExisting = new JButton("Check if existing");
        c.gridx = 2;
        c.gridy = 2;
        this.add(checkIfExisting, c);
    }

    private void headline(GridBagConstraints c) {
        createUserLabel = new JLabel("Create customer");
        createUserLabel.setFont(new Font("Times new roman", Font.BOLD, 45));
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 35, 0);
        this.add(createUserLabel, c);
    }

    private void createCustomerButtonActionPerformed() {
        createCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Readability
                String firstname = nameField.getText();
                String lastname = lastNameField.getText();
                String email = emailField.getText();
                int phone = Integer.parseInt(phoneField.getText());
                String address = addressField.getText();
                String city = cityField.getText();
                int postalCode = Integer.parseInt(zipField.getText());
                // Making new customer
                controller.insertCustomer(firstname, lastname, email, phone, address, city, postalCode);
            }
        });
    }

    private void checkIfExistingButtonActionPerformed() {
        checkIfExisting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstname = nameField.getText();
                String lastname = lastNameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();
                String city = cityField.getText();
                String postalCode = zipField.getText();
                try {
                    if (controller.checkIfCustomerExists(emailField.getText()).size() == 0) {
                        messageDialog.errorMessage("User does not exist");
                        createCustomerButton.setEnabled(true);
                    } else {
                        messageDialog.infoMessage("Customer found");
                        ArrayList<String> informationAboutCustomer = controller.checkIfCustomerExists(emailField.getText());
                        nameField.setText(informationAboutCustomer.get(1));
                        lastNameField.setText(informationAboutCustomer.get(2));
                        phoneField.setText(informationAboutCustomer.get(4));
                        emailField.setText(informationAboutCustomer.get(3));
                        addressField.setText(informationAboutCustomer.get(5));
                        cityField.setText(informationAboutCustomer.get(6));
                        zipField.setText(informationAboutCustomer.get(7));
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

        });

    }

}
