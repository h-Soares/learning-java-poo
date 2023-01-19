package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<String, Integer> totalVotes = new HashMap<>();
        String path = "C:\\Users\\hiago\\OneDrive\\Documentos\\JAVA VSCode Exemplos\\Curso Nelio\\Exercicio01Map\\src\\votes.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while(line != null) {
                String splitLine[] = line.split(",");

                if(totalVotes.containsKey(splitLine[0]))
                    totalVotes.replace(splitLine[0], totalVotes.get(splitLine[0]) + Integer.parseInt(splitLine[1]));
                else
                    totalVotes.put(splitLine[0], Integer.parseInt(splitLine[1]));
                
                line = br.readLine();
            }
        }
        catch(IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        for(String key : totalVotes.keySet())
            System.out.println(key + ": " + totalVotes.get(key));
    }
}