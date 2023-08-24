package org.auditing.dto.EventCreate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopEventCreate {

    private Long id;
    private String name;
    private double value;

    public ShopEventCreate(){}

    public ShopEventCreate( Long id, String name, double value){
        this.id = id;
        this.name = name;
        this.value = value;
    }
}
