package controller;
/**
 * Main Form Controller
 * @author - Felice Oyadomari III
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.Optional;
import java.util.ResourceBundle;

import static model.Inventory.getAllParts;

/**
 * Controller for the main screen
 */
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

    /**
     * When the "Exit" button is clicked method
     *
     * Closes the window and exits the program
     *
     * @param event when the user clicks on the "Exit" button
     */
    @FXML
    void OnActionExitMain(ActionEvent event) {

        System.exit(0);
    }

    /**
     * When the "Add" button on the parts panel is clicked method
     *
     * Opens the Add part form
     *
     * @param event when a user clicks on the "Add" button on the parts panel
     * @throws IOException dismisses any IO exceptions that may occur
     */
    @FXML
    void onActionAddPart(ActionEvent event) throws IOException {

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AddPart.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    /**
     * When the "Add" button on the product panel is clicked method
     *
     * Opens the Add product form
     *
     * @param event when a user clicks on the "Add" button in the product panel
     * @throws IOException dismisses any IO exceptions that may occur
     */
    @FXML
    void onActionAddProd(ActionEvent event) throws IOException {

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AddProduct.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    /**
     * The part "Delete" button is clicked method
     *
     * Deletes the selected from the inventory
     *
     * RUNTIME ERROR: When no part is selected, a window pops up
     *
     * @param event when a user clicks on the delete button in the parts panel
     */
    @FXML
    void onActionDeletePart(ActionEvent event) {
        selectedPart = allPartTbl.getSelectionModel().getSelectedItem();

        // Checks to see if a part is selected
        if (selectedPart == null){
            Alert alert = new Alert(Alert.AlertType.WARNING,"ERROR: No part selected.");
            alert.showAndWait();
        }
        // Gets confirmation that the user wants to delete the part from the inventory
        if (selectedPart != null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure you want to delete this part?");
            Optional<ButtonType> response = alert.showAndWait();
            if (response.isPresent() && response.get() == ButtonType.OK) {
                Inventory.deletePart(selectedPart);
            }
        }
    }

    /**
     * The product "Delete" button is clicked method
     *
     * Deletes the selected product from the inventory
     *
     * RUNTIME ERROR: When no part is selected, a window pops up
     *
     * @param event when a user clicks on the delete button in the product panel
     */
    @FXML
    void onActionDeleteProd(ActionEvent event) {
        selectedProduct = allProdTbl.getSelectionModel().getSelectedItem();

        // Checks to see if a product is selected
        try{
            if (selectedProduct.getAllAssociatedParts().size() == 0){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"This will delete this product. Are you sure?");
                Optional<ButtonType> response = alert.showAndWait();
                if (response.isPresent() && response.get() == ButtonType.OK) {
                    Inventory.deleteProduct(selectedProduct);
                }
            }
            else if (selectedProduct.getAllAssociatedParts().size() > 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "This product cannot be delete because it has associated part(s). Delete the associated part(s) first.");
                alert.showAndWait();
            }
        }
        catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.WARNING, "No product selected.");
            alert.showAndWait();
        }
    }

    /**
     * When the parts panel "Modify" button is clicked method
     *
     * Opens the Modify Part screen with the selected part's information preloaded
     *
     * RUNTIME ERROR: If no part is selected, a window pops up
     *
     * @param event when the user clicks on the "Modify" button in the parts panel
     * @throws IOException dismisses any IO exception that may occur
     */
    @FXML
    void onActionModPart(ActionEvent event) throws IOException {
        selectedPart = allPartTbl.getSelectionModel().getSelectedItem();
        // Checks to see if a part is selected
        if (selectedPart == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "No part selected.");
            alert.setTitle("Modify Error");
            alert.showAndWait();
        }
        // No error occurred, goes to Modify Part screen
        else {
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/ModifyPart.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }
    }

    /**
     * When the product panel "Modify" button is clicked method
     *
     * Opens the Modify Part screen with the selected product's information preloaded
     *
     * RUNTIME ERROR: If no product is selected, a window pops up
     *
     * @param event when the user clicks on the "Modify" button in the product panel
     * @throws IOException dismisses any IO exception that may occur
     */
    @FXML
    void onActionModProd(ActionEvent event) throws IOException {
        selectedProduct = allProdTbl.getSelectionModel().getSelectedItem();
        // Checks to see if a product is selected
        if(selectedProduct == null){
            Alert alert = new Alert(Alert.AlertType.WARNING, "ERROR: No product selected.");
            alert.setTitle("Warning Dialog");
            alert.showAndWait();
        }
        // No error occurred, goes to Modify Product screen
        else {
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/ModifyProduct.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }
    }

    /**
     * When the part search bar is used method
     * Searches the inventory for the matching part
     *
     * RUNTIME ERROR: If the search bar has no input, a window will pop up
     * RUNTIME ERROR: If there is no matching parts, a window will pop up
     *
     * @param event when a user clicks on the search button in the part panel
     */
    @FXML
    void onActionPartSearch(ActionEvent event) {
        String searchInput = allPartSearchField.getText();

        ObservableList<Part> allParts = Inventory.getAllParts();
        ObservableList<Part> matchingParts = FXCollections.observableArrayList();

        // Searches for a matching part by ID and name
        for (Part part: allParts){
            if (String.valueOf(part.getId()).contains(searchInput) || String.valueOf(part.getName()).contains(searchInput)) {
                matchingParts.add(part);
                allPartTbl.setItems(matchingParts);
            }
            // If there is no matching parts
            else if (matchingParts.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING, "No matching part found.");
                alert.showAndWait();
            }
        }
        // Checks if the search input is empty
        if (searchInput.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING," ERROR: Please enter a search input.");
            alert.showAndWait();
        }
    }

    /**
     * When the product search bar is used method
     *
     * Searches the inventory for the matching product
     *
     * RUNTIME ERROR: If the search bar has no input, a window will pop up
     * RUNTIME ERROR: If there is no matching parts, a window will pop up
     *
     * @param event when a user clicks on the "Search" button in the product panel
     */
    @FXML
    void onActionProdSearch(ActionEvent event) {
        String searchInput = allProdSearchField.getText();

        ObservableList<Product> allProducts = Inventory.getAllProducts();
        ObservableList<Product> matchingProducts = FXCollections.observableArrayList();

        for (Product product : allProducts){
            if(String.valueOf(product.getId()).contains(searchInput) || String.valueOf(product.getName()).contains(searchInput)){
                matchingProducts.add(product);
                allProdTbl.setItems(matchingProducts);
            }
            else if (matchingProducts.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "No matching product found.");
                alert.showAndWait();
            }
        }
        // Checks if the search input is empty
        if (searchInput.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING," ERROR: Please enter a search input.");
            alert.showAndWait();
        }
    }

    /**
     * Returns the selected part
     *
     * @return returns the selected part in the parts table
     */
    public static Part getSelectedPart() {
        return selectedPart;
    }

    /**
     * Returns the selected product
     *
     * @return returns the selected product in the product table
     */
    public static Product getSelectedProduct() {
        return selectedProduct;
    }

    /**
     * Initializes the controller and populates the part and product tables
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Populates the parts table with the part items in the inventory
        allPartTbl.setItems(getAllParts());
        allPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartInvLvlCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Populates the product table with the product items in the inventory
        allProdTbl.setItems((Inventory.getAllProducts()));
        allProdIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allProdInvLvlCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allProdNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allProdPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        allPartTbl.refresh();
        allProdTbl.refresh();
    }
}