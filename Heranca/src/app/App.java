package app;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingAccount;

public class App {
    public static void main(String[] args)  {
        Account acc = new Account(137, "Jon", 100.0);
        BusinessAccount bacc = new BusinessAccount(182, "Adrien", 130.0, 500.0);

        //UPCASTING: subclasse para superclasse.

        Account acc2 = bacc; //pois BusinessAccount é um Account, e as características são de Account, porque é do tipo Account.
        Account acc3 = new BusinessAccount(1, "Annie", 0.0, 50.0);
        Account acc4 = new SavingAccount(862, "Frank", 0.0, 10.0);
        
        
        //DOWNCASTING: superclasse para subclasse

        //BusinessAccount bacc2 = acc2; //ERRO, pois não tem como saber se esse Account está, de fato, associado a um BusinessAccount.
        BusinessAccount bacc2 = (BusinessAccount) acc2; //garante que o Account acc2 está associado a um BusinessAccount. É do tipo BusinessAccount.
        //BusinessAccount bacc3 = (BusinessAccount) acc4; //ERRO em tempo de execução, pois acc4 está associado a um SavingAccount, e não a um BusinessAccount.
        //Para corrigir isso e conferir se é do mesmo tipo, usa-se instaceof:

        if(acc4 instanceof BusinessAccount) { //está associado a um...
            BusinessAccount bacc3 = (BusinessAccount) acc4;
            bacc3.loan(100);
            System.out.println("Loan successful!");
        }

        if(acc4 instanceof SavingAccount) {
            SavingAccount sacc = (SavingAccount) acc4;
            sacc.updateBalance();
            System.out.println("Update successful!");
        }
    }
}