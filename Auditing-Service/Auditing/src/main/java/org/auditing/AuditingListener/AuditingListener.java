package org.auditing.AuditingListener;

import org.auditing.AuditingCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AuditingListener {

    @RabbitListener(queues = "shop.v1.shop-created.send-auditing")// com essa queue de consumer não vai aparecer o payload no rabbitmq, ja vai trazer no console
    public void onShopCreated(AuditingCreatedEvent event){
        System.out.println("Id recebido " + event.getId());
        System.out.println("Id recebido " + event.getName());
        System.out.println("Valor recebido " + event.getValue());

    }
}
