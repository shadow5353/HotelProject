package GUI;

import Domain.Catering;
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
 * Created by Bruger on 27-04-2017.
 */
public class CateringOverview extends JPanel{
    private JTable cateringOverview;
    private JScrollPane scrollPane;
    private String[] columnName = {"ID", "Name", "Description","Price"};
    private DefaultTableModel tableDemo;
    private DBFacade dbFacade = new DBFacade();
    private JButton updateButton, deleteButton;
    private JLabel headline;


    public CateringOverview() {
        createContainer();
        getCateringOverview();
        createButtons();
        headline = new JLabel("Catering Overview");
        headline.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        headline.setText("Catering Overview");
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(headline)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(scrollPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton)
                                .addComponent(updateButton)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headline)
                                .addGap(31, 31, 31)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(deleteButton)
                                        .addComponent(updateButton))
                                .addContainerGap())
        );

        this.setVisible(true);
    }
    public void getCateringOverview() {
        try {
            CallableStatement cl = dbFacade.callableStatement("{call cateringOverview}");
            ResultSet rs = cl.executeQuery();
            while (rs.next()){
                int ID = rs.getInt(1);
                String basket = rs.getString(2);
                String basketDescription = rs.getString(3);
                BigDecimal basketPrice  = rs.getBigDecimal(4);
                tableDemo.addRow(new Object[]{ID, basket, basketDescription, basketPrice});
            }
        } catch (SQLException e) {

        }
    }

    public void createCateringTable() {
        cateringOverview = new JTable();
        tableDemo = new DefaultTableModel(0, 0);
        tableDemo.setColumnIdentifiers(columnName);
        cateringOverview.setModel(tableDemo);
    }
    public void createContainer() {
        createCateringTable();
        cateringOverview.setRowHeight(50);
        //cateringOverview.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        cateringOverview.setAutoCreateRowSorter(true);

        cateringOverview.getColumnModel().getColumn(0).setPreferredWidth(50);
        cateringOverview.getColumnModel().getColumn(1).setPreferredWidth(100);
        cateringOverview.getColumnModel().getColumn(2).setPreferredWidth(300);
        cateringOverview.getColumnModel().getColumn(3).setPreferredWidth(100);

        scrollPane = new JScrollPane(cateringOverview);
        scrollPane.setViewportView(cateringOverview);
        //cateringOverview.setFillsViewportHeight(true);
        this.add(scrollPane);

    }
    public void createButtons(){
        updateButton = new JButton();
        deleteButton = new JButton();

        deleteButton.setText("Delete basket");
        updateButton.setText("Update basket");
        updateButtonEvent();
        deleteButtonEvent();
    }
    private void updateButtonEvent() {
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = cateringOverview.getSelectedRow();

                int menuID = Integer.parseInt(cateringOverview.getValueAt(row, 0).toString());

                String basketName = cateringOverview.getValueAt(row, 1).toString();
                String basketDescription = cateringOverview.getValueAt(row, 2).toString();
                BigDecimal basketPrice = new BigDecimal(cateringOverview.getValueAt(row, 3).toString());

                Catering catering = new Catering();
                catering.updateCatering(menuID, basketName, basketDescription, basketPrice);

            }
        });
    }

    private void deleteButtonEvent() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int row = cateringOverview.getSelectedRow();
                int menuID = Integer.parseInt(cateringOverview.getValueAt(row, 0).toString());

                Catering catering = new Catering();
                catering.deleteMenu(menuID);

                tableDemo.removeRow(row);
            }
        });
    }

    public static void main(String[] args) throws SQLException {
        CateringOverview view = new CateringOverview();
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.add(view);
        frame.setVisible(true);
        String ok = "";
    }
}
