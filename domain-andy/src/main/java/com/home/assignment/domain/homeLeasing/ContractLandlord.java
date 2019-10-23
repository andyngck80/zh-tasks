package com.home.assignment.domain.homeLeasing;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"contract_id", "landlord_id"}))
public class ContractLandlord {
    @Id
    private Long id;

    private Long contractId;
    private Long landlordId;
}
