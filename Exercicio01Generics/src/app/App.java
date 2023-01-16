package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import entities.Product;
import services.CalculationService;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\hiago\\OneDrive\\Documentos\\JAVA VSCode Exemplos\\Curso Nelio\\Exercicio01Generics\\src\\in.txt"))){
            String line = br.readLine();
            while(line != null) {
                String fields[] = line.split(",");
                products.add(new Product(fields[0], new BigDecimal(fields[1])));
                line = br.readLine();
            }
            System.out.println("Most expensive: ");
            System.out.println(CalculationService.max(products));
        }
        catch(IOException | IllegalStateException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}