package edu.metrostate;

import edu.metrostate.ui.LandingPageController;
import edu.metrostate.ui.RestaurantPageController;
import edu.metrostate.ui.ScrollPageController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    @FXML
    private Parent landingParent;

    @FXML
    private Parent scrollParent;

    @FXML LandingPageController landingPageController;

    @FXML ScrollPageController scrollPageController;

    @FXML RestaurantPageController restaurantPageController;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("LandingPage.fxml"));
        VBox landingPageRoot = loader1.load();
        LandingPageController landingPageController = loader1.getController();

        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("ScrollPage.fxml"));
        VBox scrollPageRoot = loader2.load();
        ScrollPageController scrollPageController = loader2.getController();

        FXMLLoader loader3 = new FXMLLoader(getClass().getResource("RestaurantPage.fxml"));
        VBox restaurantPageRoot = loader3.load();
        RestaurantPageController restaurantPageController = loader3.getController();

        landingPageController.getSearchButton().setOnAction(event -> {
            switchToScrollPage(stage);
        });

        scrollPageController.getMenuOne().setOnAction(event -> {
            switchToMenuPage(stage);
        });

        Scene scene = new Scene(landingPageRoot);
        stage.setScene(scene);
        stage.setTitle("ICS 372 - HelloFX");
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    private void switchToScrollPage(Stage stage){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ScrollPage.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void switchToMenuPage(Stage stage){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RestaurantPage.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
        }catch( IOException e){
            e.printStackTrace();
        }
    }
}
