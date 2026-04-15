package Herencia.Excepciones.SucursalBancaria;

public class FondoInversion extends Cuenta{
    //---------------ATRIBUTOS---------------
    private double interes;
    //---------------CONSTRUCTOR---------------
    public FondoInversion(double saldo, int numeroCuenta,Cliente titular, double interes){
        super(5000, numeroCuenta, titular);
        calcularInteres();
    }
    //---------------GETTERS Y SETTERS---------------
     public double getInteres() {
        return interes;
    }
    public void setInteres(double interes) {
        this.interes = interes;
    }
    //---------------METODOS----------------
    private void calcularInteres(){
        if (saldo>=100000) {
            interes=5;
        }else if (saldo>=50000) {
            interes=4;
        }else interes=2;
    }
    public void verDatos(){
        String s = "";
        s += "Nºcuenta: " + numeroCuenta+"- FONDO INVERSION AL "+interes+"%"+"\n";
        s += "Titular: " + "\n\t\t Dni:" +titular.getDni() + "\n\t\t Nombre:"+ titular.nombreCompleto() + "\n\t\t Domicilio:" + titular.direccionCompleta() + "\n";
        s += "Saldo actual: " + saldo + "€\n";
        s += "------------------------  M O V I M I E N T O S  ------------------------\n";
        System.out.println(s);
        mostrarMovimientos();
    }
    public void retirar(double cantidad) {
        if (cantidad < 500 || saldo - cantidad < 3000) {
            System.out.println("ERROR: no se puede retirar esa cantidad");
        } else {
            saldo -= cantidad;
            System.out.println("Se ha retirado correctamente");
            System.out.println(getSaldo());
        }
    }

    public void ingresar(double cantidad) {
        if (cantidad < 500) {
            System.out.println("ERROR: ingreso mínimo 500€");
        } else {
            saldo += cantidad;
            System.out.println("Se ha ingresado correctamente");
            System.out.println(getSaldo()); 
        }
    }
}
