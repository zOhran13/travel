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

    public Arrangement arrangement = new Arrangement();

    public ArrReservationController(Arrangement arrangement) {
        this.arrangement = arrangement;

    }



    public void reservationArr(ActionEvent actionEvent) {

    }
}
