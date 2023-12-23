package com.application.controller;

import java.io.IOException;

import com.application.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller {

    @FXML
    private void addPatient(ActionEvent evt) throws IOException {
        App.setRoot("Form");
    }

    // @FXML
    // private void editPatient(ActionEvent evt) throws IOException {
    // System.out.println("Edit Patient");
    // }

    // @FXML
    // private void deletePatient(ActionEvent evt) throws IOException {
    // System.out.println("Delete Patient");
    // }

    @FXML
    private void displayPatient(ActionEvent evt) throws IOException {
        App.setRoot("ShowPatient");
    }

}
