public class Account {
    private int number;
    private String name;
    private double balance;

    public Account(){

    }

    public Account(String name, int number, double inicialBalance)
    {
        this.name = name;
        this.number = number;
        deposit(inicialBalance); //para melhorar o encapsulamento. Melhor do que fazer this.balance = balance; De modo geral, NÃO É UMA BOA PRÁTICA. Mas aqui é viável,
    }                           //pois melhora a manutenção do código. Utilizar métodos em construtores não é recomendado.

    public Account(String name, int number)
    {
        this.name = name;
        this.number = number;
    }

    public void accountStatus() //VER COM JPANEL.
    {
        System.out.println("NAME: " + name);
        System.out.println("NUMBER: " + number);
        System.out.println("BALANCE: " + balance);
    }


    public void deposit(double value)
    {
        balance += value;
    }

    public void withdraw(double value)
    {
        balance -= (value + 5);
    }


    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

}
