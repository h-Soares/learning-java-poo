package entities;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Employee {
    private String name;
    private String email;
    private BigDecimal salary;
    
    public Employee(String name, String email, BigDecimal salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(name + ",");
        sb.append(email + ",");
        sb.append(NumberFormat.getCurrencyInstance().format(salary));
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }   
}