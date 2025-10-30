//package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Deposit extends JFrame implements ActionListener {
    private ATMUser user;
    private JTextField amountField;
    private JLabel statusLabel;

    public Deposit(ATMUser user) {
        this.user = user;
        setTitle("Deposit Money");
        setSize(300, 200);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Enter amount to deposit:"));
        amountField = new JTextField();
        add(amountField);

        JButton depositBtn = new JButton("Deposit");
        depositBtn.addActionListener(this);
        add(depositBtn);

        statusLabel = new JLabel("");
        add(statusLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount > 0) {
                user.deposit(amount);
                statusLabel.setText("Deposited ₹" + amount);
            } else {
                statusLabel.setText("Enter a valid amount!");
            }
        } catch (Exception ex) {
            statusLabel.setText("Invalid input!");
        }
    }
}

