package edu.metrostate.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static edu.metrostate.service.DatabaseImplementation.closeQuietly;

public class Menu {
    private int menuID = 0;
    private String category;
    private ArrayList<BasicFoodItem> foodItems;

    public Menu(String category, int id){
        this.category = category;
        this.menuID = id;
    }
    public Menu(String category, ArrayList<BasicFoodItem> foodItems){
        this.category = category;
        //this.menuID = menuID++;
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
