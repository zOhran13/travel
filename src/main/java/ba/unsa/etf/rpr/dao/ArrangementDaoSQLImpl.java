package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Arrangement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class ArrangementDaoSQLImpl implements  ArrangementDao{

    private Connection konekcija;
    public ArrangementDaoSQLImpl(){
        try{
            //konekcija na bazu
            this.konekcija = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_zohran1", "freedb_zohran1", "@YrsTSVc2ZXuzW9");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public Arrangement getById(int id) {
        return null;
    }

    @Override
    public Arrangement add(Arrangement item) {
        return null;
    }

    @Override
    public Arrangement update(Arrangement item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Arrangement> getAll() {
        return null;
    }
}
