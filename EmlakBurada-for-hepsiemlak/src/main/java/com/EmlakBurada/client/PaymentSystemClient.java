package com.EmlakBurada.client;

import com.EmlakBurada.client.request.PaymentRequest;
import com.EmlakBurada.client.response.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="paymentSystemClient",url="http://localhost:8091/payments")
public interface PaymentSystemClient {

    @PostMapping("/paymentResponse")
    public Boolean savePayment(@RequestBody PaymentRequest paymentRequest, @RequestHeader(value = "enrollee_id")int enrollee_id);
}

