//package org.acme.application;
//
//
//import jakarta.annotation.PostConstruct;
//import jakarta.enterprise.context.ApplicationScoped;
//import jakarta.inject.Inject;
//import jakarta.persistence.EntityManager;
//import jakarta.transaction.Transactional;
//
//import org.acme.domain.*;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.List;
//
//@ApplicationScoped
//public class DatabaseSeeder {
//
//    @Inject
//    EntityManager em;
//
//    @PostConstruct
//    @Transactional
//    public void init() {
//
//        // =========================
//        // CLEAN DATABASE
//        // =========================
//        em.createQuery("DELETE FROM CitizenProfile").executeUpdate();
//        em.createQuery("DELETE FROM Diploma").executeUpdate();
//        em.createQuery("DELETE FROM Vehicle").executeUpdate();
//        em.createQuery("DELETE FROM IncomeRecord").executeUpdate();
//        em.createQuery("DELETE FROM Organization").executeUpdate();
//        em.createQuery("DELETE FROM Person").executeUpdate();
//        em.createQuery("DELETE FROM Address").executeUpdate();
//
//        // =========================
//        // ADDRESSES
//        // =========================
//        Address a1 = new Address("Lange Voorhout", "12A", "2514ED", "Den Haag", "Nederland");
//        Address a2 = new Address("Coolsingel", "100", "3012AG", "Rotterdam", "Nederland");
//        Address a3 = new Address("Herengracht", "77", "1015BR", "Amsterdam", "Nederland");
//        Address a4 = new Address("Stationsplein", "5", "3511ED", "Utrecht", "Nederland");
//
//        em.persist(a1);
//        em.persist(a2);
//        em.persist(a3);
//        em.persist(a4);
//
//        // =========================
//        // PERSONEN (BRP)
//        // =========================
//        Person p1 = new Person(
//                "111111111",
//                "Jan",
//                "de",
//                "Vries",
//                LocalDate.of(1990, 5, 14),
//                "Rotterdam",
//                "Nederland",
//                Person.Gender.MALE,
//                a2,
//                List.of()
//        );
//
//        Person p2 = new Person(
//                "222222222",
//                "Fatima",
//                null,
//                "El Amrani",
//                LocalDate.of(1988, 11, 2),
//                "Amsterdam",
//                "Nederland",
//                Person.Gender.FEMALE,
//                a3,
//                List.of()
//        );
//
//        Person p3 = new Person(
//                "333333333",
//                "Sven",
//                "van",
//                "Dijk",
//                LocalDate.of(1995, 3, 21),
//                "Utrecht",
//                "Nederland",
//                Person.Gender.MALE,
//                a4,
//                List.of()
//        );
//
//        em.persist(p1);
//        em.persist(p2);
//        em.persist(p3);
//
//        // =========================
//        // INKOMENS (Belastingdienst)
//        // =========================
//        IncomeRecord i1 = new IncomeRecord("2025", 52000, IncomeRecord.IncomeType.EMPLOYMENT, 2025);
//        IncomeRecord i2 = new IncomeRecord("2025",31000, IncomeRecord.IncomeType.EMPLOYMENT, 2026);
//        IncomeRecord i3 = new IncomeRecord("2025", 18000, IncomeRecord.IncomeType.BENEFIT, 2027);
//
//        em.persist(i1);
//        em.persist(i2);
//        em.persist(i3);
//
//        // =========================
//        // ORGANISATIES (KVK)
//        // =========================
//        Organization o1 = new Organization(
//                "27364291",
//                "TechNova BV",
//                "BV",
//                List.of(a1),
//                List.of()
//        );
//
//        Organization o2 = new Organization(
//                "58492011",
//                "Rotterdam Logistics",
//                "NV",
//                List.of(a2),
//                List.of()
//        );
//
//        Organization o3 = new Organization(
//                "90218374",
//                "Utrecht Zorggroep",
//                "Stichting",
//                List.of(a4),
//                List.of()
//        );
//
//        em.persist(o1);
//        em.persist(o2);
//        em.persist(o3);
//
//        // =========================
//        // VOERTUIGEN (RDW)
//        // =========================
//        Vehicle v1 = new Vehicle("AB-123-CD", "Volkswagen", "Golf", 2026, Vehicle.VehicleStatus.ACTIVE, LocalDate.of(2025, 6, 10));
//        Vehicle v2 = new Vehicle("XY-987-ZZ", "Toyota", "Corolla", 2026, Vehicle.VehicleStatus.ACTIVE, LocalDate.of(2025, 6, 10));
//        Vehicle v3 = new Vehicle("GH-456-KL", "Tesla", "Model 3", 2026, Vehicle.VehicleStatus.ACTIVE, LocalDate.of(2025, 6, 10));
//
//        em.persist(v1);
//        em.persist(v2);
//        em.persist(v3);
//
//        // =========================
//        // DIPLOMA'S (DUO)
//        // =========================
//        Diploma d1 = new Diploma(
//                "DIP-2018-001",
//                1L,
//                "Hogeschool Rotterdam",
//                "Software Engineering",
//                LocalDate.of(2018, 6, 30),
//                Diploma.DegreeLevel.HBO
//        );
//
//        Diploma d2 = new Diploma(
//                "DIP-2015-002",
//                1L,
//                "Universiteit van Amsterdam",
//                "Bedrijfskunde",
//                LocalDate.of(2015, 7, 1),
//                Diploma.DegreeLevel.UNIVERSITY
//        );
//
//        Diploma d3 = new Diploma(
//                "DIP-2020-003",
//                1L,
//                "ROC Utrecht",
//                "ICT Beheer",
//                LocalDate.of(2020, 6, 20),
//                Diploma.DegreeLevel.MBO
//        );
//
//        em.persist(d1);
//        em.persist(d2);
//        em.persist(d3);
//
//        // =========================
//        // CITIZEN PROFILES
//        // =========================
//        CitizenProfile cp1 = new CitizenProfile(p1, i1, o1, List.of(v1), List.of(d1));
//        CitizenProfile cp2 = new CitizenProfile(p2, i2, o2, List.of(v2), List.of(d2));
//        CitizenProfile cp3 = new CitizenProfile(p3, i3, o3, List.of(v3), List.of(d3));
//
//        em.persist(cp1);
//        em.persist(cp2);
//        em.persist(cp3);
//
//        System.out.println("🇳🇱 Uitgebreide Nederlandse mockdata geladen: 3 burgers, KVK, RDW, DUO, BRP, inkomen");
//    }
//}