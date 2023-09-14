package org.auditing.Config;

import com.Config.RabbitMQConfigGlobal;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//talvez nem precise herdar as configs, olhar depois
//pois A configuração padrão vai ficar em "memoria" - olhar isso depois
@Configuration
public class RabbitMQShop extends RabbitMQConfigGlobal {
    //Produtor
    public static final String SHOP_EXCHANGE_NAME ="shop.v1.events";

    //Queue
    public static final String SHOP_QUEUE_NAME_CREATED="auditing.v1.shop.event.create";
    public static final String SHOP_QUEUE_NAME_UPDATE="auditing.v1.shop.event.update";
    public static final String SHOP_QUEUE_NAME_DELETE="auditing.v1.shop.event.delete";
   // public static final String AUDITING_QUEUE_NAME ="auditing.v1.shop.events";
    //RoutingKey
    private static final String SHOP_CREATED_ROUTING_KEY = "shop.v1.product-created";
    private static final String SHOP_UPDATE_ROUTING_KEY = "shop.v1.product-update";
    private static final String SHOP_DELETE_ROUTING_KEY = "shop.v1.product-delete";
    //public static final String SHOP_EVENTS_ROUTING_KEY="shop.#";
    @Bean
    public Queue PostShop(){
        return new Queue(SHOP_QUEUE_NAME_CREATED);
    }
    @Bean
    public Queue PutShop(){
        return new Queue(SHOP_QUEUE_NAME_UPDATE);
    }
    @Bean
    public Queue DeleteShop(){
        return new Queue(SHOP_QUEUE_NAME_DELETE);
    }
    @Bean
    public Binding bindingToCreated(){
        Queue queue = new Queue(SHOP_QUEUE_NAME_CREATED);
        TopicExchange exchange = new TopicExchange(SHOP_EXCHANGE_NAME);
        return BindingBuilder.bind(queue).to(exchange).with(SHOP_CREATED_ROUTING_KEY);
    }

    @Bean
    public Binding bindingToUpdated(){
        Queue queue = new Queue(SHOP_QUEUE_NAME_UPDATE);
        TopicExchange exchange = new TopicExchange(SHOP_EXCHANGE_NAME);
        return BindingBuilder.bind(queue).to(exchange).with(SHOP_UPDATE_ROUTING_KEY);
    }

    @Bean
    public Binding bindingToDeleted(){
        Queue queue = new Queue(SHOP_QUEUE_NAME_DELETE);
        TopicExchange exchange = new TopicExchange(SHOP_EXCHANGE_NAME);
        return BindingBuilder.bind(queue).to(exchange).with(SHOP_DELETE_ROUTING_KEY);
    }
}
