package controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPartController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cancelBtn;

    @FXML
    private Label partIdLbl;

    @FXML
    private TextField partIdTxt;

    @FXML
    private RadioButton partInHouseRadBtn;

    @FXML
    private Label partInvLbl;

    @FXML
    private TextField partInvTxt;

    @FXML
    private Label partMachineIdOrCompanyNameLbl;

    @FXML
    private TextField partMachineOrCompanyNameTxt;

    @FXML
    private Label partMaxLbl;

    @FXML
    private TextField partMaxTxt;

    @FXML
    private Label partMinLbl;

    @FXML
    private TextField partMinTxt;

    @FXML
    private Label partNameLbl;

    @FXML
    private TextField partNameTxt;

    @FXML
    private RadioButton partOutsourcedRadBtn;

    @FXML
    private Label partPriceLbl;

    @FXML
    private TextField partPriceTxt;

    @FXML
    private Button saveBtn;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
