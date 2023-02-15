package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.exceptions.ArrangementException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
 * This controller handles everything for users profile page
 */
public class ProfileController {


    public ListView listReservationId;
    public Label nameId;
    public Button btnBackId;

    public Button btnRemoveId;

    public String name;

    public int id;

    public Label phoneId;



    public ProfileController(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Initialize method happens as soon as window is opened and this one set all information about user on the window and list of users reservations.
     * @throws ArrangementException
     */
    public void initialize() throws ArrangementException {
        String userSurname = DaoFactory.userDao().getById(id).getSurname();
        nameId.setText(name+" "+userSurname);
       // String userSurname = DaoFactory.userDao().getById(id).getSurname();
        //surnameId.setText(userSurname);
        String userNumber = DaoFactory.userDao().getById(id).getPhoneNumber();
        phoneId.setText(userNumber);
        //System.out.println(userNumber);

        ObservableList items = FXCollections.observableArrayList();


        try{
            List<Reservation> reservationsList = DaoFactory.reservationDao().reservationsForUser(id);
            if(!reservationsList.isEmpty()){
                for(int i = 0; i < reservationsList.size(); i++){

                    items.add(reservationsList.get(i).getId()+" Price: "+ reservationsList.get(i).getPayment()+ "Date: "+reservationsList.get(i).getDate());
                }
                listReservationId.setItems(items);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    /**
     * This method sets home page window from users profile page
     * @param actionEvent
     * @throws IOException
     */
    public void backHome(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) btnBackId.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/homePage.fxml"));
        HomePageController cont = new HomePageController(name,id);

        fxmlLoader.setController(cont);
        stage.setTitle("HomePage");
        stage.setScene(new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();

    }

    /**
     * When the user selects some reservation and click cancel button this method remove reservation from list and database
     * @param actionEvent
     */
    public void removeReservation(ActionEvent actionEvent) {

        int selectedIdx = listReservationId.getSelectionModel().getSelectedIndex();
        if (selectedIdx != -1) {
            Object itemToRemove = listReservationId.getSelectionModel().getSelectedItem();

            int newSelectedIdx =
                    (selectedIdx == listReservationId.getItems().size() - 1)
                            ? selectedIdx - 1
                            : selectedIdx;

            listReservationId.getItems().remove(selectedIdx);

            try {
                DaoFactory.reservationDao().reservationsForUser(id).remove(itemToRemove);
                String [] index = itemToRemove.toString().split(" ");
                int indexToDelete = Integer.parseInt(index[0]);
                DaoFactory.reservationDao().delete(indexToDelete);
                System.out.println(itemToRemove);


            } catch (ArrangementException e) {
                throw new RuntimeException(e);
            }
            listReservationId.refresh();
            listReservationId.getSelectionModel().select(newSelectedIdx);
        }


    }
}
