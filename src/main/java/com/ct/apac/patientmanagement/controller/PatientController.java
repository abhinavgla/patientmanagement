package com.ct.apac.patientmanagement.controller;


import com.ct.apac.patientmanagement.dao.Patient;
import com.ct.apac.patientmanagement.exception.ResourceNotFoundException;
import com.ct.apac.patientmanagement.impl.PatientServiceImpl;
import com.ct.apac.patientmanagement.service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
@Api(value="Controller to create/update/delete patient")
public class PatientController {
    private static final Logger Log = LoggerFactory.getLogger(PatientController.class);

    private PatientService patientService;

    public PatientController(PatientServiceImpl patientServiceImpl) {
        patientService = patientServiceImpl;
    }

    @ApiOperation(value = "API to get all active patient details ")
    @GetMapping("/patient")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatient();
    }

    @ApiOperation(value = "API to get patient detail by ID")
    @GetMapping("/patient/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable(value = "id") Long PatientId)
            throws ResourceNotFoundException {
        Optional<Patient> optionalPatient = patientService.getPatientById(PatientId);
        if (!optionalPatient.isPresent()) {
            Log.error("getPatientById : Patient not found for this id :: " + PatientId);
            throw new ResourceNotFoundException("Patient not found for this id :: " + PatientId);
        }
        return ResponseEntity.ok().body(optionalPatient.get());
    }

    @ApiOperation(value = "API to create patient")
    @PostMapping("/patient")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }


    @ApiOperation(value = "API to update patient details")
    @PutMapping("/patient/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id") Long PatientId,
                                                 @RequestBody Patient PatientDetails) throws ResourceNotFoundException {

        Optional<Patient> optionalPatient = patientService.getPatientById(PatientId);
        if (!optionalPatient.isPresent()) {
            Log.error("updatePatient : Patient not found for this id :: " + PatientId);
            throw new ResourceNotFoundException("Patient not found for this id :: " + PatientId);
        }
        Patient patient = optionalPatient.get();
        patient.setEmailId(PatientDetails.getEmailId());
        patient.setLastName(PatientDetails.getLastName());
        patient.setFirstName(PatientDetails.getFirstName());
        final Patient updatedPatient = patientService.updatePatient(patient);
        return ResponseEntity.ok(updatedPatient);
    }

    @ApiOperation(value = "API to delete patient details")
    @DeleteMapping("/patient/{id}")
    public Map<String, Boolean> deletePatient(@PathVariable(value = "id") Long PatientId)
            throws ResourceNotFoundException {
        Optional<Patient> optionalPatient = patientService.getPatientById(PatientId);
        if (!optionalPatient.isPresent()) {
            Log.error("deletePatient : Patient not found for this id :: " + PatientId);
            throw new ResourceNotFoundException("Patient not found for this id :: " + PatientId);
        }
        patientService.deletePatient(optionalPatient.get());
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
