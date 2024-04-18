package edu.metrostate.ui;

import edu.metrostate.service.DatabaseImplementation;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;

public class LandingPageController {
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private Button searchButton;
    private String selectedCategory = "";

    @FXML
    private Button returnHome;

    public LandingPageController() {}

    public void initialize() {

        // create connection to database
        DatabaseImplementation db = DatabaseImplementation.getInstance();

        //get list of restaurants
        db.list();

        //set comboBox of categories
        comboBox.setItems(FXCollections.observableArrayList(db.getCategories()));

        //when a category is chosen, get value of the restaurant chosen
        comboBox.setOnAction(event -> {
            selectedCategory = comboBox.getValue();
        });

        searchButton.setOnAction(event -> {
            if(selectedCategory == null || selectedCategory.isEmpty()) {
                db.getRestaurants();
            }
        });
    }

    public Button getSearchButton(){
        return searchButton;
    }


    public String getSelectedCategory()
    {
        return selectedCategory;
    }
}