package controller;

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

public class ModifyProductController implements Initializable {

    Stage stage;
    Parent scene;

    private static Product selectedProduct;
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();

    //FXML TextFields
    @FXML private TextField partsSearchTxt;
    @FXML private TextField prodIdTxt;
    @FXML private TextField prodInvTxt;
    @FXML private TextField prodMaxTxt;
    @FXML private TextField prodMinTxt;
    @FXML private TextField prodNameTxt;

    //FXML Button
    @FXML private Button addBtn;
    @FXML private Button cancelBtn;
    @FXML private Button removePartBtn;
    @FXML private Button saveBtn;
    @FXML private Button searchBtn;


    //FXML All Parts Table
    @FXML private TableView<Part> allPartsTbl;
    @FXML private TableColumn<Part, Integer> allPartIdCol;
    @FXML private TableColumn<Part, Integer> allPartInvLvlCol;
    @FXML private TableColumn<Part, String> allPartNameCol;
    @FXML private TableColumn<Part, Double> allPartPriceCol;

    //FXML Associated Parts Table
    @FXML private TableView<Part> associatedPartsTbl;
    @FXML private TableColumn<Part, Integer> associatedPartIdCol;
    @FXML private TableColumn<Part, Integer> associatedPartInvLvlCol;
    @FXML private TableColumn<Part, String> associatedPartNameCol;
    @FXML private TableColumn<Part, Double> associatedPartPriceCol;



    @FXML
    void onActionAddPart(ActionEvent event) {


    }

    /**
     *
     * Searches the part inventory for a specific part
     * @param event when a user clicks on the search button
     */
    @FXML
    void onActionPartSearch(ActionEvent event) {
        String searchInput = partsSearchTxt.getText();

        ObservableList<Part> allParts = Inventory.getAllParts();
        ObservableList<Part> matchingParts = FXCollections.observableArrayList();

        for (Part part: allParts){
            if (String.valueOf(part.getId()).contains(searchInput) || String.valueOf(part.getName()).contains(searchInput)){
                matchingParts.add(part);
            }
            allPartsTbl.setItems(matchingParts);
        }
        // If the search input doesn't match anything in the inventory
        if (matchingParts.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING," ERROR: No matching parts found. Try again");
            alert.showAndWait();
        }
    }

    @FXML
    void onActionRemovePart(ActionEvent event) {


    }

    @FXML
    void onActionSave(ActionEvent event) {

    }

    public void onActionDisplayMainMenu(ActionEvent event) throws IOException{
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedProduct = MainFormController.getSelectedProduct();

        allPartsTbl.setItems(allPartsTbl.getItems());
        allPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        allPartInvLvlCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        allPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        associatedPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        associatedPartInvLvlCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        associatedPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        associatedPartPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

    }

}
