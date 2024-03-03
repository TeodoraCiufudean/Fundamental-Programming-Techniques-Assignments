package mvc.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private JTextField P1textField;
    private JTextField P2textField;
    private JTextField resultField;
    private JButton additionButton;
    private JButton substractionButton;
    private JButton divisionButton;
    private JButton multiplycationButton;
    private JButton integrationButton;
    private JButton derivationButton;


    public View() {
        this.getContentPane().setBackground(new Color(0, 128, 0));
        this.setBounds(100, 100, 768, 553);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("Polynomial Calculator");
        titleLabel.setBounds(250, 10, 271, 31);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        this.getContentPane().add(titleLabel);

        JLabel p1Label = new JLabel("P1");
        p1Label.setBounds(30, 156, 22, 25);
        p1Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
        this.getContentPane().add(p1Label);

        P1textField = new JTextField();
        P1textField.setBounds(57, 159, 196, 19);
        this.getContentPane().add(P1textField);
        P1textField.setColumns(10);

        JLabel p2Label = new JLabel("P2");
        p2Label.setBounds(30, 216, 22, 25);
        p2Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
        this.getContentPane().add(p2Label);

        P2textField = new JTextField();
        P2textField.setBounds(57, 219, 196, 19);
        P2textField.setColumns(10);
        this.getContentPane().add(P2textField);

        additionButton = new JButton("ADDITION");
        additionButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        additionButton.setBounds(393, 119, 168, 62);
        this.getContentPane().add(additionButton);

        substractionButton = new JButton("SUBTRACTION");
        substractionButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        substractionButton.setBounds(562, 119, 168, 62);
        this.getContentPane().add(substractionButton);

        divisionButton = new JButton("DIVISION");
        divisionButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        divisionButton.setBounds(562, 179, 168, 62);
        this.getContentPane().add(divisionButton);

        multiplycationButton = new JButton("MULTIPLICATION");
        multiplycationButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        multiplycationButton.setBounds(393, 179, 168, 62);
        this.getContentPane().add(multiplycationButton);

        integrationButton = new JButton("INTEGRATION");
        integrationButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        integrationButton.setBounds(562, 241, 168, 62);
        this.getContentPane().add(integrationButton);

        derivationButton = new JButton("DERIVATIVE");
        derivationButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        derivationButton.setBounds(393, 241, 168, 62);
        this.getContentPane().add(derivationButton);

        JLabel resultLabel = new JLabel("Result");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        resultLabel.setBounds(149, 405, 126, 25);
        this.getContentPane().add(resultLabel);

        resultField = new JTextField();
        resultField.setColumns(10);
        resultField.setBounds(260, 405, 250, 25);
        this.getContentPane().add(resultField);
        this.setVisible(true);
    }

    public String getP1textField() {
        return P1textField.getText();
    }

    public void setP1textField(String p1textField) {
        P1textField.setText(p1textField);
    }

    public String getP2textField() {
        return P2textField.getText();
    }

    public void setP2textField(String p2textField) {
        P2textField.setText(p2textField);
    }

    public String getResultField() {
        return resultField.getText();
    }

    public void setResultField(String resultField) {
        this.resultField.setText(resultField);
    }

    public void addAdditionButton(ActionListener actionListener){
        additionButton.addActionListener(actionListener);
    }

    public void addSubstractionButton(ActionListener actionListener){
        substractionButton.addActionListener(actionListener);
    }

    public void addMultiplycationButton(ActionListener actionListener){
        multiplycationButton.addActionListener(actionListener);
    }

    public void addDivisionButton(ActionListener actionListener){
        divisionButton.addActionListener(actionListener);
    }

    public void addDerivationButton(ActionListener actionListener){
        derivationButton.addActionListener(actionListener);
    }

    public void addIntegrationButton(ActionListener actionListener){
        integrationButton.addActionListener(actionListener);
    }

    public void refresh(){
        P1textField.setText(null);
        P2textField.setText(null);
        resultField.setText(null);
    }
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        refresh();
    }
}
