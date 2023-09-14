package com.gov.Config;

import com.Config.RabbitMQConfigGlobal;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// EXCHANGE : HEADER
// utilizar um nome melhor nesse cara
@Configuration
public class RabbitMQConfig extends RabbitMQConfigGlobal {

    public static final String INCOME_TAX_EXCHANGE_NAME="incometax.v1.events";

    @Bean
    public HeadersExchange HeaderExchange() {
        return new HeadersExchange(INCOME_TAX_EXCHANGE_NAME);
    }

}
