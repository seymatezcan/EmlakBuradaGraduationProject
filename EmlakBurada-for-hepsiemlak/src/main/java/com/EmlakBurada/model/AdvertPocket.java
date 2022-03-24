package com.EmlakBurada.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class AdvertPocket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int advertPocketId;
    @Column(unique = true)
    int enrolleeId;
    int total=1; //tek seferde bir ilan paketi alınabilmektedir
    double totalPrice=30.95; //ilan paketi tutarı
    int countOfAdvertTenancy=10; //bir ilan paketi içindeki ilan yayınlama hakkı
    @Column(columnDefinition = "endDate")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime endDate;
    @Column(columnDefinition = "creationDate")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime creationDate;

}
