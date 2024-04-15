package edu.metrostate.ui;

public class FoodItemUserData {
    private String name;
    private float price;

    public FoodItemUserData(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
