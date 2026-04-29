package com.mealplanner.menu_service.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MenuEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void publishMenuValidated(UUID menuId) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ROUTING_KEY,
                menuId.toString()
        );
    }
}