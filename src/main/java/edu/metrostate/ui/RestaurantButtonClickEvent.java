package edu.metrostate.ui;

import javafx.event.ActionEvent;

public class RestaurantButtonClickEvent extends ActionEvent {
    private int ID;
    private String category;

    public RestaurantButtonClickEvent(ActionEvent source, int ID, String category) {
        super(source, source.getTarget());
        this.ID = ID;
        this.category = category;
    }

    public int getID() {
        return ID;
    }

    public String getCategory() {
        return category;
    }
}
