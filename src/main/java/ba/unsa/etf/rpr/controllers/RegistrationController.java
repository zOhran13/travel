package ba.unsa.etf.rpr.controllers;


import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * This controller handles everything for users registration page
 */
public class RegistrationController {
    
    public Button btnCancelId;

    public Button btnOkId;
    public TextField nameId;
    public TextField surnameId;
    public TextField phoneId;
    public TextField emailId;
    public TextField addressId;

    public PasswordField passwordId;

    /**
     * This method returns user from registration page to log in
     * @param actionEvent
     */
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
        try {
            User u = new User();
            u.setName(nameId.getText());
            u.setSurname(surnameId.getText());
            u.setAddress(addressId.getText());
            u.setPhoneNumber(phoneId.getText());
            u.setPassword(passwordId.getText());
            u.setEmail(emailId.getText());
            UserManager.register(u);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registration");
            alert.setHeaderText("Results:");
            alert.setContentText("Thank you for registration! Please sign in.");
            alert.showAndWait();

            Stage stage = (Stage) btnOkId.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
            fxmlLoader.setController(new LoginController());
            Parent root = fxmlLoader.load();
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


}
