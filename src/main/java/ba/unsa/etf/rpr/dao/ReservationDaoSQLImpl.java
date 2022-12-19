package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Arrangement;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.exceptions.ArrangementException;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class ReservationDaoSQLImpl extends AbstractDao<Reservation> implements ReservationDao{
    public ReservationDaoSQLImpl() {
        super("Reservation");
    }

    @Override
    public Reservation row2object(ResultSet rs)  throws ArrangementException {
        try {
            Reservation res = new Reservation();
            res.setId(rs.getInt("id"));
            res.setPayment(rs.getInt("payment"));
            res.setDigitalBill(rs.getInt("digital_bill"));
            res.setDate(rs.getDate("date"));
           // res.(rs.getInt("price"));
            return res;
        } catch (SQLException e) {
            throw new ArrangementException(e.getMessage(), e);
        }

    }

    @Override
    public Map<String, Object> object2row(Reservation object) {
        Map<String, Object> row = new TreeMap<String, Object>();
//        row.put("id", object.getId());
//        row.put("name", object.getName());
//        row.put("price", object.getPrice());
//        row.put("description", object.getDescription());
//        row.put("transportation", object.getTransportation());
        return row;
    }


}
