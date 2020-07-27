package com.ct.apac.patientmanagement.repository;


import com.ct.apac.patientmanagement.dao.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
