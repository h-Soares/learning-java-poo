import java.util.Scanner;

public class JavaOne {  //Debbugger for Java - Console (para arrumar onde sai a mensagem) - 
    //PROGRAMAR EM INGLÊS!!
    public static void main(String[] args){ //Gerar Setter e Getters automaticamente: Na classe, Source Action - Generate Getters and Setters - Seleciona e dar OK.                                                                                   
        Scanner scan = new Scanner(System.in);

        System.out.println("Do you want inform the inicial balance? y/n");
        char ans = scan.next().charAt(0);

        Account account = new Account(); //isso foi feito por que a variável pode não ser inicializada, se não cair em um dos switch case que inicializa.

        System.out.println("Enter the name: ");
        scan.nextLine();
        String name = scan.nextLine();
        System.out.println("Enter the account number: ");
        int number = scan.nextInt();

        switch (ans)
        {
            case 'y':
            {
                System.out.println("Enter the inicial balance: ");
                double inicial = scan.nextDouble();

                account =  new Account(name, number, inicial);
                System.out.println();

                break;
            }

            case 'n':
            {
                account =  new Account(name, number);
                System.out.println();

                break;
            }

            default:
            {
                System.out.println("Non-existent answer!");   
                System.exit(0); //sai do programa.
            }
                
        }

        account.accountStatus();
        System.out.println();

        System.out.println("Enter a deposit value: ");
        System.out.println();
        account.deposit(scan.nextDouble());
        account.accountStatus();
        System.out.println();


        System.out.println("Enter a withdraw value: ");
        System.out.println();
        account.withdraw(scan.nextDouble());
        account.accountStatus();
        
        scan.close();
    }
}








