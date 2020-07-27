package com.ct.apac.patientmanagement.impl;

import com.ct.apac.patientmanagement.dao.Physician;
import com.ct.apac.patientmanagement.repository.PhysicianRepository;
import com.ct.apac.patientmanagement.service.PhysicianService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PhysicianServiceImpl implements PhysicianService {

    private static final Logger Log = LoggerFactory.getLogger(PhysicianServiceImpl.class);

    private PhysicianRepository physicianRepository;

    public PhysicianServiceImpl(PhysicianRepository physicianRepository) {
        this.physicianRepository = physicianRepository;
    }

    @Override
    public List<Physician> getPhysicians() {
        return this.physicianRepository.findAllActivePhysician();
    }

    @Override
    public Optional<Physician> getPhysician(Long physicianId) {
        return this.physicianRepository.findPhysicianById(physicianId);
    }

    @Override
    public Physician addPhysician(Physician physician) {
        return this.physicianRepository.save(physician);
    }

    @Override
    public void updatePhysician(Physician physician) {
        this.physicianRepository.save(physician);
    }

    @Override
    public void deletePhysician(Physician physician) {
        this.physicianRepository.deletePhysician(physician.getId());
    }
}
