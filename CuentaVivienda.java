package Herencia.Excepciones.SucursalBancaria;

public class CuentaVivienda extends Cuenta{
    //---------------CONSTRUCTOR---------------
    public CuentaVivienda(double saldo, int numeroCuenta, Cliente titular){
        super(1000, numeroCuenta, titular);
    }
    //---------------METODOS---------------
    public void verDatos(){
        String s = "";
        s += "Nºcuenta: " +numeroCuenta+"- CUENTA VIVIENDA"+"\n";
        s += "Titular: " + "\n\t\t Dni:" +titular.getDni() + "\n\t\t Nombre:"+ titular.nombreCompleto() + "\n\t\t Domicilio:" + titular.direccionCompleta() + "\n";
        s += "Saldo actual: " + saldo + "€\n";
        s += "------------------------  M O V I M I E N T O S  ------------------------\n";
        System.out.println(s);
        mostrarMovimientos();
    }
    public void retirar(double cantidad) {
        if (cantidad > 500 || saldo - cantidad < 0) {
            System.out.println("ERROR: no se puede retirar esa cantidad");
        } else {
            saldo -= cantidad;
            System.out.println("Se ha retirado correctamente");
            System.out.println(getSaldo());
        }
    }
    public void ingresar(double cantidad) {
        if (cantidad < 10) {
            System.out.println("ERROR: ingreso mínimo 10€");
        } else {
            saldo += cantidad;
            System.out.println("Se ha ingresado correctamente");
            System.out.println(getSaldo());
        }
    }
}
