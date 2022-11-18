module foyadomari.c482 {
    requires javafx.controls;
    requires javafx.fxml;


    opens foyadomari.Main to javafx.fxml;
    exports foyadomari.Main;
    exports controller;
    opens controller to javafx.fxml;
    exports Main;
    opens Main to javafx.fxml;
}