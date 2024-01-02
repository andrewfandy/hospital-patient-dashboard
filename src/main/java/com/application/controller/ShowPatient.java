package com.application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.application.model.Patient;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.SQLException;
import com.application.model.PatientDAO;
import com.application.utils.NotificationUtil;

public class ShowPatient implements Initializable {
    @FXML
    private TableView<Patient> tableContainer;
    @FXML
    private TableColumn<Patient, String> indexCol, nameCol, addressCol, patientIDCol, birthCol;
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
            ObservableList<Patient> patients = FXCollections.observableArrayList(patientDAO.getAllPatients());

            System.out.println(patients.size());
            tableContainer.setItems(patients);
            indexCol.setCellValueFactory(cell -> new SimpleStringProperty(patients.indexOf(cell.getValue()) + 1 + ""));
            nameCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getName()));
            addressCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getAddress()));
            birthCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getBirth() + ""));
            patientIDCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getPatientID()));
        } catch (SQLException e) {
            e.printStackTrace();
            NotificationUtil.showNotification("Failed to show data", "ERROR");
        }
    }

    @FXML
    private void toEditForm(ActionEvent evt) throws IOException {

        Navigation.navigateTo("Form", "EditPatient");
    }

    @FXML
    private void toMenu(ActionEvent evt) throws IOException {
        Navigation.navigateTo("Home", "Home");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showData();
        tableContainer.setPlaceholder(new Label("No records found"));
    }

}
