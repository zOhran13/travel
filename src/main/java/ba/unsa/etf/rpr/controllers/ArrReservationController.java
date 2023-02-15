package ba.unsa.etf.rpr.controllers;


import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.ReservationDao;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.exceptions.ArrangementException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import ba.unsa.etf.rpr.domain.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * This controller handles everything for home reservation window
 */
public class ArrReservationController {
    public Label nameId;
    public Label priceId;
    public Label desId;

    public Button btnReservation;

    private User user;

    private int logged;
    public int price;

    public Button btnCancelId;
 private String nameOfUser;

 private int id;



    private String  arrangement;

    /**
     * This is constructor
     * @param arrangement
     * @param nameOfUser
     * @param id
     */

    public ArrReservationController(String arrangement,String nameOfUser,int id) {
        this.arrangement = arrangement;
        this.nameOfUser = nameOfUser;
        this.id = id;

    }

    /**
     * Initialize method happens as soon as window is opened.
     */


    public void initialize() {
        String [] des = arrangement.split("About:");
        String [] arrangementArray = arrangement.split(" ");

        nameId.setText(arrangementArray[1]);
        priceId.setText(arrangementArray[3]);
        desId.setText(des[1]);
        desId.setWrapText(true);
        //System.out.println(id);

    }

    /**
     * This method returns user from reservation window to home page.
     * @param actionEvent
     */

    public void backToHomePage(ActionEvent actionEvent){
        try {
            Stage stage = (Stage) btnCancelId.getScene().getWindow();
            stage.close();
            //String ulogovan = (DaoFactory.userDao().getByEmail(u.getEmail()).getName());
            //Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/homePage.fxml"));
            HomePageController cont = new HomePageController(nameOfUser,id);

            fxmlLoader.setController(cont);

            stage.setTitle("HomePage");
            stage.setScene(new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

           // System.out.println(newArray[0]);

        }
        catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();


        }

    }

    /**
     * This method makes reservation for arrangement which is on window
     * @param actionEvent
     * @throws ArrangementException
     */
    public void reservationArr(ActionEvent actionEvent) throws ArrangementException {
        User user = DaoFactory.userDao().getById(id);
        String [] arrangementArray = arrangement.split(" ");
        String [] newArray =  arrangementArray[3].split("[$]");
        price = Integer.parseInt(newArray[0]);
        try {
            java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
            Reservation reservation = new Reservation();
            reservation.setId(1);
            reservation.setPayment(price);
            reservation.setDate(date);
            reservation.setUser(user);
            DaoFactory.reservationDao().add(reservation);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Reservation");
            alert.setHeaderText("Results:");
            alert.setContentText("Thank you for reservation! See you soon!");

            alert.showAndWait();



        }catch (ArrangementException  e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }



    }

}