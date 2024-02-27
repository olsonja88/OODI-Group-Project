package edu.metrostate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
        BorderPane root = loader.load();

        Scene scene = new Scene(root);

        stage.setTitle("ICS 372 - HelloFX");
        stage.setScene(scene);
        stage.show();
    }
}
