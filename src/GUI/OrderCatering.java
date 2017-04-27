package GUI;

import Domain.Catering;
import Domain.CateringOrder;
import Domain.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Jacob on 26-04-2017.
 */
public class OrderCatering extends JPanel {
    private JComboBox<String> customerIDs;
    private JLabel customerLabel;
    private JLabel headline;
    private JButton orderCateringButton;
    private JComboBox<String> cateringIDs;
    private JLabel orderLabel;
    private Customer customer = new Customer();
    private Catering catering = new Catering();

    public OrderCatering() {
        initComponents();
        addCustomerIDs();
        addCateringIDs();

        orderCateringButtonEvent();
    }

    private void addCustomerIDs() {
        ArrayList<Integer> ids = customer.getCustomerIDs();
        for(int id : ids) {
            customerIDs.addItem(id + "");
        }
    }

    private void addCateringIDs() {
        ArrayList<Integer> ids = catering.cateringIDs();
        for(int id : ids) {
            cateringIDs.addItem(id + "");
        }
    }

    private void orderCateringButtonEvent() {
        orderCateringButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int customerID = Integer.parseInt(customerIDs.getSelectedItem().toString());
                int cateringID = Integer.parseInt(cateringIDs.getSelectedItem().toString());

                CateringOrder cateringOrder = new CateringOrder();

                cateringOrder.insertCateringOrder(cateringID, customerID);
            }
        });
    }

    private void initComponents() {

        headline = new JLabel();
        customerIDs = new JComboBox<>();
        customerLabel = new JLabel();
        cateringIDs = new JComboBox<>();
        orderLabel = new JLabel();
        orderCateringButton = new JButton();

        headline.setFont(new Font("Dialog", 1, 25)); // NOI18N
        headline.setText("Order Catering");

        customerLabel.setText("Customer");

        orderLabel.setText("Catering");

        orderCateringButton.setText("Order Catering");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(252, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(orderLabel)
                                        .addComponent(customerLabel)
                                        .addComponent(headline, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(customerIDs, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cateringIDs, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(orderCateringButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(257, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headline)
                                .addGap(51, 51, 51)
                                .addComponent(customerLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customerIDs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(orderLabel)
                                .addGap(7, 7, 7)
                                .addComponent(cateringIDs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(orderCateringButton)
                                .addContainerGap(200, Short.MAX_VALUE))
        );
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(400, 400));
        OrderCatering orderCatering = new OrderCatering();
        frame.add(orderCatering);
    }
}

