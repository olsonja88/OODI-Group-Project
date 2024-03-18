package edu.metrostate.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class LandingPageController {

    @FXML
    private ComboBox<String> comboBox;

    public void initialize()
    {
        ObservableList<String> categories = FXCollections.observableArrayList(
                "Category 1", "Category 2", "Category 3", "Category 4"
        );

        comboBox.setItems(categories);
    }
}
