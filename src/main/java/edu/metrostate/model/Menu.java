package edu.metrostate.model;

import java.util.ArrayList;

public class Menu {
    private static int menuID = 0;
    private String category;
    private ArrayList[] BasicFoodItem;
    // do we want array list?

    public Menu(String category, ArrayList<BasicFoodItem> menu){
        this.category = category;
        this.menuID = menuID++;

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
}
