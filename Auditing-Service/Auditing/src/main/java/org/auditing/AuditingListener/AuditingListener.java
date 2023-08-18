package org.auditing.AuditingListener;

import org.auditing.AuditingCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static org.auditing.Config.RabbitMQShop.*;

@Component
public class AuditingListener {

    /*@RabbitListener(queues = "shop.v1.shop-created.send-auditing")// com essa queue de consumer não vai aparecer o payload no rabbitmq, ja vai trazer no console
    public void onShopCreated(AuditingCreatedEvent event){
        System.out.println("Id recebido " + event.getId());
        System.out.println("Name recebido " + event.getName());
        System.out.println("Valor recebido " + event.getValue());
    }*/
    @RabbitListener(queues = SHOP_QUEUE_NAME_CREATED)
    public void onShopCreated(AuditingCreatedEvent event){
        System.out.println("QUEUE CREATED: ");
        System.out.println("Id recebido " + event.getId());
        System.out.println("Name recebido " + event.getName());
        System.out.println("Valor recebido " + event.getValue());
    }
    @RabbitListener(queues = SHOP_QUEUE_NAME_UPDATE)
    public void onShopUpdate(AuditingCreatedEvent event){
        System.out.println("QUEUE UPDATED: ");
        System.out.println("Id recebido " + event.getId());
        System.out.println("Name recebido " + event.getName());
        System.out.println("Valor recebido " + event.getValue());
    }
    @RabbitListener(queues = SHOP_QUEUE_NAME_DELETE)
    public void onShopDelete(AuditingCreatedEvent event){
        System.out.println("QUEUE DELETED: ");
        System.out.println("Id recebido " + event.getId());
        System.out.println("Name recebido " + event.getName());
        System.out.println("Valor recebido " + event.getValue());
    }

}
