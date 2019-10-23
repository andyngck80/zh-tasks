package com.home.electric.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class ElectricConsumptionCounterLogDTO {
    private final Long consumerId;
    private final BigDecimal consumption;
}
