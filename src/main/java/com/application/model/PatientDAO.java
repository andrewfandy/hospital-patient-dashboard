package com.application.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.application.utils.Database;
import com.application.utils.NotificationUtil;

public class PatientDAO extends Database {
    private static Connection connection;
    private static String MAIN_TABLE;

    public PatientDAO() {
        connection = super.getConnection();
        MAIN_TABLE = super.getMainTable();
    }

    public static Patient getSelectedPatient(int referenceID) {
        Patient patient = new Patient();
        String sql = "SELECT * FROM " + MAIN_TABLE + " WHERE " + referenceID + " = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, Integer.parseInt(patient.getPatientID()));

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    patient.setName(resultSet.getString("name"));
                    patient.setAddress(resultSet.getString("address"));
                    patient.setPatientID("" + resultSet.getLong("patient_id"));
                    patient.setBirth(resultSet.getDate("birth_date").toLocalDate());

                    System.out.println(patient);

                    return patient;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            NotificationUtil.showNotification("Failed to get patient", "ERROR");
        }
        return patient;
    }

    public void deletePatient(Patient patient) throws SQLException {

        // using index ID
        String sql = "DELETE FROM " + MAIN_TABLE + " WHERE idpatient = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, patient.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            NotificationUtil.showNotification("Failed to delete patient", "ERROR");
        }
    }

    public void savePatient(Patient patient) throws SQLException {
        String sql = "INSERT INTO " + MAIN_TABLE + " (name, address, patient_id, birth_date) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
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

        } catch (SQLException e) {
            if (e.getErrorCode() == 19) {
                NotificationUtil.showNotification("Failed to save patient: Duplicate NIK",
                        "ERROR");
            } else {
                e.printStackTrace();
                NotificationUtil.showNotification("Failed to save patient", "ERROR");
            }
        }
    }

    public List<Patient> getAllPatients() throws SQLException {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM " + MAIN_TABLE + " ORDER BY idpatient ASC";

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
