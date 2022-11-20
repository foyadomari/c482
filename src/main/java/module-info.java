module Main {
    requires javafx.controls;
    requires javafx.fxml;


    opens model to javafx.fxml;
    exports model;
    exports controller;
    opens controller to javafx.fxml;
    exports Main;
    opens Main to javafx.fxml;
}