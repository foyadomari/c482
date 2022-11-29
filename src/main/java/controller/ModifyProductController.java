package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Part;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyProductController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML private Button addBtn;
    @FXML private TableColumn<Part, Integer> allPartIdCol;
    @FXML private TableColumn<Part, Integer> allPartInvLvlCol;
    @FXML private TableColumn<Part, String> allPartNameCol;
    @FXML private TableColumn<Part, Double> allPartPriceCol;
    @FXML private TableView<Part> allPartsTbl;
    @FXML private TableColumn<Part, Integer> delPartIdCol;
    @FXML private TableColumn<Part, Integer> delPartInvLvlCol;
    @FXML private TableColumn<Part, String> delPartNameCol;
    @FXML private TableView<Part> delPartsTbl;
    @FXML private TableColumn<Part, Double> delPartPriceCol;
    @FXML private Button cancelBtn;
    @FXML private TextField partsSearchTxt;
    @FXML private TextField prodIdTxt;
    @FXML private TextField prodInvTxt;
    @FXML private TextField prodMaxTxt;
    @FXML private TextField prodMinTxt;
    @FXML private TextField prodNameTxt;
    @FXML private Button removePartBtn;
    @FXML private Button saveBtn;

    @FXML
    void onActionAddPart(ActionEvent event) {

    }

    @FXML
    void onActionCancel(ActionEvent event) {

    }

    @FXML
    void onActionPartSearch(ActionEvent event) {

    }

    @FXML
    void onActionRemovePart(ActionEvent event) {

    }

    @FXML
    void onActionSave(ActionEvent event) {

    }

    public void onActionDisplayMainMenu(ActionEvent event) throws IOException {

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
