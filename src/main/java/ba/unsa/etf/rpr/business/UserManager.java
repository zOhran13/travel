package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ArrangementException;

/**
 * This class belongs to business layer for User. Checks all action which are connected with user.
 */
public class UserManager {
    /**
     *This method logs user in only if all fields are filled and username and password are correct
     * @param email
     * @param password
     * @return user which is in database
     * @throws ArrangementException
     */
    public static User login(String email, String password) throws ArrangementException {

        if (email == null || password.equals("")) {
            throw new ArrangementException("All fields have to be filled");
        }
        User u = DaoFactory.userDao().getByEmail(email);

        if (!u.getPassword().equals(password)) {
            throw new ArrangementException("Password incorrect");
        }
        return u;

    }

    /**
     * This method check is it name or surname has something beside letters
     * @param nameOrSurname
     * @return boolean true or false
     */
    public static boolean onlyLettersInNameOrSurname(String nameOrSurname) {
        char letters [] = nameOrSurname.toCharArray();
        for(char c: letters) {
            if(!Character.isLetter(c)) return false;
        }
        return true;

    }

    /**
     * This method check is it name empty string
     * @param name
     * @return boolean true or false
     */

   public static boolean isNameValid(String name) {
        if(name.equals("") ) return false;
        return true;
    }

    /**
     * This method check is it password empty string
     * @param password
     * @return boolean true or false
     */
        public static boolean isPasswordValid(String password) {
        if(password.equals("")) return false;
        return true;
    }

    /**
     * This method check is it email empty string
     * @param email
     * @return boolean true or false
     */
    public static boolean isEmailValid(String email) {
        if(email.equals("")) return false;
        return true;
    }

    /**
     *
     * @param address
     * @return boolean true or false
     * This method check is it address empty string
     */

    public static boolean isAddressValid(String address) {
        if(address.equals("")) return false;
        return true;
    }

    /**
     *
     * @param surname
     * @return boolean true or false
     * This method check is it surname empty string
     */
    public static boolean isSurnameValid(String surname) {
        if(surname.equals("")) return false;
        return true;
    }

    /**
     *
     * @param phone
     * @return boolean true or false
     * This method check is it phoneNumber empty string
     */
    public static boolean isPhoneNumberValid(String phone) {
        if(phone.equals("")) return false;
        return true;
    }

    /**
     *
     * @param user
     * @return
     * @throws ArrangementException
     * This method adds user only if his username and password are correct
     */
    public static User register(User user) throws ArrangementException {

       /// System.out.println(user.getName().equals(null));
        //System.out.println();
        if ((!isNameValid(user.getName())) || (!isPasswordValid(user.getPassword())) || (!isEmailValid(user.getEmail())) || (!isAddressValid(user.getAddress())) || (!isSurnameValid(user.getSurname()))|| (!isPhoneNumberValid(user.getPhoneNumber()))) {
            throw new ArrangementException("Missing some information's");
        }
        if(!onlyLettersInNameOrSurname(user.getName()) || !onlyLettersInNameOrSurname(user.getSurname())) {
            throw new ArrangementException("Only letters in surname or name");
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
