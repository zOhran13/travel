package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.exceptions.ArrangementException;

import java.util.List;

public interface Dao <T>{
T getById(int id)throws ArrangementException;
T add( T item) throws ArrangementException;
T update(T item) throws ArrangementException;
void delete(int id) throws ArrangementException;
List<T> getAll() throws ArrangementException;
}
