package application;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.*;

public class JavaOne {  //Debbugger for Java - Console (para arrumar onde sai a mensagem) - 
    //PROGRAMAR EM INGLÊS!!
    public static void main(String[] args){ //Gerar Setter e Getters automaticamente: Na classe, Source Action - Generate Getters and Setters - Seleciona e dar OK.                                                                                   
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number of employees: ");
        int num = scan.nextInt();

        List<Employee> list = new ArrayList<>();

        for(int i = 1; i <= num; i++)
        {
            System.out.printf("Enter the %d employee id: ", i);
            int id = scan.nextInt();
            scan.nextLine();
            System.out.printf("Enter the %d employee name: ", i);
            String name = scan.nextLine();
            System.out.printf("Enter the %d employee wage: ", i);
            double wage = scan.nextDouble();
            System.out.println();

            list.add(new Employee(id, name, wage));
        }
        
        for(Employee employee : list)
            System.out.println(employee);

        System.out.println("\nEnter the id: ");
        int id = scan.nextInt();

        boolean hasId = false;
        for(Employee employee : list)
        {
            if(employee.getId() == id)
            {
                hasId = true;   
                System.out.println("Enter the percentage to increase in wage: ");
                double X = scan.nextDouble();
                employee.increase(X);
            }      
        }
        if(hasId)
        {
            System.out.println("\n------------------------------------");
            for(Employee employee : list)
                System.out.println(employee); 
        }
        else
        {
            System.out.println("This id doesn't exist!");
        }
        scan.close();
    }
}








