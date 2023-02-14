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
        }
    }
}
