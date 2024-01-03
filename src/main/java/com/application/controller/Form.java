package com.application.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
<<<<<<< HEAD
import java.time.LocalDate;
=======
>>>>>>> ddab9f17ad8829f2371da65637be35cbfb26e622
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.text.Text;

<<<<<<< HEAD
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.text.Text;

// TODO : Refactor this class to be used in both edit and add patient
// TODO : Refactor to abstract class
// TODO : Refactor validation to other class

public class Form implements Initializable {
    @FXML
    private TextField nameField, patientID;
    @FXML
    private TextArea addressField;
    @FXML
    private DatePicker birthDate;
    @FXML
    private Text nameMaxChar, addressMaxChar, IDMaxChar;
    @FXML
    private Button deleteButton, nextBtn, prevBtn;

    private PatientDAO patientDAO;
=======
// TODO : Refactor this class to be used in both edit and add patient
// TODO : Refactor to abstract class

public abstract class Form implements Initializable {
    @FXML
    protected TextField nameField, patientID;
    @FXML
    protected TextArea addressField;
    @FXML
    protected DatePicker birthDate;
    @FXML
    protected Text nameMaxChar, addressMaxChar, IDMaxChar;
>>>>>>> ddab9f17ad8829f2371da65637be35cbfb26e622

    @FXML
    public abstract void onSubmit(ActionEvent evt) throws IOException, SQLException;

    protected void addTextLimiterTextArea(final TextArea tf, final Text lb, final int maxLength) {
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            int currentChars = maxLength - newValue.length();
            lb.setText(currentChars + " character(s) left");
            if (newValue.length() > maxLength) {
                tf.setText(newValue.substring(0, maxLength));
            }
        });
    }

<<<<<<< HEAD
    // Save to Patient DAO
    private void savePatientData(String name, String address, String patientID, LocalDate birth) {
        Patient patient = new Patient();
        patient.setName(name);
        patient.setAddress(address);
        patient.setPatientID(patientID);
        patient.setBirth(birth);

        try {
            patientDAO.savePatient(patient);
        } catch (SQLException e) {
            e.printStackTrace();
            NotificationUtil.showNotification("Failed to save data", "ERROR");
        }
    }

    private boolean submitValidation(String name, String address, String patientID, LocalDate birth) {

        if (!name.isEmpty() && !address.isEmpty() && !patientID.isEmpty() && birth != null)
            return true;
        return false;
    }

    @FXML
    public void onSubmit(ActionEvent evt) {
        String name = nameField.getText().trim();
        String address = addressField.getText().trim();
        String patientID = this.patientID.getText().trim();
        LocalDate birth = birthDate.getValue();
        if (submitValidation(name, address, patientID, birth)) {
            savePatientData(name, address, patientID, birth);
        } else {
            NotificationUtil.showNotification("All fields are required", "ERROR");
        }
=======
    protected void addTextLimiterTextField(final TextField tf, final Text lb, final int maxLength) {
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            int currentChars = maxLength - newValue.length();
            lb.setText(currentChars + " character(s) left");
            if (newValue.length() > maxLength) {
                tf.setText(newValue.substring(0, maxLength));
            }
        });
    }

    @FXML
    private void toMenu(ActionEvent evt) throws IOException {
        Navigation.setRoot("Home");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addTextLimiterTextField(nameField, nameMaxChar, 20);
        addTextLimiterTextArea(addressField, addressMaxChar, 50);
        addressField.setWrapText(true);
        addTextLimiterTextField(patientID, IDMaxChar, 15);

        patientID.setTextFormatter(
                new TextFormatter<>(change -> (change.getControlNewText().matches("^[0-9]*$")) ? change : null));

>>>>>>> ddab9f17ad8829f2371da65637be35cbfb26e622
    }

    @FXML
    private void toMenu(ActionEvent evt) throws IOException {
        Navigation.setRoot("Home");
    }

    @FXML
    public void onDeleteData(ActionEvent evt) throws IOException {
        System.out.println("Delete data");
    }

    @FXML
    public void onNextBtn(ActionEvent evt) throws IOException {
        System.out.println("Next button");
    }

    public void onPrevBtn(ActionEvent evt) throws IOException {
        System.out.println("Prev button");

    }

    private void addTextLimiterTextArea(final TextArea tf, final Text lb, final int maxLength) {
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            int currentChars = maxLength - newValue.length();
            lb.setText(currentChars + " character(s) left");
            if (newValue.length() > maxLength) {
                tf.setText(newValue.substring(0, maxLength));
            }
        });
    }

    private void addTextLimiterTextField(final TextField tf, final Text lb, final int maxLength) {
        tf.textProperty().addListener((observable, oldValue, newValue) -> {
            int currentChars = maxLength - newValue.length();
            lb.setText(currentChars + " character(s) left");
            if (newValue.length() > maxLength) {
                tf.setText(newValue.substring(0, maxLength));
            }
        });
    }

    @FXML
    private void edit(boolean visibility) {
        System.out.println(visibility);
        deleteButton.setVisible(visibility);
        deleteButton.setManaged(visibility);

        nextBtn.setVisible(visibility);
        nextBtn.setManaged(visibility);

        prevBtn.setVisible(visibility);
        prevBtn.setManaged(visibility);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        edit(Navigation.getEditMode());
        addTextLimiterTextField(nameField, nameMaxChar, 20);
        addTextLimiterTextArea(addressField, addressMaxChar, 50);
        addressField.setWrapText(true);
        addTextLimiterTextField(patientID, IDMaxChar, 15);

        patientID.setTextFormatter(
                new TextFormatter<>(change -> (change.getControlNewText().matches("^[0-9]*$")) ? change : null));

    }

}
