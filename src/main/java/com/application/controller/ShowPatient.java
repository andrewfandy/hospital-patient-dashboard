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
import java.sql.SQLException;
import com.application.model.PatientDAO;

public class ShowPatient implements Initializable {
    @FXML
    private TableView<Patient> tableContainer;
    private PatientDAO patientDAO;

    public ShowPatient() {
        this.patientDAO = new PatientDAO();

    }

    @FXML
    private void deleteData(ActionEvent evt) throws IOException {
        Patient selectedPatient = tableContainer.getSelectionModel().getSelectedItem();
        if (selectedPatient != null) {
            try {
                patientDAO.deletePatient(selectedPatient);
                tableContainer.getItems().remove(selectedPatient);
                System.out.println("Data deleted");
            } catch (SQLException e) {
                e.printStackTrace();
                NotificationUtil.showNotification("Failed to delete data", "ERROR");
            }
        } else {
            System.out.println("No row selected");
        }
    }

    @FXML
    private void showData() {
        try {
            tableContainer.getItems().clear();
            tableContainer.getItems().addAll(patientDAO.getAllPatients());
        } catch (SQLException e) {
            e.printStackTrace();
            NotificationUtil.showNotification("Failed to show data", "ERROR");
        }
    }

    @FXML
    private void toEditForm(ActionEvent evt) throws IOException {
        System.out.println("to edit form");
        Navigation navigation = new Navigation();
        navigation.editPatient(evt);
    }

    @FXML
    private void toMenu(ActionEvent evt) throws IOException {
        Navigation.setRoot("Home");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showData();
        tableContainer.setPlaceholder(new Label("No records found"));
    }

}
