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

    public void populateRestaurantPage(String restaurantName) {
        DatabaseImplementation db = DatabaseImplementation.getInstance();
        List<BasicFoodItem> restaurantItems = db.getMenuItems(restaurantName);

        VBox menuItemOptions = new VBox();

        for(BasicFoodItem basicFoodItem : restaurantItems){
            HBox foodOption = new HBox();
            foodOption.getStyleClass().add("food-option");
            Label foodName = new Label(basicFoodItem.getName());
            foodName.getStyleClass().add("food-name");
            Button addToOrder = new Button("Add to Order");
            addToOrder.setOnAction(event -> {
                order.orderItem(basicFoodItem, 1);
            });
        }
    }

    public List<Button> getButtons() {
        List<Button> buttonList = new ArrayList<>();
        for (Node node : restaurantPage.getChildren()) {
            if (node instanceof Button) {
                buttonList.add((Button) node);
            }
        }
        return buttonList;
    }
}