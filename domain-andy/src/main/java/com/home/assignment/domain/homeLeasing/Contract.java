package com.home.assignment.domain.homeLeasing;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
public class Contract {
    @Id
    private Long id;
    private ContractType type;
    private Stage stage;
    private Long rentalInCents;
    private OffsetDateTime commenceDate;
    private OffsetDateTime endDate;

    @OneToMany
    private Set<ContractProperty> properties;

    @OneToMany
    private Set<ContractLandlord> landlords;

    @OneToMany
    private Set<ContractTenant> tenants;
}
