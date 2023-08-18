package org.auditing.Config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQGovAgricultural extends RabbitMQConfig{
    public static final String AGRICULTURAL_EXCHANGE_NAME ="agriculture.v1.events";
    public static final String AGRICULTURAL_QUEUE_NAME_POST ="auditing.agricultural.v1.event.create";
    @Bean
    public Queue queueAgricultural(){
        return new Queue(AGRICULTURAL_QUEUE_NAME_POST);
    }
    @Bean
    public Binding AuditingToAgriculturalCreate(){
        Queue queue = new Queue(AGRICULTURAL_QUEUE_NAME_POST);
        FanoutExchange exchange = new FanoutExchange(AGRICULTURAL_EXCHANGE_NAME);
        return BindingBuilder.bind(queue).to(exchange);
    }

}
