package Herencia.Excepciones.SucursalBancaria;

import java.time.LocalDateTime;

public class CuentaVivienda extends Cuenta{
    //---------------CONSTRUCTOR---------------
    public CuentaVivienda(double saldo, int numeroCuenta, Cliente nombre){
        super(1000, numeroCuenta, nombre);
    }
    //---------------METODOS---------------
    public void verDatos(){
        String s = "";
        s += "- CUENTA VIVIENDA -"+"\nNºcuenta: " +numeroCuenta+"\n";
        s += "Titular: " +nombre+ "\n\t Dni:" +nombre.getDni() + "\n\t Nombre:"+ nombre.nombreCompleto() + "\n\t Domicilio:" + nombre.direccionCompleta() + "\n";
        s += "Saldo actual: " + saldo + "€\n";
        s += "---------------MOVIMIENTOS---------------\n";
        mostrarMovimientos();
        System.out.println(s);
    }
    public void retirar(double cantidad) {
        if (cantidad > 500 || saldo - cantidad < 0) {
            System.out.println("ERROR: no se puede retirar esa cantidad");
        } else {
            saldo -= cantidad;
            movimientos.add(new Movimientos(LocalDateTime.now(), cantidad, cantidad, "R"));
            System.out.println("Se ha retirado correctamnete la cantidad de " + cantidad + " $ a la cuenta:"+ numeroCuenta);
        }
    }
    public void ingresar(double cantidad) {
        if (cantidad < 10) {
            System.out.println("ERROR: ingreso mínimo 10€");
        } else {
            saldo += cantidad;
            movimientos.add(new Movimientos(LocalDateTime.now(), cantidad, cantidad, "I"));
            System.out.println("Se ha ingresado correctamnete la cantidad de " + cantidad + " $ a la cuenta:"+ numeroCuenta);
        }
    }
}
