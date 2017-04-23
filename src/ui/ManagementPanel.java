package ui;

import javax.swing.*;

/**
 * Created by Jacob on 20-04-2017.
 */
public class ManagementPanel extends JPanel {
    private JButton createUserButton;
    private JLabel headlineLabel;
    private JButton mainMenuButton;
    private JButton viewAllUsersButton;

    /**
     * Creates new form ManagementPanel
     */
    public ManagementPanel() {
        initComponents();
    }

    private void initComponents() {

        headlineLabel = new javax.swing.JLabel();
        createUserButton = new javax.swing.JButton();
        viewAllUsersButton = new javax.swing.JButton();
        mainMenuButton = new javax.swing.JButton();

        headlineLabel.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        headlineLabel.setText("Management");

        createUserButton.setText("Create User");

        viewAllUsersButton.setText("View All Users");

        mainMenuButton.setText("Main Menu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(235, 235, 235)
                                .addComponent(headlineLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(110, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(mainMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(viewAllUsersButton, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                                        .addComponent(createUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(110, 110, 110))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headlineLabel)
                                .addGap(57, 57, 57)
                                .addComponent(createUserButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(viewAllUsersButton)
                                .addGap(64, 64, 64)
                                .addComponent(mainMenuButton)
                                .addContainerGap(232, Short.MAX_VALUE))
        );
    }


    // Variables declaration - do not modify
    // End of variables declaration
}