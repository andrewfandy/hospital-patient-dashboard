package com.application.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

import com.application.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

public class AddPatient {
    private Map<String, Object> patientData;

    @FXML
    private TextField nameField;

    @FXML
    private TextArea addressField;

    @FXML
    private TextField patientID;

    @FXML
    private DatePicker birthDate;

    public AddPatient() {
        //

    }

    private String getPatientName() {
        String data = nameField.getText().trim();
        if (data.isEmpty()) {
            return null;
        }
        return data;
    }

    private String getPatientAddress() {
        addressField.setWrapText(true);

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
            System.out.println(data);
            return data;
        }
        return null;
    }

    @FXML
    private void onSubmit(ActionEvent evt) throws IOException {
        System.out.println(getPatientAddress());
    }

    @FXML
    private void toMenu(ActionEvent evt) throws IOException {
        App.setRoot("Home");

    }
}
