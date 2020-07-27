package com.ct.apac.patientmanagement.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends AbstractEntity {
    @Column(name = "userId")
    private long userId;
    @Column(name = "userRole")
    private String userRole;
    @Column(name = "isUserActive")
    private boolean isUserActive;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public boolean isUserActive() {
        return isUserActive;
    }

    public void setUserActive(boolean userActive) {
        isUserActive = userActive;
    }
}
