package com.ct.apac.patientmanagement.dao;

import com.ct.apac.patientmanagement.DateProcessor;
import com.ct.apac.patientmanagement.constants.Slots;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "appointment")
public class Appointment extends AbstractEntity{

    @NotNull
    @Column(name = "created_at", nullable = false)
    @DateTimeFormat(pattern = DateProcessor.DATE_FORMAT)
    private Date createdDate;
    @Column(name = "patientId")
    private long patientId;
    @Column(name = "physicianId")
    private long physicianId;
    @Column(name = "slot")
    private Slots slot;
    @Column(name = "isCancelled")
    private boolean isCancelled;

    public Appointment() {
    }

    public Appointment(long patientId, long physicianId, Date date, Slots slot) {
        this.patientId = patientId;
        this.physicianId = physicianId;
        this.createdDate = date;
        this.slot = slot;
        this.isCancelled = false;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public long getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(long physicianId) {
        this.physicianId = physicianId;
    }

    public Slots getSlot() {
        return slot;
    }

    public void setSlot(Slots slot) {
        this.slot = slot;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }
}
