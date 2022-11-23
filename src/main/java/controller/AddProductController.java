package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AddProductController implements Initializable {

    @FXML
    private Button addPartBtn;

    @FXML
    private TableColumn<?, ?> allPartIdCol;

    @FXML
    private TableColumn<?, ?> allPartInvLvlCol;

    @FXML
    private TableColumn<?, ?> allPartNameCol;

    @FXML
    private TableColumn<?, ?> allPartPriceCol;

    @FXML
    private TableView<?> allPartTbl;

    @FXML
    private TableColumn<?, ?> associatedPartIdCol;

    @FXML
    private TableColumn<?, ?> associatedPartInvLvlCol;

    @FXML
    private TableColumn<?, ?> associatedPartNameCol;

    @FXML
    private TableColumn<?, ?> associatedPartPriceCol;

    @FXML
    private TableView<?> associatedPartTabl;

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField partSearchTxt;

    @FXML
    private Label prodIdLbl;

    @FXML
    private TextField prodIdTxt;

    @FXML
    private Label prodInvLbl;

    @FXML
    private TextField prodInvTxt;

    @FXML
    private Label prodMaxLbl;

    @FXML
    private TextField prodMaxTxt;

    @FXML
    private Label prodMinLbl;

    @FXML
    private TextField prodMinTxt;

    @FXML
    private Label prodNameLbl;

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
