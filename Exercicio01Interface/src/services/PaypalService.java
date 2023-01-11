package services;

import java.math.BigDecimal;
import services.interfaces.OnlinePaymentService;

public class PaypalService implements OnlinePaymentService {

    @Override
    public BigDecimal interest(BigDecimal amount, int months) {
        return amount.multiply(BigDecimal.valueOf(months * 0.01));
    }

    @Override
    public BigDecimal paymentFee(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.02));
    }   
}