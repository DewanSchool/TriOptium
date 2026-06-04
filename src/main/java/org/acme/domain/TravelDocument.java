package org.acme.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class TravelDocument {
    public enum TravelDocumentType {
        PASSPORT,
        ID_CARD
    }

    @Id
    @GeneratedValue
    private Long id;
    private String documentNumber;

    @Enumerated(EnumType.STRING)
    private TravelDocumentType type;

    private LocalDate issuedAt;

    private LocalDate expiresAt;

    private String issuingAuthority;

    public TravelDocument() {
    }

    public TravelDocument(String documentNumber, TravelDocumentType type, LocalDate issuedAt, LocalDate expiresAt, String issuingAuthority) {
        this.documentNumber = documentNumber;
        this.type = type;
        this.issuedAt = issuedAt;
        this.expiresAt = expiresAt;
        this.issuingAuthority = issuingAuthority;
    }

    public Long getId() {
        return id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public TravelDocumentType getType() {
        return type;
    }

    public LocalDate getIssuedAt() {
        return issuedAt;
    }

    public LocalDate getExpiresAt() {
        return expiresAt;
    }

    public String getIssuingAuthority() {
        return issuingAuthority;
    }
}
