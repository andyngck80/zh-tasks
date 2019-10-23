package com.home.assignment.domain.homeLeasing;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("2")
@Entity
public class Tenant extends User {
}
