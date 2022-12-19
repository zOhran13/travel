package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Arrangement;
import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.exceptions.ArrangementException;

import java.io.FileReader;
import java.sql.*;
import java.util.*;

public class ArrangementDaoSQLImpl extends AbstractDao<Arrangement> implements  ArrangementDao {
    public ArrangementDaoSQLImpl() {
        super("Arrangements");
    }
//    @Override
//    public List<Arrangement> searchByCategory(Category category) {
//        String query = "SELECT * FROM quotes WHERE category = ?";
//        try {
//            PreparedStatement stmt = this.konekcija.prepareStatement(query);
//            stmt.setInt(1, category.getId());
//            ResultSet rs = stmt.executeQuery();
//            ArrayList<Arrangement>arrangementsLista = new ArrayList<>();
//            while (rs.next()) {
//                Arrangement q = new Arrangement();
//                q.setId(rs.getInt(1));
//                q.setName(rs.getString(2));
//                q.setCategory(category);
//                q.setDescription(rs.getString(3));
//                q.setPrice(rs.getInt(4));
//                q.setTransportation(rs.getString(5));
//
//                arrangementsLista.add(q);
//            }
//            return arrangementsLista;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//    public List<Arrangement> searchByName(String name) {
//        String query = "SELECT * FROM quotes WHERE quote LIKE concat('%', ?, '%')";
//        try {
//            PreparedStatement stmt = this.konekcija.prepareStatement(query);
//            stmt.setString(1, name);
//            ResultSet rs = stmt.executeQuery();
//            ArrayList<Arrangement> arrangementsLista = new ArrayList<>();
//            while (rs.next()) {
//                Arrangement q = new Arrangement();
//                q.setId(rs.getInt(1));
//                q.setName(rs.getString(2));
//                //q.setCategory(returnCategoryForId(rs.getInt(4)));
//
//                arrangementsLista.add(q);
//            }
//            return arrangementsLista;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
@Override
public Arrangement row2object(ResultSet rs)  throws ArrangementException {
    try {
        Arrangement arr = new Arrangement();
        arr.setId(rs.getInt("id"));
        arr.setName(rs.getString("name"));
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
        row.put("name", object.getName());
        row.put("price", object.getPrice());
        row.put("description", object.getDescription());
        row.put("transportation", object.getTransportation());
        return row;
    }


}
