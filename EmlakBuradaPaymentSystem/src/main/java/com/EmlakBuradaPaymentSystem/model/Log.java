package com.EmlakBuradaPaymentSystem.model;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "Logs")
public class Log {

    private String id;
    private LocalDateTime date;
    private String level;
    private String message;
    private int enrolleeId;

    public Log(String message){
        this.message=message;
    }
}

