package edu.metrostate.service;

import edu.metrostate.model.Restaurant;

import java.util.ArrayList;

public interface RestaurantService {
    // TODO: Declare the methods of RestaurantService
    public void add(Restaurant restaurant);

    public void remove(Restaurant restaurant);

    public ArrayList<Restaurant> getAll();

    public ArrayList<Restaurant> getByCat(String cat);

    public ArrayList<Restaurant> getByCity(String city);
}
