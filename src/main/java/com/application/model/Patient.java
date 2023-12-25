package com.application.model;

import java.time.LocalDate;

public class Patient {
    private String name;
    private String address;
    private String patientID;
    private LocalDate birth;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

}
