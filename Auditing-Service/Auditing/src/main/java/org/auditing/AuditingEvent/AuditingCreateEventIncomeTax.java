package org.auditing.AuditingEvent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuditingCreateEventIncomeTax {
    private Long id;

    public String name;
    public String cpf;
    public double value;
    // ver o pq desse cara não ta sendo usado..
    public AuditingCreateEventIncomeTax(){}

    public AuditingCreateEventIncomeTax(Long id, String name, String cpf, double value){
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.value = value;
    }
}
