package GUI;

import Domain.Customer;
import Domain.Service;
import Domain.ServiceOrder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Jacob on 26-04-2017.
 */
public class OrderService extends JPanel {
    private javax.swing.JComboBox<String> customerIDs;
    private javax.swing.JLabel customerLabel;
    private javax.swing.JLabel headline;
    private javax.swing.JButton orderServiceButton;
    private javax.swing.JComboBox<String> serviceIDs;
    private javax.swing.JLabel serviceLabel;
    private Customer customer = new Customer();
    private Service service = new Service();

    public OrderService() {
        initComponents();

        addServiceIDs();
        addCustomerIDs();
    }

    private void addCustomerIDs() {
        ArrayList<Integer> ids = customer.getCustomerIDs();
        for(int id : ids) {
            customerIDs.addItem(id + "");
        }
    }

    private void addServiceIDs() {
        ArrayList<Integer> ids = service.serviceIDs();

        for(int id : ids) {
            serviceIDs.addItem(id + "");
        }
    }

    private void orderServiceButtonEvent() {
        orderServiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int customerID = Integer.parseInt(customerIDs.getName());
                int serviceID = Integer.parseInt(serviceIDs.getName());

                ServiceOrder serviceOrder = new ServiceOrder();

                serviceOrder.insertServiceOrder(serviceID, customerID);
            }
        });
    }

    private void initComponents() {

        headline = new javax.swing.JLabel();
        customerIDs = new javax.swing.JComboBox<>();
        customerLabel = new javax.swing.JLabel();
        serviceIDs = new javax.swing.JComboBox<>();
        serviceLabel = new javax.swing.JLabel();
        orderServiceButton = new javax.swing.JButton();

        headline.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        headline.setText("Order Service");

        customerLabel.setText("Customer");

        serviceLabel.setText("Service");

        orderServiceButton.setText("Order Service");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(252, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(serviceLabel)
                                        .addComponent(customerLabel)
                                        .addComponent(headline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(customerIDs, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(serviceIDs, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(orderServiceButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(257, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headline)
                                .addGap(51, 51, 51)
                                .addComponent(customerLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customerIDs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(serviceLabel)
                                .addGap(7, 7, 7)
                                .addComponent(serviceIDs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(orderServiceButton)
                                .addContainerGap(200, Short.MAX_VALUE))
        );
    }
}
