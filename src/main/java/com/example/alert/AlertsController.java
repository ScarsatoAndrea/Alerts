package com.example.alert;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AlertsController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}