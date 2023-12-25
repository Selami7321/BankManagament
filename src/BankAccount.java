public class BankAccount implements Account {
    private double balance; // default balance variable

    /**
     * Default constructor
     */
    BankAccount() {
        this.balance = 0;
    }

    /**
     * Initiate user account with given balance
     * this type of relations have been named as 'method overloading'
     * @param balance balance
     */
    BankAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        // return balance
        return balance;
    }

    @Override
    public double deposit(double amount) {
        // control if amount is negative
        if (!signControl(amount)) return -1;

        // add amount to the balance
        this.balance += amount;

        // return balance
        return balance;
    }

    @Override
    public double withdrawal(double amount) {

        if (!signControl(amount)) return -2; // hatalı giriş

        if (!signControl(balance - amount)) return -1; // bakiye yok

        this.balance -= amount;

        return balance;
    }

    private boolean signControl(double result) {
        // return true if result greater than or equal to 0
        return result >= 0;
    }
}
