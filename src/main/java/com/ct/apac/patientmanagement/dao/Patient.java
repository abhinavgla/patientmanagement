package com.ct.apac.patientmanagement.dao;


import com.ct.apac.patientmanagement.DateProcessor;
import com.ct.apac.patientmanagement.constants.Gender;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "patient")
public class Patient extends AbstractEntity {

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "firstName",nullable = false)
    private String firstName;
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "emailId",nullable = true)
    private String emailId;
    @Column(name = "patientAddress")
    private String patientAddress;
    @Column(name = "phoneNumber")
    private long phoneNumber;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "telephone")
    private long telephone;
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "dob")
    @DateTimeFormat(pattern = DateProcessor.DATE_FORMAT)
    private Date dob;
    @Column(name = "ssn")
    private String ssn;
    @Column(name = "isActive")
    private boolean isActive;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String emailId, Date dob, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.dob = dob;
        this.ssn = ssn;
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

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
                + "]";
    }
}

