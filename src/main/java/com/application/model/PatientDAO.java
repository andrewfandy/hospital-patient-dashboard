package com.application.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    private Connection connection;
    private final String user = "root";
    private final String password = "root";
    private final String database = "patients_database";
    private final String table = "patients";

    public PatientDAO() {
        String url = "jdbc:mysql://localhost:3306/" + database;
        String username = this.user;
        String password = this.password;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("No SQL Connection, please try again");
        }
    }

    public void deletePatient(Patient patient) throws SQLException {
        String sql = "DELETE FROM " + table + " WHERE patient_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, Integer.parseInt(patient.getPatientID()));
            statement.executeUpdate();
        }
    }

    public void savePatient(Patient patient) throws SQLException {
        String sql = "INSERT INTO " + table + " (name, address, patient_id, birth_date) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, patient.getName());
            statement.setString(2, patient.getAddress());
            statement.setLong(3, Long.parseLong(patient.getPatientID()));
            statement.setDate(4, Date.valueOf(patient.getBirth()));

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Success: " + patient.toString());
            } else {
                System.err.println("ERROR, failed to save patient");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("ERROR, can't create");
        }
    }

    public List<Patient> getAllPatients() throws SQLException {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " ORDER BY patient_id ASC";

        try (java.sql.Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Patient patient = new Patient();
                patient.setName(resultSet.getString("name"));
                patient.setAddress(resultSet.getString("address"));
                patient.setPatientID("" + resultSet.getLong("patient_id"));
                patient.setBirth(resultSet.getDate("birth_date").toLocalDate());

                patients.add(patient);
            }
        }
        return patients;
    }
}
