package com.EmlakBuradaPaymentSystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class PaymentRequest {

    int enrolleeId;
    int advertPocketId;
    double totalPrice;

}
