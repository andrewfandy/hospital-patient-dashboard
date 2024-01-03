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
<<<<<<< HEAD
=======
import com.application.utils.NotificationUtil;
>>>>>>> ddab9f17ad8829f2371da65637be35cbfb26e622

public class ShowPatient implements Initializable {
    @FXML
    private TableView<Patient> tableContainer;
    @FXML
    private TableColumn<Patient, String> indexCol, nameCol, addressCol, patientIDCol, birthCol;
    private PatientDAO patientDAO;

    public ShowPatient() {
        this.patientDAO = new PatientDAO();

    }
<<<<<<< HEAD

    @FXML
    private void deleteData(ActionEvent evt) throws IOException {
        Patient selectedPatient = tableContainer.getSelectionModel().getSelectedItem();
=======

    private void setData(TableView<Patient> tableContainer) {
        Patient selected = selectedPatient(tableContainer);
        if (selected != null) {
            patientDAO.setSelectedPatient(selected);
        }
    }

    private static Patient selectedPatient(TableView<Patient> tableContainer) {
        Patient selected = tableContainer.getSelectionModel().getSelectedItem();
        return selected;
    }

    @FXML
    private void deleteData(ActionEvent evt) throws IOException {
        Patient selectedPatient = selectedPatient(tableContainer);
>>>>>>> ddab9f17ad8829f2371da65637be35cbfb26e622
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

<<<<<<< HEAD
            System.out.println(patients.size());
=======
>>>>>>> ddab9f17ad8829f2371da65637be35cbfb26e622
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
<<<<<<< HEAD
        Navigation.setEditMode(true);
        Navigation.navigateTo("Form");
=======
        setData(tableContainer);
        Navigation.navigateTo("EditForm");
>>>>>>> ddab9f17ad8829f2371da65637be35cbfb26e622
    }

    @FXML
    private void toMenu(ActionEvent evt) throws IOException {
<<<<<<< HEAD
        Navigation.setRoot("Home");
=======
        Navigation.navigateTo("Home");
>>>>>>> ddab9f17ad8829f2371da65637be35cbfb26e622

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showData();
        tableContainer.setPlaceholder(new Label("No records found"));
    }

}
