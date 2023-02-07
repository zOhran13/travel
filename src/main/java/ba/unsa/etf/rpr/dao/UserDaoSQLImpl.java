package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ArrangementException;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UserDaoSQLImpl extends AbstractDao<User> implements UserDao{
    public UserDaoSQLImpl() {
        super("User");
    }

    @Override
    public User row2object(ResultSet rs) throws ArrangementException{
        User user = new User();
        try{
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            return user;
        }
        catch (SQLException e){
            throw new ArrangementException(e.getMessage());
        }
    }



    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public User add(User item) {
        return null;
    }

    @Override
    public User update(User item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }
    public User getByEmail(String email) throws ArrangementException{

        String query = "SELECT * FROM  users  WHERE email = ?";

        try{

            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User result = row2object(rs);
                rs.close();
                return result;
            } else {
                throw new ArrangementException("User not found");
            }
        } catch (SQLException e) {
            throw new ArrangementException(e.getMessage(), e);
        }

    }
    @Override
    public Map<String, Object> object2row(User object) {
        Map<String, Object> row = new TreeMap<String, Object>();
        row.put("id", object.getId());
        row.put("name", object.getName());
        row.put("surname", object.getSurname());
        row.put("address", object.getAddress());
        row.put("phone_number", object.getPhoneNumber());
        row.put("email",object.getEmail());
        row.put("password",object.getPassword());
        return row;
    }


}
