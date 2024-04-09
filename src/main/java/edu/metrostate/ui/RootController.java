package edu.metrostate.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import java.io.IOException;

public class RootController {
    @FXML
    private HBox contentSection;
    private LandingPageController landingPageController;

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
            contentSection.getChildren().setAll(scrollPage.getChildren());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
