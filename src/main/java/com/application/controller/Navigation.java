package com.application.controller;

import java.io.IOException;

import com.application.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Navigation extends App {

    public void navigateTo(String fxml) {
        try {
            super.setRoot(fxml);
        } catch (IOException e) {
            NotificationUtil.showNotification("Failed to navigate", "ERROR");
            e.printStackTrace();
        }
    }

    @FXML
    private void addPatient(ActionEvent evt) throws IOException {
        navigateTo("Form");
    }

    @FXML
    private void editPatient(ActionEvent evt) throws IOException {
        navigateTo("Form");
    }

    @FXML
    private void displayPatient(ActionEvent evt) throws IOException {
        navigateTo("ShowPatient");
    }

}
