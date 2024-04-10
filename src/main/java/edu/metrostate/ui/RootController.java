package edu.metrostate.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;

import java.io.IOException;

public class RootController {
    @FXML
    private HBox contentSection;
    private LandingPageController landingPageController;
    private ScrollPageController scrollPageController;
    private RestaurantPageController restaurantPageController;

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

            FXMLLoader scrollPageLoader = new FXMLLoader(getClass().getResource("/edu/metrostate/ScrollPage.fxml"));
            HBox scrollPage = scrollPageLoader.load();
            scrollPageController = scrollPageLoader.getController();
            //scrollPageController.getButtons().setOnAction(event ->{
            //   switchToRestaurantPage();
            //});

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
            setRestaurantButtonListeners();
            contentSection.getChildren().setAll(scrollPage.getChildren());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void setMenuItemButtonListeners(){
        for(Button button : restaurantPageController.getButtons()){
            button.setOnAction(event -> {
                switchToRestaurantPage();
            });
        }
    }

    private void switchToRestaurantPage() {
        //System.out.println("Switching to restaurant: " + restaurantID);
        try {
            FXMLLoader restaurantPageLoader = new FXMLLoader(getClass().getResource("/edu/metrostate/RestaurantPage.fxml"));
            HBox restaurantPage = restaurantPageLoader.load();
            restaurantPageController = restaurantPageLoader.getController();
            restaurantPageController.populateRestaurantPage(scrollPageController.getSelectedRestaurant());
            setMenuItemButtonListeners();
            contentSection.getChildren().setAll(restaurantPage.getChildren());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void setRestaurantButtonListeners() {
        for (Button button : scrollPageController.getButtons()) {
            button.setOnAction(event -> {
                switchToRestaurantPage();
            });
        }
    }
}
