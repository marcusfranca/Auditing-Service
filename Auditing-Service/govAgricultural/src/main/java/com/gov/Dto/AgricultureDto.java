package com.gov.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AgricultureDto {

    public String placeOfLand;
    public double valueOfLand;
    public LocalDateTime localDateTimeBuy;
}
