package Herencia.Excepciones.SucursalBancaria;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Cuenta {
    //----------ATRIBUTOS----------
    protected double saldo;
    protected int numeroCuenta;
    protected Cliente titular;
    protected ArrayList<Movimientos> movimientos;
    //----------CONSTRUCTOR----------
    public Cuenta(double saldo, int numeroCuenta, Cliente titular){
        this.saldo=saldo;
        this.numeroCuenta=numeroCuenta;
        this.titular=titular;
        this.movimientos = new ArrayList<>();
    }
    //----------GETTERS Y SETTERS----------
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public int getNumeroCuenta() {
        return numeroCuenta;
    }
    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    public Cliente getTitular() {
        return titular;
    }
    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
    //----------METODOS----------
    public abstract void retirar(double cantidad);
    public abstract void ingresar(double cantidad);
    public void mostrarMovimientos() {
        for (Movimientos m : movimientos) {
            System.out.println(m);
        }
    }
    //----------CLASE MOVIMIENTOS----------
    class Movimientos {
        //----------ATRIBUTOS----------
        private LocalDateTime fechaHora;
        private double importe;
        private double saldoFinal;
        private String tipo;
        //----------CONSTRUCTOR----------
        public Movimientos(LocalDateTime fechaHora, double importe, double saldoFinal, String tipo) {
            this.fechaHora = fechaHora;
            this.importe = importe;
            this.saldoFinal = saldoFinal;
            this.tipo = tipo;
        }
        //----------METODOS----------
        public String toString() {
            return "Fecha y hora: "+fechaHora+"\nTipo de cuenta: "+tipo+"\nImporte: " + importe + "\nSaldo: " + saldoFinal;
        }
    }
}
