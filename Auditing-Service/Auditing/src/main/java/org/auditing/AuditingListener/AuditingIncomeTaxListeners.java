package org.auditing.AuditingListener;

import org.auditing.AuditingEvent.AuditingCreateEventIncomeTax;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static org.auditing.Config.RabbitMQIncomeTax.INCOME_TAX_QUEUE_POST;

@Component
public class AuditingIncomeTaxListeners {
    @RabbitListener(queues = INCOME_TAX_QUEUE_POST)
    public void onIncomeTaxCreated(AuditingCreateEventIncomeTax event){
        System.out.println("QUEUE CREATED: ");
        System.out.println("Id recebido " + event.getId());
        System.out.println("Name recebido " + event.getName());
        System.out.println("cpf Recebido " + event.getCpf());
        System.out.println("Valor recebido " + event.getValue());
    }
}
