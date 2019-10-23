package com.home.electric.dto;

import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class ElectricConsumerDTO {
    private final Long id;
    private final String villageName;
}
