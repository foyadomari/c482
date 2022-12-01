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
import model.Inventory;
import model.Part;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class AddProductController implements Initializable {

    Stage stage;
    Parent scene;

    private ObservableList<Part> associatedPartsList = FXCollections.observableArrayList();

    //FXML Text Fields
    @FXML private TextField partSearchTxt;
    @FXML private TextField prodNameTxt;
    @FXML private TextField prodMinTxt;
    @FXML private TextField prodInvTxt;
    @FXML private TextField prodIdTxt;
    @FXML private TextField prodMaxTxt;

    //FXML Button
    @FXML private Button addPartBtn;
    @FXML private Button cancelBtn;
    @FXML private Button removePartBtn;
    @FXML private Button saveBtn;

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
     * Adds the selected part from the top table to the associated parts list
     *
     * RUNTIME ERROR: If no part is selected, a window pops up
     *
     * @param event user clicks on the "Add" button
    */
    @FXML
    void onActionAdd(ActionEvent event) {
    Part selectedPart = allPartTbl.getSelectionModel().getSelectedItem();

    if(selectedPart == null){
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"No part selected to add!\nTry again");
        alert.setTitle("Add Part Error");
        alert.setHeaderText("ERROR:");
        alert.showAndWait();
    }
    else if (associatedPartsList.contains(selectedPart)) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "This product is already associated with the selected part.\nTry again");
        alert.setTitle("Product Relation Error");
        alert.setHeaderText("ERROR:");
        alert.showAndWait();
    }
    else{
        associatedPartsList.add(selectedPart);
        associatedPartTbl.setItems(associatedPartsList);
    }

    }

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
     * Removes the selected part from the associated parts list
     *
     * RUNTIME ERROR: When no part is selected, a window pops up
     *
     * @param event when the user clicks on the "Remove Associated Parts" button
     */
    @FXML
    void onActionRemovePart(ActionEvent event) {
        Part selectedPart = associatedPartTbl.getSelectionModel().getSelectedItem();

        if (selectedPart == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "No part selected!\nTry again");
            alert.setTitle("Remove Part Error");
            alert.setHeaderText("ERROR:");
            alert.showAndWait();
        }
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
     * @param event when a user clicks on the "Save" button
     */
    @FXML
    void onActionSave(ActionEvent event) {

        int id = Inventory.getUniqueProdId.incrementAndGet();
        String name = prodNameTxt.getText();
        int stock = Integer.parseInt(prodInvTxt.getText());
        int min = Integer.parseInt(prodMinTxt.getText());
        int max = Integer.parseInt(prodMaxTxt.getText());

    }

    @FXML
    void onActionSearch(ActionEvent event) {

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
