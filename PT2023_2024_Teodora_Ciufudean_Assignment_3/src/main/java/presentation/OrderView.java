package presentation;

import bll.ClientBll;
import bll.ProductBll;
import model.Client;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;

/**
 * The view for managing orders.
 */
public class OrderView extends JFrame {
    private JTextField orderNoTextField;
    private JTextField quantityTextField;
    private JButton backButton;
    private JButton addButton;
    //private JButton deleteButton;
    private JButton viewAllButton;
    //private JButton editButton;
    private JButton billButton;
    private static JTextArea textArea;
    JComboBox clientComboBox;
    JComboBox productComboBox;
    private static JScrollPane scrollPane;
    private ClientBll clientBll = new ClientBll();
    private ProductBll productBll = new ProductBll();


    /**
     * Creates a new instance of the OrderView.
     */

    public OrderView(){
        this.getContentPane().setBackground(new Color(123, 104, 238));
        this.setBounds(100, 100, 1099, 679);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("ORDER");
        lblNewLabel.setForeground(new Color(238, 130, 238));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(429, 34, 234, 57);
        this.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("OrderNo");
        lblNewLabel_1.setForeground(new Color(238, 130, 238));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(107, 153, 91, 25);
        this.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Client ID");
        lblNewLabel_1_1.setForeground(new Color(238, 130, 238));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(107, 188, 91, 25);
        this.getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Product ID");
        lblNewLabel_1_2.setForeground(new Color(238, 130, 238));
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_2.setBounds(107, 223, 91, 25);
        this.getContentPane().add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("Quantity");
        lblNewLabel_1_3.setForeground(new Color(238, 130, 238));
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_3.setBounds(107, 258, 91, 25);
        this.getContentPane().add(lblNewLabel_1_3);

        orderNoTextField = new JTextField();
        orderNoTextField.setBounds(198, 153, 104, 24);
        this.getContentPane().add(orderNoTextField);
        orderNoTextField.setColumns(10);

        quantityTextField = new JTextField();
        quantityTextField.setColumns(10);
        quantityTextField.setBounds(198, 257, 104, 24);
        this.getContentPane().add(quantityTextField);

        addButton = new JButton("ADD");
        addButton.setBackground(new Color(238, 130, 238));
        addButton.setForeground(new Color(123, 104, 238));
        addButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        addButton.setBounds(798, 153, 141, 40);
        this.getContentPane().add(addButton);

        viewAllButton = new JButton("VIEW ALL");
        viewAllButton.setForeground(new Color(123, 104, 238));
        viewAllButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        viewAllButton.setBackground(new Color(238, 130, 238));
        viewAllButton.setBounds(798, 243, 141, 40);
        this.getContentPane().add(viewAllButton);

        billButton = new JButton("BILL");
        billButton.setForeground(new Color(123, 104, 238));
        billButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        billButton.setBackground(new Color(238, 130, 238));
        billButton.setBounds(561, 192, 141, 40);
        this.getContentPane().add(billButton);

        clientComboBox = new JComboBox<>();
        List<Client> clientList = new ArrayList<>();
        clientList.addAll(clientBll.viewAllClients());
        for(Client client : clientList) {
            clientComboBox.addItem(client.getId());
        }
        clientComboBox.setBounds(198, 192, 104, 21);
        this.getContentPane().add(clientComboBox);

        productComboBox = new JComboBox();
        List<Product> productList = new ArrayList<>();
        productList.addAll(productBll.viewAllProducts());
        for(Product product : productList) {
            productComboBox.addItem(product.getId());
        }
        productComboBox.setBounds(198, 223, 104, 21);
        this.getContentPane().add(productComboBox);

        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textArea = new JTextArea();
        textArea.setBounds(107, 341, 832, 268);
        scrollPane.setBounds(107, 341, 832, 268);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.getViewport().add(textArea);
        this.getContentPane().add(scrollPane);

        backButton = new JButton("BACK");
        backButton.setForeground(new Color(123, 104, 238));
        backButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        backButton.setBackground(new Color(238, 130, 238));
        backButton.setBounds(10, 10, 96, 32);
        this.getContentPane().add(backButton);
        //this.setVisible(true);
    }

    /**
     * Gets the value of the order number from the text field.
     *
     * @return the order number
     */
    public int getOrderNoTextField() {
        return Integer.parseInt(orderNoTextField.getText());
    }

    /**
     * Sets the value of the order number text field.
     *
     * @param orderNoTextField the order number to set
     */
    public void setOrderNoTextField(int orderNoTextField) {
        this.orderNoTextField.setText(String.valueOf(orderNoTextField));
    }

    /**
     * Gets the value of the quantity from the text field.
     *
     * @return the quantity
     */
    public int getQuantityTextField() {
        return Integer.parseInt(quantityTextField.getText());
    }

    /**
     * Sets the value of the quantity text field.
     *
     * @param quantityTextField the quantity to set
     */
    public void setQuantityTextField(int quantityTextField) {
        this.quantityTextField.setText(String.valueOf(quantityTextField));
    }

    /**
     * Gets the text area component.
     *
     * @return the text area
     */
    public static JTextArea getTextArea() {
        return textArea;
    }

    /**
     * Sets the text area component.
     *
     * @param textArea the text area to set
     */
    public static void setTextArea(JTextArea textArea) {
        OrderView.textArea = textArea;
    }

    /**
     * Gets the client combo box component.
     *
     * @return the client combo box
     */
    public JComboBox getClientComboBox() {
        return clientComboBox;
    }

    /**
     * Sets the client combo box component.
     *
     * @param clientComboBox the client combo box to set
     */
    public void setClientComboBox(JComboBox clientComboBox) {
        this.clientComboBox = clientComboBox;
    }

    /**
     * Gets the product combo box component.
     *
     * @return the product combo box
     */
    public JComboBox getProductComboBox() {
        return productComboBox;
    }

    /**
     * Sets the product combo box component.
     *
     * @param productComboBox the product combo box to set
     */
    public void setProductComboBox(JComboBox productComboBox) {
        this.productComboBox = productComboBox;
    }

    /**
     * Gets the scroll pane component.
     *
     * @return the scroll pane
     */
    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    /**
     * Sets the scroll pane component.
     *
     * @param scrollPane the scroll pane to set
     */
    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    /**
     * Adds an ActionListener to the add button.
     *
     * @param actionListener the ActionListener to be added
     */
    public void addAddButtonListener(ActionListener actionListener){
        addButton.addActionListener(actionListener);
    }

    /**
     * Adds an ActionListener to the view all button.
     *
     * @param actionListener the ActionListener to be added
     */
    public void addViewAllButtonListener(ActionListener actionListener){
        viewAllButton.addActionListener(actionListener);
    }
    /**
     * Adds an ActionListener to the back button.
     *
     * @param actionListener the ActionListener to be added
     */
    public void addBackButtonListener(ActionListener actionListener){
        backButton.addActionListener(actionListener);
    }

    /**
     * Adds an ActionListener to the bill button.
     *
     * @param actionListener the ActionListener to be added
     */
    public void addBillButtonListener (ActionListener actionListener) {billButton.addActionListener(actionListener);}

    /**
     * Displays an information message dialog.
     *
     * @param message the message to display
     */
    public void showInfoMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        refresh();
    }
    /**
     * Refreshes the view by clearing input fields and selections.
     */


    public void refresh(){
        orderNoTextField.setText(null);
        quantityTextField.setText(null);
        clientComboBox.setSelectedItem(null);
        productComboBox.setSelectedItem(null);
    }
}
