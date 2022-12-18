package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Category implements Idable{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Category[" +
                "id=" + id +
                ", name='" + name +
                ']';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
