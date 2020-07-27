package com.ct.apac.patientmanagement.impl;

import com.ct.apac.patientmanagement.dao.Patient;
import com.ct.apac.patientmanagement.repository.PatientRepository;
import com.ct.apac.patientmanagement.service.PatientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class PatientServiceImpl implements PatientService {


    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> getPatientById(Long employeeId) {
        return patientRepository.findById(employeeId);
    }

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Patient patient) {
        patientRepository.delete(patient);
    }
}
