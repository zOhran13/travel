package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ArrangementException;

import javax.management.ListenerNotFoundException;

public class UserManager {
    public User login(String email, String password) throws ArrangementException {

        if (email == null || password.equals("")) {
            throw new ArrangementException("All fields have to be filled");
        }
        User u = DaoFactory.userDao().getByEmail(email);

        if (!u.getPassword().equals(password)) {
            throw new ArrangementException("Password incorrect");
        }
        return u;

    }
   public static boolean isNameValid(String name) {
        if(name.equals("") ) return false;
        char letters [] = name.toCharArray();
        for(char c: letters) {
            if(!Character.isLetter(c)) return false;
        }
        return true;
    }
    public static boolean isPasswordValid(String password) {
        if(password.equals("")) return false;
        return true;
    }
    public static boolean isEmailValid(String email) {
        if(email.equals("")) return false;
        return true;
    }

    public static boolean isAddressValid(String address) {
        if(address.equals("")) return false;
        return true;
    }
    public static boolean isSurnameValid(String surname) {
        if(surname.equals("")) return false;
        char letters [] = surname.toCharArray();
        for(char c: letters) {
            if(!Character.isLetter(c)) return false;
        }
        return true;
    }
    public static boolean isPhoneNumberValid(String phone) {
        if(phone.equals("")) return false;
        return true;
    }


    public static User register(User user) throws ArrangementException {

       /// System.out.println(user.getName().equals(null));
        //System.out.println();
        if ((!isNameValid(user.getName())) || (!isPasswordValid(user.getPassword())) || (!isEmailValid(user.getEmail())) || (!isAddressValid(user.getAddress())) || (!isSurnameValid(user.getSurname()))|| (!isPhoneNumberValid(user.getPhoneNumber()))) {
            throw new ArrangementException("Missing some information's");
        }


        if (user.getPassword().length() < 8) {

            throw new ArrangementException("Password has to be longer than 8 characters.");

        }
        try {
            return DaoFactory.userDao().add(user);
        } catch (ArrangementException e) {
            if (e.getMessage().contains("email")) {
                throw new ArrangementException("This user already have account");
            }
            throw e;

        }
    }
}
