package edu.metrostate.service;

import edu.metrostate.model.Restaurant;

import java.util.ArrayList;
import java.util.Locale;

public interface RestaurantService {
    // TODO: Declare the methods of RestaurantService
    public void add(Restaurant restaurant);

    public void remove(Restaurant restaurant);

    public ArrayList<Restaurant> getAll();

    public ArrayList<Restaurant> getByCat(String cat);

    // get all categories method?
    public ArrayList<Locale.Category> getCats();

    public ArrayList<Restaurant> getByCity(String city);
}
