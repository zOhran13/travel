package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class ReservationDaoSQLImpl implements ReservationDao{
    private Connection konekcija;
    public ReservationDaoSQLImpl(){
        try{
            //konekcija na bazu
            this.konekcija = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_zohran1", "freedb_zohran1", "@YrsTSVc2ZXuzW9");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public Reservation getById(int id) {
        return null;
    }

    @Override
    public Reservation add(Reservation item) {
        return null;
    }

    @Override
    public Reservation update(Reservation item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Reservation> getAll() {
        return null;
    }
}
