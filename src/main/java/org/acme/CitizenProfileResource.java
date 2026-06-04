package org.acme;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.acme.application.CitizenProfileService;
import org.acme.domain.*;

import java.util.List;

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CitizenProfileResource {


    @Inject
    CitizenProfileService service;


    @POST
    @Path("/init")
    public String initData(){
        return this.service.initData();
    }


    // ---------------- PERSON ----------------

    @POST
    @Path("/persons")
    public Person createPerson(Person person) {
        return service.createPerson(person);
    }


    @GET
    @Path("/persons/{id}")
    public Person getPerson(@PathParam("id") Long id) {
        return service.getPerson(id);
    }


    @GET
    @Path("/persons")
    public List<Person> getPersons() {
        return service.findAllPersons();
    }


    @DELETE
    @Path("/persons/{id}")
    public Response deletePerson(@PathParam("id") Long id) {

        service.deletePerson(id);

        return Response.ok().build();
    }


    // ---------------- ADDRESS ----------------


    @POST
    @Path("/addresses")
    public Address createAddress(Address address) {
        return service.createAddress(address);
    }



    // ---------------- ORGANIZATION / KVK ----------------


    @POST
    @Path("/organizations")
    public Organization createOrganization(
            Organization organization
    ) {
        return service.createOrganization(organization);
    }


    @GET
    @Path("/organizations/{id}")
    public Organization getOrganization(
            @PathParam("id") Long id
    ) {
        return service.getOrganization(id);
    }


    @GET
    @Path("/organizations")
    public List<Organization> getOrganizations() {
        return service.findAllOrganizations();
    }


    @DELETE
    @Path("/organizations/{id}")
    public Response deleteOrganization(
            @PathParam("id") Long id
    ) {

        service.deleteOrganization(id);

        return Response.ok().build();
    }



    // ---------------- INCOME ----------------


    @POST
    @Path("/income")
    public IncomeRecord createIncome(
            IncomeRecord income
    ) {
        return service.createIncome(income);
    }


    @GET
    @Path("/income/{id}")
    public IncomeRecord getIncome(
            @PathParam("id") Long id
    ) {
        return service.getIncome(id);
    }



    // ---------------- VEHICLES / RDW ----------------


    @POST
    @Path("/vehicles")
    public Vehicle createVehicle(
            Vehicle vehicle
    ) {
        return service.createVehicle(vehicle);
    }


    @GET
    @Path("/vehicles/{id}")
    public Vehicle getVehicle(
            @PathParam("id") Long id
    ) {
        return service.getVehicle(id);
    }



    // ---------------- DIPLOMAS / DUO ----------------


    @POST
    @Path("/diplomas")
    public Diploma createDiploma(
            Diploma diploma
    ) {
        return service.createDiploma(diploma);
    }


    @GET
    @Path("/diplomas/{id}")
    public Diploma getDiploma(
            @PathParam("id") Long id
    ) {
        return service.getDiploma(id);
    }



    // ---------------- COMPLETE PROFILE ----------------


    @POST
    @Path("/profiles")
    public CitizenProfile createProfile(
            CitizenProfile profile
    ) {
        return service.createCitizenProfile(profile);
    }


    @GET
    @Path("/profiles/{id}")
    public CitizenProfile getProfile(
            @PathParam("id") Long id
    ) {
        return service.getCitizenProfile(id);
    }
}