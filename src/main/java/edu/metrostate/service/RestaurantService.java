package edu.metrostate.service;

import edu.metrostate.model.Restaurant;
import java.util.ArrayList;

public interface RestaurantService {
    public void addRestaurant(Restaurant restaurant);

    public void removeRestaurant(Restaurant restaurant);

    public ArrayList<Restaurant> getAllRestaurants();

    public ArrayList<Restaurant> getByCategory(String category);

    public ArrayList<String> getAllCategories();

    public ArrayList<Restaurant> getByCity(String city);
}
