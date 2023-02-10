package ba.unsa.etf.rpr.controllers;


import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class LoginController {
public Button loginBtn;
    public TextField emailFld;
    public PasswordField passwordFld;
    User u = new User();
    UserManager userManager = new UserManager();
    public void showHomePage(ActionEvent event){


        try {

            u.setPassword(passwordFld.getText());
            u.setEmail(emailFld.getText());
            userManager.login(u.getEmail(), u.getPassword());
            String ulogovan = (DaoFactory.userDao().getByEmail(u.getEmail()).getName());
            int ulogovanId = DaoFactory.userDao().getByEmail(u.getEmail()).getId();
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/homePage.fxml"));
            HomePageController cont = new HomePageController(ulogovan,ulogovanId);
           // HomePageController cont2 = new HomePageController(ulogovanId);


            fxmlLoader.setController(cont);
            //fxmlLoader.setController(cont2);
            stage.setTitle("HomePage");
            stage.setScene(new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));

            stage.show();

        }
        catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();


        }
    }
}
