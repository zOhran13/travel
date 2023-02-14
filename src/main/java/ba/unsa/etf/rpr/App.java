package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Arrangement;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ArrangementException;

import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws ArrangementException {


        System.out.println("Hello user. Welcome to travel agency. This is a simple app for booking the best travel arrangements.");
        System.out.println("If you don't have a account type 1, if you already have one type 2.");

        Scanner scanner = new Scanner(System.in);
        if (scanner.nextInt() == 2) {
            String email;
            String password;
            System.out.println("Email: ");
            Scanner scanner1 = new Scanner(System.in);
            email = scanner1.next();
            System.out.println("Password: ");
            password = scanner1.next();

            User user = DaoFactory.userDao().getByEmail(email);
            //System.out.println(user);
            while (true) {
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
      else  if (scanner.nextInt() == 1) {
            try {
                String name;
                String surname;
                String address;
                String phone;
                String password;
                String email;
                System.out.println("Name: ");
                Scanner nameSc = new Scanner(System.in);
                name = nameSc.next();
                System.out.println("Surname: ");
                Scanner surnameSc = new Scanner(System.in);
                surname = surnameSc.next();
                System.out.println("Address: ");
                Scanner addressSc = new Scanner(System.in);
                address = addressSc.next();
                System.out.println("Phone: ");
                Scanner phoneSc = new Scanner(System.in);
                phone = phoneSc.next();
                System.out.println("Email: ");
                Scanner emailSc = new Scanner(System.in);
                email = emailSc.next();
                System.out.println("Password: ");
                Scanner passwordSc = new Scanner(System.in);
                password = passwordSc.next();
                User user = new User();
                user.setName(name);
                user.setPhoneNumber(phone);
                user.setSurname(surname);
                user.setEmail(email);
                user.setAddress(address);
                user.setPassword(password);
                UserManager.register(user);
                whatDoYouWant(user.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
    }

    private static void whatDoYouWant(int id) throws ArrangementException {
        System.out.println("Choose one: ");
        System.out.println("1: Show me a list of my reservations");
        System.out.println("2. Make me a reservation");
        System.out.println("3. Delete a reservation");
        System.out.println("4. Exit");
        int action;
        Scanner scanner = new Scanner(System.in);
        action = scanner.nextInt();
        switch (action){
            case 1 : listOfReservationOfaUser(id);
            case 2 :  makeAReservation(id);
            case 3 : deleteReservation(id);
            case 4 : System.exit(0);
        }

    }
    private static void listOfReservationOfaUser(int id) throws ArrangementException {
        List<Reservation> listOfReservations = DaoFactory.reservationDao().reservationsForUser(id);
        System.out.println("You have "+listOfReservations.size()+" reservations.");
        if (listOfReservations.isEmpty()){
            System.out.println("You haven't made any reservations yet!\n");
            whatDoYouWant(id);
            return;
        }
        for(int i = 0; i<listOfReservations.size(); i++) {
            System.out.println("- "+(listOfReservations.get(i).toString()));
        }
        whatDoYouWant(id);


    }
    private static void makeAReservation(int id) throws ArrangementException {
        User user = DaoFactory.userDao().getById(id);
        List<Arrangement> arrangements = DaoFactory.arrangementDao().getAll();
        for (int i = 0; i<arrangements.size(); i++) {
            System.out.println(arrangements.get(i).toString());
        }
        System.out.println("Type id for arrangement which you want.");
        Scanner scanner = new Scanner(System.in);
        int selected = scanner.nextInt();
        Reservation reservation = new Reservation();
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        reservation.setId(0);
        reservation.setPayment(DaoFactory.arrangementDao().getById(selected).getPrice());
        reservation.setDate(date);
        reservation.setUser(user);
        DaoFactory.reservationDao().add(reservation);
        System.out.println("You booked this arrangement.");
        whatDoYouWant(id);


    }
    private static void deleteReservation(int id) throws ArrangementException {
        List<Reservation> listOfReservations = DaoFactory.reservationDao().reservationsForUser(id);
        System.out.println("You have "+listOfReservations.size()+" reservations.");
        if (listOfReservations.isEmpty()){
            System.out.println("You haven't made any reservations yet!\n");

            return;
        }
        for(int i = 0; i<listOfReservations.size(); i++) {
            System.out.println("- "+(listOfReservations.get(i).toString()));
        }
        System.out.println("Type id for arrangement which you want delete.");
        Scanner scanner = new Scanner(System.in);
        int selected = scanner.nextInt();
        DaoFactory.reservationDao().delete(selected);



    }
}
