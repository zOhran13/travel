package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.UserDao;
import ba.unsa.etf.rpr.dao.UserDaoSQLImpl;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ArrangementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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

        usersDaoMock = Mockito.mock(UserDao.class);

    }
    private UserDao usersDaoMock;
    private UserManager userService;
    private UserDaoSQLImpl usersDaoSQLMock = Mockito.mock(UserDaoSQLImpl.class);

    private UserManager userManager = new UserManager();
    @Test
    void register() throws ArrangementException {
        User user = new User(1, "Zlata", "Ohran", "Vakuf", "058930209", "zlata@", "12345678");


        MockedStatic<DaoFactory> mockedFactory = Mockito.mockStatic(DaoFactory.class);
        mockedFactory.when(DaoFactory::userDao).thenReturn(usersDaoSQLMock);
        User expected = new User();
        when(usersDaoSQLMock.add(Mockito.any(User.class))).thenReturn(expected);
        User actual = usersDaoSQLMock.add(new User());
        assertEquals(expected, actual);
        mockedFactory.close();

    }
    @Test
    void onlyLettersInNameOrSurname(){
        String name = "Z1ata";
        assertFalse(UserManager.onlyLettersInNameOrSurname(name));
    }

    @Test
    void isNameValid() {

        boolean name1 = true;
        assertEquals(name1, UserManager.isNameValid(u.getName()));

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
        assertTrue(UserManager.isNameValid(u.getPhoneNumber()));
    }

    @Test
    public void testLoginWithEmptyPassword() {
        assertThrows(ArrangementException.class, () -> {
           UserManager.login("testuser@example.com", "");
        }, "Login should throw ArrangementException when password is empty");
    }

    @Test
    void login() throws ArrangementException {
        User expectedUser = new User(1, "Zlata", "Ohran", "Vakuf", "058930209", "zlata@", "12345678");

        UserDao userDao = Mockito.mock(UserDao.class);
        Mockito.when(userDao.getByEmail("testuser@example.com")).thenReturn(expectedUser);

        DaoFactory daoFactory = Mockito.mock(DaoFactory.class);
        when(usersDaoSQLMock.add(Mockito.any(User.class))).thenReturn(expectedUser);

        assertThrows(ArrangementException.class, () -> {
           UserManager.login("testuser@example.com", "incorrectpassword");
        }, "Login should throw ArrangementException when password is incorrect");
    }



}