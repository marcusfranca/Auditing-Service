package org.auditing.Config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Binding;

@Configuration
public class RabbitMQIncomeTax {
    public static final String INCOME_TAX_EXCHANGE_NAME="incometax.v1.events";
    public static final String  INCOME_TAX_QUEUE_POST ="auditing.incometax.v1.event.create";
    public static final String  INCOME_TAX_EVENT_HEADER_NAME = "incometax.event.type";
    public static final String  INCOME_TAX_EVENT_HEADER_VALUE ="incometax.create";

    @Bean
    public Queue queueAgricultural(){
        return new Queue(INCOME_TAX_QUEUE_POST);
    }
    @Bean
    public Binding AuditingToIncomeTaxCreate(){
        Queue queue = new Queue(INCOME_TAX_QUEUE_POST);
        HeadersExchange exchange = new HeadersExchange(INCOME_TAX_EXCHANGE_NAME);
        return BindingBuilder.bind(queue).to(exchange)
                .where(INCOME_TAX_EVENT_HEADER_NAME)
                .matches(INCOME_TAX_EVENT_HEADER_VALUE);
    }
}
