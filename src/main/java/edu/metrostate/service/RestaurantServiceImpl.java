package edu.metrostate.service;

import java.util.ArrayList;
import edu.metrostate.model.Restaurant;

public class RestaurantServiceImpl {
    // Instantiate restaurant table object

    public void addRestaurant(Restaurant restaurant)
    {
        // Insert restaurant object into restaurant table
    }

    public void removeRestaurant(String name)
    {
        // Find row in restaurant table a delete the row
    }

    public ArrayList<Restaurant> getAllRestaurants()
    {
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        // Select all restaurants from table and add to ArrayList

        return restaurants;
    }

    public ArrayList<String> getCategories()
    {
        ArrayList<String> categories = new ArrayList<String>();
        // Select all categories from table and add to ArrayList

        return categories;
    }

    public ArrayList<Restaurant> getByCategory(String category)
    {
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        // Select all restaurants with the specified category

        return restaurants;
    }

    public ArrayList<Restaurant> getByCity(String city)
    {
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        // Select all restaurants with the specified city

        return restaurants;
    }
}
