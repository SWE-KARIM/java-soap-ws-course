package com.rest.ws.impl;

import com.rest.ws.model.Patient;
import com.rest.ws.service.PatientService;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.*;

@Service
public class PatientServiceImpl implements PatientService {

    Map<Long, Patient> patientMap = new HashMap<>();
    long currentId = 123;

    public PatientServiceImpl(){
        initData();
    }

    private void initData() {
        Patient patient = new Patient();
        patient.setId(currentId);
        patient.setName("Karim");

        patientMap.put(patient.getId(), patient);

    }

    @Override
    public List<Patient> getPatients() {
        Collection<Patient> values = patientMap.values();

        return new ArrayList<>(values);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientMap.get(id);
    }

    @Override
    public Response deletePatientById(Long id) {
        Response response;
        Patient patient = patientMap.get(id);
        if(patient !=null){
            response = Response.ok().build();
        }else {
            response = Response.notModified().build();
        }

        return response;

    }

    @Override
    public Response createPatient(Patient patient) {
        patient.setId(++currentId);
        patientMap.put(patient.getId(), patient);

        return Response.ok(patient).build();
    }

    @Override
    public Response updatePatient(Patient patient) {
        Patient currentPatient = patientMap.get(patient.getId());
        Response response;

        if (currentPatient !=null){
            patientMap.put(patient.getId(), patient);
            response = Response.ok(patient).build();
        }else {
            response = Response.notModified().build();
        }
        return response;
    }
}
