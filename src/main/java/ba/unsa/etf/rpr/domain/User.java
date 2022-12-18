package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class User implements Idable{
    private int id;
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;
    private String eMail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    @Override
    public String toString() {
        return "User[" +
                "id=" + id +
                ", name=" + name  +
                ", surname" + surname +
                ", address" +address+
                ",phoneNumber" +phoneNumber+
                ",eMail"+eMail+
                ']';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       User user = (User) o;
        return id == user.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, address, phoneNumber, eMail);
    }

}
