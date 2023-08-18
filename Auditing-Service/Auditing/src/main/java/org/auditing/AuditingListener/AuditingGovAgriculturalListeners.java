package org.auditing.AuditingListener;

import org.auditing.AuditingEvent.AuditingCreatedEventAgricultural;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static org.auditing.Config.RabbitMQGovAgricultural.AGRICULTURAL_QUEUE_NAME_POST;

@Component
public class AuditingGovAgriculturalListeners {

    @RabbitListener(queues = AGRICULTURAL_QUEUE_NAME_POST)
    public void onAgriculturalCreate(AuditingCreatedEventAgricultural event){
        System.out.println("QUEUE CREATED: ");
        System.out.println("Id recebido " + event.getId());
        System.out.println("Land recebido " + event.getPlaceOfLand());
        System.out.println("Valor recebido " + event.getValueOfLand());
        System.out.println("Time recebido " + event.getLocalDateTimeBuy());
    }
}
