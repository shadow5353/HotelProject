package GUI;

import Domain.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

/**
 * Created by Bruger on 24-04-2017.
 */
public class DeleteUser extends JFrame {
    private JLabel userID;
    private JTextField insertID;
    private JButton deleteButton;
    private GridBagConstraints c;
    private JPanel deletePanel;
    private UserOverview userOverview;

    public DeleteUser() throws SQLException {
       // this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                userOverview.setVisible(false);
            }
        });
        this.setSize(400, 200);
        this.setTitle("Delete User");
        //this.setLayout(new GridBagLayout());
        createComponents();
        this.setVisible(true);

        userOverview = new UserOverview();

    }

    public void createComponents() {
        deletePanel = new JPanel();
        deletePanel.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;

        userID = new JLabel("Enter user ID ");
        insertID = new JTextField();
        Dimension sizeOfField = new Dimension(200, 25);
        insertID.setPreferredSize(sizeOfField);

        deleteButton = new JButton("Delete user");
        class DeleteUserU implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                try {
                    user.deleteUser(Integer.parseInt(insertID.getText()));
                    userOverview.setVisible(false);
                    userOverview = new UserOverview();
                    insertID.setText("");

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        DeleteUserU addUser = new DeleteUserU();
        deleteButton.addActionListener(addUser);

        deletePanel.add(userID, c);
        c.gridx = 2;

        deletePanel.add(insertID, c);
        c.gridx = 2;
        c.gridy = 3;
        deletePanel.add(deleteButton, c);
        this.add(deletePanel);
    }

  /*  public static void main(String[] args) throws SQLException {
        DeleteUser deleteUser = new DeleteUser();
        //UserOverview userOverview = new UserOverview();
    }*/

}
