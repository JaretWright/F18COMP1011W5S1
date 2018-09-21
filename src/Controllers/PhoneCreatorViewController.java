package Controllers;

import Models.DBConnect;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class PhoneCreatorViewController implements Initializable {

    @FXML private ChoiceBox<String> makeChoiceBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            makeChoiceBox.getItems().addAll(DBConnect.getPhoneManufacturers());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
