

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATMSystem extends JFrame implements ActionListener {
    private ATMUser[] users;
    private ATMUser currentUser;
    private JTextField pinField;
    private JButton loginBtn, depositBtn, withdrawBtn, balanceBtn, logoutBtn;
    private JLabel messageLabel;

    public ATMSystem() {
        users = new ATMUser[] {
            new ATMUser("1234", 5000),
            new ATMUser("5678", 10000)
        };

        setTitle("ATM System");
        setSize(400, 300);
        setLayout(new GridLayout(6, 1, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        messageLabel = new JLabel("Enter PIN to Login", SwingConstants.CENTER);
        add(messageLabel);

        pinField = new JTextField();
        add(pinField);

        loginBtn = new JButton("Login");
        loginBtn.addActionListener(this);
        add(loginBtn);

        depositBtn = new JButton("Deposit");
        withdrawBtn = new JButton("Withdraw");
        balanceBtn = new JButton("Check Balance");
        logoutBtn = new JButton("Logout");

        depositBtn.addActionListener(this);
        withdrawBtn.addActionListener(this);
        balanceBtn.addActionListener(this);
        logoutBtn.addActionListener(this);

        depositBtn.setEnabled(false);
        withdrawBtn.setEnabled(false);
        balanceBtn.setEnabled(false);
        logoutBtn.setEnabled(false);

        add(depositBtn);
        add(withdrawBtn);
        add(balanceBtn);
        add(logoutBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            String enteredPin = pinField.getText();
            for (ATMUser user : users) {
                if (user.getPin().equals(enteredPin)) {
                    currentUser = user;
                    messageLabel.setText("Login Successful! Welcome.");
                    toggleButtons(true);
                    return;
                }
            }
            messageLabel.setText("Invalid PIN! Try again.");
        }

        else if (e.getSource() == depositBtn) {
            new Deposit(currentUser);
        }

        else if (e.getSource() == withdrawBtn) {
            new Withdraw(currentUser);
        }

        else if (e.getSource() == balanceBtn) {
            new CheckBalance(currentUser);
        }

        else if (e.getSource() == logoutBtn) {
            currentUser = null;
            messageLabel.setText("Logged out. Enter PIN to login again.");
            toggleButtons(false);
            pinField.setText("");
        }
    }

    private void toggleButtons(boolean loggedIn) {
        depositBtn.setEnabled(loggedIn);
        withdrawBtn.setEnabled(loggedIn);
        balanceBtn.setEnabled(loggedIn);
        logoutBtn.setEnabled(loggedIn);
        loginBtn.setEnabled(!loggedIn);
        pinField.setEnabled(!loggedIn);
    }

    public static void main(String[] args) {
        new ATMSystem();
    }
}
