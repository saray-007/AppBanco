package Herencia.Excepciones.SucursalBancaria;

public class CadenaNoValidaException extends Exception{

    public CadenaNoValidaException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "ERROR"+getMessage();
    }
}
