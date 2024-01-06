package com.application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.application.model.Patient;
import com.application.model.PatientDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class EditPatient extends Form {
    @FXML
    private Pane arrowWrapper;
    @FXML
    private Button deleteButton, nextBtn, prevBtn;

    @FXML
    private Text nameMaxChar;

    private int referenceID;

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

    private void setValueText() {
        System.out.println(this.referenceID);
        // Patient patient = PatientDAO.getSelectedPatient(referenceID);
        // System.out.println(patient);

    }

    public void setReferenceID(int refID) {
        this.referenceID = refID;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        setValueText();
        addTextLimiterTextField(nameField, nameMaxChar, 20);
        addTextLimiterTextArea(addressField, IDMaxChar, 0);
        addTextLimiterTextField(patientID, IDMaxChar, 0);
    }

}
