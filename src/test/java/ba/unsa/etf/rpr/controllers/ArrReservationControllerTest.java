package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.ReservationDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ArrangementException;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ArrReservationControllerTest {
    private List<Reservation> res = new ArrayList<>();
    //String arrangement = ""
    User user = new User(1, "Zlata", "Ohran", "Vakuf", "058930209", "zlata@", "12345678");
    private ReservationDaoSQLImpl reservationsDaoSQLMock = Mockito.mock(ReservationDaoSQLImpl.class);

    private ArrReservationController reservationController = new ArrReservationController(" ",user.getName(),user.getId());

    @Test
    void reservationArr() throws ArrangementException {
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        Reservation reservation = new Reservation();
        reservation.setId(1);
        reservation.setDate(date);
        reservation.setPayment(500);
        reservation.setUser(user);
        MockedStatic<DaoFactory> mockedFactory = Mockito.mockStatic(DaoFactory.class);
        mockedFactory.when(DaoFactory::reservationDao).thenReturn(reservationsDaoSQLMock);
        Reservation expected = new Reservation();
        when(reservationsDaoSQLMock.add(Mockito.any(Reservation.class))).thenReturn(expected);
        Reservation actual = reservationsDaoSQLMock.add(new Reservation());
        assertEquals(expected, actual);
        mockedFactory.close();

    }
}