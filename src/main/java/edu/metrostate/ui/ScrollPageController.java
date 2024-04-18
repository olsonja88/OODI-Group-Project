package edu.metrostate.ui;

import edu.metrostate.model.Restaurant;
import edu.metrostate.service.DatabaseImplementation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.List;

public class ScrollPageController {
    @FXML
    private HBox scrollPage;
    @FXML
    private ScrollPane scrollWindow;
    private EventHandler<RestaurantButtonClickEvent> buttonClickHandler;

    @FXML
    private Button returnHome;

    public ScrollPageController() {}

    public void initialize() {
        scrollPage.getChildren().clear();
    }

    //populate scroll page based on restaurant chosen
    public void populateScrollPage(String selectedCategory) {

        //connect to database
        DatabaseImplementation db = DatabaseImplementation.getInstance();

        //get a list of restaurants
        List<Restaurant> allRestaurants = db.getRestaurants();

        //create arraylist for the selected restaurant
        ArrayList<Restaurant> selectedRestaurants = new ArrayList<>();

        // iterate through list of restaurants
        for (Restaurant restaurant : allRestaurants) {

            // add selected restaurant to list if chosen
            if (restaurant.getCategory().equalsIgnoreCase(selectedCategory)) {
                selectedRestaurants.add(restaurant);
            }
            else if(selectedCategory.isEmpty()){
                selectedRestaurants.add(restaurant);
            }
        }

        // create vbox for restaurant options
        VBox restaurantOptions = new VBox();

        // get selected restaurants from chosen category
        for (Restaurant restaurant : selectedRestaurants) {

            //create hbox for restaurants
            HBox restaurantOption = new HBox();

            //add style class for css file
            restaurantOption.getStyleClass().add("restaurant-option");

            // create label for each restaurant
            Label restaurantName = new Label(restaurant.getName());
            restaurantName.getStyleClass().add("restaurant-name");


            //create menu button for each restaurant
            Button viewMenuButton = new Button("View Menu");
            viewMenuButton.setUserData(new RestaurantUserData(restaurant.getID(), restaurant.getCategory()));
            viewMenuButton.setOnAction(event -> {
                RestaurantUserData restaurantUserData = (RestaurantUserData) ((Button) event.getSource()).getUserData();
                int ID = restaurantUserData.getRestaurantID();
                String category = restaurantUserData.getRestaurantCategory();

                if (buttonClickHandler != null) {
                    buttonClickHandler.handle(new RestaurantButtonClickEvent(event, ID, category));
                }
            });

            restaurantOption.getChildren().addAll(restaurantName, viewMenuButton);
            restaurantOptions.getChildren().add(restaurantOption);
        }

        scrollWindow.setContent(restaurantOptions);
        scrollPage.getChildren().add(scrollWindow);
    }

    public void setOnButtonClick(EventHandler<RestaurantButtonClickEvent> handler) {
        this.buttonClickHandler = handler;
    }

    public Button getReturnHome() {
        return returnHome;
    }
}
