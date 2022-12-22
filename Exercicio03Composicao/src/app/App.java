package app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter client data: \n");

        System.out.print("Name: ");
            String name = scan.nextLine();
        System.out.print("Email: ");
            String email = scan.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate birthDate = LocalDate.parse(scan.nextLine(), fmt);
        Client client = new Client(name, email, birthDate);

        System.out.println("\nEnter order data: \n");
        
        System.out.print("Status: ");
           OrderStatus status = OrderStatus.valueOf(scan.nextLine().toUpperCase());
        Order order = new Order(LocalDateTime.now(), status, client);
        System.out.print("How many items to this order?: ");
            int quantity = scan.nextInt();
        System.out.println();

        for(int i = 1; i <= quantity; i++)
        {
            System.out.println("Enter #" + i + " item data: ");

            System.out.print("Product name: ");
                scan.nextLine();
                String productName = scan.nextLine();
            System.out.print("Product price: ");
                double productPrice = scan.nextDouble();
            System.out.print("Quantity: ");
                int productQuantity = scan.nextInt();
            //repete o preço para manter o histórico do preço na época.
            order.addItem(new OrderItem(productQuantity, productPrice, new Product(productName, productPrice)));
            System.out.println();
        } 

        System.out.println("ORDER SUMMARY: ");
        System.out.println(order); //pelo toString !

        scan.close();
    }
}