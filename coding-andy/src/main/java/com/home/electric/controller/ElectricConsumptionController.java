package com.home.electric.controller;

import com.home.electric.dto.ElectricConsumptionCounterDTO;
import com.home.electric.dto.ElectricConsumptionCounterLogDTO;
import com.home.electric.service.ElectricConsumptionCounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/electric-consumption")
public class ElectricConsumptionController {

    private final ElectricConsumptionCounterService electricConsumptionCounterService;

    @PostMapping(value = "/counter")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ElectricConsumptionCounterDTO> log(@RequestBody ElectricConsumptionCounterLogDTO electricConsumptionCounter) {
        return electricConsumptionCounterService.log(electricConsumptionCounter);
    }

}
