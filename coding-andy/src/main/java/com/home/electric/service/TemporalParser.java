package com.home.electric.service;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
public class TemporalParser {

    public Instant getTimeBefore(String duration) {
        // FIXME: logic to parse duration
        return Instant.now().minus(24, ChronoUnit.HOURS);
    }
}
