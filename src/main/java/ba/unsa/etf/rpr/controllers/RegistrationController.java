package ba.unsa.etf.rpr.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class RegistrationController {
    public Label nameId;
    public Label surnameId;
    public Label addressId;
    public Label phoneId;
    public Label mailId;
    public Button btnCancelId;
    public Button btnOkId;

    public void backToLogin(ActionEvent actionEvent) {
        try{
            Stage stage = (Stage) btnCancelId.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
            fxmlLoader.setController(new LoginController());
            Parent root = fxmlLoader.load();
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void registrationForUser(ActionEvent actionEvent) {
    }
}
