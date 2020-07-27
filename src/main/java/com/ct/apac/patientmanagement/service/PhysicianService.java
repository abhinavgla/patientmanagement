package com.ct.apac.patientmanagement.service;

import com.ct.apac.patientmanagement.dao.Physician;

import java.util.List;
import java.util.Optional;

public interface PhysicianService {

    List<Physician> getPhysicians();

    Optional<Physician> getPhysician(Long physicianId);

    Physician addPhysician(Physician physician);

    void updatePhysician(Physician physician);

    void deletePhysician(Physician physician);
}
