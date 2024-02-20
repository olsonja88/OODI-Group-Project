package edu.metrostate.model;

public class BasicFoodItem {
    // TODO: Fill out this class from Lucid Chart diagram
    private String name;
    private static int foodID = 0;
    private String description;
    private String category;
    private float price;

    public BasicFoodItem(String name, String description, String category, float price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        foodID = foodID++;
    }

    public void setName(String name1) {
        name = name1;
    }

    public String getName() {
        return name;
    }

    public void setID(int num) {
        foodID = num;
    }

    public int getID() {
        return foodID;
    }

    public void setDescription(String decs) {
        description = decs;
    }

    public String getDescription() {
        return description;
    }

    public void setCategory(String cat) {
        category = cat;
    }

    public String getCategory() {
        return category;
    }

    public void setPrice(float f) {
        price = f;
    }

    public float getPrice() {
        return price;
    }
}
