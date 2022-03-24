package com.EmlakBurada.service;

import com.EmlakBurada.dto.request.AdvertRequest;

import com.EmlakBurada.dto.response.AdvertResponse;
import com.EmlakBurada.model.Advert;
import com.EmlakBurada.model.Enrollee;
import com.EmlakBurada.model.enums.AdvertStatus;
import com.EmlakBurada.queue.RabbitMqAdvertStatusUpdater;
import com.EmlakBurada.repository.AdvertRepository;
import com.EmlakBurada.repository.EnrolleeRepository;
import com.EmlakBurada.service.base.AdvertBaseService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
//import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvertService extends AdvertBaseService {

    @Autowired
    AdvertRepository advertRepository;

    @Autowired
    RabbitMqAdvertStatusUpdater advertStatusUpdater;

    @Autowired
    EnrolleeRepository enrolleeRepository;

    @Autowired
    AdvertPocketService advertPocketService;

    public void saveAdvert(AdvertRequest advertRequest,int enrolleeId) throws Exception {

        isEnrolleeHasAdvertPocket(enrolleeId);
        Enrollee enrollee=enrolleeRepository.findById(enrolleeId);
        advertRequest.setEnrolleeId(enrolleeId);
        advertRepository.save(convertToAdvertEntity(advertRequest,enrollee));
        activateAdvert(convertToAdvertEntity(advertRequest,enrollee));
        advertPocketService.decreaseAdvertPocket(enrolleeId);

    }

    public void activateAdvert(Advert advert) {
        advertStatusUpdater.updateAdvertStatus(advert);
    }

    public void updateAdvertStatusPassive(Advert advert){
        advert.setAdvertStatus(AdvertStatus.DEACTIVE);
        advertRepository.save(advert);
    }

    public void updateAdvertStatusActive(Advert advert) {
        advert.setAdvertStatus(AdvertStatus.ACTIVE);
        advertRepository.save(advert);
    }

    public List<AdvertResponse> getAll() {
        List<Advert>adverts=advertRepository.findAll();
        return adverts.stream().map(advert -> convertToAdvertResponse(advert)).collect(Collectors.toList());
    }

    public void deleteAdvert(int advertId){
        advertRepository.deleteById(advertId);
    }

    public void editAdvert(AdvertRequest advertRequest,int enrolleeId){
        Enrollee enrollee=enrolleeRepository.findById(enrolleeId);
        advertRequest.setEnrolleeId(enrolleeId);
        advertRepository.save(convertToAdvertEntity(advertRequest,enrollee));
    }

    public Boolean isEnrolleeHasAdvertPocket(int enrolleeId){
        return advertPocketService.isEnrolleeHasAdvertPocket(enrolleeId);
    }

    public Advert getActiveAdverts(int enrolleeId){
        return advertRepository.findActivesByEnrolleeId(enrolleeId);
    }

    public Advert getPassiveAdverts(int enrolleeId){
        return advertRepository.findPassivesByEnrolleeId(enrolleeId);
    }

}
