import java.util.Scanner;

public class MainOld {
    // user variable
    private static User user = new User("selami", "123selami", 500);
    // scanner variable
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // call login method
        login();
    }

    public static void login() {
        System.out.println("Welcome to Banking Automation! Please enter your credentials to proceed.");
        while (true) {
            // get username
            System.out.print("Username: ");
            String username = scanner.nextLine();

            // get password
            System.out.print("Password: ");
            String password = scanner.nextLine();

            // attempt login
            user.login(username, password);

            // if credentials match then break the while
            if (user.isLoggedIn()) {
                System.out.println("Welcome back, " + username);
                break;
            }

            System.out.println("Wrong username or password!");
        }

        // proceed to menu
        menu();
    }

    /**
     * Main menu of the automation
     */
    public static void menu() {
        while (true) {
            // control if user is logged in
            if (!user.isLoggedIn()) {
                System.out.println("Please log in to the system!\n");
                // call login method
                login();
            }
            // print menu
            System.out.println("Güncel bakiyeniz: " + user.getAccount().getBalance() + "$" +
                    "\nPlease select one process:" +
                    "\n1- Deposit" +
                    "\n2- Withdrawal" +
                    "\n3- Seek Balance" +
                    "\n4- Logout" +
                    "\n5- Quit");

            // print process
            System.out.print("Process: ");
            // get process
            int process = scanner.nextInt();

            // switch case
            switch (process) {
                case 1: // deposit
                    TransactionType deposit = TransactionType.Deposit;
                    double depositAmount = getAmount(deposit);
                    user.transaction(deposit, depositAmount);
                    break;
                case 2: // withdrawal
                    TransactionType withdrawal = TransactionType.Withdrawal;
                    double withdrawalAmount = getAmount(withdrawal);
                    user.transaction(withdrawal, withdrawalAmount);
                    break;
                case 3: // seek balance
                    user.getBalance();
                    break;
                case 4: // logout
                    System.out.println(user.logout() ? "You have been successfully logged out" : "An error occurred during logging out");
                    break;
                case 5: // quit
                    System.exit(0);
                    break;
            }
        }
    }

    /**
     * Returns a double value which is the amount
     * @param type transaction type
     * @return amount
     */
    private static double getAmount(TransactionType type) {
        System.out.print("What amount that you want to " + (type == TransactionType.Withdrawal ? "withdrawal" : "deposit") + ": ");
        return scanner.nextDouble();
    }

}