package app;

import java.util.Scanner;

import models.entities.Account;
import models.exceptions.DepositException;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("ACCOUNT DATA: ");
        System.out.print("Number: ");
            int number = scan.nextInt();
        System.out.print("Holder: ");
            scan.nextLine();
            String holder = scan.nextLine();
        System.out.print("Initial balance: ");
            double balance = scan.nextDouble();
        System.out.print("Withdraw limit: ");
            double withdrawLimit = scan.nextDouble();
        Account account = new Account(number, holder, balance, withdrawLimit);

        System.out.print("\nEnter a balance to withdraw: ");
            balance = scan.nextDouble();
        try {
            account.withdraw(balance);
            System.out.println("New balance: " + account.getBalance());
        }
        catch(DepositException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        scan.close();
    }
}