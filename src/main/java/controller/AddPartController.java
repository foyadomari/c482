package controller;

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

    //FXML Label
    @FXML private Label partIdLbl;
    @FXML private Label partInvLbl;
    @FXML private Label partMachineIdOrCompanyNameLbl;
    @FXML private Label partMaxLbl;
    @FXML private Label partMinLbl;
    @FXML private Label partNameLbl;
    @FXML private Label partPriceLbl;

    @FXML
    void onActionDisplayMainMenu(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "You will lose your changes, are you sure you want to continue?");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK){
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }
    }
    @FXML
    void onActionInHouse(ActionEvent event) {
        partMachineIdOrCompanyNameLbl.setText("Machine ID");
    }
    @FXML
    void onActionOutsourced(ActionEvent event) {
        partMachineIdOrCompanyNameLbl.setText("Company Name");
    }
    @FXML
    void onActionSave(ActionEvent event) throws IOException {

        int id = Integer.parseInt(partIdTxt.getText());
        String name = partNameTxt.getText();
        double price = Double.parseDouble(partPriceTxt.getText());
        int stock = Integer.parseInt(partInvTxt.getText());
        int min = Integer.parseInt(partMinTxt.getText());
        int max = Integer.parseInt(partMaxTxt.getText());

        if (min > max){

        }

        int machineId;
        String companyName;

        if (partInHouseRadBtn.isSelected()) {
            machineId = Integer.parseInt(partMachineOrCompanyNameTxt.getText());
            Inventory.addPart(new InHouse(id, name, price, stock, min, max, machineId));
        }
        else {
            companyName = partMachineOrCompanyNameTxt.getText();
            Inventory.addPart(new Outsourced(id, name, price, stock, min, max, companyName));
        }

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
