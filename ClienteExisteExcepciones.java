package Herencia.Excepciones.SucursalBancaria;

public class ClienteExisteExcepciones extends Exception{
    Cliente c;
    public ClienteExisteExcepciones(Cliente c){
        this.c=c;
    }
    @Override
    public String toString(){
        return "El cliente [ "+c.clienteCompleto()+ " ] ya existe"+"\nDime el dni del cliente";
    }
}
