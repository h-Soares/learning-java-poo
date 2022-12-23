import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
            int number = scan.nextInt();
        List<Product> products = new ArrayList<>();
        System.out.println();
        
        for(int i = 1; i <= number; i++) {
            System.out.println("Product #" + i + " data: ");
            System.out.print("Common, used or imported ? (c/u/i): ");
                scan.nextLine();
                char type = scan.next().charAt(0);

            System.out.print("Name: ");
                scan.nextLine();
                String name = scan.nextLine();
            System.out.print("Price: ");
                double price = scan.nextDouble();
            
            switch(type) {
                case 'c':
                {
                    products.add(new Product(name, price));
                    System.out.println();
                    break;
                }
                case 'u':
                {
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    scan.nextLine();
                    LocalDate date = LocalDate.parse(scan.nextLine(), fmt);
                    products.add(new UsedProduct(name, price, date));
                    System.out.println();
                    break;
                }
                case 'i':
                {
                    System.out.print("Customs fee: ");
                        double customsFee = scan.nextDouble();
                    products.add(new ImportedProduct(name, price, customsFee));
                    System.out.println();
                    break;
                }
            }
        }

        System.out.println("PRICE TAGS:");
        for(Product product : products)
            System.out.println(product.priceTag());

        scan.close();
    }
}