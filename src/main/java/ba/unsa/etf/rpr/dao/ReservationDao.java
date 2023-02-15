package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.exceptions.ArrangementException;

import java.util.List;

/**
 * Interface that extends Dao<T> plus has methods that are needed only for ReservationDao
 */
public interface ReservationDao extends Dao<Reservation> {
    public List<Reservation> reservationsForUser(int userId) throws ArrangementException;
}
