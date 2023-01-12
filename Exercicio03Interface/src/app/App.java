package app;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;
import services.UsaInterestService;
import services.interfaces.InterestService;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter amount: ");
        BigDecimal amount = new BigDecimal(scan.next());
        System.out.print("Enter months: ");
        int months = scan.nextInt();

        while(months < 1) {
            System.out.println("Invalid months input!");
            System.out.print("Enter months: ");
            months = scan.nextInt();
        }

        InterestService interestService = new UsaInterestService();
        System.out.println(NumberFormat.getCurrencyInstance().format(interestService.payment(amount, months)));

        scan.close();
    }
}