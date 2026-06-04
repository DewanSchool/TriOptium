package org.acme.domain;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private Long personId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private JobPosition position;

    public Employee() {
    }

    public Employee(Long personId, JobPosition position) {
        this.personId = personId;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public Long getPersonId() {
        return personId;
    }

    public JobPosition getPosition() {
        return position;
    }
}
