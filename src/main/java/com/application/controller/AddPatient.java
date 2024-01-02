package com.application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class AddPatient extends Form {

    // TODO : Refactor this class to be used in to add patient
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
        editMode(false);
    }
}
