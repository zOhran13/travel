package ba.unsa.etf.rpr.controllers;

import javafx.fxml.FXML;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;


public class HomePageController {

public ListView listId;

public Button btnId;

public Label imeId;

public String ime;

    public HomePageController(String  ime) {
        this.ime = ime;
    }

    @FXML
    public void initialize(){
        imeId.setText(ime);
    }


}
