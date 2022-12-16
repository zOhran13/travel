package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Arrangement;
import ba.unsa.etf.rpr.domain.Category;

import java.util.List;

public interface ArrangementDao extends Dao<Arrangement>{
    public List<Arrangement> searchByCategory(Category category);
    public List<Arrangement> searchByName(String name);
}
