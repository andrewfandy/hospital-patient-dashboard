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
    private final String DEFAULT_ROOT = "Home";
    private final String ICON = "/com/application/images/icon.png";

    @Override
    public void start(Stage stage) throws IOException {

        try {
            // Starting Page
            scene = new Scene(loadPages(DEFAULT_ROOT));
            stage.setTitle("Hospital Patient Data Registration");
            Image icon = new Image(getClass().getResourceAsStream(ICON));
            stage.setMaximized(true);
            stage.getIcons().add(icon);
            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            System.err.println("Error Start");
            e.printStackTrace();
        }
    }

    public static void setRoot(String fxml) throws IOException {
        try {
            scene.setRoot(loadPages(fxml));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(fxml + " couldn't be loaded");
        }
    }

    private static Parent loadPages(String fxml) throws IOException {
        try {
            String fxmlURL = "/com/application/fxml/" + fxml + ".fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxmlURL));
            return fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(fxml + " couldn't be loaded");
            return null;
        }
    }

    public static void main(String[] args) {
        launch();
    }

}