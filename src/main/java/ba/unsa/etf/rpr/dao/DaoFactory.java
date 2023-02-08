package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;

public class DaoFactory {

    private static final ArrangementDao arrangementDao = new ArrangementDaoSQLImpl();
    private static final ReservationDao reservationDao = new ReservationDaoSQLImpl();
    private static final UserDao userDao = new UserDaoSQLImpl();


    private DaoFactory(){
    }



    public static ArrangementDao arrangementDao(){
        return arrangementDao;
    }

    public static ReservationDao reservationDao(){
        return reservationDao;
    }
     public static UserDao userDao() {return userDao;}

}
