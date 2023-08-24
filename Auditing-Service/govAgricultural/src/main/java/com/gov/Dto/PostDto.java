package com.gov.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PostDto {

    @NotBlank(message = "Value of Field not empty or null")
    public String placeOfLand;
    @NotBlank(message = "Value of Field not empty or null")
    public double valueOfLand;
    public String localDateTimeBuy;
}
