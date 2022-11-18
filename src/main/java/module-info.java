module foyadomari.c482 {
    requires javafx.controls;
    requires javafx.fxml;


    opens foyadomari.c482 to javafx.fxml;
    exports foyadomari.c482;
    exports controller;
    opens controller to javafx.fxml;
}