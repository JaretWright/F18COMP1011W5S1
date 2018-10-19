package Controllers;

import java.io.IOException;

import Models.Phone;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneChanger {
    /**
     * This method will accept the title of the new scene, the .fxml file name for
     * the view and the ActionEvent that triggered the change
     */
    public static void changeScenes(ActionEvent event, String viewName, String title) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new Object(){}.getClass().getResource(viewName));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);

        //get the stage from the event that was passed in
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method allows the user to change scenes and pass a Phone object
     * into the new scene
     */
    public static void changeScenes(ActionEvent event, String viewName, String title,
                                    Phone phone) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new Object(){}.getClass().getResource(viewName));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        //access the controller class and load the Phone object
        PhoneLoaderInterface controller = loader.getController();
        controller.loadPhone(phone);

        //get the Stage and set the scene/show
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Phone View");
        stage.setScene(scene);
        stage.show();
    }
}


