package com.clinical.rest.service;

import com.clinical.rest.dto.ClinicalDataRequest;
import com.clinical.rest.model.ClinicalData;
import com.clinical.rest.model.Patient;
import com.clinical.rest.repo.ClinicalRepo;
import com.clinical.rest.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import java.util.List;

@Consumes("application/json")
@Produces("application/json")
@Path("/api")
public class ClinicalDataService {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private ClinicalRepo clinicalRepo;

    @Path("/clinical")
    @POST
    public ClinicalData createClinicalData(ClinicalDataRequest clinicalDataRequest){
       Patient patient =  patientRepo.findById(clinicalDataRequest.getPatientId()).get();
       ClinicalData clinicalData = new ClinicalData();
       clinicalData.setPatient(patient);
       clinicalData.setComponentName(clinicalDataRequest.getComponentName());
       clinicalData.setComponentName(clinicalDataRequest.getComponentValue());

        return clinicalRepo.save(clinicalData);
    }

    @Path("/patients/{id}")
    @GET
    public ClinicalData getClinicalDataById(@PathParam(value = "id") int id){
        return clinicalRepo.findById(id).get();
    }

    @Path("/patients")
    @GET
    public List<ClinicalData> getAllPClinicalData(){
        return clinicalRepo.findAll();
    }

}
