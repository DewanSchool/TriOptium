package org.acme.domain;

import jakarta.persistence.*;

import java.util.List;



@Entity
public class CitizenProfile {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    private IncomeRecord income;

    @OneToOne(cascade = CascadeType.ALL)
    private Organization organization;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Diploma> diplomas;


    public CitizenProfile() {
    }

    public CitizenProfile(
            Person person,
            IncomeRecord income,
            Organization organization,
            List<Vehicle> vehicles,
            List<Diploma> diplomas
    ) {
        this.person = person;
        this.income = income;
        this.organization = organization;
        this.vehicles = vehicles;
        this.diplomas = diplomas;
    }


    public Long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public IncomeRecord getIncome() {
        return income;
    }

    public Organization getOrganization() {
        return organization;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public List<Diploma> getDiplomas() {
        return diplomas;
    }
}
