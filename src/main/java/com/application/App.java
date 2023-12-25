package com.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadPages("Home"));
        stage.setTitle("Hospital Patient Data Registration");
        Image icon = new Image(getClass().getResourceAsStream("/images/icon.png"));
        stage.setMaximized(true);
        stage.getIcons().add(icon);
        stage.setScene(scene);

        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadPages(fxml));
    }

    private static Parent loadPages(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}