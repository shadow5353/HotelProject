package GUI;

import Domain.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.math.BigDecimal;

/**
 * Created by Bruger on 25-04-2017.
 */
public class AddMenu extends JPanel {
    private JLabel headlineLabel, dishNameLabel, dishDesriptionLabel, dishPriceLabel;
    private JTextField dishNameTextField, dishPriceTextfield;
    private JTextArea dishDescriptionArea;
    private JButton addMenuButton;

    public AddMenu() {

        this.setLayout(new GridBagLayout());
        Dimension sizeOfLabel = new Dimension(130, 18);
        GridBagConstraints c = new GridBagConstraints();
        jLabels(sizeOfLabel, c);
        jTextFields(c);
        createJTextArea(c);
        createJButton(c);
    }

    public void jLabels(Dimension sizeOfLabel, GridBagConstraints c){
        headlineLabel = new JLabel("Create a new dish");
        headlineLabel.setFont(new Font("Times new roman", Font.BOLD, 45));
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 25, 0);
        this.add(headlineLabel, c);

        c.insets = new Insets(0, 10, 8, 0);
        dishNameLabel = new JLabel("Name: ", SwingConstants.RIGHT);
        dishNameLabel.setPreferredSize(sizeOfLabel);
        c.gridy = 2;
        c.gridwidth = 1;
        this.add(dishNameLabel, c);

        dishDesriptionLabel = new JLabel("Description: ", SwingConstants.RIGHT);
        dishDesriptionLabel.setPreferredSize(sizeOfLabel);
        c.gridy = 3;
        this.add(dishDesriptionLabel, c);

        dishPriceLabel = new JLabel("Price: ", SwingConstants.RIGHT);
        dishPriceLabel.setPreferredSize(sizeOfLabel);
        c.gridy = 4;
        this.add(dishPriceLabel, c);

    }
    private void jTextFields(GridBagConstraints c){
        Dimension sizeOfField = new Dimension(200, 25);
        dishNameTextField = new JTextField("Name of the dish");
        dishNameTextField.setPreferredSize(sizeOfField);
        dishNameTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                dishNameTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (dishNameTextField.getText().isEmpty()) {
                    dishNameTextField.setText("Name of the dish");
                }
            }
        });
        c.gridx = 2;
        c.gridy = 2;
        this.add(dishNameTextField, c);

        dishPriceTextfield = new JTextField("Price");
        dishPriceTextfield.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                dishPriceTextfield.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (dishPriceTextfield.getText().isEmpty()) {
                    dishPriceTextfield.setText("Price");
                }
            }
        });
        dishPriceTextfield.setPreferredSize(sizeOfField);
        c.gridy = 4;
        this.add(dishPriceTextfield, c);
    }
    public void createJTextArea(GridBagConstraints c){
        Dimension sizeOfField = new Dimension(200, 125);
        dishDescriptionArea = new JTextArea("Insert dish description", 1, 1);
        dishDescriptionArea.setPreferredSize(sizeOfField);
        dishDescriptionArea.setLineWrap(true);
        dishDescriptionArea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                dishDescriptionArea.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (dishDescriptionArea.getText().isEmpty()) {
                    dishDescriptionArea.setText("Insert dish description");
                }
            }
        });
        //dishPriceTextfield.setPreferredSize(sizeOfField);
        c.gridy = 3;
        this.add(dishDescriptionArea, c);
    }
    public void createJButton(GridBagConstraints c){
        addMenuButton = new JButton("Add dish to the menu");
        class AddMenuEvent implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dishName = dishNameTextField.getText();
                String dishDescription = dishDescriptionArea.getText();
                BigDecimal price = new BigDecimal(dishPriceTextfield.getText());

                Menu menu = new Menu();
                menu.addDish(dishName, dishDescription, price);
            }
        }
        AddMenuEvent addUser = new AddMenuEvent();
        addMenuButton.addActionListener(addUser);
        c.gridy = 7;
        this.add(addMenuButton, c);

    }
}
