package Herencia.Excepciones.SucursalBancaria;

import java.time.LocalDateTime;

public class CuentaVivienda extends Cuenta{
    //---------------CONSTRUCTOR---------------
    public CuentaVivienda(double saldo, int numeroCuenta, Cliente titular){
        super(saldo, numeroCuenta, titular);
    }
    //---------------METODOS---------------
    public void retirar(double cantidad) {
        if (cantidad > saldo) {
            System.out.println("Saldo insuficiente");
        } else {
            saldo -= cantidad;
            movimientos.add(new Movimientos(LocalDateTime.now(), cantidad, saldo, "Retirada"));
        }
    }
    public void ingresar(double cantidad) {
        saldo += cantidad;
        movimientos.add(new Movimientos(LocalDateTime.now(), cantidad, saldo, "Ingreso"));
    }
}
