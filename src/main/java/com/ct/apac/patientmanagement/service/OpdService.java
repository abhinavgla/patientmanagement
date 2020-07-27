package com.ct.apac.patientmanagement.service;

import com.ct.apac.patientmanagement.dao.Appointment;

import java.util.List;
import java.util.Optional;

public interface OpdService {

    List<Appointment> getAppointments();

    boolean bookAppointment(Appointment appointment);

    boolean updateAppointment(Appointment appointment) throws Exception;

    void cancelAppointment(Long appointmentId);

    Optional<Appointment> getAppointment(Long appointmentId);
}
