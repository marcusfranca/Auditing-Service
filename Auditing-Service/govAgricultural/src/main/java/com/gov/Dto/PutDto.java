package com.gov.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PutDto {

    @NotBlank(message = "Value of Field not be empty or null")
    public String placeOfLand;
    @NotBlank(message = "Value of Field not be empty or null")
    public double valueOfLand;
    public String localDateTimeBuy;
}
