package Controllers;

import Models.DBConnect;
import Models.Phone;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;

public class PhoneCreatorViewController implements Initializable {

    @FXML private ChoiceBox<String> makeChoiceBox;
    @FXML private ChoiceBox<String> osChoiceBox;
    @FXML private TextField modelTextField;
    @FXML private TextField screenSizeTextField;
    @FXML private TextField memoryTextField;
    @FXML private TextField frontCameraResTextField;
    @FXML private TextField rearCameraResTextField;
    @FXML private TextField priceTextField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            makeChoiceBox.getItems().addAll(DBConnect.getPhoneManufacturers());
            osChoiceBox.getItems().addAll(DBConnect.getOSs());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        makeChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                //this is our custom listener code
                (observable, oldValue, newValue) -> {
                    osChoiceBox.setValue(DBConnect.getOSForManufacturer(newValue));
                }
        );
    }

    @FXML
    public void createPhoneButtonPushed()
    {
        Phone newPhone = new Phone(
                                makeChoiceBox.getValue(),
                                modelTextField.getText(),
                                osChoiceBox.getValue(),
                                Double.parseDouble(screenSizeTextField.getText()),
                                Double.parseDouble(memoryTextField.getText()),
                                Double.parseDouble(frontCameraResTextField.getText()),
                                Double.parseDouble(rearCameraResTextField.getText()));

        System.out.printf("New Phone: %s%n", newPhone);
        try {
            DBConnect.insertPhoneIntoDB(newPhone);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
