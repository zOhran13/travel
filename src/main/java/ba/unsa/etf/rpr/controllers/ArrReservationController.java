package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.domain.Arrangement;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ArrReservationController {
    public Label nameId;
    public Label priceId;
    public Label desId;
    public Button btnReservation;

    public String  arrangement;

    public ArrReservationController(String arrangement) {
        this.arrangement = arrangement;

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