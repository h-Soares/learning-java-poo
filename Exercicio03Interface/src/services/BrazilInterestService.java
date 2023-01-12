package services;

import services.interfaces.InterestService;

public class BrazilInterestService implements InterestService {
    private final double interestRate = 2.0;

    public BrazilInterestService() {
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }
}