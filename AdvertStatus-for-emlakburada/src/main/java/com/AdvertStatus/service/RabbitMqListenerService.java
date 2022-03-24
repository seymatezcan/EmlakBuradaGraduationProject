package com.AdvertStatus.service;
import com.AdvertStatus.model.Advert;
import com.AdvertStatus.model.AdvertStatus;
import com.AdvertStatus.repository.AdvertRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
@Service
@Getter
@DynamicUpdate
@Transactional
class RabbitMqListenerService {

    @Autowired
    AdvertRepository advertRepository;

    @RabbitListener(queues ="advertstatus.queue" )
    public void receive(Advert advert)  {
        advert.setAdvertStatus(AdvertStatus.ACTIVE);
        advertRepository.save(advert);
        log.info("Advert is active now ",advert);
    }

}

