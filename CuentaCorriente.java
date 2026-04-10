package Herencia.Excepciones.SucursalBancaria;

import java.time.LocalDateTime;

public class CuentaCorriente extends Cuenta{
    //----------CONSTRUCTOR----------
    public CuentaCorriente(double saldo, int numeroCuenta, Cliente titular){
        super(saldo, numeroCuenta, titular);
    }
    //----------METODOS----------
    public void retirar(double cantidad) {
        if (cantidad > 300) {
            System.out.println("No puedes retirar más de 300€");
        } else if (cantidad > saldo) {
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
