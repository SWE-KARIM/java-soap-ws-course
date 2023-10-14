package com.clinical.rest.service;

import com.clinical.rest.model.ClinicalData;
import com.clinical.rest.model.Patient;
import com.clinical.rest.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Consumes("application/json")
@Produces("application/json")
@Path("/api")
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    @Path("/patients")
    @POST
    public Patient createPatient(Patient patient){
        return patientRepo.save(patient);
    }

    @Path("/patients/{id}")
    @GET
    public Patient getPatientById(@PathParam(value = "id") int id){
        return patientRepo.findById(id).get();
    }

    @Path("/patients")
    @GET
    public List<Patient> getAllPatients(){
        return patientRepo.findAll();
    }

    @Path("/patient/analyze/{id}")
    @GET
    public Patient analyzePatient(@PathParam(value = "id") int id){
        Patient patient = patientRepo.findById(id).get();
        ArrayList<ClinicalData> clinicalData = new ArrayList<>(patient.getClinicalDataList());

        for (ClinicalData data:clinicalData){
            if (data.getComponentName().equals("hw")){
                String [] heightAndWeight = data.getComponentName().split("/");
                String height = heightAndWeight[0];
                String weight = heightAndWeight[1];

                float heightInMeters = Float.parseFloat(height) * 0.4536F;
                Float bmi = Float.parseFloat(weight) / heightInMeters * heightInMeters;

                ClinicalData bmiClinicalData = new ClinicalData();
                bmiClinicalData.setComponentName("bmi");
                bmiClinicalData.setComponentValue(bmi.toString());

                patient.getClinicalDataList().add(bmiClinicalData);
            }
        }

        return patient;
    }

}
