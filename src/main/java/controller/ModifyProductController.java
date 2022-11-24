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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyProductController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private Button addBtn;

    @FXML
    private TableColumn<?, ?> allPartIdCol;

    @FXML
    private TableColumn<?, ?> allPartInvLvlCol;

    @FXML
    private TableColumn<?, ?> allPartNameCol;

    @FXML
    private TableColumn<?, ?> allPartPriceCol;

    @FXML
    private TableView<?> allPartsTbl;

    @FXML
    private TableColumn<?, ?> associatedPartIdCol;

    @FXML
    private TableColumn<?, ?> associatedPartInvLvlCol;

    @FXML
    private TableColumn<?, ?> associatedPartNameCol;

    @FXML
    private TableView<?> associatedPartsTbl;

    @FXML
    private TableColumn<?, ?> asssociatedPartPriceCol;

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField partsSearchTxt;

    @FXML
    private TextField prodIdTxt;

    @FXML
    private TextField prodInvTxt;

    @FXML
    private TextField prodMaxTxt;

    @FXML
    private TextField prodMinTxt;

    @FXML
    private TextField prodNameTxt;

    @FXML
    private Button removePartBtn;

    @FXML
    private Button saveBtn;

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
