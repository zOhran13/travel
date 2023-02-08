package ba.unsa.etf.rpr.controllers;


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
    public void showHomePage(ActionEvent event){


        try {
            System.out.printf("homeuser");
            u.setPassword(passwordFld.getText());
            u.setEmail(emailFld.getText());
           // System.out.println("tralala" +u.getPassword());
            //(new UserManager()).login(u.getEmail(), u.getPassword());
            Stage stage1 = (Stage) loginBtn.getScene().getWindow();
            stage1.close();
            System.out.println(u);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/homePage.fxml"));
            User user = DaoFactory.userDao().getByEmail(u.getEmail());
           //fxmlLoader.setController(new HomePageController(user));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("HomePage");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.initStyle(StageStyle.UTILITY);
            stage.setResizable(false);
            stage.show();

        }
        catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();


        }
    }
}
