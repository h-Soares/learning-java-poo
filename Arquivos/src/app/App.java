package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App { //Exceção para arquivos: IOException, herda de Exception, é obrigado a tratar
    public static void main(String[] args) { //NAO RODAR, CRIA NOVOS ARQUIVOS!
        //File permite fazer diversas manipulações com o arquivo
        File myFile = new File("C:\\Users\\hiago\\OneDrive\\Documentos\\JAVA VSCode Exemplos\\Curso Nelio\\Arquivos\\src\\testing.txt"); //usa-se \\ para \
        //também pode só passar o nome do arquivo entre " " que ele é CRIADO no mesmo diretório --> caminho relativo.
         
        //entre o Scanner, BufferedReader e FileReader, usar BufferedReader, pois tem melhor performance.
        //VERSÃO 1
        Scanner scan = null; //ao instanciar o Scanner por meio do arquivo, pode ocorrer uma exceção IOException
        try { //boa prática: if file.exists() && file.canRead()...
            scan = new Scanner(myFile);
            while(scan.hasNextLine())
                System.out.println(scan.nextLine());
        }
        catch(IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        finally {
            if(scan != null)
                scan.close();
        }
        System.out.println();
        System.out.println();

        //LEITURA em arquivos: 
        //FileReader é uma classe de stream de leitura de caracteres por meio de arquivos,
            //sequência de leitura de um arquivo
        //BufferedReader é uma classe instanciada a partir de FileReader, é mais otimizado/rápido do que FileReader
        //BufferedReader pode ler qualquer fluxo de entrada de caractere, enquanto FileReader apenas de arquivos.
            //Utiliza um leitor, geralmente um FileReader
        //BufferedReader, usa buffer . FileReader lê diretamente do disco rígido --> BufferedReader mais rápido.
        //BufferedReader permite ler uma linha por vez (e armazena no buffer), enquanto FileReader, apenas um caractere por vez.
        /* 
        String path = "C:\\Users\\hiago\\OneDrive\\Documentos\\testing.txt";
        FileReader fr = null;
        BufferedReader br = null;

        //try para tentar abrir o arquivo e ler
        try {
            fr = new FileReader(path); //ou br = new BufferedReader(new FileReader(path));
            br = new BufferedReader(fr);

            String line = br.readLine(); //se o arquivo estiver no final, retorna null.
            while(line != null) {
                System.out.println(line);
                line = br.readLine(); //imprime e lê de novo
            }
        }
        catch(IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        finally {
            try { //muito verboso, isso não é utilizado. É utilizado o try-with-resources.
                if(br != null)
                    br.close();
                if(fr != null)
                    fr.close();    
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }*/

    //O bloco try-with-resources é um bloco try que declara um ou mais recursos
    //e GARANTE que serão fechados ao final do bloco. Com isso, não é necessário fazer o fechamento manual, como 
    //feito anteriormente.
    //Utilizando o código a cima com o try-with-resources: 
    String path = "C:\\Users\\hiago\\OneDrive\\Documentos\\JAVA VSCode Exemplos\\Curso Nelio\\Arquivos\\src\\testing.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(path))) { //não é declarado separadamente porque não será fechado manualmente.
        String line = br.readLine();

        while(line != null) {
            System.out.println(line);
            line = br.readLine(); 
        }   
    }
    catch(IOException e) {
        System.out.println("ERROR" + e.getMessage());
    }
    //aqui é fechado e tratado automaticamente
    System.out.println();

    //VERSÃO 2: muito melhor
    try (Scanner scanner = new Scanner(myFile)) {
        while(scanner.hasNextLine())
            System.out.println(scanner.nextLine());
    }
    catch(IOException e) {
        System.out.println("ERROR: " + e.getMessage());
    }

    /* ESCRITA em arquivos:
        FileWriter e BufferedWriter(também mais rápido, pelo mesmo motivo já apresentado)
        FileWriter fileWriter = new FileWriter(path/caminho): cria o arquivo ou recria, zerado, se ele já existir   
        FileWriter fileWriter = new FileWriter(path/caminho, true): acrescente ao final do arquivo já existente, se ele existir 
    */
    String lines[] = new String[] {"SPFC"};
    //String path = "C:\\Users\\hiago\\OneDrive\\Documentos\\testing.txt"; já declarado
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(myFile, true))) { //myFile ou o caminho/path
        for(String line : lines) {
            bw.write(line); //escreve no arquivo, sem pular linha
            bw.newLine(); //pula linha, com o quebrador de linha DO SISTEMA (nem todos usam o \n)
        }
    }
    catch(IOException e) {
        System.out.println("ERROR: " + e.getMessage());
    }

    //teste FileWriter e BufferedWriter com lista:
    List<String> lines2 = new ArrayList<>();
    lines2.add("Paul");
    lines2.add("Joseph");
    lines2.add("Mary");

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(myFile, true))) {
        for(String line : lines2) {
            bw.write(line);
            bw.newLine();
        }
    }
    catch(IOException e) {
        System.out.println("ERROR: " + e.getMessage());
    }
    
    System.out.println();
    //Listagem de pastas/diretórios em uma pasta/diretório: 
    System.out.println("Enter a folder path: ");
    Scanner scanner = new Scanner(System.in);
    String folderPath = scanner.nextLine();
    File folder = new File(folderPath);
    File folders[] = folder.listFiles(File::isDirectory); //para somente arquivos: File::isFile
    System.out.println("FOLDERS: ");
    for(File folderD : folders)
        System.out.println(folderD);

    File files[] = folder.listFiles(File::isFile);
    System.out.println("FILES: ");
    for(File file : files)
        System.out.println(file);    
        
    //para criar uma subpasta em uma pasta (precisa de boolean pois é uma função que retorna boolean): 
    //boolean success = new File(folderPath + "\\nomeDaSubPasta").mkdir();    
    boolean success = new File(folderPath + "\\TestingSub").mkdir(); //TEM QUE TER o \\ para indicar que é DENTRO da pasta passada, e não fora dela
    System.out.println("Directory created successfully: " + success);
    scanner.close();

    //Dentre várias funções de File, temos getName(), para acessar o nome do arquivo, 
    //getParent(), para acessar o caminho, desprezando o nome do arquivo. É bom para criar subpastas com mkdir()
    //getPath(), para caminho e nome... Entre outras funções em File...
   }
}