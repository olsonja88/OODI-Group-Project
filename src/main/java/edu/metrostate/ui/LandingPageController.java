package edu.metrostate.ui;

//import com.sun.javafx.stage.EmbeddedWindow;
import edu.metrostate.service.DatabaseImplementation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LandingPageController {

    public void LandingListener() {

    }

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Button searchButton;

    public void initialize() {
        ObservableList<String> categories = FXCollections.observableArrayList(
                "Category 1", "Category 2", "Category 3", "Category 4"
        );

        comboBox.setItems(categories);
    }

    public Button getSearchButton(){
        return searchButton;
    }

    @FXML
    private void onPopulateButtonClicked()
    {
        DatabaseImplementation db = DatabaseImplementation.getInstance();
        db.migrate();
    }

    @FXML
    private void onTestButtonClicked()
    {
        DatabaseImplementation db = DatabaseImplementation.getInstance();
        db.list();

        comboBox.setItems(FXCollections.observableArrayList(db.getCategories()));

     //   testButton.setDisable(true);
    }

    @FXML
    private void onCloseConnectionButtonClicked()
    {}
}