package Herencia.Excepciones.SucursalBancaria;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Cuenta {
    //---------------ATRIBUTOS---------------
    protected double saldo;
    protected int numeroCuenta;
    protected Cliente nombre;
    protected ArrayList<Movimientos> movimientos;
    //---------------CONSTRUCTOR---------------
    public Cuenta(double saldo, int numeroCuenta, Cliente nombre){
        this.saldo=saldo;
        this.numeroCuenta=numeroCuenta;
        this.nombre=nombre;
        this.movimientos = new ArrayList<>();
    }
    //---------------GETTERS Y SETTERS---------------
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
    public Cliente getnombre() {
        return nombre;
    }
    public void setnombre(Cliente nombre) {
        this.nombre = nombre;
    }
    //---------------METODOS---------------
    public abstract void retiro(double cantidad) throws RetiroNoValidoException;
    public abstract void ingreso(double cantidad) throws IngresoNoValidoException;
    public abstract void verDatos();
    protected void mostrarMovimientos() {
        for (Movimientos m : movimientos) {
            System.out.println(m.toString());
        }
    
    }
    protected void corfirmarRetiro(Double cantidad){
         // se retira y se registra
        saldo -= cantidad;
        movimientos.add(new Movimientos(LocalDateTime.now(), cantidad, cantidad, "R"));
        System.out.println("Se han retirado correctamente "+cantidad+"€ de la cuenta "+numeroCuenta);
    }
    protected void corfirmarIngreso(Double cantidad){
         // se retira y se registra
        saldo -= cantidad;
        movimientos.add(new Movimientos(LocalDateTime.now(), cantidad, cantidad, "I"));
        System.out.println("Se han ingresado correctamente "+cantidad+"€ de la cuenta "+numeroCuenta);
    }
    @Override
    public String toString() {
        return "---------------CUENTA---------------" 
        +"\n\t-Saldo: " +saldo+ "\n\t-NumeroCuenta: " +numeroCuenta+ "\n\t-Titular: " +nombre+ "\n\t-Movimientos: "+movimientos;
    }
    //---------------CLASE MOVIMIENTOS---------------
    class Movimientos {
        //---------------ATRIBUTOS---------------
        private LocalDateTime fechaHora;
        private double importe;
        private double saldoFinal;
        private String tipo;
        //---------------CONSTRUCTOR---------------
        public Movimientos(LocalDateTime fechaHora, double importe, double saldoFinal, String tipo) {
            this.fechaHora = fechaHora;
            this.importe = importe;
            this.saldoFinal = saldoFinal;
            this.tipo = tipo;
        }
        //---------------METODOS---------------
        @Override
        public String toString() {
            return "---------------MOVIMIENTOS---------------" 
            +"\n\t-FechaHora: " +fechaHora+ "\n\t-Importe: " +importe+ "\n\t-SaldoFinal: " +saldoFinal+ "\n\t-Tipo: " +tipo;
        }
    }
}
