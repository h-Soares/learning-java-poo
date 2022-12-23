package entities;

public final class SavingAccount extends Account { //FINAL faz com que a CLASSE não possa ser herdada. 
    private double interestRate;    //Atributos de uma classe final têm melhor performance, pois são analisados mais rapidamente em tempo de execução.

    public SavingAccount() {
        super();
    }

    public SavingAccount(int number, String holder, double balance, double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    @Override 
    public void withdraw(double amount) {
        if((balance -= amount) >= 0)
            balance -= amount;
        else
            System.out.println("Can t do it!");
    }

    public final void updateBalance() { //FINAL faz com que o MÉTODO não possa ser SOBREPOSTO. Sobreposições múltiplas podem gerar inconsistências, então é
        balance += balance * interestRate;  //aconselhável utilizar final depois de sobrepor um método.
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}