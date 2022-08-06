module com.example.abracadabrar {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.controller to javafx.fxml;
    exports com.controller;
    exports com.gui;
    opens com.gui to javafx.fxml;
}