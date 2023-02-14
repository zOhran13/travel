package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.exceptions.ArrangementException;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws ArrangementException {
        System.out.println("Hello user. Welcome to travel agency. This is a simple app for booking the best travel arrangements.");
        System.out.println("If you don't have a account type 1, if you already have one type 2.");
        Scanner scanner = new Scanner(System.in);
        if(scanner.nextInt() == 1) {

        }


    }
}
