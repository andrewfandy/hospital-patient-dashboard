package com.application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.application.model.Patient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

// TODO : Navigation SASA
public class EditPatient extends Form {
    @FXML
    private Pane arrowWrapper;
    @FXML
    private Button deleteButton, nextBtn, prevBtn;

    @Override
    @FXML
    public void onSubmit(ActionEvent evt) throws IOException {
        System.out.println("Submit button");
    }

    @FXML
    public void onDeleteData(ActionEvent evt) throws IOException {
        System.out.println("Delete data");
    }

    @FXML
    public void onNextBtn(ActionEvent evt) throws IOException {
        System.out.println("Next button");
    }

    @FXML
    public void onPrevBtn(ActionEvent evt) throws IOException {
        System.out.println("Prev button");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Patient patient = new Patient();
        super.initialize(location, resources);
        nameField.setText(patient.getName());
        addressField.setText(patient.getAddress());
        patientID.setText(patient.getPatientID());
        birthDate.setValue(patient.getBirth());
    }

}
