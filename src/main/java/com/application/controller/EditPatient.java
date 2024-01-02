package com.application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

// Refactor this Class only for edit patient
public class EditPatient extends Form {
    @FXML
    private Pane arrowWrapper;
    @FXML
    private Button deleteButton, nextBtn, prevBtn;

    @Override
    protected void editMode(boolean visibility) {

        arrowWrapper.setVisible(visibility);
        deleteButton.setVisible(visibility);

        nextBtn.setVisible(visibility);
        prevBtn.setVisible(visibility);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        editMode(true);
    }

}
