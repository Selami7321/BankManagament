import java.util.function.DoublePredicate;

public class User {
    private String username;
    private String password;
    private BankAccount account;
    private boolean loggedIn;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.account = new BankAccount();
    }

    public User(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.account = new BankAccount(balance);
    }

    /**
     * Control if given username and password matches user's credentials
     * if it matches then return true
     * @param username username
     * @param password password
     * @return status of login
     */
    public boolean login(String username, String password) {
        /**
         * add your codes into this area
         * do not forget to set loggedIn to true!
         */

        this.loggedIn = username.equals(this.username) && password.equals(this.password);

        return this.loggedIn;
    }

    /**
     * Control if user is already logged in
     * if user logged in set loggedIn to true and
     * return true
     * return false otherwise
     * @return status of logout
     */
    public boolean logout() {
        /**
         * add your codes into this area
         * do not forget to set loggedIn to false!
         */

        // check if logged in true
        // if it is set logged in false and return true

        if (loggedIn) {
            loggedIn = false;
            return true;
        }

        return false;
    }

    /**
     * Does a transaction in user account with given type and amount
     * @param type transaction type
     * @param amount given amount
     */
    public void transaction(TransactionType type, double amount) {
        // get result according to transaction type

        // if result is -1 call printError() method


        // else return 'Your withdrawal/deposit is done with amount. Your balance is: ...'

        if (TransactionType.Deposit == type) {
            Double result = this.account.deposit(amount);
            if (result == -1) {
                System.out.println("Yanlış işlem yaptınız.");
            } else {
                System.out.println("Yeni bakiyeniz: " + this.account.getBalance() + "$");
            }
        } else {
            Double result = this.account.withdrawal(amount);
            if (result == -1) {
                System.out.println("Bankanızda bu kadar para yok.");
            } else if (result == -2) {
                System.out.println("Yanlış işlem yaptınız.");
            } else {
                System.out.println("Yeni bakiyeniz: " + this.account.getBalance() + "$");
            }
        }

    }

    /**
     * Print out an informative message just like 'An error occurred during
     * your process' when any kind of transaction returns '-1'
     */
    public void printError() {
        /**
         * add your codes into this area
         * simply just print 'An error occurred during your process'
         */

    }

    /**
     * Getter of username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter of logged in
     * @return logged in
     */
    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    /**
     * Prints out the balance of user accounts
     */
    public void getBalance() {
        double balance = account.getBalance();
        System.out.println(getUsername() + " has $" + balance);
    }

    public BankAccount getAccount() {
        return this.account;
    }
}
