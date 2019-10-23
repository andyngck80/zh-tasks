package com.home.electric.dto;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class ElectricConsumptionReportDTO {
    private final String village;
    private final BigDecimal consumption;
}
