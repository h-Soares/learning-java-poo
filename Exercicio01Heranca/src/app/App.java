package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.Employee;
import entities.OutsourcedEmployee;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
            int number = scan.nextInt();
        List<Employee> employees = new ArrayList<>();
        System.out.println();

        for(int i = 1; i <= number; i++)
        {
            System.out.print("Outsourced? (y/n): ");
                char answer = scan.next().charAt(0);

            System.out.println("Employee #" + i + " data: ");
            System.out.print("\nEnter employee name: ");
                scan.nextLine();
                String name = scan.nextLine();
            System.out.print("Enter employee working hours: ");
                int hours = scan.nextInt();
            System.out.print("Enter employee value per hour: ");
                double valuePerHour = scan.nextDouble();
            
            if(answer == 'n') {
                employees.add(new Employee(name, hours, valuePerHour));
                System.out.println(); 
            }
            else if(answer == 'y')
            {
                System.out.print("Enter employee additionalCharge: ");
                    double additionalCharge = scan.nextDouble();
                employees.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
                System.out.println();
            }
        }

        System.out.println("EMPLOYEES: ");
        for(Employee employee : employees)
            System.out.println(employee);

        scan.close();
    }
}