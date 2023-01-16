package app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Try: trecho de código em que pode ocorrer um erro.
        //Catch: trecho de código a ser executado caso um erro ocorra. O tipo de exceção a ser tratada deve ser especificada.
        //ATENÇÃO: O tratamento de exceções deve ser usado em casos excepcionais. O mais recomendado é SEMPRE tratar os dados
        //para EVITAR que uma exceção seja lançada, utilizando while... etc.
        //Em geral, pode-se IMPEDIR a ocorrência de exceções não verificadas com codificação adequada. (Deitel). Isto é, 
        //não tratando com try-catch, mas impedindo que elas ocorram.
        //Você pode evitar uma RuntimeException com um comando 'if'. Você não deve lidar com isso ou capturar (Oracle).
        //Lance exceções de construtores para indicar que os parâmetros de construtor não são válidos — isso evita que 
            //um objeto seja criado em um estado inválido.
        //Colocar um bloco try em torno de uma parte significativa do código. Esse bloco try deve ser seguido
        //por blocos catch que tratam cada possível exceção e os blocos catch devem ser seguidos por um único bloco finally (se algum
        //for necessário) (Deitel).
        //Se é conhecido o erro que pode ocorrer, usar estruturas condicionais para EVITAR que ele ocorra.
            //Se for um erro inesperado, usar try catch.
        /* Em resumo, o try/catch serve para tratar comportamentos inesperados, entretanto ele é bem mais lento 
        que controlar o fluxo de um programa com if/else, ou seja, deve ser utilizado preferencialmente quando 
        o desenvolvedor não tem como garantir que aquele código será executado com sucesso. (StackOverflow) */
        //Não faz sentido deixar passar um erro de programação (RuntimeExceptions).
        //Você só deve capturar exceções que sejam inevitáveis por uma razão ou outra.

         
         
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
            System.out.println("Impossible to divide by zero!"); //O CERTO NÃO É TRATAR ESSA EXCEÇÃO, MAS IMPEDIR QUE ELA OCORRA.
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