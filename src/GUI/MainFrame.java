package GUI;

import Domain.UserInfo;

import javax.swing.*;

/**
 * Created by Jacob on 18-04-2017.
 */

public class MainFrame extends JFrame {
    private JButton reservationButton, restaurantButton, arrangementsButton, priceListButton, managementButton, logoutButton;
    private JLabel headingLabel, nameLabel, loggedInAsLabel;
    private JPanel panel;
    private UserInfo userInfo;

    public MainFrame(int userID) {
        this.userInfo = new UserInfo(userID);

        this.setTitle("Hotel System");

        initComponents();
        checkAdmin();
    }

    private void checkAdmin() {
        if(userInfo.getIsAdmin()) {
            managementButton.setVisible(true);
        } else {
            managementButton.setVisible(false);
        }
    }

    /**
     * Setting the components for the main form.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        panel = new JPanel();
        headingLabel = new JLabel();
        reservationButton = new JButton();
        restaurantButton = new JButton();
        arrangementsButton = new JButton();
        priceListButton = new JButton();
        managementButton = new JButton();
        logoutButton = new JButton();
        loggedInAsLabel = new JLabel();
        nameLabel = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 400));

        panel.setPreferredSize(new java.awt.Dimension(500, 500));

        headingLabel.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        headingLabel.setText("Hotel System");

        reservationButton.setLabel("Reservation");

        restaurantButton.setLabel("Restaurant");
        restaurantButton.setMaximumSize(new java.awt.Dimension(98, 32));
        restaurantButton.setMinimumSize(new java.awt.Dimension(98, 32));

        arrangementsButton.setLabel("Arrangements");

        priceListButton.setLabel("Price List");

        managementButton.setLabel("Management");

        logoutButton.setLabel("Log Out");

        loggedInAsLabel.setText("Logged In as:");

        nameLabel.setText(userInfo.getName());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(113, 113, 113)
                                                .addComponent(headingLabel))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(managementButton, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(arrangementsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(reservationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(38, 38, 38)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(restaurantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(priceListButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(154, 154, 154)
                                                .addComponent(loggedInAsLabel))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(140, 140, 140)
                                                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(174, 174, 174)
                                                .addComponent(nameLabel)))
                                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headingLabel)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(reservationButton)
                                        .addComponent(restaurantButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(arrangementsButton)
                                        .addComponent(priceListButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(managementButton)
                                .addGap(10, 10, 10)
                                .addComponent(loggedInAsLabel)
                                .addGap(8, 8, 8)
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(logoutButton)
                                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }
}
