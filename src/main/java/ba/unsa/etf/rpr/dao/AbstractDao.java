package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Arrangement;
import ba.unsa.etf.rpr.domain.Idable;
import ba.unsa.etf.rpr.exceptions.ArrangementException;

import java.io.FileReader;
import java.sql.*;
import java.util.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Properties;

public abstract class AbstractDao<T extends Idable> implements Dao<T>{
    private static  Connection konekcija = null;
    private String nazivTabele;
//    public AbstractDao(String nazivTabele) {
//        this.nazivTabele = nazivTabele;
//        createConnection();
//    }
public AbstractDao(String nazivTabele) {
    try{
        this.nazivTabele = nazivTabele;
        Properties p = new Properties();
        p.load(ClassLoader.getSystemResource("database.properties").openStream());
        String url = p.getProperty("url");
        String username = p.getProperty("username");
        String password = p.getProperty("password");
        this.konekcija = DriverManager.getConnection(url, username, password);
    }catch (Exception e){
        System.out.println("Connection to database not possible!");
        e.printStackTrace();

    }
}

    public Connection getConnection(){

        return this.konekcija;


    }



public T getById(int id) throws ArrangementException {
    return executeQueryUnique("SELECT * FROM "+this.nazivTabele+" WHERE id = ?", new Object[]{id});
}
    public List<T> getAll() throws ArrangementException {
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
            throw new ArrangementException(e.getMessage(), e);
        }
    }



    public abstract T row2object(ResultSet rs) throws ArrangementException;

    public abstract Map<String, Object> object2row(T object);



    public void delete(int id) throws ArrangementException{
        String sql = "DELETE FROM "+nazivTabele+" WHERE id = ?";
        try{
            PreparedStatement stmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new ArrangementException(e.getMessage(), e);
        }
    }

    public T add(T item) throws ArrangementException{
        Map<String, Object> row = object2row(item);
        Map.Entry<String, String> columns = prepareInsertParts(row);

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO ").append(nazivTabele);
        builder.append(" (").append(columns.getKey()).append(") ");
        builder.append("VALUES (").append(columns.getValue()).append(")");

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
            throw new ArrangementException(e.getMessage(), e);
        }

    }

    public T update(T item) throws ArrangementException{
        Map<String, Object> row = object2row(item);
        String updateColumns = prepareUpdateParts(row);
        StringBuilder builder = new StringBuilder();
        builder.append("UPDATE ")
                .append(nazivTabele)
                .append(" SET ")
                .append(updateColumns)
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
            throw new ArrangementException(e.getMessage(), e);

        }

    }
    public List<T> executeQuery(String query, Object[] params) throws ArrangementException {
        try {
            PreparedStatement stmt = getConnection().prepareStatement(query);
            if (params != null){
                for(int i = 1; i <= params.length; i++){
                    stmt.setObject(i, params[i-1]);
                }
            }
            ResultSet rs = stmt.executeQuery();
            ArrayList<T> resultList = new ArrayList<>();
            while (rs.next()) {
                resultList.add(row2object(rs));
            }
            return resultList;
        } catch (SQLException e) {
            throw new ArrangementException(e.getMessage(), e);
        }
    }
    public T executeQueryUnique(String query, Object[] params) throws ArrangementException {
        List<T> result = executeQuery(query, params);
        if (result != null && result.size() == 1){
            return result.get(0);
        }else{
            throw new ArrangementException("Object not found");
        }

    }
    private String prepareUpdateParts(Map<String, Object> row){
        StringBuilder columns = new StringBuilder();

        int counter = 0;
        for (Map.Entry<String, Object> entry: row.entrySet()) {
            counter++;
            if (entry.getKey().equals("id")) continue; //skip update of id due where clause
            columns.append(entry.getKey()).append("= ?");
            if (row.size() != counter) {
                columns.append(",");
            }
        }
        return columns.toString();
    }
    private Map.Entry<String, String> prepareInsertParts(Map<String, Object> row){
        StringBuilder columns = new StringBuilder();
        StringBuilder questions = new StringBuilder();

        int counter = 0;
        for (Map.Entry<String, Object> entry: row.entrySet()) {
            counter++;
            if (entry.getKey().equals("id")) continue; //skip insertion of id due autoincrement
            columns.append(entry.getKey());
            questions.append("?");
            if (row.size() != counter) {
                columns.append(",");
                questions.append(",");
            }
        }
        return new AbstractMap.SimpleEntry<>(columns.toString(), questions.toString());
    }



}
