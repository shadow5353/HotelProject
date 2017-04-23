package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by Kasper on 21-04-2017.
 */
public class CreateUser extends JPanel {
    JTextField username, name;
    JLabel createuser, usernameLabel, passwordLabel, confirmPasswordLabel, nameLabel;
    JPasswordField password, confirmPassword;
    JButton createButton;

    public CreateUser() {
        this.setLayout(new GridBagLayout());
        Dimension sizeOfLabel = new Dimension(130, 18);
        GridBagConstraints c = new GridBagConstraints();
        jLabels(sizeOfLabel, c);
        jTextFields(c);
        createButton = new JButton("Create");
        c.gridy = 6;
        this.add(createButton, c);
    }

    private void jTextFields(GridBagConstraints c) {
        Dimension sizeOfField = new Dimension(200, 18);
        name = new JTextField("Name");
        name.setPreferredSize(sizeOfField);
        name.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                name.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (name.getText().isEmpty()) {
                    name.setText("Name");
                }
            }
        });
        c.gridx = 2;
        c.gridy = 2;
        this.add(name, c);
        username = new JTextField("Will be your username");
        username.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                username.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (username.getText().isEmpty()) {
                    username.setText("Will be your username");
                }


            }
        });
        username.setPreferredSize(sizeOfField);
        c.gridy = 3;
        this.add(username, c);
        password = new JPasswordField("Passwor");
        password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                password.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (password.getPassword().length == 0) {
                    password.setText("Passwor");
                }


            }
        });
        password.setPreferredSize(sizeOfField);
        c.gridy = 4;
        this.add(password, c);
        confirmPassword = new JPasswordField("Passwor");
        confirmPassword.setPreferredSize(sizeOfField);
        confirmPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                confirmPassword.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (confirmPassword.getPassword().length == 0) {
                    confirmPassword.setText("Passwor");
                }

            }
        });
        c.gridy = 5;
        this.add(confirmPassword, c);
    }

    private void jLabels(Dimension sizeOfLabel, GridBagConstraints c) {
        createuser = new JLabel("Create new user");
        createuser.setFont(new Font("Times new roman", Font.BOLD, 45));
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 25, 0);
        this.add(createuser, c);
        c.insets = new Insets(0, 10, 8, 0);
        nameLabel = new JLabel("Name: ", SwingConstants.RIGHT);
        nameLabel.setPreferredSize(sizeOfLabel);
        c.gridy = 2;
        c.gridwidth = 1;
        this.add(nameLabel, c);
        usernameLabel = new JLabel("Email: ", SwingConstants.RIGHT);
        usernameLabel.setPreferredSize(sizeOfLabel);
        c.gridy = 3;
        this.add(usernameLabel, c);
        passwordLabel = new JLabel("Password: ", SwingConstants.RIGHT);
        passwordLabel.setPreferredSize(sizeOfLabel);
        c.gridy = 4;
        this.add(passwordLabel, c);
        confirmPasswordLabel = new JLabel("Confirm password: ", SwingConstants.RIGHT);
        confirmPasswordLabel.setPreferredSize(sizeOfLabel);
        c.gridy = 5;
        this.add(confirmPasswordLabel, c);
    }

}
