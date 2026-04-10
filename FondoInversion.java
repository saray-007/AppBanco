package Herencia.Excepciones.SucursalBancaria;

import java.time.LocalDateTime;

public class FondoInversion extends Cuenta{
    //---------ATRIBUTOS---------
    private double interes;
    //---------CONSTRUCTOR---------
    public FondoInversion(double saldo, int numeroCuenta, Cliente titular, double interes){
        super(saldo, numeroCuenta, titular);
        this.interes=interes;
    }
    //---------METODOS----------
    public void calcularInteres() {
        double ganancia = saldo * interes;
        saldo += ganancia;
        movimientos.add(new Movimientos(LocalDateTime.now(), ganancia, saldo, "Interes"));
    }
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
