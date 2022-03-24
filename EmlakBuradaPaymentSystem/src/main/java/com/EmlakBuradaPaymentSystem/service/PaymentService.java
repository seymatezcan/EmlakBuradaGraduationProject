package com.EmlakBuradaPaymentSystem.service;

import com.EmlakBuradaPaymentSystem.dto.PaymentRequest;
import com.EmlakBuradaPaymentSystem.dto.PaymentResponse;
import com.EmlakBuradaPaymentSystem.model.Log;
import com.EmlakBuradaPaymentSystem.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class PaymentService {

    @Autowired
    MongoTemplate mongoTemplate;

    public Boolean checkPayment(PaymentRequest paymentRequest,int enrolleeId) throws Exception {
        boolean paymentResult = Boolean.TRUE; // that value is predefined true because of we don't have actual payment system

        PaymentResponse paymentResponse = new PaymentResponse();
        Log log = new Log();
        log.setLevel("INFO");
        log.setDate(LocalDateTime.now());
        log.setMessage("success");
        log.setEnrolleeId(enrolleeId);

        if (paymentResult){
            paymentResponse.setIsSuccess(Boolean.TRUE);
            Payment payment = new Payment(enrolleeId,paymentRequest.getTotalPrice(),LocalDateTime.now());
            mongoTemplate.insert(payment);
            log.setMessage("payment success");
        } else {
            paymentResponse.setIsSuccess(Boolean.FALSE);
            log.setMessage("payment failed");
        }

        mongoTemplate.insert(log);

        return paymentResponse.getIsSuccess();
    }

}
