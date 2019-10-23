package com.home.electric.repository;

import com.home.electric.entity.ElectricConsumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ElectricConsumerRepository extends JpaRepository<ElectricConsumer, Long> {
}
