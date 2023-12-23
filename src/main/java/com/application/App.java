package com.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        // scene = new Scene(root);
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
        HBox hbox = new HBox();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        hbox.setAlignment(Pos.CENTER);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}