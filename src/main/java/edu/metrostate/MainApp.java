package edu.metrostate;

import edu.metrostate.service.DatabaseImplementation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        DatabaseImplementation db = DatabaseImplementation.getInstance();
        db.migrate();

        FXMLLoader rootLoader = new FXMLLoader(getClass().getResource("/edu/metrostate/Root.fxml"));
        VBox root = rootLoader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Yummy Food");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
