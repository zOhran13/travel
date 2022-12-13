package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Arrangement {
    private int id;
    private String name;
    private String description;
    private int price;
    private String transportation;
    private Category category;

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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getTransportation() {
        return transportation;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Arrangement{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", name=" + name +
                ", description =" + description +
                ", price=" +price+
                ", transportation="+transportation+
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       Arrangement arr = (Arrangement) o;
        return id == arr.id;

    }
    @Override
    public int hashCode() {
        return Objects.hash(id,name, category, description, price, transportation);
    }
}
