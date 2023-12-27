package com.application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.application.model.Patient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class ShowPatient implements Initializable {
    @FXML
    private TableView<Patient> tableContainer;

    @FXML
    private void deleteData(ActionEvent evt) throws IOException {
        App.setRoot("Home");

    }

    @FXML
    private void toEditForm(ActionEvent evt) throws IOException {

        App.setRoot("Form");

    }

    @FXML
    private void toMenu(ActionEvent evt) throws IOException {
        Navigation.setRoot("Home");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableContainer.setPlaceholder(new Label("No records found"));
    }

}
