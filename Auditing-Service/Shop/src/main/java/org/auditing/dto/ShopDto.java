package org.auditing.dto;

import lombok.Data;

@Data
public class ShopDto { // criar validações e trocar o nome

    public Long id; // retirar esse id e depois colocar um extarnalId
    public String name;
    public double value;
    public Boolean isApproval;
}
