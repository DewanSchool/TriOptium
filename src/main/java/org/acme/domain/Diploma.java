package org.acme.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Diploma {
    public enum DegreeLevel {

        MBO,
        HBO,
        UNIVERSITY,
        OTHER
    }

    @Id
    @GeneratedValue
    private Long id;

    private String diplomaId;

    private Long personId;

    private String institution;

    private String study;

    private LocalDate graduationDate;

    @Enumerated(EnumType.STRING)
    private DegreeLevel level;

    public Diploma() {
    }

    public Diploma(String diplomaId, Long personId, String institution, String study, LocalDate graduationDate, DegreeLevel level) {
        this.diplomaId = diplomaId;
        this.personId = personId;
        this.institution = institution;
        this.study = study;
        this.graduationDate = graduationDate;
        this.level = level;
    }

    public String getDiplomaId() {
        return diplomaId;
    }

    public Long getPersonId() {
        return personId;
    }

    public String getInstitution() {
        return institution;
    }

    public String getStudy() {
        return study;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public DegreeLevel getLevel() {
        return level;
    }
}
