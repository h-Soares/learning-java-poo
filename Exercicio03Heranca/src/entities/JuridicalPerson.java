package entities;

public class JuridicalPerson extends TaxPayer{
    private int employeesQuantity;

    public JuridicalPerson() {
        super();
    }

    public JuridicalPerson(String name, double annualIncome, int employeesQuantity) {
        super(name, annualIncome);
        this.employeesQuantity = employeesQuantity;
    }

    @Override
    public double tax() {
        double tax;

        if(employeesQuantity > 10)
            tax = getAnnualIncome() * 0.14;
        else
            tax = getAnnualIncome() * 0.16;

        return tax;
    }

    public int getEmployeesQuantity() {
        return employeesQuantity;
    }

    public void setEmployeesQuantity(int employeesQuantity) {
        this.employeesQuantity = employeesQuantity;
    }
}