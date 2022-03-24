package com.EmlakBurada.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@EnableRabbit
@Configuration
public class RabbitMqConfiguration {

    public static final String EXCHANGE_Pocket = "advertpocket.exchange";
    public static final String QUEUE_Pocket = "advertpocket.queue";
    public static final String ROUTING_Pocket = "advertpocket.routingkey";

    public static final String EXCHANGE_Status = "advertstatus.exchange";
    public static final String QUEUE_Status = "advertstatus.queue";
    public static final String ROUTING_Status = "advertstatus.routingkey";

    @Bean
    @Primary
    public Queue pocketQueue() {
        return new Queue(QUEUE_Pocket,false);
    }

    @Bean
    public Queue statusQueue() {
        return new Queue(QUEUE_Status,false);
    }

    @Bean
    @Primary
    public DirectExchange pocketExchange() {
        return new DirectExchange(EXCHANGE_Pocket);
    }

    @Bean
    public DirectExchange statusExchange() {
        return new DirectExchange(EXCHANGE_Status);
    }

    @Bean
    @Primary
    public Binding pocketBinding(Queue QUEUE_Pocket, DirectExchange exchange) {
        return BindingBuilder.bind(QUEUE_Pocket).to(exchange).with(ROUTING_Pocket);
    }

    @Bean
    public Binding statusBinding(@Qualifier ("statusQueue") Queue QUEUE_Status, DirectExchange exchange) {
        return BindingBuilder.bind(QUEUE_Status).to(exchange).with(ROUTING_Status);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
