package com.home.assignment.domain.homeLeasing;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"contract_id", "tenant_id"}))
public class ContractTenant {
    @Id
    private Long id;

    private Long contractId;
    private Long tenantId;
}
