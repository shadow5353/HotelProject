package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Domain.UserInfo;

/**
 * Created by Jacob on 18-04-2017.
 */

public class MainFrame extends JFrame {
    private JLabel jLabel1, reservationHeadline;
    private JPanel mainPanel, createUserPanel, createReservationPanel;
    private JMenuBar menu;
    private JMenu arrangementMenu, cateringMenu, managementMenu, nameMenu, reservationMenu, restaurantMenu, roomsMenu,
            servicesMenu, mainMenu;
    private JMenuItem viewAllArrangementsButton, viewAllCateringsButton, viewAllReservationButton, viewAllUsersButton,
            viewMenuButton, viewRoomsButton, viewServicesButton, logoutButton, createReservationButton, addUserButton,
            addToMenuButton, addServiceButton, addRoomButton, addCateringsButton, addArrangementButton,
            orderCateringButton, dailyOverviewButton;
    private UserInfo userInfo;

    public MainFrame(int userID) {
        this.userInfo = new UserInfo(userID);

        this.setTitle("Hotel System");

        initComponents();
        checkAdmin();
        addUserButtonEvent();
    }

    private void addUserButtonEvent() {
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container c = getContentPane();
                c.removeAll();
                createUserPanel.setBounds(0, 0, 600, 500);
                createUserPanel.setVisible(true);
            }
        });
    }

    /**
     * Check if the user is a admin, if an admin it will show the management button
     */
    private void checkAdmin() {
        if(userInfo.getIsAdmin()) {
            managementMenu.setVisible(true);
        } else {
            managementMenu.setVisible(false);
        }
    }

    /**
     * Setting the components for the main form.
     */
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        createReservationPanel = new javax.swing.JPanel();
        reservationHeadline = new JLabel();
        menu = new javax.swing.JMenuBar();
        nameMenu = new javax.swing.JMenu();
        logoutButton = new javax.swing.JMenuItem();
        mainMenu = new javax.swing.JMenu();
        dailyOverviewButton = new JMenuItem();
        reservationMenu = new javax.swing.JMenu();
        createReservationButton = new javax.swing.JMenuItem();
        viewAllReservationButton = new javax.swing.JMenuItem();
        restaurantMenu = new javax.swing.JMenu();
        viewMenuButton = new javax.swing.JMenuItem();
        addToMenuButton = new javax.swing.JMenuItem();
        cateringMenu = new javax.swing.JMenu();
        orderCateringButton = new javax.swing.JMenuItem();
        viewAllCateringsButton = new javax.swing.JMenuItem();
        addCateringsButton = new javax.swing.JMenuItem();
        arrangementMenu = new javax.swing.JMenu();
        addArrangementButton = new javax.swing.JMenuItem();
        viewAllArrangementsButton = new javax.swing.JMenuItem();
        roomsMenu = new javax.swing.JMenu();
        addRoomButton = new javax.swing.JMenuItem();
        viewRoomsButton = new javax.swing.JMenuItem();
        servicesMenu = new javax.swing.JMenu();
        addServiceButton = new javax.swing.JMenuItem();
        viewServicesButton = new javax.swing.JMenuItem();
        managementMenu = new javax.swing.JMenu();
        addUserButton = new javax.swing.JMenuItem();
        viewAllUsersButton = new javax.swing.JMenuItem();
        createUserPanel = new ManagementPanel();

        getContentPane().setLayout(new java.awt.CardLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Welcome " + userInfo.getName());

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap(337, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(339, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addContainerGap(526, Short.MAX_VALUE))
        );

        getContentPane().add(mainPanel, "card2");

        reservationHeadline.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        reservationHeadline.setText("Create Reservation");

        javax.swing.GroupLayout createReservationPanelLayout = new javax.swing.GroupLayout(createReservationPanel);
        createReservationPanel.setLayout(createReservationPanelLayout);
        createReservationPanelLayout.setHorizontalGroup(
                createReservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createReservationPanelLayout.createSequentialGroup()
                                .addContainerGap(385, Short.MAX_VALUE)
                                .addComponent(reservationHeadline)
                                .addContainerGap(386, Short.MAX_VALUE))
        );
        createReservationPanelLayout.setVerticalGroup(
                createReservationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createReservationPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(reservationHeadline)
                                .addContainerGap(540, Short.MAX_VALUE))
        );

        getContentPane().add(createReservationPanel, "card3");

        menu.setForeground(new java.awt.Color(102, 102, 102));

        nameMenu.setText(userInfo.getName());

        logoutButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        logoutButton.setText("Logout");

        nameMenu.add(logoutButton);

        menu.add(nameMenu);

        mainMenu.setText("Start Page");

        dailyOverviewButton.setText("Daily Overview");

        mainMenu.add(dailyOverviewButton);

        menu.add(mainMenu);

        reservationMenu.setText("Reservation");

        createReservationButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        createReservationButton.setText("Create Reservation");
        reservationMenu.add(createReservationButton);

        viewAllReservationButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        viewAllReservationButton.setText("View All Reservations");
        reservationMenu.add(viewAllReservationButton);

        menu.add(reservationMenu);

        restaurantMenu.setText("Restaurant");

        viewMenuButton.setText("View Menu");
        restaurantMenu.add(viewMenuButton);

        addToMenuButton.setText("Add to Menu");
        restaurantMenu.add(addToMenuButton);

        menu.add(restaurantMenu);

        cateringMenu.setText("Catering");

        orderCateringButton.setText("Order Catering");
        cateringMenu.add(orderCateringButton);

        viewAllCateringsButton.setText("View All Caterings");
        cateringMenu.add(viewAllCateringsButton);

        addCateringsButton.setText("Add Catering");

        cateringMenu.add(addCateringsButton);

        menu.add(cateringMenu);

        arrangementMenu.setText("Arrangement");

        addArrangementButton.setText("Add Arrangement");;
        arrangementMenu.add(addArrangementButton);

        viewAllArrangementsButton.setText("View All Arrangements");
        arrangementMenu.add(viewAllArrangementsButton);

        menu.add(arrangementMenu);

        roomsMenu.setText("Rooms");

        addRoomButton.setText("Add Room");
        roomsMenu.add(addRoomButton);

        viewRoomsButton.setText("View Rooms");
        roomsMenu.add(viewRoomsButton);

        menu.add(roomsMenu);

        servicesMenu.setText("Services");

        addServiceButton.setText("Add Service");
        servicesMenu.add(addServiceButton);

        viewServicesButton.setText("View Services");
        servicesMenu.add(viewServicesButton);

        menu.add(servicesMenu);

        managementMenu.setText("Management");

        addUserButton.setText("Add User");
        managementMenu.add(addUserButton);

        viewAllUsersButton.setText("View All Users");
        managementMenu.add(viewAllUsersButton);

        menu.add(managementMenu);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
}
