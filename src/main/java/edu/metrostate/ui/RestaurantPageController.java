package edu.metrostate.ui;

import edu.metrostate.model.BasicFoodItem;
import edu.metrostate.service.DatabaseImplementation;

import javafx.fxml.FXML;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.List;

public class RestaurantPageController {
    @FXML
    private HBox restaurantPage;
    @FXML
    private ScrollPane scrollWindow;
    private VBox orderTab;
    private Button checkoutButton;
    private Region spacer;

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
            foodOption.getStyleClass().add("restaurant-option");

            Label foodName = new Label(basicFoodItem.getName());
            foodName.getStyleClass().add("restaurant-name");

            Button orderItemButton = new Button("Add to Order");
            orderItemButton.setUserData(new FoodItemUserData(basicFoodItem.getName(), basicFoodItem.getPrice()));
            orderItemButton.setOnAction(event -> {
                 FoodItemUserData foodItemUserData = (FoodItemUserData) ((Button) event.getSource()).getUserData();
                 String name = foodItemUserData.getName();
                 float price = foodItemUserData.getPrice();
                 addItemToOrder(name, price);
            });

            foodOption.getChildren().addAll(foodName, orderItemButton);
            menuItemOptions.getChildren().add(foodOption);
        }

        scrollWindow.setContent(menuItemOptions);
        restaurantPage.getChildren().add(scrollWindow);
    }

    public void setupOrderTab() {
        orderTab = new VBox();
        orderTab.getStyleClass().add("order-tab");
        restaurantPage.getChildren().add(orderTab);
    }

    private void addItemToOrder(String name, float price) {
        if (checkoutButton != null) {
            orderTab.getChildren().remove(checkoutButton);
        }

        if (spacer != null) {
            orderTab.getChildren().remove(spacer);
        }

        spacer = null;
        checkoutButton = null;

        Label orderItem = new Label(name + " " + price);
        orderTab.getChildren().add(orderItem);

        spacer = new Region();
        VBox.setVgrow(spacer, javafx.scene.layout.Priority.ALWAYS);
        checkoutButton = new Button("Checkout");
        orderTab.getChildren().addAll(spacer, checkoutButton);
    }
}