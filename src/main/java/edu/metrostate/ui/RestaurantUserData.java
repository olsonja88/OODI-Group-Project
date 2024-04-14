package edu.metrostate.ui;

public class RestaurantUserData {
    private int restaurantID;
    private String restaurantCategory;

    public RestaurantUserData(int restaurantID, String restaurantCategory) {
        this.restaurantID = restaurantID;
        this.restaurantCategory = restaurantCategory;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public String getRestaurantCategory() {
        return restaurantCategory;
    }
}
