package edu.metrostate.ui;

import edu.metrostate.model.Restaurant;
import edu.metrostate.service.DatabaseImplementation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class ScrollPageController {
    @FXML
    private HBox scrollPage;

    public ScrollPageController() {}

    public void initialize() {
        scrollPage.getChildren().clear();
    }

    public void populateScrollPage(String selectedCategory) {
        DatabaseImplementation db = DatabaseImplementation.getInstance();
        List<Restaurant> allRestaurants= db.getRestaurants();
        ArrayList<Restaurant> selectedRestaurants = new ArrayList<>();

        for (Restaurant restaurant : allRestaurants) {
            if (restaurant.getCategory().equalsIgnoreCase(selectedCategory)) {
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
            viewMenuButton.setUserData(restaurant.getID());

            restaurantOption.getChildren().addAll(restaurantName, viewMenuButton);
            restaurantOptions.getChildren().add(restaurantOption);
        }

        scrollPage.getChildren().add(restaurantOptions);
    }
}