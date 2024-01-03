package com.application.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.application.utils.NotificationUtil;

public class PatientDAO {
    private Connection connection;
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "patients_database";
    private final String TABLE = "patients";

    public PatientDAO() {
        final String URL = "jdbc:mysql://localhost:3306/" + DATABASE;
        final String USER = this.USER;
        final String PASSWORD = this.PASSWORD;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            NotificationUtil.showNotification("No SQL Connection, please try again", "ERROR");

        }
    }

    public void setSelectedPatient(Patient patient) {
        String sql = "SELECT * FROM " + TABLE + " WHERE idpatient = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, patient.getId());

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    patient.setName(resultSet.getString("name"));
                    patient.setAddress(resultSet.getString("address"));
                    patient.setPatientID("" + resultSet.getLong("patient_id"));
                    patient.setBirth(resultSet.getDate("birth_date").toLocalDate());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            NotificationUtil.showNotification("Failed to get patient", "ERROR");
        }
    }

    public void deletePatient(Patient patient) throws SQLException {
        String sql = "DELETE FROM " + TABLE + " WHERE idpatient = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, patient.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            NotificationUtil.showNotification("Failed to delete patient", "ERROR");
        }
    }

    public void savePatient(Patient patient) throws SQLException {
        String sql = "INSERT INTO " + TABLE + " (name, address, patient_id, birth_date) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, patient.getName());
            statement.setString(2, patient.getAddress());
            statement.setLong(3, Long.parseLong(patient.getPatientID()));
            statement.setDate(4, Date.valueOf(patient.getBirth()));

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                NotificationUtil.showNotification("Patient saved successfully", "INFORMATION");
            } else {
                NotificationUtil.showNotification("Failed to save patient", "ERROR");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    patient.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating patient failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                NotificationUtil.showNotification("Failed to save patient: Duplicate NIK", "ERROR");
            } else {
                e.printStackTrace();
                NotificationUtil.showNotification("Failed to save patient", "ERROR");
            }
        }
    }

    public List<Patient> getAllPatients() throws SQLException {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE + " ORDER BY idpatient ASC";

        try (java.sql.Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Patient patient = new Patient();
                patient.setId(resultSet.getInt("idpatient"));
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
