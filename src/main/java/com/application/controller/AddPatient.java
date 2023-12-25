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
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

public class AddPatient implements Initializable {
    private final Map<String, Object> patientData = new HashMap<>();

    @FXML
    private AnchorPane container;

    @FXML
    private TextField nameField;

    @FXML
    private TextArea addressField;

    @FXML
    private TextField patientID;

    @FXML
    private DatePicker birthDate;

    @FXML
    private Text nameMaxChar;

    @FXML
    private Text addressMaxChar;

    @FXML
    private Text IDMaxChar;

    public Map<String, Object> getPatientData() {
        return patientData;
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
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Input must not be empty");
            alert.setTitle("Empty Input");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }

    @FXML
    private void toMenu(ActionEvent evt) throws IOException {
        App.setRoot("Home");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nameField.textProperty().addListener((observable, oldValue, newValue) -> {
            int maxChar = 20;
            int currentChars = maxChar - newValue.length();
            nameMaxChar.setText(currentChars + " character(s) left");
            if (newValue.length() > maxChar) {
                nameField.setText(newValue.substring(0, maxChar));
            }
        });

        addressField.textProperty().addListener((observable, oldValue, newValue) -> {
            int maxChar = 50;
            int currentChars = maxChar - newValue.length();
            addressMaxChar.setText(currentChars + " character(s) left");
            addressField.setWrapText(true);
            if (newValue.length() > maxChar) {
                addressField.setText(newValue.substring(0, maxChar));
            }
        });
        patientID.setTextFormatter(
                new TextFormatter<>(change -> (change.getControlNewText().matches("^[0-9]*$")) ? change : null));

        patientID.textProperty().addListener((observable, oldValue, newValue) -> {
            int maxChar = 15;
            int currentChars = maxChar - newValue.length();
            IDMaxChar.setText(currentChars + " character(s) left");

            if (newValue.length() > maxChar) {
                patientID.setText(newValue.substring(0, maxChar));
            }
        });

    }
}
