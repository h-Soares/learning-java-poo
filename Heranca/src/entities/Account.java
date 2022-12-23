package entities;

public class Account {
    private int number;
    private String holder;
    protected double balance;

    public Account() {
    }

    public Account(int number, String holder, double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if((balance -= amount) >= 0)
            balance -= amount;
        else
            System.out.println("Can t do it!");
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }    
}
