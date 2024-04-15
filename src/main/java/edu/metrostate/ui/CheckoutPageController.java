package edu.metrostate.ui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.text.DecimalFormat;

public class CheckoutPageController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField ccNumberField;
    @FXML
    private TextField cvvNumberField;
    @FXML
    private Label billingAddressLabel;
    @FXML
    private TextField billingAddressField;
    @FXML
    private Label billingCityLabel;
    @FXML
    private TextField billingCityField;
    @FXML
    private Label billingStateLabel;
    @FXML
    private TextField billingStateField;
    @FXML
    private Label billingZipCodeLabel;
    @FXML
    private TextField billingZipCodeField;
    @FXML
    private TextField tipField;
    @FXML
    private Label subtotalLabel;
    @FXML
    private Label taxLabel;
    @FXML
    private Label tipLabel;
    @FXML
    private Label totalLabel;

    private boolean sameAsDeliv = false;
    private final double TAX_RATE = 0.08375;
    private double subtotal = 0;
    private double tip = 0;
    private double total = 0;
    private DecimalFormat df = new DecimalFormat("0.00");

    public void populateCheckoutPage(float num) {
        subtotal = num;
        double currTax = subtotal * TAX_RATE;
        total = subtotal + currTax;

        subtotalLabel.setText("Subtotal: $" + df.format(subtotal));
        taxLabel.setText("Tax: $" + df.format(currTax));
        totalLabel.setText("Total: $" + df.format(total));
    }

    @FXML
    public void twentyButtonClicked() {
        tip = subtotal * 0.20;
        updateTotalLabels();
        updateTipField();
    }

    @FXML
    public void fifteenButtonClicked() {
        tip = subtotal * 0.15;
        updateTotalLabels();
        updateTipField();
    }

    @FXML
    public void tenButtonClicked() {
        tip = subtotal * 0.10;
        updateTotalLabels();
        updateTipField();
    }

    @FXML
    public void sameAsDelivClicked() {
        sameAsDeliv = !sameAsDeliv;

        billingAddressLabel.setVisible(!sameAsDeliv);
        billingAddressField.setVisible(!sameAsDeliv);

        billingCityLabel.setVisible(!sameAsDeliv);
        billingCityField.setVisible(!sameAsDeliv);

        billingStateLabel.setVisible(!sameAsDeliv);
        billingStateField.setVisible(!sameAsDeliv);

        billingZipCodeLabel.setVisible(!sameAsDeliv);
        billingZipCodeField.setVisible(!sameAsDeliv);
    }

    private void updateTipField() {
        tipField.setText(String.valueOf(tip));
    }

    private void updateTotalLabels() {
        tipLabel.setText("Tip: $" + df.format(tip));
        total = subtotal + tip;
        totalLabel.setText("Total: $" + df.format(total));
    }
}
