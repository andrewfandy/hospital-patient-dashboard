package com.application.controller;

import java.sql.SQLException;
import java.time.LocalDate;

import com.application.model.Patient;
import com.application.model.PatientDAO;

import javafx.scene.control.Alert;

public class Form {
    private PatientDAO patientDAO;

    public Form() {
        this.patientDAO = new PatientDAO();
    }

    public void savePatientData(String name, String address, String patientID, LocalDate birth) {
        Patient patient = new Patient();
        patient.setName(name);
        patient.setAddress(address);
        patient.setPatientID(patientID);
        patient.setBirth(birth);

        try {
            patientDAO.savePatient(patient);
        } catch (SQLException e) {

        }
    }

    public boolean submitValidation(String name, String address, String patientID, LocalDate birth) {
        if (!name.isEmpty() && !address.isEmpty() && !patientID.isEmpty() && birth != null)
            return true;
        return false;
    }

    public void showNotification(String s, String type) {
        try {

            Alert alert = new Alert(Alert.AlertType.valueOf(type));
            alert.setContentText(s);
            alert.setHeaderText(null);
            alert.showAndWait();
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid alert type");
            e.printStackTrace();
        }
    }

}
