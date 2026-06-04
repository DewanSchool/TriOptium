package org.acme.domain;

import jakarta.persistence.*;

@Entity
public class IncomeRecord {

    public enum IncomeType {
        EMPLOYMENT,
        BENEFIT,
        PENSION,
        OTHER
    }
    @Id
    @GeneratedValue
    private Long id;

    private String citizenServiceNumber;

    private int yearlyIncome;

    @Enumerated(EnumType.STRING)
    private IncomeType type;

    private int taxYear;

    public IncomeRecord() {
    }

    public IncomeRecord(String citizenServiceNumber, int yearlyIncome, IncomeType type, int taxYear) {
        this.citizenServiceNumber = citizenServiceNumber;
        this.yearlyIncome = yearlyIncome;
        this.type = type;
        this.taxYear = taxYear;
    }

    public Long getId() {
        return id;
    }

    public String getCitizenServiceNumber() {
        return citizenServiceNumber;
    }

    public int getYearlyIncome() {
        return yearlyIncome;
    }

    public IncomeType getType() {
        return type;
    }

    public int getTaxYear() {
        return taxYear;
    }
}
