package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.ReservationManager;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.*;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.domain.RoomType;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ArrangementException;
import ba.unsa.etf.rpr.exceptions.HotelException;
import javafx.util.Pair;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App
{
    public static void main( String[] args ) throws ArrangementException {


        System.out.println("Welcome to travel agency!");


        System.out.println("If you like to log in type 1, if you want to register, type 2: ");
        Scanner scanner = new Scanner(System.in);
        if(scanner.nextInt() == 1) {
            String name;
            String pass;
            System.out.print("Email: ");
            Scanner scanner1 = new Scanner(System.in);
            name = scanner1.next();
            System.out.print("Password: ");
            pass = scanner.next();
            User  user = DaoFactory.userDao().getByEmail(name);
            while(true){


                if (user != null && user.getPassword().equals(pass)){
                    System.out.println("Login successful\n");
                    break;
                }
                System.out.println("Username or password is wrong. Please try again.");
                String name1;
                String pass1;
                System.out.print("Email: ");
                Scanner scanner2 = new Scanner(System.in);
                name = scanner2.next();
                System.out.print("Password: ");

                pass = scanner2.next();
            }
            options(user.getId());
        }

        if(scanner.nextInt() == 2){
            try{
                String name, email, password, cpassword;
                LocalDate DOB;
                System.out.print("Name: ");
                Scanner scanner3 = new Scanner(System.in);
                name = scanner3.next();
                System.out.print("Email: ");
                Scanner scanner4 = new Scanner(System.in);
                email = scanner4.next();
                DOB = addDate();
                System.out.print("Password: ");
                Scanner scanner5 = new Scanner(System.in);
                password = scanner5.next();
                System.out.print("Confirm password: ");
                Scanner scanner6 = new Scanner(System.in);
                cpassword = scanner6.next();
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                user.setPassword(cpassword);
                user.setBirth_date(DOB);

                UserManager.add(user, cpassword);
                options(user.getId());
            }catch (Exception e){
                e.printStackTrace();
            }


        }






    }



    private static void options(int userID) throws ArrangementException {
        System.out.println("How can we help you today ");
        System.out.println("1: Show me a list of my reservations");
        System.out.println("2. Make a reservation");
        System.out.println("3. Cancel a reservation");
        System.out.println("4. Log out");



        Scanner scanner = new Scanner(System.in);
        int action1;
        while(true){
            System.out.print("I want: ");
            action1 = scanner.nextInt();
            if (action1 < 1 || action1 > 4){
                System.out.println("You haven't choose any option, please try again");
            }
            else break;
        }
        int action = action1;



        switch (action){
            case 1 : listOfReservtionOfaUser(userID);
            case 2 :  makeAReservation(userID);
            case 3 : cancelReservation(userID);
            case 4 : System.exit(0);
        }
    }




    private static void listOfReservtionOfaUser(int userID) throws HotelException {
        List<Reservation> listOfReservations = DaoFactory.reservationsDao().reservationsForUser(userID);
        if (listOfReservations.isEmpty()){
            System.out.println("You haven't made any reservations yet!\n");
            options(userID);
            return;
        }
        System.out.println("Your current reservations: ");
        int m = 0;
        for (Reservation x: listOfReservations){
            System.out.println(m + "-" + x.toString());
            m++;
        }
        options(userID);
    }


    private static void makeAReservation(int userID) throws HotelException {

        RoomType room = null;
        LocalDate startDate, endDate;
        int numberOfPeople;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of people staying: ");
        numberOfPeople = scanner.nextInt();
        System.out.println("Start date: ");
        startDate = addStartDate();
        System.out.println("End date: ");
        endDate = addEndDate();
        switch(numberOfPeople) {
            case 1:
                room = RoomType.SINGLE_ROOM;
                break;
            case 2:
                room = RoomType.DOUBLE_ROOM;
                break;
            case 3:
                room = RoomType.TRIPLE_ROOM;
                break;
            case 4:
                room = RoomType.QUADRUPLE_ROOM;
                break;
        }
        User user = DaoFactory.usersDao().getById(userID);



        Reservation reservation = new Reservation(1,startDate,endDate," ",user, new Room(1,5F,2,room));
        ReservationManager reservationManager = new ReservationManager();
        List<Reservation> reservations = new ArrayList<>();
        reservations = DaoFactory.reservationsDao().getAll();
        for(Reservation x : reservations){
            if(x.getStart()== reservation.getStart() && x.getEnd() == reservation.getEnd() && x.getUser()  == reservation.getUser())
                System.out.println("You can't make this reservation");

            else{
                reservationManager.add(reservation);
                System.out.println("Your reservation is successfully added");
            }
        }
        options(user.getId());
    }


    private static void cancelReservation(int userID) throws HotelException {
        List<Reservation> listOfReservations = DaoFactory.reservationsDao().reservationsForUser(userID);
        if (listOfReservations.isEmpty()){
            System.out.println("You haven't made any reservations yet!\n");
            options(userID);
            return;
        }
        System.out.println("Your current reservations: ");
        int c = 0;
        for (Reservation x: listOfReservations){
            System.out.println(c + "-" + x.toString());
            c++;
        }
        System.out.println("Choose the reservation you want to cancel: ");
        Scanner scanner = new Scanner(System.in);
        int numberOfCanceledReservation = scanner.nextInt();
        DaoFactory.reservationsDao().delete(listOfReservations.get(numberOfCanceledReservation).getId());
        options(userID);


    }



}

