package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Employee;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        String path = "C:\\Users\\hiago\\OneDrive\\Documentos\\JAVA VSCode Exemplos\\Curso Nelio\\Exercicio02Lambda\\src\\in.csv";
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path));
                                   Scanner scan = new Scanner(System.in)) {
            String line = br.readLine();

            while(line != null) {
                String fields[] = line.split(",");
                employees.add(new Employee(fields[0], fields[1], new BigDecimal(fields[2])));
                line = br.readLine();
            }
            System.out.print("Enter salary: ");
            BigDecimal salary = new BigDecimal(scan.nextLine());

            System.out.println("Email of people whose salary is more than " + fmt.format(salary) + ": ");
            employees.stream().filter(emp -> emp.getSalary().compareTo(salary) > 0).
                      map(Employee::getEmail).sorted().forEach(System.out::println);
            System.out.println();

            System.out.println("People info whose name starts with 'M': ");
            employees.stream().filter(emp -> emp.getName().startsWith("M")).forEach(System.out::println);
            System.out.println();

            System.out.print("Sum of salary of people whose name starts with 'M': ");
            BigDecimal sum = employees.stream().filter(emp -> emp.getName().startsWith("M")).
                                   map(Employee::getSalary).reduce(BigDecimal.ZERO, BigDecimal::add);
            System.out.println(fmt.format(sum));
        }
        catch(IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}