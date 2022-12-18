package ba.unsa.etf.rpr.exceptions;

public class ArrangementException extends Exception{
    public ArrangementException(String poruka, Exception reason){
        super(poruka, reason);
    }

    public ArrangementException(String poruka){
        super(poruka);
    }
}
