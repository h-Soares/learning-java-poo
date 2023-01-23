package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import entities.Product;

public class App {
    public static void main(String[] args) {
        String path = "C:\\Users\\hiago\\OneDrive\\Documentos\\JAVA VSCode Exemplos\\Curso Nelio\\Exercicio01Lambda\\src\\in.csv";
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            if(line == null)
                throw new IOException("Line can't be null");
            
            while(line != null) {
                String fields[] = line.split(",");
                products.add(new Product(fields[0], new BigDecimal(fields[1])));
                line = br.readLine();
            }
            BigDecimal average = products.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add).
                                divide(BigDecimal.valueOf(products.size()), 4, RoundingMode.HALF_EVEN);
            System.out.print("Average price: " + NumberFormat.getCurrencyInstance().format(average));
            System.out.println();
            products.stream().filter(p -> p.getPrice().compareTo(average) < 0).map(Product::getName).
                                sorted(Collections.reverseOrder()).forEach(System.out::println);
        }
        catch(IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}