package Controllers;

import Models.DBConnect;
import Models.Phone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

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
    private TableColumn<Phone, Double> memoryColumn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // confgure the table columns
        makeColumn.setCellValueFactory(new PropertyValueFactory<Phone, String>("make"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<Phone, String>("model"));
        osColumn.setCellValueFactory(new PropertyValueFactory<Phone, String>("os"));
        memoryColumn.setCellValueFactory(new PropertyValueFactory<Phone, Double>("memory"));

        try {
            tableView.getItems().addAll(DBConnect.getAllPhones());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void viewSelectedPhone(ActionEvent event) throws IOException {
        Phone phoneSelected = tableView.getSelectionModel().getSelectedItem();

        //check to ensure that a phone was selected before changing scenes
        if (phoneSelected != null)
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Views/PhoneView.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            //access the controller class and load the Phone object
            PhoneViewController controller = loader.getController();
            controller.loadPhone(phoneSelected);

            //get the Stage and set the scene/show
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Phone View");
            stage.setScene(scene);
            stage.show();
        }
    }
}