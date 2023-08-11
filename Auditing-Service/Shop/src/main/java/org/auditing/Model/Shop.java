package org.auditing.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_Shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String name;

    public double value;

}
