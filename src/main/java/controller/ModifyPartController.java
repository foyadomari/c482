package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifyPartController implements Initializable {

    Stage stage;
    Parent scene;

    @FXML private Button modPartCancelButton;
    @FXML private Button modPartSaveButton;
    @FXML private Label partIdLbl;
    @FXML private TextField partIdTxt;
    @FXML private RadioButton partInHouseRadioBtn;
    @FXML private Label partInvLbl;
    @FXML private TextField partInvTxt;
    @FXML private Label partMachineIdOrCompanyNameLbl;
    @FXML private TextField partMachineIdOrCompanyNameTxt;
    @FXML private Label partMaxLbl;
    @FXML private TextField partMaxTxt;
    @FXML private Label partMinLbl;
    @FXML private TextField partMinTxt;
    @FXML private Label partNameLbl;
    @FXML private TextField partNameTxt;
    @FXML private RadioButton partOutsourceRadioBtn;
    @FXML private Label partPriceLbl;
    @FXML private TextField partPriceTxt;

    @FXML
    void OnActionOutsource(ActionEvent event) {

    }

    @FXML
    void onActionCancel(ActionEvent event) {

    }

    @FXML
    void onActionInHouse(ActionEvent event) {

    }

    @FXML
    void onActionSave(ActionEvent event) {

    }

    @FXML
    void onActionDisplayMainMenu(ActionEvent event) throws IOException {

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainForm.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
