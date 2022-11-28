package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Part;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class AddProductController implements Initializable {

    Stage stage;
    Parent scene;

    public TableView<Part> myParts;

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

    @FXML
    void onActionAdd(ActionEvent event) {

    }

    @FXML
    void onActionDisplayMainMenu(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionRemovePart(ActionEvent event) {

    }

    @FXML
    void onActionSave(ActionEvent event) {

    }

    @FXML
    void onActionSearch(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
