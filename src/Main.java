import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import java.util.Scanner;

public class Main {
    // user variable
    private static User user = new User("selami", "1", 500);
    // scanner variable
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FlatMacDarkLaf.setup();
        LoginPage loginPage = new LoginPage(user);
    }


}