package com.application.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private Connection connection;
    private final String DATABASE = "patients_database";
    private final String MAIN_TABLE = "patients";
    private final String URL = "jdbc:sqlite:db/" + DATABASE + ".db";

    public Database() {
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(connection);
            NotificationUtil.showNotification("No SQL Connection, please try again", "ERROR");
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public String getMainTable() {
        String sql = "CREATE TABLE IF NOT EXISTS " + MAIN_TABLE + "(\n"
                + "idpatient INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "patient_id INT(15) UNIQUE NOT NULL,\n"
                + "name TEXT(20) NOT NULL,\n"
                + "address TEXT(50) NOT NULL,\n"
                + "birth_date DATE NOT NULL\n"
                + ");";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            NotificationUtil.showNotification("Failed to create table", "ERROR");
        }

        return this.MAIN_TABLE;
    }

}
