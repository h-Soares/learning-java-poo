package application;

import entities.*;
import entities.enums.WorkerLevel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Scanner;

public class Program {  //Debbugger for Java - Console (para arrumar onde sai a mensagem) - 
    //PROGRAMAR EM INGLÊS!!
    public static void main(String[] args){ //Gerar Setter e Getters automaticamente: Na classe, Source Action - Generate Getters and Setters - Seleciona e dar OK.                                                                                   
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter department's name: ");
            String departmentName = scan.nextLine();

        System.out.print("\nEnter worker data: ");

        System.out.print("\nName: ");
            String workerName = scan.nextLine();
        System.out.print("Level: ");
            String level = scan.nextLine().toUpperCase();
        System.out.print("Base salary: ");
            double baseSalary = scan.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(level), baseSalary, new Department(departmentName));    

        System.out.print("\nHow many contracts to this worker?: ");
            int contractQuantity = scan.nextInt();
        System.out.println();

        for(int i = 1; i <= contractQuantity; i++)
        {
            System.out.println("Enter #" + i + " data:\n");

            System.out.print("Date (DD/MM/YYYY): ");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //formata para esse padrão
                scan.nextLine();
                LocalDate date = LocalDate.parse(scan.nextLine(), formatter); //lê string na forma do padrão, formata e passa para LocalDate
            System.out.print("Value per hour: ");
                double valuePerHour = scan.nextDouble();
            System.out.print("Duration (hours): ");
                int duration = scan.nextInt();
            HourContract contract = new HourContract(date, valuePerHour, duration);
            worker.addContract(contract);
            System.out.println();
        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
            DateTimeFormatter fmt = new DateTimeFormatterBuilder().appendPattern("MM/yyyy").parseDefaulting(ChronoField.DAY_OF_MONTH, 1).toFormatter(); //formata e define o dia, que é obrigatório mas não será usado, para 1.
            scan.nextLine();
            LocalDate dateIncome = LocalDate.parse(scan.nextLine(), fmt); 
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + dateIncome.format(fmt) + ": " + worker.income(dateIncome.getYear(), dateIncome.getMonthValue())); //pega o ano e o dia e passa como argumento do método.

        scan.close(); 
    }
}