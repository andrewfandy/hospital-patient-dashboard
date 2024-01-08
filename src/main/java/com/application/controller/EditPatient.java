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

    public void isEditable(boolean isEdit) {
        super.nameField.setEditable(isEdit);
        super.addressField.setDisable(isEdit);
        super.patientID.setDisable(isEdit);
        super.birthDate.setDisable(isEdit);
        super.submitBtn.setDisable(isEdit);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        addTextLimiterTextField(nameField, nameMaxChar, 20);
        addTextLimiterTextArea(addressField, IDMaxChar, 0);
        addTextLimiterTextField(patientID, IDMaxChar, 0);
    }

}
