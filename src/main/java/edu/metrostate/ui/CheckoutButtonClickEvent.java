package edu.metrostate.ui;

import javafx.event.ActionEvent;

public class CheckoutButtonClickEvent extends ActionEvent {
    private float total;

    public CheckoutButtonClickEvent(ActionEvent source, float total) {
        super(source, source.getTarget());
        this.total = total;
    }

    public float getTotal() {
        return total;
    }
}
