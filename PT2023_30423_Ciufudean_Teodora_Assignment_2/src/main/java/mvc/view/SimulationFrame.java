package mvc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SimulationFrame extends JFrame {
    private JTextField clientsTextField;
    private JTextField queuesTextField;
    private JTextField simulationTextField;
    private JTextField minArrivalTextField;
    private JTextField maxArrivalTextField;
    private JTextField minServiceTextField;
    private JTextField maxServiceTextField;
    private static JTextArea textArea;
    private static JScrollPane scrollPane;
    private JButton startButton;
    JComboBox comboBox;

    public SimulationFrame(){
        this.getContentPane().setBackground(new Color(220, 20, 60));
        this.setBounds(100, 100, 1102, 664);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel titleLbl = new JLabel("Queues Management Application");
        titleLbl.setForeground(new Color(0, 0, 0));
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        titleLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
        titleLbl.setBounds(352, 47, 415, 34);
        this.getContentPane().add(titleLbl);

        JLabel lbl1 = new JLabel("Clients");
        lbl1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl1.setBounds(57, 188, 60, 24);
        this.getContentPane().add(lbl1);

        clientsTextField = new JTextField();
        clientsTextField.setBounds(120, 193, 46, 19);
        this.getContentPane().add(clientsTextField);
        clientsTextField.setColumns(10);

        JLabel lbl2 = new JLabel("Queues");
        lbl2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl2.setBounds(231, 188, 60, 24);
        this.getContentPane().add(lbl2);

        queuesTextField = new JTextField();
        queuesTextField.setColumns(10);
        queuesTextField.setBounds(301, 193, 46, 19);
        this.getContentPane().add(queuesTextField);

        JLabel lbl4 = new JLabel("MIN Arrival Time");
        lbl4.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl4.setBounds(57, 283, 130, 34);
        this.getContentPane().add(lbl4);

        JLabel lbl3 = new JLabel("Simulation Interval");
        lbl3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl3.setBounds(57, 239, 148, 34);
        this.getContentPane().add(lbl3);

        JLabel lbl5 = new JLabel("MAX Arrival Time");
        lbl5.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl5.setBounds(57, 331, 137, 34);
        this.getContentPane().add(lbl5);

        JLabel lbl6 = new JLabel("MIN Service Time");
        lbl6.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl6.setBounds(57, 375, 137, 34);
        this.getContentPane().add(lbl6);

        JLabel lbl7 = new JLabel("MAX Service Time");
        lbl7.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl7.setBounds(57, 419, 137, 34);
        this.getContentPane().add(lbl7);

        simulationTextField = new JTextField();
        simulationTextField.setColumns(10);
        simulationTextField.setBounds(215, 249, 46, 19);
        this.getContentPane().add(simulationTextField);

        minArrivalTextField = new JTextField();
        minArrivalTextField.setColumns(10);
        minArrivalTextField.setBounds(215, 293, 46, 19);
        this.getContentPane().add(minArrivalTextField);

        maxArrivalTextField = new JTextField();
        maxArrivalTextField.setColumns(10);
        maxArrivalTextField.setBounds(215, 341, 46, 19);
        this.getContentPane().add(maxArrivalTextField);

        minServiceTextField = new JTextField();
        minServiceTextField.setColumns(10);
        minServiceTextField.setBounds(215, 385, 46, 19);
        this.getContentPane().add(minServiceTextField);

        maxServiceTextField = new JTextField();
        maxServiceTextField.setColumns(10);
        maxServiceTextField.setBounds(215, 429, 46, 19);
        this.getContentPane().add(maxServiceTextField);

        startButton = new JButton("START");
        startButton.setForeground(new Color(255, 255, 255));
        startButton.setBackground(new Color(0, 0, 0));
        startButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        startButton.setBounds(225, 509, 122, 42);
        this.getContentPane().add(startButton);

        //this.getContentPane().add(textArea);
        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textArea = new JTextArea();
        textArea.setBounds(494, 146, 552, 437);
        scrollPane.setBounds(494, 146, 552, 437);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.getViewport().add(textArea);
        this.getContentPane().add(scrollPane);

        JLabel lbl8 = new JLabel("Policy");
        lbl8.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl8.setBounds(57, 464, 60, 24);
        this.getContentPane().add(lbl8);

        comboBox = new JComboBox<String>();
        comboBox.addItem("SHORTEST_TIME");
        comboBox.addItem("SHORTEST_QUEUE");
        comboBox.setBounds(127, 468, 134, 21);
        this.getContentPane().add(comboBox);

        this.setVisible(true);
    }

    public int getClientsTextField() {
        return Integer.parseInt(clientsTextField.getText());
    }

    public void setClientsTextField(int clientsTextField) {
        this.clientsTextField.setText(String.valueOf(clientsTextField));
    }

    public int getQueuesTextField() {
        return Integer.parseInt(queuesTextField.getText());
    }

    public void setQueuesTextField(int queuesTextField) {
        this.queuesTextField.setText(String.valueOf(queuesTextField));
    }

    public int getSimulationTextField() {
        return Integer.parseInt(simulationTextField.getText());
    }

    public void setSimulationTextField(int simulationTextField) {
        this.simulationTextField.setText(String.valueOf(simulationTextField));
    }

    public int getMinArrivalTextField() {
        return Integer.parseInt(minArrivalTextField.getText());
    }

    public void setMinArrivalTextField(int minArrivalTextField) {
        this.minArrivalTextField.setText(String.valueOf(minArrivalTextField));
    }

    public int getMaxArrivalTextField() {
        return Integer.parseInt(maxArrivalTextField.getText());
    }

    public void setMaxArrivalTextField(int maxArrivalTextField) {
        this.maxArrivalTextField.setText(String.valueOf(maxArrivalTextField));
    }

    public int getMinServiceTextField() {
        return Integer.parseInt(minServiceTextField.getText());
    }

    public void setMinServiceTextField(int minServiceTextField) {
        this.minServiceTextField.setText(String.valueOf(minServiceTextField));
    }

    public int getMaxServiceTextField() {
        return Integer.parseInt(maxServiceTextField.getText());
    }

    public void setMaxServiceTextField(int maxServiceTextField) {
        this.maxServiceTextField.setText(String.valueOf(maxServiceTextField));
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }

    public void addStartListener(ActionListener actionListener){
        startButton.addActionListener(actionListener);
    }

    public void refresh(){
        clientsTextField.setText(null);
        queuesTextField.setText(null);
        minArrivalTextField.setText(null);
        maxArrivalTextField.setText(null);
        minServiceTextField.setText(null);
        maxServiceTextField.setText(null);
        simulationTextField.setText(null);
        textArea.setText(null);
        comboBox.setSelectedItem(null);
    }

    public void showErrorMessage(String message){
        JOptionPane.showMessageDialog(this, message, "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        refresh();
    }


}
