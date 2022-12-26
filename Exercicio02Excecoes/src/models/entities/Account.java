package models.entities;

import models.exceptions.DepositException;

public class Account {
    private int number;
    private String holder;
    private double balance;
    private double withdrawLimit;

    public Account () {
    }

    public Account(int number, String holder, double balance, double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws DepositException{ //Para MELHOR DELEGAÇÃO: a classe não pode ter a responsabilidade de printar!
        if(balance < amount) 
            throw new DepositException("Insufficient balance");    
        else if(amount > withdrawLimit)
            throw new DepositException("Amount is greater than withdraw limit");
        else 
            balance -= amount;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public void setWithdrawLimit(double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public int getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

}