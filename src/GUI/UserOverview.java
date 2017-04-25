package GUI;

import Technical.DBFacade;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.sql.*;

/**
 * Created by Bruger on 24-04-2017.
 */
public class UserOverview extends JPanel {
    private javax.swing.JButton updateButton;
    private javax.swing.JButton printButton;
    private javax.swing.JLabel headline;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable users;
    private DefaultTableModel jtModel;
    private String[] tableColumnName = {"ID", "Name", "Email", "Admin"};
    private String[][] tableData = {};
    private DBFacade dbFacade = new DBFacade();


    public UserOverview() {
        initComponents();
        getUserOverview();

    }
    public void getUserOverview() {
        try {
            CallableStatement cl = dbFacade.callableStatement("{call userOverview}");
            ResultSet rs = cl.executeQuery();

            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                boolean admin = rs.getBoolean(5);

                Object[] newLine = {new Integer(id), name, email, new Boolean(admin)};

                jtModel.addRow(newLine);
            }
        } catch (SQLException e) {

        }
    }

    private void initComponents() {

        headline = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtModel = new DefaultTableModel(tableData, tableColumnName);
        users = new JTable(jtModel);
        updateButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();

        users.setAutoCreateRowSorter(true);

        headline.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        headline.setText("User Overview");



        jScrollPane1.setViewportView(users);

        updateButton.setText("Update Users");

        printButton.setText("Print Users");

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
                                .addComponent(printButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                                        .addComponent(updateButton)
                                        .addComponent(printButton))
                                .addContainerGap())
        );
    }// </editor-fold>
}
