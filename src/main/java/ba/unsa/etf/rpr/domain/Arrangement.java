package ba.unsa.etf.rpr.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Domain Javabean class Arrangement with all attributes needed for arrangement information such as id, price, arrangement, description and transportation
 * Also, setters, getters for each attribute
 */
public class Arrangement implements Idable, Serializable {
    private int id;
    private String arrangement;
    private String description;
    private int price;
    private String transportation;

    private Reservation reservation;

    public int getId() {
        return id;
    }

    public String getArrangement() {
        return arrangement;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArrangement(String arrangement) {
        this.arrangement = arrangement;
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

    /**
     * This is method that turns Arrangement to string object
     * @return string object
     */

    @Override
    public String toString() {
        return "Arrangement{" +
                "id= " + id +
                ", arragement=" + arrangement +
                ", description =" + description +
                ", price=" +price+
                ", transportation="+transportation+
                ", reservations="+reservation+
                '}';
    }

    /**
     * This method checks is it two arrangement the same
     * @param o
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       Arrangement arr = (Arrangement) o;
        return id == arr.id;

    }
    @Override
    public int hashCode() {
        return Objects.hash(id, arrangement, description, price, transportation, reservation);
    }
}
