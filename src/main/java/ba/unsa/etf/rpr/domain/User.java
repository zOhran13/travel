package ba.unsa.etf.rpr.domain;

import java.io.Serializable;
import java.util.Objects;
/**
 * Domain Javabean class User with all attributes needed for user information such as id, name, surname, address phoneNumber, password and email
 * Also, setters, getters for each attribute
 */
public class User implements Idable, Serializable {
    private int id;
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;
    private String email;

    private String password;

    /**
     * Constructor with null parameters
     */
    public User() {
    }

    public User(int id, String name, String surname, String address, String phoneNumber, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * This is method that turns User to string object
     * @return string object
     */
    @Override
    public String toString() {
        return "User[" +
                "id=" + id +
                ", name= " + name  +
                ", surname= " + surname +
                ", address= " +address+
                ",phoneNumber= " +phoneNumber+
                ",email= "+ email +
                ",password= "+password+
                ']';
    }

    /**
     * This method checks is it two users the same
     * @param o
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       User user = (User) o;
        return id == user.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, address, phoneNumber, email,password);
    }

}
