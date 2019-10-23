package com.home.electric.repository;

import com.home.electric.entity.ElectricConsumption;
import com.home.electric.entity.VillageConsumptionData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface ElectricConsumptionRepository extends CrudRepository<ElectricConsumption, Long> {

    @Query("SELECT " +
            "    new com.home.electric.entity.VillageConsumptionData(c.villageName, sum(ecs.consumption)) " +
            "FROM " +
            "    ElectricConsumption ecs join ecs.consumer c " +
            "WHERE " +
            "    ecs.createdDateTime >= :dateTime " +
            "GROUP BY " +
            "    c.villageName")
    List<VillageConsumptionData> findByCreatedDateTimeAfter(@Param("dateTime") Instant dateTime);
}
