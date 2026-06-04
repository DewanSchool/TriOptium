package org.acme.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Vehicle {

    public enum VehicleStatus {
        ACTIVE,
        EXPORTED,
        SUSPENDED
    }

    @Id
    @GeneratedValue
    private Long id;
    private String licensePlate;

    private String brand;

    private String model;

    private int year;

    @Enumerated(EnumType.STRING)
    private VehicleStatus status;

    private LocalDate apkExpiry;


    public Vehicle(String licensePlate, String brand, String model, int year, VehicleStatus status, LocalDate apkExpiry) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.status = status;
        this.apkExpiry = apkExpiry;
    }

    public Vehicle() {
    }

    public Long getId() {
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public LocalDate getApkExpiry() {
        return apkExpiry;
    }
}
