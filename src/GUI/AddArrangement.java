/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Business.InputCheck;
import Domain.Arrangement;
import Domain.Customer;
import Technical.MessageDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

/**
 * @author Nikolaj
 */
public class AddArrangement extends javax.swing.JPanel {
    private javax.swing.JTextField arrangementNameField;
    private javax.swing.JLabel arrangementNameLabel;
    private javax.swing.JCheckBox confirmOrderCheck;
    private javax.swing.JButton createArrangementButton;
    private javax.swing.JComboBox<String> customerIDCombo;
    private javax.swing.JLabel customerIDLabel;
    private org.jdesktop.swingx.JXDatePicker dateFromField;
    private javax.swing.JLabel dateFromLabel;
    private org.jdesktop.swingx.JXDatePicker dateToField;
    private javax.swing.JLabel dateToLabel;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JLabel headline;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField numberOfGuestsField;
    private javax.swing.JLabel numberOfGuestsLabel;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel priceLabel;
    private MessageDialog messageDialog;

    /**
     * Creates new form NewJPanel
     */
    public AddArrangement() {
        initComponents();
        events();
    }

    private void events() {
        createButtonEvent();
        focusEvent();
        getCustomerIDs();
    }

    private void focusEvent() {
        arrangementNameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                arrangementNameField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(arrangementNameField.getText().isEmpty()) {
                    arrangementNameField.setText("Arrangement Name");
                }
            }
        });

        numberOfGuestsField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                numberOfGuestsField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(numberOfGuestsField.getText().isEmpty()) {
                    numberOfGuestsField.setText("Number of Guests");
                }
            }
        });

        priceField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                priceField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(priceField.getText().isEmpty()) {
                    priceField.setText("Price");
                }
            }
        });
    }

    private void createButtonEvent() {
        createArrangementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(arrangementNameField.getText().isEmpty() || numberOfGuestsField.getText().isEmpty() || priceField.getText().isEmpty()) {
                    messageDialog.errorMessage("You have to fill out the form!");
                } else {
                    int customerID = Integer.parseInt(customerIDCombo.getSelectedItem().toString());
                    String arrangementName = arrangementNameField.getText();
                    String description = descriptionArea.getText();
                    int numberOfGuests = InputCheck.checkForInt(numberOfGuestsField);
                    BigDecimal price = InputCheck.checkForBigDecimal(priceField);
                    Date dateFrom = new Date(dateFromField.getDate().getTime());
                    Date dateTo = new Date(dateToField.getDate().getTime());
                    boolean confirmed = confirmOrderCheck.isSelected();

                    Arrangement arrangement = new Arrangement();

                    arrangement.createArrangement(customerID, arrangementName, description, numberOfGuests, price, dateFrom, dateTo, confirmed);
                }
            }
        });
    }

    private void getCustomerIDs() {
        Customer customer = new Customer();

        ArrayList<Integer> ids = customer.getCustomerIDs();
        for (int id : ids) {
            customerIDCombo.addItem(id + "");
        }
    }

    private void initComponents() {

        messageDialog = new MessageDialog();
        headline = new javax.swing.JLabel();
        arrangementNameField = new javax.swing.JTextField();
        arrangementNameLabel = new javax.swing.JLabel();
        customerIDCombo = new javax.swing.JComboBox<>();
        customerIDLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();
        numberOfGuestsField = new javax.swing.JTextField();
        numberOfGuestsLabel = new javax.swing.JLabel();
        dateFromField = new org.jdesktop.swingx.JXDatePicker();
        dateFromLabel = new javax.swing.JLabel();
        dateToField = new org.jdesktop.swingx.JXDatePicker();
        dateToLabel = new javax.swing.JLabel();
        createArrangementButton = new javax.swing.JButton();
        confirmOrderCheck = new javax.swing.JCheckBox();
        priceLabel = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();

        headline.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        headline.setText("Add Arrangement");

        arrangementNameField.setText("Arrangement Name");

        arrangementNameLabel.setText("Arrangement Name");

        customerIDLabel.setText("Customer ID");

        descriptionLabel.setText("Description");

        descriptionArea.setColumns(20);
        descriptionArea.setRows(5);
        jScrollPane1.setViewportView(descriptionArea);

        numberOfGuestsField.setText("Number of Guests");

        numberOfGuestsLabel.setText("Number of Guests");

        dateFromLabel.setText("From");

        dateToLabel.setText("To");

        createArrangementButton.setText("Create Arrangement");

        confirmOrderCheck.setText("Confirm Order");

        priceLabel.setText("Price");

        priceField.setText("Price");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(266, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(headline)
                                                .addGap(322, 322, 322))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(confirmOrderCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(createArrangementButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(dateFromField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(dateFromLabel)
                                                                                .addComponent(dateToField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(dateToLabel))
                                                                        .addGap(59, 59, 59)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(priceLabel)
                                                                                .addComponent(jScrollPane1)
                                                                                .addComponent(descriptionLabel)
                                                                                .addComponent(customerIDLabel)
                                                                                .addComponent(arrangementNameLabel)
                                                                                .addComponent(customerIDCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(arrangementNameField)
                                                                                .addComponent(numberOfGuestsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(numberOfGuestsField)
                                                                                .addComponent(priceField)))))
                                                .addGap(199, 199, 199))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headline)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(arrangementNameLabel)
                                        .addComponent(dateFromLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(arrangementNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dateFromField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(numberOfGuestsLabel)
                                        .addComponent(dateToLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(numberOfGuestsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dateToField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(customerIDLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customerIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(descriptionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(priceLabel)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                                .addComponent(confirmOrderCheck)
                                                .addGap(18, 18, 18))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(createArrangementButton)
                                .addGap(48, 48, 48))
        );
    }

}
