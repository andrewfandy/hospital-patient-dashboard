package com.application.controller;

import java.io.IOException;

import com.application.App;
<<<<<<< HEAD
=======
import com.application.utils.NotificationUtil;

>>>>>>> ddab9f17ad8829f2371da65637be35cbfb26e622
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

// refactor to utils package

public class Navigation extends App {
<<<<<<< HEAD
    private static boolean editMode;
=======
>>>>>>> ddab9f17ad8829f2371da65637be35cbfb26e622

    public static void navigateTo(String fxml) {
        try {
            App.setRoot(fxml);
        } catch (IOException e) {
            NotificationUtil.showNotification("Failed to navigate", "ERROR");
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
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
=======
    @FXML
    private void addPatient(ActionEvent evt) throws IOException {
        navigateTo("AddForm");
>>>>>>> ddab9f17ad8829f2371da65637be35cbfb26e622
    }

    @FXML
    private void displayPatient(ActionEvent evt) throws IOException {
        navigateTo("ShowPatient");
    }

}
