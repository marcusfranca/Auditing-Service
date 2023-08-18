package org.auditing.Config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//   EXCHANGE : TOPIC
@Configuration
public class RabbitMQConfig {
    public static final String SHOP_EXCHANGE_NAME = "shop.v1.events";


    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(SHOP_EXCHANGE_NAME);
    }
    /*@Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("shop.v1.product-created");
    }*/
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> applicationReadyEventApplicationListener(
            RabbitAdmin rabbitAdmin) {
        return event -> rabbitAdmin.initialize(); // inicializando as configurações do RabbitADMIN
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
