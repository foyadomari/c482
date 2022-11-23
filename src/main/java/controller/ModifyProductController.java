package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyProductController implements Initializable {

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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
