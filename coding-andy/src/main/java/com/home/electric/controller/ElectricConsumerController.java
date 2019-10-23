package com.home.electric.controller;

import com.home.electric.dto.ElectricConsumerDTO;
import com.home.electric.service.ElectricConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/electric-consumption")
public class ElectricConsumerController {

    private final ElectricConsumerService electricConsumerService;

    @GetMapping(value = "/consumer/{id}")
    public ElectricConsumerDTO get(@PathVariable("id") Long id) {
        return electricConsumerService.get(id);
    }
}
