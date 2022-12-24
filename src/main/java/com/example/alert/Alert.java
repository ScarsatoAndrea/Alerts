package com.example.alert;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.awt.*;
import java.io.Serializable;

public class Alert  implements Serializable {
    private final int POSTURE = 0;
    private final int DRINK = 1;
    private final int REST = 2;
    private int type;
    private int duration;
    transient private Timeline timeline;
    private SystemTray tray;

    public Alert (int type, int duration){
        this.type = type;
        this.duration = duration;
        if (duration != 0)
            this.timeline = new Timeline(new KeyFrame(Duration.minutes(duration), e -> notifica(this.type)));
        this.timeline.setCycleCount(Animation.INDEFINITE);
    }

    public void start(){
        if (timeline == null){
            this.timeline = new Timeline(new KeyFrame(Duration.minutes(duration), e -> notifica(this.type)));
            this.timeline.setCycleCount(Animation.INDEFINITE);
        }
        timeline.play();
    }

    private void notifica(int type){
        tray = SystemTray.getSystemTray();

        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");

        TrayIcon trayIcon = new TrayIcon(image, "esempio di notifica");
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("esempio di notifica");
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        if (type == POSTURE)
            trayIcon.displayMessage("Postura", "Ricordati di sederti bene", TrayIcon.MessageType.INFO);
        else if (type == DRINK)
            trayIcon.displayMessage("Bere", "Stare idratati è molto importante", TrayIcon.MessageType.INFO);
        else if(type == REST)
            trayIcon.displayMessage("Pausa", "Una pausa ogni tanto è d'obbligo", TrayIcon.MessageType.INFO);
        clearNotify();
    }

    public void clearNotify(){
        TrayIcon[] icons = tray.getTrayIcons();
        for (TrayIcon t: icons){
            tray.remove(t);
        }
    }
}
