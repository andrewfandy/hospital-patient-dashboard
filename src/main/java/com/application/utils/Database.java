package com.application.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// TODO : 1. Create a connection to database
//        2. Check if the connection is valid. If not, execute MySQL statement to create a database
//        3. Create a table if not exists
public class Database {
    private Connection connection;
    private final String DATABASE = "patients_database";
    private final String TABLE = "patients";
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

    public String getTableName() {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE + "(\n"
                + "patient_id INT(15) PRIMARY KEY NOT NULL,\n"
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

        return this.TABLE;
    }

}
