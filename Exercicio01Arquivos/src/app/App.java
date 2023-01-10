package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;

public class App {
    public static void main(String[] args) {
        String path = "C:\\Users\\hiago\\OneDrive\\Documentos\\JAVA VSCode Exemplos\\Curso Nelio\\Exercicio01Arquivos\\src\\files\\input.csv";

        Locale.setDefault(new Locale("en", "US"));
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while(line != null) {
                String splitString[] = line.split(",");

                String name = splitString[0];
                BigDecimal price = new BigDecimal(splitString[1]);
                int quantity = Integer.parseInt(splitString[2]);

                products.add(new Product(name, price, quantity));
                line = br.readLine();
            }
        }
        catch(IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\hiago\\OneDrive\\Documentos\\JAVA VSCode Exemplos\\Curso Nelio\\Exercicio01Arquivos\\src\\files\\summary.csv"))) {
            for(Product product : products) {
                bw.write(product.toString());
                bw.newLine();
            }
        }
        catch(IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}