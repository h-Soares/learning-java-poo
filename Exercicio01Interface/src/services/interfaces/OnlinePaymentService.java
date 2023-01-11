package services.interfaces;

import java.math.BigDecimal;

public interface OnlinePaymentService {
    public BigDecimal paymentFee(BigDecimal amount);
    public BigDecimal interest(BigDecimal amount, int months);
}