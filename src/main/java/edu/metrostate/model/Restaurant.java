package edu.metrostate.model;

public class Restaurant {
    public String name;
    public String location;
    public String category;
    public Menu menus[];

    public Restaurant(String name, String location, String category, Menu menus[]){
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
    }

    public void removeFromMenu(){
        //TO DO remove method
    }
}
