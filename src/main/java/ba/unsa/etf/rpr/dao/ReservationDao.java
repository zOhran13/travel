package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.exceptions.ArrangementException;

import java.util.List;

public interface ReservationDao extends Dao<Reservation> {
    public List<Reservation> reservationsForUser(int userId) throws ArrangementException;
}
