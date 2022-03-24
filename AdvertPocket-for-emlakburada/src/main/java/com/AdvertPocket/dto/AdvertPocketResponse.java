package com.AdvertPocket.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

@Setter
@Getter
public class AdvertPocketResponse {

    int advertPocketId;
    int enrolleeId;
    int total=1; //tek seferde bir ilan paketi alınabilmektedir
    double totalPrice=30.95; //ilan paketi tutarı
    //int remainderDay=30; //kalan gün sayısı
    int countOfAdvertTenancy=10; //bir ilan paketi içindeki ilan yayınlama hakkı
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime creationDate;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime endDate;
    /*@CreatedDate
    @Column(updatable = false, nullable = true)
    ZonedDateTime creationDate;
    @CreatedDate
    @Column(updatable = false, nullable = true)
    ZonedDateTime endDate;*/


}
