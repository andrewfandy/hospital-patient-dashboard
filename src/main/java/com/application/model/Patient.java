package com.application.model;

import java.time.LocalDate;

public class Patient {
    // private int id;
    private String name;
    private String address;
    private String patientID;
    private LocalDate birth;

    // TODO : create index (getters and setters)

    // public int getId() {
    // return id;
    // }

    // public void setId(int id) {
    // this.id = id;
    // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

}
