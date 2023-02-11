package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ArrangementException;

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

    public static User register(User user) throws ArrangementException {
        if (user.getName().equals(null) || user.getPassword().equals(null) || user.getEmail().equals(null) || user.getAddress() == null || user.getSurname() == null || user.getPhoneNumber() == null) {
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
