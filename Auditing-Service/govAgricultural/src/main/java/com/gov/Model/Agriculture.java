package com.gov.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_GovAgriculture")
public class Agriculture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String placeOfLand;
    public double valueOfLand;
    public LocalDateTime localDateTimeBuy;
}
