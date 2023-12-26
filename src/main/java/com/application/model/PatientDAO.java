package com.application.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PatientDAO {
    private Connection connection;
    private final String user = "username";
    private final String password = "password";

    public PatientDAO() {
        String url = "jdcb:mysql://localhost:5500/patient_database";
        String username = this.user;
        String password = this.password;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void savePatient(Patient patient) throws SQLException {
        String sql = "";
    }

    public List<Patient> getAllPatients() throws SQLException {
        return List < Patient > patients;
        // get all patients from dataabase
    }
}
