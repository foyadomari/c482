package controller;

/**
 * @author Felice Oyadomari III
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
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Controller for the Add Product screen
 */
public class AddProductController implements Initializable {

    Stage stage;
    Parent scene;

    // List of all associated parts
    private ObservableList<Part> associatedPartsList = FXCollections.observableArrayList();

    //FXML Text Fields
    @FXML private TextField partSearchTxt;
    @FXML private TextField prodNameTxt;
    @FXML private TextField prodMinTxt;
    @FXML private TextField prodInvTxt;
    @FXML private TextField prodIdTxt;
    @FXML private TextField prodMaxTxt;
    @FXML private TextField prodPriceTxt;

    //FXML Button
    @FXML private Button addPartBtn;
    @FXML private Button cancelBtn;
    @FXML private Button removePartBtn;
    @FXML private Button saveBtn;
    @FXML private Button partSearchBtn;

    //FXML All Parts Table
    @FXML private TableView<Part> allPartTbl;
    @FXML private TableColumn<Part, Integer> allPartIdCol;
    @FXML private TableColumn<Part, Integer> allPartInvLvlCol;
    @FXML private TableColumn<Part, String> allPartNameCol;
    @FXML private TableColumn<Part, Double> allPartPriceCol;

    //FXML Associated Parts Table
    @FXML private TableView<Part> associatedPartTbl;
    @FXML private TableColumn<Part, Integer> associatedPartIdCol;
    @FXML private TableColumn<Part, Integer> associatedPartInvLvlCol;
    @FXML private TableColumn<Part, String> associatedPartNameCol;
    @FXML private TableColumn<Part, Double> associatedPartPriceCol;

    /**
     * When the "Add" button is clicked method
     *
     * Adds the selected part from the top table to the bottom table (associated parts list)
     *
     * RUNTIME ERROR: If no part is selected, a window pops up
     *
     * @param event user clicks on the "Add" button
    */
    @FXML
    void onActionAdd(ActionEvent event) {
        Part selectedPart = allPartTbl.getSelectionModel().getSelectedItem();

        // Checks to see if a part is selected
        if(selectedPart == null){
            Alert alert = new Alert(Alert.AlertType.WARNING,"ERROR: No part selected was selected.");
            alert.setTitle("Add Part Error");
            alert.showAndWait();
        }
        // Checks to see if the part is already added to the associated parts list
        else if (associatedPartsList.contains(selectedPart)) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "ERROR: This product is already associated with the selected part.");
            alert.setTitle("Product Relation Error");
            alert.showAndWait();
        }
        // No error occurred, adding the selected part to the associated parts list
        else{
            associatedPartsList.add(selectedPart);
            associatedPartTbl.setItems(associatedPartsList);
        }
    }
    /**
     * When the "Cancel" button is clicked method
     *
     * Exits the Add Part Screen and takes you back to the Main Menu
     *
     * @param event when user clicks on the "Cancel" button
     * @throws IOException dismisses any IO exceptions that may occur
     */
    @FXML
    void onActionDisplayMainMenu(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "You will lose your changes, are you sure you want to continue?");
        alert.setTitle("Confirm Cancellation?");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK){
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }
    }
    /**
     * When the "Remove Associated Parts" button is clicked method
     *
     * Removes the selected part from the associated parts list
     *
     * RUNTIME ERROR: When no part is selected, a window pops up
     *
     * @param event when the user clicks on the "Remove Associated Parts" button
     */
    @FXML
    void onActionRemovePart(ActionEvent event) {
        Part selectedPart = associatedPartTbl.getSelectionModel().getSelectedItem();
        // Checks to see if a part is selected
        if (selectedPart == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "ERROR: No part selected.");
            alert.setTitle("Remove Part Error");
            alert.showAndWait();
        }
        // Gets confirmation that the user wants to delete the selected part from the associated part list
        if (associatedPartsList.contains(selectedPart)) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this part?");
            Optional<ButtonType> response = alert.showAndWait();
            if (response.isPresent() && response.get() == ButtonType.OK) {
                associatedPartsList.remove(selectedPart);
                associatedPartTbl.setItems(associatedPartsList);
            }
        }
    }
    /**
     * Creates a new product using the information filled out on the form
     *
     * RUNTIME ERROR: If the max is less than the min number, a pop-up window will appear
     * RUNTIME ERROR: If the inventory level is not between the min and max numbers, a pop-up window will appear
     * RUNTIME ERROR: If the price is a negative number, a pop-up window will appear
     *
     * @param event when a user clicks on the "Save" button
     * @throws IOException dismisses any IO exceptions that may occur
     */
    @FXML
    void onActionSave(ActionEvent event) throws IOException{

        try{
            // Checks to see if the Max number is greater than the Min number
            if (Integer.parseInt(prodMinTxt.getText()) > Integer.parseInt(prodMaxTxt.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR,"ERROR: Max must be greater than Min");
                alert.showAndWait();
            }
            // Checks to see if the Inventory level is between the Min and the Max numbers
            else if ((Integer.parseInt(prodInvTxt.getText()) > (Integer.parseInt(prodMaxTxt.getText())) || (Integer.parseInt(prodInvTxt.getText()) < (Integer.parseInt(prodMinTxt.getText()))))) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "ERROR: Inventory level must be between the Min and Max");
                alert.showAndWait();
            }
            // Checks to see if the price is greater than $0.00
            else if(Double.parseDouble(prodPriceTxt.getText()) < 0.00) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "ERROR: Price must be greater than $0.00");
                alert.showAndWait();
            }
            else {
                // No errors occurred, adding new product to inventory
                int id = Inventory.getUniqueProdId.getAndIncrement();
                String name = prodNameTxt.getText();
                int stock = Integer.parseInt(prodInvTxt.getText());
                int min = Integer.parseInt(prodMinTxt.getText());
                int max = Integer.parseInt(prodMaxTxt.getText());
                double price = Double.parseDouble(prodPriceTxt.getText());

                Product newProd = new Product(id, name, price,stock, min, max);
                Inventory.addProduct(newProd);

                for (Part pn: associatedPartsList){
                    newProd.addAssociatedPart(pn);
                }
                // Navigates back to the Main screen
                stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();
            }
        }
        // Generic error
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.WARNING,"ERROR: Please input valid values for each field");
            alert.showAndWait();
        }
    }

    /**
     * When the search bar is used method
     * Searches the part inventory for a specific part
     *
     * RUNTIME ERROR: If the search input doesn't match anything in the inventory, a window will pop up
     * @param event when a user clicks on the search button
     */
    @FXML
    void onActionSearch(ActionEvent event) {
        String searchInput = partSearchTxt.getText();

        ObservableList<Part> allParts = Inventory.getAllParts();
        ObservableList<Part> matchingParts = FXCollections.observableArrayList();

        for (Part part: allParts){
            if (String.valueOf(part.getId()).contains(searchInput) || String.valueOf(part.getName()).contains(searchInput)){
                matchingParts.add(part);
            }
        allPartTbl.setItems(matchingParts);
        }
        // If the search input doesn't match anything in the inventory
        if (matchingParts.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING," ERROR: No matching parts found. Try again");
            alert.showAndWait();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allPartTbl.setItems(Inventory.getAllParts());
        allPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartInvLvlCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        associatedPartTbl.setItems(associatedPartsList);
        associatedPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        associatedPartInvLvlCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        associatedPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        associatedPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}
