package com.application.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.application.utils.Database;
import com.application.utils.NotificationUtil;

// REFACTOR : 1. Seperate the connection to another class
//            2. Only to use CRUD operation
public class PatientDAO extends Database {
    private Connection connection;
    private final String TABLE;

    public PatientDAO() {
        connection = super.getConnection();
        TABLE = super.getTableName();
    }

    public void setSelectedPatient(Patient patient) {
        String sql = "SELECT * FROM " + TABLE + " WHERE idpatient = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, Integer.parseInt(patient.getPatientID()));

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
        String sql = "DELETE FROM " + TABLE + " WHERE patient_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, Integer.parseInt(patient.getPatientID()));
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
                NotificationUtil.showNotification("Failed to save patient TEST 1", "ERROR");
            }

        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                NotificationUtil.showNotification("Failed to save patient: Duplicate NIK", "ERROR");
            } else {
                e.printStackTrace();
                NotificationUtil.showNotification("Failed to save patient TEST 2", "ERROR");
            }
        }
    }

    public List<Patient> getAllPatients() throws SQLException {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE + " ORDER BY patient_id ASC";

        try (java.sql.Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Patient patient = new Patient();

                // TODO : set index to Patient

                // patient.setId(resultSet.getInt("idpatient"));
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
