package GUI;

import Domain.User;
import Technical.DBFacade;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by Bruger on 24-04-2017.
 */
public class UserOverview extends JPanel {
    private JButton updateButton, deleteButton;
    private JLabel headline;
    private JScrollPane jScrollPane1;
    private JTable users;
    private DefaultTableModel jtModel;
    private String[] tableColumnName = {"ID", "Name", "Email", "Admin"};
    private String[][] tableData = {};
    private DBFacade dbFacade = new DBFacade();


    public UserOverview() {
        initComponents();
        getUserOverview();
        updateButtonEvent();
        deleteButtonEvent();
    }

    private void getUserOverview() {
        try {
            CallableStatement cl = dbFacade.callableStatement("{call userOverview}");
            ResultSet rs = cl.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                boolean admin = rs.getBoolean(5);

                Object[] newLine = {id, name, email, admin};

                jtModel.addRow(newLine);
            }
        } catch (SQLException e) {

        }
    }

    private void updateButtonEvent() {
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = users.getSelectedRow();

                int id = Integer.parseInt(users.getValueAt(row, 0).toString());
                String name = users.getValueAt(row, 1).toString();
                String email = users.getValueAt(row, 2).toString();
                boolean admin = Boolean.parseBoolean(users.getValueAt(row, 3).toString());

                User user = new User();

                user.updateUser(id, name, email, admin);
            }
        });
    }

    private void deleteButtonEvent() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = users.getSelectedRow();
                int id = Integer.parseInt(users.getValueAt(row, 0).toString());

                User user = new User();

                user.deleteUser(id);

                jtModel.removeRow(row);
            }
        });
    }

    private void initComponents() {
        headline = new JLabel();
        jScrollPane1 = new JScrollPane();
        jtModel = new DefaultTableModel(tableData, tableColumnName);
        users = new JTable(jtModel);
        updateButton = new JButton();
        deleteButton = new JButton();

        users.setAutoCreateRowSorter(true);

        headline.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        headline.setText("User Overview");

        jScrollPane1.setViewportView(users);

        deleteButton.setText("Delete User");
        updateButton.setText("Update User");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(headline)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton)
                                .addComponent(updateButton)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headline)
                                .addGap(31, 31, 31)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(deleteButton)
                                        .addComponent(updateButton))
                                .addContainerGap())
        );
    }
}
