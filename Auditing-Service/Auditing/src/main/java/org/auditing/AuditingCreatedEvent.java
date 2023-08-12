package org.auditing;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuditingCreatedEvent {

    private Long id;

    private String name;
    private double value;

    public AuditingCreatedEvent(){}

    public AuditingCreatedEvent(Long id, String name, double value){
        this.id = id;
        this.name = name;
        this.value = value;
    }
}
