package com.ct.apac.patientmanagement.repository;

import com.ct.apac.patientmanagement.dao.Physician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PhysicianRepository extends JpaRepository<Physician, Long> {

    @Query(value = "Select * from physician as a where a.is_active = 1", nativeQuery = true)
    List<Physician> findAllActivePhysician();

    @Query(value = "update physician as a  set a.is_active = 0 where a.physician_id = ?1 ", nativeQuery = true)
    List<Physician> deletePhysician(Long physicianId);

    @Query(value = "Select * from physician as a where a.is_active = 1 and a.physician_id = ?1 ", nativeQuery = true)
    Optional<Physician> findPhysicianById(Long physicianId);


}
