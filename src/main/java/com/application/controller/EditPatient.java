package com.application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.application.model.Patient;
import com.application.model.PatientDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class EditPatient extends Form {

    @FXML
    Pane editPane;

    private PatientDAO patientDAO;

    public EditPatient() {
        this.patientDAO = new PatientDAO();
    }

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

    // public void setReferenceID(int refID) {
    // this.referenceID = refID;
    // }

    @FXML
    public void isEditable(boolean isEdit) {
        nameField.setEditable(isEdit);
        addressField.setEditable(isEdit);
        patientID.setEditable(isEdit);
        birthDate.setDisable(!isEdit);
        submitBtn.setDisable(!isEdit);
    }

    public void loadPatientData(int idpatient) {
        // Patient patient = patientDAO.getSelectedPatient(idpatient);
        isEditable(true);
        // if (patient != null) {
        // super.nameField.setText(patient.getName());
        // super.addressField.setText(patient.getAddress());
        // super.patientID.setText(patient.getPatientID());
        // super.birthDate.setValue(patient.getBirth());
        // isEditable(true);
        // }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        addTextLimiterTextField(nameField, nameMaxChar, 20);
        addTextLimiterTextArea(addressField, IDMaxChar, 0);
        addTextLimiterTextField(patientID, IDMaxChar, 0);
    }

}
