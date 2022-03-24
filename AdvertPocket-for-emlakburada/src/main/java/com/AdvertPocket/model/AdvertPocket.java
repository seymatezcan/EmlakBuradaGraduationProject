package com.AdvertPocket.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
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
    int enrolleeId;
    int total=1; //tek seferde bir ilan paketi alınabilmektedir
    double totalPrice=30.95; //ilan paketi tutarı
    int countOfAdvertTenancy=10; //bir ilan paketi içindeki ilan yayınlama hakkı
    int remainderDay=30;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime endDate;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    LocalDateTime creationDate;

}
