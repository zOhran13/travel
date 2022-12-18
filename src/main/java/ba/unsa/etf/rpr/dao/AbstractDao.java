package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Arrangement;
import ba.unsa.etf.rpr.domain.Idable;

import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public abstract class AbstractDao<T extends Idable> implements Dao<T>{
    private Connection konekcija;
    private String nazivTabele;
    public AbstractDao(String nazivTabele){
        try{
            this.nazivTabele = nazivTabele;
            Properties p = new Properties();
            p.load(ClassLoader.getSystemResource("database.properties").openStream());
            String url = p.getProperty("url");
            String username = p.getProperty("username");
            String password = p.getProperty("password");
            this.konekcija = DriverManager.getConnection(url, username, password);
        }catch (Exception e){
            System.out.println("Neuspjela konekcija na bazu");
            e.printStackTrace();

        }
    }
    public T getById(int id) {
        String query = "SELECT * FROM "+this.nazivTabele+" WHERE id = ?";
        try {
            PreparedStatement stmt = this.konekcija.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { // result set is iterator.
                T result = row2object(rs);
                rs.close();
                return result;
           }
//            else {
//                throw new QuoteException("Object not found");
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Connection getConnection(){
        return this.konekcija;
    }

    public abstract T row2object(ResultSet rs) ;

    public abstract Map<String, Object> object2row(T object);

    public List<T> getAll()  {
        String query = "SELECT * FROM "+ nazivTabele;
        List<T> results = new ArrayList<T>();
        try{
            PreparedStatement stmt = getConnection().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){ // result set is iterator.
                T object = row2object(rs);
                results.add(object);
            }
            rs.close();
            return results;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void delete(int id) {
        String sql = "DELETE FROM "+nazivTabele+" WHERE id = ?";
        try{
            PreparedStatement stmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public T add(T item){
        Map<String, Object> row = object2row(item);
        //Map.Entry<String, String> columns = prepareInsertParts(row);

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO ").append(nazivTabele);
        //builder.append(" (").append(columns.getKey()).append(") ");
        //builder.append("VALUES (").append(columns.getValue()).append(")");

        try{
            PreparedStatement stmt = getConnection().prepareStatement(builder.toString(), Statement.RETURN_GENERATED_KEYS);
            // bind params. IMPORTANT treeMap is used to keep columns sorted so params are bind correctly
            int counter = 1;
            for (Map.Entry<String, Object> entry: row.entrySet()) {
                if (entry.getKey().equals("id")) continue; // skip ID
                stmt.setObject(counter, entry.getValue());
                counter++;
            }
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next(); // we know that there is one key
            item.setId(rs.getInt(1)); //set id to return it back */

            return item;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public T update(T item) {
        Map<String, Object> row = object2row(item);
        //String updateColumns = prepareUpdateParts(row);
        StringBuilder builder = new StringBuilder();
        builder.append("UPDATE ")
                .append(nazivTabele)
                .append(" SET ")
                .append(nazivTabele)
                .append(" WHERE id = ?");

        try{
            PreparedStatement stmt = getConnection().prepareStatement(builder.toString());
            int counter = 1;
            for (Map.Entry<String, Object> entry: row.entrySet()) {
                if (entry.getKey().equals("id")) continue; // skip ID
                stmt.setObject(counter, entry.getValue());
                counter++;
            }
            stmt.setObject(counter+1, item.getId());
            stmt.executeUpdate();
            return item;
        }catch (SQLException e){
            e.printStackTrace();

        }
        return null;
    }


}
