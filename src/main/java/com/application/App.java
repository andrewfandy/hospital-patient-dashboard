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
<<<<<<< HEAD
    private final String DEFAULT = "Home";
=======
    private final String DEFAULT_ROOT = "Home";
>>>>>>> ddab9f17ad8829f2371da65637be35cbfb26e622
    private final String ICON = "/images/icon.png";

    @Override
    public void start(Stage stage) throws IOException {

        try {
            // Starting Page
<<<<<<< HEAD
            scene = new Scene(loadPages(DEFAULT));
=======
            scene = new Scene(loadPages(DEFAULT_ROOT));
>>>>>>> ddab9f17ad8829f2371da65637be35cbfb26e622
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
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}