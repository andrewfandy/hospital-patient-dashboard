module com.application {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.application.controller to javafx.fxml;

    exports com.application;
}
