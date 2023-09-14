package com.gov.Config;

import com.Config.RabbitMQConfigGlobal;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// EXCHANGE : Fanoult
@Configuration
public class RabbitMQConfig extends RabbitMQConfigGlobal {
    public static final String AGRICULTURAL_EXCHANGE_NAME ="agriculture.v1.events";
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(AGRICULTURAL_EXCHANGE_NAME);
    }
}
