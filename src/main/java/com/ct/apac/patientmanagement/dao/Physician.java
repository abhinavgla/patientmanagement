package com.ct.apac.patientmanagement.dao;

import com.ct.apac.patientmanagement.constants.PhysicianSpecialties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "physician")
public class Physician extends AbstractEntity {
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "emailId")
    private String emailId;
    @Column(name = "specialties")
    private PhysicianSpecialties specialties;
    @Column(name = "isActive")
    private boolean isActive;

    public Physician() {
    }

    public Physician(String firstName, String lastName, String emailId, PhysicianSpecialties specialties) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.specialties = specialties;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public PhysicianSpecialties getSpecialties() {
        return specialties;
    }

    public void setSpecialties(PhysicianSpecialties specialties) {
        this.specialties = specialties;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
