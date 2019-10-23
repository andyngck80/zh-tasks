package com.home.assignment.domain.homeLeasing;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Property {
    @Id
    private Long id;

    private String address;
    private HomeType type;
    private String geoPosition;
}
