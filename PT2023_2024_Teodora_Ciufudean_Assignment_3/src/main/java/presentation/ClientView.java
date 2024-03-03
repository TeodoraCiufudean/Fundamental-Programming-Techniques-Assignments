package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The view class for managing clients.
 */
public class ClientView extends JFrame {
    private JTextField idTextField; // Text field for entering client ID
    private JTextField nameTextField; // Text field for entering client name
    private JTextField ageTextField; // Text field for entering client age
    private JTextField addressTextField; // Text field for entering client address
    private JButton backButton; // Button for navigating back
    private JButton addButton; // Button for adding a client
    private JButton btnDelete; // Button for deleting a client
    private JButton btnViewAll; // Button for viewing all clients
    private JButton btnEdit; // Button for editing a client
    private static JTextArea textArea; // Text area for displaying client information
    private JScrollPane scrollPane; // Scroll pane for the text area

    /**
     * Constructs a new ClientView.
     */

    public ClientView(){
        // Set frame properties
        this.getContentPane().setBackground(new Color(238, 130, 238));
        this.setBounds(100, 100, 1078, 692);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        // Create and configure UI components

        JLabel lblNewLabel = new JLabel("CLIENT");
        lblNewLabel.setForeground(new Color(138, 43, 226));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(387, 45, 327, 44);

        // Add UI components to the frame
        this.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("ID");
        lblNewLabel_1.setForeground(new Color(138, 43, 226));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(120, 176, 93, 28);
        this.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Name");
        lblNewLabel_1_1.setForeground(new Color(138, 43, 226));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(120, 214, 93, 28);
        this.getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Age");
        lblNewLabel_1_2.setForeground(new Color(138, 43, 226));
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_2.setBounds(120, 252, 93, 28);
        this.getContentPane().add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("Address");
        lblNewLabel_1_3.setForeground(new Color(138, 43, 226));
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_3.setBounds(120, 295, 93, 28);
        this.getContentPane().add(lblNewLabel_1_3);

        idTextField = new JTextField();
        idTextField.setBounds(189, 176, 96, 26);
        this.getContentPane().add(idTextField);
        idTextField.setColumns(10);

        nameTextField = new JTextField();
        nameTextField.setColumns(10);
        nameTextField.setBounds(189, 214, 96, 26);
        this.getContentPane().add(nameTextField);

        ageTextField = new JTextField();
        ageTextField.setColumns(10);
        ageTextField.setBounds(189, 252, 96, 26);
        this.getContentPane().add(ageTextField);

        addressTextField = new JTextField();
        addressTextField.setColumns(10);
        addressTextField.setBounds(189, 290, 96, 26);
        this.getContentPane().add(addressTextField);

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

    // Getters and setters for text fields

    /**
     * Get the value of the ID text field.
     *
     * @return The ID entered in the text field.
     */
    public int getIdTextField() {
        return Integer.parseInt(idTextField.getText());
    }

    /**
     * Set the value of the ID text field.
     *
     * @param idTextField The ID to set in the text field.
     */
    public void setIdTextField(int idTextField) {
        this.idTextField.setText(String.valueOf(idTextField));
    }

    /**
     * Get the value of the name text field.
     *
     * @return The name entered in the text field.
     */
    public String getNameTextField() {
        return nameTextField.getText();
    }

    /**
     * Set the value of the name text field.
     *
     * @param nameTextField The name to set in the text field.
     */
    public void setNameTextField(String nameTextField) {
        this.nameTextField.setText(nameTextField);
    }

    /**
     * Get the value of the age text field.
     *
     * @return The age entered in the text field.
     */
    public int getAgeTextField() {
        return Integer.parseInt(ageTextField.getText());
    }

    /**
     * Set the value of the age text field.
     *
     * @param ageTextField The age to set in the text field.
     */
    public void setAgeTextField(int ageTextField) {
        this.ageTextField.setText(String.valueOf(ageTextField));
    }

    /**
     * Get the value of the address text field.
     *
     * @return The address entered in the text field.
     */
    public String getAddressTextField() {
        return addressTextField.getText();
    }

    /**
     * Set the value of the address text field.
     *
     * @param addressTextField The address to set in the text field.
     */
    public void setAddressTextField(String addressTextField) {
        this.addressTextField.setText(addressTextField);
    }

    /**
     * Get the text area component.
     *
     * @return The JTextArea component.
     */
    public static JTextArea getTextArea() {
        return textArea;
    }

    /**
     * Set the text area component.
     *
     * @param textArea The JTextArea component.
     */
    public static void setTextArea(JTextArea textArea) {
        ClientView.textArea = textArea;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    /**
     * Add an action listener to the Add button.
     *
     * @param actionListener The action listener to add.
     */
    public void addAddButtonListener(ActionListener actionListener){
        addButton.addActionListener(actionListener);
    }

    /**
     * Add an action listener to the Delete button.
     *
     * @param actionListener The action listener to add.
     */
    public void addDeleteButtonListener(ActionListener actionListener){
        btnDelete.addActionListener(actionListener);
    }

    /**
     * Add an action listener to the Edit button.
     *
     * @param actionListener The action listener to add.
     */
    public void addEditButtonListener(ActionListener actionListener){
        btnEdit.addActionListener(actionListener);
    }

    /**
     * Add an action listener to the View All button.
     *
     * @param actionListener The action listener to add.
     */
    public void addViewAllButtonListener(ActionListener actionListener){
        btnViewAll.addActionListener(actionListener);
    }

    public void addBackButtonListener(ActionListener actionListener){
        backButton.addActionListener(actionListener);
    }

    /**
     * Show an information message dialog.
     *
     * @param message The message to display.
     */
    public void showInfoMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        refresh();
    }


    /**
     * Refresh the view by clearing the text fields.
     */
    public void refresh(){
        nameTextField.setText(null);
        ageTextField.setText(null);
        addressTextField.setText(null);
        idTextField.setText(null);
    }

}
