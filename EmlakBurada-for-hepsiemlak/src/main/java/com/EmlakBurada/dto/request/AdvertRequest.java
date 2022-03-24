package com.EmlakBurada.dto.request;

import com.EmlakBurada.model.Address;
import com.EmlakBurada.model.Enrollee;
import com.EmlakBurada.model.enums.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AdvertRequest {

    int enrolleeId;
    String advertTitle;
    String advertDescription;
    private PublicationType publicationType;
    private Long price;
    private Category category;
    private SubCategory subCategory;
    Address address;
    private LocalDate postedDay;
    private int roomCount;
    private int bathroomCount;
    private int livingRoomCount;
    private Currency currency;
    private int netSquareMeter; //netMetrekare
    private int buildingAge; //bina yaşı
    private String buildingStyle; //yapı şekli
    private int buildingFloorCount; //bina kat sayısı
    private  String buildingType; //konut tipi
    private String usingType; //kullanımdurumu
    private int dues; //aidat
    private String isInHousingEstate; //site içinde mi
    private String front; //cephe
    private String fitForTourVideoCall;


}
