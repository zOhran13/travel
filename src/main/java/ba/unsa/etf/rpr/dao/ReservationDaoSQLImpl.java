package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Arrangement;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.exceptions.ArrangementException;

import java.io.FileReader;
import java.sql.*;
import java.util.*;

/**
 * Implements methods from Dao<T> plus methods from ReservationDao, extends AbstractDao
 */
public class ReservationDaoSQLImpl extends AbstractDao<Reservation> implements ReservationDao{
    public ReservationDaoSQLImpl() {
        super("Reservation");
    }
    /**
     * Method that turns data from database to objects
     * @param rs
     * @return
     * @throws ArrangementException
     */
    @Override
    public Reservation row2object(ResultSet rs)  throws ArrangementException {
        try {
            Reservation res = new Reservation();

            res.setId(rs.getInt("id"));
            res.setUser(DaoFactory.userDao().getById(rs.getInt("idUser")));
            res.setPayment(rs.getInt("payment"));
            res.setDate(rs.getDate("date"));
           // res.setArrangement(DaoFactory.arrangementDao().getById(rs.getInt("idArrangement")));
            return res;
        } catch (SQLException e) {
            throw new ArrangementException(e.getMessage(), e);
        }

    }

    @Override
    public Map<String, Object> object2row(Reservation object) {
        Map<String, Object> row = new TreeMap<String, Object>();
       row.put("id", object.getId());
        row.put("payment", object.getPayment());
        row.put("date", object.getDate());
        //row.put("place",object.getArrangement());
        row.put("idUser", object.getUser().getId());


        return row;
    }

    /**
     * Method chooses all reservations from database for one user
     * @param userId
     * @return list reservations for user
     * @throws ArrangementException
     */
    public  List<Reservation> reservationsForUser(int userId) throws ArrangementException {
        List<Reservation> reservationsForUser = new ArrayList<>();
        String query = "SELECT * FROM Reservation WHERE idUser = ?";
        try{
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setInt(1,userId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Reservation result = row2object(rs);
                reservationsForUser.add(result);
            }

        }
        catch (Exception e) {
            throw new ArrangementException(e.getMessage(), e);
        }

        return reservationsForUser;

    }


}
