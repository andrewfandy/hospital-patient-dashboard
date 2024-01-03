package com.application.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.application.model.Patient;
import com.application.model.PatientDAO;
import com.application.utils.NotificationUtil;
import com.application.utils.ValidationUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AddPatient extends Form {

    @Override
    @FXML
    public void onSubmit(ActionEvent evt) throws IOException, SQLException {
        Patient patient = new Patient();
        patient.setName(nameField.getText().trim());
        patient.setAddress(addressField.getText().trim());
        patient.setPatientID(patientID.getText().trim());
        patient.setBirth(birthDate.getValue());

        if (ValidationUtils.isSubmitValid(patient)) {
            try {
                PatientDAO patientDAO = new PatientDAO();
                patientDAO.savePatient(patient);
            } catch (SQLException e) {
                e.printStackTrace();
                NotificationUtil.showNotification("Failed to save data", "ERROR");
            }

        } else {
            NotificationUtil.showNotification("All fields are required", "ERROR");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
    }
}
