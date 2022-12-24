package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.JuridicalPerson;
import entities.NaturalPerson;
import entities.TaxPayer;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of tax payers: ");
            int number = scan.nextInt();
        List<TaxPayer> taxpayers = new ArrayList<>();
        System.out.println();
        
        for(int i = 1; i <= number; i++) {
            System.out.println("Taxpayer #" + i + " data: ");

            System.out.print("Natural or Juridical? (n/j): ");
                char nc = scan.next().charAt(0);
            System.out.print("Name: ");
                scan.nextLine();
                String name = scan.nextLine();
            System.out.print("Annual income: ");
                double annualIncome = scan.nextDouble();
            
            if(nc == 'n') {
                System.out.print("Health expenses: ");
                    double healthExpenses = scan.nextDouble();
                taxpayers.add(new NaturalPerson(name, annualIncome, healthExpenses));
                System.out.println();
            }
            else if(nc == 'j') {
                System.out.print("Number of employees: ");
                    int employeesQuantity = scan.nextInt();
                taxpayers.add(new JuridicalPerson(name, annualIncome, employeesQuantity));
                System.out.println();
            }
            //algum tratamento de erro....
        }

        System.out.println("TAXES PAID: ");
        for(TaxPayer taxpayer : taxpayers)
            System.out.println(taxpayer);

        System.out.print("\nTOTAL TAXES: ");
        double sum = 0;
        for(TaxPayer taxpayer : taxpayers)
            sum += taxpayer.tax();
        System.out.println(sum);

        scan.close();
    }
}