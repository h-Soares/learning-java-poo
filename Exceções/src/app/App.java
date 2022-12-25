package app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Try: trecho de código em que pode ocorrer um erro.
        //Catch: trecho de código a ser executado caso um erro ocorra. O tipo de exceção a ser tratada deve ser especificada.
        //ATENÇÃO: O tratamento de exceções deve ser usado em casos excepcionais. O mais recomendado é SEMPRE tratar os dados
        //para EVITAR que uma exceção seja lançada, utilizando while... etc.
         
        Scanner scan =  new Scanner(System.in);
        /*
        String vector[] =  scan.nextLine().split(" "); //Lê uma string e a separa por espaços. Cada separação é um elemento
        int position = scan.nextInt();                       //do vetor

        System.out.println(vector[position]); //esse programa pode dar erro: ao digitar letra, posição inválida...
        //ao digitar LETRA: InputMismatchException
        //ao digitar posição inválida: ArrayIndexOutOfBoundsException  */
/* 
        try {
            String vector[] =  scan.nextLine().split(" ");
            int position = scan.nextInt();                       
            System.out.println(vector[position]);
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid position!");
        } */

        /* 
        try {
            String vector[] =  scan.nextLine().split(" ");
            int position = scan.nextInt();                       
            System.out.println(vector[position]); 
        }
        catch(InputMismatchException e) {
            System.out.println("Invalid input!");
        }                 JUNTANDO OS DOIS:             */ 

        try {
            String vector[] =  scan.nextLine().split(" ");
            int position = scan.nextInt();                       
            System.out.println(vector[position]); 
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid position!");
            e.printStackTrace(); //mostra a PILHA de chamada de métodos, a exceção e onde ocorreu a exceção.
            //esse StackTrace também aparece quando a exceção não é tratada.
        }
        catch(InputMismatchException e) {
            System.out.println("Invalid input!");
            e.printStackTrace();
        }
        System.out.println("TESTING!");

        //O bloco finally é o bloco que contém o código a ser executado independentemente se tiver ocorrido ou não uma exceção. Mesmo se tiver um RETURN no
        //try ou no catch, o bloco finally será executado. Há RARÍSSIMOS casos em que o finally não é executado: exit... etc.

        System.out.println(method());

        scan.close();
    }
    static double method() {
        Scanner scan =  new Scanner(System.in);
        int a = 10;
        try {
            int b = scan.nextInt();
            return a / b;
        }
        catch(ArithmeticException e) {
            System.out.println("Impossible to divide by zero!");
            return -1;
        }
        catch(InputMismatchException e) {
            System.out.println("Input error!");
            return -1;
        }
        finally {//Antes de qualquer return executa esse bloco ou sempre que o bloco try termina.
            System.out.println("TESTIINNG!"); //Sem o finally: Unreachable code. Por causa dos return, essa linha não é executada.
            scan.close();
        }
    }
}