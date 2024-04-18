package edu.metrostate.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class RootController {
    @FXML
    private HBox contentSection;
    private LandingPageController landingPageController;
    private ScrollPageController scrollPageController;
    private RestaurantPageController restaurantPageController;
    private CheckoutPageController checkoutPageController;

    //button to return to homepage
    @FXML
    private Button returnHome;

    public RootController() {}

    public void initialize()
    {
        try {
            //create loader for landng page
            FXMLLoader landingPageLoader = new FXMLLoader(getClass().getResource("/edu/metrostate/LandingPage.fxml"));

            //create hbox for landing page screen
            HBox landingPage = landingPageLoader.load();

            //connect to the landing page controller
            landingPageController = landingPageLoader.getController();

            // code to switch to scroll page when getSearch Button is clicked. calls switch to scroll page method
            landingPageController.getSearchButton().setOnAction(event -> {
                switchToScrollPage();
            });

            //call root Hbox to set all attributes of landing page on the screen
            contentSection.getChildren().setAll(landingPage.getChildren());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        /*
        try{
            FXMLLoader landingPageLoader = new FXMLLoader(getClass().getResource("/edu/metrostate/LandingPage.fxml"));
            HBox landingPage = landingPageLoader.load();
            landingPageController = landingPageLoader.getController();
            landingPageController

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    */

    private void switchToScrollPage() {
        try {
            //create loader for scroll page
            FXMLLoader scrollPageLoader = new FXMLLoader(getClass().getResource("/edu/metrostate/ScrollPage.fxml"));

            // load scroll page into hbox
            HBox scrollPage = scrollPageLoader.load();

            // create instance of scrollpage controller
            scrollPageController = scrollPageLoader.getController();

            // populate scroll page
            scrollPageController.populateScrollPage(landingPageController.getSelectedCategory());

            // push populated scroll page into content section
            contentSection.getChildren().setAll(scrollPage.getChildren());

            // create event check to see if a restaurant was clicked
            scrollPageController.setOnButtonClick(event -> {

                //if restaurant was clicked get restaurant id and category to call switchtorestaurantpage method
                if (event instanceof RestaurantButtonClickEvent) {
                    RestaurantButtonClickEvent buttonClickEvent = event;
                    int ID = buttonClickEvent.getID();
                    String category = buttonClickEvent.getCategory();
                    switchToRestaurantPage(ID, category);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void switchToRestaurantPage(int restaurantID, String restaurantCategory) {
        try {

            //create loader
            FXMLLoader restaurantPageLoader = new FXMLLoader(getClass().getResource("/edu/metrostate/RestaurantPage.fxml"));

            //load restaurant page into hbox
            HBox restaurantPage = restaurantPageLoader.load();

            // create controller, call methods in restaurant page controller
            restaurantPageController = restaurantPageLoader.getController();
            restaurantPageController.populateRestaurantPage(restaurantID, restaurantCategory);
            restaurantPageController.setupOrderTab();

            //connect to restaurant page fxml file and gets all elements
            contentSection.getChildren().setAll(restaurantPage.getChildren());

            // event handler to switch to checkout page once order is finshed
            restaurantPageController.setOnButtonClick(event -> {
                CheckoutButtonClickEvent buttonClickEvent = event;
                float total = buttonClickEvent.getTotal();
                switchToCheckoutPage(total);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void switchToCheckoutPage(float total) {
        try {
            FXMLLoader checkoutPageLoader = new FXMLLoader(getClass().getResource("/edu/metrostate/CheckoutPage.fxml"));
            HBox checkoutPage = checkoutPageLoader.load();
            contentSection.getChildren().setAll(checkoutPage.getChildren());
            checkoutPageController = checkoutPageLoader.getController();
            checkoutPageController.populateCheckoutPage(total);
            checkoutPageController.getOrderButton().setOnAction(event -> {
               switchToSuccessPage();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void switchToSuccessPage() {
        try {
            FXMLLoader successPageLoader = new FXMLLoader(getClass().getResource("/edu/metrostate/SuccessPage.fxml"));
            HBox successPage = successPageLoader.load();
            contentSection.getChildren().setAll(successPage.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleReturnHome(ActionEvent event) {
        initialize();
    }
}
