package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Arrangement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;


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


    public void chooseArr(ActionEvent actionEvent) throws IOException {
        int selectedIdx = listaId.getSelectionModel().getSelectedIndex();
        if (selectedIdx != -1) {
            Object selectedItem = listaId.getSelectionModel().getSelectedItem();

            int newSelectedIdx =
                    (selectedIdx == listaId.getItems().size() - 1)
                            ? selectedIdx - 1
                            : selectedIdx;

            Arrangement arrangement = (Arrangement) listaId.getSelectionModel().getSelectedItem();

//
//            try {
//                //DaoFactory.arrangementDao().reservationsForUser(user.getId()).remove(itemToRemove);
//                String [] index = itemToRemove.toString().split(" ");
//                int indexToDelete = Integer.parseInt(index[2]);
//                DaoFactory.reservationsDao().delete(indexToDelete);
//                System.out.println(itemToRemove);
//
//
//            } catch (HotelException e) {
//                throw new RuntimeException(e);
//            }
            listaId.refresh();
            listaId.getSelectionModel().select(newSelectedIdx);

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/arrReservation.fxml"));
           ArrReservationController arrReservationController = new ArrReservationController(arrangement);

            fxmlLoader.setController(arrReservationController);

            stage.setTitle("Reservation");
            stage.setScene(new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));

            stage.show();

        }
    }
}
