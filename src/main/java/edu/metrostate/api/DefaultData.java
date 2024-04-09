package edu.metrostate.api;

import edu.metrostate.model.BasicFoodItem;
import edu.metrostate.model.Menu;
import edu.metrostate.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class DefaultData {

    private static Menu getChipotle_menu() {
        ArrayList<BasicFoodItem> items = new ArrayList<>();
        items.add(new BasicFoodItem("Burrito - Steak",
                "Steak Burrito with White Rice, Black Beans, Fresh Tomato Salsa, Sour Creame, Cheese and Romaine Lettuce",
                "Entrée", 10.25f)); //, 1 out 3
        items.add(new BasicFoodItem("Burrito - Chicken", "Chicken Burrito with Brown Rice, Black Beans, Tomatillo-Green Chili Salsa, Sour Creame, Cheese and Romaine Lettuce",
                "Entrée", 8.50f));//, 2 out 3

        return (new Menu("Entree", items));
    }

    public static Menu getChickFilA_menu() {
        ArrayList<BasicFoodItem> items = new ArrayList<>();
        items.add(new BasicFoodItem("Chicken Sandwich", "Original Chicken Sandwich, White Butter Bun Buttered, Pickles", "Entrée", 5.09F));
        items.add(new BasicFoodItem("Chicken Sandwich Meal", "Original Chicken Sandwich, White Butter Bun Buttered, Pickles with waffle fries with Medium Coke", "Meal", 9.09f));
        return (new Menu("Entree", items));
    }

    public static List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant ("Chick-fil-a", "1770 Robert St S, West Saint Paul, MN 55118",
                "American Fast Food", getChickFilA_menu()));
        restaurants.add(new Restaurant("Chipotle",  "5901 94th Ave N Ste 101, Brooklyn Park, MN 55443",
                "Mexican Fast Food", getChipotle_menu()));

        return restaurants;
    }
}
