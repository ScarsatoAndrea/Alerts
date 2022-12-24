package com.example.alert;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AlertsController {

    /**
     * Creazione degli oggetti per l'interfaccia
     * grafica
     */
    public TextField txtPostureTime;
    public TextField txtDrinkTIme;
    public TextField txtRestTime;
    public Button btnPostureTime;
    public Button btnDrinkTime;
    public Button btnRestTime;
    boolean postureType = true;
    boolean restType = true;
    boolean drinkType = true;

    int p1 = 0, d1 = 0, r1 = 0;

    public void onBtnSaveClick(ActionEvent actionEvent) {
        String p, d, r;
        p = txtPostureTime.getText();
        d = txtDrinkTIme.getText();
        r = txtRestTime.getText();

        if (p != ""){
            if(postureType)
                p1 = Integer.parseInt(p);
            else
                p1 = Integer.parseInt(p) * 60;
        }
        if (d != ""){
            if(drinkType)
                d1 = Integer.parseInt(d);
            else
                d1 = Integer.parseInt(d) * 60;
        }
        if (r != ""){
            if(restType)
                r1 = Integer.parseInt(r);
            else
                r1 = Integer.parseInt(r) * 60;
        }
    }

    /**
     * cambia la scritta del bottone da min a ore e
     * viceversa, di conseguenza anche il valore
     * del campo di testo sarà diverso
     * @param actionEvent
     */
    public void onBtnPostureTimeClick(ActionEvent actionEvent) {
        if(postureType) {
            btnPostureTime.setText("Ore");
            postureType = false;
        }
        else{
            btnPostureTime.setText("Min.");
            postureType = true;
        }

    }
    /**
     * cambia la scritta del bottone da min a ore e
     * viceversa, di conseguenza anche il valore
     * del campo di testo sarà diverso
     * @param actionEvent
     */
    public void onBtnDrinkTimeClick(ActionEvent actionEvent) {
        if(drinkType) {
            btnDrinkTime.setText("Ore");
            drinkType = false;
        }
        else{
            btnDrinkTime.setText("Min.");
            drinkType = true;
        }
    }
    /**
     * cambia la scritta del bottone da min a ore e
     * viceversa, di conseguenza anche il valore
     * del campo di testo sarà diverso
     * @param actionEvent
     */
    public void onBtnRestTimeClick(ActionEvent actionEvent) {
        if(restType) {
            btnRestTime.setText("Ore");
            restType = false;
        }
        else{
            btnRestTime.setText("Min.");
            restType = true;
        }
    }
}