package edu.metrostate.service;

import edu.metrostate.model.Restaurant;

public interface RestaurantService {
    // TODO: Declare the methods of RestaurantService
    public void add(Restaurant restaurant);

    public void remove(Restaurant restaurant);

    public List<Restaurant> getAll();

    public List<Restaurant> getByCat(String cat);

    public List<Restaurant> getByCity(String city);
}
