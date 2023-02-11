package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ArrangementException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class ProfileController {


    public ListView listReservationId;
    public Label nameId;
    public Button btnBackId;

    public String name;

    public int id;

    public Label surnameId;

    public Label phoneId;



    public ProfileController(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void initialize() throws ArrangementException {
        nameId.setText(name);
        String userSurname = DaoFactory.userDao().getById(id).getSurname();
        surnameId.setText(userSurname);
        String userNumber = DaoFactory.userDao().getById(id).getPhoneNumber();
        phoneId.setText(userNumber);
    }


    public void backHome(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) btnBackId.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/homePage.fxml"));
        HomePageController cont = new HomePageController(name,id);

        fxmlLoader.setController(cont);
        stage.setTitle("HomePage");
        stage.setScene(new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));

        stage.show();

    }

    public void removeReservation(ActionEvent actionEvent) {
    }
}
