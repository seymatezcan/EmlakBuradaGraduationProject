package com.AdvertPocket.service;


import com.AdvertPocket.model.AdvertPocket;
import com.AdvertPocket.repository.AdvertPocketRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Component
@Slf4j
@Service
@Getter
@DynamicUpdate
class RabbitMqListenerService {

    @Autowired
    AdvertPocketRepository advertPocketRepository;

    @RabbitListener(queues ="advertpocket.queue" )
    public void receivedAdvertPocket(AdvertPocket advertPocket) throws InterruptedException, MessagingException {
        advertPocket.setCreationDate(LocalDateTime.now());
        advertPocket.setEndDate(advertPocket.getCreationDate().plusDays(30));
        advertPocketRepository.save(advertPocket);
        log.info("Advert pocket created , ",advertPocket);
    }

}

