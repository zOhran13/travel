package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.domain.Arrangement;
import ba.unsa.etf.rpr.domain.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ArrReservationController {
    public Label nameId;
    public Label priceId;
    public Label desId;
    public Button btnReservation;
    private User user;
    private int logged;


    private String  arrangement;

    public ArrReservationController(String arrangement) {
        this.arrangement = arrangement;


    }
    public ArrReservationController(int logged){
        this.logged = logged;
    }

    public void initialize() {
        String [] des = arrangement.split("About");

        String [] arrangementArray = arrangement.split(" ");

        nameId.setText(arrangementArray[1]);
        priceId.setText(arrangementArray[3]);
        desId.setText(des[1]);

    }

    public void reservationArr(ActionEvent actionEvent) {



    }

}