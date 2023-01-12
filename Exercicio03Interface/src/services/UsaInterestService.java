package services;

import services.interfaces.InterestService;

public class UsaInterestService implements InterestService{
    private final double interestRate = 1.0;

    public UsaInterestService() {
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }
}