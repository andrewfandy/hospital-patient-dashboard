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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.text.Text;

// TODO : Refactor this class to be used in both edit and add patient
// TODO : Refactor to abstract class

public abstract class Form implements Initializable {
    @FXML
    private TextField nameField, patientID;
    @FXML
    private TextArea addressField;
    @FXML
    private DatePicker birthDate;
    @FXML
    protected Text nameMaxChar, addressMaxChar, IDMaxChar;
    @FXML
    protected Button deleteButton, nextBtn, prevBtn;

    @FXML
    public void onSubmit(ActionEvent evt) {
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

    @FXML
    private void toMenu(ActionEvent evt) throws IOException {
        Navigation.setRoot("Home", "Home");
    }

    @FXML
    public void onDeleteData(ActionEvent evt) throws IOException {
        System.out.println("Delete data");
    }

    @FXML
    public void onNextBtn(ActionEvent evt) throws IOException {
        System.out.println("Next button");
    }

    public void onPrevBtn(ActionEvent evt) throws IOException {
        System.out.println("Prev button");

    }

    private void addTextLimiterTextArea(final TextArea tf, final Text lb, final int maxLength) {
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            int currentChars = maxLength - newValue.length();
            lb.setText(currentChars + " character(s) left");
            if (newValue.length() > maxLength) {
                tf.setText(newValue.substring(0, maxLength));
            }
        });
    }

    private void addTextLimiterTextField(final TextField tf, final Text lb, final int maxLength) {
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            int currentChars = maxLength - newValue.length();
            lb.setText(currentChars + " character(s) left");
            if (newValue.length() > maxLength) {
                tf.setText(newValue.substring(0, maxLength));
            }
        });
    }

    @FXML
    protected abstract void editMode(boolean visibility);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addTextLimiterTextField(nameField, nameMaxChar, 20);
        addTextLimiterTextArea(addressField, addressMaxChar, 50);
        addressField.setWrapText(true);
        addTextLimiterTextField(patientID, IDMaxChar, 15);

        patientID.setTextFormatter(
                new TextFormatter<>(change -> (change.getControlNewText().matches("^[0-9]*$")) ? change : null));

    }

}
