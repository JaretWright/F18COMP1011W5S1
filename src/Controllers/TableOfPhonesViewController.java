package Controllers;

import Models.DBConnect;
import Models.Phone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TableOfPhonesViewController implements Initializable {
    @FXML
    private TableView<Phone> tableView;

    @FXML
    private TableColumn<Phone, String> makeColumn;

    @FXML
    private TableColumn<Phone, String> modelColumn;

    @FXML
    private TableColumn<Phone, String> osColumn;

    @FXML
    private TableColumn<Phone, Double> screenSizeColumn;

    @FXML
    private TableColumn<Phone, Integer> memoryColumn;

    @FXML
    private TableColumn<Phone, Double> priceColumn;

    @FXML
    private TableColumn<Phone, Image> imageColumn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // confgure the table columns
        makeColumn.setCellValueFactory(new PropertyValueFactory<Phone, String>("make"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<Phone, String>("model"));
        osColumn.setCellValueFactory(new PropertyValueFactory<Phone, String>("os"));
        screenSizeColumn.setCellValueFactory(new PropertyValueFactory<Phone, Double>("screenSize"));
        memoryColumn.setCellValueFactory(new PropertyValueFactory<Phone, Integer>("memory"));

//        try {
//            tableView.getItems().addAll(DBConnect.getAllPhones());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @FXML
    public void viewSelectedPhone(ActionEvent event) throws IOException {

    }
}