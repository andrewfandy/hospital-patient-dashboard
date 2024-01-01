package com.application.controller;

import java.io.IOException;

import com.application.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

// refactor to utils package

public class Navigation extends App {
    private static boolean editMode;

    public static void navigateTo(String fxml) {
        try {
            App.setRoot(fxml);
        } catch (IOException e) {
            NotificationUtil.showNotification("Failed to navigate", "ERROR");
            e.printStackTrace();
        }
    }

    public static void setEditMode(boolean visibility) {
        editMode = visibility;
    }

    public static boolean getEditMode() {
        return editMode;
    }

    @FXML
    private void addPatient(ActionEvent evt) throws IOException {
        setEditMode(false);
        navigateTo("Form");
    }

    @FXML
    private void displayPatient(ActionEvent evt) throws IOException {
        navigateTo("ShowPatient");
    }

}
