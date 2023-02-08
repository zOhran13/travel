package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ArrangementException;

public interface UserDao extends Dao<User>{
    User getByEmail(String email) throws ArrangementException;
}
