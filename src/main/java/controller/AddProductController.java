package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Part;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class AddProductController implements Initializable {

    Stage stage;
    Parent scene;

    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();

    @FXML
    private Button addPartBtn;

    @FXML
    private TableColumn<Part, Integer> allPartIdCol;

    @FXML
    private TableColumn<Part, Integer> allPartInvLvlCol;
    @FXML
    private TableColumn<Part, String> allPartNameCol;
    @FXML
    private TableColumn<Part, Double> allPartPriceCol;
    @FXML
    private TableView<Part> allPartTbl;
    @FXML
    private TableColumn<Part, Integer> delPartIdCol;
    @FXML
    private TableColumn<Part, Integer> delPartInvLvlCol;
    @FXML
    private TableColumn<Part, String> delPartNameCol;
    @FXML
    private TableColumn<Part, Double> delPartPriceCol;
    @FXML
    private TableView<?> delPartTabl;
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
        allPartTbl.setItems(allPartTbl.getItems());
        allPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartInvLvlCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        delPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        delPartInvLvlCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        delPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        delPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}
