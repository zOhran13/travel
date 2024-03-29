package ba.unsa.etf.rpr.controllers;


import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * This controller handles everything for login window
 */
public class LoginController {
public Button loginBtn;
    public TextField emailFld;
    public PasswordField passwordFld;
    public Button signUpId;
    User u = new User();
    UserManager userManager = new UserManager();

    /**
     * This method shows home page when the user login successful
     * @param event
     */
    public void showHomePage(ActionEvent event){


        try {

            u.setPassword(passwordFld.getText());
            u.setEmail(emailFld.getText());
            userManager.login(u.getEmail(), u.getPassword());
            String ulogovan = (DaoFactory.userDao().getByEmail(u.getEmail()).getName());
            int ulogovanId = DaoFactory.userDao().getByEmail(u.getEmail()).getId();
            //System.out.println(ulogovanId);
            Stage stage = (Stage) loginBtn.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/homePage.fxml"));
            HomePageController cont = new HomePageController(ulogovan,ulogovanId);



            fxmlLoader.setController(cont);
            stage.setTitle("HomePage");
            stage.setScene(new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

        }
        catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();


        }
    }

    /**
     * This method opens new window for registration
     * @param actionEvent
     */

    public void register(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) signUpId.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/registration.fxml"));
            RegistrationController registrationController = new RegistrationController();
            fxmlLoader.setController(registrationController);
            stage.setTitle("Registration");
            stage.setScene(new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

        }
        catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();


        }

    }
}
