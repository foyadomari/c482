package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main public class
 *
 * Creates the Inventory Management System application
 *
 * @author Felice Oyadomari III
 *
 * <p><b>FUTURE ENHANCEMENTS:</p></b>
 * <p>
 *     Store the inventory data in a database to allow the persistence of the information after the application is closed
 *     <br><br>
 *     Allow copying or templating of products and/or parts. This should speed up the creation of new parts/products that are similiar to a part/product that's already in the inventory
 *     <br><br>
 *     The highlighting of the text fields that are filled out incorrectly.
 * </p>
 *
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 400);
        stage.setTitle("C482 Inventory Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}