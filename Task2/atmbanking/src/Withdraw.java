

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Withdraw extends JFrame implements ActionListener {
    private ATMUser user;
    private JTextField amountField;
    private JLabel statusLabel;

    public Withdraw(ATMUser user) {
        this.user = user;
        setTitle("Withdraw Money");
        setSize(300, 200);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Enter amount to withdraw:"));
        amountField = new JTextField();
        add(amountField);

        JButton withdrawBtn = new JButton("Withdraw");
        withdrawBtn.addActionListener(this);
        add(withdrawBtn);

        statusLabel = new JLabel("");
        add(statusLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount > 0) {
                if (user.withdraw(amount)) {
                    statusLabel.setText("Withdrawn ₹" + amount);
                } else {
                    statusLabel.setText("Insufficient balance!");
                }
            } else {
                statusLabel.setText("Enter a valid amount!");
            }
        } catch (Exception ex) {
            statusLabel.setText("Invalid input!");
        }
    }
}
