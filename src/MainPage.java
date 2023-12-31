import javax.swing.*;
import java.awt.*;


public class MainPage extends JFrame {
    private JLabel lbl_welcome;
    private JLabel lbl_balance;
    private JPanel pnl_wrapper;
    private JPanel pnl_buttons;
    private JPanel pnl_transaction;
    private JButton btn_deposit;
    private JButton btn_withdrawal;
    private JButton btn_transaction;
    private JTextField txtfld_amount;
    private JLabel txt_transactionValidation;
    private JButton btn_logout;
    private TransactionType currentTransactionType;
    private User user;

    public MainPage(User user) {
        this.user = user;
        this.currentTransactionType = TransactionType.Deposit;

        btn_logout.setIcon(new ImageIcon("./Images/logout.png"));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(pnl_wrapper);
        setSize(620, 554);
        setResizable(false);
        setTitle("Sıradan Bank");
        setVisible(true);

        lbl_welcome.setText("    Hoşgeldiniz, " + user.getUsername() + "!");
        lbl_balance.setHorizontalAlignment(JLabel.CENTER);
        lbl_balance.setText("Bakiyeniz: " + user.getAccount().getBalance() + "₺");

        Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
        btn_logout.setCursor(handCursor);
        btn_transaction.setCursor(handCursor);

        btn_deposit.addActionListener(e -> {
            pnl_transaction.setVisible(true);
            this.currentTransactionType = TransactionType.Deposit;
            btn_transaction.setText("Deposit");
            btn_transaction.setBackground(Color.GREEN);
            btn_transaction.setForeground(Color.BLACK);
        });

        btn_withdrawal.addActionListener(e -> {
            pnl_transaction.setVisible(true);
            this.currentTransactionType = TransactionType.Withdrawal;
            btn_transaction.setText("Withdrawal");
            btn_transaction.setBackground(Color.RED);
            btn_transaction.setForeground(Color.WHITE);
        });

        btn_logout.addActionListener(e -> {
            dispose();
            new LoginPage(user);
        });

        btn_transaction.addActionListener(e -> transaction());
    }

    private void transaction() {
        String stringAmount = txtfld_amount.getText();
        try {
            Double amount = Double.parseDouble(stringAmount);
            int code = user.transaction(this.currentTransactionType, amount);

            if (code == -1) {
                txt_transactionValidation.setText("Girdiğiniz değer hatalıdır.");
            } else if (code == -2) {
                txt_transactionValidation.setText("Hesabınızda bu kadar para bulunmamaktadır.");
            } else {
                pnl_transaction.setVisible(false);
                lbl_balance.setText("Bakiyeniz: " + user.getAccount().getBalance() + "₺");
            }

            txtfld_amount.setText("");
        } catch (Exception err) {
            Double amount = 0.0;
            txt_transactionValidation.setText("Girdiğiniz değer hatalıdır.");
        }
    }
}
