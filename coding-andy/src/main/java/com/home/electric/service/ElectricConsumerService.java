package com.home.electric.service;

import com.home.electric.dto.ElectricConsumerDTO;
import com.home.electric.repository.ElectricConsumerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Service
public class ElectricConsumerService {

    private final ElectricConsumerRepository electricConsumerRepository;

    public ElectricConsumerDTO get(Long id) {
        return electricConsumerRepository.findById(id)
                .map(entity -> new ElectricConsumerDTO(entity.getId(), entity.getVillageName()))
                .orElseThrow(EntityNotFoundException::new);
    }
}
