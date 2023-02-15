package ba.unsa.etf.rpr.dao;

/**
 * DaoFactory class for making instances od dao classes
 */

public class DaoFactory {

    /**
     * Static method for DaoFactory
     */
    private static final ArrangementDao arrangementDao = new ArrangementDaoSQLImpl();
    private static final ReservationDao reservationDao = new ReservationDaoSQLImpl();
    private static final UserDao userDao = new UserDaoSQLImpl();

    /**
     * Constructor
     */
    private DaoFactory(){
    }


    /**
     * Method needed to access ArrangementDao instance
     * @return
     */
    public static ArrangementDao arrangementDao(){
        return arrangementDao;
    }

    public static ReservationDao reservationDao(){
        return reservationDao;
    }
     public static UserDao userDao() {return userDao;}

}
