package org.acme.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Organization {

    @Id
    @GeneratedValue
    private Long id;

    private String kvkNumber;

    private String name;

    private String legalForm;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Organization() {
    }

    public Organization(String kvkNumber, String name, String legalForm, List<Address> addresses, List<Employee> employees) {
        this.kvkNumber = kvkNumber;
        this.name = name;
        this.legalForm = legalForm;
        this.addresses = addresses;
        this.employees = employees;
    }

    public String getKvkNumber() {
        return kvkNumber;
    }

    public String getName() {
        return name;
    }

    public String getLegalForm() {
        return legalForm;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Long getId() {
        return id;
    }
}
