package edu.metrostate.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;

public class LandingPageController {

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Button populateButton;

    @FXML
    private Button testButton;

    @FXML
    private Button closeConnectionButton;

    public void initialize()
    {
        ObservableList<String> categories = FXCollections.observableArrayList(
                "Category 1", "Category 2", "Category 3", "Category 4"
        );

        comboBox.setItems(categories);
    }

    @FXML
    private void onPopulateButtonClicked()
    {
        ObservableList<String> categories = FXCollections.observableArrayList(
                "Populated 1", "Populated 2", "Populated 3", "Populated 4"
        );

        comboBox.setItems(categories);
        populateButton.setDisable(true);
    }

    @FXML
    private void onTestButtonClicked()
    {
        testButton.setDisable(true);
    }

    @FXML
    private void onCloseConnectionButtonClicked()
    {
    closeConnectionButton.setDisable(true);
    }
}
