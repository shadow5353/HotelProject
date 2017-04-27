package GUI;

import Domain.Menu;
import Technical.DBFacade;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Bruger on 26-04-2017.
 */
public class MenuOverview extends JPanel {
    private JTable menuOverview;
    private JScrollPane scrollPane;
    private String[] columnName = {"ID", "Name", "Description","Price"};
    private DefaultTableModel tableDemo;
    private DBFacade dbFacade = new DBFacade();
    private JButton updateButton, deleteButton;
    private JLabel headline;


    public MenuOverview() {
        createContainer();
        getMenuOverview();
        createButtons();
        headline = new JLabel("Menu Overview");
        headline.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        headline.setText("Menu Overview");
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
    public void getMenuOverview() {
        try {
            CallableStatement cl = dbFacade.callableStatement("{call menuOverview}");
            ResultSet rs = cl.executeQuery();
            while (rs.next()){
                int ID = rs.getInt(1);
                String name = rs.getString(2);
                String description = rs.getString(3);
                BigDecimal price  = rs.getBigDecimal(4);
                tableDemo.addRow(new Object[]{ID, name, description, price});
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public void createMenuTable() {
        menuOverview = new JTable();
        tableDemo = new DefaultTableModel(0, 0);
        tableDemo.setColumnIdentifiers(columnName);
        menuOverview.setModel(tableDemo);
    }
    public void createContainer() {
        createMenuTable();
        menuOverview.setRowHeight(50);
        //menuOverview.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        menuOverview.setAutoCreateRowSorter(true);

        menuOverview.getColumnModel().getColumn(0).setPreferredWidth(50);
        menuOverview.getColumnModel().getColumn(1).setPreferredWidth(100);
        menuOverview.getColumnModel().getColumn(2).setPreferredWidth(300);
        menuOverview.getColumnModel().getColumn(3).setPreferredWidth(100);

        scrollPane = new JScrollPane(menuOverview);
        scrollPane.setViewportView(menuOverview);
        //menuOverview.setFillsViewportHeight(true);
        this.add(scrollPane);
    }
    public void createButtons(){
        updateButton = new JButton();
        deleteButton = new JButton();

        deleteButton.setText("Delete dish");
        updateButton.setText("Update dish");
        updateButtonEvent();
        deleteButtonEvent();
    }
    private void updateButtonEvent() {
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = menuOverview.getSelectedRow();

                int menuID = Integer.parseInt(menuOverview.getValueAt(row, 0).toString());
                String dishName = menuOverview.getValueAt(row, 1).toString();
                String dishDescription = menuOverview.getValueAt(row, 2).toString();
                BigDecimal price = new BigDecimal(menuOverview.getValueAt(row, 3).toString());

                Menu menu = new Menu();
                System.out.println(menuID + dishName);
                menu.updateMenu(menuID, dishName, dishDescription, price);
            }
        });
    }

    private void deleteButtonEvent() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = menuOverview.getSelectedRow();

                int id = Integer.parseInt(menuOverview.getValueAt(row, 0).toString());

                Menu menu = new Menu();

                menu.deleteMenu(id);

                tableDemo.removeRow(row);
            }
        });
    }

    public static void main(String[] args) throws SQLException {
        MenuOverview view = new MenuOverview();
        JFrame frame = new JFrame();
        frame.setSize(600, 400);
        frame.add(view);
        frame.setVisible(true);
        String ok = "";
    }

}
