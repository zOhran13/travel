package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Arrangement;
import ba.unsa.etf.rpr.exceptions.ArrangementException;

import java.sql.*;
import java.util.*;

/**
 * Implements methods from Dao<T> plus methods from ArrangementDao, extends AbstractDao
 */
public class ArrangementDaoSQLImpl extends AbstractDao<Arrangement> implements  ArrangementDao {
    //private static ArrangementDaoSQLImpl instance = null;
    public ArrangementDaoSQLImpl() {
        super("Arrangement");
    }

    /**
     * Method that turns data from database to objects
     * @param rs
     * @return data from database
     * @throws ArrangementException
     */

@Override
public Arrangement row2object(ResultSet rs)  throws ArrangementException {
    try {
        Arrangement arr = new Arrangement();
        arr.setId(rs.getInt("id"));
        arr.setArrangement(rs.getString("arrangement"));
        arr.setTransportation(rs.getString("transportation"));
        arr.setDescription(rs.getString("description"));
        arr.setPrice(rs.getInt("price"));
        return arr;
    } catch (SQLException e) {
        throw new ArrangementException(e.getMessage(), e);
    }

}

    /**
     * Method that turns objects to data for database
     * @param object
     * @return row in for database
     */

    @Override
    public Map<String, Object> object2row(Arrangement object) {
        Map<String, Object> row = new TreeMap<String, Object>();
        row.put("id", object.getId());
        row.put("arrangement", object.getArrangement());
        row.put("price", object.getPrice());
        row.put("description", object.getDescription());
        row.put("transportation", object.getTransportation());
        return row;
    }


}
