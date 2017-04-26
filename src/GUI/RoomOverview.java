package GUI;

import Domain.Room;
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
public class RoomOverview extends JPanel {
    private JButton updateButton, deleteButton;
    private JLabel headline;
    private JScrollPane jScrollPane1;
    private JTable roomsTable;
    private DefaultTableModel jtModel;
    private String[] tableColumnName = {"Room ID", "Room Size", "Description", "Price"};
    private String[][] tableData = {};
    private DBFacade dbFacade = new DBFacade();

    public RoomOverview() {
        initComponents();
        getRoomOverview();
        updateButtonEvent();
        deleteButtonEvent();
    }

    private void getRoomOverview() {
        try {
            CallableStatement cl = dbFacade.callableStatement("{call roomOverview}");

            ResultSet rs = cl.executeQuery();

            while(rs.next()) {
                int roomID = rs.getInt(1);
                String roomSize = rs.getString(2);
                String description = rs.getString(3);
                BigDecimal price = rs.getBigDecimal(4);

                Object[] newLine = {roomID, roomSize, description, price};

                jtModel.addRow(newLine);
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    private void updateButtonEvent() {
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = roomsTable.getSelectedRow();

                int roomID = Integer.parseInt(roomsTable.getValueAt(row, 0).toString());
                String roomSize = roomsTable.getValueAt(row, 1).toString();
                String description = roomsTable.getValueAt(row, 2).toString();
                BigDecimal price = new BigDecimal(roomsTable.getValueAt(row, 3).toString());

                Room room = new Room();

                room.updateRoom(roomID, roomSize, description, price);
            }
        });
    }

    private void deleteButtonEvent() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = roomsTable.getSelectedRow();

                int roomID = Integer.parseInt(roomsTable.getValueAt(row, 0).toString());

                Room room = new Room();

                room.deleteRoom(roomID);

                jtModel.removeRow(row);
            }
        });
    }

    private void initComponents() {
        headline = new JLabel();
        jScrollPane1 = new JScrollPane();
        jtModel = new DefaultTableModel(tableData, tableColumnName);
        roomsTable = new JTable(jtModel);
        updateButton = new JButton();
        deleteButton = new JButton();

        roomsTable.setAutoCreateRowSorter(true);

        headline.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        headline.setText("Room Overview");

        jScrollPane1.setViewportView(roomsTable);

        deleteButton.setText("Delete Room");
        updateButton.setText("Update Room");

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
