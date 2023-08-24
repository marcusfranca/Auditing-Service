package org.auditing.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PutShopDto {

    @NotBlank(message = "Value of Field not be empty or null")
    public String name;
    @NotBlank(message = "Value of Field not be empty or null")
    public double value;
}
