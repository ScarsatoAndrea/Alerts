package com.example.alert;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

import java.io.*;

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

    private Alert[] alert = new Alert[3];
    int p1 = 0, d1 = 0, r1 = 0;

    @FXML
    public void initialize (){
        ObjectInputStream objIn = null;
        try{
            objIn = new ObjectInputStream(
                    new FileInputStream("alert.bin")
            );
            alert[0] = (Alert)objIn.readObject();
            alert[1] = (Alert)objIn.readObject();
            alert[2] = (Alert)objIn.readObject();
            objIn.close();
        }catch (IOException e){
            alert[0] = null;
            alert[1] = null;
            alert[2] = null;
        }catch (ClassNotFoundException e){
            throw new RuntimeException();
        }
        if (alert[0] != null) {
            alert[0].start();
            alert[1].start();
            alert[2].start();
        }
    }


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
        alert[0] = new Alert(0, p1);
        alert[1] = new Alert(1, d1);
        alert[2] = new Alert(2, r1);
        alert[0].start();
        alert[1].start();
        alert[2].start();

        onShutDown();
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

    public void onShutDown(){
//        alert[0].clearNotify();
//        alert[1].clearNotify();
//        alert[2].clearNotify();

        ObjectOutputStream out = null;
        try{
            out = new ObjectOutputStream(
                    new FileOutputStream("alert.bin")
            );
            out.writeObject(alert[0]);
            out.writeObject(alert[1]);
            out.writeObject(alert[2]);
            out.close();
        }catch (IOException e){
            System.out.println(e);
            throw new RuntimeException();
        }
    }
}