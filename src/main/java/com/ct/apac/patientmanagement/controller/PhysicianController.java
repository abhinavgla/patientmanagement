package com.ct.apac.patientmanagement.controller;

import com.ct.apac.patientmanagement.dao.Physician;
import com.ct.apac.patientmanagement.exception.ResourceNotFoundException;
import com.ct.apac.patientmanagement.service.PhysicianService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
@Api(value = "Controller to add/update/delete Physician")
public class PhysicianController {

    private static final Logger Log = LoggerFactory.getLogger(PhysicianController.class);
    private PhysicianService physicianService;

    public PhysicianController(PhysicianService physicianService) {
        Log.info("PhysicianController created");
        this.physicianService = physicianService;
    }

    @ApiOperation(value = "API to get all active Physician")
    @GetMapping("/physician")
    public List<Physician> getAllActivePhysician() {
        return physicianService.getPhysicians();
    }

    @ApiOperation(value = "API to get Physician detail by ID")
    @GetMapping("/physician/{id}")
    public ResponseEntity<Physician> getPhysicianById(@PathVariable(value = "id") Long physicianId)
            throws ResourceNotFoundException {

        Optional<Physician> optionalPhysician = physicianService.getPhysician(physicianId);

        if (!optionalPhysician.isPresent()) {
            Log.error("getPhysicianById : physician not found for this id :: " + physicianId);
            throw new ResourceNotFoundException("physician not found for this id :: " + physicianId);
        }
        return ResponseEntity.ok().body(optionalPhysician.get());
    }

    @ApiOperation(value = "API to create physician")
    @PostMapping("/physician")
    public Physician createPhysician(@RequestBody Physician physician) {
        return physicianService.addPhysician(physician);
    }

}
