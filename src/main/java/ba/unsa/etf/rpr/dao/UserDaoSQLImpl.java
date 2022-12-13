package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class UserDaoSQLImpl implements UserDao{

    private Connection konekcija;
    public UserDaoSQLImpl(){
        try{
            //konekcija na bazu
            this.konekcija = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_zohran1", "freedb_zohran1", "@YrsTSVc2ZXuzW9");

        }catch (Exception e) {
            e.printStackTrace();
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
}
