/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Business.InputCheck;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author Nikolaj
 */
public class AddArrangement extends javax.swing.JPanel {
    private javax.swing.JTextArea arrangementDetailTxtField;
    private javax.swing.JLabel arrangementjLabel;
    private javax.swing.JCheckBox confirmOrderCheckBox;
    private javax.swing.JLabel confirmOrderLabel;
    private javax.swing.JTextField customerIDField;
    private javax.swing.JButton finishOrderButton;
    private org.jdesktop.swingx.JXDatePicker fromDatePicker;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JLabel informationLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField numberofGuestsTXTfield;
    private javax.swing.JTextField priceTextField;
    private org.jdesktop.swingx.JXDatePicker toDatePicker;
    private javax.swing.JLabel toLabel;

    /**
     * Creates new form NewJPanel
     */
    public AddArrangement() {
        initComponents();
        events();
    }

    private void events() {
        numberOfGuestsTextField();
        customerIDTextField();
        arrangementDetailTextField();
        priceTextField();
    }

    private void priceTextField() {
        priceTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                priceTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(priceTextField.getText().isEmpty()) {
                    priceTextField.setText("Price");
                }
            }
        });
    }

    private void arrangementDetailTextField() {
        arrangementDetailTxtField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                arrangementDetailTxtField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(arrangementDetailTxtField.getText().isEmpty()) {
                    arrangementDetailTxtField.setText("Arrangement Details");
                }
            }
        });
    }

    private void customerIDTextField() {
        customerIDField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                customerIDField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(customerIDField.getText().isEmpty()) {
                    customerIDField.setText("CustomerID");
                }
            }
        });
    }

    private void numberOfGuestsTextField() {
        numberofGuestsTXTfield.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                numberofGuestsTXTfield.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(numberofGuestsTXTfield.getText().isEmpty()) {
                    numberofGuestsTXTfield.setText("Number of guests");
                }
            }
        });
    }

    private void createButtonEvent() {
        int customerID = InputCheck.checkForInt(customerIDField);
    }

    private void initComponents() {

        arrangementjLabel = new javax.swing.JLabel();
        fromLabel = new javax.swing.JLabel();
        toLabel = new javax.swing.JLabel();
        numberofGuestsTXTfield = new javax.swing.JTextField();
        informationLabel = new javax.swing.JLabel();
        customerIDField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        arrangementDetailTxtField = new javax.swing.JTextArea();
        confirmOrderLabel = new javax.swing.JLabel();
        confirmOrderCheckBox = new javax.swing.JCheckBox();
        finishOrderButton = new javax.swing.JButton();
        fromDatePicker = new org.jdesktop.swingx.JXDatePicker();
        toDatePicker = new org.jdesktop.swingx.JXDatePicker();
        priceTextField = new javax.swing.JTextField();

        arrangementjLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        arrangementjLabel.setText("Arrangements");

        fromLabel.setText("From:");

        toLabel.setText("To:");

        numberofGuestsTXTfield.setText("Number of guests");
        numberofGuestsTXTfield.setMinimumSize(new java.awt.Dimension(107, 22));


        informationLabel.setText("Arrangement Information");

        customerIDField.setText("CustomerID");
        customerIDField.setDragEnabled(true);
        customerIDField.setMinimumSize(new java.awt.Dimension(73, 22));

        arrangementDetailTxtField.setColumns(20);
        arrangementDetailTxtField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        arrangementDetailTxtField.setRows(5);
        arrangementDetailTxtField.setText("Arrangement Details");

        jScrollPane1.setViewportView(arrangementDetailTxtField);

        confirmOrderLabel.setText("Confirm Order");

        confirmOrderCheckBox.setAlignmentY(0.0F);

        finishOrderButton.setText("Finish Order");

        priceTextField.setText("Price");
        priceTextField.setMinimumSize(new java.awt.Dimension(34, 22));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(arrangementjLabel)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(numberofGuestsTXTfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(fromLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(fromDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(toLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(toDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(159, 159, 159)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(customerIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(informationLabel)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addComponent(confirmOrderLabel)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(confirmOrderCheckBox))
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(finishOrderButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addContainerGap(177, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {fromLabel, toLabel});

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(arrangementjLabel)
                                .addGap(28, 28, 28)
                                .addComponent(informationLabel)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(customerIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(numberofGuestsTXTfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(fromLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(fromDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(toLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(toDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(100, 100, 100))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(confirmOrderLabel)
                                        .addComponent(confirmOrderCheckBox))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(finishOrderButton))
                                .addGap(18, 18, 18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addContainerGap(118, Short.MAX_VALUE))
        );
    }


}
