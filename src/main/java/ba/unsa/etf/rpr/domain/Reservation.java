package ba.unsa.etf.rpr.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Reservation implements Idable, Serializable {

    private int id;
    private int payment;
    private Date date;
     private User user;

//     private Arrangement arrangement;

//    public Arrangement getArrangement() {
//        return arrangement;
//    }
//
//    public void setArrangement(Arrangement arrangement) {
//        this.arrangement = arrangement;
//    }

    public int getId() {
        return id;
    }

    public int getPayment() {
        return payment;
    }

    public User getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }



    public void setDate(Date date) {
        this.date = date;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Date getDate() {
        return date;
    }
    public String toString() {
        return "Reservation[" +
                "id=" + id +
                ", payment=" + payment+
                ", date: " + date+
               // ", place: "+arrangement+
                ", user" +user+
                ']';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       Reservation reservation = (Reservation) o;
        return id == reservation.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, payment, date, user);
    }



}
