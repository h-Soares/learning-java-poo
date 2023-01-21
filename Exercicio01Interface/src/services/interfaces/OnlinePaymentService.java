package services.interfaces;

import java.math.BigDecimal;

public interface OnlinePaymentService {
    BigDecimal paymentFee(BigDecimal amount);
    BigDecimal interest(BigDecimal amount, int months);
}