package edu.metrostate.model;

import java.util.ArrayList;

public class Menu {
    private static int menuID = 0;
    private String category;
    private ArrayList<BasicFoodItem> foodItems;

    public Menu(String category, ArrayList<BasicFoodItem> foodItems){
        this.category = category;
        this.menuID = menuID++;
        this.foodItems = foodItems;

    }
    public int getMenuID(){
        return menuID;
    }
    public void setCategory(String cat){
        category = cat;
    }
    public String getCategory(){
        return category;
    }
    public void addItem(BasicFoodItem newItem){
        foodItems.add(newItem);
    }
}
