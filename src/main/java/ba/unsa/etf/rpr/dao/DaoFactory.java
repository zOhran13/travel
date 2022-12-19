package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;

public class DaoFactory {
    private static final CategoryDao catDao = new CategoryDaoSQLImpl();
    private static final ArrangementDao arrDao = new ArrangementDaoSQLImpl();
    private static final ReservationDao resDao = new ReservationDaoSQLImpl();
    private static final UserDao usDao = new UserDaoSQLImpl();


    private DaoFactory(){
    }

    public static CategoryDao catDao(){
        return catDao;
    }

    public static ArrangementDao arrDao(){
        return arrDao;
    }

    public static ReservationDao resDao(){
        return resDao;
    }
     public static UserDao usDao() {return usDao;}

}
