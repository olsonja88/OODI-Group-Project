package edu.metrostate.ui;

import edu.metrostate.model.BasicFoodItem;
import edu.metrostate.service.DatabaseImplementation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.List;
import java.text.DecimalFormat;

public class RestaurantPageController {
    @FXML
    private HBox restaurantPage;
    @FXML
    private ScrollPane scrollWindow;
    private ScrollPane orderWindow;
    private VBox orderTab;
    private VBox orderItems;
    private Label total;
    private Button checkoutButton;
    private float sum = 0;
    private DecimalFormat df = new DecimalFormat("0.00");

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
        // Create the order tab
        orderTab = new VBox();
        orderTab.getStyleClass().add("order-tab");

        // Create the box that will hold order items
        orderItems = new VBox();

        // Create the scroll pane that will hold the box that holds the order items
        orderWindow = new ScrollPane();
        orderWindow.setContent(orderItems);

        // Create the spacer between the order window and the total and checkout button
        Region spacer = new Region();
        VBox.setVgrow(spacer, javafx.scene.layout.Priority.ALWAYS);

        // Create a total label
        total = new Label("Total : $0.00");

        // Create a checkout button
        checkoutButton = new Button("Checkout");

        // Add scroll pane and spacer as children of the tab
        orderTab.getChildren().addAll(orderWindow, spacer, total, checkoutButton);

        // Add order tab as child of the whole page
        restaurantPage.getChildren().add(orderTab);
    }

    private void addItemToOrder(String name, float price) {
        // Create a new order item and add it to the orderItems
        Label orderItem = new Label(name + " $" + price);
        orderItems.getChildren().add(orderItem);

        // Update our total with a new total
        sum += price;
        String newTotal = df.format(sum);
        total.setText("Total: $" + newTotal);
    }
}