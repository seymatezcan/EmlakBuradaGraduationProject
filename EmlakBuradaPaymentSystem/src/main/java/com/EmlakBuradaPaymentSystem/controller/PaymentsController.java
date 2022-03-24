package com.EmlakBuradaPaymentSystem.controller;

import com.EmlakBuradaPaymentSystem.dto.PaymentRequest;
import com.EmlakBuradaPaymentSystem.dto.PaymentResponse;
import com.EmlakBuradaPaymentSystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/payments/paymentResponse")
    public Boolean savePayment(@RequestBody PaymentRequest paymentRequest, @RequestHeader(value = "enrolleeId")int enrolleeId) throws Exception {
        return paymentService.checkPayment(paymentRequest,enrolleeId);

    }
}
