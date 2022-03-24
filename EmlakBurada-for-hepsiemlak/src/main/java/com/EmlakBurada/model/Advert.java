package com.EmlakBurada.model;

import com.EmlakBurada.model.enums.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int advertId;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    Enrollee owner;
    String advertTitle;
    String advertDescription;
    private PublicationType publicationType;
    private Long price;
    AdvertStatus advertStatus;
    @ManyToOne
    Address address;
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
    //@OneToMany
    //private List<Image> imageList=new ArrayList<Image>(); //new lemediğimde hata verdi.


    public Advert(Long price, String advertTitle, String advertDescription){
        this.price=price;
        this.advertTitle=advertTitle;
        this.advertDescription=advertDescription;
    }
    public Advert(String advertTitle){
        this.advertTitle=advertTitle;
    }


}
