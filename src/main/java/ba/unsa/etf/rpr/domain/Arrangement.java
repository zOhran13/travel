package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Arrangement implements Idable{
    private int id;
    private String arragement;
    private String description;
    private int price;
    private String transportation;

    private Reservation reservation;

    public int getId() {
        return id;
    }

    public String getArragement() {
        return arragement;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArragement(String arragement) {
        this.arragement = arragement;
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



    @Override
    public String toString() {
        return "Arrangement{" +
                "id=" + id +
                ", arragement=" + arragement +
                ", description =" + description +
                ", price=" +price+
                ", transportation="+transportation+
                ", reservations="+reservation+
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
        return Objects.hash(id, arragement, description, price, transportation, reservation);
    }
}
