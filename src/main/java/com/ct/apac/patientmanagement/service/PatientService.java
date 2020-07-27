package com.ct.apac.patientmanagement.service;


import com.ct.apac.patientmanagement.dao.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<Patient> getAllPatient();

    Optional<Patient> getPatientById(Long employeeId);

    Patient createPatient(Patient patient);

    Patient updatePatient(Patient patient);

    void deletePatient(Patient patient);
}
