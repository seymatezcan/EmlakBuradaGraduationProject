package com.EmlakBurada.service;

import com.EmlakBurada.client.PaymentSystemClient;
import com.EmlakBurada.client.request.PaymentRequest;
import com.EmlakBurada.dto.request.AdvertPocketRequest;
import com.EmlakBurada.model.AdvertPocket;
import com.EmlakBurada.model.Enrollee;
import com.EmlakBurada.queue.RabbitMqAdvertPocketProducer;
import com.EmlakBurada.repository.AdvertPocketRepository;
import com.EmlakBurada.repository.EnrolleeRepository;
import com.EmlakBurada.service.base.AdvertPocketBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class AdvertPocketService {



    @Autowired
    PaymentSystemClient paymentSystemClient;

    @Autowired
    RabbitMqAdvertPocketProducer advertPocketProducer;

    @Autowired
    AdvertPocketBaseService advertPocketBaseService;

    @Autowired
    AdvertPocketRepository advertPocketRepository;

    @Autowired
    EnrolleeRepository enrolleeRepository;



    public void saveAdvertPocket(AdvertPocketRequest advertPocketRequest,int enrolleeId) throws InterruptedException {
        PaymentRequest paymentRequest=new PaymentRequest(enrolleeId);
        if(paymentSystemClient.savePayment(paymentRequest,enrolleeId)){
            Enrollee enrollee=enrolleeRepository.findById(enrolleeId);
            advertPocketRequest.setEnrolleeId(enrolleeId);
            AdvertPocket advertPocket = advertPocketRepository.findByEnrolleeId(enrolleeId);

            if(advertPocket != null) {

                LocalDateTime previousEndDate = advertPocket.getEndDate();
                LocalDateTime date=advertPocket.getCreationDate();
                LocalDateTime newEndDate= previousEndDate.plusDays(30);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime dateTime = LocalDateTime.of(1986, Month.APRIL, 8, 12, 30);
                String formattedDateTime = dateTime.format(formatter);
                //advertPocket.setDate(formattedDateTime);
                advertPocketRequest.setCountOfAdvertTenancy(advertPocketRequest.getCountOfAdvertTenancy() +10);
                advertPocketProducer.createAdvertPocket(advertPocketBaseService.convertToAdvertPocketEntity(advertPocketRequest,enrollee));

            }

            else {

                LocalDateTime newEndDate=LocalDateTime.now().plusDays(30);
                advertPocketRequest.setEndDate(newEndDate);
                advertPocketRequest.setDate(LocalDateTime.now());
                advertPocketProducer.createAdvertPocket(advertPocketBaseService.convertToAdvertPocketEntity(advertPocketRequest,enrollee));
            }

        }

    }

    public Boolean isEnrolleeHasAdvertPocket(int enrolleeId) {
        Optional<AdvertPocket> advertPocket=advertPocketRepository.findById(enrolleeId);
        if(advertPocket!=null){
            return true;
        }
        return false;
    }

    public int getTenancyOfAdverts(int enrolleeId){
        AdvertPocket advertPocket = advertPocketRepository.findByEnrolleeId(enrolleeId);
        return advertPocket.getCountOfAdvertTenancy();
    }

    public void decreaseAdvertPocket(int enrolleeId) throws Exception {
        AdvertPocket advertPocket = advertPocketRepository.findByEnrolleeId(enrolleeId);
        if (advertPocket.getCountOfAdvertTenancy() > 0) {
            advertPocket.setCountOfAdvertTenancy(advertPocket.getCountOfAdvertTenancy() - 1);
        } else {
            throw new Exception("You have not an advert pocket! ");
        }

    }

    /*public void increaseAdvertPocket(AdvertPocket advertPocket,int enrolleeId) throws Exception {

        advertPocket.setCountOfAdvertTenancy(advertPocket.getCountOfAdvertTenancy() +10);
    }*/

}
