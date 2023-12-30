package com.application.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.application.model.Patient;
import com.application.model.PatientDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.text.Text;

public class Form implements Initializable {
    @FXML
    private TextField nameField, patientID;
    @FXML
    private TextArea addressField;
    @FXML
    private DatePicker birthDate;
    @FXML
    private Text nameMaxChar, addressMaxChar, IDMaxChar;

    private PatientDAO patientDAO;

    public Form() {
        this.patientDAO = new PatientDAO();
    }

    // Save to Patient DAO
    private void savePatientData(String name, String address, String patientID, LocalDate birth) {
        Patient patient = new Patient();
        patient.setName(name);
        patient.setAddress(address);
        patient.setPatientID(patientID);
        patient.setBirth(birth);

        try {
            patientDAO.savePatient(patient);
        } catch (SQLException e) {
            e.printStackTrace();
            NotificationUtil.showNotification("Failed to save data", "ERROR");
        }
    }

    private boolean submitValidation(String name, String address, String patientID, LocalDate birth) {

        if (!name.isEmpty() && !address.isEmpty() && !patientID.isEmpty() && birth != null)
            return true;
        return false;
    }

    @FXML
    public void onSubmit(ActionEvent evt) {
        String name = nameField.getText().trim();
        String address = addressField.getText().trim();
        String patientID = this.patientID.getText().trim();
        LocalDate birth = birthDate.getValue();
        if (submitValidation(name, address, patientID, birth)) {
            savePatientData(name, address, patientID, birth);
        } else {
            NotificationUtil.showNotification("All fields are required", "ERROR");
        }
    }

    @FXML
    private void toMenu(ActionEvent evt) throws IOException {
        Navigation.setRoot("Home");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addTextLimiterTextField(nameField, nameMaxChar, 20);
        addTextLimiterTextArea(addressField, addressMaxChar, 50);
        addressField.setWrapText(true);
        addTextLimiterTextField(patientID, IDMaxChar, 15);

        patientID.setTextFormatter(
                new TextFormatter<>(change -> (change.getControlNewText().matches("^[0-9]*$")) ? change : null));

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
}
