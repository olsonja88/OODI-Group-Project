package edu.metrostate.model;

import java.util.ArrayList;

public class Restaurant {
    public String name;
    public String location;
    public String category;
    public ArrayList<Menu> menus;
    //ie breakfast menu, lunch menu

    public Restaurant(String name, String location, String category, ArrayList<Menu> menus){
        this.name = name;
        this.location = location;
        this.category = category;
        this.menus = menus;
    }
    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
    public void setLocation(String l){
        location = l;
    }
    public String getLocation(){
        return location;
    }
    public void setCategory(String c){
        category = c;
    }
    public String getCategory(){
        return category;
    }
    public void addToMenu(Menu item){
        //TO DO add method
        menus.add(item);
    }
    public void removeFromMenu(Menu item){
        //TO DO remove method
        menus.remove(item);
    }
    public Menu getMenu(int index) {
        return menus.get(index);
    }
}
