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
 * Created by Jacob on 26-04-2017.
 */
public class ServiceOverview extends JPanel {
    private JButton updateButton, deleteButton;
    private JLabel headline;
    private JScrollPane jScrollPane1;
    private JTable serviceTable;
    private DefaultTableModel jtModel;
    private String[] tableColumnName = {"Service ID", "Service Name", "Description", "Price"};
    private String[][] tableData = {};
    private DBFacade dbFacade = new DBFacade();

    public ServiceOverview() {
        initComponents();
        getServiceOverview();
        updateButtonEvent();
        deleteButtonEvent();
    }

    private void getServiceOverview() {
        try {
            CallableStatement cl = dbFacade.callableStatement("{call serviceOverview}");
            ResultSet rs = cl.executeQuery();

            while (rs.next()) {
                int serviceID = rs.getInt(1);
                String serviceName = rs.getString(2);
                BigDecimal price = rs.getBigDecimal(4);
                String serviceDescription = rs.getString(3);

                Object[] newLine = {serviceID, serviceName, serviceDescription, price};

                jtModel.addRow(newLine);
            }
        } catch (SQLException e) {

        }
    }

    private void updateButtonEvent() {
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = serviceTable.getSelectedRow();

                int serviceID = Integer.parseInt(serviceTable.getValueAt(row, 0).toString());
                String serviceName = serviceTable.getValueAt(row, 1).toString();
                String description = serviceTable.getValueAt(row, 2).toString();
                BigDecimal price = new BigDecimal(serviceTable.getValueAt(row, 3).toString());

                Service service = new Service();

                service.updateService(serviceID, serviceName, description, price);
            }
        });
    }

    private void deleteButtonEvent() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = serviceTable.getSelectedRow();

                int id = Integer.parseInt(serviceTable.getValueAt(row, 0).toString());

                Service service = new Service();

                service.deleteService(id);

                jtModel.removeRow(row);
            }
        });
    }

    private void initComponents() {
        headline = new JLabel();
        jScrollPane1 = new JScrollPane();
        jtModel = new DefaultTableModel(tableData, tableColumnName);
        serviceTable = new JTable(jtModel);
        updateButton = new JButton();
        deleteButton = new JButton();

        serviceTable.setAutoCreateRowSorter(true);

        headline.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        headline.setText("Service Overview");

        jScrollPane1.setViewportView(serviceTable);

        deleteButton.setText("Delete Service");
        updateButton.setText("Update Service");

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
