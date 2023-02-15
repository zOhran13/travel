package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.exceptions.ArrangementException;

import java.util.List;

/**
 * Dao interface extend by ArrangementDao, ReservationDao, UsersDao
 * @param <T>
 */
public interface Dao <T>{
    /**
     * Get entity from database base on ID
     * @param id
     * @return
     * @throws ArrangementException
     */
    T getById(int id)throws ArrangementException;
T add( T item) throws ArrangementException;
T update(T item) throws ArrangementException;
void delete(int id) throws ArrangementException;
List<T> getAll() throws ArrangementException;
}
