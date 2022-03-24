package com.AdvertStatus.model;

import com.AdvertStatus.model.enums.Category;
import com.AdvertStatus.model.enums.Currency;
import com.AdvertStatus.model.enums.PublicationType;
import com.AdvertStatus.model.enums.SubCategory;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "Advert ")
@SelectBeforeUpdate(true)
@DynamicUpdate(value = true)

public class Advert implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@Column(name="advertId", updatable=false)
    int advertId;
    AdvertStatus advertStatus;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE})
    Enrollee owner;
    String advertTitle;
    String advertDescription;
    private PublicationType publicationType;
    private Long price;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE})
    Address address;
    private LocalDate postedDay;
    private int roomCount;
    private int bathroomCount;
    private int livingRoomCount;
    private Currency currency;
    private Category category;
    private SubCategory subCategory;
    private int netSquareMeter; //netMetrekare
    private int buildingAge; //bina yaşı
    private String buildingStyle; //yapı şekli
    private int buildingFloorCount; //bina kat sayısı
    private  String buildingType; //konut tipi
    private String usingType; //kullanımdurumu
    private int dues; //aidat
    private String isInHousingEstate; //site içinde mi
    private String front; //cephe
    private String fitForTourVideoCall; //görüntülü arama ile gezilir mi

}

