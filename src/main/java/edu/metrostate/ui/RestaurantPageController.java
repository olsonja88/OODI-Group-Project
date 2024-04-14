package edu.metrostate.ui;

import edu.metrostate.model.BasicFoodItem;
import edu.metrostate.model.Order;
import edu.metrostate.model.OrderItem;
import edu.metrostate.model.Restaurant;
import edu.metrostate.service.DatabaseImplementation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class RestaurantPageController {
    @FXML
    private HBox restaurantPage;

    private OrderItem order;

    public RestaurantPageController() {}

    public void initialize() {
        restaurantPage.getChildren().clear();
    }

    public void populateRestaurantPage(int restaurantID, String restaurantCategory) {
        DatabaseImplementation db = DatabaseImplementation.getInstance();
        List<BasicFoodItem> restaurantItems = db.getMenuItems(restaurantID, restaurantCategory);

        VBox menuItemOptions = new VBox();

        for(BasicFoodItem basicFoodItem : restaurantItems) {
            HBox foodOption = new HBox();
            foodOption.getStyleClass().add("food-option");
            Label foodName = new Label(basicFoodItem.getName());
            foodName.getStyleClass().add("food-name");
            Button orderItemButton = new Button("Add to Order");
            orderItemButton.setOnAction(event -> {
            });

            foodOption.getChildren().addAll(foodName, orderItemButton);
            menuItemOptions.getChildren().add(foodOption);
        }

        restaurantPage.getChildren().add(menuItemOptions);
    }
}