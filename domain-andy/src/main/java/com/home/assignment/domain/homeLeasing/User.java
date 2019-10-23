package com.home.assignment.domain.homeLeasing;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.INTEGER,
        name = "type",
        columnDefinition = "TINYINT(1)"
)
@Entity
public class User {
    @Id
    private Long id;

    private String name;
    private String email;
    private Integer type;
}
