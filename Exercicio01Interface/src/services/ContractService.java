package services;

import java.math.BigDecimal;
import entities.Contract;
import entities.Installment;
import services.interfaces.OnlinePaymentService;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {
        BigDecimal basicQuota = contract.getTotalValue().divide(BigDecimal.valueOf(months)).setScale(4);
        
        for(int i = 1; i <= months; i++) {
            BigDecimal interest = onlinePaymentService.interest(basicQuota, i);
            BigDecimal paymentFee = onlinePaymentService.paymentFee(basicQuota.add(interest));
            BigDecimal quota = basicQuota.add(interest.add(paymentFee));
            contract.getInstallments().add(new Installment(contract.getDate().plusMonths(i), quota));
        }        
    }
}