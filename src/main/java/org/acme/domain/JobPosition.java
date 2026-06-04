package org.acme.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class JobPosition {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String department;
    private boolean active;

    @OneToOne()
    private Employee employee;

    public JobPosition() {
    }

    public JobPosition(String title, String department, boolean active, Employee employee) {
        this.title = title;
        this.department = department;
        this.active = active;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDepartment() {
        return department;
    }

    public boolean isActive() {
        return active;
    }

    public Employee getEmployee() {
        return employee;
    }
}
