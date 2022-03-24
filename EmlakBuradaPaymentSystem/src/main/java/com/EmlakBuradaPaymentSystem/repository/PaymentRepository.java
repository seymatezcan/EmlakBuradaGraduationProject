package com.EmlakBuradaPaymentSystem.repository;

import com.EmlakBuradaPaymentSystem.dto.PaymentRequest;
import com.EmlakBuradaPaymentSystem.model.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Log,String> {

}
