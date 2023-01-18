package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> names = new HashSet<>();

        System.out.print("Enter file path: ");
        String path = scan.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            
            String line = br.readLine();
            while(line != null) {
                String userFields[] = line.split(" ");
                names.add(userFields[0]); //utiliza hashCode e equals para não aceitar os repetidos.
                line = br.readLine();
            }
        }
        catch(IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("Total users: " + names.size());

        scan.close();
    }
}