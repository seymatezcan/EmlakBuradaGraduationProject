package com.EmlakBurada.queue;

import com.EmlakBurada.dto.response.AdvertResponse;
import com.EmlakBurada.model.Advert;
import com.EmlakBurada.model.AdvertPocket;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class RabbitMqAdvertStatusUpdater {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.status}")
    private String exchange;

    @Value("${rabbitmq.routingkey.status}")
    private String routingkey;

    public void updateAdvertStatus(Advert advert)  {
        rabbitTemplate.convertAndSend(exchange,routingkey,advert);

    }
}
