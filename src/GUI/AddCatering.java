package GUI;

import Domain.Catering;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.math.BigDecimal;

/**
 * Created by Bruger on 26-04-2017.
 */
public class AddCatering extends JPanel {
    private JLabel headlineLabel, basketNameLabel, basketDescriptionLabel, basketPriceLabel;
    private JTextField basketNameTextField, basketPriceTextfield;
    private JTextArea basketDescriptionArea;
    private JButton addCateringButton;

    public AddCatering() {

        this.setLayout(new GridBagLayout());
        Dimension sizeOfLabel = new Dimension(130, 18);
        GridBagConstraints c = new GridBagConstraints();
        //this.add(new JLabel("lllll"));
        jLabels(sizeOfLabel, c);
        jTextFields(c);
        createJTextArea(c);
        createJButton(c);
    }

    public void jLabels(Dimension sizeOfLabel, GridBagConstraints c) {
        headlineLabel = new JLabel("Add a new basket");
        headlineLabel.setFont(new Font("Times new roman", Font.BOLD, 45));
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 25, 0);
        this.add(headlineLabel, c);

        c.insets = new Insets(0, 10, 8, 0);
        basketNameLabel = new JLabel("Name: ", SwingConstants.RIGHT);
        basketNameLabel.setPreferredSize(sizeOfLabel);
        c.gridy = 2;
        c.gridwidth = 1;
        this.add(basketNameLabel, c);

        basketDescriptionLabel = new JLabel("Description: ", SwingConstants.RIGHT);
        basketDescriptionLabel.setPreferredSize(sizeOfLabel);
        c.gridy = 3;
        this.add(basketDescriptionLabel, c);

        basketPriceLabel = new JLabel("Price: ", SwingConstants.RIGHT);
        basketPriceLabel.setPreferredSize(sizeOfLabel);
        c.gridy = 4;
        this.add(basketPriceLabel, c);

    }

    private void jTextFields(GridBagConstraints c) {

        Dimension sizeOfField = new Dimension(200, 25);
        basketNameTextField = new JTextField("Name of the basket");
        basketNameTextField.setPreferredSize(sizeOfField);
        basketNameTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                basketNameTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (basketNameTextField.getText().isEmpty()) {
                    basketNameTextField.setText("Name of the basket");
                }
            }
        });
        c.gridx = 2;
        c.gridy = 2;
        this.add(basketNameTextField, c);

        basketPriceTextfield = new JTextField("Price");
        basketPriceTextfield.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                basketPriceTextfield.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (basketPriceTextfield.getText().isEmpty()) {
                    basketPriceTextfield.setText("Price");
                }
            }
        });
        basketPriceTextfield.setPreferredSize(sizeOfField);
        c.gridy = 4;
        this.add(basketPriceTextfield, c);
    }

    public void createJTextArea(GridBagConstraints c) {
        Dimension sizeOfField = new Dimension(200, 125);
        basketDescriptionArea = new JTextArea("Insert basket description", 1, 1);
        basketDescriptionArea.setPreferredSize(sizeOfField);
        basketDescriptionArea.setLineWrap(true);
        basketDescriptionArea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                basketDescriptionArea.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (basketDescriptionArea.getText().isEmpty()) {
                    basketDescriptionArea.setText("Insert basket description");
                }
            }
        });
        //basketPriceTextfield.setPreferredSize(sizeOfField);
        c.gridy = 3;
        this.add(basketDescriptionArea, c);
    }

    public void createJButton(GridBagConstraints c) {
        addCateringButton = new JButton("Add the basket to the catering");
        class AddMenuEvent implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String basketName = basketNameTextField.getText();
                String dishDescription = basketDescriptionArea.getText();
                BigDecimal price = new BigDecimal(basketPriceTextfield.getText());

                Catering catering = new Catering();
                catering.addBasket(basketName, dishDescription, price);
            }
        }
        AddMenuEvent addUser = new AddMenuEvent();
        addCateringButton.addActionListener(addUser);
        c.gridy = 8;
        this.add(addCateringButton, c);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(new Dimension(600, 600));
        AddCatering addCatering = new AddCatering();
        frame.add(addCatering);
    }
}


