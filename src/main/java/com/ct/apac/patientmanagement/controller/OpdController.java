package com.ct.apac.patientmanagement.controller;

import com.ct.apac.patientmanagement.dao.Appointment;
import com.ct.apac.patientmanagement.exception.ResourceNotFoundException;
import com.ct.apac.patientmanagement.service.OpdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
@Api(value = "Controller to book/update/cancel Appointment")
public class OpdController {
    private static final Logger Log = LoggerFactory.getLogger(OpdController.class);
    private OpdService opdService;

    public OpdController(OpdService opdService) {
        this.opdService = opdService;
    }

    @ApiOperation(value = "API to get all active appointment ")
    @GetMapping("/appointments")
    public List<Appointment> getAllPatients() {
        return this.opdService.getAppointments();
    }

    @ApiOperation(value = "API to book appointment")
    @PostMapping("/bookAppointment")
    public Appointment bookAppointment(@RequestBody Appointment appointment) {
        this.opdService.bookAppointment(appointment);
        return appointment;
    }

    @ApiOperation(value = "API to update patient details")
    @PutMapping("/updateAppointment")
    public void updateAppointment(@RequestBody Appointment appointment)
            throws Exception {
        opdService.updateAppointment(appointment);
    }

    @ApiOperation(value = "API to cancel appointment ")
    @PutMapping("/cancelAppointment/{appointmentId}")
    public void cancelAppointment(@PathVariable(value = "appointmentId") Long appointmentId)
            throws ResourceNotFoundException {
        opdService.cancelAppointment(appointmentId);
    }

}
