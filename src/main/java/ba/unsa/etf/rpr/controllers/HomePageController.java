package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Arrangement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.List;


public class HomePageController {



public Button btnId;

public Label imeId;

public String ime;
    public ListView listaId;
    public Button btnChooseId;

    public HomePageController(String  ime) {
        this.ime = ime;
    }


    public void initialize(){
        imeId.setText(ime);


        ObservableList items = FXCollections.observableArrayList();

        try{
            List<Arrangement> arrangementsList = DaoFactory.arrangementDao().getAll();
            if(!arrangementsList.isEmpty()){
                for(int i = 0; i < arrangementsList.size(); i++){
                    items.add("Where: "+ arrangementsList.get(i).getArragement()+ " "+"Price: " + arrangementsList.get(i).getPrice() + "$ "+"About: " + arrangementsList.get(i).getDescription());

                }
                //System.out.println(items);


                listaId.setItems(items);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void chooseArr(ActionEvent actionEvent) {
    }
}
