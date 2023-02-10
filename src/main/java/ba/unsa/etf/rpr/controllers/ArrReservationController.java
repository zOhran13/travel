package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import ba.unsa.etf.rpr.domain.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class ArrReservationController {
    public Label nameId;
    public Label priceId;
    public Label desId;

    public Button btnReservation;

    private User user;
    private int logged;

    private Button btnCancelId;
 private String nameOfUser;

 private int id;



    private String  arrangement;

    public ArrReservationController(String arrangement,String nameOfUser,int id) {
        this.arrangement = arrangement;
        this.nameOfUser = nameOfUser;
        this.id = id;

    }

//    public ArrReservationController(int logged, String nameOfUser){
//
//        this.logged = logged;
//        this.nameOfUser = nameOfUser;
//    }

    public void initialize() {
        String [] des = arrangement.split("About");

        String [] arrangementArray = arrangement.split(" ");

        nameId.setText(arrangementArray[1]);
        priceId.setText(arrangementArray[3]);
        desId.setText(des[1]);
        //System.out.println(logged);

    }
    public void backToHomePage(ActionEvent actionEvent){
        try {

            //String ulogovan = (DaoFactory.userDao().getByEmail(u.getEmail()).getName());
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/homePage.fxml"));
            HomePageController cont = new HomePageController(nameOfUser,id);

            fxmlLoader.setController(cont);

            stage.setTitle("HomePage");
            stage.setScene(new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));

            stage.show();

        }
        catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();


        }

    }

    public void reservationArr(ActionEvent actionEvent) {



    }

}