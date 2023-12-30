module com.application {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires transitive javafx.graphics;

    opens com.application.controller to javafx.fxml;

    exports com.application;
}
