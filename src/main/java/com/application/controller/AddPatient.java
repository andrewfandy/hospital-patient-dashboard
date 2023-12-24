package com.application.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.application.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

public class AddPatient implements Initializable {
    private final Map<String, Object> patientData = new HashMap<>();

    @FXML
    private TextField nameField;

    @FXML
    private TextArea addressField;

    @FXML
    private TextField patientID;

    @FXML
    private DatePicker birthDate;

    public AddPatient() {
    }

    private String getPatientName() {
        String data = nameField.getText().trim();
        if (data.isEmpty()) {
            return null;
        }
        return data;
    }

    private String getPatientAddress() {

        String data = addressField.getText().trim();
        if (data.isEmpty()) {
            return null;
        }
        return data;
    }

    private String getPatientID() {
        String data = patientID.getText().trim();
        if (data.isEmpty()) {
            return null;
        }

        return data;
    }

    @FXML
    private String getPatientBirth() {
        LocalDate date = birthDate.getValue();
        if (date != null) {
            String data = date.toString();
            return data;
        }
        return null;
    }

    @FXML
    private Boolean submitValidation() {
        if (getPatientName() == null) {
            return false;
        }
        if (getPatientAddress() == null) {
            return false;
        }
        if (getPatientID() == null) {
            return false;
        }
        if (getPatientBirth() == null) {
            return false;
        }

        return true;
    }

    @FXML
    private void onSubmit(ActionEvent evt) throws IOException {
        if (submitValidation()) {
            patientData.put("patient_name", getPatientName());
            patientData.put("patient_address", getPatientAddress());
            patientData.put("patient_ID", getPatientID());
            patientData.put("patient_birthdate", getPatientBirth());
            System.out.println(patientData);
        } else {
            // TODO : Create Alert button OK to close
            Alert alert = new Alert(null);
            alert.setContentText("Input must not be empty");
            alert.setTitle("Empty Input");
            alert.close();

            alert.show();
        }
    }

    @FXML
    private void toMenu(ActionEvent evt) throws IOException {
        App.setRoot("Home");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addressField.setWrapText(true);
    }
}
