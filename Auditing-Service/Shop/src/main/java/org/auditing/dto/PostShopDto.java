package org.auditing.dto;

import lombok.Data;

@Data
public class PostShopDto {
    public Long id; // retirar esse id e depois colocar um extarnalId
    public String name;
    public double value;
}
