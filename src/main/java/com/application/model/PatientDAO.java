package com.application.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    private Connection connection;
    private final String user = "username";
    private final String password = "password";

    public PatientDAO() {
        String url = "jdcb:mysql://localhost:3306/patient_database";
        String username = this.user;
        String password = this.password;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void savePatient(Patient patient) throws SQLException {

        String sql = "INSERT INTO patient_database (name, address, patient_id, birth_date) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, patient.getName());
            statement.setString(2, patient.getAddress());
            statement.setString(3, patient.getPatientID());
            statement.setDate(4, Date.valueOf(patient.getBirth()));

            statement.executeUpdate();
        }
    }

    public List<Patient> getAllPatients() throws SQLException {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patient_database";

        try (java.sql.Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Patient patient = new Patient();
                patient.setName(resultSet.getString("name"));
                patient.setAddress(resultSet.getString("address"));
                patient.setPatientID(resultSet.getString("patient_id"));
                patient.setBirth(resultSet.getDate("birth_date").toLocalDate());

                patients.add(patient);
            }
        }
        return patients;
    }
}
