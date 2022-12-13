package ba.unsa.etf.rpr.domain;

public class Arrangement {
    private int id;
    private String name;
    private String description;
    private int price;
    private String transportation;

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

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getTransportation() {
        return transportation;
    }
}
