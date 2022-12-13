package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class CategoryDaoSQLImpl implements CategoryDao{

    private Connection konekcija;
    public CategoryDaoSQLImpl(){
        try{
            //konekcija na bazu
            this.konekcija = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_zohran1", "freedb_zohran1", "@YrsTSVc2ZXuzW9");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public Category getById(int id) {
        return null;
    }

    @Override
    public Category add(Category item) {
        return null;
    }

    @Override
    public Category update(Category item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Category> getAll() {
        return null;
    }
}
