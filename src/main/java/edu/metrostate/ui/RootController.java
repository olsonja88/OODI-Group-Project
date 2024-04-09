package edu.metrostate.ui;

import edu.metrostate.model.Restaurant;
import edu.metrostate.service.DatabaseImplementation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class RootController {
    @FXML
    private HBox contentSection;
    private LandingPageController landingPageController;
    private ScrollPageController scrollPageController;

    public RootController() {}

    public void initialize()
    {
        try {
            FXMLLoader landingPageLoader = new FXMLLoader(getClass().getResource("/edu/metrostate/LandingPage.fxml"));
            HBox landingPage = landingPageLoader.load();
            landingPageController = landingPageLoader.getController();
            landingPageController.getSearchButton().setOnAction(event -> {
                switchToScrollPage();
            });
            contentSection.getChildren().setAll(landingPage.getChildren());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void switchToScrollPage(){
        try{
            FXMLLoader scrollPageLoader = new FXMLLoader(getClass().getResource("/edu/metrostate/ScrollPage.fxml"));
            HBox scrollPage = scrollPageLoader.load();
            scrollPageController = scrollPageLoader.getController();
            scrollPageController.populateScrollPage(landingPageController.getSelectedCategory());
            contentSection.getChildren().setAll(scrollPage.getChildren());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
