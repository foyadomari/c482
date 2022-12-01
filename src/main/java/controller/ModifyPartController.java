package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.InHouse;
import model.Outsourced;
import model.Part;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ModifyPartController implements Initializable {

    Stage stage;
    Parent scene;

    //FXML Text Fields
    @FXML private TextField partIdTxt;
    @FXML private TextField partInvTxt;
    @FXML private TextField partMachineIdOrCompanyNameTxt;
    @FXML private TextField partMaxTxt;
    @FXML private TextField partMinTxt;
    @FXML private TextField partNameTxt;
    @FXML private TextField partPriceTxt;

    //FXML Button
    @FXML private Button modPartCancelButton;
    @FXML private Button modPartSaveButton;

    //FXML Radio Button
    @FXML private RadioButton partInHouseRadioBtn;
    @FXML private RadioButton partOutsourceRadioBtn;

    //FXML Label
    @FXML private Label partMachineIdOrCompanyNameLbl;

    private static Part selectedPart;

    @FXML
    void OnActionOutsource(ActionEvent event) {
        partMachineIdOrCompanyNameLbl.setText("Company Name");
    }
    @FXML
    void onActionInHouse(ActionEvent event) {
        partMachineIdOrCompanyNameLbl.setText("Machine ID");
    }
    @FXML
    void onActionSave(ActionEvent event) {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedPart = MainFormController.getSelectedPart();

        partIdTxt.setText(String.valueOf(selectedPart.getId()));
        partInvTxt.setText(String.valueOf(selectedPart.getStock()));
        partMinTxt.setText(String.valueOf(selectedPart.getMin()));
        partMaxTxt.setText(String.valueOf(selectedPart.getMax()));
        partNameTxt.setText(String.valueOf(selectedPart.getName()));
        partPriceTxt.setText(String.valueOf(selectedPart.getPrice()));

        if (selectedPart instanceof InHouse){
            partInHouseRadioBtn.setSelected(true);
            partMachineIdOrCompanyNameLbl.setText("Machine ID");
            partMachineIdOrCompanyNameTxt.setText(String.valueOf(((InHouse) selectedPart).getMachineId()));
        }
        else {
            partOutsourceRadioBtn.setSelected(true);
            partMachineIdOrCompanyNameLbl.setText("Company Name");
            partMachineIdOrCompanyNameTxt.setText(((Outsourced)selectedPart).getCompanyName());
        }
    }
}
