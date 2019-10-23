package com.home.electric.service;

import com.home.electric.dto.ElectricConsumptionCounterDTO;
import com.home.electric.dto.ElectricConsumptionCounterLogDTO;
import com.home.electric.dto.ElectricConsumptionReportDTO;
import com.home.electric.entity.ElectricConsumption;
import com.home.electric.entity.VillageConsumptionData;
import com.home.electric.repository.ElectricConsumptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ElectricConsumptionCounterService {

    private final ElectricConsumptionRepository electricConsumptionRepository;
    private final TemporalParser temporalParser;

    public Mono<ElectricConsumptionCounterDTO> log(ElectricConsumptionCounterLogDTO electricConsumptionCounter) {
        return Mono.just(toDto(electricConsumptionRepository.save(toEntity(electricConsumptionCounter))));
    }

    private ElectricConsumption toEntity(ElectricConsumptionCounterLogDTO dto) {
        ElectricConsumption electricConsumption = new ElectricConsumption();
        electricConsumption.setConsumerId(dto.getConsumerId());
        electricConsumption.setConsumption(dto.getConsumption());
        return electricConsumption;
    }

    private ElectricConsumptionCounterDTO toDto(ElectricConsumption entity) {
        return new ElectricConsumptionCounterDTO(entity.getId(), entity.getConsumerId(), entity.getConsumption());
    }

    public List<ElectricConsumptionReportDTO> getConsumption(String duration) {
        Instant timeBefore = temporalParser.getTimeBefore(duration);

        List<VillageConsumptionData> consumptions = electricConsumptionRepository.findByCreatedDateTimeAfter(timeBefore);

        return consumptions.stream()
                .map(consumption -> new ElectricConsumptionReportDTO(consumption.getVillage(), consumption.getConsumption()))
                .collect(Collectors.toList());
    }
}
