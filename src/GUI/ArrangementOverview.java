package GUI;

import Technical.DBFacade;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jacob on 27-04-2017.
 */
public class ArrangementOverview extends JPanel {
    private JButton updateButton, deleteButton;
    private JLabel headline;
    private JScrollPane jScrollPane1;
    private JTable serviceTable;
    private DefaultTableModel jtModel;
    private String[] tableColumnName = {"Arrangement", "Customer", "Name", "Description", "Guests", "Price", "Date From", "Date To"};
    private String[][] tableData = {};
    private DBFacade dbFacade = new DBFacade();

    public ArrangementOverview() {
        initComponents();
        getCustomerOverview();
//        updateButtonEvent();
//        deleteButtonEvent();
    }

    private void getCustomerOverview() {
        try {
            CallableStatement cl = dbFacade.callableStatement("{call arrangementOverview}");
            ResultSet rs = cl.executeQuery();

            while (rs.next()) {
                int arrangementID = rs.getInt(1);
                int customerID = rs.getInt(2);
                String arrangementName = rs.getString(3);
                String description = rs.getString(4);
                int numberOfGuests = rs.getInt(5);
                BigDecimal price = rs.getBigDecimal(6);
                Date dateFrom = rs.getDate(7);
                Date dateTo = rs.getDate(8);

                Object[] newLine = {arrangementID, customerID, arrangementName, description, numberOfGuests, price, dateFrom, dateTo};

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
        headline.setText("Arrangement Overview");

        jScrollPane1.setViewportView(serviceTable);

        deleteButton.setText("Delete Arrangement");
        updateButton.setText("Update Arrangement");

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