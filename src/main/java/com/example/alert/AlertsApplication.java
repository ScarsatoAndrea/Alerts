package com.example.alert;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import com.example.alert.Alert;
import java.io.ObjectOutputStream;


public class AlertsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AlertsApplication.class.getResource("alerts-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Alerts!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}