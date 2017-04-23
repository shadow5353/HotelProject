package ui;

import domain.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by Kasper on 18-04-2017.
 */
public class LoginGUI extends JFrame {
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginGUI() {
        this.setSize(420, 220);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setFocusable(true);
        this.add(textFields_Button());
        this.setVisible(true);
        this.setTitle("Login");

        enterEvent();
        loginButtonEvent();
    }

    private void enterEvent() {
        passwordField.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });
    }

    private void loginButtonEvent() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });
    }

    /**
     * LoginController the user
     */
    private void loginUser() {
        LoginController loginController = new LoginController();

        String username = userNameField.getText();
        String password = passwordField.getText();

        boolean found = loginController.login(username, password);

        if(found) {
            setVisible(false);

            new MainFrame(loginController.getUserID()).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Wrong username or password!");
        }
    }

    public JPanel textFields_Button() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JLabel headLine = new JLabel("Login to hotel system");
        headLine.setFont(new Font("calibri", Font.ITALIC, 24));
        c.gridwidth = 3;
        c.insets = new Insets(0, 0, 25, 0);
        panel.add(headLine, c);
        userNameField = new JTextField("Username");
        userNameField.setPreferredSize(new Dimension(150, 29));
        userNameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                userNameField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        c.gridy = 2;
        c.gridx = 1;
        c.insets = new Insets(0, 0, 0, 0);
        c.gridwidth = 1;
        panel.add(userNameField, c);
        passwordField = new JPasswordField();
        passwordField.setText("Password");
        passwordField.setPreferredSize(new Dimension(150, 29));
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                passwordField.setText("");

            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        c.insets = new Insets(0, 5, 0, 5);
        c.gridx = 2;
        panel.add(passwordField, c);
        loginButton = new JButton("Login");
        c.gridx = 3;
        panel.add(loginButton, c);

        return panel;
    }


}