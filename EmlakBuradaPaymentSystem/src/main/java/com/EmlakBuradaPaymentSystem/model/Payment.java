package com.EmlakBuradaPaymentSystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Payments")
public class Payment {

    private String id;
    private int enrolleeId;
    private int advertPocketId;
    private double totalPrice;
    private Date date;

    public Payment(int enrolleeId, double totalPrice, LocalDateTime date){
        this.enrolleeId=enrolleeId;
        this.advertPocketId=advertPocketId;
        this.totalPrice=totalPrice;
    }
}
