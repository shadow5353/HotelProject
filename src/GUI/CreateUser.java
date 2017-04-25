package GUI;

import Domain.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Kasper on 21-04-2017.
 */
public class CreateUser extends JPanel {
    private JTextField username, name;
    private JLabel createuser, usernameLabel, passwordLabel, confirmPasswordLabel, nameLabel;
    private JPasswordField password, confirmPassword;
    private JButton createButton;
    private JCheckBox adminCheckBox;
    private boolean checkedAdmin;

    public CreateUser() {
        this.setLayout(new GridBagLayout());
        Dimension sizeOfLabel = new Dimension(130, 18);
        GridBagConstraints c = new GridBagConstraints();
        jLabels(sizeOfLabel, c);
        jTextFields(c);
        checkBox(c);
        createButton = new JButton("Create");
        class AddUser implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = name.getText();
                String emailUserName = username.getText();
                String userPassword = password.getText();

                User user = new User();
                user.insertUser(userName, emailUserName, userPassword, checkedAdmin);
            }
        }
        AddUser addUser = new AddUser();
        createButton.addActionListener(addUser);
        c.gridy = 7;
        this.add(createButton, c);
    }

    private void jTextFields(GridBagConstraints c) {
        Dimension sizeOfField = new Dimension(200, 25);
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
        password = new JPasswordField("Password");
        password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                password.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (password.getPassword().length == 0) {
                    password.setText("Password");
                }
            }
        });
        password.setPreferredSize(sizeOfField);
        c.gridy = 4;
        this.add(password, c);

        confirmPassword = new JPasswordField("Password");
        confirmPassword.setPreferredSize(sizeOfField);
        confirmPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                confirmPassword.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (confirmPassword.getPassword().length == 0) {
                    confirmPassword.setText("Password");
                }
            }
        });
        c.gridy = 5;
        this.add(confirmPassword, c);
    }

    private void jLabels(Dimension sizeOfLabel, GridBagConstraints c) {
        createuser = new JLabel("Create a new user");
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

    private void checkBox(GridBagConstraints c) {
        adminCheckBox = new JCheckBox("Admin");
        adminCheckBox.setFont(new Font("Times new roman", Font.BOLD, 15));
        c.gridx = 2;
        c.gridy = 6;
        adminCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
                    checkedAdmin = true;
                }
            }
        });
        this.add(adminCheckBox, c);
    }
}
