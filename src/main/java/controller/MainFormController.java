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
import java.util.ResourceBundle;

import static model.Inventory.getAllParts;


public class MainFormController implements Initializable {
    private static Part partToModify;
    private static int selectedPart;
    private static Product productToModify;
    private static int selectedProduct;

    Stage stage;
    Parent scene;

    @FXML private TableView<Part> allPartTbl;
    @FXML private TableColumn<Part, Integer> allPartIdCol;
    @FXML private TableColumn<Part, Integer> allPartInvLvlCol;
    @FXML private TableColumn<Part, String> allPartNameCol;
    @FXML private TableColumn<Part, Double> allPartPriceCol;

    @FXML private TextField allPartSearchField;
    @FXML private TextField allProdSearchField;

    @FXML private TableView<Product> allProdTbl;
    @FXML private TableColumn<Product, Integer> allProdIDCol;
    @FXML private TableColumn<Product, Integer> allProdInvLvlCol;
    @FXML private TableColumn<Product, String> allProdNameCol;
    @FXML private TableColumn<Product, Double> allProdPriceCol;

    @FXML private Button addPartButton;
    @FXML private Button modPartButton;
    @FXML private Button deletePartButton;
    @FXML private Button addProdButton;
    @FXML private Button modProdButton;
    @FXML private Button deleteProdButton;

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

        System.out.println("Modify Part Button clicked");
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/ModifyPart.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionModProd(ActionEvent event) throws IOException {

        System.out.println("Modify Product Button clicked");
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/ModifyProduct.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

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