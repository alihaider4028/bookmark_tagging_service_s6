package com.anushka.bookmark_tagging_s6.publisher;

import com.anushka.bookmark_tagging_s6.entity.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RabbitMQEventProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQEventProducer.class);

    private RabbitTemplate rabbitTemplate;

    public RabbitMQEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(Optional<Event> resp){
        LOGGER.info(String.format("Json message sent -> %s", resp.toString()));
        rabbitTemplate.convertAndSend(exchange, routingKey, resp.get());
    }


}
