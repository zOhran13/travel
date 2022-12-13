package ba.unsa.etf.rpr.domain;

import java.util.Date;

public class Reservation {

    private int id;
    private int payment;
    private int digitalBill;
    private Date date;

    public int getId() {
        return id;
    }

    public int getPayment() {
        return payment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public void setDigitalBill(int digitalBill) {
        this.digitalBill = digitalBill;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDigitalBill() {
        return digitalBill;
    }
    public Date getDate() {
        return date;
    }


}
