module com.example.alert {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.alert to javafx.fxml;
    exports com.example.alert;
}