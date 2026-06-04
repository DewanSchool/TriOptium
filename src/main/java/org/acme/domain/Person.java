package org.acme.domain;



import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
public class Person {

    public enum Gender {
        MALE,
        FEMALE,
        OTHER,
        UNKNOWN
    }

    public enum MaritalStatus {
        SINGLE,
        MARRIED,
        DIVORCED,
        WIDOWED,
        REGISTERED_PARTNERSHIP
    }


    @Id
    @GeneratedValue
    private Long id;


    private String bsn;

    private String firstName;
    private String middleName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;


    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private String countryOfBirth;

    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    // Adresgegevens
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    // Reisdocumenten
    @OneToMany(cascade = CascadeType.ALL)
    private List<TravelDocument> travelDocuments;


    public Person() {}

    public Person(String bsn, String firstName, String middleName, String lastName,  LocalDate dateOfBirth, String placeOfBirth, String countryOfBirth, Gender gender, Address address, List<TravelDocument> travelDocuments) {
        this.bsn = bsn;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.countryOfBirth = countryOfBirth;
        this.maritalStatus = maritalStatus;
        this.address = address;
        this.travelDocuments = travelDocuments;
    }

    public Long getId() {
        return id;
    }

    public String getBsn() {
        return bsn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }


    public String getLastName() {
        return lastName;
    }


    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }


    public String getPlaceOfBirth() {
        return placeOfBirth;
    }


    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }


}
