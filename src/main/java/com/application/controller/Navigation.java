package com.application.controller;

import java.io.IOException;

import com.application.App;
import com.application.utils.NotificationUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

// refactor to utils package

public class Navigation extends App {

    public static void navigateTo(String fxml) {
        try {
            App.setRoot(fxml);
        } catch (IOException e) {
            NotificationUtil.showNotification("Failed to navigate", "ERROR");
            e.printStackTrace();
        }
    }

    @FXML
    private void addPatient(ActionEvent evt) throws IOException {
        navigateTo("AddForm");
    }

    @FXML
    private void displayPatient(ActionEvent evt) throws IOException {
        navigateTo("ShowPatient");
    }

}
