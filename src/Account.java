public interface Account {
    /**
     * Return the balance of the account
     * @return balance
     */
    double getBalance();

    /**
     * Deposits the given amount of money to the account
     * @param amount given amount of money
     * @return returns the new balance if there is an error occur returns -1
     */
    double deposit(double amount);

    /**
     * Withdraws the given amount of money from the account
     * @param amount given amount of money
     * @return returns the new balance if there is an error occur returns -1
     */
    double withdrawal(double amount);
}
