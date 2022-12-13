package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Arrangement;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

public class ArrangementDaoSQLImpl implements  ArrangementDao{

    private Connection konekcija;
    public ArrangementDaoSQLImpl(){
        try{
            //konekcija na bazu
            FileReader reader = new FileReader("src/main/resources/database.properties");
            Properties p = new Properties();
            p.load(reader);
            String s1 = p.getProperty("url");
            String s2 = p.getProperty("user");
            String s3 = p.getProperty("password");
            Class.forName("com.mysql.cj.jcbc.Driver");
            this.konekcija = DriverManager.getConnection(s1,s2,s3);

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
