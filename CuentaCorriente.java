package Herencia.Excepciones.SucursalBancaria;

import java.time.LocalDateTime;

public class CuentaCorriente extends Cuenta{
    //---------------CONSTRUCTOR---------------
    public CuentaCorriente(double saldo, int numeroCuenta, Cliente nombre){
        super(0, numeroCuenta, nombre);
    }
    //---------------METODOS---------------
    public void verDatos(){
        String s = "";
        s += "- CUENTA CORRIENTE -"+"\nNºcuenta: " +numeroCuenta+"\n";
        s += "Titular: " +nombre+ "\n\t Dni:" +nombre.getDni() + "\n\t Nombre:"+ nombre.nombreCompleto() + "\n\t Domicilio:" + nombre.direccionCompleta() + "\n";
        s += "Saldo actual: " + saldo + "€\n";
        s += "---------------MOVIMIENTOS---------------\n";
        mostrarMovimientos();
        System.out.println(s);
    }
    public void retirar(double cantidad) {
        if (cantidad > 300 || saldo - cantidad < 0) {
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
