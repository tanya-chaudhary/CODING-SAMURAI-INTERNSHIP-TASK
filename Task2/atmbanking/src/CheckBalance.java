

import javax.swing.*;
import java.awt.*;

public class CheckBalance extends JFrame {
    public CheckBalance(ATMUser user) {
        setTitle("Check Balance");
        setSize(300, 150);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel balanceLabel = new JLabel("Your Balance: ₹" + user.getBalance());
        add(balanceLabel);

        setVisible(true);
    }
}
