package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Category;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

public class CategoryDaoSQLImpl implements CategoryDao{

    private Connection konekcija;
    public CategoryDaoSQLImpl(){

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
