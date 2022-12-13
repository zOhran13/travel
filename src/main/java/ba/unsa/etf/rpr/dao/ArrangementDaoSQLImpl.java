package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Arrangement;
import ba.unsa.etf.rpr.domain.Category;

import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
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
    @Override
    public List<Arrangement> searchByCategory(Category category) {
        String query = "SELECT * FROM quotes WHERE category = ?";
        try {
            PreparedStatement stmt = this.konekcija.prepareStatement(query);
            stmt.setInt(1, category.getId());
            ResultSet rs = stmt.executeQuery();
            ArrayList<Arrangement> quoteLista = new ArrayList<>();
            while (rs.next()) {
                Arrangement q = new Arrangement();
                q.setId(rs.getInt(1));
                q.setName(rs.getString(2));
                q.setCategory(category);
                q.setDescription(rs.getString(3));
                q.setPrice(rs.getInt(4));
                q.setTransportation(rs.getString(5));

                quoteLista.add(q);
            }
            return quoteLista;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
