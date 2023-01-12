package services.interfaces;

import java.math.BigDecimal;

public interface InterestService {
    double getInterestRate(); //obrigado a implementar

    default BigDecimal payment(BigDecimal amount, int months) { //já vem como padrão, mas pode sobrescrever
        return amount.multiply(BigDecimal.valueOf(1 + getInterestRate() / 100).pow(months));
    }
}