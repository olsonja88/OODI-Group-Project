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

    public LandingPageController() {}

    public void initialize() {
        DatabaseImplementation db = DatabaseImplementation.getInstance();
        db.list();
        comboBox.setItems(FXCollections.observableArrayList(db.getCategories()));
    }

    public Button getSearchButton()
    {
        return searchButton;
    }
}