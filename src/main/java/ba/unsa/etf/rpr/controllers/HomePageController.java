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

/**
 * This controller handles everything for home page window
 */
public class HomePageController {



    public Button btnId;

    public Label imeId;

    public String ime;
    public ListView listaId;
    public Button btnChooseId;

    public int id;

    public HomePageController(String  ime, int id) {

        this.ime = ime;
        this.id = id;

    }
    /**
     * Initialize method happens as soon as window is opened and this one set all arrangement on list.
     */
    public void initialize(){
        imeId.setText(ime);
        //System.out.println(id);


        ObservableList items = FXCollections.observableArrayList();


        try{
            List<Arrangement> arrangementsList = DaoFactory.arrangementDao().getAll();
            if(!arrangementsList.isEmpty()){
                for(int i = 0; i < arrangementsList.size(); i++){

                    items.add("Where: "+ arrangementsList.get(i).getArragement()+ " "+"Price: " + arrangementsList.get(i).getPrice() + "$ "+"About: " + arrangementsList.get(i).getDescription());


                }
                listaId.setItems(items);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     *
     * @param actionEvent
     * @throws IOException
     * This method close this window and opens profile window for user
     */
    public void goToProfile(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) btnId.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/profile.fxml"));
        ProfileController cont = new ProfileController(ime,id);
        fxmlLoader.setController(cont);
        stage.setTitle("Profile");
        stage.setScene(new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();

    }

    /**
     *
     * @param actionEvent
     * @throws IOException
     * Method opens new window and shows information for arrangement which is chosen
     */

    public void chooseArr(ActionEvent actionEvent) throws IOException {
        int selectedIdx = listaId.getSelectionModel().getSelectedIndex();
        if (selectedIdx != -1) {
            Object selectedItem = listaId.getSelectionModel().getSelectedItem();

            int newSelectedIdx =
                    (selectedIdx == listaId.getItems().size() - 1)
                            ? selectedIdx - 1
                            : selectedIdx;

            listaId.refresh();
            listaId.getSelectionModel().select(newSelectedIdx);
            Stage stage = (Stage) btnChooseId.getScene().getWindow();
            stage.close();
           // Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/arrReservation.fxml"));


            ArrReservationController arrReservationController = new ArrReservationController(selectedItem.toString(),ime,id);

            fxmlLoader.setController(arrReservationController);

            stage.setTitle("Reservation");
            stage.setScene(new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();
            System.out.println(id);

        }
    }
}