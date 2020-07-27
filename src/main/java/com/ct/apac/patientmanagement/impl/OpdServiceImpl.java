package com.ct.apac.patientmanagement.impl;

import com.ct.apac.patientmanagement.constants.Slots;
import com.ct.apac.patientmanagement.dao.Appointment;
import com.ct.apac.patientmanagement.exception.ResourceNotFoundException;
import com.ct.apac.patientmanagement.repository.AppointmentRepository;
import com.ct.apac.patientmanagement.service.OpdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class OpdServiceImpl implements OpdService {
    private static final Logger Log = LoggerFactory.getLogger(OpdServiceImpl.class);

    private AppointmentRepository appointmentRepository;

    public OpdServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getAppointments() {
        Date date = new Date();
        return this.appointmentRepository.findActiveAppointments(date);
    }

    @Override
    public boolean bookAppointment(Appointment appointment) {
        this.appointmentRepository.save(appointment);
        return true;
    }

    @Override
    public boolean updateAppointment(Appointment newAppointment)
            throws Exception {
        Optional<Appointment> optionalAppointment = getAppointment(newAppointment.getId());
        if (!optionalAppointment.isPresent()) {
            Log.error("updateAppointment : appointment not found for this id :: " + newAppointment.getId());
            throw new ResourceNotFoundException("appointment not found for this id :: " + newAppointment.getId());
        }

        Appointment appointment = optionalAppointment.get();
        Period period = Period.between(convertToLocalDateViaInstant(appointment.getCreatedDate()),
                convertToLocalDateViaInstant(new Date()));

        if (period.getDays() <= 2) {
            Log.error("updateAppointment : new appointment should be 2 days prior to OPD visit");
            throw new ValidationException("new appointment should be 2 days prior to OPD visit");
        }
        appointment.setCreatedDate(newAppointment.getCreatedDate());
        appointment.setPhysicianId(appointment.getPhysicianId());
        appointment.setSlot(appointment.getSlot());
        try {
            this.appointmentRepository.save(appointment);
        } catch (Exception exception) {
            Log.error("updateAppointment : Unknown database error " + exception.toString());
        }

        return true;
    }

    @Override
    public void cancelAppointment(Long appointmentId) {
        this.appointmentRepository.cancelAppointments(appointmentId);
    }

    @Override
    public Optional<Appointment> getAppointment(Long appointmentId) {
        return appointmentRepository.findById(appointmentId);
    }

    private boolean isAppointmentAvailable(Appointment appointment) {
        List<Appointment> appointmentList = appointmentRepository.
                findByPatientIdAndDoctorIdAndCancelled(appointment.getPatientId(), appointment.getPhysicianId(), appointment.getCreatedDate());
        return appointmentList.size() == Slots.values().length;
    }

    private LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
