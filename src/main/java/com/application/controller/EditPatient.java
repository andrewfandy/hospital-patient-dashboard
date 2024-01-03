package com.application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

<<<<<<< HEAD
=======
import com.application.model.Patient;

>>>>>>> ddab9f17ad8829f2371da65637be35cbfb26e622
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

<<<<<<< HEAD
// Refactor this Class only for edit patient
=======
// TODO : Navigation SASA
>>>>>>> ddab9f17ad8829f2371da65637be35cbfb26e622
public class EditPatient extends Form {
    @FXML
    private Pane arrowWrapper;
    @FXML
    private Button deleteButton, nextBtn, prevBtn;

<<<<<<< HEAD
    // @Override
    // public void initialize(URL location, ResourceBundle resources) {
    // super.edit(true);
    // }
=======
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
>>>>>>> ddab9f17ad8829f2371da65637be35cbfb26e622

}
