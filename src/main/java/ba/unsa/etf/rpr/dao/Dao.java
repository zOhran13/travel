package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.exceptions.ArrangementException;

import java.util.List;

/**
 * Dao interface extend by ArrangementDao, ReservationDao, UserDao
 * @param <T>
 */
public interface Dao <T>{
    /**
     * Get entity from database base on ID
     * @param id
     * @return id primary key of entity
     * @throws ArrangementException
     */
    T getById(int id)throws ArrangementException;

    /**
     * Saves entity into database
     * @param item
     * @return saved item with id field populated
     * @throws ArrangementException
     */
    T add( T item) throws ArrangementException;


    /**
     * Delete entity into database
     * @param id
     * @throws ArrangementException
     */
    void delete(int id) throws ArrangementException;

    /**
     * Lists all entities from database.
     * @return List of entities from database
     * @throws ArrangementException
     */
    List<T> getAll() throws ArrangementException;
}
