package GUI;

import Domain.Service;
import Technical.DBFacade;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jacob on 27-04-2017.
 */
public class CustomerOverview extends JPanel {
    private JButton updateButton, deleteButton;
    private JLabel headline;
    private JScrollPane jScrollPane1;
    private JTable serviceTable;
    private DefaultTableModel jtModel;
    private String[] tableColumnName = {"Customer ID", "First Name", "Last Name", "Email", "Phone No", "Address", "City", "Postal Code"};
    private String[][] tableData = {};
    private DBFacade dbFacade = new DBFacade();

    public CustomerOverview() {
        initComponents();
        getCustomerOverview();
//        updateButtonEvent();
//        deleteButtonEvent();
    }

    private void getCustomerOverview() {
        try {
            CallableStatement cl = dbFacade.callableStatement("{call customerOverview}");
            ResultSet rs = cl.executeQuery();

            while (rs.next()) {
                int customerID = rs.getInt(1);
                String firstname = rs.getString(2);
                String lastname = rs.getString(3);
                String email = rs.getString(4);
                int phone = rs.getInt(5);
                String address = rs.getString(6);
                String city = rs.getString(7);
                int postalCode = rs.getInt(8);

                Object[] newLine = {customerID, firstname, lastname, email, phone, address, city, postalCode};

                jtModel.addRow(newLine);
            }
        } catch (SQLException e) {

        }
    }

//    private void updateButtonEvent() {
//        updateButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int row = serviceTable.getSelectedRow();
//
//                int serviceID = Integer.parseInt(serviceTable.getValueAt(row, 0).toString());
//                String serviceName = serviceTable.getValueAt(row, 1).toString();
//                String description = serviceTable.getValueAt(row, 2).toString();
//                BigDecimal price = new BigDecimal(serviceTable.getValueAt(row, 3).toString());
//
//                Service service = new Service();
//
//                service.updateService(serviceID, serviceName, description, price);
//            }
//        });
//    }
//
//    private void deleteButtonEvent() {
//        deleteButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int row = serviceTable.getSelectedRow();
//
//                int id = Integer.parseInt(serviceTable.getValueAt(row, 0).toString());
//
//                Service service = new Service();
//
//                service.deleteService(id);
//
//                jtModel.removeRow(row);
//            }
//        });
//    }

    private void initComponents() {
        headline = new JLabel();
        jScrollPane1 = new JScrollPane();
        jtModel = new DefaultTableModel(tableData, tableColumnName);
        serviceTable = new JTable(jtModel);
        updateButton = new JButton();
        deleteButton = new JButton();

        serviceTable.setAutoCreateRowSorter(true);

        headline.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        headline.setText("Customer Overview");

        jScrollPane1.setViewportView(serviceTable);

        deleteButton.setText("Delete Customer");
        updateButton.setText("Update Customer");

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
