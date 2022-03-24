package com.EmlakBurada.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

@Getter
@Setter
public class AdvertPocketRequest {

    int enrolleeId;
    int advertPocketId;
    int total=1; //tek seferde bir ilan paketi alınabilmektedir
    double totalPrice=30.95; //ilan paketi tutarı
    int countOfAdvertTenancy=10; //bir ilan paketi içindeki ilan yayınlama hakkı
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime endDate=LocalDateTime.now().plusDays(30);
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime date=LocalDateTime.now();


}
