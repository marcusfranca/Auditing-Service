package org.auditing.AuditingEvent;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AuditingCreatedEventAgricultural {
    private Long id;
    private String placeOfLand;
    private double valueOfLand;
    private String localDateTimeBuy;

    public AuditingCreatedEventAgricultural(){}

    public AuditingCreatedEventAgricultural(Long id, String placeOfLand, double valueOfLand, String localDateTimeBuy){
        this.id = id;
        this.placeOfLand = placeOfLand;
        this.valueOfLand = valueOfLand;
        this.localDateTimeBuy = localDateTimeBuy;
    }
}
