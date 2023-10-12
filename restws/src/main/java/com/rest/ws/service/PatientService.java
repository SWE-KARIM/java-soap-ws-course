package com.rest.ws.service;

import com.rest.ws.model.Patient;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")

@Path("/patientservice")
public interface PatientService {

    @Path("/patients")
    @GET
    List<Patient> getPatients();

    @Path("/patients/{id}")
    @GET
    Patient getPatientById(@PathParam(value="id") Long id);

    @Path("/patients/{id}")
    @DELETE
    Response deletePatientById(@PathParam(value="id") Long id);

    @Path("/patients")
    @POST
    Response createPatient(Patient patient);

    @Path("/patients")
    @PUT
    Response updatePatient(Patient patient);


}
