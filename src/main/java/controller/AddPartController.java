package controller;

/**
 * @author Felice Oyadomari III
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.InHouse;
import model.Inventory;
import model.Outsourced;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Controller for the Add Part screen and
 */
public class AddPartController implements Initializable {

    Stage stage;
    Parent scene;

    //FXML Text Fields
    @FXML private TextField partIdTxt;
    @FXML private TextField partInvTxt;
    @FXML private TextField partMachineOrCompanyNameTxt;
    @FXML private TextField partMaxTxt;
    @FXML private TextField partMinTxt;
    @FXML private TextField partNameTxt;
    @FXML private TextField partPriceTxt;

    //FXML Button
    @FXML private Button cancelBtn;
    @FXML private Button saveBtn;

    //FXML Radio Button
    @FXML private RadioButton partInHouseRadBtn;
    @FXML private RadioButton partOutsourcedRadBtn;

    // FXML Toggle Group
    @FXML private ToggleGroup addPartTogGrp;

    //FXML Label
    @FXML private Label partIdLbl;
    @FXML private Label partInvLbl;
    @FXML private Label partMachineIdOrCompanyNameLbl;
    @FXML private Label partMaxLbl;
    @FXML private Label partMinLbl;
    @FXML private Label partNameLbl;
    @FXML private Label partPriceLbl;

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
     * 
     * @param event
     */
    @FXML
    void onActionInHouse(ActionEvent event) {
        partMachineIdOrCompanyNameLbl.setText("Machine ID");
    }
    @FXML
    void onActionOutsourced(ActionEvent event) {
        partMachineIdOrCompanyNameLbl.setText("Company Name");
    }

    /**
     * When the "Save" button is clicked method
     *
     * Creates a new part with the information filled out on the form and adds it to the inventory
     *
     * RUNTIME ERROR: If the max is less than the min number, a pop-up window will appear
     * RUNTIME ERROR: If the inventory level is not between the min and max numbers, a pop-up window will appear
     * RUNTIME ERROR: If the price is a negative number, a pop-up window will appear
     *
     * @param event when user clicks on the "Save" button
     * @throws IOException dismisses any IO exception that may occur
     */
    @FXML
    void onActionSave(ActionEvent event) throws IOException {
        int machineId;
        String companyName;
        try {

            // Checks to see if the Max number is greater than the Min number
            if (Integer.parseInt(partMinTxt.getText()) > Integer.parseInt(partMaxTxt.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR,"ERROR: Max must be greater than Min");
                alert.showAndWait();
            }
            // Checks to see if the Inventory level is between the Min and the Max numbers
            else if ((Integer.parseInt(partInvTxt.getText()) > (Integer.parseInt(partMaxTxt.getText())) || (Integer.parseInt(partInvTxt.getText()) < (Integer.parseInt(partMinTxt.getText()))))) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "ERROR: Inventory level must be between the Min and Max");
                alert.showAndWait();
            }
            // Checks to see if the price is greater than $0.00
            else if(Double.parseDouble(partPriceTxt.getText()) < 0.00){
                Alert alert = new Alert(Alert.AlertType.WARNING,"ERROR: Price must be greater than $0.00");
                alert.showAndWait();
            }
            else {
                // No errors occurred, adding the new part to the inventory
                int id = Inventory.getUniquePartId.getAndIncrement();
                String name = partNameTxt.getText();
                double price = Double.parseDouble(partPriceTxt.getText());
                int stock = Integer.parseInt(partInvTxt.getText());
                int min = Integer.parseInt(partMinTxt.getText());
                int max = Integer.parseInt(partMaxTxt.getText());
                // Checks to see which radio button is selected and adds the new part accordingly
                if (partInHouseRadBtn.isSelected()) {
                    machineId = Integer.parseInt(partMachineOrCompanyNameTxt.getText());
                    Inventory.addPart(new InHouse(id, name, price, stock, min, max, machineId));
                }
                else {
                    companyName = partMachineOrCompanyNameTxt.getText();
                    Inventory.addPart(new Outsourced(id, name, price, stock, min, max, companyName));
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
     * Method to select the In-House radio button by default
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        partInHouseRadBtn.setSelected(true);

    }
}
