package com.gov.Dto.Event;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncomeEventCreate {
    public String name;
    public String cpf;
    public double value;
}
