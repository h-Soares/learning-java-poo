package app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        System.out.println("Contract data: ");

        System.out.print("Number: ");
        int number = scan.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        scan.nextLine();
        LocalDate date = LocalDate.parse(scan.next(), fmt);
        System.out.print("Contract value: ");
        BigDecimal totalValue = new BigDecimal(scan.next());

        Contract contract = new Contract(number, date, totalValue);

        System.out.print("Number of installments: ");
        int numberInstallments = scan.nextInt();

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, numberInstallments);

        System.out.println("\nInstallments: ");
        for(Installment installment : contract.getInstallments())
            System.out.println(installment);

        scan.close();
    }
}