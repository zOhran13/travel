package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ArrangementException;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Implements methods from Dao<T> plus methods from UserDao, extends AbstractDao
 */
public class UserDaoSQLImpl extends AbstractDao<User> implements UserDao{
    public UserDaoSQLImpl() {
        super("User");
    }
    /**
     * Method that turns data from database to objects
     * @param rs
     * @return
     * @throws ArrangementException
     *
     */
    @Override
    public User row2object(ResultSet rs) throws ArrangementException{
        User user = new User();
        try{
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setSurname((rs.getString("surname")));
            user.setAddress(rs.getString("address"));
            user.setPhoneNumber(rs.getString("phone_number"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            return user;
        }
        catch (SQLException e){
            throw new ArrangementException(e.getMessage());
        }
    }


    /**
     * Method returns one user by id
     * @param id
     * @return user
     * @throws ArrangementException
     */
    @Override
    public User getById(int id) throws ArrangementException {
        String query = "SELECT * FROM User WHERE id = ?";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { // result set is iterator.
                User result = row2object(rs);
                rs.close();
                return result;
            } else {
                throw new ArrangementException("Object not found");
            }
        } catch (SQLException e) {
            throw new ArrangementException(e.getMessage(), e);
        }
    }



    @Override
    public User update(User item) {
        return null;
    }

    @Override
    public void delete(int id) {

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

    /**
     * Method return user from database with email. Two users can't have same email.
     * @param email
     * @return user
     * @throws ArrangementException
     */
    public User getByEmail(String email) throws ArrangementException{

        String query = "SELECT * FROM  User  WHERE email = ?";

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



}
