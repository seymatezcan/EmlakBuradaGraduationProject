package com.EmlakBuradaPaymentSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class PaymentResponse {

    Boolean isSuccess;
    LocalDate localDate;
    LocalDateTime localDateTime;
    int enrolleeId;
}
