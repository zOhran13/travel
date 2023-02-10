package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Arrangement;
import ba.unsa.etf.rpr.exceptions.ArrangementException;

import java.sql.*;
import java.util.*;

public class ArrangementDaoSQLImpl extends AbstractDao<Arrangement> implements  ArrangementDao {
    //private static ArrangementDaoSQLImpl instance = null;
    public ArrangementDaoSQLImpl() {
        super("Arrangement");
    }
//    public static ArrangementDaoSQLImpl getInstance(){
//        if(instance==null)
//            instance = new ArrangementDaoSQLImpl();
//        return instance;
//    }


@Override
public Arrangement row2object(ResultSet rs)  throws ArrangementException {
    try {
        Arrangement arr = new Arrangement();
        arr.setId(rs.getInt("id"));
        arr.setArragement(rs.getString("arrangement"));
        arr.setTransportation(rs.getString("transportation"));
        arr.setDescription(rs.getString("description"));
        arr.setPrice(rs.getInt("price"));
        return arr;
    } catch (SQLException e) {
        throw new ArrangementException(e.getMessage(), e);
    }

}

    @Override
    public Map<String, Object> object2row(Arrangement object) {
        Map<String, Object> row = new TreeMap<String, Object>();
        row.put("id", object.getId());
        row.put("arrangement", object.getArragement());
        row.put("price", object.getPrice());
        row.put("description", object.getDescription());
        row.put("transportation", object.getTransportation());
        return row;
    }


}
