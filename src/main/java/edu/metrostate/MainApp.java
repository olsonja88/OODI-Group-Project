package edu.metrostate;

import edu.metrostate.ui.LandingPageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LandingPage.fxml"));
        VBox root = loader.load();

        LandingPageController landingPageController = loader.getController();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("ICS 372 - HelloFX");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
