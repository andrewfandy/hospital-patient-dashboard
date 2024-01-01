package com.application.controller;

import javafx.scene.control.Alert;

public class NotificationUtil {
    public static void showNotification(String s, String type) {
        try {
            Alert alert = new Alert(Alert.AlertType.valueOf(type));
            alert.setContentText(s);
            alert.setHeaderText(null);
            alert.showAndWait();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.err.println("Invalid alert type");
        }
    }
}