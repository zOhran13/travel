package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {
    User u = new User();
    @BeforeEach
            void setUp() {
        //User u = new User();

        u.setEmail("zlataohran@gmail.com");
        u.setPassword("123456789");
        u.setAddress("Vakuf");
        u.setSurname("Ohran");
        u.setName("Zlata");
        u.setPhoneNumber("06356589");
        u.setId(1);

    }

    @Test
    void login() {


    }

    @Test
    void isNameValid() {

        boolean ime = true;
        assertEquals(ime, UserManager.isNameValid(u.getName()));
    }

    @Test
    void isPasswordValid() {
        assertTrue(UserManager.isPasswordValid(u.getPassword()));
    }

    @Test
    void isEmailValid() {
        assertTrue(UserManager.isEmailValid(u.getEmail()));
    }

    @Test
    void isAddressValid() {
        assertTrue(UserManager.isAddressValid(u.getAddress()));
    }

    @Test
    void isSurnameValid() {
        assertTrue(UserManager.isNameValid(u.getName()));
    }

    @Test
    void isPhoneNumberValid() {
    }

    @Test
    void register() {
    }
}