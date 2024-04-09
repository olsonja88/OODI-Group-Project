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
            populateScrollPage(scrollPage);
            contentSection.getChildren().setAll(scrollPage.getChildren());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void populateScrollPage(HBox scrollPage) {
        DatabaseImplementation db = DatabaseImplementation.getInstance();
        List<Restaurant> allRestaurants= db.getRestaurants();
        ArrayList<Restaurant> selectedRestaurants = new ArrayList<>();

        for (Restaurant restaurant : allRestaurants) {
            if (restaurant.getCategory().equalsIgnoreCase(landingPageController.getSelectedCategory())) {
                selectedRestaurants.add(restaurant);
            }
        }

        VBox restaurantOptions = new VBox();

        for (Restaurant restaurant : selectedRestaurants) {
            HBox restaurantOption = new HBox();
            restaurantOption.getStyleClass().add("restaurant-option");
            Label restaurantName = new Label(restaurant.getName());
            restaurantName.getStyleClass().add("restaurant-name");
            Button viewMenuButton = new Button("View Menu");

            restaurantOption.getChildren().addAll(restaurantName, viewMenuButton);
            restaurantOptions.getChildren().add(restaurantOption);
        }

        scrollPage.getChildren().add(restaurantOptions);
    }
}
