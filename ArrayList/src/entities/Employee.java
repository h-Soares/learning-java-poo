package entities;

public class Employee {
    private int id;
    private String name;
    private double wage;
    
    public Employee(int id, String name, double wage) {
        this.id = id;
        this.name = name;
        this.wage = wage;
    }

    @Override
    public String toString()
    {
        return "Id: " + getId() + "  Name: " + getName() + "  Wage: " + getWage();
    }

    public void increase(double percentage)
    {
        wage = (1 + percentage / 100) * wage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWage() {
        return wage;
    }
}
