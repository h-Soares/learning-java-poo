package entities;

public class NaturalPerson extends TaxPayer {
    private double healthExpenses;

    public NaturalPerson() {
        super();
    }

    public NaturalPerson(String name, double annualIncome, double healthExpenses) {
        super(name, annualIncome);
        this.healthExpenses = healthExpenses;
    }

    @Override
    public double tax() {
        double tax;

        if(getAnnualIncome() < 20000)
            tax = getAnnualIncome() * 0.15;
        else
            tax = getAnnualIncome() * 0.25;
        
        if(healthExpenses != 0)
            tax -= 0.5 * healthExpenses;

        return tax;
    }

    public double getHealthExpenses() {
        return healthExpenses;
    }

    public void setHealthExpenses(double healthExpenses) {
        this.healthExpenses = healthExpenses;
    }
}