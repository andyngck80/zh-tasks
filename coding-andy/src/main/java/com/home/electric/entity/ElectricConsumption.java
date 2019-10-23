package com.home.electric.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@Table(name = "electric_consumption")
@EntityListeners(AuditingEntityListener.class)
public class ElectricConsumption {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "consumer_id")
    private Long consumerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consumer_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ElectricConsumer consumer;

    private BigDecimal consumption;

    @CreatedDate
    private Instant createdDateTime;

}
