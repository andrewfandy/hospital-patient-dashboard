package com.application.controller;

import java.io.IOException;

import com.application.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Navigation extends App {

    @FXML
    public void addPatient(ActionEvent evt) throws IOException {
        super.setRoot("Form");
    }

    @FXML
    public void editPatient(ActionEvent evt) throws IOException {
        super.setRoot("Form");
    }

    @FXML
    public void displayPatient(ActionEvent evt) throws IOException {
        super.setRoot("ShowPatient");
    }

}
