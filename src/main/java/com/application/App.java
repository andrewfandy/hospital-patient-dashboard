package com.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import com.application.controller.*;

public class App extends Application {
    private static Scene scene;
    private final String DEFAULT_ROOT = "Home";
    private final String DEFAULT_CONTROLLER = "Home";
    private final String ICON = "/images/icon.png";

    @Override
    public void start(Stage stage) throws IOException {

        try {
            // Starting Page
            scene = new Scene(loadPages(DEFAULT_ROOT, DEFAULT_CONTROLLER));
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

    public static void setRoot(String fxml, String controller) throws IOException {
        try {
            scene.setRoot(loadPages(fxml, controller));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(fxml + " couldn't be loaded");
        }
    }

    private static Parent loadPages(String fxml, String controller) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        switch (controller) {
            case "Home":
                fxmlLoader.setController(new App());
                break;
            case "AddPatient":
                fxmlLoader.setController(new AddPatient());
                break;
            case "ShowPatient":
                fxmlLoader.setController(new ShowPatient());
                break;
            case "EditPatient":
                fxmlLoader.setController(new EditPatient());
                break;
            default:
                break;
        }
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}