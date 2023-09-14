package org.auditing.Config;

import com.Config.RabbitMQConfigGlobal;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//   EXCHANGE : TOPIC
@Configuration
public class RabbitMQConfig extends RabbitMQConfigGlobal {
    public static final String SHOP_EXCHANGE_NAME = "shop.v1.events";


    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(SHOP_EXCHANGE_NAME);
    }
    /*@Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("shop.v1.product-created");
    }*/
}
