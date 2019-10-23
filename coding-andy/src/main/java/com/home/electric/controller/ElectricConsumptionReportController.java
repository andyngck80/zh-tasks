package com.home.electric.controller;

import com.home.electric.dto.ElectricConsumptionReportDTO;
import com.home.electric.service.ElectricConsumptionCounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/electric-consumption")
public class ElectricConsumptionReportController {

    private final ElectricConsumptionCounterService electricConsumptionCounterService;

    @GetMapping(value = "/report")
    public List<ElectricConsumptionReportDTO> getReport(@RequestParam("duration") String duration) {
        return electricConsumptionCounterService.getConsumption(duration);
    }

    @GetMapping(value = "/report/{village}")
    public ElectricConsumptionReportDTO getReportByCity(@PathVariable("village") String village) {
        return new ElectricConsumptionReportDTO(village, BigDecimal.ZERO);
    }
}
