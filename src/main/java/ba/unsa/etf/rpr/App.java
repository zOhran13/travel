package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ArrangementException;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws ArrangementException {


        System.out.println("Hello user. Welcome to travel agency. This is a simple app for booking the best travel arrangements.");
        System.out.println("If you don't have a account type 1, if you already have one type 2.");
        Scanner scanner = new Scanner(System.in);
        if(scanner.nextInt() == 2) {
            String email;
            String password;
            System.out.println("Email: ");
            Scanner scanner1 = new Scanner(System.in);
            email = scanner1.next();
            System.out.println("Password: ");
            password = scanner1.next();

            User user = DaoFactory.userDao().getByEmail(email);
            //System.out.println(user);
            while(true) {
                if (user != null && user.getPassword().equals(password)) {
                    System.out.println("Login successful\n");
                    break;
                }
                System.out.println("Username or password is wrong. Please try again.");

                System.out.println("Email: ");
                Scanner scanner2 = new Scanner(System.in);
                email = scanner2.next();
                System.out.println("Password: ");
                password = scanner2.next();
                 user = DaoFactory.userDao().getByEmail(email);

            }
            whatDoYouWant(user.getId());
        }
    }
    private static void whatDoYouWant(int id){
        System.out.println("Choose one: ");
        System.out.println("1: Show me a list of my reservations");
        System.out.println("2. Make me a reservation");
        System.out.println("3. Delete a reservation");
        System.out.println("4. Exit");
        int action;
        Scanner scanner = new Scanner(System.in);
        action = scanner.nextInt();
        switch (action){
            case 1 : listOfReservtionOfaUser(id);
            case 2 :  makeAReservation(id);
            case 3 : deleteReservation(id);
            case 4 : System.exit(0);
        }

    }
    private static void listOfReservtionOfaUser(int id) {

    }
    private static void makeAReservation(int id) {

    }
    private static void deleteReservation(int id) {

    }
}
