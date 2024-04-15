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
import javafx.event.EventHandler;

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
    private EventHandler<CheckoutButtonClickEvent> buttonClickHandler;

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

        orderItems = new VBox();
        orderWindow = new ScrollPane();
        orderWindow.setContent(orderItems);

        Region spacer = new Region();
        VBox.setVgrow(spacer, javafx.scene.layout.Priority.ALWAYS);

        total = new Label("Total : $0.00");
        checkoutButton = new Button("Checkout");
        checkoutButton.setUserData(sum);
        checkoutButton.setOnAction(event -> {
            float totalPrice = (float) ((Button) event.getSource()).getUserData();

            if (buttonClickHandler != null) {
                buttonClickHandler.handle(new CheckoutButtonClickEvent(event, totalPrice));
            }
        });

        orderTab.getChildren().addAll(orderWindow, spacer, total, checkoutButton);

        restaurantPage.getChildren().add(orderTab);
    }

    private void addItemToOrder(String name, float price) {
        Label orderItem = new Label(name + " $" + price);
        orderItems.getChildren().add(orderItem);

        sum += price;
        checkoutButton.setUserData(sum);
        String newTotal = df.format(sum);
        total.setText("Total: $" + newTotal);
    }

    public void setOnButtonClick(EventHandler<CheckoutButtonClickEvent> handler) {
        this.buttonClickHandler = handler;
    }
}