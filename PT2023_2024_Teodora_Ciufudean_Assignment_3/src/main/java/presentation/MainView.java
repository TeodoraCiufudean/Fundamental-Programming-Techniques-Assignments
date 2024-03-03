package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The main view of the Orders Management application.
 */
public class MainView extends JFrame {
    private JButton productButton;
    private JButton orderButton;
    private JButton clientButton;

    /**
     * Creates a new instance of the MainView.
     */
    public MainView() {
        this.getContentPane().setEnabled(false);
        this.getContentPane().setBackground(new Color(123, 104, 238));
        this.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("ORDERS MANAGEMENT");
        lblNewLabel.setForeground(new Color(238, 130, 238));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(320, 43, 372, 63);
        this.getContentPane().add(lblNewLabel);

        productButton = new JButton("Product");
        productButton.setForeground(new Color(238, 130, 238));
        productButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        productButton.setBounds(667, 205, 182, 49);
        this.getContentPane().add(productButton);

        orderButton = new JButton("Order");
        orderButton.setForeground(new Color(238, 130, 238));
        orderButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        orderButton.setBounds(422, 295, 182, 49);
        this.getContentPane().add(orderButton);

        clientButton = new JButton("Client");
        clientButton.setForeground(new Color(238, 130, 238));
        clientButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        clientButton.setBounds(177, 205, 182, 49);
        this.getContentPane().add(clientButton);
        this.setBounds(100, 100, 1005, 556);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Adds an ActionListener to the client button.
     *
     * @param actionListener the ActionListener to be added
     */
    public void addClientButtonListener(ActionListener actionListener) {
        clientButton.addActionListener(actionListener);
    }

    /**
     * Adds an ActionListener to the product button.
     *
     * @param actionListener the ActionListener to be added
     */
    public void addProductButtonListener(ActionListener actionListener) {
        productButton.addActionListener(actionListener);
    }

    /**
     * Adds an ActionListener to the order button.
     *
     * @param actionListener the ActionListener to be added
     */
    public void addOrderButtonListener(ActionListener actionListener) {
        orderButton.addActionListener(actionListener);
    }
}
