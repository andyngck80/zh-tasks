package com.home.electric.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "electric_consumer")
public class ElectricConsumer {
    @Id
    @GeneratedValue
    private Long id;

    private String villageName;
}
