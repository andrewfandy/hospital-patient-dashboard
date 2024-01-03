package com.application.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.text.Text;

// TODO : Refactor this class to be used in both edit and add patient
// TODO : Refactor to abstract class

public abstract class Form implements Initializable {
    @FXML
    protected TextField nameField, patientID;
    @FXML
    protected TextArea addressField;
    @FXML
    protected DatePicker birthDate;
    @FXML
    protected Text nameMaxChar, addressMaxChar, IDMaxChar;

    @FXML
    public abstract void onSubmit(ActionEvent evt) throws IOException, SQLException;

    protected void addTextLimiterTextArea(final TextArea tf, final Text lb, final int maxLength) {
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            int currentChars = maxLength - newValue.length();
            lb.setText(currentChars + " character(s) left");
            if (newValue.length() > maxLength) {
                tf.setText(newValue.substring(0, maxLength));
            }
        });
    }

    protected void addTextLimiterTextField(final TextField tf, final Text lb, final int maxLength) {
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            int currentChars = maxLength - newValue.length();
            lb.setText(currentChars + " character(s) left");
            if (newValue.length() > maxLength) {
                tf.setText(newValue.substring(0, maxLength));
            }
        });
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

}
