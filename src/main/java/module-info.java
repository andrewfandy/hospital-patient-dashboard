module com.application {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires transitive javafx.graphics;

    opens com.application.controller to javafx.fxml;
    opens com.application.model to javafx.base;

    exports com.application;
}
