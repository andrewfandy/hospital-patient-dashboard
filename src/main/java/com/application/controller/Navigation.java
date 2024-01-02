package com.application.controller;

import java.io.IOException;

import com.application.App;
import com.application.utils.NotificationUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

// refactor to utils package

public class Navigation extends App {

    public static void navigateTo(String fxml, String controller) {
        try {
            App.setRoot(fxml, controller);
        } catch (IOException e) {
            NotificationUtil.showNotification("Failed to navigate", "ERROR");
            e.printStackTrace();
        }
    }

    @FXML
    private void addPatient(ActionEvent evt) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(AddPatient.class);
        navigateTo("Form", "AddPatient");
    }

    @FXML
    private void displayPatient(ActionEvent evt) throws IOException {
        navigateTo("ShowPatient", "ShowPatient");
    }

}
