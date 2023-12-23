package com.application.controller;

import java.io.IOException;

import com.application.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddPatient {

    @FXML
    private TextField nameField;

    @FXML
    private void onSubmit(ActionEvent evt) throws IOException {
        System.out.println("Halo " + nameField.getText());
    }

    @FXML
    private void toMenu(ActionEvent evt) throws IOException {
        App.setRoot("Home");

    }
}
