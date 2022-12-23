package entities;

public class BusinessAccount extends Account { //BusinessAccount É UM Account
    private double loanLimit;

    public BusinessAccount(){
        super(); //começar com conta zerada.. etc..
    }

    public BusinessAccount(int number, String holder, double balance, double loanLimit) {
        super(number, holder, balance); //super chama o construtor da superclasse.
        this.loanLimit = loanLimit;
    }

    public void loan(double amount) {
        if(amount <= loanLimit)
            balance += amount - 10; //preferir não usar protected. Mas em alguns casos é necessário, ex: quando não é permitido set.
    }

    public double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(double loanLimit) {
        this.loanLimit = loanLimit;
    }
}
