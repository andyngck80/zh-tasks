package com.home.electric.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;


@Getter
public class ElectricConsumptionCounterDTO extends ElectricConsumptionCounterLogDTO {
    private Long id;

    public ElectricConsumptionCounterDTO(Long id, Long consumerId, BigDecimal consumption) {
        super(consumerId, consumption);
        this.id = id;
    }
}
