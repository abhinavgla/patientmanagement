package com.ct.apac.patientmanagement.repository;

import com.ct.apac.patientmanagement.dao.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query(value = "Select * from appointment as a where a.patient_Id = ?1 and a.physician_Id=?2 and a.created_at = ?3 and a.is_Cancelled = 0", nativeQuery = true)
    List<Appointment> findByPatientIdAndDoctorIdAndCancelled(long patientId, long doctorId, Date date);

    @Query(value = "Select * from appointment as a where a.created_at >= ?1 and a.is_Cancelled = 0", nativeQuery = true)
    List<Appointment> findActiveAppointments(Date date);

    @Query(value = "update appointment as a  set a.is_Cancelled = 1 where a.appointmentId = ?1 ", nativeQuery = true)
    List<Appointment> cancelAppointments(Long appointmentId);
}
