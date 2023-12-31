import javax.swing.*;


public class LoginPage extends JFrame {
    private JPanel pnl_wrapper;
    private JTextField txtFld_tcno;
    private JPasswordField txtFld_password;
    private JButton btn_login;
    private JButton btn_register;
    private JLabel lbl_status;
    private JPanel pnl_btmWrapper;
    private JPanel pnl_topWrapper;
    private JLabel lbl_tcno;
    private JLabel lbl_password;
    private JLabel lbl_haveAccount;
    private JPanel pnl_loginWrapper;
    private JPanel pnl_registerWrapper;
    private JPanel pnl_register_topWrapper;
    private JPanel pnl_register_buttomWrapper;
    private JTextField txtfld_register_surname;
    private JTextField txtfld_register_name;
    private JTextField txtfld_register_tcno;
    private JPasswordField txtfld_register_password;
    private JButton btn_register_register;
    private JButton btn_register_goback;
    private JLabel lbl_register_surname;
    private JLabel lbl_register_warning;

    public LoginPage(User user) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(pnl_wrapper);
        setSize(350, 350);
        setResizable(false);
        setTitle("Sıradan Bank");
        setVisible(true);

        btn_login.addActionListener(e -> {
            if (user.login(txtFld_tcno.getText(), String.valueOf(txtFld_password.getPassword()))) {
                dispose();
                new MainPage(user);
            }
            else {
                lbl_status.setText("Giriş bilgileriniz yanlıştır!");
            }
        });
    }


}