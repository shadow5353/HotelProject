package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import Domain.Controller;
import Domain.UserInfo;
import oracle.jrockit.jfr.JFR;

/**
 * Created by Jacob on 18-04-2017.
 */

public class MainFrame extends JFrame {
    private GridBagLayout grid = new GridBagLayout();
    private JLabel headline;
    private JPanel mainPanel, createUser, dymanicPanel, addRoomPanel, addService, userOverviewPanel, roomOverviewPanel,
            serviceOverviewPanel, orderServicePanel, addMenuPanel, addCateringPanel, addReservation, addArrangementPanel,
            viewAllArrangementPanel, reservationOverviewPanel, cateringOverviewPanel, orderCatering, menuOverviewPanel,
            createCustomerPanel, arrangementOverviewPanel, customerOverviewPanel;
    private JMenuBar menu;
    private JMenu arrangementMenu, cateringMenu, managementMenu, nameMenu, reservationMenu, restaurantMenu, roomsMenu,
            servicesMenu, mainMenu, customerMenu;
    private JMenuItem viewAllArrangementsButton, viewAllCateringsButton, viewAllReservationButton, viewAllUsersButton,
            viewMenuButton, viewRoomsButton, viewServicesButton, logoutButton, createReservationButton, addUserButton,
            addToMenuButton, addServiceButton, addRoomButton, addCateringsButton, addArrangementButton,
            orderCateringButton, dailyOverviewButton, exitButton, orderServiceButton, createCustomerButton, viewCustomerButton;
    private UserInfo userInfo;

    public MainFrame(int userID) {
        this.userInfo = new UserInfo(userID);

        this.setTitle("Hotel System");

        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                screenSize.width - inset * 2,
                screenSize.height - inset * 2);

        initComponents();
        events();
    }

    /**
     * Holds all the events for buttons
     */
    private void events() {
        checkAdmin();
        mainMenuButtonEvent();
        addUserButtonEvent();
        logoutButtonEvent();
        exitButtonEvent();
        addRoomButtonEvent();
        addServiceButtonEvent();
        userOverviewButtonEvent();
        viewAllRooms();
        serviceOverview();
        orderServiceButton();
        addMenuButtonEvent();
        setAddCateringsButtonEvent();
        addReservationButtonEvent();
        addArangementButtonEvent();
        addViewAllArrangementsButtonEvent();
        viewAllReservationButton();
        cateringOverviewButtonEvent();
        orderCateringButtonEvent();
        menuOverviewButtonEvent();
        createCustomerButtonEvent();
        viewAllCustomers();
    }


    /**
     * Check if the user is a admin, if an admin it will show the management button
     */
    private void checkAdmin() {
        if (!userInfo.getIsAdmin()) {
            managementMenu.setVisible(false);
            addToMenuButton.setVisible(false);
            addCateringsButton.setVisible(false);
            addRoomButton.setVisible(false);
            addServiceButton.setVisible(false);
        }
    }

    /**
     * Logout the program
     */
    private void logout() {
        new LoginGUI().setVisible(true);
        this.dispose();
    }


    /**
     * ActionListener for logout button
     * This will logout of the program
     */
    private void logoutButtonEvent() {
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });
    }

    /**
     * ActionListener for addUserButton
     * This will make add user panel visible
     */
    private void addUserButtonEvent() {
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disablePanels();
                createUser.setVisible(true);
            }
        });
    }

    /**
     * ActionListener for mainMenu Button
     * This will make the main menu/daily overview visible
     */
    private void mainMenuButtonEvent() {
        dailyOverviewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disablePanels();
                mainPanel.setVisible(true);

            }
        });
    }

    private void addRoomButtonEvent() {
        addRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disablePanels();
                addRoomPanel.setVisible(true);
            }
        });
    }

    /**
     * ActionListener for exit Button
     * This exit the program
     */
    private void exitButtonEvent() {
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void addServiceButtonEvent() {
        addServiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disablePanels();
                addService.setVisible(true);
            }
        });
    }

    private void userOverviewButtonEvent() {
        viewAllUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disablePanels();
                dymanicPanel.remove(userOverviewPanel);
                userOverviewPanel = new UserOverview();
                dymanicPanel.add(userOverviewPanel);
                userOverviewPanel.setVisible(true);
            }
        });
    }

    private void viewAllRooms() {
        viewRoomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disablePanels();
                dymanicPanel.remove(roomOverviewPanel);
                roomOverviewPanel = new RoomOverview();
                dymanicPanel.add(roomOverviewPanel);
                roomOverviewPanel.setVisible(true);
            }
        });
    }

    private void serviceOverview() {
        viewServicesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disablePanels();
                dymanicPanel.remove(serviceOverviewPanel);
                serviceOverviewPanel = new ServiceOverview();
                dymanicPanel.add(serviceOverviewPanel);
                serviceOverviewPanel.setVisible(true);
            }
        });
    }

    private void orderServiceButton() {
        orderServiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disablePanels();
                dymanicPanel.remove(serviceOverviewPanel);
                serviceOverviewPanel = new OrderService();
                dymanicPanel.add(serviceOverviewPanel);
                serviceOverviewPanel.setVisible(true);
            }
        });
    }

    private void setAddCateringsButtonEvent() {
        addCateringsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disablePanels();
                addCateringPanel.setVisible(true);
            }
        });
    }

    private void addMenuButtonEvent() {
        addToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                disablePanels();
                addMenuPanel.setVisible(true);
            }
        });
    }

    private void addReservationButtonEvent() {
        createReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disablePanels();
                addReservation.setVisible(true);
            }
        });
    }

    private void addArangementButtonEvent() {
        addArrangementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disablePanels();
                addArrangementPanel.setVisible(true);
            }
        });
    }

    private void addViewAllArrangementsButtonEvent() {
        viewAllArrangementsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disablePanels();
                dymanicPanel.remove(viewAllArrangementPanel);
                viewAllArrangementPanel = new ArrangementOverview();
                dymanicPanel.add(viewAllArrangementPanel);
                viewAllArrangementPanel.setVisible(true);
            }
        });
    }

    private void viewAllReservationButton() {
        viewAllReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disablePanels();
                dymanicPanel.remove(reservationOverviewPanel);
                reservationOverviewPanel = new ReservationOverview(new Controller());
                dymanicPanel.add(reservationOverviewPanel);
                reservationOverviewPanel.setVisible(true);
            }
        });
    }

    private void orderCateringButtonEvent() {
        orderCateringButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disablePanels();
                orderCatering.setVisible(true);
            }
        });
    }

    private void cateringOverviewButtonEvent() {
        viewAllCateringsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disablePanels();
                cateringOverviewPanel = new CateringOverview();
                cateringOverviewPanel.setVisible(true);
                GridBagConstraints gc = new GridBagConstraints();
                gc.gridx = 0;
                gc.gridy = 0;
                dymanicPanel.add(cateringOverviewPanel, gc);
            }
        });
    }

    private void menuOverviewButtonEvent() {
        viewMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disablePanels();
                menuOverviewPanel = new MenuOverview();
                menuOverviewPanel.setVisible(true);
                GridBagConstraints gc = new GridBagConstraints();
                gc.gridx = 0;
                gc.gridy = 0;
                dymanicPanel.add(menuOverviewPanel, gc);
            }
        });
    }

    private void createCustomerButtonEvent() {
        createCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disablePanels();
                createCustomerPanel.setVisible(true);
            }
        });
    }

    private void viewAllCustomers() {
        viewCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disablePanels();
                dymanicPanel.remove(customerOverviewPanel);
                customerOverviewPanel = new CustomerOverview();
                dymanicPanel.add(customerOverviewPanel);
                customerOverviewPanel.setVisible(true);
            }
        });
    }

    private void disablePanels() {
        mainPanel.setVisible(false);
        createUser.setVisible(false);
        addRoomPanel.setVisible(false);
        addService.setVisible(false);
        roomOverviewPanel.setVisible(false);
        userOverviewPanel.setVisible(false);
        serviceOverviewPanel.setVisible(false);
        orderServicePanel.setVisible(false);
        addMenuPanel.setVisible(false);
        addCateringPanel.setVisible(false);
        addReservation.setVisible(false);
        addArrangementPanel.setVisible(false);
        viewAllArrangementPanel.setVisible(false);
        reservationOverviewPanel.setVisible(false);
        orderCatering.setVisible(false);
        cateringOverviewPanel.setVisible(false);
        menuOverviewPanel.setVisible(false);
        createCustomerPanel.setVisible(false);
        arrangementOverviewPanel.setVisible(false);
        customerOverviewPanel.setVisible(false);
    }

    /**
     * Setting the components for the main form.
     */
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        addRoomPanel = new AddRoom();
        addService = new AddService();
        headline = new javax.swing.JLabel();
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
        orderServiceButton = new JMenuItem();
        customerMenu = new JMenu();
        createCustomerButton = new JMenuItem();
        viewCustomerButton = new JMenuItem();
        createUser = new CreateUser();
        dymanicPanel = new JPanel();
        exitButton = new JMenuItem();
        userOverviewPanel = new UserOverview();
        roomOverviewPanel = new RoomOverview();
        serviceOverviewPanel = new ServiceOverview();
        orderServicePanel = new OrderService();
        addMenuPanel = new AddMenu();
        addCateringPanel = new AddCatering();
        addReservation = new ReservationGUI(new Controller());
        addArrangementPanel = new AddArrangement();
        reservationOverviewPanel = new ReservationOverview(new Controller());
        cateringOverviewPanel = new CateringOverview();
        orderCatering = new OrderCatering();
        menuOverviewPanel = new MenuOverview();
        createCustomerPanel = new CreateCustomerGUI(new Controller());
        arrangementOverviewPanel = new ArrangementOverview();
        customerOverviewPanel = new CustomerOverview();

        getContentPane().setLayout(new java.awt.CardLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.add(headline);

        headline.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        headline.setText("Welcome " + userInfo.getName());

        menu.setForeground(new java.awt.Color(102, 102, 102));

        nameMenu.setText(userInfo.getName());

        logoutButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
        logoutButton.setText("Logout");

        nameMenu.add(logoutButton);

        exitButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
        exitButton.setText("Exit");

        nameMenu.add(exitButton);

        menu.add(nameMenu);

        mainMenu.setText("Start Page");

        dailyOverviewButton.setText("Daily Overview");

        mainMenu.add(dailyOverviewButton);

        menu.add(mainMenu);

        createCustomerButton.setText("Create Customer");
        customerMenu.add(createCustomerButton);

        viewCustomerButton.setText("View Customer");
        customerMenu.add(viewCustomerButton);

        customerMenu.setText("Customer");
        menu.add(customerMenu);

        reservationMenu.setText("Reservation");

        createReservationButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
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

        addArrangementButton.setText("Add Arrangement");
        ;
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

        orderServiceButton.setText("Order Service");
        servicesMenu.add(orderServiceButton);

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

        add(mainPanel);

        dymanicPanel.setLayout(grid);

        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;

        dymanicPanel.add(mainPanel, gc);
        dymanicPanel.add(createUser, gc);
        dymanicPanel.add(addRoomPanel, gc);
        dymanicPanel.add(addService, gc);
        dymanicPanel.add(userOverviewPanel, gc);
        dymanicPanel.add(roomOverviewPanel, gc);
        dymanicPanel.add(serviceOverviewPanel, gc);
        dymanicPanel.add(orderServicePanel, gc);
        dymanicPanel.add(addMenuPanel, gc);
        dymanicPanel.add(addCateringPanel, gc);
        dymanicPanel.add(addReservation, gc);
        dymanicPanel.add(addArrangementPanel, gc);
        dymanicPanel.add(viewAllArrangementPanel, gc);
        dymanicPanel.add(reservationOverviewPanel, gc);
        dymanicPanel.add(cateringOverviewPanel, gc);
        dymanicPanel.add(orderCatering, gc);
        dymanicPanel.add(menuOverviewPanel, gc);
        dymanicPanel.add(createCustomerPanel,gc);
        dymanicPanel.add(arrangementOverviewPanel, gc);
        dymanicPanel.add(customerOverviewPanel, gc);

        disablePanels();
        mainPanel.setVisible(true);

        this.add(dymanicPanel);

    }
}
