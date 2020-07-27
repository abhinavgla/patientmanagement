package com.ct.apac.patientmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientApplication {
    private static final Logger Log = LoggerFactory.getLogger(PatientApplication.class);

    public static void main(String[] args) {
        Log.info("Starting PatientApplication ....");
        SpringApplication.run(PatientApplication.class, args);

    }
}
