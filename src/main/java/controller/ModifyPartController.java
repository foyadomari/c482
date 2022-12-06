package controller;
/**
 * Modify Part Controller
 * @author Felice Oyadomari III
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.InHouse;
import model.Inventory;
import model.Outsourced;
import model.Part;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Controller for the Modify Part screen
 */
public class ModifyPartController implements Initializable {

    Stage stage;
    Parent scene;

    //FXML Text Fields
    @FXML
    private TextField partIdTxt;
    @FXML
    private TextField partInvTxt;
    @FXML
    private TextField partMachineIdOrCompanyNameTxt;
    @FXML
    private TextField partMaxTxt;
    @FXML
    private TextField partMinTxt;
    @FXML
    private TextField partNameTxt;
    @FXML
    private TextField partPriceTxt;

    //FXML Button
    @FXML
    private Button modPartCancelButton;
    @FXML
    private Button modPartSaveButton;

    //FXML Radio Button
    @FXML
    private RadioButton partInHouseRadBtn;
    @FXML
    private RadioButton partOutsourceRadBtn;

    //FXML Label
    @FXML
    private Label partMachineIdOrCompanyNameLbl;

    private static Part selectedPart;

    /**
     * When the "Outsource" radio button is selected method
     *
     * Changes the dynamic label to "Company Name"
     *
     * @param event when a user selects the "Outsourced" radio button
     */
    @FXML
    void OnActionOutsource(ActionEvent event) {

        partMachineIdOrCompanyNameLbl.setText("Company Name");
    }

    /**
     * When the "In-House" radio button is selected method
     *
     * Changes the dynamic label to "Machine ID"
     *
     * @param event when a user selects the "In-House" radio button
     */
    @FXML
    void onActionInHouse(ActionEvent event) {

        partMachineIdOrCompanyNameLbl.setText("Machine ID");
    }

    /**
     * When the "Save" button is clicked method
     *
     * Modifies the selected part with the information filled out on the form
     *
     * @param event when the user clicks on the "Save" button
     * @throws IOException dismisses any IO exceptions that may occur
     */
    @FXML
    void onActionSave(ActionEvent event) throws IOException {
        int machineId;
        String companyName;

        try {
            // Checks to see if the Max number is greater than the Min number
            if (Integer.parseInt(partMinTxt.getText()) > Integer.parseInt(partMaxTxt.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "ERROR: Max must be greater than Min");
                alert.showAndWait();
            }
            // Checks to see if the Inventory level is between the Min and the Max numbers
            else if ((Integer.parseInt(partInvTxt.getText()) > (Integer.parseInt(partMaxTxt.getText())) || (Integer.parseInt(partInvTxt.getText()) < (Integer.parseInt(partMinTxt.getText()))))) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "ERROR: Inventory level must be between the Min and Max");
                alert.showAndWait();
            }
            // Checks to see if the price is greater than $0.00
            else if (Double.parseDouble(partPriceTxt.getText()) < 0.00) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "ERROR: Price must be greater than $0.00");
                alert.showAndWait();
            } else {
                // No errors occurred, adding the new part to the inventory
                int id = Integer.parseInt(partIdTxt.getText());
                String name = partNameTxt.getText();
                double price = Double.parseDouble(partPriceTxt.getText());
                int stock = Integer.parseInt(partInvTxt.getText());
                int min = Integer.parseInt(partMinTxt.getText());
                int max = Integer.parseInt(partMaxTxt.getText());
                // Checks to see which radio button is selected and adds the new part accordingly
                if (partInHouseRadBtn.isSelected()) {
                    machineId = Integer.parseInt(partMachineIdOrCompanyNameTxt.getText());
                    InHouse updatedPart = new InHouse(id, name, price, stock, min, max, machineId);
                    Inventory.deletePart(selectedPart);
                    Inventory.addPart(updatedPart);
                }
                else {
                    companyName = partMachineIdOrCompanyNameTxt.getText();
                    Outsourced updatedPart = new Outsourced(id, name, price, stock, min, max, companyName);
                    Inventory.deletePart(selectedPart);
                    Inventory.addPart(updatedPart);
                }
                // Navigates back to the Main screen
                stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "ERROR: Please input valid values for each field");
            alert.showAndWait();
        }
    }

    /**
     * The "Cancel" button is clicked method
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

        if (result.isPresent() && result.get() == ButtonType.OK) {
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }
    }

    /**
     * Initializes the controller and populates the top table with the parts from the inventory
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedPart = MainFormController.getSelectedPart();

        partIdTxt.setText(String.valueOf(selectedPart.getId()));
        partInvTxt.setText(String.valueOf(selectedPart.getStock()));
        partMinTxt.setText(String.valueOf(selectedPart.getMin()));
        partMaxTxt.setText(String.valueOf(selectedPart.getMax()));
        partNameTxt.setText(String.valueOf(selectedPart.getName()));
        partPriceTxt.setText(String.valueOf(selectedPart.getPrice()));

        if (selectedPart instanceof InHouse) {
            partInHouseRadBtn.setSelected(true);
            partMachineIdOrCompanyNameLbl.setText("Machine ID");
            partMachineIdOrCompanyNameTxt.setText(String.valueOf(((InHouse) selectedPart).getMachineId()));
        }
        else {
            partOutsourceRadBtn.setSelected(true);
            partMachineIdOrCompanyNameLbl.setText("Company Name");
            partMachineIdOrCompanyNameTxt.setText(((Outsourced) selectedPart).getCompanyName());
        }
    }
}

