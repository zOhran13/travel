package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Category;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

public class CategoryDaoSQLImpl implements CategoryDao{

    private Connection konekcija;

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
