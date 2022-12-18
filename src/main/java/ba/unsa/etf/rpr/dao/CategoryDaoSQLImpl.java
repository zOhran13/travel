package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.exceptions.ArrangementException;


import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Map;

import java.util.TreeMap;

public class CategoryDaoSQLImpl extends AbstractDao<Category> implements CategoryDao{

    public CategoryDaoSQLImpl() {
        super("categories");
    }

    @Override
    public Category row2object(ResultSet rs) throws ArrangementException {
        try {
            Category cat = new Category();
            cat.setId(rs.getInt("id"));
            cat.setName(rs.getString("name"));
            return cat;
        } catch (SQLException e) {
            throw new ArrangementException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Category object) {
        Map<String, Object> row = new TreeMap<String, Object>();
        row.put("id", object.getId());
        row.put("name", object.getName());
        return row;
    }


}
