package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ArrangementException;

public class UserManager {
    public User login(String email, String password) throws ArrangementException {

        if(email == null || password.equals("")){
            throw new ArrangementException("All fields have to be filled");
        }
        User u = DaoFactory.userDao().getByEmail(email);

        if(!u.getPassword().equals(password)){
            throw new ArrangementException("Password incorrect");
        }
        return u;

    }
}
