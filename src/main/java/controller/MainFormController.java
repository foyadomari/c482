package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static model.Inventory.getAllParts;


public class MainFormController implements Initializable {
    private static Part selectedPart;
    private static Product selectedProduct;

    Stage stage;
    Parent scene;

    //FXML All Parts Table
    @FXML private TableView<Part> allPartTbl;
    @FXML private TableColumn<Part, Integer> allPartIdCol;
    @FXML private TableColumn<Part, Integer> allPartInvLvlCol;
    @FXML private TableColumn<Part, String> allPartNameCol;
    @FXML private TableColumn<Part, Double> allPartPriceCol;

    //FXML Text Fields
    @FXML private TextField allPartSearchField;
    @FXML private TextField allProdSearchField;

    //FXML All Products Table
    @FXML private TableView<Product> allProdTbl;
    @FXML private TableColumn<Product, Integer> allProdIDCol;
    @FXML private TableColumn<Product, Integer> allProdInvLvlCol;
    @FXML private TableColumn<Product, String> allProdNameCol;
    @FXML private TableColumn<Product, Double> allProdPriceCol;

    //FXML Button
    @FXML private Button addPartButton;
    @FXML private Button modPartButton;
    @FXML private Button deletePartButton;
    @FXML private Button addProdButton;
    @FXML private Button modProdButton;
    @FXML private Button deleteProdButton;
    @FXML private Button partSearchBtn;
    @FXML private Button prodSearchBtn;

    @FXML
    void OnActionExitMain(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void onActionAddPart(ActionEvent event) throws IOException {

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AddPart.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionAddProd(ActionEvent event) throws IOException {

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AddProduct.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionDeletePart(ActionEvent event) {

        System.out.println("Delete Part Button clicked");

    }

    @FXML
    void onActionDeleteProd(ActionEvent event) {

        System.out.println("Delete Product Button clicked");

    }

    @FXML
    void onActionModPart(ActionEvent event) throws IOException {
        selectedPart = allPartTbl.getSelectionModel().getSelectedItem();

        if (selectedPart == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "No part selected \n Try again");
            alert.setTitle("Modify Error");
            alert.setContentText("No part selected \nTry again");
            alert.showAndWait();
        } else {
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/ModifyPart.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }

    }

    @FXML
    void onActionModProd(ActionEvent event) throws IOException {
        selectedProduct = allProdTbl.getSelectionModel().getSelectedItem();

        if(selectedProduct == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setContentText("ERROR: No product selected \n Try again");
            alert.showAndWait();
        }
        else {
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/ModifyProduct.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }

    }

    @FXML
    void onActionPartSearch(ActionEvent event) {

    }

    @FXML
    void onActionProdSearch(ActionEvent event) {

    }
    public static Part getSelectedPart() {
        return selectedPart;
    }
    public static Product getSelectedProduct() {
        return selectedProduct;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        allPartTbl.setItems(getAllParts());
        allPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartInvLvlCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        allProdTbl.setItems((Inventory.getAllProducts()));
        allProdIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allProdInvLvlCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allProdNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allProdPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

    }

}