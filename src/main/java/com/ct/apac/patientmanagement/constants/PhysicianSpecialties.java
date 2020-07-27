package com.ct.apac.patientmanagement.constants;

public enum PhysicianSpecialties {
    Pediatrician,
    Surgeon,
    Gynecologist,
    Psychiatrist,
    Cardiologist,
    Dermatologist,
    Ophthalmologist,
    Neurologist,
    Radiologist,
    Anesthesiologist,
    Oncologist;

    public String value() {
        return name();
    }
}
