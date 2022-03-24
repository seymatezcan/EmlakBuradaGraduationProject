package com.EmlakBurada.service.base;

import com.EmlakBurada.dto.request.AdvertRequest;
import com.EmlakBurada.dto.response.AdvertResponse;
import com.EmlakBurada.model.Advert;
import com.EmlakBurada.model.Enrollee;
import com.EmlakBurada.model.enums.AdvertStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AdvertBaseService {

    public Advert convertToAdvertEntity(AdvertRequest advertRequest, Enrollee enrollee){
        Advert advert=new Advert();
        advert.setAdvertStatus(AdvertStatus.IN_REVIEW);
        advert.setAdvertTitle(advertRequest.getAdvertTitle());
        advert.setAdvertDescription(advertRequest.getAdvertDescription());
        advert.setCategory(advertRequest.getCategory());
        advert.setPublicationType(advertRequest.getPublicationType());
        advert.setSubCategory(advertRequest.getSubCategory());
        advert.setPrice(advertRequest.getPrice());
        advert.setOwner(enrollee);
        advert.setCurrency(advertRequest.getCurrency());
        advert.setBathroomCount(advertRequest.getBathroomCount());
        advert.setBuildingAge(advertRequest.getBuildingAge());
        advert.setBuildingFloorCount(advertRequest.getBuildingFloorCount());
        advert.setBuildingStyle(advertRequest.getBuildingStyle());
        advert.setBuildingType(advertRequest.getBuildingType());
        advert.setDues(advertRequest.getDues());
        advert.setFitForTourVideoCall(advertRequest.getFitForTourVideoCall());
        advert.setFront(advertRequest.getFront());
        advert.setIsInHousingEstate(advertRequest.getIsInHousingEstate());
        advert.setLivingRoomCount(advertRequest.getLivingRoomCount());
        advert.setNetSquareMeter(advertRequest.getNetSquareMeter());
        advert.setRoomCount(advertRequest.getRoomCount());
        advert.setUsingType(advertRequest.getUsingType());
        return advert;
    }

    public AdvertResponse convertToAdvertResponse(Advert advert){
        AdvertResponse advertResponse=new AdvertResponse();
        advertResponse.setAdvertStatus(advertResponse.getAdvertStatus());
        advertResponse.setAdvertTitle(advertResponse.getAdvertTitle());
        advertResponse.setAdvertDescription(advertResponse.getAdvertDescription());
        advertResponse.setCategory(advertResponse.getCategory());
        advertResponse.setPublicationType(advertResponse.getPublicationType());
        advertResponse.setSubCategory(advertResponse.getSubCategory());
        advertResponse.setPrice(advertResponse.getPrice());
        advertResponse.setCurrency(advertResponse.getCurrency());
        advertResponse.setBathroomCount(advertResponse.getBathroomCount());
        advertResponse.setBuildingAge(advertResponse.getBuildingAge());
        advertResponse.setBuildingFloorCount(advertResponse.getBuildingFloorCount());
        advertResponse.setBuildingStyle(advertResponse.getBuildingStyle());
        advertResponse.setBuildingType(advertResponse.getBuildingType());
        advertResponse.setDues(advertResponse.getDues());
        advertResponse.setFitForTourVideoCall(advertResponse.getFitForTourVideoCall());
        advertResponse.setFront(advertResponse.getFront());
        advertResponse.setIsInHousingEstate(advertResponse.getIsInHousingEstate());
        advertResponse.setLivingRoomCount(advertResponse.getLivingRoomCount());
        advertResponse.setNetSquareMeter(advertResponse.getNetSquareMeter());
        advertResponse.setRoomCount(advertResponse.getRoomCount());
        advertResponse.setUsingType(advertResponse.getUsingType());
        return advertResponse;
    }

    public Advert convertToAdvertEntity(AdvertResponse advertResponse){
        Advert advert=new Advert();
        advert.setAdvertStatus(advertResponse.getAdvertStatus());
        return advert;
    }

}
