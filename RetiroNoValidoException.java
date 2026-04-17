package Herencia.Excepciones.SucursalBancaria;

public class RetiroNoValidoException extends Exception{

    public RetiroNoValidoException(String message) {
        super(message);
    }
    @Override
    public String toString() {
        return "ERROR: No se ha podido hacer el retiro, "+getMessage();
    }
}
