package com.home.electric.entity;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class VillageConsumptionData {
    private String village;
    private BigDecimal consumption;
}
