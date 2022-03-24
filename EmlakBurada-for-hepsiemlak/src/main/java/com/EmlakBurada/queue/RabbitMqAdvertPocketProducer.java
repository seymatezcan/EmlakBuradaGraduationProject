package com.EmlakBurada.queue;

import com.EmlakBurada.model.AdvertPocket;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class RabbitMqAdvertPocketProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.pocket}")
    private String exchange;

    @Value("${rabbitmq.routingkey.pocket}")
    private String routingkey;

    public void createAdvertPocket(AdvertPocket advertPocket) throws InterruptedException {
        rabbitTemplate.convertAndSend(exchange,routingkey,advertPocket);

    }
}
