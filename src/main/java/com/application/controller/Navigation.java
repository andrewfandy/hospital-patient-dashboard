package com.application.controller;

import java.io.IOException;

import com.application.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Navigation extends App {

    @FXML
    private void addPatient(ActionEvent evt) throws IOException {
        App.setRoot("Form");
    }

    @FXML
    private void displayPatient(ActionEvent evt) throws IOException {
        App.setRoot("ShowPatient");
    }

}
