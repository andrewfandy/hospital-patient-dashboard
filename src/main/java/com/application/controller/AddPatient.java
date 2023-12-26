package com.application.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.application.App;
import com.application.model.Patient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

public class AddPatient implements Initializable {
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

    @FXML
    private void onSubmit(ActionEvent evt) throws IOException {
        Form form = new Form();

        String name = nameField.getText().trim();
        String address = addressField.getText().trim();
        String patientID = this.patientID.getText().trim();
        LocalDate birth = birthDate.getValue();
        if (form.validation(name, address, patientID, birth)) {
            form.savePatientData(name, address, patientID, birth);
        } else {
            form.displayError("All fields are required");
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
