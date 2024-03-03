package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The view for managing products.
 */
public class ProductView extends JFrame {
    private JTextField idTextField;
    private JTextField nameTextField;
    private JTextField stockTextField;
    private JButton backButton;
    private JButton addButton;
    private JButton btnDelete;
    private JButton btnViewAll;
    private JButton btnEdit;
    private static JTextArea textArea;
    private JScrollPane scrollPane;

    /**
     * Creates a new instance of the ProductView.
     */
    public ProductView(){
        this.getContentPane().setBackground(new Color(238, 130, 238));
        this.setBounds(100, 100, 1078, 692);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("PRODUCT");
        lblNewLabel.setForeground(new Color(138, 43, 226));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(387, 45, 327, 44);
        this.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("ID");
        lblNewLabel_1.setForeground(new Color(138, 43, 226));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(120, 176, 93, 28);
        this.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Name");
        lblNewLabel_1_1.setForeground(new Color(138, 43, 226));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(120, 231, 93, 28);
        this.getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Stock");
        lblNewLabel_1_2.setForeground(new Color(138, 43, 226));
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_2.setBounds(120, 285, 93, 28);
        this.getContentPane().add(lblNewLabel_1_2);

        idTextField = new JTextField();
        idTextField.setBounds(189, 176, 96, 26);
        this.getContentPane().add(idTextField);
        idTextField.setColumns(10);

        nameTextField = new JTextField();
        nameTextField.setColumns(10);
        nameTextField.setBounds(189, 235, 96, 26);
        this.getContentPane().add(nameTextField);

        stockTextField = new JTextField();
        stockTextField.setColumns(10);
        stockTextField.setBounds(189, 287, 96, 26);
        this.getContentPane().add(stockTextField);

        backButton = new JButton("BACK");
        backButton.setBackground(new Color(138, 43, 226));
        backButton.setForeground(new Color(238, 130, 238));
        backButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        backButton.setBounds(20, 10, 80, 28);
        this.getContentPane().add(backButton);

        addButton = new JButton("ADD");
        addButton.setBackground(new Color(138, 43, 226));
        addButton.setForeground(new Color(238, 130, 238));
        addButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        addButton.setBounds(479, 182, 126, 38);
        this.getContentPane().add(addButton);

        btnDelete = new JButton("DELETE");
        btnDelete.setForeground(new Color(238, 130, 238));
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnDelete.setBackground(new Color(138, 43, 226));
        btnDelete.setBounds(785, 182, 126, 38);
        this.getContentPane().add(btnDelete);

        btnEdit = new JButton("EDIT");
        btnEdit.setForeground(new Color(238, 130, 238));
        btnEdit.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnEdit.setBackground(new Color(138, 43, 226));
        btnEdit.setBounds(544, 278, 126, 38);
        this.getContentPane().add(btnEdit);

        btnViewAll = new JButton("VIEW ALL");
        btnViewAll.setForeground(new Color(238, 130, 238));
        btnViewAll.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnViewAll.setBackground(new Color(138, 43, 226));
        btnViewAll.setBounds(727, 278, 126, 38);
        this.getContentPane().add(btnViewAll);

        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textArea = new JTextArea();
        textArea.setBounds(120, 363, 791, 266);
        scrollPane.setBounds(120, 363, 791, 266);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.getViewport().add(textArea);
        this.getContentPane().add(scrollPane);

        //this.setVisible(true);
    }

    /**
     * Retrieves the value from the ID text field.
     *
     * @return the value of the ID text field
     */
    public int getIdTextField() {
        return Integer.parseInt(idTextField.getText());
    }

    /**
     * Sets the value of the ID text field.
     *
     * @param idTextField the value to set
     */
    public void setIdTextField(int idTextField) {
        this.idTextField.setText(String.valueOf(idTextField));
    }

    /**
     * Retrieves the value from the Name text field.
     *
     * @return the value of the Name text field
     */
    public String getNameTextField() {
        return nameTextField.getText();
    }

    /**
     * Sets the value of the Name text field.
     *
     * @param nameTextField the value to set
     */
    public void setNameTextField(String nameTextField) {
        this.nameTextField.setText(nameTextField);
    }

    /**
     * Retrieves the value from the Stock text field.
     *
     * @return the value of the Stock text field
     */
    public int getStockTextField() {
        return Integer.parseInt(stockTextField.getText());
    }

    /**
     * Sets the value of the Stock text field.
     *
     * @param stockTextField the value to set
     */
    public void setStockTextField(int stockTextField) {
        this.stockTextField.setText(String.valueOf(stockTextField));
    }

    /**
     * Retrieves the text area component.
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
        ProductView.textArea = textArea;
    }

    /**
     * Retrieves the scroll pane component.
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
     * Adds an action listener to the Add button.
     *
     * @param actionListener the action listener to add
     */
    public void addAddButtonListener(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    /**
     * Adds an action listener to the Delete button.
     *
     * @param actionListener the action listener to add
     */
    public void addDeleteButtonListener(ActionListener actionListener) {
        btnDelete.addActionListener(actionListener);
    }

    /**
     * Adds an action listener to the Edit button.
     *
     * @param actionListener the action listener to add
     */
    public void addEditButtonListener(ActionListener actionListener) {
        btnEdit.addActionListener(actionListener);
    }

    /**
     * Adds an action listener to the View All button.
     *
     * @param actionListener the action listener to add
     */
    public void addViewAllButtonListener(ActionListener actionListener) {
        btnViewAll.addActionListener(actionListener);
    }

    /**
     * Adds an action listener to the Back button.
     *
     * @param actionListener the action listener to add
     */
    public void addBackButtonListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    /**
     * Displays an information message dialog with the given message.
     *
     * @param message the message to display
     */
    public void showInfoMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        refresh();
    }

    /**
     * Refreshes the text fields by clearing their values.
     */
    public void refresh() {
        nameTextField.setText(null);
        stockTextField.setText(null);
        idTextField.setText(null);
    }
}