module com.application {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.application.controller to javafx.fxml;

    exports com.application;
}
