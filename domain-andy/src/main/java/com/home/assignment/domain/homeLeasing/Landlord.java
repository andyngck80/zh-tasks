package com.home.assignment.domain.homeLeasing;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@DiscriminatorValue("1")
@Entity
public class Landlord extends User {
}